package de.uni_hildesheim.sse.easy.ui.reasoner;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;

/**
 * Central class for images used in the reasoner core UI.
 * 
 * @author Holger Eichelberger
 */
public class Images {

    public static final String NAME_READY = "reasoner/ready.gif";
    public static final String NAME_READY_DEFAULT = "reasoner/readyAsDefault.gif";
    public static final String NAME_NOT_READY = "reasoner/notReady.gif";
    public static final String NAME_NOT_READY_DEFAULT = "reasoner/notReadyAsDefault.gif";
    public static final String NAME_UNKNOWN = "reasoner/unknown.gif";

    /**
     * Returns the image for the specified name.
     * 
     * @param name the name of the image (one of the constants specified in this class)
     * 
     * @return the related image
     */
    public static Image getImage(String name) {
        Activator activator = Activator.getDefault();
        String relativeUrl = "icons/" + name;
        Image image = activator.getImageRegistry().get(relativeUrl);
        if (null == image) {
            URL imageURL = activator.getBundle().getEntry(relativeUrl);
            ImageDescriptor descriptor = ImageDescriptor.createFromURL(imageURL);
            image = descriptor.createImage();
            activator.getImageRegistry().put(relativeUrl, image);
        }
        return image;
    }
    
}
