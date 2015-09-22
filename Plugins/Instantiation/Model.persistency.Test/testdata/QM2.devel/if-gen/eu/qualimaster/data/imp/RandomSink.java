package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IRandomSink;
import eu.qualimaster.data.inf.IRandomSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

/**
* Define the data source class(GEN).
**/
public class RandomSink implements IRandomSink{

    /**
    * Define the source data input interface.
    **/
    public static class RandomSinkProccessedDataInput implements IRandomSinkProccessedDataInput {
        private int randomInteger;
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
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data RandomSinkProccessedDataInput
    **/
    @Override
    public void postDataProccessedData(IRandomSinkProccessedDataInput data) {
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
