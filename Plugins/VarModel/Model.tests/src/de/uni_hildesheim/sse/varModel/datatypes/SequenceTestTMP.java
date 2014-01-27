package de.uni_hildesheim.sse.varModel.datatypes;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;

/**
 * This class tests the correct behavior of the sequence class.
 * @author El-Sharkawy
 *
 */
public class SequenceTestTMP {

    /**
     * Tests whether the sequence including its delegate are instantiated correctly.
     * @throws NullPointerException This exception will be thrown if the delegate is not instantiated correctly.
     */
    @Test
    public void testInstantiation() throws NullPointerException {
        IDatatype seq = Sequence.TYPE;
        int anzOperations = seq.getGenericTypeCount();
        for (int i = 0; i < anzOperations; i++) {
            System.out.println(seq.getOperation(i).getName());
            //Next line must not throw NullPointerException.
            System.out.println(seq.getOperation(i).getOperand().getName());
        }
    }

}
