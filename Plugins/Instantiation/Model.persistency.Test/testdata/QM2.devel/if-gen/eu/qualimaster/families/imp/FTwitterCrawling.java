package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTwitterCrawling" (GEN).
 */
public class FTwitterCrawling implements IFTwitterCrawling {

    /**
     * Provides a default implementation of the data input for the {@link IFTwitterCrawlingAnalysisInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterCrawlingAnalysisInput implements IIFTwitterCrawlingAnalysisInput {

        private twitter4j.Status status;

        @Override
        public twitter4j.Status getStatus(){
            return status;
        }

        @Override
        public void setStatus(twitter4j.Status status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFTwitterCrawlingAnalysisInput", FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTwitterCrawlingAnalysisOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterCrawlingAnalysisOutput implements IIFTwitterCrawlingAnalysisOutput {

        private java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events;
        private eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getEvents(){
            return events;
        }

        @Override
        public void setEvents(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> events){
            this.events = events;
        }
        @Override
        public eu.qualimaster.families.datatypes.common.IFTimeInterval getTimeInterval(){
            return timeInterval;
        }

        @Override
        public void setTimeInterval(eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval){
            this.timeInterval = timeInterval;
        }
        static {
            SerializerRegistry.register("IFTwitterCrawlingAnalysisOutput", FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTwitterCrawlingAnalysisInput input, IIFTwitterCrawlingAnalysisOutput result){
    }


    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
