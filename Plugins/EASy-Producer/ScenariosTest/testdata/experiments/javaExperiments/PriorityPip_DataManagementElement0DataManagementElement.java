package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualimaster.common.signal.*;
import eu.qualimaster.dataManagement.DataManager;
import eu.qualimaster.dataManagement.storage.AbstractStorageTable;
import eu.qualimaster.dataManagement.storage.support.IStorageSupport;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.families.inf.IFSentimentAnalysis.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_DataManagementElement0DataManagementElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PriorityPip_DataManagementElement0DataManagementElement.class);
    transient OutputCollector _collector;
    private static String streamId;
    private transient IStorageSupport support;
    transient IIFSentimentAnalysisAnalyzedStreamOutput iTupleAnalyzedStream = null;

    public PriorityPip_DataManagementElement0DataManagementElement(String name, String namespace) {
        super(name, namespace);
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
                 super.prepare(map, topologyContext, collector);
                 String pipelineName = "PriorityPip";
                 String location = "hBase-l3s";
                 IStorageStrategyDescriptor storageStrategy = FirstInFirstOutStorageStrategyDescriptor.INSTANCE;
                 AbstractStorageTable table = DataManager.INTERMEDIARY_STORAGE_MANAGER.getTable(pipelineName, location, storageStrategy);
         support = table.getStorageSupport();
         _collector = collector;
        initMonitor();
        logger.info("The end of the prepare method.");
    }

    @Override
    protected boolean initMonitorDuringPrepare() {
        return false;
    }

    public void execute(Tuple tuple) {
        startMonitoring();
    if(tuple instanceof IIFSentimentAnalysisAnalyzedStreamOutput) {
        iTupleAnalyzedStream = (IIFSentimentAnalysisAnalyzedStreamOutput)tuple.getValue(0);
        streamId = "PriorityPip_DataManagementElement0StreamAnalyzedStream";
        //support.write(iTuple);
        //_collector.ack(tuple);
    }
        endMonitoring();
    }

    @Override
    public void cleanup() {
        super.cleanup();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_DataManagementElement0StreamAnalyzedStream", new Fields("IIHBaseDataManagementOutput"));
    }

}
