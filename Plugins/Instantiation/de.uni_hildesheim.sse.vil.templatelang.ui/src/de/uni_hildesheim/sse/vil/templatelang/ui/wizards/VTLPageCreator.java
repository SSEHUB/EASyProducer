package de.uni_hildesheim.sse.vil.templatelang.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizardPage;
import net.ssehub.easy.dslCore.ui.wizards.IWizardPageFactory;

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
