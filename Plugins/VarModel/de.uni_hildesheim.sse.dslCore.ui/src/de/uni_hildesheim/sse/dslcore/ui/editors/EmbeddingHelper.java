package de.uni_hildesheim.sse.dslcore.ui.editors;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
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
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    public static IEmbeddedEditor embedEditor(final java.net.URI file, Composite parent, final Injector injector) {
        String[] content = new String[3];
        content[0] = "";
        content[1] = getResourceContent(file);
        content[2] = "";
        return embedEditor(file, parent, injector, content, true);
    }
    
    /**
     * Embeds an xText editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @param injector the injector configured for the editor and the grammar of <code>file</code>
     * @param content a split of <code>file</code> consisting of the actual editable content in terms of prefix not to 
     *   be shown [0], content to be displayed [1] and postfix not to be shown[2]
     * @param requireWorkspaceResource whether the editor requires a workspace resource and shall complain at least in 
     *   the logs or whether it shall be silent
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    public static IEmbeddedEditor embedEditor(final java.net.URI file, Composite parent, final Injector injector, 
        String[] content, boolean requireWorkspaceResource) {
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
        return embedEditor(parent, injector, resourceProvider, content, requireWorkspaceResource);
    }

    /**
     * Embeds an xText editor for the given resource into the given <code>parent</code>.
     * 
     * @param parent the parent UI component
     * @param injector the injector configured for the editor and the grammar of <code>file</code>
     * @param resourceProvider the resource to be displayed
     * @param content the actual editable content in terms of prefix not to be shown [0], content to be displayed [1] 
     *   and postfix not to be shown[2]
     * @param requireWorkspaceResource whether the editor requires a workspace resource and shall complain at least in 
     *   the logs or whether it shall be silent
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    private static IEmbeddedEditor embedEditor(Composite parent, Injector injector, 
        IEditedResourceProvider resourceProvider, String[] content, boolean requireWorkspaceResource) {
        // processIssuesBy
        EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
        EmbeddedEditor embeddedEditor = factory.newEditor(resourceProvider).showErrorAndWarningAnnotations()
            .withParent(parent);
        // solution by: http://stackoverflow.com/questions/15324481/xtext-dsl-embedded-editor-in-a-dialog
        EmbeddedEditorModelAccess partialEditorModelAccess = embeddedEditor.createPartialEditor(content[0], 
            content[1], content[2], false);
        XtextSourceViewer viewer = embeddedEditor.getViewer();
        StyledText text = viewer.getTextWidget();
        try {
            Font font = text.getFont();
            if (null != font) {
                // TODO preliminary, use editor configuration instead
                FontData[] fontData = font.getFontData();
                if (null != fontData && fontData.length > 0) {
                    text.setFont(new Font(font.getDevice(), "Consolas", 
                        fontData[0].getHeight(), fontData[0].getStyle()));
                }
            }
        } catch (SWTError e) {
            // no font, ignore
            EASyLoggerFactory.INSTANCE.getLogger(EmbeddingHelper.class, Activator.PLUGIN_ID).error(e.getMessage());
        }
        return new EmbeddedXtextSourceEditor(embeddedEditor, viewer, partialEditorModelAccess, 
            requireWorkspaceResource);
    }
    
}
