package eu.qualimaster.TransferPip.topology;

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
import eu.qualimaster.families.inf.IFTransferEntropy.*;
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
import eu.qualimaster.algorithms.imp.TransferEntropy;
import eu.qualimaster.families.inf.IFPreprocessor.*;
import eu.qualimaster.data.inf.IFocusFincancialData.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_13_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_13_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private transient FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput pairwiseFinancialResult = new FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput();
    private transient IFTransferEntropy alg = null; 
    transient IIFPreprocessorPreprocessedStreamOutput iTuplePreprocessedStream = null;
    transient IFocusFincancialDataSymbolListOutput iTupleSymbolList = null;
    transient IIFTransferEntropyPreprocessedStreamInput inputPreprocessedStream = null;
    transient IIFTransferEntropySymbolListInput inputSymbolList = null;

    public PipelineVar_13_FamilyElement1FamilyElement(String name, String namespace) {
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

        pairwiseFinancialResult = new FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput();
        IItemEmitter<IIFTransferEntropyPairwiseFinancialOutput> pairwiseFinancialEmitter = new IItemEmitter<IIFTransferEntropyPairwiseFinancialOutput>() {
            @Override
            public void emitDirect(String streamId, IIFTransferEntropyPairwiseFinancialOutput item) {
                _collector.emit("PipelineVar_13_FamilyElement1PairwiseFinancial", new Values(item));
            }
        };
        pairwiseFinancialResult.setEmitter(pairwiseFinancialEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.imp.TransferEntropy");
                    alg = (IFTransferEntropy) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 300));
                alg.setParameterWindowAdvance(PipelineOptions.getExecutorIntArgument(map, getName(), "windowAdvance", 1));
                alg.setParameterDensitySize(PipelineOptions.getExecutorIntArgument(map, getName(), "densitySize", 128));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("TransferEntropy", null);
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
        // delegate to family "fTransferEntropy"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
        if(tupleItem instanceof IIFPreprocessorPreprocessedStreamOutput) {
            iTuplePreprocessedStream = (IIFPreprocessorPreprocessedStreamOutput)tupleItem;
            inputPreprocessedStream = new FTransferEntropy.IFTransferEntropyPreprocessedStreamInput();
            inputPreprocessedStream.setSymbolId(iTuplePreprocessedStream.getSymbolId());
            inputPreprocessedStream.setTimestamp(iTuplePreprocessedStream.getTimestamp());
            inputPreprocessedStream.setValue(iTuplePreprocessedStream.getValue());
            inputPreprocessedStream.setVolume(iTuplePreprocessedStream.getVolume());
            try {
                if(alg != null) {
                    alg.calculate(inputPreprocessedStream, pairwiseFinancialResult);
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
                pairwiseFinancialResult.setId0("");
                pairwiseFinancialResult.setId1("");
                pairwiseFinancialResult.setDate("");
                pairwiseFinancialResult.setValue(0.0);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IFocusFincancialDataSymbolListOutput) {
            iTupleSymbolList = (IFocusFincancialDataSymbolListOutput)tupleItem;
            inputSymbolList = new FTransferEntropy.IFTransferEntropySymbolListInput();
            inputSymbolList.setAllSymbols(iTupleSymbolList.getAllSymbols());
            try {
                if(alg != null) {
                    alg.calculate(inputSymbolList, pairwiseFinancialResult);
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
                pairwiseFinancialResult.setId0("");
                pairwiseFinancialResult.setId1("");
                pairwiseFinancialResult.setDate("");
                pairwiseFinancialResult.setValue(0.0);
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFTransferEntropyPairwiseFinancialOutput> iterPairwiseFinancial = pairwiseFinancialResult.iterator();
            iterPairwiseFinancial.reset();
            while (iterPairwiseFinancial.hasNext()) {
                IIFTransferEntropyPairwiseFinancialOutput out = iterPairwiseFinancial.next();
                _collector.emit("PipelineVar_13_FamilyElement1PairwiseFinancial", new Values(out));
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
                case "windowAdvance" :
                    try {
                        System.out.println("Received parameter changing signal windowAdvance");
                        alg.setParameterWindowAdvance(para.getIntValue()); 
                        sendParameterChangeEvent("windowAdvance", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case "densitySize" :
                    try {
                        System.out.println("Received parameter changing signal densitySize");
                        alg.setParameterDensitySize(para.getIntValue()); 
                        sendParameterChangeEvent("densitySize", para.getIntValue(), signal.getCauseMessageId());
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
            case "TransferEntropy":
                if (!algChange || !(alg instanceof TransferEntropy)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.TransferEntropy");
                        alg = (IFTransferEntropy) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    alg.setParameterWindowSize(300);
                    alg.setParameterWindowAdvance(1);
                    alg.setParameterDensitySize(128);
                    sendAlgorithmChangeEvent("TransferEntropy", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_13_FamilyElement1PairwiseFinancial", new Fields("PipelineVar_13_FamilyElement1PairwiseFinancialFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
