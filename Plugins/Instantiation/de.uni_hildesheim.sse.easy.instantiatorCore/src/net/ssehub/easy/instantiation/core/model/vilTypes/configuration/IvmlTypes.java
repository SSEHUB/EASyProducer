package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.vilTypes.Project;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Provides access to the type descriptors of the types defined in this package.
 * 
 * @author Holger Eichelberger
 */
public class IvmlTypes {

    /**
     * Returns the type descriptor for the built-in type 'Configuration'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> configurationType() {
        return TypeRegistry.DEFAULT.getType(Configuration.class);
    }

    /**
     * Returns the type descriptor for the built-in type 'DecisionVariable'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> decisionVariableType() {
        return TypeRegistry.DEFAULT.getType(DecisionVariable.class);
    }
    
    /**
     * Returns the type descriptor for the built-in type 'IvmlDeclaration'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> declarationType() {
        return TypeRegistry.DEFAULT.getType(IvmlDeclaration.class);
    }

    /**
     * Returns the type descriptor for the built-in type 'Project'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> projectType() {
        return TypeRegistry.DEFAULT.getType(Project.class);
    }

    /**
     * Returns the type descriptor for the built-in type 'Attribute'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> attributeType() {
        return TypeRegistry.DEFAULT.getType(Attribute.class);
    }

    /**
     * Returns the type descriptor for the built-in (fallback) type 'IvmlElement'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> ivmlElement() {
        return TypeRegistry.DEFAULT.getType(IvmlElement.class);
    }

}
