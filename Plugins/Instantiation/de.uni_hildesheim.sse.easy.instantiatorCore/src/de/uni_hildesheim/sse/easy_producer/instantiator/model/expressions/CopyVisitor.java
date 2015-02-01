package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction.IVariableMapper;

/**
 * Implements a visitor for copying expressions. Results of the methods will always be expressions.
 * Please note that build and template model may define a more specific copy visitor as the may define
 * specialized expressions.
 * 
 * @author Holger Eichelberger
 */
public class CopyVisitor implements IExpressionVisitor {

    private Map<VariableDeclaration, VariableDeclaration> mapping;
    private boolean reuse;
    private IVariableMapper mapper;
    
    /**
     * Creates a new copy visitor.
     * 
     * @param mapping the variable mapping to be considered while copying (may be <b>null</b> for no mapping)
     * @param reuse whether leaves shall be reused rather than created again
     */
    public CopyVisitor(Map<VariableDeclaration, VariableDeclaration> mapping, boolean reuse) {
        this(mapping, reuse, null);
    }

    /**
     * Creates a new copy visitor.
     * 
     * @param mapping the variable mapping to be considered while copying (may be <b>null</b> for no mapping)
     * @param reuse whether leaves shall be reused rather than created again
     * @param mapper an optional variable mapper (may be <b>null</b> if absent)
     */
    public CopyVisitor(Map<VariableDeclaration, VariableDeclaration> mapping, boolean reuse, IVariableMapper mapper) {
        this.mapping = mapping;
        this.reuse = reuse;
        this.mapper = mapper;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
        Expression result = new ParenthesisExpression((Expression) par.accept(this));
        result.inferType();
        return result;
    }
    
    /**
     * Copies the arguments of the given <code>call</code>.
     * 
     * @param call the call the arguments shall be copied from
     * @return the copied arguments
     * @throws ExpressionException in case that processing expressions fails
     */
    protected CallArgument[] copyCallArguments(AbstractCallExpression call) throws ExpressionException  {
        CallArgument[] arguments = new CallArgument[call.getArgumentsCount()];
        for (int a = 0; a < arguments.length; a++) {
            CallArgument arg = call.getArgument(a);
            arguments[a] = new CallArgument(arg.getName(), (Expression) arg.getExpression().accept(this));
        }
        return arguments;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(call);
        switch (call.getCallType()) {
        case NORMAL:
            result = new CallExpression(call.getParent(), call.getName(), call.isDotRightExpression(), arguments);
            break;
        case EXTERNAL:
            result = new CallExpression((IMetaOperation) call.getResolved(), arguments);
            break;
        case TRANSPARENT:
            result = new CallExpression(call.getResolved(), arguments[0]);
            break;
        default:
            result = call; // shall not happen
            break;
        }
        result.inferType();
        return result;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        return cst; // reuse always for now... the type registry may be a problem :o
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        Expression result;
        if (reuse) {
            result = identifier;
        } else {
            result = new VarModelIdentifierExpression(identifier.getIdentifier());
            result.inferType();
        }
        return result;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        Expression result;
        if (reuse) {
            result = typeExpression;
        } else {
            result = new VilTypeExpression(typeExpression.getIdentifier(), typeExpression.getResolved());
            result.inferType();
        }
        return result;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        Expression result;
        VariableDeclaration var = map(cst.getDeclaration(), true);
        if (null == var) {
            result = cst;
        } else {
            result = new VariableExpression(var);
            result.inferType();
        }
        return result;
    }

    /**
     * Maps the variable declaration considering the initially specified mapping.
     * 
     * @param decl the declaration to be mapped
     * @param allowNull whether the result may be null or <code>decl</code> instead
     * @return the mapped declaration (may be <b>null</b> if the originating expression shall be reused)
     */
    protected VariableDeclaration map(VariableDeclaration decl, boolean allowNull) {
        VariableDeclaration result = null;
        if (null != mapping) {
            result = mapping.get(decl);
        }
        if (null == result && null != mapper) {
            IVariable var = mapper.map(decl);
            if (var instanceof VariableDeclaration) {
                result = (VariableDeclaration) var;
            }
        }
        if (!reuse && null == result) {
            result = decl;
        }
        if (!allowNull && null == result) {
            result = decl;
        }
        return result;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        VariableDeclaration iter = map(ex.getIteratorVariable(), false);
        Expression expr = (Expression) ex.getExpression().accept(this);
        Expression result = new ExpressionEvaluator(expr, iter);
        result.inferType();
        return result;
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        return new ParenthesisExpression((Expression) ex.accept(this));
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        VariableDeclaration decl = map(ex.getVarDecl(), false);
        Expression valEx = (Expression) ex.getValueExpression().accept(this);
        Expression result = new ValueAssignmentExpression(decl, valEx);
        result.inferType();
        return result;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        Expression[] init = new Expression[ex.getInitExpressionsCount()];
        for (int i = 0; i < init.length; i++) {
            init[i] = (Expression) ex.getInitExpression(i).accept(this);
        }
        Expression result = new ContainerInitializerExpression(init);
        result.inferType();
        return result;
    }
    
}
