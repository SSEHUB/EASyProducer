package eu.qualimaster.families.imp;

import java.io.Serializable;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;

/**
 * The implementation for the algorithm family "IFPreprocessor" (GEN).
 */
public class FPreprocessor implements IFPreprocessor {

    /**
     * Provides a default implementation of the data input for the {@link IFPreprocessorInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFPreprocessorInput implements IIFPreprocessorInput {

        private static final long serialVersionUID = 1L;
        private String symbolTuple;

        @Override
        public String getSymbolTuple(){
            return symbolTuple;
        }

        @Override
        public void setSymbolTuple(String symbolTuple){
            this.symbolTuple = symbolTuple;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFPreprocessorOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFPreprocessorOutput implements IIFPreprocessorOutput {

        private static final long serialVersionUID = 1L;
        private String symbolId;
        private long timestamp;
        private double value;
        private int volume;

        @Override
        public String getSymbolId(){
            return symbolId;
        }

        @Override
        public void setSymbolId(String symbolId){
            this.symbolId = symbolId;
        }
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        @Override
        public double getValue(){
            return value;
        }

        @Override
        public void setValue(double value){
            this.value = value;
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
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFPreprocessorInput input, IIFPreprocessorOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
