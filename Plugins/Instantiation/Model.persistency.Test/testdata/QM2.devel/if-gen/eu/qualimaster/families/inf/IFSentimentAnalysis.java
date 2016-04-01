package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFSentimentAnalysis" (GEN).
 */
public interface IFSentimentAnalysis extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFSentimentAnalysisTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFSentimentAnalysisTwitterStreamInput extends Serializable{

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
     * Defines the data output interface for the {@link IIFSentimentAnalysisAnalyzedStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFSentimentAnalysisAnalyzedStreamOutput extends Serializable{

        /**
         * Returns the input value for tuple field "symbolId".
         * @return the tuple value
         */
        public String getSymbolId();

        /**
         * Changes the output value for tuple field "symbolId".
         * @param symbolId the field value
         */
        public void setSymbolId(String symbolId);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public long getTimestamp();

        /**
         * Changes the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(long timestamp);
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
        /**
         * Returns the input value for tuple field "volume".
         * @return the tuple value
         */
        public int getVolume();

        /**
         * Changes the output value for tuple field "volume".
         * @param volume the field value
         */
        public void setVolume(int volume);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSentimentAnalysisTwitterStreamInput input, IIFSentimentAnalysisAnalyzedStreamOutput result);


    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value);

    /**
     * Sets the algorithm parameter "sentimentClass".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterSentimentClass(int value);

    /**
     * Sets the algorithm parameter "classificationThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterClassificationThreshold(double value);

}
