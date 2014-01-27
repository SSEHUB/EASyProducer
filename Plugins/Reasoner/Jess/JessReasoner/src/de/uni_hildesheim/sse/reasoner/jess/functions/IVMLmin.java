package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML operation min. This works for 
 * 1) get the minimum of the list elements, and
 * 2) get the minimum of two values. 
 * @author Phani
 *
 */
public class IVMLmin implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        Value min = null;
        if (vv.get(1).resolveValue(context).type() == RU.LIST) {
            min = minOfList(vv, context); 
        } else {
            min = minOfValues(vv, context);
        }
        return min;
    }

    /**
     * Private method to calculate the minimum of list elements.
     * @param vv ValueVector.
     * @param context Context of the engine.
     * @return maximum value.
     * @throws JessException Should not occur if it is a list and syntactically right.
     */
    private Value minOfList(ValueVector vv, Context context) throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        int inc = 0;
        double minValue = v.get(0).numericValue(context);
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i).numericValue(context) < minValue) {
                minValue = v.get(i).numericValue(context);
                inc = i; 
            }
        }
        return new Value(minValue, v.get(inc).resolveValue(context).type());
    } 
    /**
     * Private method to calculate the minimum of given two values (not a list).
     * @param vv ValueVector.
     * @param context Context of the engine.
     * @return Maximum value of the given two values.
     * @throws JessException Should not occur if it syntactically right.
     */
    private Value minOfValues(ValueVector vv, Context context) throws JessException {
        Value min = null;
        if (vv.get(1).numericValue(context) < vv.get(2).numericValue(context)) {
            min = new Value(vv.get(1).numericValue(context), vv.get(1).resolveValue(context).type());
        } else {
            min = new Value(vv.get(2).numericValue(context), vv.get(2).resolveValue(context).type());
        }
        
        return min;

    }

    @Override
    public String getName() {
        return "IVMLmin";
    }

}
