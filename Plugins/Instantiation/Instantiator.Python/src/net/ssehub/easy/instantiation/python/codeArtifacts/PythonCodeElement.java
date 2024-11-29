package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python code element in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public abstract class PythonCodeElement implements IPythonCodeElement {
    
    private IPythonCodeElement parent;

    protected PythonCodeElement(IPythonCodeElement parent) {
        this.parent = parent;
    }
    
    @Override
    public IPythonCodeArtifact getArtifact() {
        return parent.getArtifact();
    }

    @Override
    public IPythonCodeElement getParent() {
        return parent;
    }

    @Invisible
    @Override
    public void setParent(IPythonCodeElement parent) {
        this.parent = parent;
    }

}
