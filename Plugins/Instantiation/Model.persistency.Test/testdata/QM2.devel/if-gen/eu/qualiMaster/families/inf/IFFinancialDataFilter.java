package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFFinancialDataFilter".
 */
public interface IFFinancialDataFilter {

    /**
     * Defines the data input interface for the {@link IIFFinancialDataFilterInput} algorithm (over all defined input tuples).
     */
    public interface IIFFinancialDataFilterInput {

    }

    /**
     * Defines the data output interface for the {@link IIFFinancialDataFilterOutput} algorithm (over all defined output tuples).
     */
    public interface IIFFinancialDataFilterOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFFinancialDataFilterInput input, IIFFinancialDataFilterOutput result);

}
