package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;

/**
 * Configures the interface tests for reasoners.
 * 
 * @author Eichelberger
 */
public class InterfaceTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected InterfaceTests(ITestDescriptor descriptor) {
        super(descriptor, "interfaces");
    }

    /**
     * Tests changing constraint variables.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void unfrozenTest() throws IOException, ModelQueryException {
        reasoningTest("Basis", 0);
        Configuration cfg = reasoningTest("Unfrozen", 1);
        assertState(cfg, "iVal", AssignmentState.DERIVED, AssignmentState.ASSIGNED);
        assertState(cfg, "sVal", AssignmentState.DERIVED, AssignmentState.ASSIGNED);
        assertState(cfg, "myVal", AssignmentState.DERIVED, AssignmentState.ASSIGNED);
    }

    /**
     * Tests changing constraint variables.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void frozenTest() throws IOException, ModelQueryException {
        reasoningTest("Basis", 0);
        Configuration cfg = reasoningTest("Frozen", 1);
        assertState(cfg, "iVal", AssignmentState.FROZEN);
        assertState(cfg, "sVal", AssignmentState.FROZEN);
        assertState(cfg, "myVal", AssignmentState.FROZEN);
    }

    /**
     * Asserts the state of a given variable, also as fallback by iterating through the configuration
     * in case of variables under IVML interface access restrictions.
     * 
     * @param cfg the configuration
     * @param varName the variable name
     * @param states the states to be asserted (at least one)
     * @throws ModelQueryException in case that accessing the underlying variable fails
     */
    private void assertState(Configuration cfg, String varName, IAssignmentState... states) throws ModelQueryException {
        Project prj = cfg.getProject();
        AbstractVariable decl = ModelQuery.findVariable(prj, varName, null);
        IDecisionVariable var = null;
        if (null == decl) {
            // fallback to bypass interface access restriction
            Iterator<IDecisionVariable> iter = cfg.iterator();
            while (null == var && iter.hasNext()) {
                IDecisionVariable tmp = iter.next();
                if (varName.equals(tmp.getDeclaration().getName())) {
                    var = tmp;
                }
            }
        } else {
            var = cfg.getDecision(decl);
        }
        Assert.assertNotNull(var);
        assertContained(var.getState(), (Object[]) states);
    }
    

}
