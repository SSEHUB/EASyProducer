package de.uni_hildesheim.sse.easy.ui.productline_editor;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Supports external updates to the created editors.
 * 
 * @author Holger Eichelberger
 */
public interface IUpdateProvider {

    /**
     * Refreshes the contents of the editor.
     */
    public void refreshContents();
    
    /**
     * Defines the update listener. The update listener will be disposed automatically .
     * 
     * @param listener the update listener
     */
    public void setUpdateListener(IUpdateListener listener);
    
    /**
     * Returns the underlying decision variable.
     * 
     * @return the decision variable
     */
    public IDecisionVariable getVariable();
}
