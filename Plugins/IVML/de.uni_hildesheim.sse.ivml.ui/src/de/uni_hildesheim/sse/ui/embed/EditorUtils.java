package de.uni_hildesheim.sse.ui.embed;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.ui.internal.IvmlActivator;

@SuppressWarnings("restriction")
public class EditorUtils {

    /**
     * Creates an instance (public constructor required by OSGI-DS.
     */
    public EditorUtils() {
    }

    /**
     * Returns the IVML injector.
     * 
     * @return the injector
     */
    private static Injector getInjector() {
        IvmlActivator activator = IvmlActivator.getInstance();
        return activator.getInjector(IvmlActivator.DE_UNI_HILDESHEIM_SSE_IVML);
    }
    
    /**
     * Embeds an IVML editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     */
    public static void embedIvmlEditor(final java.net.URI file, Composite parent) {
        IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
            public XtextResource createResource() {
                Injector injector = getInjector();
                XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
                rs.setClasspathURIContext(getClass());

                IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
                URI uri = URI.createURI(file.toString());
                XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
                rs.getResources().add(resource);
                /*try {
                resource.load(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                EcoreUtil.resolveAll(resource);

                if (!resource.getErrors().isEmpty()) {
                    // handle error?
                }
                return resource;
            }};

        Injector injector = getInjector();
        // processIssuesBy
        EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
        EmbeddedEditor embeddedEditor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
            .withParent(parent);
//        EmbeddedEditorModelAccess partialEditorModelAccess = embeddedEditor.createPartialEditor(false);
        embeddedEditor.createPartialEditor();
    }

}
