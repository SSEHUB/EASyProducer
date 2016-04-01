package de.uni_hildesheim.sse.easy.loader.framework;

/**
 * In case that a bundle manifest cannot be analyzed properly.
 * 
 * @author Holger Eichelberger
 */
public class BundleException extends Exception {

    private static final long serialVersionUID = 291794257043171478L;

    /**
     * Creates a new bundle exception from the given <code>message</code>.
     * 
     * @param message the message characterizing the problem
     */
    public BundleException(String message) {
        super(message);
    }

}
