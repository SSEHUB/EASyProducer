package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FNormalize implements IFNormalize {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFNormalizeInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFNormalizeInput implements IFNormalize.IIFNormalizeInput {

        private String springData;

        @Override
        public String getSpringData() {
            return springData;
        }

        @Override
        public void setSpringData(String springData) {
            this.springData = springData;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFNormalizeOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFNormalizeOutput implements IFNormalize.IIFNormalizeOutput {

        private String streamID;
        private String timestamp;
        private double quote;
        private int volume;

        @Override
        public String getStreamID() {
            return streamID;
        }

        @Override
        public void setStreamID(String streamID) {
            this.streamID = streamID;
        }
        @Override
        public String getTimestamp() {
            return timestamp;
        }

        @Override
        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
        @Override
        public double getQuote() {
            return quote;
        }

        @Override
        public void setQuote(double quote) {
            this.quote = quote;
        }
        @Override
        public int getVolume() {
            return volume;
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
        }
    }

    // algorithm parameters

    /**
     * Sets the algorithm parameter "test".
     *
     * @param value the new value of the algorithm parameter
     */

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFNormalizeInput input, IIFNormalizeOutput result) {
    }

}
