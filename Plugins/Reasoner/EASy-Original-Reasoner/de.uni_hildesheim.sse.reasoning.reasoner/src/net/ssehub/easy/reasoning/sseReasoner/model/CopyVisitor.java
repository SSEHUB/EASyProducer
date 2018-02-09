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
package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Sizonenko
 * @author Holger Eichelberger (original class)
 */
public class CopyVisitor implements IConstraintTreeVisitor {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, Descriptor.BUNDLE_NAME);
    private Map<Variable, Variable> mapping;
    private Map<AbstractVariable, CompoundAccess> mappingCA;
    private ConstraintSyntaxTree result;
    private ConstraintSyntaxTree selfEx;
    private AbstractVariable self;
    private boolean containsSelf;

    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this(null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mappingCA a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @see #setMappings(Map, Map)
     */
    public CopyVisitor(Map<AbstractVariable, CompoundAccess> mappingCA) {
        setMappings(mappingCA);
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
     * Sets the mapping. [init, reuse]
     * 
     * @param mappingCA a mapping from variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public void setMappings(Map<AbstractVariable, CompoundAccess> mappingCA) {
        this.mappingCA = mappingCA;
    }

    /**
     * Returns whether the last execution visited a <i>self</i>.
     * 
     * @return <code>true</code> for <i>self</i>, <code>false</code> else
     */
    public boolean containsSelf() {
        return containsSelf;
    }
    
    /**
     * Clears this visitor for reuse.
     * 
     * @see #clearVariableMapping()
     */
    public void clear() {
        result = null;
        containsSelf = false;
        mappingCA = null;
        selfEx = null;
        self = null;
        clearVariableMapping();
    }
    
    /**
     * Adds a variable mapping to be considered during copying.
     * 
     * @param orig the original variable to be replaced (may be <b>null</b>, ignored)
     * @param dest the destination variable to replace <code>orig</code> (may be <b>null</b>, ignored)
     * @return <b>this</b>
     */
    public CopyVisitor addVariableMapping(Variable orig, Variable dest) {
        if (null != orig) {
            if (null == mapping) {
                mapping = new HashMap<Variable, Variable>();
            }
            mapping.put(orig, dest);
        }
        return this;
    }

    /**
     * Clears the mapping for a given variable.
     * 
     * @param var the variable to clear the mapping for (may be <b>null</b>, ignored)
     * @return <b>this</b>
     */
    public CopyVisitor clearVariableMapping(Variable var) {
        if (null != mapping && null != var) {
            mapping.remove(var);
        }
        return this;
    }

    /**
     * Clears the entire variable mapping.
     * @return <b>this</b>
     */
    public CopyVisitor clearVariableMapping() {
        if (null != mapping) {
            mapping.clear();
        }
        return this;
    }

    /**
     * Defines <i>self</i> in terms of an expression.
     * 
     * @param selfEx the expression (may be <b>null</b>, ignored then).
     * @return <b>this</b>
     */
    public CopyVisitor setSelf(ConstraintSyntaxTree selfEx) {
        this.selfEx = selfEx;
        return this;
    }

    /**
     * Defines <i>self</i> in terms of a variable declaration. Creates a variable on demand and re-uses it. Dont' call
     * also {@link #setSelf(ConstraintSyntaxTree)} on the same expression.
     * 
     * @param self the variable (declaration) representing self (may be <b>null</b>, ignored then).
     * @return <b>this</b>
     */
    public CopyVisitor setSelf(AbstractVariable self) {
        this.self = self;
        return this;
    }
    
    /**
     * Accepts <b>this</b> on <code>cst</code> and returns {@link #getResult()}.
     * 
     * @param cst the constraint to visit
     * @return the visiting result
     */
    public ConstraintSyntaxTree accept(ConstraintSyntaxTree cst) {
        cst.accept(this);
        return getResult();
    }

    /**
     * Accepts <b>this</b> on <code>cst</code>, returns {@link #getResult()} and {@link #clear() clears} 
     * <b>this</b>.
     * 
     * @param cst the constraint to visit
     * @return the visiting result
     */
    public ConstraintSyntaxTree acceptAndClear(ConstraintSyntaxTree cst) {
        cst.accept(this);
        ConstraintSyntaxTree result = getResult();
        clear();
        return result;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        result = new ConstantValue(value.getConstantValue());
    }

    @Override
    public void visitVariable(Variable variable) {
        CompoundAccess tmp = null == mappingCA ? null : mappingCA.get(variable.getVariable());
        if (null != tmp) {
            result = tmp;
            try {
                tmp.inferDatatype();
            } catch (CSTSemanticException e) {
                LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
            }
        } else {
            result = variable;
            if (null != mapping) {
                result = mapping.get(variable);
                if (null == result) {
                    result = variable;
                }
            }
        }
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
        result = new Parenthesis(result);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
    }

    @Override
    public void visitComment(Comment comment) {
//        comment.getExpr().accept(this);
//        result = new Comment(result, comment.getComment());
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (call.getOperand() != null) {
            call.getOperand().accept(this);
            ConstraintSyntaxTree operand = result;
            ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
            for (int p = 0; p < args.length; p++) {
                call.getParameter(p).accept(this);
                args[p] = result;
            }
            result = new OCLFeatureCall(operand, call.getOperation(), call.getAccessor(), args);
            try {
                result.inferDatatype();
            } catch (CSTSemanticException e) {
                e.printStackTrace();
            }            
        }
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        OCLFeatureCall[] expressions = new OCLFeatureCall[expression.getExpressionCount()];
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
            expressions[e] = (OCLFeatureCall) result;
        }
        try {
            result = new MultiAndExpression(expressions);
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }            
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
        result = new Let(let.getVariable(), result);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
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
        result = new IfThen(ifExpr, thenExpr, elseExpr);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        ConstraintSyntaxTree container = result;
        call.getExpression().accept(this);
        ConstraintSyntaxTree expression = result;
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < decls.length; d++) {
            decls[d] = call.getDeclarator(d);
        }
        result = new ContainerOperationCall(container, call.getOperation(), expression, decls);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        result = new CompoundAccess(result, access.getSlotName());
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
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
            slotDecls[s] = initializer.getSlotDeclaration(s);
        }
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[initializer.getExpressionCount()];
        for (int e = 0; e < exprs.length; e++) {
            initializer.getExpression(e).accept(this);
            exprs[e] = result;
        }
        try {
            result = new CompoundInitializer(initializer.getType(), slots, slotDecls, exprs);
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
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
            result = new ContainerInitializer(initializer.getType(), exprs);
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // shall not occur with initially correct constraints, logging is ok
        }
        
    }

    @Override
    public void visitSelf(Self self) {
        if (null == selfEx && null != this.self) {
            selfEx = new Variable(this.self);
        }
        if (selfEx != null) {
            result = selfEx;
        } else {
            result = self; // no replacement needed            
        }
        containsSelf = true;
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
