package eu.qualimaster.PriorityPip.topology;

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
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
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
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.families.inf.IFPreprocessor.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private String streamId = "PriorityPip_FamilyElement0StreamPairwiseFinancial";
    private transient IIFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
    private transient IFCorrelationFinancial alg = null; 
    transient IIFPreprocessorPreprocessedStreamOutput iTuplePreprocessedStream = null;
    transient ISpringFinancialDataSymbolListOutput iTupleSymbolList = null;
    transient IIFCorrelationFinancialPreprocessedStreamInput inputPreprocessedStream = null;
    transient IIFCorrelationFinancialSymbolListInput inputSymbolList = null;

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
        result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial");
            alg = (IFCorrelationFinancial) cls.newInstance();
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
        alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 30));
        alg.switchState(State.ACTIVATE); //activate the current algorithm
		sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
        streamId = "PriorityPip_FamilyElement01TopoStream";
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        // delegate to family "fCorrelationFinancial"
        if(tuple.getValue(0) instanceof IIFPreprocessorPreprocessedStreamOutput) {
            iTuplePreprocessedStream = (IIFPreprocessorPreprocessedStreamOutput)tuple.getValue(0);
            inputPreprocessedStream = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
            inputPreprocessedStream.setSymbolId(iTuplePreprocessedStream.getSymbolId());
            inputPreprocessedStream.setTimestamp(iTuplePreprocessedStream.getTimestamp());
            inputPreprocessedStream.setValue(iTuplePreprocessedStream.getValue());
            inputPreprocessedStream.setVolume(iTuplePreprocessedStream.getVolume());
            try {
                alg.calculate(inputPreprocessedStream, result);
            } catch(DefaultModeException e) {
                result.setPairwiseCorrelationFinancial(null);
                sendDefaultModeMonitoringEvent(e);
            }
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputPreprocessedStream));
            }
        }

        if(tuple.getValue(0) instanceof ISpringFinancialDataSymbolListOutput) {
            iTupleSymbolList = (ISpringFinancialDataSymbolListOutput)tuple.getValue(0);
            inputSymbolList = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            try {
                alg.calculate(inputSymbolList, result);
            } catch(DefaultModeException e) {
                result.setPairwiseCorrelationFinancial(null);
                sendDefaultModeMonitoringEvent(e);
            }
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputSymbolList));
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFCorrelationFinancialPairwiseFinancialOutput> iter = result.iterator();
            iter.reset();
            while (iter.hasNext()) {
                IIFCorrelationFinancialPairwiseFinancialOutput out = iter.next();
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
                case "windowSize" :
                    try {
                        System.out.println("Received parameter changing signal windowSize");
                        alg.setParameterWindowSize(para.getIntValue()); 
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
            case "TopoSoftwareCorrelationFinancial":
                if(!(alg instanceof TopoSoftwareCorrelationFinancial)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PriorityPip_FamilyElement01TopoStream";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
                    alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
                break;
            case "TopoHardwareCorrelationFinancial":
                if(!(alg instanceof TopoHardwareCorrelationFinancial)) {
                    alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PriorityPip_FamilyElement02TopoStream";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoHardwareCorrelationFinancial");
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
        declarer.declareStream("PriorityPip_FamilyElement0StreamPairwiseFinancial", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement01TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement02TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
    }

}
