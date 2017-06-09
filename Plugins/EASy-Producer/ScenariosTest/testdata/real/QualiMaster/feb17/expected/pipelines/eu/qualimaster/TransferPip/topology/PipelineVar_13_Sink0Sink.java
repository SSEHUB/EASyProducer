package eu.qualimaster.TransferPip.topology;

import java.util.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.data.inf.ITransferSink;
import eu.qualimaster.data.inf.ITransferSink.*;
import eu.qualimaster.data.imp.TransferSink;
import eu.qualimaster.data.imp.TransferSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.dataManagement.DataManager;
import eu.qualimaster.families.inf.IFTransferEntropy.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_13_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_13_Sink0Sink.class);
    transient OutputCollector _collector;
    transient ITransferSink sinkHandler;
private int counter = 0;
    transient IIFTransferEntropyPairwiseFinancialOutput iTuplePairwiseFinancial = null;
    transient ITransferSinkPairwiseFinancialInput inputPairwiseFinancial = null;

	public PipelineVar_13_Sink0Sink(String name, String namespace) {
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


    public void forwardTuple(Object tupleItem) {
        startMonitoring();
        //for now, sink just emits the tuple that get from last familyelement
    if(tupleItem instanceof IIFTransferEntropyPairwiseFinancialOutput) {
        iTuplePairwiseFinancial = (IIFTransferEntropyPairwiseFinancialOutput)tupleItem;
        inputPairwiseFinancial = new TransferSink.TransferSinkPairwiseFinancialInput();
        inputPairwiseFinancial.setId0(iTuplePairwiseFinancial.getId0());
        inputPairwiseFinancial.setId1(iTuplePairwiseFinancial.getId1());
        inputPairwiseFinancial.setDate(iTuplePairwiseFinancial.getDate());
        inputPairwiseFinancial.setValue(iTuplePairwiseFinancial.getValue());
        sinkHandler.postDataPairwiseFinancial(inputPairwiseFinancial);
        emitted(inputPairwiseFinancial);
    }

        endMonitoring();
    }

    @Override
    public void execute(Tuple tuple) {
        forwardTuple(tuple.getValue(0));
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        new TransferSink.TransferSinkPairwiseFinancialInput();
        try {
            @SuppressWarnings("unchecked")
            Class<? extends ITransferSink> cls = (Class<? extends ITransferSink>)Class.forName("eu.qualimaster.algorithms.imp.TransferSink");
			boolean autoConnect = "true".equals(map.get(Constants.CONFIG_KEY_SOURCE_AUTOCONNECT));
			if(autoConnect) {
            	sinkHandler = DataManager.DATA_SINK_MANAGER.createDataSink(getPipeline(), cls, NoStorageStrategyDescriptor.INSTANCE);
			} else {
            	sinkHandler = cls.newInstance();
			}
			if (!autoConnect) {
		    	sinkHandler.connect();
			}
		    sendAlgorithmChangeEvent("TransferSink", null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        initMonitor();
        logger.info("The end of the prepare method.");
    }

    @Override
    protected boolean initMonitorDuringPrepare() {
        return false;
    }

    @Override
    public void cleanup() {
        super.cleanup();
		 sinkHandler.disconnect();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_13_Sink0PairwiseFinancial", new Fields("PipelineVar_13_Sink0PairwiseFinancialFields"));
    }

    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
    sendAlgorithmChangeEvent(signal.getAlgorithm(), signal.getCauseMessageId());
    super.notifyAlgorithmChange(signal);
}

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        sinkHandler.disconnect();
    }

}
