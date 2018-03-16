package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.IWindowedSpringFinancialData;
import eu.qualimaster.data.inf.IWindowedSpringFinancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class WindowedSpringFinancialData implements IWindowedSpringFinancialData{

    /**
    * Define the source data input interface.
    **/
    public static class WindowedSpringFinancialDataSymbolListOutput implements IWindowedSpringFinancialDataSymbolListOutput {
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
            SerializerRegistry.register("WindowedSpringFinancialDataSymbolListOutput", WindowedSpringFinancialDataSerializers.WindowedSpringFinancialDataSymbolListOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class WindowedSpringFinancialDataSpringStreamOutput implements IWindowedSpringFinancialDataSpringStreamOutput {
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
            SerializerRegistry.register("WindowedSpringFinancialDataSpringStreamOutput", WindowedSpringFinancialDataSerializers.WindowedSpringFinancialDataSpringStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class WindowedSpringFinancialDataResetWindowOutput implements IWindowedSpringFinancialDataResetWindowOutput {
        private long windowStart;
        private long windowEnd;
        /**
        * Returns the input value for tuple field "windowStart".
        * @return the tuple value
        */
        @Override
        public long getWindowStart(){
            return windowStart;
        }

        /**
        * Sets the output value for tuple field "windowStart".
        * @param windowStart the field value
        */
        @Override
        public void setWindowStart(long windowStart){
            this.windowStart = windowStart;
        }
        /**
        * Returns the input value for tuple field "windowEnd".
        * @return the tuple value
        */
        @Override
        public long getWindowEnd(){
            return windowEnd;
        }

        /**
        * Sets the output value for tuple field "windowEnd".
        * @param windowEnd the field value
        */
        @Override
        public void setWindowEnd(long windowEnd){
            this.windowEnd = windowEnd;
        }
        static {
            SerializerRegistry.register("WindowedSpringFinancialDataResetWindowOutput", WindowedSpringFinancialDataSerializers.WindowedSpringFinancialDataResetWindowOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return WindowedSpringFinancialDataSymbolListOutput the source data
    **/
    @Override
    public WindowedSpringFinancialDataSymbolListOutput getSymbolList() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IWindowedSpringFinancialDataSymbolListOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return WindowedSpringFinancialDataSpringStreamOutput the source data
    **/
    @Override
    public WindowedSpringFinancialDataSpringStreamOutput getSpringStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IWindowedSpringFinancialDataSpringStreamOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return WindowedSpringFinancialDataResetWindowOutput the source data
    **/
    @Override
    public WindowedSpringFinancialDataResetWindowOutput getResetWindow() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(IWindowedSpringFinancialDataResetWindowOutput tuple) {
        return null;
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
