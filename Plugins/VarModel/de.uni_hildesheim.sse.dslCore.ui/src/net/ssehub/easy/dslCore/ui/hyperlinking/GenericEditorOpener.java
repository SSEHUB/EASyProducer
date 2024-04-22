package net.ssehub.easy.dslCore.ui.hyperlinking;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.BundleId;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;

/**
 * This class provides a single method for opening an language-specific editor and selecting
 * a specific element of the opened file in that editor based on a given
 * {@link ILeafNode} that represents the element for which the declaration
 * should be displayed.
 * 
 * This is used to enable the "F3"-functionality.
 * 
 * @param <T> the type of the top-level language element
 * @param <P> the type of the "project", the top-most semantic language unit
 * @param <M> the type of model representing "project"
 * @param <E> the top-level element type of &lt;M&gt;
 * @param <R> the result type when querying for model elements in {@link IModelQuery} and searching them 
 *     on Ecore ({@link IEcoreModelQuery})
 * @author kroeher
 */
public class GenericEditorOpener <T extends EObject, P extends EObject, M extends IModel, E, R> {

    private IEcoreModelQuery<P, R> ecoreModelQuery;
    private IModelQuery<M, E, R> modelQuery;
    
    /**
     * Constructs the singleton instance.
     * 
     * @param ecoreModelQuery the ECore model query object
     * @param modelQuery the model query object
     */
    public GenericEditorOpener(IEcoreModelQuery<P, R> ecoreModelQuery, IModelQuery<M, E, R> modelQuery) {
        this.ecoreModelQuery = ecoreModelQuery;
        this.modelQuery = modelQuery;
    }

    /**
     * Opens an editor for displaying the declaration of an element to
     * the user.
     * 
     * If the declaration is in the same file than the selected element, no
     * new editor will be opened but the selection will change to the
     * declaration.
     * 
     * @param parseTreeElement
     *            the {@link ILeafNode} that represents the selection of the
     *            user for which he wants to see the declaration
     * @param parseTreeProject the project to open the editor for
     */
    public void open(ILeafNode parseTreeElement, P parseTreeProject) {
        if (parseTreeElement != null) {
            ModelManagement<M> modelMgt = modelQuery.getModelManagement();
            // We need the element of the model to get the information in
            // which project the element's declaration is located
            E modelElement = modelQuery.getModelElement(parseTreeElement.getText(),
                ecoreModelQuery.getName(parseTreeProject));
            // If the selected element is a project, e.g. in an import
            // statement, modelElement is null.
            if (modelElement == null) {
                /*
                 * In that case, use the text from parseTreeElement to check
                 * whether a project exists that has this name, then open it and
                 * mark project-entry (first line in the editor).
                 */
                CommonXtextEditor<T, P> editor = null;
                int projectCounter = 0;
                while (editor == null && projectCounter < modelMgt.getModelCount()) {
                    M project = modelMgt.getModel(projectCounter);
                    if (project.getName().equals(parseTreeElement.getText())) {
                        // Get the URI of the project for opening the file
                        // at that URI in a (new) editor.
                        URI projectUri = getProjectUri(project);
                        // Get the editor by opening the project (the
                        // file) in a (new) instance of such an editor
                        editor = openEditor(projectUri);
                        // Get the offset and end of the first line of the
                        // editor's document (project declaration)
                        try {
                            int projectOffset = editor.getDocument().getLineOffset(0);
                            int projectEnd = projectOffset + editor.getDocument().getLineLength(0);
                            setCursor(editor, projectOffset, projectEnd);
                        } catch (BadLocationException e) {
                            getLogger().error("Opening editor: " + e.getMessage());
                        }
                    }
                    projectCounter++;
                }
            } else {
                // If the selected element is a project element, we need the
                // parent project the varModelElement is declared in.
                M parentProject = modelQuery.getParentProject(modelElement);
                // Get the URI of the parent project for opening the file
                // at that URI in a (new) editor.
                URI parentProjectUri = getProjectUri(parentProject);
                // Get the editor by opening the parent project (the
                // file) in a (new) instance of such an editor
                CommonXtextEditor<T, P> editor = openEditor(parentProjectUri);
                // Get the type of the varModelElement in order to unambiguously
                // identify its declaration in the newly opened editor
                R declaration = modelQuery.findDeclaration(parentProject, modelElement);

                /*
                 * If the type if the varModelElement is "project", we do not
                 * need to search the Ecore-model for that element and set the
                 * cursor to that elemen's declaration as the editor with
                 * that project is already open.
                 */
                if (declaration != null) {
                    // Else, get the EObject that represents the element's
                    // declaration
                    EObject elementDeclaration = ecoreModelQuery.getEcoreElement(editor, declaration);
                    // Finally, set the cursor to the element's declaration in
                    // the file
                    setCursor(editor, elementDeclaration);
                }
            }
        }
    }
    

    /**
     * Returns the {@link URI} of the given
     * {@link net.ssehub.easy.varModel.model.Project}.
     * 
     * @param project
     *            the {@link net.ssehub.easy.varModel.model.Project} for which
     *            the {@link URI} should be returned
     * @return the {@link URI} of the given project. May return
     *         <code>null</code> if the given project is <code>null</code> or
     *         the project URI could not be resolved.
     */
    private java.net.URI getProjectUri(M project) {
        java.net.URI varModelProjectUri = null;
        if (project != null) {
            ModelManagement<M> modelMgt = modelQuery.getModelManagement();
            AvailableModels<M> availableModel = modelMgt.availableModels();
            if (availableModel != null) {
                ModelInfo<M> projectInfo = availableModel.getModelInfo(project);
                if (projectInfo != null) {
                    varModelProjectUri = projectInfo.getLocation();
                }
            }
        }
        return varModelProjectUri;
    }

