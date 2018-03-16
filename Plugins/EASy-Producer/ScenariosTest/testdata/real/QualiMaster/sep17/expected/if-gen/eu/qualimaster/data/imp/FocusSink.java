package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IFocusSink;
import eu.qualimaster.data.inf.IFocusSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
* Define the data source class(GEN).
**/
public class FocusSink implements IFocusSink{

    /**
    * Define the source data input interface.
    **/
    public static class FocusSinkRecommendationStreamInput implements IFocusSinkRecommendationStreamInput {
        private String recommendations;
        /**
        * Returns the input value for tuple field "recommendations".
        * @return the tuple value
        */
        @Override
        public String getRecommendations() {
            return recommendations;
        }

        /**
        * Sets the output value for tuple field "recommendations".
        * @param recommendations the field value
        */
        @Override
        public void setRecommendations(String recommendations) {
            this.recommendations = recommendations;
        }
        static {
            SerializerRegistry.register("FocusSinkRecommendationStreamInput", FocusSinkSerializers.FocusSinkRecommendationStreamInputSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class FocusSinkEdgeStreamInput implements IFocusSinkEdgeStreamInput {
        private String edge;
        /**
        * Returns the input value for tuple field "edge".
        * @return the tuple value
        */
        @Override
        public String getEdge() {
            return edge;
        }

        /**
        * Sets the output value for tuple field "edge".
        * @param edge the field value
        */
        @Override
        public void setEdge(String edge) {
            this.edge = edge;
        }
        static {
            SerializerRegistry.register("FocusSinkEdgeStreamInput", FocusSinkSerializers.FocusSinkEdgeStreamInputSerializer.class);
        }
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data FocusSinkRecommendationStreamInput
    **/
    @Override
    public void postDataRecommendationStream(IFocusSinkRecommendationStreamInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IFocusSinkRecommendationStreamInput to be emitted 
    **/
    public void emit(int ticket, IFocusSinkRecommendationStreamInput tuple) {
    }

    /**
    * Posts a specific type of data sink.
    * @param data the sink data FocusSinkEdgeStreamInput
    **/
    @Override
    public void postDataEdgeStream(IFocusSinkEdgeStreamInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IFocusSinkEdgeStreamInput to be emitted 
    **/
    public void emit(int ticket, IFocusSinkEdgeStreamInput tuple) {
    }

    @Override
    public void connect() {}

    @Override
    public void disconnect(){}

    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {}

    @Override
    public IStorageStrategyDescriptor getStrategy() { return NoStorageStrategyDescriptor.INSTANCE;}

    @Override
    public Double getMeasurement(IObservable observable) { return null;}
}
