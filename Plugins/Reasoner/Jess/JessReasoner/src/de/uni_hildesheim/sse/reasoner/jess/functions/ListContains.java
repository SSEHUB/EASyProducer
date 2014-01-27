package de.uni_hildesheim.sse.reasoner.jess.functions;

import java.util.List;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement to check if a list contains a string literal.
 * @author Phani
 *
 */
public class ListContains implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        String str = vv.get(2).stringValue(context);
        boolean equals = false;
        @SuppressWarnings({ "rawtypes" })
        List list = (List) vv.get(1).javaObjectValue(context);
//        System.out.println("list and str " + list + "  " + str + " ... " + list.contains(str));
        if (list.contains(str)) {
            equals = true;
        }
//        Value val = new Value(equals);
//        System.out.println("val : " + val.symbolValue(context));
        return new Value(equals);
    }
    
    

    @Override
    public String getName() {
        return "ListContains";
    }

}
