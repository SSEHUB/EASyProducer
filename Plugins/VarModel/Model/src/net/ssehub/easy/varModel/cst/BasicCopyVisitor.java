/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Implements a basic constraint copy visitor. Allows leaving variable nodes as they are as
 * well as mapping variables (although no mapping happens in this class).
 * 
 * @author Holger Eichelberger
 */
public class BasicCopyVisitor implements IConstraintTreeVisitor {

    private ConstraintSyntaxTree result;
    private boolean copyVariables = false;
    private boolean doInferDatatype = false;
    private boolean copyConstants = true;
    private boolean copyExpressions = true; // legacy

    /**
     * Creates a copy visitor leaving variable nodes as they are, copying constants, not inferring
     * types on intermediary expressions.
     */
    protected BasicCopyVisitor() {
    }

    /**
     * Defines whether variables shall always be copied or whether instances shall be reused if possible.
     * 
     * @param copyVariables copy variable node instances if <code>true</code>, reuse them if <code>false</code>
     */
    protected void setCopyVariables(boolean copyVariables) {
        this.copyVariables = copyVariables;
    }

    /**
     * Returns variables shall always be copied or whether instances shall be reused if possible.
     * 
     * @return copy variable node instances if <code>true</code>, reuse them if <code>false</code>
     */
    protected boolean getCopyVariables() {
        return copyVariables;
    }
    
    /**
     * Defines whether {@link ConstraintSytaxTree#inferDatatype} shall be called on each partial expression.
     * 
     * @param doInferDatatype call/validate the datatypes, <code>false</code> else (then caller is required
     *  to infer the datatype before usage of the resulting constraint)
     */
    protected void setDoInferDatatype(boolean doInferDatatype) {
        this.doInferDatatype = doInferDatatype;
    }

    /**
     * Defines whether {@link ConstraintSytaxTree#inferDatatype} shall be called on each partial expression.
     * 
     * @param copyConstants copy all constant nodes (<code>true</code>), reuse constant nodes (<code>false)</code>)
     */
    protected void setCopyConstants(boolean copyConstants) {
        this.copyConstants = copyConstants;
    }
    
    /**
     * Defines whether (partial) expressions shall always be copied or only if needed.
     * 
     * @param copyExpressions <code>true</code> for copy always, <code>false</code> else
     */
    protected void setCopyExpressions(boolean copyExpressions) {
        this.copyExpressions = copyExpressions;
    }
    
    /**
     * Returns whether (partial) expressions shall always be copied or only if needed.
     * 
     * @return <code>true</code> for copy always, <code>false</code> else
     */
    protected boolean getCopyExpressions() {
        return copyExpressions;
    }

    /**
     * Allows inherited classed to overwrite visiting method and to return a partially translated cst.
     * @param cst A partially copied cst.
     */
    protected void setResult(ConstraintSyntaxTree cst) {
        result = cst;
    }
    
