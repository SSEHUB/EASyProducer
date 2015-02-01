package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFDouble".
 */
public interface IFDouble {

    /**
     * Defines the data input interface for the {@link IIFDoubleInput} algorithm (over all defined input tuples).
     */
    public interface IIFDoubleInput {

        /**
         * Returns the input value for tuple field "valuePlus10".
         * @return the tuple value
         */
        public double getValuePlus10();

        /**
         * Changes the output value for tuple field "valuePlus10".
         * @param valuePlus10 the field value
         */
        public void setValuePlus10(double valuePlus10);
    }

    /**
     * Defines the data output interface for the {@link IIFDoubleOutput} algorithm (over all defined output tuples).
     */
    public interface IIFDoubleOutput {

        /**
         * Returns the input value for tuple field "batchDoubleValue".
         * @return the tuple value
         */
        public double getBatchDoubleValue();

        /**
         * Changes the output value for tuple field "batchDoubleValue".
         * @param batchDoubleValue the field value
         */
        public void setBatchDoubleValue(double batchDoubleValue);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFDoubleInput input, IIFDoubleOutput result);

}
