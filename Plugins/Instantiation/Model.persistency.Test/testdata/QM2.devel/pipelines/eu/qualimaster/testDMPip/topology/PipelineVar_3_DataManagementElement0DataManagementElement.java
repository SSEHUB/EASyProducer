package eu.qualimaster.testDMPip.topology;

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
import eu.qualimaster.families.inf.ISwitchFamily.*;

/**
* Defines the FamilyElment in the pipeline(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PipelineVar_3_DataManagementElement0DataManagementElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PipelineVar_3_DataManagementElement0DataManagementElement.class);
    transient OutputCollector _collector;
    private static String streamId;
    private transient IStorageSupport support;
    transient IISwitchFamilyProccessedDataOutput iTuple = null;

    public PipelineVar_3_DataManagementElement0DataManagementElement(String name, String namespace) {
        super(name, namespace);
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		 super.prepare(map, topologyContext, collector);
		 String pipelineName = "testDMPip";
		 String location = "hBase-l3s";
		 IStorageStrategyDescriptor storageStrategy = FirstInFirstOutStorageStrategyDescriptor.INSTANCE;
		 AbstractStorageTable table = DataManager.INTERMEDIARY_STORAGE_MANAGER.getTable(pipelineName, location, storageStrategy);
         support = table.getStorageSupport();
         _collector = collector;
    }

    public void execute(Tuple tuple) {
        iTuple = (IISwitchFamilyProccessedDataOutput)tuple.getValue(0);
        streamId = "PipelineVar_3_DataManagementElement0StreamProccessedData";
        //support.write(iTuple);
        //_collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        super.cleanup();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PipelineVar_3_DataManagementElement0StreamProccessedData", new Fields("IIHBaseDataManagementOutput"));
    }

}
