package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFResultCombination".
 */
public interface IFResultCombination {

    /**
     * Defines the data input interface for the {@link IIFResultCombinationInput} algorithm (over all defined input tuples).
     */
    public interface IIFResultCombinationInput {

    }

    /**
     * Defines the data output interface for the {@link IIFResultCombinationOutput} algorithm (over all defined output tuples).
     */
    public interface IIFResultCombinationOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFResultCombinationInput input, IIFResultCombinationOutput result);

}
