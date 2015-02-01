package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * An internal temporary node representing an untyped empty initializer. 
 * Problem is that we allow the same syntax for empty compound and container 
 * initializers, i.e., we can only distinguish them according to their
 * target type. This target type is not available in operation calls, as the
 * operation is not yet determined. Thus, instances of this node (singleton, constant)
 * can be used while parsing but shall be replaced by operation resolution as soon as 
 * it becomes clear which type actually shall be used.
 * 
 * @author Holger Eichelberger
 */
public class EmptyInitializer extends Leaf {

    public static final EmptyInitializer INSTANCE = new EmptyInitializer();
    
    /**
     * Prevents external initialization.
     */
    private EmptyInitializer() {
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        // do not visit, do not print
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return AnyType.TYPE; // assignable to everything
    }

}
