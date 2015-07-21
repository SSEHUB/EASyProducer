package eu.qualimaster.topologies.PriorityPip;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationTwitter;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationTwitter;

/**
* Define the main topology class(GEN).
**/
public class Topology {
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "PriorityPip";
    private static int maxNumWorkers = 1; //initialized by default value
    private static int maxTaskParallelism = 1; //initialized by default value

    public static void main(String[] args) throws Exception {
        int numWorkers = 7; //initialized by the pipeline configuration
        Config config = new Config();
        config.setMessageTimeoutSecs(100);
        config.setDebug(false);
        config.put("windowSize", 1 * 30);  // Window size (in secs)
        config.put("windowAdvance", 1);  // Advance of the window (in secs)

        if (args != null && args.length > 0) {
            config.put(Configuration.HOST_EVENT, Configuration.getEventHost());
            config.put(Configuration.PORT_EVENT, Configuration.getEventPort());
        }

        TopologyBuilder b = new TopologyBuilder();
        // Declare a Spout "FinancialDataSource"
        b.setSpout("PriorityPip_Source0", new PriorityPip_Source0Source("PriorityPip_Source0", "PriorityPip"), 1);
        // Declare a Bolt "Preprocessor"
        BoltDeclarer PriorityPip_FamilyElement0 = b.setBolt("PriorityPip_FamilyElement0", new PriorityPip_FamilyElement0FamilyElement("PriorityPip_FamilyElement0", "PriorityPip"), 1);
        PriorityPip_FamilyElement0
        .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0Stream1")
        ;
        // Declare a Bolt "FinancialCorrelation"
        BoltDeclarer PriorityPip_FamilyElement1 = b.setBolt("PriorityPip_FamilyElement1", new PriorityPip_FamilyElement1FamilyElement("PriorityPip_FamilyElement1", "PriorityPip"), 1);
        PriorityPip_FamilyElement1
        .shuffleGrouping("PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0Stream")
        ;
        //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
        SubTopologyOutput PriorityPip_FamilyElement11SubOutput = new TopoSoftwareCorrelationFinancial().createSubTopology(b,config,"TopoSoftwareCorrelationFinancial", "PriorityPip_FamilyElement1", "PriorityPip_FamilyElement11TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement11SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement11SubOutput.getMaxTaskParallelism());
        //generate the Storm-based algorithm topology name:TopoHardwareCorrelationFinancial
        SubTopologyOutput PriorityPip_FamilyElement12SubOutput = new TopoHardwareCorrelationFinancial().createSubTopology(b,config,"TopoHardwareCorrelationFinancial", "PriorityPip_FamilyElement1", "PriorityPip_FamilyElement12TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement12SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement12SubOutput.getMaxTaskParallelism());
        // Declare a Bolt "Sink"
        BoltDeclarer PriorityPip_Sink0 = b.setBolt("PriorityPip_Sink0", new PriorityPip_Sink0Sink("PriorityPip_Sink0", "PriorityPip"), 1);
        PriorityPip_Sink0
        .shuffleGrouping(PriorityPip_FamilyElement11SubOutput.getBoltName(), PriorityPip_FamilyElement11SubOutput.getStreamId())
        .shuffleGrouping(PriorityPip_FamilyElement12SubOutput.getBoltName(), PriorityPip_FamilyElement12SubOutput.getStreamId())
        ;
        PriorityPip_FamilyElement1
        .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0Stream2")
        ;
        // Declare a Spout "TwitterDataSource"
        b.setSpout("PriorityPip_Source1", new PriorityPip_Source1Source("PriorityPip_Source1", "PriorityPip"), 1);
        // Declare a Bolt "SentimentAnalysis"
        BoltDeclarer PriorityPip_FamilyElement2 = b.setBolt("PriorityPip_FamilyElement2", new PriorityPip_FamilyElement2FamilyElement("PriorityPip_FamilyElement2", "PriorityPip"), 1);
        PriorityPip_FamilyElement2
        .shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1Stream1")
        ;
        //generate the Storm-based algorithm topology name:SentimentAnaylsisSentiWordNetTopology
        SubTopologyOutput PriorityPip_FamilyElement21SubOutput = new SentimentAnaylsisSentiWordNetTopology().createSubTopology(b,config,"SentimentAnaylsisSentiWordNetTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement21TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement21SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement21SubOutput.getMaxTaskParallelism());
        //generate the Storm-based algorithm topology name:SentimentAnaylsisSVMTopology
        SubTopologyOutput PriorityPip_FamilyElement22SubOutput = new SentimentAnaylsisSVMTopology().createSubTopology(b,config,"SentimentAnaylsisSVMTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement22TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement22SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement22SubOutput.getMaxTaskParallelism());
        // Declare a Bolt "DataManagement"
        BoltDeclarer PriorityPip_DataManagementElement0 = b.setBolt("PriorityPip_DataManagementElement0", new PriorityPip_DataManagementElement0DataManagementElement("PriorityPip_DataManagementElement0", "PriorityPip"), 1);
        PriorityPip_DataManagementElement0
        .shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId())
        .shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId())
        ;
        // Declare a Bolt "TwitterCorrelation"
        BoltDeclarer PriorityPip_FamilyElement3 = b.setBolt("PriorityPip_FamilyElement3", new PriorityPip_FamilyElement3FamilyElement("PriorityPip_FamilyElement3", "PriorityPip"), 1);
        PriorityPip_FamilyElement3
        .shuffleGrouping("PriorityPip_DataManagementElement0", "PriorityPip_DataManagementElement0Stream")
        ;
        //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationTwitter
        SubTopologyOutput PriorityPip_FamilyElement31SubOutput = new TopoSoftwareCorrelationTwitter().createSubTopology(b,config,"TopoSoftwareCorrelationTwitter", "PriorityPip_FamilyElement3", "PriorityPip_FamilyElement31TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement31SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement31SubOutput.getMaxTaskParallelism());
        //generate the Storm-based algorithm topology name:TopoHardwareCorrelationTwitter
        SubTopologyOutput PriorityPip_FamilyElement32SubOutput = new TopoHardwareCorrelationTwitter().createSubTopology(b,config,"TopoHardwareCorrelationTwitter", "PriorityPip_FamilyElement3", "PriorityPip_FamilyElement32TopoStream");
        maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement32SubOutput.getNumWorkers());
        maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement32SubOutput.getMaxTaskParallelism());
        PriorityPip_Sink0
        .shuffleGrouping(PriorityPip_FamilyElement31SubOutput.getBoltName(), PriorityPip_FamilyElement31SubOutput.getStreamId())
        .shuffleGrouping(PriorityPip_FamilyElement32SubOutput.getBoltName(), PriorityPip_FamilyElement32SubOutput.getStreamId())
        ;
        PriorityPip_FamilyElement3
        .shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1Stream2")
        ;

        if (args != null && args.length > 0) {
            if(maxNumWorkers > numWorkers) {
                logger.error("ERROR: the number of workers in sub-topology is larger than in the main topology!");
            }
            config.setNumWorkers(numWorkers);
            StormSubmitter.submitTopology(args[0], config, b.createTopology());
        }
        else{
           config.setMaxTaskParallelism(maxTaskParallelism);
           final LocalCluster cluster = new LocalCluster();
           cluster.submitTopology(TOPOLOGY_NAME, config, b.createTopology());
        }
    }
}
