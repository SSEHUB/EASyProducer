package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Represents the a compound itself (for constraints within compounds). Self
 * must be replaced accordingly, e.g., by all-quantification.
 * 
 * @author Holger Eichelberger
 */
public class Self extends Leaf {

    private Compound type;
    
    /**
     * Creates a self constant for <code>type</code>.
     * 
     * @param type the actual type of this self leaf
     */
    public Self(Compound type) {
        this.type = type;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitSelf(this);
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return type;
    }
    
    /**
     * Returns the type (without exception throwing).
     * 
     * @return the type of "self"
     */
    public IDatatype getType() {
        return type;
    }

}
