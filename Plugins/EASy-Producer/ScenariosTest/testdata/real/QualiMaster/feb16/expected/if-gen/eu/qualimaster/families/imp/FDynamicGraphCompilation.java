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

        private String pairwiseCorrelationFinancial;

        @Override
        public String getPairwiseCorrelationFinancial(){
            return pairwiseCorrelationFinancial;
        }

        @Override
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial){
            this.pairwiseCorrelationFinancial = pairwiseCorrelationFinancial;
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
        protected IFDynamicGraphCompilationEdgeStreamOutput createItem() {
            return new IFDynamicGraphCompilationEdgeStreamOutput(false);
        }
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
    @Override
    public void calculate(IIFDynamicGraphCompilationPairwiseFinancialInput input, IIFDynamicGraphCompilationEdgeStreamOutput result){
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
