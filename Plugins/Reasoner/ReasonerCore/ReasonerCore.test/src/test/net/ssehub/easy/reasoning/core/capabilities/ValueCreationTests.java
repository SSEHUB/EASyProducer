package test.net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import org.junit.Assert;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Value creation tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ValueCreationTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected ValueCreationTests(ITestDescriptor descriptor) {
        super(descriptor, "values");
    }
    
    /**
     * Basic value creation test.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ModelQueryException  shall not occur
     */
    @Test    
    public void testBasicValueCreation() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ModelQueryException {
        Configuration cfg = reasoningTest("BasicValueCreation.ivml", 0);
        Project prj = cfg.getProject();
        AbstractVariable var = ModelQuery.findVariable(prj, "c", null);
        Assert.assertNotNull("Variable c does not exist", var);
        IReasoner reasoner = createReasoner();
        assertBasicValueCreation(reasoner.createValue(cfg, var, null, null, ProgressObserver.NO_OBSERVER));
        assertBasicValueCreation(reasoner.createValue(cfg, null, var.getType(), null, ProgressObserver.NO_OBSERVER));
        assertBasicValueCreation(reasoner.createValue(cfg, var, var.getType(), null, ProgressObserver.NO_OBSERVER));
    }
    
    /**
     * Does the assertions for {@link #testBasicValueCreation()}.
     * 
     * @param vRes the value creation result to be asserted
     */
    private static void assertBasicValueCreation(ValueCreationResult vRes) {
        Assert.assertNotNull(vRes);
        Assert.assertNotNull(vRes.getVariable());
        Assert.assertTrue(vRes.getValue() instanceof CompoundValue);
        CompoundValue cVal = (CompoundValue) vRes.getValue();
        Value nVal = cVal.getNestedValue("val");
        Assert.assertTrue(nVal instanceof IntValue);
        Assert.assertEquals(25, ((IntValue) nVal).getValue().intValue());
    }

}
