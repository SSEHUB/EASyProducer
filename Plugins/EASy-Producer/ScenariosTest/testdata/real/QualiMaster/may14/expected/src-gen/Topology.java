import backtype.storm.*;
import backtype.storm.topology.*;

public class Topology {
    static final String TOPOLOGY_NAME = "test";

    public static void main(String[] args) {
        Config config = new Config();
        config.setMessageTimeoutSecs(120);
        TopologyBuilder b = new TopologyBuilder();
        b.setSpout("src", new SrcSource());
        b.setBolt("pe1", new Pe1FamilyElement()).shuffleGrouping("src");
        b.setBolt("snk", new SnkSink()).shuffleGrouping("pe1");

        final LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(TOPOLOGY_NAME, config, b.createTopology());
    }
}
