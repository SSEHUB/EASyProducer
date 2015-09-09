package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;

/**
 * The implementation for the algorithm family "IFSentimentAnalysis" (GEN).
 */
public class FSentimentAnalysis implements IFSentimentAnalysis {

    /**
     * Provides a default implementation of the data input for the {@link IFSentimentAnalysisTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentAnalysisTwitterStreamInput implements IIFSentimentAnalysisTwitterStreamInput {

        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFSentimentAnalysisAnalyzedStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSentimentAnalysisAnalyzedStreamOutput implements IIFSentimentAnalysisAnalyzedStreamOutput {

        private String symbolId;
        private long timestamp;
        private double value;
        private int volume;

        @Override
        public String getSymbolId(){
            return symbolId;
        }

        @Override
        public void setSymbolId(String symbolId){
            this.symbolId = symbolId;
        }
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        @Override
        public double getValue(){
            return value;
        }

        @Override
        public void setValue(double value){
            this.value = value;
        }
        @Override
        public int getVolume(){
            return volume;
        }

        @Override
        public void setVolume(int volume){
            this.volume = volume;
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFSentimentAnalysisTwitterStreamInput input, IIFSentimentAnalysisAnalyzedStreamOutput result){
    }

    // algorithm parameters

    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value) {
    }

    /**
     * Sets the algorithm parameter "sentimentClass".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterSentimentClass(int value) {
    }

    /**
     * Sets the algorithm parameter "classificationThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterClassificationThreshold(double value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
