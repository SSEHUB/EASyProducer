package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Method to implement the IVML string operation substring.
 * @author Phani
 *
 */
public class IVMLsubstring implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        String s1 = vv.get(1).stringValue(context);
        int intA = vv.get(2).intValue(context);
        int intB = vv.get(3).intValue(context);
        
        return new Value(s1.substring(intA, intB), RU.STRING);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLsubstring";
    }

}
