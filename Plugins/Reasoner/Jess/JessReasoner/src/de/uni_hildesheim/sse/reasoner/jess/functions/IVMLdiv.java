package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML function div - Integer division Integer.
 * @author Phani
 *
 */
public class IVMLdiv implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        int typ1 = vv.get(1).resolveValue(context).type();
        int typ2 = vv.get(2).resolveValue(context).type();
        
        Value v = null;
        
        boolean operandIsInteger = (typ1 == RU.INTEGER);
        boolean parameterIsInteger = (typ2 == RU.INTEGER);
        
        if (operandIsInteger && parameterIsInteger) {
            v = new Value(vv.get(1).numericValue(context) / vv.get(2).numericValue(context), RU.INTEGER);
            if (vv.get(2).numericValue(context) == 0) {
                v = new Value(0);
            }
        } else {
            v = new Value(vv.get(1).numericValue(context) / vv.get(2).numericValue(context), RU.FLOAT);
            if (vv.get(2).numericValue(context) == 0) {
                v = new Value(0.0);
            }
        }
        return v;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLdiv";
    }

}
