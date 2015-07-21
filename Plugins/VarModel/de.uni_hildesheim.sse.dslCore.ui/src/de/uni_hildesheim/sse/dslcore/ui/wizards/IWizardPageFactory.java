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
package de.uni_hildesheim.sse.dslcore.ui.wizards;

import org.eclipse.jface.viewers.ISelection;

/**
 * Factory interface for individual wizard pages.
 * @author El-Sharkawy
 *
 */
public interface IWizardPageFactory {

    /**
     * Creates a new {@link AbstractFiletypeWizardPage}.
     * @param selection The selection given by the {@link AbstractFiletypeWizard}.
     * @return A {@link AbstractFiletypeWizardPage} instance for the related {@link AbstractFiletypeWizard}.
     */
    public AbstractFiletypeWizardPage createPage(ISelection selection);
    
    /**
     * The file extension of files created by the {@link AbstractFiletypeWizard}.
     * @return The file extension of files to be created, including a leading dot.
     */
    public String getFileExtension();
}
