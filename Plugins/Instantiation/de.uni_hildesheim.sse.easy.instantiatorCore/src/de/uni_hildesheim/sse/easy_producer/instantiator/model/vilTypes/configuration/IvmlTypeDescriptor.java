package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Implements a dynamic type descriptor for IVM decision variables. Instances of this
 * class represent IVML types and act as a frontend for {@link DecisionVariable}, thus,
 * {@link DecisionVariable decision variables} are assignable.
 * 
 * @author Holger Eichelberger
 */
class IvmlTypeDescriptor extends AbstractIvmlTypeDescriptor {
  
    /**
     * Creates a new type descriptor.
     * 
     * @param project the underlying IVML project the descriptor shall be created for
     * @param ivmlType the IVML type to create the descriptor for
     * @param resolver for retrieving further IVML types
     * @param declaredAttributes attributes declared for all variables of that type, may be <b>null</b>
     * @throws VilException if analyzing the class fails for some reason
     */
    IvmlTypeDescriptor(Project project, IDatatype ivmlType, IvmlTypeResolver resolver, 
        Set<de.uni_hildesheim.sse.model.varModel.Attribute> declaredAttributes) throws VilException {
        super(ivmlType, resolver);
        Map<String, OperationDescriptor> operations = new HashMap<String, OperationDescriptor>();
        addMetaOperations(operations);
        addComparisonOperations(operations);
        // first of the type, then specific -> map, only one will be added
        addAttributeOperations(operations, ivmlType instanceof IModelElement ? (IModelElement) ivmlType : project);
        if (null != declaredAttributes) {
            for (de.uni_hildesheim.sse.model.varModel.Attribute att : declaredAttributes) {
                IvmlAttributeOperationDescriptor.createDescriptors(this, att, operations);
            }
        }
        if (ivmlType instanceof Compound) {
            Compound comp = (Compound) ivmlType;
            Compound refines = comp.getRefines();
            if (null != refines) {
                TypeDescriptor<? extends IVilType> tmp = resolver.obtainType(refines);
                if (tmp instanceof IvmlTypeDescriptor) { // just to be sure
                    IvmlTypeDescriptor refinesDesc = (IvmlTypeDescriptor) tmp;
                    setRefines(refinesDesc);
                    for (int o = 0; o < refinesDesc.getOperationsCount(); o++) {
                        OperationDescriptor op = refinesDesc.getOperation(o);
                        // not the meta operations
                        if (op instanceof IvmlAccessorOperationDescriptor) {
                            addOperation(op, operations);
                        }
                    }
                }
            }
            for (int e = 0; e < comp.getElementCount(); e++) {
                DecisionVariableDeclaration decl = comp.getElement(e);
                IvmlAccessorOperationDescriptor.createDescriptors(this, decl, operations);
            }
        }
        setOperations(operations.values());
        List<OperationDescriptor> conversions = new ArrayList<OperationDescriptor>();
        conversions.add(new IvmlConversionOperationDescriptor(this));
        addConversionOperations(conversions);
        setConversions(conversions);
    }
    
    @Override
    public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
        // final check at runtime
        // check direct type or decision variable
        boolean assignable = (desc == this || IvmlTypes.decisionVariableType() == desc);
        if (!assignable && null != desc) {
            // check refines hierarchy on desc
            TypeDescriptor<? extends IVilType> iter = desc;
            do {
                if (iter instanceof AbstractIvmlTypeDescriptor) {
                    iter = ((AbstractIvmlTypeDescriptor) iter).getRefines();
                    assignable = (iter == this);
                } else {
                    iter = null;
                }
            } while (!assignable && null != iter);
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
        }
        if (null != objectType) {
            isInstance = getDatatype().isAssignableFrom(objectType);
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
    
}
