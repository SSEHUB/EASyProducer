package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.IRandomSource;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class RandomSource implements IRandomSource{

    /**
    * Define the source data input interface.
    **/
    public static class RandomSourceRandomDataOutput implements IRandomSourceRandomDataOutput {
        private int randomInteger;
        private long timestamp;
        /**
        * Returns the input value for tuple field "randomInteger".
        * @return the tuple value
        */
        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        /**
        * Sets the output value for tuple field "randomInteger".
        * @param randomInteger the field value
        */
        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        /**
        * Returns the input value for tuple field "timestamp".
        * @return the tuple value
        */
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        /**
        * Sets the output value for tuple field "timestamp".
        * @param timestamp the field value
        */
        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        static {
            SerializerRegistry.register("RandomSourceRandomDataOutput", RandomSourceSerializers.RandomSourceRandomDataOutputSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return RandomSourceRandomDataOutput the source data
    **/
    @Override
    public RandomSourceRandomDataOutput getRandomData() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IRandomSourceRandomDataOutput tuple) {
        return null;
    }
    // data source parameters

    /**
     * Sets the data source parameter "delay".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterDelay(int value) {
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
