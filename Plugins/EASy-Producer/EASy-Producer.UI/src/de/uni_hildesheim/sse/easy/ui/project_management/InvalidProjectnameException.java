package de.uni_hildesheim.sse.easy.ui.project_management;

/**
 * Exception which will be thrown, if a chosen name of a project is not valid.
 * 
 * @author Nowatzki
 * 
 */
@SuppressWarnings("serial")
public class InvalidProjectnameException extends Exception {
    /**
     * Sole constructor for this class.<br>
     * This exception should only be thrown inside this package.
     */
    InvalidProjectnameException() {
        super();
    }
}
