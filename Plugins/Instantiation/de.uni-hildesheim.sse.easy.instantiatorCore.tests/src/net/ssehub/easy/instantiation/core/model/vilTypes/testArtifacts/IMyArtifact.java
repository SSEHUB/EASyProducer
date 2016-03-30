package net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * An interface which declares an inherited invisible method.
 * 
 * @author Holger Eichelberger
 */
public interface IMyArtifact {

    /**
     * This shall not be visible to VIL, also not the implemented methods.
     */
    @Invisible(inherit = true)
    public void internal();
    
    /**
     * This shall be visible.
     */
    public void shallBeVisible();
    
}
