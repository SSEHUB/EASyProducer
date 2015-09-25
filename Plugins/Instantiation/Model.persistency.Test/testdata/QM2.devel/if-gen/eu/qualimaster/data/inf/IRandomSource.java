package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface IRandomSource extends IDataSource {

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
    // data source parameters

    /**
     * Sets the data source parameter "delay".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterDelay(int value);

}
