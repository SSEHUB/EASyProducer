package net.ssehub.easy.reasoning.core.model;

import net.ssehub.easy.reasoning.core.model.variables.ReasonerVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.FilterType;

/**
 * A visitor to retrieve which variables have ReasoningState.DEFAULT_SAME.
 *
 */
class ReasoningStateRetriver extends AbstractProjectVisitor implements IConstraintTreeVisitor {

    /**
     * The variable which must be checked.
     */
    private ReasonerVariable variable;
    
    /**
     * Constructor of the visitor.
     * @param originProject current project
     * @param variable passed {@link ReasonerVariable}
     *
     */
    ReasoningStateRetriver(Project originProject, ReasonerVariable variable) {
        super(originProject, FilterType.NO_IMPORTS);
        this.variable = variable;
        
        // Check only variables, haven the Reasoning state set to DEFAULT_DIFERENT
        // as it was set inside the constructor. 2nd check (could be optimized).
        if (variable.getReasoningState() == ReasoningState.DEFAULT_DIFFERENT) {
            originProject.accept(this);
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        /*
         * If the variable was created in this project AND has a value,
         * then the state must be DEFAULT_SAME.
         * We don't need to search the related assignment.
         */
        AbstractVariable originDeclaration = variable.getDecisionVariable().getDeclaration();
        if (decl.equals(originDeclaration)) {
            variable.setReasoningState(ReasoningState.DEFAULT_SAME);
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO SE: Check whether this is needed, I think it's not needed
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        constraint.getConsSyntax().accept(this);
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
        // TODO Auto-generated method stub
        
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
        // TODO SE: Check which behavior a compound definition should have.        
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
    public void visitConstantValue(ConstantValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitVariable(Variable variable) {
        variable.getVariable().accept(this);
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
            call.getOperand().accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        // Not needed here
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }

}