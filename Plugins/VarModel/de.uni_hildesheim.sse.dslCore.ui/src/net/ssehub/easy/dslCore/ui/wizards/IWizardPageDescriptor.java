package net.ssehub.easy.dslCore.ui.wizards;

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
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Specification of relevant information of a {@link AbstractFiletypeWizardPage} instance.
 * @author El-Sharkawy
 *
 */
public interface IWizardPageDescriptor {

    /**
     * The file extension to be created (needed for a consistency check).
     * @return The file extension without a leading dot.
     */
    public String getFileExtension();
    
    /**
     * The title of the {@link AbstractFiletypeWizardPage}.
     * @return A short title.
     */
    public String getTitle();
    
    /**
     * A description of the {@link AbstractFiletypeWizardPage}.
     * @return A description.
     */
    public String getDescription();
    
    /**
     * An image for the {@link AbstractFiletypeWizardPage}.
     * @return A loaded image or <b>null</b>.
     */
    public ImageDescriptor getImageDescriptor();
    
    /**
     * A default name as a suggestion for the user.
     * @return Something like "new_file.extension".
     */
    public String getDefaultFileName();
}
