package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * Class to implement the IVML operation inverse.
 * @author Phani
 *
 */
public class IVMLminus implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        int type = vv.get(1).resolveValue(context).type();
        int type1 = vv.get(2).resolveValue(context).type();
        Value v = null;
        if (vv.size() == 2) {
            if ((type == RU.INTEGER) && (type1 == RU.INTEGER) ) {
                
                v = new Value(Math.pow(vv.get(1).intValue(context), -1), RU.INTEGER);
            } else {
                v = new Value(Math.pow(vv.get(1).floatValue(context), -1), RU.FLOAT);
            }
        } else if (vv.size() == 3) {
            double minus = vv.get(1).numericValue(context) - vv.get(2).numericValue(context);
//            System.out.println(" type is : " + vv.get(1).resolveValue(context).type());
            if ((type == RU.FLOAT) || (type1 == RU.FLOAT) ) {
                v = new Value(minus, RU.FLOAT);
            } else {
                v = new Value(minus, RU.INTEGER);
            }
            
        }
        
        return v;
    }

    @Override
    public String getName() {
        return "IVMLminus";
    }

}
