package de.uni_hildesheim.sse.vil.wizards;

import org.eclipse.jface.viewers.ISelection;

/**
 * Factory interface for individual wizard pages.
 * @author El-Sharkawy
 *
 */
public interface IWizardPageFactory {

    /**
     * Creates a new {@link AbstractFiletypeWizardPage}
     * @param selection The selection given by the {@link AbstractFiletypeWizard}.
     * @return A {@link AbstractFiletypeWizardPage} instance for the related {@link AbstractFiletypeWizard}.
     */
    public AbstractFiletypeWizardPage createPage(ISelection selection);
    
    /**
     * The file extension of files created by the {@link AbstractFiletypeWizard}.
     * @return The file extension of files to be created, including a leading dot.
     */
    public String getFileExtension();
}
