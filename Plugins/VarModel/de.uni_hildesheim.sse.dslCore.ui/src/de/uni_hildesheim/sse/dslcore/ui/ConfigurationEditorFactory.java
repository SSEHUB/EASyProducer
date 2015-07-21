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
package de.uni_hildesheim.sse.dslcore.ui;

import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.Configuration;

/**
 * Implements a factory for creating EASy configuration editors. This is needed to decouple
 * optional DSL editors from the EASy UI.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationEditorFactory {
    
    private static IConfigurationEditorCreator creator = null;

    // actually, hiding the resulting editor behind an interface would be better... when there is time somewhen
    
    /**
     * Defines the instance of an editor creator.
     * 
     * @author Holger Eichelberger
     */
    public interface IConfigurationEditorCreator {

        /**
         * Creates a configuration editor.
         * 
         * @param config the configuration to be shown in the editor
         * @param parent the UI parent
         * @return the editor
         */
        public TreeViewer createEditor(Configuration config, Composite parent);
        
        /**
         * Creates a name filter.
         * 
         * @param nameRegEx a regular expression for including names
         * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
         * @return the name filter
         * @throws PatternSyntaxException in case of erroneous pattern syntax
         */
        public ViewerFilter createNameFilter(String nameRegEx, boolean showAllNestedElements) 
            throws PatternSyntaxException;

        /**
         * Creates a simple attribute filter.
         * 
         * @param attributeNameRegEx the name of the attribute as regular expression
         * @param valueRegEx a regular expression to be applied on the text representation of values
         * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
         * @return the name filter
         * @throws PatternSyntaxException in case of erroneous pattern syntax
         */
        public ViewerFilter createAttributeFilter(String attributeNameRegEx, String valueRegEx, 
            boolean showAllNestedElements) throws PatternSyntaxException;
        
        /**
         * Creates a filter that shows only non-frozen elements.
         * 
         * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
         * @return the non-frozen filter
         */
        public ViewerFilter createNonFrozenFilter(boolean showAllNestedElements);
        
    }

    /**
     * Defines the editor creator.
     * 
     * @param cfgCreator the creator instance
     */
    public static void setCreator(IConfigurationEditorCreator cfgCreator) {
        creator = cfgCreator;
    }
    
    /**
     * Creates a configuration editor.
     * 
     * @param config the configuration to be shown in the editor
     * @param parent the UI parent
     * @return the editor, <b>null</b> if none can be created, e.g., creator missing
     */
    public static TreeViewer createEditor(Configuration config, Composite parent) {
        TreeViewer result = null;
        if (null != creator) {
            result = creator.createEditor(config, parent);
        }
        return result;
    }
    
    /**
     * Creates a name filter.
     * 
     * @param nameRegEx a regular expression for including names
     * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
     * @return the name filter
     * @throws PatternSyntaxException in case of an erroneous pattern syntax
     */
    public static ViewerFilter createNameFilter(String nameRegEx, boolean showAllNestedElements) 
        throws PatternSyntaxException {
        ViewerFilter result = null;
        if (null != creator) {
            result = creator.createNameFilter(nameRegEx, showAllNestedElements);
        }
        return result;
    }

    /**
     * Creates a simple attribute filter.
     * 
     * @param attributeNameRegEx the name of the attribute as regular expression
     * @param valueRegEx a regular expression to be applied on the text representation of values
     * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
     * @return the name filter
     * @throws PatternSyntaxException in case of an erroneous pattern syntax
     */
    public static ViewerFilter createAttributeFilter(String attributeNameRegEx, String valueRegEx, 
        boolean showAllNestedElements) throws PatternSyntaxException {
        ViewerFilter result = null;
        if (null != creator) {
            result = creator.createAttributeFilter(attributeNameRegEx, valueRegEx, showAllNestedElements);
        }
        return result;
    }

    /**
     * Creates a filter for non-frozen variables.
     * 
     * @param showAllNestedElements if all nested elements or only the selected ones shall be displayed
     * @return the name filter
     */
    public static ViewerFilter createNonFrozenFilter(boolean showAllNestedElements) {
        ViewerFilter result = null;
        if (null != creator) {
            result = creator.createNonFrozenFilter(showAllNestedElements);
        }
        return result;
    }

}
