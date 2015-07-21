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
package de.uni_hildesheim.sse.vil.rt.ui.embed;

import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Implements a combination of name and filter for display.
 * 
 * @author Holger Eichelberger
 */
public class NamedViewerFilter {

    private ViewerFilter filter;
    private String name;
    
    /**
     * Creates a named viewer filter.
     * 
     * @param name the name of the filter
     * @param filter the filter
     */
    public NamedViewerFilter(String name, ViewerFilter filter) {
        this.name = name;
        this.filter = filter;
    }
    
    /**
     * Returns the filter.
     * 
     * @return the filter
     */
    public ViewerFilter getFilter() {
        return filter;
    }
    
    /**
     * Returns the name of the filter.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Turns an array of named viewer filters into viewer filters.
     * 
     * @param filters the filters as input
     * @return the viewer filters as output (<b>null</b> if <code>filters</code> is <b>null</b>)
     */
    public static ViewerFilter[] toFilter(NamedViewerFilter[] filters) {
        ViewerFilter[] result;
        if (null == filters) {
            result = null;
        } else {
            result = new ViewerFilter[filters.length];
            for (int f = 0; f < filters.length; f++) {
                result[f] = filters[f].getFilter();
            }
        }
        return result;
    }
    
    /**
     * Turns the names of the filters into a comma separated list.
     * 
     * @param filters the filters to be turned into a string
     * @return the string representation
     */
    public static String toString(NamedViewerFilter[] filters) {
        String result = "";
        if (filters != null) {
            for (int i = 0; i < filters.length; i++) {
                if (i > 0) {
                    result += ", ";
                }
                result += filters[i].getName();
            }
        }
        return result;
    }
    
}
