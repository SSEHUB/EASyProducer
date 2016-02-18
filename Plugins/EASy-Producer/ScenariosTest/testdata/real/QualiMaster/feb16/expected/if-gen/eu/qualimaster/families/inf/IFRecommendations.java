package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFRecommendations" (GEN).
 */
public interface IFRecommendations extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFRecommendationsTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFRecommendationsTwitterStreamInput extends Serializable {

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
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }

    /**
     * Defines the data output interface for the {@link IIFRecommendationsRecommendationStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFRecommendationsRecommendationStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFRecommendationsRecommendationStreamOutput> {

        /**
         * Returns the input value for tuple field "recommendations".
         * @return the tuple value
         */
        public String getRecommendations();

        /**
         * Changes the output value for tuple field "recommendations".
         * @param recommendations the field value
         */
        public void setRecommendations(String recommendations);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFRecommendationsTwitterStreamInput input, IIFRecommendationsRecommendationStreamOutput result);


    /**
     * Sets the algorithm parameter "impactThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterImpactThreshold(double value);

    /**
     * Sets the algorithm parameter "stockCooccurrenceThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterStockCooccurrenceThreshold(double value);

}
