package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTimeGraphIndexer" (GEN).
 */
public interface IFTimeGraphIndexer extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTimeGraphIndexerDataStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphIndexerDataStreamInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFTimeGraphIndexerInternalRequestsInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphIndexerInternalRequestsInput extends Serializable {

        /**
         * Returns the input value for tuple field "internalRequest".
         * @return the tuple value
         */
        public Object getInternalRequest();

        /**
         * Changes the output value for tuple field "internalRequest".
         * @param internalRequest the field value
         */
        public void setInternalRequest(Object internalRequest);
    }

    /**
     * Defines the data input interface for the {@link IIFTimeGraphIndexerUnicastRequestsInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphIndexerUnicastRequestsInput extends Serializable {

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
     * Defines the data input interface for the {@link IIFTimeGraphIndexerBroadcastRequestsInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTimeGraphIndexerBroadcastRequestsInput extends Serializable {

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
     * Defines the data output interface for the {@link IIFTimeGraphIndexerExternalResponsesOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphIndexerExternalResponsesOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphIndexerExternalResponsesOutput>, IDirectGroupingInfo {

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
     * Defines the data output interface for the {@link IIFTimeGraphIndexerInternalRequestsOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTimeGraphIndexerInternalRequestsOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTimeGraphIndexerInternalRequestsOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "internalRequest".
         * @return the tuple value
         */
        public Object getInternalRequest();

        /**
         * Changes the output value for tuple field "internalRequest".
         * @param internalRequest the field value
         */
        public void setInternalRequest(Object internalRequest);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerDataStreamInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerInternalRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerUnicastRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTimeGraphIndexerBroadcastRequestsInput input, IIFTimeGraphIndexerExternalResponsesOutput externalResponsesResult, IIFTimeGraphIndexerInternalRequestsOutput internalRequestsResult);
}
