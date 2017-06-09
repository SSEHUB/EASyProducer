package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface IFocusSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IFocusSinkRecommendationStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "recommendations".
         * @return the tuple value
         */
        public String getRecommendations();

        /**
         * Sets the output value for tuple field "recommendations".
         * @param recommendations the field value
         */
        public void setRecommendations(String recommendations);
    }
    /**
    * Define the sink data input interface.
    **/
    public static interface IFocusSinkEdgeStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "edge".
         * @return the tuple value
         */
        public String getEdge();

        /**
         * Sets the output value for tuple field "edge".
         * @param edge the field value
         */
        public void setEdge(String edge);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data IFocusSinkRecommendationStreamInput 
    **/
    public void postDataRecommendationStream(IFocusSinkRecommendationStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IFocusSinkRecommendationStreamInput to be emitted 
    **/
    public void emit(int ticket, IFocusSinkRecommendationStreamInput tuple);

    /**
    * Posts a specific type of data sink.
    * @param data the sink data IFocusSinkEdgeStreamInput 
    **/
    public void postDataEdgeStream(IFocusSinkEdgeStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IFocusSinkEdgeStreamInput to be emitted 
    **/
    public void emit(int ticket, IFocusSinkEdgeStreamInput tuple);

}
