package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFMismatchedFamily" (GEN).
 */
public class FMismatchedFamily implements IFMismatchedFamily {

    /**
     * Provides a default implementation of the data input for the {@link IFMismatchedFamilyMisStringInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMismatchedFamilyMisStringInput implements IIFMismatchedFamilyMisStringInput {

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
        static {
            SerializerRegistry.register("IFMismatchedFamilyMisStringInput", FMismatchedFamilySerializers.IFMismatchedFamilyMisStringInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFMismatchedFamilyMisStringOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFMismatchedFamilyMisStringOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFMismatchedFamilyMisStringOutput> implements IIFMismatchedFamilyMisStringOutput {

        /**
         * Creates the item.
         */
        public IFMismatchedFamilyMisStringOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFMismatchedFamilyMisStringOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFMismatchedFamilyMisStringOutput createItem() {
            return new IFMismatchedFamilyMisStringOutput(false);
        }
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
        static {
            SerializerRegistry.register("IFMismatchedFamilyMisStringOutput", FMismatchedFamilySerializers.IFMismatchedFamilyMisStringOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFMismatchedFamilyMisStringInput input, IIFMismatchedFamilyMisStringOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
