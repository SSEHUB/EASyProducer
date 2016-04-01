package eu.qualimaster.PriorityPip.topology;

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
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
import eu.qualimaster.data.inf.ISpringFinancialData.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private static String streamId = "PriorityPip_FamilyElement0StreamPreprocessedStream";
    private static transient IIFPreprocessorPreprocessedStreamOutput result = new FPreprocessor.IFPreprocessorPreprocessedStreamOutput();
    private transient IFPreprocessor alg = null; 
    transient ISpringFinancialDataSpringStreamOutput iTupleSpringStream = null;
    transient IIFPreprocessorSpringStreamInput inputSpringStream = null;

    public PriorityPip_FamilyElement0FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement0", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement0", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputSpringStream = new FPreprocessor.IFPreprocessorSpringStreamInput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.Preprocessor");
            alg = (IFPreprocessor) cls.newInstance();
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
		sendAlgorithmChangeEvent("Preprocessor");
        streamId = "PriorityPip_FamilyElement0StreamPreprocessedStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fPreprocessor"
        iTupleSpringStream = (ISpringFinancialDataSpringStreamOutput)tuple.getValue(0);
        inputSpringStream.setSymbolTuple(iTupleSpringStream.getSymbolTuple());
        try {
            alg.calculate(inputSpringStream, result);
        } catch(DefaultModeException e) {
            result.setSymbolId(null);
            result.setTimestamp(0);
            result.setValue(0.0);
            result.setVolume(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputSpringStream));
        }

        if(!(alg instanceof ITopologyCreate)) {
            _collector.emit(streamId, new Values(result));
        }
//		 _collector.ack(tuple);
    }


    @Override
    public void cleanup() {
        super.cleanup();
        alg.switchState(State.TERMINATING);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_FamilyElement0StreamPreprocessedStream", new Fields("IIFPreprocessorPreprocessedStreamOutput"));
    }

}
