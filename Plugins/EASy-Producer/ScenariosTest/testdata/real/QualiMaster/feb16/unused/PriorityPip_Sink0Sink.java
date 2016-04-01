package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;
import eu.qualimaster.data.inf.IPriorityDataSink;
import eu.qualimaster.data.inf.IPriorityDataSink.*;
import eu.qualimaster.data.imp.PriorityDataSink;
import eu.qualimaster.algorithms.imp.correlation.PriorityDataSinkForFinancialAndTwitter;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.inf.IFSentimentAnalysis.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Sink0Sink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_Sink0Sink.class);
    transient OutputCollector _collector;
    transient IPriorityDataSink sinkHandler;
    transient IIFCorrelationFinancialPairwiseFinancialOutput iTuplePairwiseFinancial = null;
    transient IIFSentimentAnalysisAnalyzedStreamOutput iTupleAnalyzedStream = null;
    transient IPriorityDataSinkPairwiseFinancialInput inputPairwiseFinancial = null;
    transient IPriorityDataSinkAnalyzedStreamInput inputAnalyzedStream = null;

	public PriorityPip_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_Sink0", algorithm));
    }

    @Override
    public void execute(Tuple tuple) {
        long start = System.currentTimeMillis();
        //for now, sink just emits the tuple that get from last familyelement
        if(tuple.getValue(0) instanceof IIFCorrelationFinancialPairwiseFinancialOutput) {
            iTuplePairwiseFinancial = (IIFCorrelationFinancialPairwiseFinancialOutput)tuple.getValue(0);
            inputPairwiseFinancial = new PriorityDataSink.PriorityDataSinkPairwiseFinancialInput();
            inputPairwiseFinancial.setPairwiseCorrelationFinancial(iTuplePairwiseFinancial.getPairwiseCorrelationFinancial());
            sinkHandler.postDataPairwiseFinancial(inputPairwiseFinancial);
        }

        if(tuple.getValue(0) instanceof IIFSentimentAnalysisAnalyzedStreamOutput) {
            iTupleAnalyzedStream = (IIFSentimentAnalysisAnalyzedStreamOutput)tuple.getValue(0);
            inputAnalyzedStream = new PriorityDataSink.PriorityDataSinkAnalyzedStreamInput();
            inputAnalyzedStream.setSymbolId(iTupleAnalyzedStream.getSymbolId());
            inputAnalyzedStream.setTimestamp(iTupleAnalyzedStream.getTimestamp());
            inputAnalyzedStream.setValue(iTupleAnalyzedStream.getValue());
            inputAnalyzedStream.setVolume(iTupleAnalyzedStream.getVolume());
            sinkHandler.postDataAnalyzedStream(inputAnalyzedStream);
        }

        _collector.ack(tuple);
        aggregateExecutionTime(start);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.PriorityDataSinkForFinancialAndTwitter");
            sinkHandler = (IPriorityDataSink) cls.newInstance();
		    sinkHandler.connect();
		    sendAlgorithmChangeEvent("PriorityDataSinkForFinancialAndTwitter");
        } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
		 sinkHandler.disconnect();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_Sink0Stream", new Fields("sinkData"));
    }

}
