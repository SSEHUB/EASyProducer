package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFTwitterCrawling" (GEN).
 */
public interface IFTwitterCrawling extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTwitterCrawlingAnalysisInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTwitterCrawlingAnalysisInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public twitter4j.Status getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(twitter4j.Status status);
    }

    /**
     * Defines the data output interface for the {@link IIFTwitterCrawlingAnalysisOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTwitterCrawlingAnalysisOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTwitterCrawlingAnalysisOutput> {

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
    public void calculate(IIFTwitterCrawlingAnalysisInput input, IIFTwitterCrawlingAnalysisOutput result);


    /**
     * Sets the algorithm parameter "timeSeriesGranularity".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterTimeSeriesGranularity(int value);

}
