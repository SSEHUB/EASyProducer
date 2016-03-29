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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.ssehub.easy.dslCore.ui.Activator;
import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizard;

/**
 * This is a new file wizard for ivml files. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "ivml". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 * 
 * @author El-Sharkawy
 */

public class CommentsFiletypeWizard extends AbstractFiletypeWizard {

    /**
     * Sole Constructor for {@link CommentsFiletypeWizard}.
     */
    public CommentsFiletypeWizard() {
        super(new CommentsPageCreator(), Activator.PLUGIN_ID);
    }

    @Override
    protected InputStream openContentStream(String fileName) {
        String contents = "";
        return new ByteArrayInputStream(contents.getBytes());
    }
}