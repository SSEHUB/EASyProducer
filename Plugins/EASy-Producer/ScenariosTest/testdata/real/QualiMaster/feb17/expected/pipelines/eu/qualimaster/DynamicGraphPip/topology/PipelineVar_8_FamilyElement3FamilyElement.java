package eu.qualimaster.DynamicGraphPip.topology;

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
import eu.qualimaster.families.inf.IFDynamicHubComputation.*;
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
import eu.qualimaster.dynamicgraph.TopoDynamicHubComputation;
import eu.qualimaster.families.inf.IFDynamicGraphCompilation.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_8_FamilyElement3FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_8_FamilyElement3FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private String streamId = "PipelineVar_8_FamilyElement3TopoDynamicHubComputation";
    private transient FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput hubStreamResult = new FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput();
    private transient IFDynamicHubComputation alg = null; 
    transient IIFDynamicGraphCompilationEdgeStreamOutput iTupleEdgeStream = null;
    transient IIFDynamicHubComputationEdgeStreamInput inputEdgeStream = null;

    public PipelineVar_8_FamilyElement3FamilyElement(String name, String namespace) {
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

        hubStreamResult = new FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput();
        IItemEmitter<IIFDynamicHubComputationHubStreamOutput> hubStreamEmitter = new IItemEmitter<IIFDynamicHubComputationHubStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFDynamicHubComputationHubStreamOutput item) {
                _collector.emit("PipelineVar_8_FamilyElement3HubStream", new Values(item));
            }
        };
        hubStreamResult.setEmitter(hubStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.dynamicgraph.TopoDynamicHubComputation");
                    alg = (IFDynamicHubComputation) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 30));
                alg.setParameterHubListSize(PipelineOptions.getExecutorIntArgument(map, getName(), "hubListSize", 10));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("TopoDynamicHubComputation", null);
            streamId = "PipelineVar_8_FamilyElement3TopoDynamicHubComputation";
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
        // delegate to family "fDynamicHubComputation"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IIFDynamicGraphCompilationEdgeStreamOutput) {
        iTupleEdgeStream = (IIFDynamicGraphCompilationEdgeStreamOutput)tupleItem;
        inputEdgeStream = new FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput();
        inputEdgeStream.setEdge(iTupleEdgeStream.getEdge());
        try {
            if(alg != null) {
                alg.calculate(inputEdgeStream, hubStreamResult);
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
            hubStreamResult.setHubList("");
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputEdgeStream));
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFDynamicHubComputationHubStreamOutput> iterHubStream = hubStreamResult.iterator();
            iterHubStream.reset();
            while (iterHubStream.hasNext()) {
                IIFDynamicHubComputationHubStreamOutput out = iterHubStream.next();
                _collector.emit("PipelineVar_8_FamilyElement3HubStream", new Values(out));
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
                case "windowSize" :
                    try {
                        System.out.println("Received parameter changing signal windowSize");
                        alg.setParameterWindowSize(para.getIntValue()); 
                        sendParameterChangeEvent("windowSize", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "hubListSize" :
                    try {
                        System.out.println("Received parameter changing signal hubListSize");
                        alg.setParameterHubListSize(para.getIntValue()); 
                        sendParameterChangeEvent("hubListSize", para.getIntValue(), signal.getCauseMessageId());
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
            case "TopoDynamicHubComputation":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof TopoDynamicHubComputation)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.dynamicgraph.TopoDynamicHubComputation");
                        alg = (IFDynamicHubComputation) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement3TopoDynamicHubComputation";
                    alg.setParameterWindowSize(30);
                    alg.setParameterHubListSize(10);
                    sendAlgorithmChangeEvent("TopoDynamicHubComputation", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
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
        declarer.declareStream("PipelineVar_8_FamilyElement3HubStream", new Fields("PipelineVar_8_FamilyElement3HubStreamFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement3TopoDynamicHubComputation", new Fields("PipelineVar_8_FamilyElement3TopoDynamicHubComputationFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
