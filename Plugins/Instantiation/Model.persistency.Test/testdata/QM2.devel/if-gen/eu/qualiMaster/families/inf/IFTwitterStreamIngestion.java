package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFTwitterStreamIngestion".
 */
public interface IFTwitterStreamIngestion {

    /**
     * Defines the data input interface for the {@link IIFTwitterStreamIngestionInput} algorithm (over all defined input tuples).
     */
    public interface IIFTwitterStreamIngestionInput {

    }

    /**
     * Defines the data output interface for the {@link IIFTwitterStreamIngestionOutput} algorithm (over all defined output tuples).
     */
    public interface IIFTwitterStreamIngestionOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterStreamIngestionInput input, IIFTwitterStreamIngestionOutput result);

}
