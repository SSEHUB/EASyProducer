package eu.qualimaster.RandomSubPipeline2.topology;

import org.apache.log4j.Logger;
import backtype.storm.Config;
import backtype.storm.topology.TopologyBuilder;
import eu.qualimaster.base.algorithm.ITopologyCreate;
import eu.qualimaster.base.algorithm.SubTopologyOutput;
import backtype.storm.topology.BoltDeclarer;
import eu.qualimaster.common.signal.ParameterChangeSignal;
import eu.qualimaster.common.signal.SignalException;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.families.inf.IRandomFamily;

public class RandomSubPipeline2SubTopology implements IRandomFamily, ITopologyCreate {
    final static Logger logger = Logger.getLogger(RandomSubPipeline2SubTopology.class);
    private int delay;
    private boolean flag;
    private int windowSize;
    private transient State state;

    public void switchState(State arg0) {
        this.state = arg0;	
    }

    public Double getMeasurement(IObservable observable) {
        return null;
    }

    public SubTopologyOutput createSubTopology(TopologyBuilder builder,
    			Config config, String prefix, String input, String streamId) {
        String namespace = "RandomSubPipeline2";
        if(config.containsKey(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME)) {
            namespace = (String)config.get(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME);
        }
        // Declare a Bolt "dataProcessor2"

        BoltDeclarer SubPipelineVar_15_FamilyElement0 =builder.setBolt(prefix+"DataProcessor2", new SubPipelineVar_15_FamilyElement0FamilyElement(prefix+"DataProcessor2", namespace), 1);
        SubPipelineVar_15_FamilyElement0.shuffleGrouping(input, streamId);
        return new SubTopologyOutput(prefix+"DataProcessor2", "DataProcessor2RandomData", 1, 1); //TODO: consider PipelineOptions to change the parallelisms
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIRandomFamilyRandomDataInput input, IIRandomFamilyRandomDataOutput randomDataResult) {
    }


    /**
     * Sets the algorithm parameter "delay". Note that the actual parameter change will be dynamically
     * handled by the infrastructure via parameter mapping. This method is only for the purpose of testing the
     * sub-topology.
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDelay(int value) {
        this.delay = delay;
        try {
            logger.info("sending new Delay signal " + value + "!");
            ParameterChangeSignal signal = new ParameterChangeSignal("RandomSubPipeline2", 
                    "RandomSubPipeline2DataProcessor2", "delay", value, null);
            signal.sendSignal();
        } catch (Exception e) {
            logger.error("Signal not sent!");
            e.printStackTrace();
        }
    }

    /**
     * Sets the algorithm parameter "flag". Note that the actual parameter change will be dynamically
     * handled by the infrastructure via parameter mapping. This method is only for the purpose of testing the
     * sub-topology.
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFlag(boolean value) {
        this.flag = flag;
        try {
            logger.info("sending new Flag signal " + value + "!");
            ParameterChangeSignal signal = new ParameterChangeSignal("RandomSubPipeline2", 
                    "RandomSubPipeline2DataProcessor2", "flag", value, null);
            signal.sendSignal();
        } catch (Exception e) {
            logger.error("Signal not sent!");
            e.printStackTrace();
        }
    }

    /**
     * Sets the algorithm parameter "windowSize". Note that the actual parameter change will be dynamically
     * handled by the infrastructure via parameter mapping. This method is only for the purpose of testing the
     * sub-topology.
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
        this.windowSize = windowSize;
        try {
            logger.info("sending new WindowSize signal " + value + "!");
            ParameterChangeSignal signal = new ParameterChangeSignal("RandomSubPipeline2", 
                    "RandomSubPipeline2DataProcessor2", "windowSize", value, null);
            signal.sendSignal();
        } catch (Exception e) {
            logger.error("Signal not sent!");
            e.printStackTrace();
        }
    }

}
