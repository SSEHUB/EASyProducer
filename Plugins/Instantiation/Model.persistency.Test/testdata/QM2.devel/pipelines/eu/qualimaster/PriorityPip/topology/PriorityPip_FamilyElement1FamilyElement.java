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
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
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
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement1", algorithm));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_FamilyElement1", exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        inputPreprocessedStream = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
        inputSymbolList = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
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
                    case "windowSize" :
                        System.out.println("Received parameter changing signal windowSize");
                        alg.setParameterWindowSize(para.getIntValue()); 
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
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial");
                    streamId = "PriorityPip_FamilyElement11TopoStream";
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
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoHardwareCorrelationFinancial");
                    streamId = "PriorityPip_FamilyElement12TopoStream";
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
        declarer.declareStream("PriorityPip_FamilyElement1StreamPairwiseFinancial", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement11TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
        declarer.declareStream("PriorityPip_FamilyElement12TopoStream", new Fields("IIFCorrelationFinancialPairwiseFinancialOutput"));
    }

}
