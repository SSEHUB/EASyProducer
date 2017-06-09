package eu.qualimaster.DynamicGraphPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.data.inf.IDynamicGraphSink;
import eu.qualimaster.data.inf.IDynamicGraphSink.*;
import eu.qualimaster.data.imp.DynamicGraphSink;
import eu.qualimaster.dynamicgraph.DynamicGraphSinkAlgorithm;
import eu.qualimaster.families.inf.IFDynamicHubComputation.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_8_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_8_Sink0Sink.class);
    transient OutputCollector _collector;
    transient IDynamicGraphSink sinkHandler;
    transient IIFDynamicHubComputationHubStreamOutput iTupleHubStream = null;
    transient IDynamicGraphSinkHubStreamInput inputHubStream = null;

	public PipelineVar_8_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("DynamicGraphPip", "PipelineVar_8_Sink0", algorithm));
    }

    @Override
    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        //for now, sink just emits the tuple that get from last familyelement
    if(tuple.getValue(0) instanceof IIFDynamicHubComputationHubStreamOutput) {
        iTupleHubStream = (IIFDynamicHubComputationHubStreamOutput)tuple.getValue(0);
        inputHubStream = new DynamicGraphSink.DynamicGraphSinkHubStreamInput();
        inputHubStream.setHubList(iTupleHubStream.getHubList());
        sinkHandler.postDataHubStream(inputHubStream);
    }

        _collector.ack(tuple);
        aggregateExecutionTime(start);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.dynamicgraph.DynamicGraphSinkAlgorithm");
            sinkHandler = (IDynamicGraphSink) cls.newInstance();
		    sinkHandler.connect();
		    sendAlgorithmChangeEvent("DynamicGraphSinkAlgorithm");
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
        declarer.declareStream("PipelineVar_8_Sink0Stream", new Fields("sinkData"));
    }

}
