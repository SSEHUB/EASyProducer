package eu.qualimaster.RandomPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
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

    @Override
    public void execute(Tuple tuple) {
        //for now, sink just emits the tuple that get from last familyelement
        iTupleProccessedData = (IIRandomFamilyProccessedDataOutput)tuple.getValue(0);
        inputProccessedData = new RandomSink.RandomSinkProccessedDataInput();
        inputProccessedData.setRandomInteger(iTupleProccessedData.getRandomInteger());
        sinkHandler.postDataProccessedData(inputProccessedData);

        _collector.ack(tuple);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.RandomSinkAlg");
            sinkHandler = (IRandomSink) cls.newInstance();
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
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_1_Sink0Stream", new Fields("sinkData"));
    }

    /**
    * Receives the signal data for Sink adaptation.
    * @param data the signal data
    **/
    @Override
    public void onSignal(byte[] data) {
        String signal=new String(data);
        logger.info("Received signal: " + signal);
        //handle the received signal and make related changes, e.g., give a parameter to Source
        String[] parts = signal.split(":");
        if (parts.length >= 2) {
            if ("param".equals(parts[0]) && 3 == parts.length) {
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParameterParam1(parts[2]); 
 	             break;
	          }*/
            }
        }
    }
}
