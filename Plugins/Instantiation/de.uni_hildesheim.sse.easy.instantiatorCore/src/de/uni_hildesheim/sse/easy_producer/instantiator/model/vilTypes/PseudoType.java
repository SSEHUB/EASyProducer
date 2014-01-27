package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Just a type for types.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "Type", equiv = Class.class)
public final class PseudoType implements IVilType {

    /**
     * Prevents external instantiation.
     */
    private PseudoType() {
    }
    
}
