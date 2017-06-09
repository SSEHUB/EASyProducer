package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IRandomSink;
import eu.qualimaster.data.inf.IRandomSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
* Define the data source class(GEN).
**/
public class RandomSink implements IRandomSink{

    /**
    * Define the source data input interface.
    **/
    public static class RandomSinkRandomDataInput implements IRandomSinkRandomDataInput {
        private int randomInteger;
        private long timestamp;
        /**
        * Returns the input value for tuple field "randomInteger".
        * @return the tuple value
        */
        @Override
        public int getRandomInteger() {
            return randomInteger;
        }

        /**
        * Sets the output value for tuple field "randomInteger".
        * @param randomInteger the field value
        */
        @Override
        public void setRandomInteger(int randomInteger) {
            this.randomInteger = randomInteger;
        }
        /**
        * Returns the input value for tuple field "timestamp".
        * @return the tuple value
        */
        @Override
        public long getTimestamp() {
            return timestamp;
        }

        /**
        * Sets the output value for tuple field "timestamp".
        * @param timestamp the field value
        */
        @Override
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
        static {
            SerializerRegistry.register("RandomSinkRandomDataInput", RandomSinkSerializers.RandomSinkRandomDataInputSerializer.class);
        }
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data RandomSinkRandomDataInput
    **/
    @Override
    public void postDataRandomData(IRandomSinkRandomDataInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IRandomSinkRandomDataInput to be emitted 
    **/
    public void emit(int ticket, IRandomSinkRandomDataInput tuple) {
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
