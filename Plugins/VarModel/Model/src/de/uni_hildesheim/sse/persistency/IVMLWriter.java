package de.uni_hildesheim.sse.persistency;

import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ASSIGN;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ASSIGNMENT;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ATTRIBUTE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ATTRIBUTE_ACCESS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.BEGINNING_BLOCK;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.BEGINNING_PARENTHESIS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.BUT;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.COLON;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.COMMA;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.COMPOUND;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.COMPOUND_ACCESS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.CONFLICTS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.CONTAINER_OP_ACCESS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.DEF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.DSL_CONTEXT_END;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.DSL_CONTEXT_START;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.DSL_END;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.DSL_START;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ELSE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENDIF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENDING_BLOCK;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENDING_PARENTHESIS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENUM;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENUM_ACCESS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.EVAL;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.EXPORT;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.FREEZE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.IF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.IMPORT;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.IN;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.INTERFACE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.LET;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.LINEFEED;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.NAMESPACE_SEPARATOR;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.NULL;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.OPDEF_SEPARATOR;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.PIPE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.PROJECT;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.QUOTES;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.REFBY;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.REFINES;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.SEMICOLON;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.SEQUENCEOF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.SETOF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.THEN;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.TO;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.TYPEDEF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.VERSION;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.VERSION_START;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.WHITESPACE;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.WITH;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.toText;

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
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
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
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

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
     * {@inheritDoc}
     */
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
            result = POOL.get(0);
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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
        int rCount = pImport.getRestrictionsCount();
        if (rCount > 0) {
            appendOutput(WHITESPACE);
            appendOutput(WITH);
            appendOutput(WHITESPACE);
            appendOutput(BEGINNING_PARENTHESIS);
            for (int r = 0; r < rCount; r++) {
                if (r > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
                }
                VersionRestriction restriction = pImport.getRestriction(r);
                appendOutput(restriction.getName());
                appendOutput(ATTRIBUTE_ACCESS);
                appendOutput(VERSION);
                appendOutput(WHITESPACE);
                appendOutput(toText(restriction.getOperator()));
                appendOutput(WHITESPACE);
                appendOutput(VERSION_START);
                appendOutput(restriction.getVersion().getVersion());
            }
            appendOutput(ENDING_PARENTHESIS);
        }
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    @Override
    protected void startWritingCompound(Compound compound) {
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
    
    /**
     * {@inheritDoc}
     */
    public void visitEnumValue(EnumValue value) {
        appendOutput(IvmlDatatypeVisitor.getUniqueType(value.getType()));
        appendOutput(ENUM_ACCESS);
        appendOutput(value.getValue().getName());
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        appendIndentation();
        emitDecisionVariableDeclarationExpression(decl);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }
    
    /**
     * Emits the expression part of a variable declaration without the statement part.
     * 
     * @param decl the declaration to be emitted
     */
    private void emitDecisionVariableDeclarationExpression(DecisionVariableDeclaration decl) {
        appendOutput(IvmlDatatypeVisitor.getUniqueType(decl.getType()));
        appendOutput(WHITESPACE);
        appendOutput(decl.getName());
        
        //If the default value = null, Semicolon and line feed will be addded
        if (null != decl.getDefaultValue()) {
            appendOutput(WHITESPACE);
            appendOutput(ASSIGNMENT);
            appendOutput(WHITESPACE);
            decl.getDefaultValue().accept(this);
        } 
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitStringValue(StringValue value) {
        String val = value.getValue();
        if (null != val) {
            appendOutput(QUOTES);
            appendOutput(val);
            appendOutput(QUOTES);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundValue(CompoundValue value) {
        if (!nestedValues.isEmpty()) {
            Value containing = nestedValues.peek();
            if (containing instanceof ContainerValue) {
                Container container = (Container) ((ContainerValue) containing).getType();
                IDatatype containedType = container.getContainedType();
                IDatatype thisType = value.getType();
                if (!containedType.equals(thisType)) { // equals is not really defined
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(thisType));
                    appendOutput(WHITESPACE);
                }
            }
        }
        nestedValues.push(value);
        appendOutput(BEGINNING_BLOCK);
        Compound comp = (Compound) value.getType();
        visitCompoundDecisionVariableContainer(comp, value, 0);
        appendOutput(ENDING_BLOCK);
        nestedValues.pop();
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
            if (null != nestedValue) {
                if (printed > 0) {
                    appendOutput(COMMA);
                    appendOutput(WHITESPACE);
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

    /**
     * {@inheritDoc}
     */
    public void visitIntValue(IntValue value) {
        Integer val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());    
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitRealValue(RealValue value) {
        Double val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitBooleanValue(BooleanValue value) {
        Boolean val = value.getValue();
        if (null != val) {
            appendOutput(val.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerValue(ContainerValue value) {
        nestedValues.push(value);
        appendOutput(BEGINNING_BLOCK);
        for (int i = 0; i < value.getElementSize(); i++) {
            if (i > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            value.getElement(i).accept(this);
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
        if (!nestedExpressions.isEmpty()) {
            ConstraintSyntaxTree containing = nestedExpressions.peek();
            if (containing instanceof ContainerInitializer) {
                Container container = ((ContainerInitializer) containing).getType();
                IDatatype containedType = container.getContainedType();
                IDatatype thisType = initializer.getType();
                if (!containedType.equals(thisType)) { // equals is not really defined
                    appendOutput(IvmlDatatypeVisitor.getUniqueType(thisType));
                    appendOutput(WHITESPACE);
                }
            }
        }
        nestedExpressions.push(initializer);
        appendOutput(BEGINNING_BLOCK);
        for (int e = 0; e < initializer.getSlotCount(); e++) {
            if (e > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            appendOutput(initializer.getSlot(e));
            appendOutput(WHITESPACE);
            appendOutput(ASSIGNMENT);
            appendOutput(WHITESPACE);
            initializer.getExpression(e).accept(this);
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
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            if (i > 0) {
                appendOutput(COMMA);
                appendOutput(WHITESPACE);
            }
            initializer.getExpression(i).accept(this);
        }
        appendOutput(ENDING_BLOCK);
        nestedExpressions.pop();
    }


    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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
            if (freezable.getParent() instanceof Compound) {
                appendOutput(freezable.getParent().getName());
                appendOutput(COMPOUND_ACCESS);
            }
            appendOutput(freezable.getName());
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

    /**
     * {@inheritDoc}
     */
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
                appendOutput(COLON);
                appendOutput(WHITESPACE);
            }
            emitDecisionVariableDeclarationExpression(op.getParameterDeclaration(p));
        }
        appendOutput(ENDING_PARENTHESIS);
        appendOutput(WHITESPACE);
        appendOutput(OPDEF_SEPARATOR);
        appendOutput(WHITESPACE);
        op.getFunction().accept(this);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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
            appendIndentation();
            appendOutput(EXPORT);
            appendOutput(WHITESPACE);
            appendOutput(iface.getExport(e).getName());
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        appendOutput(literal.getName());
        // no indentation, no semicolon - this is part of a CST!
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitReferenceValue(ReferenceValue referenceValue) {
        appendOutput(REFBY);
        appendOutput(BEGINNING_PARENTHESIS);
        DecisionVariableDeclaration referenced = referenceValue.getValue();
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
        return found;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        appendOutput(BEGINNING_PARENTHESIS);
        parenthesis.getExpr().accept(this);
        appendOutput(ENDING_PARENTHESIS);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        appendIndentation();
        super.visitConstraint(constraint);
        appendOutput(SEMICOLON);
        appendOutput(LINEFEED);
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        // no indentation, no semicolon - this is part of a CST!
        appendOutput(LET);
        appendOutput(WHITESPACE);
        emitDecisionVariableDeclarationExpression(let.getVariable());
        appendOutput(WHITESPACE);
        appendOutput(IN);
        appendOutput(WHITESPACE);
        let.getInExpression().accept(this);
        // no indentation, no semicolon - this is part of a CST!
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        appendOutput(CONTAINER_OP_ACCESS);
        appendOutput(call.getOperation());
        appendOutput(BEGINNING_PARENTHESIS);
        IDatatype contained;
        try {
            Container cont = (Container) call.getContainer().inferDatatype();
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
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        appendOutput(COMPOUND_ACCESS);
        appendOutput(access.getSlotName());
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        appendOutput(DSL_CONTEXT_START);
        appendOutput("\"");
        appendOutput(fragment.getStop());
        appendOutput("\", \"");
        appendOutput(fragment.getEscape());    
        appendOutput("\", \"");
        appendOutput(fragment.getCommand());
        appendOutput("\"");
        appendOutput(DSL_CONTEXT_END);
        appendOutput(WHITESPACE);
        appendOutput(DSL_START);
        appendOutput(WHITESPACE);
        appendOutput(fragment.getDsl());
        appendOutput(WHITESPACE);
        appendOutput(DSL_END);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitMetaTypeValue(MetaTypeValue value) {
        appendOutput(IvmlDatatypeVisitor.getUniqueType(value.getValue()));
    }

    /**
     * {@inheritDoc}
     */
    public void visitNullValue(NullValue value) {
        appendOutput(NULL);
    }
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        if (emitComments) {
            String text = comment.getName(); // this is the comment text!
            if (null != text) {
                appendOutput(text);
            }
            setLastComment(comment);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(de.uni_hildesheim.sse.model.cst.Comment comment) {
        String text = comment.getComment();
        if (null != text) {
            appendOutput(text);
        }
        comment.getExpr().accept(this);
    }
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
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
    
}
