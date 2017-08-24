package net.ssehub.easy.instantiation.core.model.expressions;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.AbstractTest;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Tests {@link ConstructorCallExpression}.
 * 
 * @author Holger Eichelberger
 */
public class ConstructorCallExpressionTest extends AbstractTest {
    
    /**
     * Tests a simple constructor call.
     */
    @Test
    public void testConstructor() {
        try {
            TypeDescriptor<?> fDesc = getRegistry().getType(FileArtifact.class.getSimpleName());
            Assert.assertNotNull("FileArtifact descriptor must exist", fDesc);
            ConstructorCallExpression constructor = new ConstructorCallExpression(fDesc, new CallArgument[0]);
            Assert.assertNotNull("cannot infer type", constructor.inferType());
            Assert.assertNotNull("cannot resolve constructor", constructor.getResolved());
            Object result = constructor.getResolved().invoke((Object[]) null);
            Assert.assertTrue(result instanceof FileArtifact);
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }
    
}
