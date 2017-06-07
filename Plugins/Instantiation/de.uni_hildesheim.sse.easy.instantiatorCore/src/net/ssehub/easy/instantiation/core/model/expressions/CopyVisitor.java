package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;

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
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        Expression result = new ParenthesisExpression((Expression) par.accept(this));
        result.inferType();
        return result;
    }
    
    /**
     * Copies the arguments of the given <code>call</code>.
     * 
     * @param call the call the arguments shall be copied from
     * @return the copied arguments
     * @throws VilException in case that processing expressions fails
     */
    protected CallArgument[] copyCallArguments(AbstractCallExpression call) throws VilException  {
        CallArgument[] arguments = new CallArgument[call.getArgumentsCount()];
        for (int a = 0; a < arguments.length; a++) {
            CallArgument arg = call.getArgument(a);
            arguments[a] = new CallArgument(arg.getName(), (Expression) arg.getExpression().accept(this));
        }
        return arguments;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
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
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return cst; // reuse always for now... the type registry may be a problem :o
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException {
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
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
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
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
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
    
    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        Expression result;
        if (null != ex.getVariable()) {
            VariableDeclaration var = map(ex.getVariable(), true);
            if (null == var) {
                result = ex;
            } else {
                result = new FieldAccessExpression(var, ex.getField());
                result.inferType();
            }
        } else {
            Object nested = ex.getNested().accept(this);
            if (nested instanceof FieldAccessExpression) {
                result = new FieldAccessExpression((FieldAccessExpression) nested, ex.getField());
                result.inferType();
            } else {
                result = null;
            }
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
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        VariableDeclaration origIter = ex.getIteratorVariable();
        VariableDeclaration iter = map(origIter, false);
        Expression expr = (Expression) ex.getExpression().accept(this);
        List<VariableDeclaration> decl = new ArrayList<VariableDeclaration>();
        for (int d = 0; d < ex.getDeclaratorsCount(); d++) {
            VariableDeclaration declarator = ex.getDeclarator(d);
            if (declarator == origIter) {
                declarator = iter;
            } else {
                declarator = map(declarator, false);
            }
            decl.add(declarator);
        }
        Expression result = new ExpressionEvaluator(expr, iter, decl);
        result.inferType();
        return result;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return new ParenthesisExpression((Expression) ex.accept(this));
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        VariableDeclaration decl = map(ex.getVarDecl(), false);
        Expression valEx = (Expression) ex.getValueExpression().accept(this);
        Expression result = new ValueAssignmentExpression(decl, ex.getField(), valEx);
        result.inferType();
        return result;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        Expression[] init = new Expression[ex.getInitExpressionsCount()];
        for (int i = 0; i < init.length; i++) {
            init[i] = (Expression) ex.getInitExpression(i).accept(this);
        }
        Expression result = new ContainerInitializerExpression(init);
        result.inferType();
        return result;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        List<Expression> result = new ArrayList<Expression>();
        for (Expression expression : ex.getExpressionList()) {
            result.add((Expression) expression.accept(this));
        }
        return new CompositeExpression(result);
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return new ResolvableOperationExpression(ex.getType(), ex.getOperation());
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        return new ResolvableOperationCallExpression(ex.getVariable(), copyCallArguments(ex));
    }

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        AbstractCallExpression[] exprs = new AbstractCallExpression[ex.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            exprs[e] = (AbstractCallExpression) ex.getExpression(e).accept(this);
        }
        Expression result = new MultiAndExpression(exprs);
        result.inferType();
        return result;
    }
    
}
