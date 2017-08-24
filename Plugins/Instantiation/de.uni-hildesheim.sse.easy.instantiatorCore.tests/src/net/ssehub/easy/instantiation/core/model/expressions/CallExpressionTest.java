package net.ssehub.easy.instantiation.core.model.expressions;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.AbstractTest;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactTypes;
import net.ssehub.easy.instantiation.core.model.artifactModel.JavaPath;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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
        TypeDescriptor<?> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        TypeDescriptor<?> rDesc = TypeRegistry.realType();
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
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }

    /**
     * Tests a call expression with a static operation.
     */
    @Test
    public void testStaticExpression() {
        TypeDescriptor<?> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        try {
            CallArgument param1 = new CallArgument(
                new ConstantExpression(iDesc, Integer.valueOf(1), getRegistry()));
            CallArgument param2 = new CallArgument(
                new ConstantExpression(iDesc, Integer.valueOf(2), getRegistry()));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<?> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertTrue("result must be of type Integer", eDesc == iDesc);
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Integer", result instanceof Integer);
            Assert.assertEquals("result is incorrect", 3, ((Integer) result).intValue());
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }
   
    /**
     * Tests a call expression with a non-static operation.
     */
    @Test
    public void testNonStaticExpression() {
        TypeDescriptor<?> pDesc = ArtifactTypes.pathType();
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
            TypeDescriptor<?> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Assert.assertEquals("result must be of type JavaPath", oDesc.getReturnType().getName(), eDesc.getName());
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type JavaPath", result instanceof JavaPath);
            Assert.assertEquals("result must be " + expectedJavaPath, expectedJavaPath, ((JavaPath) result).getPath());
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);            
        }
    }
    
    /**
     * Tests a call expression with a parameter conversion.
     */
    @Test
    public void testParameterConversion() {
        TypeDescriptor<?> iDesc = TypeRegistry.integerType();
        Assert.assertNotNull("integer type descriptor must exist", iDesc);
        TypeDescriptor<?> rDesc = TypeRegistry.realType();
        Assert.assertNotNull("double/real type descriptor must exist", rDesc);
        try {
            CallArgument param1 = new CallArgument(
                 new ConstantExpression(rDesc, Double.valueOf(1.5), getRegistry()));
            CallArgument param2 = new CallArgument(
                 new ConstantExpression(iDesc, Integer.valueOf(2), getRegistry()));
            CallExpression ex = new CallExpression(null, "+", param1, param2);
            TypeDescriptor<?> eDesc = ex.inferType();
            Assert.assertNotNull("result type must not be null", eDesc);
            Object result = ex.accept(new EvaluationVisitor(new RuntimeEnvironment(), NoTracer.INSTANCE));
            Assert.assertNotNull("result must not be null", result);
            Assert.assertTrue("result must be of type Double", result instanceof Double);
            Assert.assertEquals("result is incorrect", 3.5, ((Double) result).doubleValue(), REAL_COMPARISON_EPSILON);
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);
        }        
    }
    
}
