package eu.qualimaster.FocusPip.topology;

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
import eu.qualimaster.families.inf.IFKeywordAnalyzer.*;
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
import eu.qualimaster.algorithms.keywordAnalyzer.correlation.BasicKeywordAnalyzerAlgorithm;
import eu.qualimaster.families.inf.IFTwitterEventDetection.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_FamilyElement4FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_FamilyElement4FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput twitterStreamResult = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput();
    private transient IFKeywordAnalyzer alg = null; 
    transient IIFTwitterEventDetectionTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFKeywordAnalyzerTwitterStreamInput inputTwitterStream = null;

    public PipelineVar_7_FamilyElement4FamilyElement(String name, String namespace) {
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

        twitterStreamResult = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput();
        IItemEmitter<IIFKeywordAnalyzerTwitterStreamOutput> twitterStreamEmitter = new IItemEmitter<IIFKeywordAnalyzerTwitterStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFKeywordAnalyzerTwitterStreamOutput item) {
                _collector.emit("PipelineVar_7_FamilyElement4TwitterStream", new Values(item));
            }
        };
        twitterStreamResult.setEmitter(twitterStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.keywordAnalyzer.correlation.BasicKeywordAnalyzerAlgorithm");
                    alg = (IFKeywordAnalyzer) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "threshold", 0.5));
                alg.setParameterDecay(PipelineOptions.getExecutorDoubleArgument(map, getName(), "decay", 0.5));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("BasicKeywordAnalyzerAlgorithm", null);
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
        // delegate to family "fKeywordAnalyzer"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IIFTwitterEventDetectionTwitterStreamOutput) {
        iTupleTwitterStream = (IIFTwitterEventDetectionTwitterStreamOutput)tupleItem;
        inputTwitterStream = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput();
        inputTwitterStream.setEvents(iTupleTwitterStream.getEvents());
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        try {
            if(alg != null) {
                alg.calculate(inputTwitterStream, twitterStreamResult);
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
            twitterStreamResult.setEvents(null);
            twitterStreamResult.setStatus(null);
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFKeywordAnalyzerTwitterStreamOutput> iterTwitterStream = twitterStreamResult.iterator();
            iterTwitterStream.reset();
            while (iterTwitterStream.hasNext()) {
                IIFKeywordAnalyzerTwitterStreamOutput out = iterTwitterStream.next();
                _collector.emit("PipelineVar_7_FamilyElement4TwitterStream", new Values(out));
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
                case "threshold" :
                    try {
                        System.out.println("Received parameter changing signal threshold");
                        alg.setParameterThreshold(para.getDoubleValue()); 
                        sendParameterChangeEvent("threshold", para.getDoubleValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "decay" :
                    try {
                        System.out.println("Received parameter changing signal decay");
                        alg.setParameterDecay(para.getDoubleValue()); 
                        sendParameterChangeEvent("decay", para.getDoubleValue(), signal.getCauseMessageId());
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
            case "BasicKeywordAnalyzerAlgorithm":
                if (!algChange || !(alg instanceof BasicKeywordAnalyzerAlgorithm)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.keywordAnalyzer.correlation.BasicKeywordAnalyzerAlgorithm");
                        alg = (IFKeywordAnalyzer) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterThreshold(0.5);
                    alg.setParameterDecay(0.5);
                    sendAlgorithmChangeEvent("BasicKeywordAnalyzerAlgorithm", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_7_FamilyElement4TwitterStream", new Fields("PipelineVar_7_FamilyElement4TwitterStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
