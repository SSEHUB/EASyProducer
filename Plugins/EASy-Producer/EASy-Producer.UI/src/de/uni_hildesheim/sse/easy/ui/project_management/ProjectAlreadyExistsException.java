package de.uni_hildesheim.sse.easy.ui.project_management;

/**
 * Exception which will be thrown, if a projectname of project, which should be created, already exists.
 * 
 * @author EL-Sharkawy
 * 
 */
@SuppressWarnings("serial")
public class ProjectAlreadyExistsException extends Exception {

    /**
     * Sole constructor for this class.<br>
     * This exception should only be thrown inside this package.
     */
    ProjectAlreadyExistsException() {
        super();
    }
}