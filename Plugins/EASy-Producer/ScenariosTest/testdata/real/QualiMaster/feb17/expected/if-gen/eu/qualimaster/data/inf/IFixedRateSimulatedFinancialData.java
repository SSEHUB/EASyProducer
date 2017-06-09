package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface IFixedRateSimulatedFinancialData extends IDataSource {


    /**
    * Define the source data input interface.
    **/
    public static interface IFixedRateSimulatedFinancialDataSymbolListOutput extends Serializable{
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
    public static interface IFixedRateSimulatedFinancialDataSpringStreamOutput extends Serializable{
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
    * @return IFixedRateSimulatedFinancialDataSymbolListOutput the source data
    **/
    public IFixedRateSimulatedFinancialDataSymbolListOutput getSymbolList();

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    public String getAggregationKey(IFixedRateSimulatedFinancialDataSymbolListOutput tuple);
    /**
    * Returns a specific type of data source.
    * @return IFixedRateSimulatedFinancialDataSpringStreamOutput the source data
    **/
    public IFixedRateSimulatedFinancialDataSpringStreamOutput getSpringStream();

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    public String getAggregationKey(IFixedRateSimulatedFinancialDataSpringStreamOutput tuple);
}
