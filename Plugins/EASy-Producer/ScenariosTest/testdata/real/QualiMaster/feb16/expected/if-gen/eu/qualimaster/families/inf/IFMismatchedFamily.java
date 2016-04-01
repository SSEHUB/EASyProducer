package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFMismatchedFamily" (GEN).
 */
public interface IFMismatchedFamily extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFMismatchedFamilyMisStringInput} algorithm (over all defined input tuples).
     */
    public static interface IIFMismatchedFamilyMisStringInput extends Serializable {

        /**
         * Returns the input value for tuple field "symbolTuple1".
         * @return the tuple value
         */
        public String getSymbolTuple1();

        /**
         * Changes the output value for tuple field "symbolTuple1".
         * @param symbolTuple1 the field value
         */
        public void setSymbolTuple1(String symbolTuple1);
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
     * Defines the data output interface for the {@link IIFMismatchedFamilyMisStringOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFMismatchedFamilyMisStringOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFMismatchedFamilyMisStringOutput> {

        /**
         * Returns the input value for tuple field "streamID1".
         * @return the tuple value
         */
        public String getStreamID1();

        /**
         * Changes the output value for tuple field "streamID1".
         * @param streamID1 the field value
         */
        public void setStreamID1(String streamID1);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public int getTimestamp();

        /**
         * Changes the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(int timestamp);
        /**
         * Returns the input value for tuple field "quote".
         * @return the tuple value
         */
        public double getQuote();

        /**
         * Changes the output value for tuple field "quote".
         * @param quote the field value
         */
        public void setQuote(double quote);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFMismatchedFamilyMisStringInput input, IIFMismatchedFamilyMisStringOutput result);

}
