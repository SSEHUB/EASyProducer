package de.uni_hildesheim.sse.varModel.datatypes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Testfile for the EnumClass.
 * 
 * @author heiko beck
 *
 */
public class EnumTest {

    private String enumName;
    private Enum test;
    
    /**
     * setUp method to create an new test enum.
     */
    @Before
    public void setUp() {
        enumName = "enum1";
        test = new Enum(enumName, null);
    }
    
    /**
     * Method to test whether the empty enumeration is correctly initialized.
     */
    @Test
    public void testEmptyEnum() {        
        Assert.assertEquals(enumName, test.getName());
        Assert.assertEquals(0, test.getLiteralCount());
        
        //test the getLength-method to improve test-coverage to 100%
        //method returns the final int 1;
//        int n = test.getFieldLength();
//        Assert.assertEquals(1, n);
    }
    
    /**
     * Method to create an Enum with EnumLiterals.
     */
    @Test
    public void testToFillEnum() {
        String lit1 = "Montag";        
        String lit2 = "Dienstag";
        Enum woche = new Enum(enumName, null, lit1, lit2);
        Assert.assertEquals(2, woche.getLiteralCount());
        Assert.assertNotNull(woche.getLiteralByOrdinal(0));
        Assert.assertEquals(lit1, woche.getLiteralByOrdinal(0).getName());
        Assert.assertNotNull(woche.getLiteralByOrdinal(1));
        Assert.assertEquals(lit2, woche.getLiteralByOrdinal(1).getName());
        Assert.assertNull(null, woche.getLiteralByOrdinal(-1));
        Assert.assertNull(null, woche.getLiteralByOrdinal(10));
    }
    
    /**
     * Test ordinal enums.
     * 
     * @throws IvmlException in case that values cannot be converted (should not happen)
     */
    @Test
    public void testOrdered() throws IvmlException {
        // this should fail and therefore succeed
        testEnumForOrdering(new Enum("unordered", null));
        // this should only succeed
        OrderedEnum oen = new OrderedEnum("ordered", null);
        testEnumForOrdering(oen);
        Assert.assertTrue(oen.isOrdered());
    }
    
    /**
     * Implements the ordering test depending on the enum.
     * 
     * @param woche the enum to be tested
     * @throws IvmlException in case that values cannot be converted (should not happen)
     */
    private void testEnumForOrdering(Enum woche) throws IvmlException {
        final int lit1Ordinal = 100;
        final int lit2Ordinal = 150;
        EnumLiteral lit1 = new EnumLiteral("Montag", lit1Ordinal, woche); // given ordinals for some reasons
        EnumLiteral lit2 = new EnumLiteral("Dienstag", lit2Ordinal, woche);
        Assert.assertTrue(woche.add(lit1));
        Assert.assertTrue(woche.add(lit2));
        Assert.assertEquals(2, woche.getLiteralCount());
        Assert.assertTrue(woche.getLiteral(0).equals(lit1));
        Assert.assertTrue(woche.getLiteral(1).equals(lit2));
        Assert.assertEquals(lit1, woche.getLiteralByOrdinal(lit1Ordinal));
        Assert.assertEquals(lit2, woche.getLiteralByOrdinal(lit2Ordinal));
        Assert.assertNull(null, woche.getLiteralByOrdinal(0));
        
        Value vlit1 = ValueFactory.createValue(woche, lit1);
        ConstantValue clit1 = new ConstantValue(vlit1);
        Value vlit2 = ValueFactory.createValue(woche, lit2);
        ConstantValue clit2 = new ConstantValue(vlit2);
        try {
            OCLFeatureCall comp = new OCLFeatureCall(clit1, "<", clit2);
            // exception occurs for unordered enum
            // here now ordered
            Assert.assertTrue(null != comp.inferDatatype());
            Assert.assertTrue(BooleanType.TYPE.isAssignableFrom(comp.inferDatatype()));
        } catch (IvmlException e) {
            if (woche.isOrdered()) {
                Assert.fail(); // must be present in ordered enum
            }
        }
    }

}
