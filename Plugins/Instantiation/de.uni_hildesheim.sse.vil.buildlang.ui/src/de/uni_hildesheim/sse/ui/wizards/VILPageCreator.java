package de.uni_hildesheim.sse.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

import de.uni_hildesheim.sse.vil.wizards.AbstractFiletypeWizardPage;
import de.uni_hildesheim.sse.vil.wizards.IWizardPageFactory;

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
