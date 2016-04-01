package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFEventEnrichment" (GEN).
 */
public class FEventEnrichment implements IFEventEnrichment {

    /**
     * Provides a default implementation of the data input for the {@link IFEventEnrichmentEventStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFEventEnrichmentEventStreamInput implements IIFEventEnrichmentEventStreamInput {

        private Object tweet;
        private Object events;

        @Override
        public Object getTweet(){
            return tweet;
        }

        @Override
        public void setTweet(Object tweet){
            this.tweet = tweet;
        }
        @Override
        public Object getEvents(){
            return events;
        }

        @Override
        public void setEvents(Object events){
            this.events = events;
        }
        static {
            SerializerRegistry.register("IFEventEnrichmentEventStreamInput", FEventEnrichmentSerializers.IFEventEnrichmentEventStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFEventEnrichmentKeywordStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFEventEnrichmentKeywordStreamInput implements IIFEventEnrichmentKeywordStreamInput {

        private Object keywords;

        @Override
        public Object getKeywords(){
            return keywords;
        }

        @Override
        public void setKeywords(Object keywords){
            this.keywords = keywords;
        }
        static {
            SerializerRegistry.register("IFEventEnrichmentKeywordStreamInput", FEventEnrichmentSerializers.IFEventEnrichmentKeywordStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFEventEnrichmentEnrichedEventsStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFEventEnrichmentEnrichedEventsStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFEventEnrichmentEnrichedEventsStreamOutput> implements IIFEventEnrichmentEnrichedEventsStreamOutput {

        /**
         * Creates the item.
         */
        public IFEventEnrichmentEnrichedEventsStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFEventEnrichmentEnrichedEventsStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFEventEnrichmentEnrichedEventsStreamOutput createItem() {
            return new IFEventEnrichmentEnrichedEventsStreamOutput(false);
        }
        private Object events;

        @Override
        public Object getEvents(){
            return events;
        }

        @Override
        public void setEvents(Object events){
            this.events = events;
        }
        static {
            SerializerRegistry.register("IFEventEnrichmentEnrichedEventsStreamOutput", FEventEnrichmentSerializers.IFEventEnrichmentEnrichedEventsStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFEventEnrichmentEventStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFEventEnrichmentKeywordStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
