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
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
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
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement3", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement3", exceptionCase));
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
        alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 30));
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
            try {
                alg.calculate(inputAnalyzedStream, result);
            } catch(DefaultModeException e) {
                result.setPairwiseCorrelationTwitter(null);
                sendDefaultModeMonitoringEvent(e);
            }
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputAnalyzedStream));
            }
        }

        if(tuple.getValue(0) instanceof ITwitterStreamDataSymbolListOutput) {
            iTupleSymbolList = (ITwitterStreamDataSymbolListOutput)tuple.getValue(0);
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            try {
                alg.calculate(inputSymbolList, result);
            } catch(DefaultModeException e) {
                result.setPairwiseCorrelationTwitter(null);
                sendDefaultModeMonitoringEvent(e);
            }
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputSymbolList));
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            _collector.emit(streamId, new Values(result));
        }
//		 _collector.ack(tuple);
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
            for(int i = 0; i < signal.getChangeCount(); i++) {
                ParameterChange para = signal.getChange(i);
                switch (para.getName()) {
                    case "windowSize" :
                        System.out.println("Received parameter changing signal windowSize");
                        alg.setParameterWindowSize(para.getIntValue()); 
                        break;
                }
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        System.out.println("Received algorithm switching signal " + signal.getAlgorithm());
        switch (signal.getAlgorithm()) {
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
                    alg.setParameterWindowSize(30);
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
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoHardwareCorrelationTwitter");
                    streamId = "PriorityPip_FamilyElement32TopoStream";
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
        declarer.declareStream("PriorityPip_FamilyElement3StreamPairwiseTwitter", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement31TopoStream", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
        declarer.declareStream("PriorityPip_FamilyElement32TopoStream", new Fields("IIFCorrelationTwitterPairwiseTwitterOutput"));
    }

}
