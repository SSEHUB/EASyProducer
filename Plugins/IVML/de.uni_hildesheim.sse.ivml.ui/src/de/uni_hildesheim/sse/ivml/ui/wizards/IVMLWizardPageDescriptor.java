/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.ivml.ui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;

import de.uni_hildesheim.sse.ui.Activator;
import net.ssehub.easy.dslCore.ui.wizards.IWizardPageDescriptor;

/**
 * Specification of the {@link IVMLFiletypeWizardPage}.
 * @author El-Sharkawy
 *
 */
public class IVMLWizardPageDescriptor implements IWizardPageDescriptor {

    @Override
    public String getFileExtension() {
        return "ivml";
    }

    @Override
    public String getTitle() {
        return "New IVML File";
    }

    @Override
    public String getDescription() {
        return "This wizard creates a new IVML file with *.ivml extension that can be opened by the IVML editor.";
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return Activator.getImageDescriptor("icons/file_wizard_logo.gif");
    }

    @Override
    public String getDefaultFileName() {
        return "new_model.ivml";
    }

}
