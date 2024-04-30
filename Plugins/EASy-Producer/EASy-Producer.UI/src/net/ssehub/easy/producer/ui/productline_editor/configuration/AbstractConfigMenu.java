package net.ssehub.easy.producer.ui.productline_editor.configuration;

import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.productline_editor.AbstractHeaderMenu;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IConfigurationChangeListener;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Abstract super class for menu modifying the {@link net.ssehub.easy.producer.ui.confModel.GUIConfiguration}.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractConfigMenu extends AbstractHeaderMenu implements IConfigurationChangeListener {

    private IGUIConfigurationContainer guiConfigContainer;
    private GUIConfigurationFilter filters;
    /**
     * Sole constructor for this class.
     * @param parent The parent holding this menu.
     * @param plp The current edited {@link ProductLineProject}
     */
    protected AbstractConfigMenu(Composite parent, ProductLineProject plp) {
        super(parent, plp);
        guiConfigContainer = null;
    }

    /**
     * Setter for the {@link IGUIConfigurationContainer}.
     * 
     * @param guiConfigContainer
     *            Sets the {@link IGUIConfigurationContainer} (Can be <code>null</code>, but than errorMessages from the
     *            reasoning steps will not be passed to the {@link IGUIConfigurationContainer}, also ViewerFilters will
     *            not be handled).
     */
    public final void setGUIConfiguration(IGUIConfigurationContainer guiConfigContainer) {
        // unregister from old configuration
        if (null != this.guiConfigContainer) {
            this.guiConfigContainer.getConfig().unregister(this);
        }
        this.guiConfigContainer = guiConfigContainer;
        
        // register new configuration
        if (null != this.guiConfigContainer) {
            this.guiConfigContainer.getConfig().register(this);
        }
        
        // Apply current filters to new guiContainer
        if (null != filters) {
            setFilter(filters);
        }
    }
    
    /**
     * Returns the {@link IGUIConfigurationContainer} which will be manipulated by this menu.
     * @return The related {@link IGUIConfigurationContainer}, can be <code>null</code> if no container
     *     was set via the {@link #setGUIConfiguration(IGUIConfigurationContainer)} method.
     */
    protected final IGUIConfigurationContainer getConfigContainer() {
        return guiConfigContainer;
    }
    
    /**
     * Sets the filters, replacing any previous filters, and triggers
     * refiltering and resorting of the elements.
     * 
     * @param filters A set of filters which shall be applied to the current configuration, must not be 
     * <code>null</code>
     * @see IGUIConfigurationContainer#setFilters(org.eclipse.jface.viewers.ViewerFilter[])
     */
    protected final void setFilter(GUIConfigurationFilter filters) {
        if (null != guiConfigContainer) {
            guiConfigContainer.setFilters(filters.getFilters());
        }
        
        this.filters = filters;
    }
    
    /**
     * Removes all errors appended to the current configuration and adds the specified error messages.
     * @param errorMessages A list of error/warning messages, produced by a reasoning step.
     * @see net.ssehub.easy.producer.ui.confModel.GUIConfiguration#setErrorMessages(Message[])
     */
    protected final void setErrorMessages(Message[] errorMessages) {
        if (null != guiConfigContainer) {
            guiConfigContainer.getGuiConfig().setErrorMessages(errorMessages);
        }
    }
    
    /**
     * Removes the error messages of all stored {@link net.ssehub.easy.producer.ui.confModel.GUIVariable}.
     * This method should be called after a reasoning was performed and no error was detected.
     */
    protected final void clearErrorMessages() {
        if (null != guiConfigContainer) {
            guiConfigContainer.getGuiConfig().clearErrorMessages();
        }
    }
    
    @Override
    public void itemChanged(Configuration config, IDecisionVariable changedVariable, Value oldValue) {
        // Method of the IConfigurationChangeListener, no action needed
    }
    
    @Override
    public void stateChanged(Configuration config, IDecisionVariable changedVariable) {
        // Method of the IConfigurationChangeListener, no action needed
    }
    
    @Override
    public void configurationRefreshed(Configuration config) {
        revalidateButtons();
    }
}
