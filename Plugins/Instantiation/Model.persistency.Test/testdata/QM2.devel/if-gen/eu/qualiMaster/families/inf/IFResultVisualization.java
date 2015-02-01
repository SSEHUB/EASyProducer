package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFResultVisualization".
 */
public interface IFResultVisualization {

    /**
     * Defines the data input interface for the {@link IIFResultVisualizationInput} algorithm (over all defined input tuples).
     */
    public interface IIFResultVisualizationInput {

    }

    /**
     * Defines the data output interface for the {@link IIFResultVisualizationOutput} algorithm (over all defined output tuples).
     */
    public interface IIFResultVisualizationOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFResultVisualizationInput input, IIFResultVisualizationOutput result);

}
