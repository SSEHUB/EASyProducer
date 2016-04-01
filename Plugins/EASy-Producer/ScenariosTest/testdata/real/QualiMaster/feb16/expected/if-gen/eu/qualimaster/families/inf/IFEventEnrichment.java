package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

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
        public Object getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(Object tweet);
        /**
         * Returns the input value for tuple field "events".
         * @return the tuple value
         */
        public Object getEvents();

        /**
         * Changes the output value for tuple field "events".
         * @param events the field value
         */
        public void setEvents(Object events);
    }

    /**
     * Defines the data input interface for the {@link IIFEventEnrichmentKeywordStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFEventEnrichmentKeywordStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "keywords".
         * @return the tuple value
         */
        public Object getKeywords();

        /**
         * Changes the output value for tuple field "keywords".
         * @param keywords the field value
         */
        public void setKeywords(Object keywords);
    }

    /**
     * Defines the data output interface for the {@link IIFEventEnrichmentEnrichedEventsStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFEventEnrichmentEnrichedEventsStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFEventEnrichmentEnrichedEventsStreamOutput> {

        /**
         * Returns the input value for tuple field "events".
         * @return the tuple value
         */
        public Object getEvents();

        /**
         * Changes the output value for tuple field "events".
         * @param events the field value
         */
        public void setEvents(Object events);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentEventStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput result);

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentKeywordStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput result);

}
