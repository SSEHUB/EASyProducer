package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFFinancialStreamIngestion".
 */
public interface IFFinancialStreamIngestion {

    /**
     * Defines the data input interface for the {@link IIFFinancialStreamIngestionInput} algorithm (over all defined input tuples).
     */
    public interface IIFFinancialStreamIngestionInput {

    }

    /**
     * Defines the data output interface for the {@link IIFFinancialStreamIngestionOutput} algorithm (over all defined output tuples).
     */
    public interface IIFFinancialStreamIngestionOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFFinancialStreamIngestionInput input, IIFFinancialStreamIngestionOutput result);

}
