package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Attribute;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
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
            TypeRegistry.register(PseudoBoolean.class);
            TypeRegistry.register(PseudoInteger.class);
            TypeRegistry.register(PseudoReal.class);
            TypeRegistry.register(PseudoString.class);
            TypeRegistry.register(PseudoType.class);
            TypeRegistry.register(Collection.class);
            TypeRegistry.register(Set.class);
            TypeRegistry.register(Sequence.class);
            TypeRegistry.register(Map.class);

            TypeRegistry.register(Project.class);

            TypeRegistry.register(IvmlElement.class);
            TypeRegistry.register(Attribute.class);
            TypeRegistry.register(DecisionVariable.class);
            TypeRegistry.register(Configuration.class);
        }
    }

}
