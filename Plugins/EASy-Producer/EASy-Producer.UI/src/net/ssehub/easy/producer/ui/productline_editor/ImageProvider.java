package net.ssehub.easy.producer.ui.productline_editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * An image provider shielding the platform UI image source in case of RCP applications.
 * 
 * @author Holger Eichelberger
 *
 */
public class ImageProvider {
    
    private static ImageProvider instance;
    private Map<ImageType, Image> map = new HashMap<ImageType, Image>();
    
    /**
     * Defines the supported image types.
     * 
     * @author Holger Eichelberger
     */
    public enum ImageType {
        ADD,
        DELETE;
    }

    /**
     * Creates an uninitialized image provider.
     */
    protected ImageProvider() {
    }
    
    /**
     * Creates an instance for a <code>sharedImages</code> object.
     * 
     * @param sharedImages the shared images object to instantiated from
     */
    protected ImageProvider(ISharedImages sharedImages) {
        setImage(ImageType.ADD, sharedImages.getImage(ISharedImages.IMG_OBJ_ADD));
        setImage(ImageType.DELETE, sharedImages.getImage(ISharedImages.IMG_TOOL_DELETE));
    }

    /**
     * Returns the image provider with lazy instantiation of this {@link ImageProvider}
     * in case no other was specified before.
     * 
     * @return the image provider
     */
    public static ImageProvider getInstance() {
        if (null == instance) {
            instance = new ImageProvider(PlatformUI.getWorkbench().getSharedImages());
        }
        return instance;
    }
    
    /**
     * Returns the specified image.
     * 
     * @param type the image type to return
     * @return the image
     */
    public Image getImage(ImageType type) {
        return map.get(type);
    }
    
    /**
     * Defines the recent image provider.
     * 
     * @param iProvider the new image provider
     */
    public static void setInstance(ImageProvider iProvider) {
        instance = iProvider;
    }
    
    /**
     * Defines a specific image.
     * 
     * @param type the type
     * @param image the associated image
     */
    protected void setImage(ImageType type, Image image) {
        map.put(type, image);
    }

}
