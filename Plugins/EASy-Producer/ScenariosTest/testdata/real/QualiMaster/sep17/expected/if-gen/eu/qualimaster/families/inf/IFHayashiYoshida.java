package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFHayashiYoshida" (GEN).
 */
public interface IFHayashiYoshida extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFHayashiYoshidaSymbolsStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFHayashiYoshidaSymbolsStreamInput extends Serializable {

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
    }

    /**
     * Defines the data input interface for the {@link IIFHayashiYoshidaConfigurationStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFHayashiYoshidaConfigurationStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "pairKey".
         * @return the tuple value
         */
        public String getPairKey();

        /**
         * Changes the output value for tuple field "pairKey".
         * @param pairKey the field value
         */
        public void setPairKey(String pairKey);
        /**
         * Returns the input value for tuple field "pairValue".
         * @return the tuple value
         */
        public String getPairValue();

        /**
         * Changes the output value for tuple field "pairValue".
         * @param pairValue the field value
         */
        public void setPairValue(String pairValue);
    }

    /**
     * Defines the data input interface for the {@link IIFHayashiYoshidaResetWindowStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFHayashiYoshidaResetWindowStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "windowStart".
         * @return the tuple value
         */
        public long getWindowStart();

        /**
         * Changes the output value for tuple field "windowStart".
         * @param windowStart the field value
         */
        public void setWindowStart(long windowStart);
    }

    /**
     * Defines the data output interface for the {@link IIFHayashiYoshidaPairwiseFinancialOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFHayashiYoshidaPairwiseFinancialOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFHayashiYoshidaPairwiseFinancialOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "pairwiseCorrelationFinancial".
         * @return the tuple value
         */
        public String getPairwiseCorrelationFinancial();

        /**
         * Changes the output value for tuple field "pairwiseCorrelationFinancial".
         * @param pairwiseCorrelationFinancial the field value
         */
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaSymbolsStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaConfigurationStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFHayashiYoshidaResetWindowStreamInput input, IIFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult);
}
