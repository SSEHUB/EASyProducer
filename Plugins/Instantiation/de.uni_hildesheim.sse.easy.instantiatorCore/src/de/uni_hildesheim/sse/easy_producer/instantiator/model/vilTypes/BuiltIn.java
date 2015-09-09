package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ProjectSettings;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Attribute;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.ChangeHistory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;

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
        }
    }

}
