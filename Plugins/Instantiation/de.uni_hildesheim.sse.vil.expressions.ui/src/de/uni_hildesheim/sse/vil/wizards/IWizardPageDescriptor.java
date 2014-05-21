package de.uni_hildesheim.sse.vil.wizards;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Specification of relevant information of a {@link AbstractFiletypeWizardPage} instance.
 * @author El-Sharkawy
 *
 */
public interface IWizardPageDescriptor {

    /**
     * The file extension to be created (needed for a consistency check).
     * @return The file extension without a leading dot.
     */
    public String getFileExtension();
    
    /**
     * The title of the {@link AbstractFiletypeWizardPage}.
     * @return A short title.
     */
    public String getTitle();
    
    /**
     * A description of the {@link AbstractFiletypeWizardPage}
     * @return A description.
     */
    public String getDescription();
    
    /**
     * An image for the {@link AbstractFiletypeWizardPage}
     * @return A loaded image or <tt>null</tt>.
     */
    public ImageDescriptor getImageDescriptor();
    
    /**
     * A default name as a suggestion for the user.
     * @return Something like "new_file.extension".
     */
    public String getDefaultFileName();
}
