/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.cst;

import java.util.Map;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Holger Eichelberger
 */
public class CopyVisitor implements IConstraintTreeVisitor {

    private Map<AbstractVariable, AbstractVariable> mapping;
    private ConstraintSyntaxTree result;

    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this(null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapping a mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public CopyVisitor(Map<AbstractVariable, AbstractVariable> mapping) {
        this.mapping = mapping;
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

    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        result = new ConstantValue(value.getConstantValue());
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        result = new Variable(mapVariable(variable.getVariable()));
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        result = new Parenthesis(result);
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
        result = new Comment(result, comment.getComment());
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        call.getOperand().accept(this);
        ConstraintSyntaxTree operand = result;
        ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int p = 0; p < args.length; p++) {
            call.getParameter(p).accept(this);
            args[p] = result;
        }
        result = new OCLFeatureCall(operand, call.getOperation(), args);
    }

    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    private DecisionVariableDeclaration mapVariable(DecisionVariableDeclaration var) {
        DecisionVariableDeclaration result = null;
        if (null != mapping) {
            AbstractVariable tmp = mapping.get(var); 
            if (null == tmp || !(tmp instanceof DecisionVariableDeclaration)) {
                result = var;
            }
        }
        return result;
    }

    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    private AbstractVariable mapVariable(AbstractVariable var) {
        AbstractVariable result = null;
        if (null != mapping) {
            result = mapping.get(var);
            if (null == result) {
                result = var;
            }
        }
        return result;
    }

    
    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        DecisionVariableDeclaration var = mapVariable(let.getVariable());
        let.getInExpression().accept(this);
        result = new Let(var, result);
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ConstraintSyntaxTree ifExpr = result;
        ifThen.getThenExpr();
        ConstraintSyntaxTree thenExpr = result;
        ConstraintSyntaxTree elseExpr;
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr();
            elseExpr = result;
        } else {
            elseExpr = null;
        }
        result = new IfThen(ifExpr, thenExpr, elseExpr);
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        ConstraintSyntaxTree container = result;
        call.getExpression().accept(this);
        ConstraintSyntaxTree expression = result;
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < decls.length; d++) {
            decls[d] = mapVariable(call.getDeclarator(d));
        }
        result = new ContainerOperationCall(container, call.getOperation(), expression, decls);
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        result = new CompoundAccess(result, access.getSlotName());
    }

    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        result = new DslFragment(fragment.getCommand(), fragment.getEscape(), fragment.getStop(), fragment.getDsl());
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        if (null != expression.getUnresolvedLeaf()) {
            result = new UnresolvedExpression(expression.getUnresolvedLeaf());
        } else {
            expression.accept(this);
            result = new UnresolvedExpression(result);
        }
    }

    /**
     * {@inheritDoc}
     */
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
            result = new CompoundInitializer(initializer.getType(), slots, slotDecls, exprs);
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, Bundle.ID).exception(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            initializer.getExpression(e).accept(this);
            exprs[e] = result;
        }
        try {
            result = new ContainerInitializer(initializer.getType(), exprs);
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, Bundle.ID).exception(e);
        }
    }

}
