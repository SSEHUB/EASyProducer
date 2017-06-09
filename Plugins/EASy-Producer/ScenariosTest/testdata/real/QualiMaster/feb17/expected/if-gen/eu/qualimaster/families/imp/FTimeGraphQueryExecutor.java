package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTimeGraphQueryExecutor" (GEN).
 */
public class FTimeGraphQueryExecutor implements IFTimeGraphQueryExecutor {

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphQueryExecutorSnapshotQueryStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorSnapshotQueryStreamInput implements IIFTimeGraphQueryExecutorSnapshotQueryStreamInput {

        private long start;
        private long end;

        @Override
        public long getStart(){
            return start;
        }

        @Override
        public void setStart(long start){
            this.start = start;
        }
        @Override
        public long getEnd(){
            return end;
        }

        @Override
        public void setEnd(long end){
            this.end = end;
        }
        static {
            SerializerRegistry.register("IFTimeGraphQueryExecutorSnapshotQueryStreamInput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorSnapshotQueryStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphQueryExecutorPathQueryStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorPathQueryStreamInput implements IIFTimeGraphQueryExecutorPathQueryStreamInput {

        private long start;
        private long end;
        private String vertexA;
        private String vertexB;
        private String type;

        @Override
        public long getStart(){
            return start;
        }

        @Override
        public void setStart(long start){
            this.start = start;
        }
        @Override
        public long getEnd(){
            return end;
        }

        @Override
        public void setEnd(long end){
            this.end = end;
        }
        @Override
        public String getVertexA(){
            return vertexA;
        }

        @Override
        public void setVertexA(String vertexA){
            this.vertexA = vertexA;
        }
        @Override
        public String getVertexB(){
            return vertexB;
        }

        @Override
        public void setVertexB(String vertexB){
            this.vertexB = vertexB;
        }
        @Override
        public String getType(){
            return type;
        }

        @Override
        public void setType(String type){
            this.type = type;
        }
        static {
            SerializerRegistry.register("IFTimeGraphQueryExecutorPathQueryStreamInput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorPathQueryStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphQueryExecutorExternalResponsesInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorExternalResponsesInput implements IIFTimeGraphQueryExecutorExternalResponsesInput {

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
            SerializerRegistry.register("IFTimeGraphQueryExecutorExternalResponsesInput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorExternalResponsesInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphQueryExecutorSnapshotStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorSnapshotStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphQueryExecutorSnapshotStreamOutput> implements IIFTimeGraphQueryExecutorSnapshotStreamOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphQueryExecutorSnapshotStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphQueryExecutorSnapshotStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphQueryExecutorSnapshotStreamOutput createItem() {
            return new IFTimeGraphQueryExecutorSnapshotStreamOutput(false);
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
        private String snapshot;

        @Override
        public String getSnapshot(){
            return snapshot;
        }

        @Override
        public void setSnapshot(String snapshot){
            this.snapshot = snapshot;
        }
        static {
            SerializerRegistry.register("IFTimeGraphQueryExecutorSnapshotStreamOutput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorSnapshotStreamOutputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphQueryExecutorPathStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorPathStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphQueryExecutorPathStreamOutput> implements IIFTimeGraphQueryExecutorPathStreamOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphQueryExecutorPathStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphQueryExecutorPathStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphQueryExecutorPathStreamOutput createItem() {
            return new IFTimeGraphQueryExecutorPathStreamOutput(false);
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
        private String path;

        @Override
        public String getPath(){
            return path;
        }

        @Override
        public void setPath(String path){
            this.path = path;
        }
        static {
            SerializerRegistry.register("IFTimeGraphQueryExecutorPathStreamOutput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorPathStreamOutputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphQueryExecutorUnicastRequestsOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorUnicastRequestsOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphQueryExecutorUnicastRequestsOutput> implements IIFTimeGraphQueryExecutorUnicastRequestsOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphQueryExecutorUnicastRequestsOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphQueryExecutorUnicastRequestsOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphQueryExecutorUnicastRequestsOutput createItem() {
            return new IFTimeGraphQueryExecutorUnicastRequestsOutput(false);
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
            SerializerRegistry.register("IFTimeGraphQueryExecutorUnicastRequestsOutput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorUnicastRequestsOutputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphQueryExecutorBroadcastRequestsOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphQueryExecutorBroadcastRequestsOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphQueryExecutorBroadcastRequestsOutput> implements IIFTimeGraphQueryExecutorBroadcastRequestsOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphQueryExecutorBroadcastRequestsOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphQueryExecutorBroadcastRequestsOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphQueryExecutorBroadcastRequestsOutput createItem() {
            return new IFTimeGraphQueryExecutorBroadcastRequestsOutput(false);
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
            SerializerRegistry.register("IFTimeGraphQueryExecutorBroadcastRequestsOutput", FTimeGraphQueryExecutorSerializers.IFTimeGraphQueryExecutorBroadcastRequestsOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorSnapshotQueryStreamInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorPathQueryStreamInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorExternalResponsesInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
