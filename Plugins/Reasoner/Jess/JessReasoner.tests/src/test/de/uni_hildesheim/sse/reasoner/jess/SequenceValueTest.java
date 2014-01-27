package test.de.uni_hildesheim.sse.reasoner.jess;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Test case for SequenceValue & also CompoundValue.
 * 
 * @author Saripalli
 * 
 */
public class SequenceValueTest {

    /**
     * Method to test SequenceValue if it is possible to create a sequence of a
     * type Compound and successfully create sequence values.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Must not throw ValueDoesNotMatchTypeException.
     */
    @Test
    public void testSequenceValue() throws ValueDoesNotMatchTypeException {

        Compound gassenTyp = new Compound("gassenTyp", null);

        // Add maxX and maxY of type integers to the compound gassenTyp
        gassenTyp.add(new DecisionVariableDeclaration("maxX", IntegerType.TYPE,
                gassenTyp));
        gassenTyp.add(new DecisionVariableDeclaration("maxY", IntegerType.TYPE,
                gassenTyp));

        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(
                gassenTyp, "maxX", "5", "maxY", "10");
        Assert.assertTrue(cValue.isFullyConfigured());

        // Defining another compound in which a sequence of gassenTyp is added
        Compound hochRegal = new Compound("hochRegal", null);
        Container seq = new Sequence("seq", gassenTyp, hochRegal);
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration(
                "seq_var", seq, hochRegal);
        hochRegal.add(seqDec);

        String[] value1 = {"maxX", "10", "maxY", "20"};
        Object[] cmpValues = {value1};

        // Must not throw ValueDoesNotMatchTypeException
        ContainerValue seqValue = (ContainerValue) ValueFactory.createValue(
                seq, cmpValues);
        Assert.assertTrue(seqValue.isFullyConfigured());

    }

}
