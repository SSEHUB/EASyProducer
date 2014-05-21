package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * This is custom made Jess function for IVML indexOf. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLindexOf implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        
        int index = -1;

        boolean toBreak = false;
        
        for (int i = 0; !toBreak && i < vv.get(1).listValue(context).size(); i++) {
            
            if (vv.get(1).listValue(context).get(i).equals(vv.get(2).resolveValue(context))) {
                index = i;
                toBreak = true;
               // break;
            }
            
        }
        
        Value v;
        if (index != -1) {
            v = new Value(index, RU.INTEGER);
        } else {
            v = new Value(-1, RU.INTEGER);
        }
        
        return v;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLindexOf";
    }

}
