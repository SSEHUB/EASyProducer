package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.ISimulatedGraphData;
import eu.qualimaster.data.inf.ISimulatedGraphData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class SimulatedGraphData implements ISimulatedGraphData{

    /**
    * Define the source data input interface.
    **/
    public static class SimulatedGraphDataEdgeStreamOutput implements ISimulatedGraphDataEdgeStreamOutput {
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
        static {
            SerializerRegistry.register("SimulatedGraphDataEdgeStreamOutput", SimulatedGraphDataSerializers.SimulatedGraphDataEdgeStreamOutputSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return SimulatedGraphDataEdgeStreamOutput the source data
    **/
    @Override
    public SimulatedGraphDataEdgeStreamOutput getEdgeStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ISimulatedGraphDataEdgeStreamOutput tuple) {
        return null;
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

    @Override
    public IHistoricalDataProvider getHistoricalDataProvider() {
        return null;
    }

    @Override
    public Map<String, String> getIdsNamesMap() {
        return null;
    }

    @Override
    public void setDataSourceListener(IDataSourceListener listener) {
        // no mapping, no listener needed
    }

}
