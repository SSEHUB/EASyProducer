package de.uni_hildesheim.sse.dslcore.ui.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * A common extension of the general <code>org.eclipse.xtext.ui.editor.XtextEditor</code>.
 * The extension hooks into the dispose- and the getDocument-mechanism in order to register
 * or unregister a <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * instance, which will update the editor if the underlying data model changes.
 * 
 * @author kroeher
 *
 */
public class CommonXtextEditor extends org.eclipse.xtext.ui.editor.XtextEditor {
    
	/**
	 * The listener which will be registered to this editor in order to receive
	 * notifications about updates of the underlying model.
	 */
    protected AbstractModelChangeListener modelListener;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
    	// Unregister the model listener from the underlying model
    	if (modelListener != null) {      	
            modelListener.unregister();
        }
        super.dispose();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public IXtextDocument getDocument() {
        IXtextDocument doc = super.getDocument();
        /*
         * If the underlying data model could not be found or resolved before (the listener is not listening),
         * try to build the model based on the document that is currently edited in the editor and register
         * this editor's listener again.
         */
        if(doc != null && modelListener != null && !modelListener.isListening()) {
        	//System.out.println("[CommonXtextEditor]: getDocument() - doc available");
            modelListener.setXtextDocument(doc);
            modelListener.register(this);
        }
        return doc;
    }
    
    /**
     * Updates this editor by "touching" its <code>org.eclipse.core.resources.IResource</code>.
     * 
     * @see <code>void org.eclipse.core.resources.IResource.touch(IProgressMonitor monitor) throws CoreException</code>
     */
    public void updateEditor() {    	
    	try {
			this.getResource().touch(getProgressMonitor());
		} catch (CoreException e) {
			System.err.println("[Error] Updating editor failed: " + this);
			e.printStackTrace();
		}
    }
}
