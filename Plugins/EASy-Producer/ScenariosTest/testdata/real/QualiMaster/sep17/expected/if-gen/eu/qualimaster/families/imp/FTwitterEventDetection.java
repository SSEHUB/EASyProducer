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

        private eu.qualimaster.data.stream.source.LabelledTweet status;
        private java.util.List<String> stocks;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        @Override
        public java.util.List<String> getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(java.util.List<String> stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFTwitterEventDetectionTwitterStreamInput", FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamInputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
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
        public IFTwitterEventDetectionTwitterStreamOutput createItem() {
            return new IFTwitterEventDetectionTwitterStreamOutput(false);
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
        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;
        private eu.qualimaster.data.stream.source.LabelledTweet status;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFTwitterEventDetectionTwitterStreamOutput", FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterEventDetectionTwitterStreamInput input, IIFTwitterEventDetectionTwitterStreamOutput twitterStreamResult) {
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
