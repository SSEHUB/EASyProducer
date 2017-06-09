package eu.qualimaster.TimeTravelPip.topology;

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
import eu.qualimaster.data.inf.ITimeTravelSink;
import eu.qualimaster.data.inf.ITimeTravelSink.*;
import eu.qualimaster.data.imp.TimeTravelSink;
import eu.qualimaster.data.imp.TimeTravelSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.dataManagement.DataManager;
import eu.qualimaster.families.inf.IFTimeGraphQueryExecutor.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_10_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_10_Sink0Sink.class);
    transient OutputCollector _collector;
    transient ITimeTravelSink sinkHandler;
private int counter = 0;
    transient IIFTimeGraphQueryExecutorSnapshotStreamOutput iTupleSnapshotStream = null;
    transient IIFTimeGraphQueryExecutorPathStreamOutput iTuplePathStream = null;
    transient ITimeTravelSinkSnapshotStreamInput inputSnapshotStream = null;
    transient ITimeTravelSinkPathStreamInput inputPathStream = null;

	public PipelineVar_10_Sink0Sink(String name, String namespace) {
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
        if(tupleItem instanceof IIFTimeGraphQueryExecutorSnapshotStreamOutput) {
            iTupleSnapshotStream = (IIFTimeGraphQueryExecutorSnapshotStreamOutput)tupleItem;
            inputSnapshotStream = new TimeTravelSink.TimeTravelSinkSnapshotStreamInput();
            inputSnapshotStream.setSnapshot(iTupleSnapshotStream.getSnapshot());
            sinkHandler.postDataSnapshotStream(inputSnapshotStream);
            emitted(inputSnapshotStream);
        }

        if(tupleItem instanceof IIFTimeGraphQueryExecutorPathStreamOutput) {
            iTuplePathStream = (IIFTimeGraphQueryExecutorPathStreamOutput)tupleItem;
            inputPathStream = new TimeTravelSink.TimeTravelSinkPathStreamInput();
            inputPathStream.setPath(iTuplePathStream.getPath());
            sinkHandler.postDataPathStream(inputPathStream);
            emitted(inputPathStream);
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
        new TimeTravelSink.TimeTravelSinkSnapshotStreamInput();
        new TimeTravelSink.TimeTravelSinkPathStreamInput();
        try {
            @SuppressWarnings("unchecked")
            Class<? extends ITimeTravelSink> cls = (Class<? extends ITimeTravelSink>)Class.forName("eu.qualimaster.timegraph.TimeTravelSink");
			boolean autoConnect = "true".equals(map.get(Constants.CONFIG_KEY_SOURCE_AUTOCONNECT));
			if(autoConnect) {
            	sinkHandler = DataManager.DATA_SINK_MANAGER.createDataSink(getPipeline(), cls, NoStorageStrategyDescriptor.INSTANCE);
			} else {
            	sinkHandler = cls.newInstance();
			}
			if (!autoConnect) {
		    	sinkHandler.connect();
			}
		    sendAlgorithmChangeEvent("TimeTravelSink", null);
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
        declarer.declareStream("PipelineVar_10_Sink0SnapshotStream", new Fields("PipelineVar_10_Sink0SnapshotStreamFields"));
        declarer.declareStream("PipelineVar_10_Sink0PathStream", new Fields("PipelineVar_10_Sink0PathStreamFields"));
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
