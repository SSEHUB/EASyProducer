package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.ISimulatedFocusFinancialData;
import eu.qualimaster.data.inf.ISimulatedFocusFinancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class SimulatedFocusFinancialData implements ISimulatedFocusFinancialData{

    /**
    * Define the source data input interface.
    **/
    public static class SimulatedFocusFinancialDataSymbolListOutput implements ISimulatedFocusFinancialDataSymbolListOutput {
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
            SerializerRegistry.register("SimulatedFocusFinancialDataSymbolListOutput", SimulatedFocusFinancialDataSerializers.SimulatedFocusFinancialDataSymbolListOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class SimulatedFocusFinancialDataSpringStreamOutput implements ISimulatedFocusFinancialDataSpringStreamOutput {
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
            SerializerRegistry.register("SimulatedFocusFinancialDataSpringStreamOutput", SimulatedFocusFinancialDataSerializers.SimulatedFocusFinancialDataSpringStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return SimulatedFocusFinancialDataSymbolListOutput the source data
    **/
    @Override
    public SimulatedFocusFinancialDataSymbolListOutput getSymbolList() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ISimulatedFocusFinancialDataSymbolListOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return SimulatedFocusFinancialDataSpringStreamOutput the source data
    **/
    @Override
    public SimulatedFocusFinancialDataSpringStreamOutput getSpringStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ISimulatedFocusFinancialDataSpringStreamOutput tuple) {
        return null;
    }
    // data source parameters

    /**
     * Sets the data source parameter "speedFactor".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterSpeedFactor(double value) {
    }

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
