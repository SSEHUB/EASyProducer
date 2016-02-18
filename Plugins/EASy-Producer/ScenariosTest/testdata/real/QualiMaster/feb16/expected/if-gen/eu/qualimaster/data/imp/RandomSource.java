package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IRandomSource;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

/**
* Define the data source class(GEN).
**/
public class RandomSource implements IRandomSource{

    /**
    * Define the source data input interface.
    **/
    public static class RandomSourceRandomDataOutput implements IRandomSourceRandomDataOutput {
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
    * Returns a specific type of data source.
    * @return RandomSourceRandomDataOutput the source data
    **/
    @Override
    public RandomSourceRandomDataOutput getRandomData() {
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
}
