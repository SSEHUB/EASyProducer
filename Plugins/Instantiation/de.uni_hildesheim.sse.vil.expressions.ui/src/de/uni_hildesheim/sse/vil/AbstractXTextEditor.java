package de.uni_hildesheim.sse.vil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;

/**
 * An abstract XText editor providing some capabilities for VIL/VTL.
 * In particular, this class extends the official xText editor in order to hook into
 * the saving mechanism. The <code>afterSave</code> event provided
 * by the xText Editor Callback is not sufficient, as it is also called
 * when a in an editor is changed from outside and pushed back into 
 * the editor via the Eclipse refresh mechanism.
 * 
 * @param <T> the type of the top-level language element
 * @author Holger Eichelberger
 */
public abstract class AbstractXTextEditor <T extends EObject> extends org.eclipse.xtext.ui.editor.XtextEditor {

    private URI resourceUri;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void doSaveAs() {
        super.doSaveAs();
        onSave();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        onSave();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRevertToSaved() {
        super.doRevertToSaved();
        onSave();
    }

    /**
     * Is called on saving the model.
     */
    protected abstract void onSave();
    
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        IXtextDocument doc = getDocument();
        if (null != doc) {
            doc.readOnly(new IUnitOfWork<T, XtextResource>() {
                @SuppressWarnings("unchecked")
                public T exec(XtextResource resource) {
                    T root = (T) resource.getContents().get(0);
                    if (null != resource) {
                        AbstractXTextEditor.this.resourceUri = resource.getURI();
                    }
                    return root;
                }
            });
        }
    }
    
    @Override
    public void dispose() {
        if (null != resourceUri) {
            ResourceRegistry.unregister(resourceUri);
            resourceUri = null;
        }
        super.dispose();
    }
    
}
