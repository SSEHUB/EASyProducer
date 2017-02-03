package net.ssehub.easy.dslCore.ui.hyperlinking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

/**
 * This class enables the creation of {@link GenericHyperlink}s for any
 * IVML-element in an IVML-file if the user selects such an element either via
 * pressing the "F3"-key or by clicking on that element while pressing the
 * "CTRL"-key.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * 
 * @author kroeher
 */
public class GenericHyperlinkHelper <P extends EObject> extends HyperlinkHelper {

    private IEcoreModelQuery<P, ?> modelQuery;
    private IHyperlinkFactory<P> hyperlinkFactory;
    
    /**
     * Creates an instance of this {@link GenericHyperlinkHelper}.
     * 
     * @param modelQuery the language-specific instance performing model queries
     * @param hyperlinkFactory a factory creating language-specific hyperlinks
     */
    public GenericHyperlinkHelper(IEcoreModelQuery<P, ?> modelQuery, IHyperlinkFactory<P> hyperlinkFactory) {
        this.modelQuery = modelQuery;
        this.hyperlinkFactory = hyperlinkFactory;
    }

    @Override
    public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
        ICompositeNode rootNode = modelQuery.getRootNode(resource);
        P correspondingIvmlProject = modelQuery.getProject(rootNode);
        if (rootNode != null) {
            ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
            if (leafNodeAtOffset != null) {

                /*
                 * Create an IvmlHyperlink for the element at the given offset.
                 * What happens when opening this hyperlink is handled by the
                 * IvmlHyperlink-class, see:
                 * 
                 * IvmlHyperlink.open()
                 */
                AbstractHyperlink hyperlink = hyperlinkFactory.createHyperlink(leafNodeAtOffset, 
                    correspondingIvmlProject);
                // Currently not used: hyperlink.setHyperlinkText("A hyperlink
                // text");
                hyperlink.setHyperlinkRegion(new Region(leafNodeAtOffset.getOffset(), leafNodeAtOffset.getLength()));

                acceptor.accept(hyperlink);
            }
        }
    }
}
