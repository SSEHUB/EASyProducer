package de.uni_hildesheim.sse.translation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.ivml.ActualArgument;
import de.uni_hildesheim.sse.ivml.ActualArgumentList;
import de.uni_hildesheim.sse.ivml.AdditiveExpression;
import de.uni_hildesheim.sse.ivml.AdditiveExpressionPart;
import de.uni_hildesheim.sse.ivml.AssignmentExpression;
import de.uni_hildesheim.sse.ivml.AssignmentExpressionPart;
import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.ContainerInitializer;
import de.uni_hildesheim.sse.ivml.Declaration;
import de.uni_hildesheim.sse.ivml.Declarator;
import de.uni_hildesheim.sse.ivml.EqualityExpression;
import de.uni_hildesheim.sse.ivml.EqualityExpressionPart;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionAccess;
import de.uni_hildesheim.sse.ivml.ExpressionListEntry;
import de.uni_hildesheim.sse.ivml.ExpressionListOrRange;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.IfExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpressionPart;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LetExpression;
import de.uni_hildesheim.sse.ivml.Literal;
import de.uni_hildesheim.sse.ivml.LogicalExpression;
import de.uni_hildesheim.sse.ivml.LogicalExpressionPart;
import de.uni_hildesheim.sse.ivml.MultiplicativeExpression;
import de.uni_hildesheim.sse.ivml.OptBlockExpression;
import de.uni_hildesheim.sse.ivml.PostfixExpression;
import de.uni_hildesheim.sse.ivml.PrimaryExpression;
import de.uni_hildesheim.sse.ivml.RelationalExpression;
import de.uni_hildesheim.sse.ivml.ContainerOp;
import de.uni_hildesheim.sse.ivml.UnaryExpression;
import de.uni_hildesheim.sse.ivml.Value;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IIdentifiable;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.varModel.capabilities.DefaultReasonerAccess;
import net.ssehub.easy.varModel.capabilities.IvmlReasonerCapabilities;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DebugConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.EmptyInitializer;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.NamedArgument;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.AbstractVarModelWriter;

