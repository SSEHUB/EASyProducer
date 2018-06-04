package eu.qualimaster.DynamicGraphPip.topology;

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
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.GenTopoHardwareCorrelationFinancial.GenTopoHardwareCorrelationFinancialSubTopology;
import eu.qualimaster.CorrelationSW.topology.CorrelationSWSubTopology;
import eu.qualimaster.algorithms.TransferEntropyHardware.TransferEntropyHardwareSubTopology;
import eu.qualimaster.algorithms.MutualInformationHardware.MutualInformationHardwareSubTopology;
import eu.qualimaster.CorrelationSWAlternative.topology.CorrelationSWAlternativeSubTopology;
import eu.qualimaster.families.inf.IFPreprocessor.*;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.common.hardware.*;
import com.google.protobuf.ByteString;
import eu.qualimaster.base.algorithm.IItemEmitter;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_8_FamilyElement1FamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_8_FamilyElement1FamilyElement.class);
    transient OutputCollector _collector;
    private boolean algChange = false;
    private boolean firstTuple = false;
    private long record = 0;
    private int taskId;
    private String streamId = "PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancial";
    private transient FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput pairwiseFinancialResult = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
    private transient IFCorrelationFinancial alg = null; 
    transient IIFPreprocessorPreprocessedStreamOutput iTuplePreprocessedStream = null;
    transient ISpringFinancialDataSymbolListOutput iTupleSymbolList = null;
    transient IIFCorrelationFinancialPreprocessedStreamInput inputPreprocessedStream = null;
    transient IIFCorrelationFinancialSymbolListInput inputSymbolList = null;

    public PipelineVar_8_FamilyElement1FamilyElement(String name, String namespace) {
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

        pairwiseFinancialResult = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
        IItemEmitter<IIFCorrelationFinancialPairwiseFinancialOutput> pairwiseFinancialEmitter = new IItemEmitter<IIFCorrelationFinancialPairwiseFinancialOutput>() {
            @Override
            public void emitDirect(String streamId, IIFCorrelationFinancialPairwiseFinancialOutput item) {
                _collector.emit("PipelineVar_8_FamilyElement1PairwiseFinancial", new Values(item));
            }
        };
        pairwiseFinancialResult.setEmitter(pairwiseFinancialEmitter);

        if("STATIC".equals(map.get(Constants.CONFIG_KEY_INIT_MODE))) {
            try {
                try {
                    Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial");
                    alg = (IFCorrelationFinancial) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                alg.setParameterWindowSize(PipelineOptions.getExecutorIntArgument(map, getName(), "windowSize", 30));
                if (alg != null) {
            	alg.switchState(State.ACTIVATE); //activate the current algorithm
                }
		    	sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial", null);
            streamId = "PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancial";
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
        // delegate to family "fCorrelationFinancial"
        if (!firstTuple) {//the first tuple arrived
            firstTuple = true;
            record = System.currentTimeMillis();
        }
        if(tupleItem instanceof IIFPreprocessorPreprocessedStreamOutput) {
            iTuplePreprocessedStream = (IIFPreprocessorPreprocessedStreamOutput)tupleItem;
            inputPreprocessedStream = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
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
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputPreprocessedStream));
            }
        }

        if(tupleItem instanceof ISpringFinancialDataSymbolListOutput) {
            iTupleSymbolList = (ISpringFinancialDataSymbolListOutput)tupleItem;
            inputSymbolList = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
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
            if(alg instanceof ITopologyCreate) {
                _collector.emit(streamId, new Values(inputSymbolList));
            }
        }

        if(!(alg instanceof ITopologyCreate)) {
            eu.qualimaster.base.algorithm.IOutputItemIterator<IIFCorrelationFinancialPairwiseFinancialOutput> iterPairwiseFinancial = pairwiseFinancialResult.iterator();
            iterPairwiseFinancial.reset();
            while (iterPairwiseFinancial.hasNext()) {
                IIFCorrelationFinancialPairwiseFinancialOutput out = iterPairwiseFinancial.next();
                _collector.emit("PipelineVar_8_FamilyElement1PairwiseFinancial", new Values(out));
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
            case "TopoSoftwareCorrelationFinancial":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof TopoSoftwareCorrelationFinancial)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancial";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TopoSoftwareCorrelationFinancial", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "GenTopoHardwareCorrelationFinancial":
            case "GenTopoHardwareCorrelationFinancialSubTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof GenTopoHardwareCorrelationFinancialSubTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.GenTopoHardwareCorrelationFinancial.GenTopoHardwareCorrelationFinancialSubTopology");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        String host = signal.getStringParameter(AlgorithmChangeParameter.COPROCESSOR_HOST, "147.27.39.13");
                        int sendingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_REQUEST_PORT, 2400);
                        int receivingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_RESPONSE_PORT, 2401);
                        String url = signal.getStringParameter(AlgorithmChangeParameter.IMPLEMENTING_ARTIFACT, null);
                        HardwareControlConnection hardwareConnection = new HardwareControlConnection(host, sendingPort, receivingPort);
                        ByteString executable = ByteString.copyFromUtf8(url);
                        UploadMessageOut msg = hardwareConnection.uploadAlgorithm("GenTopoHardwareCorrelationFinancial", 12, executable);
                        ParameterChangeSignal signalForBolt= new ParameterChangeSignal("DynamicGraphPip",
                                            "GenTopoHardwareCorrelationFinancialHardwareConnectionBolt", "port", msg.getPortIn(), null);
                        sendSignal(signalForBolt);
                        String ports = "";
                        ports = ports + msg.getPortOut(0);
                        for (int i=1; i<msg.getPortOutCount(); i++) {
                            ports = ports + "," + msg.getPortOut(i);
                        }
                        ParameterChangeSignal signalForSpout= new ParameterChangeSignal("DynamicGraphPip",
                                            "GenTopoHardwareCorrelationFinancialHardwareConnectionSpout", "port", ports, null);
                        sendSignal(signalForSpout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SignalException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1GenTopoHardwareCorrelationFinancial";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("GenTopoHardwareCorrelationFinancialSubTopology", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "CorrelationSW":
            case "CorrelationSWSubTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof CorrelationSWSubTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.CorrelationSW.topology.CorrelationSWSubTopology");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1CorrelationSW";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("CorrelationSWSubTopology", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "TransferEntropyHardware":
            case "TransferEntropyHardwareSubTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof TransferEntropyHardwareSubTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.TransferEntropyHardware.TransferEntropyHardwareSubTopology");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        String host = signal.getStringParameter(AlgorithmChangeParameter.COPROCESSOR_HOST, "147.27.39.12");
                        int sendingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_REQUEST_PORT, 2400);
                        int receivingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_RESPONSE_PORT, 2401);
                        String url = signal.getStringParameter(AlgorithmChangeParameter.IMPLEMENTING_ARTIFACT, null);
                        HardwareControlConnection hardwareConnection = new HardwareControlConnection(host, sendingPort, receivingPort);
                        ByteString executable = ByteString.copyFromUtf8(url);
                        UploadMessageOut msg = hardwareConnection.uploadAlgorithm("TransferEntropyHardware", 1, executable);
                        ParameterChangeSignal signalForBolt= new ParameterChangeSignal("DynamicGraphPip",
                                            "TransferEntropyHardwareHardwareConnectionBolt", "port", msg.getPortIn(), null);
                        sendSignal(signalForBolt);
                        String ports = "";
                        ports = ports + msg.getPortOut(0);
                        for (int i=1; i<msg.getPortOutCount(); i++) {
                            ports = ports + "," + msg.getPortOut(i);
                        }
                        ParameterChangeSignal signalForSpout= new ParameterChangeSignal("DynamicGraphPip",
                                            "TransferEntropyHardwareHardwareConnectionSpout", "port", ports, null);
                        sendSignal(signalForSpout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SignalException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1TransferEntropyHardware";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("TransferEntropyHardwareSubTopology", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "MutualInformationHardware":
            case "MutualInformationHardwareSubTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof MutualInformationHardwareSubTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.algorithms.MutualInformationHardware.MutualInformationHardwareSubTopology");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        String host = signal.getStringParameter(AlgorithmChangeParameter.COPROCESSOR_HOST, "147.27.39.12");
                        int sendingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_REQUEST_PORT, 2400);
                        int receivingPort = signal.getIntParameter(AlgorithmChangeParameter.CONTROL_RESPONSE_PORT, 2401);
                        String url = signal.getStringParameter(AlgorithmChangeParameter.IMPLEMENTING_ARTIFACT, null);
                        HardwareControlConnection hardwareConnection = new HardwareControlConnection(host, sendingPort, receivingPort);
                        ByteString executable = ByteString.copyFromUtf8(url);
                        UploadMessageOut msg = hardwareConnection.uploadAlgorithm("MutualInformationHardware", 1, executable);
                        ParameterChangeSignal signalForBolt= new ParameterChangeSignal("DynamicGraphPip",
                                            "MutualInformationHardwareHardwareConnectionBolt", "port", msg.getPortIn(), null);
                        sendSignal(signalForBolt);
                        String ports = "";
                        ports = ports + msg.getPortOut(0);
                        for (int i=1; i<msg.getPortOutCount(); i++) {
                            ports = ports + "," + msg.getPortOut(i);
                        }
                        ParameterChangeSignal signalForSpout= new ParameterChangeSignal("DynamicGraphPip",
                                            "MutualInformationHardwareHardwareConnectionSpout", "port", ports, null);
                        sendSignal(signalForSpout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SignalException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1MutualInformationHardware";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("MutualInformationHardwareSubTopology", signal.getCauseMessageId());
                    if(alg != null) {
                        alg.switchState(State.ACTIVATE); //activate the current algorithm
                    }
                    algChange = true;
                }
                break;
            case "CorrelationSWAlternative":
            case "CorrelationSWAlternativeSubTopology":
                logger.info("Is it the first change? " + algChange);
                if(!algChange || !(alg instanceof CorrelationSWAlternativeSubTopology)) {
                    logger.info("Changing to the algorithm: " + signal.getAlgorithm());
                    if(alg != null) {
                        alg.switchState(State.PASSIVATE); //passivate the previous algorithm
                    }
                    try {
                        Class cls = Class.forName("eu.qualimaster.CorrelationSWAlternative.topology.CorrelationSWAlternativeSubTopology");
                        alg = (IFCorrelationFinancial) cls.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    streamId = "PipelineVar_8_FamilyElement1CorrelationSWAlternative";
                    alg.setParameterWindowSize(30);
                    sendAlgorithmChangeEvent("CorrelationSWAlternativeSubTopology", signal.getCauseMessageId());
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
        declarer.declareStream("PipelineVar_8_FamilyElement1PairwiseFinancial", new Fields("PipelineVar_8_FamilyElement1PairwiseFinancialFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancial", new Fields("PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancialFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1GenTopoHardwareCorrelationFinancial", new Fields("PipelineVar_8_FamilyElement1GenTopoHardwareCorrelationFinancialFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1CorrelationSW", new Fields("PipelineVar_8_FamilyElement1CorrelationSWFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1TransferEntropyHardware", new Fields("PipelineVar_8_FamilyElement1TransferEntropyHardwareFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1MutualInformationHardware", new Fields("PipelineVar_8_FamilyElement1MutualInformationHardwareFields"));
        declarer.declareStream("PipelineVar_8_FamilyElement1CorrelationSWAlternative", new Fields("PipelineVar_8_FamilyElement1CorrelationSWAlternativeFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        if(alg != null) {
            alg.switchState(State.TERMINATING);
        }
    }

}
