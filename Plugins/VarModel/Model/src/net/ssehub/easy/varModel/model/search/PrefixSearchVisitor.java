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
package net.ssehub.easy.varModel.model.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
import net.ssehub.easy.varModel.model.AbstractVisitor;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.QualifiedNameMode;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

// TODO for further optimization also the SearchResults shall be pooled!!!

/**
 * Realizes a visitor which searches for a given prefix in a given context and returns 
 * all matching model elements.
 * 
 * @author Holger Eichelberger
 */
public class PrefixSearchVisitor extends AbstractVisitor implements IConstraintTreeVisitor {

    private static final List<PrefixSearchVisitor> INSTANCES = new ArrayList<PrefixSearchVisitor>();
    private List<SearchResult> result = new ArrayList<SearchResult>();
    private HashSet<Object> inResult = new HashSet<Object>();
    private Class<?>[] restrictions;
    private String prefix;
    private DatatypeVisitor datatypeVisitor;
    private SearchContext context;
    private Stack<Project> nesting = new Stack<Project>();
    private boolean inInterface = false;
    
    /**
     * Constructs an instances. Prevents that instance can be created from outside.
     */
    private PrefixSearchVisitor() {
    }
    
    /**
     * Obtains a (pooled) instance. The result must be released by {@link #release(PrefixSearchVisitor)}.
     * 
     * @param prefix the name search prefix
     * @param datatypeVisitor the visitor for obtaining full type names
     * @param context the search context (may be <b>null</b>)
     * @param restrictions type restrictions on search results (may be <b>null</b>)
     * @return the visitor
     */
    public static final synchronized PrefixSearchVisitor getInstance(String prefix, DatatypeVisitor datatypeVisitor, 
        SearchContext context, Class<?>... restrictions) {
        PrefixSearchVisitor result;
        if (!INSTANCES.isEmpty()) {
            result = INSTANCES.remove(INSTANCES.size() - 1);
        } else {
            result = new PrefixSearchVisitor();
        }
        result.prepareInstance(prefix, datatypeVisitor, context, restrictions);
        return result;
    }
    
    /**
     * Releases a given visitor. Do not use <code>visitor</code> afterwards.
     * 
     * @param visitor the visitor to be released
     */
    public static final synchronized void release(PrefixSearchVisitor visitor) {
        visitor.clear();
        visitor.restrictions = null;
        visitor.prefix = "";
        visitor.datatypeVisitor = null;
        visitor.context = null;
        visitor.nesting.clear();
        visitor.inInterface = false;
        INSTANCES.add(visitor);
    }

    /**
     * Prepares a (reused) instance.
     * 
     * @param prefix the name search prefix
     * @param datatypeVisitor the visitor for obtaining full type names
     * @param context the search context (may be <b>null</b>)
     * @param restrictions type restrictions on search results (may be <b>null</b>)
     */
    private void prepareInstance(String prefix, DatatypeVisitor datatypeVisitor, 
        SearchContext context, Class<?>... restrictions) {
        this.prefix = prefix;
        if (null == context) {
            this.context = SearchContext.ALL;
        } else {
            this.context = context;
        }
        this.datatypeVisitor = datatypeVisitor;
        this.datatypeVisitor.setQualifiedNameMode(QualifiedNameMode.QUALIFIED);
        this.restrictions = restrictions;
        
        if (null != context && context.includeOperations()) {
            int oCount = Operation.getOperationsCount();
            for (int o = 0; o < oCount; o++) {
                Operation op = Operation.getOperation(o);
                checkName(op.getName(), op);
            }
        }
    }
    
    /**
     * Returns the collected results.
     * 
     * @return the results
     */
    public List<SearchResult> getResult() {
        List<SearchResult> result = new ArrayList<SearchResult>();
        result.addAll(this.result);
        return result;
    }
    
    /**
     * Clears the results for reusing this instance.
     */
    public void clear() {
        result.clear();
        inResult.clear();
    }
    
    /**
     * Checks a name for inclusion.
     * 
     * @param name the name to be checked
     * @param element the element associated with <code>name</code>
     */
    private void checkName(String name, Object element) {
        if (null != name && name.startsWith(prefix)) {
            boolean restricted = false;
            if (null != restrictions && null != element) {
                for (int r = 0; !restricted && r < restrictions.length; r++) {
                    restricted = restrictions[r] == element.getClass();
                }
            }
            if (!restricted) {
                result.add(new SearchResult(name, element));
                inResult.add(element);
            }
        }
    }

    /**
     * Checks a model <code>element</code> for inclusion. This method checks the simple and 
     * the qualified name of <code>element</code>.
     * 
     * @param element the element to be checked
     */
    private void checkName(ModelElement element) {
        if (context.includeUnqualifiedNames()) {
            checkName(element.getName(), element);
        }
        if (context.includeQualifiedNames()) {
            checkName(element.getQualifiedName(), element);
        }
    }

