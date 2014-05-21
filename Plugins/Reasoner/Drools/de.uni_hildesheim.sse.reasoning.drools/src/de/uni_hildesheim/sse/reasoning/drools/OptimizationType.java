package de.uni_hildesheim.sse.reasoning.drools;

/**
 * Defines the optimization type for Drools reasoning.
 * @author saripalli
 *
 */
public enum OptimizationType {
    
    /**
     * Case 0 : all the variables are passed for reasoning.
     */
    NONE,
    
    /**
     * Case 1 : only variables that have constraints are passed. Note : this allows the type 
     *          definitions, which are treated as internal constraints, are also passed.
     */
    INTERMEDIATE,
    
    /**
     * Case 2 : only the variables that have constraints are passed. Note : type definitions, or the internal
     *          constraints are not passed.     
     */
    ADVANCED
}
