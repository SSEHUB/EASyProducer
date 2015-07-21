package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IFSentimentAnalysis.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology;
import eu.qualimaster.data.inf.ITwitterStreamData.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement2FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement2FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PriorityPip_FamilyElement2StreamAnalyzedStream";
    private static transient IIFSentimentAnalysisAnalyzedStreamOutput result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
    private transient IFSentimentAnalysis alg = null; 
    transient ITwitterStreamDataTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFSentimentAnalysisTwitterStreamInput inputTwitterStream = null;

    public PriorityPip_FamilyElement2FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "SentimentAnalysis", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputTwitterStream = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        alg = new SentimentAnaylsisSentiWordNetTopology();
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology");
        streamId = "PriorityPip_FamilyElement21TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fSentimentAnalysis"
        iTupleTwitterStream = (ITwitterStreamDataTwitterStreamOutput)tuple.getValue(0);
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        alg.calculate(inputTwitterStream, result);
        if(alg instanceof ITopologyCreate) {
            logger.info("Emitting data with streamId: "+ streamId + ", data:" + inputTwitterStream);
            _collector.emit(streamId, tuple, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            logger.info("Emitting data with streamId: " + streamId + ", data:" + result);
            _collector.emit(streamId, tuple, new Values(result));
        }
		 _collector.ack(tuple);
    }

    /**
    * Receives the signal data for FamilyElement adaptation.
    * @param data the signal data
    **/
	public void onSignal(byte[] data) {
        String signal=new String(data);
        logger.info("Received signal: " + signal);
        //handle the received signal and make related changes, e.g., switch algorithm from software to hardware
        String[] parts = signal.split(":");
        if (parts.length >= 2) {
            if ("param".equals(parts[0]) && 3 == parts.length) {
       	     switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "timeSeriesGranularity" : 
		         alg.setParameterTimeSeriesGranularity(Integer.parseInt(parts[2])); 
 	             break;
	          }
       	     switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "sentimentClass" : 
		         alg.setParameterSentimentClass(Integer.parseInt(parts[2])); 
 	             break;
	          }
       	     switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "classificationThreshold" : 
		         alg.setParameterClassificationThreshold(Double.parseDouble(parts[2])); 
 	             break;
	          }
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParameterParam1(parts[2]); 
 	             break;
	          }*/
 	         } else if ("alg".equals(parts[0])) {
	             switch (parts[1]) {
                    case "SentimentAnaylsisSentiWordNetTopology":
                        if(!(alg instanceof SentimentAnaylsisSentiWordNetTopology)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new SentimentAnaylsisSentiWordNetTopology();
		 					sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology");
                            streamId = "PriorityPip_FamilyElement21TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
                    case "SentimentAnaylsisSVMTopology":
                        if(!(alg instanceof SentimentAnaylsisSVMTopology)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new SentimentAnaylsisSVMTopology();
		 					sendAlgorithmChangeEvent("SentimentAnaylsisSVMTopology");
                            streamId = "PriorityPip_FamilyElement22TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
	             }
	         }
        }
	}

    @Override
    public void cleanup() {
        super.cleanup();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_FamilyElement2StreamAnalyzedStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
        declarer.declareStream("PriorityPip_FamilyElement21TopoStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
        declarer.declareStream("PriorityPip_FamilyElement22TopoStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
    }

}
