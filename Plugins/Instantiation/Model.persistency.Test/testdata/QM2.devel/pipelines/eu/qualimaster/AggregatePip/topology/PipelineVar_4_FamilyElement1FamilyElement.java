package eu.qualimaster.AggregatePip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.families.inf.*;
import eu.qualimaster.families.inf.IAggregateFamily.*;
import eu.qualimaster.families.imp.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.base.algorithm.IFamily.State;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.algorithms.AggregationAlg;
import eu.qualimaster.families.inf.IAggregateFamily.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_4_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_4_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PipelineVar_4_FamilyElement1StreamRandomData";
    private static transient IIAggregateFamilyRandomDataOutput result = new AggregateFamily.IAggregateFamilyRandomDataOutput();
    private transient IAggregateFamily alg = null; 
    transient IIAggregateFamilyRandomDataOutput iTupleRandomData = null;
    transient IIAggregateFamilyRandomDataInput inputRandomData = null;

    public PipelineVar_4_FamilyElement1FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("AggregatePip", "PipelineVar_4_FamilyElement1", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("AggregatePip", "PipelineVar_4_FamilyElement1", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputRandomData = new AggregateFamily.IAggregateFamilyRandomDataInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.AggregationAlg");
            alg = (IAggregateFamily) cls.newInstance();
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
        alg.setParameterFactor(PipelineOptions.getExecutorIntArgument(map, getName(), "factor", 1));
        alg.setParameterDelay(PipelineOptions.getExecutorIntArgument(map, getName(), "delay", 0));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("AggregationAlg");
        streamId = "PipelineVar_4_FamilyElement1StreamRandomData";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "aggregateFamily"
        iTupleRandomData = (IIAggregateFamilyRandomDataOutput)tuple.getValue(0);
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
                    case "factor" :
                        System.out.println("Received parameter changing signal factor");
                        alg.setParameterFactor(para.getIntValue()); 
                        break;
                    case "delay" :
                        System.out.println("Received parameter changing signal delay");
                        alg.setParameterDelay(para.getIntValue()); 
                        break;
                }
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_4_FamilyElement1StreamRandomData", new Fields("IIAggregateFamilyRandomDataOutput"));
    }

}
