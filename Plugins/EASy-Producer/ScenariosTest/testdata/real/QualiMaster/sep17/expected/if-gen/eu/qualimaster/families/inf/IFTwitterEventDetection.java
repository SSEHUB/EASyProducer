package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTwitterEventDetection" (GEN).
 */
public interface IFTwitterEventDetection extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTwitterEventDetectionTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTwitterEventDetectionTwitterStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
        /**
         * Returns the input value for tuple field "stocks".
         * @return the tuple value
         */
        public java.util.List<String> getStocks();

        /**
         * Changes the output value for tuple field "stocks".
         * @param stocks the field value
         */
        public void setStocks(java.util.List<String> stocks);
    }

    /**
     * Defines the data output interface for the {@link IIFTwitterEventDetectionTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTwitterEventDetectionTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTwitterEventDetectionTwitterStreamOutput>, IDirectGroupingInfo {

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
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTwitterEventDetectionTwitterStreamInput input, IIFTwitterEventDetectionTwitterStreamOutput twitterStreamResult);

    /**
     * Sets the algorithm parameter "hardThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterHardThreshold(int value);

    /**
     * Sets the algorithm parameter "percentageThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterPercentageThreshold(double value);

    /**
     * Sets the algorithm parameter "lengthOfTimeWindow".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterLengthOfTimeWindow(int value);

    /**
     * Sets the algorithm parameter "frequenceOfCheckForEvent".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFrequenceOfCheckForEvent(int value);

}
