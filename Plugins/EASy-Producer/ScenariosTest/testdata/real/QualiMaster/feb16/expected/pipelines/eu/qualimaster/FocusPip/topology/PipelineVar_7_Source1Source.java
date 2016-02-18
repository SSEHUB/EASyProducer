package eu.qualimaster.FocusPip.topology;

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
public class PipelineVar_7_Source1Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PipelineVar_7_Source1Source.class);
    transient SpoutOutputCollector _collector;
    transient ISpringFinancialData sourceData;

    public PipelineVar_7_Source1Source(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("FocusPip", "PipelineVar_7_Source1", algorithm));
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
        EventManager.send(new DefaultModeMonitoringEvent("FocusPip", "PipelineVar_7_Source1", exceptionCase));
    }
    @Override
    public void nextTuple() {
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PipelineVar_7_Source1StreamSymbolList".
        ISpringFinancialDataSymbolListOutput dataItemSymbolList = new SpringFinancialData.SpringFinancialDataSymbolListOutput();
        try {
            dataItemSymbolList = sourceData.getSymbolList();
        } catch(DefaultModeException e) {
            dataItemSymbolList.setAllSymbols(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSymbolList!=null){
            _collector.emit("PipelineVar_7_Source1StreamSymbolList", new Values(dataItemSymbolList));
            emitted = true;
        }

        // Emitting stream "PipelineVar_7_Source1StreamSpringStream".
        ISpringFinancialDataSpringStreamOutput dataItemSpringStream = new SpringFinancialData.SpringFinancialDataSpringStreamOutput();
        try {
            dataItemSpringStream = sourceData.getSpringStream();
        } catch(DefaultModeException e) {
            dataItemSpringStream.setSymbolTuple(null);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemSpringStream!=null){
            _collector.emit("PipelineVar_7_Source1StreamSpringStream", new Values(dataItemSpringStream));
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
        declarer.declareStream("PipelineVar_7_Source1StreamSymbolList", new Fields("datastreamSymbolList"));
        declarer.declareStream("PipelineVar_7_Source1StreamSpringStream", new Fields("datastreamSpringStream"));
    }
}
