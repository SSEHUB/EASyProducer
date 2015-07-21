package de.uni_hildesheim.sse.vil.templatelang.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

import de.uni_hildesheim.sse.dslcore.ui.wizards.AbstractFiletypeWizardPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (vtl).
 * @author El-Sharkawy
 */
public class VTLFiletypeWizardPage extends AbstractFiletypeWizardPage {
 
    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param selection The current object selection, as specified at 
     * {@link org.eclipse.ui.IWorkbenchWizard
     * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)}.
     */
    public VTLFiletypeWizardPage(ISelection selection) {
        super(selection, new VTLWizardPageDescriptor());
    }
    
}