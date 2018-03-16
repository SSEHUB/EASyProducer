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

        private eu.qualimaster.data.stream.source.LabelledTweet tweet;
        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getTweet(){
            return tweet;
        }

        @Override
        public void setTweet(eu.qualimaster.data.stream.source.LabelledTweet tweet){
            this.tweet = tweet;
        }
        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
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

        private java.util.List<String> keywords;

        @Override
        public java.util.List<String> getKeywords(){
            return keywords;
        }

        @Override
        public void setKeywords(java.util.List<String> keywords){
            this.keywords = keywords;
        }
        static {
            SerializerRegistry.register("IFEventEnrichmentKeywordStreamInput", FEventEnrichmentSerializers.IFEventEnrichmentKeywordStreamInputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
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
        public IFEventEnrichmentEnrichedEventsStreamOutput createItem() {
            return new IFEventEnrichmentEnrichedEventsStreamOutput(false);
        }
        @Override
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public int getTaskId() {
            return taskId;
        }
        private transient int taskId;
        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        static {
            SerializerRegistry.register("IFEventEnrichmentEnrichedEventsStreamOutput", FEventEnrichmentSerializers.IFEventEnrichmentEnrichedEventsStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentEventStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput enrichedEventsStreamResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFEventEnrichmentKeywordStreamInput input, IIFEventEnrichmentEnrichedEventsStreamOutput enrichedEventsStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
