package eu.qualiMaster.algorithms;

/**
 * Define the interface for creating algorithm topology.
**/
public interface ITopologyCreate {
    /**
     * Create the algorithm topology without Spout
    **/
    public String createTopology(String spoutName);
}
