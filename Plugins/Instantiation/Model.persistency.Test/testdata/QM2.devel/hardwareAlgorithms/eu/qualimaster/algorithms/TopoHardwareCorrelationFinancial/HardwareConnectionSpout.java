package eu.qualimaster.algorithms.TopoHardwareCorrelationFinancial;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.Map;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import eu.qualimaster.common.signal.BaseSignalSpout;
import eu.qualimaster.base.algorithm.HardwareTransmitter;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.imp.FCorrelationFinancial.*;
import eu.qualimaster.families.imp.FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput;

public class HardwareConnectionSpout extends BaseSignalSpout {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HardwareConnectionSpout.class);
    private SpoutOutputCollector collector;
    private String streamId;
    private String ip;
    private int port;
    private HardwareTransmitter hardwareConnection;
    private transient byte[] receivedData = null;
    private transient ByteArrayInputStream in = null;
    private transient IFCorrelationFinancialPairwiseFinancialOutput outputPairwiseFinancial = null;
    public HardwareConnectionSpout(String name, String namespace, String streamId) {
        super(name, namespace); 
        this.streamId = streamId;
    }

    @SuppressWarnings("rawtypes")
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutputCollector) {
        super.open(map, topologyContext, spoutputCollector);
        collector = spoutputCollector;
        ip = "147.27.39.13";
        port = 2401;
    }

    public void nextTuple() {
        if (connect()) {
            try {
                logger.info("Receiving data from the hardware.");
                receivedData = hardwareConnection.recvMsg();
                if (receivedData.length > 0) {
                    logger.info("Received the data.");
                    in = new ByteArrayInputStream(receivedData);
                    outputPairwiseFinancial = SerializerRegistry.getSerializerSafe("IFCorrelationFinancialPairwiseFinancialOutput", IFCorrelationFinancialPairwiseFinancialOutput.class).deserializeFrom(in);
                }
                if(outputPairwiseFinancial != null) {
                    logger.info("HW-BOLT received data: ");
                    collector.emit(streamId, new Values(outputPairwiseFinancial));
                }
            } catch (IOException e) {
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
}
