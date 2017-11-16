package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.instantiation.core.model.common.ExecutionLocal;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualTypeAssignmentProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements a dynamic type descriptor for IVML decision variables. Instances of this
 * class represent IVML types and act as a frontend for {@link DecisionVariable}, thus,
 * {@link DecisionVariable decision variables} are assignable.
 * 
 * @author Holger Eichelberger
 */
public class IvmlTypeDescriptor extends AbstractIvmlTypeDescriptor implements IActualTypeAssignmentProvider {

    private TypeDescriptor<?> baseType;
    private IDatatype type;
    
    /**
     * Creates a new type descriptor.
     * 
     * @param project the underlying IVML project the descriptor shall be created for
     * @param ivmlType the IVML type to create the descriptor for
     * @param resolver for retrieving further IVML types
     * @throws VilException if analyzing the class fails for some reason
     */
    IvmlTypeDescriptor(Project project, IDatatype ivmlType, IvmlTypeResolver resolver) throws VilException {
        super(ivmlType, resolver);
        this.type = ivmlType;
    }
    
    /**
     * Resolves the type descriptor by filling it with operations and fields. This method
     * is separated from the constructor so that the type can be registered first and resolved then in
     * order to enable parent resolution.
     * 
     * @param project the underlying IVML project the descriptor shall be created for
     * @param ivmlType the IVML type to resolve for
     * @param declaredAttributes attributes declared for all variables of that type, may be <b>null</b>
     * @throws VilException if analyzing the underlying type fails for some reason
     */
    void resolve(Project project, IDatatype ivmlType, 
        Set<net.ssehub.easy.varModel.model.Attribute> declaredAttributes) throws VilException {
        TypeRegistry registry = getTypeRegistry();
        Map<String, OperationDescriptor> operations = new HashMap<String, OperationDescriptor>();
        Map<String, FieldDescriptor> fields = new HashMap<String, FieldDescriptor>();
        addDecisionVariableOperations(operations);
        addComparisonOperations(ivmlType, operations);
        // first of the type, then specific -> map, only one will be added
        addAttributeFields(fields, ivmlType instanceof IModelElement ? (IModelElement) ivmlType : project, 
            registry);
        if (null != declaredAttributes) {
            for (net.ssehub.easy.varModel.model.Attribute att : declaredAttributes) {
                Utils.addField(new IvmlAnnotationFieldDescriptor(this, att, registry), fields);
            }
        }
        addCompoundOperations(ivmlType, operations, fields);
        addEnumOperations(ivmlType, operations);
        if (Compound.TYPE.isAssignableFrom(ivmlType) || Container.TYPE.isAssignableFrom(ivmlType)) {
            Utils.addOperation(new IvmlConstructorOperationDescriptor(this, ivmlType), operations);
        }
        setOperations(operations.values());
        setFields(fields.values());
        List<OperationDescriptor> conversions = new ArrayList<OperationDescriptor>();
        conversions.add(new IvmlConversionOperationDescriptor(this));
        // for VarModelIdentifierExpression not having IvmlElement as type
        conversions.add(new IvmlToStringConversionOperationDescriptor(this));
        addDerivedTypeConversions(ivmlType, conversions);
        addConversionOperations(ivmlType, conversions);
        setConversions(conversions);
    }

    /**
     * Adds the operations for compound types if needed.
     * 
     * @param ivmlType the type to process
     * @param operations the operations (may be modified as a side effect)
     * @param fields the actually known fields of <code>ivmlType</code> (may be modified as a side effect)
     * @throws VilException in case that creating fields for the elements fails
     */
    private void addCompoundOperations(IDatatype ivmlType, Map<String, OperationDescriptor> operations, 
        Map<String, FieldDescriptor> fields) throws VilException {
        if (ivmlType instanceof Compound) {
            TypeRegistry registry = getTypeRegistry();
            Compound comp = (Compound) ivmlType;
            for (int r = 0; r < comp.getRefinesCount(); r++) {
                Compound refines = comp.getRefines(r);
                TypeDescriptor<?> tmp = registry.getType(refines);
                if (tmp instanceof IvmlTypeDescriptor) { // just to be sure
                    IvmlTypeDescriptor refinesDesc = (IvmlTypeDescriptor) tmp;
                    setRefines(refinesDesc);
                    for (int f = 0; f < refinesDesc.getFieldCount(); f++) {
                        FieldDescriptor fi = refinesDesc.getField(f);
                        if (fi instanceof IvmlAccessorFieldDescriptor) {
                            Utils.addField(fi, fields);
                        }
                    }
                }
            }
            addElements(comp, registry, fields);
        }        
    }
    
