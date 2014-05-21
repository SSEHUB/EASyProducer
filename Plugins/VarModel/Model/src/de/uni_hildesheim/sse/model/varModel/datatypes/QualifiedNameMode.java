package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Defines modes for considering the qualified name.
 * 
 * @author Holger Eichelberger
 */
public enum QualifiedNameMode {
    
    /**
     * Use unqualified names always.
     */
    UNQUALIFIED,
    
    /**
     * Use qualified names always.
     */
    QUALIFIED,
    
    /**
     * Use unique names (automatic).
     */
    UNIQUE;
}