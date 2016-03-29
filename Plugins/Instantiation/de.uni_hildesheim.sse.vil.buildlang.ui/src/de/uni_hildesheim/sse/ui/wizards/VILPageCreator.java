package de.uni_hildesheim.sse.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizardPage;
import net.ssehub.easy.dslCore.ui.wizards.IWizardPageFactory;

/**
 * Creates the contents of the {@link VILFiletypeWizard}.
 * @author El-Sharkawy
 *
 */
public class VILPageCreator implements IWizardPageFactory {

    @Override
    public AbstractFiletypeWizardPage createPage(ISelection selection) {
        return new VILFiletypeWizardPage(selection);
    }

    @Override
    public String getFileExtension() {
        return ".vil";
    }

}
