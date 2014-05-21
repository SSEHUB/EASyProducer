package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML list operation average - to get the average of all 
 * the list elements. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLavg implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        
        ValueVector v = vv.get(1).listValue(context);
        double sum = v.get(0).numericValue(context);
        int type = v.get(0).resolveValue(context).type();
        
        for (int i = 1; i < v.size(); i++) {
            sum = sum + v.get(i).numericValue(context);
        }
        
        double avg = sum / v.size();
        
        if (type == RU.INTEGER) {
            type = RU.INTEGER;
        } else {
            type = RU.FLOAT;
        }
        return new Value(avg, type);
    }

    @Override
    public String getName() {
        return "IVMLavg";
    }

}