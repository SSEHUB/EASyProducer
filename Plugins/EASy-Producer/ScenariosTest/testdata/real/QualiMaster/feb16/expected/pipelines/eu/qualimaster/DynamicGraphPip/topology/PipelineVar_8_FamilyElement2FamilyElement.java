package eu.qualimaster.DynamicGraphPip.topology;

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
import eu.qualimaster.families.inf.IFDynamicGraphCompilation.*;
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
import eu.qualimaster.dynamicgraph.DynamicGraphCompilation;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_8_FamilyElement2FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_8_FamilyElement2FamilyElement.class);
    transient OutputCollector _collector;
    private String streamId = "PipelineVar_8_FamilyElement2StreamEdgeStream";
    private transient IIFDynamicGraphCompilationEdgeStreamOutput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
    private transient IFDynamicGraphCompilation alg = null; 
    transient IIFCorrelationFinancialPairwiseFinancialOutput iTuplePairwiseFinancial = null;
    transient IIFDynamicGraphCompilationPairwiseFinancialInput inputPairwiseFinancial = null;

    public PipelineVar_8_FamilyElement2FamilyElement(String name, String namespace) {
        super(name, namespace);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("DynamicGraphPip", "PipelineVar_8_FamilyElement2", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("DynamicGraphPip", "PipelineVar_8_FamilyElement2", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
        try {
            Class cls = Class.forName("eu.qualimaster.dynamicgraph.DynamicGraphCompilation");
            alg = (IFDynamicGraphCompilation) cls.newInstance();
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
		sendAlgorithmChangeEvent("DynamicGraphCompilation");
        streamId = "PipelineVar_8_FamilyElement2StreamEdgeStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fDynamicGraphCompilation"
        iTuplePairwiseFinancial = (IIFCorrelationFinancialPairwiseFinancialOutput)tuple.getValue(0);
        inputPairwiseFinancial = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
        inputPairwiseFinancial.setPairwiseCorrelationFinancial(iTuplePairwiseFinancial.getPairwiseCorrelationFinancial());
        try {
            alg.calculate(inputPairwiseFinancial, result);
        } catch(DefaultModeException e) {
            result.setEdge(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputPairwiseFinancial));
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFDynamicGraphCompilationEdgeStreamOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFDynamicGraphCompilationEdgeStreamOutput out = iter.next();
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
                case "correlationThreshold" :
                    try {
                        System.out.println("Received parameter changing signal correlationThreshold");
                        alg.setParameterCorrelationThreshold(para.getDoubleValue()); 
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
        declarer.declareStream("PipelineVar_8_FamilyElement2StreamEdgeStream", new Fields("IIFDynamicGraphCompilationEdgeStreamOutput"));
        declarer.declareStream("PipelineVar_8_FamilyElement21TopoStream", new Fields("IIFDynamicGraphCompilationEdgeStreamOutput"));
    }

}
