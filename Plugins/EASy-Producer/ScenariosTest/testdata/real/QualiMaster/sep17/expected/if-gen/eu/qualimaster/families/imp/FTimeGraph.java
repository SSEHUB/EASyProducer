package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTimeGraph" (GEN).
 */
public class FTimeGraph implements IFTimeGraph {

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphDataStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphDataStreamInput implements IIFTimeGraphDataStreamInput {

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
            SerializerRegistry.register("IFTimeGraphDataStreamInput", FTimeGraphSerializers.IFTimeGraphDataStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphSnapshotQueryStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphSnapshotQueryStreamInput implements IIFTimeGraphSnapshotQueryStreamInput {

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
            SerializerRegistry.register("IFTimeGraphSnapshotQueryStreamInput", FTimeGraphSerializers.IFTimeGraphSnapshotQueryStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphPathQueryStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphPathQueryStreamInput implements IIFTimeGraphPathQueryStreamInput {

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
            SerializerRegistry.register("IFTimeGraphPathQueryStreamInput", FTimeGraphSerializers.IFTimeGraphPathQueryStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphSnapshotStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphSnapshotStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphSnapshotStreamOutput> implements IIFTimeGraphSnapshotStreamOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphSnapshotStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphSnapshotStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphSnapshotStreamOutput createItem() {
            return new IFTimeGraphSnapshotStreamOutput(false);
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
            SerializerRegistry.register("IFTimeGraphSnapshotStreamOutput", FTimeGraphSerializers.IFTimeGraphSnapshotStreamOutputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphPathStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphPathStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphPathStreamOutput> implements IIFTimeGraphPathStreamOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphPathStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphPathStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphPathStreamOutput createItem() {
            return new IFTimeGraphPathStreamOutput(false);
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
            SerializerRegistry.register("IFTimeGraphPathStreamOutput", FTimeGraphSerializers.IFTimeGraphPathStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphDataStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphSnapshotQueryStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphPathQueryStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
