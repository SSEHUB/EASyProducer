package eu.qualimaster.PriorityPip.topology;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.topology.*;
import backtype.storm.task.*;
import backtype.storm.spout.*;
import backtype.storm.tuple.*;
import eu.qualimaster.data.inf.ISpringFinancialData;
import eu.qualimaster.data.inf.ISpringFinancialData.*;
import eu.qualimaster.algorithms.imp.correlation.SpringClientSimulator;
import eu.qualimaster.common.signal.*;

/**
* Define the source Spout class(GEN).
**/
@SuppressWarnings({ "rawtypes", "serial" })
public class PriorityPip_Source0Source extends BaseSignalSpout {

    transient SpoutOutputCollector _collector;
    transient ISpringFinancialData sourceData;
    transient ISpringFinancialDataSymbolListOutput dataItemSymbolList = null;
    transient ISpringFinancialDataSpringStreamOutput dataItemSpringStream = null;

    public PriorityPip_Source0Source(String name, String namespace) {
        super(name, namespace);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 super.open(conf, context, collector);
        _collector = collector;
        try {
            Class cls = Class.forName("eu.qualimaster.algorithms.imp.correlation.SpringClientSimulator");
            sourceData = (ISpringFinancialData) cls.newInstance();
        } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
           // TODO Auto-generated catch block
            e.printStackTrace();
        }
		sourceData.connect();
    }

    @Override
    public void nextTuple() {
        // Emitting stream "PriorityPip_Source0StreamSymbolList".
        dataItemSymbolList = sourceData.getSymbolList();
        if(dataItemSymbolList!=null){
            _collector.emit("PriorityPip_Source0StreamSymbolList", new Values(dataItemSymbolList),dataItemSymbolList);
        }

        // Emitting stream "PriorityPip_Source0StreamSpringStream".
        dataItemSpringStream = sourceData.getSpringStream();
        if(dataItemSpringStream!=null){
            _collector.emit("PriorityPip_Source0StreamSpringStream", new Values(dataItemSpringStream),dataItemSpringStream);
        }

    }


    @Override
    public void close() {
        super.close();
		 sourceData.disconnect();
    }

	@Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("PriorityPip_Source0StreamSymbolList", new Fields("datastreamSymbolList"));
        declarer.declareStream("PriorityPip_Source0StreamSpringStream", new Fields("datastreamSpringStream"));
    }
}
