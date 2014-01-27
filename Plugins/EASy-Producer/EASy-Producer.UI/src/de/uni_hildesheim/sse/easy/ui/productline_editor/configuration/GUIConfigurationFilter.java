package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Container for applayable ViewerFilter.
 * @author El-Sharkawy
 *
 */
class GUIConfigurationFilter {
    
    private ViewerFilter[] filters;
    
    /**
     * Sole constructor of this class for creating an empty filter, which filter nothing.
     */
    public GUIConfigurationFilter() {
        filters = new ViewerFilter[4];
    }
    

    /**
     * Sets the attribute filter.
     * @param filter an {@link AttributeFilter} or <tt>null</tt> to delete an existing filter.
     */
    void setAttributeFilter(AbstractConfigurationFilter filter) {
        filters[0] = filter;
    }
    
    /**
     * Sets the name filter.
     * @param filter an {@link ConfigNameFilter} or <tt>null</tt> to delete an existing filter.
     */
    void setNameFilter(AbstractConfigurationFilter filter) {
        filters[1] = filter;
    }
    
    /**
     * Sets the namespace filter.
     * @param filter an {@link NamespaceFilter} or <tt>null</tt> to delete an existing filter.
     */
    void setNamespaceFilter(AbstractConfigurationFilter filter) {
        filters[2] = filter;
    }
    
    /**
     * Sets the Assignmentfilter.
     * @param filter an {@link AssignmentStateFilter} or <tt>null</tt> to delete an existing filter.
     */
    void setAssignmentStateFilter(AbstractConfigurationFilter filter) {
        filters[3] = filter;
    }
    
    /**
     * Determines how many active filters are set.
     * @return <tt>0</tt> if no filter was set, otherwise a number greater than 0.
     */
    private int countElements() {
        int elements = 0;
        for (int i = 0; i < filters.length; i++) {
            if (null != filters[i]) {
                elements++;
            }
        }
        
        return elements;
    }
    
    /**
     * Returns only the configured (not <tt>null</tt>) filters as an array.
     * @return A array of filter, if now filter was specified an empty array will be returned.
     */
    ViewerFilter[] getFilters() {
        ViewerFilter[] result = new ViewerFilter[countElements()];
        
        if (result.length > 0) {
            int pos = 0;
            for (int i = 0; i < filters.length && pos < result.length; i++) {
                if (null != filters[i]) {
                    result[pos] = filters[i];
                    pos++;
                }
            }
        }
        
        return result;
    }
}
