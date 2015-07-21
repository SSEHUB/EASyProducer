package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.ISpringFinancialData.*;

/**
* Define the data source class(GEN).
**/
public class SpringFinancialData {

    /**
    * Define the source data input interface.
    **/
    public static class SpringFinancialDataSymbolListOutput implements ISpringFinancialDataSymbolListOutput {
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
    public static class SpringFinancialDataSpringStreamOutput implements ISpringFinancialDataSpringStreamOutput {
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
    * Returns a specific type of data source.
    * @return SpringFinancialDataSymbolListOutput the source data
    **/
    public SpringFinancialDataSymbolListOutput getSymbolList() {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return SpringFinancialDataSpringStreamOutput the source data
    **/
    public SpringFinancialDataSpringStreamOutput getSpringStream() {
        return null;
    }
}
