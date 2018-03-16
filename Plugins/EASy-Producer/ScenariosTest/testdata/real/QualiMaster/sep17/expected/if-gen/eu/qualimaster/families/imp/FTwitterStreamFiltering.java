package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTwitterStreamFiltering" (GEN).
 */
public class FTwitterStreamFiltering implements IFTwitterStreamFiltering {

    /**
     * Provides a default implementation of the data input for the {@link IFTwitterStreamFilteringAnalysisInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamFilteringAnalysisInput implements IIFTwitterStreamFilteringAnalysisInput {

        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFTwitterStreamFilteringAnalysisInput", FTwitterStreamFilteringSerializers.IFTwitterStreamFilteringAnalysisInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTwitterStreamFilteringAnalysisOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamFilteringAnalysisOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTwitterStreamFilteringAnalysisOutput> implements IIFTwitterStreamFilteringAnalysisOutput {

        /**
         * Creates the item.
         */
        public IFTwitterStreamFilteringAnalysisOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTwitterStreamFilteringAnalysisOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTwitterStreamFilteringAnalysisOutput createItem() {
            return new IFTwitterStreamFilteringAnalysisOutput(false);
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
        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFTwitterStreamFilteringAnalysisOutput", FTwitterStreamFilteringSerializers.IFTwitterStreamFilteringAnalysisOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterStreamFilteringAnalysisInput input, IIFTwitterStreamFilteringAnalysisOutput analysisResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
