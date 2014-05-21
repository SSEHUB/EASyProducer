package de.uni_hildesheim.sse.model.confModel;

/**
 * Defines the default and global assignment states.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public enum AssignmentState implements IAssignmentState {

    /**
     * An undefined value. The decision must be taken in future. 
     */
    UNDEFINED,
    
    /**
     * The value is set by the user, but not yet frozen.
     */
    ASSIGNED,
    
    /**
     * The default value is (still) assigned.
     */
    DEFAULT,
    
    /**
     * A (reasoning) mechanism defined the value.
     */
    DERIVED,
    
    /**
     * The value is frozen and cannot be changed.
     */
    FROZEN;
}
