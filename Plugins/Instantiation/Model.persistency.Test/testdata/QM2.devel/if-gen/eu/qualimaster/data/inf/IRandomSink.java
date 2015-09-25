package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface IRandomSink extends IDataSink {

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
    * Posts a specific type of data sink.
    * @param data the sink data IRandomSinkProccessedDataInput 
    **/
    public void postDataProccessedData(IRandomSinkProccessedDataInput data);
}
