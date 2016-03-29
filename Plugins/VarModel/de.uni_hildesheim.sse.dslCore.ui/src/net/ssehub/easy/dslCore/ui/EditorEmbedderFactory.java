/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.ui;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;

/**
 * A factory for creating embedded editors. The purpose of this class is to decouple actual editor implementations
 * from the EASy-Producer UI, so that editors can be installed optionally.
 * 
 * @author Holger Eichelberger
 */
public class EditorEmbedderFactory {

    private static final Map<String, IEditorCreator> CREATORS = new HashMap<String, IEditorCreator>();

    /**
     * Creates a specific embedded editor.
     */
    public interface IEditorCreator {
        
        /**
         * Embeds an editor handling the given <code>resourceURI</code>.
         * 
         * @param resourceURI the URI to be handled
         * @param composite the parent composite to embed the editor into
         * @return the embedded editor (or <b>null</b> if embedding failed for some reason)
         */
        public IEmbeddedEditor embedEditor(URI resourceURI, Composite composite);
    }
    
    /**
     * Registers an editor creator.
     * 
     * @param extension the file extension to react on
     * @param creator the editor creator to register
     */
    public static void register(String extension, IEditorCreator creator) {
        if (null != extension) {
            CREATORS.put(extension, creator);
        }
    }
    
    /**
     * Unregisters an editor creator.
     * 
     * @param extension the file extension to unregister the creator for
     */
    public static void unregister(String extension) {
        CREATORS.remove(extension);
    }
    
    /**
     * Embeds an editor for the given resource URI into <code>composite</code>.
     * 
     * @param resourceURI the URI to be handled
     * @param composite the parent composite to embed the editor into
     * @return the embedded editor (or <b>null</b> if embedding failed for some reason)
     */
    public static IEmbeddedEditor embedEditor(URI resourceURI, Composite composite) {
        IEmbeddedEditor viewer = null;
        String tmp = resourceURI.toString();
        int pos = tmp.lastIndexOf('.');
        if (pos > 0 && pos < tmp.length() - 1) {
            String extension = tmp.substring(pos + 1);
            IEditorCreator creator = CREATORS.get(extension);
            if (null != creator) {
                viewer = creator.embedEditor(resourceURI, composite);
            }
        }
        return viewer;
    }
    
}
