package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFTest".
 */
public interface IFTest {

    /**
     * Defines the data input interface for the {@link IIFTestInput} algorithm (over all defined input tuples).
     */
    public interface IIFTestInput {

    }

    /**
     * Defines the data output interface for the {@link IIFTestOutput} algorithm (over all defined output tuples).
     */
    public interface IIFTestOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTestInput input, IIFTestOutput result);

}
