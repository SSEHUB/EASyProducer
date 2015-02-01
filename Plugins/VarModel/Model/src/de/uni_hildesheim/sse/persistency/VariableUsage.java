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

package de.uni_hildesheim.sse.persistency;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
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
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

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
        for (int e = 0; e < project.getElementCount(); e++) {
            project.getElement(e).accept(this);
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
    public void visitParenthesis(Parenthesis parenthesis) {
        if (null != parenthesis.getExpr()) {
            parenthesis.getExpr().accept(this);
        }
    }

    @Override
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
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

}
