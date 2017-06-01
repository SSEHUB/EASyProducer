package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.io.File;
import java.util.HashMap;

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A slightly extended abstract test class.
 * 
 * @author Holger Eichelberger
 */
public class AbstractTest extends net.ssehub.easy.instantiation.core.model.AbstractTest {
    
    private TypeRegistry registry = new TypeRegistry(TypeRegistry.DEFAULT);
    
    /**
     * Returns the local registry for this test.
     * 
     * @return the local registry
     */
    protected TypeRegistry getRegistry() {
        return registry;
    }
    
    /**
     * Just for testing!
     * 
     * @return an execution environment
     */
    protected static final BuildlangExecution createExecutionInstance() {
        return new BuildlangExecution(NoTracer.INSTANCE, new File("."), new HashMap<String, Object>());
    }

}
