package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFDynamicGraphCompilation" (GEN).
 */
public class FDynamicGraphCompilation implements IFDynamicGraphCompilation {

    /**
     * Provides a default implementation of the data input for the {@link IFDynamicGraphCompilationPairwiseFinancialInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDynamicGraphCompilationPairwiseFinancialInput implements IIFDynamicGraphCompilationPairwiseFinancialInput {

        private String id0;
        private String id1;
        private String date;
        private double value;

        @Override
        public String getId0(){
            return id0;
        }

        @Override
        public void setId0(String id0){
            this.id0 = id0;
        }
        @Override
        public String getId1(){
            return id1;
        }

        @Override
        public void setId1(String id1){
            this.id1 = id1;
        }
        @Override
        public String getDate(){
            return date;
        }

        @Override
        public void setDate(String date){
            this.date = date;
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
            SerializerRegistry.register("IFDynamicGraphCompilationPairwiseFinancialInput", FDynamicGraphCompilationSerializers.IFDynamicGraphCompilationPairwiseFinancialInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFDynamicGraphCompilationEdgeStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDynamicGraphCompilationEdgeStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFDynamicGraphCompilationEdgeStreamOutput> implements IIFDynamicGraphCompilationEdgeStreamOutput {

        /**
         * Creates the item.
         */
        public IFDynamicGraphCompilationEdgeStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFDynamicGraphCompilationEdgeStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFDynamicGraphCompilationEdgeStreamOutput createItem() {
            return new IFDynamicGraphCompilationEdgeStreamOutput(false);
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
        private String edge;

        @Override
        public String getEdge(){
            return edge;
        }

        @Override
        public void setEdge(String edge){
            this.edge = edge;
        }
        static {
            SerializerRegistry.register("IFDynamicGraphCompilationEdgeStreamOutput", FDynamicGraphCompilationSerializers.IFDynamicGraphCompilationEdgeStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFDynamicGraphCompilationPairwiseFinancialInput input, IIFDynamicGraphCompilationEdgeStreamOutput edgeStreamResult) {
    }

    /**
     * Sets the algorithm parameter "correlationThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterCorrelationThreshold(double value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
