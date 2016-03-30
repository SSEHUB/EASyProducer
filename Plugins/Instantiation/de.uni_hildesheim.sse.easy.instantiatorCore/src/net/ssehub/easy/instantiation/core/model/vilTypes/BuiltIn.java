package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.instantiation.core.model.artifactModel.ProjectSettings;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Attribute;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.ChangeHistory;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;

/**
 * Initializes built-in VIL types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn {
    
    private static boolean initialized = false;
    
    /**
     * Default built-in types.
     */
    public static synchronized void initialize() {
        if (!initialized) {
            initialized = true;
            TypeRegistry.DEFAULT.register(PseudoBoolean.class);
            TypeRegistry.DEFAULT.register(PseudoInteger.class);
            TypeRegistry.DEFAULT.register(PseudoReal.class);
            TypeRegistry.DEFAULT.register(PseudoString.class);
            TypeRegistry.DEFAULT.register(Collection.class);
            TypeRegistry.DEFAULT.register(Set.class);
            TypeRegistry.DEFAULT.register(Sequence.class);
            TypeRegistry.DEFAULT.register(Map.class);
            TypeRegistry.DEFAULT.register(ResolvableOperationType.class);

            TypeRegistry.DEFAULT.register(Project.class);

            TypeRegistry.DEFAULT.register(IvmlElement.class);
            TypeRegistry.DEFAULT.register(Attribute.class);
            
            TypeRegistry.DEFAULT.register(DecisionVariable.class);
            TypeRegistry.DEFAULT.register(EnumValue.class);
            TypeRegistry.DEFAULT.register(IvmlDeclaration.class);
            TypeRegistry.DEFAULT.register(ChangeHistory.class);
            TypeRegistry.DEFAULT.register(Configuration.class);
            TypeRegistry.DEFAULT.register(ProjectSettings.class);

            // TODO preliminary, attribute -> annotation
            @SuppressWarnings("unchecked")
            TypeDescriptor<Attribute> desc = (TypeDescriptor<Attribute>) TypeRegistry.DEFAULT.getType(Attribute.class);
            TypeRegistry.addTypeMapping("Annotation", desc);
        }
    }

}
