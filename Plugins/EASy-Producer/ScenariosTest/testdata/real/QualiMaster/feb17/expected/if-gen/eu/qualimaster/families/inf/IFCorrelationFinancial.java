package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFCorrelationFinancial" (GEN).
 */
public interface IFCorrelationFinancial extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFCorrelationFinancialPreprocessedStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFCorrelationFinancialPreprocessedStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "symbolId".
         * @return the tuple value
         */
        public String getSymbolId();

        /**
         * Changes the output value for tuple field "symbolId".
         * @param symbolId the field value
         */
        public void setSymbolId(String symbolId);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public long getTimestamp();

        /**
         * Changes the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(long timestamp);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Changes the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
        /**
         * Returns the input value for tuple field "volume".
         * @return the tuple value
         */
        public int getVolume();

        /**
         * Changes the output value for tuple field "volume".
         * @param volume the field value
         */
        public void setVolume(int volume);
    }

    /**
     * Defines the data input interface for the {@link IIFCorrelationFinancialSymbolListInput} algorithm (over all defined input tuples).
     */
    public static interface IIFCorrelationFinancialSymbolListInput extends Serializable {

        /**
         * Returns the input value for tuple field "allSymbols".
         * @return the tuple value
         */
        public java.util.List<String> getAllSymbols();

        /**
         * Changes the output value for tuple field "allSymbols".
         * @param allSymbols the field value
         */
        public void setAllSymbols(java.util.List<String> allSymbols);
    }

    /**
     * Defines the data output interface for the {@link IIFCorrelationFinancialPairwiseFinancialOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFCorrelationFinancialPairwiseFinancialOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFCorrelationFinancialPairwiseFinancialOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "id0".
         * @return the tuple value
         */
        public String getId0();

        /**
         * Changes the output value for tuple field "id0".
         * @param id0 the field value
         */
        public void setId0(String id0);
        /**
         * Returns the input value for tuple field "id1".
         * @return the tuple value
         */
        public String getId1();

        /**
         * Changes the output value for tuple field "id1".
         * @param id1 the field value
         */
        public void setId1(String id1);
        /**
         * Returns the input value for tuple field "date".
         * @return the tuple value
         */
        public String getDate();

        /**
         * Changes the output value for tuple field "date".
         * @param date the field value
         */
        public void setDate(String date);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Changes the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCorrelationFinancialPreprocessedStreamInput input, IIFCorrelationFinancialPairwiseFinancialOutput pairwiseFinancialResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCorrelationFinancialSymbolListInput input, IIFCorrelationFinancialPairwiseFinancialOutput pairwiseFinancialResult);

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value);

}
