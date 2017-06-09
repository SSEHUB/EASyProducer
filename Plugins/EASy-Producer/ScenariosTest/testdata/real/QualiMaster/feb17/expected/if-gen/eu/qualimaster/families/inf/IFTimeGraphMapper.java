package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTimeGraphMapper" (GEN).
 */
public interface IFTimeGraphMapper extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTimeGraphMapperEdgeStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphMapperEdgeStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "edge".
         * @return the tuple value
         */
        public String getEdge();

        /**
         * Changes the output value for tuple field "edge".
         * @param edge the field value
         */
        public void setEdge(String edge);
    }

    /**
     * Defines the data output interface for the {@link IIFTimeGraphMapperDataStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphMapperDataStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphMapperDataStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "update".
         * @return the tuple value
         */
        public Object getUpdate();

        /**
         * Changes the output value for tuple field "update".
         * @param update the field value
         */
        public void setUpdate(Object update);
        /**
         * Returns the input value for tuple field "isAddition".
         * @return the tuple value
         */
        public boolean getIsAddition();

        /**
         * Changes the output value for tuple field "isAddition".
         * @param isAddition the field value
         */
        public void setIsAddition(boolean isAddition);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphMapperEdgeStreamInput input, IIFTimeGraphMapperDataStreamOutput dataStreamResult);
}
