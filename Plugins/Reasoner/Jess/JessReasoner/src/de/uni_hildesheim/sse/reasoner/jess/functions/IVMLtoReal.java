package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML string operation toInteger.
 * @author Phani
 *
 */
public class IVMLtoReal implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        String s1 = vv.get(1).stringValue(context);
        double realA = Double.valueOf(s1);
        
        return new Value(realA, RU.FLOAT);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLtoReal";
    }

}
