package eu.qualimaster.algorithms.MutualInformationHardware;

import eu.qualimaster.base.algorithm.ITopologyCreate;
import eu.qualimaster.base.algorithm.SubTopologyOutput;
import eu.qualimaster.families.inf.IFCorrelationFinancial;
import eu.qualimaster.observables.IObservable;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.Config;
import eu.qualimaster.infrastructure.PipelineOptions;

public class MutualInformationHardwareSubTopology implements ITopologyCreate, IFCorrelationFinancial {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MutualInformationHardwareSubTopology.class);
    private String pipelineName = "TimeTravelSimPip";

    public SubTopologyOutput createSubTopology(TopologyBuilder topologyBuilder,
                Config config, String prefix, String input, String streamId) {
        String keyPrefix = prefix + ".MutualInformationHardware.";
        String senderKey = keyPrefix + "sender";
        String receiverKey = keyPrefix + "receiver";
        int senderParallelism = PipelineOptions.getExecutorParallelism(config, senderKey, 1);
        int senderTasks = PipelineOptions.getTaskParallelism(config, senderKey, 1);
        int receiverParallelism = PipelineOptions.getExecutorParallelism(config, receiverKey, 1);
        int receiverTasks = PipelineOptions.getTaskParallelism(config, receiverKey, 1);
        int totalParallelism = Math.max(senderParallelism, receiverParallelism);
        topologyBuilder.setSpout(prefix + "HardwareConnectionSpout", new HardwareConnectionSpout(prefix + "HardwareConnectionSpout",
                                pipelineName, streamId), receiverParallelism).setNumTasks(receiverTasks);
        topologyBuilder.setBolt(prefix + "HardwareConnectionBolt", new HardwareConnectionBolt(prefix + "HardwareConnectionBolt",
                                pipelineName), senderParallelism).setNumTasks(senderTasks).shuffleGrouping(input, streamId);
        return new SubTopologyOutput(prefix + "HardwareConnectionSpout", streamId, 1, totalParallelism);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationFinancialPreprocessedStreamInput input, IIFCorrelationFinancialPairwiseFinancialOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFCorrelationFinancialSymbolListInput input, IIFCorrelationFinancialPairwiseFinancialOutput result){
    }

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
    }

    public Double getMeasurement(IObservable observable) {
        return null; 
    }

    @Override
    public void switchState(State state) {
    }

}
