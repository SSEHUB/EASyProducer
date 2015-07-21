package de.uni_hildesheim.sse.vil.templatelang.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

import de.uni_hildesheim.sse.dslcore.ui.wizards.AbstractFiletypeWizardPage;
import de.uni_hildesheim.sse.dslcore.ui.wizards.IWizardPageFactory;

/**
 * Creates the contents of the {@link VTLFiletypeWizard}.
 * @author El-Sharkawy
 *
 */
class VTLPageCreator implements IWizardPageFactory {

    @Override
    public AbstractFiletypeWizardPage createPage(ISelection selection) {
        return new VTLFiletypeWizardPage(selection);
    }

    @Override
    public String getFileExtension() {
        return ".vtl";
    }

}
