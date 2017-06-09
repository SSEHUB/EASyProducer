package eu.qualimaster.RandomPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.data.inf.IRandomSink;
import eu.qualimaster.data.inf.IRandomSink.*;
import eu.qualimaster.data.imp.RandomSink;
import eu.qualimaster.algorithms.RandomSinkAlg;
import eu.qualimaster.families.inf.IRandomFamily.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_1_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_1_Sink0Sink.class);
    transient OutputCollector _collector;
    transient IRandomSink sinkHandler;
    transient IIRandomFamilyProccessedDataOutput iTupleProccessedData = null;
    transient IRandomSinkProccessedDataInput inputProccessedData = null;

	public PipelineVar_1_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("RandomPip", "PipelineVar_1_Sink0", algorithm));
    }

    @Override
    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        //for now, sink just emits the tuple that get from last familyelement
    if(tuple.getValue(0) instanceof IIRandomFamilyProccessedDataOutput) {
        iTupleProccessedData = (IIRandomFamilyProccessedDataOutput)tuple.getValue(0);
        inputProccessedData = new RandomSink.RandomSinkProccessedDataInput();
        inputProccessedData.setRandomInteger(iTupleProccessedData.getRandomInteger());
        sinkHandler.postDataProccessedData(inputProccessedData);
    }

        _collector.ack(tuple);
        aggregateExecutionTime(start);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.RandomSinkAlg");
            sinkHandler = (IRandomSink) cls.newInstance();
		    sinkHandler.connect();
		    sendAlgorithmChangeEvent("RandomSinkAlg");
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
        declarer.declareStream("PipelineVar_1_Sink0Stream", new Fields("sinkData"));
    }

}
