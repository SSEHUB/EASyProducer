package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML last operation. This is works for both list and also to getmax of
 * two integers or reals. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLmax implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        Value max = null;
        if (vv.get(1).resolveValue(context).type() == RU.LIST) {
            max = maxOfList(vv, context); 
        } else {
            max = maxOfValues(vv, context);
        }
        
        return max;
    }

    /**
     * Private method to calculate the maximum of list elements.
     * @param vv ValueVector.
     * @param context Context of the engine.
     * @return maximum value.
     * @throws JessException Should not occur if it is a list and syntactically right.
     */
    private Value maxOfList(ValueVector vv, Context context) throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        int inc = 0;
        double maxValue = v.get(0).numericValue(context);
        
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i).numericValue(context) > maxValue) {
                maxValue = v.get(i).numericValue(context);
                inc = i; 
            }
        }
        return new Value(maxValue, v.get(inc).resolveValue(context).type());
    }
    
    /**
     * Private method to calculate the maximum of given two values (not a list).
     * @param vv ValueVector.
     * @param context Context of the engine.
     * @return Maximum value of the given two values.
     * @throws JessException Should not occur if it syntactically right.
     */
    private Value maxOfValues(ValueVector vv, Context context) throws JessException {
        Value max = null;
        
        if (vv.get(1).numericValue(context) > vv.get(2).numericValue(context)) {
            max = new Value(vv.get(1).numericValue(context), vv.get(1).resolveValue(context).type());
        } else {
            max = new Value(vv.get(2).numericValue(context), vv.get(2).resolveValue(context).type());
        }
        
        return max;
    }

    @Override
    public String getName() {
        return "IVMLmax";
    }

}
