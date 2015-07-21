package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Prints out all registered types.
 * 
 * @author Holger Eichelberger
 */
public class TypePrinter {

    /**
     * Prints out the types.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        for (TypeDescriptor<?> type : TypeRegistry.DEFAULT.allTypes()) {
            System.out.println(type.getName());
            for (OperationDescriptor op : type.getOperations()) {
                System.out.println(" - " + op.getJavaSignature());
            }
        }
    }
    
}
