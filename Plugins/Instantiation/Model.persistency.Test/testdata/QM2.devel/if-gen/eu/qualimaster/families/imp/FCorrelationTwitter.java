package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFCorrelationTwitter" (GEN).
 */
public class FCorrelationTwitter implements IFCorrelationTwitter {

    /**
     * Provides a default implementation of the data input for the {@link IFCorrelationTwitterAnalyzedStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationTwitterAnalyzedStreamInput implements IIFCorrelationTwitterAnalyzedStreamInput {

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
        static {
            SerializerRegistry.register("IFCorrelationTwitterAnalyzedStreamInput", FCorrelationTwitterSerializers.IFCorrelationTwitterAnalyzedStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFCorrelationTwitterSymbolListInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationTwitterSymbolListInput implements IIFCorrelationTwitterSymbolListInput {

        private java.util.List<String> allSymbols;

        @Override
        public java.util.List<String> getAllSymbols(){
            return allSymbols;
        }

        @Override
        public void setAllSymbols(java.util.List<String> allSymbols){
            this.allSymbols = allSymbols;
        }
        static {
            SerializerRegistry.register("IFCorrelationTwitterSymbolListInput", FCorrelationTwitterSerializers.IFCorrelationTwitterSymbolListInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFCorrelationTwitterPairwiseTwitterOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationTwitterPairwiseTwitterOutput implements IIFCorrelationTwitterPairwiseTwitterOutput {

        private String pairwiseCorrelationTwitter;

        @Override
        public String getPairwiseCorrelationTwitter(){
            return pairwiseCorrelationTwitter;
        }

        @Override
        public void setPairwiseCorrelationTwitter(String pairwiseCorrelationTwitter){
            this.pairwiseCorrelationTwitter = pairwiseCorrelationTwitter;
        }
        static {
            SerializerRegistry.register("IFCorrelationTwitterPairwiseTwitterOutput", FCorrelationTwitterSerializers.IFCorrelationTwitterPairwiseTwitterOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationTwitterAnalyzedStreamInput input, IIFCorrelationTwitterPairwiseTwitterOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationTwitterSymbolListInput input, IIFCorrelationTwitterPairwiseTwitterOutput result){
    }


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
