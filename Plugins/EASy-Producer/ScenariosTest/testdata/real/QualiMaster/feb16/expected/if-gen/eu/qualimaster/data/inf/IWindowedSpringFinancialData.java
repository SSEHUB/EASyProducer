package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface IWindowedSpringFinancialData extends IDataSource {

    /**
    * Define the source data input interface.
    **/
    public static interface IWindowedSpringFinancialDataSymbolListOutput extends Serializable{
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
    public static interface IWindowedSpringFinancialDataSpringStreamOutput extends Serializable{
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
    public static interface IWindowedSpringFinancialDataResetWindowOutput extends Serializable{
        /**
         * Returns the input value for tuple field "windowStart".
         * @return the tuple value
         */
        public long getWindowStart();

        /**
         * Sets the output value for tuple field "windowStart".
         * @param windowStart the field value
         */
        public void setWindowStart(long windowStart);
        /**
         * Returns the input value for tuple field "windowEnd".
         * @return the tuple value
         */
        public long getWindowEnd();

        /**
         * Sets the output value for tuple field "windowEnd".
         * @param windowEnd the field value
         */
        public void setWindowEnd(long windowEnd);
    }


    /**
    * Returns a specific type of data source.
    * @return IWindowedSpringFinancialDataSymbolListOutput the source data
    **/
    public IWindowedSpringFinancialDataSymbolListOutput getSymbolList();
    /**
    * Returns a specific type of data source.
    * @return IWindowedSpringFinancialDataSpringStreamOutput the source data
    **/
    public IWindowedSpringFinancialDataSpringStreamOutput getSpringStream();
    /**
    * Returns a specific type of data source.
    * @return IWindowedSpringFinancialDataResetWindowOutput the source data
    **/
    public IWindowedSpringFinancialDataResetWindowOutput getResetWindow();
}
