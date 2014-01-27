package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to define custom function IVMLrej for the operator rej.
 * @author Phani
 *
 */
public class IVMLrej implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context engine) throws JessException {

        ValueVector v = vv.get(1).listValue(engine);
        ValueVector list = new ValueVector();
         
        for (int i = 0; i < vv.get(2).listValue(engine).size(); i++) {
            if (!v.contains(new Value(i, RU.INTEGER))) {
                list.add(vv.get(2).listValue(engine).get(i));
            }
        }
        
        return new Value(list, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLrej";
    }

}
