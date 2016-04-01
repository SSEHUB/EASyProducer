package eu.qualimaster.algorithms.TopoHardwareCorrelationFinancial;

import eu.qualimaster.base.algorithm.ITopologyCreate;
import eu.qualimaster.base.algorithm.SubTopologyOutput;
import eu.qualimaster.families.inf.IFCorrelationFinancial;
import eu.qualimaster.observables.IObservable;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.Config;


public class HardwareAlgorithmSubTopology implements ITopologyCreate, IFCorrelationFinancial {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HardwareAlgorithmSubTopology.class);
    private String pipelineName = "PriorityPip";

    public SubTopologyOutput createSubTopology(TopologyBuilder topologyBuilder,
                Config config, String prefix, String input, String streamId) {
        topologyBuilder.setBolt(prefix + "hardwareConnectionBolt", new HardwareConnectionBolt(prefix + "hardwareConnectionBolt",
                                pipelineName), 1).shuffleGrouping(input, streamId);
        topologyBuilder.setSpout(prefix + "hardwareConnectionSpout", new HardwareConnectionSpout(prefix + "hardwareConnectionSpout",
                                pipelineName, streamId), 1);
        return new SubTopologyOutput(prefix + "hardwareConnectionSpout", streamId, 1, 1);
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
