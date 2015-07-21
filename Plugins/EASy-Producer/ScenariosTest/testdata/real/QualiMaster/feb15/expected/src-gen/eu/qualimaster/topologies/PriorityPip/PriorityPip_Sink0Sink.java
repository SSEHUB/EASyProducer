package eu.qualimaster.topologies.PriorityPip;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.data.inf.IPriorityDataSink;
import eu.qualimaster.data.inf.IPriorityDataSink.*;
import eu.qualimaster.data.imp.PriorityDataSink;
import eu.qualimaster.algorithms.imp.correlation.PriorityDataSinkForFinancialAndTwitter;
import eu.qualimaster.families.inf.IFCorrelationTwitter.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_Sink0Sink.class);
    transient OutputCollector _collector;
    transient IPriorityDataSink sinkHandler;
    transient IIFCorrelationTwitterOutput iTuple2 = null;
    transient IPriorityDataSink1Input input1 = null;
    transient IPriorityDataSink2Input input2 = null;

	public PriorityPip_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void execute(Tuple tuple) {
        //for now, sink just emits the tuple that get from last familyelement
            input1 = new PriorityDataSink.PriorityDataSink1Input();
            input1.setPairwiseCorrelationFinancial(iTuple1.getPairwiseCorrelationFinancial());
            sinkHandler.postData1(input1);
        }

        if(tuple.getValue(0) instanceof IIFCorrelationTwitterOutput) {
            iTuple2 = (IIFCorrelationTwitterOutput)tuple.getValue(0);
            input2 = new PriorityDataSink.PriorityDataSink2Input();
            input2.setPairwiseCorrelationTwitter(iTuple2.getPairwiseCorrelationTwitter());
            sinkHandler.postData2(input2);
        }

        _collector.ack(tuple);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        sinkHandler = new PriorityDataSinkForFinancialAndTwitter();
    }

    @Override
    public void cleanup() {
        super.cleanup();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_Sink0Stream", new Fields("sinkData"));
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
