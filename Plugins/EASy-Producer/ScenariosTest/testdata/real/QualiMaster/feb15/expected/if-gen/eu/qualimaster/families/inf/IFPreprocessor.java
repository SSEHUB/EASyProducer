package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFPreprocessor" (GEN).
 */
public interface IFPreprocessor extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFPreprocessorInput} algorithm (over all defined input tuples).
     */
    public static interface IIFPreprocessorInput extends Serializable{

        /**
         * Returns the input value for tuple field "symbolTuple".
         * @return the tuple value
         */
        public String getSymbolTuple();

        /**
         * Changes the output value for tuple field "symbolTuple".
         * @param symbolTuple the field value
         */
        public void setSymbolTuple(String symbolTuple);
    }

    /**
     * Defines the data output interface for the {@link IIFPreprocessorOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFPreprocessorOutput extends Serializable{

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
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFPreprocessorInput input, IIFPreprocessorOutput result);

}
