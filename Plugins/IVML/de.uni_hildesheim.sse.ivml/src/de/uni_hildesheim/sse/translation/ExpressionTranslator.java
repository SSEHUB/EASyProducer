package de.uni_hildesheim.sse.translation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.ActualParameterList;
import de.uni_hildesheim.sse.ivml.AdditiveExpression;
import de.uni_hildesheim.sse.ivml.AdditiveExpressionPart;
import de.uni_hildesheim.sse.ivml.AssignmentExpression;
import de.uni_hildesheim.sse.ivml.AssignmentExpressionPart;
import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.CollectionInitializer;
import de.uni_hildesheim.sse.ivml.Declaration;
import de.uni_hildesheim.sse.ivml.DslContext;
import de.uni_hildesheim.sse.ivml.EqualityExpression;
import de.uni_hildesheim.sse.ivml.EqualityExpressionPart;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionAccess;
import de.uni_hildesheim.sse.ivml.ExpressionListEntry;
import de.uni_hildesheim.sse.ivml.ExpressionListOrRange;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.IfExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpressionPart;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LetExpression;
import de.uni_hildesheim.sse.ivml.LogicalExpression;
import de.uni_hildesheim.sse.ivml.LogicalExpressionPart;
import de.uni_hildesheim.sse.ivml.MultiplicativeExpression;
import de.uni_hildesheim.sse.ivml.PostfixExpression;
import de.uni_hildesheim.sse.ivml.PrimaryExpression;
import de.uni_hildesheim.sse.ivml.RelationalExpression;
import de.uni_hildesheim.sse.ivml.SetOp;
import de.uni_hildesheim.sse.ivml.UnaryExpression;
import de.uni_hildesheim.sse.ivml.Value;
import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DebugConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.IIdentifiable;

