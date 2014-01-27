package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

/**
 * Representation of an abstract project element. This will be further refined by
 * specific elements that can be added to a project: <code>VariableDeclaration</code>
 * and <code>Workflow</code>
 * 
 * @author kroeher
 *
 */
public abstract class ProjectElement implements IBuildlangElement {
    
    private String name;
    
    /**
     * Create a new project element with the given name.
     *  
     * @param name The name of the project element.
     */
    public ProjectElement(String name) {
        this.name = name;
    }
    
    /**
     * Get the name of this project element.
     * 
     * @return The name of this project element.
     */
    public String getName() {
        return this.name;
    }

}
