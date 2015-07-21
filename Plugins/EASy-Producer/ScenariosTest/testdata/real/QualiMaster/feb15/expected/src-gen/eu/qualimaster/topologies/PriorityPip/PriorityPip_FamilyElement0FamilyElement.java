package eu.qualimaster.topologies.PriorityPip;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IFPreprocessor.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
import eu.qualimaster.data.inf.ISpringFinancialData.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PriorityPip_FamilyElement0Stream";
    private static transient IIFPreprocessorOutput result = new FPreprocessor.IFPreprocessorOutput();
    private transient IFPreprocessor alg = null; 
    transient ISpringFinancialData1Output iTuple = null;
    transient IIFPreprocessorInput input = null;

    public PriorityPip_FamilyElement0FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "Preprocessor", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        input = new FPreprocessor.IFPreprocessorInput();
        alg = new Preprocessor();
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("Preprocessor");
        streamId = "PriorityPip_FamilyElement0Stream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fPreprocessor"
        iTuple = (ISpringFinancialData1Output)tuple.getValue(0);
        input.setSymbolTuple(iTuple.getSymbolTuple());
        alg.calculate(input, result);
        if(alg instanceof ITopologyCreate) {
            logger.info("Emitting data with streamId: "+ streamId + ", data:" + input);
            _collector.emit(streamId, tuple, new Values(input));
        }

        if(!(alg instanceof ITopologyCreate)) {
            logger.info("Emitting data with streamId: " + streamId + ", data:" + result);
            _collector.emit(streamId, tuple, new Values(result));
        }
		 _collector.ack(tuple);
    }

    /**
    * Receives the signal data for FamilyElement adaptation.
    * @param data the signal data
    **/
	public void onSignal(byte[] data) {
        String signal=new String(data);
        logger.info("Received signal: " + signal);
        //handle the received signal and make related changes, e.g., switch algorithm from software to hardware
        String[] parts = signal.split(":");
        if (parts.length >= 2) {
            if ("param".equals(parts[0]) && 3 == parts.length) {
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParameterParam1(parts[2]); 
 	             break;
	          }*/
 	         } else if ("alg".equals(parts[0])) {
	             switch (parts[1]) {
	                  case "Preprocessor":
		                 if (!(alg instanceof Preprocessor)) {
		                 alg = new Preprocessor(); 
		 				 sendAlgorithmChangeEvent("Preprocessor");
                         streamId = "PriorityPip_FamilyElement0Stream";
			             }
		                break;
	             }
	         }
        }
	}

    @Override
    public void cleanup() {
        super.cleanup();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_FamilyElement0Stream", new Fields("IIFPreprocessorOutput"));
    }

}
