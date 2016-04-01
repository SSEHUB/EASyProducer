package eu.qualimaster.testDMPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.ISwitchFamily.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.algorithms.SwitchProcessor1;
import eu.qualimaster.algorithms.SwitchProcessor2;
import eu.qualimaster.data.inf.IRandomSource.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_3_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_3_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PipelineVar_3_FamilyElement0StreamProccessedData";
    private static transient IISwitchFamilyProccessedDataOutput result = new SwitchFamily.ISwitchFamilyProccessedDataOutput();
    private transient ISwitchFamily alg = null; 
    transient IRandomSourceRandomDataOutput iTupleRandomData = null;
    transient IISwitchFamilyRandomDataInput inputRandomData = null;

    public PipelineVar_3_FamilyElement0FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("testDMPip", "PipelineVar_3_FamilyElement0", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("testDMPip", "PipelineVar_3_FamilyElement0", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputRandomData = new SwitchFamily.ISwitchFamilyRandomDataInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor1");
            alg = (ISwitchFamily) cls.newInstance();
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
        alg.setParameterDelay(PipelineOptions.getExecutorIntArgument(map, getName(), "delay", 0));
        alg.setParameterFlag(PipelineOptions.getExecutorBooleanArgument(map, getName(), "flag", false));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("SwitchProcessor1");
        streamId = "PipelineVar_3_FamilyElement0StreamProccessedData";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "switchFamily"
        iTupleRandomData = (IRandomSourceRandomDataOutput)tuple.getValue(0);
        inputRandomData.setRandomInteger(iTupleRandomData.getRandomInteger());
        try {
            alg.calculate(inputRandomData, result);
        } catch(DefaultModeException e) {
            result.setRandomInteger(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputRandomData));
        }

        if(!(alg instanceof ITopologyCreate)) {
            _collector.emit(streamId, new Values(result));
        }
//		 _collector.ack(tuple);
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
            for(int i = 0; i < signal.getChangeCount(); i++) {
                ParameterChange para = signal.getChange(i);
                switch (para.getName()) {
                    case "delay" :
                        System.out.println("Received parameter changing signal delay");
                        alg.setParameterDelay(para.getIntValue()); 
                        break;
                    case "flag" :
                        System.out.println("Received parameter changing signal flag");
                        alg.setParameterFlag(para.getBooleanValue()); 
                        break;
                }
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        System.out.println("Received algorithm switching signal " + signal.getAlgorithm());
        switch (signal.getAlgorithm()) {
            case "SwitchProcessor1":
                if (!(alg instanceof SwitchProcessor1)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor1");
                        alg = (ISwitchFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(false);
                    streamId = "PipelineVar_3_FamilyElement0StreamProccessedData";
                    sendAlgorithmChangeEvent("SwitchProcessor1");
                    alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
                break;
            case "SwitchProcessor2":
                if (!(alg instanceof SwitchProcessor2)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor2");
                        alg = (ISwitchFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(false);
                    streamId = "PipelineVar_3_FamilyElement0StreamProccessedData";
                    sendAlgorithmChangeEvent("SwitchProcessor2");
                    alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
                break;
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_3_FamilyElement0StreamProccessedData", new Fields("IISwitchFamilyProccessedDataOutput"));
    }

}
