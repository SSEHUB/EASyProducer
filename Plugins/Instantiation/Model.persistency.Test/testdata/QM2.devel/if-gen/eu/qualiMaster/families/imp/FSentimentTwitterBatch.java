package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FSentimentTwitterBatch implements IFSentimentTwitterBatch {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFSentimentTwitterBatchInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentTwitterBatchInput implements IFSentimentTwitterBatch.IIFSentimentTwitterBatchInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFSentimentTwitterBatchOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentTwitterBatchOutput implements IFSentimentTwitterBatch.IIFSentimentTwitterBatchOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFSentimentTwitterBatchInput input, IIFSentimentTwitterBatchOutput result) {
    }

}
