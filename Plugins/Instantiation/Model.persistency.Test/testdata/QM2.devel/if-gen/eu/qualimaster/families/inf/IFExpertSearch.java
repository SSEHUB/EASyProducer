package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFExpertSearch" (GEN).
 */
public interface IFExpertSearch extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFExpertSearchAnalysisInput} algorithm (over all defined input tuples).
     */
    public static interface IIFExpertSearchAnalysisInput extends Serializable{

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public twitter4j.Status getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(twitter4j.Status status);
    }

    /**
     * Defines the data output interface for the {@link IIFExpertSearchAnalysisOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFExpertSearchAnalysisOutput extends Serializable{

        /**
         * Returns the input value for tuple field "experts".
         * @return the tuple value
         */
        public java.util.List<eu.qualimaster.families.datatypes.expertsearch.IFExpert> getExperts();

        /**
         * Changes the output value for tuple field "experts".
         * @param experts the field value
         */
        public void setExperts(java.util.List<eu.qualimaster.families.datatypes.expertsearch.IFExpert> experts);
        /**
         * Returns the input value for tuple field "timeInterval".
         * @return the tuple value
         */
        public eu.qualimaster.families.datatypes.common.IFTimeInterval getTimeInterval();

        /**
         * Changes the output value for tuple field "timeInterval".
         * @param timeInterval the field value
         */
        public void setTimeInterval(eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval);
        /**
         * Returns the input value for tuple field "keywords".
         * @return the tuple value
         */
        public java.util.List<String> getKeywords();

        /**
         * Changes the output value for tuple field "keywords".
         * @param keywords the field value
         */
        public void setKeywords(java.util.List<String> keywords);
        /**
         * Returns the input value for tuple field "symbols".
         * @return the tuple value
         */
        public java.util.List<String> getSymbols();

        /**
         * Changes the output value for tuple field "symbols".
         * @param symbols the field value
         */
        public void setSymbols(java.util.List<String> symbols);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFExpertSearchAnalysisInput input, IIFExpertSearchAnalysisOutput result);


    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value);

}
