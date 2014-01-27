package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import junit.framework.Assert;

import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Tests the constant expression.
 * 
 * @author Holger Eichelberger
 */
public class ConstantExpressionTest extends AbstractTest {

    /**
     * Tests the construction.
     */
    @Test
    public void testBasicTypes() {
        testType("Integer", 1, "1");
        testType("Integer", 0, "0");
        testType("Integer", -1, "-1");

        testType("Real", 1.0, "1.0");
        testType("Real", 0.0, "0.0");
        testType("Real", -1.0, "-1.0");

        testType("Boolean", true, "true");
        testType("Boolean", false, "false");

        testType("String", "test", "test");
    }

    /**
     * Tests the creation of {@link ConstantExpression} for a specific type. This method
     * tests a null value, <code>value</code> as well as <code>stringValue</code> via 
     * implicit conversion (if specified).
     * 
     * @param vilTypeName the VIL name of the type
     * @param value the object value to be tested for
     * @param stringValue a string for implicit conversion (may be <b>null</b> to disable this part)
     */
    private static void testType(String vilTypeName, Object value, String stringValue) {
        try {
            TypeDescriptor<? extends IVilType> type = TypeRegistry.getType(vilTypeName);
            
            // test null
            ConstantExpression expr = new ConstantExpression(type, null);
            Assert.assertNotNull(expr);
            Assert.assertTrue("type must match", type == expr.getType());
            Assert.assertTrue("value must match", null == expr.getValue());
            
            // test direct value
            expr = new ConstantExpression(type, value);
            Assert.assertNotNull(expr);
            Assert.assertTrue("type must match", type == expr.getType());
            Assert.assertTrue("value must match", value.equals(expr.getValue()));
            
            // test conversion if specified
            if (null != stringValue) {
                expr = new ConstantExpression(type, stringValue);                
                Assert.assertNotNull(expr);
                Assert.assertTrue("type must match", type == expr.getType());
                Assert.assertTrue("value must match", stringValue.equals(expr.getValue().toString()));
            }
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
    }
    
}
