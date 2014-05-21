package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * Represents the actual parent class for an EASy table editor.
 *  
 * @author Holger Eichelberger
 */
public interface IEASyEditorPage  {

    /**
     * Informs all {@link IEASyPageListener} that this page became dirty.
     */
    public void setDirty();
    
    /**
     * Returns the content pane of this editor page.
     * @return The content pane of this editor page
     */
    public Composite getContentPane();

    /**
     * Returns the <code>Display</code> that is associated with
     * the receiver.
     *
     * @return the receiver's display
     */
    public Display getDisplay();
    
    /**
     * Returns the text label for the editor page.
     * This is for creating labels/tabs in an editor.
     * @return The text label for the editor page (must not be <tt>null</tt>).
     */
    public String getPageText();
    
    /**
     * Refreshes the shown content of the current project.
     * This method should be calles if the contant inside the editor has been changed and should also affect
     * other editor parts.
     */
    public void refresh();

}