    /**
     * Opens an {@link XtextEditor} for the language for the resource
     * identified by the given {@link URI}.
     * 
     * If the resource is already opened in such an editor, this editor will be
     * activated only.
     * 
     * @param uri
     *            the {@link URI} that identifies the resource (a file)
     *            that should be opened in an editor
     * @return the {@link XtextEditor} for the language that displays the
     *         given resource. May be <code>null</code> if the {@link URI} does
     *         not identify an existing file in the workspace or the editor
     *         cannot be opened
     */
    private CommonXtextEditor<T, P> openEditor(java.net.URI uri) {
        CommonXtextEditor<T, P> editor = null;
        if (uri != null) {
            IFile[] allWorkspaceFiles = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(uri);
            if (allWorkspaceFiles.length > 0) {
                // As the given URI points to a single file there must only
                // be one file in the array
                IFile projectFile = allWorkspaceFiles[0];

                /*
                 * Open an editor with the given file. If an editor with
                 * this file is already open, it will be activated.
                 */
                if (projectFile != null) {
                    // Get the default editor for based on extension.
                    IWorkbench workbench = PlatformUI.getWorkbench();
                    IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
                    IWorkbenchPage activeWorkbenchWindowPage = activeWorkbenchWindow.getActivePage();
                    IEditorDescriptor editorDescr = workbench.getEditorRegistry()
                                    .getDefaultEditor(projectFile.getName());
                    editor = open(editorDescr, activeWorkbenchWindowPage, projectFile);
                }
            }
        }
        return editor;
    }

    /**
     * Finally opens the editor.
     * 
     * @param editorDescr the editor descriptor (may be <b>null</b>)
     * @param activeWorkbenchWindowPage the active workbench window page
     * @param projectFile the project file
     * @return the editor (may be <b>null</b>)
     */
    @SuppressWarnings("unchecked")
    private CommonXtextEditor<T, P> open(IEditorDescriptor editorDescr, IWorkbenchPage activeWorkbenchWindowPage, 
        IFile projectFile) {
        CommonXtextEditor<T, P> result = null;
        if (editorDescr != null) {
            IEditorPart editorPart = null;
            IEditorReference[] refs = activeWorkbenchWindowPage.getEditorReferences();
            for (int r = 0; null == editorPart && r < refs.length; r++) {
                if (refs[r].getId().equals(editorDescr.getId())) {
                    try {
                        IEditorInput input = refs[r].getEditorInput();
                        if (input instanceof FileEditorInput) {
                            if (((FileEditorInput) input).getFile().equals(projectFile)) {
                                editorPart = refs[r].getEditor(true);
                            }
                        }
                    } catch (PartInitException e) {
                        getLogger().error("Finding editor: " + e.getMessage());
                    }
                    if (null != editorPart) {
                        activeWorkbenchWindowPage.bringToTop(editorPart);
                    }
                }
            }
            if (null == editorPart) {
                try {
                    // Try opening the file in the editor.
                    editorPart = activeWorkbenchWindowPage
                        .openEditor(new FileEditorInput(projectFile), editorDescr.getId());
                } catch (PartInitException e) {
                    getLogger().error("Opening editor: " + e.getMessage());
                }
            }
            if (editorPart instanceof CommonXtextEditor) {
                result = (CommonXtextEditor<T, P>) editorPart;
            }
        }
        return result;
    }

    /**
     * Sets the cursor in the given editor to the location of the given object
     * and highlights this object (the textual representation in the file).
     * 
     * @param editor
     *            the editor in which the the cursor should be set
     * @param targetObject
     *            the {@link EObject} that represent the element in the file of
     *            the editor to which the cursor should be set
     */
    private void setCursor(CommonXtextEditor<T, P> editor, EObject targetObject) {
        if (targetObject != null) {
            ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(targetObject);
            if (actualNode != null) {
                int targetOffset = actualNode.getOffset();
                int targetEnd = targetOffset + actualNode.getLength();
                setCursor(editor, targetOffset, targetEnd);
            }
        }
    }

    /**
     * Sets the cursor in the given editor to the given target offset and
     * selects the full text from that offset to the given target end.
     * 
     * @param editor
     *            the editor in which the the cursor should be set
     * @param targetOffset
     *            the offset in the editor's file to which the cursor should be
     *            set and from which the text selection should start
     * @param targetEnd
     *            the index at which the text selection should end (this value
     *            must be greater than <i>targetOffset</i>
     */
    private void setCursor(CommonXtextEditor<T, P> editor, int targetOffset, int targetEnd) {
        if (editor != null) {
            IXtextDocument editorDoc = editor.getDocument();
            if (editorDoc != null && targetOffset >= 0 && targetEnd > targetOffset) {
                ISelection selection = new TextSelection(editorDoc, targetOffset, targetEnd - targetOffset);
                ISelectionProvider selectionProvider = editor.getSelectionProvider();
                if (selectionProvider != null) {
                    selectionProvider.setSelection(selection);
                }
            }
        }
    }
    
    /**
     * Returns the logger.
     * 
     * @return the logger
     */
    private EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(GenericEditorOpener.class, BundleId.ID);
    }
    
}
