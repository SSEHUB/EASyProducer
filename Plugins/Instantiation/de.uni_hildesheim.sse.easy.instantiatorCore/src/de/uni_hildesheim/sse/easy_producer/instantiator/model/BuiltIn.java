package de.uni_hildesheim.sse.easy_producer.instantiator.model;

/**
 * Initializes built-in VIL types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn {
    
    /**
     * Default built-in types.
     */
    public static synchronized void initialize() {
        de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.BuiltIn.initialize();
    }


}
