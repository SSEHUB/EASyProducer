package de.uni_hildesheim.sse.vil.rt.ui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;

import net.ssehub.easy.dslCore.ui.wizards.IWizardPageDescriptor;

/**
 * Specification of the {@link VILFiletypeWizardPage}.
 * @author El-Sharkawy
 *
 */
public class VILWizardPageDescriptor implements IWizardPageDescriptor {

    @Override
    public String getFileExtension() {
        return "rtvil";
    }

    @Override
    public String getTitle() {
        return "New Adaptation / Reconfiguration Script File";
    }

    @Override
    public String getDescription() {
        return "This wizard creates a new script file with *.rtvil extension "
            + "that can be opened by the rt-VIL editor.";
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getDefaultFileName() {
        return "new_adaptation_script.rtvil";
    }

}
