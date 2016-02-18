package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTransferEntropy" (GEN).
 */
public class FTransferEntropy implements IFTransferEntropy {

    /**
     * Provides a default implementation of the data input for the {@link IFTransferEntropyPreprocessedStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTransferEntropyPreprocessedStreamInput implements IIFTransferEntropyPreprocessedStreamInput {

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
            SerializerRegistry.register("IFTransferEntropyPreprocessedStreamInput", FTransferEntropySerializers.IFTransferEntropyPreprocessedStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTransferEntropySymbolListInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTransferEntropySymbolListInput implements IIFTransferEntropySymbolListInput {

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
            SerializerRegistry.register("IFTransferEntropySymbolListInput", FTransferEntropySerializers.IFTransferEntropySymbolListInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTransferEntropyPairwiseFinancialOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTransferEntropyPairwiseFinancialOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTransferEntropyPairwiseFinancialOutput> implements IIFTransferEntropyPairwiseFinancialOutput {

        /**
         * Creates the item.
         */
        public IFTransferEntropyPairwiseFinancialOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTransferEntropyPairwiseFinancialOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFTransferEntropyPairwiseFinancialOutput createItem() {
            return new IFTransferEntropyPairwiseFinancialOutput(false);
        }
        private String pairwiseCorrelationFinancial;

        @Override
        public String getPairwiseCorrelationFinancial(){
            return pairwiseCorrelationFinancial;
        }

        @Override
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial){
            this.pairwiseCorrelationFinancial = pairwiseCorrelationFinancial;
        }
        static {
            SerializerRegistry.register("IFTransferEntropyPairwiseFinancialOutput", FTransferEntropySerializers.IFTransferEntropyPairwiseFinancialOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTransferEntropyPreprocessedStreamInput input, IIFTransferEntropyPairwiseFinancialOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTransferEntropySymbolListInput input, IIFTransferEntropyPairwiseFinancialOutput result){
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
