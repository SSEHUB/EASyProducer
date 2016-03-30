package net.ssehub.easy.instantiation.core.model.buildlangModel;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Tests {@link CallExpression}.
 * 
 * @author Holger Eichelberger
 */
public class VariableExpressionTest extends AbstractTest {

    /**
     * Tests a call expression with a static operation and a variable (defined and undefined).
     */
    @Test
    public void testStaticExpression() {
        testStaticExpression(true);
        testStaticExpression(false);
    }

    /**
     * Tests a call expression with a static operation and a variable.
     * 
     * @param defineVariable define the variable or not (and cause and catch an exception)
     */
    public void testStaticExpression(boolean defineVariable) {
        TypeDescriptor<?> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        try {
            VariableDeclaration xVar = new VariableDeclaration("x", iDesc);
            BuildlangExecution exec = createExecutionInstance();
            RuntimeEnvironment env = exec.getRuntimeEnvironment();
            env.switchContext(new Script("test"));
            if (defineVariable) {
                try {
                    env.setValue(xVar, Integer.valueOf(1));
                } catch (VilException e) {
                    Assert.fail("unexpected exception: " + e.getMessage());
                }
            }
            CallArgument param1 = new CallArgument(new VariableExpression(xVar));
            CallArgument param2 = new CallArgument(
                 new ConstantExpression(iDesc, Integer.valueOf(2), getRegistry()));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<?> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertTrue("result must be of type Integer", eDesc == iDesc);
            Object result = ex.accept(exec);
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Integer", result instanceof Integer);
            Assert.assertEquals("result is incorrect", 3, ((Integer) result).intValue());
        } catch (VilException e) {
            if (defineVariable) {
                Assert.fail("unexpected exception: " + e);
            } else {
                Assert.assertEquals(VilException.ID_NOT_FOUND, e.getId());
            }
        }
    }
    
}
