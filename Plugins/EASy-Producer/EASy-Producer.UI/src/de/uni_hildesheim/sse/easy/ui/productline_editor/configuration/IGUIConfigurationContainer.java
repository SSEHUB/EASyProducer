package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.ViewerFilter;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.model.confModel.Configuration;

/**
 * Interface for a viewer holding the GUIConfiguration.
 * Adds methods for:
 * <ul>
 * <li>get {@link GUIConfiguration}</li>
 * <li>specify filters for filtering elements of the {@link GUIConfiguration}</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
interface IGUIConfigurationContainer {
    
    /**
     * Returns the GUI configuration instance.
     * 
     * @return the GUI configuration instance
     */
    public GUIConfiguration getGuiConfig();
    
    /**
     * Adds the given filter to the viewer, and triggers refiltering and
     * resorting of the elements. If you want to add more than one filter
     * consider using {@link #setFilters(ViewerFilter[])}.
     * 
     * @param filter a viewer filter
     */
    public void addFilter(ViewerFilter filter);
    
    /**
     * Sets the filters, replacing any previous filters, and triggers
     * refiltering and resorting of the elements.
     * 
     * @param filters An array of viewer filters, must not be <tt>null</tt>
     */
    public void setFilters(ViewerFilter[] filters);
    
    /**
     * Removes the given filter from the viewer, and triggers refiltering and
     * resorting of the elements if required. Has no effect if the identical
     * filter is not registered. If you want to remove more than one filter
     * consider using {@link #setFilters(ViewerFilter[])}.
     * 
     * @param filter A viewer filter
     * @see #setFilters(ViewerFilter[])
     */
    public void removeFilter(ViewerFilter filter);

    /**
     * Returns the configuration instance.
     * 
     * @return the configuration instance
     */
    public Configuration getConfig();
}
