package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
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
 * Tests whether a {@link ContainableModelElement} is a {@link DecisionVariableDeclaration} or an
 * {@link AttributeAssignment}. In case of a {@link DecisionVariableDeclaration} the {@link DecisionVariableDeclaration}
 * will be returned. In case of an {@link AttributeAssignment} all nested {@link DecisionVariableDeclaration}s will be
 * returned.
 * @author El-Sharkawy
 *
 */
public class DeclarationInContainerFinder implements IModelVisitor {
    
    private List<DecisionVariableDeclaration> declarations;

    /**
     * Sole constructor for this class.
     * @param element the element to be checked.
     */
    public DeclarationInContainerFinder(ContainableModelElement element) {
        declarations = new ArrayList<DecisionVariableDeclaration>();
        element.accept(this);
    }
    
    /**
     * Returns
     * <ul>
     * <li>The parameter of the constructor call if the element was a {@link DecisionVariableDeclaration}</li>
     * <li>Returns a list of {@link DecisionVariableDeclaration} if the parameter of the constrcutor call
     * was an {@link AttributeAssignment} (This list maybe empty)</li>
     * <li>Otherwise an empty list will be returned</li>
     * </ul>.
     * @return A List of {@link DecisionVariableDeclaration} (must not be <tt>null</tt>).
     */
    public List<DecisionVariableDeclaration> getDeclarations() {
        return declarations;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitProject(Project project) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectImport(ProjectImport pImport) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        declarations.add(decl);
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        //No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int i = 0; i < assignment.getModelElementCount(); i++) {
            assignment.getModelElement(i).accept(this);
        }
    }

}
