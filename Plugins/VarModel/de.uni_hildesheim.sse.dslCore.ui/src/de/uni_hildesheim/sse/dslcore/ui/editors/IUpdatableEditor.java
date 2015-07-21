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
package de.uni_hildesheim.sse.dslcore.ui.editors;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * An updatable editor.
 * 
 * @author Holger Eichelberger
 */
public interface IUpdatableEditor {

    /**
     * Updates this editor.
     */
    public void updateEditor();

    /**
     * Returns the resource of this editor.
     * 
     * @return the resource
     */
    IResource getResource();
    
    /**
     * Creates the model in the given xText document <code>doc</code>. This method synchronizes over <code>doc</code>
     * in order to avoid reentrant model validation.
     * 
     * @param doc the document to create the model for
     */
    public void buildModel(IXtextDocument doc);

}
