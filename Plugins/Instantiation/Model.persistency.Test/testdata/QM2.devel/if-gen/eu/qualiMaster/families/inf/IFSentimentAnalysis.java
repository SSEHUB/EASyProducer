package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFSentimentAnalysis".
 */
public interface IFSentimentAnalysis {

    /**
     * Defines the data input interface for the {@link IIFSentimentAnalysisInput} algorithm (over all defined input tuples).
     */
    public interface IIFSentimentAnalysisInput {

    }

    /**
     * Defines the data output interface for the {@link IIFSentimentAnalysisOutput} algorithm (over all defined output tuples).
     */
    public interface IIFSentimentAnalysisOutput {

    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSentimentAnalysisInput input, IIFSentimentAnalysisOutput result);

}
