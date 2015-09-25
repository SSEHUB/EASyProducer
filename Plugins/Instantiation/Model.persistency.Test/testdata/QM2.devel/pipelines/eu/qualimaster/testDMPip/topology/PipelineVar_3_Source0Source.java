package eu.qualimaster.testDMPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.IRandomSource;
import eu.qualimaster.data.inf.IRandomSource.*;
import eu.qualimaster.algorithms.RandomSourceAlg;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.events.EventManager;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.pipeline.DefaultModeException;
import eu.qualimaster.pipeline.DefaultModeMonitoringEvent;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_3_Source0Source extends BaseSignalSpout {

    transient SpoutOutputCollector _collector;
    transient IRandomSource sourceData;
    transient IRandomSourceRandomDataOutput dataItemRandomData = null;

    public PipelineVar_3_Source0Source(String name, String namespace) {
        super(name, namespace);
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
        EventManager.send(new DefaultModeMonitoringEvent("testDMPip", "PipelineVar_3_Source0", exceptionCase));
    }
    @Override
    public void nextTuple() {
        long start = System.currentTimeMillis();
        boolean emitted = false;
        // Emitting stream "PipelineVar_3_Source0StreamRandomData".
        try {
            dataItemRandomData = sourceData.getRandomData();
        } catch(DefaultModeException e) {
            dataItemRandomData.setRandomInteger(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemRandomData!=null){
            _collector.emit("PipelineVar_3_Source0StreamRandomData", new Values(dataItemRandomData));
            emitted = true;
        }

        if (emitted) {
            aggregateExecutionTime(start);
        }
        
    }

    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
        try {
            switch (signal.getParameter()) {
                case "delay" :
                    sourceData.setParameterDelay(signal.getIntValue()); 
                    break;
            }
        } catch (ValueFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_3_Source0StreamRandomData", new Fields("datastreamRandomData"));
    }
}
