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

        @Override
        public String getId0() {
            return id0;
        }

        @Override
        public void setId0(String id0) {
            this.id0 = id0;
        }

        @Override
        public String getId1() {
            return id1;
        }

        @Override
        public void setId1(String id1) {
            this.id1 = id1;
        }

        @Override
        public String getDate() {
            return date;
        }

        @Override
        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public double getValue() {
            return value;
        }

        @Override
        public void setValue(double value) {
            this.value = value;
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

        @Override
        public String getSymbolId() {
            return symbolId;
        }

        @Override
        public void setSymbolId(String symbolId) {
            this.symbolId = symbolId;
        }

        @Override
        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public double getValue() {
            return value;
        }

        @Override
        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public int getVolume() {
            return volume;
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
        }
    }

    @Override
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data) {
    }

    @Override
    public void emit(int ticket, IPriorityDataSinkPairwiseFinancialInput tuple) {
    }

    @Override
    public void postDataAnalyzedStream(IPriorityDataSinkAnalyzedStreamInput data) {
    }

    @Override
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
