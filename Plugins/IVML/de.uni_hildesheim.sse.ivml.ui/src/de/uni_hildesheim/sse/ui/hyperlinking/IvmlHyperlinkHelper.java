package de.uni_hildesheim.sse.ui.hyperlinking;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

import de.uni_hildesheim.sse.ivml.Project;

/**
 * This class enables the creation of {@link IvmlHyperlink}s for any IVML-element in an IVML-file
 * if the user selects such an element either via pressing the "F3"-key or by clicking on that
 * element while pressing the "CTRL"-key.
 * 
 * @author kroeher
 *
 */
public class IvmlHyperlinkHelper extends HyperlinkHelper {
	
	/**
	 * Creates an instance of this {@link IvmlHyperlinkHelper}.
	 */
	public IvmlHyperlinkHelper() {}

	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		ICompositeNode rootNode = EcoreModelQuery.INSTANCE.getRootNode(resource);
		Project correspondingIvmlProject = EcoreModelQuery.INSTANCE.getProject(rootNode);
		if (rootNode != null) {
			ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
			if (leafNodeAtOffset != null) {
				
				/*
				 * Create an IvmlHyperlink for the element at the given offset.
				 * What happens when opening this hyperlink is handled by the IvmlHyperlink-class, see:
				 * 
				 * IvmlHyperlink.open()
				 */
				IvmlHyperlink hyperlink = new IvmlHyperlink(leafNodeAtOffset, correspondingIvmlProject);
				// Currently not used: hyperlink.setHyperlinkText("A hyperlink text");
				hyperlink.setHyperlinkRegion(new Region(leafNodeAtOffset.getOffset(), leafNodeAtOffset.getLength()));
				
				acceptor.accept(hyperlink);
			}
		}
	}
}
