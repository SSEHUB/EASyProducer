package test.net.ssehub.easy.reasoning.core.capabilities;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.StringValue;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Dynamic imports tests.
 * 
 * @author Holger Eichelberger
 */
public class DynamicImportsTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected DynamicImportsTests(ITestDescriptor descriptor) {
        super(descriptor, "dynamicImports");
    }
    
    /**
     * Tests the dynamic configuration.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void dynamicImports() throws IOException, ModelQueryException {
        Project prj = loadCompleteProject("dynamicImports", "DynamicImports");
        Configuration cfg = resultHandler(0, 0, prj);
        Configuration.printConfig(System.out, cfg);
        assertStringVar(cfg, "dispS1", "Service1");
        assertStringVar(cfg, "dirS1", "Service1");
        assertStringVar(cfg, "dispS2", "Service2");
        assertStringVar(cfg, "dirS2", "Service2");
    }
    
    /**
     * Asserts a string variable.
     * 
     * @param cfg the configuration
     * @param varName the variable name
     * @param value the expected value
     * @throws ModelQueryException if querying the variable fails
     */
    private void assertStringVar(Configuration cfg, String varName, String value) throws ModelQueryException {
        IDecisionVariable v = cfg.getDecision(varName, false);
        Assert.assertNotNull(v);
        Assert.assertTrue(v.getValue() instanceof StringValue);
        Assert.assertEquals(value, ((StringValue) v.getValue()).getValue());
    }
    
}
