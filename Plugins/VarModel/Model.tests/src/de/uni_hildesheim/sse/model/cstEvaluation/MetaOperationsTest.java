package de.uni_hildesheim.sse.model.cstEvaluation;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented metatype/type operations.
 * 
 * @author Holger Eichelberger
 */
public class MetaOperationsTest {

    /**
     * Tests the equals and the unequals operation for booleans.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor sType = Utils.createValue(MetaType.TYPE, context, StringType.TYPE);
        EvaluationAccessor bType = Utils.createValue(MetaType.TYPE, context, BooleanType.TYPE);
        
        Utils.testEquals(true, MetaType.EQUALS, MetaType.NOTEQUALS, sType, sType);
        Utils.testEquals(true, MetaType.EQUALS, MetaType.NOTEQUALS, bType, bType);
        Utils.testEquals(false, MetaType.EQUALS, MetaType.NOTEQUALS, bType, sType);
        Utils.testEquals(false, MetaType.EQUALS, MetaType.NOTEQUALS, sType, bType);

        sType.release();
        bType.release();
    }
    
}
