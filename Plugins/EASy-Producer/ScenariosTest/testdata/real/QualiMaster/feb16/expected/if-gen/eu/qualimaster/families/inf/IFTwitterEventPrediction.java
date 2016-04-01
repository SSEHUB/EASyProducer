package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFTwitterEventPrediction" (GEN).
 */
public interface IFTwitterEventPrediction extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTwitterEventPredictionAnalysisInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTwitterEventPredictionAnalysisInput extends Serializable {

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
     * Defines the data output interface for the {@link IIFTwitterEventPredictionAnalysisOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTwitterEventPredictionAnalysisOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTwitterEventPredictionAnalysisOutput> {

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
         * Returns the input value for tuple field "symbols".
         * @return the tuple value
         */
        public java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> getSymbols();

        /**
         * Changes the output value for tuple field "symbols".
         * @param symbols the field value
         */
        public void setSymbols(java.util.List<eu.qualimaster.families.datatypes.events.IFEvent> symbols);
        /**
         * Returns the input value for tuple field "timeInterval".
         * @return the tuple value
         */
        public eu.qualimaster.families.datatypes.common.IFTimeInterval getTimeInterval();

        /**
         * Changes the output value for tuple field "timeInterval".
         * @param timeInterval the field value
         */
        public void setTimeInterval(eu.qualimaster.families.datatypes.common.IFTimeInterval timeInterval);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterEventPredictionAnalysisInput input, IIFTwitterEventPredictionAnalysisOutput result);


    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value);

}
