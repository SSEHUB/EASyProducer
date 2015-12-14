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

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Class to copy an expression. May be superseded by {@link CopyVisitor}.
 * 
 * @author beck
 * @author Holger Eichelberger
 */
public class ConstraintReplacer implements IConstraintTreeVisitor {

    // TODO check for replacement with CopyVisitor
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ConstraintReplacer.class, Bundle.ID);
    private Map<Leaf, Leaf> mapping = new HashMap<Leaf, Leaf>();
    private Map<AbstractVariable, AbstractVariable> varMapping = new HashMap<AbstractVariable, AbstractVariable>();
    private ConstraintSyntaxTree copiedConstraint;
    private ConstraintSyntaxTree origin;
    
    /**
     * Creates a ConstraintReplacer witch is needed to copy a OCLFeatureCall.
     * @param origin ConstraintSyntaxTree witch should be copied
     */
    public ConstraintReplacer(ConstraintSyntaxTree origin) {
        this.origin = origin;
    }
    
    /**
     * Copies a ConstraintSyntaxTree and replaces all occurrences of oldLeaf with newLeaf.
     * @param oldLeaf Variables and Constants witch should be replaced
     * @param newLeaf Replacement of oldLeaf
     * @return returns a new ConstraintSyntaxTree
     */
    public ConstraintSyntaxTree replaceVariable(Leaf oldLeaf, Leaf newLeaf) {
        mapping.put(oldLeaf, newLeaf);
        origin.accept(this);
        return copiedConstraint;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        replace(value);
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable mappedDecl = varMapping.get(variable.getVariable());
        if (null != mappedDecl) {
            copiedConstraint = new Variable(mappedDecl);
        } else {
            replace(variable);
        }
    }
    
    /**
     * Replaces a leaf if in {@link #mapping}.
     * 
     * @param oldLeaf the candidate for replacement
     */
    private void replace(Leaf oldLeaf) {
        Leaf newLeaf = mapping.get(oldLeaf);
        if (null != newLeaf) {
            copiedConstraint = newLeaf;
        } else {
            copiedConstraint = oldLeaf;
        }      
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
        copiedConstraint = new Parenthesis(copiedConstraint);
        resolve();
    }
    
    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        int count = initializer.getExpressionCount();
        String[] slots = new String[count];
        AbstractVariable[] slotDecls = new AbstractVariable[count];
        ConstraintSyntaxTree[] expressions = new ConstraintSyntaxTree[count];
        for (int e = 0; e < count; e++) {
            slots[e] = initializer.getSlot(e);
            slotDecls[e] = map(initializer.getSlotDeclaration(e));
        }
        for (int e = 0; e < count; e++) {
            initializer.getExpression(e).accept(this);
            expressions[e] = copiedConstraint;
        }
        try {
            copiedConstraint = new CompoundInitializer(initializer.getType(), slots, slotDecls, expressions);
            resolve();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        int count = initializer.getExpressionCount();
        ConstraintSyntaxTree[] expressions = new ConstraintSyntaxTree[count];
        for (int e = 0; e < count; e++) {
            initializer.getExpression(e).accept(this);
            expressions[e] = copiedConstraint;
        }
        try {
            copiedConstraint = new ContainerInitializer(initializer.getType(), expressions);
            resolve();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e);
        }
    }
    
    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        call.getOperand().accept(this);
        ConstraintSyntaxTree operand = copiedConstraint;
        ConstraintSyntaxTree[] parameters = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            parameters[i] = copiedConstraint;
        }
        copiedConstraint = new OCLFeatureCall(operand, call.getOperation(), call.getAccessor(), parameters);
        resolve();
    }

    /**
     * Resolves the type of {@link #copiedConstraint}.
     */
    private void resolve() {
        if (null != copiedConstraint) {
            try {
                copiedConstraint.inferDatatype();
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
        }
    }

    @Override
    public void visitLet(Let let) {
        DecisionVariableDeclaration var = map(let.getVariable());
        let.getInExpression().accept(this);
        ConstraintSyntaxTree inEx = copiedConstraint;
        copiedConstraint = new Let(var, inEx);
        resolve();
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ConstraintSyntaxTree ifEx = copiedConstraint;
        ifThen.getThenExpr().accept(this);
        ConstraintSyntaxTree thenEx = copiedConstraint;
        ConstraintSyntaxTree elseEx = null;
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr().accept(this);
            elseEx = copiedConstraint;
        }
        copiedConstraint = new IfThen(ifEx, thenEx, elseEx);
        resolve();
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        ConstraintSyntaxTree container = copiedConstraint;
        DecisionVariableDeclaration[] declarators = new DecisionVariableDeclaration[call.getDeclaratorsCount()];
        for (int d = 0; d < declarators.length; d++) {
            declarators[d] = map(call.getDeclarator(d));
        }
        call.getExpression().accept(this);
        ConstraintSyntaxTree expression = copiedConstraint;
        copiedConstraint = new ContainerOperationCall(container, call.getOperation(), expression, declarators);
        resolve();
    }

    /**
     * Maps an abstract variable for proper copying.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable
     */
    private AbstractVariable map(AbstractVariable var) {
        AbstractVariable result;
        if (var instanceof DecisionVariableDeclaration) {
            result = map((DecisionVariableDeclaration) var);
        } else if (var instanceof Attribute) {
            Attribute old = (Attribute) var;
            IAttributableElement element = old.getElement();
            if (element instanceof AbstractVariable) {
                AbstractVariable tmp = varMapping.get(((AbstractVariable) element));
                if (tmp instanceof IAttributableElement) {
                    element = (IAttributableElement) tmp;
                }
            }
            result = new Attribute(old.getName(), old.getType(), old.getParent(), element);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Maps a decision variable for proper copying.
     * 
     * @param var the variable to be mapped
     * @return the mapped variable
     */
    private DecisionVariableDeclaration map(DecisionVariableDeclaration var) {
        DecisionVariableDeclaration result = new DecisionVariableDeclaration(var.getName(), 
            var.getType(), var.getParent());
        varMapping.put(var, result);
        return result;
    }
    
    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        ConstraintSyntaxTree compEx = copiedConstraint;
        copiedConstraint = new CompoundAccess(compEx, access.getSlotName());
        resolve();
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        ConstraintSyntaxTree actual = expression.getActualExpression();
        if (null != actual) {
            actual.accept(this);
        }
    }

    @Override
    public void visitSelf(Self self) {
        copiedConstraint = self; // no replacement needed
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO Check whether a specific method is needed
        visitVariable(variable);
    }

}
