package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFEventEnrichment" (GEN).
 */
public interface IFEventEnrichment extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFEventEnrichmentEventStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFEventEnrichmentEventStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "tweet".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(eu.qualimaster.data.stream.source.LabelledTweet tweet);
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
    }

    /**
     * Defines the data input interface for the {@link IIFEventEnrichmentKeywordStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFEventEnrichmentKeywordStreamInput extends Serializable {

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
    }

    /**
     * Defines the data output interface for the {@link IIFEventEnrichmentEnrichedEventsStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFEventEnrichmentEnrichedEventsStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFEventEnrichmentEnrichedEventsStreamOutput>, IDirectGroupingInfo {

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
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentEventStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput enrichedEventsStreamResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentKeywordStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput enrichedEventsStreamResult);
}
