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
public class ListAdd implements Userfunction {

    @SuppressWarnings("unchecked")
    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        String str = vv.get(2).stringValue(context);
        boolean equals = false;
        @SuppressWarnings({ "rawtypes" })
        List list = (List) vv.get(1).javaObjectValue(context);
        list.add(str);
//        System.out.println("list now is " + list);
        return new Value(list);
    }
    
    

    @Override
    public String getName() {
        return "ListAdd";
    }

}
