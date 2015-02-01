package eu.qualiMaster.topologies.pipTSI;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualiMaster.signal.*;
import eu.qualiMaster.families.inf.IFShow.IIFShowOutput;

@SuppressWarnings({ "rawtypes", "serial" })
public class Snk_TSISink extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(Snk_TSISink.class);
    OutputCollector _collector;

	public Snk_TSISink(String name) {
        super(name);
   }
    @Override
    public void execute(Tuple tuple) {
        //for now, sink just emits the tuple that get from last familyelement
        IIFShowOutput iTuple = (IIFShowOutput) tuple.getValue(0); 
        logger.info("Emitting data from Sink:" + iTuple);
        _collector.emit(tuple, new Values(iTuple));
        _collector.ack(tuple);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        _collector = collector;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("sinkData"));
    }

    @Override
    public void onSignal(byte[] data) {
    }
}
