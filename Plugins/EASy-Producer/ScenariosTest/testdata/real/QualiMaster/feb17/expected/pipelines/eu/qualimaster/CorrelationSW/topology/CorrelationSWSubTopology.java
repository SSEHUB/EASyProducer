package eu.qualimaster.CorrelationSW.topology;

import org.apache.log4j.Logger;
import backtype.storm.Config;
import backtype.storm.topology.TopologyBuilder;
import eu.qualimaster.base.algorithm.ITopologyCreate;
import eu.qualimaster.base.algorithm.SubTopologyOutput;
import backtype.storm.topology.BoltDeclarer;
import eu.qualimaster.common.signal.ParameterChangeSignal;
import eu.qualimaster.common.signal.SignalException;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.families.inf.IFCorrelationFinancial;

public class CorrelationSWSubTopology implements IFCorrelationFinancial, ITopologyCreate {
    final static Logger logger = Logger.getLogger(CorrelationSWSubTopology.class);
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
        String namespace = "CorrelationSW";
        if(config.containsKey(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME)) {
            namespace = (String)config.get(eu.qualimaster.common.signal.Constants.CONFIG_KEY_SUBPIPELINE_NAME);
        }
        // Declare a Bolt "Mapper"

        BoltDeclarer SubTopology_FamilyElement0 =builder.setBolt(prefix+"Mapper", new SubTopology_FamilyElement0FamilyElement(prefix+"Mapper", namespace), 1);
        SubTopology_FamilyElement0.shuffleGrouping(input, streamId);
        // Declare a Bolt "HayashiYoshida"

        BoltDeclarer SubTopology_FamilyElement1 =builder.setBolt(prefix+"HayashiYoshida", new SubTopology_FamilyElement1FamilyElement(prefix+"HayashiYoshida", namespace), 14);
        //SubTopology_FamilyElement1 subscribing streams:
        SubTopology_FamilyElement1.directGrouping(prefix+"Mapper", "MapperSymbolsStream");
        SubTopology_FamilyElement1.directGrouping(prefix+"Mapper", "MapperConfigurationStream");
        SubTopology_FamilyElement1.allGrouping(prefix+"Mapper", "MapperResetWindowStream");
        return new SubTopologyOutput(prefix+"HayashiYoshida", "HayashiYoshidaPairwiseFinancial", 4, 14); //TODO: consider PipelineOptions to change the parallelisms
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCorrelationFinancialPreprocessedStreamInput input, IIFCorrelationFinancialPairwiseFinancialOutput pairwiseFinancialResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCorrelationFinancialSymbolListInput input, IIFCorrelationFinancialPairwiseFinancialOutput pairwiseFinancialResult) {
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
            ParameterChangeSignal signal = new ParameterChangeSignal("CorrelationSW", 
                    "CorrelationSWMapper", "windowSize", value, null);
            signal.sendSignal();
        } catch (Exception e) {
            logger.error("Signal not sent!");
            e.printStackTrace();
        }
    }

}
