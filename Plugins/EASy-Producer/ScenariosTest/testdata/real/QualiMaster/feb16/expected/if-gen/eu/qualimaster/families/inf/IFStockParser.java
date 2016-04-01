package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFStockParser" (GEN).
 */
public interface IFStockParser extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFStockParserTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFStockParserTwitterStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }

    /**
     * Defines the data output interface for the {@link IIFStockParserTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFStockParserTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFStockParserTwitterStreamOutput> {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
        /**
         * Returns the input value for tuple field "stocks".
         * @return the tuple value
         */
        public Object getStocks();

        /**
         * Changes the output value for tuple field "stocks".
         * @param stocks the field value
         */
        public void setStocks(Object stocks);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFStockParserTwitterStreamInput input, IIFStockParserTwitterStreamOutput result);

}
