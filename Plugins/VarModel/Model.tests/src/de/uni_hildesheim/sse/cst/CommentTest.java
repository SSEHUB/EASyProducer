package de.uni_hildesheim.sse.cst;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Tests the {@link Comment} class.
 * @author El-Sharkawy
 *
 */
public class CommentTest {
    
    private ConstraintSyntaxTree cst;
    private Comment comment;
    private String commentText;
    
    /**
     * Initializes objects needed for testing.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} is broken.
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        Value intValue = ValueFactory.createValue(IntegerType.TYPE, "1");
        ConstantValue constValue = new ConstantValue(intValue);
        cst = new OCLFeatureCall(constValue, OclKeyWords.PLUS, constValue);
        commentText = "1 + 1";
        comment = new Comment(cst, commentText);
    }

    /**
     * Tests whether the comment has the same behavior as the nested elements.
     */
    @Test
    public void testEqualityOfNestedElements() {
        Assert.assertSame(cst, comment.getExpr());
        Assert.assertEquals(cst.hashCode(), comment.getExpr().hashCode());
        Assert.assertEquals(commentText.hashCode(), comment.getComment().hashCode());
        Assert.assertFalse(comment.equals(cst));
        Assert.assertNotSame(cst, comment);
        Assert.assertSame(commentText, comment.getComment());
    }

}
