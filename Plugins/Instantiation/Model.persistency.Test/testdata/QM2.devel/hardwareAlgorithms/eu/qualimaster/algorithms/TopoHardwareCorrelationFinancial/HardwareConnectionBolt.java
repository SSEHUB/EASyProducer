package eu.qualimaster.algorithms.TopoHardwareCorrelationFinancial;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import eu.qualimaster.common.signal.BaseSignalBolt;
import eu.qualimaster.base.algorithm.HardwareTransmitter;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.families.imp.FCorrelationFinancial.*;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialSymbolListInput;

public class HardwareConnectionBolt extends BaseSignalBolt {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HardwareConnectionBolt.class);
    private OutputCollector collector;
    private String ip;
    private int port;
    private HardwareTransmitter hardwareConnection;
    private transient ByteArrayOutputStream output = null;
    private transient IFCorrelationFinancialPreprocessedStreamInput inputPreprocessedStream = null;
    private transient IFCorrelationFinancialSymbolListInput inputSymbolList = null;

    public HardwareConnectionBolt(String name, String namespace) {
        super(name, namespace); 
    }

    @SuppressWarnings("rawtypes")
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        super.prepare(map, topologyContext, outputCollector);
        collector = outputCollector;
        ip = "147.27.39.13";
        port = 2400;
        output = new ByteArrayOutputStream();
    }

    public void execute(Tuple tuple) {
        if(tuple.getValue(0) instanceof IFCorrelationFinancialPreprocessedStreamInput) {
            inputPreprocessedStream = (IFCorrelationFinancialPreprocessedStreamInput)tuple.getValue(0);
            try {
                output.reset();
                SerializerRegistry.getSerializerSafe("IFCorrelationFinancialPreprocessedStreamInput", IFCorrelationFinancialPreprocessedStreamInput.class).serializeTo(inputPreprocessedStream, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connect()) {
                hardwareConnection.sendData(output.toByteArray());
                collector.ack(tuple);
            }
        }

        if(tuple.getValue(0) instanceof IFCorrelationFinancialSymbolListInput) {
            inputSymbolList = (IFCorrelationFinancialSymbolListInput)tuple.getValue(0);
            try {
                output.reset();
                SerializerRegistry.getSerializerSafe("IFCorrelationFinancialSymbolListInput", IFCorrelationFinancialSymbolListInput.class).serializeTo(inputSymbolList, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connect()) {
                hardwareConnection.sendData(output.toByteArray());
                collector.ack(tuple);
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

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    }
}
