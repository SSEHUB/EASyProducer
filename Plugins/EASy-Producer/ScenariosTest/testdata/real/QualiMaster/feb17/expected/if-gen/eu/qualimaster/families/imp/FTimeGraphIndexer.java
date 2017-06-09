package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTimeGraphIndexer" (GEN).
 */
public class FTimeGraphIndexer implements IFTimeGraphIndexer {

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphIndexerDataStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerDataStreamInput implements IIFTimeGraphIndexerDataStreamInput {

        private Object update;
        private boolean isAddition;

        @Override
        public Object getUpdate(){
            return update;
        }

        @Override
        public void setUpdate(Object update){
            this.update = update;
        }
        @Override
        public boolean getIsAddition(){
            return isAddition;
        }

        @Override
        public void setIsAddition(boolean isAddition){
            this.isAddition = isAddition;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerDataStreamInput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerDataStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphIndexerInternalRequestsInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerInternalRequestsInput implements IIFTimeGraphIndexerInternalRequestsInput {

        private Object internalRequest;

        @Override
        public Object getInternalRequest(){
            return internalRequest;
        }

        @Override
        public void setInternalRequest(Object internalRequest){
            this.internalRequest = internalRequest;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerInternalRequestsInput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerInternalRequestsInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphIndexerUnicastRequestsInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerUnicastRequestsInput implements IIFTimeGraphIndexerUnicastRequestsInput {

        private Object unicastExternalRequest;

        @Override
        public Object getUnicastExternalRequest(){
            return unicastExternalRequest;
        }

        @Override
        public void setUnicastExternalRequest(Object unicastExternalRequest){
            this.unicastExternalRequest = unicastExternalRequest;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerUnicastRequestsInput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerUnicastRequestsInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphIndexerBroadcastRequestsInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerBroadcastRequestsInput implements IIFTimeGraphIndexerBroadcastRequestsInput {

        private Object broadcastExternalRequest;

        @Override
        public Object getBroadcastExternalRequest(){
            return broadcastExternalRequest;
        }

        @Override
        public void setBroadcastExternalRequest(Object broadcastExternalRequest){
            this.broadcastExternalRequest = broadcastExternalRequest;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerBroadcastRequestsInput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerBroadcastRequestsInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphIndexerExternalResponsesOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerExternalResponsesOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphIndexerExternalResponsesOutput> implements IIFTimeGraphIndexerExternalResponsesOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphIndexerExternalResponsesOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphIndexerExternalResponsesOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphIndexerExternalResponsesOutput createItem() {
            return new IFTimeGraphIndexerExternalResponsesOutput(false);
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
        private Object externalResponse;

        @Override
        public Object getExternalResponse(){
            return externalResponse;
        }

        @Override
        public void setExternalResponse(Object externalResponse){
            this.externalResponse = externalResponse;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerExternalResponsesOutput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerExternalResponsesOutputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphIndexerInternalRequestsOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphIndexerInternalRequestsOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphIndexerInternalRequestsOutput> implements IIFTimeGraphIndexerInternalRequestsOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphIndexerInternalRequestsOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphIndexerInternalRequestsOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphIndexerInternalRequestsOutput createItem() {
            return new IFTimeGraphIndexerInternalRequestsOutput(false);
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
        private Object internalRequest;

        @Override
        public Object getInternalRequest(){
            return internalRequest;
        }

        @Override
        public void setInternalRequest(Object internalRequest){
            this.internalRequest = internalRequest;
        }
        static {
            SerializerRegistry.register("IFTimeGraphIndexerInternalRequestsOutput", FTimeGraphIndexerSerializers.IFTimeGraphIndexerInternalRequestsOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerDataStreamInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerInternalRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerUnicastRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerBroadcastRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
