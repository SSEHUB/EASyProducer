package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTimeGraphQueryExecutor" (GEN).
 */
public interface IFTimeGraphQueryExecutor extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTimeGraphQueryExecutorSnapshotQueryStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphQueryExecutorSnapshotQueryStreamInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFTimeGraphQueryExecutorPathQueryStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphQueryExecutorPathQueryStreamInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFTimeGraphQueryExecutorExternalResponsesInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphQueryExecutorExternalResponsesInput extends Serializable {

        /**
         * Returns the input value for tuple field "externalResponse".
         * @return the tuple value
         */
        public Object getExternalResponse();

        /**
         * Changes the output value for tuple field "externalResponse".
         * @param externalResponse the field value
         */
        public void setExternalResponse(Object externalResponse);
    }

    /**
     * Defines the data output interface for the {@link IIFTimeGraphQueryExecutorSnapshotStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphQueryExecutorSnapshotStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphQueryExecutorSnapshotStreamOutput>, IDirectGroupingInfo {

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
     * Defines the data output interface for the {@link IIFTimeGraphQueryExecutorPathStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphQueryExecutorPathStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphQueryExecutorPathStreamOutput>, IDirectGroupingInfo {

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
     * Defines the data output interface for the {@link IIFTimeGraphQueryExecutorUnicastRequestsOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphQueryExecutorUnicastRequestsOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphQueryExecutorUnicastRequestsOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "unicastExternalRequest".
         * @return the tuple value
         */
        public Object getUnicastExternalRequest();

        /**
         * Changes the output value for tuple field "unicastExternalRequest".
         * @param unicastExternalRequest the field value
         */
        public void setUnicastExternalRequest(Object unicastExternalRequest);
    }

    /**
     * Defines the data output interface for the {@link IIFTimeGraphQueryExecutorBroadcastRequestsOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphQueryExecutorBroadcastRequestsOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphQueryExecutorBroadcastRequestsOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "broadcastExternalRequest".
         * @return the tuple value
         */
        public Object getBroadcastExternalRequest();

        /**
         * Changes the output value for tuple field "broadcastExternalRequest".
         * @param broadcastExternalRequest the field value
         */
        public void setBroadcastExternalRequest(Object broadcastExternalRequest);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorSnapshotQueryStreamInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorPathQueryStreamInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphQueryExecutorExternalResponsesInput input, IIFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult, IIFTimeGraphQueryExecutorPathStreamOutput pathStreamResult, IIFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult, IIFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult);
}
