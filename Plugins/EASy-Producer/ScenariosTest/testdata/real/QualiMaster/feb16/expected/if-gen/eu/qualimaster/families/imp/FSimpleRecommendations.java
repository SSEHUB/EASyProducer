package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFSimpleRecommendations" (GEN).
 */
public class FSimpleRecommendations implements IFSimpleRecommendations {

    /**
     * Provides a default implementation of the data input for the {@link IFSimpleRecommendationsTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSimpleRecommendationsTwitterStreamInput implements IIFSimpleRecommendationsTwitterStreamInput {

        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;
        private Object status;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFSimpleRecommendationsTwitterStreamInput", FSimpleRecommendationsSerializers.IFSimpleRecommendationsTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFSimpleRecommendationsTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSimpleRecommendationsTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFSimpleRecommendationsTwitterStreamOutput> implements IIFSimpleRecommendationsTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFSimpleRecommendationsTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFSimpleRecommendationsTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFSimpleRecommendationsTwitterStreamOutput createItem() {
            return new IFSimpleRecommendationsTwitterStreamOutput(false);
        }
        private Object recommendations;

        @Override
        public Object getRecommendations(){
            return recommendations;
        }

        @Override
        public void setRecommendations(Object recommendations){
            this.recommendations = recommendations;
        }
        static {
            SerializerRegistry.register("IFSimpleRecommendationsTwitterStreamOutput", FSimpleRecommendationsSerializers.IFSimpleRecommendationsTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFSimpleRecommendationsTwitterStreamInput input, IIFSimpleRecommendationsTwitterStreamOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
