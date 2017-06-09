package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFMapper" (GEN).
 */
public interface IFMapper extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFMapperPreprocessedStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFMapperPreprocessedStreamInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFMapperSymbolListInput} algorithm (over all defined input tuples).
     */
    public static interface IIFMapperSymbolListInput extends Serializable {

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
     * Defines the data output interface for the {@link IIFMapperSymbolsStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFMapperSymbolsStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFMapperSymbolsStreamOutput>, IDirectGroupingInfo {

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
     * Defines the data output interface for the {@link IIFMapperConfigurationStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFMapperConfigurationStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFMapperConfigurationStreamOutput>, IDirectGroupingInfo {

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
     * Defines the data output interface for the {@link IIFMapperResetWindowStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFMapperResetWindowStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFMapperResetWindowStreamOutput>, IDirectGroupingInfo {

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
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFMapperPreprocessedStreamInput input, IIFMapperSymbolsStreamOutput symbolsStreamResult, IIFMapperConfigurationStreamOutput configurationStreamResult, IIFMapperResetWindowStreamOutput resetWindowStreamResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFMapperSymbolListInput input, IIFMapperSymbolsStreamOutput symbolsStreamResult, IIFMapperConfigurationStreamOutput configurationStreamResult, IIFMapperResetWindowStreamOutput resetWindowStreamResult);

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value);

}
