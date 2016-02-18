package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFTwitterStreamFiltering" (GEN).
 */
public interface IFTwitterStreamFiltering extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTwitterStreamFilteringAnalysisInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTwitterStreamFilteringAnalysisInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }

    /**
     * Defines the data output interface for the {@link IIFTwitterStreamFilteringAnalysisOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTwitterStreamFilteringAnalysisOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTwitterStreamFilteringAnalysisOutput> {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterStreamFilteringAnalysisInput input, IIFTwitterStreamFilteringAnalysisOutput result);

}
