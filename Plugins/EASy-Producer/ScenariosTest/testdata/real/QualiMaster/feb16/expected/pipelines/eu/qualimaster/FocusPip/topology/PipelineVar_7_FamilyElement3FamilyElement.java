package eu.qualimaster.FocusPip.topology;

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
import eu.qualimaster.families.inf.IFTwitterEventDetection.*;
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
import eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm;
import eu.qualimaster.families.inf.IFStockParser.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_FamilyElement3FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_FamilyElement3FamilyElement.class);
    transient OutputCollector _collector;
    private String streamId = "PipelineVar_7_FamilyElement3StreamTwitterStream";
    private transient IIFTwitterEventDetectionTwitterStreamOutput result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
    private transient IFTwitterEventDetection alg = null; 
    transient IIFStockParserTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFTwitterEventDetectionTwitterStreamInput inputTwitterStream = null;

    public PipelineVar_7_FamilyElement3FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement3", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement3", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm");
            alg = (IFTwitterEventDetection) cls.newInstance();
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
        alg.setParameterHardThreshold(PipelineOptions.getExecutorIntArgument(map, getName(), "hardThreshold", 1000));
        alg.setParameterPercentageThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "percentageThreshold", 0.5));
        alg.setParameterLengthOfTimeWindow(PipelineOptions.getExecutorIntArgument(map, getName(), "lengthOfTimeWindow", 86400));
        alg.setParameterFrequenceOfCheckForEvent(PipelineOptions.getExecutorIntArgument(map, getName(), "frequenceOfCheckForEvent", 1));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("EventDetectionHardThresholdAlgorithm");
        streamId = "PipelineVar_7_FamilyElement3StreamTwitterStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fTwitterEventDetection"
        iTupleTwitterStream = (IIFStockParserTwitterStreamOutput)tuple.getValue(0);
        inputTwitterStream = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput();
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        inputTwitterStream.setStocks(iTupleTwitterStream.getStocks());
        try {
            alg.calculate(inputTwitterStream, result);
        } catch(DefaultModeException e) {
            result.setEvents(null);
            result.setStatus(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTwitterEventDetectionTwitterStreamOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFTwitterEventDetectionTwitterStreamOutput out = iter.next();
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
                case "hardThreshold" :
                    try {
                        System.out.println("Received parameter changing signal hardThreshold");
                        alg.setParameterHardThreshold(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "percentageThreshold" :
                    try {
                        System.out.println("Received parameter changing signal percentageThreshold");
                        alg.setParameterPercentageThreshold(para.getDoubleValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "lengthOfTimeWindow" :
                    try {
                        System.out.println("Received parameter changing signal lengthOfTimeWindow");
                        alg.setParameterLengthOfTimeWindow(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "frequenceOfCheckForEvent" :
                    try {
                        System.out.println("Received parameter changing signal frequenceOfCheckForEvent");
                        alg.setParameterFrequenceOfCheckForEvent(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_7_FamilyElement3StreamTwitterStream", new Fields("IIFTwitterEventDetectionTwitterStreamOutput"));
    }

}
