package eu.qualimaster.data.imp;

import java.io.Serializable;
import eu.qualimaster.data.inf.ISpringFinancialData.*;

/**
* Define the data source class(GEN).
**/
public class SpringFinancialData {

    /**
    * Define the source data input interface.
    **/
    public static class SpringFinancialData1Output implements ISpringFinancialData1Output {
        private static final long serialVersionUID = 1L;
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
    public static class SpringFinancialData2Output implements ISpringFinancialData2Output {
        private static final long serialVersionUID = 1L;
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
    * Returns a specific type of data source.
    * @return SpringFinancialData1Output the source data
    **/
    public SpringFinancialData1Output getData1() {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return SpringFinancialData2Output the source data
    **/
    public SpringFinancialData2Output getData2() {
        return null;
    }
}
