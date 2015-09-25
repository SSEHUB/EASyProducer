package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.data.inf.IPriorityDataSink;
import eu.qualimaster.data.inf.IPriorityDataSink.*;
import eu.qualimaster.data.imp.PriorityDataSink;
import eu.qualimaster.algorithms.imp.correlation.PriorityDataSinkForFinancialAndTwitter;
import eu.qualimaster.families.inf.IFCorrelationFinancial.*;
import eu.qualimaster.families.inf.IFCorrelationTwitter.*;

/**
* Defines the Sink class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Sink0Sink extends BaseSignalBolt {

    transient OutputCollector _collector;
    transient IPriorityDataSink sinkHandler;
    transient IIFCorrelationFinancialPairwiseFinancialOutput iTuplePairwiseFinancial = null;
    transient IIFCorrelationTwitterPairwiseTwitterOutput iTuplePairwiseTwitter = null;
    transient IPriorityDataSinkPairwiseFinancialInput inputPairwiseFinancial = null;
    transient IPriorityDataSinkPairwiseTwitterInput inputPairwiseTwitter = null;

	public PriorityPip_Sink0Sink(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void execute(Tuple tuple) {
        //for now, sink just emits the tuple that get from last familyelement
        if(tuple.getValue(0) instanceof IIFCorrelationFinancialPairwiseFinancialOutput) {
            iTuplePairwiseFinancial = (IIFCorrelationFinancialPairwiseFinancialOutput)tuple.getValue(0);
            inputPairwiseFinancial = new PriorityDataSink.PriorityDataSinkPairwiseFinancialInput();
            inputPairwiseFinancial.setPairwiseCorrelationFinancial(iTuplePairwiseFinancial.getPairwiseCorrelationFinancial());
            sinkHandler.postDataPairwiseFinancial(inputPairwiseFinancial);
        }

        if(tuple.getValue(0) instanceof IIFCorrelationTwitterPairwiseTwitterOutput) {
            iTuplePairwiseTwitter = (IIFCorrelationTwitterPairwiseTwitterOutput)tuple.getValue(0);
            inputPairwiseTwitter = new PriorityDataSink.PriorityDataSinkPairwiseTwitterInput();
            inputPairwiseTwitter.setPairwiseCorrelationTwitter(iTuplePairwiseTwitter.getPairwiseCorrelationTwitter());
            sinkHandler.postDataPairwiseTwitter(inputPairwiseTwitter);
        }

        _collector.ack(tuple);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		super.prepare(map, topologyContext, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.PriorityDataSinkForFinancialAndTwitter");
            sinkHandler = (IPriorityDataSink) cls.newInstance();
		    sinkHandler.connect();
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
