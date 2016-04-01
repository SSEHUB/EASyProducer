package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFKeywordAnalyzer" (GEN).
 */
public class FKeywordAnalyzer implements IFKeywordAnalyzer {

    /**
     * Provides a default implementation of the data input for the {@link IFKeywordAnalyzerTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFKeywordAnalyzerTwitterStreamInput implements IIFKeywordAnalyzerTwitterStreamInput {

        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;
        private Object status;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFKeywordAnalyzerTwitterStreamInput", FKeywordAnalyzerSerializers.IFKeywordAnalyzerTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFKeywordAnalyzerTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFKeywordAnalyzerTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFKeywordAnalyzerTwitterStreamOutput> implements IIFKeywordAnalyzerTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFKeywordAnalyzerTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFKeywordAnalyzerTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFKeywordAnalyzerTwitterStreamOutput createItem() {
            return new IFKeywordAnalyzerTwitterStreamOutput(false);
        }
        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;
        private Object status;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFKeywordAnalyzerTwitterStreamOutput", FKeywordAnalyzerSerializers.IFKeywordAnalyzerTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFKeywordAnalyzerTwitterStreamInput input, IIFKeywordAnalyzerTwitterStreamOutput result){
    }


    /**
     * Sets the algorithm parameter "threshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterThreshold(double value) {
    }

    /**
     * Sets the algorithm parameter "decay".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDecay(double value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
