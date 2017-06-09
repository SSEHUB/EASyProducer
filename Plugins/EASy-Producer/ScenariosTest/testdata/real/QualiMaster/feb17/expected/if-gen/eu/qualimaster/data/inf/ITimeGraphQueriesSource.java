package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sources.IDataSource;

/**
* Define the data source interface(GEN).
**/
public interface ITimeGraphQueriesSource extends IDataSource {


    /**
    * Define the source data input interface.
    **/
    public static interface ITimeGraphQueriesSourceSnapshotQueryStreamOutput extends Serializable{
        /**
         * Returns the input value for tuple field "start".
         * @return the tuple value
         */
        public long getStart();

        /**
         * Sets the output value for tuple field "start".
         * @param start the field value
         */
        public void setStart(long start);
        /**
         * Returns the input value for tuple field "end".
         * @return the tuple value
         */
        public long getEnd();

        /**
         * Sets the output value for tuple field "end".
         * @param end the field value
         */
        public void setEnd(long end);
    }
    /**
    * Define the source data input interface.
    **/
    public static interface ITimeGraphQueriesSourcePathQueryStreamOutput extends Serializable{
        /**
         * Returns the input value for tuple field "start".
         * @return the tuple value
         */
        public long getStart();

        /**
         * Sets the output value for tuple field "start".
         * @param start the field value
         */
        public void setStart(long start);
        /**
         * Returns the input value for tuple field "end".
         * @return the tuple value
         */
        public long getEnd();

        /**
         * Sets the output value for tuple field "end".
         * @param end the field value
         */
        public void setEnd(long end);
        /**
         * Returns the input value for tuple field "vertexA".
         * @return the tuple value
         */
        public String getVertexA();

        /**
         * Sets the output value for tuple field "vertexA".
         * @param vertexA the field value
         */
        public void setVertexA(String vertexA);
        /**
         * Returns the input value for tuple field "vertexB".
         * @return the tuple value
         */
        public String getVertexB();

        /**
         * Sets the output value for tuple field "vertexB".
         * @param vertexB the field value
         */
        public void setVertexB(String vertexB);
        /**
         * Returns the input value for tuple field "type".
         * @return the tuple value
         */
        public String getType();

        /**
         * Sets the output value for tuple field "type".
         * @param type the field value
         */
        public void setType(String type);
    }


    /**
    * Returns a specific type of data source.
    * @return ITimeGraphQueriesSourceSnapshotQueryStreamOutput the source data
    **/
    public ITimeGraphQueriesSourceSnapshotQueryStreamOutput getSnapshotQueryStream();

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    public String getAggregationKey(ITimeGraphQueriesSourceSnapshotQueryStreamOutput tuple);
    /**
    * Returns a specific type of data source.
    * @return ITimeGraphQueriesSourcePathQueryStreamOutput the source data
    **/
    public ITimeGraphQueriesSourcePathQueryStreamOutput getPathQueryStream();

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    public String getAggregationKey(ITimeGraphQueriesSourcePathQueryStreamOutput tuple);
    // data source parameters

    /**
     * Sets the data source parameter "snapshotQuery".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterSnapshotQuery(String value);

    /**
     * Sets the data source parameter "pathQuery".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterPathQuery(String value);

}
