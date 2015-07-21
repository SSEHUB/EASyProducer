package eu.qualimaster.topologies.PriorityPip;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.algorithms.imp.correlation.SpringClientSimulator;
import eu.qualimaster.common.signal.*;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Source0Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PriorityPip_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient SpringClientSimulator sourceData;
    transient ISpringFinancialData1Output dataItem1 = null;
    transient ISpringFinancialData2Output dataItem2 = null;

    public PriorityPip_Source0Source(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        sourceData = new SpringClientSimulator();
    }

    @Override
    public void nextTuple() {
        // Emitting stream "PriorityPip_Source0Stream2".
        dataItem2 = sourceData.getData2();
        if(dataItem2!=null){
            logger.info("Get data tuple for data source Spout:" + dataItem2);
            _collector.emit("PriorityPip_Source0Stream2", new Values(dataItem2),dataItem2);
        }

        // Emitting stream "PriorityPip_Source0Stream1".
        dataItem1 = sourceData.getData1();
        if(dataItem1!=null){
            logger.info("Get data tuple for data source Spout:" + dataItem1);
            _collector.emit("PriorityPip_Source0Stream1", new Values(dataItem1),dataItem1);
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
        declarer.declareStream("PriorityPip_Source0Stream1", new Fields("datastream1"));
        declarer.declareStream("PriorityPip_Source0Stream2", new Fields("datastream2"));
    }
}
