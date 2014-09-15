package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * A type which can be assigned to any type.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "Any")
final class PseudoAny implements IVilType {
    
    /**
     * Prevents external instantiation.
     */
    private PseudoAny() {
    }
    
}
