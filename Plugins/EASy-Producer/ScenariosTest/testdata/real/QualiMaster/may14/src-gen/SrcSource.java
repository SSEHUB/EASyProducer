import java.util.*;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.topology.base.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class SrcSource extends BaseRichSpout {

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
    }

    @Override
    public void nextTuple() {
    }

    @Override
    public void close() {
    }

	 @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}
