package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML list operation product - to get the product of all the list elements. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLproduct implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        
        ValueVector v = vv.get(1).listValue(context);
        double product = v.get(0).numericValue(context);
        int type = v.get(0).resolveValue(context).type();
        int inc = 0;
        
        for (int i = 1; i < v.size(); i++) {
            product = product * v.get(i).numericValue(context);
            //System.out.println("type is " + v.get(i).resolveValue(context).type());
            if (v.get(i).resolveValue(context).type() == RU.FLOAT) {
                inc++;
            }
            
        } 
        
        if (inc > 0) {
            type = RU.FLOAT;
        } else {
            type = RU.INTEGER;
        }
        return new Value(product, type);
    }

    @Override
    public String getName() {
        return "IVMLproduct";
    }

}
