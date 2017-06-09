package eu.qualimaster.RandomPip.topology;

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
import eu.qualimaster.algorithms.RandomProcessor1;
import eu.qualimaster.algorithms.RandomProcessor2;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_1_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_1_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private String streamId = "PipelineVar_1_FamilyElement0RandomProcessor1";
    private transient RandomFamily.IRandomFamilyRandomDataOutput randomDataResult = new RandomFamily.IRandomFamilyRandomDataOutput();
    private transient IRandomFamily alg = null; 
    transient IRandomSourceRandomDataOutput iTupleRandomData = null;
    transient IIRandomFamilyRandomDataInput inputRandomData = null;

    public PipelineVar_1_FamilyElement0FamilyElement(String name, String namespace) {
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

        randomDataResult = new RandomFamily.IRandomFamilyRandomDataOutput();
        IItemEmitter<IIRandomFamilyRandomDataOutput> randomDataEmitter = new IItemEmitter<IIRandomFamilyRandomDataOutput>() {
            @Override
            public void emitDirect(String streamId, IIRandomFamilyRandomDataOutput item) {
                _collector.emit("PipelineVar_1_FamilyElement0RandomData", new Values(item));
            }
        };
        randomDataResult.setEmitter(randomDataEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor1");
                    alg = (IRandomFamily) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterDelay(PipelineOptions.getExecutorIntArgument(map, getName(), "delay", 5));
                alg.setParameterFlag(PipelineOptions.getExecutorBooleanArgument(map, getName(), "flag", false));
                alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 10));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("RandomProcessor1", null);
            streamId = "PipelineVar_1_FamilyElement0RandomProcessor1";
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
        // delegate to family "randomFamily"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
    if(tupleItem instanceof IRandomSourceRandomDataOutput) {
        iTupleRandomData = (IRandomSourceRandomDataOutput)tupleItem;
        inputRandomData = new RandomFamily.IRandomFamilyRandomDataInput();
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
        if(alg instanceof ITopologyCreate) {
            _collector.emit(streamId, new Values(inputRandomData));
        }
    }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIRandomFamilyRandomDataOutput> iterRandomData = randomDataResult.iterator();
            iterRandomData.reset();
            while (iterRandomData.hasNext()) {
                IIRandomFamilyRandomDataOutput out = iterRandomData.next();
                _collector.emit("PipelineVar_1_FamilyElement0RandomData", new Values(out));
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
            case "RandomProcessor1":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof RandomProcessor1)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor1");
                        alg = (IRandomFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_1_FamilyElement0RandomProcessor1";
                    alg.setParameterDelay(5);
                    alg.setParameterFlag(false);
                    alg.setParameterWindowSize(10);
                    sendAlgorithmChangeEvent("RandomProcessor1", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "RandomProcessor2":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof RandomProcessor2)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.RandomProcessor2");
                        alg = (IRandomFamily) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_1_FamilyElement0RandomProcessor2";
                    alg.setParameterDelay(0);
                    alg.setParameterFlag(false);
                    alg.setParameterWindowSize(10);
                    sendAlgorithmChangeEvent("RandomProcessor2", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_1_FamilyElement0RandomData", new Fields("PipelineVar_1_FamilyElement0RandomDataFields"));
        declarer.declareStream("PipelineVar_1_FamilyElement0RandomProcessor1", new Fields("PipelineVar_1_FamilyElement0RandomProcessor1Fields"));
        declarer.declareStream("PipelineVar_1_FamilyElement0RandomProcessor2", new Fields("PipelineVar_1_FamilyElement0RandomProcessor2Fields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
