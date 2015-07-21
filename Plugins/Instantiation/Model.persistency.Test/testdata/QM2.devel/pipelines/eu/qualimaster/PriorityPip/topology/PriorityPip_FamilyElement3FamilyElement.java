package eu.qualimaster.PriorityPip.topology;

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
    private static String streamId = "PriorityPip_FamilyElement3StreamPairwiseTwitter";
    private static transient IIFCorrelationTwitterPairwiseTwitterOutput result = new FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput();
    private transient IFCorrelationTwitter alg = null; 
    transient IIFSentimentAnalysisAnalyzedStreamOutput iTupleAnalyzedStream = null;
    transient ITwitterStreamDataSymbolListOutput iTupleSymbolList = null;
    transient IIFCorrelationTwitterAnalyzedStreamInput inputAnalyzedStream = null;
    transient IIFCorrelationTwitterSymbolListInput inputSymbolList = null;

    public PriorityPip_FamilyElement3FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "fCorrelationTwitter", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputAnalyzedStream = new FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput();
        inputSymbolList = new FCorrelationTwitter.IFCorrelationTwitterSymbolListInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationTwitter");
            alg = (IFCorrelationTwitter) cls.newInstance();
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
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("TopoSoftwareCorrelationTwitter");
        streamId = "PriorityPip_FamilyElement31TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fCorrelationTwitter"
        if(tuple.getValue(0) instanceof IIFSentimentAnalysisAnalyzedStreamOutput) {
            iTupleAnalyzedStream = (IIFSentimentAnalysisAnalyzedStreamOutput)tuple.getValue(0);
            inputAnalyzedStream.setSymbolId(iTupleAnalyzedStream.getSymbolId());
            inputAnalyzedStream.setTimestamp(iTupleAnalyzedStream.getTimestamp());
            inputAnalyzedStream.setValue(iTupleAnalyzedStream.getValue());
            inputAnalyzedStream.setVolume(iTupleAnalyzedStream.getVolume());
            alg.calculate(inputAnalyzedStream, result);
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, tuple, new Values(inputAnalyzedStream));
            }
        }

        if(tuple.getValue(0) instanceof ITwitterStreamDataSymbolListOutput) {
            iTupleSymbolList = (ITwitterStreamDataSymbolListOutput)tuple.getValue(0);
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            alg.calculate(inputSymbolList, result);
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, tuple, new Values(inputSymbolList));
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
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
                            try {
                                Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationTwitter");
                                alg = (IFCorrelationTwitter) cls.newInstance();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
		 					sendAlgorithmChangeEvent("TopoSoftwareCorrelationTwitter");
                            streamId = "PriorityPip_FamilyElement31TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
                    case "TopoHardwareCorrelationTwitter":
                        if(!(alg instanceof TopoHardwareCorrelationTwitter)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            try {
                                Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationTwitter");
                                alg = (IFCorrelationTwitter) cls.newInstance();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
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
        declarer.declareStream("PriorityPip_FamilyElement3StreamPairwiseTwitter", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement31TopoStream", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement32TopoStream", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
    }

}
