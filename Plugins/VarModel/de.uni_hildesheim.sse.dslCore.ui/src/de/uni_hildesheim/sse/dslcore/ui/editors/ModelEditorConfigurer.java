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
package de.uni_hildesheim.sse.dslcore.ui.editors;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * Defines an interface and registration methods to describe how top-level models shall
 * be displayed in the EASy product line editor. This helps separating language editors
 * from the EASy UI. Please note that for the plain editor functionality, there is the 
 * {@link #EditorEmbedderFactory} which may also be used outside the EASY UI.
 * 
 * @author Holger Eichelberger
 */
public class ModelEditorConfigurer {
    
    public static final boolean EMBED_DEFAULT_EASY_EDITORS = Boolean.valueOf(
        System.getProperty("easy.ui.embeddedEditors", "false"));
    
    /**
     * The actual configurer interface.
     * 
     * @author Holger Eichelberger
     */
    public interface IModelEditorConfigurer {
        
        /**
         * Returns the editor title.
         * 
         * @param editable whether the editor is editable
         * @return the editor title
         */
        public String getEditorTitle(boolean editable);
        
        /**
         * Returns the page title.
         * 
         * @param editable whether the editor is editable
         * @return the page title
         */
        public String getPageTitle(boolean editable);
   
        /**
         * Returns the file extension to configure fore.
         * 
         * @return the file extension
         */
        public String getExtension();
        
        /**
         * Returns an ordinal for sorting model configurers for displying them.
         * 
         * @return the ordinal
         */
        public int getOrdinal();
        
        /**
         * Returns whether the described editor shall have a header.
         * 
         * @return <code>true</code> if it shall have a header, <code>false</code> else
         */
        public boolean hasHeader();
        
        /**
         * Creates the actual header.
         * 
         * @param parent the parent composite
         * @param configuration the recent product line configuration
         * @param base the basic directory of the project we are working in
         * @param info the actual model being displayed
         * @return the header instance
         */
        public IHeader createHeader(Composite parent, Configuration configuration, File base, ModelInfo<?> info);
        
        /**
         * Returns the model change listener, e.g., to rebuild the related model on save.
         * 
         * @return the model change listener or <b>null</b> for none
         */
        public AbstractModelChangeListener getModelChangeListener();
    }
    
    /**
     * Defines the interface for a header component created by a configurer.
     * 
     * @author Holger Eichelberger
     */
    public interface IHeader {

        /**
         * Called to revalidate the UI components.
         * 
         * @param hasErrors whether the actual (model) editor this header is attached to has errors
         */
        public void revalidateComponents(boolean hasErrors);
        
        /**
         * Closes the header component.
         */
        public void close();
        
    }

    /**
     * Implements a comparator to sort configurers according to the ordinal.
     * 
     * @author Holger Eichelberger
     */
    public static final Comparator<IModelEditorConfigurer> COMPARATOR = new Comparator<IModelEditorConfigurer>() {

        @Override
        public int compare(IModelEditorConfigurer o1, IModelEditorConfigurer o2) {
            return Integer.compare(o1.getOrdinal(), o2.getOrdinal());
        }
        
    };

    private static final List<IModelEditorConfigurer> CONFIGURERS = new ArrayList<IModelEditorConfigurer>();

    /**
     * Registers a configurer.
     * 
     * @param configurer the configurer to register
     */
    public static void register(IModelEditorConfigurer configurer) {
        if (null != configurer) {
            CONFIGURERS.add(configurer);
            Collections.sort(CONFIGURERS, COMPARATOR);
        }
    }
    
    /**
     * Unregisters a configurer.
     * 
     * @param configurer the configurer to unregister
     */
    public static void unregister(IModelEditorConfigurer configurer) {
        if (null != configurer) {
            CONFIGURERS.remove(configurer);
        }
    }
    
    /**
     * Allows iterating over the registered configurers.
     * 
     * @return an iterable on the configurers
     */
    public static Iterable<IModelEditorConfigurer> registered() {
        return CONFIGURERS;
    }
    
}
