package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFDynamicGraphCompilation" (GEN).
 */
public interface IFDynamicGraphCompilation extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFDynamicGraphCompilationPairwiseFinancialInput} algorithm (over all defined input tuples).
     */
    public static interface IIFDynamicGraphCompilationPairwiseFinancialInput extends Serializable {

        /**
         * Returns the input value for tuple field "pairwiseCorrelationFinancial".
         * @return the tuple value
         */
        public String getPairwiseCorrelationFinancial();

        /**
         * Changes the output value for tuple field "pairwiseCorrelationFinancial".
         * @param pairwiseCorrelationFinancial the field value
         */
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial);
    }

    /**
     * Defines the data output interface for the {@link IIFDynamicGraphCompilationEdgeStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFDynamicGraphCompilationEdgeStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFDynamicGraphCompilationEdgeStreamOutput> {

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
    public void calculate(IIFDynamicGraphCompilationPairwiseFinancialInput input, IIFDynamicGraphCompilationEdgeStreamOutput result);


    /**
     * Sets the algorithm parameter "correlationThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterCorrelationThreshold(double value);

}