/**
 * Implements a class which translates a given EMF expression in terms of the
 * IVML grammar into the IVML object model. Please note that errors which occur
 * during translation are not signaled as individual exceptions but collected
 * and accessible through {@link #getMessage(int)}.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator extends de.uni_hildesheim.sse.dslCore.translation.ExpressionTranslator {

    /**
     * Creates an expression translator (to be used within this package only).
     */
    public ExpressionTranslator() {
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
     * Processes an expression and returns the result as a syntax tree.
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
        return processExpression(null, expr, context, parent);
    }

    /**
     * Processes an expression and returns the result as a syntax tree.
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
                LetExpression letEx = expr.getLet();
                IDatatype type = context.resolveType(letEx.getType());
                DecisionVariableDeclaration var = new DecisionVariableDeclaration(
                        letEx.getName(), type, parent);
                context.pushLayer();
                context.addToContext(var);
                try {
                    var.setValue(processExpression(letEx.getValueExpr(),
                            context, parent));
                    result = new Let(var, processExpression(letEx.getSubExpr(),
                            context, parent));
                } catch (TranslatorException e) {
                    throw e;
                } catch (IvmlException e) {
                    error(e, expr,
                            IvmlPackage.Literals.LET_EXPRESSION__VALUE_EXPR);
                } finally {
                    context.popLayer();
                }
            } else if (null != expr.getExpr()) {
                // processing of the expression
                result = processImplicationExpression(expr.getExpr(), context, parent);
            } else if (null != expr.getCollection()) {
                try {
                    result = processCollectionInitializer(lhsType, expr, expr.getCollection(), context, parent);
                } catch (IvmlException e) {
                    throw new TranslatorException(e, expr,
                            IvmlPackage.Literals.EXPRESSION__COLLECTION);
                }
            } else if (null != expr.getDsl()) {
                DslContext dslContext = expr.getDsl();
                String dsl = dslContext.getDsl();
                if (null != dsl) {
                    dsl = dsl.trim();
                    if (dsl.startsWith(IvmlKeyWords.DSL_START)) {
                        dsl = dsl.substring(IvmlKeyWords.DSL_START.length());
                    }
                    if (dsl.endsWith(IvmlKeyWords.DSL_END)) {
                        dsl = dsl.substring(0, dsl.length()
                                - IvmlKeyWords.DSL_END.length());
                    }
                    dsl = dsl.trim();
                }
                result = new DslFragment(dslContext.getCommand(),
                        dslContext.getEscape(), dslContext.getStop(), dsl);
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
    ConstraintSyntaxTree processAssignmentExpression(
        AssignmentExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processLogicalExpression(
                expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            for (AssignmentExpressionPart part : expr.getRight()) {
                ConstraintSyntaxTree rhs = null;
                if (null != part.getEx()) {
                    rhs = processLogicalExpression(part.getEx(), context, parent);
                } else if (null != part.getCollection()) {
                    try {
                        rhs = processCollectionInitializer(result.inferDatatype(),
                                expr, part.getCollection(), context, parent);
                    } catch (IvmlException e) {
                        throw new TranslatorException(e, expr,
                                IvmlPackage.Literals.ASSIGNMENT_EXPRESSION__RIGHT);
                    }
                }
                if (null != rhs) {
                    result = new OCLFeatureCall(result, part.getOp(), context.getProject(), rhs);
                }
            }
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
    ConstraintSyntaxTree processImplicationExpression(
        ImplicationExpression expr, TypeContext context, IModelElement parent)
        throws TranslatorException {
        ConstraintSyntaxTree result = processAssignmentExpression(
                expr.getLeft(), context, parent);
        if (null != expr.getRight()) {
            for (ImplicationExpressionPart part : expr.getRight()) {
                result = new OCLFeatureCall(result, part.getOp(),
                    context.getProject(), processAssignmentExpression(
                        part.getEx(), context, parent));
            }
        }
        return result;
    }
    
    /**
     * Process a logical expression and turn it into a feature call.
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
            for (LogicalExpressionPart part : expr.getRight()) {
                result = new OCLFeatureCall(result, part.getOp(),
                    context.getProject(), processEqualityExpression(part.getEx(), context, parent));
            }
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
            String op = expr.getRight().getOp();
            // normalize to OCL
            if (IvmlKeyWords.UNEQUALS_ALIAS.equals(op)) {
                op = OclKeyWords.UNEQUALS;
            }
            ConstraintSyntaxTree rhs = null;
            if (null != expr.getRight().getEx()) {
                rhs = processRelationalExpression(right.getEx(), context, parent);
            } else if (null != right.getCollection()) {
                try {
                    rhs = processCollectionInitializer(result.inferDatatype(),
                            expr, right.getCollection(), context, parent);
                } catch (IvmlException e) {
                    throw new TranslatorException(e, expr,
                            IvmlPackage.Literals.ASSIGNMENT_EXPRESSION_PART__COLLECTION);
                }
            }
            if (null != rhs) {
                result = new OCLFeatureCall(result, op, context.getProject(), rhs);
            }
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
            String op = expr.getRight().getOp();
            result = new OCLFeatureCall(result, op, context.getProject(),
                    processAdditiveExpression(expr.getRight().getEx(), context, parent));
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
            for (AdditiveExpressionPart part : expr.getRight()) {
                result = new OCLFeatureCall(result, part.getOp(),
                        context.getProject(), processMultiplicativeExpression(
                                part.getEx(), context, parent));
            }
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
            result = new OCLFeatureCall(result, expr.getRight().getOp(),
                    context.getProject(), processUnaryExpression(expr
                            .getRight().getExpr(), context, parent));
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
            result = new OCLFeatureCall(result, expr.getOp(), context.getProject());
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
        FeatureCall call, TypeContext context, IModelElement parent)
        throws TranslatorException {
        boolean regularFeatureCall = true;
        ActualParameterList pList = call.getParam();
        String callName = call.getName();
        ConstraintSyntaxTree[] param;
        if (null == pList) {
            param = null;
            if (null != lhs) {
                try {
                    IDatatype leftType = lhs.inferDatatype();
                    if (leftType.isAssignableFrom(Compound.TYPE)) {
                        // check whether it could be an operation
                        boolean isOp = false;
                        for (int o = 0; !isOp
                                && o < leftType.getOperationCount(); o++) {
                            isOp = leftType.getOperation(o).getName()
                                    .equals(callName);
                        }
                        if (isOp) {
                            checkForCompoundElement((Compound) leftType, callName, call);
                        }
                    }
                } catch (CSTSemanticException e) {
                    throw new TranslatorException(e, call,
                            IvmlPackage.Literals.POSTFIX_EXPRESSION__LEFT);
                }
            }
        } else {
            int pListSize = pList.getParam().size();
            if (0 == pListSize) {
                param = null;
            } else {
                if (null == lhs) {
                    lhs = processExpression(pList.getParam().get(0), context,
                            parent);
                    if (pListSize - 1 > 0) {
                        param = new ConstraintSyntaxTree[pListSize - 1];
                        for (int p = 1; p < pListSize; p++) {
                            param[p - 1] = processExpression(pList.getParam()
                                    .get(p), context, parent);
                        }
                    } else {
                        param = null;
                    }
                } else {
                    param = new ConstraintSyntaxTree[pListSize];
                    for (int p = 0; p < pListSize; p++) {
                        param[p] = processExpression(pList.getParam().get(p),
                                context, parent);
                    }
                }
            }
        }
        if (regularFeatureCall) {
            // if this is a feature call, obtain all parameters and construct
            // a feature call node
            lhs = new OCLFeatureCall(lhs, callName, context.getProject(), param);
        }
        return lhs;
    }
    
    /**
     * Checks for an existing compound element <code>name</code> in <code>comp</code> and throws an
     * exception if that element does not exist. This method is used to check whether a compound access
     * overlaps with an operation name.
     * 
     * @param comp the compound to check
     * @param name the name of the element
     * @param call the causing feature call
     * @throws TranslatorException an exception in case that the element does not exist (and in this
     *   specific case clashes with an operation call of the same name
     */
    private void checkForCompoundElement(Compound comp, String name, FeatureCall call) throws TranslatorException {
        if (null != comp.getElement(name)) {
            throw new TranslatorException("compound slot '" + name + "' clashes with operation of same name",
                call, IvmlPackage.Literals.POSTFIX_EXPRESSION__LEFT, ErrorCodes.NAME_CLASH);
        }        
    }

    /**
     * Processes a set operation.
     * 
     * @param lhs
     *            the operand expression the set operation runs on
     * @param op
     *            the set operation
     * @param context
     *            the type context to be considered
     * @param parent
     *            the actual (intended) parent of the constraint to be created
     * @return the expression as a parsed syntax tree
     * @throws TranslatorException
     *             in case that the processing of the <code>lhs</code> must be
     *             terminated abnormally
     */
    private ConstraintSyntaxTree processSetOp(ConstraintSyntaxTree lhs,
        SetOp op, TypeContext context, IModelElement parent)
        throws TranslatorException {
        // process a set operation, i.e. a quantor call after ->
        EList<Declaration> declarations = op.getDecl().getDecl();
        // grammar ensures that at least one declarator is present
        List<DecisionVariableDeclaration> declarators = new ArrayList<DecisionVariableDeclaration>();
        // declarators are local variable declarations for iteration
        for (int d = 0; d < declarations.size(); d++) {
            Declaration declaration = declarations.get(d);
            ConstraintSyntaxTree valueEx;
            if (null != declaration.getInit()) {
                valueEx = processExpression(declaration.getInit(), context,
                        parent);
            } else {
                valueEx = null;
            }
            IDatatype type = null;
            if (null != declaration.getType()) {
                // if specified, take type from declaration (may collide)
                type = context.resolveType(declaration.getType());
            } else {
                // if not specified, take type from collection
                try {
                    IDatatype collectionType = lhs.inferDatatype();
                    if (collectionType instanceof Container) {
                        type = ((Container) collectionType).getContainedType();
                    } else {
                        error("left hand of "
                                + IvmlKeyWords.CONTAINER_OP_ACCESS
                                + " is not a collection", op,
                                IvmlPackage.Literals.SET_OP__DECL_EX,
                                ErrorCodes.LHS_NOT_COLLECTION);
                    }
                } catch (IvmlException e) {
                    error(e, op, IvmlPackage.Literals.SET_OP__DECL_EX);
                }
            }
            // process the default values
            EList<String> ids = declaration.getId();
            for (int i = 0; i < ids.size(); i++) {
                DecisionVariableDeclaration declarator = new DecisionVariableDeclaration(
                        ids.get(i), type, parent);
                if (null != valueEx) {
                    try {
                        declarator.setValue(valueEx);
                    } catch (IvmlException e) {
                        error(e, op, IvmlPackage.Literals.SET_OP__DECL_EX);
                    }
                }
                declarators.add(declarator);
            }
        }
        context.pushLayer();
        // construct container operation call
        int declSize = declarators.size();
        DecisionVariableDeclaration[] decls = new DecisionVariableDeclaration[declSize];
        for (int ds = 0; ds < declSize; ds++) {
            decls[ds] = declarators.get(ds);
            context.addToContext(decls[ds]);
        }
        try {
            lhs = new ContainerOperationCall(lhs, op.getName(),
                    processExpression(op.getDeclEx(), context, parent), decls);
        } catch (TranslatorException e) {
            throw e;
        } finally {
            context.popLayer();
        }
        return lhs;
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
        ConstraintSyntaxTree result;
        if (null == expr) {
            throw new TranslatorException("<consume>", expr,
                    IvmlPackage.Literals.POSTFIX_EXPRESSION__LEFT,
                    TranslatorException.CONSUME);
        }
        if (null != expr.getCall()) {
            result = processFeatureCall(null, expr.getCall(), context, parent);
            result = processCallsAndAccess(result, expr.getFCalls(),
                    expr.getAccess(), context, parent);
        } else {
            result = processPrimaryExpression(expr.getLeft(), context, parent);
        }
        return result;
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
        ConstraintSyntaxTree result = null;
        if (null != expr.getRefName()) {
            try {
                AbstractVariable var = context.findVariable(expr.getRefName(),
                        null);
                if (null != var) {
                    result = new ConstantValue(ValueFactory.createValue(
                            Reference.TYPE, var));
                } else {
                    throw new TranslatorException("reference '"
                            + expr.getRefName() + "' is undefined", expr,
                            IvmlPackage.Literals.PRIMARY_EXPRESSION__REF_NAME,
                            ErrorCodes.UNKNOWN_ELEMENT);
                }
            } catch (IvmlException e) {
                throw new TranslatorException(e, expr,
                        IvmlPackage.Literals.PRIMARY_EXPRESSION__REF_NAME);
            }
        } else if (null != expr.getEx()) {
            // process "( expr )"
            result = new Parenthesis(processExpression(expr.getEx(), context,
                    parent));
        } else if (null != expr.getIfEx()) {
            // process if-then-else expression by combining related expressions
            // into one node
            IfExpression ifExpr = expr.getIfEx();
            result = new IfThen(processExpression(ifExpr.getIfEx(), context,
                parent), processExpression(ifExpr.getThenEx(), context,
                    parent), processExpression(ifExpr.getElseEx(), context,
                        parent));
        } else if (null != expr.getLit()) {
            // process one of the various types of literals
            Value value = expr.getLit().getVal();
            EStructuralFeature causingFeature = IvmlPackage.Literals.PRIMARY_EXPRESSION__LIT;
            if (null != value.getBValue()) {
                causingFeature = IvmlPackage.Literals.PRIMARY_EXPRESSION__LIT;
            }
            result = context.resolveValue(value, expr, causingFeature);
            result = handleBasicComment(expr.getLit(), result);
        }
        result = processCallsAndAccess(result, expr.getCalls(), expr.getAccess(), context, parent);
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
        ConstraintSyntaxTree result = lhs;
        if (null != calls) {
            for (Call call : calls) {
                if (null != call.getCall()) {
                    result = processFeatureCall(result, call.getCall(), context, parent);
                } else if (null != call.getSetOp()) {
                    result = processSetOp(result, call.getSetOp(), context, parent);
                } else if (null != call.getArrayEx()) {
                    // operation is obvious, no custom operation holder
                    result = new OCLFeatureCall(result, OclKeyWords.INDEX_ACCESS, 
                        processExpression(call.getArrayEx(), context, parent));
                }
            }
        }
        if (null != access) {
            result = processAccess(result, access, context, parent);
        }
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
        ConstraintSyntaxTree result = null;
        String name = access.getName();
        try {
            IDatatype type = lhs.getContainedType();
            if (null == type) {
                type = lhs.inferDatatype();
            } // else: lhs is a type expression, inferDatatype would lead to a
              // MetaType
            if (Compound.TYPE.isAssignableFrom(type) && hasSlot((Compound) type, name)) {
                result = new CompoundAccess(lhs, name);
            } else if (Enum.TYPE.isAssignableFrom(type) && hasLiteral((Enum) type, name)) {
                result = new ConstantValue(ValueFactory.createValue(type, name));
            } else {
                Attribute attr = ModelElement.findAttribute(lhs, name);
                if (null == attr) {
                    attr = ModelElement.findAttribute(context.getProject(), name);
                }
                if (null != attr) {
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
        return result;
    }

    /**
     * Processes a collection initializer.
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
    private ConstraintSyntaxTree processCollectionInitializer(IDatatype lhsType,
            EObject expr, CollectionInitializer initializer, TypeContext context,
            IModelElement parent) throws TranslatorException, IvmlException {
        ConstraintSyntaxTree result;
        if (Constants.USE_NEW_LITERALS) {
            // TODO when decided, join method here
            result = processLiteralCollection(lhsType, initializer, context, parent);        
        } else {
            Object[] values = collectionInitializerToArray(lhsType, initializer, context, parent);
            values = translateToValues(values);
            result = new ConstantValue(ValueFactory.createValue(lhsType, values));
        }
        return result;
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
                }
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
    private IDatatype getSpecificType(IDatatype lhsType, CollectionInitializer initializer, TypeContext context) 
        throws TranslatorException {
        IDatatype specificType = null;
        // this may now initialize either a container or a compound
        // the grammar prescribes only values but not expressions!
        if (null != initializer.getType()) {
            try {
                String sTypeName = Utils.getQualifiedNameString(initializer.getType());
                specificType = context.findType(sTypeName, null);
                if (!lhsType.isAssignableFrom(specificType)) {
                    throw new TranslatorException("collection type '" + IvmlDatatypeVisitor.getQualifiedType(lhsType)
                        + "' does not match specified entry type'" + sTypeName + "'", initializer,
                        IvmlPackage.Literals.COLLECTION_INITIALIZER__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                }
                lhsType = specificType;
            } catch (ModelQueryException e) {
                throw new TranslatorException(e, initializer, IvmlPackage.Literals.COLLECTION_INITIALIZER__TYPE);
            }
        }
        return specificType;
    }
    
    /**
     * Transforms a collection initializer to an array.
     * 
     * @param lhsType the left hand side which defines the type (part)
     * @param initializer the initializer
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @return the created array
     * @throws TranslatorException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     * @throws CSTSemanticException in case that the processing of the <code>initializer</code> 
     *   must be terminated abnormally
     */
    private Object[] collectionInitializerToArray(IDatatype lhsType, CollectionInitializer initializer, 
        TypeContext context, IModelElement parent) throws TranslatorException, CSTSemanticException {
        Object[] result = null;
        IDatatype specificType = getSpecificType(lhsType, initializer, context);
        if (null != specificType) {
            lhsType = specificType;            
        }
        ExpressionListOrRange init = initializer.getInit();
        int withoutId = 0;
        int withId = 0;
        int entryCount = 0;
        EList<ExpressionListEntry> entryList;
        if (null != init) {
            entryList = init.getList();
            entryCount = entryList.size();
            for (int e = 0; e < entryCount; e++) {
                String name = entryList.get(e).getName();
                if (null != name) {
                    withId++;
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
            throw new TranslatorException("value entries must either all have names or none", init, 
                IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE, ErrorCodes.INITIALIZER_CONSISTENCY);
        }
        boolean isContainer = lhsType instanceof Container;
        boolean isCompound = lhsType instanceof Compound;
        if (isContainer || isCompound) {
            if (isContainer && allWithId && entryCount > 0) {
                throw new TranslatorException("container initialization must not have name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, ErrorCodes.INITIALIZER_CONSISTENCY);
            } else if (isCompound && allWithoutId && entryCount > 0) {
                throw new TranslatorException("compound initialization requires name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_OR_RANGE__LIST, ErrorCodes.INITIALIZER_CONSISTENCY);
            }
            int typeAddOn = 0;
            if (isCompound && null != specificType) {
                typeAddOn += 2;
            }
            result = new Object[typeAddOn + (allWithId ? 2 * entryCount : entryCount)];
            int valuePos = 0;
            if (typeAddOn > 0) {
                result[valuePos++] = CompoundValue.SPECIAL_SLOT_NAME_TYPE;
                result[valuePos++] = specificType;
            }
            for (int e = 0; e < entryCount; e++) {
                ExpressionListEntry entry = entryList.get(e);
                DecisionVariableDeclaration field = null;
                if (isCompound) {
                    field = ((Compound) lhsType).getElement(entry.getName());
                    if (null == field) {
                        throw new TranslatorException("field '" + entry.getName() + "' does not exist in '"
                            + lhsType.getName() + "'", entry, IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE,
                            ErrorCodes.UNKNOWN_ELEMENT);
                    }
                }
                if (null != entry.getName()) {
                    result[valuePos++] = entry.getName();
                }
                if (null != entry.getValue()) {
                    result[valuePos++] = processLogicalExpression(entry.getValue(), context, parent);
                }
                if (null != entry.getCollection()) {
                    IDatatype contained;
                    if (null != field) {
                        contained = field.getType();
                    } else {
                        contained = ((Container) lhsType).getContainedType();
                    }
                    result[valuePos++] = collectionInitializerToArray(
                        contained, entry.getCollection(), context, parent);
                }
            }
        } else {
            throwNonContainerException(lhsType);
        }
        return result;
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
    private ConstraintSyntaxTree processLiteralCollection(IDatatype lhsType, CollectionInitializer initializer, 
        TypeContext context, IModelElement parent) throws TranslatorException, CSTSemanticException, IvmlException {
        ConstraintSyntaxTree result = null;
        IDatatype specificType = getSpecificType(lhsType, initializer, context);
        if (null != specificType) {
            lhsType = specificType;            
        } 
        
        ExpressionListOrRange init = initializer.getInit();
        int withoutId = 0;
        int withId = 0;
        int entryCount = 0;
        EList<ExpressionListEntry> entryList;
        if (null != init) {
            entryList = init.getList();
            entryCount = entryList.size();
            for (int e = 0; e < entryCount; e++) {
                String name = entryList.get(e).getName();
                if (null != name) {
                    withId++;
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
                IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE, ErrorCodes.INITIALIZER_CONSISTENCY);
        }
        if (lhsType instanceof Container) {
            if (allWithId && entryCount > 0) {
                throw new TranslatorException(
                    "container initialization must not have name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE, ErrorCodes.INITIALIZER_CONSISTENCY);
            } 
            result = processContainerInitializer(lhsType, context, parent, entryList);
        } else if (lhsType instanceof Compound) {
            if (allWithoutId && entryCount > 0) {
                throw new TranslatorException("compound initialization requires name-value assignments", init,
                    IvmlPackage.Literals.EXPRESSION_LIST_ENTRY__VALUE, ErrorCodes.INITIALIZER_CONSISTENCY);
            }
            result = processCompoundInitializer(lhsType, context, parent, specificType, entryList);
        } else {
            throwNonContainerException(lhsType);
        }
        return result;
    }

    /**
     * Processes a compound initializer.
     * 
     * @param lhsType the left hand side type
     * @param context the type context for resolving variables etc.
     * @param parent the parent element
     * @param specificType the specific type of the container
     * @param entryList the entries of the iniutializer
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
        ConstraintSyntaxTree result;
        Compound comp = (Compound) lhsType;
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
                exprs[e] = processLogicalExpression(entry.getValue(), context, parent);
            }
            if (null != entry.getCollection()) {
                exprs[e] = processLiteralCollection(slotDecls[e].getType(), entry.getCollection(), context, parent);
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
        ConstraintSyntaxTree result;
        int entryCount = (null == entryList ? 0 : entryList.size());
        ConstraintSyntaxTree[] exprs = new ConstraintSyntaxTree[entryCount];
        IDatatype contained = ((Container) lhsType).getContainedType();
        for (int e = 0; e < entryCount; e++) {
            ExpressionListEntry entry = entryList.get(e);
            if (null != entry.getValue()) {
                exprs[e] = processLogicalExpression(entry.getValue(), context, parent);
            }
            if (null != entry.getCollection()) {
                exprs[e] = processLiteralCollection(contained, entry.getCollection(), context, parent);
            }
        }
        if (allConstant(exprs)) {
            Object[] obj = new Object[exprs.length];
            for (int e = 0; e < obj.length; e++) {
                obj[e] = exprs[e];
            }
            result = new ConstantValue(ValueFactory.createValue(lhsType, translateToValues(obj)));
        } else {
            result = new ContainerInitializer((Container) lhsType, exprs);
        }
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
     * Throws a non-container exception.
     * 
     * @param lhsType the left hand side
     * @throws CSTSemanticException the exception
     */
    private void throwNonContainerException(IDatatype lhsType) throws CSTSemanticException {
        if (null == lhsType) {
            throw new CSTSemanticException("internal null", ErrorCodes.TYPE_CONSISTENCY);
        }
        throw new CSTSemanticException("type '" + IvmlDatatypeVisitor.getUniqueType(lhsType)
            + "' cannot be applied here", ErrorCodes.TYPE_CONSISTENCY);        
    }

}
