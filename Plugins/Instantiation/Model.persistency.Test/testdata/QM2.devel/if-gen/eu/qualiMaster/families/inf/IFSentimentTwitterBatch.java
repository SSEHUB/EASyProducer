package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFSentimentTwitterBatch".
 */
public interface IFSentimentTwitterBatch {

    /**
     * Defines the data input interface for the {@link IIFSentimentTwitterBatchInput} algorithm (over all defined input tuples).
     */
    public interface IIFSentimentTwitterBatchInput {

    }

    /**
     * Defines the data output interface for the {@link IIFSentimentTwitterBatchOutput} algorithm (over all defined output tuples).
     */
    public interface IIFSentimentTwitterBatchOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSentimentTwitterBatchInput input, IIFSentimentTwitterBatchOutput result);

}
