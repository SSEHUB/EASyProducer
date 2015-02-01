package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FAdd10 implements IFAdd10 {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFAdd10Input} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFAdd10Input implements IFAdd10.IIFAdd10Input {

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

    /**
     * Provides a default implementation of the data output for the {@link IFAdd10Output} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFAdd10Output implements IFAdd10.IIFAdd10Output {

        private double valuePlus10;

        @Override
        public double getValuePlus10() {
            return valuePlus10;
        }

        @Override
        public void setValuePlus10(double valuePlus10) {
            this.valuePlus10 = valuePlus10;
        }
    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFAdd10Input input, IIFAdd10Output result) {
    }

}
