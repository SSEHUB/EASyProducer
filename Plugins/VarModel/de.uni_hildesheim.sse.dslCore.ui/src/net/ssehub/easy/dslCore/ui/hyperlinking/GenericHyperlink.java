package net.ssehub.easy.dslCore.ui.hyperlinking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;

/**
 * This class realizes a custom hyperlink that is created for any IVML-element
 * in an IVML-file if the user selects such an element either via pressing the
 * "F3"-key or by clicking on that element while pressing the "CTRL"-key.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * @author kroeher
 */
public class GenericHyperlink<P extends EObject> extends AbstractHyperlink {

    /**
     * Stores the element for which this hyperlink is created.
     */
    private ILeafNode hyperlinkLeafNode;

    /**
     * Stores the IVML-project in which the node of this hyperlink is located
     * in.
     */
    private P leafNodeProject;
    
    private IHyperlinkFactory<P> factory;

    /**
     * Creates an instance of this {@link GenericHyperlink} for the given
     * {@link ILeafNode} which enables the jump to the element's declaration the
     * node represents.
     * 
     * This is a user visible feature as this hyperlink is shown when the user
     * holds CTRL and points to an element in an IVML-editor.
     * 
     * @param parseTreeElement
     *            the {@link ILeafNode} of the parsed resource for which this
     *            hyperlink should be created
     * @param project
     *            the project the given node is located in
     * @param factory the creating factory
     */
    public GenericHyperlink(ILeafNode parseTreeElement, P project, IHyperlinkFactory<P> factory) {
        super();
        hyperlinkLeafNode = parseTreeElement;
        leafNodeProject = project;
        this.factory = factory;
    }

    /**
     * Opens an IVML-editor for showing the declaration of the IVML-element this
     * hyperlink was created for.
     */
    public void open() {
        factory.getEditorOpener().open(hyperlinkLeafNode, leafNodeProject);
    }
}
