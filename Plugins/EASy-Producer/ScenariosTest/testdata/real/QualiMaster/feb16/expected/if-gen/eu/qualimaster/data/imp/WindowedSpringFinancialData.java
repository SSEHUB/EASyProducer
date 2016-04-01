package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IWindowedSpringFinancialData;
import eu.qualimaster.data.inf.IWindowedSpringFinancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

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
    * Returns a specific type of data source.
    * @return WindowedSpringFinancialDataSpringStreamOutput the source data
    **/
    @Override
    public WindowedSpringFinancialDataSpringStreamOutput getSpringStream() {
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
}
