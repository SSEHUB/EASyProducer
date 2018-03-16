package eu.qualimaster.TimeTravelSimPip.topology;

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
import eu.qualimaster.families.inf.IFTimeGraphMapper.*;
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
import eu.qualimaster.timegraph.TimeGraphMapper;
import eu.qualimaster.data.inf.ISimulatedGraphData.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_18_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_18_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput dataStreamResult = new FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput();
    private transient IFTimeGraphMapper alg = null; 
    private transient List<Integer> taskIdTimeGraphIndexer;
    private int PipelineVar_18_FamilyElement0TaskId;
    transient ISimulatedGraphDataEdgeStreamOutput iTupleEdgeStream = null;
    transient IIFTimeGraphMapperEdgeStreamInput inputEdgeStream = null;

    public PipelineVar_18_FamilyElement0FamilyElement(String name, String namespace) {
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
        taskIdTimeGraphIndexer = topologyContext.getComponentTasks("PipelineVar_18_FamilyElement1");
        logger.info("taskIdsTimeGraphIndexer = " + taskIdTimeGraphIndexer);
        PipelineVar_18_FamilyElement0TaskId = topologyContext.getThisTaskId();
        logger.info("PipelineVar_18_FamilyElement0TaskId = " + PipelineVar_18_FamilyElement0TaskId);

        dataStreamResult = new FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput();
        IItemEmitter<IIFTimeGraphMapperDataStreamOutput> dataStreamEmitter = new IItemEmitter<IIFTimeGraphMapperDataStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphMapperDataStreamOutput item) {
                _collector.emitDirect(item.getTaskId(), "PipelineVar_18_FamilyElement0DataStream", new Values(item));
            }
        };
        dataStreamResult.setEmitter(dataStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphMapper");
                    alg = (IFTimeGraphMapper) cls.getConstructor(List.class, int.class).newInstance(taskIdTimeGraphIndexer, PipelineVar_18_FamilyElement0TaskId);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("TimeGraphMapper", null);
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
        // delegate to family "fTimeGraphMapper"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof ISimulatedGraphDataEdgeStreamOutput) {
        iTupleEdgeStream = (ISimulatedGraphDataEdgeStreamOutput)tupleItem;
        inputEdgeStream = new FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput();
        inputEdgeStream.setEdge(iTupleEdgeStream.getEdge());
        try {
            if(alg != null) {
                alg.calculate(inputEdgeStream, dataStreamResult);
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
            dataStreamResult.setUpdate(null);
            dataStreamResult.setIsAddition(false);
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphMapperDataStreamOutput> iterDataStream = dataStreamResult.iterator();
            iterDataStream.reset();
            while (iterDataStream.hasNext()) {
                IIFTimeGraphMapperDataStreamOutput out = iterDataStream.next();
                _collector.emitDirect(out.getTaskId(), "PipelineVar_18_FamilyElement0DataStream", new Values(out));
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
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
        logger.info("Received algorithm switching signal " + signal.getAlgorithm());
        try {
        switch (signal.getAlgorithm()) {
            case "TimeGraphMapper":
                if (!algChange || !(alg instanceof TimeGraphMapper)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphMapper");
                        alg = (IFTimeGraphMapper) cls.getConstructor(List.class, int.class).newInstance(taskIdTimeGraphIndexer, PipelineVar_18_FamilyElement0TaskId);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    sendAlgorithmChangeEvent("TimeGraphMapper", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_18_FamilyElement0DataStream", new Fields("PipelineVar_18_FamilyElement0DataStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
