package eu.qualimaster.TimeTravelSimPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.timegraph.TimeGraphMapper;
import eu.qualimaster.timegraph.TimeGraphIndexer;
import eu.qualimaster.timegraph.TimeGraphQueryExecutor;

/**
* Define the main topology class(GEN).
**/
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "TimeTravelSimPip";
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
            // Declare a Spout "GraphDataSource"

            builder.setSpout("PipelineVar_18_Source0", new PipelineVar_18_Source0Source("PipelineVar_18_Source0", "TimeTravelSimPip"), 1);
            // Declare a Bolt "TimeGraphMapper"

            BoltDeclarer PipelineVar_18_FamilyElement0=builder.setBolt("PipelineVar_18_FamilyElement0", new PipelineVar_18_FamilyElement0FamilyElement("PipelineVar_18_FamilyElement0", "TimeTravelSimPip"), 1);
            PipelineVar_18_FamilyElement0.shuffleGrouping("PipelineVar_18_Source0", "PipelineVar_18_Source0EdgeStream");
            // Declare a Bolt "TimeGraphIndexer"

            BoltDeclarer PipelineVar_18_FamilyElement1=builder.setBolt("PipelineVar_18_FamilyElement1", new PipelineVar_18_FamilyElement1FamilyElement("PipelineVar_18_FamilyElement1", "TimeTravelSimPip"), 1);
            PipelineVar_18_FamilyElement1.directGrouping("PipelineVar_18_FamilyElement0", "PipelineVar_18_FamilyElement0DataStream");
            PipelineVar_18_FamilyElement1.directGrouping("PipelineVar_18_FamilyElement1", "PipelineVar_18_FamilyElement1InternalRequests");
            // Declare a Bolt "TimeGraphQueryExecutor"

            BoltDeclarer PipelineVar_18_FamilyElement2=builder.setBolt("PipelineVar_18_FamilyElement2", new PipelineVar_18_FamilyElement2FamilyElement("PipelineVar_18_FamilyElement2", "TimeTravelSimPip"), 1);
            PipelineVar_18_FamilyElement2.directGrouping("PipelineVar_18_FamilyElement1", "PipelineVar_18_FamilyElement1ExternalResponses");
            PipelineVar_18_FamilyElement1.directGrouping("PipelineVar_18_FamilyElement2", "PipelineVar_18_FamilyElement2UnicastRequests");
            // Declare a Bolt "TimeTravelSink"

            BoltDeclarer PipelineVar_18_Sink0=builder.setBolt("PipelineVar_18_Sink0", new PipelineVar_18_Sink0Sink("PipelineVar_18_Sink0", "TimeTravelSimPip"), 1);
            PipelineVar_18_Sink0.shuffleGrouping("PipelineVar_18_FamilyElement2", "PipelineVar_18_FamilyElement2SnapshotStream");
            PipelineVar_18_Sink0.shuffleGrouping("PipelineVar_18_FamilyElement2", "PipelineVar_18_FamilyElement2PathStream");
            PipelineVar_18_FamilyElement1.allGrouping("PipelineVar_18_FamilyElement2", "PipelineVar_18_FamilyElement2BroadcastRequests");
            // Declare a Spout "queries"

            builder.setSpout("PipelineVar_18_Source1", new PipelineVar_18_Source1Source("PipelineVar_18_Source1", "TimeTravelSimPip"), 1);
            PipelineVar_18_FamilyElement2.shuffleGrouping("PipelineVar_18_Source1", "PipelineVar_18_Source1SnapshotQueryStream");
            PipelineVar_18_FamilyElement2.shuffleGrouping("PipelineVar_18_Source1", "PipelineVar_18_Source1PathQueryStream");
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
