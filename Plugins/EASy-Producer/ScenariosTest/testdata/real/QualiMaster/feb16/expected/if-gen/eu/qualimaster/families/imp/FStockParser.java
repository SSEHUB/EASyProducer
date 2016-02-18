package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFStockParser" (GEN).
 */
public class FStockParser implements IFStockParser {

    /**
     * Provides a default implementation of the data input for the {@link IFStockParserTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFStockParserTwitterStreamInput implements IIFStockParserTwitterStreamInput {

        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFStockParserTwitterStreamInput", FStockParserSerializers.IFStockParserTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFStockParserTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFStockParserTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFStockParserTwitterStreamOutput> implements IIFStockParserTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFStockParserTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFStockParserTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFStockParserTwitterStreamOutput createItem() {
            return new IFStockParserTwitterStreamOutput(false);
        }
        private Object status;
        private Object stocks;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        @Override
        public Object getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(Object stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFStockParserTwitterStreamOutput", FStockParserSerializers.IFStockParserTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFStockParserTwitterStreamInput input, IIFStockParserTwitterStreamOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
