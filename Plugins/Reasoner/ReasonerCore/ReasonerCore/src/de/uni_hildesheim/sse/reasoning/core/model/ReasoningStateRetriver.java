package de.uni_hildesheim.sse.reasoning.core.model;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
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
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;

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
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
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