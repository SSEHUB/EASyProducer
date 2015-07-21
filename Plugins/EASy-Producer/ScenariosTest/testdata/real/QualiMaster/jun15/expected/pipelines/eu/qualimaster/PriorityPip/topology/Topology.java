package eu.qualimaster.PriorityPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
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
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "PriorityPip";
    private static int maxNumWorkers = 1; //initialized by default value
    private static int maxTaskParallelism = 1; //initialized by default value

    /**
     * Define a class for creating the main topology.
     */
    public static class MainTopologyCreator implements IMainTopologyCreate {
        /**
         * Create a main topology.
         * @return a TopologyOutput carring the storm config and TopologyBuilder information
         */
        public TopologyOutput createMainTopology() {
            int numWorkers = 7; //initialized by the pipeline configuration
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

            RecordingTopologyBuilder builder = new RecordingTopologyBuilder();
            // Declare a Spout "FinancialDataSource"
            builder.setSpout("PriorityPip_Source0", new PriorityPip_Source0Source("PriorityPip_Source0", "PriorityPip"), 1);
            // Declare a Bolt "Preprocessor"
            BoltDeclarer PriorityPip_FamilyElement0 = builder.setBolt("PriorityPip_FamilyElement0", new PriorityPip_FamilyElement0FamilyElement("PriorityPip_FamilyElement0", "PriorityPip"), 1);
            PriorityPip_FamilyElement0
                .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0StreamSpringStream")
                ;
            // Declare a Bolt "FinancialCorrelation"
            BoltDeclarer PriorityPip_FamilyElement1 = builder.setBolt("PriorityPip_FamilyElement1", new PriorityPip_FamilyElement1FamilyElement("PriorityPip_FamilyElement1", "PriorityPip"), 1);
            PriorityPip_FamilyElement1
                .shuffleGrouping("PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0StreamPreprocessedStream")
                ;
            builder.startRecording("PriorityPip_FamilyElement1");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            SubTopologyOutput PriorityPip_FamilyElement11SubOutput = new TopoSoftwareCorrelationFinancial().createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PriorityPip_FamilyElement1", "PriorityPip_FamilyElement11TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement11SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement11SubOutput.getMaxTaskParallelism());
            builder.startRecording("PriorityPip_FamilyElement1");
            //generate the Storm-based algorithm topology name:TopoHardwareCorrelationFinancial
            SubTopologyOutput PriorityPip_FamilyElement12SubOutput = new TopoHardwareCorrelationFinancial().createSubTopology(builder,config,"TopoHardwareCorrelationFinancial", "PriorityPip_FamilyElement1", "PriorityPip_FamilyElement12TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement12SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement12SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "Sink"
            BoltDeclarer PriorityPip_Sink0 = builder.setBolt("PriorityPip_Sink0", new PriorityPip_Sink0Sink("PriorityPip_Sink0", "PriorityPip"), 1);
            PriorityPip_Sink0
                .shuffleGrouping(PriorityPip_FamilyElement11SubOutput.getBoltName(), PriorityPip_FamilyElement11SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement12SubOutput.getBoltName(), PriorityPip_FamilyElement12SubOutput.getStreamId())
                ;
            PriorityPip_FamilyElement1
                .shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0StreamSymbolList")
                ;
            // Declare a Spout "TwitterDataSource"
            builder.setSpout("PriorityPip_Source1", new PriorityPip_Source1Source("PriorityPip_Source1", "PriorityPip"), 1);
            // Declare a Bolt "SentimentAnalysis"
            BoltDeclarer PriorityPip_FamilyElement2 = builder.setBolt("PriorityPip_FamilyElement2", new PriorityPip_FamilyElement2FamilyElement("PriorityPip_FamilyElement2", "PriorityPip"), 1);
            PriorityPip_FamilyElement2
                .shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1StreamTwitterStream")
                ;
            builder.startRecording("PriorityPip_FamilyElement2");
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSentiWordNetTopology
            SubTopologyOutput PriorityPip_FamilyElement21SubOutput = new SentimentAnaylsisSentiWordNetTopology().createSubTopology(builder,config,"SentimentAnaylsisSentiWordNetTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement21TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement21SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement21SubOutput.getMaxTaskParallelism());
            builder.startRecording("PriorityPip_FamilyElement2");
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSVMTopology
            SubTopologyOutput PriorityPip_FamilyElement22SubOutput = new SentimentAnaylsisSVMTopology().createSubTopology(builder,config,"SentimentAnaylsisSVMTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement22TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement22SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement22SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DataManagement"
            BoltDeclarer PriorityPip_DataManagementElement0 = builder.setBolt("PriorityPip_DataManagementElement0", new PriorityPip_DataManagementElement0DataManagementElement("PriorityPip_DataManagementElement0", "PriorityPip"), 1);
            PriorityPip_DataManagementElement0
                .shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId())
                ;
            // Declare a Bolt "TwitterCorrelation"
            BoltDeclarer PriorityPip_FamilyElement3 = builder.setBolt("PriorityPip_FamilyElement3", new PriorityPip_FamilyElement3FamilyElement("PriorityPip_FamilyElement3", "PriorityPip"), 1);
            PriorityPip_FamilyElement3
                .shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId())
                ;
            builder.startRecording("PriorityPip_FamilyElement3");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationTwitter
            SubTopologyOutput PriorityPip_FamilyElement31SubOutput = new TopoSoftwareCorrelationTwitter().createSubTopology(builder,config,"TopoSoftwareCorrelationTwitter", "PriorityPip_FamilyElement3", "PriorityPip_FamilyElement31TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement31SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement31SubOutput.getMaxTaskParallelism());
            builder.startRecording("PriorityPip_FamilyElement3");
            //generate the Storm-based algorithm topology name:TopoHardwareCorrelationTwitter
            SubTopologyOutput PriorityPip_FamilyElement32SubOutput = new TopoHardwareCorrelationTwitter().createSubTopology(builder,config,"TopoHardwareCorrelationTwitter", "PriorityPip_FamilyElement3", "PriorityPip_FamilyElement32TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement32SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement32SubOutput.getMaxTaskParallelism());
            PriorityPip_Sink0
                .shuffleGrouping(PriorityPip_FamilyElement31SubOutput.getBoltName(), PriorityPip_FamilyElement31SubOutput.getStreamId())
                .shuffleGrouping(PriorityPip_FamilyElement32SubOutput.getBoltName(), PriorityPip_FamilyElement32SubOutput.getStreamId())
                ;
            PriorityPip_FamilyElement3
                .shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1StreamSymbolList")
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
        MainTopologyCreator topoCreator = new MainTopologyCreator();
        TopologyOutput topo = topoCreator.createMainTopology();
        //get the topology information
        Config config = topo.getConfig();
        TopologyBuilder builder = topo.getBuilder();
        int defNumWorkers = topo.getNumWorkers();
        PipelineOptions options = new PipelineOptions(args);
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
