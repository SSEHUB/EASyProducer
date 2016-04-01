import java.util.*;
import backtype.storm.topology.base.*;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class SnkSink extends BaseRichBolt {

    @Override
    public void execute(Tuple tuple) {
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

}
