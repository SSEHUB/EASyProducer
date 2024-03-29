package eu.qualimaster.ReflectiveRandomPip.topology;

import java.util.*;
import java.io.Serializable;
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
import eu.qualimaster.monitoring.events.ParameterChangedMonitoringEvent;
import eu.qualimaster.dataManagement.sources.*;
import eu.qualimaster.dataManagement.events.HistoricalDataProviderRegistrationEvent;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.dataManagement.DataManager;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_14_Source0Source extends BaseSignalSourceSpout implements IDataSourceListener {

    final static Logger logger = Logger.getLogger(PipelineVar_14_Source0Source.class);
    transient SpoutOutputCollector _collector;
    transient IRandomSource sourceData;

    public PipelineVar_14_Source0Source(String name, String namespace) {
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


    /**
     * Sends an parameter change event and considers whether the coordination layer shall be bypassed for direct
     * testing.
     * @param parameter the parameter to be changed
     * @param value the new value
     * @param causeMsgId the message id of the causing message (may be empty or null)
     */
    private static void sendParameterChangeEvent(String parameter, Serializable value, String causeMsgId) {
        EventManager.send(new ParameterChangedMonitoringEvent("ReflectiveRandomPip", "PipelineVar_14_Source0", parameter, value, causeMsgId));
    }

    /**
     * Sends an event for registering the historical data provider of a data source.
     * @param source the data source
     */
    private void sendHistoricalDataProviderRegistrationEvent(IDataSource source) {
        EventManager.send(new HistoricalDataProviderRegistrationEvent(getNamespace(), getName(), source.getHistoricalDataProvider(), source.getIdsNamesMap()));
    }

    protected void configure(SourceMonitor monitor) {
        monitor.setAggregationInterval(60000);
        monitor.registerAggregationKeyProvider(new AggregationKeyProvider<IRandomSourceRandomDataOutput>(IRandomSourceRandomDataOutput.class) {
            @Override
            public String getAggregationKey(IRandomSourceRandomDataOutput tuple) {
                return sourceData.getAggregationKey(tuple);
            }
        });
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            @SuppressWarnings("unchecked")
            Class<? extends IRandomSource> cls = (Class<? extends IRandomSource>) Class.forName("eu.qualimaster.algorithms.RandomSourceAlg");
			boolean autoConnect = "true".equals(conf.get(Constants.CONFIG_KEY_SOURCE_AUTOCONNECT));
			if(autoConnect) {
            	sourceData = DataManager.DATA_SOURCE_MANAGER.createDataSource(getPipeline(), cls, NoStorageStrategyDescriptor.INSTANCE);
			} else {
            	sourceData = cls.newInstance();
			}
			sendHistoricalDataProviderRegistrationEvent(sourceData);
		    sendAlgorithmChangeEvent("RandomSourceAlg", null);
            sourceData.setParameterDelay(PipelineOptions.getExecutorIntArgument(conf, getName(), "delay", 0));
			if(!autoConnect) {
		    	sourceData.connect();
			}
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
        logger.info("The end of the open method.");
    }

    @Override
    protected boolean initMonitorDuringOpen() {
        return false;
    }

    /**
     * Sends an a default mode monitoring event with a DefaultModeException case.
     * @param exceptionCase the DefaultModeException case
     */
    private static void sendDefaultModeMonitoringEvent(DefaultModeException exceptionCase) {
        EventManager.send(new DefaultModeMonitoringEvent("ReflectiveRandomPip", "PipelineVar_14_Source0", exceptionCase));
    }
    @Override
    public void nextTuple() {
        startMonitoring();
        // Emitting stream "PipelineVar_14_Source0StreamRandomData".
        IRandomSourceRandomDataOutput dataItemRandomData = new RandomSource.RandomSourceRandomDataOutput();
        try {
            dataItemRandomData = sourceData.getRandomData();
        } catch(DefaultModeException e) {
            dataItemRandomData.setRandomInteger(0);
            dataItemRandomData.setTimestamp(0);
            sendDefaultModeMonitoringEvent(e);
        }
        if(dataItemRandomData!=null){
            _collector.emit("PipelineVar_14_Source0RandomData", new Values(dataItemRandomData));
        }

        endMonitoring();
        
    }

    @Override
    public void notifyAlgorithmChange(AlgorithmChangeSignal signal) {
    sendAlgorithmChangeEvent(signal.getAlgorithm(), signal.getCauseMessageId());
    super.notifyAlgorithmChange(signal);
}
    @Override
    public void notifyParameterChange(ParameterChangeSignal signal) {
    logger.info("Received the parameter change signal!");
        for(int i = 0; i < signal.getChangeCount(); i++) {
        logger.info("For-loop: Checking each parameter!");
            ParameterChange para = signal.getChange(i);
            switch (para.getName()) {
                case "delay" :
                    try {
                        logger.info("Received the parameter delay!");
                        sourceData.setParameterDelay(para.getIntValue()); 
                        sendParameterChangeEvent("delay", para.getIntValue(), signal.getCauseMessageId());
                    } catch (ValueFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    @Override
    public void notifyIdsNamesMapChanged() {
        sendHistoricalDataProviderRegistrationEvent(sourceData);
    }

    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_14_Source0RandomData", new Fields("PipelineVar_14_Source0RandomDataFields"));
    }

    @Override
    protected void prepareShutdown(ShutdownSignal signal) {
        super.prepareShutdown(signal);
        sourceData.disconnect();
    }

}
