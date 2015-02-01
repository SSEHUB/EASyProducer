package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFSentimentTwitterStream".
 */
public interface IFSentimentTwitterStream {

    /**
     * Defines the data input interface for the {@link IIFSentimentTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public interface IIFSentimentTwitterStreamInput {

    }

    /**
     * Defines the data output interface for the {@link IIFSentimentTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public interface IIFSentimentTwitterStreamOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSentimentTwitterStreamInput input, IIFSentimentTwitterStreamOutput result);

}
