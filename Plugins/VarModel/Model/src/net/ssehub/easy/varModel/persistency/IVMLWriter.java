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

import static net.ssehub.easy.varModel.model.IvmlKeyWords.ABSTRACT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ASSIGN;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ASSIGNMENT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ATTRIBUTE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.BEGINNING_BLOCK;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.BEGINNING_PARENTHESIS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.BUT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.CONST;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.COMMA;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.COMPOUND;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.COMPOUND_ACCESS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.CONFLICTS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.CONTAINER_OP_ACCESS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.DEF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ELSE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ENDIF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ENDING_BLOCK;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ENDING_PARENTHESIS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ENUM;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.ENUM_ACCESS;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.EVAL;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.EXPORT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.FREEZE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.IF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.INSERT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.IMPORT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.IN;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.INTERFACE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.LET;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.LINEFEED;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.NAMESPACE_SEPARATOR;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.NULL;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.OPDEF_SEPARATOR;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.PIPE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.PROJECT;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.QUOTES;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.REFBY;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.REFINES;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.SEMICOLON;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.SEQUENCEOF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.SETOF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.STATIC;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.THEN;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.TO;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.TYPEDEF;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.VERSION;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.VERSION_START;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.WHITESPACE;
import static net.ssehub.easy.varModel.model.IvmlKeyWords.WITH;
import static net.ssehub.easy.varModel.model.datatypes.OclKeyWords.SELF;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringEscapeUtils;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CSTUtils;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.Operation.FormattingHint;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Writer for writing the variability model to an IVML output file. Please note
 * that this writer creates output regardless of the correctness of the semantics 
 * of the model being visited. However, if the full IVML infrastructure including 
 * the IVML parser is used and given interfaces of this model are used properly, 
 * the output will be valid. In case that the classes in this model package are 
 * directly used from external code, it is strongly advised to use the 
 * {@link net.ssehub.easy.varModel.validation.IvmlValidationVisitor} to check the validity
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
    
    private Stack<OCLFeatureCall> callStack = new Stack<OCLFeatureCall>();

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
        // reset formatting to default
        writer.setIndentationStep(getIvmlIndentStep().length());
        writer.setUseWhitespaces(getUseIvmlWhitespace());
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
            if (pImport.isInsert()) {
                appendOutput(INSERT);
            } else {
                appendOutput(IMPORT);
            }
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
        int rCount = compound.getRefinesCount();
        if (rCount > 0) {
            appendOutput(REFINES);
            appendOutput(WHITESPACE);
            for (int r = 0; r < rCount; r++) {
                if (r > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
                }
                appendOutput(compound.getRefines(r).getUniqueName());
            }
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
        if (considerOclCompliance()) {
            appendOutput(NAMESPACE_SEPARATOR);
        } else {
            appendOutput(ENUM_ACCESS);
        }
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
        if (decl.isConstant()) {
            appendOutput(CONST);
            appendOutput(WHITESPACE);
        }
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
            emitDecisionVariableDeclarationDefault(decl, dflt);
        } 
        inDecl = null;
    }

    /**
     * Emits the default value of a decision variable declaration (for extension).
     * 
     * @param decl the declaration
     * @param defaultValue the specified default value
     */
    protected void emitDecisionVariableDeclarationDefault(DecisionVariableDeclaration decl, 
        ConstraintSyntaxTree defaultValue) {
        setExpressionContext(decl);
        defaultValue.accept(this);
        setExpressionContext(null);
    }
    
    @Override
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        if (null != val) {
            appendOutput(QUOTES);
            appendOutput(StringEscapeUtils.escapeJava(val));
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
                } else if (!callStack.isEmpty()) {
                    // if we have an assignment (top-level op), take the LHS (var) as implicit type
                    ConstraintSyntaxTree top = callStack.peek();
                    if (CSTUtils.isAssignment(top)) {
                        OCLFeatureCall call = (OCLFeatureCall) top; // by spec of isAssignment()
                        try {
                            implicitType = call.getOperand().inferDatatype();
                        } catch (CSTSemanticException e) {
                            getLogger().exception(e); // shall not occur, don't inform the user
                        }
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
        nestedValues.push(value);
        appendOutput(BEGINNING_BLOCK);
        if (formatInitializer) {
            appendOutput(LINEFEED);
            addParent(DUMMY_PARENT);
        }
        visitCompoundRefines((Compound) value.getType(), value, 0, new HashSet<String>());
        if (formatInitializer) {
            removeLastParent();
            appendOutput(LINEFEED);
            appendIndentation();
        }
        appendOutput(ENDING_BLOCK);
        nestedValues.pop();
    }

    /**
     * Calls 
     * {@link #visitCompoundDecisionVariableContainer(IDecisionVariableContainer, CompoundValue, int, java.util.Set)
     * <code>comp</code> and for all its refines.
     * 
     * @param comp the compound
     * @param value the compound value
     * @param count the count
     * @param done already processed (or <b>null</b>)
     * @return the aggregated count
     */
    private int visitCompoundRefines(Compound comp, CompoundValue value, int count, java.util.Set<String> done) {
        count = visitCompoundDecisionVariableContainer(comp, value, count, done);
        for (int r = 0; r < comp.getRefinesCount(); r++) {
            count = visitCompoundRefines(comp.getRefines(r), value, count, done);
        }
        return count;
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
     * @param done already processed slots (may be <b>null</b> if not relevant, modified as a side effect)
     * @return the number of printed elements
     */
    private int visitCompoundDecisionVariableContainer(IDecisionVariableContainer cont, CompoundValue value, 
        int printed, java.util.Set<String> done) {
        for (int e = 0; e < cont.getElementCount(); e++) {
            // be careful with null values -> writing partial configurations
            String name = cont.getElement(e).getName();
            boolean emit;
            if (null == done) {
                emit = true;
            } else {
                emit = !done.contains(name);
                if (emit) {
                    done.add(name);
                }
            }
            if (emit) {
                Value nestedValue = value.getNestedValue(name);
                boolean isAbstract = (null != nestedValue) && nestedValue.getType() instanceof Compound
                    && ((Compound) nestedValue.getType()).isAbstract();
                if (null != nestedValue && !isAbstract && writeValue(nestedValue)) {
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
        }
        for (int a = 0; a < cont.getAssignmentCount(); a++) {
            printed = visitCompoundDecisionVariableContainer(cont.getAssignment(a), value, printed, done);
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
        boolean isConstraintType = ConstraintType.TYPE.isAssignableFrom(initializer.getContainedType());
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
            if (isConstraintType) { // basically the same but allows splits
                emitConstraintExpression(getExpressionContext(), expr);
            } else {
                expr.accept(this);
            }
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
            if (attribute.isDot()) {
                appendOutput(IvmlKeyWords.THIS_PROJECT);
            } else {
                appendOutput(attribute.getElement().getName());
            }
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
        
        DecisionVariableDeclaration iter = freeze.getIter();
        ConstraintSyntaxTree selector = freeze.getSelector();
        if (null != iter && null != selector) {
            appendOutput(WHITESPACE);
            appendOutput(BUT);
            appendOutput(WHITESPACE);
            appendOutput(BEGINNING_PARENTHESIS);
            appendOutput(iter.getName());
            appendOutput(PIPE);
            selector.accept(this);
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
        if (op.isStatic()) {
            appendOutput(STATIC);
            appendOutput(WHITESPACE);
        }
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
            String containerPrefix = "";
            String containerPostfix = "";
            IModelElement iter = referenced.getParent();
            while (iter instanceof DecisionVariableDeclaration 
                && Container.TYPE.isAssignableFrom(((DecisionVariableDeclaration) iter).getType())) {
                containerPrefix = iter.getName() + "[" + containerPrefix;
                containerPostfix += "]";
                iter = iter.getParent();
            }
            appendOutput(containerPrefix + referenced.getName() + containerPostfix);
        } else {
            ConstraintSyntaxTree ex = referenceValue.getValueEx();
            if (null != ex) {
                ex.accept(this);
            }
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
            found = needsQualificationThroughContext(getParent(p), name, var, true);
        }
        if (!found) {
            for (int n = nestedValues.size() - 1; !found && n >= 0; n--) {
                found = needsQualificationThroughContext(nestedValues.get(n).getType(), name, var, false);
            }
            if (found) {
                found = false;
            } else {
                Project underVisiting = getParent(Project.class);
                if (var.getTopLevelParent() != underVisiting) {
                    found = variableUsage.needsQualification(var);
                }
            }
        }
        return found;
    }
    
    /**
     * Returns whether the variable name <code>name</code> of <code>var</code> needs qualification within its context 
     * <code>context</code>.
     * 
     * @param context the context (only considered if {@link IDecisionVariableContainer}
     * @param name the name of the variable to determine qualification need for
     * @param var the variable itself
     * @param exclude whether this call is intended to exclude (<code>true</code>) the qualification of <code>var</code>
     *   or whether it shall search for the existence of <code>name</code> in <code>context</code>(<code>false</code>)
     * @return whether <code>var</code> needs qualification if <code>exclude</code> is <code>true</code> or whether 
     * <code>name</code> was found in <code>context</code> if <code>exclude</code> is <code>false</code>
     */
    private boolean needsQualificationThroughContext(Object context, String name, AbstractVariable var, 
        boolean exclude) {
        boolean found = false;
        if (context instanceof IDecisionVariableContainer) {
            IDecisionVariableContainer cont = (IDecisionVariableContainer) context;
            DecisionVariableDeclaration elt = cont.getElement(name);
            // using the simple name would point to the wrong variable, identical var does not need qualification
            found = (null != elt && elt.getName().equals(name));
            if (exclude) {
                found &= (var != elt);
            }
        }
        return found;
        
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable var = variable.getVariable();
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
    public void visitAnnotationVariable(AttributeVariable variable) {
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        appendOutput(BEGINNING_PARENTHESIS);
        parenthesis.getExpr().accept(this);
        appendOutput(ENDING_PARENTHESIS);
    }
    

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        callStack.push(call);
        FormattingHint hint;
        Operation resolved = call.getResolvedOperation();
        if (null != resolved) {
            hint = resolved.getFormattingHint();
        } else {
            hint = FormattingHint.FUNCTION_CALL;
        }            
        appendOCLFeatureCall(call, hint);
        callStack.pop();
    }
    
    /**
     * Does the formatting of an OCL feature call and allows for overwriting.
     * 
     * @param call the call
     * @param hint the formatting hint for the call
     */
    protected void appendOCLFeatureCall(OCLFeatureCall call, FormattingHint hint) {
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
                        ConstraintSyntaxTree param = call.getParameter(p);
                        if (null != operand || (null == operand && p > 0)) {
                            appendOutput(",");
                        }
                        if (null != param.getName()) {
                            appendOutput(WHITESPACE);
                            appendOutput(param.getName());
                            appendOutput(WHITESPACE);
                            appendOutput("=");
                        }
                        appendOutput(WHITESPACE);
                        param.accept(this);
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
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this); // transparent
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            OCLFeatureCall call = expression.getExpression(e);
            if (0 == e) {
                call.getOperand().accept(this);
                appendOutput(WHITESPACE);
            }
            for (int p = 0; p < call.getParameterCount(); p++) {
                appendOutput(call.getOperation());
                appendOutput(WHITESPACE);
                call.getParameter(p).accept(this);
                if (!(e + 1 == expression.getExpressionCount() && p + 1 == call.getParameterCount())) {
                    // do not emit the very last whitespace
                    appendOutput(WHITESPACE);
                }
            }
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
        int declCount = call.getDeclaratorsCount();
        if (!(1 == declCount && call.getDeclarator(0).isTemporaryDeclarator())) {
            for (int d = 0; d < declCount; d++) {
                DecisionVariableDeclaration decl = call.getDeclarator(d);
                ConstraintSyntaxTree deflt = decl.getDefaultValue();
                IDatatype type = decl.getType();
                // this is a bit strange but matches the OCL/IVML grammar
                ConstraintSyntaxTree next;
                IDatatype nextType;
                if (d + 1 >= declCount) {
                    next = null;
                    nextType = null;
                } else {
                    DecisionVariableDeclaration nextDecl = call.getDeclarator(d + 1);
                    next = nextDecl.getDefaultValue();
                    nextType = nextDecl.getType();
                }
                if (decl.isDeclaratorTypeExplicit()) {
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(decl.getType()));
                    appendOutput(WHITESPACE);
                }
                appendOutput(decl.getName());
                if (null != deflt && deflt != next) {
                    appendOutput(WHITESPACE);
                    appendOutput(ASSIGNMENT);
                    appendOutput(WHITESPACE);
                    decl.getDefaultValue().accept(this);
                }
                if (d < declCount - 1) {
                    if ((null == deflt && null != next) || (nextType != null && type != nextType)) {
                        // if next has a different default
                        appendOutput(SEMICOLON);
                    } else {
                        appendOutput(COMMA);
                    }
                }
            }
            appendOutput(PIPE);
            call.getExpression().accept(this);
        } else {
            // else implicitly classified
            if (call.getExpression() instanceof CompoundAccess) {
                CompoundAccess ca = (CompoundAccess) call.getExpression();
                appendOutput(ca.getSlotName());
            }
        }
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
    public void visitComment(net.ssehub.easy.varModel.cst.Comment comment) {
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
    
    @Override
    public void visitBlockExpression(BlockExpression block) {
        appendOutput(BEGINNING_BLOCK);
        appendOutput(LINEFEED);

        increaseAdditionalIndentation();
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            appendIndentation();
            block.getExpression(e).accept(this);
            appendOutput(SEMICOLON);
            appendOutput(LINEFEED);
        }
        decreaseAdditionalIndentation();
        
        appendIndentation();
        appendOutput(ENDING_BLOCK);
    }

}
