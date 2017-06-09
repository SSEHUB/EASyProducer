package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFDynamicGraphCompilation" (GEN).
 */
public interface IFDynamicGraphCompilation extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFDynamicGraphCompilationPairwiseFinancialInput} algorithm (over all defined input tuples).
     */
    public static interface IIFDynamicGraphCompilationPairwiseFinancialInput extends Serializable {

        /**
         * Returns the input value for tuple field "id0".
         * @return the tuple value
         */
        public String getId0();

        /**
         * Changes the output value for tuple field "id0".
         * @param id0 the field value
         */
        public void setId0(String id0);
        /**
         * Returns the input value for tuple field "id1".
         * @return the tuple value
         */
        public String getId1();

        /**
         * Changes the output value for tuple field "id1".
         * @param id1 the field value
         */
        public void setId1(String id1);
        /**
         * Returns the input value for tuple field "date".
         * @return the tuple value
         */
        public String getDate();

        /**
         * Changes the output value for tuple field "date".
         * @param date the field value
         */
        public void setDate(String date);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Changes the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
    }

    /**
     * Defines the data output interface for the {@link IIFDynamicGraphCompilationEdgeStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFDynamicGraphCompilationEdgeStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFDynamicGraphCompilationEdgeStreamOutput>, IDirectGroupingInfo {

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
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFDynamicGraphCompilationPairwiseFinancialInput input, IIFDynamicGraphCompilationEdgeStreamOutput edgeStreamResult);

    /**
     * Sets the algorithm parameter "correlationThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterCorrelationThreshold(double value);

}
