package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFExpertSearch" (GEN).
 */
public class FExpertSearch implements IFExpertSearch {

    /**
     * Provides a default implementation of the data input for the {@link IFExpertSearchAnalysisInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFExpertSearchAnalysisInput implements IIFExpertSearchAnalysisInput {

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
            SerializerRegistry.register("IFExpertSearchAnalysisInput", FExpertSearchSerializers.IFExpertSearchAnalysisInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFExpertSearchAnalysisOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFExpertSearchAnalysisOutput implements IIFExpertSearchAnalysisOutput {

        private java.util.List<eu.qualimaster.families.datatypes.expertsearch.IFExpert> experts;
        private eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval;
        private java.util.List<String> keywords;
        private java.util.List<String> symbols;

        @Override
        public java.util.List<eu.qualimaster.families.datatypes.expertsearch.IFExpert> getExperts(){
            return experts;
        }

        @Override
        public void setExperts(java.util.List<eu.qualimaster.families.datatypes.expertsearch.IFExpert> experts){
            this.experts = experts;
        }
        @Override
        public eu.qualimaster.families.datatypes.common.IFTimeInterval getTimeInterval(){
            return timeInterval;
        }

        @Override
        public void setTimeInterval(eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval){
            this.timeInterval = timeInterval;
        }
        @Override
        public java.util.List<String> getKeywords(){
            return keywords;
        }

        @Override
        public void setKeywords(java.util.List<String> keywords){
            this.keywords = keywords;
        }
        @Override
        public java.util.List<String> getSymbols(){
            return symbols;
        }

        @Override
        public void setSymbols(java.util.List<String> symbols){
            this.symbols = symbols;
        }
        static {
            SerializerRegistry.register("IFExpertSearchAnalysisOutput", FExpertSearchSerializers.IFExpertSearchAnalysisOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFExpertSearchAnalysisInput input, IIFExpertSearchAnalysisOutput result){
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
