package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.io.File;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts.StaticInstantiator;

/**
 * Tests {@link StrategyCallExpression}.
 * 
 * @author Holger Eichelberger
 */
public class StrategyCallExpressionTest extends AbstractTest {

    private static final File TESTDATA_DIR = determineTestDataDir();

    /**
     * Tests resolving and executing a test instantiator.
     */
    @Test
    public void testInstantiator() {
        TypeRegistry registry = getRegistry();
        Class<?extends IVilType> cls = StaticInstantiator.class;
        try {
            registry.registerType(cls);
        } catch (VilException e) {
            // don't care for duplicates
        }
        Instantiator inst = cls.getAnnotation(Instantiator.class);
        Assert.assertNotNull("instantiator annotation missing (refactored?)", inst);
        Assert.assertTrue("instantiator name missing (refactored?)", 
            null != inst.value() && inst.value().length() > 0);
        IArtifact artifact = null;
        try {
            artifact = ArtifactFactory.createArtifact(new File(TESTDATA_DIR, "TextFile.txt"));
        } catch (VilException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        }
        TypeDescriptor<?> artifactType = registry.getType(FileArtifact.class.getSimpleName());
        Assert.assertNotNull("file artifact not found", artifactType);
        Assert.assertTrue("wrong artifact type", artifact instanceof FileArtifact);
        try {
            StrategyCallExpression ex = new StrategyCallExpression(null, inst.value(), 
                new ConstantExpression(artifactType, artifact, registry));
            TypeDescriptor<?> resultType = ex.inferType();
            Assert.assertTrue("result type does not match", 
                 registry.getType(Set.class).isAssignableFrom(resultType));
            ex.accept(createExecutionInstance());
        } catch (VilException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        }
    }

    /**
     * Tests a system exec call.
     */
    @Test
    public void testSystemExecution() {
        TypeRegistry registry = getRegistry();
        TypeDescriptor<?> stringType = TypeRegistry.stringType();
        try {
            StrategyCallExpression ex;
            VariableDeclaration varName = new VariableDeclaration("callName", TypeRegistry.stringType());
            String varNameValue;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                varNameValue = "cmd";
                ex = new StrategyCallExpression(varName, 
                    new ConstantExpression(stringType, "/c", registry),
                    new ConstantExpression(stringType, "dir", registry), 
                    new ConstantExpression(stringType, ".", registry));
            } else {
                varNameValue = "ls";
                ex = new StrategyCallExpression(varName, 
                    new ConstantExpression(stringType, "-l", registry),
                    new ConstantExpression(stringType, ".", registry));
            }
            TypeDescriptor<?> result = ex.inferType();
            Assert.assertTrue("result is not of correct type", result == TypeRegistry.voidType());
            BuildlangExecution exec = createExecutionInstance();
            exec.getRuntimeEnvironment().switchContext(new Script("test"));
            exec.getRuntimeEnvironment().addValue(varName, varNameValue);
            ex.accept(exec);
            // no result expected but also no exception
        } catch (VilException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        }
    }
    
    /**
     * Tests a workflow call.
     */
    @Test
    @Ignore
    public void testWorkflowCall() {
        // TODO
    }
    
    /**
     * Tests a workflow super call.
     */
    @Test
    @Ignore
    public void testWorkflowSuperCall() {
        // TODO
    }

}
