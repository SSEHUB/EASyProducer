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

        private eu.qualimaster.data.stream.source.LabelledTweet status;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
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
        public IFStockParserTwitterStreamOutput createItem() {
            return new IFStockParserTwitterStreamOutput(false);
        }
        @Override
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public int getTaskId() {
            return taskId;
        }
        private transient int taskId;
        private eu.qualimaster.data.stream.source.LabelledTweet status;
        private java.util.List<String> stocks;

        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        @Override
        public java.util.List<String> getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(java.util.List<String> stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFStockParserTwitterStreamOutput", FStockParserSerializers.IFStockParserTwitterStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFStockParserTwitterStreamInput input, IIFStockParserTwitterStreamOutput twitterStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
