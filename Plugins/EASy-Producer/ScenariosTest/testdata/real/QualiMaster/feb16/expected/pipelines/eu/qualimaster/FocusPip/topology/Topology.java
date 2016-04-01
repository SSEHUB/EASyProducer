package eu.qualimaster.FocusPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.algorithms.stream.spam.SpamDetectionBolt;
import eu.qualimaster.algorithms.stream.spam.SpamRemovalBolt;
import eu.qualimaster.algorithms.keywordAnalyzer.correlation.BasicKeywordAnalyzerAlgorithm;
import eu.qualimaster.algorithms.recommendations.family.impl.RecommendationsAlgorithm;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
import eu.qualimaster.dynamicgraph.DynamicGraphCompilation;

/**
* Define the main topology class(GEN).
**/
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "FocusPip";
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
            // Declare a Spout "TwitterDataSource"
            builder.setSpout("PipelineVar_7_Source0", new PipelineVar_7_Source0Source("PipelineVar_7_Source0", "FocusPip"), 1).setNumTasks(1);
            // Declare a Bolt "SpamDetection"
            BoltDeclarer PipelineVar_7_FamilyElement0 = builder.setBolt("PipelineVar_7_FamilyElement0", new PipelineVar_7_FamilyElement0FamilyElement("PipelineVar_7_FamilyElement0", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement0
                .shuffleGrouping("PipelineVar_7_Source0", "PipelineVar_7_Source0StreamTwitterStream")
                ;
            // Declare a Bolt "Spam Removal"
            BoltDeclarer PipelineVar_7_FamilyElement1 = builder.setBolt("PipelineVar_7_FamilyElement1", new PipelineVar_7_FamilyElement1FamilyElement("PipelineVar_7_FamilyElement1", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement1
                .shuffleGrouping("PipelineVar_7_FamilyElement0", "PipelineVar_7_FamilyElement0StreamTwitterStream")
                ;
            // Declare a Bolt "StockParser"
            BoltDeclarer PipelineVar_7_FamilyElement2 = builder.setBolt("PipelineVar_7_FamilyElement2", new PipelineVar_7_FamilyElement2FamilyElement("PipelineVar_7_FamilyElement2", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement2
                .shuffleGrouping("PipelineVar_7_FamilyElement1", "PipelineVar_7_FamilyElement1StreamTwitterStream")
                ;
            // Declare a Bolt "EventDetection"
            BoltDeclarer PipelineVar_7_FamilyElement3 = builder.setBolt("PipelineVar_7_FamilyElement3", new PipelineVar_7_FamilyElement3FamilyElement("PipelineVar_7_FamilyElement3", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement3
                .shuffleGrouping("PipelineVar_7_FamilyElement2", "PipelineVar_7_FamilyElement2StreamTwitterStream")
                ;
            // Declare a Bolt "KeywordAnalyzer"
            BoltDeclarer PipelineVar_7_FamilyElement4 = builder.setBolt("PipelineVar_7_FamilyElement4", new PipelineVar_7_FamilyElement4FamilyElement("PipelineVar_7_FamilyElement4", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement4
                .shuffleGrouping("PipelineVar_7_FamilyElement3", "PipelineVar_7_FamilyElement3StreamTwitterStream")
                ;
            // Declare a Bolt "Recommendations"
            BoltDeclarer PipelineVar_7_FamilyElement5 = builder.setBolt("PipelineVar_7_FamilyElement5", new PipelineVar_7_FamilyElement5FamilyElement("PipelineVar_7_FamilyElement5", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement5
                .shuffleGrouping("PipelineVar_7_FamilyElement4", "PipelineVar_7_FamilyElement4StreamTwitterStream")
                ;
            // Declare a Bolt "FocusSink"
            BoltDeclarer PipelineVar_7_Sink0 = builder.setBolt("PipelineVar_7_Sink0", new PipelineVar_7_Sink0Sink("PipelineVar_7_Sink0", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_Sink0
                .shuffleGrouping("PipelineVar_7_FamilyElement5", "PipelineVar_7_FamilyElement5StreamRecommendationStream")
                ;
            // Declare a Spout "SpringDataSource"
            builder.setSpout("PipelineVar_7_Source1", new PipelineVar_7_Source1Source("PipelineVar_7_Source1", "FocusPip"), 1).setNumTasks(1);
            // Declare a Bolt "preprocessor"
            BoltDeclarer PipelineVar_7_FamilyElement6 = builder.setBolt("PipelineVar_7_FamilyElement6", new PipelineVar_7_FamilyElement6FamilyElement("PipelineVar_7_FamilyElement6", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement6
                .shuffleGrouping("PipelineVar_7_Source1", "PipelineVar_7_Source1StreamSpringStream")
                ;
            // Declare a Bolt "correlation"
            BoltDeclarer PipelineVar_7_FamilyElement7 = builder.setBolt("PipelineVar_7_FamilyElement7", new PipelineVar_7_FamilyElement7FamilyElement("PipelineVar_7_FamilyElement7", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement7
                .shuffleGrouping("PipelineVar_7_FamilyElement6", "PipelineVar_7_FamilyElement6StreamPreprocessedStream")
                ;
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            SubTopologyOutput PipelineVar_7_FamilyElement71SubOutput = new TopoSoftwareCorrelationFinancial().createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement71TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement71SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement71SubOutput.getMaxTaskParallelism());
            builder.startRecording("TopoHardwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoHardwareCorrelationFinancial
            SubTopologyOutput PipelineVar_7_FamilyElement72SubOutput = new TopoHardwareCorrelationFinancial().createSubTopology(builder,config,"TopoHardwareCorrelationFinancial", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement72TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement72SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement72SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphCompilation"
            BoltDeclarer PipelineVar_7_FamilyElement8 = builder.setBolt("PipelineVar_7_FamilyElement8", new PipelineVar_7_FamilyElement8FamilyElement("PipelineVar_7_FamilyElement8", "FocusPip"), 1).setNumTasks(1);
            PipelineVar_7_FamilyElement8
                .shuffleGrouping(PipelineVar_7_FamilyElement71SubOutput.getBoltName(), PipelineVar_7_FamilyElement71SubOutput.getStreamId())
                .shuffleGrouping(PipelineVar_7_FamilyElement72SubOutput.getBoltName(), PipelineVar_7_FamilyElement72SubOutput.getStreamId())
                ;
            PipelineVar_7_Sink0
                .shuffleGrouping("PipelineVar_7_FamilyElement8", "PipelineVar_7_FamilyElement8StreamEdgeStream")
                ;
            PipelineVar_7_FamilyElement7
                .shuffleGrouping("PipelineVar_7_Source1", "PipelineVar_7_Source1StreamSymbolList")
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
