package eu.qualimaster.RandomSubPipeline2.topology;

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
import eu.qualimaster.families.inf.ISwitchFamily.*;
import eu.qualimaster.families.inf.IRandomFamily.*;
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
import eu.qualimaster.algorithms.SwitchProcessor1;
import eu.qualimaster.algorithms.SwitchProcessor2;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class SubPipelineVar_15_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(SubPipelineVar_15_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient SwitchFamily.ISwitchFamilyRandomDataOutput randomDataResult = new SwitchFamily.ISwitchFamilyRandomDataOutput();
    private transient ISwitchFamily alg = null; 
    transient IIRandomFamilyRandomDataInput iTupleRandomData = null;
    transient IISwitchFamilyRandomDataInput inputRandomData = null;

    public SubPipelineVar_15_FamilyElement0FamilyElement(String name, String namespace) {
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

        randomDataResult = new SwitchFamily.ISwitchFamilyRandomDataOutput();
        IItemEmitter<IISwitchFamilyRandomDataOutput> randomDataEmitter = new IItemEmitter<IISwitchFamilyRandomDataOutput>() {
            @Override
            public void emitDirect(String streamId, IISwitchFamilyRandomDataOutput item) {
                _collector.emit("DataProcessor2RandomData", new Values(item));
            }
        };
        randomDataResult.setEmitter(randomDataEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor1");
                    alg = (ISwitchFamily) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterAggregationFactor(PipelineOptions.getExecutorIntArgument(map, getName(), "aggregationFactor", 0));
                alg.setParameterDelay(PipelineOptions.getExecutorIntArgument(map, getName(), "delay", 0));
                alg.setParameterFlag(PipelineOptions.getExecutorBooleanArgument(map, getName(), "flag", true));
                alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 10));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("SwitchProcessor1", null);
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
        // delegate to family "switchFamily"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IIRandomFamilyRandomDataInput) {
        iTupleRandomData = (IIRandomFamilyRandomDataInput)tupleItem;
        inputRandomData = new SwitchFamily.ISwitchFamilyRandomDataInput();
        inputRandomData.setRandomInteger(iTupleRandomData.getRandomInteger());
        inputRandomData.setTimestamp(iTupleRandomData.getTimestamp());
        try {
            if(alg != null) {
                alg.calculate(inputRandomData, randomDataResult);
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
            randomDataResult.setRandomInteger(0);
            randomDataResult.setTimestamp(0);
            if (e instanceof DefaultModeException) {
                sendDefaultModeMonitoringEvent((DefaultModeException) e);
            }
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IISwitchFamilyRandomDataOutput> iterRandomData = randomDataResult.iterator();
            iterRandomData.reset();
            while (iterRandomData.hasNext()) {
                IISwitchFamilyRandomDataOutput out = iterRandomData.next();
                _collector.emit("DataProcessor2RandomData", new Values(out));
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
                case "aggregationFactor" :
                    try {
                        System.out.println("Received parameter changing signal aggregationFactor");
                        alg.setParameterAggregationFactor(para.getIntValue()); 
                        sendParameterChangeEvent("aggregationFactor", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delay" :
                    try {
                        System.out.println("Received parameter changing signal delay");
                        alg.setParameterDelay(para.getIntValue()); 
                        sendParameterChangeEvent("delay", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "flag" :
                    try {
                        System.out.println("Received parameter changing signal flag");
                        alg.setParameterFlag(para.getBooleanValue()); 
                        sendParameterChangeEvent("flag", para.getBooleanValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "windowSize" :
                    try {
                        System.out.println("Received parameter changing signal windowSize");
                        alg.setParameterWindowSize(para.getIntValue()); 
                        sendParameterChangeEvent("windowSize", para.getIntValue(), signal.getCauseMessageId());
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
            case "SwitchProcessor1":
                if (!algChange || !(alg instanceof SwitchProcessor1)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor1");
                        alg = (ISwitchFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterAggregationFactor(0);
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(true);
                    alg.setParameterWindowSize(10);
                    sendAlgorithmChangeEvent("SwitchProcessor1", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                }
                break;
            case "SwitchProcessor2":
                if (!algChange || !(alg instanceof SwitchProcessor2)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.SwitchProcessor2");
                        alg = (ISwitchFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterAggregationFactor(0);
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(true);
                    alg.setParameterWindowSize(10);
                    sendAlgorithmChangeEvent("SwitchProcessor2", signal.getCauseMessageId());
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
        declarer.declareStream("DataProcessor2RandomData", new Fields("DataProcessor2RandomDataFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
