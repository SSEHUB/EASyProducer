package de.uni_hildesheim.sse.translation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.AttrAssignment;
import de.uni_hildesheim.sse.ivml.AttrAssignmentPart;
import de.uni_hildesheim.sse.ivml.AttributeTo;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.Eval;
import de.uni_hildesheim.sse.ivml.Export;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.FreezeButExpression;
import de.uni_hildesheim.sse.ivml.FreezeStatement;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.InterfaceDeclaration;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.OpDefParameter;
import de.uni_hildesheim.sse.ivml.OpDefStatement;
import de.uni_hildesheim.sse.ivml.ProjectContents;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.TypedefCompound;
import de.uni_hildesheim.sse.ivml.TypedefEnum;
import de.uni_hildesheim.sse.ivml.TypedefEnumLiteral;
import de.uni_hildesheim.sse.ivml.TypedefMapping;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.ivml.VariableDeclaration;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;
import de.uni_hildesheim.sse.ivml.VersionStmt;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IPartialEvaluable;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.StructuredComment;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.translation.Utils.SplitResult;
import de.uni_hildesheim.sse.utils.messages.IIdentifiable;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.AvailableModels;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * Implements a ECore-to-IVML translator. Please note that errors which occur
 * during translation are not signalled as individual exceptions but collected
 * and accessible through {@link #getMessage(int)}.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.dslCore.translation.ModelTranslator<ExpressionTranslator> {

    /**
     * Defines whether recursive operation definitions are allowed in IVML.
     */
    public static final boolean ENABLE_RECURSIVE_OPERATION_DEFINITIONS = true;

    private Map<TypedefCompound, Compound> compoundMapping = new HashMap<TypedefCompound, Compound>();
    private Map<AttrAssignment, AttributeAssignment> assignmentMapping 
        = new HashMap<AttrAssignment, AttributeAssignment>();
   
    private Map<VariableDeclarationPart, DecisionVariableDeclaration> varMapping = 
        new HashMap<VariableDeclarationPart, DecisionVariableDeclaration>();
    
    private Map<TypedefMapping, DerivedDatatype> typedefMapping = new HashMap<TypedefMapping, DerivedDatatype>();
        
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
     * @return the corresponding variability model
     */
    public List<Project> createModel(VariabilityUnit unit, URI uri, boolean registerSuccessful) {
        List<Project> result = new ArrayList<Project>();
        if (null != unit.getProjects()) {
            HashSet<String> names = new HashSet<String>();
            for (de.uni_hildesheim.sse.ivml.Project p : unit.getProjects()) {
                String name = p.getName();
                if (!names.contains(name)) {
                    result.add(createProject(p, uri, registerSuccessful, unit.getProjects()));
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
     * @param comment the comment to be assinged
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
     * @return the corresponding IVML project
     */
    public Project createProject(de.uni_hildesheim.sse.ivml.Project project,
            URI uri, boolean registerSuccessful,
            List<de.uni_hildesheim.sse.ivml.Project> inProgress) {
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
        resolveImports(project, result, uri, inProgress);
        ProjectContents contents = project.getContents();
        Utils.SplitResult splitRes = Utils.split(contents.getElements());
        processDefinitions(splitRes.getTypedefs(), splitRes.getVarDecls(), splitRes.getAttrAssignments(), context);
        if (null != splitRes.getAttrs()) {
            for (AttributeTo attribute : splitRes.getAttrs()) {
                processAttribute(attribute, context);
            }
        }
        if (null != splitRes.getOpdefs()) {
            processOpDefs(splitRes.getOpdefs(), context);
        }
        processExpressions(splitRes.getTypedefs(), splitRes.getAttrAssignments(), splitRes.getExprs(), context);
        for (InterfaceDeclaration iface : project.getInterfaces()) {
            processInterface(iface, context);
        }
        if (null != splitRes.getEvals()) {
            for (Eval eval : splitRes.getEvals()) {
                processEval(eval, context);
            }
        }
        if (null != splitRes.getFreezes()) {
            for (Freeze freeze : splitRes.getFreezes()) {
                processFreeze(freeze, context);
            }
        }
        if (registerSuccessful && errorCount == getErrorCount()) {
            // required if models in the same file refer to each other
            VarModel.INSTANCE.updateModel(result, uri, ModelUtility.INSTANCE);
        }
        context.sortProjectElements(contents.getElements());
        context.clear();
        return result;
    }

    /**
     * Resolve the imports.
     * 
     * @param input the Ecore project representation
     * @param project the target project
     * @param uri the physical URI of the project
     * @param inProgress the other projects being resolved at once (in order to avoid loops)
     */
    private void resolveImports(de.uni_hildesheim.sse.ivml.Project input, Project project, URI uri,
            List<de.uni_hildesheim.sse.ivml.Project> inProgress) {
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
            List<IMessage> resolutionMessages = VarModel.INSTANCE.resolveImports(project, uri, infoInProgress);
            for (int i = 0; i < resolutionMessages.size(); i++) {
                IMessage msg = resolutionMessages.get(i);
                switch (msg.getStatus()) {
                case ERROR:
                    error(msg.getDescription(), input, IvmlPackage.Literals.PROJECT__IMPORTS, ErrorCodes.IMPORT);
                    break;
                case WARNING:
                    warning(msg.getDescription(), input, IvmlPackage.Literals.PROJECT__IMPORTS, ErrorCodes.IMPORT);
                    break;
                default:
                    break;
                }
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
        IDecisionVariableContainer parent, boolean internal) 
        throws TranslatorException {
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
                decVar.setValue(expressionTranslator.processExpression(decVar.getType(), part.getDefault(), context,
                    decVar.getParent()));
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
            context.pushLayer();
            try {
                context.addToContext(type.getTypeDeclaration());
                EList<Expression> expressions = mapping.getConstraint().getExpressions();
                Constraint[] constraints = new Constraint[expressions.size()];
                for (int e = 0; e < constraints.length; e++) {
                    constraints[e] = new Constraint(type);
                    constraints[e].setConsSyntax(expressionTranslator.processExpression(expressions.get(e), context,
                        constraints[e]));
                }
                type.setConstraints(constraints);
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
                    context.pushLayer();
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
        // TODO unify with compound
        for (AttrAssignment assgn : assignments) {
            AttributeAssignment assignment = assignmentMapping.get(assgn);
            context.pushLayer();
            context.addToContext(assignment);
            try {
                for (AttrAssignmentPart part : assgn.getParts()) {
                    ConstraintSyntaxTree valueEx = expressionTranslator.processLogicalExpression(
                        part.getValue(), context, assignment);
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
                                new Variable(attribute), data.getOperation(), data.getExpression());
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

    /**
     * Resolve dependencies among type definitions and resolve types in proper
     * sequence.
     * 
     * @param typedefs the type definitions
     * @param vardecls the variable declarations
     * @param assignments the assignments
     * @param context the type resolution context
     */
    private void processDefinitions(List<Typedef> typedefs, List<VariableDeclaration> vardecls, 
        List<AttrAssignment> assignments, TypeContext context) {
        List<Typedef> typesToDo = new LinkedList<Typedef>();
        if (null != typedefs) {
            // process enums first - no type dependencies
            for (Typedef typedef : typedefs) {
                if (null != typedef.getTEnum()) {
                    try {
                        processEnum(typedef.getTEnum(), context);
                    } catch (TranslatorException e) {
                        error(e);
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
                processTypedefs(typesToDo, context, false);
            }
            if (declsCount > 0) {
                processVars(declsToDo, context, false);
            }
            if (assgnCount > 0) {
                processAttributeAssignments(assgnToDo, context, false);
            }
            if (typesCount == typesToDo.size()
                && declsCount == declsToDo.size()
                && assgnCount == assgnToDo.size()) {
                break; // break endless loop
            }
        } while (typesCount > 0 || declsCount > 0);
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
            try {
                boolean done = false;
                if (null != typedef.getTCompound()) {
                    done = processCompound(typedef.getTCompound(), context, force);
                }
                if (null != typedef.getTMapping()) {
                    done = processMapping(typedef.getTMapping(), context, force);
                }
                if (done) {
                    tdIter.remove();
                }
            } catch (TranslatorException e) {
                tdIter.remove(); // don't cause endless loops
                error(e);
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
            try {
                if (processVariableDeclaration(vDecl, context, null, true, force)) {
                    dIter.remove();
                }
            } catch (TranslatorException e) {
                dIter.remove(); // don't cause endless loops
                error(e);
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
            try {
                if (processAttributeAssignment(assgn, context, null, true, force)) {
                    aIter.remove();
                }
            } catch (TranslatorException e) {
                aIter.remove(); // don't cause endless loops
                error(e);
            }
        }
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
                DecisionVariableDeclaration decVar = new DecisionVariableDeclaration(
                    part.getName(), type, parent);
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
    protected boolean processOpdef(OpDefStatement op, TypeContext context, 
        boolean force) throws TranslatorException {
        boolean done = true;
        Project project = context.getProject();
        IDatatype resultType = context.resolveType(op.getResult());
        context.pushLayer();
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
                            params[p].setValue(
                                expressionTranslator.processExpression(parameter.getVal(), context, opDef));
                        } catch (IvmlException e) {
                            throw new TranslatorException(e, op, IvmlPackage.Literals.OP_DEF_PARAMETER__VAL);
                        }
                    }
                    context.addToContext(params[p]);
                }
            }
            IDatatype projectType = project.getType();
            CustomOperation operation = new CustomOperation(resultType, op.getId(), projectType, null, params);
            opDef.setOperation(operation);
            if (ENABLE_RECURSIVE_OPERATION_DEFINITIONS) {
                context.addToContext(opDef);
                project.add(opDef);
            }
            ConstraintSyntaxTree impl = expressionTranslator.processExpression(op.getImpl(), context, opDef);
            try {
                IDatatype implType = impl.inferDatatype();
                if (!resultType.isAssignableFrom(implType)) {
                    throw new TranslatorException("implementation type '"
                        + IvmlDatatypeVisitor.getUnqualifiedType(implType) + "' does not match operation result type '"
                        + IvmlDatatypeVisitor.getUnqualifiedType(resultType) + "'", op,
                        IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL, ErrorCodes.TYPE_CONSISTENCY);
                }
                operation.setFunction(impl);
            } catch (IvmlException e) {
                throw new TranslatorException(e, op, IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL);
            }
            if (ENABLE_RECURSIVE_OPERATION_DEFINITIONS) {
                project.remove(opDef);
            }
            //CustomOperation operation = new CustomOperation(resultType, op.getId(), projectType, impl, params);
            //opDef.setOperation(operation);
            if (findOperation(projectType, operation, false)) {
                // does project define two similar operations?
                // TODO check on imported projects
                throw new TranslatorException("operation '" + op.getId() + "' defined multiple times on project", op,
                    IvmlPackage.Literals.OP_DEF_PARAMETER__TYPE, ErrorCodes.REDEFINITION);
            } else if (operation.getParameterCount() > 0 && findOperation(operation.getParameter(0), operation, true)) {
                // does operation match to an operation on the first type (vs
                // implicit project parameter)
                throw new TranslatorException("operation '" + op.getId() + "' is ambigously defined on type '"
                    + IvmlDatatypeVisitor.getUnqualifiedType(operation.getParameter(0)) + '"', op,
                    IvmlPackage.Literals.OP_DEF_PARAMETER__TYPE, ErrorCodes.AMBIGUITY);
            } else {
                // in case of no error - add, first resovable then as model
                // element
                project.add(opDef);
                context.addToProject(op, comment, opDef);
            }
        } catch (TranslatorException e) {
            if (ENABLE_RECURSIVE_OPERATION_DEFINITIONS) {
                project.remove(opDef);
            }
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
                for (String name : export.getNames()) {
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
     * Processes an attribute. In case of success, the attribute will be
     * applied.
     * 
     * @param attribute the interface to be processed
     * @param context the type context to be considered
     */
    protected void processAttribute(AttributeTo attribute, TypeContext context) {
        if (null != attribute.getNames()) { // incomplete parsing
            Attribute initial = null;
            for (String name : attribute.getNames()) {
                Attribute tmp = processAttribute(attribute, name, context, initial);
                if (null == initial) {
                    initial = tmp;
                }
            }
        }
    }
    
    /**
     * Processes the attribution of <code>name</code>. In case of success, the attribute will be
     * applied.
     * 
     * @param attribute the interface to be processed
     * @param name the name of the attribute
     * @param context the type context to be considered
     * @param initial the initial attribute created in series
     * @return the created attribute or <b>null</b>
     */
    protected Attribute processAttribute(AttributeTo attribute, String name, TypeContext context, Attribute initial) {
        Attribute attr = null;
        IAttributableElement elt = null;
        try {
            AbstractVariable var = context.findVariable(name, null);
            if (null == var) {
                if (context.getProject().getName().equals(name)) {
                    elt = context.getProject().getVariable();
                } else {
                    error("cannot find '" + name + '"', attribute, IvmlPackage.Literals.ATTRIBUTE_TO__NAMES,
                        ErrorCodes.UNKNOWN_ELEMENT);
                }
            } else if (var instanceof Attribute) {
                error("cannot attribute attributes", attribute, IvmlPackage.Literals.ATTRIBUTE_TO__NAMES,
                    ErrorCodes.ATTRIBUTION);
            } else {
                elt = (DecisionVariableDeclaration) var;
            }
        } catch (IvmlException e) {
            error(e, attribute, IvmlPackage.Literals.ATTRIBUTE_TO__NAMES);
        }
        if (null != elt) {
            try {
                IDatatype type = context.resolveType(attribute.getAttributeType());
                VariableDeclarationPart vDecl = attribute.getAttributeDecl();
                Comment comment = handleBasicComment(attribute, context);
                if (vDecl.getName().startsWith("e") || vDecl.getName().startsWith("v")) {
                    error("attribute name '" + vDecl.getName() + "' must not start with 'v' or 'e'"
                        + elt.getName() + "'", attribute, IvmlPackage.Literals.ATTRIBUTE_TO__NAMES,
                        ErrorCodes.ATTRIBUTION);
                }
                attr = new Attribute(vDecl.getName(), type, context.getProject(), elt);
                if (null != vDecl.getDefault()) {
                    try {
                        attr.setValue(expressionTranslator.processExpression(vDecl.getDefault(),
                            context, context.getProject()));
                    } catch (IvmlException e) {
                        error(e, vDecl, IvmlPackage.Literals.VARIABLE_DECLARATION_PART__DEFAULT);
                    }
                }
                if (!elt.attribute(attr)) {
                    error("attribute '" + attr.getName() + "' is defined multiple times on '"
                        + elt.getName() + "'", attribute, IvmlPackage.Literals.ATTRIBUTE_TO__NAMES,
                        ErrorCodes.ATTRIBUTION);
                }
                context.addToProject(attribute, comment, attr);
                if (null != initial) {
                    initial.addSeries(attr);
                }
            } catch (TranslatorException e) {
                error(e);
            }
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
                            operation.getParameter(0));
                    defPInc = 1;
                }
                for (int p = 0; paramMatch
                        && p < defOperation.getParameterCount(); p++) {
                    paramMatch = defOperation.getParameter(p + defPInc).equals(
                            operation.getParameter(p));
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
    private void processEnum(TypedefEnum tenum, TypeContext context)
        throws TranslatorException {
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
            de.uni_hildesheim.sse.model.varModel.datatypes.Enum iEnum;
            if (noOrdinals == literalCount) {
                iEnum = new de.uni_hildesheim.sse.model.varModel.datatypes.Enum(
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
                    error("enum value '" + lit.getName() + "' is defined twice",
                            lit,
                            IvmlPackage.Literals.TYPEDEF_ENUM_LITERAL__NAME,
                            ErrorCodes.INITIALIZER_CONSISTENCY);
                }
            }
            context.addToProject(tenum, comment, iEnum);
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
        Compound compound = new Compound(tcomp.getName(), context.getProject(), superCompound);
        SplitResult split = Utils.split(tcomp.getElements());
        if (!force) {
            resolvable &= variableDeclarationsResolvable(split.getVarDecls(), context, compound, force);
            resolvable &= attributeAssignmentsResolvable(split.getAttrAssignments(), context, compound, force);
        }
        if (resolvable) {
            compoundMapping.put(tcomp, compound);
         // assignments first to find duplicates
            resolveAssignments(split.getAttrAssignments(), context, compound, force);
            resolveDeclarations(split.getVarDecls(), context, compound, force);
            Comment comment = CommentUtils.toComment(tcomp, context.getProject());
            context.addToProject(null, null, comment);
            context.addToProject(tcomp, comment, compound);
            // constraints are resolved afterwards
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
            DerivedDatatype result = new DerivedDatatype(tmapping.getNewType(),
                    baseType, context.getProject());
            Comment comment = handleBasicComment(tmapping, context);
            if (null != tmapping.getConstraint()) {
                typedefMapping.put(tmapping, result);
            }
            context.addToProject(tmapping, comment, result);
        }
        return resolvable;
    }

    /**
     * Processes an evaluation block. In case of errors the respective element
     * is not added to the resulting project.
     * 
     * @param eval the evaluation block
     * @param context the context for type resolution
     */
    protected void processEval(Eval eval, TypeContext context) {
        EvalBlockResult result = processEval(eval, context.getProject(), context);
        context.addToProject(eval, result.comment, result.block);
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
                DecisionVariableDeclaration var = (DecisionVariableDeclaration) context
                        .findVariable(name, DecisionVariableDeclaration.class);
                if (null == var) {
                    error("variable '" + name + "' is undefined", freeze,
                            IvmlPackage.Literals.FREEZE__NAMES,
                            ErrorCodes.UNKNOWN_ELEMENT);
                } else {
                    freezes.add(var);
                }
            } catch (IvmlException e) {
                error(e, freeze, IvmlPackage.Literals.FREEZE__NAMES);
            }
        }
        String[] buts;
        if (null != freeze.getBut()) {
            List<String> tmp = new ArrayList<String>();
            for (FreezeButExpression expr : freeze.getBut().getList()) {
                String but = Utils.getQualifiedNameString(expr.getName(),
                        expr.getAccess());
                if (null != expr.getWildcard()) {
                    but += "*";
                }
                tmp.add(but);
            }
            buts = new String[tmp.size()];
            tmp.toArray(buts);
        } else {
            buts = null;
        }
        IFreezable[] aFreeze = new IFreezable[freezes.size()];
        freezes.toArray(aFreeze);
        StructuredComment sComment = createStructuredComment(freeze, context, comments);
        FreezeBlock block = new FreezeBlock(aFreeze, buts, context.getProject());
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
     * @param importStmt
     *            the import statement
     * @param context
     *            the type context to be considered
     */
    protected void processImport(ImportStmt importStmt, TypeContext context) {
        try {
            ProjectImport imp = ImportTranslator.processImport(importStmt);
            assignProjectComment(context.getProject(), imp, CommentUtils.toComment(importStmt, context.getProject()));
            if (!context.getProject().addImport(imp)) {
                // does not apply to conflicts!
                error("project '" + imp.getProjectName()
                        + "' is already imported", importStmt,
                        IvmlPackage.Literals.VERSION_STMT__VERSION,
                        ErrorCodes.IMPORT);
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
            context.getProject().addImport(
                    ImportTranslator.processConflict(conflictStmt));
        } catch (TranslatorException e) {
            error(e);
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
    void error(IIdentifiable exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.error(exception, cause, causeFeature);
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
    void warning(IvmlException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

}
