package net.ssehub.easy.reasonerCore.model.datatypes;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * A visitor to retrieve constraints.
 *
 */
class CompoundConstraintFinder implements IModelVisitor {

    private List<ConstraintSyntaxTree> constraints;
    private List<Constraint> constraintList;
    
    
    /**
     * Constructor of the visitor.
     * @param cmp Compound that is visited to retrieve constraints.
     */
    CompoundConstraintFinder(Compound cmp) {
        constraints = new ArrayList<ConstraintSyntaxTree>();
        constraintList = new ArrayList<Constraint>();
        cmp.accept(this);        
    }
    
    /**
     * Method to get all constraints from the compound.
     * @return List of {@link ConstraintSyntaxTree} values.
     */
    List<ConstraintSyntaxTree> getConstraints() {
        return constraints;
    }
    
    /**
     * Method to get all constraints from the compound.
     * @return List of {@link Constraint} values.
     */
    List<Constraint> getConstraintList() {
        return constraintList;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed here
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // Not needed here
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // Not needed here
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Not needed here 
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed here 
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // Not needed here 
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed here 
    }

    @Override
    public void visitComment(Comment comment) {
        // Not needed here 
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int i = 0; i < assignment.getConstraintsCount(); i++) {
            constraints.add(assignment.getConstraint(i).getConsSyntax());
            constraintList.add(assignment.getConstraint(i));
        }
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Not needed here 
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed here 
    }

    @Override
    public void visitCompound(Compound compound) {
        Compound refinedCmp = compound.getRefines();
        
        if (null != refinedCmp) {
            refinedCmp.accept(this);
        }
        
        
        for (int i = 0; i < compound.getConstraintsCount(); i++) {
            constraints.add(compound.getConstraint(i).getConsSyntax());
            constraintList.add(compound.getConstraint(i));
        }
        
        for (int i = 0; i < compound.getAssignmentCount(); i++) {
            compound.getAssignment(i).accept(this);
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed here 
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed here 
    }

    @Override
    public void visitReference(Reference reference) {
        // Not needed here
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Not needed here
    }

    @Override
    public void visitSet(Set set) {
        // Not needed here
    }

    @Override
    public void visitProject(Project project) {
        // Not needed here
        
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        // Not needed here
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // Not needed here
    }
    
}
