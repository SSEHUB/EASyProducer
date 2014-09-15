package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import org.junit.Assert;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstructorCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

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
            TypeDescriptor<? extends IVilType> fDesc = getRegistry().getType(FileArtifact.class.getSimpleName());
            Assert.assertNotNull("FileArtifact descriptor must exist", fDesc);
            ConstructorCallExpression constructor = new ConstructorCallExpression(fDesc, new CallArgument[0]);
            Assert.assertNotNull("cannot infer type", constructor.inferType());
            Assert.assertNotNull("cannot resolve constructor", constructor.getResolved());
            Object result = constructor.getResolved().invoke((Object[]) null);
            Assert.assertTrue(result instanceof FileArtifact);
        } catch (ExpressionException e) {
            Assert.fail("unexpected exception: " + e);
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e);
        }
    }
    
}
