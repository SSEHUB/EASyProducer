package eu.qualimaster.RandomPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IRandomFamily.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.algorithms.RandomProcessor1;
import eu.qualimaster.algorithms.RandomProcessor2;
import eu.qualimaster.data.inf.IRandomSource.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_1_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_1_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PipelineVar_1_FamilyElement0StreamProccessedData";
    private static transient IIRandomFamilyProccessedDataOutput result = new RandomFamily.IRandomFamilyProccessedDataOutput();
    private transient IRandomFamily alg = null; 
    transient IRandomSourceRandomDataOutput iTupleRandomData = null;
    transient IIRandomFamilyRandomDataInput inputRandomData = null;

    public PipelineVar_1_FamilyElement0FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    	    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("RandomPip", "randomFamily", algorithm));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputRandomData = new RandomFamily.IRandomFamilyRandomDataInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor1");
            alg = (IRandomFamily) cls.newInstance();
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
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("RandomProcessor1");
        streamId = "PipelineVar_1_FamilyElement01TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "randomFamily"
        iTupleRandomData = (IRandomSourceRandomDataOutput)tuple.getValue(0);
        inputRandomData.setRandomInteger(iTupleRandomData.getRandomInteger());
        alg.calculate(inputRandomData, result);
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, tuple, new Values(inputRandomData));
        }

        if(!(alg instanceof ITopologyCreate)) {
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
                    case "RandomProcessor1":
                        if(!(alg instanceof RandomProcessor1)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            try {
                                Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor1");
                                alg = (IRandomFamily) cls.newInstance();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
		 					sendAlgorithmChangeEvent("RandomProcessor1");
                            streamId = "PipelineVar_1_FamilyElement01TopoStream";
						    alg.switchState(State.ACTIVATE); //activate the current algorithm
                        }
		                 break;
                    case "RandomProcessor2":
                        if(!(alg instanceof RandomProcessor2)) {
							alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                            try {
                                Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor2");
                                alg = (IRandomFamily) cls.newInstance();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
		 					sendAlgorithmChangeEvent("RandomProcessor2");
                            streamId = "PipelineVar_1_FamilyElement02TopoStream";
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
        declarer.declareStream("PipelineVar_1_FamilyElement0StreamProccessedData", new Fields("IIRandomFamilyProccessedDataOutput"));
        declarer.declareStream("PipelineVar_1_FamilyElement01TopoStream", new Fields("IIRandomFamilyProccessedDataOutput"));
        declarer.declareStream("PipelineVar_1_FamilyElement02TopoStream", new Fields("IIRandomFamilyProccessedDataOutput"));
    }

}
