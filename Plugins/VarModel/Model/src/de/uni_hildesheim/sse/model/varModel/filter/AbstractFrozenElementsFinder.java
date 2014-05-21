package de.uni_hildesheim.sse.model.varModel.filter;

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * Abstract superclass for {@link FreezeBlockFinder} and {@link FrozenElementsFinder} for discovering frozen elements.
 * @author El-Sharkawy
 *
 */
abstract class AbstractFrozenElementsFinder extends AbstractProjectVisitor {
    /**
     * Sole constructor for this class.
     * @param originProject The project on where the filtering was started.
     * @param filterType Specifies whether imports shall be considered or not.
     */
    protected AbstractFrozenElementsFinder(Project originProject, FilterType filterType) {
       super(originProject, filterType);
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        // No action needed
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        // No action needed
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // No action needed
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // No action needed
    }

}
