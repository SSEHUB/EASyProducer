package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IRandomSink.*;

/**
* Define the data source class(GEN).
**/
public class RandomSink {

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
    * Returns a specific type of data sink.
    * @return RandomSinkProccessedDataInput the sink data
    **/
    public RandomSinkProccessedDataInput getDataProccessedData() {
        return null;
    }
}
