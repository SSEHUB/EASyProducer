package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface ISpringFinancialData extends IDataSource {

    /**
    * Define the source data input interface.
    **/
    public static interface ISpringFinancialDataSymbolListOutput extends Serializable{
        /**
         * Returns the input value for tuple field "allSymbols".
         * @return the tuple value
         */
        public java.util.List<String> getAllSymbols();

        /**
         * Sets the output value for tuple field "allSymbols".
         * @param allSymbols the field value
         */
        public void setAllSymbols(java.util.List<String> allSymbols);
    }
    /**
    * Define the source data input interface.
    **/
    public static interface ISpringFinancialDataSpringStreamOutput extends Serializable{
        /**
         * Returns the input value for tuple field "symbolTuple".
         * @return the tuple value
         */
        public String getSymbolTuple();

        /**
         * Sets the output value for tuple field "symbolTuple".
         * @param symbolTuple the field value
         */
        public void setSymbolTuple(String symbolTuple);
    }


    /**
    * Returns a specific type of data source.
    * @return ISpringFinancialDataSymbolListOutput the source data
    **/
    public ISpringFinancialDataSymbolListOutput getSymbolList();
    /**
    * Returns a specific type of data source.
    * @return ISpringFinancialDataSpringStreamOutput the source data
    **/
    public ISpringFinancialDataSpringStreamOutput getSpringStream();
    // data source parameters

    /**
     * Sets the data source parameter "playerList".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterPlayerList(String value);

}
