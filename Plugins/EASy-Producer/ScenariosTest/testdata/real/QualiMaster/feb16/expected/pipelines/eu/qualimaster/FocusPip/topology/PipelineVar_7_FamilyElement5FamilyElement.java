package eu.qualimaster.FocusPip.topology;

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
import eu.qualimaster.families.inf.IFRecommendations.*;
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
import eu.qualimaster.algorithms.recommendations.family.impl.RecommendationsAlgorithm;
import eu.qualimaster.families.inf.IFKeywordAnalyzer.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_FamilyElement5FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_FamilyElement5FamilyElement.class);
    transient OutputCollector _collector;
    private String streamId = "PipelineVar_7_FamilyElement5StreamRecommendationStream";
    private transient IIFRecommendationsRecommendationStreamOutput result = new FRecommendations.IFRecommendationsRecommendationStreamOutput();
    private transient IFRecommendations alg = null; 
    transient IIFKeywordAnalyzerTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFRecommendationsTwitterStreamInput inputTwitterStream = null;

    public PipelineVar_7_FamilyElement5FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement5", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement5", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new FRecommendations.IFRecommendationsRecommendationStreamOutput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.recommendations.family.impl.RecommendationsAlgorithm");
            alg = (IFRecommendations) cls.newInstance();
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
        alg.setParameterImpactThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "impactThreshold", 0.5));
        alg.setParameterStockCooccurrenceThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "stockCooccurrenceThreshold", 0.5));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("RecommendationsAlgorithm");
        streamId = "PipelineVar_7_FamilyElement5StreamRecommendationStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fRecommendations"
        iTupleTwitterStream = (IIFKeywordAnalyzerTwitterStreamOutput)tuple.getValue(0);
        inputTwitterStream = new FRecommendations.IFRecommendationsTwitterStreamInput();
        inputTwitterStream.setEvents(iTupleTwitterStream.getEvents());
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        try {
            alg.calculate(inputTwitterStream, result);
        } catch(DefaultModeException e) {
            result.setRecommendations(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFRecommendationsRecommendationStreamOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFRecommendationsRecommendationStreamOutput out = iter.next();
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
                case "impactThreshold" :
                    try {
                        System.out.println("Received parameter changing signal impactThreshold");
                        alg.setParameterImpactThreshold(para.getDoubleValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "stockCooccurrenceThreshold" :
                    try {
                        System.out.println("Received parameter changing signal stockCooccurrenceThreshold");
                        alg.setParameterStockCooccurrenceThreshold(para.getDoubleValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_7_FamilyElement5StreamRecommendationStream", new Fields("IIFRecommendationsRecommendationStreamOutput"));
        declarer.declareStream("PipelineVar_7_FamilyElement51TopoStream", new Fields("IIFRecommendationsRecommendationStreamOutput"));
    }

}
