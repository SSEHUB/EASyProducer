package de.uni_hildesheim.sse.translation;


import de.uni_hildesheim.sse.dslCore.translation.MessageHandler;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import net.ssehub.easy.basics.messages.IMessageHandler;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExpressionVersionRestriction;
import net.ssehub.easy.varModel.model.ExpressionVersionRestrictionValidator;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * A class which specifically does the import translations. The methods
 * are available for reuse.
 * 
 * @author Holger Eichelberger
 */
public class ImportTranslator {

    /**
     * Turns an ECore expression into a version restriction.
     * 
     * @param name the name of the element being processed
     * @param expr the expression to be turned into a version restriction (may be <b>null</b> but then the result will
     *   also be <b>null</b>).
     * @param translator the expression translator (may be <b>null</b> but then the result will also be <b>null</b>)
     * @param context the current type context (may be <b>null</b> but then the result will also be <b>null</b>)
     * @param handler an optional message handler (may be <b>null</b>)
     * @return the related version restriction (may be <b>null</b>)
     * @throws TranslatorException in case of translation problems
     * @throws RestrictionEvaluationException in case of problems while creating the restriction
     */
    private static IVersionRestriction processRestrictionExpression(String name, Expression expr, 
        ExpressionTranslator translator, TypeContext context, IMessageHandler handler) 
        throws TranslatorException, RestrictionEvaluationException {
        IVersionRestriction result;
        if (null == expr || null == translator || null == context) {
            result = null;
        } else {
            context.pushLayer(null);

            // reuse the same variable twice in order to allow name.version and version on the same variable :o
            // compound $name {Version version;} $name name; Version version;
            DecisionVariableDeclaration[] vars = ExpressionVersionRestriction.createRestrictionVars(name);
            context.addToContext(vars[0]);
            context.addToContext(vars[1]);
            ConstraintSyntaxTree tmp = translator.processExpression(expr, context, context.getProject());
            context.popLayer();
            ExpressionVersionRestrictionValidator validator = new ExpressionVersionRestrictionValidator(handler);
            tmp.accept(validator);
            result = new ExpressionVersionRestriction(tmp, vars[0], vars[1]);
        }
        return result;
    }

    /**
     * Processes a conflict statement including import restrictions. In case of
     * errors the respective element is not added to the resulting project. Anyway, no restriction expressions are 
     * produced!
     * 
     * @param conflictStmt the conflict statement
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processConflict(ConflictStmt conflictStmt) throws TranslatorException {
        return processConflict(conflictStmt, null, null);
    }
    
    /**
     * Processes a conflict statement including import restrictions. In case of
     * errors the respective element is not added to the resulting project.
     * 
     * @param conflictStmt the conflict statement
     * @param translator the expression translator (may be <b>null</b> but then no restriction expressions are produced)
     * @param context the current type context (may be <b>null</b> but then no restriction expressions are produced)
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processConflict(ConflictStmt conflictStmt, ExpressionTranslator translator, 
        TypeContext context) throws TranslatorException {
        String name = conflictStmt.getName();
        try {
            IVersionRestriction restriction = processRestrictionExpression(name, conflictStmt.getRestriction(), 
                translator, context, 
                new MessageHandler(translator, conflictStmt, IvmlPackage.Literals.CONFLICT_STMT__RESTRICTION));
            // no check for conflicts!
            if (!VarModel.INSTANCE.availableModels().hasModelInfo(name) && Utils.isImportResolutionEnabled()) {
                throw new TranslatorException(
                    "project '" + name + "' cannot be resolved", conflictStmt,
                    IvmlPackage.Literals.CONFLICT_STMT__NAME, ErrorCodes.IMPORT);
            }
            return new ProjectImport(name, null, true, false, restriction);
        } catch (RestrictionEvaluationException e) {
            throw new TranslatorException(e.getMessage(), conflictStmt, 
                IvmlPackage.Literals.CONFLICT_STMT__RESTRICTION, e.getId());
        }
    }

    /**
     * Processes an import statement including import restrictions. In case 
     * of errors the respective element is not added to the resulting project. Anyway, no restriction expressions are 
     * produced!
     * 
     * @param importStmt the import statement
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processImport(ImportStmt importStmt) throws TranslatorException {
        return processImport(importStmt, null, null);
    }
    
    /**
     * Processes an import statement including import restrictions. In case 
     * of errors the respective element is not added to the resulting project. 
     * 
     * @param importStmt the import statement
     * @param translator the expression translator (may be <b>null</b> but then no restriction expressions are produced)
     * @param context the current type context (may be <b>null</b> but then no restriction expressions are produced)
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processImport(ImportStmt importStmt, ExpressionTranslator translator, 
        TypeContext context) throws TranslatorException {
        try {
            IVersionRestriction restriction = processRestrictionExpression(importStmt.getName(), 
                importStmt.getRestriction(), translator, context, 
                new MessageHandler(translator, importStmt, IvmlPackage.Literals.IMPORT_STMT__RESTRICTION));
            return new ProjectImport(importStmt.getName(), importStmt.getInterface(), false, false, restriction); 
        } catch (RestrictionEvaluationException e) {
            throw new TranslatorException(e.getMessage(), importStmt, 
                IvmlPackage.Literals.IMPORT_STMT__RESTRICTION, e.getId());
        }
    }

}
