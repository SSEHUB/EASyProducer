package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IFocusSink;
import eu.qualimaster.data.inf.IFocusSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

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
        public String getRecommendations(){
            return recommendations;
        }

        /**
        * Sets the output value for tuple field "recommendations".
        * @param recommendations the field value
        */
        @Override
        public void setRecommendations(String recommendations){
            this.recommendations = recommendations;
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
        public String getEdge(){
            return edge;
        }

        /**
        * Sets the output value for tuple field "edge".
        * @param edge the field value
        */
        @Override
        public void setEdge(String edge){
            this.edge = edge;
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
    * Posts a specific type of data sink.
    * @param data the sink data FocusSinkEdgeStreamInput
    **/
    @Override
    public void postDataEdgeStream(IFocusSinkEdgeStreamInput data) {
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