    /**
     * Adds the operations for enumeration types if needed.
     * 
     * @param ivmlType the type to process
     * @param operations the operations (may be modified as a side effect)
     */
    private void addEnumOperations(IDatatype ivmlType, Map<String, OperationDescriptor> operations) {
        if (ivmlType instanceof OrderedEnum) {
            for (IvmlOrderedEnumMinMaxOperationDescriptor.OperationKind op 
                : IvmlOrderedEnumMinMaxOperationDescriptor.OperationKind.values()) {
                Utils.addOperation(new IvmlOrderedEnumMinMaxOperationDescriptor(this, op), operations);
            }
            for (IvmlOrderedEnumComparisonOperationDescriptor.OperationKind op 
                : IvmlOrderedEnumComparisonOperationDescriptor.OperationKind.values()) {
                Utils.addOperation(new IvmlOrderedEnumComparisonOperationDescriptor(this, op), operations);
            }
        }
    }

    /**
     * Adds the conversion operations for derived types if needed.
     * 
     * @param ivmlType the type to process
     * @param conversions the conversion operations (may be modified as a side effect)
     */
    private void addDerivedTypeConversions(IDatatype ivmlType, List<OperationDescriptor> conversions) {
        if (DerivedDatatype.TYPE.isAssignableFrom(ivmlType)) {
            TypeRegistry registry = getTypeRegistry();
            IDatatype baseType = DerivedDatatype.resolveToBasis(ivmlType);
            TypeDescriptor<?> vilBaseType = registry.getType(baseType.getName());
            if (net.ssehub.easy.varModel.model.datatypes.Set.TYPE.isAssignableFrom(baseType)) {
                IvmlOperationDescriptor desc = new IvmlSetConversionOperationDescriptor(this, vilBaseType);
                conversions.add(desc);
                this.baseType = desc.getReturnType();
            } else if (Sequence.TYPE.isAssignableFrom(baseType)) {
                IvmlOperationDescriptor desc = new IvmlSequenceConversionOperationDescriptor(this, vilBaseType);
                conversions.add(desc);
                this.baseType = desc.getReturnType();
            }
        }
    }
    
    /**
     * Adds all the elements in this container and recursively processes attribute assignments.
     * 
     * @param container the container
     * @param registry the actual type registry
     * @param fields the name-field mapping to be modified as a side effect
     * @throws VilException in case that creating fields for the elements fails
     */
    private void addElements(IDecisionVariableContainer container, TypeRegistry registry, 
        Map<String, FieldDescriptor> fields) throws VilException {
        for (int e = 0; e < container.getElementCount(); e++) {
            DecisionVariableDeclaration decl = container.getElement(e);
            Utils.addField(new IvmlAccessorFieldDescriptor(this, decl, registry), fields);
        }
        for (int a = 0; a < container.getAssignmentCount(); a++) {
            addElements(container.getAssignment(a), registry, fields);
        }
    }
    
