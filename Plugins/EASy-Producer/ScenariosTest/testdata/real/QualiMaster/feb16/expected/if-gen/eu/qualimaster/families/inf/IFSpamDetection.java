package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "IFSpamDetection" (GEN).
 */
public interface IFSpamDetection extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFSpamDetectionTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFSpamDetectionTwitterStreamInput extends Serializable {

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
     * Defines the data output interface for the {@link IIFSpamDetectionTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFSpamDetectionTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFSpamDetectionTwitterStreamOutput> {

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
         * Returns the input value for tuple field "spamPropability".
         * @return the tuple value
         */
        public double getSpamPropability();

        /**
         * Changes the output value for tuple field "spamPropability".
         * @param spamPropability the field value
         */
        public void setSpamPropability(double spamPropability);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSpamDetectionTwitterStreamInput input, IIFSpamDetectionTwitterStreamOutput result);

}
