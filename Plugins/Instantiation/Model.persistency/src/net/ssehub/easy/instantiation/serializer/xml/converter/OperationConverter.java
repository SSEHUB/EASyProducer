package net.ssehub.easy.instantiation.serializer.xml.converter;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.QualifiedNameMode;
import net.ssehub.easy.varModel.model.datatypes.Types;

/**
 * A type converter for built-in operations. Background: Similar to delegating 
 * singletons also operations must be mapped. Therefore, this class writes the
 * signature to the stream and maps back from the signature.
 * 
 * @author Holger Eichelberger
 */
public class OperationConverter implements Converter {

    /**
     * Stores the signature-operation-mappings. So far we do not allow operations
     * to be modified dynamically.
     */
    private static final Map<String, Operation> OPERATIONS = new HashMap<String, Operation>();

    /**
     * Maps the signatures of the built-in operations to their operations.
     */
    static {
        Types.getTypes();
        int opCount = Operation.getOperationsCount();
        for (int o = 0; o < opCount; o++) {
            Operation operation = Operation.getOperation(o);
            OPERATIONS.put(getSignature(operation), operation);
        }
    }
    
    /**
     * Creates an operation converter.
     */
    public OperationConverter() {
    }

    /**
     * Returns the signature of an operation.
     * 
     * @param operation the operation to return the signature for
     * @return the signature of <code>operation</code>
     */
    private static final String getSignature(Operation operation) {
        IvmlDatatypeVisitor dVis = IvmlDatatypeVisitor.getInstance(QualifiedNameMode.QUALIFIED);
        StringBuilder result = new StringBuilder();
        result.append(dVis.getType(operation.getReturns()));
        dVis.clear();
        result.append("#");
        result.append(operation.getName());
        result.append("(");
        int paramCount = operation.getParameterCount();
        for (int p = 0; p < paramCount; p++) {
            if (p > 0) {
                result.append(",");
            }
            result.append(dVis.getType(operation.getParameter(p)));
            dVis.clear();
        }
        result.append(")");
        IvmlDatatypeVisitor.release(dVis);
        return result.toString();
    }
    
    /**
     * Determines whether this converter instance handles the given class.
     *
     * @param cls the class to be tested
     * @return <code>true</code> if this instance handles <code>class</code> (this 
     *   is only the case if it is an {@link Operation}), <code>false</code> else 
     */
    @SuppressWarnings("rawtypes") 
    public boolean canConvert(Class cls) {
        return cls.equals(Operation.class);
    }

    /**
     * Marshals a given <code>object</code> to the given <code>writer</code> in the 
     * specified marshalling <code>context</code>. This method translates a delegating
     * type singleton to a name.
     * 
     * @param object the object to be marshalled
     * @param writer the output stream writer
     * @param context the marshalling context
     */
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.startNode("signature");
        writer.setValue(getSignature((Operation) object));
        writer.endNode();
    }

    /**
     * Unmarshals the current object to be read from the given <code>reader</code> in the 
     * specified unmarshalling <code>context</code>. This method translates the name
     * back to the singleton instance.
     * 
     * @param reader the input stream writer
     * @param context the marshalling context
     * @return the unmarshalled object
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Object result;
        reader.moveDown();
        result = OPERATIONS.get(reader.getValue());
        reader.moveUp();
        return result;
    }

}
