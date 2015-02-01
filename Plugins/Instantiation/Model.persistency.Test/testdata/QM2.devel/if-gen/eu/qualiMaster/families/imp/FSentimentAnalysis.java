package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FSentimentAnalysis implements IFSentimentAnalysis {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFSentimentAnalysisInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentAnalysisInput implements IFSentimentAnalysis.IIFSentimentAnalysisInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFSentimentAnalysisOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentAnalysisOutput implements IFSentimentAnalysis.IIFSentimentAnalysisOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFSentimentAnalysisInput input, IIFSentimentAnalysisOutput result) {
    }

}
