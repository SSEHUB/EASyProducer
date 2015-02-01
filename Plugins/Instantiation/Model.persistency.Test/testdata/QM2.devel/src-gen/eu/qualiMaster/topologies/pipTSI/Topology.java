package eu.qualiMaster.topologies.pipTSI;

import backtype.storm.*;
import backtype.storm.topology.*;

public class Topology {
    static final String TOPOLOGY_NAME = "pipTSI";

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setMessageTimeoutSecs(100);
        TopologyBuilder b = new TopologyBuilder();
        b.setSpout("src_TSI", new Src_TSISource());
        b.setBolt("peNormalize", new PeNormalizeFamilyElement("peNormalize")).shuffleGrouping("src_TSI");
        b.setBolt("peAdd10", new PeAdd10FamilyElement("peAdd10")).shuffleGrouping("peNormalize");
        b.setBolt("peDouble", new PeDoubleFamilyElement("peDouble")).shuffleGrouping("peAdd10");
        b.setBolt("peShow", new PeShowFamilyElement("peShow")).shuffleGrouping("peDouble");
        b.setBolt("snk_TSI", new Snk_TSISink("snk_TSI")).shuffleGrouping("peShow");

        if (args != null && args.length > 0) {
            config.setNumWorkers(1);
            StormSubmitter.submitTopology(args[0], config, b.createTopology());
        }
        else{
           final LocalCluster cluster = new LocalCluster();
           cluster.submitTopology(TOPOLOGY_NAME, config, b.createTopology());
        }
    }
}
