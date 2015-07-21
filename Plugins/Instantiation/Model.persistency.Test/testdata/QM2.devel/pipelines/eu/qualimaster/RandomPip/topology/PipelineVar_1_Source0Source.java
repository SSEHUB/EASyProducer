package eu.qualimaster.RandomPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.IRandomSource;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.algorithms.RandomSourceAlg;
import eu.qualimaster.common.signal.*;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_1_Source0Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PipelineVar_1_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient IRandomSource sourceData;
    transient IRandomSourceRandomDataOutput dataItemRandomData = null;

    public PipelineVar_1_Source0Source(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.RandomSourceAlg");
            sourceData = (IRandomSource) cls.newInstance();
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
    public void nextTuple() {
        // Emitting stream "PipelineVar_1_Source0StreamRandomData".
        dataItemRandomData = sourceData.getRandomData();
        if(dataItemRandomData!=null){
            _collector.emit("PipelineVar_1_Source0StreamRandomData", new Values(dataItemRandomData),dataItemRandomData);
        }

    }

    /**
    * Receives the signal data for Source adaptation.
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
		         sourceData.setParameterParam1(parts[2]); 
 	             break;
	          }*/
            }
        }
    }

    @Override
    public void close() {
        super.close();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_1_Source0StreamRandomData", new Fields("datastreamRandomData"));
    }
}
