package net.ssehub.easy.reasoning.drools2.translation;

import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.drools2.model.ConstraintPatternFactory;
import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.reasoning.drools2.model.datatypes.CompoundType;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * This class is responsible for translating the whole {@link ReasonerModel} into Drools specific code.
 * Thus, this class is the starting point for the complete transformation.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class ModelTranslator extends AbstractModelTranslator {

    /**
     * Dateformat is used for creating debugging information.
     */
    private static final DateFormat DATEFORMAT = new SimpleDateFormat("HH:mm:ss (dd.MM.yyyy)");
    
    /**
     * Constant value for the <b>beginning</b> of each Drools reasoner file.
     */
    private static final String BEGIN_OF_FILE = "package net.ssehub.easy.reasoning.drools2;"
            + LINEBREAK
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.FailedRules.addFailedRule"
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.FailedRules.addFailedRuleInCompound"
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.BooleanAlgebraFunctions.*"
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.AdvancedMathFunctions.*"
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.StringFunctions.*"
            + LINEBREAK
            + "import function net.ssehub.easy.reasoning.drools2.functions.DefFunctions.*"
            + LINEBREAK
            + "import net.ssehub.easy.reasoning.drools2.model.variables.*"
            + LINEBREAK
            + LINEBREAK
            + "dialect \"mvel\""
            + LINEBREAK
            + LINEBREAK;
    
    /**
     * Constant value for the <b>ending</b> of each Drools reasoner file.
     */
    private static final String END_OF_FILE = "";
    
    /**
     * Specifies whether the translation of constraints should be verified, before the result is appended to the
     * current output.
     * <ul>
     * <li><tt>true</tt>Corrupt output should be avoided as corrupted partial translations will be skipped.</li>
     * <li><tt>false</tt>Faster translation</li>
     * </ul>
     */
    //private static final boolean CHECK_CONSTRAINT_BEFORE_ADDING = true;
    
    /**
     * Translates the whole model into Drools specific code.
     * the output will be send directly to the specified writer.
     * @param model The {@link ReasonerModel}, which should be translated (must not be <tt>null</tt>).
     * @param writer The writer where the output shall be written to (must not be <tt>null</tt>).
     * @param reasoningID The unique ID of the current reasoning process.
     * @param operation Reasoning operation performed.
     * @see net.ssehub.easy.reasoning.drools2.functions.FailedRules#createNewList(String)
     */
    public ModelTranslator(ReasonerModel model, Writer writer, String reasoningID, ReasoningOperation operation) {
        super(model, writer, reasoningID);
        
        //Write preamble: Comments, package, imports, dialect, ...
        String time = DATEFORMAT.format(new Date());
        appendComment("Project: " + model.getProject().getName() + " @ " + time);
        append(BEGIN_OF_FILE);
       
        //Translate normal and internal constraints
        appendComment("--Normal constraint translation--");
        append(LINEBREAK);
        for (int i = 0; i < getModel().getConstraintCount(); i++) {
            ConstraintSyntaxTree cst = getModel().getConstraint(i);
            if (!ConstraintPatternFactory.isDefaultAssignmentConstraint(cst)) {                
                if (!StringProvider.toIvmlString(cst).contains("{")) {
                    //System.out.println(ConstraintPatternFactory.isDefaultAssignmentConstraint(cst));
                    ConstraintTranslator translator = new ConstraintTranslator(cst, i, model, writer, reasoningID);
                    translator.setReasoningOperation(operation);
                    translator.translate();
                    append(LINEBREAK);
                    append(LINEBREAK);
                }
            }
        }
        
        //Translate compound constraints
        appendComment("--Compound constraint translation--");
        append(LINEBREAK);
        List<CompoundType> constrainedCompounds = getModel().getConstrainedCompounds();
        for (int i = 0; i < constrainedCompounds.size(); i++) {
            for (int j = 0; j < constrainedCompounds.get(i).getConstraintCount(); j++) { 
                ConstraintSyntaxTree cst = constrainedCompounds.get(i).getConstrain(j);                                
                CompoundConstraintTranslator translator 
                    = new CompoundConstraintTranslator(cst, j, getModel(), getWriter(), getReasoningID());
                translator.setReasoningOperation(operation);
                translator.setCompoundType(constrainedCompounds.get(i));
                translator.isCompoundConstraint(false);
                translator.translate();                
            }
        }
        
        append(END_OF_FILE);
    }

    /**
     * Translates one constraint into Drools specific code.
     * @param cst The constraint to translate.
     * Must be elements of the {@link #getModel()}.
     * @param index The index of the {@link ConstraintSyntaxTree} inside of the {@link #getModel()}.
     */
//    private void translateConstraint(ConstraintSyntaxTree cst, int index) {
//        if (CHECK_CONSTRAINT_BEFORE_ADDING) {
//            StringWriter sWriter = new StringWriter();
//            ValidationConstraintTranslator translator =
//                new ValidationConstraintTranslator(cst, index, getModel(), sWriter, getReasoningID());
//            
//            if (!translator.hasErrors()) {
//                append(sWriter.toString());
//                append(LINEBREAK);
//            } else {
//                copyAllExceptions(translator);
//            }
//        } else {
//            new ValidationConstraintTranslator(cst, index, getModel(), getWriter(), getReasoningID());
//            append(LINEBREAK);
//        }
//    }
}
