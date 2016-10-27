package eu.qualimaster.FocusPip.topology;

import java.util.*;
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

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_Source0Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PipelineVar_7_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient ITwitterStreamData sourceData;

    public PipelineVar_7_Source0Source(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_Source0", algorithm));
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.data.stream.source.TwitterFileStreaming");
            sourceData = (ITwitterStreamData) cls.newInstance();
            sourceData.setParameterConsumerKey(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerKey", "consumerKey"));
            sourceData.setParameterConsumerSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerSecret", "consumerSecret"));
            sourceData.setParameterAccessToken(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessToken", "accessToken"));
            sourceData.setParameterAccessTokenSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessTokenSecret", "accessTokenSecret"));
            sourceData.setParameterQueueSize(PipelineOptions.getExecutorIntArgument(conf, getName(), "queueSize", 0));
            sourceData.setParameterTweetDirectory(PipelineOptions.getExecutorStringArgument(conf, getName(), "tweetDirectory", "/user/storm/resultSymbols"));
            sourceData.setParameterSpeedFactor(PipelineOptions.getExecutorDoubleArgument(conf, getName(), "speedFactor", 0.0));
            sourceData.setParameterRunLocally(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "runLocally", true));
            sourceData.setParameterAdjustTimeToNow(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "adjustTimeToNow", false));
            sourceData.setParameterRealLoops(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "realLoops", false));
            sourceData.setParameterSetAdditionalKeywords(PipelineOptions.getExecutorStringArgument(conf, getName(), "setAdditionalKeywords", ""));
		    sourceData.connect();
		    sendAlgorithmChangeEvent("TwitterFileStreaming");
        } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PipelineVar_7_Source0StreamSymbolList".
        ITwitterStreamDataSymbolListOutput dataItemSymbolList = new TwitterStreamData.TwitterStreamDataSymbolListOutput();
        try {
            dataItemSymbolList = sourceData.getSymbolList();
        } catch(DefaultModeException e) {
            dataItemSymbolList.setAllSymbols(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSymbolList!=null){
            _collector.emit("PipelineVar_7_Source0StreamSymbolList", new Values(dataItemSymbolList));
            emitted = true;
        }

        // Emitting stream "PipelineVar_7_Source0StreamTwitterStream".
        ITwitterStreamDataTwitterStreamOutput dataItemTwitterStream = new TwitterStreamData.TwitterStreamDataTwitterStreamOutput();
        try {
            dataItemTwitterStream = sourceData.getTwitterStream();
        } catch(DefaultModeException e) {
            dataItemTwitterStream.setStatus(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemTwitterStream!=null){
            _collector.emit("PipelineVar_7_Source0StreamTwitterStream", new Values(dataItemTwitterStream));
            emitted = true;
        }

        if (emitted) {
            aggregateExecutionTime(start);
        }
        
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        for(int i = 0; i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "consumerKey" :
                    logger.info("Received the parameter consumerKey!");
                    sourceData.setParameterConsumerKey(para.getStringValue()); 
                    break;
                case "consumerSecret" :
                    logger.info("Received the parameter consumerSecret!");
                    sourceData.setParameterConsumerSecret(para.getStringValue()); 
                    break;
                case "accessToken" :
                    logger.info("Received the parameter accessToken!");
                    sourceData.setParameterAccessToken(para.getStringValue()); 
                    break;
                case "accessTokenSecret" :
                    logger.info("Received the parameter accessTokenSecret!");
                    sourceData.setParameterAccessTokenSecret(para.getStringValue()); 
                    break;
                case "queueSize" :
                    try {
                        logger.info("Received the parameter queueSize!");
                        sourceData.setParameterQueueSize(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "tweetDirectory" :
                    logger.info("Received the parameter tweetDirectory!");
                    sourceData.setParameterTweetDirectory(para.getStringValue()); 
                    break;
                case "speedFactor" :
                    try {
                        logger.info("Received the parameter speedFactor!");
                        sourceData.setParameterSpeedFactor(para.getDoubleValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "runLocally" :
                    try {
                        logger.info("Received the parameter runLocally!");
                        sourceData.setParameterRunLocally(para.getBooleanValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "adjustTimeToNow" :
                    try {
                        logger.info("Received the parameter adjustTimeToNow!");
                        sourceData.setParameterAdjustTimeToNow(para.getBooleanValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "realLoops" :
                    try {
                        logger.info("Received the parameter realLoops!");
                        sourceData.setParameterRealLoops(para.getBooleanValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "setAdditionalKeywords" :
                    logger.info("Received the parameter setAdditionalKeywords!");
                    sourceData.setParameterSetAdditionalKeywords(para.getStringValue()); 
                    break;
            }
        }
    }

    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_7_Source0StreamSymbolList", new Fields("datastreamSymbolList"));
        declarer.declareStream("PipelineVar_7_Source0StreamTwitterStream", new Fields("datastreamTwitterStream"));
    }
}
