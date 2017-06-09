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
import eu.qualimaster.algorithms.stockParser.family.impl.StockParserAlgorithm;
import eu.qualimaster.algorithms.stream.eventdetection.family.impl.EventDetectionHardThresholdAlgorithm;
import eu.qualimaster.algorithms.keywordAnalyzer.correlation.BasicKeywordAnalyzerAlgorithm;
import eu.qualimaster.algorithms.recommendations.family.impl.RecommendationsAlgorithm;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.GenTopoHardwareCorrelationFinancial.GenTopoHardwareCorrelationFinancialSubTopology;
import eu.qualimaster.CorrelationSW.topology.CorrelationSWSubTopology;
import eu.qualimaster.algorithms.TransferEntropyHardware.TransferEntropyHardwareSubTopology;
import eu.qualimaster.algorithms.MutualInformationHardware.MutualInformationHardwareSubTopology;
import eu.qualimaster.CorrelationSWAlternative.topology.CorrelationSWAlternativeSubTopology;
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
            int numWorkers = 13; //initialized by the pipeline configuration
            Config config = new Config();
            config.setMessageTimeoutSecs(100);
            config.setDebug(false);
            config.put("windowSize", 1 * 30);  // Window size (in secs)
            config.put("windowAdvance", 1);  // Advance of the window (in secs)
            if(options.isSubPipeline()) {
                config.put(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME, options.getMainPipeline());
            } else {
            config.put(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME, TOPOLOGY_NAME); //sub-pipeline namespace
            }
			//The settings to optimize the storm performance.
			config.put(Config.TOPOLOGY_RECEIVER_BUFFER_SIZE, 8);
			config.put(Config.TOPOLOGY_TRANSFER_BUFFER_SIZE, 32);
			config.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, 16384);
			config.put(Config.TOPOLOGY_EXECUTOR_SEND_BUFFER_SIZE, 16384);
            config.put(Configuration.HOST_EVENT, Configuration.getEventHost());
            config.put(Configuration.PORT_EVENT, Configuration.getEventPort());
            config.put(Configuration.EVENT_DISABLE_LOGGING, Configuration.getEventDisableLogging());
			 config.put(Configuration.PIPELINE_INTERCONN_PORTS, Configuration.getPipelinePorts());
            options.toConf(config);

            RecordingTopologyBuilder builder = new RecordingTopologyBuilder(options);
            // Declare a Spout "TwitterDataSource"

            builder.setSpout("PipelineVar_7_Source0", new PipelineVar_7_Source0Source("PipelineVar_7_Source0", "FocusPip"), 1);
            // Declare a Bolt "SpamDetection"

            BoltDeclarer PipelineVar_7_FamilyElement0=builder.setBolt("PipelineVar_7_FamilyElement0", new PipelineVar_7_FamilyElement0FamilyElement("PipelineVar_7_FamilyElement0", "FocusPip"), 1);
            PipelineVar_7_FamilyElement0.shuffleGrouping("PipelineVar_7_Source0", "PipelineVar_7_Source0TwitterStream");
            // Declare a Bolt "Spam Removal"

            BoltDeclarer PipelineVar_7_FamilyElement1=builder.setBolt("PipelineVar_7_FamilyElement1", new PipelineVar_7_FamilyElement1FamilyElement("PipelineVar_7_FamilyElement1", "FocusPip"), 1);
            PipelineVar_7_FamilyElement1.shuffleGrouping("PipelineVar_7_FamilyElement0", "PipelineVar_7_FamilyElement0TwitterStream");
            // Declare a Bolt "StockParser"

            BoltDeclarer PipelineVar_7_FamilyElement2=builder.setBolt("PipelineVar_7_FamilyElement2", new PipelineVar_7_FamilyElement2FamilyElement("PipelineVar_7_FamilyElement2", "FocusPip"), 1);
            PipelineVar_7_FamilyElement2.shuffleGrouping("PipelineVar_7_FamilyElement1", "PipelineVar_7_FamilyElement1TwitterStream");
            // Declare a Bolt "EventDetection"

            BoltDeclarer PipelineVar_7_FamilyElement3=builder.setBolt("PipelineVar_7_FamilyElement3", new PipelineVar_7_FamilyElement3FamilyElement("PipelineVar_7_FamilyElement3", "FocusPip"), 1);
            PipelineVar_7_FamilyElement3.shuffleGrouping("PipelineVar_7_FamilyElement2", "PipelineVar_7_FamilyElement2TwitterStream");
            // Declare a Bolt "KeywordAnalyzer"

            BoltDeclarer PipelineVar_7_FamilyElement4=builder.setBolt("PipelineVar_7_FamilyElement4", new PipelineVar_7_FamilyElement4FamilyElement("PipelineVar_7_FamilyElement4", "FocusPip"), 1);
            PipelineVar_7_FamilyElement4.shuffleGrouping("PipelineVar_7_FamilyElement3", "PipelineVar_7_FamilyElement3TwitterStream");
            // Declare a Bolt "Recommendations"

            BoltDeclarer PipelineVar_7_FamilyElement5=builder.setBolt("PipelineVar_7_FamilyElement5", new PipelineVar_7_FamilyElement5FamilyElement("PipelineVar_7_FamilyElement5", "FocusPip"), 1);
            PipelineVar_7_FamilyElement5.shuffleGrouping("PipelineVar_7_FamilyElement4", "PipelineVar_7_FamilyElement4TwitterStream");
            // Declare a Bolt "FocusSink"

            BoltDeclarer PipelineVar_7_Sink0=builder.setBolt("PipelineVar_7_Sink0", new PipelineVar_7_Sink0Sink("PipelineVar_7_Sink0", "FocusPip"), 1);
            PipelineVar_7_Sink0.shuffleGrouping("PipelineVar_7_FamilyElement5", "PipelineVar_7_FamilyElement5RecommendationStream");
            // Declare a Spout "SpringDataSource"

            builder.setSpout("PipelineVar_7_Source1", new PipelineVar_7_Source1Source("PipelineVar_7_Source1", "FocusPip"), 1);
            // Declare a Bolt "preprocessor"

            BoltDeclarer PipelineVar_7_FamilyElement6=builder.setBolt("PipelineVar_7_FamilyElement6", new PipelineVar_7_FamilyElement6FamilyElement("PipelineVar_7_FamilyElement6", "FocusPip"), 1);
            PipelineVar_7_FamilyElement6.shuffleGrouping("PipelineVar_7_Source1", "PipelineVar_7_Source1SpringStream");
            // Declare a Bolt "correlation"

            BoltDeclarer PipelineVar_7_FamilyElement7=builder.setBolt("PipelineVar_7_FamilyElement7", new PipelineVar_7_FamilyElement7FamilyElement("PipelineVar_7_FamilyElement7", "FocusPip"), 1);
            PipelineVar_7_FamilyElement7.shuffleGrouping("PipelineVar_7_FamilyElement6", "PipelineVar_7_FamilyElement6PreprocessedStream");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"), 14);
            }
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            ITopologyCreate PipelineVar_7_FamilyElement71SubCreator = new TopoSoftwareCorrelationFinancial();
            SubTopologyOutput PipelineVar_7_FamilyElement71SubOutput = PipelineVar_7_FamilyElement71SubCreator.createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7TopoSoftwareCorrelationFinancial");
            builder.endRecording(PipelineVar_7_FamilyElement71SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement71SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement71SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:GenTopoHardwareCorrelationFinancialSubTopology
            ITopologyCreate PipelineVar_7_FamilyElement72SubCreator = new GenTopoHardwareCorrelationFinancialSubTopology();
            SubTopologyOutput PipelineVar_7_FamilyElement72SubOutput = PipelineVar_7_FamilyElement72SubCreator.createSubTopology(builder,config,"GenTopoHardwareCorrelationFinancial", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7GenTopoHardwareCorrelationFinancial");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement72SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement72SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWSubTopology
            ITopologyCreate PipelineVar_7_FamilyElement73SubCreator = new CorrelationSWSubTopology();
            SubTopologyOutput PipelineVar_7_FamilyElement73SubOutput = PipelineVar_7_FamilyElement73SubCreator.createSubTopology(builder,config,"CorrelationSW", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7CorrelationSW");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement73SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement73SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:TransferEntropyHardwareSubTopology
            ITopologyCreate PipelineVar_7_FamilyElement74SubCreator = new TransferEntropyHardwareSubTopology();
            SubTopologyOutput PipelineVar_7_FamilyElement74SubOutput = PipelineVar_7_FamilyElement74SubCreator.createSubTopology(builder,config,"TransferEntropyHardware", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7TransferEntropyHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement74SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement74SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:MutualInformationHardwareSubTopology
            ITopologyCreate PipelineVar_7_FamilyElement75SubCreator = new MutualInformationHardwareSubTopology();
            SubTopologyOutput PipelineVar_7_FamilyElement75SubOutput = PipelineVar_7_FamilyElement75SubCreator.createSubTopology(builder,config,"MutualInformationHardware", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7MutualInformationHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement75SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement75SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWAlternativeSubTopology
            ITopologyCreate PipelineVar_7_FamilyElement76SubCreator = new CorrelationSWAlternativeSubTopology();
            SubTopologyOutput PipelineVar_7_FamilyElement76SubOutput = PipelineVar_7_FamilyElement76SubCreator.createSubTopology(builder,config,"CorrelationSWAlternative", "PipelineVar_7_FamilyElement7", "PipelineVar_7_FamilyElement7CorrelationSWAlternative");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_7_FamilyElement76SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_7_FamilyElement76SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphCompilation"

            BoltDeclarer PipelineVar_7_FamilyElement8=builder.setBolt("PipelineVar_7_FamilyElement8", new PipelineVar_7_FamilyElement8FamilyElement("PipelineVar_7_FamilyElement8", "FocusPip"), 1);
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement71SubOutput.getBoltName(), PipelineVar_7_FamilyElement71SubOutput.getStreamId());
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement72SubOutput.getBoltName(), PipelineVar_7_FamilyElement72SubOutput.getStreamId());
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement73SubOutput.getBoltName(), PipelineVar_7_FamilyElement73SubOutput.getStreamId());
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement74SubOutput.getBoltName(), PipelineVar_7_FamilyElement74SubOutput.getStreamId());
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement75SubOutput.getBoltName(), PipelineVar_7_FamilyElement75SubOutput.getStreamId());
            PipelineVar_7_FamilyElement8.shuffleGrouping(PipelineVar_7_FamilyElement76SubOutput.getBoltName(), PipelineVar_7_FamilyElement76SubOutput.getStreamId());
            PipelineVar_7_Sink0.shuffleGrouping("PipelineVar_7_FamilyElement8", "PipelineVar_7_FamilyElement8EdgeStream");
            PipelineVar_7_FamilyElement7.shuffleGrouping("PipelineVar_7_Source1", "PipelineVar_7_Source1SymbolList");
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
        int numWorkers = options.getNumberOfWorkers(defNumWorkers);

        //submit the topology in the real cluster
        if (args != null && args.length > 0) {
            if(!options.isInProfilingMode()) {
                if(maxNumWorkers > numWorkers) {
                    logger.warn("WARNING: the number of workers in sub-topology is larger than in the main topology!");
                }
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
