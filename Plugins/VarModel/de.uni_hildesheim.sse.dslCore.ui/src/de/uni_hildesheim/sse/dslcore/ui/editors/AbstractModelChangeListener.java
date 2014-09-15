package de.uni_hildesheim.sse.dslcore.ui.editors;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import de.uni_hildesheim.sse.utils.modelManagement.IModel;

/**
 * Abstract listener for listening to changes of an underlying model and updating the respective
 * <code>org.eclipse.xtext.ui.editor.XtextEditor</code> registered to this listener as well as all
 * other <code>org.eclipse.xtext.ui.editor.XtextEditor</code> currently running.
 * 
 * <b>Note</b> that all derived classes of this abstract class must also implement the
 * <code>de.uni_hildesheim.sse.utils.modelManagement.IModelListener</code> interface
 * with the respective generic:
 * 
 * Listening to a specific <code>de.uni_hildesheim.sse.model.varModel.Project</code>: IModelListerner<Project>
 * Listening to a specific <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script</code>: IModelListerner<Script>
 * Listening to a specific <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template</code>: IModelListerner<Template>
 * 
 * Further, retrieving the respective model, adding this listener to this model and unregistering from this model must be implemented by the
 * derived classes as well. 
 * 
 * @author kroeher
 *
 */
public abstract class AbstractModelChangeListener {

	/**
	 * The <code>de.uni_hildesheim.sse.dslcore.ui.editors.XtextEditor</code> instance which
	 * is registered to this listener in order to be updated if the underlying
	 * model changes.
	 */
	protected CommonXtextEditor xtextEditor;
	
	/**
	 * Indicates whether this listener is currently listening
	 * to a specific model (<code>true</code>) or not (<code>false</code>).
	 */
	protected boolean isListening;
	
	/**
	 * The <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> instance
	 * which is currently edited in the <code>org.eclipse.xtext.ui.editor.XtextEditor</code> instance
	 * that is registered to this listener.
	 */
	protected IXtextDocument xtextDocument;
	
	/**
	 * The <code>de.uni_hildesheim.sse.utils.modelManagement.IModel</code> instance
	 * (IVML- or VIL-model) which is currently edited in the registered
	 * <code>org.eclipse.xtext.ui.editor.XtextEditor</code> instance of this listener.
	 */
	protected IModel underlyingModel;
	
	/**
	 * Unregisters this listener from the underlying model in order to receive
	 * no events about changes of the model anymore.
	 * 
	 * <b>This method must be called if the registered editor is disposed.</b>
	 */
	public abstract void unregister();
	
	/**
	 * Adds this listener to the underlying model in order to receive events
	 * if this model changes.
	 * 
	 * @param underlyingModel the <code>de.uni_hildesheim.sse.utils.modelManagement.IModel</code>
	 * to which this listener must be registered
	 * @return <code>true</code> if the registration of this listener to the given mode was successful,
	 * <code>false</code> otherwise
	 */
	protected abstract boolean registerToUnderlyingModel(IModel underlyingModel);
	
	/**
	 * Returns the <code>de.uni_hildesheim.sse.utils.modelManagement.IModel</code> instance
	 * (an IVML-, VIL-, or VTL-model) based on the URI of the <code>org.eclipse.core.resources.IResource</code>
	 * (the document) currently in use by the editor that is registered to this listener.
	 * 
	 * <b>Note</b> that this method will be called internally to retrieve the underlying model.
	 *   
	 * @param modelFileUri the <code>java.net.URI</code> of the <code>org.eclipse.core.resources.IResource</code>
	 * (the document) currently in use by the editor that is registered to this listener.
	 * @param forceBuild <code>true</code> if the model should be build if it cannot resolved. <code>false</code>
	 * if no build should be forced.
	 * @return the <code>de.uni_hildesheim.sse.utils.modelManagement.IModel</code>
	 * (an IVML-, VIL-, or VTL-model) which is currently edited in the registered editor
	 * of this listener. 
	 */
	protected abstract IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild);
	
	/**
	 * Registers the editor to this listener in order to update the editor
	 * if the underlying model changes. This method will automatically register
	 * this listener to the model which is currently edited in the editor.
	 * 
	 * @param editor the <code>org.eclipse.xtext.ui.editor.XtextEditor</code> instance
	 * which has to be updated.
	 */
	public void register(CommonXtextEditor editor){
		if (editor != null) {
			if (xtextEditor == null) {				
				xtextEditor = editor;
			}
			isListening = addListenerToModel();
		}
	}
	
	/**
	 * Sets the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the editor currently
	 * registered to this listener.
	 * 
	 * The <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> instance is required to find
	 * the underlying model and to register this listener to that model.
	 * 
	 * @param doc the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> instance in use by
	 * the registered editor.
	 */
	public void setXtextDocument(IXtextDocument doc) {
		if (doc != null && xtextDocument == null) {
			xtextDocument = doc;
		}
	}
	
	/**
	 * Returns the current status of this listener.
	 * 
	 * @return <code>true</code> if this listener is currently listening to an underlying model.
	 * <code>false</code> if this listener is currently not added to a specific model.
	 */
	public boolean isListening() {
		return isListening;
	}
    
    /**
     * Updates the registered editor.
     * 
     */
    protected void updateRegisteredEditor() {
        xtextEditor.updateEditor();
    }
    
    /**
     * Registers this listener to the model which is currently edited in the editor
     * that is registered to this listener.
     * 
     * @return <code>true</code> if the registration of this listener to the given mode was successful,
	 * <code>false</code> otherwise
     */
	private boolean addListenerToModel() {
		boolean listenerAdded = false;
		IResource editorResource = xtextEditor.getResource();
        if (editorResource != null) {
            URI modelFileUri = editorResource.getLocationURI();
            if (modelFileUri != null) {
            	underlyingModel = getUnderlyingModel(modelFileUri, true);
            	listenerAdded = registerToUnderlyingModel(underlyingModel);
            }
        }
		return listenerAdded;
	}
}