/**
 * Implements a class which translates a given EMF expression in terms of the
 * IVML grammar into the IVML object model. Please note that errors which occur
 * during translation are not signaled as individual exceptions but collected
 * and accessible through {@link #getMessage(int)}.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator extends net.ssehub.easy.dslCore.translation.ExpressionTranslator {

    private AssignmentDetector assignmentDetector = new AssignmentDetector();
    private int level;
    private boolean hasTopLevelWarning;
    private RefByCheckVisitor refByChecker = new RefByCheckVisitor();
    
    /**
     * Creates an expression translator (to be used within this package only).
     */
    public ExpressionTranslator() {
    }
    
    /**
     * Initializes the levels.
     */
    void initLevel() {
        level = -1;
        hasTopLevelWarning = false;
    }

    /**
     * Checks for illegal top-level warnings and emits an error if required.
     * 
     * @param cause the causing EObject
     * @param causingFeature the causing feature
     */
    void errorAboutTopLevelWarning(EObject cause, EStructuralFeature causingFeature) {
        if (hasTopLevelWarning) {
            error("warning not allowed here", cause, causingFeature, ErrorCodes.WARNING_USAGE);
        }
    }

    /**
     * Turns an IVML exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    void error(IIdentifiable exception, EObject cause, EStructuralFeature causeFeature) {
        error(exception.getMessage(), cause, causeFeature, exception.getId());
    }

    /**
     * Turns an IVML exception into a xText warning.
     * 
     * @param exception the exception to used
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    void warning(IvmlException exception, EObject cause, EStructuralFeature causeFeature) {
        error(exception.getMessage(), cause, causeFeature, exception.getCode());
    }

    // ------------------------------ comment assignment ----------------------
        
    /**
     * Handles the comments assigned to the EMF AST element <code>object</code>
     * and inserts a comment node as top of the <code>subtree</code> if required.
     * 
     * @param object the EMF AST element to analyze
     * @param subtree the constraint subtree to add the comment before
     * @return the resulting subtree
     */
    private ConstraintSyntaxTree handleBasicComment(EObject object, ConstraintSyntaxTree subtree) {
        ConstraintSyntaxTree result = subtree;
        /*if (null != subtree) { // does not work properly ;/
            // currently disabled as comment assignment does not work properly
            String comment = CommentUtils.commentsToString(object);
            if (null != comment) {
                result = new de.uni_hildesheim.sse.model.cst.Comment(subtree, comment);
            }
        }*/
        return result;
    }

    // ---------------------------------- processing --------------------------

    /**
     * Processes an expression and returns the result as a syntax tree. Calls {@link #initLevel()}, 
     * i.e., do not call from inside.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    public ConstraintSyntaxTree processExpression(Expression expr,
        TypeContext context, IModelElement parent) throws TranslatorException {
        initLevel();
        return processExpression(null, expr, context, parent);
    }

    /**
     * Processes a block expression.
     * 
     * @param block the block
     * @param context the type context
     * @param parent the parent element
     * @return the created constraint syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>block</code> must be
     *             terminated abnormally
     */
    ConstraintSyntaxTree processBlockExpression(de.uni_hildesheim.sse.ivml.BlockExpression block, 
        TypeContext context, IModelElement parent) throws TranslatorException {
        List<ExpressionStatement> stmts = block.getExprs();
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[stmts.size()];
        for (int e = 0; e < stmts.size(); e++) {
            exprs[e] = processExpression(stmts.get(e).getExpr(), context, parent);
        }
        try {
            return new BlockExpression(exprs);
        } catch (CSTSemanticException e) {
            throw new TranslatorException(e, block, IvmlPackage.Literals.BLOCK_EXPRESSION__EXPRS);
        }
    }
    
    /**
     * Processes an (optional block) expression.
     * 
     * @param lhsType the data type on the left hand side of the expression
     * @param expr the expression to be processed
     * @param context the type context to be considered
     * @param parent the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processExpression(IDatatype lhsType, OptBlockExpression expr,
        TypeContext context, IModelElement parent) throws TranslatorException {
        ConstraintSyntaxTree result = null;
        if (null != expr.getBlock()) {
            result = processBlockExpression(expr.getBlock(), context, parent);
        } else if (null != expr.getExpr()) {
            result = processExpression(lhsType, expr.getExpr(), context, parent);
        }
        return result;
    }

    /**
     * Processes an expression and returns the result as a syntax tree. Call {@link #initLevel()} 
     * if called from outside.
     * 
     * @param lhsType the data type on the left hand side of the expression
     * @param expr the expression to be processed
     * @param context the type context to be considered
     * @param parent the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    ConstraintSyntaxTree processExpression(IDatatype lhsType, Expression expr,
        TypeContext context, IModelElement parent) throws TranslatorException {
        ConstraintSyntaxTree result = null;
        if (null != expr) {
            if (null != expr.getLet()) {
                // an expression may either be nested in a let expression
                level++;
                LetExpression letEx = expr.getLet();
                IDatatype type = context.resolveType(letEx.getType());
                DecisionVariableDeclaration var = new DecisionVariableDeclaration(
                        letEx.getName(), type, parent);
                context.pushLayer(parent);
                context.addToContext(var);
                try {
                    var.setValue(processExpression(null, letEx.getValueExpr(), context, parent));
                    result = new Let(var, processExpression(null, letEx.getSubExpr(), context, parent));
                } catch (TranslatorException e) {
                    throw e;
                } catch (IvmlException e) {
                    error(e, expr.getLet(), IvmlPackage.Literals.LET_EXPRESSION__VALUE_EXPR);
                } finally {
                    context.popLayer();
                    level--;
                }
            } else if (null != expr.getExpr()) {
                // processing of the expression
                result = processImplicationExpression(expr.getExpr(), context, parent);
            } else if (null != expr.getContainer()) {
                try {
                    result = processContainerInitializer(lhsType, expr, expr.getContainer(), context, parent);
                } catch (IvmlException e) {
                    throw new TranslatorException(e, expr, IvmlPackage.Literals.EXPRESSION__CONTAINER);
                }
            } 
        }
        if (Constants.DEBUG) {
            if (null != result) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintStream pOut = new PrintStream(out);
                DebugConstraintTreeVisitor vis = new DebugConstraintTreeVisitor(pOut);
                pOut.println(">>");
                result.accept(vis);
                pOut.println("<<");
                logger.info(out.toString());
            }
        }
        return result;
    }
    
    /**
     * Process an assignment expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processAssignmentExpression(
        AssignmentExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processLogicalExpression(expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            for (AssignmentExpressionPart part : expr.getRight()) {
                ConstraintSyntaxTree rhs = null;
                if (null != part.getEx()) {
                    rhs = processLogicalExpression(part.getEx(), context, parent);
                } else if (null != part.getContainer()) {
                    try {
                        rhs = processContainerInitializer(result.inferDatatype(),
                            expr, part.getContainer(), context, parent);
                    } catch (IvmlException e) {
                        throw new TranslatorException(e, expr, IvmlPackage.Literals.ASSIGNMENT_EXPRESSION__RIGHT);
                    }
                }
                if (null != rhs) {
                    result = new OCLFeatureCall(result, part.getOp(), context.getProject(), rhs);
                }
            }
            level--;
        }
        return result;
    }

    /**
     * Process an implication expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processImplicationExpression(
        ImplicationExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processAssignmentExpression(
            expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            if (!expr.getRight().isEmpty()) {
                checkForAssigment(result, true, expr, IvmlPackage.Literals.IMPLICATION_EXPRESSION__LEFT);
            }
            for (ImplicationExpressionPart part : expr.getRight()) {
                ConstraintSyntaxTree cst = processAssignmentExpression(part.getEx(), context, parent);
                checkForAssigment(cst, false, part, IvmlPackage.Literals.IMPLICATION_EXPRESSION_PART__EX);
                result = new OCLFeatureCall(result, part.getOp(),
                    context.getProject(), cst);
            }
            level--;
        }
        return result;
    }

    /**
     * Checks for an assignment operation directly in <code>cst</code> and emits an error
     * or a warning in case that the operation is found.
     * 
     * @param cst the constraint syntax tree to be checked
     * @param error emit an error or a warning
     * @param cause the causing EObject
     * @param causingFeature the causing feature in <code>cause</code>
     */
    private void checkForAssigment(ConstraintSyntaxTree cst, boolean error, EObject cause, 
        EStructuralFeature causingFeature) {
        assignmentDetector.setMaxLevel(AssignmentDetector.NO_DEEP_TRAVERSAL);
        cst.accept(assignmentDetector);
        if (assignmentDetector.isAssignment()) {
            if (error) {
                error("assignments are not allowed here", cause, causingFeature, ErrorCodes.ASSIGNMENT);
            } else {
                warning("discouraged use in expression as assignments are always true", cause, 
                    causingFeature, ErrorCodes.ASSIGNMENT);
            }
        }
        assignmentDetector.clear();
    }
    
    /**
     * Process a logical expression and turn it into a feature call. If called from outside, 
     * call {@link #initLevel()} before.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    ConstraintSyntaxTree processLogicalExpression(
        LogicalExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processEqualityExpression(expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            if (!expr.getRight().isEmpty()) {
                checkForAssigment(result, false, expr, IvmlPackage.Literals.LOGICAL_EXPRESSION__LEFT);
            }
            for (LogicalExpressionPart part : expr.getRight()) {
                ConstraintSyntaxTree cst = processEqualityExpression(part.getEx(), context, parent);
                checkForAssigment(result, false, part, IvmlPackage.Literals.LOGICAL_EXPRESSION_PART__EX);
                result = new OCLFeatureCall(result, part.getOp(),
                    context.getProject(), cst);
            }
            level--;
        }
        return result;
    }

    /**
     * Process a equality expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processEqualityExpression(
        EqualityExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processRelationalExpression(expr.getLeft(), context, parent);
        EqualityExpressionPart right = expr.getRight();
        if (null != right) {
            level++;
            String op = expr.getRight().getOp();
            // normalize to OCL
            if (IvmlKeyWords.UNEQUALS_ALIAS.equals(op)) {
                op = OclKeyWords.UNEQUALS;
                if (AbstractVarModelWriter.considerOclCompliance()) {
                    warning("OCL compliance: Please use <> instead of !=", expr, 
                        IvmlPackage.Literals.EQUALITY_EXPRESSION_PART__OP, ErrorCodes.WARNING_USAGE);
                }
            }
            ConstraintSyntaxTree rhs = null;
            if (null != expr.getRight().getEx()) {
                rhs = processRelationalExpression(right.getEx(), context, parent);
                checkForAssigment(rhs, false, right, IvmlPackage.Literals.EQUALITY_EXPRESSION__RIGHT);
            } else if (null != right.getContainer()) {
                try {
                    rhs = processContainerInitializer(result.inferDatatype(),
                            expr, right.getContainer(), context, parent);
                } catch (IvmlException e) {
                    throw new TranslatorException(e, expr,
                            IvmlPackage.Literals.ASSIGNMENT_EXPRESSION_PART__CONTAINER);
                }
            }
            if (null != rhs) {
                result = new OCLFeatureCall(result, op, context.getProject(), rhs);
            }
            level--;
        }
        return result;
    }
    
    /**
     * Process a relational expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processRelationalExpression(
        RelationalExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processAdditiveExpression(expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            checkForAssigment(result, false, expr, IvmlPackage.Literals.RELATIONAL_EXPRESSION__LEFT);
            String op = expr.getRight().getOp();
            ConstraintSyntaxTree cst = processAdditiveExpression(expr.getRight().getEx(), context, parent);
            checkForAssigment(cst, false, expr, IvmlPackage.Literals.RELATIONAL_EXPRESSION__RIGHT);
            OCLFeatureCall call1 = new OCLFeatureCall(result, op, context.getProject(), cst);
            result = call1;
            if (null != expr.getRight2()) {
                String op2 = expr.getRight2().getOp();
                ConstraintSyntaxTree cst2 = processAdditiveExpression(expr.getRight2().getEx(), context, parent);
                checkForAssigment(cst2, false, expr, IvmlPackage.Literals.RELATIONAL_EXPRESSION__RIGHT);
                OCLFeatureCall call2 = new OCLFeatureCall(cst, op2, context.getProject(), cst2);
                try {
                    result = new MultiAndExpression(call1, call2);
                } catch (CSTSemanticException e) {
                    throw new TranslatorException(e, expr, IvmlPackage.Literals.RELATIONAL_EXPRESSION__RIGHT2);
                }
                if (AbstractVarModelWriter.considerOclCompliance()) {
                    warning("OCL compliance: chain of relational operations shall be written by a combination of binary"
                        + " comparisons and Boolean and operatoins", expr, 
                        IvmlPackage.Literals.RELATIONAL_EXPRESSION__RIGHT2, ErrorCodes.WARNING_USAGE);
                }
            }
            level--;
        }
        return result;
    }

    /**
     * Process an additive expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processAdditiveExpression(
        AdditiveExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processMultiplicativeExpression(expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            if (!expr.getRight().isEmpty()) {
                checkForAssigment(result, false, expr, IvmlPackage.Literals.ADDITIVE_EXPRESSION__LEFT);
            }
            for (AdditiveExpressionPart part : expr.getRight()) {
                ConstraintSyntaxTree cst = processMultiplicativeExpression(part.getEx(), context, parent);
                checkForAssigment(cst, false, part, IvmlPackage.Literals.ADDITIVE_EXPRESSION_PART__EX);
                result = new OCLFeatureCall(result, part.getOp(), context.getProject(), cst);
            }
            level--;
        }
        return result;
    }

    /**
     * Process a multiplicative expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processMultiplicativeExpression(
            MultiplicativeExpression expr, TypeContext context,
            IModelElement parent) throws TranslatorException {
        ConstraintSyntaxTree result = processUnaryExpression(expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            level++;
            checkForAssigment(result, false, expr, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION__LEFT);
            ConstraintSyntaxTree cst = processUnaryExpression(expr.getRight().getExpr(), context, parent);
            checkForAssigment(cst, false, expr, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION__RIGHT);
            result = new OCLFeatureCall(result, expr.getRight().getOp(), context.getProject(), cst);
            level--;
        }
        return result;
    }

    /**
     * Process a unary expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processUnaryExpression(UnaryExpression expr,
        TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processPostfixExpression(expr.getExpr(), context, parent);
        if (null != expr.getOp()) {
            level++;
            result = new OCLFeatureCall(result, expr.getOp(), context.getProject());
            level--;
        }
        return result;
    }

    /**
     * Processes a feature call. This method allows to work with an empty
     * <code>lhs</code> in case of a "context less method call" such as
     * <code>max(1, 2)</code> or with a given <code>lhs</code>, e.g. for
     * <code>s.size()</code>;
     * 
     * @param lhs
     *            the operand expression (may be <b>null</b> as described above)
     * @param call
     *            the call to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>lhs</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processFeatureCall(ConstraintSyntaxTree lhs,
        FeatureCall call, TypeContext context, IModelElement parent) throws TranslatorException {
        return processFeatureCallImpl(lhs, call, context, parent, true);
    }

    /**
     * Processes a feature call. This method allows to work with an empty
     * <code>lhs</code> in case of a "context less method call" such as
     * <code>max(1, 2)</code> or with a given <code>lhs</code>, e.g. for
     * <code>s.size()</code>;
     * 
     * @param lhs
     *            the operand expression (may be <b>null</b> as described above)
     * @param call
     *            the call to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @param checkOclCompliance
     *            check for OCL compliance of this call, i.e., -> vs .
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>lhs</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processFeatureCallImpl(ConstraintSyntaxTree lhs,
        ActualArgumentList call, TypeContext context, IModelElement parent, boolean checkOclCompliance) 
        throws TranslatorException {
        level++;
        boolean regularFeatureCall = true;
        List<ActualArgument> args = call.getArgs();
        String callName = call.getName();
        ConstraintSyntaxTree[] param;
        if (null == args) {
            param = null;
            if (null != lhs) {
                try {
                    IDatatype leftType = lhs.inferDatatype();
                    if (leftType.isAssignableFrom(Compound.TYPE)) {
                        // check whether it could be an operation
                        boolean isOp = false;
                        for (int o = 0; !isOp && o < leftType.getOperationCount(); o++) {
                            isOp = leftType.getOperation(o).getName().equals(callName);
                        }
                        if (isOp) {
                            checkForCompoundElement((Compound) leftType, callName, call);
                        }
                    }
                } catch (CSTSemanticException e) {
                    throw new TranslatorException(e, call, IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__ARGS);
                }
            }
        } else {
            int pListSize = args.size();
            if (0 == pListSize) {
                param = null;
            } else {
                if (null == lhs) {
                    lhs = processArgument(null, args.get(0), context, parent);
                    if (pListSize - 1 > 0) {
                        param = new ConstraintSyntaxTree[pListSize - 1];
                        for (int p = 1; p < pListSize; p++) {
                            param[p - 1] = processArgument(null, args.get(p), context, parent);
                        }
                    } else {
                        param = null;
                    }
                } else {
                    param = new ConstraintSyntaxTree[pListSize];
                    for (int p = 0; p < pListSize; p++) {
                        param[p] = processArgument(null, args.get(p), context, parent);
                    }
                }
            }
        }
        if (regularFeatureCall) {
            // if this is a feature call, obtain all parameters and construct
            // a feature call node
            OCLFeatureCall tmp = new OCLFeatureCall(lhs, callName, context.getProject(), param);
            try {
                tmp.inferDatatype();
                Operation op = tmp.getResolvedOperation();
                if (checkOclCompliance && AbstractVarModelWriter.considerOclCompliance()) { 
                    if (null != op && Container.TYPE.isAssignableFrom(op.getOperand())) {
                        warning("OCL compliance: Container operations shall be called by '->' rather than '.'", call, 
                            IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME, ErrorCodes.WARNING_USAGE);
                    }
                    checkOperationOclCompliance(op, call, IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME);
                }
            } catch (CSTSemanticException e) {
            }
            lhs = tmp;
        }
        if (OclKeyWords.WARNING.equals(callName)) {
            if (level > 1) {                 
                error("warning is not allowed in nested expressions", call, 
                    IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME, ErrorCodes.WARNING_USAGE);
            } else {
                this.hasTopLevelWarning = true;
            }
        }
        level--;
        return lhs;
    }

    /**
     * Process an argument and returns a (named) expression.
     * 
     * @param lhsType the left hand side type (optional, may be <b>null</b>)
     * @param arg the argument expression
     * @param context the type context to be considered
     * @param parent the actual (intended) parent of the constraint to be created
     * @return the (named) expression
     * @throws TranslatorException in case that the expression cannot be translated for some reason
     */
    private ConstraintSyntaxTree processArgument(IDatatype lhsType, ActualArgument arg, TypeContext context, 
        IModelElement parent) throws TranslatorException {
        ConstraintSyntaxTree result = processExpression(lhsType, arg.getArg(), context, parent);
        if (null != result && null != arg.getName()) {
            result = new NamedArgument(arg.getName(), result);
        }
        return result;
    }

    /**
     * Checks for an existing compound element <code>name</code> in <code>comp</code> and throws an
     * exception if that element does not exist. This method is used to check whether a compound access
     * overlaps with an operation name.
     * 
     * @param comp the compound to check
     * @param name the name of the element
     * @param call the causing call
     * @throws TranslatorException an exception in case that the element does not exist (and in this
     *   specific case clashes with an operation call of the same name
     */
    private void checkForCompoundElement(Compound comp, String name, ActualArgumentList call) 
        throws TranslatorException {
        if (null != comp.getElement(name)) {
            throw new TranslatorException("compound slot '" + name + "' clashes with operation of same name",
                call, IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME, ErrorCodes.NAME_CLASH);
        }        
    }

    /**
     * Processes a valid declaration.
     * 
     * @param lhs the operand expression the container operation runs on
     * @param op the container operation
     * @param context the type context to be considered
     * @param parent the actual (intended) parent of the constraint to be created
     * @param declaration the declaration to be processed
     * @param declarators the declarators to be modified as a side effect
     * @throws TranslatorException in case that the processing of the <code>lhs</code> must be terminated abnormally
     */
    private void processDeclaration(ConstraintSyntaxTree lhs, ContainerOp op, TypeContext context, IModelElement parent,
        Declaration declaration, List<DecisionVariableDeclaration> declarators) throws TranslatorException {
        level++;
        IDatatype type = null;
        boolean explicitType;
        if (null != declaration.getType()) {
            // if specified, take type from declaration (may collide)
            type = context.resolveType(declaration.getType());
            explicitType = true;
        } else {
            explicitType = false;
            // if not specified, take type from collection
            try {
                IDatatype collectionType = lhs.inferDatatype();
                if (collectionType instanceof Container) {
                    type = ((Container) collectionType).getContainedType();
                } else {
                    type = new Set("", collectionType, null);
                }
            } catch (IvmlException e) {
                error(e, op, IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__ARGS);
            }
        }
        ConstraintSyntaxTree valueEx;
        if (null != declaration.getInit()) {
            valueEx = processExpression(type, declaration.getInit(), context, parent);
        } else {
            valueEx = null;
        }
        // process the default values
        if (null != type) {
            EList<String> ids = declaration.getId();
            for (int i = 0; i < ids.size(); i++) {
                DecisionVariableDeclaration declarator;
                if (0 == i && explicitType) {
                    declarator = new ExplicitTypeVariableDeclaration(ids.get(i), type, parent);
                } else {
                    declarator = new DecisionVariableDeclaration(ids.get(i), type, parent);
                }
                if (null != valueEx) {
                    try {
                        declarator.setValue(valueEx);
                    } catch (IvmlException e) {
                        error(e, op, IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__ARGS);
                    }
                }
                declarators.add(declarator);
            }
        }
        level--;
    }

    /**
     * Processes a container operation. Fallback resolution to usual operations for non-iterating container operations 
     * and fallback to unqualified iterator expressions.
     * 
     * @param lhs
     *            the operand expression the container operation runs on
     * @param op
     *            the container operation
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>lhs</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processContainerOp(ConstraintSyntaxTree lhs, ContainerOp op, TypeContext context, 
        IModelElement parent) throws TranslatorException {
        Declarator declarator = op.getDecl();
        List<ActualArgument> args = op.getArgs();
        if (null != declarator && (null == args || args.size() == 1)) {
            lhs = processContainerOp(lhs, op, null, null, context, parent);
        } else if (null == declarator) { // go for parameters
            try {
                lhs = processFeatureCallImpl(lhs, op, context, parent, false);
            } catch (TranslatorException e) { // may fail if container op with unqualified var
                try {
                    IDatatype lhsType = lhs.inferDatatype();
                    if (Container.TYPE.isAssignableFrom(lhsType) && 1 == lhsType.getGenericTypeCount()) {
                        List<DecisionVariableDeclaration> decls = new ArrayList<DecisionVariableDeclaration>();
                        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("t", 
                            lhsType.getGenericType(0), new Constraint(null)); // constraint -> temporary
                        decls.add(decl);
                        ConstraintSyntaxTree declEx = getAccessor(args, decl);
                        if (null != declEx) { 
                            lhs = processContainerOp(lhs, op, decls, declEx, context, parent);
                        } else {
                            throw e;
                        }
                    }
                } catch (CSTSemanticException e1) {
                    throw e;
                } catch (TranslatorException e1) {
                    throw e;
                }
            }
        } else {
            throw new TranslatorException("An iterating container operation requires at most one expression", op, 
                IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__ARGS, ErrorCodes.SYNTAX);
        }
        return lhs;
    }
    
    /**
     * Extracts a compound accessor/slot name from the given arguments.
     * 
     * @param args the arguments
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(List<ActualArgument> args, DecisionVariableDeclaration decl) {
        ConstraintSyntaxTree result = null;
        if (1 == args.size()) {
            ActualArgument arg = args.get(0);
            if (null != arg && arg.getArg() != null) {
                result = getAccessor(arg.getArg().getExpr(), decl);
            }
        }
        return result;
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(ImplicationExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(AssignmentExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(LogicalExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(EqualityExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(RelationalExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }
    
    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(AdditiveExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(MultiplicativeExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(UnaryExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getExpr(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(PostfixExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLeft(), decl);
    }

    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(PrimaryExpression ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getLit(), decl);
    }
    
    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(Literal ex, DecisionVariableDeclaration decl) {
        return null == ex ? null : getAccessor(ex.getVal(), decl);
    }
    
    /**
     * Extracts a compound accessor/slot name from the given expression.
     * 
     * @param ex the expression
     * @param decl the binding declarator 
     * @return the accessor, may be <b>null</b> if there is none
     */
    private ConstraintSyntaxTree getAccessor(Value ex, DecisionVariableDeclaration decl) {
        ConstraintSyntaxTree result = null;
        if (null != ex && null != ex.getQValue()) {
            result = new CompoundAccess(new Variable(decl), Utils.getQualifiedNameString(ex.getQValue()));
        }
        return result;
    }

    /**
     * Processes a container operation.
     * 
     * @param lhs
     *            the operand expression the container operation runs on
     * @param op
     *            the container operation
     * @param declarators
     *            explicit declarators overriding the information given in <code>op</code>
     * @param declEx
     *            explicit iterator expression overriding the information given in <code>op</code>
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>lhs</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processContainerOp(ConstraintSyntaxTree lhs, ContainerOp op, 
        List<DecisionVariableDeclaration> declarators, ConstraintSyntaxTree declEx, TypeContext context, 
        IModelElement parent) throws TranslatorException {
        level++;
        if (null == declarators) {
            List<Declaration> declarations = op.getDecl().getDecl();
            // grammar ensures that at least one declarator is present
            declarators = new ArrayList<DecisionVariableDeclaration>();
            // declarators are local variable declarations for iteration
            for (int d = 0; d < declarations.size(); d++) {
                Declaration declaration = declarations.get(d);
                List<String> ids = declaration.getId();
                if (ids != null && ids.size() > 0 && ids.get(0) != null) {
                    processDeclaration(lhs, op, context, parent, declaration, declarators);
                } else {
                    throw new TranslatorException("Iterating container operations require at least one declarator", 
                        declaration, IvmlPackage.Literals.CONTAINER_OP__DECL, ErrorCodes.SYNTAX);
                }
            }
        }
        context.pushLayer(parent);
        // construct container operation call
        int declSize = declarators.size();
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[declSize];
        for (int ds = 0; ds < declSize; ds++) {
            decls[ds] = declarators.get(ds);
            context.addToContext(decls[ds]);
        }
        try {
            if (null == declEx) {
                List<ActualArgument> args = op.getArgs();
                if (null == args || args.size() == 1) {
                    declEx = processExpression(null, null != args ? args.get(0).getArg() : null, context, parent);    
                }
            }
            if (null == declEx) {
                throw new TranslatorException("No iterating expression given", op, 
                    IvmlPackage.Literals.CONTAINER_OP__DECL, ErrorCodes.SYNTAX);
            }
            declEx.inferDatatype();
            ContainerOperationCall coc = new ContainerOperationCall(lhs, op.getName(), declEx, decls);
            coc.inferDatatype(); 
            checkOperationOclCompliance(coc.getResolvedOperation(), op, IvmlPackage.Literals.CONTAINER_OP__DECL);
            lhs = coc;  
        } catch (TranslatorException e) {
            throw e;
        } catch (CSTSemanticException e) {
            throw new TranslatorException(e, op, IvmlPackage.Literals.CONTAINER_OP__DECL);
        } finally {
            context.popLayer();
        }
        level--;
        return lhs;
    }

    /**
     * Checks for OCL operation compliance and issues a warning if violated and compliance mode is enabled.
     * 
     * @param op the operation
     * @param cause the causing ECore object
     * @param feature the causing ECore feature
     */
    private void checkOperationOclCompliance(Operation op, EObject cause, EStructuralFeature feature) {
        if (AbstractVarModelWriter.considerOclCompliance()) {
            Operation alias = Operation.getAlias(op);
            if (null != alias) {
                warning("OCL compliance: Please use '" + alias.getSignature() + "' instead of '" + op.getSignature() 
                    + "'", cause, feature, ErrorCodes.WARNING_USAGE);
            }
        }
    }

    /**
     * Process a postfix expression and turn it into a feature call.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processPostfixExpression(
        PostfixExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        level++;
        ConstraintSyntaxTree result;
        if (null == expr) {
            throw new TranslatorException("<consume>", expr, IvmlPackage.Literals.POSTFIX_EXPRESSION__LEFT,
                TranslatorException.CONSUME);
        }
        if (null != expr.getCall()) {
            result = processFeatureCall(null, expr.getCall(), context, parent);
            result = processCallsAndAccess(result, expr.getFCalls(),
                    expr.getAccess(), context, parent);
        } else if (null != expr.getLeft()) {
            result = processPrimaryExpression(expr.getLeft(), context, parent);
        } else {
            throw new TranslatorException("<consume>", expr, IvmlPackage.Literals.POSTFIX_EXPRESSION__LEFT,
                TranslatorException.CONSUME);
        }
        level--;
        return result;
    }
    
    /**
     * Obtains the reference type.
     * 
     * @param varType the variable type
     * @param context the type context
     * @return the reference type
     */
    private static IDatatype refType(IDatatype varType, TypeContext context) {
        IDatatype refType;
        if (Reference.TYPE.isAssignableFrom(varType)) {
            // just take the referece
            refType = varType;
        } else {
            // provide reference to variable
            refType = context.findRefType(varType);
        }
        return refType;
    }

    /**
     * Process a primary expression.
     * 
     * @param expr
     *            the expression to be processed
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processPrimaryExpression(
        PrimaryExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        level++;
        ConstraintSyntaxTree result = null;
        if (null != expr.getRefEx()) { // (refby)
            ConstraintSyntaxTree refEx = processExpression(null, expr.getRefEx(), context, parent);
            try {
                if (refEx instanceof Variable) {
                    AbstractVariable var = ((Variable) refEx).getVariable();
                    IDatatype varType = var.getType();
                    IDatatype refType = refType(varType, context);
                    result = new ConstantValue(ValueFactory.createValue(refType, var));
                } else { // more complex expression
                    IDatatype varType = refEx.inferDatatype();
                    refByChecker.reset();
                    refEx.accept(refByChecker);
                    if (refByChecker.canBeDereferenced()) {
                        IDatatype refType = refType(varType, context);
                        result = new ConstantValue(ValueFactory.createValue(refType, refEx));
                    } else {
                        throw new TranslatorException("Expression cannot be dereferenced", expr, 
                            IvmlPackage.Literals.PRIMARY_EXPRESSION__REF_EX, ErrorCodes.DEREFERENCE);        
                    }
                }
            } catch (IvmlException e) {
                throw new TranslatorException(e, expr, IvmlPackage.Literals.PRIMARY_EXPRESSION__REF_EX);
            } 
        } else if (null != expr.getEx()) {
            // process "( expr )"
            result = new Parenthesis(processExpression(null, expr.getEx(), context, parent));
        } else if (null != expr.getIfEx()) {
            // process if-then-else expression by combining related expressions
            // into one node
            IfExpression ifExpr = expr.getIfEx();
            result = new IfThen(processExpression(null, ifExpr.getIfEx(), context,
                parent), processExpression(null, ifExpr.getThenEx(), context,
                    parent), processExpression(null, ifExpr.getElseEx(), context, parent));
        } else if (null != expr.getLit()) {
            // process one of the various types of literals
            Value value = expr.getLit().getVal();
            EStructuralFeature causingFeature = IvmlPackage.Literals.PRIMARY_EXPRESSION__LIT;
            if (null != value.getBValue()) {
                causingFeature = IvmlPackage.Literals.PRIMARY_EXPRESSION__LIT;
            }
            result = context.resolveValue(value, parent, expr, causingFeature);
            result = handleBasicComment(expr.getLit(), result);
        }
        result = processCallsAndAccess(result, expr.getCalls(), expr.getAccess(), context, parent);
        level--;
        return result;
    }

    /**
     * Process a possible empty list of calls and a possible empty access
     * expression.
     * 
     * @param lhs
     *            the expression on the left hand side (processed so far)
     * @param calls
     *            a list of calls (may be <b>null</b> or empty)
     * @param access
     *            an optional access expression (may be <b>null</b>)
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processCallsAndAccess(
        ConstraintSyntaxTree lhs, List<Call> calls,
        ExpressionAccess access, TypeContext context, IModelElement parent)
        throws TranslatorException {
        level++;
        ConstraintSyntaxTree result = lhs;
        if (null != calls) {
            for (Call call : calls) {
                if (null != call.getCall()) {
                    result = processFeatureCall(result, call.getCall(), context, parent);
                } else if (null != call.getContainerOp()) {
                    result = processContainerOp(result, call.getContainerOp(), context, parent);
                } else if (null != call.getArrayEx()) {
                    // operation is obvious, no custom operation holder
                    result = new OCLFeatureCall(result, OclKeyWords.INDEX_ACCESS, 
                        processExpression(null, call.getArrayEx(), context, parent));
                }
            }
        }
        if (null != access) {
            result = processAccess(result, access, context, parent);
        }
        level--;
        return result;
    }

    /**
     * Returns whether the given enumeration <code>eenum</code> defines a literal
     * called <code>name</code>.
     * 
     * @param eenum the enumeration to to search for
     * @param name the name of the literal
     * @return <code>true</code> if there is a literal with the given name, <code>false</code> else
     */
    private boolean hasLiteral(Enum eenum, String name) {
        return null != eenum.get(name);
    }
    
    /**
     * Returns whether the given compound <code>comp</code> or its refined compounds
     * contains a slot of name <code>name</code>.
     * 
     * @param comp the compound to search for
     * @param name the name of the slot
     * @return <code>true</code> if there is a slot with the given name, <code>false</code> else
     */
    private boolean hasSlot(Compound comp, String name) {
        boolean result = false;
        if (null != comp.getElement(name)) {
            result = true;
        } else {
            if (null != comp.getRefines()) {
                result = hasSlot(comp.getRefines(), name);
            }
        }
        return result;
    }

    /**
     * Process an access expression.
     * 
     * @param lhs
     *            the expression on the left hand side (processed so far)
     * @param access
     *            an access expression
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>expr</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processAccess(ConstraintSyntaxTree lhs,
        ExpressionAccess access, TypeContext context, IModelElement parent)
        throws TranslatorException {
        level++;
        ConstraintSyntaxTree result = null;
        String name = access.getName();
        try {
            IDatatype type = lhs.getContainedType();
            if (null == type) {
                type = lhs.inferDatatype();
            } // else: lhs is a type expression, inferDatatype would lead to a
              // MetaType
            type = Reference.dereference(type);
            if (Compound.TYPE.isAssignableFrom(type) && hasSlot((Compound) type, name)) {
                result = new CompoundAccess(lhs, name);
                IDatatype lhsType = lhs.inferDatatype();
                if (!DefaultReasonerAccess.hasCapability(IvmlReasonerCapabilities.QUALIFIED_COMPOUND_ACCESS) 
                    && MetaType.TYPE.isAssignableFrom(lhsType)) {
                    warning("Qualified compound type '" + lhsType.getName() 
                        + "' outside a compound is currently not supported in reasoning.", access, 
                        IvmlPackage.Literals.EXPRESSION_ACCESS__NAME, Message.CODE_IGNORE);
                }
            } else if (Enum.TYPE.isAssignableFrom(type) && hasLiteral((Enum) type, name)) {
                result = new ConstantValue(ValueFactory.createValue(type, name));
                context.checkEnumOclCompliance(((Enum) type).getName() + "." + name, access, 
                    IvmlPackage.Literals.EXPRESSION_ACCESS__NAME);
            } else if (FreezeVariableType.TYPE.isAssignableFrom(type) 
                && null != ((FreezeVariableType) type).getAttribute(name)) {
                result = new AttributeVariable(lhs, ((FreezeVariableType) type).getAttribute(name));
            } else {
                Attribute attr = ModelElement.findAttribute(lhs, name);
                if (null == attr) {
                    attr = ModelElement.findAttribute(context.getProject(), name);
                }
                if (null != attr) {
                    if (lhs instanceof ConstantValue) {
                        throw new TranslatorException("project attributes are templates to declare attributes of "
                            + "variables", access, IvmlPackage.Literals.EXPRESSION_ACCESS__NAME, 
                            CSTSemanticException.UNKNOWN_ELEMENT);
                    }
                    result = new AttributeVariable(lhs, attr);
                }
            }
            if (null != result) {
                result = processCallsAndAccess(result, access.getCalls(),
                        access.getAccess(), context, parent);
            } else {
                throw new TranslatorException("cannot resolve '" + access.getName() + "'", access, 
                    IvmlPackage.Literals.EXPRESSION_ACCESS__NAME, CSTSemanticException.UNKNOWN_ELEMENT);
            }
        } catch (IvmlException e) {
            throw new TranslatorException(e, access, IvmlPackage.Literals.EXPRESSION_ACCESS__NAME);
        }
        level--;
        return result;
    }

    /**
     * Processes a container initializer.
     * 
     * @param lhsType the left hand side which defines the type (part)
     * @param expr the containing primary expression
     * @param initializer the initializer
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @return an expression representing the literal collection
     * @throws TranslatorException in case that the processing of the <code>initializer</code> must
     *         be terminated abnormally
     * @throws IvmlException in case that the processing terminates in IVML type resolution
     */
    private ConstraintSyntaxTree processContainerInitializer(IDatatype lhsType,
            EObject expr, ContainerInitializer initializer, TypeContext context,
            IModelElement parent) throws TranslatorException, IvmlException {
        return processLiteralContainer(lhsType, initializer, context, parent);        
    }
    
    /**
     * Translates constant expression trees to constant values. This method is required
     * since value objects shall not have constraint syntax tree values but store the values
     * directly.
     * 
     * @param values the values to be translated (to be modified as a side effect)
     * @return the translated values
     * @throws IvmlException in case that the expressions in <code>value</code> do not
     *   represent literals
     */
    private Object[] translateToValues(Object[] values) throws IvmlException {
        for (int i = 0; i < values.length; i++) {
            if (null != values[i]) {
                if (values[i].getClass().isArray()) {
                    values[i] = translateToValues((Object[]) values[i]);
                } else if (values[i] instanceof ConstantValue) {
                    values[i] = ((ConstantValue) values[i]).getConstantValue();
                } else if (values[i] instanceof ConstraintSyntaxTree) {
                    throw new ValueDoesNotMatchTypeException("only literal values are allowed here", 
                        ValueDoesNotMatchTypeException.NO_LITERAL);
                } // compounds may start with a special name String entry and a type - ignore here!
            }
        }
        return values;
    }

    /**
     * Returns the specific type of a collection initializer.
     * 
     * @param lhsType the left hand side which defines the type (part)
     * @param initializer the initializer
     * @param context the type context for resolving variables etc.
     * @return the specific type (may be <b>null</b> if there is none)
     * @throws TranslatorException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     */
    private IDatatype getSpecificType(IDatatype lhsType, ContainerInitializer initializer, TypeContext context) 
        throws TranslatorException {
        IDatatype specificType = null;
        // this may now initialize either a container or a compound
        // the grammar prescribes only values but not expressions!
        if (null != initializer.getType()) {
            try {
                String sTypeName = Utils.getQualifiedNameString(initializer.getType());
                specificType = context.findType(sTypeName, null);
                if (null == specificType) {
                    throw new TranslatorException("type '" + sTypeName + "' is not defined", initializer,
                        IvmlPackage.Literals.CONTAINER_INITIALIZER__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                }
                if (null != lhsType && !lhsType.isAssignableFrom(specificType)) {
                    throw new TranslatorException("collection type '" + IvmlDatatypeVisitor.getQualifiedType(lhsType)
                        + "' does not match specified entry type'" + sTypeName + "'", initializer,
                        IvmlPackage.Literals.CONTAINER_INITIALIZER__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                }
                //lhsType = specificType;
            } catch (ModelQueryException e) {
                throw new TranslatorException(e, initializer, IvmlPackage.Literals.CONTAINER_INITIALIZER__TYPE);
            }
        }
        return specificType;
    }

    /**
     * Processes a collection initializer and returns the related constraint syntax tree node.
     * 
     * @param lhsType the left hand side which defines the type (part)
     * @param initializer the initializer
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @return the related constraint syntax tree node
     * @throws TranslatorException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws CSTSemanticException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws IvmlException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     */
    private ConstraintSyntaxTree processLiteralContainer(IDatatype lhsType, ContainerInitializer initializer, 
        TypeContext context, IModelElement parent) throws TranslatorException, CSTSemanticException, IvmlException {
        level++;
        ConstraintSyntaxTree result = null;
        lhsType = DerivedDatatype.resolveToBasis(lhsType);
        IDatatype specificType = getSpecificType(lhsType, initializer, context);
        if (null != specificType) {
            lhsType = specificType;            
        } 
        
        ExpressionListOrRange init = initializer.getInit();
        int withoutId = 0;
        int withId = 0;
        int entryCount = 0;
        boolean isConstraintContainer = Container.isConstraintContainer(lhsType);
        EList<ExpressionListEntry> entryList;
        if (null != init) {
            entryList = init.getList();
            entryCount = entryList.size();
            for (int e = 0; e < entryCount; e++) {
                ExpressionListEntry entry = entryList.get(e);
                String name = entry.getName();
                if (null != name) {
                    if (isConstraintContainer) { // ambiguous grammar situation, name=value looks like constraint
                        withoutId++;
                    } else {
                        withId++;
                    }
                } else {
                    withoutId++;
                }
            }
        } else {
            entryCount = 0;
            entryList = null;
        }
        boolean allWithId = (withId == entryCount);
        boolean allWithoutId = (withoutId == entryCount);
        if (!allWithId && !allWithoutId) {
            throw new TranslatorException(
                "value entries must either all have names or none", init, 
                IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, ErrorCodes.INITIALIZER_CONSISTENCY);
        }
        if (lhsType instanceof Container) {
            if (allWithId && entryCount > 0) {
                throw new TranslatorException(
                    "container initialization must not have name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, ErrorCodes.INITIALIZER_CONSISTENCY);
            } 
            result = processContainerInitializer(lhsType, context, parent, entryList);
        } else if (lhsType instanceof Compound) {
            if (allWithoutId && entryCount > 0) {
                throw new TranslatorException("compound initialization requires name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, ErrorCodes.INITIALIZER_CONSISTENCY);
            }
            result = processCompoundInitializer(lhsType, context, parent, specificType, entryList);
            IDatatype resType = result.inferDatatype();
            if (resType instanceof Compound) {
                if (((Compound) resType).isAbstract()) {
                    throw new TranslatorException("Cannot instantiate abstract compound '" + resType.getName() + "'", 
                        init, IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, 
                        ValueDoesNotMatchTypeException.IS_ABSTRACT);
                }
            }
        } else {
            result = EmptyInitializer.INSTANCE; // to be replaced as soon as possible, assignable to any type!
        }
        level--;
        return result;
    }

    /**
     * Processes a compound initializer.
     * 
     * @param lhsType the left hand side type
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @param specificType the specific type of the container
     * @param entryList the entries of the initializer
     * @return the model instance representing the container initializer
     * 
     * @throws TranslatorException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws CSTSemanticException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws IvmlException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws ValueDoesNotMatchTypeException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     */
    private ConstraintSyntaxTree processCompoundInitializer(IDatatype lhsType, TypeContext context,
        IModelElement parent, IDatatype specificType, EList<ExpressionListEntry> entryList)
        throws TranslatorException, CSTSemanticException, IvmlException, ValueDoesNotMatchTypeException {
        level++;
        ConstraintSyntaxTree result;
        Compound comp = (Compound) lhsType;
        context.pushLayer(comp);
        context.addToContext(comp);
        int entryCount = (null == entryList ? 0 : entryList.size());
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[entryCount];
        String[] slots = new String[entryCount];
        AbstractVariable[] slotDecls = new AbstractVariable[entryCount];
        for (int e = 0; e < entryCount; e++) {
            ExpressionListEntry entry = entryList.get(e);
            if (null != entry.getName()) {
                slots[e] = entry.getName();
                slotDecls[e] = comp.getElement(slots[e]);
                if (null == slotDecls[e]) {
                    throw new TranslatorException("field '" + slots[e] + "' does not exist in '"
                        + lhsType.getName() + "'", entry, IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE,
                        ErrorCodes.UNKNOWN_ELEMENT);
                }
                if (null != entry.getAttrib()) {
                    slots[e] += "." + entry.getAttrib();
                    slotDecls[e].getAttribute(entry.getAttrib());
                    if (null == slotDecls[e]) {
                        throw new TranslatorException("attribute '" + slots[e] + "' does not exist in '"
                            + lhsType.getName() + "'", entry, IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE,
                            ErrorCodes.UNKNOWN_ELEMENT);
                    }
                }
            }
            if (null != entry.getValue()) {
                exprs[e] = processImplicationExpression(entry.getValue(), context, parent);
                exprs[e].inferDatatype();
            }
            if (null != entry.getContainer()) {
                exprs[e] = processLiteralContainer(slotDecls[e].getType(), entry.getContainer(), context, parent);
            }            
        }
        if (allConstant(exprs)) {
            int pos = 0;
            Object[] obj  = new Object[2 + 2 * entryCount];
            obj[pos++] = CompoundValue.SPECIAL_SLOT_NAME_TYPE;
            obj[pos++] = specificType;
            for (int e = 0; e < exprs.length; e++) {
                obj[pos++] = slots[e];
                obj[pos++] = exprs[e];
            }
            result = new ConstantValue(ValueFactory.createValue(lhsType, translateToValues(obj)));
        } else {
            result = new CompoundInitializer(comp, slots, slotDecls, exprs);
        }
        context.popLayer();
        level--;
        return result;
    }

    /**
     * Processes a container initializer.
     * 
     * @param lhsType the left hand side type
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @param entryList the entries in the initializer
     * @return the model instance representing the container initializer
     * @throws TranslatorException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws CSTSemanticException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws IvmlException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws ValueDoesNotMatchTypeException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     */
    private ConstraintSyntaxTree processContainerInitializer(IDatatype lhsType, TypeContext context,
        IModelElement parent, EList<ExpressionListEntry> entryList) 
        throws TranslatorException, CSTSemanticException, IvmlException, ValueDoesNotMatchTypeException {
        level++;
        ConstraintSyntaxTree result;
        int entryCount = (null == entryList ? 0 : entryList.size());
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[entryCount];
        IDatatype contained = ((Container) lhsType).getContainedType();
        // assignable <-> Boolean
        boolean isConstraintCollection = ConstraintType.TYPE.getType().equals(contained.getType()); 
        for (int e = 0; e < entryCount; e++) {
            ExpressionListEntry entry = entryList.get(e);
            if (null != entry.getValue()) {
                exprs[e] = processImplicationExpression(entry.getValue(), context, parent);
                if (null != exprs[e]) {
                    exprs[e].inferDatatype();
                }
                if (isConstraintCollection && null != entry.getName()) { 
                    // ambiguous grammar situation, name=value looks like constraint
                    ConstraintSyntaxTree varTree = context.processQValue(entry.getName(), entry, 
                        IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__NAME);
                    exprs[e] = new OCLFeatureCall(varTree, OclKeyWords.ASSIGNMENT, context.getProject(), exprs[e]);
                    warning("assignment is discouraged in constraint set as it is always true", entry, 
                        IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__NAME, ErrorCodes.DISCOURAGED);
                    exprs[e].inferDatatype();
                }
            }
            if (null != entry.getContainer()) {
                exprs[e] = processLiteralContainer(contained, entry.getContainer(), context, parent);
            }
        }
        if (allConstant(exprs)) {
            Object[] obj = new Object[exprs.length];
            for (int e = 0; e < obj.length; e++) {
                obj[e] = exprs[e];
            }
            Object[] values = translateToValues(obj);
            // basically, translateToValues creates constant values but no constraint values
            if (null != values && Container.isContainer(lhsType, ConstraintType.TYPE)) {
                for (int v = 0; v < values.length; v++) {
                    Object val = values[v];
                    if (!(val instanceof ConstraintValue) && isConstraintCollection) {
                        values[v] = ValueFactory.createValue(ConstraintType.TYPE, 
                            new ConstantValue((net.ssehub.easy.varModel.model.values.Value) val));
                    }
                }
            }
            result = new ConstantValue(ValueFactory.createValue(lhsType, values));
        } else {
            result = new net.ssehub.easy.varModel.cst.ContainerInitializer((Container) lhsType, exprs);
        }
        level--;
        return result;
    }

    /**
     * Returns whether all <code>exprs</code> are constant.
     * @param exprs the expressions to analyze
     * @return <code>true</code> if all expressions are constant, <code>false</code> else
     */
    private static boolean allConstant(ConstraintSyntaxTree[] exprs) {
        boolean allConst = true;
        for (int e = 0; allConst && e < exprs.length; e++) {
            allConst = exprs[e] instanceof ConstantValue;
        }
        return allConst;
    }
    
    /**
     * Checks for and warns about discouraged names.
     * 
     * @param name the name to be checked
     * @param cause the causing language element
     * @param causingFeature the causing language feature
     */
    public void warnDiscouragedNames(String name, EObject cause, EStructuralFeature causingFeature) {
        if ("Version".equals(name)) { // -> internal version type
            warning("'Version' is discouraged due to possible future language extensions", cause, 
                causingFeature, ErrorCodes.DISCOURAGED);
        }
    }
    
}
