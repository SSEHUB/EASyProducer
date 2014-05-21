package de.uni_hildesheim.sse.utils.logger;

import java.util.logging.Level;

/**
 * Extension for java.util.logging.Level since it does not have a DEBUG level.
 * 
 * @author Sass
 *
 */
public class DebugLevel extends Level {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 2568194940376788365L;

    /**
     * Constructor for DEBUG level which calls super constructor of Level.
     * Level value is placed between CONFIG and INFO.
     * 
     */
    protected DebugLevel() {
        super("DEBUG", 750);
    }

}
