package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
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
 * This class locates all {@link PartialEvaluationBlock} in a project.
 * @author El-Sharkawy
 *
 */
public class EvalBlockFinder extends AbstractProjectVisitor {
    private List<PartialEvaluationBlock> evalBlocks;
    
    /**
     * Sole constructor for this class.
     * Searches inside the specified project for {@link PartialEvaluationBlock}s.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public EvalBlockFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        evalBlocks = new ArrayList<PartialEvaluationBlock>();
        project.accept(this);
    }
    
    /**
     * Returns all discovered {@link PartialEvaluationBlock}s.
     * @return All {@link PartialEvaluationBlock}s.
     */
    public List<PartialEvaluationBlock> getEvalBlocks() {
        return evalBlocks;
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed here
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        evalBlocks.add(block);
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed here
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // Not needed here
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
    }

}
