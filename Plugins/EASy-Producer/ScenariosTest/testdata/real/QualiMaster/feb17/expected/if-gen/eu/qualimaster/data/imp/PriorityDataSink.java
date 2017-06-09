package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IPriorityDataSink;
import eu.qualimaster.data.inf.IPriorityDataSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
* Define the data source class(GEN).
**/
public class PriorityDataSink implements IPriorityDataSink{

    /**
    * Define the source data input interface.
    **/
    public static class PriorityDataSinkPairwiseFinancialInput implements IPriorityDataSinkPairwiseFinancialInput {
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
            SerializerRegistry.register("PriorityDataSinkPairwiseFinancialInput", PriorityDataSinkSerializers.PriorityDataSinkPairwiseFinancialInputSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class PriorityDataSinkAnalyzedStreamInput implements IPriorityDataSinkAnalyzedStreamInput {
        private String symbolId;
        private long timestamp;
        private double value;
        private int volume;
        /**
        * Returns the input value for tuple field "symbolId".
        * @return the tuple value
        */
        @Override
        public String getSymbolId() {
            return symbolId;
        }

        /**
        * Sets the output value for tuple field "symbolId".
        * @param symbolId the field value
        */
        @Override
        public void setSymbolId(String symbolId) {
            this.symbolId = symbolId;
        }
        /**
        * Returns the input value for tuple field "timestamp".
        * @return the tuple value
        */
        @Override
        public long getTimestamp() {
            return timestamp;
        }

        /**
        * Sets the output value for tuple field "timestamp".
        * @param timestamp the field value
        */
        @Override
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
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
        /**
        * Returns the input value for tuple field "volume".
        * @return the tuple value
        */
        @Override
        public int getVolume() {
            return volume;
        }

        /**
        * Sets the output value for tuple field "volume".
        * @param volume the field value
        */
        @Override
        public void setVolume(int volume) {
            this.volume = volume;
        }
        static {
            SerializerRegistry.register("PriorityDataSinkAnalyzedStreamInput", PriorityDataSinkSerializers.PriorityDataSinkAnalyzedStreamInputSerializer.class);
        }
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data PriorityDataSinkPairwiseFinancialInput
    **/
    @Override
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IPriorityDataSinkPairwiseFinancialInput to be emitted 
    **/
    public void emit(int ticket, IPriorityDataSinkPairwiseFinancialInput tuple) {
    }

    /**
    * Posts a specific type of data sink.
    * @param data the sink data PriorityDataSinkAnalyzedStreamInput
    **/
    @Override
    public void postDataAnalyzedStream(IPriorityDataSinkAnalyzedStreamInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IPriorityDataSinkAnalyzedStreamInput to be emitted 
    **/
    public void emit(int ticket, IPriorityDataSinkAnalyzedStreamInput tuple) {
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
