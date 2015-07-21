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
		sourceData.connect();
    }

    @Override
    public void nextTuple() {
        // Emitting stream "PriorityPip_Source1StreamSymbolList".
        dataItemSymbolList = sourceData.getSymbolList();
        if(dataItemSymbolList!=null){
            _collector.emit("PriorityPip_Source1StreamSymbolList", new Values(dataItemSymbolList),dataItemSymbolList);
        }

        // Emitting stream "PriorityPip_Source1StreamTwitterStream".
        dataItemTwitterStream = sourceData.getTwitterStream();
        if(dataItemTwitterStream!=null){
            _collector.emit("PriorityPip_Source1StreamTwitterStream", new Values(dataItemTwitterStream),dataItemTwitterStream);
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
