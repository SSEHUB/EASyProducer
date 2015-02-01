package eu.qualiMaster.topologies.pipTSI;

import java.util.*;
import org.apache.log4j.Logger;
import backtype.storm.tuple.*;
import backtype.storm.task.*;
import backtype.storm.topology.*;
import eu.qualiMaster.families.inf.*;
import eu.qualiMaster.hardware.inf.HardwareStub;
import eu.qualiMaster.families.inf.IFAdd10.IIFAdd10Output;
import eu.qualiMaster.families.inf.IFDouble.*;
import eu.qualiMaster.families.imp.*;
import eu.qualiMaster.hardware.imp.*;
import eu.qualiMaster.signal.*;
import algorithms.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class PeDoubleFamilyElement extends BaseSignalBolt {

    final static Logger logger = Logger.getLogger(PeDoubleFamilyElement.class);
    OutputCollector _collector;
    private static IIFDoubleOutput result = new FDouble.IFDoubleOutput();
    private transient IFDouble alg = null; // just take the first one, better would be a factory call

    public PeDoubleFamilyElement(String name) {
        super(name);
    }

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        alg = new ADouble1();
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        // delegate to family "fDouble"
        IIFAdd10Output iTuple = (IIFAdd10Output) tuple.getValue(0); //here the tuple indicates the input object
        IIFDoubleInput input = new FDouble.IFDoubleInput();
        input.setValuePlus10(iTuple.getValuePlus10());

        alg.calculate(input, result);
        logger.info("Emitting data: "+ result);
		 _collector.emit(tuple, new Values(result));
		 _collector.ack(tuple);
    }

    protected void checkDisconnect(IFDouble alg) {
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
	             case "ADouble1":
		             if (!(alg instanceof ADouble1)) {
		             alg = new ADouble1(); 
			         }
		             break;
	            case "HwDouble":
		             if (!(alg instanceof HwDouble)) {
			             HwDouble tmp = new HwDouble();
				         tmp.connect(parts[3]);
				         alg = tmp;
			             } else {
			                 checkDisconnect(alg);
			            }
	             }
	         }
        }
        SignalHandler.handle(signal);
	}

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("IIFDoubleOutput"));
    }

}
