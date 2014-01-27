package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to define custom function IVMLselect for the operator select.
 * @author Phani
 *
 */
public class IVMLsel implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context engine) throws JessException {

        ValueVector v = vv.get(1).listValue(engine);
        ValueVector list = new ValueVector();
        
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).symbolValue(engine).equals("TRUE")) {
                list.add(i);
            }
        }
        
        return new Value(list, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLsel";
    }

}
