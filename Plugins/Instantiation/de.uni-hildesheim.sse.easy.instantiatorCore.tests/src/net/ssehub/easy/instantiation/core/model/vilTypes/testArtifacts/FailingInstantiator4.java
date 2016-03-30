package net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * A dynamic instantiator with missing instantiator method.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("instanceInstantiator2")
public class FailingInstantiator4 implements IVilType {

    /**
     * Shall not be an instantiator method.
     */
    public void test() {
    }
    
}
