package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

/**
 * Defines the interface for the algorithm family "ISwitchFamily" (GEN).
 */
public interface ISwitchFamily extends IFamily{

    /**
     * Defines the data input interface for the {@link IISwitchFamilyRandomDataInput} algorithm (over all defined input tuples).
     */
    public static interface IISwitchFamilyRandomDataInput extends Serializable{

        /**
         * Returns the input value for tuple field "randomInteger".
         * @return the tuple value
         */
        public int getRandomInteger();

        /**
         * Changes the output value for tuple field "randomInteger".
         * @param randomInteger the field value
         */
        public void setRandomInteger(int randomInteger);
    }

    /**
     * Defines the data output interface for the {@link IISwitchFamilyProccessedDataOutput} algorithm (over all defined output tuples).
     */
    public static interface IISwitchFamilyProccessedDataOutput extends Serializable{

        /**
         * Returns the input value for tuple field "randomInteger".
         * @return the tuple value
         */
        public int getRandomInteger();

        /**
         * Changes the output value for tuple field "randomInteger".
         * @param randomInteger the field value
         */
        public void setRandomInteger(int randomInteger);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IISwitchFamilyRandomDataInput input, IISwitchFamilyProccessedDataOutput result);


    /**
     * Sets the algorithm parameter "delay".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDelay(int value);

    /**
     * Sets the algorithm parameter "flag".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFlag(boolean value);

}
