package eu.qualimaster.families.imp;

import java.io.Serializable;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;

/**
 * The implementation for the algorithm family "IFCorrelationFinancial" (GEN).
 */
public class FCorrelationFinancial implements IFCorrelationFinancial {

    /**
     * Provides a default implementation of the data input for the {@link IFCorrelationFinancial1Input} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationFinancial1Input implements IIFCorrelationFinancial1Input {

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
     * Provides a default implementation of the data input for the {@link IFCorrelationFinancial2Input} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationFinancial2Input implements IIFCorrelationFinancial2Input {

        private static final long serialVersionUID = 1L;
        private java.util.List<String> allSymbols;

        @Override
        public java.util.List<String> getAllSymbols(){
            return allSymbols;
        }

        @Override
        public void setAllSymbols(java.util.List<String> allSymbols){
            this.allSymbols = allSymbols;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFCorrelationFinancialOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationFinancialOutput implements IIFCorrelationFinancialOutput {

        private static final long serialVersionUID = 1L;
        private String pairwiseCorrelationFinancial;

        @Override
        public String getPairwiseCorrelationFinancial(){
            return pairwiseCorrelationFinancial;
        }

        @Override
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial){
            this.pairwiseCorrelationFinancial = pairwiseCorrelationFinancial;
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationFinancial1Input input, IIFCorrelationFinancialOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationFinancial2Input input, IIFCorrelationFinancialOutput result){
    }

    // algorithm parameters

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
