package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * Implements a dynamic type descriptor for IVM decision variables. Instances of this
 * class represent IVML types and act as a frontend for {@link DecisionVariable}, thus,
 * {@link DecisionVariable decision variables} are assignable.
 * 
 * @author Holger Eichelberger
 */
public class IvmlTypeDescriptor extends AbstractIvmlTypeDescriptor {

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
        Set<de.uni_hildesheim.sse.model.varModel.Attribute> declaredAttributes) throws VilException {
        TypeRegistry registry = getTypeRegistry();
        Map<String, OperationDescriptor> operations = new HashMap<String, OperationDescriptor>();
        Map<String, FieldDescriptor> fields = new HashMap<String, FieldDescriptor>();
        addDecisionVariableOperations(operations);
        addComparisonOperations(ivmlType, operations);
        // first of the type, then specific -> map, only one will be added
        addAttributeFields(fields, ivmlType instanceof IModelElement ? (IModelElement) ivmlType : project, 
            registry);
        if (null != declaredAttributes) {
            for (de.uni_hildesheim.sse.model.varModel.Attribute att : declaredAttributes) {
                Utils.addField(new IvmlAnnotationFieldDescriptor(this, att, registry), fields);
            }
        }
        if (ivmlType instanceof Compound) {
            Compound comp = (Compound) ivmlType;
            Compound refines = comp.getRefines();
            if (null != refines) {
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
        setOperations(operations.values());
        setFields(fields.values());
        List<OperationDescriptor> conversions = new ArrayList<OperationDescriptor>();
        conversions.add(new IvmlConversionOperationDescriptor(this));
        if (DerivedDatatype.TYPE.isAssignableFrom(ivmlType)) {
            IDatatype baseType = DerivedDatatype.resolveToBasis(ivmlType);
            TypeDescriptor<?> vilBaseType = registry.getType(baseType.getName());
            if (de.uni_hildesheim.sse.model.varModel.datatypes.Set.TYPE.isAssignableFrom(baseType)) {
                IvmlOperationDescriptor desc = new IvmlSetConversionOperationDescriptor(this, vilBaseType);
                conversions.add(desc);
                this.baseType = desc.getReturnType();
            } else if (Sequence.TYPE.isAssignableFrom(baseType)) {
                IvmlOperationDescriptor desc = new IvmlSequenceConversionOperationDescriptor(this, vilBaseType);
                conversions.add(desc);
                this.baseType = desc.getReturnType();
            }
        }
        addConversionOperations(ivmlType, conversions);
        setConversions(conversions);
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
        if (!assignable && null != desc) {
            // check refines hierarchy on desc
            TypeDescriptor<?> iter = desc;
            do {
                if (iter instanceof AbstractIvmlTypeDescriptor) {
                    iter = ((AbstractIvmlTypeDescriptor) iter).getRefines();
                    assignable = (iter == this);
                } else {
                    iter = null;
                }
            } while (!assignable && null != iter);
        }
        if (!assignable && null != baseType) {
            assignable = baseType.isAssignableFrom(desc);
        }
        return assignable;
    }

    @Override
    public boolean isInstance(Object object) {
        boolean isInstance = false;
        IDatatype objectType = null;
        if (object instanceof DecisionVariable) {
            DecisionVariable var = (DecisionVariable) object;
            objectType = var.getDecisionVariable().getDeclaration().getType();
        } else if (object instanceof Attribute) {
            Attribute att = (Attribute) object;
            objectType = att.getDecisionVariable().getDeclaration().getType();
        } else if (object instanceof EnumValue) {
            objectType = ((EnumValue) object).getDatatype();
        } else if (object instanceof de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set) {
            objectType = de.uni_hildesheim.sse.model.varModel.datatypes.Set.TYPE;
        } else if (object instanceof de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence) {
            objectType = de.uni_hildesheim.sse.model.varModel.datatypes.Sequence.TYPE;
        } else if (object instanceof Integer) {
            objectType = IntegerType.TYPE;
        } else if (object instanceof Double) {
            objectType = RealType.TYPE;
        } else if (object instanceof String) {
            objectType = StringType.TYPE;
        }  else if (object instanceof Boolean) {
            objectType = BooleanType.TYPE;
        }
        if (null != objectType) {            
            isInstance = type.isAssignableFrom(objectType);
            if (!isInstance && null != baseType) {
                IDatatype bType = DerivedDatatype.resolveToBasis(type);
                isInstance = objectType.isAssignableFrom(bType); // objectType is raw
            }
        } 
        return isInstance;
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

}
