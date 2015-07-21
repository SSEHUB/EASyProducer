package eu.qualimaster.topologies.PriorityPip;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IFCorrelationTwitter.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationTwitter;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationTwitter;
import eu.qualimaster.families.inf.IFSentimentAnalysis.*;
import eu.qualimaster.data.inf.ITwitterStreamData.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement3FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement3FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PriorityPip_FamilyElement3Stream";
    private static transient IIFCorrelationTwitterOutput result = new FCorrelationTwitter.IFCorrelationTwitterOutput();
    private transient IFCorrelationTwitter alg = null; 
    transient IIFSentimentAnalysisOutput iTuple1 = null;
    transient ITwitterStreamData2Output iTuple2 = null;
    transient IIFCorrelationTwitter1Input input1 = null;
    transient IIFCorrelationTwitter2Input input2 = null;

    public PriorityPip_FamilyElement3FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "TwitterCorrelation", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        input1 = new FCorrelationTwitter.IFCorrelationTwitter1Input();
        input2 = new FCorrelationTwitter.IFCorrelationTwitter2Input();
        alg = new TopoSoftwareCorrelationTwitter();
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("TopoSoftwareCorrelationTwitter");
        streamId = "PriorityPip_FamilyElement31TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fCorrelationTwitter"
        if(tuple.getValue(0) instanceof IIFSentimentAnalysisOutput) {
            iTuple1 = (IIFSentimentAnalysisOutput)tuple.getValue(0);
            input1.setSymbolId(iTuple1.getSymbolId());
            input1.setTimestamp(iTuple1.getTimestamp());
            input1.setValue(iTuple1.getValue());
            input1.setVolume(iTuple1.getVolume());
            alg.calculate(input1, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + input1);
                _collector.emit(streamId, tuple, new Values(input1));
            }
        }

        if(tuple.getValue(0) instanceof ITwitterStreamData2Output) {
            iTuple2 = (ITwitterStreamData2Output)tuple.getValue(0);
            input2.setAllSymbols(iTuple2.getAllSymbols());
            alg.calculate(input2, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + input2);
                _collector.emit(streamId, tuple, new Values(input2));
            }
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
 	             case "windowSize" : 
		         alg.setParameterWindowSize(Integer.parseInt(parts[2])); 
 	             break;
	          }
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParameterParam1(parts[2]); 
 	             break;
	          }*/
 	         } else if ("alg".equals(parts[0])) {
	             switch (parts[1]) {
                    case "TopoSoftwareCorrelationTwitter":
                        if(!(alg instanceof TopoSoftwareCorrelationTwitter)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new TopoSoftwareCorrelationTwitter();
		 					sendAlgorithmChangeEvent("TopoSoftwareCorrelationTwitter");
                            streamId = "PriorityPip_FamilyElement31TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
                    case "TopoHardwareCorrelationTwitter":
                        if(!(alg instanceof TopoHardwareCorrelationTwitter)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new TopoHardwareCorrelationTwitter();
		 					sendAlgorithmChangeEvent("TopoHardwareCorrelationTwitter");
                            streamId = "PriorityPip_FamilyElement32TopoStream";
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
        declarer.declareStream("PriorityPip_FamilyElement3Stream", new Fields("IIFCorrelationTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement31TopoStream", new Fields("IIFCorrelationTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement32TopoStream", new Fields("IIFCorrelationTwitterOutput"));
    }

}
