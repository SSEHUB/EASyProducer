package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.IFocusFincancialData;
import eu.qualimaster.data.inf.IFocusFincancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class FocusFincancialData implements IFocusFincancialData{

    /**
    * Define the source data input interface.
    **/
    public static class FocusFincancialDataSymbolListOutput implements IFocusFincancialDataSymbolListOutput {
        private java.util.List<String> allSymbols;
        /**
        * Returns the input value for tuple field "allSymbols".
        * @return the tuple value
        */
        @Override
        public java.util.List<String> getAllSymbols(){
            return allSymbols;
        }

        /**
        * Sets the output value for tuple field "allSymbols".
        * @param allSymbols the field value
        */
        @Override
        public void setAllSymbols(java.util.List<String> allSymbols){
            this.allSymbols = allSymbols;
        }
        static {
            SerializerRegistry.register("FocusFincancialDataSymbolListOutput", FocusFincancialDataSerializers.FocusFincancialDataSymbolListOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class FocusFincancialDataSpringStreamOutput implements IFocusFincancialDataSpringStreamOutput {
        private String symbolTuple;
        /**
        * Returns the input value for tuple field "symbolTuple".
        * @return the tuple value
        */
        @Override
        public String getSymbolTuple(){
            return symbolTuple;
        }

        /**
        * Sets the output value for tuple field "symbolTuple".
        * @param symbolTuple the field value
        */
        @Override
        public void setSymbolTuple(String symbolTuple){
            this.symbolTuple = symbolTuple;
        }
        static {
            SerializerRegistry.register("FocusFincancialDataSpringStreamOutput", FocusFincancialDataSerializers.FocusFincancialDataSpringStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return FocusFincancialDataSymbolListOutput the source data
    **/
    @Override
    public FocusFincancialDataSymbolListOutput getSymbolList() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IFocusFincancialDataSymbolListOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return FocusFincancialDataSpringStreamOutput the source data
    **/
    @Override
    public FocusFincancialDataSpringStreamOutput getSpringStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IFocusFincancialDataSpringStreamOutput tuple) {
        return null;
    }
    // data source parameters

    /**
     * Sets the data source parameter "playerList".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterPlayerList(String value) {
    }

    @Override
    public void connect() {}

    @Override
    public void disconnect(){}

    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {}

    @Override
    public IStorageStrategyDescriptor getStrategy() { return NoStorageStrategyDescriptor.INSTANCE;}

    @Override
    public Double getMeasurement(IObservable observable) { return null;}

    @Override
    public IHistoricalDataProvider getHistoricalDataProvider() {
        return null;
    }

    @Override
    public Map<String, String> getIdsNamesMap() {
        return null;
    }

    @Override
    public void setDataSourceListener(IDataSourceListener listener) {
        // no mapping, no listener needed
    }

}
