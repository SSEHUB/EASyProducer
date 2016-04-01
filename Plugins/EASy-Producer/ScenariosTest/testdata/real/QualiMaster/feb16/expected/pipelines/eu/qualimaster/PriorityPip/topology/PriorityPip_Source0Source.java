package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ISpringFinancialData;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.data.imp.SpringFinancialData;
import eu.qualimaster.algorithms.imp.correlation.SpringClient;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;
import eu.qualimaster.monitoring.events.AlgorithmChangedMonitoringEvent;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Source0Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PriorityPip_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient ISpringFinancialData sourceData;

    public PriorityPip_Source0Source(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("PriorityPip", "PriorityPip_Source0", algorithm));
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.SpringClient");
            sourceData = (ISpringFinancialData) cls.newInstance();
            sourceData.setParameterPlayerList(PipelineOptions.getExecutorStringArgument(conf, getName(), "playerList", ""));
		    sourceData.connect();
		    sendAlgorithmChangeEvent("SpringClient");
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
        ISpringFinancialDataSymbolListOutput dataItemSymbolList = new SpringFinancialData.SpringFinancialDataSymbolListOutput();
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
        ISpringFinancialDataSpringStreamOutput dataItemSpringStream = new SpringFinancialData.SpringFinancialDataSpringStreamOutput();
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
    public void notifyParameterChange(ParameterChangeSignal signal) {
        for(int i = 0; i < signal.getChangeCount(); i++) {
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "playerList" :
                    logger.info("Received the parameter playerList!");
                    sourceData.setParameterPlayerList(para.getStringValue()); 
                    break;
            }
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
