package de.uni_hildesheim.sse.model.cstEvaluation;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented metatype/type operations.
 * 
 * @author Holger Eichelberger
 */
public class EnumOperationsTest {

    private static final Enum UNORDERED_ENUM_TYPE = new Enum("uEnum", null, "Val1", "Val2");

    private static final Enum ORDERED_ENUM_TYPE;
    
    static {
        ORDERED_ENUM_TYPE = new Enum("oEnum", null);
        ORDERED_ENUM_TYPE.add(new EnumLiteral("OVal1", 42, ORDERED_ENUM_TYPE));
        ORDERED_ENUM_TYPE.add(new EnumLiteral("OVal2", 101, ORDERED_ENUM_TYPE));
        ORDERED_ENUM_TYPE.add(new EnumLiteral("OVal3", 153, ORDERED_ENUM_TYPE));
    }
    
    /**
     * Tests the equals and the unequals operation for enums.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        testEquals(UNORDERED_ENUM_TYPE);
        testEquals(ORDERED_ENUM_TYPE);
    }

    /**
     * Tests the equals and unequals operation for enums.
     * 
     * @param eType the enum type to be tested
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    private static void testEquals(de.uni_hildesheim.sse.model.varModel.datatypes.Enum eType) 
        throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        
        EvaluationAccessor val1 = Utils.createValue(eType, context, eType.getLiteral(0));
        EvaluationAccessor val2 = Utils.createValue(eType, context, eType.getLiteral(eType.getLiteralCount() - 1));
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, Enum.EQUALS, Enum.NOTEQUALS, val1, val1);
        Utils.testEquals(true, Enum.EQUALS, Enum.NOTEQUALS, val2, val2);
        Utils.testEquals(false, Enum.EQUALS, Enum.NOTEQUALS, val1, val2);
        Utils.testEquals(false, Enum.EQUALS, Enum.NOTEQUALS, val2, val1);
        Utils.testEquals(false, Enum.EQUALS, Enum.NOTEQUALS, val1, nullV);
        Utils.testEquals(false, Enum.EQUALS, Enum.NOTEQUALS, val2, nullV);

        val1.release();
        val2.release();
        nullV.release();
    }
    
    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Utils.testDefined(ORDERED_ENUM_TYPE, Enum.IS_DEFINED, ORDERED_ENUM_TYPE.getLiteral(0));
        Utils.testDefined(UNORDERED_ENUM_TYPE, Enum.IS_DEFINED, UNORDERED_ENUM_TYPE.getLiteral(0));
    }
    
    /**
     * Tests the ordinal operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testOrdinal() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        testOrdinals(ORDERED_ENUM_TYPE, context);
        testOrdinals(UNORDERED_ENUM_TYPE, context);
    }
    
    /**
     * Tests the ordinals of the given enumeration type.
     * 
     * @param eType the enumeration type to be tested
     * @param context the evaluation context
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    private static void testOrdinals(Enum eType, EvaluationContext context) throws ValueDoesNotMatchTypeException {
        for (int l = 0; l < eType.getLiteralCount(); l++) {
            EnumLiteral lit = eType.getLiteral(l);
            EvaluationAccessor litValue = Utils.createValue(eType, context, lit);
            Utils.assertEquals(lit.getOrdinal(), Utils.evaluate(Enum.ORDINAL, litValue));
            litValue.release();
        }
    }
    
    /**
     * Tests the comparisons for ordered enums.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testComparisons() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EnumLiteral lit1 = ORDERED_ENUM_TYPE.getLiteral(0);
        EnumLiteral lit2 = ORDERED_ENUM_TYPE.getLiteral(ORDERED_ENUM_TYPE.getLiteralCount() - 1);
        EvaluationAccessor val1 = Utils.createValue(ORDERED_ENUM_TYPE, context, lit1);
        EvaluationAccessor val2 = Utils.createValue(ORDERED_ENUM_TYPE, context, lit2);

        Utils.assertEquals(lit2.getOrdinal() > lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER, val2, val2));
        Utils.assertEquals(lit2.getOrdinal() > lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER, val2, val1));
        Utils.assertEquals(lit1.getOrdinal() > lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER, val1, val2));
        Utils.assertEquals(lit1.getOrdinal() > lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER, val1, val1));

        Utils.assertEquals(lit2.getOrdinal() >= lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER_EQUALS, val2, val2));
        Utils.assertEquals(lit2.getOrdinal() >= lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER_EQUALS, val2, val1));
        Utils.assertEquals(lit1.getOrdinal() >= lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER_EQUALS, val1, val2));
        Utils.assertEquals(lit1.getOrdinal() >= lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.GREATER_EQUALS, val1, val1));

        Utils.assertEquals(lit2.getOrdinal() < lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS, val2, val2));
        Utils.assertEquals(lit2.getOrdinal() < lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS, val2, val1));
        Utils.assertEquals(lit1.getOrdinal() < lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS, val1, val2));
        Utils.assertEquals(lit1.getOrdinal() < lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS, val1, val1));

        Utils.assertEquals(lit2.getOrdinal() <= lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS_EQUALS, val2, val2));
        Utils.assertEquals(lit2.getOrdinal() <= lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS_EQUALS, val2, val1));
        Utils.assertEquals(lit1.getOrdinal() <= lit2.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS_EQUALS, val1, val2));
        Utils.assertEquals(lit1.getOrdinal() <= lit1.getOrdinal(), 
            Utils.evaluate(OrderedEnum.LESS_EQUALS, val1, val1));
        
        val1.release();
        val2.release();
    }
    
}
