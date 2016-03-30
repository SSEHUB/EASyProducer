package net.ssehub.easy.producer.ui.productline_editor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * Implementation of an editorpage to use the configuration table editor within 
 * usual composites.
 */
public class DelegatingEasyEditorPage implements IEASyEditorPage {

    private Composite composite;
    private boolean dirty;
    private IDirtyListener listener;
    
    /**
     * A dirty listener interface.
     * 
     * @author Holger Eichelberger
     */
    public interface IDirtyListener {
        
        /**
         * Notifies the listener about a change in the dirty state.
         * 
         * @param dirtyState the new dirty state
         */
        public void notifyDirty(boolean dirtyState);
    }

    /**
     * Constructor for an EasyEditorPage.
     * @param composite This Composite will be set. 
     */
    public DelegatingEasyEditorPage(Composite composite) {
        this(composite, null);
    }

    /**
     * Constructor for an EasyEditorPage.
     * @param composite This Composite will be set. 
     * @param listener optional dirty listener (may be <b>null</b>)
     */
    public DelegatingEasyEditorPage(Composite composite, IDirtyListener listener) {
        this.composite = composite;
        this.listener = listener;
    }
    
    /**
     * Notifies the dirty listener about a change in the dirty flag.
     */
    private void notifyListener() {
        if (null != listener) {
            listener.notifyDirty(dirty);
        }
    }
    
    @Override
    public void setDirty() {
        this.dirty = true;
        notifyListener();
    }

    /**
     * Resets the dirty flag.
     */
    public void unsetDirty() {
        this.dirty = false;
        notifyListener();
    }
    
    /**
     * Returns whether dirty or not.
     * @return dirty true -> dirty.
     *               false -> not dirty.
     */
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public Composite getContentPane() {
        return composite;
    }

    @Override
    public Display getDisplay() {
        Display result;
        if (composite.isDisposed()) {
            result = null;
        } else {
            result = composite.getDisplay();
        }
        return result;
    }

    @Override
    public String getPageText() {
        return "";
    }

    @Override
    public void refresh() {
    }

    @Override
    public boolean isDisposed() {
        return composite.isDisposed();
    }
}
