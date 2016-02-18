package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFPreprocessor" (GEN).
 */
public class FPreprocessor implements IFPreprocessor {

    /**
     * Provides a default implementation of the data input for the {@link IFPreprocessorSpringStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFPreprocessorSpringStreamInput implements IIFPreprocessorSpringStreamInput {

        private String symbolTuple;

        @Override
        public String getSymbolTuple(){
            return symbolTuple;
        }

        @Override
        public void setSymbolTuple(String symbolTuple){
            this.symbolTuple = symbolTuple;
        }
        static {
            SerializerRegistry.register("IFPreprocessorSpringStreamInput", FPreprocessorSerializers.IFPreprocessorSpringStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFPreprocessorPreprocessedStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFPreprocessorPreprocessedStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFPreprocessorPreprocessedStreamOutput> implements IIFPreprocessorPreprocessedStreamOutput {

        /**
         * Creates the item.
         */
        public IFPreprocessorPreprocessedStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFPreprocessorPreprocessedStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFPreprocessorPreprocessedStreamOutput createItem() {
            return new IFPreprocessorPreprocessedStreamOutput(false);
        }
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
            SerializerRegistry.register("IFPreprocessorPreprocessedStreamOutput", FPreprocessorSerializers.IFPreprocessorPreprocessedStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFPreprocessorSpringStreamInput input, IIFPreprocessorPreprocessedStreamOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
