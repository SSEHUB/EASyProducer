package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FSentimentTwitterStream implements IFSentimentTwitterStream {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFSentimentTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentTwitterStreamInput implements IFSentimentTwitterStream.IIFSentimentTwitterStreamInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFSentimentTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentTwitterStreamOutput implements IFSentimentTwitterStream.IIFSentimentTwitterStreamOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFSentimentTwitterStreamInput input, IIFSentimentTwitterStreamOutput result) {
    }

}
