package eu.qualimaster.RandomPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.IRandomSource;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.data.imp.RandomSource;
import eu.qualimaster.algorithms.RandomSourceAlg;
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
public class PipelineVar_1_Source0Source extends BaseSignalSpout {

    final static Logger logger = Logger.getLogger(PipelineVar_1_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient IRandomSource sourceData;

    public PipelineVar_1_Source0Source(String name, String namespace) {
        super(name, namespace);
    }


    /**
     * Sends an algorithm change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param algorithm the new algorithm
     */
    private static void sendAlgorithmChangeEvent(String algorithm) {
        EventManager.send(new AlgorithmChangedMonitoringEvent("RandomPip", "PipelineVar_1_Source0", algorithm));
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.RandomSourceAlg");
            sourceData = (IRandomSource) cls.newInstance();
            sourceData.setParameterDelay(PipelineOptions.getExecutorIntArgument(conf, getName(), "delay", 0));
		    sourceData.connect();
		    sendAlgorithmChangeEvent("RandomSourceAlg");
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
        EventManager.send(new DefaultModeMonitoringEvent("RandomPip", "PipelineVar_1_Source0", exceptionCase));
    }
    @Override
    public void nextTuple() {
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PipelineVar_1_Source0StreamRandomData".
        IRandomSourceRandomDataOutput dataItemRandomData = new RandomSource.RandomSourceRandomDataOutput();
        try {
            dataItemRandomData = sourceData.getRandomData();
        } catch(DefaultModeException e) {
            dataItemRandomData.setRandomInteger(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemRandomData!=null){
            _collector.emit("PipelineVar_1_Source0StreamRandomData", new Values(dataItemRandomData));
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
                case "delay" :
                    try {
                        logger.info("Received the parameter delay!");
                        sourceData.setParameterDelay(para.getIntValue()); 
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
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
        declarer.declareStream("PipelineVar_1_Source0StreamRandomData", new Fields("datastreamRandomData"));
    }
}
