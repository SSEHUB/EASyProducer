package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFSpamRemoval" (GEN).
 */
public interface IFSpamRemoval extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFSpamRemovalTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFSpamRemovalTwitterStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
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
     * Defines the data output interface for the {@link IIFSpamRemovalTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFSpamRemovalTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFSpamRemovalTwitterStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFSpamRemovalTwitterStreamInput input, IIFSpamRemovalTwitterStreamOutput twitterStreamResult);

    /**
     * Sets the algorithm parameter "spamThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterSpamThreshold(double value);

}
