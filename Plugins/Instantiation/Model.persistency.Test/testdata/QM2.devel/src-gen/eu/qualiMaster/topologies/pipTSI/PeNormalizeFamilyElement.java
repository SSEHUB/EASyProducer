package eu.qualiMaster.topologies.pipTSI;

import eu.qualiMaster.data.inf.IFinancialData;
import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualiMaster.families.inf.*;
import eu.qualiMaster.hardware.inf.HardwareStub;
import eu.qualiMaster.families.inf.IFNormalize.*;
import eu.qualiMaster.families.imp.*;
import eu.qualiMaster.hardware.imp.*;
import eu.qualiMaster.signal.*;
import algorithms.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class PeNormalizeFamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PeNormalizeFamilyElement.class);
    OutputCollector _collector;
    private static IIFNormalizeOutput result = new FNormalize.IFNormalizeOutput();
    private transient IFNormalize alg = null; // just take the first one, better would be a factory call

    public PeNormalizeFamilyElement(String name) {
        super(name);
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        alg = new ANormalize1();
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fNormalize"
        IFinancialData iTuple = (IFinancialData)tuple.getValue(0);
        IIFNormalizeInput input = new FNormalize.IFNormalizeInput();
        input.setSpringData(iTuple.getSpringData());

        alg.calculate(input, result);
        logger.info("Emitting data: "+ result);
		 _collector.emit(tuple, new Values(result));
		 _collector.ack(tuple);
    }

    protected void checkDisconnect(IFNormalize alg) {
        if (alg instanceof HardwareStub) {
            ((HardwareStub) alg).disconnect();
            }
    }

	public void onSignal(byte[] data) {
        String signal=new String(data);
        logger.info("Received signal: " + signal);
        //handle the received signal and make related changes, e.g., switch algorithm from software to hardware
        String[] parts = signal.split(":");
        if (parts.length >= 2) {
            if ("param".equals(parts[0]) && 3 == parts.length) {
       	     /*switch (parts[1]) { // just for illustration, may need parameter conversion
 	             case "param1" : 
		         alg.setParamParam1(parts[3]); 
 	             break;
	          }*/
 	         } else if ("alg".equals(parts[0])) {
	             switch (parts[1]) {
	             case "ANormalize1":
		             if (!(alg instanceof ANormalize1)) {
		             alg = new ANormalize1(); 
			         }
		             break;
	             }
	         }
        }
        SignalHandler.handle(signal);
	}

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("IIFNormalizeOutput"));
    }

}
