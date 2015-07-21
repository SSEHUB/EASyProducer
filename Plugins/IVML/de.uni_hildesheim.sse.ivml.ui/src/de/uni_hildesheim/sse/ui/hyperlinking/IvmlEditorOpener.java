package de.uni_hildesheim.sse.ui.hyperlinking;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.ModelElementTypeFinder;
import de.uni_hildesheim.sse.model.varModel.filter.ModelElementTypeFinder.ModelElementDescription;
import de.uni_hildesheim.sse.ui.XtextEditor;
import de.uni_hildesheim.sse.utils.modelManagement.AvailableModels;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * This class provides a single method for opening an IVML-editor and selecting a specific element
 * of the opened IVML-file in that editor based on a given {@link ILeafNode} that represents
 * the IVML-element for which the declaration should be displayed.
 * 
 * This is used to enable the "F3"-functionality.
 * 
 * @author kroeher
 *
 */
public class IvmlEditorOpener {
	
	/**
	 * The instance of this class that provides the method for opening individual IVML-editors
	 * based on a given {@link ILeadNode}.
	 */
	public static final IvmlEditorOpener INSTANCE = new IvmlEditorOpener();
	
	/**
	 * Constructs the singleton instance.
	 */
	private IvmlEditorOpener() {}
	
	/**
	 * Opens an IVML-editor for displaying the declaration of an IVML-element to the user.
	 * 
	 * If the declaration is in the same IVML-file than the selected element, no new IVML-editor
	 * will be opened but the selection will change to the declaration.
	 * 
	 * @param parseTreeElement the {@link ILeadNode} that represents the selection of the user
	 * for which he wants to see the declaration
	 */
	public void open(ILeafNode parseTreeElement, Project parseTreeProject) {
		if (parseTreeElement != null) {
			// We need the element of the VarModel to get the information in which project the element's declaration is located
			ContainableModelElement varModelElement = getVarModelElement(parseTreeElement.getText(), parseTreeProject.getName());
			
			// If the selected element is a project, e.g. in an import statement, varModelElement is null.
			if (varModelElement == null) {
				/*
				 * In that case, use the text from parseTreeElement to check whether a project exists that has this name,
				 * then open it and mark project-entry (first line in the editor).
				 */
				XtextEditor ivmlEditor = null;
				int projectCounter = 0;
				while (ivmlEditor == null && projectCounter < VarModel.INSTANCE.getModelCount()) {
					de.uni_hildesheim.sse.model.varModel.Project project = VarModel.INSTANCE.getModel(projectCounter);
					if (project.getName().equals(parseTreeElement.getText())) {
						// Get the URI of the project for opening the IVML-file at that URI in a (new) editor.
						URI projectUri = getProjectUri(project);
						// Get the IVML-editor by opening the project (the IVML-file) in a (new) instance of such an editor
						ivmlEditor = openIvmlEditor(projectUri);
						// Get the offset and end of the first line of the editor's document (project declaration)
						try {
							int projectOffset = ivmlEditor.getDocument().getLineOffset(0);
							int projectEnd = projectOffset + ivmlEditor.getDocument().getLineLength(0);
							setCursor(ivmlEditor, projectOffset, projectEnd);
						} catch (BadLocationException e) {
							// TODO use the logger?
						}
					}
					projectCounter++;
				}
			} else {
				// If the selected element is a project element, we need the parent project the varModelElement is declared in.
				de.uni_hildesheim.sse.model.varModel.Project parentProject = getParentProject(varModelElement);
				// Get the URI of the parent project for opening the IVML-file at that URI in a (new) editor.
				URI parentProjectUri = getProjectUri(parentProject);
				// Get the IVML-editor by opening the parent project (the IVML-file) in a (new) instance of such an editor
				XtextEditor ivmlEditor = openIvmlEditor(parentProjectUri);
				
				// Get the type of the varModelElement in order to unambiguously identify its declaration in the newly opened editor
				ModelElementTypeFinder typeFinder = new ModelElementTypeFinder(parentProject, FilterType.ALL);
				ModelElementDescription varModelElementTypeDescription = typeFinder.getDatatypeByElementName(varModelElement.getName());
				
				/*
				 * If the type if the varModelElement is "project", we do not need to search the Ecore-model for that
				 * element and set the cursor to that elemen's declaration as the ivmlEditor with that project is already open.
				 */
				if (varModelElementTypeDescription != null) {					
					// Else, get the EObject that represents the element's declaration
					EObject elementDeclaration = EcoreModelQuery.INSTANCE.getEcoreElement(ivmlEditor, varModelElementTypeDescription);
					// Finally, set the cursor to the element's declaration in the IVML-file
					setCursor(ivmlEditor, elementDeclaration);
				}
			}
		}
	}
	
