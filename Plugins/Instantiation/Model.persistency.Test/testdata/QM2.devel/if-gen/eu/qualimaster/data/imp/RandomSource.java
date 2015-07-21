package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IRandomSource.*;

/**
* Define the data source class(GEN).
**/
public class RandomSource {

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
    public RandomSourceRandomDataOutput getRandomData() {
        return null;
    }
}
