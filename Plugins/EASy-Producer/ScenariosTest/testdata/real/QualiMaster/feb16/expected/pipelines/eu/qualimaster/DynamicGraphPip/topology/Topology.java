package eu.qualimaster.DynamicGraphPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.imp.correlation.hardwaresubtopology.TopoHardwareCorrelationFinancial;
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
            builder.setSpout("PipelineVar_8_Source0", new PipelineVar_8_Source0Source("PipelineVar_8_Source0", "DynamicGraphPip"), 1).setNumTasks(1);
            // Declare a Bolt "preprocessor"
            BoltDeclarer PipelineVar_8_FamilyElement0 = builder.setBolt("PipelineVar_8_FamilyElement0", new PipelineVar_8_FamilyElement0FamilyElement("PipelineVar_8_FamilyElement0", "DynamicGraphPip"), 1).setNumTasks(1);
            PipelineVar_8_FamilyElement0
                .shuffleGrouping("PipelineVar_8_Source0", "PipelineVar_8_Source0StreamSpringStream")
                ;
            // Declare a Bolt "CorrelationComputation"
            BoltDeclarer PipelineVar_8_FamilyElement1 = builder.setBolt("PipelineVar_8_FamilyElement1", new PipelineVar_8_FamilyElement1FamilyElement("PipelineVar_8_FamilyElement1", "DynamicGraphPip"), 1).setNumTasks(1);
            PipelineVar_8_FamilyElement1
                .shuffleGrouping("PipelineVar_8_FamilyElement0", "PipelineVar_8_FamilyElement0StreamPreprocessedStream")
                ;
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            SubTopologyOutput PipelineVar_8_FamilyElement11SubOutput = new TopoSoftwareCorrelationFinancial().createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement11TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement11SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement11SubOutput.getMaxTaskParallelism());
            builder.startRecording("TopoHardwareCorrelationFinancial");
            //generate the Storm-based algorithm topology name:TopoHardwareCorrelationFinancial
            SubTopologyOutput PipelineVar_8_FamilyElement12SubOutput = new TopoHardwareCorrelationFinancial().createSubTopology(builder,config,"TopoHardwareCorrelationFinancial", "PipelineVar_8_FamilyElement1", "PipelineVar_8_FamilyElement12TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement12SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement12SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphCompilation"
            BoltDeclarer PipelineVar_8_FamilyElement2 = builder.setBolt("PipelineVar_8_FamilyElement2", new PipelineVar_8_FamilyElement2FamilyElement("PipelineVar_8_FamilyElement2", "DynamicGraphPip"), 1).setNumTasks(1);
            PipelineVar_8_FamilyElement2
                .shuffleGrouping(PipelineVar_8_FamilyElement11SubOutput.getBoltName(), PipelineVar_8_FamilyElement11SubOutput.getStreamId())
                .shuffleGrouping(PipelineVar_8_FamilyElement12SubOutput.getBoltName(), PipelineVar_8_FamilyElement12SubOutput.getStreamId())
                ;
            // Declare a Bolt "DynamicHubComputation"
            BoltDeclarer PipelineVar_8_FamilyElement3 = builder.setBolt("PipelineVar_8_FamilyElement3", new PipelineVar_8_FamilyElement3FamilyElement("PipelineVar_8_FamilyElement3", "DynamicGraphPip"), 1).setNumTasks(1);
            PipelineVar_8_FamilyElement3
                .shuffleGrouping("PipelineVar_8_FamilyElement2", "PipelineVar_8_FamilyElement2StreamEdgeStream")
                ;
            builder.startRecording("TopoDynamicHubComputation");
            //generate the Storm-based algorithm topology name:TopoDynamicHubComputation
            SubTopologyOutput PipelineVar_8_FamilyElement31SubOutput = new TopoDynamicHubComputation().createSubTopology(builder,config,"TopoDynamicHubComputation", "PipelineVar_8_FamilyElement3", "PipelineVar_8_FamilyElement31TopoStream");
            builder.endRecording();
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_8_FamilyElement31SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_8_FamilyElement31SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DynamicGraphSink"
            BoltDeclarer PipelineVar_8_Sink0 = builder.setBolt("PipelineVar_8_Sink0", new PipelineVar_8_Sink0Sink("PipelineVar_8_Sink0", "DynamicGraphPip"), 1).setNumTasks(1);
            PipelineVar_8_Sink0
                .shuffleGrouping(PipelineVar_8_FamilyElement31SubOutput.getBoltName(), PipelineVar_8_FamilyElement31SubOutput.getStreamId())
                ;
            PipelineVar_8_FamilyElement1
                .shuffleGrouping("PipelineVar_8_Source0", "PipelineVar_8_Source0StreamSymbolList")
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
