package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;

/**
 * Representation of an abstract project element. This will be further refined by
 * specific elements that can be added to a project.
 * 
 * @author kroeher
 */
public abstract class ProjectElement implements IBuildlangElement {
    
    private String name;
    private ILanguageElement parent;
    
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

    @Override
    public ILanguageElement getParent() {
        return parent;
    }
    
    /**
     * Changes the parent. Please override if children must be adjusted according.
     * Shall be called only once per instance, but there is no limitation.
     * 
     * @param parent the parent
     */
    protected void setParent(ILanguageElement parent) {
        this.parent = parent;
    }

}
