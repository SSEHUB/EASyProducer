package de.uni_hildesheim.sse.dslcore.ui.editors;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.dslcore.ui.Activator;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Helps embedding the xText-editor of a certain grammar.
 * 
 * @author Holger Eichelberger
 * @author Christian Kröher
 */
@SuppressWarnings("restriction")
public abstract class EmbeddingHelper {

    /**
     * Returns the content of the file identified by the given URI.
     * 
     * @param file the URI that identifies the file
     * @return the content of the file as <code>String</code> or <code>null</code> if
     * the file does not exist
     */
    private static String getResourceContent(java.net.URI file) {
        String fileContent = null;
        if (file != null) {
            File resourceFile = new File(file);
            if (resourceFile.exists()) {
                StringBuilder contentBuilder = new StringBuilder();
                try {
                    List<String> content = Files.readAllLines(resourceFile.toPath(), Charset.defaultCharset());
                    for (String line : content) {
                        contentBuilder.append(line);
                        contentBuilder.append("\n");
                    }
                } catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(EmbeddingHelper.class, Activator.PLUGIN_ID).exception(e);
                }
                fileContent = contentBuilder.toString();
            }
        }
        return fileContent;
    }
    
    /**
     * Embeds an xText editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @param injector the injector configured for the editor and the grammar of <code>file</code>
     */
    public static void embedEditor(final java.net.URI file, Composite parent, final Injector injector) {
        IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
            public XtextResource createResource() {
                XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
                rs.setClasspathURIContext(getClass());

                IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
                URI uri = URI.createURI(file.toString());
                XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
                rs.getResources().add(resource);
                EcoreUtil.resolveAll(resource);

                if (!resource.getErrors().isEmpty()) {
                    StringBuilder tmp = new StringBuilder();
                    for (Diagnostic d : resource.getErrors()) {
                        if (tmp.length() > 0) {
                            tmp.append(", ");
                        }
                        tmp.append(d.getMessage());
                    }
                    EASyLoggerFactory.INSTANCE.getLogger(EmbeddingHelper.class, Activator.PLUGIN_ID).error(
                        tmp.toString());
                }
                return resource;
            }
        };
        embedEditor(parent, injector, resourceProvider, getResourceContent(file));
        // currently a meaningful return object is unclear
    }

    /**
     * Embeds an xText editor for the given resource into the given <code>parent</code>.
     * 
     * @param parent the parent UI component
     * @param injector the injector configured for the editor and the grammar of <code>file</code>
     * @param resourceProvider the resource to be displayed
     * @param editablePart the actual editable content
     */
    private static void embedEditor(Composite parent, Injector injector, IEditedResourceProvider resourceProvider, 
        String editablePart) {
        // processIssuesBy
        EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
        EmbeddedEditor embeddedEditor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
            .withParent(parent);
        // solution by: http://stackoverflow.com/questions/15324481/xtext-dsl-embedded-editor-in-a-dialog
        @SuppressWarnings("unused")
        EmbeddedEditorModelAccess partialEditorModelAccess = embeddedEditor.createPartialEditor("", 
            editablePart, "", false);
        // currently a meaningful return object is unclear
    }

}
