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

import org.eclipse.jface.viewers.ISelection;

import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizardPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (comments).
 * @author El-Sharkawy
 */
public class CommentsFiletypeWizardPage extends AbstractFiletypeWizardPage {
 
    /**
     * Constructor for {@link CommentsFiletypeWizardPage}.
     * 
     * @param selection The current object selection, as specified at 
     * {@link org.eclipse.ui.IWorkbenchWizard
     * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)}.
     */
    public CommentsFiletypeWizardPage(ISelection selection) {
        super(selection, new CommentsWizardPageDescriptor());
    }
    
}