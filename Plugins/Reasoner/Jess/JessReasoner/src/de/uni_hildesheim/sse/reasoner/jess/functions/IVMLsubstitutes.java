package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Method to implement the IVML string operation substitutes.
 * @author Phani
 *
 */
public class IVMLsubstitutes implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        
        String s1 = vv.get(1).stringValue(context);
        String s2 = vv.get(2).stringValue(context);
        String s3 = vv.get(3).stringValue(context);
        s1 = s1.replaceAll(s2, s3);
        return new Value(s1, RU.STRING);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLsubstitutes";
    }

}
