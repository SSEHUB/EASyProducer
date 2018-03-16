package eu.qualimaster.CorrelationSW.topology;

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
import eu.qualimaster.families.inf.IFHayashiYoshida.*;
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
import eu.qualimaster.algorithms.imp.correlation.HayashiYoshida;
import eu.qualimaster.families.inf.IFMapper.*;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class SubTopology_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(SubTopology_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
int counter = 0;
long recordOutput = 0;
    private transient FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput pairwiseFinancialResult = new FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput();
    private transient IFHayashiYoshida alg = null; 
    transient IIFMapperSymbolsStreamOutput iTupleSymbolsStream = null;
    transient IIFMapperConfigurationStreamOutput iTupleConfigurationStream = null;
    transient IIFMapperResetWindowStreamOutput iTupleResetWindowStream = null;
    transient IIFHayashiYoshidaSymbolsStreamInput inputSymbolsStream = null;
    transient IIFHayashiYoshidaConfigurationStreamInput inputConfigurationStream = null;
    transient IIFHayashiYoshidaResetWindowStreamInput inputResetWindowStream = null;

    public SubTopology_FamilyElement1FamilyElement(String name, String namespace) {
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
counter = 0;

        pairwiseFinancialResult = new FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput();
        IItemEmitter<IIFHayashiYoshidaPairwiseFinancialOutput> pairwiseFinancialEmitter = new IItemEmitter<IIFHayashiYoshidaPairwiseFinancialOutput>() {
            @Override
            public void emitDirect(String streamId, IIFHayashiYoshidaPairwiseFinancialOutput item) {
                _collector.emit("HayashiYoshidaPairwiseFinancial", new Values(item));
            }
        };
        pairwiseFinancialResult.setEmitter(pairwiseFinancialEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.HayashiYoshida");
                    alg = (IFHayashiYoshida) cls.getConstructor(int.class).newInstance(taskId);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("HayashiYoshida", null);
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
        // delegate to family "fHayashiYoshida"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
recordOutput = System.currentTimeMillis();
        }
        if(tupleItem instanceof IIFMapperSymbolsStreamOutput) {
            iTupleSymbolsStream = (IIFMapperSymbolsStreamOutput)tupleItem;
            inputSymbolsStream = new FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput();
            inputSymbolsStream.setSymbolId(iTupleSymbolsStream.getSymbolId());
            inputSymbolsStream.setTimestamp(iTupleSymbolsStream.getTimestamp());
            inputSymbolsStream.setValue(iTupleSymbolsStream.getValue());
            try {
                if(alg != null) {
                    alg.calculate(inputSymbolsStream, pairwiseFinancialResult);
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
                pairwiseFinancialResult.setPairwiseCorrelationFinancial("");
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFMapperConfigurationStreamOutput) {
            iTupleConfigurationStream = (IIFMapperConfigurationStreamOutput)tupleItem;
            inputConfigurationStream = new FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput();
            inputConfigurationStream.setPairKey(iTupleConfigurationStream.getPairKey());
            inputConfigurationStream.setPairValue(iTupleConfigurationStream.getPairValue());
            try {
                if(alg != null) {
                    alg.calculate(inputConfigurationStream, pairwiseFinancialResult);
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
                pairwiseFinancialResult.setPairwiseCorrelationFinancial("");
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(tupleItem instanceof IIFMapperResetWindowStreamOutput) {
            iTupleResetWindowStream = (IIFMapperResetWindowStreamOutput)tupleItem;
            inputResetWindowStream = new FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput();
            inputResetWindowStream.setWindowStart(iTupleResetWindowStream.getWindowStart());
            try {
                if(alg != null) {
                    alg.calculate(inputResetWindowStream, pairwiseFinancialResult);
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
                pairwiseFinancialResult.setPairwiseCorrelationFinancial("");
                if (e instanceof DefaultModeException) {
                    sendDefaultModeMonitoringEvent((DefaultModeException) e);
                }
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFHayashiYoshidaPairwiseFinancialOutput> iterPairwiseFinancial = pairwiseFinancialResult.iterator();
            iterPairwiseFinancial.reset();
            while (iterPairwiseFinancial.hasNext()) {
long nowOutput = System.currentTimeMillis();
if ((nowOutput - recordOutput) > 1000) {
recordOutput = nowOutput;
logger.error("The output rate at the time " + nowOutput + ":" + counter);
counter = 0;
} else {
counter++;
}
                IIFHayashiYoshidaPairwiseFinancialOutput out = iterPairwiseFinancial.next();
                _collector.emit("HayashiYoshidaPairwiseFinancial", new Values(out));
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
            case "HayashiYoshida":
                if (!algChange || !(alg instanceof HayashiYoshida)) {
                    algChange = true;
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.HayashiYoshida");
                        alg = (IFHayashiYoshida) cls.getConstructor(int.class).newInstance(taskId);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    sendAlgorithmChangeEvent("HayashiYoshida", signal.getCauseMessageId());
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
        declarer.declareStream("HayashiYoshidaPairwiseFinancial", new Fields("HayashiYoshidaPairwiseFinancialFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
