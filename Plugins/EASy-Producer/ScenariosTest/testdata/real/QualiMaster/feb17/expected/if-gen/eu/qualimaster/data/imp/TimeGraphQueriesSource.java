package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.ITimeGraphQueriesSource;
import eu.qualimaster.data.inf.ITimeGraphQueriesSource.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class TimeGraphQueriesSource implements ITimeGraphQueriesSource{

    /**
    * Define the source data input interface.
    **/
    public static class TimeGraphQueriesSourceSnapshotQueryStreamOutput implements ITimeGraphQueriesSourceSnapshotQueryStreamOutput {
        private long start;
        private long end;
        /**
        * Returns the input value for tuple field "start".
        * @return the tuple value
        */
        @Override
        public long getStart(){
            return start;
        }

        /**
        * Sets the output value for tuple field "start".
        * @param start the field value
        */
        @Override
        public void setStart(long start){
            this.start = start;
        }
        /**
        * Returns the input value for tuple field "end".
        * @return the tuple value
        */
        @Override
        public long getEnd(){
            return end;
        }

        /**
        * Sets the output value for tuple field "end".
        * @param end the field value
        */
        @Override
        public void setEnd(long end){
            this.end = end;
        }
        static {
            SerializerRegistry.register("TimeGraphQueriesSourceSnapshotQueryStreamOutput", TimeGraphQueriesSourceSerializers.TimeGraphQueriesSourceSnapshotQueryStreamOutputSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class TimeGraphQueriesSourcePathQueryStreamOutput implements ITimeGraphQueriesSourcePathQueryStreamOutput {
        private long start;
        private long end;
        private String vertexA;
        private String vertexB;
        private String type;
        /**
        * Returns the input value for tuple field "start".
        * @return the tuple value
        */
        @Override
        public long getStart(){
            return start;
        }

        /**
        * Sets the output value for tuple field "start".
        * @param start the field value
        */
        @Override
        public void setStart(long start){
            this.start = start;
        }
        /**
        * Returns the input value for tuple field "end".
        * @return the tuple value
        */
        @Override
        public long getEnd(){
            return end;
        }

        /**
        * Sets the output value for tuple field "end".
        * @param end the field value
        */
        @Override
        public void setEnd(long end){
            this.end = end;
        }
        /**
        * Returns the input value for tuple field "vertexA".
        * @return the tuple value
        */
        @Override
        public String getVertexA(){
            return vertexA;
        }

        /**
        * Sets the output value for tuple field "vertexA".
        * @param vertexA the field value
        */
        @Override
        public void setVertexA(String vertexA){
            this.vertexA = vertexA;
        }
        /**
        * Returns the input value for tuple field "vertexB".
        * @return the tuple value
        */
        @Override
        public String getVertexB(){
            return vertexB;
        }

        /**
        * Sets the output value for tuple field "vertexB".
        * @param vertexB the field value
        */
        @Override
        public void setVertexB(String vertexB){
            this.vertexB = vertexB;
        }
        /**
        * Returns the input value for tuple field "type".
        * @return the tuple value
        */
        @Override
        public String getType(){
            return type;
        }

        /**
        * Sets the output value for tuple field "type".
        * @param type the field value
        */
        @Override
        public void setType(String type){
            this.type = type;
        }
        static {
            SerializerRegistry.register("TimeGraphQueriesSourcePathQueryStreamOutput", TimeGraphQueriesSourceSerializers.TimeGraphQueriesSourcePathQueryStreamOutputSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return TimeGraphQueriesSourceSnapshotQueryStreamOutput the source data
    **/
    @Override
    public TimeGraphQueriesSourceSnapshotQueryStreamOutput getSnapshotQueryStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ITimeGraphQueriesSourceSnapshotQueryStreamOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return TimeGraphQueriesSourcePathQueryStreamOutput the source data
    **/
    @Override
    public TimeGraphQueriesSourcePathQueryStreamOutput getPathQueryStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ITimeGraphQueriesSourcePathQueryStreamOutput tuple) {
        return null;
    }
    // data source parameters

    /**
     * Sets the data source parameter "snapshotQuery".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterSnapshotQuery(String value) {
    }

    /**
     * Sets the data source parameter "pathQuery".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterPathQuery(String value) {
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
