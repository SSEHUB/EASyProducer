package de.uni_hildesheim.sse.ui.wizards;

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
        return "vil";
    }

    @Override
    public String getTitle() {
        return "New Build Script File";
    }

    @Override
    public String getDescription() {
        return "This wizard creates a new script file with *.vil extension "
            + "that can be opened by the VIL editor.";
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getDefaultFileName() {
        return "new_build_script.vil";
    }

}
