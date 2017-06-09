package eu.qualimaster.CorrelationSWAlternative.topology;

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
import eu.qualimaster.families.inf.IFMapper.*;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
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
import eu.qualimaster.algorithms.imp.correlation.Mapper;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class SubPipelineVar_19_FamilyElement0FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(SubPipelineVar_19_FamilyElement0FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FMapper.IFMapperSymbolsStreamOutput symbolsStreamResult = new FMapper.IFMapperSymbolsStreamOutput();
    private transient FMapper.IFMapperConfigurationStreamOutput configurationStreamResult = new FMapper.IFMapperConfigurationStreamOutput();
    private transient FMapper.IFMapperResetWindowStreamOutput resetWindowStreamResult = new FMapper.IFMapperResetWindowStreamOutput();
    private transient IFMapper alg = null; 
    private transient List<Integer> taskIdHY;
    private int SubPipelineVar_19_FamilyElement0TaskId;
    transient IIFCorrelationFinancialPreprocessedStreamInput iTuplePreprocessedStream = null;
    transient IIFCorrelationFinancialSymbolListInput iTupleSymbolList = null;
    transient IIFMapperPreprocessedStreamInput inputPreprocessedStream = null;
    transient IIFMapperSymbolListInput inputSymbolList = null;

    public SubPipelineVar_19_FamilyElement0FamilyElement(String name, String namespace) {
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
        taskIdHY = topologyContext.getComponentTasks("CorrelationSWAlternativeHY");
        logger.info("taskIdsHY = " + taskIdHY);
        SubPipelineVar_19_FamilyElement0TaskId = topologyContext.getThisTaskId();
        logger.info("SubPipelineVar_19_FamilyElement0TaskId = " + SubPipelineVar_19_FamilyElement0TaskId);

        symbolsStreamResult = new FMapper.IFMapperSymbolsStreamOutput();
        IItemEmitter<IIFMapperSymbolsStreamOutput> symbolsStreamEmitter = new IItemEmitter<IIFMapperSymbolsStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFMapperSymbolsStreamOutput item) {
                _collector.emitDirect(item.getTaskId(), "MPSymbolsStream", new Values(item));
            }
        };
        symbolsStreamResult.setEmitter(symbolsStreamEmitter);

        configurationStreamResult = new FMapper.IFMapperConfigurationStreamOutput();
        IItemEmitter<IIFMapperConfigurationStreamOutput> configurationStreamEmitter = new IItemEmitter<IIFMapperConfigurationStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFMapperConfigurationStreamOutput item) {
                _collector.emitDirect(item.getTaskId(), "MPConfigurationStream", new Values(item));
            }
        };
        configurationStreamResult.setEmitter(configurationStreamEmitter);

        resetWindowStreamResult = new FMapper.IFMapperResetWindowStreamOutput();
        IItemEmitter<IIFMapperResetWindowStreamOutput> resetWindowStreamEmitter = new IItemEmitter<IIFMapperResetWindowStreamOutput>() {
            @Override
            public void emitDirect(String streamId, IIFMapperResetWindowStreamOutput item) {
                _collector.emit("MPResetWindowStream", new Values(item));
            }
        };
        resetWindowStreamResult.setEmitter(resetWindowStreamEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.Mapper");
                    alg = (IFMapper) cls.getConstructor(List.class, int.class).newInstance(taskIdHY, SubPipelineVar_19_FamilyElement0TaskId);
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
                if (PipelineOptions.hasExecutorArgument(map, getName(), "windowSize")) {
                    alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 0));
                }
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("Mapper", null);
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
        // delegate to family "fMapper"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
        if(tupleItem instanceof IIFCorrelationFinancialPreprocessedStreamInput) {
            iTuplePreprocessedStream = (IIFCorrelationFinancialPreprocessedStreamInput)tupleItem;
            inputPreprocessedStream = new FMapper.IFMapperPreprocessedStreamInput();
            inputPreprocessedStream.setSymbolId(iTuplePreprocessedStream.getSymbolId());
            inputPreprocessedStream.setTimestamp(iTuplePreprocessedStream.getTimestamp());
            inputPreprocessedStream.setValue(iTuplePreprocessedStream.getValue());
            inputPreprocessedStream.setVolume(iTuplePreprocessedStream.getVolume());
            try {
                if(alg != null) {
                    alg.calculate(inputPreprocessedStream, symbolsStreamResult, configurationStreamResult, resetWindowStreamResult);
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
                symbolsStreamResult.setSymbolId("");
                symbolsStreamResult.setTimestamp(0);
                symbolsStreamResult.setValue(0.0);
                configurationStreamResult.setPairKey("");
                configurationStreamResult.setPairValue("");
                resetWindowStreamResult.setWindowStart(0);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFCorrelationFinancialSymbolListInput) {
            iTupleSymbolList = (IIFCorrelationFinancialSymbolListInput)tupleItem;
            inputSymbolList = new FMapper.IFMapperSymbolListInput();
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            try {
                if(alg != null) {
                    alg.calculate(inputSymbolList, symbolsStreamResult, configurationStreamResult, resetWindowStreamResult);
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
                symbolsStreamResult.setSymbolId("");
                symbolsStreamResult.setTimestamp(0);
                symbolsStreamResult.setValue(0.0);
                configurationStreamResult.setPairKey("");
                configurationStreamResult.setPairValue("");
                resetWindowStreamResult.setWindowStart(0);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFMapperSymbolsStreamOutput> iterSymbolsStream = symbolsStreamResult.iterator();
            iterSymbolsStream.reset();
            while (iterSymbolsStream.hasNext()) {
                IIFMapperSymbolsStreamOutput out = iterSymbolsStream.next();
                _collector.emitDirect(out.getTaskId(), "MPSymbolsStream", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFMapperConfigurationStreamOutput> iterConfigurationStream = configurationStreamResult.iterator();
            iterConfigurationStream.reset();
            while (iterConfigurationStream.hasNext()) {
                IIFMapperConfigurationStreamOutput out = iterConfigurationStream.next();
                _collector.emitDirect(out.getTaskId(), "MPConfigurationStream", new Values(out));
            }
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFMapperResetWindowStreamOutput> iterResetWindowStream = resetWindowStreamResult.iterator();
            iterResetWindowStream.reset();
            while (iterResetWindowStream.hasNext()) {
                IIFMapperResetWindowStreamOutput out = iterResetWindowStream.next();
                _collector.emit("MPResetWindowStream", new Values(out));
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
            case "Mapper":
                if (!algChange || !(alg instanceof Mapper)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.Mapper");
                        alg = (IFMapper) cls.getConstructor(List.class, int.class).newInstance(taskIdHY, SubPipelineVar_19_FamilyElement0TaskId);
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
                    alg.setParameterWindowSize(0);
                    sendAlgorithmChangeEvent("Mapper", signal.getCauseMessageId());
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
        declarer.declareStream("MPSymbolsStream", new Fields("MPSymbolsStreamFields"));
        declarer.declareStream("MPConfigurationStream", new Fields("MPConfigurationStreamFields"));
        declarer.declareStream("MPResetWindowStream", new Fields("MPResetWindowStreamFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