	/**
	 * Returns the element of the {@link VarModel} identified by the selected element (the name) and the scope
	 * which is the name of the project the selected element is located in.
	 * 
	 * @param selectedElement the name of the selected element as a {@link String} for which the element in the
	 * {@link VarModel} should be found. 
	 * @param selectedElementsProjectName the name of the project of the selected element as a {@link String} which
	 * is used as the starting point for finding the corresponding element in the {@link VarModel} 
	 * @return a {@link ContainableModelElement} which is the element in the {@link VarModel} identified by the given
	 * namen of the selected element. May return <code>null</code> if the element could not be found.
	 */
	private ContainableModelElement getVarModelElement(String selectedElement, String selectedElementsProjectName) {
    	// Find the corresponding VarModel element for the selected element
		ContainableModelElement modelElement = null;
		if (selectedElement != null && !selectedElement.isEmpty()
				&& selectedElementsProjectName != null && !selectedElementsProjectName.isEmpty()) {			
			int modelCount = VarModel.INSTANCE.getModelCount();
			int modelCounter = 0;
			while (modelElement == null && modelCounter < modelCount) {
				if (VarModel.INSTANCE.getModel(modelCounter).getName().equals(selectedElementsProjectName)) {
					try {
						modelElement = ModelQuery.findElementByName(VarModel.INSTANCE.getModel(modelCounter), selectedElement, null);
					} catch (ModelQueryException e) {
						// TODO use the logger?
					}
				}
				modelCounter++;
			}
		}
    	return modelElement;
	}
	
	/**
	 * Returns the parent {@link de.uni_hildesheim.sse.model.varModel.Project} the given {@link ContainableModelElement}
	 * is declared in.
	 * 
	 * @param modelElement the {@link ContainableModelElement} for which the parent project should be found
	 * @return the parent {@link de.uni_hildesheim.sse.model.varModel.Project} the given {@link ContainableModelElement}
	 * is declared in. May return <code>null</null> if the given model element is <code>null</null>, if the model element
	 * has no top-level parent (which typically is  the {@link de.uni_hildesheim.sse.model.varModel.Project}), or the
	 * top-level parent is not an instance of {@link de.uni_hildesheim.sse.model.varModel.Project}.
	 */
	private de.uni_hildesheim.sse.model.varModel.Project getParentProject(ContainableModelElement modelElement) {
		de.uni_hildesheim.sse.model.varModel.Project parentProject = null;
		if (modelElement != null
				&& modelElement.getTopLevelParent() != null
				&& modelElement.getTopLevelParent() instanceof de.uni_hildesheim.sse.model.varModel.Project) {
			parentProject =	(de.uni_hildesheim.sse.model.varModel.Project) modelElement.getTopLevelParent();
		}
		return parentProject;
	}
	
	/**
	 * Returns the {@link URI} of the given {@link de.uni_hildesheim.sse.model.varModel.Project}.
	 * 
	 * @param project the {@link de.uni_hildesheim.sse.model.varModel.Project} for which the {@link URI} should be returned
	 * @return the {@link URI} of the given project. May return <code>null</code> if the given project is <code>null</code>
	 * or the project URI could not be resolved.
	 */
	private java.net.URI getProjectUri (de.uni_hildesheim.sse.model.varModel.Project project) {
		java.net.URI varModelProjectUri = null;
		if (project != null) {
    		AvailableModels<de.uni_hildesheim.sse.model.varModel.Project> availableModel = VarModel.INSTANCE.availableModels();
    		if (availableModel != null) {
    			ModelInfo<de.uni_hildesheim.sse.model.varModel.Project> projectInfo = availableModel.getModelInfo(project);
    			if (projectInfo != null) {
    				varModelProjectUri = projectInfo.getLocation();
    			}
    		}
		}
		return varModelProjectUri;
	}

