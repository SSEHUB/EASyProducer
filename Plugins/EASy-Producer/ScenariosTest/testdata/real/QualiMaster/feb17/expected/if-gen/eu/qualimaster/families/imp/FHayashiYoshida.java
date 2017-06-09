package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFHayashiYoshida" (GEN).
 */
public class FHayashiYoshida implements IFHayashiYoshida {

    /**
     * Provides a default implementation of the data input for the {@link IFHayashiYoshidaSymbolsStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFHayashiYoshidaSymbolsStreamInput implements IIFHayashiYoshidaSymbolsStreamInput {

        private String symbolId;
        private long timestamp;
        private double value;

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
        static {
            SerializerRegistry.register("IFHayashiYoshidaSymbolsStreamInput", FHayashiYoshidaSerializers.IFHayashiYoshidaSymbolsStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFHayashiYoshidaConfigurationStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFHayashiYoshidaConfigurationStreamInput implements IIFHayashiYoshidaConfigurationStreamInput {

        private String pairKey;
        private String pairValue;

        @Override
        public String getPairKey(){
            return pairKey;
        }

        @Override
        public void setPairKey(String pairKey){
            this.pairKey = pairKey;
        }
        @Override
        public String getPairValue(){
            return pairValue;
        }

        @Override
        public void setPairValue(String pairValue){
            this.pairValue = pairValue;
        }
        static {
            SerializerRegistry.register("IFHayashiYoshidaConfigurationStreamInput", FHayashiYoshidaSerializers.IFHayashiYoshidaConfigurationStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFHayashiYoshidaResetWindowStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFHayashiYoshidaResetWindowStreamInput implements IIFHayashiYoshidaResetWindowStreamInput {

        private long windowStart;

        @Override
        public long getWindowStart(){
            return windowStart;
        }

        @Override
        public void setWindowStart(long windowStart){
            this.windowStart = windowStart;
        }
        static {
            SerializerRegistry.register("IFHayashiYoshidaResetWindowStreamInput", FHayashiYoshidaSerializers.IFHayashiYoshidaResetWindowStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFHayashiYoshidaPairwiseFinancialOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFHayashiYoshidaPairwiseFinancialOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFHayashiYoshidaPairwiseFinancialOutput> implements IIFHayashiYoshidaPairwiseFinancialOutput {

        /**
         * Creates the item.
         */
        public IFHayashiYoshidaPairwiseFinancialOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFHayashiYoshidaPairwiseFinancialOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFHayashiYoshidaPairwiseFinancialOutput createItem() {
            return new IFHayashiYoshidaPairwiseFinancialOutput(false);
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
            SerializerRegistry.register("IFHayashiYoshidaPairwiseFinancialOutput", FHayashiYoshidaSerializers.IFHayashiYoshidaPairwiseFinancialOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaSymbolsStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaConfigurationStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaResetWindowStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
