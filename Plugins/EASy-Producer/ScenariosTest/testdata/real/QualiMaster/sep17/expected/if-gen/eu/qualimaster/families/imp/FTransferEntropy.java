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
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
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
        public IFTransferEntropyPairwiseFinancialOutput createItem() {
            return new IFTransferEntropyPairwiseFinancialOutput(false);
        }
        @Override
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public int getTaskId() {
            return taskId;
        }
        private transient int taskId;
        private String id0;
        private String id1;
        private String date;
        private double value;

        @Override
        public String getId0(){
            return id0;
        }

        @Override
        public void setId0(String id0){
            this.id0 = id0;
        }
        @Override
        public String getId1(){
            return id1;
        }

        @Override
        public void setId1(String id1){
            this.id1 = id1;
        }
        @Override
        public String getDate(){
            return date;
        }

        @Override
        public void setDate(String date){
            this.date = date;
        }
        @Override
        public double getValue(){
            return value;
        }

        @Override
        public void setValue(double value){
            this.value = value;
        }
        static {
            SerializerRegistry.register("IFTransferEntropyPairwiseFinancialOutput", FTransferEntropySerializers.IFTransferEntropyPairwiseFinancialOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTransferEntropyPreprocessedStreamInput input, IIFTransferEntropyPairwiseFinancialOutput pairwiseFinancialResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTransferEntropySymbolListInput input, IIFTransferEntropyPairwiseFinancialOutput pairwiseFinancialResult) {
    }

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
    }

    /**
     * Sets the algorithm parameter "windowAdvance".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowAdvance(int value) {
    }

    /**
     * Sets the algorithm parameter "densitySize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDensitySize(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
