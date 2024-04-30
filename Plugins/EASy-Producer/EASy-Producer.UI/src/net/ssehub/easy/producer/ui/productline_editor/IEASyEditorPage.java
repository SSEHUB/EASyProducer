package net.ssehub.easy.producer.ui.productline_editor;

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
     * @return the receiver's display (may be <b>null</b> if disposed)
     */
    public Display getDisplay();
    
    /**
     * Returns the text label for the editor page.
     * This is for creating labels/tabs in an editor.
     * @return The text label for the editor page (must not be <code>null</code>).
     */
    public String getPageText();
    
    /**
     * Refreshes the shown content of the current project.
     * This method should be calles if the contant inside the editor has been changed and should also affect
     * other editor parts.
     */
    public void refresh();

    /**
     * Returns whether the editor page is disposed.
     * 
     * @return <code>true</code> if the editor page is disposed, <code>false</code> else
     */
    public boolean isDisposed();
    
}
