package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTimeGraph" (GEN).
 */
public interface IFTimeGraph extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTimeGraphDataStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphDataStreamInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFTimeGraphSnapshotQueryStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphSnapshotQueryStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "start".
         * @return the tuple value
         */
        public long getStart();

        /**
         * Changes the output value for tuple field "start".
         * @param start the field value
         */
        public void setStart(long start);
        /**
         * Returns the input value for tuple field "end".
         * @return the tuple value
         */
        public long getEnd();

        /**
         * Changes the output value for tuple field "end".
         * @param end the field value
         */
        public void setEnd(long end);
    }

    /**
     * Defines the data input interface for the {@link IIFTimeGraphPathQueryStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphPathQueryStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "start".
         * @return the tuple value
         */
        public long getStart();

        /**
         * Changes the output value for tuple field "start".
         * @param start the field value
         */
        public void setStart(long start);
        /**
         * Returns the input value for tuple field "end".
         * @return the tuple value
         */
        public long getEnd();

        /**
         * Changes the output value for tuple field "end".
         * @param end the field value
         */
        public void setEnd(long end);
        /**
         * Returns the input value for tuple field "vertexA".
         * @return the tuple value
         */
        public String getVertexA();

        /**
         * Changes the output value for tuple field "vertexA".
         * @param vertexA the field value
         */
        public void setVertexA(String vertexA);
        /**
         * Returns the input value for tuple field "vertexB".
         * @return the tuple value
         */
        public String getVertexB();

        /**
         * Changes the output value for tuple field "vertexB".
         * @param vertexB the field value
         */
        public void setVertexB(String vertexB);
        /**
         * Returns the input value for tuple field "type".
         * @return the tuple value
         */
        public String getType();

        /**
         * Changes the output value for tuple field "type".
         * @param type the field value
         */
        public void setType(String type);
    }

    /**
     * Defines the data output interface for the {@link IIFTimeGraphSnapshotStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphSnapshotStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphSnapshotStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "snapshot".
         * @return the tuple value
         */
        public String getSnapshot();

        /**
         * Changes the output value for tuple field "snapshot".
         * @param snapshot the field value
         */
        public void setSnapshot(String snapshot);
    }

    /**
     * Defines the data output interface for the {@link IIFTimeGraphPathStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphPathStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphPathStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "path".
         * @return the tuple value
         */
        public String getPath();

        /**
         * Changes the output value for tuple field "path".
         * @param path the field value
         */
        public void setPath(String path);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphDataStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphSnapshotQueryStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphPathQueryStreamInput input, IIFTimeGraphSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphPathStreamOutput pathStreamResult);
}
