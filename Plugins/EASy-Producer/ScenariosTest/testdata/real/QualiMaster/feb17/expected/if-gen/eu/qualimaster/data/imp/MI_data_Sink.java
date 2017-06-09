package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IMI_data_Sink;
import eu.qualimaster.data.inf.IMI_data_Sink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
* Define the data source class(GEN).
**/
public class MI_data_Sink implements IMI_data_Sink{

    /**
    * Define the source data input interface.
    **/
    public static class MI_data_SinkPairwiseFinancialInput implements IMI_data_SinkPairwiseFinancialInput {
        private String id0;
        private String id1;
        private String date;
        private double value;
        /**
        * Returns the input value for tuple field "id0".
        * @return the tuple value
        */
        @Override
        public String getId0() {
            return id0;
        }

        /**
        * Sets the output value for tuple field "id0".
        * @param id0 the field value
        */
        @Override
        public void setId0(String id0) {
            this.id0 = id0;
        }
        /**
        * Returns the input value for tuple field "id1".
        * @return the tuple value
        */
        @Override
        public String getId1() {
            return id1;
        }

        /**
        * Sets the output value for tuple field "id1".
        * @param id1 the field value
        */
        @Override
        public void setId1(String id1) {
            this.id1 = id1;
        }
        /**
        * Returns the input value for tuple field "date".
        * @return the tuple value
        */
        @Override
        public String getDate() {
            return date;
        }

        /**
        * Sets the output value for tuple field "date".
        * @param date the field value
        */
        @Override
        public void setDate(String date) {
            this.date = date;
        }
        /**
        * Returns the input value for tuple field "value".
        * @return the tuple value
        */
        @Override
        public double getValue() {
            return value;
        }

        /**
        * Sets the output value for tuple field "value".
        * @param value the field value
        */
        @Override
        public void setValue(double value) {
            this.value = value;
        }
        static {
            SerializerRegistry.register("MI_data_SinkPairwiseFinancialInput", MI_data_SinkSerializers.MI_data_SinkPairwiseFinancialInputSerializer.class);
        }
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data MI_data_SinkPairwiseFinancialInput
    **/
    @Override
    public void postDataPairwiseFinancial(IMI_data_SinkPairwiseFinancialInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IMI_data_SinkPairwiseFinancialInput to be emitted 
    **/
    public void emit(int ticket, IMI_data_SinkPairwiseFinancialInput tuple) {
    }

    @Override
    public void connect() {}

    @Override
    public void disconnect(){}

    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {}

    @Override
    public IStorageStrategyDescriptor getStrategy() { return NoStorageStrategyDescriptor.INSTANCE;}

    @Override
    public Double getMeasurement(IObservable observable) { return null;}
}
