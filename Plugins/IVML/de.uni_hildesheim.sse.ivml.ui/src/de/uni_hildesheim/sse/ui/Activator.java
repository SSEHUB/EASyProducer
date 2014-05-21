package de.uni_hildesheim.sse.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import de.uni_hildesheim.sse.ui.internal.IvmlActivator;

public class Activator extends IvmlActivator {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.uni_hildesheim.sse.ivml.ui"; //$NON-NLS-1$

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

}
