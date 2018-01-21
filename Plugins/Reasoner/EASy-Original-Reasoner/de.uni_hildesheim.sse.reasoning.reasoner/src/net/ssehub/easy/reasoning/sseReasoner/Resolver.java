package net.ssehub.easy.reasoning.sseReasoner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.Utils;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration.IAdditionalInformationLogger;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningErrorCodes;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElementDetails;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElements;
import net.ssehub.easy.reasoning.sseReasoner.functions.ScopeAssignments;
import net.ssehub.easy.reasoning.sseReasoner.model.AssignmentConstraintFinder;
import net.ssehub.easy.reasoning.sseReasoner.model.CollectionConstraintsFinder;
import net.ssehub.easy.reasoning.sseReasoner.model.CopyVisitor;
import net.ssehub.easy.reasoning.sseReasoner.model.VariablesInConstraintsFinder;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.cstEvaluation.IResolutionListener;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.InternalConstraint;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.filter.ConstraintFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.VariablesInConstraintFinder;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

import static net.ssehub.easy.reasoning.sseReasoner.ReasoningUtils.*;

/**
 * Constraint identifier, resolver and executor. Assumption that constraints are not evaluated in parallel (see some
 * comments).
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class Resolver {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(Resolver.class, Descriptor.BUNDLE_NAME);
    @SuppressWarnings("unused")
    private IAdditionalInformationLogger infoLogger; 
    
    private Configuration config;
    private boolean incremental;

    private EvalVisitor evaluator = new EvalVisitor();
    private FailedElements failedElements = new FailedElements();
    private ScopeAssignments scopeAssignments = new ScopeAssignments();

    private VariablesMap constraintMap = new VariablesMap();
    private Map<Constraint, IDecisionVariable> constraintVariableMap = new HashMap<Constraint, IDecisionVariable>();
    private Deque<Constraint> constraintBase = new LinkedList<Constraint>();
    private Set<Constraint> constraintBaseSet = new HashSet<Constraint>();
    private List<Constraint> constraintVariablesConstraints = new LinkedList<Constraint>();
    private List<Constraint> defaultConstraints = new LinkedList<Constraint>();
    private List<Constraint> deferredDefaultConstraints = new LinkedList<Constraint>();
    private List<Constraint> derivedTypeConstraints = new LinkedList<Constraint>();
    private List<Constraint> defaultAnnotationConstraints = new LinkedList<Constraint>();
    private List<Constraint> compoundConstraints = new LinkedList<Constraint>();
    private List<Constraint> compoundEvalConstraints = new LinkedList<Constraint>();

    private List<Constraint> unresolvedConstraints = new LinkedList<Constraint>(); 
    private List<Constraint> assignedAttributeConstraints = new LinkedList<Constraint>();
    private List<Constraint> collectionConstraints = new LinkedList<Constraint>();
    private boolean considerFrozenConstraints;
    
    private Map<AbstractVariable, CompoundAccess> varMap; // TODO turn into local map
    
    private List<Constraint> collectionCompoundConstraints = new ArrayList<Constraint>();
    
    // Stats
    private int constraintCounter = 0;
    private int variablesInConstraintsCounter = 0;    
    private int reevaluationCounter = 0;
    private int variablesCounter = 0;

    // global temporary variables avoiding parameter passing (performance)
    
    private transient Project project;
    private transient Set<IDecisionVariable> usedVariables = new HashSet<IDecisionVariable>();

    // >>> from here the names follows the reasoner.tex documentation

    private IValueChangeListener listener = new IValueChangeListener() {
        
        @Override
        public void notifyUnresolved(IDecisionVariable variable) {
        }
        
        @Override
        public void notifyChanged(IDecisionVariable variable, Value oldValue) {
            if (!(variable.isLocal())) {
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Value changed: " + variable.getDeclaration().getName() + " " + variable.getValue()
                        + " Parent: " + (null == variable.getParent() ? null : variable.getParent()));                 
                }
                scopeAssignments.addAssignedVariable(variable);
                // TODO if value type changes (currently not part of the notification), change also constraints
                Set<Constraint> constraintsToReevaluate = new HashSet<Constraint>();
                constraintsForChilds(variable, constraintsToReevaluate);
                // All constraints for the parent (as this was also changed)
                constraintsForParent(variable, constraintsToReevaluate);
                // All constraints for childs (as they may also changed)
                for (Constraint varConstraint : constraintsToReevaluate) {
                    if (!constraintBaseSet.contains(varConstraint)) {
                        addToConstraintBase(varConstraint);
                        constraintCounter++;
                        
                    }
                }
            }
        }

        /**
         * Determines the constraints needed for the parents of <code>variable</code>.
         * 
         * @param variable the variable to analyze
         * @param constraintsToReevaluate the constraint set to be modified as a side effect
         */
        private void constraintsForParent(IDecisionVariable variable, Set<Constraint> constraintsToReevaluate) {
            IConfigurationElement parent = variable.getParent();
            if (parent instanceof IDecisionVariable) {
                IDecisionVariable pVar = (IDecisionVariable) parent;
                AbstractVariable declaration = pVar.getDeclaration();
                Set<Constraint> varConstraints = constraintMap.getRelevantConstraints(declaration);
                if (null != varConstraints) {
                    constraintsToReevaluate.addAll(varConstraints);
                }
                constraintsForParent(pVar, constraintsToReevaluate);                            
            }
        }

        /**
         * Determines the constraints needed for <code>variable</code> and its (transitive) child slots.
         * 
         * @param variable the variable to analyze
         * @param constraintsToReevaluate the constraint set to be modified as a side effect
         */
        private void constraintsForChilds(IDecisionVariable variable, Set<Constraint> constraintsToReevaluate) {
            AbstractVariable declaration = variable.getDeclaration();
            Set<Constraint> varConstraints = constraintMap.getRelevantConstraints(declaration);
            if (null != varConstraints) {
                constraintsToReevaluate.addAll(varConstraints);
            }
            // All constraints for childs (as they may also changed)
            for (int j = 0, nChilds = variable.getNestedElementsCount(); j < nChilds; j++) {
                IDecisionVariable nestedVar = variable.getNestedElement(j);
                if (!(nestedVar.isLocal())) {
                    constraintsForChilds(nestedVar, constraintsToReevaluate);
                }
            }
        }
    };
    
    /**
     * Listener for the {@link #evaluator} to record changed variables.
     */
    private IResolutionListener resolutionListener = new IResolutionListener() {
        
        @Override
        public void notifyResolved(IDecisionVariable compound, String slotName, IDecisionVariable resolved) {
            if (!(resolved.isLocal())) {
                usedVariables.add(resolved);                
            }
        }
        
        @Override
        public void notifyResolved(AbstractVariable declaration, IDecisionVariable resolved) {
            if (!(resolved.isLocal())) {
                usedVariables.add(resolved);                
            }            
        }
    };
    
    // <<< documented until here    
    
    /**
     * Main constructor that activates Resolver constructor.
     * @param project Project for evaluation.
     * @param config Configuration to reason on.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param considerFrozenConstraints Specification whether constraints containing only frozen variables
     *     shall be considered during reasoning (<tt>true</tt>: Shall be considered).
     */
    public Resolver(Project project, Configuration config, boolean considerFrozenConstraints,
        ReasonerConfiguration reasonerConfig) {
        
        this.infoLogger = reasonerConfig.getLogger();
        this.config = config;
        this.incremental = false;
        this.considerFrozenConstraints = considerFrozenConstraints;
    } 
    
    /**
     * Main constructor that activates Resolver constructor with clean {@link Configuration}.
     * @param project Project for evaluation.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     */
    public Resolver(Project project, ReasonerConfiguration reasonerConfig) {
        new Resolver(project, createCleanConfiguration(project), true, reasonerConfig);        
    } 
    
    /**
     * Main constructor that activates Resolver constructor.
     * @param config Configuration to reason on.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     */
    public Resolver(Configuration config, ReasonerConfiguration reasonerConfig) {
        new Resolver(config.getProject(), config, true, reasonerConfig);
    }  
    
    // >>> from here the names follow the reasoner.tex documentation
    
    /**
     * Resolves the (initial) values of the configuration. This is done as follows:
     * <ol>
     * <li>Identify the relevant project imports from 
     *     {@link Utils#discoverImports(net.ssehub.easy.basics.modelManagement.IModel)} for the actual 
     *     {@link #config Configuration}.
     * <li>For each project:
     *   <ol>
     *     <li>Collect constraints for default values of variable declarations ({@link #translateDefaults()})</li>
     *     <li>Collect constraints for the other constraints ({@link #translateConstraints()})</li>
     *     <li>Evaluate the constraints ({@link #evaluateConstraints(Deque)}.
     *     <li>Freezing the assigned variables</li>
     *   </ol> 
     * </ol>
     */
    public void resolve() { 
        // Stack of importedProject (start with inner most imported project)
        evaluator.init(config, null, false, listener); 
        evaluator.setResolutionListener(resolutionListener);
        evaluator.setScopeAssignments(scopeAssignments);
        List<Project> projects = Utils.discoverImports(config.getProject());
        for (int p = 0; p < projects.size(); p++) {
            project = projects.get(p);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Project:" + project.getName());                
            }
            translateDefaults();
            translateConstraints();
            evaluateConstraints();
            // Freezes values after each scope
            config.freezeValues(project, FilterType.NO_IMPORTS);
            // TODO do incremental freezing in here -> required by interfaces with propagation constraints
            if (Descriptor.LOGGING) {
                printFailedElements(failedElements);                                
            }
        }
        variablesInConstraintsCounter = constraintMap.getDeclarationSize();
        evaluator.clear();
    }
    
    /**
     * Evaluates and reschedules failed constraints.
     * 
     * @see #resolve()
     */
    private void evaluateConstraints() {
        if (Descriptor.LOGGING) {
            printConstraints(constraintBase);            
        }
        scopeAssignments.clearScopeAssignments();
        evaluator.setDispatchScope(project);
        while (!constraintBase.isEmpty()) { 
            usedVariables.clear();
            Constraint constraint = constraintBase.pop();
            constraintBaseSet.remove(constraint);
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            evaluator.setAssignmentState(constraint.isDefaultConstraint() 
                ? AssignmentState.DEFAULT : AssignmentState.DERIVED);
            reevaluationCounter++;
            if (cst != null) {
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Resolving: " + reevaluationCounter + ": " + toIvmlString(cst) 
                        + " : " + constraint.getTopLevelParent());                    
                }
                evaluator.visit(cst);
                analyzeEvaluationResult(constraint);
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Result: " + evaluator.getResult());
                    LOGGER.debug("------");                     
                }
                evaluator.clearIntermediary();
            }
        }
    }

    /**
     * Resolves and translates the constraints initializing/guarding the default values of all variable declarations 
     * in {@link #project}.
     * 
     * @see #resolve()
     */
    protected void translateDefaults() {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.NO_IMPORTS, null);
        List<AbstractVariable> variables = finder.getVariableDeclarations(VisibilityType.ALL);
        varMap = new HashMap<AbstractVariable, CompoundAccess>();
        for (AbstractVariable decl : variables) {
            translateDeclarationDefaults(decl, config.getDecision(decl), null);
        }
    }    

    /**
     * Extracts, translates and collects the internal constraints of <code>type</code> and stores them 
     * in {@link #derivedTypeConstraints}.
     * 
     * @param decl VariableDeclaration of <code>DerivedDatatype</code>
     * @param type the type to translate, nothing happens if <code>type</code> is not a {@link DerivedDatatype}
     */
    private void translateDerivedDatatypeConstraints(AbstractVariable decl, IDatatype type) {
        if (type instanceof DerivedDatatype) {
            DerivedDatatype dType = (DerivedDatatype) type;
            ConstraintSyntaxTree[] cst = createDerivedDatatypeExpressions(decl, dType);
            if (null != cst) {
                IModelElement topLevelParent = decl.getTopLevelParent();
                for (int c = 0; c < cst.length; c++) {
                    // Should be in same project as the declaration belongs to
                    try {
                        derivedTypeConstraints.add(new InternalConstraint(dType, cst[c], topLevelParent));
                    } catch (CSTSemanticException e) {
                        LOGGER.exception(e);
                    }
                }
            }
            translateDerivedDatatypeConstraints(decl, dType.getBasisType());
        }
    }

    /**
     * Translates constraint expressions specified for derived datatypes.
     *  
     * @param declaration VariableDeclaration of <code>DerivedDatatype</code>
     * @param dType type of <code>DerivedDatatype</code>
     * @return <code>null</code> if <code>dType</code> is not a <i>DerivedDatatype</i> or if <code>dType</code> 
     *   has no constraints, otherwise the translated constraint expressions of the <code>dType</code> instantiated 
     *   for <code>declaration</code>
     */
    private ConstraintSyntaxTree[] createDerivedDatatypeExpressions(AbstractVariable declaration, 
        DerivedDatatype dType) {
        ConstraintSyntaxTree[] csts = null;
        int count = dType.getConstraintCount();
        DecisionVariableDeclaration dVar = dType.getTypeDeclaration();
        if (count > 0 && dVar != declaration) {
            csts = new ConstraintSyntaxTree[count];
            Variable origin = new Variable(dVar);
            Variable replacement = new Variable(declaration);
            //Copy and replace each instance of the internal declaration with the given instance
            for (int i = 0; i < count; i++) {
                csts[i] = substituteVariable(dType.getConstraint(i), origin, replacement); 
            }
        }        
        return csts;
    }
    
    /**
     * Translates annotation default value expressions.
     * 
     * @param decl {@link AbstractVariable} with annotations.
     * @param variable {@link IDecisionVariable} with annotations.
     * @param compound {@link CompoundAccess} null if variable is not nested.
     */
    private void translateAnnotationDefaults(AbstractVariable decl, IDecisionVariable variable, 
        CompoundAccess compound) {
        for (int i = 0; i < variable.getAttributesCount(); i++) {
            Attribute attribute = (Attribute) variable.getAttribute(i).getDeclaration();
            ConstraintSyntaxTree defaultValue = attribute.getDefaultValue();
            if (null != defaultValue) {
                try {
                    ConstraintSyntaxTree op;
                    if (compound == null) {
                        op = new AttributeVariable(new Variable(decl), attribute);                        
                    } else {                        
                        op = new AttributeVariable(compound, attribute);
                    }
                    defaultValue = new OCLFeatureCall(op, OclKeyWords.ASSIGNMENT, defaultValue);
                    defaultAnnotationConstraints.add(createDefaultConstraint(defaultValue, project));
                } catch (CSTSemanticException e) {
                    e.printStackTrace();
                }                    
            }
        }
    }

    /**
     * Translates the (transitive) defaults and type constraints for a declaration. 
     * 
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param var the instance of <tt>decl</tt>.
     * @param cAcc if variable is a nested compound.
     * 
     * @see #translateDefaults()
     */
    protected void translateDeclarationDefaults(AbstractVariable decl, IDecisionVariable var, CompoundAccess cAcc) {
        List<Constraint> defltCons = defaultConstraints; 
        variablesCounter++;
        IDatatype type = decl.getType();
        translateDerivedDatatypeConstraints(decl, type);
        translateAnnotationDefaults(decl, var, cAcc);
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        if (TypeQueries.isCompound(type)) {
            if (null != defaultValue) { // try considering the actual type, not only the base type
                type = inferTypeSafe(defaultValue, type);
            }
            translateCompoundDefaults(decl, var, cAcc, type); 
            if (null != defaultValue) {
                defaultValue = copyCST(defaultValue, new Variable(decl), varMap);
            }
        } else if (null != defaultValue) {
            if (TypeQueries.isContainer(type)) {
                Set<Compound> used = getUsedTypes(defaultValue, Compound.class);
                if (null != used && !used.isEmpty()) {
                    for (Compound uType : used) {
                        translateDefaultsCompoundCollection(decl, uType, new HashSet<Compound>());
                    }
                }
            } else if (null != cAcc) {
                // all self/overriden compound initialization constraints have to be deferred until compound/container 
                // initializers are set as they would be overridden else
                CopyVisitor visitor = new CopyVisitor(null, null).setSelf(cAcc.getCompoundExpression());
                defaultValue = visitor.accept(defaultValue);
                inferTypeSafe(defaultValue, null);
                if (visitor.containsSelf() || isOverriddenSlot(decl)) {
                    defltCons = deferredDefaultConstraints;
                }
            }
        }
        translateCollectionCompoundConstraints(decl, var, null, collectionCompoundConstraints);
        // Container
        if (TypeQueries.isContainer(type)) {            
            IDatatype containedType = ((Container) type).getContainedType();
            if (containedType instanceof DerivedDatatype) {
                translateCollectionDerivedDatatypeConstraints((DerivedDatatype) containedType, decl, null);
            }
        }
        if (null != defaultValue) {
            try {
                if (TypeQueries.isConstraint(type)) {
                    if (cAcc == null) {
                        variablesCounter--;
                        // use closest parent instead of project -> runtime analysis
                        Constraint constraint = new Constraint(defaultValue, var.getDeclaration());
                        constraintVariablesConstraints.add(constraint);
                        constraintVariableMap.put(constraint, var);
                        if (Descriptor.LOGGING) {
                            LOGGER.debug(var.getDeclaration().getName() + " project constraint variable " 
                                + toIvmlString(defaultValue));
                        }
                    } 
                } else { // Create default constraint
                    ConstraintSyntaxTree cst = new OCLFeatureCall(
                        defltCons == deferredDefaultConstraints ? cAcc : new Variable(decl), 
                        OclKeyWords.ASSIGNMENT, defaultValue);
                    defltCons.add(createDefaultConstraint(cst, project));
                }                
            } catch (CSTSemanticException e) {
                LOGGER.exception(e); // should not occur, ok to log
            }            
        }
    }
    
    /**
     * Collect constraints representing compound defaults in collections of compounds.
     * 
     * @param decl the collection variable
     * @param cmpType the compound type used in the actual <code>decl</code> value to focus the constraints created
     * @param done the already processed types (to be modified as a side effect)
     */
    private void translateDefaultsCompoundCollection(AbstractVariable decl, Compound cmpType, Set<Compound> done) {
        if (!done.contains(cmpType)) {
            done.add(cmpType);
            for (int d = 0; d < cmpType.getDeclarationCount(); d++) {
                DecisionVariableDeclaration uDecl = cmpType.getDeclaration(d);
                ConstraintSyntaxTree defaultValue = uDecl.getDefaultValue();
                if (null != defaultValue) {
                    DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("cmp", cmpType, null);
                    //varMap.put(nestedDecl, cmpAccess); // ???
                    try {
                        Variable localDeclVar = new Variable(localDecl);
                        defaultValue = copyCST(defaultValue, localDeclVar, null); // replace self
                        defaultValue = new OCLFeatureCall(new CompoundAccess(localDeclVar, uDecl.getName()), 
                            OclKeyWords.ASSIGNMENT, defaultValue);
                        ConstraintSyntaxTree containerOp = new Variable(decl);
                        if (!TypeQueries.sameTypes(decl.getType(), cmpType)) {
                            containerOp = new OCLFeatureCall(containerOp, OclKeyWords.TYPE_SELECT, 
                                new ConstantValue(ValueFactory.createValue(MetaType.TYPE, cmpType)));
                        }
                        if (isNestedCollection(decl.getType())) {
                            containerOp = new OCLFeatureCall(containerOp, OclKeyWords.FLATTEN);
                        }
                        defaultValue = createContainerCall(containerOp, Container.FORALL, defaultValue, localDecl);
                        deferredDefaultConstraints.add(createDefaultConstraint(defaultValue, project));
                    } catch (CSTSemanticException e) {
                        LOGGER.exception(e); // should not occur, ok to log
                    } catch (ValueDoesNotMatchTypeException e) {
                        LOGGER.exception(e); // should not occur, ok to log
                    }
                }
            }
            // attributes??
            for (int r = 0; r < cmpType.getRefinesCount(); r++) {
                translateDefaultsCompoundCollection(decl, cmpType.getRefines(r), done);
            }
        }
    }

    /**
     * Method for translating the internal constraint from collections with derived contained types.
     * 
     * @param derivedType {@link DerivedDatatype} of the Collection.
     * @param decl Collection variable.
     * @param topcmpAccess {@link CompoundAccess}, might be <b>null</b>.
     */
    private void translateCollectionDerivedDatatypeConstraints(DerivedDatatype derivedType, 
        AbstractVariable decl, CompoundAccess topcmpAccess) {
        // as long as evaluation is not parallelized, using the same localDecl shall not be a problem
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("derivedType", derivedType, null);
        ConstraintSyntaxTree[] cst = createDerivedDatatypeExpressions(localDecl, derivedType);
        if (null != cst) {
            for (int i = 0, n = cst.length; i < n; i++) {
                ConstraintSyntaxTree itExpression = cst[i];
                ConstraintSyntaxTree containerOp = null;
                if (topcmpAccess == null) {
                    containerOp = createContainerCall(new Variable(decl), Container.FORALL, itExpression, localDecl);
                } else {
                    containerOp = createContainerCall(topcmpAccess, Container.FORALL, itExpression, localDecl);
                }            
                try {
                    if (containerOp != null) {
                        containerOp.inferDatatype();
                        Constraint constraint = new Constraint(containerOp, project);
                        derivedTypeConstraints.add(constraint);                    
                    }
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                }            
            }            
        }
        if (derivedType.getBasisType() instanceof DerivedDatatype) {
            translateCollectionDerivedDatatypeConstraints((DerivedDatatype) derivedType.getBasisType(), 
                decl, topcmpAccess);
        }
    }
    
    /**
     * Method for retrieving constraints from compounds initialized in collections.
     * 
     * @param decl AbstractVariable.
     * @param variable the instance of <tt>decl</tt>.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @param results the resulting constraints
     */
    private void translateCollectionCompoundConstraints(AbstractVariable decl, IDecisionVariable variable, 
        CompoundAccess topcmpAccess, List<Constraint> results) {
        IDatatype type = decl.getType();
        if (TypeQueries.isContainer(type)) {
            IDatatype containedType = ((Container) type).getContainedType();
            for (IDatatype tmp : identifyContainedTypes(variable, containedType)) {
                if (TypeQueries.isCompound(tmp)) {
                    translateCollectionCompoundConstraints((Compound) tmp, containedType, decl, topcmpAccess, results);
                }
            }
        }
    }
    
    /**
     * Method for transforming a compound constraint into collection forAll constraint.
     * @param cmpType Specific compound type (with constraints).
     * @param declaredContainedType the declared contained type of the container.
     * @param decl {@link AbstractVariable}.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @param result List of transformed constraints, to be modified as a side effect.
     */
    private void translateCollectionCompoundConstraints(Compound cmpType, IDatatype declaredContainedType, 
        AbstractVariable decl, CompoundAccess topcmpAccess, List<Constraint> result) {
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("cmp", cmpType, null);        
        // fill varMap
        for (int i = 0, n = cmpType.getInheritedElementCount(); i < n; i++) {
            AbstractVariable nestedDecl = cmpType.getInheritedElement(i);
            CompoundAccess cmpAccess = null;           
            cmpAccess = new CompoundAccess(new Variable(localDecl), nestedDecl.getName());
            varMap.put(nestedDecl, cmpAccess);
        }
        
        List<Constraint> thisCompoundConstraints = new ArrayList<Constraint>(); 
        allCompoundConstraints(cmpType, thisCompoundConstraints, true);
        ConstraintSyntaxTree typeExpression = null;
        if (!TypeQueries.sameTypes(cmpType, declaredContainedType)) {
            typeExpression = createTypeValueConstantSafe(cmpType);
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree itExpression = thisCompoundConstraints.get(i).getConsSyntax();
            itExpression = copyCST(itExpression, new Variable(localDecl), varMap);
            if (Descriptor.LOGGING) {
                LOGGER.debug("New loop constraint " + toIvmlString(itExpression));
            }   
            try {
                ConstraintSyntaxTree containerOp = topcmpAccess == null ? new Variable(decl) : topcmpAccess;
                containerOp.inferDatatype();
                if (null != typeExpression) {
                    containerOp = new OCLFeatureCall(containerOp, Container.SELECT_BY_KIND.getName(), typeExpression);
                }
                if (containerOp != null) {
                    containerOp.inferDatatype();
                    containerOp = createContainerCall(containerOp, Container.FORALL, itExpression, localDecl);
                }
                if (containerOp != null) {
                    containerOp.inferDatatype();
                    Constraint constraint = new Constraint(containerOp, project);
                    result.add(constraint);
                }
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }            
        }
    }

    /**
     * Method for translating compound default value declarations.
     * 
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of <tt>decl</tt>.
     * @param compound if variable is a nested compound, the access expression to 
     *     <code>decl</code>/<code>variable</code>
     * @param type {@link Compound} type.
     */
    private void translateCompoundDefaults(AbstractVariable decl, IDecisionVariable variable,
        CompoundAccess compound, IDatatype type) {
        Compound cmpType = (Compound) type;
        CompoundVariable cmpVar = (CompoundVariable) variable;  
        for (int i = 0, n = cmpVar.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVariable = cmpVar.getNestedElement(i);
            AbstractVariable nestedDecl = nestedVariable.getDeclaration();
            CompoundAccess cmpAccess;
            if (compound == null) {
                cmpAccess = new CompoundAccess(new Variable(decl), nestedDecl.getName());                   
            } else {
                cmpAccess = new CompoundAccess(createAsTypeCast(compound, type, cmpVar.getValue().getType()), 
                    nestedDecl.getName());
            }
            inferTypeSafe(cmpAccess, null);
            // fill varMap
            varMap.put(nestedDecl, cmpAccess);
            translateDeclarationDefaults(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()),
                cmpAccess);
        }
        // used strategy: resolve and register compound accesses first in loop before, then constraints using them
        for (int i = 0, n = cmpVar.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVariable = cmpVar.getNestedElement(i);
            AbstractVariable nestedDecl = nestedVariable.getDeclaration();
            IDatatype nestedType = nestedDecl.getType();
            if (Container.isContainer(nestedType, ConstraintType.TYPE)  // THIS IS JUST PRELIMINARY - QM
                && nestedVariable.getValue() instanceof ContainerValue) {
                checkContainerValue((ContainerValue) nestedVariable.getValue(), decl, nestedDecl, 
                    nestedVariable, variable);
            }
            translateCollectionCompoundConstraints(nestedDecl, variable, varMap.get(nestedDecl), compoundConstraints);
            if (ConstraintType.TYPE.isAssignableFrom(nestedType)  // TODO TypeQuery.isConstraint
                && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                createConstraint(nestedDecl.getDefaultValue(), decl, nestedDecl, nestedVariable, variable);
            }
        }
        // Nested attribute assignments handling
        for (int x = 0; x < cmpType.getAssignmentCount(); x++) {
            processAttributeAssignments(cmpType.getAssignment(x), null, compound);
        }
        List<Constraint> thisCompoundConstraints = new ArrayList<Constraint>(); 
        allCompoundConstraints(cmpType, thisCompoundConstraints, false);        
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree oneConstraint = thisCompoundConstraints.get(i).getConsSyntax();
            // changed null to decl
            oneConstraint = copyCST(oneConstraint, new Variable(decl), varMap);
            try {
                Constraint constraint = new Constraint(oneConstraint, decl);
                compoundConstraints.add(constraint);            
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }               
        }
        processCompoundEvals(cmpType);
    }

    /**
     * Method for extracting constraints from compounds eval blocks (also refined compounds).
     * @param cmpType Compound to be analyzed 
     */
    private void processCompoundEvals(Compound cmpType) {
        for (int r = 0; r < cmpType.getRefinesCount(); r++) {
            processCompoundEvals(cmpType.getRefines(r));
        }
        for (int i = 0; i < cmpType.getModelElementCount(); i++) {            
            if (cmpType.getModelElement(i) instanceof PartialEvaluationBlock) {
                PartialEvaluationBlock evalBlock = (PartialEvaluationBlock) cmpType.getModelElement(i);
                processEvalConstraints(evalBlock);
            }
        }
    }
    
    /**
     * Method for handling eval blocks - searching for nested eval blocks and extracting constraints.
     * @param evalBlock Eval block to be processed.
     */
    private void processEvalConstraints(PartialEvaluationBlock evalBlock) {
        for (int i = 0; i < evalBlock.getNestedCount(); i++) {
            processEvalConstraints(evalBlock.getNested(i));
        }
        for (int i = 0; i < evalBlock.getEvaluableCount(); i++) {
            if (evalBlock.getEvaluable(i) instanceof Constraint) {
                Constraint evalConstraint = (Constraint) evalBlock.getEvaluable(i);
                ConstraintSyntaxTree evalCst = evalConstraint.getConsSyntax();
                ConstraintSyntaxTree cst = copyCST(evalCst, null, varMap);
                try {
                    cst.inferDatatype();
                    Constraint constraint = new Constraint(project);
                    constraint.setConsSyntax(cst);
                    compoundEvalConstraints.add(constraint);
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                } 
            }
        }
    }

    // <<< documented until here    
    
    /**
     * Method for checking if {@link CompoundInitializer} holds 
     * a {@link de.uni_hildesheim.sse.ivml.CollectionInitializer} with {@link Constraint}s.
     * @param exp expression to check.
     * @param compound false if variable is not nested.
     * @param parent parent for temporary constraints
     */
    private void checkCompoundInitializer(ConstraintSyntaxTree exp, Boolean compound, IModelElement parent) {
        CompoundInitializer compoundInit = (CompoundInitializer) exp;
        for (int i = 0; i < compoundInit.getExpressionCount(); i++) {
            if (compoundInit.getExpression(i) instanceof ContainerInitializer) {
                checkContainerInitializer(compoundInit.getExpression(i), compound, parent);
            }
            if (compoundInit.getExpression(i) instanceof CompoundInitializer) {
                checkCompoundInitializer(compoundInit.getExpression(i), compound, parent);
            }    
        }
    }

    /**
     * Method for checking if an expression is a {@link ContainerInitializer}.
     * @param exp expression to be checked.
     * @param compound false if variable is not nested.
     * @param parent parent for temporary constraints
     */
    private void checkContainerInitializer(ConstraintSyntaxTree exp, Boolean compound, IModelElement parent) {
        ContainerInitializer containerInit = (ContainerInitializer) exp;
        if (ConstraintType.TYPE.isAssignableFrom(containerInit.getType().getContainedType())) {
            extractCollectionConstraints(containerInit, compound, parent);
        }
    }

    /**
     * Method for extracting collection constraints.
     * @param containerInit Container with constraints.
     * @param compound false if variable is not nested.
     * @param parent parent for temporary constraints
     */
    private void extractCollectionConstraints(ContainerInitializer containerInit, Boolean compound, 
        IModelElement parent) {
        for (int i = 0; i < containerInit.getExpressionCount(); i++) {
            Constraint constraint = new Constraint(parent);
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            if (compound) {
                cst = copyCST(cst, null, varMap);
            }
            try {
                constraint.setConsSyntax(cst);
                collectionConstraints.add(constraint);
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
        }
    }

    /**
     * Checks a container value for nested constraints.
     * 
     * @param val the container value
     * @param decl unclear - refactored from above
     * @param parent the parent for new constraints
     * @param nestedVariable unclear - refactored from above
     * @param variable unclear - refactored from above
     */
    private void checkContainerValue(ContainerValue val, AbstractVariable decl, IModelElement parent, 
        IDecisionVariable nestedVariable, IDecisionVariable variable) {
        for (int n = 0; n < val.getElementSize(); n++) {
            Value cVal = val.getElement(n);
            if (cVal instanceof ConstraintValue) {
                ConstraintValue constraint = (ConstraintValue) cVal;
                createConstraint(constraint.getValue(), decl, parent, nestedVariable, variable);
            }
        }
    }
    
    /**
     * Creates a constraint from a constraint variable.
     * 
     * @param cst the constraint
     * @param decl unclear - refactored from above
     * @param parent the parent for new constraints
     * @param nestedVariable unclear - refactored from above
     * @param variable unclear - refactored from above
     * @return the created constraint
     */
    private Constraint createConstraint(ConstraintSyntaxTree cst, AbstractVariable decl, IModelElement parent, 
        IDecisionVariable nestedVariable, IDecisionVariable variable) {
        Constraint constraint = null;
        if (cst != null) {
            cst = copyCST(cst, new Variable(decl), varMap);
            try {
                constraint = new Constraint(cst, parent);
                constraintVariablesConstraints.add(constraint);
                //after refactoring duplicate check for ConstraintVariable is needed
                IDatatype nestedType = nestedVariable.getDeclaration().getType();
                if (ConstraintType.TYPE.isAssignableFrom(nestedType) 
                    && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                    constraintVariableMap.put(constraint, nestedVariable);
                }
                if (Descriptor.LOGGING) {
                    LOGGER.debug(variable.getDeclaration().getName() + " compound constraint variable " 
                        + toIvmlString(cst));
                }                    
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
        }
        return constraint;
    }
    
    /**
     * Method for getting all constraints relevant to a {@link Compound}.
     * @param cmpType Compound to be analyzed.
     * @param thisCompoundConstraints The list to add the compound {@link Constraint}s to.
     * @param host True if this is a host compound.
     */
    private void allCompoundConstraints(Compound cmpType, 
        List<Constraint> thisCompoundConstraints, boolean host) {
        for (int i = 0; i < cmpType.getConstraintsCount(); i++) {
            thisCompoundConstraints.add(cmpType.getConstraint(i));            
        }
        if (host) { // TODO why not constraint expr via refines?
            for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
                DecisionVariableDeclaration decl = cmpType.getInheritedElement(i);
                ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
                if (null != defaultValue) {
                    if (ConstraintType.TYPE.isAssignableFrom(decl.getType())) {
                        Constraint constraint = new Constraint(project);
                        try {
                            constraint.setConsSyntax(defaultValue);
                            thisCompoundConstraints.add(constraint);
                        } catch (CSTSemanticException e) {
                            LOGGER.exception(e);
                        }                   
                    }
                } 
            }            
        }
        for (int r = 0; r < cmpType.getRefinesCount(); r++) {
            allCompoundConstraints(cmpType.getRefines(r), thisCompoundConstraints, false);
        }
        for (int a = 0; a < cmpType.getAssignmentCount(); a++) {
            allAssignmentConstraints(cmpType.getAssignment(a), thisCompoundConstraints);
        }
    }
    
    /**
     * Collects all assignment constraints and adds them to <code>result</code>.
     * 
     * @param assng the assignment constraint
     * @param result the list of constraints to be modified as a side effect
     */
    private void allAssignmentConstraints(AttributeAssignment assng, List<Constraint> result) {
        for (int c = 0; c < assng.getConstraintsCount(); c++) {
            result.add(assng.getConstraint(c));
        }
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            allAssignmentConstraints(assng.getAssignment(a), result);
        }
    }    
    
    /**
     * Adds the constraints of <tt>constraintsToAdd</tt> to <tt>scopeConstraints</tt> while considering
     * {@link #considerFrozenConstraints}.
     * @param scopeConstraints The list of constraints for the current reasoning process
     *     (will be changed as side effect).
     * @param constraintsToAdd The constraints to be added to <tt>scopeConstraints</tt>.
     */
    private void addAllConstraints(List<Constraint> scopeConstraints, List<Constraint> constraintsToAdd) {
        if (considerFrozenConstraints) {
            scopeConstraints.addAll(constraintsToAdd);
        } else {
            for (int i = 0, n = constraintsToAdd.size(); i < n; i++) {
                Constraint currentConstraint = constraintsToAdd.get(i);
                VariablesInConstraintFinder finder = new VariablesInConstraintFinder(currentConstraint.getConsSyntax(),
                    config);
                Set<IAssignmentState> states = finder.getStates();
                if (!(1 == states.size() && states.contains(AssignmentState.FROZEN))) {
                    scopeConstraints.add(currentConstraint);
                }
            }
        }
    }
    
    /**
     * Translates and collects all constraints in {@link #project} by adding the collected constraints to the 
     * {@link #constraintBase}.
     * 
     * @see #resolve()
     */
    private void translateConstraints() { 
        List<Constraint> scopeConstraints = new ArrayList<Constraint>();
        if (!incremental && defaultConstraints.size() > 0) {
            defaultConstraints.addAll(deferredDefaultConstraints);
            addAllConstraints(scopeConstraints, transformConstraints(defaultConstraints, true));
        }
        if (derivedTypeConstraints.size() > 0) {
            addAllConstraints(scopeConstraints, transformConstraints(derivedTypeConstraints, false));
        }
        ConstraintFinder finder = new ConstraintFinder(project, false, false, true);
        addAllConstraints(scopeConstraints, finder.getEvalConstraints());
        if (compoundEvalConstraints.size() > 0) {
            scopeConstraints.addAll(compoundEvalConstraints);
        }
        addAllConstraints(scopeConstraints, finder.getConstraints());
        if (!incremental) {
            List<AttributeAssignment> scopeAttributes = new ArrayList<AttributeAssignment>();
            scopeAttributes = finder.getAttributeAssignments();
            if (scopeAttributes.size() > 0) {
                for (AttributeAssignment attributeAssignment : scopeAttributes) {
                    processAttributeAssignments(attributeAssignment, null, null);                
                }
            }            
        }
        if (compoundConstraints.size() > 0) {
            scopeConstraints.addAll(compoundConstraints);            
        }
        if (constraintVariablesConstraints.size() > 0) {
            scopeConstraints.addAll(constraintVariablesConstraints);
        }
        if (collectionCompoundConstraints.size() > 0) {
            scopeConstraints.addAll(collectionCompoundConstraints);            
        }
        for (Constraint constraint : scopeConstraints) {
            retrieveCollectionConstraints(constraint);
        }
        if (collectionConstraints.size() > 0) {
            scopeConstraints.addAll(collectionConstraints);
        }
        if (scopeConstraints.size() > 0) {
            fillVariableConstraintPool(scopeConstraints);
            if (incremental) {
                AssignmentConstraintFinder assignmentFinder = new AssignmentConstraintFinder(scopeConstraints);
                scopeConstraints = assignmentFinder.getValidationConstraints();                
            }
            addAllToConstraintBase(scopeConstraints);
            scopeConstraints.clear();
        }
        if (!incremental) {
            addAllToConstraintBase(defaultAnnotationConstraints);
            addAllToConstraintBase(assignedAttributeConstraints);
        }
        constraintCounter = constraintCounter + constraintBase.size();
        clearConstraintLists();
    }

    /**
     * Method for processing scope attribute assignments.
     * @param hostAssignment Attribute assignments on top-level.
     * @param nestAssignment Attribute assignments with data.
     * @param compound Parent {@link CompoundAccess}.
     */
    private void processAttributeAssignments(AttributeAssignment hostAssignment, AttributeAssignment nestAssignment, 
        CompoundAccess compound) {
        for (int i = 0; i < hostAssignment.getAssignmentDataCount(); i++) { 
            if (nestAssignment == null) {
                nestAssignment = hostAssignment;              
            } 
            for (int y = 0; y < nestAssignment.getElementCount(); y++) {
                processElement(hostAssignment.getAssignmentData(i),
                    nestAssignment.getElement(y), compound);
                if (TypeQueries.isCompound(nestAssignment.getElement(y).getType())) {                    
                    Compound cmp = (Compound) nestAssignment.getElement(y).getType();
                    for (int j = 0; j < cmp.getDeclarationCount(); j++) {
                        CompoundAccess cmpAccess;
                        if (compound == null) {
                            cmpAccess = new CompoundAccess(new Variable(nestAssignment.getElement(y)), 
                                cmp.getDeclaration(j).getName());                   
                        } else {
                            cmpAccess = new CompoundAccess(compound, cmp.getDeclaration(j).getName());

                        }
                        inferTypeSafe(cmpAccess, null);
                        processElement(hostAssignment.getAssignmentData(i), cmp.getDeclaration(j), cmpAccess);
                    }
                    
                }
            }
            for (int z = 0; z < nestAssignment.getAssignmentCount(); z++) {
                processAttributeAssignments(hostAssignment, nestAssignment.getAssignment(z), compound);
            }
        }        
    }
    
    /**
     * Method for creating attribute constraint for a specific element.
     * @param assignment Attribute assignment constraint.
     * @param element Elements to which the attribute is assigned.
     * @param compound Nesting compound if there is one.
     */
    private void processElement(Assignment assignment, DecisionVariableDeclaration element,
        CompoundAccess compound) {
        String attributeName = assignment.getName();
        Attribute attrib = (Attribute) element.getAttribute(attributeName);
        if (null != attrib) {
            ConstraintSyntaxTree cst = null;
            //handle annotations in compounds
            compound = null;
            compound = varMap.get(element);
            if (compound == null) {                      
                cst = new OCLFeatureCall(
                    new AttributeVariable(new Variable(element), attrib),
                        OclKeyWords.ASSIGNMENT, assignment.getExpression());
            } else {
                cst = new OCLFeatureCall(new AttributeVariable(compound, attrib),
                    OclKeyWords.ASSIGNMENT, assignment.getExpression());
            }
            inferTypeSafe(cst, null);
            Constraint constraint = new Constraint(project);
            try {
                constraint.setConsSyntax(cst);
                assignedAttributeConstraints.add(constraint);
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
        }
    }
    
    /**
     * Method for retrieving constraints from collections.
     * @param constraint Constraint to be analyzed.
     */
    private void retrieveCollectionConstraints(Constraint constraint) {
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        CollectionConstraintsFinder finder = new CollectionConstraintsFinder(cst);
        if (finder.isConstraintCollection()) {
            checkContainerInitializer(finder.getExpression(), false, constraint.getParent());
        }
        if (finder.isCompoundInitializer()) {
            checkCompoundInitializer(finder.getExpression(), true, constraint.getParent());
        }
    }


    /**
     * Method for filling the map with constraints related to specific variable.
     * @param constraints Constraints to be checked for variables.
     */
    private void fillVariableConstraintPool(List<Constraint> constraints) {
        for (Constraint constraint : constraints) { 
            if (constraint.getConsSyntax() != null) {
                VariablesInConstraintsFinder varFinder = new VariablesInConstraintsFinder(constraint.getConsSyntax());
                if (!varFinder.isSimpleAssignment()) {
                    for (AbstractVariable declaration : varFinder.getVariables()) {
                        constraintMap.add(declaration, constraint);                       
                    }
                }                    
            }
        }
    }
    
    // messages
    
    /**
     * Records information about the evaluation result, failed evaluation messages.
     * 
     * @param constraint the constraint to record the actual messages for
     */
    private void analyzeEvaluationResult(Constraint constraint) {
        if (evaluator.constraintFailed()) {
            FailedElementDetails failedElementDetails = new FailedElementDetails();
            failedElementDetails.setProblemPoints(new HashSet<IDecisionVariable>(usedVariables));
            failedElementDetails.setProblemConstraintPart(getFailedConstraintPart());
            failedElementDetails.setProblemConstraint(constraint);
            failedElementDetails.setErrorClassifier(ReasoningErrorCodes.FAILED_CONSTRAINT);
            failedElements.addProblemConstraint(constraint, failedElementDetails);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Failed constraint: " + toIvmlString(constraint));
                printModelElements(config, "constraint resolved");
                printProblemPoints(usedVariables);
            }
        } else if (evaluator.constraintFulfilled()) {
            failedElements.removeProblemConstraint(constraint);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Constraint fulfilled: " + toIvmlString(constraint));
            }
        }
        // must be done always, constraints -> undefined may cause illegal variable assignments as side effect
        for (int j = 0; j < evaluator.getMessageCount(); j++) {
            Message msg = evaluator.getMessage(j);
            AbstractVariable var = msg.getVariable();
            if (var != null) {
                // no local variable, i.e., defined for/within user-defined operation or within constraint
                if (!(var.getParent() instanceof OperationDefinition) && !(var.getParent() instanceof Constraint)) {
                    usedVariables.clear();
                    usedVariables.add(msg.getDecision());
                    FailedElementDetails failedelementDetails = new FailedElementDetails();
                    failedelementDetails.setProblemPoints(new HashSet<IDecisionVariable>(usedVariables));
                    // due to NULL result if failed assignment
                    failedelementDetails.setProblemConstraintPart(constraint.getConsSyntax());
                    failedelementDetails.setProblemConstraint(constraint);
                    failedelementDetails.setErrorClassifier(ReasoningErrorCodes.FAILED_REASSIGNMENT);
                    failedElements.addProblemVariable(var, failedelementDetails);
                    if (Descriptor.LOGGING) {
                        LOGGER.debug("Assigment error: " + evaluator.getMessage(j).getVariable());
                        printProblemPoints(usedVariables);
                    }
                }
            } 
        }
    }
    
    // helpers, accessors

    /**
     * Adds <code>constraint</code> to the constraint base.
     * 
     * @param constraint the constraint
     */
    private void addToConstraintBase(Constraint constraint) {
        constraintBase.addLast(constraint);
        constraintBaseSet.add(constraint);
    }

    /**
     * Adds all <code>constraints</code> to the constraint base.
     * 
     * @param constraints the constraints
     */
    private void addAllToConstraintBase(Collection<Constraint> constraints) {
        if (constraints.size() > 0) {
            constraintBase.addAll(constraints);
            constraintBaseSet.addAll(constraints);
        }
    }

    /**
     * Method for clearing all constraint lists.
     */
    private void clearConstraintLists() {
        defaultConstraints.clear();
        derivedTypeConstraints.clear();
        compoundConstraints.clear();
        compoundEvalConstraints.clear();
        constraintVariablesConstraints.clear();        
        collectionCompoundConstraints.clear(); 
        collectionConstraints.clear();      
        defaultAnnotationConstraints.clear();
        assignedAttributeConstraints.clear();
        unresolvedConstraints.clear();   
    }
    
    /**
     * Will be called after a failure was detected in a default constraint of an {@link AbstractVariable}.
     * @param decl The conflicting declaration of an {@link AbstractVariable}.
     *     Call {@link AbstractVariable#getDefaultValue()} to retrieve the conflicting constraint.
     */
    @SuppressWarnings("unused")
    private void conflictingDefault(AbstractVariable decl) {
        // currently unused
    }
    
    /**
     * Method for creating a clean {@link Configuration}.
     * @param project Project for {@link Configuration}
     * @return Created {@link Configuration}
     */
    private Configuration createCleanConfiguration(Project project) {
        return new Configuration(project, false);
    }
    
    /**
     * Method for transforming constraints with CopyVisitor.
     * @param constraints Constraints to be transformed (already copied constraint list).
     * @param makeDefaultConstraint True if constraints should be default.
     * @return List of transformed constraints.
     */
    private List<Constraint> transformConstraints(List<Constraint> constraints, boolean makeDefaultConstraint) {
        for (int i = 0; i < constraints.size(); i++) {
            ConstraintSyntaxTree cst = constraints.get(i).getConsSyntax();
            cst = copyCST(cst, null, varMap);
            if (makeDefaultConstraint) {
                constraints.get(i).makeDefaultConstraint();                
            }
            if (cst != null) {
                try {
                    constraints.get(i).setConsSyntax(cst);
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                }                            
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Default constraint: " + toIvmlString(cst));                    
                }
            }            
        }
        return constraints;
    }
    
    /**
     * Method for checking part of a failed constraints against null.
     * @return null or part of a failed constraint.
     */
    private ConstraintSyntaxTree getFailedConstraintPart() {
        ConstraintSyntaxTree cstPart = null;
        if (evaluator.getFailedExpression() != null) {
            cstPart = evaluator.getFailedExpression()[0];
        }        
        return cstPart;
    }
    
    /**
     * Getter for the map of all ConstraintVariables.
     * and their {@link Constraint}s.
     * @return Map of constraint variables and their constraints.
     */
    Map<Constraint, IDecisionVariable> getConstraintVariableMap() {
        return constraintVariableMap;
    }
    
    /**
     * Method for returning the overall count of evaluated constraints in the model.
     * @return number of evaluated constraints.
     */
    public int constraintCount() {
        return constraintCounter;
    }
    
    /**
     * Method for returning the overall number of variables in the model.
     * @return number of variables.
     */
    public int variableCount() {
        return variablesCounter;
    }
    
    /**
     * Method for returning the number of variables involved in constraints.
     * @return number of variables.
     */
    public int variableInConstraintCount() {
        return variablesInConstraintsCounter;
    }
    
    /**
     * Method for returning the overall number of reevaluations in the model.
     * @return number of reevaluations.
     */
    public int reevaluationCount() {
        return reevaluationCounter;
    }
    
    /**
     * Method for retrieving {@link FailedElements} with failed {@link Constraint}s and {@link IDecisionVariable}s.
     * @return {@link FailedElements}
     */
    public FailedElements getFailedElements() {
        return failedElements;
    }  

    /**
     * Sets whether reasoning shall happen incrementally. 
     * @param incremental if reasoning shall happen incrementally
     */
    void setIncremental(boolean incremental) {
        this.incremental = incremental;
    }
    
    
    /**
     * Factory method for creating the evaluation visitor.
     * 
     * @return the evaluation visitor
     */
    protected EvaluationVisitor createEvaluationVisitor() {
        return new EvalVisitor();
    }

}
