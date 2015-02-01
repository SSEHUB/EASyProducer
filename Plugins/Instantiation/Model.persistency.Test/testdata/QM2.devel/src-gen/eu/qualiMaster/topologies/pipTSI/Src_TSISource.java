package eu.qualiMaster.topologies.pipTSI;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.topology.base.*;
import backtype.storm.tuple.*;
import backtype.storm.utils.Utils;
import eu.qualiMaster.data.inf.IFinancialData;
import data.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class Src_TSISource extends BaseRichSpout {

    final static Logger logger = Logger.getLogger(Src_TSISource.class);
    SpoutOutputCollector _collector;
    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        _collector = collector;
    }

    @Override
    public void nextTuple() {
        Utils.sleep(100);
        IFinancialData dataItem = FinancialDataGenerator.getFinancialData();
        if(dataItem!=null){
            String dataString = dataItem.getSymbol() + "," + dataItem.getQuotes() +"," + dataItem.getVolume() + dataItem.getTimestamp();
            logger.info("Get data tuple in FinancialDataSpout:" + dataString);
            _collector.emit(new Values(dataItem),dataItem);
        }
    }

    @Override
    public void close() {
    }

	 @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("datastream"));
    }
}
