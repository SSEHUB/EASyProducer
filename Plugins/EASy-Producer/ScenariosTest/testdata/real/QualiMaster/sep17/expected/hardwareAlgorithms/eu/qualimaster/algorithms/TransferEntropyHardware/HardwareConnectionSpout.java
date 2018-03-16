package eu.qualimaster.algorithms.TransferEntropyHardware;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import eu.qualimaster.common.signal.BaseSignalSpout;
import eu.qualimaster.base.algorithm.HardwareTransmitter;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.common.signal.ParameterChangeSignal;
import eu.qualimaster.common.signal.ShutdownSignal;
import eu.qualimaster.common.signal.ParameterChange;
import eu.qualimaster.common.signal.ValueFormatException;
import eu.qualimaster.common.signal.SignalException;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import eu.qualimaster.common.switching.SynchronizedQueue;
import eu.qualimaster.families.imp.FCorrelationFinancial.*;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput;
import eu.qualimaster.families.inf.IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput;

public class HardwareConnectionSpout extends BaseSignalSpout {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HardwareConnectionSpout.class);
    private transient SpoutOutputCollector collector;
    private String streamId;
    private int MAXDATASIZE;
    private int taskId;
    private int taskNum;
    private int taskIndex;
    private boolean ready = false;
    private String ip;
    private int port = 0;
    private byte [] msg = null;
    private transient HardwareTransmitter hardwareConnection;
    private transient ByteArrayInputStream in = null;
    private transient IIFCorrelationFinancialPairwiseFinancialOutput outputPairwiseFinancial = null;
    private transient Queue<IIFCorrelationFinancialPairwiseFinancialOutput> queuePairwiseFinancial = new ConcurrentLinkedQueue<IIFCorrelationFinancialPairwiseFinancialOutput>();
    private transient SynchronizedQueue<IIFCorrelationFinancialPairwiseFinancialOutput> synPairwiseFinancial = null;
    private int size;
    private transient DataEmitter dataEmitter;
    public HardwareConnectionSpout(String name, String namespace, String streamId) {
        super(name, namespace, true); 
        this.streamId = streamId;
    }

    @SuppressWarnings("rawtypes")
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutputCollector) {
        super.open(map, topologyContext, spoutputCollector);
        collector = spoutputCollector;
        taskId = topologyContext.getThisTaskId();
        taskNum = topologyContext.getThisWorkerTasks().size();
        taskIndex = topologyContext.getThisTaskIndex();
        queuePairwiseFinancial = new ConcurrentLinkedQueue<IIFCorrelationFinancialPairwiseFinancialOutput>();
        size = 50;
        synPairwiseFinancial = new SynchronizedQueue<IIFCorrelationFinancialPairwiseFinancialOutput>(queuePairwiseFinancial, size);
        ip = "147.27.39.12";
        ready = false;
        msg = new byte[MAXDATASIZE];
        MAXDATASIZE = 16384;
        new IFCorrelationFinancialPairwiseFinancialOutput();
        try {
            dataEmitter = new DataEmitter();
        } catch (Exception e) {
            logger.error("", e);
        }
        Thread dataEmitterThread = new Thread(dataEmitter);
        dataEmitterThread.start();
        initMonitor();
        logger.info("The end of the open method.");
    }

    @Override
    protected boolean initMonitorDuringOpen() {
        return false;
    }
    public class DataEmitter implements Runnable {
        private boolean cont = false;

        public DataEmitter() {
            cont = true;
        }

        @Override
        public void run() {
            while(cont) {
                collector.emit(streamId, new Values(synPairwiseFinancial.consume()));
            }
        }

        public void stop() {
            cont = false;
        }
    }

    public void nextTuple() {
        if(ready) {
        if (connect()) {
            try {
                in = null;
                msg = hardwareConnection.receiveData();
                if(msg != null) {
                    if (msg[0] == 'd') {
                    in = new ByteArrayInputStream(msg, 1, msg.length-1);
                        if (in != null) {
                            startMonitoring();
                            outputPairwiseFinancial = null;
                            outputPairwiseFinancial = SerializerRegistry.getSerializerSafe("IFCorrelationFinancialPairwiseFinancialOutput", IIFCorrelationFinancialPairwiseFinancialOutput.class).deserializeFrom(in);
                            if(outputPairwiseFinancial != null) {
                                synPairwiseFinancial.produce(outputPairwiseFinancial);
                                endMonitoring();
                            }
                        }
                    } else if (msg[0] == 'o') {
                            /* HERE PUT THE CODE FOR THE FLUSH PROCESS */
                        ParameterChangeSignal paraSignal = new ParameterChangeSignal(
                        				                        "TimeTravelSimPip", "TransferEntropyHardwareEndBolt", "emit", true, null);
                        try {
                            sendSignal(paraSignal);
                        } catch (SignalException e) {
                            e.printStackTrace();
                        }
                    } else if (msg[0] == 'f') {
                        /* HERE PUT THE CODE FOR THE OMIT PROCESS */
                        ParameterChangeSignal paraSignal = new ParameterChangeSignal(
                        				                        "TimeTravelSimPip", "TransferEntropyHardwareEndBolt", "disable", true, null);
                        try {
                            sendSignal(paraSignal);
                        } catch (SignalException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                logger.info("IOException : " + e.getMessage());
            }
        }
        }
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        logger.info("Received the parameter change signal!");
        for(int i = 0; i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "port": 
                    String value = para.getStringValue();
                    logger.info("Received signal port!" + value + ", taskId: " + taskId); 
                    String[] portList = value.split(",");
                    port = assignPort(portList, taskIndex);
                    ready = true;
                    logger.info("Assigned port:" + port + ", taskId:" + taskId + ", taskIndex: " + taskIndex);
                    break;
              }
        }
    }

    private boolean connect() {
        if (null == hardwareConnection) {
            try {
                hardwareConnection = new HardwareTransmitter(ip, port);
                logger.info("Created a receiver connection.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null != hardwareConnection;
    }
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declareStream(streamId, false, new Fields("hardwareOutput"));
    }

    @Override
    public void close() {
        super.close();
        try {
            if(hardwareConnection != null) {
                hardwareConnection.sendCloseMessage();
                hardwareConnection.close();
            }
            if(in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        dataEmitter.stop();
        try {
            if(hardwareConnection != null) {
                hardwareConnection.sendCloseMessage();
                hardwareConnection.close();
            }
            if(in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int assignPort(String[] ports, int index) {
        //int mode = index % ports.length;
        return Integer.parseInt(ports[index]);
    }
}
