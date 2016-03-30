package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Represents a file of properties to be loaded.
 * 
 * @author Holger Eichelberger
 */
public class LoadProperties implements IBuildlangElement {

    private String path;

    /**
     * Creates a new properties object.
     * 
     * @param path the path from where to load the properties
     */
    public LoadProperties(String path) {
        this.path = path;
    }
    
    /**
     * Returns the original path as String.
     * 
     * @return the original path
     */
    public String getPath() {
        return path;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitLoadProperties(this);        
    }

}
