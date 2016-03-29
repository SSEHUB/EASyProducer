package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.Writer;

import net.ssehub.easy.reasonerCore.model.ConstraintPatternFactory;
import net.ssehub.easy.reasonerCore.model.ReasonerModel;
import net.ssehub.easy.reasonerCore.model.datatypes.CompoundType;
import net.ssehub.easy.reasonerCore.model.variables.CompoundVariable;
import net.ssehub.easy.reasonerCore.model.variables.ReasonerVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;

/**
 * Translates the constraints of a compound into Drools specific code.
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class CompoundConstraintTranslator extends AbstractConstraintTranslator {

    private String variableName;
    private String cmpName;
    private Compound type;
    private boolean isCompoundConstraint;
    
    /**
     * Sole constructor for this class.
     * @param constraint The {@link ConstraintSyntaxTree} that will be translated.
     * @param index The index of the {@link ConstraintSyntaxTree} inside of the {@link #getModel()}.
     * @param model The {@link ReasonerModel} where the constraint came from
     *     (needed for translating embedded variables, must not be <tt>null</tt>).
     * @param writer The writer where the output shall be written to.
     * @param reasoningID The unique ID of the current reasoning process.
     * @see de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    public CompoundConstraintTranslator(ConstraintSyntaxTree constraint, int index, ReasonerModel model,
        Writer writer, String reasoningID) {
        super(model, writer, reasoningID,
            ConstraintPatternFactory.getConstraintPattern(constraint));
        
        this.index = index;
        this.constraint = constraint;         
    }
    
    @Override
    public void translate() {
        appendComment(TranslationFragmentFactory.getTranslationPattern(cstPattern));            
        append("rule \"" + index + " in " + cmpName + "\"");
        append(LINEBREAK);
        append("when");
        append(LINEBREAK);
        append("    " + variableName + " : " + CompoundVariable.class.getSimpleName()
            + "(" + variableName + ".getTypeName() == \"" + cmpName + "\")");
        append(LINEBREAK);
        for (ReasonerVariable variableInConstraint 
            : getModel().getCompoundNotNestedVariablesFromConstraints(cmpName + "_" + index)) {
            append("    $" + variableInConstraint.getName() 
                        + " : " 
                        + variableInConstraint.getClass().getSimpleName()
                        + " ( "
                        + "name == \"" + variableInConstraint.getName() + "\""
                        + " )");
            append(LINEBREAK);
        } 
        append("eval (");
        append(LINEBREAK);
        append(TranslationFragmentFactory.getNegationOpeningInWhen(cstPattern));
        constraint.accept(this);
        append(TranslationFragmentFactory.getNegationClosingInWhen(cstPattern));
        append(LINEBREAK);
        append(")");
        append(LINEBREAK);
        append("then");
        append(LINEBREAK);
        appendResult();
        append(LINEBREAK);
        append("end");
        append(LINEBREAK);
        append(LINEBREAK);
    }
    
    /**
     * Method for setting the compound which constraints are translated.
     * @param compound Translated compound.
     */
    public void setCompoundType(CompoundType compound) {
        this.cmpName = compound.getName();        
        this.variableName = "$" + cmpName;
        this.type = compound.getType();
    }
    
    /**
     * Method for setting constraint trend.
     * @param isCompoundConstraint Determines if it is a simple constraint. Needed for ConstraintPatternFactory.
     */
    public void isCompoundConstraint(boolean isCompoundConstraint) {
        this.isCompoundConstraint = isCompoundConstraint;
    }
   
    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable decl = variable.getVariable();
        String name = decl.getName();
        // Workaround for variable in assignments
        if (decl.getParent().getParent() == null) {            
            append("$" + name);
        } else if (decl.getParent().getClass().getSimpleName().equals("AttributeAssignment") 
            && decl.getParent().getParent().getClass().getSimpleName().equals("Project")) {
            append("$" + name);            
        } else if (decl.getParent().getClass().getSimpleName().equals("Compound")
            || (decl.getParent().getClass().getSimpleName().equals("AttributeAssignment")
                && decl.getParent().getParent().getClass().getSimpleName().equals("Compound"))) {
            append(createCompoundAccess(decl));
            
        } else {
            append(createCompoundAccess(decl));        
        }
        appendVariableAccess();
    }
    
    @Override
    public void appendResult() {
        switch (cstPattern) {
        case SIMPLE_VALIDATION:
            addFailedRuleinCompound(variableName + ".getName()", index);
            break;
        case SIMPLE_ASSIGNMENT:
            addFailedRuleinCompound(variableName + ".getName()", index);
            break;
        case IMPLIES_VALIDATION:
            appendImpliesExtension();
            break;
        case IMPLIES_ASSIGNMENT:
            appendImpliesExtension();
            break;
        default:
            addFailedRuleinCompound(variableName + ".getName()", index);
            break;
        } 
    }
    
    @Override
    public void appendImpliesExtension() {
        append("if ( ");
        append(TranslationFragmentFactory.getNegationOpeningInThen(cstPattern));
        isPropagationPosition = true;
        constraint.accept(this);
        isPropagationPosition = false;
        append(TranslationFragmentFactory.getNegationClosingInThen(cstPattern));
        append(" ) {");
        append(LINEBREAK);
        addFailedRuleinCompound(variableName + ".getName()", index);
        append(LINEBREAK);
        append("}");
    }
    
    /**
     * Handles unqualified variable names inside of a compound.
     * @param decl The nested declaration.
     * @return A string in form of: <tt>$var.get("decl.getName()")</tt>.
     */
    private String createCompoundAccess(AbstractVariable decl) {
        String result = null;
        // Workaround attribute assignment nesting in compounds
        if (decl.getParent() == type || decl.getParent().getParent() == type) {
            result = variableName + ".get(\"" + decl.getName() + "\")";
        } else {
            AbstractVariable parent = (AbstractVariable) decl.getParent();
            result = createCompoundAccess(parent) + ".get(\"" + decl.getName() + "\")";
        }
        return result;
    }
}
