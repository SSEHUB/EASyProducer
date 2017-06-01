package net.ssehub.easy.instantiation.core.model.vilTypes;

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