    /**
     * Returns the copied syntax tree.
     * 
     * @return the copied tree (may be <b>null</b> if no tree was visited).
     */
    public ConstraintSyntaxTree getResult() {
        return result;
    }
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        result = null;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        result = copyConstants ? new ConstantValue(value.getConstantValue()) : value;
    }

    @Override
    public void visitVariable(Variable variable) {
        result = copyVariables ? new Variable(variable.getVariable()) : variable;
    }
    
    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    protected DecisionVariableDeclaration mapVariable(DecisionVariableDeclaration var) {
        return var;
    }

    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    protected AbstractVariable mapVariable(AbstractVariable var) {
        return var;
    }
    
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        ConstraintSyntaxTree parEx = parenthesis.getExpr();
        parEx.accept(this);
        
        if (copyExpressions || parEx != result) {
            result = inferDatatype(new Parenthesis(result));
        } else {
            result = parenthesis;
        }
    }

    @Override
    public void visitComment(Comment comment) {
        ConstraintSyntaxTree cEx = comment.getExpr();
        cEx.accept(this);
        
        if (copyExpressions || cEx != result) {
            result = new Comment(result, comment.getComment());
        } else {
            result = comment;
        }
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        boolean doCopy = copyExpressions;
        ConstraintSyntaxTree operand = call.getOperand();
        if (null != operand) {
            operand.accept(this);
            doCopy |= operand != result;
            operand = result;
        }

        ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int p = 0; p < args.length; p++) {
            ConstraintSyntaxTree arg = call.getParameter(p);
            arg.accept(this);
            doCopy |= arg != result;
            args[p] = result;
        }

        if (doCopy) {
            result = inferDatatype(new OCLFeatureCall(operand, call.getOperation(), call.getAccessor(), args));
        } else {
            result = call;
        }
    }
    

    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        boolean doCopy = copyExpressions;
        OCLFeatureCall[] expressions = new OCLFeatureCall[expression.getExpressionCount()];
        for (int e = 0; e < expressions.length; e++) {
            ConstraintSyntaxTree ex = expression.getExpression(e);
            ex.accept(this);
            doCopy |= ex != result;
            expressions[e] = (OCLFeatureCall) result;
        }
        if (doCopy) {
            try {
                result = inferDatatype(new MultiAndExpression(expressions));
            } catch (CSTSemanticException e) {
                getLogger().exception(e);
            }
        } else {
            result = expression;
        }
    }
    
    /**
     * Visits a default init expression.
     * 
     * @param expression the expression
     */
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this);
        result = inferDatatype(new DeferInitExpression(result));
    }

    @Override
    public void visitLet(Let let) {
        DecisionVariableDeclaration letVar = let.getVariable();
        DecisionVariableDeclaration var = mapVariable(letVar);
        ConstraintSyntaxTree ex = let.getInExpression();
        ex.accept(this);
        if (copyExpressions || letVar != var || ex != result) {
            result = inferDatatype(new Let(var, result));
        } else {
            result = let;
        }
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ConstraintSyntaxTree ifE = ifThen.getIfExpr();
        ifE.accept(this);
        ConstraintSyntaxTree ifExpr = result;
       
        ConstraintSyntaxTree thenE = ifThen.getThenExpr();
        thenE.accept(this);
        ConstraintSyntaxTree thenExpr = result;
        
        ConstraintSyntaxTree elseE = ifThen.getElseExpr();
        ConstraintSyntaxTree elseExpr;
        if (null != elseE) {
            elseE.accept(this);
            elseExpr = result;
        } else {
            elseExpr = null;
        }
        
        if (copyExpressions || ifE != ifExpr || thenE != thenExpr || elseE != elseExpr) {
            result = inferDatatype(new IfThen(ifExpr, thenExpr, elseExpr));
        } else {
            result = ifThen;
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        ConstraintSyntaxTree cCont = call.getContainer();
        cCont.accept(this);
        ConstraintSyntaxTree container = result;

        ConstraintSyntaxTree cEx = call.getExpression();
        cEx.accept(this);
        ConstraintSyntaxTree expression = result;
        
        boolean doCopy = copyExpressions || cCont != container || cEx != expression;
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < decls.length; d++) {
            DecisionVariableDeclaration decl = call.getDeclarator(d);
            decls[d] = mapVariable(decl);
            doCopy |= decls[d] != decl;
        }
        if (doCopy) {
            result = inferDatatype(new ContainerOperationCall(container, call.getOperation(), expression, decls));
        } else {
            result = call;
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        ConstraintSyntaxTree cEx = access.getCompoundExpression();
        cEx.accept(this);
        if (copyExpressions || cEx != result) {
            result = inferDatatype(new CompoundAccess(result, access.getSlotName()));
        } else {
            result = access;
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        String leaf = expression.getUnresolvedLeaf();
        if (null != leaf) {
            if (copyExpressions) {
                result = new UnresolvedExpression(expression.getUnresolvedLeaf());
            } else {
                result = expression;
            }
        } else {
            ConstraintSyntaxTree ex = expression.getActualExpression();
            if (null != ex) {
                ex.accept(this);
            } else {
                result = null;
            }
            if (copyExpressions || result != ex) {
                result = new UnresolvedExpression(result);
            } else {
                result = expression;
            }
        }
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        boolean doCopy = copyExpressions;
        AbstractVariable[] slotDecls = new DecisionVariableDeclaration[initializer.getSlotCount()];
        for (int s = 0; s < slotDecls.length; s++) {
            AbstractVariable decl = initializer.getSlotDeclaration(s);
            slotDecls[s] = mapVariable(decl);
            doCopy |= slotDecls[s] != decl;
        }
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            ConstraintSyntaxTree ex = initializer.getExpression(e);
            ex.accept(this);
            doCopy |= result != ex;
            exprs[e] = result;
        }
        if (doCopy) {
            try {
                String[] slots = new String[initializer.getSlotCount()];
                for (int s = 0; s < slots.length; s++) {
                    slots[s] = initializer.getSlot(s);
                }
                result = inferDatatype(new CompoundInitializer(initializer.getType(), slots, slotDecls, exprs));
            } catch (CSTSemanticException e) {
                getLogger().exception(e);
            }
        } else {
            result = initializer;
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        boolean doCopy = copyExpressions;
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            ConstraintSyntaxTree ex = initializer.getExpression(e);
            ex.accept(this);
            doCopy |= ex != result;
            exprs[e] = result;
        }
        if (doCopy) {
            try {
                result = inferDatatype(new ContainerInitializer(initializer.getType(), exprs));
            } catch (CSTSemanticException e) {
                getLogger().exception(e);
            }
        } else {
            result = initializer;
        }
    }

    @Override
    public void visitSelf(Self self) {
        result = self; // no replacement needed
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        ConstraintSyntaxTree qu = variable.getQualifier();
        ConstraintSyntaxTree qualifier;
        if (null != qu) {
            qu.accept(this);
            qualifier = result;
        } else {
            qualifier = null;
        }
        AbstractVariable var = variable.getVariable();
        Attribute mVar = (Attribute) mapVariable(var);
        if (copyExpressions || qu != qualifier || var != mVar) {
            result = new AttributeVariable(qualifier, mVar);
        } else {
            result = variable;
        }
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        boolean doCopy = copyExpressions;
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[block.getExpressionCount()];
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            ConstraintSyntaxTree ex = block.getExpression(e);
            ex.accept(this);
            doCopy |= ex != result;
            exprs[e] = result;
        }
        if (doCopy) {
            try {
                result = new BlockExpression(exprs);
            } catch (CSTSemanticException e) {
                getLogger().exception(e);
            }
        } else {
            result = block;
        }
    }
    
    /**
     * Performs datatype validation if requested.
     * 
     * @param cst the constraint expression to perform the validation on
     * @throws CSTSemanticException if validation fails
     * @return <code>cst</code>
     */
    protected ConstraintSyntaxTree inferDatatype(ConstraintSyntaxTree cst) {
        if (doInferDatatype) {
            try {
                cst.inferDatatype();
            } catch (CSTSemanticException e) {
                getLogger().exception(e);
            }
        }
        return cst;
    }

    /**
     * Returns the logger.
     * 
     * @return the logger
     */
    protected EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
    }

}
