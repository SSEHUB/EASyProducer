package eu.qualimaster.TimeTravelPip.topology;

import java.util.*;
import java.io.IOException;
import java.lang.NoSuchMethodException;
import java.lang.reflect.InvocationTargetException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.io.PrintWriter;
import eu.qualimaster.common.logging.DataLogger;
import java.net.UnknownHostException;
import com.esotericsoftware.kryo.io.Output;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.monitoring.events.ParameterChangedMonitoringEvent;
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
import eu.qualimaster.pipeline.AlgorithmChangeParameter;
import eu.qualimaster.dynamicgraph.DynamicGraphCompilation;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.inf.IFHayashiYoshida.*;
import eu.qualimaster.families.inf.IFHayashiYoshida.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_10_FamilyElement2FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_10_FamilyElement2FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput edgeStreamResult = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
    private transient IFDynamicGraphCompilation alg = null; 
    transient IIFCorrelationFinancialPairwiseFinancialOutput iTuplePairwiseFinancial = null;
    transient IIFDynamicGraphCompilationPairwiseFinancialInput inputPairwiseFinancial = null;

    public PipelineVar_10_FamilyElement2FamilyElement(String name, String namespace) {
        super(name, namespace, true);
    }

    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     * @param causeMsgId the message id of the causing message (may be empty or null)
     */
    private void sendAlgorithmChangeEvent(String algorithm, String causeMsgId) {
        EventManager.send(new AlgorithmChangedMonitoringEvent(getPipeline(), getName(), algorithm, causeMsgId));
    }

    /**
     * Sends an parameter change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param parameter the parameter to be changed
     * @param value the new value
     * @param causeMsgId the message id of the causing message (may be empty or null)
     */
    private void sendParameterChangeEvent(String parameter, Serializable value, String causeMsgId) {
        EventManager.send(new ParameterChangedMonitoringEvent(getPipeline(), getName(), parameter, value, causeMsgId));
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent(getPipeline(), getName(), exceptionCase));
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        _collector = collector;
        taskId = topologyContext.getThisTaskId();
        algChange = false;

        edgeStreamResult = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
        IItemEmitter<IIFDynamicGraphCompilationEdgeStreamOutput> edgeStreamEmitter = new IItemEmitter<IIFDynamicGraphCompilationEdgeStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFDynamicGraphCompilationEdgeStreamOutput item) {
                _collector.emit("PipelineVar_10_FamilyElement2EdgeStream", new Values(item));
            }
        };
        edgeStreamResult.setEmitter(edgeStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.dynamicgraph.DynamicGraphCompilation");
                    alg = (IFDynamicGraphCompilation) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (PipelineOptions.hasExecutorArgument(map, getName(), "correlationThreshold")) {
                    alg.setParameterCorrelationThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "correlationThreshold", 0.0));
                }
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("DynamicGraphCompilation", null);
                algChange = true;
            } catch (Throwable e) {
                if (e instanceof DefaultModeException) {
                    logger.error("Throwable caught - turning to default mode");
                    e.printStackTrace();
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }
        initMonitor();

        logger.info("The end of the prepare method.");
    }

    @Override
    protected boolean initMonitorDuringPrepare() {
        return false;
    }

    public void forwardTuple(Object tupleItem) {
        startMonitoring();
        // delegate to family "fDynamicGraphCompilation"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IIFCorrelationFinancialPairwiseFinancialOutput) {
        iTuplePairwiseFinancial = (IIFCorrelationFinancialPairwiseFinancialOutput)tupleItem;
        inputPairwiseFinancial = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
        inputPairwiseFinancial.setId0(iTuplePairwiseFinancial.getId0());
        inputPairwiseFinancial.setId1(iTuplePairwiseFinancial.getId1());
        inputPairwiseFinancial.setDate(iTuplePairwiseFinancial.getDate());
        inputPairwiseFinancial.setValue(iTuplePairwiseFinancial.getValue());
        try {
            if(alg != null) {
                alg.calculate(inputPairwiseFinancial, edgeStreamResult);
            } else {
            long now = System.currentTimeMillis();
            if ((now - record) > 1000) {//print this error log once per second
                logger.error("Algorithm is not assigned!");
                record = now;
            }
            }
        } catch(Throwable e) {
            long now = System.currentTimeMillis();
            if ((now - record) > 1000) {//print this error log once per second
                e.printStackTrace();
                record = now;
            }
            edgeStreamResult.setEdge("");
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFDynamicGraphCompilationEdgeStreamOutput> iterEdgeStream = edgeStreamResult.iterator();
            iterEdgeStream.reset();
            while (iterEdgeStream.hasNext()) {
                IIFDynamicGraphCompilationEdgeStreamOutput out = iterEdgeStream.next();
                _collector.emit("PipelineVar_10_FamilyElement2EdgeStream", new Values(out));
            }
        }
//		 _collector.ack(tuple);
        endMonitoring();
    }

    @Override
    public void execute(Tuple tuple) {
        forwardTuple(tuple.getValue(0));
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
        for(int i = 0; alg!=null && i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "correlationThreshold" :
                    try {
                        System.out.println("Received parameter changing signal correlationThreshold");
                        alg.setParameterCorrelationThreshold(para.getDoubleValue()); 
                        sendParameterChangeEvent("correlationThreshold", para.getDoubleValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        } catch (Throwable e) {
            if (e instanceof DefaultModeException) {
                logger.error("Throwable caught - turning to default mode");
                e.printStackTrace();
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }
    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        logger.info("Received algorithm switching signal " + signal.getAlgorithm());
        try {
        switch (signal.getAlgorithm()) {
            case "DynamicGraphCompilation":
                if (!algChange || !(alg instanceof DynamicGraphCompilation)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.dynamicgraph.DynamicGraphCompilation");
                        alg = (IFDynamicGraphCompilation) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterCorrelationThreshold(0.0);
                    sendAlgorithmChangeEvent("DynamicGraphCompilation", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                }
                break;
        }
        super.notifyAlgorithmChange(signal);
        } catch (Throwable e) {
            if (e instanceof DefaultModeException) {
                logger.error("Throwable caught - turning to default mode");
                e.printStackTrace();
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_10_FamilyElement2EdgeStream", new Fields("PipelineVar_10_FamilyElement2EdgeStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
