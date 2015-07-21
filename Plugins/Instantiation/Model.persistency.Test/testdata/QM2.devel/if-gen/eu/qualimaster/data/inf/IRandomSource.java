package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data source interface(GEN).
**/
public interface IRandomSource {

    /**
    * Define the source data input interface.
    **/
    public static interface IRandomSourceRandomDataOutput extends Serializable{
        /**
         * Returns the input value for tuple field "randomInteger".
         * @return the tuple value
         */
        public int getRandomInteger();

        /**
         * Sets the output value for tuple field "randomInteger".
         * @param randomInteger the field value
         */
        public void setRandomInteger(int randomInteger);
    }


    /**
    * Returns a specific type of data source.
    * @return IRandomSourceRandomDataOutput the source data
    **/
    public IRandomSourceRandomDataOutput getRandomData();
}
