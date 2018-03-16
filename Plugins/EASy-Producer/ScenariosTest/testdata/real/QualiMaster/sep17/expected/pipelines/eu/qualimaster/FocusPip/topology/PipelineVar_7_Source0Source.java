package eu.qualimaster.FocusPip.topology;

import java.util.*;
import java.io.Serializable;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ITwitterStreamData;
import eu.qualimaster.data.inf.ITwitterStreamData.*;
import eu.qualimaster.data.imp.TwitterStreamData;
import eu.qualimaster.data.stream.source.TwitterFileStreaming;
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
public class PipelineVar_7_Source0Source extends BaseSignalSourceSpout implements IDataSourceListener {

    final static Logger logger = Logger.getLogger(PipelineVar_7_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient ITwitterStreamData sourceData;

    public PipelineVar_7_Source0Source(String name, String namespace) {
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
        EventManager.send(new ParameterChangedMonitoringEvent("FocusPip", "PipelineVar_7_Source0", parameter, value, causeMsgId));
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
        monitor.registerAggregationKeyProvider(new AggregationKeyProvider<ITwitterStreamDataSymbolListOutput>(ITwitterStreamDataSymbolListOutput.class) {
            @Override
            public String getAggregationKey(ITwitterStreamDataSymbolListOutput tuple) {
                return sourceData.getAggregationKey(tuple);
            }
        });
        monitor.registerAggregationKeyProvider(new AggregationKeyProvider<ITwitterStreamDataTwitterStreamOutput>(ITwitterStreamDataTwitterStreamOutput.class) {
            @Override
            public String getAggregationKey(ITwitterStreamDataTwitterStreamOutput tuple) {
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
            Class<? extends ITwitterStreamData> cls = (Class<? extends ITwitterStreamData>) Class.forName("eu.qualimaster.data.stream.source.TwitterFileStreaming");
			boolean autoConnect = "true".equals(conf.get(Constants.CONFIG_KEY_SOURCE_AUTOCONNECT));
			if(autoConnect) {
            	sourceData = DataManager.DATA_SOURCE_MANAGER.createDataSource(getPipeline(), cls, NoStorageStrategyDescriptor.INSTANCE);
			} else {
            	sourceData = cls.newInstance();
			}
			sendHistoricalDataProviderRegistrationEvent(sourceData);
		    sendAlgorithmChangeEvent("TwitterFileStreaming", null);
            sourceData.setParameterConsumerKey(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerKey", ""));
            sourceData.setParameterConsumerSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerSecret", ""));
            sourceData.setParameterAccessToken(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessToken", ""));
            sourceData.setParameterAccessTokenSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessTokenSecret", ""));
            sourceData.setParameterQueueSize(PipelineOptions.getExecutorIntArgument(conf, getName(), "queueSize", 0));
            sourceData.setParameterTweetDirectory(PipelineOptions.getExecutorStringArgument(conf, getName(), "tweetDirectory", "/user/storm/resultSymbols"));
            sourceData.setParameterSpeedFactor(PipelineOptions.getExecutorDoubleArgument(conf, getName(), "speedFactor", 0.0));
            sourceData.setParameterRunLocally(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "runLocally", false));
            sourceData.setParameterAdjustTimeToNow(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "adjustTimeToNow", false));
            sourceData.setParameterRealLoops(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "realLoops", false));
            sourceData.setParameterSetAdditionalKeywords(PipelineOptions.getExecutorStringArgument(conf, getName(), "setAdditionalKeywords", ""));
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
        EventManager.send(new DefaultModeMonitoringEvent("FocusPip", "PipelineVar_7_Source0", exceptionCase));
    }
    @Override
    public void nextTuple() {
        startMonitoring();
        // Emitting stream "PipelineVar_7_Source0StreamSymbolList".
        ITwitterStreamDataSymbolListOutput dataItemSymbolList = new TwitterStreamData.TwitterStreamDataSymbolListOutput();
        try {
            dataItemSymbolList = sourceData.getSymbolList();
        } catch(DefaultModeException e) {
            dataItemSymbolList.setAllSymbols(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSymbolList!=null){
            _collector.emit("PipelineVar_7_Source0SymbolList", new Values(dataItemSymbolList));
        }

        // Emitting stream "PipelineVar_7_Source0TwitterStream".
        ITwitterStreamDataTwitterStreamOutput dataItemTwitterStream = new TwitterStreamData.TwitterStreamDataTwitterStreamOutput();
        try {
            dataItemTwitterStream = sourceData.getTwitterStream();
        } catch(DefaultModeException e) {
            dataItemTwitterStream.setStatus(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemTwitterStream!=null){
            _collector.emit("PipelineVar_7_Source0TwitterStream", new Values(dataItemTwitterStream));
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
                case "consumerKey" :
                    logger.info("Received the parameter consumerKey!");
                    sourceData.setParameterConsumerKey(para.getStringValue()); 
                    sendParameterChangeEvent("consumerKey", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "consumerSecret" :
                    logger.info("Received the parameter consumerSecret!");
                    sourceData.setParameterConsumerSecret(para.getStringValue()); 
                    sendParameterChangeEvent("consumerSecret", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "accessToken" :
                    logger.info("Received the parameter accessToken!");
                    sourceData.setParameterAccessToken(para.getStringValue()); 
                    sendParameterChangeEvent("accessToken", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "accessTokenSecret" :
                    logger.info("Received the parameter accessTokenSecret!");
                    sourceData.setParameterAccessTokenSecret(para.getStringValue()); 
                    sendParameterChangeEvent("accessTokenSecret", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "queueSize" :
                    try {
                        logger.info("Received the parameter queueSize!");
                        sourceData.setParameterQueueSize(para.getIntValue()); 
                        sendParameterChangeEvent("queueSize", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "tweetDirectory" :
                    logger.info("Received the parameter tweetDirectory!");
                    sourceData.setParameterTweetDirectory(para.getStringValue()); 
                    sendParameterChangeEvent("tweetDirectory", para.getStringValue(), signal.getCauseMessageId());
                    break;
                case "speedFactor" :
                    try {
                        logger.info("Received the parameter speedFactor!");
                        sourceData.setParameterSpeedFactor(para.getDoubleValue()); 
                        sendParameterChangeEvent("speedFactor", para.getDoubleValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "runLocally" :
                    try {
                        logger.info("Received the parameter runLocally!");
                        sourceData.setParameterRunLocally(para.getBooleanValue()); 
                        sendParameterChangeEvent("runLocally", para.getBooleanValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "adjustTimeToNow" :
                    try {
                        logger.info("Received the parameter adjustTimeToNow!");
                        sourceData.setParameterAdjustTimeToNow(para.getBooleanValue()); 
                        sendParameterChangeEvent("adjustTimeToNow", para.getBooleanValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "realLoops" :
                    try {
                        logger.info("Received the parameter realLoops!");
                        sourceData.setParameterRealLoops(para.getBooleanValue()); 
                        sendParameterChangeEvent("realLoops", para.getBooleanValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "setAdditionalKeywords" :
                    logger.info("Received the parameter setAdditionalKeywords!");
                    sourceData.setParameterSetAdditionalKeywords(para.getStringValue()); 
                    sendParameterChangeEvent("setAdditionalKeywords", para.getStringValue(), signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_7_Source0SymbolList", new Fields("PipelineVar_7_Source0SymbolListFields"));
        declarer.declareStream("PipelineVar_7_Source0TwitterStream", new Fields("PipelineVar_7_Source0TwitterStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        sourceData.disconnect();
    }

}
