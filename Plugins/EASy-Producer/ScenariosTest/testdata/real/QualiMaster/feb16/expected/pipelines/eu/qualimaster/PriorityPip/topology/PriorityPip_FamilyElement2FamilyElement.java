package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import com.esotericsoftware.kryo.io.Output;
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
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.base.serializer.KryoSwitchTupleSerializer;
import backtype.storm.Config;
import eu.qualimaster.base.pipeline.CollectingTopologyInfo;
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
    private String streamId = "PriorityPip_FamilyElement2StreamAnalyzedStream";
    private transient IIFSentimentAnalysisAnalyzedStreamOutput result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
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
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement2", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement2", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
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
        alg.setParameterTimeSeriesGranularity(PipelineOptions.getExecutorIntArgument(map, getName(), "timeSeriesGranularity", 60));
        alg.setParameterSentimentClass(PipelineOptions.getExecutorIntArgument(map, getName(), "sentimentClass", 10));
        alg.setParameterClassificationThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "classificationThreshold", 2.5));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology");
        streamId = "PriorityPip_FamilyElement21TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fSentimentAnalysis"
        iTupleTwitterStream = (ITwitterStreamDataTwitterStreamOutput)tuple.getValue(0);
        inputTwitterStream = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        try {
            alg.calculate(inputTwitterStream, result);
        } catch(DefaultModeException e) {
            result.setSymbolId(null);
            result.setTimestamp(0);
            result.setValue(0.0);
            result.setVolume(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFSentimentAnalysisAnalyzedStreamOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFSentimentAnalysisAnalyzedStreamOutput out = iter.next();
                _collector.emit(streamId, new Values(out));
            }
        }
//		 _collector.ack(tuple);
        aggregateExecutionTime(start, result.count());
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        for(int i = 0; i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "timeSeriesGranularity" :
                    try {
                        System.out.println("Received parameter changing signal timeSeriesGranularity");
                        alg.setParameterTimeSeriesGranularity(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "sentimentClass" :
                    try {
                        System.out.println("Received parameter changing signal sentimentClass");
                        alg.setParameterSentimentClass(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "classificationThreshold" :
                    try {
                        System.out.println("Received parameter changing signal classificationThreshold");
                        alg.setParameterClassificationThreshold(para.getDoubleValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        logger.info("Received algorithm switching signal " + signal.getAlgorithm());
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
                    streamId = "PriorityPip_FamilyElement21TopoStream";
                    alg.setParameterTimeSeriesGranularity(60);
                    alg.setParameterSentimentClass(10);
                    alg.setParameterClassificationThreshold(2.5);
                    sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology");
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
                    streamId = "PriorityPip_FamilyElement22TopoStream";
                    alg.setParameterTimeSeriesGranularity(60);
                    alg.setParameterSentimentClass(10);
                    alg.setParameterClassificationThreshold(2.5);
                    sendAlgorithmChangeEvent("SentimentAnaylsisSVMTopology");
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
