package de.uni_hildesheim.sse.vil.templatelang.ui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;

import de.uni_hildesheim.sse.vil.wizards.IWizardPageDescriptor;

/**
 * Specification of the {@link VTLFiletypeWizardPage}.
 * @author El-Sharkawy
 *
 */
public class VTLWizardPageDescriptor implements IWizardPageDescriptor {

    @Override
    public String getFileExtension() {
        return "vtl";
    }

    @Override
    public String getTitle() {
        return "New Template File";
    }

    @Override
    public String getDescription() {
        return "This wizard creates a new template file with *.vtl extension "
            + "that can be opened by the VTL editor.";
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getDefaultFileName() {
        return "new_template.vtl";
    }

}
