package de.uni_hildesheim.sse.model.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IPartialEvaluable;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Checks a model for IVML compliance. This visitor is currently not complete!
 * 
 * @author Holger Eichelberger
 */
public class IvmlValidationVisitor extends AbstractVisitor 
    implements IValueVisitor, IConstraintTreeVisitor {

    private List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    private Stack<String> location = new Stack<String>();

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
     * Checks for a valid (name) identifier and stores an error message if required.
     * 
     * @param identifier the identifier to check for
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void checkNameIdentifier(String identifier, Object cause) {
        checkIdentifier(identifier, "name", cause);
    }
    
    /**
     * Checks for a valid identifier and stores an error message if required.
     * 
     * @param identifier the identifier to check for
     * @param info optional information denoting the specific part with invalid identifier
     * @param cause the cause for the error (may be <b>null</b>)
     */
    private void checkIdentifier(String identifier, String info, Object cause) {
        if (!IvmlIdentifierCheck.isValidIdentifier(identifier)) {
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
        
    /**
     * {@inheritDoc}
     */
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

        super.visitProject(project);
        location.pop();
    }
    
    /**
     * {@inheritDoc}
     * <i>Sequence:</i> literals.
     */
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

    /**
     * {@inheritDoc}
     * <i>Sequence:</i> literals.
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getInterfaceName()) {
            checkIdentifier(pImport.getInterfaceName(), "interface", pImport);
        }
        checkIdentifier(pImport.getProjectName(), "project", pImport);
    }

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        checkNameIdentifier(decl.getName(), decl);
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        checkNameIdentifier(attribute.getName(), attribute);
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        if (null != constraint.getConsSyntax()) {
            // null is allowed here
            constraint.getConsSyntax().accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        location.push("freeze block");
        for (int f = 0; f < freeze.getFreezableCount(); f++) {
            IFreezable freezable = freeze.getFreezable(f);
            if (null == freezable) {
                addElementIsNullError("freezable", f, freeze);
            } else {
                // no parent test as references are reused
                checkIdentifier(freezable.getName(), "freezable " + f, freeze);
            }
        }
        // TODO but
        location.pop();
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        checkNameIdentifier(opdef.getName(), opdef);
        // TODO visit datatypes?
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        checkComment(comment.getComment(), true, comment);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        checkNameIdentifier(datatype.getName(), datatype);
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        checkNameIdentifier(literal.getName(), literal);
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        checkType(reference.getType(), reference);
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        checkNameIdentifier(sequence.getName(), sequence);
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        checkNameIdentifier(set.getName(), set);
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        // done by value factory
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        if (null == variable.getVariable()) {
            addError("link to variable declaration must not be <null>", variable, ValidationMessage.IS_NULL);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        if (checkExpression(parenthesis.getExpr(), "parenthesis", parenthesis)) {
            parenthesis.getExpr().accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
        checkComment(comment.getComment(), true, comment);
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitConstraintValue(ConstraintValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumValue(EnumValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitStringValue(StringValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundValue(CompoundValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerValue(ContainerValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitIntValue(IntValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitRealValue(RealValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitBooleanValue(BooleanValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitReferenceValue(ReferenceValue referenceValue) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitMetaTypeValue(MetaTypeValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitNullValue(NullValue value) {
        // ok
    }

}
