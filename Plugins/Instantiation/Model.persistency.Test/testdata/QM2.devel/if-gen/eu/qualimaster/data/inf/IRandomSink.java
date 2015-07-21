package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data sink interface(GEN).
**/
public interface IRandomSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IRandomSinkProccessedDataInput extends Serializable {
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
    * Returns a specific type of data sink.
    * @return IRandomSinkProccessedDataInput the sink data
    **/
    public void postDataProccessedData(IRandomSinkProccessedDataInput data);
}
