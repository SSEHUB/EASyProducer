package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

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
        TypeDescriptor<? extends IVilType> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        try {
            VariableDeclaration xVar = new VariableDeclaration("x", iDesc);
            BuildlangExecution exec = createExecutionInstance();
            RuntimeEnvironment env = exec.getRuntimeEnvironment();
            env.switchContext(new Script("test"));
            if (defineVariable) {
                try {
                    env.setValue(xVar, Integer.valueOf(1));
                } catch (VilLanguageException e) {
                    Assert.fail("unexpected exception: " + e.getMessage());
                }
            }
            CallArgument param1 = new CallArgument(new VariableExpression(xVar));
            CallArgument param2 = new CallArgument(
                 new ConstantExpression(iDesc, Integer.valueOf(2), TypeRegistry.DEFAULT));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<? extends IVilType> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertTrue("result must be of type Integer", eDesc == iDesc);
            Object result = ex.accept(exec);
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Integer", result instanceof Integer);
            Assert.assertEquals("result is incorrect", 3, ((Integer) result).intValue());
        } catch (ExpressionException e) {
            if (defineVariable) {
                Assert.fail("unexpected exception: " + e);
            } else {
                Assert.assertEquals(VilLanguageException.ID_NOT_FOUND, e.getId());
            }
        }
    }
    
}
