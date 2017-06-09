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
import eu.qualimaster.families.inf.IFTimeGraphIndexer.*;
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
import eu.qualimaster.timegraph.TimeGraphIndexer;
import eu.qualimaster.families.inf.IFTimeGraphMapper.*;
import eu.qualimaster.families.inf.IFTimeGraphIndexer.*;
import eu.qualimaster.families.inf.IFTimeGraphQueryExecutor.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_10_FamilyElement4FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_10_FamilyElement4FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput externalResponsesResult = new FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput();
    private transient FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput internalRequestsResult = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput();
    private transient IFTimeGraphIndexer alg = null; 
    private transient List<Integer> taskIdTimeGraphIndexer;
    private transient List<Integer> taskIdTimeGraphQueryExecutor;
    private int PipelineVar_10_FamilyElement4TaskId;
    transient IIFTimeGraphMapperDataStreamOutput iTupleDataStream = null;
    transient IIFTimeGraphIndexerInternalRequestsOutput iTupleInternalRequests = null;
    transient IIFTimeGraphQueryExecutorUnicastRequestsOutput iTupleUnicastRequests = null;
    transient IIFTimeGraphQueryExecutorBroadcastRequestsOutput iTupleBroadcastRequests = null;
    transient IIFTimeGraphIndexerDataStreamInput inputDataStream = null;
    transient IIFTimeGraphIndexerInternalRequestsInput inputInternalRequests = null;
    transient IIFTimeGraphIndexerUnicastRequestsInput inputUnicastRequests = null;
    transient IIFTimeGraphIndexerBroadcastRequestsInput inputBroadcastRequests = null;

    public PipelineVar_10_FamilyElement4FamilyElement(String name, String namespace) {
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
        taskIdTimeGraphIndexer = topologyContext.getComponentTasks("PipelineVar_10_FamilyElement4");
        logger.info("taskIdsTimeGraphIndexer = " + taskIdTimeGraphIndexer);
        taskIdTimeGraphQueryExecutor = topologyContext.getComponentTasks("PipelineVar_10_FamilyElement5");
        logger.info("taskIdsTimeGraphQueryExecutor = " + taskIdTimeGraphQueryExecutor);
        PipelineVar_10_FamilyElement4TaskId = topologyContext.getThisTaskId();
        logger.info("PipelineVar_10_FamilyElement4TaskId = " + PipelineVar_10_FamilyElement4TaskId);

        externalResponsesResult = new FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput();
        IItemEmitter<IIFTimeGraphIndexerExternalResponsesOutput> externalResponsesEmitter = new IItemEmitter<IIFTimeGraphIndexerExternalResponsesOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphIndexerExternalResponsesOutput item) {
                _collector.emitDirect(item.getTaskId(), "PipelineVar_10_FamilyElement4ExternalResponses", new Values(item));
            }
        };
        externalResponsesResult.setEmitter(externalResponsesEmitter);

        internalRequestsResult = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput();
        IItemEmitter<IIFTimeGraphIndexerInternalRequestsOutput> internalRequestsEmitter = new IItemEmitter<IIFTimeGraphIndexerInternalRequestsOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphIndexerInternalRequestsOutput item) {
                _collector.emitDirect(item.getTaskId(), "PipelineVar_10_FamilyElement4InternalRequests", new Values(item));
            }
        };
        internalRequestsResult.setEmitter(internalRequestsEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphIndexer");
                    alg = (IFTimeGraphIndexer) cls.getConstructor(List.class, List.class, int.class).newInstance(taskIdTimeGraphIndexer, taskIdTimeGraphQueryExecutor, PipelineVar_10_FamilyElement4TaskId);
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
		    	sendAlgorithmChangeEvent("TimeGraphIndexer", null);
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
        // delegate to family "fTimeGraphIndexer"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
        if(tupleItem instanceof IIFTimeGraphMapperDataStreamOutput) {
            iTupleDataStream = (IIFTimeGraphMapperDataStreamOutput)tupleItem;
            inputDataStream = new FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput();
            inputDataStream.setUpdate(iTupleDataStream.getUpdate());
            inputDataStream.setIsAddition(iTupleDataStream.getIsAddition());
            try {
                if(alg != null) {
                    alg.calculate(inputDataStream, externalResponsesResult, internalRequestsResult);
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
                externalResponsesResult.setExternalResponse(null);
                internalRequestsResult.setInternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFTimeGraphIndexerInternalRequestsOutput) {
            iTupleInternalRequests = (IIFTimeGraphIndexerInternalRequestsOutput)tupleItem;
            inputInternalRequests = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput();
            inputInternalRequests.setInternalRequest(iTupleInternalRequests.getInternalRequest());
            try {
                if(alg != null) {
                    alg.calculate(inputInternalRequests, externalResponsesResult, internalRequestsResult);
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
                externalResponsesResult.setExternalResponse(null);
                internalRequestsResult.setInternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFTimeGraphQueryExecutorUnicastRequestsOutput) {
            iTupleUnicastRequests = (IIFTimeGraphQueryExecutorUnicastRequestsOutput)tupleItem;
            inputUnicastRequests = new FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput();
            inputUnicastRequests.setUnicastExternalRequest(iTupleUnicastRequests.getUnicastExternalRequest());
            try {
                if(alg != null) {
                    alg.calculate(inputUnicastRequests, externalResponsesResult, internalRequestsResult);
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
                externalResponsesResult.setExternalResponse(null);
                internalRequestsResult.setInternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFTimeGraphQueryExecutorBroadcastRequestsOutput) {
            iTupleBroadcastRequests = (IIFTimeGraphQueryExecutorBroadcastRequestsOutput)tupleItem;
            inputBroadcastRequests = new FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput();
            inputBroadcastRequests.setBroadcastExternalRequest(iTupleBroadcastRequests.getBroadcastExternalRequest());
            try {
                if(alg != null) {
                    alg.calculate(inputBroadcastRequests, externalResponsesResult, internalRequestsResult);
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
                externalResponsesResult.setExternalResponse(null);
                internalRequestsResult.setInternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphIndexerExternalResponsesOutput> iterExternalResponses = externalResponsesResult.iterator();
            iterExternalResponses.reset();
            while (iterExternalResponses.hasNext()) {
                IIFTimeGraphIndexerExternalResponsesOutput out = iterExternalResponses.next();
                _collector.emitDirect(out.getTaskId(), "PipelineVar_10_FamilyElement4ExternalResponses", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphIndexerInternalRequestsOutput> iterInternalRequests = internalRequestsResult.iterator();
            iterInternalRequests.reset();
            while (iterInternalRequests.hasNext()) {
                IIFTimeGraphIndexerInternalRequestsOutput out = iterInternalRequests.next();
                _collector.emitDirect(out.getTaskId(), "PipelineVar_10_FamilyElement4InternalRequests", new Values(out));
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
            case "TimeGraphIndexer":
                if (!algChange || !(alg instanceof TimeGraphIndexer)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphIndexer");
                        alg = (IFTimeGraphIndexer) cls.getConstructor(List.class, List.class, int.class).newInstance(taskIdTimeGraphIndexer, taskIdTimeGraphQueryExecutor, PipelineVar_10_FamilyElement4TaskId);
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
                    sendAlgorithmChangeEvent("TimeGraphIndexer", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_10_FamilyElement4ExternalResponses", new Fields("PipelineVar_10_FamilyElement4ExternalResponsesFields"));
        declarer.declareStream("PipelineVar_10_FamilyElement4InternalRequests", new Fields("PipelineVar_10_FamilyElement4InternalRequestsFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
