package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.Writer;
import java.util.Set;

import de.uni_hildesheim.sse.reasoning.core.model.ConstraintPatternFactory;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Translates a single normal constraint into Drools specific code.
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class ConstraintTranslator extends AbstractConstraintTranslator {    
    
    /**
     * Constructor for translating {@link ConstraintSyntaxTree} into drools rule.
     * @param constraint The {@link ConstraintSyntaxTree} that will be translated.
     * @param index The index of the {@link ConstraintSyntaxTree} inside of the {@link #getModel()}.
     * @param model The {@link ReasonerModel} where the {@link ConstraintSyntaxTree} came from
     *     (needed for translating embedded variables, must not be <tt>null</tt>).
     * @param writer The writer where the output shall be written to.
     * @param reasoningID The unique ID of the current reasoning process.
     * @see de.uni_hildesheim.sse.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    public ConstraintTranslator(ConstraintSyntaxTree constraint, int index, ReasonerModel model,
        Writer writer, String reasoningID) {
        
        super(model, writer, reasoningID, ConstraintPatternFactory.getConstraintPattern(constraint));
        
        this.index = index;
        this.constraint = constraint;
    }
    
    @Override
    public void translate() {
        Set<ReasonerVariable> variablesInConstraint = getModel().getVariablesOfConstraint(index);
        
        appendComment(TranslationFragmentFactory.getTranslationPattern(cstPattern));        
        append("rule \"" + index + "\"");
        append(LINEBREAK);
        append("when");
        append(LINEBREAK);
        for (ReasonerVariable variableInConstraint : variablesInConstraint) {
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
    }
    
    @Override
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
        addFailedRule(index);
        append(LINEBREAK);
        append("}");
    }
    
    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable decl = variable.getVariable();
        String name = decl.getName();        
        append("$" + name);
        appendVariableAccess();
    }
    
}
