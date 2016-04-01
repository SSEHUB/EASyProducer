package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTwitterEventDetection" (GEN).
 */
public class FTwitterEventDetection implements IFTwitterEventDetection {

    /**
     * Provides a default implementation of the data input for the {@link IFTwitterEventDetectionTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterEventDetectionTwitterStreamInput implements IIFTwitterEventDetectionTwitterStreamInput {

        private Object status;
        private Object stocks;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        @Override
        public Object getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(Object stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFTwitterEventDetectionTwitterStreamInput", FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTwitterEventDetectionTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterEventDetectionTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTwitterEventDetectionTwitterStreamOutput> implements IIFTwitterEventDetectionTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFTwitterEventDetectionTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTwitterEventDetectionTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFTwitterEventDetectionTwitterStreamOutput createItem() {
            return new IFTwitterEventDetectionTwitterStreamOutput(false);
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
            SerializerRegistry.register("IFTwitterEventDetectionTwitterStreamOutput", FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTwitterEventDetectionTwitterStreamInput input, IIFTwitterEventDetectionTwitterStreamOutput result){
    }


    /**
     * Sets the algorithm parameter "hardThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterHardThreshold(int value) {
    }

    /**
     * Sets the algorithm parameter "percentageThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterPercentageThreshold(double value) {
    }

    /**
     * Sets the algorithm parameter "lengthOfTimeWindow".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterLengthOfTimeWindow(int value) {
    }

    /**
     * Sets the algorithm parameter "frequenceOfCheckForEvent".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFrequenceOfCheckForEvent(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
