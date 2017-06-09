package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFSpamDetection" (GEN).
 */
public class FSpamDetection implements IFSpamDetection {

    /**
     * Provides a default implementation of the data input for the {@link IFSpamDetectionTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSpamDetectionTwitterStreamInput implements IIFSpamDetectionTwitterStreamInput {

        private eu.qualimaster.data.stream.source.LabelledTweet status;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFSpamDetectionTwitterStreamInput", FSpamDetectionSerializers.IFSpamDetectionTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFSpamDetectionTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSpamDetectionTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFSpamDetectionTwitterStreamOutput> implements IIFSpamDetectionTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFSpamDetectionTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFSpamDetectionTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFSpamDetectionTwitterStreamOutput createItem() {
            return new IFSpamDetectionTwitterStreamOutput(false);
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
        private eu.qualimaster.data.stream.source.LabelledTweet status;
        private double spamPropability;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        @Override
        public double getSpamPropability(){
            return spamPropability;
        }

        @Override
        public void setSpamPropability(double spamPropability){
            this.spamPropability = spamPropability;
        }
        static {
            SerializerRegistry.register("IFSpamDetectionTwitterStreamOutput", FSpamDetectionSerializers.IFSpamDetectionTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSpamDetectionTwitterStreamInput input, IIFSpamDetectionTwitterStreamOutput twitterStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
