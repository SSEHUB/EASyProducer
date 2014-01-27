package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * This is custom made Jess function for IVML append. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLappend implements Userfunction {
    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector rVector = new ValueVector();
        rVector.addAll(vv.get(1).listValue(context));
        rVector.add(vv.get(2).resolveValue(context));

        return new Value(rVector, RU.LIST);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLappend";
    }

}
