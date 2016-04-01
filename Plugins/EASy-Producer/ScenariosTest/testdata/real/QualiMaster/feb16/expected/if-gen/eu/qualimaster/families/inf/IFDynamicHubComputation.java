package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFDynamicHubComputation" (GEN).
 */
public interface IFDynamicHubComputation extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFDynamicHubComputationEdgeStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFDynamicHubComputationEdgeStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "edge".
         * @return the tuple value
         */
        public String getEdge();

        /**
         * Changes the output value for tuple field "edge".
         * @param edge the field value
         */
        public void setEdge(String edge);
    }

    /**
     * Defines the data output interface for the {@link IIFDynamicHubComputationHubStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFDynamicHubComputationHubStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFDynamicHubComputationHubStreamOutput> {

        /**
         * Returns the input value for tuple field "hubList".
         * @return the tuple value
         */
        public String getHubList();

        /**
         * Changes the output value for tuple field "hubList".
         * @param hubList the field value
         */
        public void setHubList(String hubList);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFDynamicHubComputationEdgeStreamInput input, IIFDynamicHubComputationHubStreamOutput result);


    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value);

    /**
     * Sets the algorithm parameter "hubListSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterHubListSize(int value);

}
