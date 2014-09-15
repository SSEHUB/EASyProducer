package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import org.junit.Assert;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactTypes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.JavaPath;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.EvaluationVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.NoTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Tests {@link CallExpression}.
 * 
 * @author Holger Eichelberger
 */
public class CallExpressionTest extends AbstractTest {

    /**
     * The default precision for comparing reals.
     */
    public static final double REAL_COMPARISON_EPSILON = 1E-6;
    
    /**
     * Tests a transparent conversion as simple expression tree.
     */
    @Test
    public void testTransparentConversion() {
        TypeDescriptor<? extends IVilType> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        TypeDescriptor<? extends IVilType> rDesc = TypeRegistry.realType();
        Assert.assertNotNull("double/real type descriptor must exist", rDesc);
        OperationDescriptor op = iDesc.findConversion(iDesc, rDesc);
        Assert.assertNotNull("int->double conversion operation must exist", op);
        try {
            int value = 1;
            ConstantExpression arg = new ConstantExpression(iDesc, Integer.valueOf(value), getRegistry());
            CallExpression ex = new CallExpression(op, new CallArgument(arg));
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Double", result instanceof Double);
            Assert.assertEquals("result is incorrect", 1, ((Double) result).doubleValue(), REAL_COMPARISON_EPSILON);
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }

    /**
     * Tests a call expression with a static operation.
     */
    @Test
    public void testStaticExpression() {
        TypeDescriptor<? extends IVilType> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        try {
            CallArgument param1 = new CallArgument(
                new ConstantExpression(iDesc, Integer.valueOf(1), getRegistry()));
            CallArgument param2 = new CallArgument(
                new ConstantExpression(iDesc, Integer.valueOf(2), getRegistry()));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<? extends IVilType> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertTrue("result must be of type Integer", eDesc == iDesc);
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Integer", result instanceof Integer);
            Assert.assertEquals("result is incorrect", 3, ((Integer) result).intValue());
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }
   
    /**
     * Tests a call expression with a non-static operation.
     */
    @Test
    public void testNonStaticExpression() {
        TypeDescriptor<? extends IVilType> pDesc = ArtifactTypes.pathType();
        Assert.assertNotNull("path type descriptor must exist", pDesc);
        try {
            String filePath = "java/lang/test";
            String expectedJavaPath = filePath.replace('/', '.');
            Object path = pDesc.create(filePath);
            Assert.assertNotNull("Path constructor failed", path);
            Assert.assertTrue("result of Path constructor is not of type Path", path instanceof Path);
            final String opName = "toJavaPath";
            OperationDescriptor oDesc = null;
            for (int o = 0; o < pDesc.getOperationsCount(); o++) {
                OperationDescriptor tmp = pDesc.getOperation(o);
                if (!tmp.isStatic() && tmp.getName().equals(opName) 
                    && 1 == tmp.getParameterCount()) { // implicit this
                    oDesc = tmp;
                }
            }
            Assert.assertNotNull("cannot find toJavaPath operation in Path. Renamed?", oDesc);
            Assert.assertTrue("toJavaPath operation in Path must not be static. Refactored?", !oDesc.isStatic());
            CallExpression ex = new CallExpression(null, opName, 
                new CallArgument(new ConstantExpression(pDesc, path, getRegistry())));
            TypeDescriptor<? extends IVilType> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertEquals("result must be of type JavaPath", oDesc.getReturnType().getName(), eDesc.getName());
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type JavaPath", result instanceof JavaPath);
            Assert.assertEquals("result must be " + expectedJavaPath, expectedJavaPath, ((JavaPath) result).getPath());
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e);            
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);            
        }
    }
    
    /**
     * Tests a call expression with a parameter conversion.
     */
    @Test
    public void testParameterConversion() {
        TypeDescriptor<? extends IVilType> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        TypeDescriptor<? extends IVilType> rDesc = TypeRegistry.realType();
        Assert.assertNotNull("double/real type descriptor must exist", rDesc);
        try {
            CallArgument param1 = new CallArgument(
                 new ConstantExpression(rDesc, Double.valueOf(1.5), getRegistry()));
            CallArgument param2 = new CallArgument(
                 new ConstantExpression(iDesc, Integer.valueOf(2), getRegistry()));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<? extends IVilType> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Double", result instanceof Double);
            Assert.assertEquals("result is incorrect", 3.5, ((Double) result).doubleValue(), REAL_COMPARISON_EPSILON);
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e);
        }        
    }
    
}
