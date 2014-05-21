package de.uni_hildesheim.sse.persistency;

import java.io.StringWriter;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.IPartialEvaluable;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Turns model (parts) into strings.
 * 
 * @author Holger Eichelberger
 * @author Christian Kröher
 */
public class StringProvider {

    /**
     * Turns a model element into a string containing IVML.
     * 
     * @param element the element to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(ModelElement element) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        element.accept(visitor);
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;
    }
    
    /**
     * Turns a syntax tree into a string containing IVML.
     * 
     * @param cst the constraint syntax tree to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(ConstraintSyntaxTree cst) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        cst.accept(visitor);
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;        
    }
    
    /**
     * Turns a value into a string containing IVML.
     * 
     * @param value the value to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(Value value) {
        String result;
        if (null != value) {
            StringWriter writer = new StringWriter();
            IVMLWriter visitor = IVMLWriter.getInstance(writer);
            value.accept(visitor);
            result = writer.toString();
            IVMLWriter.releaseInstance(visitor);
        } else {
            result = "";
        }
        return result;        
    }
    
    /**
     * Turns a type into a string containing IVML.
     * 
     * @param type the type to be turned into a string
     * @return The resulting string as unique string using {@link IvmlDatatypeVisitor}
     */
    public static final String toIvmlString(IDatatype type) {
        return IvmlDatatypeVisitor.getUniqueType(type);
    }
    
    /**
     * Turns an evaluable element into a string containing IVML.
     * 
     * @param element the evaluable element to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(IPartialEvaluable element) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        element.accept(visitor);
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;
    }
    
}
