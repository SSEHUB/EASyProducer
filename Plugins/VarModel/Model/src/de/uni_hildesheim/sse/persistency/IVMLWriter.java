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

import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.*;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation.FormattingHint;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.VersionValue;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Writer for writing the variability model to an IVML output file. Please note
 * that this writer creates output regardless of the correctness of the semantics 
 * of the model being visited. However, if the full IVML infrastructure including 
 * the IVML parser is used and given interfaces of this model are used properly, 
 * the output will be valid. In case that the classes in this model package are 
 * directly used from external code, it is strongly advised to use the 
 * {@link de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor} to check the validity
 * of the visited model before producing output.
 * 
 * @author El-Sharkawy
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class IVMLWriter extends AbstractVarModelWriter {

    private static final List<IVMLWriter> POOL = new ArrayList<IVMLWriter>(); 

    private Stack<Value> nestedValues = new Stack<Value>();

    private Stack<ConstraintSyntaxTree> nestedExpressions = new Stack<ConstraintSyntaxTree>();

    private boolean emitComments = true;
    
    private Stack<Comment> lastComment = new Stack<Comment>();
    
    private java.util.Set<Attribute> handled = new HashSet<Attribute>();
    
    private VariableUsage variableUsage = new VariableUsage();
    
    private boolean formatInitializer = false;
    
    private boolean forceCompoundTypes = false;
    
    private DecisionVariableDeclaration inDecl;
    
    /**
     * Class for writing <code>ivml</code> output appropriate for the EASy-Producer tool.
     * @param writer Writer which should be used for writing the output.
     */
    public IVMLWriter(Writer writer) {
        super(writer);
    }

    /**
     * Creates a writer instance. Due to the pooling mechanism, disabling comments
     * can only be done by a non-pooled subclass.
     *  
     * @param writer the writer which should be used for writing the output
     * @param emitComments whether comments shall be emitted or ignored
     */
    protected IVMLWriter(Writer writer, boolean emitComments) {
        this(writer);
        this.emitComments = emitComments;
    }

    /**
     * Defines whether initializers shall be formatted.
     * 
     * @param formatInitializer <code>true</code> if initializers shall be formatted, 
     *   <code>false</code> else
     */
    public void setFormatInitializer(boolean formatInitializer) {
        this.formatInitializer = formatInitializer;
    }
    
    /**
     * Forces the output of compound types and bypasses the automatic
     * detection.
     * 
     * @param forceCompoundTypes if <code>true</code>, compound types are
     *   always emitted at creation, <code>false</code> else
     */
    public void forceComponundTypes(boolean forceCompoundTypes) {
        this.forceCompoundTypes = forceCompoundTypes;
    }
    
    @Override
    public boolean emitComments() {
        return emitComments;
    }
    
    /**
     * Obtains an instance from the pool (always emitting comments).
     * 
     * @param writer the target output writer
     * @return the instance, to be released by {@link #releaseInstance(IVMLWriter)}
     */
    public static final synchronized IVMLWriter getInstance(Writer writer) {
        IVMLWriter result;
        if (POOL.size() > 0) {
            result = POOL.remove(0);
        } else {
            result = new IVMLWriter(writer);
        }
        result.setWriter(writer);
        return result;
    }

    /**
     * Releases an instance to the pool.
     * 
     * @param writer the instance to be released
     */
    public static final synchronized void releaseInstance(IVMLWriter writer) {
        assert writer.getClass() == IVMLWriter.class;
        writer.setWriter(null);
        writer.emitComments = true; // just to be sure -> ConfigurableIVMLWriter vs. POOL
        writer.lastComment.clear();
        POOL.add(writer);
    }

    @Override
    protected void printDefaultSpace(DefaultSpace location) {
        switch (location) {
        case PROJECT:
            appendOutput(LINEFEED);
            appendOutput(LINEFEED);
            break;
        default:
            break;
        }
    }

    @Override
    protected void startWritingProject(Project project) {
        if (emitComments) {
            Comment comment = project.getNestedComment(project);
            if (null != comment) {
                appendOutput(comment.getName());
            }
        }
        appendOutput(PROJECT);
        appendOutput(WHITESPACE);
        appendOutput(project.getName());
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
    }

    @Override
    protected void endWritingProject(Project project) {
        appendOutput(ENDING_BLOCK);
        appendOutput(LINEFEED);
    }

    @Override
    protected void processVersion(Version version) {
        appendIndentation();
        appendOutput(VERSION);
        appendOutput(WHITESPACE);
        appendOutput(VERSION_START);
        appendOutput(version.getVersion());
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitProject(Project project) {
        project.accept(variableUsage);
        super.visitProject(project);
        variableUsage.clear();
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        appendIndentation();
        if (pImport.isConflict()) {
            appendOutput(CONFLICTS);
        } else {
            appendOutput(IMPORT);
        }
        appendOutput(WHITESPACE);
        appendOutput(pImport.getProjectName());
        if (null != pImport.getInterfaceName() && pImport.getInterfaceName().length() > 0) {
            appendOutput(NAMESPACE_SEPARATOR);
            appendOutput(pImport.getInterfaceName());
        }
        IVersionRestriction restriction = pImport.getVersionRestriction();
        if (null != restriction) {
            appendOutput(WHITESPACE);
            appendOutput(WITH);
            appendOutput(WHITESPACE);
            appendOutput(restriction.toSpecification());
        }
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    protected void startWritingCompound(Compound compound) {
        if (compound.isAbstract()) {
            appendOutput(ABSTRACT);
            appendOutput(WHITESPACE);
        }
        appendOutput(COMPOUND);
        appendOutput(WHITESPACE);
        appendOutput(compound.getName());
        appendOutput(WHITESPACE);
        if (null != compound.getRefines()) {
            appendOutput(REFINES);
            appendOutput(WHITESPACE);
            appendOutput(compound.getRefines().getUniqueName());
            appendOutput(WHITESPACE);
        }
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);
    }

    @Override
    protected void endWritingCompound(Compound compound) {
        appendOutput(ENDING_BLOCK);
        appendOutput(LINEFEED + LINEFEED);
    }
    
    /**
     * Method for visiting an enum.
     * 
     * @param eenum The enum which should be visited.
     */
    public void visitEnum(Enum eenum) {
        appendIndentation();
        appendOutput(ENUM);
        appendOutput(WHITESPACE);
        appendOutput(eenum.getName());
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
        
        //Writing first literals
        for (int i = 0; i < eenum.getLiteralCount(); i++) {
            if (i > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            appendOutput(eenum.getLiteral(i).getName());
            if (eenum.isOrdered()) {
                appendOutput(WHITESPACE);
                appendOutput(ASSIGNMENT);
                appendOutput(WHITESPACE);
                appendOutput(String.valueOf(eenum.getLiteral(i).getOrdinal()));
            }
        }
        //Nested EnumLiteral
        appendOutput(ENDING_BLOCK);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }
    
    @Override
    public void visitEnumValue(EnumValue value) {
        appendOutput(IvmlDatatypeVisitor.getUniqueType(value.getType()));
        appendOutput(ENUM_ACCESS);
        appendOutput(value.getValue().getName());
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        appendIndentation();
        emitDecisionVariableDeclarationExpression(decl, null);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }
    
    /**
     * Emits the expression part of a variable declaration without the statement part.
     * 
     * @param decl the declaration to be emitted
     * @param defaultValue an explicitly given default value that supersedes the one of <code>decl</code> 
     *   (may be <b>null</b> to force the one given by <code>decl</code>)
     */
    private void emitDecisionVariableDeclarationExpression(DecisionVariableDeclaration decl, 
        ConstraintSyntaxTree defaultValue) {
        inDecl = decl;
        appendOutput(IvmlDatatypeVisitor.getUniqueType(decl.getType()));
        appendOutput(WHITESPACE);
        appendOutput(decl.getName());
        
        //If the default value = null, Semicolon and line feed will be added
        ConstraintSyntaxTree dflt = defaultValue;
        if (null == dflt) {
            dflt = decl.getDefaultValue();
        }
        if (null != dflt) {
            appendOutput(WHITESPACE);
            appendOutput(ASSIGNMENT);
            appendOutput(WHITESPACE);
            dflt.accept(this);
        } 
        inDecl = null;
    }
    
    @Override
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        if (null != val) {
            appendOutput(QUOTES);
            appendOutput(val);
            appendOutput(QUOTES);
        }
    }
    
    /**
     * Emits the type of an initializer if required. Considers {@link #forceCompoundTypes},
     * {@link #nestedValues} and {@link #nestedExpressions}.
     * 
     * @param type the actual type of the element
     * @param considerValues whether {@link #nestedValues} or {@link #nestedExpressions} shall be considered
     */
    private void emitType(IDatatype type, boolean considerValues) {
        IDatatype implicitType = null;
        if (!forceCompoundTypes) {
            if (considerValues) {
                if (!nestedValues.isEmpty()) {
                    Value top = nestedValues.peek();
                    if (top instanceof ContainerValue) {
                        Container container = (Container) ((ContainerValue) top).getType();
                        implicitType = container.getContainedType();
                    }
                }
            } else if (!nestedExpressions.isEmpty()) {
                ConstraintSyntaxTree top = nestedExpressions.peek();
                if (top instanceof ContainerInitializer) {
                    Container container = ((ContainerInitializer) top).getType();
                    implicitType = container.getContainedType();
                }
            }
            if (null == implicitType && null != inDecl) {
                implicitType = inDecl.getType();
            }
        }
        if (forceCompoundTypes || (null != implicitType && !implicitType.equals(type))) {
            appendOutput(IvmlDatatypeVisitor.getUniqueType(type));
            appendOutput(WHITESPACE);
        }
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        emitType(value.getType(), true);
        /*if (!nestedValues.isEmpty()) {
            Value containing = nestedValues.peek();
            if (containing instanceof ContainerValue) {
                Container container = (Container) ((ContainerValue) containing).getType();
                IDatatype containedType = container.getContainedType();
                IDatatype thisType = value.getType();
                if (forceCompoundTypes || !containedType.equals(thisType)) { // equals is not really defined
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(thisType));
                    appendOutput(WHITESPACE);
                }
            }
        }*/
/*
 
        if (!nestedExpressions.isEmpty()) {
            ConstraintSyntaxTree containing = nestedExpressions.peek();
            if (containing instanceof ContainerInitializer) {
                Container container = ((ContainerInitializer) containing).getType();
                IDatatype containedType = container.getContainedType();
                IDatatype thisType = initializer.getType();
                if (forceCompoundTypes || !containedType.equals(thisType)) { // equals is not really defined
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(thisType));
                    appendOutput(WHITESPACE);
                }
            }
        }
         
         
         
 */
        nestedValues.push(value);
        appendOutput(BEGINNING_BLOCK);
        if (formatInitializer) {
            appendOutput(LINEFEED);
            addParent(DUMMY_PARENT);
        }
        int count = 0;
        Compound comp = (Compound) value.getType();
        while (null != comp) {
            count = visitCompoundDecisionVariableContainer(comp, value, count);
            comp = comp.getRefines();
        }
        if (formatInitializer) {
            removeLastParent();
            appendOutput(LINEFEED);
            appendIndentation();
        }
        appendOutput(ENDING_BLOCK);
        nestedValues.pop();
    }
    
    /**
     * Returns whether a certain value shall be written.
     * 
     * @param value the value to be checked
     * @return <code>true</code> if the value shall be written, <code>false</code> else
     */
    protected boolean writeValue(Value value) {
        return true;
    }
    
    /**
     * Visits a compound decision variable container for output of configuration values.
     * 
     * @param cont the container
     * @param value the container value
     * @param printed the number of printed elements so far
     * @return the number of printed elements
     */
    private int visitCompoundDecisionVariableContainer(IDecisionVariableContainer cont, CompoundValue value, 
        int printed) {
        for (int e = 0; e < cont.getElementCount(); e++) {
            // be careful with null values -> writing partial configurations
            String name = cont.getElement(e).getName();
            Value nestedValue = value.getNestedValue(name);
            if (null != nestedValue && writeValue(nestedValue)) {
                if (printed > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
                    if (formatInitializer) {
                        appendOutput(LINEFEED);
                    }
                }
                if (formatInitializer) {
                    appendIndentation();
                }
                appendOutput(name);
                appendOutput(WHITESPACE);
                appendOutput(ASSIGNMENT);
                appendOutput(WHITESPACE);
                nestedValue.accept(this);
                printed++;
            }
        }
        for (int a = 0; a < cont.getAssignmentCount(); a++) {
            printed = visitCompoundDecisionVariableContainer(cont.getAssignment(a), value, printed);
        }
        return printed;
    }

    @Override
    public void visitIntValue(IntValue value) {
        Integer val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());    
        }
    }

    @Override
    public void visitRealValue(RealValue value) {
        Double val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());
        }
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        Boolean val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        nestedValues.push(value);
        appendOutput(BEGINNING_BLOCK);
        if (formatInitializer && value.getElementSize() > 0) {
            appendOutput(LINEFEED);
            addParent(DUMMY_PARENT);
            appendIndentation();
        }
        for (int i = 0; i < value.getElementSize(); i++) {
            if (i > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            value.getElement(i).accept(this);
        }
        if (formatInitializer && value.getElementSize() > 0) {
            removeLastParent();
            appendOutput(LINEFEED);
            appendIndentation();
        }
        appendOutput(ENDING_BLOCK);
        nestedValues.pop();
    }
    
    /**
     * Visits a compound initializer.
     * 
     * @param initializer the compound initializer node
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        emitType(initializer.getType(), false);
        /*if (!nestedExpressions.isEmpty()) {
            ConstraintSyntaxTree containing = nestedExpressions.peek();
            if (containing instanceof ContainerInitializer) {
                Container container = ((ContainerInitializer) containing).getType();
                IDatatype containedType = container.getContainedType();
                IDatatype thisType = initializer.getType();
                if (forceCompoundTypes || !containedType.equals(thisType)) { // equals is not really defined
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(thisType));
                    appendOutput(WHITESPACE);
                }
            }
        }*/
        nestedExpressions.push(initializer);
        appendOutput(BEGINNING_BLOCK);
        if (formatInitializer) {
            appendOutput(LINEFEED);
            addParent(DUMMY_PARENT);
            appendIndentation();
        }
        for (int e = 0; e < initializer.getSlotCount(); e++) {
            if (e > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
                if (formatInitializer) {
                    appendOutput(LINEFEED);
                }
            }
            if (formatInitializer) {
                appendIndentation();
            }
            appendOutput(initializer.getSlot(e));
            appendOutput(WHITESPACE);
            appendOutput(ASSIGNMENT);
            appendOutput(WHITESPACE);
            initializer.getExpression(e).accept(this);
        }
        if (formatInitializer) {
            removeLastParent();
            appendOutput(LINEFEED);
            appendIndentation();
        }
        appendOutput(ENDING_BLOCK);
        nestedExpressions.pop();
    }

    /**
     * Visits a container initializer.
     * 
     * @param initializer the container initializer node
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        nestedExpressions.push(initializer);
        appendOutput(BEGINNING_BLOCK);
        if (formatInitializer && initializer.getExpressionCount() > 0) {
            appendOutput(LINEFEED);
            addParent(DUMMY_PARENT);
            appendIndentation();
        }
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            ConstraintSyntaxTree expr = initializer.getExpression(i);
            if (i > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            expr.accept(this);
        }
        if (formatInitializer && initializer.getExpressionCount() > 0) {
            removeLastParent();
            appendOutput(LINEFEED);
            appendIndentation();
        }
        appendOutput(ENDING_BLOCK);
        nestedExpressions.pop();
    }


    @Override
    public void visitAttribute(Attribute attribute) {
        if (handled.contains(attribute)) {
            handled.remove(attribute);
        } else {
            appendIndentation();
            appendOutput(ATTRIBUTE);
            appendOutput(WHITESPACE);
            appendOutput(IvmlDatatypeVisitor.getUniqueType(attribute.getType()));
            appendOutput(WHITESPACE);
            appendOutput(attribute.getName());
            appendOutput(WHITESPACE);
            ConstraintSyntaxTree defltCst = attribute.getDefaultValue(); 
            if (null != defltCst) {
                appendOutput(ASSIGNMENT);
                appendOutput(WHITESPACE);
                defltCst.accept(this);
                appendOutput(WHITESPACE);
            }
            appendOutput(TO);
            appendOutput(WHITESPACE);
            appendOutput(attribute.getElement().getName());
            for (int a = 0; a < attribute.getSeriesCount(); a++) {
                Attribute attr = attribute.getSeries(a);
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
                appendOutput(attr.getElement().getName());
                handled.add(attr);
            }
            appendOutput(SEMICOLON);
            appendOutput(LINEFEED);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        appendIndentation();
        appendOutput(FREEZE);
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);
        addParent(freeze);
        for (int f = 0; f < freeze.getFreezableCount(); f++) {
            IFreezable freezable = freeze.getFreezable(f);
            beforeNestedElement(freezable);
            appendIndentation();
            if (freezable instanceof CompoundAccessStatement) {
                freezable.accept(this);
            } else {
                if (freezable.getParent() instanceof Compound) {
                    appendOutput(freezable.getParent().getName());
                    appendOutput(COMPOUND_ACCESS);
                }
                appendOutput(freezable.getName());
            }
            appendOutput(SEMICOLON);
            appendOutput(LINEFEED);
        }
        removeLastParent();
        appendIndentation();
        appendOutput(ENDING_BLOCK);
        int butCount = freeze.getButCount();
        if (butCount > 0) {
            appendOutput(WHITESPACE);
            appendOutput(BUT);
            appendOutput(WHITESPACE);
            appendOutput(BEGINNING_PARENTHESIS);
            for (int b = 0; b < butCount; b++) {
                if (b > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
                }
                appendOutput(freeze.getBut(b));
            }
            appendOutput(ENDING_PARENTHESIS);
        }
        appendOutput(LINEFEED);
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        appendIndentation();
        CustomOperation op = opdef.getOperation();
        appendOutput(DEF);
        appendOutput(WHITESPACE);
        appendOutput(IvmlDatatypeVisitor.getUniqueType(op.getReturns()));
        appendOutput(WHITESPACE);
        appendOutput(opdef.getName());
        appendOutput(BEGINNING_PARENTHESIS);
        int paramSize = op.getParameterCount();
        for (int p = 0; p < paramSize; p++) {
            if (p > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            emitDecisionVariableDeclarationExpression(op.getParameterDeclaration(p), null);
        }
        appendOutput(ENDING_PARENTHESIS);
        appendOutput(WHITESPACE);
        appendOutput(OPDEF_SEPARATOR);
        appendOutput(WHITESPACE);
        op.getFunction().accept(this);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        appendIndentation();
        appendOutput(EVAL);
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);
        super.visitPartialEvaluationBlock(block);
        appendIndentation();
        appendOutput(ENDING_BLOCK);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        appendIndentation();
        appendOutput(INTERFACE);
        appendOutput(WHITESPACE);
        appendOutput(iface.getName());
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);
        addParent(iface);
        for (int e = 0; e < iface.getExportsCount(); e++) {
            DecisionVariableDeclaration export = iface.getExport(e);
            appendIndentation();
            appendOutput(EXPORT);
            appendOutput(WHITESPACE);
            if (needsQualification(export)) {
                appendOutput(export.getQualifiedName());
            } else {
                appendOutput(export.getName());
            }
            appendOutput(SEMICOLON);
            appendOutput(LINEFEED);
        }
        removeLastParent();
        appendIndentation();
        appendOutput(ENDING_BLOCK);
        // lueder: refering to the ivml lang. spec. (p.29) the semicolon is not needed
        // HE: doesn't matter as we accept both but change may break dependent tests - please ask before changing!!!
        appendOutput(LINEFEED);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        appendIndentation();
        appendOutput(TYPEDEF);
        appendOutput(WHITESPACE);
        appendOutput(datatype.getName());
        appendOutput(WHITESPACE);
        appendOutput(IvmlDatatypeVisitor.getUniqueType(datatype.getBasisType()));
        int cCount = datatype.getConstraintCount();
        if (0 != cCount) {
            appendOutput(WHITESPACE);
            appendOutput(WITH);
            appendOutput(WHITESPACE);
            appendOutput(BEGINNING_PARENTHESIS);
            for (int c = 0; c < cCount; c++) {
                if (c > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
                }
                ConstraintSyntaxTree cst = datatype.getConstraint(c).getConsSyntax();
                if (null != cst) {
                    cst.accept(this); // call directly so that ";\n\r" is not emitted
                }
            }
            appendOutput(ENDING_PARENTHESIS);
        }
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        appendOutput(literal.getName());
        // no indentation, no semicolon - this is part of a CST!
    }
    
    @Override
    public void visitReference(Reference reference) {
    }

    @Override
    public void visitSequence(Sequence sequence) {
        appendIndentation();
        appendOutput(SEQUENCEOF);
        appendOutput(BEGINNING_PARENTHESIS);
        appendOutput(sequence.getContainedType().getName());
        appendOutput(ENDING_PARENTHESIS);
        appendOutput(WHITESPACE);
        appendOutput(sequence.getName());
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitSet(Set set) {
        appendIndentation();
        appendOutput(SETOF);
        appendOutput(BEGINNING_PARENTHESIS);
        appendOutput(set.getContainedType().getName());
        appendOutput(ENDING_PARENTHESIS);
        appendOutput(WHITESPACE);
        appendOutput(set.getName());
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        appendOutput(REFBY);
        appendOutput(BEGINNING_PARENTHESIS);
        AbstractVariable referenced = referenceValue.getValue();
        if (null != referenced) {
            appendOutput(referenced.getName());
        }
        appendOutput(ENDING_PARENTHESIS);
    }
    
    /**
     * Determines whether (on-demand) qualification of the given <code>var</code> is needed,
     * i.e., whether its qualified name shall be printed out.
     * 
     * @param var the variable
     * @return <code>true</code> if it needs to be qualified, <code>false</code> else
     */
    private boolean needsQualification(AbstractVariable var) {
        boolean found = false;
        String name = var.getName();
        for (int p = getParentCount() - 1; !found && p > 0; p--) {
            IModelElement par = getParent(p);
            if (par instanceof IDecisionVariableContainer) {
                IDecisionVariableContainer cont = (IDecisionVariableContainer) par;
                DecisionVariableDeclaration elt = cont.getElement(name);
                // using the simple name would point to the wrong variable
                found = (null != elt && elt.getName().equals(name) && var != elt);
            }
        }
        if (!found) {
            Project underVisiting = getParent(Project.class);
            if (var.getTopLevelParent() != underVisiting) {
                found = variableUsage.needsQualification(var);
            }
        }
        return found;
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable var = variable.getVariable();
        /*if (var instanceof Attribute) {
            Attribute attribute = (Attribute) var;
            appendOutput(attribute.getElement().getName());
            appendOutput(".");
        }*/
        boolean needsFqn = false;
        if (null != variable.getQualifier()) {
            variable.getQualifier().accept(this);
            appendOutput(".");
        } else {
            needsFqn = needsQualification(variable.getVariable()); 
        }
        if (needsFqn) {
            appendOutput(var.getQualifiedName());
        } else {
            appendOutput(var.getName());
        }
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        appendOutput(BEGINNING_PARENTHESIS);
        parenthesis.getExpr().accept(this);
        appendOutput(ENDING_PARENTHESIS);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        FormattingHint hint;
        Operation resolved = call.getResolvedOperation();
        if (null != resolved) {
            hint = resolved.getFormattingHint();
        } else {
            hint = FormattingHint.FUNCTION_CALL;
        }
        String name = call.getOperation();
        switch (hint) {
        case FUNCTION_CALL:
            if (OclKeyWords.INDEX_ACCESS.equals(name) && 1 == call.getParameterCount()) {
                call.getOperand().accept(this);
                appendOutput("[");
                call.getParameter(0).accept(this);
                appendOutput("]");
            } else {
                appendOutput(name);
                appendOutput("(");
                ConstraintSyntaxTree operand = call.getOperand();
                if (null != operand) {
                    operand.accept(this);
                }
                if (call.getParameterCount() > 0) {
                    for (int p = 0; p < call.getParameterCount(); p++) {
                        if (null != operand || (null == operand && p > 0)) {
                            appendOutput(",");
                        }
                        appendOutput(WHITESPACE);
                        call.getParameter(p).accept(this);
                    }
                }
                appendOutput(")");
            }
            break;
        case OPERATOR_INFIX:
            call.getOperand().accept(this);
            for (int p = 0; p < call.getParameterCount(); p++) {
                appendOutput(WHITESPACE);
                appendOutput(name);
                appendOutput(WHITESPACE);
                call.getParameter(p).accept(this);
            }
            break;
        case OPERATOR_PREFIX:
            appendOutput(name);
            appendOutput(WHITESPACE);
            call.getOperand().accept(this);
            // it is ensured that there are no more parameters
            break;
        case OPERATOR_POSTFIX:
            call.getOperand().accept(this);
            appendOutput(name);
            // it is ensured that there are no more parameters
            break;
        default:
            // should not occur
            break;
        }
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        appendIndentation();
        super.visitConstraint(constraint);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }
    
    @Override
    public void visitLet(Let let) {
        // no indentation, no semicolon - this is part of a CST!
        appendOutput(LET);
        appendOutput(WHITESPACE);
        emitDecisionVariableDeclarationExpression(let.getVariable(), let.getInitExpression());
        appendOutput(WHITESPACE);
        appendOutput(IN);
        appendOutput(WHITESPACE);
        let.getInExpression().accept(this);
        // no indentation, no semicolon - this is part of a CST!
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // no indentation, no semicolon - this is part of a CST!
        appendOutput(IF);
        appendOutput(WHITESPACE);
        ifThen.getIfExpr().accept(this);
        appendOutput(WHITESPACE);
        appendOutput(THEN);
        appendOutput(WHITESPACE);
        ifThen.getThenExpr().accept(this);
        appendOutput(WHITESPACE);
        appendOutput(ELSE);
        appendOutput(WHITESPACE);
        ifThen.getElseExpr().accept(this);
        appendOutput(WHITESPACE);
        appendOutput(ENDIF);
        // no indentation, no semicolon - this is part of a CST!
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        appendOutput(CONTAINER_OP_ACCESS);
        appendOutput(call.getOperation());
        appendOutput(BEGINNING_PARENTHESIS);
        IDatatype contained;
        try {
            Container cont = (Container) DerivedDatatype.resolveToBasis(call.getContainer().inferDatatype());
            contained = cont.getContainedType();
        } catch (CSTSemanticException e) {
            contained = AnyType.TYPE; // just to be safe, let's see
        }
        int declCount = call.getDeclaratorsCount();
        for (int d = 0; d < declCount; d++) {
            DecisionVariableDeclaration decl = call.getDeclarator(d);
            ConstraintSyntaxTree deflt = decl.getDefaultValue();
            // this is a bit strange but matches the OCL/IVML grammar
            ConstraintSyntaxTree next = d + 1 >= declCount ? null : call.getDeclarator(d + 1).getDefaultValue();
            appendOutput(decl.getName());
            if (!decl.getType().isAssignableFrom(contained)) {
                appendOutput(WHITESPACE);
                appendOutput(COLON);
                appendOutput(WHITESPACE);
                appendOutput(IvmlDatatypeVisitor.getUniqueType(decl.getType()));
            }
            if (null != deflt && deflt != next) {
                appendOutput(WHITESPACE);
                appendOutput(ASSIGNMENT);
                appendOutput(WHITESPACE);
                decl.getDefaultValue().accept(this);
            }
            if (d < declCount - 1) {
                if (null == deflt && null != next) {
                    // if next has a different default
                    appendOutput(SEMICOLON);
                } else {
                    appendOutput(COMMA);
                }
            }
        }
        appendOutput(PIPE);
        call.getExpression().accept(this);
        appendOutput(ENDING_PARENTHESIS);
    }
    
    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        appendOutput(COMPOUND_ACCESS);
        appendOutput(access.getSlotName());
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        appendOutput(IvmlDatatypeVisitor.getUniqueType(value.getValue()));
    }

    @Override
    public void visitNullValue(NullValue value) {
        appendOutput(NULL);
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        dupLastComment(); // actually not needed as no nested compounds may be defined -> example
        appendIndentation();
        appendOutput(ASSIGN);
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_PARENTHESIS);
        for (int d = 0; d < assignment.getAssignmentDataCount(); d++) {
            if (d > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            Assignment data = assignment.getAssignmentData(d);
            appendOutput(data.getName());
            appendOutput(WHITESPACE);
            appendOutput(data.getOperation());
            appendOutput(WHITESPACE);
            data.getExpression().accept(this);
        }
        appendOutput(ENDING_PARENTHESIS);
        appendOutput(WHITESPACE);
        appendOutput(TO);
        appendOutput(WHITESPACE);
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);
        super.visitAttributeAssignment(assignment);
        appendIndentation();
        appendOutput(ENDING_BLOCK);
        appendOutput(LINEFEED);
        popLastComment(); // actually not needed as no nested compounds may be defined -> example
    }
    
    @Override
    public void visitComment(Comment comment) {
        if (emitComments) {
            String text = comment.getName(); // this is the comment text!
            if (null != text) {
                appendOutput(text);
            }
            setLastComment(comment);
        }
    }
    
    @Override
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
        String text = comment.getComment();
        if (null != text) {
            appendOutput(text);
        }
        comment.getExpr().accept(this);
    }
    
    @Override
    protected void beforeNestedElement(Object element) {
        Comment lastComment = getLastComment();
        if (null != lastComment) {
            Comment nestedComment = lastComment.getComment(element);
            if (null != nestedComment) {
                // no accept here -> lastComment
                String name = nestedComment.getName();
                if (null != name) {
                    appendOutput(name);
                }
            }
        }
    }
    
    @Override
    public void visitCompound(Compound compound) {
        dupLastComment(); // actually not needed as no nested compounds may be defined -> example
        super.visitCompound(compound);
        popLastComment(); // actually not needed as no nested compounds may be defined -> example
    }
    
    /**
     * Returns the last comment from the internal comment stack.
     * 
     * @return the last comment
     */
    private Comment getLastComment() {
        Comment result = null;
        if (emitComments && !lastComment.isEmpty()) {
            result = lastComment.peek();
        }
        return result;
    }

    /**
     * Duplicates the last comment on the stack for nesting.
     */
    private void dupLastComment() {
        if (emitComments && !lastComment.isEmpty()) {
            lastComment.push(lastComment.peek());
        }
    }

    /**
     * Removes the comment on top of the stack.
     * 
     * @return the comment which was on the top of the stack before this
     *   operation
     */
    private Comment popLastComment() {
        Comment result = null;
        if (emitComments && !lastComment.isEmpty()) {
            result = lastComment.pop();
        }
        return result;
    }
    
    /**
     * Defines the next comment on top of the stack (combined pop/push).
     * 
     * @param comment the new comment to be on the top of the stack
     */
    private void setLastComment(Comment comment) {
        if (emitComments) {
            if (!lastComment.isEmpty()) {
                lastComment.pop();
            }
            lastComment.push(comment);
        }        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        AbstractVariable var = access.getCompoundVariable();
        if (needsQualification(var)) {
            appendOutput(var.getQualifiedName());
        } else {
            appendOutput(var.getName());
        }
        appendOutput(COMPOUND_ACCESS);
        appendOutput(access.getSlotName());
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        String tmp = Version.toString(value.getValue());
        if (tmp.length() > 0) {
            // add the version marker
            tmp = "v" + tmp;
        }
        appendOutput(tmp);
    }

    @Override
    public void visitSelf(Self self) {
        appendOutput(SELF);
    }
    
}
