package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Just a type for types. {@link TypeDescriptor} is also considered equivalent
 * to {@link PseudoType} and <i>Class</i> for convenience of writing artifacts
 * and types. This is handled by explicit type conversion before a call.
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
