package de.uni_hildesheim.sse.vil;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;

/**
 * An abstract XText editor providing some capabilities for VIL/VTL.
 * In particular, this class extends the official xText editor in order to hook into
 * the saving mechanism. The <code>afterSave</code> event provided
 * by the xText Editor Callback is not sufficient, as it is also called
 * when a in an editor is changed from outside and pushed back into 
 * the editor via the Eclipse refresh mechanism.
 * 
 * Update: This class now extends the
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.CommonXtextEditor</code>
 * which in turn extends the official Xtext editor. This update hooks into
 * the initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data model.
 * 
 * @param <T> the type of the top-level language element
 * @author Holger Eichelberger
 * @author kroeher
 */
public abstract class AbstractXTextEditor <T extends EObject, R> extends CommonXtextEditor<T, R> {

    private URI resourceUri;
    
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        IXtextDocument doc = getDocument();
        if (null != doc) {
            doc.readOnly(new IUnitOfWork<T, XtextResource>() {
                @SuppressWarnings("unchecked")
                public T exec(XtextResource resource) {
                    T root = null; 
                    if (null != resource) { // file not there
                        EList<?> lst = resource.getContents();
                        if (lst.isEmpty()) {
                            root = null;
                        } else {
                            root = (T) resource.getContents().get(0);
                        }
                        if (null != resource) {
                            AbstractXTextEditor.this.resourceUri = resource.getURI();
                        }
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
