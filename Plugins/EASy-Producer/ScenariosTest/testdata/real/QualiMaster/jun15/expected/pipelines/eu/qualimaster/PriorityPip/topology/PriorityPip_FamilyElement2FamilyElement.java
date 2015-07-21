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
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "fSentimentAnalysis", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputTwitterStream = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology");
            alg = (IFSentimentAnalysis) cls.newInstance();
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
            _collector.emit(streamId, tuple, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            _collector.emit(streamId, tuple, new Values(result));
        }
		 _collector.ack(tuple);
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
            switch (signal.getParameter()) {
                case "timeSeriesGranularity" :
                    System.out.println("Received parameter changing signal timeSeriesGranularity");
                    alg.setParameterTimeSeriesGranularity(signal.getIntValue()); 
                    break;
                case "sentimentClass" :
                    System.out.println("Received parameter changing signal sentimentClass");
                    alg.setParameterSentimentClass(signal.getIntValue()); 
                    break;
                case "classificationThreshold" :
                    System.out.println("Received parameter changing signal classificationThreshold");
                    alg.setParameterClassificationThreshold(signal.getDoubleValue()); 
                    break;
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        switch (signal.getAlgorithm()) {
            case "SentimentAnaylsisSentiWordNetTopology":
                if(!(alg instanceof SentimentAnaylsisSentiWordNetTopology)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology");
                        alg = (IFSentimentAnalysis) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology");
                    streamId = "PriorityPip_FamilyElement21TopoStream";
                    alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
                break;
            case "SentimentAnaylsisSVMTopology":
                if(!(alg instanceof SentimentAnaylsisSVMTopology)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology");
                        alg = (IFSentimentAnalysis) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    sendAlgorithmChangeEvent("SentimentAnaylsisSVMTopology");
                    streamId = "PriorityPip_FamilyElement22TopoStream";
                    alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
                break;
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_FamilyElement2StreamAnalyzedStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
        declarer.declareStream("PriorityPip_FamilyElement21TopoStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
        declarer.declareStream("PriorityPip_FamilyElement22TopoStream", new Fields("IIFSentimentAnalysisAnalyzedStreamOutput"));
    }

}
