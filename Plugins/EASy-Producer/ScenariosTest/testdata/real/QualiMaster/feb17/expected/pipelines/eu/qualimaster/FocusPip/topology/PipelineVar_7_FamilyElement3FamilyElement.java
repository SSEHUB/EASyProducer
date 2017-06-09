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
import eu.qualimaster.families.inf.IFTwitterEventDetection.*;
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
import eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm;
import eu.qualimaster.families.inf.IFStockParser.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_7_FamilyElement3FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_7_FamilyElement3FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput twitterStreamResult = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
    private transient IFTwitterEventDetection alg = null; 
    transient IIFStockParserTwitterStreamOutput iTupleTwitterStream = null;
    transient IIFTwitterEventDetectionTwitterStreamInput inputTwitterStream = null;

    public PipelineVar_7_FamilyElement3FamilyElement(String name, String namespace) {
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

        twitterStreamResult = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
        IItemEmitter<IIFTwitterEventDetectionTwitterStreamOutput> twitterStreamEmitter = new IItemEmitter<IIFTwitterEventDetectionTwitterStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTwitterEventDetectionTwitterStreamOutput item) {
                _collector.emit("PipelineVar_7_FamilyElement3TwitterStream", new Values(item));
            }
        };
        twitterStreamResult.setEmitter(twitterStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm");
                    alg = (IFTwitterEventDetection) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterHardThreshold(PipelineOptions.getExecutorIntArgument(map, getName(), "hardThreshold", 1000));
                alg.setParameterPercentageThreshold(PipelineOptions.getExecutorDoubleArgument(map, getName(), "percentageThreshold", 0.5));
                alg.setParameterLengthOfTimeWindow(PipelineOptions.getExecutorIntArgument(map, getName(), "lengthOfTimeWindow", 86400));
                alg.setParameterFrequenceOfCheckForEvent(PipelineOptions.getExecutorIntArgument(map, getName(), "frequenceOfCheckForEvent", 1));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("EventDetectionHardThresholdAlgorithm", null);
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
        // delegate to family "fTwitterEventDetection"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IIFStockParserTwitterStreamOutput) {
        iTupleTwitterStream = (IIFStockParserTwitterStreamOutput)tupleItem;
        inputTwitterStream = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput();
        inputTwitterStream.setStatus(iTupleTwitterStream.getStatus());
        inputTwitterStream.setStocks(iTupleTwitterStream.getStocks());
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
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTwitterEventDetectionTwitterStreamOutput> iterTwitterStream = twitterStreamResult.iterator();
            iterTwitterStream.reset();
            while (iterTwitterStream.hasNext()) {
                IIFTwitterEventDetectionTwitterStreamOutput out = iterTwitterStream.next();
                _collector.emit("PipelineVar_7_FamilyElement3TwitterStream", new Values(out));
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
                case "hardThreshold" :
                    try {
                        System.out.println("Received parameter changing signal hardThreshold");
                        alg.setParameterHardThreshold(para.getIntValue()); 
                        sendParameterChangeEvent("hardThreshold", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "percentageThreshold" :
                    try {
                        System.out.println("Received parameter changing signal percentageThreshold");
                        alg.setParameterPercentageThreshold(para.getDoubleValue()); 
                        sendParameterChangeEvent("percentageThreshold", para.getDoubleValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "lengthOfTimeWindow" :
                    try {
                        System.out.println("Received parameter changing signal lengthOfTimeWindow");
                        alg.setParameterLengthOfTimeWindow(para.getIntValue()); 
                        sendParameterChangeEvent("lengthOfTimeWindow", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "frequenceOfCheckForEvent" :
                    try {
                        System.out.println("Received parameter changing signal frequenceOfCheckForEvent");
                        alg.setParameterFrequenceOfCheckForEvent(para.getIntValue()); 
                        sendParameterChangeEvent("frequenceOfCheckForEvent", para.getIntValue(), signal.getCauseMessageId());
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
            case "EventDetectionHardThresholdAlgorithm":
                if (!algChange || !(alg instanceof EventDetectionHardThresholdAlgorithm)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm");
                        alg = (IFTwitterEventDetection) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterHardThreshold(1000);
                    alg.setParameterPercentageThreshold(0.5);
                    alg.setParameterLengthOfTimeWindow(86400);
                    alg.setParameterFrequenceOfCheckForEvent(1);
                    sendAlgorithmChangeEvent("EventDetectionHardThresholdAlgorithm", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_7_FamilyElement3TwitterStream", new Fields("PipelineVar_7_FamilyElement3TwitterStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
