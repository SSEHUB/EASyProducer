package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.Writer;

import de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls.OCLFeatureTranslationFactory;
import de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls.TranslationFragment;
import net.ssehub.easy.reasonerCore.model.ConstraintPattern;
import net.ssehub.easy.reasonerCore.model.ReasonerModel;
import net.ssehub.easy.reasonerCore.model.ReasoningOperation;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Abstract superclass for constraint translators.
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class AbstractConstraintTranslator extends AbstractModelTranslator implements IConstraintTreeVisitor {

    protected static final String GET_VALUE = ".getValue()";
    protected static final String SET_VALUE = ".setValue";
    
    protected ReasoningOperation operation;
    protected int index;
    protected ConstraintSyntaxTree constraint;
    protected ConstraintPattern cstPattern;
    protected boolean valueAccess;    
    protected boolean isAssignmentOperand;
    protected boolean isPropagationPosition;
    
    // Used in ImpliesHandler
    private boolean isImpliesOperand;
    
    
    /**
     * Internal Translator for translating a value depending on its {@link IDatatype}.
     * @author El-Sharkawy
     * @author Sizonenko
     *
     */
    private class ValueTranslator implements IDatatypeVisitor {
        private Value value;
        
        /**
         * Sole constructor, translates the value and adds the output to the surrounding
         * {@link AbstractConstraintTranslator}.
         * @param value The Value to be translated.
         * @see AbstractConstraintTranslator#visitConstantValue(ConstantValue)
         */
        private ValueTranslator(Value value) {
            this.value = value;
            value.getType().accept(this);
        }
        
        /**
         * Creates a value expression for variables storing a primitive data type.
         */
        private void handlePrimitiveType() {
            append(value.getValue().toString());                
        }
        
        @Override
        public void visitStringType(StringType type) {
            append("\"");
            append(value.getValue().toString());
            append("\"");
        }        
        
        @Override
        public void visitSet(net.ssehub.easy.varModel.model.datatypes.Set set) {
            // FIXME SE: No idea how to handle container values...
        }
        
        @Override
        public void visitSequence(Sequence sequence) {
            // FIXME SE: No idea how to handle container values...
        }
        
        @Override
        public void visitReference(Reference reference) {
            ReferenceValue refValue = (ReferenceValue) value;
            append("\"");
            //TODO SE: Check whether getName or QualifiedName should be used.
            append(refValue.getValue().getName()); // may be null -> getValueEx
            append("\"");
        }
        
        @Override
        public void visitRealType(RealType type) {
            handlePrimitiveType();
        }
        
        @Override
        public void visitOrderedEnumType(OrderedEnum enumType) {
            visitEnumType(enumType);
        }
        
        @Override
        public void visitMetaType(MetaType datatype) {
            // Solution for qualified names inside compounds.
            MetaTypeValue metaValue = (MetaTypeValue) value;
            append("$");
            append(metaValue.getValue().getName());
        }
        
        @Override
        public void visitIntegerType(IntegerType type) {
            handlePrimitiveType();
        }
        
        @Override
        public void visitEnumType(Enum enumType) {
            EnumValue enumValue = (EnumValue) value;
            append(Integer.toString(enumValue.getValue().getOrdinal()));
        }
        
        @Override
        public void visitDerivedType(DerivedDatatype datatype) {
            datatype.getBasisType().accept(this);
        }
        
        @Override
        public void visitDatatype(IDatatype datatype) {
            // Not needed
        }
        
        @Override
        public void visitCompoundType(Compound compound) {
            // TODO no idea how to handle compound values
        }
        
        @Override
        public void visitBooleanType(BooleanType type) {
            handlePrimitiveType();
        }
        
        @Override
        public void visitAnyType(AnyType datatype) {
            // TODO unclear whether we need this
        }

        @Override
        public void visitConstraintType(ConstraintType type) {
            // TODO unclear whether we need this            
        }

        @Override
        public void visitVersionType(VersionType type) {
            // currently no attribute / variable can have this type
        }        
    }
    
    /**
     * Sole constructor for this class.
     * The <tt>constraint.accept(...)</tt> method must be called from the concrete sub class, because the individual
     * preamble must be written before.
     * @param model The {@link ReasonerModel}, which should be translated (must not be <tt>null</tt>).
     * @param writer The writer where the output shall be written to (must not be <tt>null</tt>).
     * @param reasoningID The unique ID of the current reasoning process.
     * @param cstType Type of constraint that is translated.
     * @see de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    public AbstractConstraintTranslator(ReasonerModel model, Writer writer, String reasoningID,
        ConstraintPattern cstType) {
        super(model, writer, reasoningID);
        this.valueAccess = true;
        this.cstPattern = cstType; 
        this.isAssignmentOperand = false;
        this.isImpliesOperand = true;
        this.isPropagationPosition = false;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        new ValueTranslator(value.getConstantValue());
    }

    @Override
    public void visitVariable(Variable variable) { 
        // Implemented in related Translators
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        append("(");
        parenthesis.getExpr().accept(this);
        append(")");
        
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        try {
            TranslationFragment translator = OCLFeatureTranslationFactory.getTranslator(call);
            translator.toDroolsCode(this, call);            
        } catch (CSTSemanticException exc) {
            addException(exc);
        }        
    }

    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        /*
         * Translates the access to:
         * $compoundVar.get("slotName")
         */
        boolean valueAccessBefore = valueAccess;
        valueAccess = false;
        access.getCompoundExpression().accept(this);
        valueAccess = valueAccessBefore;        
        append(".get(\"");        
        append(access.getSlotName());
        append("\")");
        // Needs to be changed to fit translation patterns!
        appendVariableAccess();
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        /*
         * Translate CompoundInitializer as a set of compound accesses:
         *     cmp = {a = 5, b = 7}
         * would be translated to:
         * cmg.get("a").value = 5 && cmp.get("b").value = 7
         */
        
        append("(");
        append(")");        
    }

    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub        
    }
    
    @Override
    public void append(String droolsCode) {
        super.append(droolsCode);
    }
    
    /**
     * Appends a String for returning that a constraint/rule was violated.
     * @param ruleNo The rule number of the violated rule/constraint.
     */
    protected void addFailedRule(int ruleNo) {
        append("    addFailedRule(\"" + getReasoningID() + "\", " + ruleNo + ");");
    }
    
    /**
     * Appends a String for returning that a compound instance contains values
     * violating constraints of the related was compound definition.
     * @param varName The variable name inside of the drools constraint, including the leading
     *     dollar sign, e.g. <tt>$var</tt>.
     */
    protected void addFailedDeclaration(String varName) {
        append("    addFailedDeclaration(\"" + getReasoningID() + "\", " + varName + ".getDeclaration());");
    }
    
    /**
     * Appends a String for returning that a compound instance contains values
     * violating constraints of the related was compound definition.
     * @param varName The variable name inside of the drools constraint, including the leading
     *     dollar sign, e.g. <tt>$var</tt>.
     * @param index Index of failed constraint.  .getDeclaration()  
     */
    protected void addFailedRuleinCompound(String varName, int index) {
        append("    addFailedRuleInCompound(\"" + getReasoningID() + "\", " 
            + varName + "," + " " + index + ");");
    }
    
    /**
     * Getter for the valueAcces attribute.
     * @return <tt>true</tt> if <tt>.value</tt> should be added to the current variable expression,
     *     <tt>false</tt> otherwise.
     */
    protected boolean isValueAccess() {
        return valueAccess;
    }
    
    /**
     * Method for setting an indicator if a variable is an operand in assignment constraint.
     * @param isAssignmentOperand false if not operand.
     */
    public void setIsAssignmentOperand(boolean isAssignmentOperand) {
        this.isAssignmentOperand = isAssignmentOperand;
    } 
    
    /**
     * Method for setting an indicator if a constraint is an operand in implies constraint.
     * @param isImpliesOperand false if not operand.
     */
    public void setIsImpliesOperand(boolean isImpliesOperand) {
        this.isImpliesOperand = isImpliesOperand;
    } 
    
    /**
     * Method for setting reasoning operation.
     * @param operation {@link ReasoningOperation}.
     */
    public void setReasoningOperation(ReasoningOperation operation) {
        this.operation = operation;
    } 
    
    /**
     * Method for getting an indicator if a constraint is an operand in implies constraint.
     * @return false if not operand.
     */
    public boolean getIsImpliesOperand() {
        return this.isImpliesOperand;
    }

    /**
     * Method for runing translation.
     */
    public void translate() {
        // Implemented in relevant translators        
    }

    /**
     * Method to append needed variable access code.
     */
    public void appendVariableAccess() {
        if (operation == ReasoningOperation.VALIDATION) {           
            if (valueAccess 
                &&
                (cstPattern == ConstraintPattern.IMPLIES_VALIDATION 
                || cstPattern == ConstraintPattern.SIMPLE_VALIDATION)) {                
                append(GET_VALUE);                
            } else if (valueAccess 
                &&
                (cstPattern == ConstraintPattern.IMPLIES_ASSIGNMENT 
                || cstPattern == ConstraintPattern.SIMPLE_ASSIGNMENT) 
                &&
                isAssignmentOperand) {                
                append(SET_VALUE);                
            } else if (valueAccess 
                && 
                (cstPattern == ConstraintPattern.IMPLIES_ASSIGNMENT 
                || cstPattern == ConstraintPattern.SIMPLE_ASSIGNMENT) 
                && 
                !isAssignmentOperand) {                
                append(GET_VALUE);
            }        
        } else {
            if (valueAccess 
                &&
                (cstPattern == ConstraintPattern.IMPLIES_VALIDATION 
                || cstPattern == ConstraintPattern.SIMPLE_VALIDATION)
                &&
                !appendGet(isAssignmentOperand, isPropagationPosition)) {                
                append(GET_VALUE);                
            } else if (valueAccess 
                &&
                (cstPattern == ConstraintPattern.IMPLIES_VALIDATION 
                || cstPattern == ConstraintPattern.SIMPLE_VALIDATION)
                &&
                appendGet(isAssignmentOperand, isPropagationPosition)) {
                append(SET_VALUE);                
            } else if (valueAccess 
                &&
                (cstPattern == ConstraintPattern.IMPLIES_ASSIGNMENT 
                || cstPattern == ConstraintPattern.SIMPLE_ASSIGNMENT) 
                &&
                isAssignmentOperand) {                
                append(SET_VALUE);                
            } else if (valueAccess 
                && 
                (cstPattern == ConstraintPattern.IMPLIES_ASSIGNMENT 
                || cstPattern == ConstraintPattern.SIMPLE_ASSIGNMENT) 
                && 
                !isAssignmentOperand) {                
                append(GET_VALUE);
            }        
            
        }
    } 
    
    /**
     * Method for appending result of a fired rule.
     */
    public void appendResult() {
        switch (cstPattern) {
        case SIMPLE_VALIDATION:
            addFailedRule(index);
            break;
        case SIMPLE_ASSIGNMENT:
            addFailedRule(index);
            break;
        case IMPLIES_VALIDATION:
            appendImpliesExtension();
            break;
        case IMPLIES_ASSIGNMENT:
            appendImpliesExtension();
            break;
        default:
            addFailedRule(index);
            break;
        } 
    }
    
    /**
     * Method for appending THEN extension of IMPLIES constraints.
     */
    public void appendImpliesExtension() {
        append("if ( ");
        append(TranslationFragmentFactory.getNegationOpeningInThen(cstPattern));
        constraint.accept(this);
        append(TranslationFragmentFactory.getNegationClosingInThen(cstPattern));
        append(" ) {");
        append(LINEBREAK);
        addFailedRule(index);
        append(LINEBREAK);
        append("}");
    }
    
    /**
     * Method for returning reasoning operation.
     * @return ReasoningOperation.
     */
    public ReasoningOperation getOperation() {
        return operation;        
    }
    
    /**
     * Method for returning constraintType.
     * @return Constraint pattern.
     */
    public ConstraintPattern getConstraintPattern() {
        return cstPattern;
    }
    
    /**
     * Method for returning operation position.
     * @return Operation position.
     */
    public boolean getPropagationPosition() {
        return isPropagationPosition;
    }
    
    /**
     * Method for returning propagation attribute.
     * @param isAssignmentOperand is assignment
     * @param isPropagationPosition is propagation position
     * @return boolean true if propagation needed.
     */
    private boolean appendGet(boolean isAssignmentOperand, boolean isPropagationPosition) {
        return isAssignmentOperand && isPropagationPosition;
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO Check whether specific method is needed
        visitVariable(variable);
    }

}
