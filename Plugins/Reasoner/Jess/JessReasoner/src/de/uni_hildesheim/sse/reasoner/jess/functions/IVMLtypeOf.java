package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * This is custom made Jess function for IVML typeOf. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLtypeOf implements Userfunction {

    
    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        
        //ValueVector v = vv.get(1).listValue(context);
        
        int typ = vv.get(1).resolveValue(context).type();
        
        String typeOf = ""; 
        if (typ == RU.INTEGER)  {
            typeOf = "int";
            
            if (vv.get(1).toStringWithParens().contains("enum")) {
                String enumDeclName = vv.get(1).toStringWithParens();
                String delimiter = "_";
                String[] temp;
                temp = enumDeclName.split(delimiter);
                typeOf = temp[1];
            }
        } else if (typ == RU.FACT) {
            typeOf = vv.get(1).factValue(context).getDeftemplate().getBaseName();
        } else  if (typ == RU.LIST) {
            //typeOf = vv.get(1).listValue(context).get(0).factValue(context).getDeftemplate().getBaseName();
            typeOf = internalTypeOf(vv, context, typeOf);
        } else {
            typeOf = vv.get(1).resolveValue(context).toStringWithParens();
            
            
        }
        
        return new Value(typeOf, RU.STRING);
        
    }

    /**
     * Private method to do get the typeOf for a Jess list.
     * @param vv ValuVector.
     * @param context Context of Jess.
     * @param typeOf TypeOf.
     * @return typeOf as string.
     * @throws JessException Should not occur when the Jess transformation is correct syntactically.
     */
    private String internalTypeOf(ValueVector vv, Context context, String typeOf)
        throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        int tempTyp = v.get(0).resolveValue(context).type();
        if (tempTyp == RU.INTEGER) {
            typeOf = "int_" + vv.get(1).toStringWithParens();
        } else if (tempTyp == RU.FACT) {
            typeOf = v.get(0).factValue(context).getDeftemplate().getBaseName();
        } else if (tempTyp == RU.LIST) {
            typeOf = v.get(0).resolveValue(context).toString();
        } else {
            typeOf = v.get(0).resolveValue(context).toString();
            System.out.println("... " + v.get(0).resolveValue(context) + " " + typeOf);
        }
        return typeOf;
    }

    @Override
    public String getName() {
        return "IVMLtypeOf";
    }

}