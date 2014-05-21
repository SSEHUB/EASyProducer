package de.uni_hildesheim.sse.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;


/**
 * That class is for creating a virtual node.
 * @author Dernek
 *
 */
public class VirtualOutlineNode extends AbstractOutlineNode {

    /**
     * The constructor of a virtual outline node.
     * 
     * @param parent The parent-node of this node.
     * @param image The image of this node displayed in the outline view.
     * @param text The text of this node diyplayed in the outline view.
     * @param isLeaf <b>True</b> if this node is a leaf. <b>False</b> otherwise.
     */
    protected VirtualOutlineNode(IOutlineNode parent, Image image, Object text, boolean isLeaf) {
        super(parent, image, text, isLeaf);
    }
}
