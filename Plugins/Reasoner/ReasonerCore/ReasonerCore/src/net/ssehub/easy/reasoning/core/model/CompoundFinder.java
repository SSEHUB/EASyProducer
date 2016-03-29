package net.ssehub.easy.reasoning.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.ssehub.easy.reasoning.core.model.datatypes.CompoundType;
import net.ssehub.easy.reasoning.core.model.datatypes.EnumType;
import net.ssehub.easy.reasoning.core.model.datatypes.IReasonerTypeVisitor;
import net.ssehub.easy.reasoning.core.model.datatypes.ReasonerDatatype;
import net.ssehub.easy.reasoning.core.model.datatypes.ReferenceType;

/**
 * Filters the list of {@link ReasonerDatatype} and searches for {@link CompoundType}s containing constraints.
 * @author El-Sharkawy
 *
 */
class CompoundFinder implements IReasonerTypeVisitor {
    
    private List<CompoundType> constrainedCompounds;

    /**
     * Sole constructor for this class.
     * @param customTypes The collection of all stored {@link ReasonerDatatype}s
     *     stored inside of the {@link ReasonerModel}.
     */
    CompoundFinder(Collection<ReasonerDatatype> customTypes) {
        constrainedCompounds = new ArrayList<CompoundType>();
        for (ReasonerDatatype customType : customTypes) {
            customType.accept(this);
        }
    }
    
    /**
     * Returns a subset of the given {@link ReasonerDatatype}s. This list contains only {@link CompoundType}s,
     * containing constraints.
     * @return A list of constrained {@link CompoundType}s, maybe empty.
     */
    List<CompoundType> getConstrainedCompounds() {
        return constrainedCompounds;
    }
    
    @Override
    public void visitCompoundType(CompoundType cmpType) {
        if (cmpType.hasConstraints()) {
            constrainedCompounds.add(cmpType);
        }
    }

    @Override
    public void visitEnumType(EnumType enumType) {
        // No functionality needed
    }

    @Override
    public void visitRefernceType(ReferenceType refType) {
        // No functionality needed
    }
}
