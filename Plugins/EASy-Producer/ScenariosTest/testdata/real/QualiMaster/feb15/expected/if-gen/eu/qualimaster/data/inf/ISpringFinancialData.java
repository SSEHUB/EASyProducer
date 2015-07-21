package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data source interface(GEN).
**/
public interface ISpringFinancialData {

    /**
    * Define the source data input interface.
    **/
    public static interface ISpringFinancialData1Output extends Serializable{
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
    * Define the source data input interface.
    **/
    public static interface ISpringFinancialData2Output extends Serializable{
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
    * Returns a specific type of data source.
    * @return ISpringFinancialData1Output the source data
    **/
    public ISpringFinancialData1Output getData1();
    /**
    * Returns a specific type of data source.
    * @return ISpringFinancialData2Output the source data
    **/
    public ISpringFinancialData2Output getData2();
}
