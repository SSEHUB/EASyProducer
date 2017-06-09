package eu.qualimaster.DynamicGraphPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.GenTopoHardwareCorrelationFinancial.GenTopoHardwareCorrelationFinancialSubTopology;
import eu.qualimaster.CorrelationSW.topology.CorrelationSWSubTopology;
import eu.qualimaster.algorithms.TransferEntropyHardware.TransferEntropyHardwareSubTopology;
import eu.qualimaster.algorithms.MutualInformationHardware.MutualInformationHardwareSubTopology;
import eu.qualimaster.CorrelationSWAlternative.topology.CorrelationSWAlternativeSubTopology;
import eu.qualimaster.dynamicgraph.DynamicGraphCompilation;
import eu.qualimaster.dynamicgraph.TopoDynamicHubComputation;

/**
* Define the main topology class(GEN).
**/
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "DynamicGraphPip";
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
            int numWorkers = 18; //initialized by the pipeline configuration
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
            // Declare a Spout "FinancialDataSource"

            builder.setSpout("PipelineVar_8_Source0", new PipelineVar_8_Source0Source("PipelineVar_8_Source0", "DynamicGraphPip"), 1);
            // Declare a Bolt "preprocessor"

            BoltDeclarer PipelineVar_8_FamilyElement0=builder.setBolt("PipelineVar_8_FamilyElement0", new PipelineVar_8_FamilyElement0FamilyElement("PipelineVar_8_FamilyElement0", "DynamicGraphPip"), 1);
            PipelineVar_8_FamilyElement0.shuffleGrouping("PipelineVar_8_Source0", "PipelineVar_8_Source0SpringStream");
            // Declare a Bolt "CorrelationComputation"

            BoltDeclarer PipelineVar_8_FamilyElement1=builder.setBolt("PipelineVar_8_FamilyElement1", new PipelineVar_8_FamilyElement1FamilyElement("PipelineVar_8_FamilyElement1", "DynamicGraphPip"), 1);
            PipelineVar_8_FamilyElement1.shuffleGrouping("PipelineVar_8_FamilyElement0", "PipelineVar_8_FamilyElement0PreprocessedStream");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"), 14);
            }
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            ITopologyCreate PipelineVar_8_FamilyElement11SubCreator = new TopoSoftwareCorrelationFinancial();
            SubTopologyOutput PipelineVar_8_FamilyElement11SubOutput = PipelineVar_8_FamilyElement11SubCreator.createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1TopoSoftwareCorrelationFinancial");
            builder.endRecording(PipelineVar_8_FamilyElement11SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement11SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement11SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:GenTopoHardwareCorrelationFinancialSubTopology
            ITopologyCreate PipelineVar_8_FamilyElement12SubCreator = new GenTopoHardwareCorrelationFinancialSubTopology();
            SubTopologyOutput PipelineVar_8_FamilyElement12SubOutput = PipelineVar_8_FamilyElement12SubCreator.createSubTopology(builder,config,"GenTopoHardwareCorrelationFinancial", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1GenTopoHardwareCorrelationFinancial");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement12SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement12SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWSubTopology
            ITopologyCreate PipelineVar_8_FamilyElement13SubCreator = new CorrelationSWSubTopology();
            SubTopologyOutput PipelineVar_8_FamilyElement13SubOutput = PipelineVar_8_FamilyElement13SubCreator.createSubTopology(builder,config,"CorrelationSW", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1CorrelationSW");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement13SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement13SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:TransferEntropyHardwareSubTopology
            ITopologyCreate PipelineVar_8_FamilyElement14SubCreator = new TransferEntropyHardwareSubTopology();
            SubTopologyOutput PipelineVar_8_FamilyElement14SubOutput = PipelineVar_8_FamilyElement14SubCreator.createSubTopology(builder,config,"TransferEntropyHardware", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1TransferEntropyHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement14SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement14SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:MutualInformationHardwareSubTopology
            ITopologyCreate PipelineVar_8_FamilyElement15SubCreator = new MutualInformationHardwareSubTopology();
            SubTopologyOutput PipelineVar_8_FamilyElement15SubOutput = PipelineVar_8_FamilyElement15SubCreator.createSubTopology(builder,config,"MutualInformationHardware", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1MutualInformationHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement15SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement15SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWAlternativeSubTopology
            ITopologyCreate PipelineVar_8_FamilyElement16SubCreator = new CorrelationSWAlternativeSubTopology();
            SubTopologyOutput PipelineVar_8_FamilyElement16SubOutput = PipelineVar_8_FamilyElement16SubCreator.createSubTopology(builder,config,"CorrelationSWAlternative", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement1CorrelationSWAlternative");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement16SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement16SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphCompilation"

            BoltDeclarer PipelineVar_8_FamilyElement2=builder.setBolt("PipelineVar_8_FamilyElement2", new PipelineVar_8_FamilyElement2FamilyElement("PipelineVar_8_FamilyElement2", "DynamicGraphPip"), 1);
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement11SubOutput.getBoltName(), PipelineVar_8_FamilyElement11SubOutput.getStreamId());
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement12SubOutput.getBoltName(), PipelineVar_8_FamilyElement12SubOutput.getStreamId());
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement13SubOutput.getBoltName(), PipelineVar_8_FamilyElement13SubOutput.getStreamId());
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement14SubOutput.getBoltName(), PipelineVar_8_FamilyElement14SubOutput.getStreamId());
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement15SubOutput.getBoltName(), PipelineVar_8_FamilyElement15SubOutput.getStreamId());
            PipelineVar_8_FamilyElement2.shuffleGrouping(PipelineVar_8_FamilyElement16SubOutput.getBoltName(), PipelineVar_8_FamilyElement16SubOutput.getStreamId());
            // Declare a Bolt "DynamicHubComputation"

            BoltDeclarer PipelineVar_8_FamilyElement3=builder.setBolt("PipelineVar_8_FamilyElement3", new PipelineVar_8_FamilyElement3FamilyElement("PipelineVar_8_FamilyElement3", "DynamicGraphPip"), 1);
            PipelineVar_8_FamilyElement3.shuffleGrouping("PipelineVar_8_FamilyElement2", "PipelineVar_8_FamilyElement2EdgeStream");
            //generate the Storm-based algorithm topology name:TopoDynamicHubComputation
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("TopoDynamicHubComputation"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("TopoDynamicHubComputation"), 1);
            }
            builder.startRecording("TopoDynamicHubComputation");
            ITopologyCreate PipelineVar_8_FamilyElement31SubCreator = new TopoDynamicHubComputation();
            SubTopologyOutput PipelineVar_8_FamilyElement31SubOutput = PipelineVar_8_FamilyElement31SubCreator.createSubTopology(builder,config,"TopoDynamicHubComputation", "PipelineVar_8_FamilyElement3", "PipelineVar_8_FamilyElement3TopoDynamicHubComputation");
            builder.endRecording(PipelineVar_8_FamilyElement31SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement31SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement31SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphSink"

            BoltDeclarer PipelineVar_8_Sink0=builder.setBolt("PipelineVar_8_Sink0", new PipelineVar_8_Sink0Sink("PipelineVar_8_Sink0", "DynamicGraphPip"), 1);
            PipelineVar_8_Sink0.shuffleGrouping(PipelineVar_8_FamilyElement31SubOutput.getBoltName(), PipelineVar_8_FamilyElement31SubOutput.getStreamId());
            PipelineVar_8_FamilyElement1.shuffleGrouping("PipelineVar_8_Source0", "PipelineVar_8_Source0SymbolList");
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
