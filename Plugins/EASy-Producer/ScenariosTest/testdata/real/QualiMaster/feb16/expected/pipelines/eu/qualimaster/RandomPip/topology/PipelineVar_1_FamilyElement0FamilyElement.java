package eu.qualimaster.RandomPip.topology;

import java.util.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import com.esotericsoftware.kryo.io.Output;
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
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.base.serializer.KryoSwitchTupleSerializer;
import backtype.storm.Config;
import eu.qualimaster.base.pipeline.CollectingTopologyInfo;
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
    private String streamId = "PipelineVar_1_FamilyElement0StreamProccessedData";
    private transient IIRandomFamilyProccessedDataOutput result = new RandomFamily.IRandomFamilyProccessedDataOutput();
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
        EventManager.send(new AlgorithmChangedMonitoringEvent("RandomPip", "PipelineVar_1_FamilyElement0", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("RandomPip", "PipelineVar_1_FamilyElement0", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new RandomFamily.IRandomFamilyProccessedDataOutput();
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
        alg.setParameterDelay(PipelineOptions.getExecutorIntArgument(map, getName(), "delay", 0));
        alg.setParameterFlag(PipelineOptions.getExecutorBooleanArgument(map, getName(), "flag", false));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("RandomProcessor1");
        streamId = "PipelineVar_1_FamilyElement01TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "randomFamily"
        iTupleRandomData = (IRandomSourceRandomDataOutput)tuple.getValue(0);
        inputRandomData = new RandomFamily.IRandomFamilyRandomDataInput();
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
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIRandomFamilyProccessedDataOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIRandomFamilyProccessedDataOutput out = iter.next();
                _collector.emit(streamId, new Values(out));
            }
        }
//		 _collector.ack(tuple);
        aggregateExecutionTime(start, result.count());
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        for(int i = 0; i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "delay" :
                    try {
                        System.out.println("Received parameter changing signal delay");
                        alg.setParameterDelay(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "flag" :
                    try {
                        System.out.println("Received parameter changing signal flag");
                        alg.setParameterFlag(para.getBooleanValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        logger.info("Received algorithm switching signal " + signal.getAlgorithm());
        switch (signal.getAlgorithm()) {
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
                    streamId = "PipelineVar_1_FamilyElement01TopoStream";
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(false);
                    sendAlgorithmChangeEvent("RandomProcessor1");
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
                    streamId = "PipelineVar_1_FamilyElement02TopoStream";
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(false);
                    sendAlgorithmChangeEvent("RandomProcessor2");
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
        declarer.declareStream("PipelineVar_1_FamilyElement0StreamProccessedData", new Fields("IIRandomFamilyProccessedDataOutput"));
        declarer.declareStream("PipelineVar_1_FamilyElement01TopoStream", new Fields("IIRandomFamilyProccessedDataOutput"));
        declarer.declareStream("PipelineVar_1_FamilyElement02TopoStream", new Fields("IIRandomFamilyProccessedDataOutput"));
    }

}
