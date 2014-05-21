package de.uni_hildesheim.sse.model.cst;

/**
 * Defines the interface for a visitor for the constraint tree.
 * 
 * @author Holger Eichelberger
 */
public interface IConstraintTreeVisitor {

    /**
     * Visits a constant value.
     * 
     * @param value the value which should be visited
     */
    public void visitConstantValue(ConstantValue value);

    /**
     * Visits a variable.
     * 
     * @param variable the variable which should be visited
     */
    public void visitVariable(Variable variable);

    /**
     * Visits a parenthesis.
     * 
     * @param parenthesis the parenthesis which should be visited
     */
    public void visitParenthesis(Parenthesis parenthesis);

    /**
     * Visits a comment.
     * 
     * @param comment the comment node which should be visited
     */
    public void visitComment(Comment comment);
    
    /**
     * Visits an OCL feature call.
     * 
     * @param call the feature call which should be visited
     */
    public void visitOclFeatureCall(OCLFeatureCall call);
    
    /**
     * Visits a let expression.
     * 
     * @param let the let expression which should be visited
     */
    public void visitLet(Let let);

    /**
     * Visits an if-then-else expression.
     * 
     * @param ifThen the if-then-else expression which should be visited
     */
    public void visitIfThen(IfThen ifThen);

    /**
     * Visits a container operation call (e.g. quantors, iterators).
     * 
     * @param call the container operation call
     */
    public void visitContainerOperationCall(ContainerOperationCall call);

    /**
     * Visits a compound access node.
     * 
     * @param access the compound access node
     */
    public void visitCompoundAccess(CompoundAccess access);

    /**
     * Visits a DSL fragment.
     * 
     * @param fragment the fragment
     */
    public void visitDslFragment(DslFragment fragment);
    
    /**
     * Visits an unresolved expression. Please note that an unresolved
     * expression may represent a leaf as well as an inner tree node.
     * Typically, visitors shall continue visiting transparently at 
     * {@link UnresolvedExpression#getActualExpression()}.
     * 
     * @param expression the expression
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression);
    
    /**
     * Visits a compound initializer.
     * 
     * @param initializer the compound initializer node
     */
    public void visitCompoundInitializer(CompoundInitializer initializer);

    /**
     * Visits a container initializer.
     * 
     * @param initializer the container initializer node
     */
    public void visitContainerInitializer(ContainerInitializer initializer);
    
}
