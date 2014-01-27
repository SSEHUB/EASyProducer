package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML operation including. 
 * @author Phani
 *
 */
public class IVMLexcluding implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector rV = new ValueVector();
        for (int i = 0; i < vv.get(1).listValue(context).size(); i++) {
            rV.add(vv.get(1).listValue(context).get(i));
        }
        if (rV.contains(vv.get(2).resolveValue(context))) {
            int index = -1;  
            for (int j = 0; j < rV.size(); j++) {
                if (rV.get(j).equals(vv.get(2).resolveValue(context))) {
                    index = j;
                }
            }
            if (index != -1) {
                rV.remove(index);
            }
        }
        
        return new Value(rV, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLexcluding";
    }


}

