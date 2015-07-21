package eu.qualimaster.topologies.PriorityPip;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
import eu.qualimaster.families.inf.IFPreprocessor.*;
import eu.qualimaster.data.inf.ISpringFinancialData.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PriorityPip_FamilyElement1Stream";
    private static transient IIFCorrelationFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialOutput();
    private transient IFCorrelationFinancial alg = null; 
    transient IIFPreprocessorOutput iTuple1 = null;
    transient ISpringFinancialData2Output iTuple2 = null;
    transient IIFCorrelationFinancial1Input input1 = null;
    transient IIFCorrelationFinancial2Input input2 = null;

    public PriorityPip_FamilyElement1FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "FinancialCorrelation", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        input1 = new FCorrelationFinancial.IFCorrelationFinancial1Input();
        input2 = new FCorrelationFinancial.IFCorrelationFinancial2Input();
        alg = new TopoSoftwareCorrelationFinancial();
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
        streamId = "PriorityPip_FamilyElement11TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fCorrelationFinancial"
        if(tuple.getValue(0) instanceof IIFPreprocessorOutput) {
            iTuple1 = (IIFPreprocessorOutput)tuple.getValue(0);
            input1.setSymbolId(iTuple1.getSymbolId());
            input1.setTimestamp(iTuple1.getTimestamp());
            input1.setValue(iTuple1.getValue());
            input1.setVolume(iTuple1.getVolume());
            alg.calculate(input1, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + input1);
                _collector.emit(streamId, tuple, new Values(input1));
            }
        }

        if(tuple.getValue(0) instanceof ISpringFinancialData2Output) {
            iTuple2 = (ISpringFinancialData2Output)tuple.getValue(0);
            input2.setAllSymbols(iTuple2.getAllSymbols());
            alg.calculate(input2, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + input2);
                _collector.emit(streamId, tuple, new Values(input2));
            }
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
       	     switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "windowSize" : 
		         alg.setParameterWindowSize(Integer.parseInt(parts[2])); 
 	             break;
	          }
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParameterParam1(parts[2]); 
 	             break;
	          }*/
 	         } else if ("alg".equals(parts[0])) {
	             switch (parts[1]) {
                    case "TopoSoftwareCorrelationFinancial":
                        if(!(alg instanceof TopoSoftwareCorrelationFinancial)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new TopoSoftwareCorrelationFinancial();
		 					sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
                            streamId = "PriorityPip_FamilyElement11TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
                    case "TopoHardwareCorrelationFinancial":
                        if(!(alg instanceof TopoHardwareCorrelationFinancial)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            alg = new TopoHardwareCorrelationFinancial();
		 					sendAlgorithmChangeEvent("TopoHardwareCorrelationFinancial");
                            streamId = "PriorityPip_FamilyElement12TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
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
        declarer.declareStream("PriorityPip_FamilyElement1Stream", new Fields("IIFCorrelationFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement11TopoStream", new Fields("IIFCorrelationFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement12TopoStream", new Fields("IIFCorrelationFinancialOutput"));
    }

}
