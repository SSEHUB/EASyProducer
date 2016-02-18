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
import eu.qualimaster.families.inf.IFSpamRemoval.*;
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
import eu.qualimaster.algorithms.stream.spam.SpamRemovalBolt;
import eu.qualimaster.families.inf.IFSpamDetection.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private String streamId = "PipelineVar_7_FamilyElement1StreamTwitterStream";
    private transient IIFSpamRemovalTwitterStreamOutput result = new FSpamRemoval.IFSpamRemovalTwitterStreamOutput();
    private transient IFSpamRemoval alg = null; 
    transient IIFSpamDetectionTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFSpamRemovalTwitterStreamInput inputTwitterStream = null;

    public PipelineVar_7_FamilyElement1FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement1", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("FocusPip", "PipelineVar_7_FamilyElement1", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new FSpamRemoval.IFSpamRemovalTwitterStreamOutput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.stream.spam.SpamRemovalBolt");
            alg = (IFSpamRemoval) cls.newInstance();
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
        alg.setParameterSpamThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "spamThreshold", 0.5));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("SpamRemovalBolt");
        streamId = "PipelineVar_7_FamilyElement1StreamTwitterStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fSpamRemoval"
        iTupleTwitterStream = (IIFSpamDetectionTwitterStreamOutput)tuple.getValue(0);
        inputTwitterStream = new FSpamRemoval.IFSpamRemovalTwitterStreamInput();
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        inputTwitterStream.setSpamPropability(iTupleTwitterStream.getSpamPropability());
        try {
            alg.calculate(inputTwitterStream, result);
        } catch(DefaultModeException e) {
            result.setStatus(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputTwitterStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFSpamRemovalTwitterStreamOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFSpamRemovalTwitterStreamOutput out = iter.next();
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
                case "spamThreshold" :
                    try {
                        System.out.println("Received parameter changing signal spamThreshold");
                        alg.setParameterSpamThreshold(para.getDoubleValue()); 
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
        declarer.declareStream("PipelineVar_7_FamilyElement1StreamTwitterStream", new Fields("IIFSpamRemovalTwitterStreamOutput"));
        declarer.declareStream("PipelineVar_7_FamilyElement11TopoStream", new Fields("IIFSpamRemovalTwitterStreamOutput"));
    }

}
