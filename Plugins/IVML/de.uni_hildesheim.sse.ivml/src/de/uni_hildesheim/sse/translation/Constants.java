package de.uni_hildesheim.sse.translation;

/**
 * Global configuration constants for the IVML translation.
 * 
 * @author Holger Eichelberger
 */
class Constants {

    /**
     * Enables unqualified variable names (in compounds).
     */
    public static final boolean REASONER_UNQUALIFIED_NAME_WARNING = true;

    /**
     * Enables translation to CompoundInitializer and ContainerInitializer for LiteralCollections.
     */
    public static final boolean USE_NEW_LITERALS = true;
    // when this constant is removed, please adjust initializersCustom.ivml in order to have an expression in the test
    
    /**
     * Creates additional debug output.
     */
    public static final boolean DEBUG = false;

}