    @Override
    public IMetaType getBaseType() {
        return baseType;
    }
    
    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        // final check at runtime
        // check direct type or decision variable
        boolean assignable = (desc == this || IvmlTypes.decisionVariableType() == desc);
        if (!assignable && desc instanceof AbstractIvmlTypeDescriptor) {
            // check refines hierarchy on desc
            AbstractIvmlTypeDescriptor iter = (AbstractIvmlTypeDescriptor) desc;
            assignable = isEqual(iter, this);
            while (!assignable && null != iter) {
                if (iter instanceof AbstractIvmlTypeDescriptor) {
                    iter = ((AbstractIvmlTypeDescriptor) iter).getRefines();
                    assignable = isEqual(iter, this);
                } else {
                    iter = null;
                }
            }
        }
        if (!assignable && null != baseType) {
            assignable = baseType.isAssignableFrom(desc);
        }
        return assignable;
    }
    
    @Override
    public boolean isSet() {
        return net.ssehub.easy.varModel.model.datatypes.Set.TYPE.isAssignableFrom(type);
    }

    @Override
    public boolean isSequence() {
        return net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE.isAssignableFrom(type);
    }
    
    @Override
    protected IDatatype getIvmlType() {
        return type;
    }
    
    @Invisible
    @Override
    public boolean isAssignableFrom(IMetaType type1, IMetaType type2) {
        // allow for backward compatibility complementing to isAssignableFrom(TypeDescriptor<?>)
        return IvmlTypes.decisionVariableType() == type1 && type2 instanceof IvmlTypeDescriptor;
    }

    @Override
    public boolean isInstance(Object object) {
        boolean isInstance = false;
        IDatatype objectType = getDatatype(object);
        if (null != objectType) {            
            isInstance = type.isAssignableFrom(objectType);
            if (!isInstance && null != baseType) {
                IDatatype bType = DerivedDatatype.resolveToBasis(type);
                isInstance = objectType.isAssignableFrom(bType); // objectType is raw
            }
        } 
        return isInstance;
    }

    /**
     * Returns the datatype for <code>object</code>.
     * 
     * @param object the object to return the datatype for
     * @return the datatype or <b>null</b> if there is none
     */
    private IDatatype getDatatype(Object object) {
        IDatatype objectType = null;
        if (object instanceof DecisionVariable) {
            DecisionVariable var = (DecisionVariable) object;
            Value val = var.getDecisionVariable().getValue();
            if (null != val) {
                objectType = val.getType(); // obtain the specific type
            } else {
                objectType = var.getDecisionVariable().getDeclaration().getType();
            }
        } else if (object instanceof Attribute) {
            Attribute att = (Attribute) object;
            objectType = att.getDecisionVariable().getDeclaration().getType();
        } else if (object instanceof EnumValue) {
            objectType = ((EnumValue) object).getDatatype();
        } else if (object instanceof net.ssehub.easy.instantiation.core.model.vilTypes.Set) {
            objectType = net.ssehub.easy.varModel.model.datatypes.Set.TYPE;
        } else if (object instanceof net.ssehub.easy.instantiation.core.model.vilTypes.Sequence) {
            objectType = net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE;
        } else if (object instanceof Integer) {
            objectType = IntegerType.TYPE;
        } else if (object instanceof Double) {
            objectType = RealType.TYPE;
        } else if (object instanceof String) {
            objectType = StringType.TYPE;
        }  else if (object instanceof Boolean) {
            objectType = BooleanType.TYPE;
        }
        return objectType;
    }
    
    @Override
    public boolean isSameType(Object object) {
        boolean isSame = false;
        IDatatype objectType = getDatatype(object);
        if (null != objectType) {            
            isSame = TypeQueries.sameTypes(type, objectType);
            if (!isSame && null != baseType) {
                IDatatype bType = DerivedDatatype.resolveToBasis(type);
                isSame = TypeQueries.sameTypes(objectType, bType); // objectType is raw
            }
        } 
        return isSame;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public boolean isInstantiator() {
        return false;
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        boolean result = true;
        if (param instanceof IvmlTypeDescriptor) {
            IMetaType type = conversion.getReturnType();
            if (IvmlTypes.decisionVariableType() == type || IvmlTypes.ivmlElement() == type) {
                result = false; // this is else an implicit conversion from IVML a to IVML b, a and b unrelated
            }
        }
        return result;
    }

    @Override
    public net.ssehub.easy.instantiation.core.model.vilTypes.Set<?> allInstances() {
        net.ssehub.easy.instantiation.core.model.vilTypes.Set<?> result = null;
        Configuration cfg = ExecutionLocal.getCurrentConfiguration();
        if (null != cfg) {
            result = cfg.allInstances(this);
        }
        return result;
    }

}
