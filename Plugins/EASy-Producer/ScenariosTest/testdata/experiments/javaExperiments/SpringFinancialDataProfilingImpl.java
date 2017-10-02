package eu.qualimaster.data.imp;

import java.io.*;
import org.apache.log4j.Logger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;
import eu.qualimaster.data.inf.ISpringFinancialData;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.dataManagement.serialization.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.EndOfDataEvent;
import eu.qualimaster.dataManagement.sources.DataQueueDescriptor;
import eu.qualimaster.dataManagement.sources.GenericMultiSourceHandler;
import eu.qualimaster.dataManagement.sources.ReplayMechanism;
import eu.qualimaster.dataManagement.sources.ReplayMechanism.ProfilingQueueItem;
import eu.qualimaster.dataManagement.sources.replay.LongTimestampParser;
import eu.qualimaster.dataManagement.sources.IHistoricalDataProvider;

/**
* Implements the data source class for profiling (GEN).
**/
@Generated("by QM")
public class SpringFinancialDataProfiling extends SpringFinancialData {

    private static final Logger logger = Logger.getLogger(SpringFinancialDataProfiling.class); 
    private static final int MAXIMUM_DATA_ENTRIES = 400000;
    private GenericMultiSourceHandler handler = new GenericMultiSourceHandler(2);
    private ReplayMechanism replay = new ReplayMechanism(LongTimestampParser.INSTANCE);
    private boolean eodSent = false;
    private boolean isConnected = false;
    private transient Queue<ProfilingQueueItem<SpringFinancialDataSymbolListOutput>> SpringFinancialDataSymbolListOutputQueue = 
    				new ArrayDeque<ProfilingQueueItem<SpringFinancialDataSymbolListOutput>>();
    private transient Queue<ProfilingQueueItem<SpringFinancialDataSpringStreamOutput>> SpringFinancialDataSpringStreamOutputQueue = 
    				new ArrayDeque<ProfilingQueueItem<SpringFinancialDataSpringStreamOutput>>();
    private transient List<DataQueueDescriptor<?>> queueList = new ArrayList<DataQueueDescriptor<?>>();

    /**
    * Provides a serializer for the test data.
    */
    public static class SpringFinancialDataSymbolListOutputSerializer implements ISerializer<SpringFinancialDataSymbolListOutput> {

        @Override
        public void serializeTo(SpringFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
            // no protobuf by now
        }

        @Override
        public SpringFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
            return null; // no protobuf by now
        }

        @Override
        public void serializeTo(SpringFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }


        @Override
        public SpringFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            SpringFinancialDataSymbolListOutput result = new SpringFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    }

    @Override
    public SpringFinancialDataSymbolListOutput getSymbolList() {
        SpringFinancialDataSymbolListOutput result = null;
        if (isConnected) {
            if (!SpringFinancialDataSymbolListOutputQueue.isEmpty()) {
                try {
                    result = replay.getNextItem(SpringFinancialDataSymbolListOutputQueue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (SpringFinancialDataSymbolListOutputQueue.isEmpty() && SpringFinancialDataSpringStreamOutputQueue.isEmpty()) {
                if (!eodSent) {
                    EventManager.send(new EndOfDataEvent("PriorityPip", "FinancialDataSource"));
                    eodSent = true;
                }
            }
        }
        //logger.info("getSymbolList -- Returning the result: " + result);
        return result;
    }
    @Override
    public String getAggregationKey(ISpringFinancialDataSymbolListOutput tuple) {
        return null;
    }
    /**
    * Provides a serializer for the test data.
    */
    public static class SpringFinancialDataSpringStreamOutputSerializer implements ISerializer<SpringFinancialDataSpringStreamOutput> {

        @Override
        public void serializeTo(SpringFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
            // no protobuf by now
        }

        @Override
        public SpringFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
            return null; // no protobuf by now
        }

        @Override
        public void serializeTo(SpringFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }


        @Override
        public SpringFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            SpringFinancialDataSpringStreamOutput result = new SpringFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    }

    @Override
    public SpringFinancialDataSpringStreamOutput getSpringStream() {
        SpringFinancialDataSpringStreamOutput result = null;
        if (isConnected) {
            if (!SpringFinancialDataSpringStreamOutputQueue.isEmpty()) {
                try {
                    result = replay.getNextItem(SpringFinancialDataSpringStreamOutputQueue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (SpringFinancialDataSymbolListOutputQueue.isEmpty() && SpringFinancialDataSpringStreamOutputQueue.isEmpty()) {
                if (!eodSent) {
                    EventManager.send(new EndOfDataEvent("PriorityPip", "FinancialDataSource"));
                    eodSent = true;
                }
            }
        }
        //logger.info("getSpringStream -- Returning the result: " + result);
        return result;
    }
    @Override
    public String getAggregationKey(ISpringFinancialDataSpringStreamOutput tuple) {
        return null;
    }

    @Override
    public void connect() {
        logger.info("Connecting the source...");
        SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        SerializerRegistry.register(SpringFinancialDataSymbolListOutput.class, SpringFinancialDataSymbolListOutputSerializer.class);
        SerializerRegistry.register(SpringFinancialDataSpringStreamOutput.class, SpringFinancialDataSpringStreamOutputSerializer.class);
        replay.connect();
        queueList.add(new DataQueueDescriptor<SpringFinancialDataSymbolListOutput>("symbolList", SpringFinancialDataSymbolListOutputQueue, 
                    SpringFinancialDataSymbolListOutput.class));
        queueList.add(new DataQueueDescriptor<SpringFinancialDataSpringStreamOutput>("springStream", SpringFinancialDataSpringStreamOutputQueue, 
                    SpringFinancialDataSpringStreamOutput.class));
        //read profiling data in advance
        try {
            replay.readProfilingData(handler, MAXIMUM_DATA_ENTRIES, queueList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("The size of the SpringFinancialDataSymbolListOutputQueue : " + SpringFinancialDataSymbolListOutputQueue.size());
        logger.info("The size of the SpringFinancialDataSpringStreamOutputQueue : " + SpringFinancialDataSpringStreamOutputQueue.size());
        isConnected = true;
        logger.info("Connected the source...");
    }
    @Override
    public void disconnect() {
        logger.info("Disconnecting the source...");
        isConnected = false;
        replay.disconnect();
        SerializerRegistry.unregister(SpringFinancialDataSymbolListOutput.class);
        SerializerRegistry.unregister(SpringFinancialDataSpringStreamOutput.class);
        logger.info("Disconnected the source...");
    }
    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {
        replay.setStrategy(strategy);
    }
    @Override
    public IStorageStrategyDescriptor getStrategy() {
        return replay.getStrategy();
    }
    @Override
    public Double getMeasurement(IObservable observable) {
        return replay.getMeasurement(observable);
    }

    @Override
    public IHistoricalDataProvider getHistoricalDataProvider() {
        return replay.getHistoricalDataProvider();
    }
}
