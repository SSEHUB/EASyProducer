package eu.qualimaster.PriorityPip.topology;

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
import eu.qualimaster.families.inf.IFSentimentAnalysis.*;
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
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology;
import eu.qualimaster.data.inf.ITwitterStreamData.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_FamilyElement2FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_FamilyElement2FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private String streamId = "PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopology";
    private transient FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput analyzedStreamResult = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
    private transient IFSentimentAnalysis alg = null; 
    transient ITwitterStreamDataTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFSentimentAnalysisTwitterStreamInput inputTwitterStream = null;

    public PriorityPip_FamilyElement2FamilyElement(String name, String namespace) {
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

        analyzedStreamResult = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
        IItemEmitter<IIFSentimentAnalysisAnalyzedStreamOutput> analyzedStreamEmitter = new IItemEmitter<IIFSentimentAnalysisAnalyzedStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFSentimentAnalysisAnalyzedStreamOutput item) {
                _collector.emit("PriorityPip_FamilyElement2AnalyzedStream", new Values(item));
            }
        };
        analyzedStreamResult.setEmitter(analyzedStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology");
                    alg = (IFSentimentAnalysis) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterTimeSeriesGranularity(PipelineOptions.getExecutorIntArgument(map, getName(), "timeSeriesGranularity", 60));
                alg.setParameterSentimentClass(PipelineOptions.getExecutorIntArgument(map, getName(), "sentimentClass", 10));
                alg.setParameterClassificationThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "classificationThreshold", 2.5));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology", null);
            streamId = "PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopology";
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
        // delegate to family "fSentimentAnalysis"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof ITwitterStreamDataTwitterStreamOutput) {
        iTupleTwitterStream = (ITwitterStreamDataTwitterStreamOutput)tupleItem;
        inputTwitterStream = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        try {
            if(alg != null) {
                alg.calculate(inputTwitterStream, analyzedStreamResult);
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
            analyzedStreamResult.setSymbolId("");
            analyzedStreamResult.setTimestamp(0);
            analyzedStreamResult.setValue(0.0);
            analyzedStreamResult.setVolume(0);
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputTwitterStream));
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFSentimentAnalysisAnalyzedStreamOutput> iterAnalyzedStream = analyzedStreamResult.iterator();
            iterAnalyzedStream.reset();
            while (iterAnalyzedStream.hasNext()) {
                IIFSentimentAnalysisAnalyzedStreamOutput out = iterAnalyzedStream.next();
                _collector.emit("PriorityPip_FamilyElement2AnalyzedStream", new Values(out));
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
                case "timeSeriesGranularity" :
                    try {
                        System.out.println("Received parameter changing signal timeSeriesGranularity");
                        alg.setParameterTimeSeriesGranularity(para.getIntValue()); 
                        sendParameterChangeEvent("timeSeriesGranularity", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "sentimentClass" :
                    try {
                        System.out.println("Received parameter changing signal sentimentClass");
                        alg.setParameterSentimentClass(para.getIntValue()); 
                        sendParameterChangeEvent("sentimentClass", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "classificationThreshold" :
                    try {
                        System.out.println("Received parameter changing signal classificationThreshold");
                        alg.setParameterClassificationThreshold(para.getDoubleValue()); 
                        sendParameterChangeEvent("classificationThreshold", para.getDoubleValue(), signal.getCauseMessageId());
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
            case "SentimentAnaylsisSentiWordNetTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof SentimentAnaylsisSentiWordNetTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology");
                        alg = (IFSentimentAnalysis) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopology";
                    alg.setParameterTimeSeriesGranularity(60);
                    alg.setParameterSentimentClass(10);
                    alg.setParameterClassificationThreshold(2.5);
                    sendAlgorithmChangeEvent("SentimentAnaylsisSentiWordNetTopology", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "SentimentAnaylsisSVMTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof SentimentAnaylsisSVMTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology");
                        alg = (IFSentimentAnalysis) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PriorityPip_FamilyElement2SentimentAnaylsisSVMTopology";
                    alg.setParameterTimeSeriesGranularity(60);
                    alg.setParameterSentimentClass(10);
                    alg.setParameterClassificationThreshold(2.5);
                    sendAlgorithmChangeEvent("SentimentAnaylsisSVMTopology", signal.getCauseMessageId());
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
        declarer.declareStream("PriorityPip_FamilyElement2AnalyzedStream", new Fields("PriorityPip_FamilyElement2AnalyzedStreamFields"));
        declarer.declareStream("PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopology", new Fields("PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopologyFields"));
        declarer.declareStream("PriorityPip_FamilyElement2SentimentAnaylsisSVMTopology", new Fields("PriorityPip_FamilyElement2SentimentAnaylsisSVMTopologyFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
