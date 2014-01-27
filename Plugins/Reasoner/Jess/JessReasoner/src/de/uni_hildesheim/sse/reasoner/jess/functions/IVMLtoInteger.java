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
public class IVMLtoInteger implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        String s1 = vv.get(1).stringValue(context);
        int intA = Integer.valueOf(s1);
        return new Value(intA, RU.INTEGER);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLtoInteger";
    }

}
