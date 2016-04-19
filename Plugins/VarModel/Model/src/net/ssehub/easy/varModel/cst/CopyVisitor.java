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
package net.ssehub.easy.varModel.cst;

import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Holger Eichelberger
 */
public class CopyVisitor implements IConstraintTreeVisitor {

    private Map<AbstractVariable, AbstractVariable> mapping;
    private ConstraintSyntaxTree result;
    private IVariableMapper mapper;
    private IVariableReplacer replacer;

    /**
     * Defines a common variable replacer. (Shall replace <code>mapping</code> in the future).
     * 
     * @author Holger Eichelberger
     */
    public interface IVariableReplacer extends IVariableMapper {
        
        /**
         * Maps a leaf variable.
         * 
         * @param variable the variable to be mapped
         * @return the mapped variable or <b>null</b> if there is no mapping
         */
        public ConstraintSyntaxTree mapLeaf(Variable variable);
        
    }
    
    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this((Map<AbstractVariable, AbstractVariable>) null);
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
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapper the variable mapper (may be <b>null</b>)
     */
    public CopyVisitor(IVariableMapper mapper) {
        this.mapper = mapper;
        if (mapper instanceof IVariableReplacer) {
            this.replacer = (IVariableReplacer) mapper;
        }
    }
    
    /**
     * Returns the specified variable mapping.
     * @return A mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     */
    protected Map<AbstractVariable, AbstractVariable> getMapping() {
        return mapping;
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
        result = new ConstantValue(value.getConstantValue());
    }

    @Override
    public void visitVariable(Variable variable) {
        ConstraintSyntaxTree var = null;
        if (null != replacer) {
            var = replacer.mapLeaf(variable);
        }
        if (null == var) {
            var = new Variable(mapVariable(variable.getVariable()));
        }
        result = var;
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
        result = new Parenthesis(result);
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
        }
        operand = result;
        ConstraintSyntaxTree[] args = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int p = 0; p < args.length; p++) {
            call.getParameter(p).accept(this);
            args[p] = result;
        }
        result = new OCLFeatureCall(operand, call.getOperation(), call.getAccessor(), args);
    }

    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    protected DecisionVariableDeclaration mapVariable(DecisionVariableDeclaration var) {
        DecisionVariableDeclaration result = null;
        if (null != mapping) {
            AbstractVariable tmp = mapping.get(var); 
            if (tmp instanceof DecisionVariableDeclaration) {
                result = var;
            }
        }
        if (null == result && null != mapper) {
            IVariable tmp = mapper.map(var);
            if (tmp instanceof DecisionVariableDeclaration) {
                result = var;
            }
        }
        if (null == result) {
            result = var;
        }
        return result;
    }

    /**
     * Maps a variable.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable or <code>var</code>
     */
    protected AbstractVariable mapVariable(AbstractVariable var) {
        AbstractVariable result = null;
        if (null != mapping) {
            result = mapping.get(var);
            if (null == result) {
                result = var;
            }
        } else {
            result = var;
        }
        return result;
    }

    
    @Override
    public void visitLet(Let let) {
        DecisionVariableDeclaration var = mapVariable(let.getVariable());
        let.getInExpression().accept(this);
        result = new Let(var, result);
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
        result = new ContainerOperationCall(container, call.getOperation(), expression, decls);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        result = new CompoundAccess(result, access.getSlotName());
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
            result = new CompoundInitializer(initializer.getType(), slots, slotDecls, exprs);
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, Bundle.ID).exception(e);
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
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, Bundle.ID).exception(e);
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
        
        ConstraintSyntaxTree var = null;
        if (null != replacer) {
            var = replacer.mapLeaf(variable);
        }
        if (null == var) {
            var = new AttributeVariable(qualifier, (Attribute) mapVariable(variable.getVariable()));
        }
        result = var;
    }

}
