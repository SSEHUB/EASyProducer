package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFShow".
 */
public interface IFShow {

    /**
     * Defines the data input interface for the {@link IIFShowInput} algorithm (over all defined input tuples).
     */
    public interface IIFShowInput {

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
     * Defines the data output interface for the {@link IIFShowOutput} algorithm (over all defined output tuples).
     */
    public interface IIFShowOutput {

        /**
         * Returns the input value for tuple field "result".
         * @return the tuple value
         */
        public double getResult();

        /**
         * Changes the output value for tuple field "result".
         * @param result the field value
         */
        public void setResult(double result);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFShowInput input, IIFShowOutput result);

}
