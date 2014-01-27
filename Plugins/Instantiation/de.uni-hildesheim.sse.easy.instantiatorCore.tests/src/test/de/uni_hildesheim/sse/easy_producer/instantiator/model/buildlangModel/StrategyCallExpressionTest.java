package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.File;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts.StaticInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

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
        Class<?extends IVilType> cls = StaticInstantiator.class;
        try {
            TypeRegistry.registerType(cls);
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
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        }
        TypeDescriptor<? extends IVilType> artifactType = TypeRegistry.getType(FileArtifact.class.getSimpleName());
        Assert.assertNotNull("file artifact not found", artifactType);
        Assert.assertTrue("wrong artifact type", artifact instanceof FileArtifact);
        try {
            StrategyCallExpression ex = new StrategyCallExpression(inst.value(), 
                new ConstantExpression(artifactType, artifact));
            TypeDescriptor<? extends IVilType> resultType = ex.inferType();
            Assert.assertTrue("result type does not match", 
                 TypeRegistry.getType(Set.class).isAssignableFrom(resultType));
            ex.accept(createExecutionInstance());
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        }
    }

    /**
     * Tests a system exec call.
     */
    @Test
    public void testSystemExecution() {
        TypeDescriptor<? extends IVilType> stringType = TypeRegistry.stringType();
        try {
            StrategyCallExpression ex;
            VariableDeclaration varName = new VariableDeclaration("callName", TypeRegistry.stringType());
            String varNameValue;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                varNameValue = "cmd";
                ex = new StrategyCallExpression(varName, 
                    new ConstantExpression(stringType, "/c"),
                    new ConstantExpression(stringType, "dir"), 
                    new ConstantExpression(stringType, "."));
            } else {
                varNameValue = "ls";
                ex = new StrategyCallExpression(varName, 
                    new ConstantExpression(stringType, "-l"),
                    new ConstantExpression(stringType, "."));
            }
            TypeDescriptor<? extends IVilType> result = ex.inferType();
            Assert.assertTrue("result is not of correct type", result == TypeDescriptor.VOID);
            BuildlangExecution exec = createExecutionInstance();
            exec.getRuntimeEnvironment().switchContext(new Script("test"));
            exec.getRuntimeEnvironment().addValue(varName, varNameValue);
            ex.accept(exec);
            // no result expected but also no exception
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception:" + e.getMessage());
        } catch (VilLanguageException e) {
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
