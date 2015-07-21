package eu.qualimaster.PriorityPip.topology;

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
    private static String streamId = "PriorityPip_FamilyElement1StreamPairwiseFinancial";
    private static transient IIFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
    private transient IFCorrelationFinancial alg = null; 
    transient IIFPreprocessorPreprocessedStreamOutput iTuplePreprocessedStream = null;
    transient ISpringFinancialDataSymbolListOutput iTupleSymbolList = null;
    transient IIFCorrelationFinancialPreprocessedStreamInput inputPreprocessedStream = null;
    transient IIFCorrelationFinancialSymbolListInput inputSymbolList = null;

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
        inputPreprocessedStream = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
        inputSymbolList = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
        alg = new TopoSoftwareCorrelationFinancial();
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
        streamId = "PriorityPip_FamilyElement11TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fCorrelationFinancial"
        if(tuple.getValue(0) instanceof IIFPreprocessorPreprocessedStreamOutput) {
            iTuplePreprocessedStream = (IIFPreprocessorPreprocessedStreamOutput)tuple.getValue(0);
            inputPreprocessedStream.setSymbolId(iTuplePreprocessedStream.getSymbolId());
            inputPreprocessedStream.setTimestamp(iTuplePreprocessedStream.getTimestamp());
            inputPreprocessedStream.setValue(iTuplePreprocessedStream.getValue());
            inputPreprocessedStream.setVolume(iTuplePreprocessedStream.getVolume());
            alg.calculate(inputPreprocessedStream, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + inputPreprocessedStream);
                _collector.emit(streamId, tuple, new Values(inputPreprocessedStream));
            }
        }

        if(tuple.getValue(0) instanceof ISpringFinancialDataSymbolListOutput) {
            iTupleSymbolList = (ISpringFinancialDataSymbolListOutput)tuple.getValue(0);
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            alg.calculate(inputSymbolList, result);
            if(alg instanceof ITopologyCreate) {
                logger.info("Emitting data with streamId: "+ streamId + ", data:" + inputSymbolList);
                _collector.emit(streamId, tuple, new Values(inputSymbolList));
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
        declarer.declareStream("PriorityPip_FamilyElement1StreamPairwiseFinancial", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement11TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement12TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
    }

}
