package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFMapper" (GEN).
 */
public class FMapper implements IFMapper {

    /**
     * Provides a default implementation of the data input for the {@link IFMapperPreprocessedStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMapperPreprocessedStreamInput implements IIFMapperPreprocessedStreamInput {

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
            SerializerRegistry.register("IFMapperPreprocessedStreamInput", FMapperSerializers.IFMapperPreprocessedStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFMapperSymbolListInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMapperSymbolListInput implements IIFMapperSymbolListInput {

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
            SerializerRegistry.register("IFMapperSymbolListInput", FMapperSerializers.IFMapperSymbolListInputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFMapperSymbolsStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMapperSymbolsStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFMapperSymbolsStreamOutput> implements IIFMapperSymbolsStreamOutput {

        /**
         * Creates the item.
         */
        public IFMapperSymbolsStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFMapperSymbolsStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFMapperSymbolsStreamOutput createItem() {
            return new IFMapperSymbolsStreamOutput(false);
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
            SerializerRegistry.register("IFMapperSymbolsStreamOutput", FMapperSerializers.IFMapperSymbolsStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFMapperConfigurationStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMapperConfigurationStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFMapperConfigurationStreamOutput> implements IIFMapperConfigurationStreamOutput {

        /**
         * Creates the item.
         */
        public IFMapperConfigurationStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFMapperConfigurationStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFMapperConfigurationStreamOutput createItem() {
            return new IFMapperConfigurationStreamOutput(false);
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
            SerializerRegistry.register("IFMapperConfigurationStreamOutput", FMapperSerializers.IFMapperConfigurationStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFMapperResetWindowStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMapperResetWindowStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFMapperResetWindowStreamOutput> implements IIFMapperResetWindowStreamOutput {

        /**
         * Creates the item.
         */
        public IFMapperResetWindowStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFMapperResetWindowStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFMapperResetWindowStreamOutput createItem() {
            return new IFMapperResetWindowStreamOutput(false);
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
            SerializerRegistry.register("IFMapperResetWindowStreamOutput", FMapperSerializers.IFMapperResetWindowStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFMapperPreprocessedStreamInput input, IIFMapperSymbolsStreamOutput symbolsStreamResult, IIFMapperConfigurationStreamOutput configurationStreamResult, IIFMapperResetWindowStreamOutput resetWindowStreamResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFMapperSymbolListInput input, IIFMapperSymbolsStreamOutput symbolsStreamResult, IIFMapperConfigurationStreamOutput configurationStreamResult, IIFMapperResetWindowStreamOutput resetWindowStreamResult) {
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
