package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.io.File;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Lable provider for the file tree of an instantiator. Shows the name of the file object and an image based of it's
 * type (folder or file).
 * 
 * @author gawenda
 */
class InstantiatorTreeLabelProvider extends LabelProvider {

    private static final Image FOLDER = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_OBJ_FOLDER);
    private static final Image FILE = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

    @Override
    public String getText(Object element) {
        // Get the name of the file
        String text = ((File) element).getName();

        // If name is blank, get the path
        if (text.length() == 0) {
            text = ((File) element).getPath();
        }
        return text;
    }

    @Override
    public Image getImage(Object element) {
        Image result = FILE;
        if (!((File) element).isFile()) {
            result = FOLDER;
        }
        return result;
    }

}
