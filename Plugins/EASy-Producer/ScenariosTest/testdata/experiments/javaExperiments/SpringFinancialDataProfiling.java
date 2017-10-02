package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.ISpringFinancialData;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class SpringFinancialData implements ISpringFinancialData{

    /**
    * Define the source data input interface.
    **/
    public static class SpringFinancialDataSymbolListOutput implements ISpringFinancialDataSymbolListOutput {
        private java.util.List<String> allSymbols;

        @Override
        public java.util.List<String> getAllSymbols() {
            return allSymbols;
        }

        @Override
        public void setAllSymbols(java.util.List<String> allSymbols) {
            this.allSymbols = allSymbols;
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class SpringFinancialDataSpringStreamOutput implements ISpringFinancialDataSpringStreamOutput {
        private String symbolTuple;

        @Override
        public String getSymbolTuple() {
            return symbolTuple;
        }

        @Override
        public void setSymbolTuple(String symbolTuple) {
            this.symbolTuple = symbolTuple;
        }
    }

    @Override
    public SpringFinancialDataSymbolListOutput getSymbolList() {
        return null;
    }

    @Override
    public String getAggregationKey(ISpringFinancialDataSymbolListOutput tuple) {
        return null;
    }

    @Override
    public SpringFinancialDataSpringStreamOutput getSpringStream() {
        return null;
    }

    @Override
    public String getAggregationKey(ISpringFinancialDataSpringStreamOutput tuple) {
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
