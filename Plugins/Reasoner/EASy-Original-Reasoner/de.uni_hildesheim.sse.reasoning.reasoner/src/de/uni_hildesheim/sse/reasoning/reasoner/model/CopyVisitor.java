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
package de.uni_hildesheim.sse.reasoning.reasoner.model;

import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.CompoundVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
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
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction.IVariableMapper;

/**
 * Copies a constraint syntax tree possibly mapping the variables. May be 
 * reused after calling {@link #clear()}
 * 
 * @author Holger Eichelberger
 */
public class CopyVisitor implements IConstraintTreeVisitor {

    private Map<AbstractVariable, AbstractVariable> mapping;
    private Map<AbstractVariable, CompoundAccess> mappingCA;
    private ConstraintSyntaxTree result;
    private IVariableMapper mapper;
    private AbstractVariable cmpVar; 
    private Self self;

    /**
     * Creates a copy visitor without mapping.
     */
    public CopyVisitor() {
        this((Map<AbstractVariable, AbstractVariable>) null);
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapping a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public CopyVisitor(Map<AbstractVariable, AbstractVariable> mapping) {
        this.mapping = mapping;
    }
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapping a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @param mappingCA a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    public CopyVisitor(Map<AbstractVariable, AbstractVariable> mapping, 
        Map<AbstractVariable, CompoundAccess> mappingCA) {
        this.mappingCA = mappingCA;
        this.mapping = mapping;
    }  

    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapper the variable mapper (may be <b>null</b>)
     */
    public CopyVisitor(IVariableMapper mapper) {
        this.mapper = mapper;
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
     * Method for setting self variable.
     * @param selfVariable self variable.
     */
    public void setSelf(AbstractVariable selfVariable) {
        this.cmpVar = selfVariable;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        result = new ConstantValue(value.getConstantValue());
    }

    @Override
    public void visitVariable(Variable variable) {
        CompoundAccess tmp = mappingCA.get(variable.getVariable());
        if (null != tmp) {
            result = tmp;
            try {
                tmp.inferDatatype();
            } catch (CSTSemanticException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
//            result = new Variable(mapVariable(variable.getVariable()));
            result = variable;
        }
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        result = new Parenthesis(result);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void visitComment(Comment comment) {
//        comment.getExpr().accept(this);
//        result = new Comment(result, comment.getComment());
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    
    @Override
    public void visitLet(Let let) {
        DecisionVariableDeclaration var = mapVariable(let.getVariable());
        let.getInExpression().accept(this);
        result = new Let(var, result);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            decls[d] = mapVariable(call.getDeclarator(d));
        }
        result = new ContainerOperationCall(container, call.getOperation(), expression, decls);
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        result = new CompoundAccess(result, access.getSlotName());
        try {
            result.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            slotDecls[s] = mapVariable(initializer.getSlotDeclaration(s));
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
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, "CompoundConstraintCopyVisitor").exception(e);
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
            EASyLoggerFactory.INSTANCE.getLogger(CopyVisitor.class, "CompoundConstraintCopyVisitor").exception(e);
        }
        
    }

    @Override
    public void visitSelf(Self self) {
        if (cmpVar != null) {
            result = new Variable(cmpVar);
        } else {
            result = self; // no replacement needed            
        }
    }

}
