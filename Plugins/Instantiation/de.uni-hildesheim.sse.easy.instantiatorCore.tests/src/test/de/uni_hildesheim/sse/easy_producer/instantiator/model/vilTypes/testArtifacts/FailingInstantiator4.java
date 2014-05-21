package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;

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
