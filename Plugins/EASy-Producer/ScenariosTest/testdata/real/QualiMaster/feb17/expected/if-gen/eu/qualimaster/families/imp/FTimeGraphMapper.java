package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTimeGraphMapper" (GEN).
 */
public class FTimeGraphMapper implements IFTimeGraphMapper {

    /**
     * Provides a default implementation of the data input for the {@link IFTimeGraphMapperEdgeStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphMapperEdgeStreamInput implements IIFTimeGraphMapperEdgeStreamInput {

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
            SerializerRegistry.register("IFTimeGraphMapperEdgeStreamInput", FTimeGraphMapperSerializers.IFTimeGraphMapperEdgeStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTimeGraphMapperDataStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTimeGraphMapperDataStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTimeGraphMapperDataStreamOutput> implements IIFTimeGraphMapperDataStreamOutput {

        /**
         * Creates the item.
         */
        public IFTimeGraphMapperDataStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTimeGraphMapperDataStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTimeGraphMapperDataStreamOutput createItem() {
            return new IFTimeGraphMapperDataStreamOutput(false);
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
            SerializerRegistry.register("IFTimeGraphMapperDataStreamOutput", FTimeGraphMapperSerializers.IFTimeGraphMapperDataStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphMapperEdgeStreamInput input, IIFTimeGraphMapperDataStreamOutput dataStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
