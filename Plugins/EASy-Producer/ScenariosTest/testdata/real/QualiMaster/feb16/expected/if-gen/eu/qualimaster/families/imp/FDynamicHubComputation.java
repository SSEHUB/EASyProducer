package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFDynamicHubComputation" (GEN).
 */
public class FDynamicHubComputation implements IFDynamicHubComputation {

    /**
     * Provides a default implementation of the data input for the {@link IFDynamicHubComputationEdgeStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDynamicHubComputationEdgeStreamInput implements IIFDynamicHubComputationEdgeStreamInput {

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
            SerializerRegistry.register("IFDynamicHubComputationEdgeStreamInput", FDynamicHubComputationSerializers.IFDynamicHubComputationEdgeStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFDynamicHubComputationHubStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDynamicHubComputationHubStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFDynamicHubComputationHubStreamOutput> implements IIFDynamicHubComputationHubStreamOutput {

        /**
         * Creates the item.
         */
        public IFDynamicHubComputationHubStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFDynamicHubComputationHubStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFDynamicHubComputationHubStreamOutput createItem() {
            return new IFDynamicHubComputationHubStreamOutput(false);
        }
        private String hubList;

        @Override
        public String getHubList(){
            return hubList;
        }

        @Override
        public void setHubList(String hubList){
            this.hubList = hubList;
        }
        static {
            SerializerRegistry.register("IFDynamicHubComputationHubStreamOutput", FDynamicHubComputationSerializers.IFDynamicHubComputationHubStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFDynamicHubComputationEdgeStreamInput input, IIFDynamicHubComputationHubStreamOutput result){
    }


    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
    }

    /**
     * Sets the algorithm parameter "hubListSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterHubListSize(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
