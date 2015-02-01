package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFCorrelation".
 */
public interface IFCorrelation {

    /**
     * Defines the data input interface for the {@link IIFCorrelationInput} algorithm (over all defined input tuples).
     */
    public interface IIFCorrelationInput {

    }

    /**
     * Defines the data output interface for the {@link IIFCorrelationOutput} algorithm (over all defined output tuples).
     */
    public interface IIFCorrelationOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCorrelationInput input, IIFCorrelationOutput result);

}
