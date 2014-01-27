package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML operation excludes.
 * @author Phani
 *
 */
public class IVMLexcludes implements Userfunction {
   
    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        boolean contains = vv.get(1).listValue(context).contains(vv.get(2).resolveValue(context));
        return new Value(!contains);
    }
    
    @Override
    public String getName() {
        return "IVMLexcludes";
    }

}