    /**
     * Checks a <code>type</code> for inclusion. 
     * 
     * @param type the type to be checked
     * @param element the element which uses or defines <code>type</code>
     * @return the explicated name of the type using {@link #datatypeVisitor}
     */
    private String checkType(IDatatype type, ModelElement element) {
        type.accept(datatypeVisitor);
        String name = datatypeVisitor.getResult();
        checkName(name, element);
        datatypeVisitor.clear();
        return name;
    }

    /**
     * Returns whether the <code>object</code> is part of the result.
     * 
     * @param object the object to check for
     * @return <code>true</code> if <code>object</code> is part of the result, <code>false</code> else
     */
    private boolean resultContains(Object object) {
        return inResult.contains(object);
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        checkName(pImport.getProjectName(), pImport);
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        boolean consider = context.includeUnqualifiedNames();
        if (inInterface) {
            consider &= (1 == nesting.size() || !nesting.peek().hasInterfaces());
        }
        if (consider) {
            if (!resultContains(decl)) {
                checkName(decl);
                checkType(decl.getType(), decl);
                int aCount = decl.getAttributesCount();
                for (int a = 0; a < aCount; a++) {
                    decl.accept(this);
                }
            }
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        checkName(attribute);
        checkType(attribute.getType(), attribute);
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        if (context.includeConstraints()) {
            constraint.getConsSyntax().accept(this);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // no declaration, nothing special
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        checkName(opdef);
        if (context.includeOperationDefinitions()) {
            CustomOperation operation = opdef.getOperation();
            int pCount = operation.getParameterCount();
            for (int p = 0; p < pCount; p++) {
                checkName(operation.getParameterDeclaration(p));
            }
        }
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        if (context.includeEvals()) {
            int eCount = block.getEvaluableCount();
            for (int e = 0; e < eCount; e++) {
                block.getEvaluable(e).accept(this);
            }
        }
    }

    @Override
    public void visitProject(Project project) {
        nesting.push(project);
        project.getVariable().accept(this); // self, attributes
        super.visitProject(project); // imports, elements, custom operations via elements
        nesting.pop();
    }
    
    @Override
    public void visitEnum(Enum eenum) {
        checkName(eenum);
        super.visitEnum(eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        checkName(compound);
        super.visitCompound(compound);  
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        if (nesting.size() > 1) {
            inInterface = true;
            // unclear... interfaces need to be imported - search imports
            int eCount = iface.getExportsCount();
            for (int e = 0; e < eCount; e++) {
                iface.getExport(e).accept(this);
            }
            inInterface = false;
        }
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        visitEnum(eenum);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        checkName(datatype);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // getName() cannot be referenced as individual name
        checkName(literal.getQualifiedName(), literal);
    }

    @Override
    public void visitReference(Reference reference) {
        String name = checkType(reference, reference); // check name with refTo()
        if (name.startsWith(IvmlKeyWords.REFTO)) { // should be the case always
            checkName(IvmlKeyWords.REFBY + name.substring(0, IvmlKeyWords.REFTO.length()), reference);
        }
    }

    @Override
    public void visitSequence(Sequence sequence) {
        checkName(sequence);
    }

    @Override
    public void visitSet(Set set) {
        checkName(set);
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // no name
    }

    @Override
    public void visitVariable(Variable variable) {
        // collected above in tree or model
        //variable.getVariable().accept(this); // varDecl avoids adding duplicates
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }
    
    @Override
    public void visitContainerInitializer(ContainerInitializer init) {
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }
    
    @Override
    public void visitCompoundInitializer(CompoundInitializer init) {
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }
    
    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        comment.getExpr().accept(this);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // operations are considered in project
        call.getOperand().accept(this);
        int pCount = call.getParameterCount();
        for (int p = 0; p < pCount; p++) {
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
        if (context.includeLets()) {
            let.getVariable().accept(this);
        }
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // operations are considered in project
        call.getContainer().accept(this);
        int dCount = call.getDeclaratorsCount();
        for (int d = 0; d < dCount; d++) {
            call.getDeclarator(d).accept(this);
        }
        call.getExpression().accept(this);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
    }
    
    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        if (expression.isLeaf()) {
            checkName(expression.getUnresolvedLeaf(), expression);
        } else {
            ConstraintSyntaxTree actual = expression.getActualExpression();
            if (null != actual) {
                actual.accept(this);
            }
        }
    }

    @Override
    public void visitComment(Comment comment) {
        // do not consider comments at the moment
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int v = 0; v < assignment.getElementCount(); v++) {
            assignment.getElement(v).accept(this);
        }
        for (int c = 0; c < assignment.getConstraintsCount(); c++) {
            assignment.getConstraint(c).accept(this);
        }
        // may be nested, even on top-level
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // does not contribute to result as parts are defined somewhere else in the model
    }

    @Override
    public void visitSelf(Self self) {
        // does not contribute to result
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
