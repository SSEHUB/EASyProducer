package eu.qualimaster.families.imp;

import java.io.Serializable;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;

/**
 * The implementation for the algorithm family "IFMismatchedFamily" (GEN).
 */
public class FMismatchedFamily implements IFMismatchedFamily {

    /**
     * Provides a default implementation of the data input for the {@link IFMismatchedFamilyInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMismatchedFamilyInput implements IIFMismatchedFamilyInput {

        private static final long serialVersionUID = 1L;
        private String symbolTuple1;
        private int volume;

        @Override
        public String getSymbolTuple1(){
            return symbolTuple1;
        }

        @Override
        public void setSymbolTuple1(String symbolTuple1){
            this.symbolTuple1 = symbolTuple1;
        }
        @Override
        public int getVolume(){
            return volume;
        }

        @Override
        public void setVolume(int volume){
            this.volume = volume;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFMismatchedFamilyOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMismatchedFamilyOutput implements IIFMismatchedFamilyOutput {

        private static final long serialVersionUID = 1L;
        private String streamID1;
        private int timestamp;
        private double quote;

        @Override
        public String getStreamID1(){
            return streamID1;
        }

        @Override
        public void setStreamID1(String streamID1){
            this.streamID1 = streamID1;
        }
        @Override
        public int getTimestamp(){
            return timestamp;
        }

        @Override
        public void setTimestamp(int timestamp){
            this.timestamp = timestamp;
        }
        @Override
        public double getQuote(){
            return quote;
        }

        @Override
        public void setQuote(double quote){
            this.quote = quote;
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFMismatchedFamilyInput input, IIFMismatchedFamilyOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
