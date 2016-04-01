package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ITwitterStreamData;
import eu.qualimaster.data.inf.ITwitterStreamData.*;
import eu.qualimaster.data.stream.source.TwitterFileStreaming;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Source1Source extends BaseSignalSpout {

    transient SpoutOutputCollector _collector;
    transient ITwitterStreamData sourceData;
    transient ITwitterStreamDataSymbolListOutput dataItemSymbolList = null;
    transient ITwitterStreamDataTwitterStreamOutput dataItemTwitterStream = null;

    public PriorityPip_Source1Source(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.data.stream.source.TwitterFileStreaming");
            sourceData = (ITwitterStreamData) cls.newInstance();
            sourceData.setParameterConsumerKey(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerKey", "default"));
            sourceData.setParameterConsumerSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "consumerSecret", "default"));
            sourceData.setParameterAccessToken(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessToken", "default"));
            sourceData.setParameterAccessTokenSecret(PipelineOptions.getExecutorStringArgument(conf, getName(), "accessTokenSecret", "default"));
            sourceData.setParameterQueueSize(PipelineOptions.getExecutorIntArgument(conf, getName(), "queueSize", 0));
            sourceData.setParameterTweetDirectory(PipelineOptions.getExecutorStringArgument(conf, getName(), "tweetDirectory", "default"));
            sourceData.setParameterSpeedFactor(PipelineOptions.getExecutorDoubleArgument(conf, getName(), "speedFactor", 0.0));
            sourceData.setParameterRunLocally(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "runLocally", false));
            sourceData.setParameterAdjustTimeToNow(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "adjustTimeToNow", false));
            sourceData.setParameterRealLoops(PipelineOptions.getExecutorBooleanArgument(conf, getName(), "realLoops", false));
		    sourceData.connect();
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
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_Source1", exceptionCase));
    }
    @Override
    public void nextTuple() {
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PriorityPip_Source1StreamSymbolList".
        try {
            dataItemSymbolList = sourceData.getSymbolList();
        } catch(DefaultModeException e) {
            dataItemSymbolList.setAllSymbols(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSymbolList!=null){
            _collector.emit("PriorityPip_Source1StreamSymbolList", new Values(dataItemSymbolList));
            emitted = true;
        }

        // Emitting stream "PriorityPip_Source1StreamTwitterStream".
        try {
            dataItemTwitterStream = sourceData.getTwitterStream();
        } catch(DefaultModeException e) {
            dataItemTwitterStream.setStatus(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemTwitterStream!=null){
            _collector.emit("PriorityPip_Source1StreamTwitterStream", new Values(dataItemTwitterStream));
            emitted = true;
        }

        if (emitted) {
            aggregateExecutionTime(start);
        }
        
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
            switch (signal.getParameter()) {
                case "consumerKey" :
                    sourceData.setParameterConsumerKey(signal.getStringValue()); 
                    break;
                case "consumerSecret" :
                    sourceData.setParameterConsumerSecret(signal.getStringValue()); 
                    break;
                case "accessToken" :
                    sourceData.setParameterAccessToken(signal.getStringValue()); 
                    break;
                case "accessTokenSecret" :
                    sourceData.setParameterAccessTokenSecret(signal.getStringValue()); 
                    break;
                case "queueSize" :
                    sourceData.setParameterQueueSize(signal.getIntValue()); 
                    break;
                case "tweetDirectory" :
                    sourceData.setParameterTweetDirectory(signal.getStringValue()); 
                    break;
                case "speedFactor" :
                    sourceData.setParameterSpeedFactor(signal.getDoubleValue()); 
                    break;
                case "runLocally" :
                    sourceData.setParameterRunLocally(signal.getBooleanValue()); 
                    break;
                case "adjustTimeToNow" :
                    sourceData.setParameterAdjustTimeToNow(signal.getBooleanValue()); 
                    break;
                case "realLoops" :
                    sourceData.setParameterRealLoops(signal.getBooleanValue()); 
                    break;
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_Source1StreamSymbolList", new Fields("datastreamSymbolList"));
        declarer.declareStream("PriorityPip_Source1StreamTwitterStream", new Fields("datastreamTwitterStream"));
    }
}
