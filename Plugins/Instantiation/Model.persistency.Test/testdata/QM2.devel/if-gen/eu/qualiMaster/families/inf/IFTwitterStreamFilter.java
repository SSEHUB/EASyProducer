package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFTwitterStreamFilter".
 */
public interface IFTwitterStreamFilter {

    /**
     * Defines the data input interface for the {@link IIFTwitterStreamFilterInput} algorithm (over all defined input tuples).
     */
    public interface IIFTwitterStreamFilterInput {

    }

    /**
     * Defines the data output interface for the {@link IIFTwitterStreamFilterOutput} algorithm (over all defined output tuples).
     */
    public interface IIFTwitterStreamFilterOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterStreamFilterInput input, IIFTwitterStreamFilterOutput result);

}
