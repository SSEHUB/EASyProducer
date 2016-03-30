package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Label provider for the instantiator tree.
 * 
 * @author gawenda
 * @author Holger Eichelberger
 */
class InstantiatorTreeLabelProvider extends LabelProvider {

    private static final Image DEFLT = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_UP);

    @Override
    public String getText(Object element) {
        String result;
        if (element instanceof TreeNode) {
            result = ((TreeNode) element).getText();
        } else {
            result = null == element ? "" : element.toString();
        }
        return result;
    }

    @Override
    public Image getImage(Object element) {
        Image result = DEFLT;
        if (element instanceof TreeNode) {
            result = ((TreeNode) element).getImage();
        }
        return result;
    }

}
