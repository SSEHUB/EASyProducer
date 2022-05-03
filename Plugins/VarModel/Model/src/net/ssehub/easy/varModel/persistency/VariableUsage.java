/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.varModel.persistency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
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
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * Collects the variable usage in order to determine those variables that can be
 * written in an unqualified way.
 * 
 * @author Holger Eichelberger
 */
class VariableUsage implements IModelVisitor, IConstraintTreeVisitor {

    // very initial - improvements are welcome, local types may lead to problems
    
    private Map<String, Integer> imports = new HashMap<String, Integer>();
    private Map<String, AbstractVariable> mapping = new HashMap<String, AbstractVariable>();
    private java.util.Set<Project> done = new HashSet<Project>();

    /**
     * Returns whether <code>var</code> needs qualification.
     * 
     * @param var the variable to be checked
     * @return <code>true</code> if qualification is needed, <code>false</code> else
     */
    public boolean needsQualification(AbstractVariable var) {
        return mapping.get(var.getName()) != var;
    }
    
    /**
     * Clears this object for reuse.
     */
    public void clear() {
        imports.clear();
        mapping.clear();
        done.clear();
    }
    
    @Override
    public void visitEnum(Enum eenum) {
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
    }

    @Override
    public void visitCompound(Compound compound) {
        for (int c = 0; c < compound.getConstraintsCount(); c++) {
            compound.getConstraint(c).accept(this);
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        for (int c = 0; c < datatype.getConstraintCount(); c++) {
            datatype.getConstraint(c).accept(this);
        }
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
    }

    @Override
    public void visitReference(Reference reference) {
    }

    @Override
    public void visitSequence(Sequence sequence) {
    }

    @Override
    public void visitSet(Set set) {
    }

    @Override
    public void visitProject(Project project) {
        if (!done.contains(project)) {
            done.add(project);
            // local variables take precedence over imports
            for (int e = 0; e < project.getElementCount(); e++) {
                project.getElement(e).accept(this);
            }
            for (int i = 0; i < project.getImportsCount(); i++) {
                ProjectImport imp = project.getImport(i);
                String name = imp.getName();
                if (null != imp.getInterfaceName()) {
                    name = name + IvmlKeyWords.NAMESPACE_SEPARATOR + imp.getInterfaceName();
                }
                imports.put(name, i);
                if (null != imp.getResolved()) {
                    imp.getResolved().accept(this);
                }
            }
        }
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        String name = decl.getName();
        if (!mapping.containsKey(name)) {
            mapping.put(name, decl); // local declarations can be written unqualified
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        if (null != constraint.getConsSyntax()) {
            constraint.getConsSyntax().accept(this);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        CustomOperation custOp = opdef.getOperation();
        if (null != custOp) {
            ConstraintSyntaxTree cst = custOp.getFunction();
            if (null != cst) {
                cst.accept(this);
            }
        }
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int e = 0; e < assignment.getElementCount(); e++) {
            assignment.getElement(e).accept(this);
        }
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
    }

    /**
     * Returns a pseudo position index for <code>variable</code> according to 
     * its import position.
     * 
     * @param variable the variable to return the position for
     * @return <code>-1</code> if the variable is defined in this project, 
     *   the index number of the responsible import, the maximum integer value
     *   if no import was found else
     */
    private int getImportPos(AbstractVariable variable) {
        int result;
        String ns = variable.getNameSpace();
        if (0 == ns.length()) {
            result = -1;
        } else {
            Integer pos;
            do {
                pos = imports.get(ns);
                if (null == pos) {
                    int i = ns.lastIndexOf(IvmlKeyWords.NAMESPACE_SEPARATOR);
                    if (i > 0) {
                        ns = ns.substring(0, i);
                    } else {
                        ns = "";
                    }
                }
            } while (null == pos && ns.length() > 0);
            if (null != pos) {
                result = pos;
            } else {
                result = Integer.MAX_VALUE;
            }
        }
        return result;
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable var = variable.getVariable();
        String name = var.getName();
        AbstractVariable unQ = mapping.get(name);
        boolean put;
        if (null == unQ) {
            put = true;
        } else {
            put = getImportPos(var) < getImportPos(unQ);
        }
        if (put) {
            mapping.put(name, var);
        }
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        if (null != parenthesis.getExpr()) {
            parenthesis.getExpr().accept(this);
        }
    }

    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) {
            call.getOperand().accept(this);
        }
        for (int p = 0; p < call.getParameterCount(); p++) {
            call.getParameter(p).accept(this);
        }
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this);
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr().accept(this);
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        if (null != call.getExpression()) {
            call.getExpression().accept(this);
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // does not contribute
    }

    @Override
    public void visitSelf(Self self) {
        // does not contribute
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }
    
    @Override
    public String toString() {
        return "VariableUsage " + mapping;
    }

}
