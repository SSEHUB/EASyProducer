package de.uni_hildesheim.sse.utils.logger;

import java.util.logging.Level;

/**
 * Extension for java.util.logging.Level since it does not have a EXCEPTION level.
 * 
 * @author Sass
 *
 */
public class ExceptionLevel extends Level {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 6875381264871245337L;

    /**
     * Constructor for EXCEPTION level which calls super constructor of Level.
     * Level value is placed between CONFIG and INFO.
     * 
     */
    protected ExceptionLevel() {
        super("EXCEPTION", 760);
    }

}
