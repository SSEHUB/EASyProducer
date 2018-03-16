package eu.qualimaster.TimeTravelPip.topology;

import java.util.*;
import java.io.Serializable;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ITimeGraphQueriesSource;
import eu.qualimaster.data.inf.ITimeGraphQueriesSource.*;
import eu.qualimaster.data.imp.TimeGraphQueriesSource;
import eu.qualimaster.timegraph.QueriesSource;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.monitoring.events.ParameterChangedMonitoringEvent;
import eu.qualimaster.dataManagement.sources.*;
import eu.qualimaster.dataManagement.events.HistoricalDataProviderRegistrationEvent;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.dataManagement.DataManager;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_10_Source1Source extends BaseSignalSourceSpout implements IDataSourceListener {

    final static Logger logger = Logger.getLogger(PipelineVar_10_Source1Source.class);
    transient SpoutOutputCollector _collector;
    transient ITimeGraphQueriesSource sourceData;

    public PipelineVar_10_Source1Source(String name, String namespace) {
        super(name, namespace, true);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     * @param causeMsgId the message id of the causing message (may be empty or null)
     */
    private void sendAlgorithmChangeEvent(String algorithm, String causeMsgId) {
        EventManager.send(new AlgorithmChangedMonitoringEvent(getPipeline(), getName(), algorithm, causeMsgId));
    }


    /**
     * Sends an parameter change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param parameter the parameter to be changed
     * @param value the new value
     * @param causeMsgId the message id of the causing message (may be empty or null)
     */
    private static void sendParameterChangeEvent(String parameter, Serializable value, String causeMsgId) {
        EventManager.send(new ParameterChangedMonitoringEvent("TimeTravelPip", "PipelineVar_10_Source1", parameter, value, causeMsgId));
    }

    /**
     * Sends an event for registering the historical data provider of a data source.
     * @param source the data source
     */
    private void sendHistoricalDataProviderRegistrationEvent(IDataSource source) {
        EventManager.send(new HistoricalDataProviderRegistrationEvent(getNamespace(), getName(), source.getHistoricalDataProvider(), source.getIdsNamesMap()));
    }

    protected void configure(SourceMonitor monitor) {
        monitor.setAggregationInterval(60000);
        monitor.registerAggregationKeyProvider(new AggregationKeyProvider<ITimeGraphQueriesSourceSnapshotQueryStreamOutput>(ITimeGraphQueriesSourceSnapshotQueryStreamOutput.class) {
            @Override
            public String getAggregationKey(ITimeGraphQueriesSourceSnapshotQueryStreamOutput tuple) {
                return sourceData.getAggregationKey(tuple);
            }
        });
        monitor.registerAggregationKeyProvider(new AggregationKeyProvider<ITimeGraphQueriesSourcePathQueryStreamOutput>(ITimeGraphQueriesSourcePathQueryStreamOutput.class) {
            @Override
            public String getAggregationKey(ITimeGraphQueriesSourcePathQueryStreamOutput tuple) {
                return sourceData.getAggregationKey(tuple);
            }
        });
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            @SuppressWarnings("unchecked")
            Class<? extends ITimeGraphQueriesSource> cls = (Class<? extends ITimeGraphQueriesSource>) Class.forName("eu.qualimaster.timegraph.QueriesSource");
			boolean autoConnect = "true".equals(conf.get(Constants.CONFIG_KEY_SOURCE_AUTOCONNECT));
			if(autoConnect) {
            	sourceData = DataManager.DATA_SOURCE_MANAGER.createDataSource(getPipeline(), cls, NoStorageStrategyDescriptor.INSTANCE);
			} else {
            	sourceData = cls.newInstance();
			}
			sendHistoricalDataProviderRegistrationEvent(sourceData);
		    sendAlgorithmChangeEvent("QueriesSource", null);
            if (PipelineOptions.hasExecutorArgument(conf, getName(), "snapshotQuery")) {
                sourceData.setParameterSnapshotQuery(PipelineOptions.getExecutorStringArgument(conf, getName(), "snapshotQuery", ""));
            }
            if (PipelineOptions.hasExecutorArgument(conf, getName(), "pathQuery")) {
                sourceData.setParameterPathQuery(PipelineOptions.getExecutorStringArgument(conf, getName(), "pathQuery", ""));
            }
			if(!autoConnect) {
		    	sourceData.connect();
			}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        initMonitor();
        logger.info("The end of the open method.");
    }

    @Override
    protected boolean initMonitorDuringOpen() {
        return false;
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("TimeTravelPip", "PipelineVar_10_Source1", exceptionCase));
    }
    @Override
    public void nextTuple() {
        startMonitoring();
        // Emitting stream "PipelineVar_10_Source1StreamSnapshotQueryStream".
        ITimeGraphQueriesSourceSnapshotQueryStreamOutput dataItemSnapshotQueryStream = new TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput();
        try {
            dataItemSnapshotQueryStream = sourceData.getSnapshotQueryStream();
        } catch(DefaultModeException e) {
            dataItemSnapshotQueryStream.setStart(0);
            dataItemSnapshotQueryStream.setEnd(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSnapshotQueryStream!=null){
            _collector.emit("PipelineVar_10_Source1SnapshotQueryStream", new Values(dataItemSnapshotQueryStream));
        }

        // Emitting stream "PipelineVar_10_Source1PathQueryStream".
        ITimeGraphQueriesSourcePathQueryStreamOutput dataItemPathQueryStream = new TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput();
        try {
            dataItemPathQueryStream = sourceData.getPathQueryStream();
        } catch(DefaultModeException e) {
            dataItemPathQueryStream.setStart(0);
            dataItemPathQueryStream.setEnd(0);
            dataItemPathQueryStream.setVertexA("");
            dataItemPathQueryStream.setVertexB("");
            dataItemPathQueryStream.setType("");
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemPathQueryStream!=null){
            _collector.emit("PipelineVar_10_Source1PathQueryStream", new Values(dataItemPathQueryStream));
        }

        endMonitoring();
        
    }

    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
    sendAlgorithmChangeEvent(signal.getAlgorithm(), signal.getCauseMessageId());
    super.notifyAlgorithmChange(signal);
}
    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
    logger.info("Received the parameter change signal!");
        for(int i = 0; i < signal.getChangeCount(); i++) {
        logger.info("For-loop: Checking each parameter!");
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "snapshotQuery" :
                    logger.info("Received the parameter snapshotQuery!");
                    sourceData.setParameterSnapshotQuery(para.getStringValue()); 
                    sendParameterChangeEvent("snapshotQuery", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "pathQuery" :
                    logger.info("Received the parameter pathQuery!");
                    sourceData.setParameterPathQuery(para.getStringValue()); 
                    sendParameterChangeEvent("pathQuery", para.getStringValue(), signal.getCauseMessageId());
                    break;
            }
        }
    }

    @Override
    public void notifyIdsNamesMapChanged() {
        sendHistoricalDataProviderRegistrationEvent(sourceData);
    }

    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_10_Source1SnapshotQueryStream", new Fields("PipelineVar_10_Source1SnapshotQueryStreamFields"));
        declarer.declareStream("PipelineVar_10_Source1PathQueryStream", new Fields("PipelineVar_10_Source1PathQueryStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        sourceData.disconnect();
    }

}