	/**
	 * Opens an {@link XtextEditor} for the IVML-language for the resource identified by the given {@link URI}.
	 * 
	 * If the resource is already opened in such an editor, this editor will be activated only.
	 * 
	 * @param uri the {@link URI} that identifies the resource (an IVML-file) that should be opened in an IVML-editor
	 * @return the {@link XtextEditor} for the IVML-language that displays the given resource. May be <code>null</code>
	 * if the {@link URI} does not identify an existing IVML-file in the workspace or the editor cannot be opened
	 */
	private XtextEditor openIvmlEditor(java.net.URI uri) {
		XtextEditor ivmlEditor = null;
    	
        if (uri != null) {
            IFile[] allWorkspaceFiles = ResourcesPlugin.getWorkspace().getRoot()
                .findFilesForLocationURI(uri);
            if (allWorkspaceFiles.length > 0) {            	
            	// As the given URI points to a single IVML-file there must only be one file in the array
            	IFile ivmlProjectFile = allWorkspaceFiles[0];
            	
            	/*
            	 * Open an IVML editor with the given file.
            	 * If an editor with this file is already open, it will be activated.
            	 */
            	if (ivmlProjectFile != null) {
            		// Get the default editor for IVML based on extension.
            		IWorkbench workbench = PlatformUI.getWorkbench();
            		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            		IWorkbenchPage activeWorkbenchWindowPage = activeWorkbenchWindow.getActivePage();
            		IEditorDescriptor editorDescr = workbench.getEditorRegistry().getDefaultEditor(ivmlProjectFile.getName());
            		
            		if (editorDescr != null) {
            			// Try opening the file in the editor.
            			try {
            				IEditorPart openedEditorPart = activeWorkbenchWindowPage.openEditor(new FileEditorInput(ivmlProjectFile), editorDescr.getId());
            				if (openedEditorPart instanceof XtextEditor) {
            					ivmlEditor = (XtextEditor) openedEditorPart;
            				}
            			} catch (PartInitException e) {
            				// TODO use the logger?
            			}
            		}
            	}
            }
        }
        
        return ivmlEditor;
    }

	/**
	 * Sets the cursor in the given editor to the location of the given object and highlights this object (the
	 * textual representation in the file).
	 * 
	 * @param ivmlEditor the {@link XtextEditor} in which the the cursor should be set
	 * @param targetObject the {@link EObject} that represent the element in the file of the editor to which
	 * the cursor should be set
	 */
    private void setCursor(XtextEditor ivmlEditor, EObject targetObject) {
    	if (targetObject != null) {
    		ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(targetObject);
    		if (actualNode != null) {    			
    			int targetOffset = actualNode.getOffset();
    			int targetEnd = targetOffset + actualNode.getLength();
    			setCursor(ivmlEditor, targetOffset, targetEnd);
    		}
    	}
    }
    
	/**
	 * Sets the cursor in the given editor to the given target offset and selects the full text from that offset
	 * to the given target end.
	 * 
	 * @param ivmlEditor the {@link XtextEditor} in which the the cursor should be set
	 * @param targetOffset the offset in the editor's file to which the cursor sould be set and from which
	 * the text selection should start
	 * @param targetEnd the index at which the text selection should end (this value must be greater than <i>targetOffset</i>
	 */
    private void setCursor(XtextEditor ivmlEditor, int targetOffset, int targetEnd) {
    	if (ivmlEditor != null) {
    		IXtextDocument editorDoc = ivmlEditor.getDocument();
    		if (editorDoc != null && targetOffset >= 0 && targetEnd > targetOffset) {
    			ISelection selection = new TextSelection(editorDoc,
    					targetOffset, targetEnd - targetOffset);
    			ISelectionProvider selectionProvider = ivmlEditor.getSelectionProvider();
    			if (selectionProvider != null) {
    				selectionProvider.setSelection(selection);
    			}
    		}
		}
    }
}
