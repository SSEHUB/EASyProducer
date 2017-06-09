package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFKeywordAnalyzer" (GEN).
 */
public interface IFKeywordAnalyzer extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFKeywordAnalyzerTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFKeywordAnalyzerTwitterStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "events".
         * @return the tuple value
         */
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents();

        /**
         * Changes the output value for tuple field "events".
         * @param events the field value
         */
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events);
        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
    }

    /**
     * Defines the data output interface for the {@link IIFKeywordAnalyzerTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFKeywordAnalyzerTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFKeywordAnalyzerTwitterStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "events".
         * @return the tuple value
         */
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents();

        /**
         * Changes the output value for tuple field "events".
         * @param events the field value
         */
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events);
        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFKeywordAnalyzerTwitterStreamInput input, IIFKeywordAnalyzerTwitterStreamOutput twitterStreamResult);

    /**
     * Sets the algorithm parameter "threshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterThreshold(double value);

    /**
     * Sets the algorithm parameter "decay".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDecay(double value);

}
