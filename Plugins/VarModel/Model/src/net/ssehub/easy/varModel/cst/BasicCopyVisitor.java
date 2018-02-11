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

    /**
     * Creates a copy visitor leaving variable nodes as they are, copying constants, not inferring
     * types on intermediary expressions.
     */
    protected BasicCopyVisitor() {
    }

    /**
     * Defines variable replacement.
     * 
     * @param copyVariables copy variable node instances if <code>true</code>, reuse them if <code>false</code>
     */
    protected void setCopyVariables(boolean copyVariables) {
        this.copyVariables = copyVariables;
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
        parenthesis.getExpr().accept(this);
        result = inferDatatype(new Parenthesis(result));
    }

    @Override
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
        result = new Comment(result, comment.getComment());
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        ConstraintSyntaxTree operand = call.getOperand();
        if (null != operand) {
            operand.accept(this);
            operand = result;
        }
        ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int p = 0; p < args.length; p++) {
            call.getParameter(p).accept(this);
            args[p] = result;
        }
        result = inferDatatype(new OCLFeatureCall(operand, call.getOperation(), call.getAccessor(), args));
    }
    

    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        OCLFeatureCall[] expressions = new OCLFeatureCall[expression.getExpressionCount()];
        for (int e = 0; e < expressions.length; e++) {
            expression.getExpression(e).accept(this);
            expressions[e] = (OCLFeatureCall) result;
        }
        try {
            result = inferDatatype(new MultiAndExpression(expressions));
        } catch (CSTSemanticException e) {
            getLogger().exception(e);
        }
    }

    @Override
    public void visitLet(Let let) {
        DecisionVariableDeclaration var = mapVariable(let.getVariable());
        let.getInExpression().accept(this);
        result = inferDatatype(new Let(var, result));
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ConstraintSyntaxTree ifExpr = result;
        ifThen.getThenExpr().accept(this);
        ConstraintSyntaxTree thenExpr = result;
        ConstraintSyntaxTree elseExpr;
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr().accept(this);
            elseExpr = result;
        } else {
            elseExpr = null;
        }
        result = inferDatatype(new IfThen(ifExpr, thenExpr, elseExpr));
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        ConstraintSyntaxTree container = result;
        call.getExpression().accept(this);
        ConstraintSyntaxTree expression = result;
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < decls.length; d++) {
            decls[d] = mapVariable(call.getDeclarator(d));
        }
        result = inferDatatype(new ContainerOperationCall(container, call.getOperation(), expression, decls));
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        result = inferDatatype(new CompoundAccess(result, access.getSlotName()));
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        if (null != expression.getUnresolvedLeaf()) {
            result = new UnresolvedExpression(expression.getUnresolvedLeaf());
        } else {
            expression.accept(this);
            result = new UnresolvedExpression(result);
        }
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        String[] slots = new String[initializer.getSlotCount()];
        for (int s = 0; s < slots.length; s++) {
            slots[s] = initializer.getSlot(s);
        }
        AbstractVariable[] slotDecls = new DecisionVariableDeclaration[initializer.getSlotCount()];
        for (int s = 0; s < slotDecls.length; s++) {
            slotDecls[s] = mapVariable(initializer.getSlotDeclaration(s));
        }
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            initializer.getExpression(e).accept(this);
            exprs[e] = result;
        }
        try {
            result = inferDatatype(new CompoundInitializer(initializer.getType(), slots, slotDecls, exprs));
        } catch (CSTSemanticException e) {
            getLogger().exception(e);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            initializer.getExpression(e).accept(this);
            exprs[e] = result;
        }
        try {
            result = inferDatatype(new ContainerInitializer(initializer.getType(), exprs));
        } catch (CSTSemanticException e) {
            getLogger().exception(e);
        }
    }

    @Override
    public void visitSelf(Self self) {
        result = self; // no replacement needed
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
        ConstraintSyntaxTree qualifier = result;
        result = new AttributeVariable(qualifier, (Attribute) mapVariable(variable.getVariable()));
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[block.getExpressionCount()];
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
            exprs[e] = result;
        }
        try {
            result = new BlockExpression(exprs);
        } catch (CSTSemanticException e) {
            getLogger().exception(e);
        }
    }
    
    /**
     * Performs datatype validation if requested.
     * 
     * @param cst the constraint expression to perform the validation on
     * @throws CSTSemanticException if validation fails
     * @return cst
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
