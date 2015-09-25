package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ISpringFinancialData;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.algorithms.imp.correlation.SpringClientSimulator;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Source0Source extends BaseSignalSpout {

    transient SpoutOutputCollector _collector;
    transient ISpringFinancialData sourceData;
    transient ISpringFinancialDataSymbolListOutput dataItemSymbolList = null;
    transient ISpringFinancialDataSpringStreamOutput dataItemSpringStream = null;

    public PriorityPip_Source0Source(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.SpringClientSimulator");
            sourceData = (ISpringFinancialData) cls.newInstance();
		    sourceData.connect();
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

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("PriorityPip", "PriorityPip_Source0", exceptionCase));
    }
    @Override
    public void nextTuple() {
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PriorityPip_Source0StreamSymbolList".
        try {
            dataItemSymbolList = sourceData.getSymbolList();
        } catch(DefaultModeException e) {
            dataItemSymbolList.setAllSymbols(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSymbolList!=null){
            _collector.emit("PriorityPip_Source0StreamSymbolList", new Values(dataItemSymbolList));
            emitted = true;
        }

        // Emitting stream "PriorityPip_Source0StreamSpringStream".
        try {
            dataItemSpringStream = sourceData.getSpringStream();
        } catch(DefaultModeException e) {
            dataItemSpringStream.setSymbolTuple(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSpringStream!=null){
            _collector.emit("PriorityPip_Source0StreamSpringStream", new Values(dataItemSpringStream));
            emitted = true;
        }

        if (emitted) {
            aggregateExecutionTime(start);
        }
        
    }


    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_Source0StreamSymbolList", new Fields("datastreamSymbolList"));
        declarer.declareStream("PriorityPip_Source0StreamSpringStream", new Fields("datastreamSpringStream"));
    }
}
