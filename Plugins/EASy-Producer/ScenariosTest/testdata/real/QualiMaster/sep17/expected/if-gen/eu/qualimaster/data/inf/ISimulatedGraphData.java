package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface ISimulatedGraphData extends IDataSource {


    /**
    * Define the source data input interface.
    **/
    public static interface ISimulatedGraphDataEdgeStreamOutput extends Serializable{
        /**
         * Returns the input value for tuple field "edge".
         * @return the tuple value
         */
        public String getEdge();

        /**
         * Sets the output value for tuple field "edge".
         * @param edge the field value
         */
        public void setEdge(String edge);
    }


    /**
    * Returns a specific type of data source.
    * @return ISimulatedGraphDataEdgeStreamOutput the source data
    **/
    public ISimulatedGraphDataEdgeStreamOutput getEdgeStream();

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    public String getAggregationKey(ISimulatedGraphDataEdgeStreamOutput tuple);
}
