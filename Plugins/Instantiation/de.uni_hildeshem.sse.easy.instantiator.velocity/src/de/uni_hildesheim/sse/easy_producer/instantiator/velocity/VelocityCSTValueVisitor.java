package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;

class VelocityCSTValueVisitor implements IConstraintTreeVisitor{

    private Object returnValue;
    
    public VelocityCSTValueVisitor(ConstraintSyntaxTree cstValue) {
        returnValue = null;
        cstValue.accept(this);
    }
    
    public Object getReturnValue() {
        return returnValue;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        returnValue = value.getConstantValue().getValue();
    }

    @Override
    public void visitVariable(Variable variable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitComment(Comment parenthesis) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitLet(Let let) {
        // Not needed       
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // Not needed       
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // Not needed
        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitDslFragment(DslFragment fragment) {
        // Not needed      
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // Not needed       
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub
    }
    
}
