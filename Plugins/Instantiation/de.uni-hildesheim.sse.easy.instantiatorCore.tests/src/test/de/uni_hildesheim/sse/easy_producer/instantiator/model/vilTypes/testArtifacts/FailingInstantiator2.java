package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * A static instantiator with missing method.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("staticInstantiator2")
public class FailingInstantiator2 implements IVilType {

    /**
     * Shall not be an instantiator method.
     */
    public static void test() {
    }
    
}
