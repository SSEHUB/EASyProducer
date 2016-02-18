package eu.qualimaster.PriorityPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSentiWordNetTopology;
import eu.qualimaster.algorithms.stream.sentiment.topology.impl.SentimentAnaylsisSVMTopology;

/**
* Define the main topology class(GEN).
**/
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "PriorityPip";
    private static int maxNumWorkers = 1; //initialized by default value
    private static int maxTaskParallelism = 1; //initialized by default value
    private static PipelineOptions options = null; //initialized by default value

    /**
     * Define a class for creating the main topology.
     */
    public static class MainTopologyCreator implements IMainTopologyCreate {
        /**
         * Create a main topology.
         * @return a TopologyOutput carring the storm config and TopologyBuilder information
         */
        public TopologyOutput createMainTopology() {
            int numWorkers = 1; //initialized by the pipeline configuration
            Config config = new Config();
            config.setMessageTimeoutSecs(100);
            config.setDebug(false);
            config.put("windowSize", 1 * 30);  // Window size (in secs)
            config.put("windowAdvance", 1);  // Advance of the window (in secs)
			//The settings to optimize the storm performance.
			config.put(Config.TOPOLOGY_RECEIVER_BUFFER_SIZE, 8);
			config.put(Config.TOPOLOGY_TRANSFER_BUFFER_SIZE, 32);
			config.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, 16384);
			config.put(Config.TOPOLOGY_EXECUTOR_SEND_BUFFER_SIZE, 16384);
            config.put(Configuration.HOST_EVENT, Configuration.getEventHost());
            config.put(Configuration.PORT_EVENT, Configuration.getEventPort());
            config.put(Configuration.EVENT_DISABLE_LOGGING, Configuration.getEventDisableLogging());

            RecordingTopologyBuilder builder = new RecordingTopologyBuilder(options);
            // Declare a Spout "FinancialDataSource"
            builder.setSpout("PriorityPip_Source0", new PriorityPip_Source0Source("PriorityPip_Source0", "PriorityPip"), 1).setNumTasks(1);
            // Declare a Bolt "FinancialCorrelation"
            BoltDeclarer PriorityPip_FamilyElement0 = builder.setBolt("PriorityPip_FamilyElement0", new PriorityPip_FamilyElement0FamilyElement("PriorityPip_FamilyElement0", "PriorityPip"), 1).setNumTasks(1);
            PriorityPip_FamilyElement0
                .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0StreamSymbolList")
                ;
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            SubTopologyOutput PriorityPip_FamilyElement01SubOutput = new TopoSoftwareCorrelationFinancial().createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement01TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement01SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement01SubOutput.getMaxTaskParallelism());
            builder.startRecording("TopoHardwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoHardwareCorrelationFinancial
            SubTopologyOutput PriorityPip_FamilyElement02SubOutput = new TopoHardwareCorrelationFinancial().createSubTopology(builder,config,"TopoHardwareCorrelationFinancial", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement02TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement02SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement02SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "Sink"
            BoltDeclarer PriorityPip_Sink0 = builder.setBolt("PriorityPip_Sink0", new PriorityPip_Sink0Sink("PriorityPip_Sink0", "PriorityPip"), 1).setNumTasks(1);
            PriorityPip_Sink0
                .shuffleGrouping(PriorityPip_FamilyElement01SubOutput.getBoltName(), PriorityPip_FamilyElement01SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement02SubOutput.getBoltName(), PriorityPip_FamilyElement02SubOutput.getStreamId())
                ;
            // Declare a Bolt "Preprocessor"
            BoltDeclarer PriorityPip_FamilyElement1 = builder.setBolt("PriorityPip_FamilyElement1", new PriorityPip_FamilyElement1FamilyElement("PriorityPip_FamilyElement1", "PriorityPip"), 1).setNumTasks(1);
            PriorityPip_FamilyElement1
                .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0StreamSpringStream")
                ;
            PriorityPip_FamilyElement0
                .shuffleGrouping("PriorityPip_FamilyElement1", "PriorityPip_FamilyElement1StreamPreprocessedStream")
                ;
            // Declare a Spout "TwitterDataSource"
            builder.setSpout("PriorityPip_Source1", new PriorityPip_Source1Source("PriorityPip_Source1", "PriorityPip"), 1).setNumTasks(1);
            // Declare a Bolt "SentimentAnalysis"
            BoltDeclarer PriorityPip_FamilyElement2 = builder.setBolt("PriorityPip_FamilyElement2", new PriorityPip_FamilyElement2FamilyElement("PriorityPip_FamilyElement2", "PriorityPip"), 1).setNumTasks(1);
            PriorityPip_FamilyElement2
                .shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1StreamTwitterStream")
                ;
            builder.startRecording("SentimentAnaylsisSentiWordNetTopology");
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSentiWordNetTopology
            SubTopologyOutput PriorityPip_FamilyElement21SubOutput = new SentimentAnaylsisSentiWordNetTopology().createSubTopology(builder,config,"SentimentAnaylsisSentiWordNetTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement21TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement21SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement21SubOutput.getMaxTaskParallelism());
            builder.startRecording("SentimentAnaylsisSVMTopology");
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSVMTopology
            SubTopologyOutput PriorityPip_FamilyElement22SubOutput = new SentimentAnaylsisSVMTopology().createSubTopology(builder,config,"SentimentAnaylsisSVMTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement22TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement22SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement22SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DataManagement"
            BoltDeclarer PriorityPip_DataManagementElement0 = builder.setBolt("PriorityPip_DataManagementElement0", new PriorityPip_DataManagementElement0DataManagementElement("PriorityPip_DataManagementElement0", "PriorityPip"), 1).setNumTasks(1);
            PriorityPip_DataManagementElement0
                .shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId())
                ;
            PriorityPip_Sink0
                .shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId())
                ;
            builder.close(TOPOLOGY_NAME, config);
            return new TopologyOutput(config, builder, numWorkers);
        }

    }
    /**
     * Main method.
     */
    public static void main(String[] args) throws Exception {
        //create the main topology.
        options = new PipelineOptions(args);
        MainTopologyCreator topoCreator = new MainTopologyCreator();
        TopologyOutput topo = topoCreator.createMainTopology();
        //get the topology information
        Config config = topo.getConfig();
        TopologyBuilder builder = topo.getBuilder();
        int defNumWorkers = topo.getNumWorkers();
        options.toConf(config);
        int numWorkers = options.getNumberOfWorkers(defNumWorkers);

        //submit the topology in the real cluster
        if (args != null && args.length > 0) {
            if(maxNumWorkers > numWorkers) {
                logger.error("ERROR: the number of workers in sub-topology is larger than in the main topology!");
            }
            config.setNumWorkers(numWorkers);
            StormSubmitter.submitTopology(args[0], config, builder.createTopology());
        }
        else{ //submit the topology locally
           config.setMaxTaskParallelism(maxTaskParallelism);
           final LocalCluster cluster = new LocalCluster();
           cluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
        }
    }
}
