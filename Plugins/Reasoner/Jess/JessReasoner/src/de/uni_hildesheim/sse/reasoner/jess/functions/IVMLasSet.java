package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for asSet. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLasSet implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        ValueVector v1 = new ValueVector();
        if (vv.get(2).intValue(context) == 1) {
            
            for (int i = 0; i < v.size(); i++) {
                if (!v1.contains(v.get(i))) {
                    v1.add(v.get(i));
                }
            }
        } else {
            v1.addAll(v);
        }
       
        return new Value(v1, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLasSet";
    }

}