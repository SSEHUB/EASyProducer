package eu.qualimaster.RandomPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.algorithms.RandomProcessor1;
import eu.qualimaster.algorithms.RandomProcessor2;

/**
* Define the main topology class(GEN).
**/
public class Topology{
    final static Logger logger = Logger.getLogger(Topology.class);
    static final String TOPOLOGY_NAME = "RandomPip";
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
            int numWorkers = 1; //initialized by the pipeline configuration
            Config config = new Config();
            config.setMessageTimeoutSecs(100);
            config.setDebug(false);
            config.put("windowSize", 1 * 30);  // Window size (in secs)
            config.put("windowAdvance", 1);  // Advance of the window (in secs)
            config.put(Configuration.HOST_EVENT, Configuration.getEventHost());
            config.put(Configuration.PORT_EVENT, Configuration.getEventPort());

            TopologyBuilder builder = new TopologyBuilder();
            // Declare a Spout "src"
            builder.setSpout("PipelineVar_1_Source0", new PipelineVar_1_Source0Source("PipelineVar_1_Source0", "RandomPip"), 1);
            // Declare a Bolt "processor"
            BoltDeclarer PipelineVar_1_FamilyElement0 = builder.setBolt("PipelineVar_1_FamilyElement0", new PipelineVar_1_FamilyElement0FamilyElement("PipelineVar_1_FamilyElement0", "RandomPip"), 1);
            PipelineVar_1_FamilyElement0
                .shuffleGrouping("PipelineVar_1_Source0", "PipelineVar_1_Source0StreamRandomData")
                ;
            //generate the Storm-based algorithm topology name:RandomProcessor1
            SubTopologyOutput PipelineVar_1_FamilyElement01SubOutput = new RandomProcessor1().createSubTopology(builder,config,"RandomProcessor1", "PipelineVar_1_FamilyElement0", "PipelineVar_1_FamilyElement01TopoStream");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_1_FamilyElement01SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_1_FamilyElement01SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:RandomProcessor2
            SubTopologyOutput PipelineVar_1_FamilyElement02SubOutput = new RandomProcessor2().createSubTopology(builder,config,"RandomProcessor2", "PipelineVar_1_FamilyElement0", "PipelineVar_1_FamilyElement02TopoStream");
            maxNumWorkers = Math.max(maxNumWorkers, PipelineVar_1_FamilyElement02SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PipelineVar_1_FamilyElement02SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "snk"
            BoltDeclarer PipelineVar_1_Sink0 = builder.setBolt("PipelineVar_1_Sink0", new PipelineVar_1_Sink0Sink("PipelineVar_1_Sink0", "RandomPip"), 1);
            PipelineVar_1_Sink0
                .shuffleGrouping(PipelineVar_1_FamilyElement01SubOutput.getBoltName(), PipelineVar_1_FamilyElement01SubOutput.getStreamId())
                .shuffleGrouping(PipelineVar_1_FamilyElement02SubOutput.getBoltName(), PipelineVar_1_FamilyElement02SubOutput.getStreamId())
                ;
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
        int numWorkers = topo.getNumWorkers();

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
