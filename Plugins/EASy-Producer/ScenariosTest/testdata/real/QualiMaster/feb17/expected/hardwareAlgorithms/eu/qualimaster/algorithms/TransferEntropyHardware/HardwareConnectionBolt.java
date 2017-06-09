package eu.qualimaster.algorithms.TransferEntropyHardware;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import eu.qualimaster.common.signal.AbstractMonitor;
import eu.qualimaster.common.signal.BaseSignalBolt;
import eu.qualimaster.base.algorithm.HardwareTransmitter;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.base.serializer.Parameters.*;
import eu.qualimaster.common.signal.ShutdownSignal;
import eu.qualimaster.common.signal.ParameterChangeSignal;
import eu.qualimaster.common.signal.ParameterChange;
import eu.qualimaster.common.signal.ValueFormatException;
import eu.qualimaster.observables.ResourceUsage;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import eu.qualimaster.common.switching.SynchronizedQueue;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.imp.FCorrelationFinancial.*;
import eu.qualimaster.families.inf.IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput;
import eu.qualimaster.families.inf.IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialSymbolListInput;

public class HardwareConnectionBolt extends BaseSignalBolt {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HardwareConnectionBolt.class);
    private transient OutputCollector collector;
    private String ip;
    private int port = 0;
    private boolean ready = false;
    private transient Queue<Tuple> queueTuple = new ConcurrentLinkedQueue<Tuple>();
    private transient HardwareTransmitter hardwareConnection;
    private transient ByteArrayOutputStream output = null;
    private transient ByteArrayOutputStream paraOutput = null;
    private String separator;
    private transient IIFCorrelationFinancialPreprocessedStreamInput inputPreprocessedStream = null;
    private transient IIFCorrelationFinancialSymbolListInput inputSymbolList = null;
    private int size;
    private transient DataAcker dataAcker;
    private transient Queue<Tuple> queue = new ConcurrentLinkedQueue<Tuple>();
    private transient SynchronizedQueue<Tuple> syn = null;

    public HardwareConnectionBolt(String name, String namespace) {
        super(name, namespace, true); 
    }

    @SuppressWarnings("rawtypes")
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        super.prepare(map, topologyContext, outputCollector);
        collector = outputCollector;
        ip = "147.27.39.12";
        ready = false;
        queueTuple = new ConcurrentLinkedQueue<Tuple>();
        output = new ByteArrayOutputStream();
        paraOutput = new ByteArrayOutputStream();
        new IFCorrelationFinancialPreprocessedStreamInput();
        new IFCorrelationFinancialSymbolListInput();
        queue = new ConcurrentLinkedQueue<Tuple>();
        size = 50;
        syn = new SynchronizedQueue<Tuple>(queue, size);
        try {
            dataAcker = new DataAcker();
        } catch (Exception e) {
            logger.error("", e);
        }
        Thread dataAckerThread = new Thread(dataAcker);
        dataAckerThread.start();
        initMonitor();
        logger.info("The end of the prepare method.");
    }

    @Override
    protected boolean initMonitorDuringPrepare() {
        return false;
    }
    public class DataAcker implements Runnable {
        private boolean cont = false;

        public DataAcker() {
            cont = true;
        }

        @Override
        public void run() {
            while(cont) {
                collector.ack(syn.consume());
            }
        }

        public void stop() {
            cont = false;
        }
    }


    public void execute(Tuple tuple) {
        queueTuple.offer(tuple);
        if(ready) {
            sendTuple();
        }
    }

    protected void sendTuple() {
        AbstractMonitor monitor = createThreadMonitor();
        Tuple tuple = queueTuple.poll();
    if(tuple != null) {
        if(tuple.getValue(0) instanceof IIFCorrelationFinancialPreprocessedStreamInput) {
if(!(tuple.getValue(0) instanceof IIFCorrelationFinancialSymbolListInput)) {
            separator = "da";
            inputPreprocessedStream = (IIFCorrelationFinancialPreprocessedStreamInput)tuple.getValue(0);
            try {
                output.reset();
                SerializerRegistry.getSerializerSafe("IFCorrelationFinancialPreprocessedStreamInput", IIFCorrelationFinancialPreprocessedStreamInput.class).serializeTo(inputPreprocessedStream, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
}
        }

        if(tuple.getValue(0) instanceof IIFCorrelationFinancialSymbolListInput) {
if(!(tuple.getValue(0) instanceof IIFCorrelationFinancialSymbolListInput)) {
            separator = "db";
            inputSymbolList = (IIFCorrelationFinancialSymbolListInput)tuple.getValue(0);
            try {
                output.reset();
                SerializerRegistry.getSerializerSafe("IFCorrelationFinancialSymbolListInput", IIFCorrelationFinancialSymbolListInput.class).serializeTo(inputSymbolList, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
}
        }

        syn.produce(tuple);
        if (connect()) {
            if(output != null && separator != null) {
                monitor.startMonitoring();
                hardwareConnection.sendSeparator(separator);
                hardwareConnection.sendData(output.toByteArray());
                monitor.endMonitoring(tuple);
                }
            }
    }
    }
    private boolean connect() {
        if (null == hardwareConnection) {
            try {
                hardwareConnection = new HardwareTransmitter(ip, port);
                logger.info("Created a transmitter connection.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null != hardwareConnection;
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        logger.info("Received the parameter change signal!");
        String paraSeparator = null;
        try {
            for(int i = 0; i < signal.getChangeCount(); i++) {
                ParameterChange para = signal.getChange(i);
                paraOutput.reset();
                switch (para.getName()) {
                    case "windowSize" :
                        logger.info("Received parameter changing signal windowSize");
                        IntegerParameter windowSizePara = new IntegerParameter();
                        windowSizePara.setName("windowSize");
                        windowSizePara.setValue(para.getIntValue());
                        SerializerRegistry.getSerializerSafe("IntegerParameter", IntegerParameter.class).serializeTo(windowSizePara, paraOutput);
                        paraSeparator = "pa";
                        if (connect()) {
                            if(paraOutput != null && paraSeparator != null) {
                                hardwareConnection.sendSeparator(paraSeparator);
                                hardwareConnection.sendData(paraOutput.toByteArray());
                            }
                        }
                        break;
                    case "port": 
                        logger.info("Received signal port!"); 
                        port = para.getIntValue();
                        ready = true;
                        logger.info("Received signal port!" + port); 
                        recordOnce(ResourceUsage.USED_CPUS, 1);
                        recordOnce(ResourceUsage.USED_DFES, 1);
                        break;
                    case "omit": 
                        logger.info("Received signal omit, sending the omit message to hardware!!");
                        paraSeparator = "cc";
                        if (connect()) {
                                hardwareConnection.sendSeparator(paraSeparator);
                        }
                    break;
                    case "flush": 
                        logger.info("Received signal flush, sending the flush message to hardware!!");
                        if (connect()) {
                                hardwareConnection.sendFlushMessage();
                        }
                    break;
                }
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        dataAcker.stop();
        try {
            if(hardwareConnection != null) {
                hardwareConnection.sendCloseMessage();
                hardwareConnection.close();
            }
            if(output != null) {
                output.close();
            }
            if(paraOutput != null) {
                paraOutput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        recordOnce(ResourceUsage.USED_CPUS, 0);
        recordOnce(ResourceUsage.USED_DFES, 0);
    }

    @Override
    public void cleanup() {
        super.cleanup();
        try {
            if(hardwareConnection != null) {
                hardwareConnection.sendCloseMessage();
                hardwareConnection.close();
            }
            if(output != null) {
                output.close();
            }
            if(paraOutput != null) {
                paraOutput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
