package de.uni_hildesheim.sse.ui.hyperlinking;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;

import de.uni_hildesheim.sse.ivml.Project;

/**
 * This class realizes a custom hyperlink that is created for any IVML-element in an IVML-file
 * if the user selects such an element either via pressing the "F3"-key or by clicking on that
 * element while pressing the "CTRL"-key.
 * 
 * @author kroeher
 *
 */
public class IvmlHyperlink extends AbstractHyperlink {
	
	/**
	 * Stores the element for which this hyperlink is created.
	 */
	private ILeafNode hyperlinkLeafNode;
	
	/**
	 * Stores the IVML-project in which the node of this hyperlink is located in.
	 */
	private Project leafNodeProject;
	
	/**
	 * Creates an instance of this {@link IvmlHyperlink} for the given {@link ILeafNode}
	 * which enables the jump to the element's declaration the node represents.
	 * 
	 * This is a user visible feature as this hyperlink is shown when the user holds CTRL and points
	 * to an element in an IVML-editor.
	 * 
	 * @param parseTreeElement the {@link ILeafNode} of the parsed resource for which this hyperlink
	 * should be created
	 * @param ivmlProject the {@link Project} the given node is located in
	 */
	public IvmlHyperlink(ILeafNode parseTreeElement, Project ivmlProject) {
		super();
		hyperlinkLeafNode = parseTreeElement;
		leafNodeProject = ivmlProject;
	}
	
	/**
	 * Opens an IVML-editor for showing the declaration of the IVML-element this hyperlink
	 * was created for. 
	 */
	public void open() {
		IvmlEditorOpener.INSTANCE.open(hyperlinkLeafNode, leafNodeProject);
	}
}
