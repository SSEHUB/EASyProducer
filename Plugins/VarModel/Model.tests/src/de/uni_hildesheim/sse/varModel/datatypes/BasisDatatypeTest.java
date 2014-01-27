package de.uni_hildesheim.sse.varModel.datatypes;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * Testclass for basis datatypes.
 * @author lueder
 *
 */
public class BasisDatatypeTest {

    /**
     * Tests the whole class.
     */
    @Test
    public void basisTest() {
        DecisionVariableDeclaration dec = new DecisionVariableDeclaration("dec", StringType.TYPE, null);
        
        Assert.assertEquals("String", dec.getType().getName());
        Assert.assertEquals("", dec.getType().getNameSpace());
        Assert.assertEquals("String", dec.getType().getQualifiedName());
        Assert.assertEquals("String", dec.getType().getUniqueName());
        Assert.assertEquals(14, dec.getType().getOperationCount());
        Assert.assertEquals(StringType.EQUALS, dec.getType().getOperation(3));
        Assert.assertEquals(StringType.class, dec.getType().getTypeClass());
        
        try {
            Assert.assertEquals(StringType.class, dec.getType().getGenericType(0));
            Assert.fail(); //Should not occur
        } catch (IndexOutOfBoundsException e) {
            Assert.assertTrue(true);
        }
        
        Assert.assertEquals(0, dec.getType().getGenericTypeCount());
        
        try {
            Assert.assertEquals(null, dec.getType().createConstraints(
                    new DecisionVariableDeclaration("dec2", StringType.TYPE, null)));
        } catch (CSTSemanticException e) {
            Assert.assertTrue(false);
        }
        
        Assert.assertTrue(!dec.getType().isPseudoType());
    }

}
