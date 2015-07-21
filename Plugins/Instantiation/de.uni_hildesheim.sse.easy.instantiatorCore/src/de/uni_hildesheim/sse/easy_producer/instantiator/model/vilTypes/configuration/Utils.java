package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * Some utility methods. Currently it is unsure how much access to pure variable
 * declarations VIL actually needs. Here are some accessor methods for VIL compliant
 * types but, however, the results are actually not cached!
 * 
 * @author Holger Eichelberger
 */
public class Utils {
    
    /**
     * Prevents external creation.
     */
    private Utils() {
    }
    
    /**
     * Returns a matching attribute declaration.
     * 
     * @param configuration the configuration to return the declaration for
     * @param name the name of the attribute to be returned
     * @return the attribute declaration or <b>null</b> if not found
     */
    public static IvmlDeclaration getAttributeDeclaration(Configuration configuration, String name) {
        IvmlDeclaration result = null;
        Project project = configuration.getConfiguration().getProject();
        for (int a = 0; null == result && a < project.getAttributesCount(); a++) {
            AbstractVariable var = project.getAttribute(a);
            if (var.getName().equals(name) || var.getQualifiedName().equals(name)) {
                result = new IvmlDeclaration(var);
            }
        }
        return result;
    }

    /**
     * Determines the VIL/VTL return type for the given IVML <code>type</code>.
     * @param type the IVML type
     * @param registry the actual type registry (may be <b>null</b>, result is 
     *   then {@link IvmlTypes#decisionVariableType()}
     * @param specific resolve for the specific IVML type or for IVML specific dynamic type descriptors
     * @return the return type
     * @throws VilException in case that creating the type fails
     */
    protected static TypeDescriptor<?> determineReturnType(IDatatype type, TypeRegistry registry, boolean specific) 
        throws VilException {
        TypeDescriptor<?> result;
        type = DerivedDatatype.resolveToBasis(type);
        if (Set.TYPE.isAssignableFrom(type)) {
            result = TypeRegistry.getSetType(determineGenerics(type, registry, specific));
        } else if (Sequence.TYPE.isAssignableFrom(type)) {
            result = TypeRegistry.getSequenceType(determineGenerics(type, registry, specific));
        } else { // no map in IVML
            result = null;
            if (specific && null != registry) { // typically given
                // TODO move out
                if (!ConstraintType.TYPE.isAssignableFrom(type)) {
                    result = registry.getType(Reference.dereference(type));
                }
            }
            if (null == result) {
                result = IvmlTypes.decisionVariableType();
            }
        }
        return result;
    }
    
    /**
     * Determines the VIL types for the given generic types.
     * 
     * @param type the type to take the generic types from
     * @param registry the actual type registry (may be <b>null</b>, result is 
     *   then {@link IvmlTypes#decisionVariableType()}
     * @param specific resolve for the specific IVML type or for IVML specific dynamic type descriptors
     * @return the generic types
     * @throws VilException in case that creating a type fails
     */
    protected static TypeDescriptor<?>[] determineGenerics(IDatatype type, TypeRegistry registry, boolean specific) 
        throws VilException {
        TypeDescriptor<?>[] generics = TypeDescriptor.createArray(type.getGenericTypeCount());
        for (int t = 0; t < generics.length; t++) {
            generics[t] = determineReturnType(type.getGenericType(t), registry, specific);
        }
        return generics;
    }

    /**
     * Generic implementation of the compatibility method for a parameter of type {@link DecisionVariable}.
     * 
     * @param param the actual parameter
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatibleToDecisionVariable(Object param) {
        return isCompatible(param, DecisionVariable.class);
    }
    
    /**
     * Generic implementation of the compatibility method for one parameter of type {@link DecisionVariable}.
     * 
     * @param params the actual parameters
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatibleToDecisionVariable(Object[] params) {
        return isCompatible(params, DecisionVariable.class);
    }
  
    /**
     * Generic implementation of the compatibility method for one parameter.
     * 
     * @param params the actual parameters
     * @param paramType the expected parameter type
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatible(Object[] params, Class<?> paramType) {
        CompatibilityResult result;
        if (null != params && params.length == 1) {
            result = isCompatible(params[0], paramType);
        } else {
            result = CompatibilityResult.INCOMPATIBLE;
        }
        return result;
    }

    
    /**
     * Generic implementation of the compatibility method for a parameter.
     * 
     * @param param the actual parameter
     * @param paramType the expected parameter type
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatible(Object param, Class<?> paramType) {
        CompatibilityResult result;
        if (paramType.isInstance(param)) {
            result = CompatibilityResult.COMPATIBLE;
        } else {
            result = CompatibilityResult.INCOMPATIBLE;
        }
        return result;
    }

    /**
     * Adds a descriptor to the given signature-descriptor map.
     * 
     * @param operation the operation to be added
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected static void addOperation(OperationDescriptor operation, Map<String, OperationDescriptor> operations) {
        String sig = operation.getSignature();
        if (!operations.containsKey(sig)) {
            operations.put(sig, operation);
        }
    }

    /**
     * Adds a descriptor to the given signature-descriptor map.
     * 
     * @param field the field to be added
     * @param fields the operations (signature-descriptor) (to be modified as a side effect)
     */
    protected static void addField(FieldDescriptor field, Map<String, FieldDescriptor> fields) {
        String sig = field.getSignature();
        if (!fields.containsKey(sig)) {
            fields.put(sig, field);
        }
    }

}
