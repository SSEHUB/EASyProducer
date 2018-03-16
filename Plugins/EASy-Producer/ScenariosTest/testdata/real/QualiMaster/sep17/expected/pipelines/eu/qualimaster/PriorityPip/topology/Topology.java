package eu.qualimaster.PriorityPip.topology;

import org.apache.log4j.Logger;
import backtype.storm.*;
import backtype.storm.topology.*;
import eu.qualimaster.Configuration;
import eu.qualimaster.base.algorithm.*;
import eu.qualimaster.infrastructure.PipelineOptions;
import eu.qualimaster.base.pipeline.RecordingTopologyBuilder;
import eu.qualimaster.algorithms.imp.correlation.softwaresubtopology.TopoSoftwareCorrelationFinancial;
import eu.qualimaster.algorithms.GenTopoHardwareCorrelationFinancial.GenTopoHardwareCorrelationFinancialSubTopology;
import eu.qualimaster.CorrelationSW.topology.CorrelationSWSubTopology;
import eu.qualimaster.algorithms.TransferEntropyHardware.TransferEntropyHardwareSubTopology;
import eu.qualimaster.algorithms.MutualInformationHardware.MutualInformationHardwareSubTopology;
import eu.qualimaster.CorrelationSWAlternative.topology.CorrelationSWAlternativeSubTopology;
import eu.qualimaster.algorithms.imp.correlation.Preprocessor;
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

            builder.setSpout("PriorityPip_Source0", new PriorityPip_Source0Source("PriorityPip_Source0", "PriorityPip"), 1);
            // Declare a Bolt "FinancialCorrelation"

            BoltDeclarer PriorityPip_FamilyElement0=builder.setBolt("PriorityPip_FamilyElement0", new PriorityPip_FamilyElement0FamilyElement("PriorityPip_FamilyElement0", "PriorityPip"), 1);
            PriorityPip_FamilyElement0.shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0SymbolList");
            //generate the Storm-based algorithm topology name:TopoSoftwareCorrelationFinancial
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("TopoSoftwareCorrelationFinancial"), 14);
            }
            builder.startRecording("TopoSoftwareCorrelationFinancial");
            ITopologyCreate PriorityPip_FamilyElement01SubCreator = new TopoSoftwareCorrelationFinancial();
            SubTopologyOutput PriorityPip_FamilyElement01SubOutput = PriorityPip_FamilyElement01SubCreator.createSubTopology(builder,config,"TopoSoftwareCorrelationFinancial", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0TopoSoftwareCorrelationFinancial");
            builder.endRecording(PriorityPip_FamilyElement01SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement01SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement01SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:GenTopoHardwareCorrelationFinancialSubTopology
            ITopologyCreate PriorityPip_FamilyElement02SubCreator = new GenTopoHardwareCorrelationFinancialSubTopology();
            SubTopologyOutput PriorityPip_FamilyElement02SubOutput = PriorityPip_FamilyElement02SubCreator.createSubTopology(builder,config,"GenTopoHardwareCorrelationFinancial", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0GenTopoHardwareCorrelationFinancial");
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement02SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement02SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWSubTopology
            ITopologyCreate PriorityPip_FamilyElement03SubCreator = new CorrelationSWSubTopology();
            SubTopologyOutput PriorityPip_FamilyElement03SubOutput = PriorityPip_FamilyElement03SubCreator.createSubTopology(builder,config,"CorrelationSW", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0CorrelationSW");
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement03SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement03SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:TransferEntropyHardwareSubTopology
            ITopologyCreate PriorityPip_FamilyElement04SubCreator = new TransferEntropyHardwareSubTopology();
            SubTopologyOutput PriorityPip_FamilyElement04SubOutput = PriorityPip_FamilyElement04SubCreator.createSubTopology(builder,config,"TransferEntropyHardware", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0TransferEntropyHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement04SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement04SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:MutualInformationHardwareSubTopology
            ITopologyCreate PriorityPip_FamilyElement05SubCreator = new MutualInformationHardwareSubTopology();
            SubTopologyOutput PriorityPip_FamilyElement05SubOutput = PriorityPip_FamilyElement05SubCreator.createSubTopology(builder,config,"MutualInformationHardware", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0MutualInformationHardware");
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement05SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement05SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:CorrelationSWAlternativeSubTopology
            ITopologyCreate PriorityPip_FamilyElement06SubCreator = new CorrelationSWAlternativeSubTopology();
            SubTopologyOutput PriorityPip_FamilyElement06SubOutput = PriorityPip_FamilyElement06SubCreator.createSubTopology(builder,config,"CorrelationSWAlternative", "PriorityPip_FamilyElement0", "PriorityPip_FamilyElement0CorrelationSWAlternative");
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement06SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement06SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "Sink"

            BoltDeclarer PriorityPip_Sink0=builder.setBolt("PriorityPip_Sink0", new PriorityPip_Sink0Sink("PriorityPip_Sink0", "PriorityPip"), 1);
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement01SubOutput.getBoltName(), PriorityPip_FamilyElement01SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement02SubOutput.getBoltName(), PriorityPip_FamilyElement02SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement03SubOutput.getBoltName(), PriorityPip_FamilyElement03SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement04SubOutput.getBoltName(), PriorityPip_FamilyElement04SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement05SubOutput.getBoltName(), PriorityPip_FamilyElement05SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement06SubOutput.getBoltName(), PriorityPip_FamilyElement06SubOutput.getStreamId());
            // Declare a Bolt "Preprocessor"

            BoltDeclarer PriorityPip_FamilyElement1=builder.setBolt("PriorityPip_FamilyElement1", new PriorityPip_FamilyElement1FamilyElement("PriorityPip_FamilyElement1", "PriorityPip"), 1);
            PriorityPip_FamilyElement1.shuffleGrouping("PriorityPip_Source0", "PriorityPip_Source0SpringStream");
            PriorityPip_FamilyElement0.shuffleGrouping("PriorityPip_FamilyElement1", "PriorityPip_FamilyElement1PreprocessedStream");
            // Declare a Spout "TwitterDataSource"

            builder.setSpout("PriorityPip_Source1", new PriorityPip_Source1Source("PriorityPip_Source1", "PriorityPip"), 1);
            // Declare a Bolt "SentimentAnalysis"

            BoltDeclarer PriorityPip_FamilyElement2=builder.setBolt("PriorityPip_FamilyElement2", new PriorityPip_FamilyElement2FamilyElement("PriorityPip_FamilyElement2", "PriorityPip"), 1);
            PriorityPip_FamilyElement2.shuffleGrouping("PriorityPip_Source1", "PriorityPip_Source1TwitterStream");
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSentiWordNetTopology
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("SentimentAnaylsisSentiWordNetTopology"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("SentimentAnaylsisSentiWordNetTopology"), 1);
            }
            builder.startRecording("SentimentAnaylsisSentiWordNetTopology");
            ITopologyCreate PriorityPip_FamilyElement21SubCreator = new SentimentAnaylsisSentiWordNetTopology();
            SubTopologyOutput PriorityPip_FamilyElement21SubOutput = PriorityPip_FamilyElement21SubCreator.createSubTopology(builder,config,"SentimentAnaylsisSentiWordNetTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement2SentimentAnaylsisSentiWordNetTopology");
            builder.endRecording(PriorityPip_FamilyElement21SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement21SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement21SubOutput.getMaxTaskParallelism());
            //generate the Storm-based algorithm topology name:SentimentAnaylsisSVMTopology
            if (!config.containsKey(PipelineOptions.getExecutorParallelismKey("SentimentAnaylsisSVMTopology"))) {
                config.put(PipelineOptions.getExecutorParallelismKey("SentimentAnaylsisSVMTopology"), 1);
            }
            builder.startRecording("SentimentAnaylsisSVMTopology");
            ITopologyCreate PriorityPip_FamilyElement22SubCreator = new SentimentAnaylsisSVMTopology();
            SubTopologyOutput PriorityPip_FamilyElement22SubOutput = PriorityPip_FamilyElement22SubCreator.createSubTopology(builder,config,"SentimentAnaylsisSVMTopology", "PriorityPip_FamilyElement2", "PriorityPip_FamilyElement2SentimentAnaylsisSVMTopology");
            builder.endRecording(PriorityPip_FamilyElement22SubCreator);
            maxNumWorkers = Math.max(maxNumWorkers, PriorityPip_FamilyElement22SubOutput.getNumWorkers());
            maxTaskParallelism = Math.max(maxTaskParallelism, PriorityPip_FamilyElement22SubOutput.getMaxTaskParallelism());
            // Declare a Bolt "DataManagement"

            BoltDeclarer PriorityPip_DataManagementElement0=builder.setBolt("PriorityPip_DataManagementElement0", new PriorityPip_DataManagementElement0DataManagementElement("PriorityPip_DataManagementElement0", "PriorityPip"), 1);
            PriorityPip_DataManagementElement0.shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId());
            PriorityPip_DataManagementElement0.shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement21SubOutput.getBoltName(), PriorityPip_FamilyElement21SubOutput.getStreamId());
            PriorityPip_Sink0.shuffleGrouping(PriorityPip_FamilyElement22SubOutput.getBoltName(), PriorityPip_FamilyElement22SubOutput.getStreamId());
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
