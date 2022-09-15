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
package net.ssehub.easy.varModel.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import net.ssehub.easy.basics.messages.Status;
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
import net.ssehub.easy.varModel.model.AbstractVisitor;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IPartialEvaluable;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DatatypeFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Checks a model for IVML compliance. This visitor is currently not complete!
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class IvmlValidationVisitor extends AbstractVisitor 
    implements IValueVisitor, IConstraintTreeVisitor {

    private List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    private Stack<String> location = new Stack<String>();
    private java.util.Set<IDatatype> customTypes;

    /**
     * Returns the number of detected errors.
     * 
     * @return the number of detected errors
     */
    public int getErrorCount() {
        int count = 0;
        for (int m = 0; m < messages.size(); m++) {
            if (Status.ERROR == messages.get(m).getStatus()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Returns the number of detected messages.
     * 
     * @return the number of detected messages
     */
    public int getMessageCount() {
        return messages.size();
    }
    
    /**
     * Returns the specified message.
     * 
     * @param index the index of the message to return
     * @return the message
     * @throws IndexOutOfBoundsException if 
     *   <code>index &lt; 0 || index &gt;={@link #getMessageCount()}}</code>
     */
    public ValidationMessage getMessage(int index) {
        return messages.get(index);
    }


    /**
     * Check whether the {@link IDatatype} of an {@link AbstractVariable} is part of the {@link Project}.
     * @param decl The declaration to check, must be part of the project.
     */
    private void checkDeclaration(AbstractVariable decl) {
        IDatatype type = decl.getType();
        // Test IDatatypes, which must be added to the project separately
        if ((type instanceof Enum || type instanceof Compound) && !customTypes.contains(type)) {
            addError("datatype '" + type.getName() + "' of '" + decl.getName() + "' is not part of the project", decl,
                ValidationMessage.MISSING_CUSTOM_DATATYPE);
        }
    }

    /**
     * Checks for a valid (name) identifier and stores an error message if required.
     * 
     * @param identifier the identifier to check for
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void checkNameIdentifier(String identifier, Object cause) {
        checkIdentifier(identifier, "name", cause, false);
    }
    
    /**
     * Checks for a valid identifier and stores an error message if required.
     * 
     * @param identifier the identifier to check for
     * @param info optional information denoting the specific part with invalid identifier
     * @param cause the cause for the error (may be <b>null</b>)
     * @param allowWildcard allows for wildcard characters
     */
    private void checkIdentifier(String identifier, String info, Object cause, boolean allowWildcard) {
        String id = identifier;
        if (allowWildcard && id.endsWith("*")) {
            id = id.substring(0, id.length() - 1);
        }
        if (!IvmlIdentifierCheck.isValidIdentifier(id)) {
            if (null != info && info.length() > 0) {
                info = " at " + info;
            }
            addError("invalid identifier '" + identifier + "'" + info, cause, 
                ValidationMessage.INVALID_IDENTIFIER);
        }
    }
    
    /**
     * Checks for a valid datatype.
     * 
     * @param type the type to be checked
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void checkType(IDatatype type, Object cause) {
        if (null == type) {
            addError("type must not be <null>", cause, ValidationMessage.TYPE_IS_NULL);
        }
    }

    /**
     * Checks for a valid parent (reference).
     * 
     * @param element the element to check the parent reference for
     * @param expectedParent the expected parent reference
     */
    private void checkParent(IModelElement element, IModelElement expectedParent) {
        checkParent(element.getParent(), element, expectedParent);
    }
    
    /**
     * Checks for a valid parent (reference).
     * 
     * @param parent the parent reference for
     * @param cause the cause for the error (the holder of the parent reference)
     * @param expectedParent the expected parent reference
     */
    private void checkParent(IModelElement parent, Object cause, IModelElement expectedParent) {
        if (null == parent) {
            addError("parent must not be <null> " + cause.getClass(), cause, ValidationMessage.INVALID_PARENT);
        } else {
            if (null != expectedParent) {
                if (parent != expectedParent) {
                    addError("incorrect reference to parent", cause, ValidationMessage.INVALID_PARENT);
                }
            }
        }
    }

    /**
     * Checks a comment.
     * 
     * @param text the comment text
     * @param allowNull if <code>true</code> then <code>text==<b>null</b></code> is not
     *   considered as an error, if <code>false</code> an error is registered in case of
     *   <code>text==<b>null</b></code>
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void checkComment(String text, boolean allowNull, Object cause) {
        if (null != text) {
            if (text.indexOf("/*") >= 0 || text.indexOf("*/") >= 0) {
                addError("illegal comment '" + text + "'", cause, ValidationMessage.ILLEGAL_COMMENT);
            }
        } else {
            if (!allowNull) {
                addError("comment is <null>'" + text + "'", cause, ValidationMessage.ILLEGAL_COMMENT);
            }
        }
    }

    /**
     * Checks for a valid (sub-)expression.
     * 
     * @param expression the expression to check
     * @param info optional information denoting the specific expression
     * @param cause the cause for the error (may be <b>null</b>)
     * @return <code>true</code> if the expression is valid, <code>false</code> else
     */
    private boolean checkExpression(ConstraintSyntaxTree expression, String info, Object cause) {
        boolean isValid = (null != expression);
        if (!isValid) {
            String error = "expression is <null>";
            if (null != info && info.length() > 0) {
                error = info + " " + error;
            }
            addError(error, cause, ValidationMessage.MISSING_EXPRESSION);
        }
        return isValid;
    }

    /**
     * Adds an error and appends the current location if possible.
     * 
     * @param text the textual description of the error
     * @param cause the cause for the error (may be <b>null</b>)
     * @param code specifies the kind of the error ({@link ValidationMessage})
     */
    private void addError(String text, Object cause, int code) {
        if (!location.isEmpty()) {
            text += " in " + location;
        }
        messages.add(new ValidationMessage(text, Status.ERROR, cause, code));
    }

    /**
     * Adds an error because the given element is <b>null</b>.
     * 
     * @param elementName the logical name of the element
     * @param pos the position within the element collection
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void addElementIsNullError(String elementName, int pos, Object cause) {
        messages.add(new ValidationMessage(elementName + " " + pos + " must not be <null>", Status.ERROR, 
            cause, ValidationMessage.ELEMENT_IS_NULL));
    }
        
    @Override
    public void visitProject(Project project) {
        checkNameIdentifier(project.getName(), project);
        location.push("project " + project.getName());
        int count;
        //Projects imports
        count = project.getImportsCount();
        for (int p = 0; p < count; p++) {
            ProjectImport imp = project.getImport(p);
            if (null == imp) {
                addElementIsNullError("import", p, project);
            } else {
                // imp has no parent!
                imp.accept(this);
            }
        }
        
        /*
         * Collect all custom datatypes.
         * Sascha El-Sharkawy: This will only be a heuristic, but reduces the run time.
         * I think this will be sufficient for most cases.
         */
        if (1 == location.size()) {
            DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, null);
            customTypes = new HashSet<IDatatype>(finder.getFoundDatatypes());
        }

        //Elements on top layer inside the project
        count = project.getElementCount();
        for (int c = 0; c < count; c++) {
            ContainableModelElement elt = project.getElement(c);
            if (null == elt) {
                addElementIsNullError("element ", c, project);
            } else {
                checkParent(elt, project);
                elt.accept(this);
            }
        }

        //super.visitProject(project);
        location.pop();
    }
    
    @Override
    public void visitEnum(Enum eenum) {
        checkNameIdentifier(eenum.getName(), eenum);
        location.push("enum " + eenum.getName());
        int count = eenum.getLiteralCount();
        for (int e = 0; e < count; e++) {
            EnumLiteral lit = eenum.getLiteral(e);
            if (null == lit) {
                addElementIsNullError("literal", e, eenum);
            } else {
                checkParent(lit, eenum);
                lit.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        checkNameIdentifier(eenum.getName(), eenum);
        location.push("enum " + eenum.getName());
        int count = eenum.getLiteralCount();
        for (int e = 0; e < count; e++) {
            EnumLiteral lit = eenum.getLiteral(e);
            if (null == lit) {
                addElementIsNullError("literal ", e, eenum);
            } else {
                // ordinals are being checked by OrderedEnum
                checkParent(lit, eenum);
                lit.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitCompound(Compound compound) {
        checkNameIdentifier(compound.getName(), compound);
        location.push("compound " + compound.getName());
        int count = compound.getElementCount();
        for (int e = 0; e < count; e++) {
            DecisionVariableDeclaration decl = compound.getElement(e);
            if (null == decl) {
                addElementIsNullError("declaration", e, compound);
            } else {
                checkParent(decl, compound);
                decl.accept(this);    
            }
        }
        count = compound.getConstraintsCount();
        for (int c = 0; c < count; c++) {
            Constraint constr = compound.getConstraint(c);
            if (null == constr) {
                addElementIsNullError("constraint", c, compound);
            } else {
                checkParent(constr, compound);
                constr.accept(this);
            }
        }
        count = compound.getAssignmentCount();
        for (int c = 0; c < count; c++) {
            AttributeAssignment assng = compound.getAssignment(c);
            if (null == assng) {
                addElementIsNullError("assignment", c, compound);
            } else {
                checkParent(assng, compound);
                assng.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getInterfaceName()) {
            checkIdentifier(pImport.getInterfaceName(), "interface", pImport, false);
        }
        checkIdentifier(pImport.getProjectName(), "project", pImport, pImport.isWildcard());
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        checkNameIdentifier(decl.getName(), decl);
        // Check presence of custom data types
        checkDeclaration(decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        checkNameIdentifier(attribute.getName(), attribute);
        // Check presence of custom data types
        checkDeclaration(attribute);

        // Check whether annotated element has this annotation (could happen if wrong add method was used)
        IAttributableElement annotatedElement = attribute.getElement();
        if (null != annotatedElement) {
            boolean annotationFound = attribute == annotatedElement.getAttribute(attribute.getName());
            if (!annotationFound) {
                addError(annotatedElement.getClass().getSimpleName() + " \"" + annotatedElement.getName()
                    + "\" was not annotated by " + attribute.getName(),
                    annotatedElement, ValidationMessage.UNRESOLVED_ANNOTATION);
            }
        } else {
            addError("Annotated element of " + attribute.getName() + " is <null>",
                attribute, ValidationMessage.ELEMENT_IS_NULL);
        }
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        if (null != constraint.getConsSyntax()) {
            // null is allowed here
            constraint.getConsSyntax().accept(this);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        location.push("freeze block");
        for (int f = 0; f < freeze.getFreezableCount(); f++) {
            IFreezable freezable = freeze.getFreezable(f);
            if (null == freezable) {
                addElementIsNullError("freezable", f, freeze);
            } else {
                if (!(freezable instanceof CompoundAccessStatement)) {
                    // no parent test as references are reused
                    checkIdentifier(freezable.getName(), "freezable " + f, freeze, false);
                }
            }
        }
        // TODO but
        location.pop();
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        checkNameIdentifier(opdef.getName(), opdef);
        // TODO visit datatypes?
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        location.push("in partial evaluation block");
        for (int e = 0; e < block.getEvaluableCount(); e++) {
            IPartialEvaluable eval = block.getEvaluable(e); 
            if (null == eval) {
                addElementIsNullError("expression", e, block);
            } else {
                checkParent(eval.getParent(), eval, block);
                eval.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        checkNameIdentifier(iface.getName(), iface);
        location.push("interface " + iface.getName());
        // TODO check elements
        for (int e = 0; e < iface.getExportsCount(); e++) {
            DecisionVariableDeclaration decl = iface.getExport(e);
            if (null == decl) {
                addElementIsNullError("export", e, iface);
            } else {
                // no parent test as references are used
                decl.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitComment(Comment comment) {
        checkComment(comment.getComment(), true, comment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        location.push("attribute assignment");
        // TODO check model elements
        for (int e = 0; e < assignment.getConstraintsCount(); e++) {
            Constraint constraint = assignment.getConstraint(e);
            if (null == constraint) {
                addElementIsNullError("constraint", e, assignment);
            } else {
                checkParent(constraint, assignment);
                constraint.accept(this);
            }
        }
        for (int e = 0; e < assignment.getElementCount(); e++) {
            DecisionVariableDeclaration decl = assignment.getElement(e);
            if (null == decl) {
                addElementIsNullError("declaration", e, assignment);
            } else {
                checkParent(decl, assignment);
                decl.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        checkNameIdentifier(datatype.getName(), datatype);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        checkNameIdentifier(literal.getName(), literal);
    }

    @Override
    public void visitReference(Reference reference) {
        checkType(reference.getType(), reference);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        checkNameIdentifier(sequence.getName(), sequence);
    }

    @Override
    public void visitSet(Set set) {
        checkNameIdentifier(set.getName(), set);
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // done by value factory
    }

    @Override
    public void visitVariable(Variable variable) {
        if (null == variable.getVariable()) {
            addError("link to variable declaration must not be <null>", variable, ValidationMessage.IS_NULL);
        }
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        if (checkExpression(parenthesis.getExpr(), "parenthesis", parenthesis)) {
            parenthesis.getExpr().accept(this);
        }
    }

    @Override
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
        checkComment(comment.getComment(), true, comment);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null == call.getResolvedOperation()) {
            addError("Operation of OclFeatureCall could not be resolved.", call,
                ValidationMessage.UNRESOLVED_OPERATION);
        }
        if (null != call.getOperand()) {
            call.getOperand().accept(this);
        } // then call.getAccessor() shall be given!
        for (int i = 0, n = call.getParameterCount(); i < n; i++) {
            call.getParameter(i).accept(this);
        }
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this); // transparent
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        // TODO check
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO check
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO check
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO check
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        location.push("compound initializer");
        checkType(initializer.getType(), initializer);
        for (int e = 0; e < initializer.getSlotCount(); e++) {
            String name = initializer.getSlot(e);
            if (null == name) {
                addElementIsNullError("slot", e, initializer);
            } else {
                if (null == initializer.getType().getElement(name)) {
                    addError("slot '" + e + "' not declared in respective type", initializer, 
                        ValidationMessage.UNDECLARED_SLOT);
                }
            }
            ConstraintSyntaxTree cst = initializer.getExpression(e);
            if (null == cst) {
                addElementIsNullError("expression", e, initializer);
            } else {
                cst.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        location.push("container initializer");
        checkType(initializer.getType(), initializer);
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            ConstraintSyntaxTree cst = initializer.getExpression(e);
            if (null == cst) {
                addElementIsNullError("expression", e, initializer);
            } else {
                cst.accept(this);
            }
        }
        location.pop();
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
    }

    @Override
    public void visitEnumValue(EnumValue value) {
    }

    @Override
    public void visitStringValue(StringValue value) {
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
    }

    @Override
    public void visitIntValue(IntValue value) {
    }

    @Override
    public void visitRealValue(RealValue value) {
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
    }

    @Override
    public void visitNullValue(NullValue value) {
        // ok
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO check whether slot is in variable
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        // TODO shall only occur in imports for now
    }

    @Override
    public void visitSelf(Self self) {
        // TODO type != null
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
