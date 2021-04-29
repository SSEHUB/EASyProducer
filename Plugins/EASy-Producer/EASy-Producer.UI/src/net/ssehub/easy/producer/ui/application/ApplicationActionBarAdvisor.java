package net.ssehub.easy.producer.ui.application;

import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 * 
 * @author Holger Eichelberger
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    /**
     * Calls superclass constructor thus creates a new action bar advisor.
     * to configure a workbench window's action bars via the given action bar configurer.
     * 
     * @param configurer the action bar configurer. 
     */
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

}
