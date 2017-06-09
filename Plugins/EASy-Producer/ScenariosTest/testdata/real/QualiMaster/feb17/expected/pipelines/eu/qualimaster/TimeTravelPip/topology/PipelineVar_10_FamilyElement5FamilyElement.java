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
import eu.qualimaster.families.inf.IFTimeGraphQueryExecutor.*;
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
import eu.qualimaster.timegraph.TimeGraphQueryExecutor;
import eu.qualimaster.families.inf.IFTimeGraphIndexer.*;
import eu.qualimaster.data.inf.ITimeGraphQueriesSource.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_10_FamilyElement5FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_10_FamilyElement5FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput snapshotStreamResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput();
    private transient FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput pathStreamResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput();
    private transient FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput unicastRequestsResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput();
    private transient FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput broadcastRequestsResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput();
    private transient IFTimeGraphQueryExecutor alg = null; 
    private transient List<Integer> taskIdTimeGraphIndexer;
    private int PipelineVar_10_FamilyElement5TaskId;
    transient ITimeGraphQueriesSourceSnapshotQueryStreamOutput iTupleSnapshotQueryStream = null;
    transient ITimeGraphQueriesSourcePathQueryStreamOutput iTuplePathQueryStream = null;
    transient IIFTimeGraphIndexerExternalResponsesOutput iTupleExternalResponses = null;
    transient IIFTimeGraphQueryExecutorSnapshotQueryStreamInput inputSnapshotQueryStream = null;
    transient IIFTimeGraphQueryExecutorPathQueryStreamInput inputPathQueryStream = null;
    transient IIFTimeGraphQueryExecutorExternalResponsesInput inputExternalResponses = null;

    public PipelineVar_10_FamilyElement5FamilyElement(String name, String namespace) {
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
        PipelineVar_10_FamilyElement5TaskId = topologyContext.getThisTaskId();
        logger.info("PipelineVar_10_FamilyElement5TaskId = " + PipelineVar_10_FamilyElement5TaskId);

        snapshotStreamResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput();
        IItemEmitter<IIFTimeGraphQueryExecutorSnapshotStreamOutput> snapshotStreamEmitter = new IItemEmitter<IIFTimeGraphQueryExecutorSnapshotStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphQueryExecutorSnapshotStreamOutput item) {
                _collector.emit("PipelineVar_10_FamilyElement5SnapshotStream", new Values(item));
            }
        };
        snapshotStreamResult.setEmitter(snapshotStreamEmitter);

        pathStreamResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput();
        IItemEmitter<IIFTimeGraphQueryExecutorPathStreamOutput> pathStreamEmitter = new IItemEmitter<IIFTimeGraphQueryExecutorPathStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphQueryExecutorPathStreamOutput item) {
                _collector.emit("PipelineVar_10_FamilyElement5PathStream", new Values(item));
            }
        };
        pathStreamResult.setEmitter(pathStreamEmitter);

        unicastRequestsResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput();
        IItemEmitter<IIFTimeGraphQueryExecutorUnicastRequestsOutput> unicastRequestsEmitter = new IItemEmitter<IIFTimeGraphQueryExecutorUnicastRequestsOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphQueryExecutorUnicastRequestsOutput item) {
                _collector.emitDirect(item.getTaskId(), "PipelineVar_10_FamilyElement5UnicastRequests", new Values(item));
            }
        };
        unicastRequestsResult.setEmitter(unicastRequestsEmitter);

        broadcastRequestsResult = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput();
        IItemEmitter<IIFTimeGraphQueryExecutorBroadcastRequestsOutput> broadcastRequestsEmitter = new IItemEmitter<IIFTimeGraphQueryExecutorBroadcastRequestsOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTimeGraphQueryExecutorBroadcastRequestsOutput item) {
                _collector.emit("PipelineVar_10_FamilyElement5BroadcastRequests", new Values(item));
            }
        };
        broadcastRequestsResult.setEmitter(broadcastRequestsEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphQueryExecutor");
                    alg = (IFTimeGraphQueryExecutor) cls.getConstructor(List.class, int.class).newInstance(taskIdTimeGraphIndexer, PipelineVar_10_FamilyElement5TaskId);
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
		    	sendAlgorithmChangeEvent("TimeGraphQueryExecutor", null);
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
        // delegate to family "fTimeGraphQueryExecutor"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
        if(tupleItem instanceof ITimeGraphQueriesSourceSnapshotQueryStreamOutput) {
            iTupleSnapshotQueryStream = (ITimeGraphQueriesSourceSnapshotQueryStreamOutput)tupleItem;
            inputSnapshotQueryStream = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput();
            inputSnapshotQueryStream.setStart(iTupleSnapshotQueryStream.getStart());
            inputSnapshotQueryStream.setEnd(iTupleSnapshotQueryStream.getEnd());
            try {
                if(alg != null) {
                    alg.calculate(inputSnapshotQueryStream, snapshotStreamResult, pathStreamResult, unicastRequestsResult, broadcastRequestsResult);
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
                snapshotStreamResult.setSnapshot("");
                pathStreamResult.setPath("");
                unicastRequestsResult.setUnicastExternalRequest(null);
                broadcastRequestsResult.setBroadcastExternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof ITimeGraphQueriesSourcePathQueryStreamOutput) {
            iTuplePathQueryStream = (ITimeGraphQueriesSourcePathQueryStreamOutput)tupleItem;
            inputPathQueryStream = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput();
            inputPathQueryStream.setStart(iTuplePathQueryStream.getStart());
            inputPathQueryStream.setEnd(iTuplePathQueryStream.getEnd());
            inputPathQueryStream.setVertexA(iTuplePathQueryStream.getVertexA());
            inputPathQueryStream.setVertexB(iTuplePathQueryStream.getVertexB());
            inputPathQueryStream.setType(iTuplePathQueryStream.getType());
            try {
                if(alg != null) {
                    alg.calculate(inputPathQueryStream, snapshotStreamResult, pathStreamResult, unicastRequestsResult, broadcastRequestsResult);
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
                snapshotStreamResult.setSnapshot("");
                pathStreamResult.setPath("");
                unicastRequestsResult.setUnicastExternalRequest(null);
                broadcastRequestsResult.setBroadcastExternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFTimeGraphIndexerExternalResponsesOutput) {
            iTupleExternalResponses = (IIFTimeGraphIndexerExternalResponsesOutput)tupleItem;
            inputExternalResponses = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput();
            inputExternalResponses.setExternalResponse(iTupleExternalResponses.getExternalResponse());
            try {
                if(alg != null) {
                    alg.calculate(inputExternalResponses, snapshotStreamResult, pathStreamResult, unicastRequestsResult, broadcastRequestsResult);
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
                snapshotStreamResult.setSnapshot("");
                pathStreamResult.setPath("");
                unicastRequestsResult.setUnicastExternalRequest(null);
                broadcastRequestsResult.setBroadcastExternalRequest(null);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphQueryExecutorSnapshotStreamOutput> iterSnapshotStream = snapshotStreamResult.iterator();
            iterSnapshotStream.reset();
            while (iterSnapshotStream.hasNext()) {
                IIFTimeGraphQueryExecutorSnapshotStreamOutput out = iterSnapshotStream.next();
                _collector.emit("PipelineVar_10_FamilyElement5SnapshotStream", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphQueryExecutorPathStreamOutput> iterPathStream = pathStreamResult.iterator();
            iterPathStream.reset();
            while (iterPathStream.hasNext()) {
                IIFTimeGraphQueryExecutorPathStreamOutput out = iterPathStream.next();
                _collector.emit("PipelineVar_10_FamilyElement5PathStream", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphQueryExecutorUnicastRequestsOutput> iterUnicastRequests = unicastRequestsResult.iterator();
            iterUnicastRequests.reset();
            while (iterUnicastRequests.hasNext()) {
                IIFTimeGraphQueryExecutorUnicastRequestsOutput out = iterUnicastRequests.next();
                _collector.emitDirect(out.getTaskId(), "PipelineVar_10_FamilyElement5UnicastRequests", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTimeGraphQueryExecutorBroadcastRequestsOutput> iterBroadcastRequests = broadcastRequestsResult.iterator();
            iterBroadcastRequests.reset();
            while (iterBroadcastRequests.hasNext()) {
                IIFTimeGraphQueryExecutorBroadcastRequestsOutput out = iterBroadcastRequests.next();
                _collector.emit("PipelineVar_10_FamilyElement5BroadcastRequests", new Values(out));
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
            case "TimeGraphQueryExecutor":
                if (!algChange || !(alg instanceof TimeGraphQueryExecutor)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.timegraph.TimeGraphQueryExecutor");
                        alg = (IFTimeGraphQueryExecutor) cls.getConstructor(List.class, int.class).newInstance(taskIdTimeGraphIndexer, PipelineVar_10_FamilyElement5TaskId);
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
                    sendAlgorithmChangeEvent("TimeGraphQueryExecutor", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_10_FamilyElement5SnapshotStream", new Fields("PipelineVar_10_FamilyElement5SnapshotStreamFields"));
        declarer.declareStream("PipelineVar_10_FamilyElement5PathStream", new Fields("PipelineVar_10_FamilyElement5PathStreamFields"));
        declarer.declareStream("PipelineVar_10_FamilyElement5UnicastRequests", new Fields("PipelineVar_10_FamilyElement5UnicastRequestsFields"));
        declarer.declareStream("PipelineVar_10_FamilyElement5BroadcastRequests", new Fields("PipelineVar_10_FamilyElement5BroadcastRequestsFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
