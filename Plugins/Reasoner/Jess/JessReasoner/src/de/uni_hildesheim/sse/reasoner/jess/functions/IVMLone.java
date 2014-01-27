package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to define custom function IVMLone for the container operator one.
 * @author Phani
 *
 */
public class IVMLone implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context engine) throws JessException {

        ValueVector v = vv.get(1).listValue(engine);
//        System.out.println("here one .. " + vv.get(1).listValue(engine).toString()
//                    + "list two? " + vv.get(2).listValue(engine).toString());
        
        return new Value(v.size() == 1);
    }

    @Override
    public String getName() {
        return "IVMLone";
    }

}
