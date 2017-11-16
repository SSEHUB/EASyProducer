package de.uni_hildesheim.sse.translation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ivml.AnnotateTo;
import de.uni_hildesheim.sse.ivml.AttrAssignment;
import de.uni_hildesheim.sse.ivml.AttrAssignmentPart;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.Eval;
import de.uni_hildesheim.sse.ivml.Export;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.FreezeStatement;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.InterfaceDeclaration;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.OpDefParameter;
import de.uni_hildesheim.sse.ivml.OpDefStatement;
import de.uni_hildesheim.sse.ivml.QualifiedName;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.TypedefCompound;
import de.uni_hildesheim.sse.ivml.TypedefEnum;
import de.uni_hildesheim.sse.ivml.TypedefEnumLiteral;
import de.uni_hildesheim.sse.ivml.TypedefMapping;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.ivml.VariableDeclaration;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;
import de.uni_hildesheim.sse.ivml.VersionStmt;
import de.uni_hildesheim.sse.translation.Utils.SplitResult;
import net.ssehub.easy.basics.messages.IIdentifiable;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IDeferredModelLoader;
import net.ssehub.easy.basics.modelManagement.IModelProcessingListener;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.ConstantDecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IPartialEvaluable;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.StructuredComment;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.CustomDynamicOperation;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Implements a ECore-to-IVML translator. Please note that errors which occur
 * during translation are not signalled as individual exceptions but collected
 * and accessible through {@link #getMessage(int)}.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends net.ssehub.easy.dslCore.translation.ModelTranslator<ExpressionTranslator> {

    private Map<TypedefCompound, Compound> compoundMapping = new HashMap<TypedefCompound, Compound>();
    private Map<AttrAssignment, AttributeAssignment> assignmentMapping 
        = new HashMap<AttrAssignment, AttributeAssignment>();
   
    private Map<VariableDeclarationPart, DecisionVariableDeclaration> varMapping = 
        new HashMap<VariableDeclarationPart, DecisionVariableDeclaration>();
    
    private Map<TypedefMapping, DerivedDatatype> typedefMapping = new HashMap<TypedefMapping, DerivedDatatype>();
    
    private Set<EObject> definitionsProcessed = new HashSet<EObject>();
    private IModelProcessingListener<Project> onLoadMsgCleanupListener = new IModelProcessingListener<Project>() {

        @Override
        public void notifyProcessingStarted(ModelInfo<Project> info, Type type) {
            if (Type.LOADING == type) {
                expressionTranslator.clearMessages(info);
            }
        }

        @Override
        public void notifyProcessingEnded(ModelInfo<Project> info, Type type) {
            // nothing to do
        }
        
    };

    /**
     * Implements a translation result enabling deferred model loading. As long as {@link #completeLoading()} is not 
     * called, the model instances stored in this instance are not ready for use.
     * 
     * @author Holger Eichelberger
     */
    public static class Result implements IDeferredModelLoader<Project> {

        private List<ResultEntry> entries = new ArrayList<ResultEntry>();
        private ModelTranslator translator;
        
        /**
         * Creates a result instance representing the parse result for multiple projects and enables deferred loading.
         * 
         * @param translator the model translator instance
         */
        private Result(ModelTranslator translator) {
            this.translator = translator;
        }

        /**
         * Adds a partially completed xText project and an IVML project in terms of an <code>entry</code>.
         * 
         * @param entry the entry to be added
         */
        private void add(ResultEntry entry) {
            entries.add(entry);
        }
        
        @Override
        public void completeLoading() {
            for (int e = 0; e < entries.size(); e++) {
                entries.get(e).completeLoading(this);
            }
        }
        
        /**
         * Creates the translation result.
         * 
         * @return the translation result
         */
        public TranslationResult<Project> createTranslationResult() {
            List<Project> projects = new ArrayList<Project>();
            for (int e = 0; e < entries.size(); e++) {
                projects.add(entries.get(e).getProject());
            }
            return new TranslationResult<Project>(projects, translator);
        }
        
        /**
         * Returns the translator instance.
         * 
         * @return the translator instance
         */
        ModelTranslator getTranslator() {
            return translator;
        }
        
    }
        
    /**
     * Contains an expression translator instance. Expression are realized in an
     * own class due to separation of concerns.
     */
    private ExpressionTranslator expressionTranslator;

    /**
     * Creates a model translator instance.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator());
        this.expressionTranslator = getExpressionTranslator();
    }

    /**
     * Creates a variability model from a given variability unit. This is the
     * top-level entry method.
     * 
     * @param unit
     *            the variability unit to be translated
     * @param uri
     *            the URI of the project to resolve (in order to find the
     *            closest project, may be <b>null</b>)
     * @param registerSuccessful
     *            successfully created models shall be registered in
     *            {@link VarModel}
     * @param impResolver the import resolver (may be <b>null</b> to use a new default import resolver)           
     * @return the corresponding variability model
     */
    public Result createModel(VariabilityUnit unit, URI uri, boolean registerSuccessful, 
        ImportResolver<Project> impResolver) {
        Result result = new Result(this);
        if (null != unit.getProjects()) {
            HashSet<String> names = new HashSet<String>();
            for (de.uni_hildesheim.sse.ivml.Project p : unit.getProjects()) {
                String name = p.getName();
                if (!names.contains(name)) {
                    result.add(createProject(p, uri, registerSuccessful, unit.getProjects(), impResolver));
                    names.add(name);
                } else {
                    error("project '" + name + "' occurs multiple times in the same file", p,
                        IvmlPackage.Literals.PROJECT__NAME, ErrorCodes.NAME_CLASH);
                }
            }
        }
        return result;
    }
    
    /**
     * Creates an empty result for failure cases.
     * 
     * @return an empty result
     */
    public Result createEmptyResult() {
        return new Result(this);
    }

    /**
     * Handles the comments assigned to the EMF AST element <code>object</code>.
     * 
     * @param object the EMF AST element to analyze
     * @param context the parent context of the new comment in the IVML object model
     * @return the resulting comment (may be <b>null</b>)
     */
    private Comment handleBasicComment(EObject object, TypeContext context) {
        Comment comment = CommentUtils.toComment(object, context.getProject());
        if (null != comment) {
            context.addToProject(null, null, comment);
        }
        return comment;
    }
    
    /**
     * Assigns a <code>comment</code> to an <code>element</code> directly assigned to a <code>project</code> and 
     * ensures the existence the structured comment for the project if required.
     * @param project the project to assign to
     * @param element the element to assign to
     * @param comment the comment to be assigned
     */
    private void assignProjectComment(Project project, Object element, Comment comment) {
        StructuredComment sComment = project.getComments();
        if (null == sComment) {
            sComment = new StructuredComment(null, project);
        }
        sComment.assignComment(element, comment);
    }

    /**
     * Creates a variability model from a given ECore representation of a
     * project. This method is intended as a second-level entry to the
     * translation process.
     * 
     * @param project
     *            the project to be translated.
     * @param uri
     *            the URI of the project to resolve (in order to find the
     *            closest project, may be <b>null</b>)
     * @param registerSuccessful
     *            successfully created models shall be registered in
     *            {@link VarModel}
     * @param inProgress
     *            the projects currently being processed at once
     * @param impResolver the import resolver to use (may be <b>null</b> to use a new default import resolver)
     * @return the corresponding IVML project
     */
    private ResultEntry createProject(de.uni_hildesheim.sse.ivml.Project project,
            URI uri, boolean registerSuccessful, List<de.uni_hildesheim.sse.ivml.Project> inProgress, 
            ImportResolver<Project> impResolver) {
        int errorCount = getErrorCount();
        Project result = new Project(project.getName());
        TypeContext context = new TypeContext(result, this);
        result.setComments(CommentUtils.toStructuredComment(project, result));
        if (null != project.getVersion()) {
            try {
                Version version = new Version(project.getVersion().getVersion());
                result.setVersion(version);
                assignProjectComment(result, version, CommentUtils.toComment(project.getVersion(), result));
            } catch (VersionFormatException e) {
                error(e, project, IvmlPackage.Literals.PROJECT__VERSION);
            }
        }
        // resolve here
        // processing sequence ensures resolved types (but not sequence in IVML
        // model, might need reordering)
        for (ImportStmt importStmt : project.getImports()) {
            processImport(importStmt, context);
        }
        for (ConflictStmt importStmt : project.getConflicts()) {
            processConflict(importStmt, context);
        }
        
        Utils.SplitResult splitRes = Utils.split(project.getContents().getElements());
        resolveImports(project, result, uri, inProgress, impResolver, false);
        processDefinitions(splitRes.getTypedefs(), splitRes.getVarDecls(), splitRes.getAttrAssignments(), 
            context, false);
        resolveImports(project, result, uri, inProgress, impResolver, true);
        processDefinitions(splitRes.getTypedefs(), splitRes.getVarDecls(), splitRes.getAttrAssignments(), 
            context, true);
        for (InterfaceDeclaration iface : project.getInterfaces()) {
            processInterface(iface, context);
        }
        checkCompounds(project, result);
        
        // requires completeLoading!

        ResultEntry entry = new ResultEntry(project, result, context, splitRes);
        if (registerSuccessful) {
            entry.setRegistrationInfo(uri, errorCount);
        }
        return entry;
    }
    
    /**
     * Checks the compounds in this project.
     * 
     * @param eProject the AST project instance to check (fallback for messages)
     * @param project the corresponding IVML project instance
     */
    private void checkCompounds(de.uni_hildesheim.sse.ivml.Project eProject, Project project) {
        Map<String, DecisionVariableDeclaration> decls = new HashMap<String, DecisionVariableDeclaration>();
        Map<Compound, TypedefCompound> cmpMapping = new HashMap<Compound, TypedefCompound>();
        for (Map.Entry<TypedefCompound, Compound> e : compoundMapping.entrySet()) {
            cmpMapping.put(e.getValue(), e.getKey());
        }
        for (int e = 0; e < project.getElementCount(); e++) {
            ContainableModelElement elt = project.getElement(e);
            if (elt instanceof Compound) {
                checkCompound(eProject, (Compound) elt, cmpMapping, decls);
            }
            decls.clear();
        }
    }

    /**
     * Checks the given compound. Due to the dynamic resolution sequence, we perform a post-check for hierarchical
     * compound properties.
     * 
     * @param eProject the AST project instance to check (fallback for messages)
     * @param cmp the compound to check
     * @param cmpMapping mapping between compounds and related AST objects for error identification
     * @param done already known/checked slot declarations
     */
    private void checkCompound(de.uni_hildesheim.sse.ivml.Project eProject, Compound cmp, 
        Map<Compound, TypedefCompound> cmpMapping, Map<String, DecisionVariableDeclaration> done) {
        for (int d = 0; d < cmp.getDeclarationCount(); d++) {
            DecisionVariableDeclaration decl = cmp.getDeclaration(d);
            String name = decl.getName();
            DecisionVariableDeclaration known = done.get(name);
            if (null == known) {
                done.put(name, decl);
            } else {
                if (!decl.getType().isAssignableFrom(known.getType())) {
                    TypedefCompound tdC = cmpMapping.get(known.getParent());
                    List<EObject> elts = tdC.getElements();
                    EObject cause = eProject;
                    EStructuralFeature feature = IvmlPackage.Literals.PROJECT__NAME;
                    VariableDeclaration slot = null;
                    for (int e = 0; null == slot && e < elts.size(); e++) {
                        EObject elt = elts.get(e);
                        if (elt instanceof VariableDeclaration) {
                            VariableDeclaration vd = (VariableDeclaration) elt;
                            List<VariableDeclarationPart> parts = vd.getDecls();
                            for (int p = 0; null == slot && p < parts.size(); p++) {
                                if (name.equals(parts.get(p).getName())) {
                                    slot = vd;
                                    cause = slot;
                                    feature = IvmlPackage.Literals.VARIABLE_DECLARATION_PART__NAME;
                                }
                            }
                        }
                    }
                    error("Slot '" + name + "' in compound '" + known.getParent().getName() 
                        + "' does not refine slot with same name in refining compound '" + cmp.getName() + "'", 
                        cause, feature, ValueDoesNotMatchTypeException.TYPE_MISMATCH);
                }
            }
        }
        if (null != cmp.getRefines()) {
            checkCompound(eProject, cmp.getRefines(), cmpMapping, done);
        }
    }
    
    /**
     * Complete loading of a given model.
     * 
     * @param entry the result entry on which to complete loading
     */
    void completeLoading(ResultEntry entry) {
        Utils.SplitResult splitRes = entry.getSplitResult();
        TypeContext context = entry.getContext();
        //eProject, project, context, splitResult
        if (null != splitRes.getAttrs()) {
            for (AnnotateTo annotation : splitRes.getAttrs()) {
                processAnnotation(annotation, context);
            }
        }
        if (null != splitRes.getOpdefs()) {
            processOpDefs(splitRes.getOpdefs(), context);
        }
        processExpressions(splitRes.getTypedefs(), splitRes.getAttrAssignments(), splitRes.getExprs(), context);
        if (null != splitRes.getEvals()) {
            for (Eval eval : splitRes.getEvals()) {
                processEval(eval, context, null);
            }
        }
        if (null != splitRes.getFreezes()) {
            for (Freeze freeze : splitRes.getFreezes()) {
                processFreeze(freeze, context);
            }
        }

        context.sortProjectElements(entry.getEProject().getContents().getElements());
        context.clear();

        entry.registerIfNeeded(getErrorCount());
    }

    /**
     * Resolve the imports.
     * 
     * @param input the Ecore project representation
     * @param project the target project
     * @param uri the physical URI of the project
     * @param inProgress the other projects being resolved at once (in order to avoid loops)
     * @param impResolver the import resolver to use (may be <b>null</b> to use a new default import resolver)
     * @param transitiveLoading with or without transitive loading (false = lazy, true = force)
     */
    private void resolveImports(de.uni_hildesheim.sse.ivml.Project input, Project project, URI uri,
        List<de.uni_hildesheim.sse.ivml.Project> inProgress, ImportResolver<Project> impResolver, 
        boolean transitiveLoading) {
        if (Utils.isImportResolutionEnabled()) { // as long as initialization for Editor is not final
            List<ModelInfo<Project>> infoInProgress = new ArrayList<ModelInfo<Project>>();
            AvailableModels<Project> available = VarModel.INSTANCE.availableModels();
            for (int p = 0; p < inProgress.size(); p++) {
                de.uni_hildesheim.sse.ivml.Project pr = inProgress.get(p);
                VersionStmt versionStatement = pr.getVersion();
                String vString;
                if (null == versionStatement) {
                    vString = null;
                } else {
                    vString = versionStatement.getVersion();
                }
                try {
                    List<ModelInfo<Project>> info = available.getModelInfo(pr.getName(), vString);
                    if (null != info) {
                        infoInProgress.addAll(info);
                    }
                } catch (VersionFormatException e) {
                    error(e.getMessage(), input, IvmlPackage.Literals.PROJECT__IMPORTS, ErrorCodes.IMPORT);
                }
            }
            IModelProcessingListener<Project> oldListener = impResolver.setProcessingListener(onLoadMsgCleanupListener);
            List<IMessage> resolutionMessages = VarModel.INSTANCE.resolveImports(project, uri, infoInProgress, 
                impResolver, transitiveLoading);
            impResolver.setProcessingListener(oldListener);
            for (int i = 0; i < resolutionMessages.size(); i++) {
                collect(resolutionMessages.get(i), input, IvmlPackage.Literals.PROJECT__IMPORTS, ErrorCodes.IMPORT);
            }
        }
    }
    
    /**
     * Processes an expression statement and adds the result to the project in
     * <code>context</code>.
     * 
     * @param statement the statement to process
     * @param context the type context to be considered
     * @param parent the actual (intended) parent of the constraint to be created
     * @param internal whether the constraint to be created is internal (and shall not be visible to the user)
     * @throws TranslatorException in case that the processing of the <code>statement</code>
     *   was terminated abnormally
     */
    public void processExpressionStatement(ExpressionStatement statement, TypeContext context, 
        IDecisionVariableContainer parent, boolean internal) throws TranslatorException {
        if (null != statement.getExpr()) {
            IModelElement cParent = parent;
            if (null == cParent) {
                cParent = context.getProject();
            }
            try {
                Comment comment = CommentUtils.toComment(statement, parent);
                Constraint constraint = new Constraint(cParent);
                constraint.setConsSyntax(expressionTranslator.processExpression(
                    statement.getExpr(), context, constraint));
                if (null != parent) {
                    parent.add(comment);
                    parent.addConstraint(constraint, internal);
                    context.registerSorter(parent, statement, comment, constraint);
                } else {
                    if (null != comment) {
                        context.addToProject(null, null, comment);
                    }
                    context.addToProject(statement, comment, constraint);
                }
            } catch (IvmlException e) {
                error(e, statement, IvmlPackage.Literals.EXPRESSION_STATEMENT__EXPR);
            }
        }
    }

    /**
     * Processes all expressions at once and delegates to further processing methods.
     * 
     * @param typedefs the type definitions for which expressions shall be resolved
     * @param assignments the attribute assignments for which expressions shall be resolved
     * @param exprs the expressions to be resolved
     * @param context the type resolution context
     * 
     * @see #processAttributeAssignmentExpressions(List, TypeContext)
     * @see #processTypeDefExpressions(List, TypeContext)
     */
    private void processExpressions(List<Typedef> typedefs, List<AttrAssignment> assignments, 
        List<ExpressionStatement> exprs, TypeContext context) {
        // translate constraints in compounds
        if (null != typedefs) {
            processTypeDefExpressions(typedefs, context);
        }
        compoundMapping.clear();
        if (null != assignments) {
            processAttributeAssignmentExpressions(assignments, context);
        }
        assignmentMapping.clear();
        // translate constraints in decision variables
        for (Map.Entry<VariableDeclarationPart, DecisionVariableDeclaration> entry : varMapping.entrySet()) {
            DecisionVariableDeclaration decVar = entry.getValue();
            VariableDeclarationPart part = entry.getKey();
            try {
                int layers = context.pushParent(decVar);
                expressionTranslator.initLevel();
                ConstraintSyntaxTree dfltExpr = expressionTranslator.processExpression(decVar.getType(), 
                    part.getDefault(), context, decVar.getParent());
                IDatatype dfltExprType = dfltExpr.inferDatatype();
                String rhsError = null;
                if (Reference.TYPE.isAssignableFrom(decVar.getType()) && AnyType.TYPE == dfltExprType 
                    && !ConstantValue.isNull(dfltExpr)) { // some kind of compound may be used
                    rhsError = "";
                }
                if (null != rhsError || !decVar.getType().isAssignableFrom(dfltExprType)) {
                    if (null == rhsError) {
                        rhsError = "of type '" + IvmlDatatypeVisitor.getUnqualifiedType(dfltExprType) + "' ";
                    }
                    throw new TranslatorException("cannot assign the expression " + rhsError  
                        + "to a variable of type '" 
                        + IvmlDatatypeVisitor.getUnqualifiedType(decVar.getType()) + "'", part, 
                        IvmlPackage.Literals.VARIABLE_DECLARATION_PART__DEFAULT, ErrorCodes.TYPE_CONSISTENCY);
                }
                decVar.setValue(dfltExpr);
                if (!ConstraintType.TYPE.isAssignableFrom(decVar.getType())) {
                    expressionTranslator.errorAboutTopLevelWarning(part, 
                        IvmlPackage.Literals.VARIABLE_DECLARATION_PART__DEFAULT);
                }
                context.popLayer(layers);
            } catch (IvmlException e) {
                error(e, part, IvmlPackage.Literals.VARIABLE_DECLARATION_PART__DEFAULT);
            } catch (TranslatorException e) {
                error(e);
            }
        }
        varMapping.clear();

        // translate constraints in typedefs
        for (Map.Entry<TypedefMapping, DerivedDatatype> entry : typedefMapping.entrySet()) {
            TypedefMapping mapping = entry.getKey();
            DerivedDatatype type = entry.getValue();
            context.pushLayer(null);
            try {
                context.addToContext(type.getTypeDeclaration());
                Expression expression = mapping.getConstraint().getExpressions();
                if (null != expression) {
                    Constraint[] constraints = new Constraint[1];
                    constraints[0] = new Constraint(type);
                    constraints[0].setConsSyntax(expressionTranslator.processExpression(expression, context,
                        constraints[0]));
                    type.setConstraints(constraints);
                }
            } catch (IvmlException e) {
                error(e, mapping, IvmlPackage.Literals.TYPEDEF_MAPPING__CONSTRAINT);
            } catch (TranslatorException e) {
                error(e);
            } finally {
                context.popLayer();
            }
        }
        typedefMapping.clear();

        // translate expressions in project
        if (null != exprs) {
            for (ExpressionStatement ex : exprs) {
                try {
                    processExpressionStatement(ex, context, null, false);
                } catch (TranslatorException e) {
                    error(e);
                }
            }
        }
    }

    /**
     * Processes all the expressions of type definitions.
     * 
     * @param typedefs the type definitions for which expressions shall be resolved
     * @param context the type resolution context
     * 
     * @see #processExpressions(List, List, List, TypeContext)
     */
    private void processTypeDefExpressions(List<Typedef> typedefs, TypeContext context) {
        for (Typedef typedef : typedefs) {
            TypedefCompound tCompound = typedef.getTCompound();
            if (null != tCompound) {
                Compound compound = compoundMapping.get(typedef.getTCompound());
                if (null != compound) {
                    context.pushLayer(compound);
                    context.addToContext(compound);
                    SplitResult split = Utils.split(tCompound.getElements());
                    if (null != split.getExprs()) {
                        for (ExpressionStatement expression : split.getExprs()) {
                            try {
                                processExpressionStatement(expression, context, compound, false);
                            } catch (TranslatorException e) {
                                error(e); // in case of problems... stop, throw but also pop layer
                            }
                        }
                    }
                    if (null != split.getAttrAssignments()) {
                        processAttributeAssignmentExpressions(split.getAttrAssignments(), context);
                    }
                    if (null != split.getEvals()) {
                        for (Eval eval : split.getEvals()) {
                            processEval(eval, context, compound);
                        }
                    }
                    context.popLayer();
                    context.closeSorter(compound, tCompound.getElements());
                }
            }
        }
    }

    /**
     * Processes all the expressions of attribute assignments.
     * 
     * @param assignments the attribute assignments for which expressions shall be resolved
     * @param context the type resolution context
     * 
     * @see #processExpressions(List, List, List, TypeContext)
     */
    private void processAttributeAssignmentExpressions(List<AttrAssignment> assignments, TypeContext context) {
        for (AttrAssignment assgn : assignments) {
            AttributeAssignment assignment = assignmentMapping.get(assgn);
            if (null != assignment) { // may happen if resolving the inner parts of the assignment fails
                context.pushLayer(null);
                context.addToContext(assignment);
                try {
                    for (AttrAssignmentPart part : assgn.getParts()) {
                        expressionTranslator.initLevel();
                        ConstraintSyntaxTree valueEx = expressionTranslator.processLogicalExpression(
                            part.getValue(), context, assignment);
                        expressionTranslator.errorAboutTopLevelWarning(part, 
                            IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__VALUE);
                        AttributeAssignment.Assignment data = new AttributeAssignment.Assignment(part.getName(), 
                            IvmlKeyWords.ASSIGNMENT, valueEx);
                        assignment.add(data);
                        for (int e = 0; e < assignment.getElementCount(); e++) {
                            try {
                                DecisionVariableDeclaration var = assignment.getElement(e);
                                String attributeName = var.getName() + "." + data.getName();
                                AbstractVariable attribute = context.findVariable(attributeName, null);
                                if (null == attribute || !(attribute instanceof Attribute)) {
                                    throw new UnknownVariableException(attributeName, part, 
                                        IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__NAME);
                                }
                                ConstraintSyntaxTree cst = new OCLFeatureCall(
                                    context.obtainVariable(attribute), data.getOperation(), data.getExpression());
                                Constraint constraint = new Constraint(assignment);
                                constraint.setConsSyntax(cst);
                                assignment.addConstraint(constraint, true);
                            } catch (ModelQueryException ex) {
                                error(ex, part, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__NAME);
                            } catch (CSTSemanticException ex) {
                                error(ex, part, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__NAME);
                            }
                        }
                    }
                    SplitResult split = Utils.split(assgn.getElements());
                    if (null != split.getExprs()) {
                        for (ExpressionStatement expression : split.getExprs()) {
                            try {
                                processExpressionStatement(expression, context, assignment, false);
                            } catch (TranslatorException e) {
                                error(e); // in case of problems... stop, throw but also pop layer
                            }
                        }
                    }
                    if (null != split.getAttrAssignments()) {
                        processAttributeAssignmentExpressions(split.getAttrAssignments(), context);
                    }
                } catch (TranslatorException e) {
                    error(e); // in case of problems... stop, notify but also pop layer
                } finally  {
                    context.popLayer();
                    context.closeSorter(assignment, assgn.getElements());
                }
            }
        }
    }

    /**
     * Resolve dependencies among type definitions and resolve types in proper
     * sequence.
     * 
     * @param typedefs the type definitions
     * @param vardecls the variable declarations
     * @param assignments the assignments
     * @param context the type resolution context
     * @param force if creation (and related errors) shall be forced or just tested and created on best-effort
     */
    private void processDefinitions(List<Typedef> typedefs, List<VariableDeclaration> vardecls, 
        List<AttrAssignment> assignments, TypeContext context, boolean force) {
        List<Typedef> typesToDo = new LinkedList<Typedef>();
        if (null != typedefs) {
            // process enums first - no type dependencies
            for (Typedef typedef : typedefs) {
                if (null != typedef.getTEnum() && !definitionsProcessed.contains(typedef)) {
                    try {
                        processEnum(typedef.getTEnum(), context);
                        definitionsProcessed.add(typedef);
                    } catch (TranslatorException e) {
                        if (force) {
                            error(e);
                        }
                    }
                } else if (null != typedef.getTMapping()) {
                    typesToDo.add(typedef);
                } else if (null != typedef.getTCompound()) {
                    typesToDo.add(typedef);
                }
            }
        }
        List<VariableDeclaration> declsToDo = new LinkedList<VariableDeclaration>();
        if (null != vardecls) {
            declsToDo.addAll(vardecls);
        }
        List<AttrAssignment> assgnToDo = new LinkedList<AttrAssignment>();
        if (null != assignments) {
            assgnToDo.addAll(assignments);
        }
        int typesCount;
        int declsCount;
        int assgnCount;
        do {
            typesCount = typesToDo.size();
            declsCount = declsToDo.size();
            assgnCount = assgnToDo.size();
            if (typesCount > 0) {
                processTypedefs(typesToDo, context, force);
            }
            if (declsCount > 0) {
                processVars(declsToDo, context, force);
            }
            if (assgnCount > 0) {
                processAttributeAssignments(assgnToDo, context, force);
            }
            if (typesCount == typesToDo.size()
                && declsCount == declsToDo.size()
                && assgnCount == assgnToDo.size()) {
                break; // break endless loop
            }
        } while (typesCount > 0 || declsCount > 0);
        if (force) {
            if (typesCount > 0) {
                processTypedefs(typesToDo, context, true);
            }
            if (declsCount > 0) {
                processVars(declsToDo, context, true);
            }
            if (assgnCount > 0) {
                processAttributeAssignments(assgnToDo, context, true);
            }
        }
    }
    
    /**
     * Resolve dependencies among operation definitions in proper sequence.
     * 
     * @param opDefs the operation definitions
     * @param context
     *            the type resolution context
     */
    private void processOpDefs(List<OpDefStatement> opDefs, TypeContext context) {
        // similar to processDefinition (join?)
        List<OpDefStatement> opsToDo = new LinkedList<OpDefStatement>();
        opsToDo.addAll(opDefs);
        int opsCount;
        do {
            opsCount = opsToDo.size();
            if (opsCount > 0) {
                processOpDefs(opsToDo, context, false);
            }
            if (opsCount == opsToDo.size()) {
                break; // break endless loop
            }
        } while (opsCount > 0);
        if (opsCount > 0) {
            processOpDefs(opsToDo, context, true);
        }
    }

    /**
     * Resolves operation definitions.
     * 
     * @param opDefs 
     *            the operation definitions to be resolved (to be modified as a side effect)
     * @param context
     *            the type context
     * @param force
     *            if creation (and related errors) shall be forced or just tested
     */
    private void processOpDefs(List<OpDefStatement> opDefs, TypeContext context, boolean force) {
        // similar to processTypedefs (join?)
        Iterator<OpDefStatement> opIter = opDefs.iterator();
        while (opIter.hasNext()) {
            OpDefStatement opDef = opIter.next();
            try {
                boolean done = false;
                done = processOpdef(opDef, context, force); 
                if (done) {
                    opIter.remove();
                }
            } catch (TranslatorException e) {
                opIter.remove(); // don't cause endless loops
                error(e);
            }

        }
    }

    /**
     * Resolves compound type definitions.
     * 
     * @param compounds
     *            the compounds to be resolved (to be modified as a side effect)
     * @param context
     *            the type context
     * @param force
     *            if creation (and related errors) shall be forced or just tested
     */
    private void processTypedefs(List<Typedef> compounds, TypeContext context, boolean force) {
        Iterator<Typedef> tdIter = compounds.iterator();
        while (tdIter.hasNext()) {
            Typedef typedef = tdIter.next();
            if (!definitionsProcessed.contains(typedef)) {
                try {
                    boolean done = false;
                    if (null != typedef.getTCompound()) {
                        done = processCompound(typedef.getTCompound(), context, force);
                    }
                    if (null != typedef.getTMapping()) {
                        done = processMapping(typedef.getTMapping(), context, force);
                    }
                    if (done) {
                        definitionsProcessed.add(typedef);
                        tdIter.remove();
                    }
                } catch (TranslatorException e) {
                    tdIter.remove(); // don't cause endless loops
                    error(e);
                }
            }
        }
    }

    /**
     * Resolves variable declarations.
     * 
     * @param vars the variables types to be resolved (to be modified as a side
     *        effect)
     * @param context the type context
     * @param force if creation (and related errors) shall be forced
     */
    private void processVars(List<VariableDeclaration> vars, TypeContext context, boolean force) {
        Iterator<VariableDeclaration> dIter = vars.iterator();
        while (dIter.hasNext()) {
            VariableDeclaration vDecl = dIter.next();
            if (!definitionsProcessed.contains(vDecl)) {
                try {
                    if (processVariableDeclaration(vDecl, context, null, true, force)) {
                        dIter.remove();
                        definitionsProcessed.add(vDecl);
                    }
                } catch (TranslatorException e) {
                    dIter.remove(); // don't cause endless loops
                    error(e);
                }
            }
        }
    }

    /**
     * Resolves attribute assignments.
     * 
     * @param assignments the attribute assignments to be resolved (to be modified as a side effect)
     * @param context the type context
     * @param force if creation (and related errors) shall be forced
     */
    private void processAttributeAssignments(List<AttrAssignment> assignments, TypeContext context, boolean force) {
        Iterator<AttrAssignment> aIter = assignments.iterator();
        while (aIter.hasNext()) {
            AttrAssignment assgn = aIter.next();
            if (!definitionsProcessed.contains(assgn)) {
                try {
                    if (processAttributeAssignment(assgn, context, null, true, force)) {
                        definitionsProcessed.add(assgn);
                        aIter.remove();
                    }
                } catch (TranslatorException e) {
                    aIter.remove(); // don't cause endless loops
                    error(e);
                }
            }
        }
    }
    
    /**
     * Turns variable declaration parts into strings for debugging.
     * 
     * @param parts the parts
     * @return the names
     */
    @SuppressWarnings("unused")
    private String toString(List<VariableDeclarationPart> parts) {
        String result = "";
        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) {
                result = result + ",";
            }
            result = result + parts.get(i).getName();
        }
        return result;
    }
    
    /**
     * Process variable declaration <code>decl</code> add IVML object model
     * instances to <code>project</code> or <code>compound</code>.
     * 
     * @param decl
     *            the variable declarations in the project
     * @param context
     *            the resolution context
     * @param container optional element to add the instances to instead of
     *            <code>project</code>
     * @param process
     *            <code>false</code> if the declaration shall not be created but
     *            only tested first, <code>true</code> if creation should be
     *            done in case that the variable declaration can be processed
     * @param force
     *            process anyway, don't test
     * @return <code>true</code> if the base type is yet available and the
     *         remaining type resolution was done, <code>false</code> if this
     *         typedef can actually not be processed
     * @throws TranslatorException in case of any problem during the translation
     */
    private boolean processVariableDeclaration(VariableDeclaration decl,
        TypeContext context, IDecisionVariableContainer container, boolean process,
        boolean force) throws TranslatorException {
        boolean ok = true;
        IDatatype type;
        try {
            type = context.resolveType(decl.getType());
        } catch (TranslatorException e) {
            type = null;
            if (!force) {
                ok = false;
            } else {
                throw e;
            }
        }
        ok &= (null != type);
        // expressions are processed in a separate step

        if ((ok && process) || force) {
            for (VariableDeclarationPart part : decl.getDecls()) {
                IModelElement parent;
                if (null != container) {
                    parent = container;
                } else {
                    parent = context.getProject();
                }
                Comment comment = null;
                if (null == container) { // handled outside as nested ;)
                    comment = handleBasicComment(decl, context);
                }
                expressionTranslator.warnDiscouragedNames(part.getName(), part, 
                    IvmlPackage.Literals.VARIABLE_DECLARATION_PART__NAME);
                DecisionVariableDeclaration decVar;
                if (null != decl.getConst()) {
                    if (null == part.getDefault()) {
                        throw new TranslatorException("constant '" + part.getName() + "' must be defined immediatley", 
                            part, IvmlPackage.Literals.VARIABLE_DECLARATION__CONST, ErrorCodes.REDEFINITION);
                    }
                    decVar = new ConstantDecisionVariableDeclaration(part.getName(), type, parent);
                } else {
                    decVar = new DecisionVariableDeclaration(part.getName(), type, parent);
                }
                if (null != part.getDefault()) {
                    varMapping.put(part, decVar);
                    // expressions are processed in a separate step
                }
                if (null != container) {
                    if (!container.add(decVar)) {
                        alreadyDefinedError(part.getName(), part,
                            IvmlPackage.Literals.VARIABLE_DECLARATION_PART__NAME);
                    }
                } else {
                    if (!context.addToProject(decl, comment, decVar)) {
                        alreadyDefinedError(part.getName(), part,
                            IvmlPackage.Literals.VARIABLE_DECLARATION_PART__NAME);
                    }
                }
            }
        }
        return ok;
    }

    /**
     * Emits an already defined error.
     * 
     * @param name the already defined name
     * @param object the causing Ecore object
     * @param feature the causing feature
     * @throws TranslatorException the corresponding exception always  
     */
    private void alreadyDefinedError(String name, EObject object, EStructuralFeature feature) 
        throws TranslatorException {
        throw new TranslatorException("name '" + name + "' is already defined in the same scope", object, feature, 
            ErrorCodes.REDEFINITION);
    }

    /**
     * Processes a custom operation definition and adds it to the type context.
     * 
     * @param op
     *            the operation definition
     * @param context
     *            the type context to be considered
     * @param force
     *            if creation (and related errors) shall be forced or just tested
     * @return <code>true</code> if processing was successful, <code>false</code>
     *         if (typically) a function is called which is currently not defined.
     * @throws TranslatorException
     *             in case that the processing of the <code>statement</code>
     *             must be terminated abnormally
     */
    protected boolean processOpdef(OpDefStatement op, TypeContext context, boolean force) throws TranslatorException {
        boolean done = true;
        Project project = context.getProject();
        IDatatype resultType = context.resolveType(op.getResult());
        context.pushLayer(null);
        Comment comment = handleBasicComment(op, context);
        OperationDefinition opDef = new OperationDefinition(context.getProject());
        try {
            DecisionVariableDeclaration[] params;
            EList<OpDefParameter> eParamList = op.getParam().getList();
            if (null == eParamList || 0 == eParamList.size()) {
                params = null;
            } else {
                params = new DecisionVariableDeclaration[eParamList.size()];
                for (int p = 0; p < params.length; p++) {
                    OpDefParameter parameter = eParamList.get(p);
                    IDatatype type = context.resolveType(parameter.getType());
                    params[p] = new DecisionVariableDeclaration(parameter.getId(), type, opDef);
                    if (null != parameter.getVal()) {
                        try {
                            params[p].setValue(expressionTranslator.processExpression(parameter.getVal(), 
                                context, opDef));
                            expressionTranslator.errorAboutTopLevelWarning(op, 
                                IvmlPackage.Literals.OP_DEF_PARAMETER__VAL);
                        } catch (IvmlException e) {
                            throw new TranslatorException(e, op, IvmlPackage.Literals.OP_DEF_PARAMETER__VAL);
                        }
                    }
                    context.addToContext(params[p]);
                }
                checkDefaultParamSequence(op, params);
            }
            IDatatype projectType = project.getType();
            CustomOperation operation;
            if (null != op.getStatic()) {
                operation = new CustomOperation(resultType, op.getId(), projectType, null, params);
            } else {
                operation = new CustomDynamicOperation(resultType, op.getId(), projectType, null, params);
            }
            opDef.setOperation(operation);
            context.addToContext(opDef);
            project.add(opDef);
            ConstraintSyntaxTree impl = processOpDefImpl(op, context, opDef);
            if (null != impl) {
                try {
                    IDatatype implType = impl.inferDatatype();
                    if (!resultType.isAssignableFrom(implType)) {
                        throw new TranslatorException("implementation type '" + unqualified(implType) 
                            + "' does not match operation result type '" + unqualified(resultType) + "'", op,
                            IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL, ErrorCodes.TYPE_CONSISTENCY);
                    }
                    operation.setFunction(impl);
                } catch (IvmlException e) {
                    throw new TranslatorException(e, op, IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL);
                }
                project.remove(opDef);
                if (findOperation(projectType, operation, false)) {
                    // does project define two similar operations?
                    throw new TranslatorException("operation '" + op.getId() + "' defined multiple times on project", 
                        op, IvmlPackage.Literals.OP_DEF_PARAMETER__TYPE, ErrorCodes.REDEFINITION);
                } else if (operation.getParameterCount() > 0 
                    && findOperation(operation.getParameterType(0), operation, true)) {
                    // does operation match to an operation on the first type (vs implicit project parameter)
                    throw new TranslatorException("operation '" + op.getId() + "' is ambigously defined on type '"
                        + IvmlDatatypeVisitor.getUnqualifiedType(operation.getParameterType(0)) + '"', op,
                        IvmlPackage.Literals.OP_DEF_PARAMETER__TYPE, ErrorCodes.AMBIGUITY);
                } else {
                    // in case of no error - add, first resolvable then as model element
                    project.add(opDef);
                    context.addToProject(op, comment, opDef);
                }
            }
        } catch (TranslatorException e) {
            project.remove(opDef);
            if (force) {
                error(e);
            } else {
                done = false;
            }
        } finally {
            context.popLayer();
        }
        return done;
    }
    
    /**
     * Returns the unqualified name of <code>type</code>.
     * 
     * @param type the type
     * @return the unqualified name
     */
    private static String unqualified(IDatatype type) {
        return IvmlDatatypeVisitor.getUnqualifiedType(type);
    }
    
    /**
     * Checks the sequence of default and non-default parameters.
     * 
     * @param op the operation declaration
     * @param param the parameters to check
     */
    private void checkDefaultParamSequence(OpDefStatement op, DecisionVariableDeclaration[] param) {
        int lastNonDefaultParam = -1;
        int lastDefaultParam = -1;
        for (int p = 0; p < param.length; p++) {
            if (null == param[p].getName()) {
                lastNonDefaultParam = p;
            } else {
                if (lastDefaultParam < 0) {
                    lastDefaultParam = p;
                }
            }
        }
        if (param.length > 0) {
            if (lastDefaultParam > 0 && lastNonDefaultParam > lastDefaultParam) {
                error("parameters with default values must follow parameters without default values", op, 
                    IvmlPackage.Literals.ACTUAL_ARGUMENT_LIST__NAME, ErrorCodes.WARNING_USAGE);
            }
        }
    }
    
    /**
     * Processes an operation definition implementation.
     * 
     * @param op the operation definition
     * @param context the type context
     * @param parent the parent model element
     * @return the implementing constraint syntax tree
     * @throws TranslatorException in case that the processing of the <code>op</code>
     *      must be terminated abnormally
     */
    private ConstraintSyntaxTree processOpDefImpl(OpDefStatement op, TypeContext context, IModelElement parent) 
        throws TranslatorException {
        ConstraintSyntaxTree impl = null;
        if (null != op.getImpl()) {
            impl = expressionTranslator.processExpression(op.getImpl(), context, parent);
        } else if (null != op.getBlock()) {
            impl = expressionTranslator.processBlockExpression(op.getBlock(), context, parent);
        }
        return impl;
    }

    /**
     * Processes an interface. In case of success, the interface will be added
     * to the project in <code>context</code>.
     * 
     * @param eIface
     *            the interface to be processed
     * @param context
     *            the type context to be considered
     */
    protected void processInterface(InterfaceDeclaration eIface, TypeContext context) {
        if (null != eIface.getName()) { // due to incremental editing
            List<Comment> comments = new ArrayList<Comment>();
            List<DecisionVariableDeclaration> exports = new ArrayList<DecisionVariableDeclaration>();
            List<Export> eExports = eIface.getExports();
            for (Export export : eExports) {
                comments.add(CommentUtils.toComment(export, null));
                for (QualifiedName qn : export.getNames()) {
                    String name = Utils.getQualifiedNameString(qn);
                    try {
                        DecisionVariableDeclaration variable = (DecisionVariableDeclaration) 
                            context.findVariable(name, DecisionVariableDeclaration.class);
                        if (null == variable) {
                            error("cannot resolve '" + name + "'", eIface,
                                IvmlPackage.Literals.INTERFACE_DECLARATION__EXPORTS, ErrorCodes.UNKNOWN_ELEMENT);
                        }
                        exports.add(variable);
                    } catch (IvmlException e) {
                        error(e, eIface, IvmlPackage.Literals.INTERFACE_DECLARATION__EXPORTS);
                    }
                }
            }
            DecisionVariableDeclaration[] exp = new DecisionVariableDeclaration[exports.size()];
            exports.toArray(exp);
            StructuredComment sComment = createStructuredComment(eIface, context, comments);
            ProjectInterface iface = new ProjectInterface(eIface.getName(), exp, context.getProject());
            // currently only if fully processed
            if (null != sComment && exports.size() == eExports.size() && eExports.size() == comments.size()) {
                assignComments(sComment, exports, comments, iface);
            }
            if (!context.addToProject(eIface, sComment, iface)) {
                error("interface '" + iface.getName() + "' is defined multiple times in this project",
                    eIface, IvmlPackage.Literals.INTERFACE_DECLARATION__NAME, ErrorCodes.REDEFINITION);
            }
        }
    }

    /**
     * Processes an annotation. In case of success, the annotation will be
     * applied.
     * 
     * @param annotation the interface to be processed
     * @param context the type context to be considered
     */
    protected void processAnnotation(AnnotateTo annotation, TypeContext context) {
        if (null != annotation.getNames()) { // incomplete parsing
            Attribute initial = null;
            for (String name : annotation.getNames()) {
                if (null != name) {
                    Attribute tmp = processAnnotation(annotation, name, context, initial);
                    if (null == initial) {
                        initial = tmp;
                    }
                }
            }
        }
    }
    
    /**
     * Processes the annotation of <code>name</code>. In case of success, the annotation will be
     * applied.
     * 
     * @param annotation the annotation to be processed
     * @param name the name of the annotated element
     * @param context the type context to be considered
     * @param initial the initial attribute created in series
     * @return the created attribute or <b>null</b>
     */
    protected Attribute processAnnotation(AnnotateTo annotation, String name, TypeContext context, Attribute initial) {
        Attribute attr = null;
        IAttributableElement elt = null;
        try {
            AbstractVariable var = context.findVariable(name, null);
            if (null == var) {
                if (context.getProject().getName().equals(name)) {
                    elt = context.getProject().getVariable();
                } else {
                    error("cannot find '" + name + '"', annotation, IvmlPackage.Literals.ANNOTATE_TO__NAMES,
                        ErrorCodes.UNKNOWN_ELEMENT);
                }
            } else if (var instanceof Attribute) {
                error("cannot annotate annotations", annotation, IvmlPackage.Literals.ANNOTATE_TO__NAMES,
                    ErrorCodes.ATTRIBUTION);
            } else {
                elt = (DecisionVariableDeclaration) var;
            }
        } catch (IvmlException e) {
            error(e, annotation, IvmlPackage.Literals.ANNOTATE_TO__NAMES);
        }
        if (null != elt) {
            try {
                IDatatype type = context.resolveType(annotation.getAnnotationType());
                VariableDeclarationPart vDecl = annotation.getAnnotationDecl();
                Comment comment = handleBasicComment(annotation, context);
                if (vDecl.getName().startsWith("e") || vDecl.getName().startsWith("v")) {
                    error("annotation name '" + vDecl.getName() + "' must not start with 'v' or 'e'"
                        + elt.getName() + "'", annotation, IvmlPackage.Literals.ANNOTATE_TO__NAMES,
                        ErrorCodes.ATTRIBUTION);
                }
                expressionTranslator.warnDiscouragedNames(vDecl.getName(), vDecl, 
                    IvmlPackage.Literals.VARIABLE_DECLARATION_PART__NAME);
                attr = new Attribute(vDecl.getName(), type, context.getProject(), elt);
                if (null != vDecl.getDefault()) {
                    try {
                        expressionTranslator.initLevel();
                        ConstraintSyntaxTree deflt = expressionTranslator.processExpression(type, vDecl.getDefault(),
                            context, context.getProject());
                        attr.setValue(deflt);
                    } catch (IvmlException e) {
                        error(e, vDecl, IvmlPackage.Literals.VARIABLE_DECLARATION_PART__DEFAULT);
                    }
                }
                if (!elt.attribute(attr)) {
                    error("annotation '" + attr.getName() + "' is defined multiple times on '"
                        + elt.getName() + "'", annotation, IvmlPackage.Literals.ANNOTATE_TO__NAMES,
                        ErrorCodes.ATTRIBUTION);
                }
                context.addToProject(annotation, comment, attr);
                if (null != initial) {
                    initial.addSeries(attr);
                }
            } catch (TranslatorException e) {
                error(e);
            }
        }
        if (annotation.getSname().equals("attribute")) {
            warning("The keyword 'attribute' is deprecated. For future compatibility please use 'annotate' instead.", 
                annotation, IvmlPackage.Literals.ANNOTATE_TO__SNAME, ErrorCodes.ATTRIBUTION);
        }
        return attr;
    }

    /**
     * Finds an operation on a given datatype.
     * 
     * @param datatype
     *            the datatype to search for
     * @param operation
     *            the operation to be searched for
     * @param considerOperand
     *            whether the operand of the operations defined in
     *            <code>datatype</code> should be considered as first parameter
     *            of <code>operation</code>, used to match the implicit project
     *            parameter for ambigous operation checking
     * @return <code>true</code> if the operation was found, <code>false</code>
     *         else
     */
    private boolean findOperation(IDatatype datatype, Operation operation,
            boolean considerOperand) {
        boolean found = false;
        for (int op = 0; !found && op < datatype.getOperationCount(); op++) {
            Operation defOperation = datatype.getOperation(op);
            int defParamCount = defOperation.getParameterCount();
            if (considerOperand) {
                defParamCount++;
            }
            if (defOperation.getName().equals(operation.getName())
                    && (defParamCount == operation.getParameterCount())) {
                boolean paramMatch = true;
                int defPInc = 0;
                if (considerOperand) {
                    paramMatch = defOperation.getOperand().equals(
                            operation.getParameterType(0));
                    defPInc = 1;
                }
                for (int p = 0; paramMatch
                        && p < defOperation.getParameterCount(); p++) {
                    paramMatch = defOperation.getParameterType(p + defPInc).equals(
                            operation.getParameterType(p));
                }
                found = paramMatch;
            }
        }
        return found;
    }

    /**
     * Processes an enum definition.
     * 
     * @param tenum
     *            the type definition for the enum
     * @param context
     *            the type context to be considered
     * @throws TranslatorException
     *             in case that the processing of the <code>statement</code>
     *             must be terminated abnormally
     */
    private void processEnum(TypedefEnum tenum, TypeContext context) throws TranslatorException {
        int noOrdinals = 0;
        int allOrdinals = 0;
        int literalCount = tenum.getLiterals().size();
        Comment comment = handleBasicComment(tenum, context);
        for (TypedefEnumLiteral literal : tenum.getLiterals()) {
            if (null == literal.getValue()) {
                noOrdinals++;
            } else {
                allOrdinals++;
            }
        }
        if (noOrdinals != literalCount && allOrdinals != literalCount) {
            error("either all nor no enum values may have explicit ordinal values",
                    tenum, IvmlPackage.Literals.TYPEDEF_ENUM__LITERALS,
                    ErrorCodes.INITIALIZER_CONSISTENCY);
        } else {
            net.ssehub.easy.varModel.model.datatypes.Enum iEnum;
            if (noOrdinals == literalCount) {
                iEnum = new net.ssehub.easy.varModel.model.datatypes.Enum(
                        tenum.getName(), context.getProject());
            } else {
                iEnum = new OrderedEnum(tenum.getName(), context.getProject());
            }
            for (int l = 0; l < literalCount; l++) {
                TypedefEnumLiteral lit = tenum.getLiterals().get(l);
                int pos;
                if (noOrdinals == literalCount) {
                    pos = l;
                } else {
                    pos = Integer.parseInt(lit.getValue().getVal());
                }
                if (!iEnum.add(new EnumLiteral(lit.getName(), pos, iEnum))) {
                    error("enum value '" + lit.getName() + "' is defined twice", lit,
                            IvmlPackage.Literals.TYPEDEF_ENUM_LITERAL__NAME,
                            ErrorCodes.INITIALIZER_CONSISTENCY);
                }
            }
            if (!context.addToProject(tenum, comment, iEnum)) {
                throw new TranslatorException("duplicated type name '" + tenum.getName() + "'", tenum, 
                    IvmlPackage.Literals.TYPEDEF_ENUM__NAME, ErrorCodes.NAME_CLASH);
            }
        }
    }

    /**
     * Processes a compound definition.
     * 
     * @param tcomp the type definition for the compound
     * @param context the type context to be considered
     * @param force creation, don't check before
     * @return <code>true</code> if the base type is yet available and the
     *         remaining type resolution was done, <code>false</code> if this
     *         typedef can actually not be processed
     * @throws TranslatorException in case that the processing of the <code>tcomp</code>
     *         must be terminated abnormally due to type problems
     */
    private boolean processCompound(TypedefCompound tcomp, TypeContext context, boolean force) 
        throws TranslatorException {
        boolean resolvable = true;
        Compound superCompound;
        if (null != tcomp.getSuper()) {
            try {
                superCompound = (Compound) context.findType(tcomp.getSuper(), Compound.class);
            } catch (ModelQueryException e) {
                throw new TranslatorException(e, tcomp, IvmlPackage.Literals.TYPEDEF_COMPOUND__SUPER);
            }
            resolvable = force || (null != superCompound);
        } else {
            superCompound = null;
        }
        Compound stored = compoundMapping.get(tcomp);
        if (null != stored && null == stored.getRefines() && null != superCompound) {
            stored.setRefines(superCompound);
        }
        expressionTranslator.warnDiscouragedNames(tcomp.getName(), tcomp, IvmlPackage.Literals.TYPEDEF_COMPOUND__NAME);
        Compound compound = (null != stored ? stored : new Compound(tcomp.getName(), context.getProject(), 
            tcomp.getAbstract() != null, superCompound));
        SplitResult split = Utils.split(tcomp.getElements());
        if (!force) {
            resolvable &= variableDeclarationsResolvable(split.getVarDecls(), context, compound, force);
            resolvable &= attributeAssignmentsResolvable(split.getAttrAssignments(), context, compound, force);
        }
        if (null == stored) {
            compoundMapping.put(tcomp, compound);
            Comment comment = CommentUtils.toComment(tcomp, context.getProject());
            context.addToProject(null, null, comment);
            context.addToProject(tcomp, comment, compound);
        }
        if (resolvable) {
            // assignments first to find duplicates
            resolveAssignments(split.getAttrAssignments(), context, compound, force);
            resolveDeclarations(split.getVarDecls(), context, compound, force);
            // constraints are resolved afterwards
        }
        // Handle refinments where the refined compound is written before the super compound.
        if (null != compound) {
            // Keep compounds into mind, where the parent could not be found until yet
            if (null != tcomp.getSuper() && null == superCompound) {
                context.addToContext(compound, tcomp.getSuper());
            }
            // Set refined compounds if the super compound was found at a later time
            List<Compound> childs = context.getUnresolvedCompoundRefinments(compound.getName());
            if (null != childs) {
                for (int i = 0; i < childs.size(); i++) {
                    Compound child = childs.get(i);
                    if (null == child.getRefines()) {
                        child.setRefines(compound);
                    }
                }
            }
            context.clearUnresolvedCompounds(compound.getName());

            if (resolvable && null != tcomp.getSuper() && null == compound.getRefines()) {
                throw new TranslatorException("cannot resolve '" + tcomp.getSuper() + "'", tcomp, 
                   IvmlPackage.Literals.TYPEDEF_COMPOUND__SUPER, ErrorCodes.UNKNOWN_ELEMENT);
            }

        }
        return resolvable;
    }

    /**
     * Processes an attribute assignment.
     * 
     * @param assgn the attribute assignment
     * @param context the type context to be considered
     * @param parent the parent container
     * @param process the assignment or do only type resolution
     * @param force creation, don't check before
     * @return <code>true</code> if the base types is yet available and the
     *         remaining type resolution was done, <code>false</code> if this
     *         assignment can actually not be processed
     * @throws TranslatorException in case that the processing of the <code>assgn</code>
     *         must be terminated abnormally due to type problems
     */
    private boolean processAttributeAssignment(AttrAssignment assgn, TypeContext context, 
        IDecisionVariableContainer parent, boolean process, boolean force) throws TranslatorException {
        boolean resolvable = true;

        IModelElement mParent;
        if (null == parent) {
            mParent = context.getProject();
        } else {
            mParent = parent;
        }
        AttributeAssignment assignment = new AttributeAssignment(mParent);
        SplitResult split = Utils.split(assgn.getElements());
        if (!force) {
            resolvable &= variableDeclarationsResolvable(split.getVarDecls(), context, assignment, force);
            resolvable &= attributeAssignmentsResolvable(split.getAttrAssignments(), context, assignment, force);
        }
        if (resolvable && (process || force)) {
            assignmentMapping.put(assgn, assignment);
            // assignments first to find duplicates
            resolveAssignments(split.getAttrAssignments(), context, assignment, force);
            resolveDeclarations(split.getVarDecls(), context, assignment, force);
            Comment comment = CommentUtils.toComment(assgn, mParent);
            if (null != parent) {
                parent.add(assignment);
            } else {
                context.addToProject(null, null, comment);
                context.addToProject(assgn, comment, assignment);
            }
            // constraints are resolved afterwards
        }
        return resolvable;
    }

    /**
     * Returns whether the declarations in <code>varDecl</code> can be resolved in the given <code>context</code>
     * and the given parent <code>container</code>.
     * 
     * @param varDecls the variable declarations to be resolved
     * @param context the type context
     * @param parent the parent the <code>varDecls</code> shall be inserted into
     * @param force creation, don't check before
     * @return <code>true</code> if the declarations are resolvable, <code>false</code> else
     * @throws TranslatorException in case of type problems, resolution problems or type incompatibilities
     */
    private boolean variableDeclarationsResolvable(List<VariableDeclaration> varDecls, TypeContext context, 
        IDecisionVariableContainer parent, boolean force) throws TranslatorException {
        boolean resolvable = true;
        if (null != varDecls) {
            for (int v = 0; resolvable && v < varDecls.size(); v++) {
                resolvable &= processVariableDeclaration(varDecls.get(v), context, parent, false, force);
            }
        }
        return resolvable;
    }

    /**
     * Returns whether the assignments in <code>attrAssignments</code> can be resolved in the given <code>context</code>
     * and the given parent <code>container</code>.
     * 
     * @param attrAssignments the assignments to be resolved
     * @param context the type context
     * @param parent the parent the <code>varDecls</code> shall be inserted into
     * @param force creation, don't check before
     * @return <code>true</code> if the declarations are resolvable, <code>false</code> else
     * @throws TranslatorException in case of type problems, resolution problems or type incompatibilities
     */
    private boolean attributeAssignmentsResolvable(List<AttrAssignment> attrAssignments, TypeContext context, 
        IDecisionVariableContainer parent, boolean force) throws TranslatorException {
        boolean resolvable = true;
        if (null != attrAssignments) {
            for (int a = 0; resolvable && a < attrAssignments.size(); a++) {
                resolvable &= processAttributeAssignment(attrAssignments.get(a), context, parent, false, force);
            }
        }
        return resolvable;
    }

    /**
     * Resolves the given declarations in <code>varDecl</code>.
     * 
     * @param varDecls the variable declarations to be resolved
     * @param context the type context
     * @param parent the parent the <code>varDecls</code> shall be inserted into
     * @param force creation, don't check before
     * @throws TranslatorException in case of type problems, resolution problems or type incompatibilities
     */
    private void resolveDeclarations(List<VariableDeclaration> varDecls, TypeContext context, 
        IDecisionVariableContainer parent, boolean force) throws TranslatorException {
        if (null != varDecls) {
            for (int v = 0; v < varDecls.size(); v++) {
                VariableDeclaration vDecl = varDecls.get(v);
                Comment comment = CommentUtils.toComment(vDecl, parent);
                parent.add(comment);
                processVariableDeclaration(vDecl, context, parent, true, force);
                context.registerSorter(parent, vDecl, comment, parent.getElement(v));
            }
        }
    }

    /**
     * Resolves the given assignments in <code>attrAssignments</code>.
     * 
     * @param attrAssignments the assignments to be resolved
     * @param context the type context
     * @param parent the parent the <code>attrAssignments</code> shall be inserted into
     * @param force creation, don't check before
     * @throws TranslatorException in case of type problems, resolution problems or type incompatibilities
     */
    private void resolveAssignments(List<AttrAssignment> attrAssignments, TypeContext context, 
        IDecisionVariableContainer parent, boolean force) throws TranslatorException {
        if (null != attrAssignments) {
            for (int a = 0; a < attrAssignments.size(); a++) {
                AttrAssignment nested = attrAssignments.get(a);
                Comment comment = CommentUtils.toComment(nested, parent);
                parent.add(comment);
                processAttributeAssignment(nested, context, parent, true, force);
                context.registerSorter(parent, nested, comment, parent.getAssignment(a));
            }
        }
    }

    /**
     * Processes a typdef (type mapping).
     * 
     * @param tmapping
     *            the type mapping definition
     * @param context
     *            the type context to be considered
     * @return <code>true</code> if the base type is yet available and the
     *         remaining type resolution was done, <code>false</code> if this
     *         typedef can actually not be processed
     * @param force
     *            if creation (and related errors) shall be forced or just tested
     * @throws TranslatorException
     *             in case that the processing of the <code>statement</code>
     *             must be terminated abnormally
     */
    private boolean processMapping(TypedefMapping tmapping,
        TypeContext context, boolean force) throws TranslatorException {
        boolean resolvable = true;
        IDatatype baseType;
        try {
            baseType = context.resolveType(tmapping.getType()); // implicit
                                                                // throw is fine
        } catch (TranslatorException e) {
            if (force) {
                throw e;
            } else {
                resolvable = false;
                baseType = null;
            }
        }
        if (resolvable) {
            expressionTranslator.warnDiscouragedNames(tmapping.getNewType(), tmapping, 
                IvmlPackage.Literals.TYPEDEF_MAPPING__NEW_TYPE);
            DerivedDatatype result = new DerivedDatatype(tmapping.getNewType(),
                    baseType, context.getProject());
            Comment comment = handleBasicComment(tmapping, context);
            if (null != tmapping.getConstraint()) {
                typedefMapping.put(tmapping, result);
            }
            if (!context.addToProject(tmapping, comment, result)) {
                throw new TranslatorException("duplicated type name '" + tmapping.getNewType() + "'", tmapping, 
                    IvmlPackage.Literals.TYPEDEF_MAPPING__NEW_TYPE, ErrorCodes.NAME_CLASH);
            }
        }
        return resolvable;
    }

    /**
     * Processes an evaluation block. In case of errors the respective element
     * is not added to the resulting project.
     * 
     * @param eval the evaluation block
     * @param context the context for type resolution
     * @param compound optional compound to add the eval block to, <b>null</b> for adding it to the actual project in 
     *     <code>context</code>
     */
    protected void processEval(Eval eval, TypeContext context, Compound compound) {
        EvalBlockResult result = processEval(eval, context.getProject(), context);
        if (null != compound) {
            if (null != result.comment) { 
                compound.add(result.comment);
            }
            compound.add(result.block);
        } else {
            context.addToProject(eval, result.comment, result.block);
        }
    }
    
    /**
     * Temporary result of evalu block processing.
     * 
     * @author Holger Eichelberger
     */
    private class EvalBlockResult {
        private PartialEvaluationBlock block;
        private StructuredComment comment;
    }

    /**
     * Process an eval block.
     * @param eval the evaluation block
     * @param parent the parent element
     * @param context the context for type resolution
     * @return result of processing an eval block
     */
    private EvalBlockResult processEval(Eval eval, IModelElement parent, TypeContext context) {
        EvalBlockResult result = new EvalBlockResult();
        result.block = new PartialEvaluationBlock("", parent);
        List<Comment> comments = new ArrayList<Comment>();
        if (null != eval.getNested()) {
            List<Eval> evals = eval.getNested();
            PartialEvaluationBlock[] nested = new PartialEvaluationBlock[evals.size()];
            for (int n = 0; n < evals.size(); n++) {
                EvalBlockResult nResult = processEval(evals.get(n), result.block, context);
                result.block.addModelElement(nResult.comment);
                result.block.addModelElement(nResult.block);
                nested[n] = nResult.block;
            }
            result.block.setNested(nested);
        }
        List<IPartialEvaluable> constraints = new ArrayList<IPartialEvaluable>();
        for (ExpressionStatement stmt : eval.getStatements()) {
            comments.add(CommentUtils.toComment(stmt, null));
            try {
                
                Constraint constraint = new Constraint(result.block);
                constraint.setConsSyntax(expressionTranslator.processExpression(
                    stmt.getExpr(), context, constraint));
                constraints.add(constraint);
                result.block.addModelElement(constraint);
            } catch (TranslatorException e) {
                error(e);
            } catch (IvmlException e) {
                error(e, eval, IvmlPackage.Literals.EVAL__STATEMENTS);
            }
        }
        result.comment = createStructuredComment(eval, context, comments);
        IPartialEvaluable[] constr = new IPartialEvaluable[constraints.size()];
        result.block.setEvaluables(constraints.toArray(constr));
        List<ExpressionStatement> stmts = eval.getStatements();
        // currently only if fully processed
        if (null != result.comment && constraints.size() == stmts.size() && stmts.size() == comments.size()) {
            assignComments(result.comment, constraints, comments, result.block);
        }
        return result;
    }

    /**
     * Processes a freeze block. In case of errors the respective element is not
     * added to the resulting project.
     * 
     * @param freeze
     *            the freeze block
     * @param context
     *            the type context to be considered
     */
    protected void processFreeze(Freeze freeze, TypeContext context) {
        List<IFreezable> freezes = new ArrayList<IFreezable>();
        List<Comment> comments = new ArrayList<Comment>();
        for (FreezeStatement stmt : freeze.getNames()) {
            comments.add(CommentUtils.toComment(stmt, null));
            String name = Utils.getQualifiedNameString(stmt.getName(), stmt.getAccess());
            try {
                IModelElement elt = context.findVariableUse(name);
                if (null == elt) {
                    elt = ModelQuery.findProject(context.getProject(), name);
                }
                if (null == elt) {
                    error(name + "' is undefined", freeze, IvmlPackage.Literals.FREEZE__NAMES,
                        ErrorCodes.UNKNOWN_ELEMENT);
                } else {
                    if (elt instanceof IFreezable) {
                        freezes.add((IFreezable) elt);
                    } else {
                        if (elt instanceof IDatatype) {
                            error("Cannot freeze type declaration '" + name + "'", freeze, 
                                IvmlPackage.Literals.FREEZE__NAMES, ErrorCodes.FREEZE);
                        } else {                        
                            error("'" + name + "' cannot be frozen", freeze, IvmlPackage.Literals.FREEZE__NAMES,
                                ErrorCodes.UNKNOWN_ELEMENT);
                        }
                    }
                }
            } catch (IvmlException e) {
                error(e, freeze, IvmlPackage.Literals.FREEZE__NAMES);
            }
        }
        IFreezable[] aFreeze = new IFreezable[freezes.size()];
        freezes.toArray(aFreeze);
        DecisionVariableDeclaration var = null;
        ConstraintSyntaxTree selector = null;
        IModelElement parent = context.getProject();
        if (null != freeze.getId()) {
            FreezeVariableType type = new FreezeVariableType(aFreeze, parent);
            var = new DecisionVariableDeclaration(freeze.getId(), type, parent);
            TypeContext local = new TypeContext(context);
            local.pushLayer(parent);
            local.addToContext(var);
            try {
                selector = getExpressionTranslator().processLogicalExpression(freeze.getEx(), local, parent);
                if (!BooleanType.TYPE.isAssignableFrom(selector.inferDatatype())) {
                    error("selector expression must be of type Boolean", freeze, IvmlPackage.Literals.FREEZE__EX, 
                        ErrorCodes.TYPE_CONSISTENCY);
                }
            } catch (CSTSemanticException e) {
                error(e.getMessage(), freeze, IvmlPackage.Literals.FREEZE__EX, ErrorCodes.TYPE_CONSISTENCY);
            } catch (TranslatorException e) {
                error(e);
            } finally {
                local.popLayer();
            }
        }
        StructuredComment sComment = createStructuredComment(freeze, context, comments);
        FreezeBlock block = new FreezeBlock(aFreeze, var, selector, parent);
        List<FreezeStatement> stmts = freeze.getNames();
        // currently only if fully processed
        if (null != sComment && freezes.size() == stmts.size() && stmts.size() == comments.size()) {
            assignComments(sComment, freezes, comments, block);
        }
        context.addToProject(freeze, sComment, block);
    }
    
    /**
     * Creates a structured comment for the given <code>object</code> in <code>context</code> depending on the 
     * contents of <code>comments</code>, i.e. whether there are comments or not.
     * 
     * @param object the EObject to create the comment for
     * @param context the type context to assign the created context to
     * @param comments the comments to consider
     * @return the created comment object or <b>null</b>
     */
    private StructuredComment createStructuredComment(EObject object, TypeContext context, List<Comment> comments) {
        StructuredComment comment;
        if (comments.isEmpty()) {
            comment = null; 
        } else {
            comment = CommentUtils.ensureStructuredComment(object, context);
        }
        return comment;
    }
    
    /**
     * Assigns the comments in <code>comments</code> to the corresponding model elements
     * in <code>elements</code>.
     * 
     * @param target the structured comment to store the mapping in
     * @param elements the elements to be assigned to the comments
     * @param comments the comments (must be of same size)
     * @param parent the explicit parent element of the comments
     */
    private void assignComments(StructuredComment target, List<?> elements, List<Comment> comments, 
        IModelElement parent) {
        assert comments.size() == elements.size();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            if (null != comment) {
                comment.setParent(parent);
                target.assignComment(elements.get(i), comment);
            }
        }
    }

    /**
     * Processes an import statement including import restrictions. In case of
     * errors the respective element is not added to the resulting project.
     * 
     * @param importStmt the import statement
     * @param context the type context to be considered
     */
    protected void processImport(ImportStmt importStmt, TypeContext context) {
        try {
            // context may contain further "global" variables
            ProjectImport imp = ImportTranslator.processImport(importStmt, expressionTranslator, context);
            Project project = context.getProject();
            assignProjectComment(project, imp, CommentUtils.toComment(importStmt, project));
            if (!context.getProject().addImport(imp)) {
                // does not apply to conflicts!
                error("project '" + imp.getProjectName() + "' is already imported", importStmt,
                    IvmlPackage.Literals.IMPORT_STMT__NAME, ErrorCodes.IMPORT);
            }
        } catch (TranslatorException e) {
            error(e);
        }
    }
    
    /**
     * Processes a conflict statement including import restrictions. In case of
     * errors the respective element is not added to the resulting project.
     * 
     * @param conflictStmt the conflict statement
     * @param context the type context to be considered
     */
    protected void processConflict(ConflictStmt conflictStmt, TypeContext context) {
        try {
            // context may contain further "global" variables
            context.getProject().addImport(ImportTranslator.processConflict(conflictStmt, expressionTranslator, 
                context));
        } catch (TranslatorException e) {
            error(e);
        }
    }

    /**
     * Turns an IVML exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the cause of the feature as an appropriate constant from
     *     {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    void error(IIdentifiable exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.error(exception, cause, causeFeature);
    }

    /**
     * Turns an IVML exception into a xText warning.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the cause of the feature as an appropriate constant from
     *     {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    void warning(IvmlException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

}
