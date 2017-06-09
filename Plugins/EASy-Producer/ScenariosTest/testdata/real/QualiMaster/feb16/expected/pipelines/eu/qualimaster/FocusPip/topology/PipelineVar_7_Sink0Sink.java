package eu.qualimaster.FocusPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.data.inf.IFocusSink;
import eu.qualimaster.data.inf.IFocusSink.*;
import eu.qualimaster.data.imp.FocusSink;
import eu.qualimaster.focus.FocusSinkAlgorithm;
import eu.qualimaster.families.inf.IFRecommendations.*;
import eu.qualimaster.families.inf.IFDynamicGraphCompilation.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_Sink0Sink.class);
    transient OutputCollector _collector;
    transient IFocusSink sinkHandler;
    transient IIFRecommendationsRecommendationStreamOutput iTupleRecommendationStream = null;
    transient IIFDynamicGraphCompilationEdgeStreamOutput iTupleEdgeStream = null;
    transient IFocusSinkRecommendationStreamInput inputRecommendationStream = null;
    transient IFocusSinkEdgeStreamInput inputEdgeStream = null;

	public PipelineVar_7_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_Sink0", algorithm));
    }

    @Override
    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        //for now, sink just emits the tuple that get from last familyelement
        if(tuple.getValue(0) instanceof IIFRecommendationsRecommendationStreamOutput) {
            iTupleRecommendationStream = (IIFRecommendationsRecommendationStreamOutput)tuple.getValue(0);
            inputRecommendationStream = new FocusSink.FocusSinkRecommendationStreamInput();
            inputRecommendationStream.setRecommendations(iTupleRecommendationStream.getRecommendations());
            sinkHandler.postDataRecommendationStream(inputRecommendationStream);
        }

        if(tuple.getValue(0) instanceof IIFDynamicGraphCompilationEdgeStreamOutput) {
            iTupleEdgeStream = (IIFDynamicGraphCompilationEdgeStreamOutput)tuple.getValue(0);
            inputEdgeStream = new FocusSink.FocusSinkEdgeStreamInput();
            inputEdgeStream.setEdge(iTupleEdgeStream.getEdge());
            sinkHandler.postDataEdgeStream(inputEdgeStream);
        }

        _collector.ack(tuple);
        aggregateExecutionTime(start);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.focus.FocusSinkAlgorithm");
            sinkHandler = (IFocusSink) cls.newInstance();
		    sinkHandler.connect();
		    sendAlgorithmChangeEvent("FocusSinkAlgorithm");
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

    @Override
    public void cleanup() {
        super.cleanup();
		 sinkHandler.disconnect();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_7_Sink0Stream", new Fields("sinkData"));
    }

}
