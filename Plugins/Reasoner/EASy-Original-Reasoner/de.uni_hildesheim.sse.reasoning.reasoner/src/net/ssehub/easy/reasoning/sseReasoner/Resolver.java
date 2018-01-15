package net.ssehub.easy.reasoning.sseReasoner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintReplacer;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.cstEvaluation.IResolutionListener;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener;
import net.ssehub.easy.varModel.cstEvaluation.LocalDecisionVariable;
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
import net.ssehub.easy.varModel.model.datatypes.Operation;
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
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Constraint identifier, resolver and executor.
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
    
    private Project project;
    private Configuration config;
    private EvalVisitor evaluator = new EvalVisitor();
    private FailedElements failedElements = new FailedElements();
    private ScopeAssignments scopeAssignments = new ScopeAssignments();

    private VariablesMap constraintMap = new VariablesMap();
    private Map<Constraint, IDecisionVariable> constraintVariableMap = new HashMap<Constraint, IDecisionVariable>();
    private Deque<Constraint> constraintBase = new LinkedList<Constraint>();   
    private List<Constraint> constraintVariables = new ArrayList<Constraint>();
    private List<Constraint> compoundConstraints = new ArrayList<Constraint>();
    private List<Constraint> compoundEvalConstraints = new ArrayList<Constraint>();
    private List<Constraint> unresolvedConstraints = new ArrayList<Constraint>(); 
    private List<Constraint> defaultAttributeConstraints = new ArrayList<Constraint>();
    private List<Constraint> assignedAttributeConstraints = new ArrayList<Constraint>();
    private List<Constraint> collectionConstraints = new ArrayList<Constraint>();
    private List<Constraint> defaultConstraints = new ArrayList<Constraint>();
    private List<Constraint> deferredDefaultConstraints = new ArrayList<Constraint>();
    private List<Constraint> internalConstraints = new ArrayList<Constraint>();
    private boolean considerFrozenConstraints;
    
    private Map<AbstractVariable, CompoundAccess> varMap;
    
    private List<Constraint> collectionCompoundConstraints = new ArrayList<Constraint>();
    private Set<IDecisionVariable> problemVariables = new HashSet<IDecisionVariable>();
    
    // Stats
    private int constraintCounter = 0;
    private int variablesInConstraintsCounter = 0;    
    private int reevaluationCounter = 0;
    private int variablesCounter = 0;
    
    private boolean incremental;
    
    private IValueChangeListener listener = new IValueChangeListener() {
        
        @Override
        public void notifyUnresolved(IDecisionVariable variable) {
        }
        
        @Override
        public void notifyChanged(IDecisionVariable variable) {
            if (!(variable instanceof LocalDecisionVariable)) {
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Value changed: " + variable.getDeclaration().getName() + " " + variable.getValue()
                        + " Parent: " + (null == variable.getParent() ? null : variable.getParent()));                 
                }
                scopeAssignments.addAssignedVariable(variable);
                AbstractVariable declaration = variable.getDeclaration();
                Set<Constraint> varConstraints = constraintMap.getRelevantConstraints(declaration);
                Set<Constraint> constraintsToReevaluate = new HashSet<Constraint>();
                if (null != varConstraints) {
                    constraintsToReevaluate.addAll(varConstraints);
                }
                // All constraints for the parent (as this was also changed)
                IConfigurationElement parent = variable.getParent();
                if (parent instanceof IDecisionVariable) {
                    constraintsForParent((IDecisionVariable) parent, constraintsToReevaluate);
                }
                // All constraints for childs (as they may also changed)
                for (int j = 0, nChilds = variable.getNestedElementsCount(); j < nChilds; j++) {
                    IDecisionVariable nestedVar = variable.getNestedElement(j);
                    if (!(nestedVar instanceof LocalDecisionVariable)) {
                        constraintsForChild(nestedVar, constraintsToReevaluate);
                    }
                }
                for (Constraint varConstraint : constraintsToReevaluate) {
                    boolean found = false;
                    for (Constraint c : constraintBase) {
                        if (c == varConstraint) { // reference equality is ok here as we search for the identical one
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        constraintBase.add(varConstraint);
                        constraintCounter++;
                    }
                }
            }
        }
        
        private void constraintsForParent(IDecisionVariable variable, Set<Constraint> constraintsToReevaluate) {
            AbstractVariable declaration = variable.getDeclaration();
            Set<Constraint> varConstraints = constraintMap.getRelevantConstraints(declaration);
            if (null != varConstraints) {
                constraintsToReevaluate.addAll(varConstraints);
            }
            IConfigurationElement parent = variable.getParent();
            if (parent instanceof IDecisionVariable) {
                constraintsForParent((IDecisionVariable) parent, constraintsToReevaluate);                            
            }
        }
        
        private void constraintsForChild(IDecisionVariable variable, Set<Constraint> constraintsToReevaluate) {
            AbstractVariable declaration = variable.getDeclaration();
            Set<Constraint> varConstraints = constraintMap.getRelevantConstraints(declaration);
            if (null != varConstraints) {
                constraintsToReevaluate.addAll(varConstraints);
            }
            for (int j = 0, nChilds = variable.getNestedElementsCount(); j < nChilds; j++) {
                IDecisionVariable nestedVar = variable.getNestedElement(j);
                if (!(nestedVar instanceof LocalDecisionVariable)) {
                    constraintsForChild(nestedVar, constraintsToReevaluate);
                }
            }
        }
    };
    
    private IResolutionListener resolutionListener = new IResolutionListener() {
        
        @Override
        public void notifyResolved(IDecisionVariable compound, String slotName, IDecisionVariable resolved) {
            if (!(resolved instanceof LocalDecisionVariable)) {
                problemVariables.add(resolved);                
            }
        }
        
        @Override
        public void notifyResolved(AbstractVariable declaration, IDecisionVariable resolved) {
            if (!(resolved instanceof LocalDecisionVariable)) {
                problemVariables.add(resolved);                
            }            
        }
    };
    
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
    
    /**
     * Resolves the (initial) values of the configuration. This is done as follows:
     * <ol>
     * <li>Resolve default values of variable declarations</li>
     * <li>Resolve values of assignments</li>
     * </ol>
     */
    public void resolve() { 
        // Stack of importedProject (start with inner most imported project)
        List<Project> projects = Utils.discoverImports(config.getProject());    
        while (!projects.isEmpty()) {
            project = projects.remove(0);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Project:" + project.getName());                
            }
            evaluator.setDispatchScope(project);
            scopeAssignments.clearScopeAssignments();
            resolveDefaultValues();
            processConstraints(project);
            // Freezes values after each scope
            config.freezeValues(project, FilterType.NO_IMPORTS);
            // TODO do incremental freezing in here -> required by interfaces with propagation constraints
            if (Descriptor.LOGGING) {
//                printModelElements(config, "After reasoning in scope " + project.getName());
                displayFailedElements();                                
            }
        }
        variablesInConstraintsCounter = constraintMap.getDeclarationSize();
    }   
    
    /**
     * Part of the {@link #resolve()} method.
     * Resolves default values of variable declarations.
     */
    protected void resolveDefaultValues() {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.NO_IMPORTS, null);
        List<AbstractVariable> variables = finder.getVariableDeclarations(VisibilityType.ALL);
        varMap = new HashMap<AbstractVariable, CompoundAccess>();
        for (AbstractVariable decl : variables) {
            resolveDefaultsForDeclaration(decl, config.getDecision(decl), null);
        }
    }    
    
    /**
     * Part of the {@link #resolveDefaultValues(Project)} method.
     * Resolves default values of a particular declaration.
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param var the instance of <tt>decl</tt>.
     * @param compAcc if variable is a nested compound.
     */
    protected void resolveDefaultsForDeclaration(AbstractVariable decl, IDecisionVariable var, CompoundAccess compAcc) {
        List<Constraint> defltCons = defaultConstraints; 
        variablesCounter++;
        IDatatype type = decl.getType();
        // Internal constraints
        if (type instanceof DerivedDatatype) {
            DerivedDatatype dType = (DerivedDatatype) type;
            analyseDerivedDatatype(decl, dType); 
        }
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        // Attribute handling
        if (var.getAttributesCount() > 0) {
            resolveAttributeAssignments(decl, var, compAcc);
        }
        if (TypeQueries.isCompound(type)) {
            if (null != defaultValue) { // try considering the actual type, not only the base type
                type = inferTypeSafe(defaultValue, type);
            }
            resolveCompoundDefaultValueForDeclaration(decl, var, compAcc, type); 
            if (null != defaultValue) {
                defaultValue = copyExpression(defaultValue, decl);
            }
        } else if (null != defaultValue && TypeQueries.isContainer(type)) {
            Set<Compound> used = getUsedTypes(defaultValue, Compound.class);
            if (null != used && !used.isEmpty()) {
                for (Compound uType : used) {
                    collectDefaultsCompoundCollection(decl, uType, new HashSet<Compound>());
                }
            }
        } else if (null != defaultValue && null != compAcc) {
            // all self/overriden compound initialization constraints have to be deferred until compound/container 
            // initializers are set as they would be overridden else
            CopyVisitor visitor = new CopyVisitor(null, null).setSelf(compAcc.getCompoundExpression());
            defaultValue = visitor.accept(defaultValue);
            inferTypeSafe(defaultValue, null);
            if (visitor.containsSelf() || isOverriddenSlot(decl)) {
                defltCons = deferredDefaultConstraints;
            }
        }
        collectionCompoundConstraints.addAll(collectionCompoundConstraints(decl, var, null));
        // Container
        if (net.ssehub.easy.varModel.model.datatypes.Container.TYPE.isAssignableFrom(type)) {            
            collectionInternalConstraints(decl, null);
        }
        if (null != defaultValue) {
            try {
                if (ConstraintType.TYPE.isAssignableFrom(type) 
                    && !(type.getType() == BooleanType.TYPE.getType())) {
                    if (compAcc == null) {
                        variablesCounter--;
                        // use closest parent instead of project -> runtime analysis
                        Constraint constraint = new Constraint(defaultValue, var.getDeclaration());
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, var);
                        if (Descriptor.LOGGING) {
                            LOGGER.debug(var.getDeclaration().getName() + " project constraint variable " 
                                + StringProvider.toIvmlString(defaultValue));
                        }
                    } 
                } else { // Create default constraint
                    ConstraintSyntaxTree cst = new OCLFeatureCall(
                        defltCons == deferredDefaultConstraints ? compAcc : new Variable(decl), 
                        OclKeyWords.ASSIGNMENT, defaultValue);
                    defltCons.add(createDefaultConstraint(cst, project));
                }                
            } catch (CSTSemanticException e) {
                LOGGER.exception(e); // should not occur, ok to log
            }            
        }
    }

    /**
     * Returns whether <code>decl</code> is an overridden slot.
     * 
     * @param decl the declaration of the slot to search for
     * @return <code>true</code> if overridden, <code>false</code> else
     */
    private static boolean isOverriddenSlot(AbstractVariable decl) {
        boolean overridden = false;
        IModelElement iter = decl.getParent(); 
        // find declaring compound
        while (null != iter && !(iter instanceof Compound)) {
            iter = iter.getParent();
        }
        if (iter instanceof Compound) {
            overridden = countSlots((Compound) iter, decl.getName(), true) > 1;
        }
        return overridden;
    }
    
    /**
     * Counts the number of slots with given <code>name</code> in the refines hierarchy 
     * of <code>cmp</code>.
     * 
     * @param cmp the compound to start searching
     * @param name the name of the slot to search for
     * @param stopGreater1 stop searching if we have more than one matching slot
     * @return the number of slots
     */
    private static int countSlots(Compound cmp, String name, boolean stopGreater1) {
        int result = 0;
        if (null != cmp.getElement(name)) {
            result++;
        }
        for (int r = 0; r < cmp.getRefinesCount(); r++) {
            result += countSlots(cmp.getRefines(r), name, stopGreater1);
            if (stopGreater1 && result > 1) {
                break;
            }
        }
        return result;
    }
    
    /**
     * Collect constraints representing compound defaults in collections of compounds.
     * 
     * @param decl the collection variable
     * @param cmpType the compound type used in the actual <code>decl</code> value to focus the constraints created
     * @param done the already processed types (to be modified as a side effect)
     */
    private void collectDefaultsCompoundCollection(AbstractVariable decl, Compound cmpType, Set<Compound> done) {
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
                        defaultValue = copyExpression(defaultValue, localDeclVar, null); // copy and replace self
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
                collectDefaultsCompoundCollection(decl, cmpType.getRefines(r), done);
            }
        }
    }

    /**
     * Returns whether <code>type</code> is a type-nested collection.
     * 
     * @param type the type
     * @return <code>true</code> for a nested collection, <code>false else</code>
     */
    private boolean isNestedCollection(IDatatype type) {
        return TypeQueries.isContainer(type) 
            && 1 == type.getGenericTypeCount() 
            && isNestedCollection(type.getGenericType(0));
    }

    /**
     * Returns the used types if <code>cst</code> is a constant container value.
     * 
     * @param <D> the the to filter for
     * @param cst the expression
     * @param filter the type class to filter for
     * @return the set of used types, may be empty or <b>null</b> for none
     */
    private <D extends IDatatype> Set<D> getUsedTypes(ConstraintSyntaxTree cst, Class<D> filter) {
        Set<D> result = null;
        if (cst instanceof ConstantValue) {
            result = new HashSet<D>();
            getUsedTypes(((ConstantValue) cst).getConstantValue(), filter, result);
        }
        return result;
    }

    /**
     * Returns the used types if <code>value</code> is a container value.
     * 
     * @param <D> the the to filter for
     * @param val the value
     * @param filter the type class to filter for
     * @param result the result set to be modified as a side effect
     * @return the set of used types, may be empty or <b>null</b> for none
     */
    private <D extends IDatatype> boolean getUsedTypes(Value val, Class<D> filter, Set<D> result) {
        boolean done = false;
        if (val instanceof ContainerValue) {
            ContainerValue cVal = (ContainerValue) val;
            for (int v = 0; v < cVal.getElementSize(); v++) {
                Value tmp = cVal.getElement(v);
                if (!getUsedTypes(tmp, filter, result)) {
                    IDatatype tType = tmp.getType();
                    if (filter.isInstance(tType)) {
                        result.add(filter.cast(tType));
                    }
                }
            }
            done = true;
        }
        return done;
    }
    
    /**
     * Creates a default constraint.
     * 
     * @param cst the constraint expression
     * @param parent the parent
     * @return the created constraint
     * @throws CSTSemanticException in case that the creation fails
     */
    private Constraint createDefaultConstraint(ConstraintSyntaxTree cst, IModelElement parent) 
        throws CSTSemanticException {
        Constraint constraint = new Constraint(project);
        constraint.makeDefaultConstraint();
        cst.inferDatatype(); 
        constraint.setConsSyntax(cst);
        return constraint;
    }

    /**
     * Infers the type of <code>cst</code> using <code>dflt</code> as fallback.
     * 
     * @param cst the expression to infer the type for
     * @param dflt the default
     * @return the type of the expression or <code>dflt</code> in case of failures
     */
    private IDatatype inferTypeSafe(ConstraintSyntaxTree cst, IDatatype dflt) {
        IDatatype result = dflt;
        try {
            result = cst.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // should not occur, ok to log
        }
        return result;
    }

    /**
     * Method for analyzing {@link DerivedDatatype}s and extracting internal constraints.
     * @param decl VariableDeclaration of <code>DerivedDatatype</code>
     * @param dType type of <code>DerivedDatatype</code>
     */
    private void analyseDerivedDatatype(AbstractVariable decl, DerivedDatatype dType) {
        InternalConstraint[] typeConstraints = createInternalConstraints(decl, dType);
        if (typeConstraints != null) {
            for (InternalConstraint internalConstraint : typeConstraints) {
                internalConstraints.add(internalConstraint);                    
            }
        }
        if (dType.getBasisType() instanceof DerivedDatatype) {
            analyseDerivedDatatype(decl, (DerivedDatatype) dType.getBasisType());
        }        
    }
    
    /**
     * Creates constraints related to variable declaration. This method is needed for <code>DerivedDatatypes</code>. 
     * @param declaration VariableDeclaration of <code>DerivedDatatype</code>
     * @param dType type of <code>DerivedDatatype</code>
     * @return <code>null</code> if this datatype is not <code>DerivedDatatype</code> or if this 
     * <code>DerivedDatatype</code> has no constraints, otherwise the adapted constraints of the 
     * <code>DerivedDatatype</code> for this VariableDeclaration
     */
    private InternalConstraint[] createInternalConstraints(AbstractVariable declaration, DerivedDatatype dType) {
        InternalConstraint[] constraintInstances = null;
        if (dType.getConstraintCount() > 0 && dType.getTypeDeclaration() != declaration) {
            constraintInstances = new InternalConstraint[dType.getConstraintCount()];            
            //Copy and replace each instance of the internal declaration with the given instance
            for (int i = 0; i < dType.getConstraintCount(); i++) {
                ConstraintSyntaxTree oneConstraint = dType.getConstraint(i).getConsSyntax();
                ConstraintReplacer replacer = new ConstraintReplacer(oneConstraint);
                Variable origin = new Variable(dType.getTypeDeclaration());
                Variable replacement = new Variable(declaration);
                ConstraintSyntaxTree copiedCST = replacer.replaceVariable(origin, replacement);
                // Should be in same project as the declaration belongs to
                try {
                    constraintInstances[i] = new InternalConstraint(dType, copiedCST, declaration.getTopLevelParent());
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                }
            }
        }        
        return constraintInstances;
    }

    /**
     * Method for checking if {@link CompoundInitializer} holds 
     * a {@link de.uni_hildesheim.sse.ivml.CollectionInitializer} with {@link Constraint}s.
     * @param exp expression to check.
     * @param compound false if variable is not nested.
     * @param parent parent for temporary constraints
     */
    private void checkCompoundInitializer(ConstraintSyntaxTree exp, Boolean compound, IModelElement parent) {
//        infoLogger.info("CompoundInitializer: " + StringProvider.toIvmlString(exp));
        CompoundInitializer compoundInit = (CompoundInitializer) exp;
        for (int i = 0; i < compoundInit.getExpressionCount(); i++) {
//            infoLogger.info("Exp: " + StringProvider.toIvmlString(compoundInit.getExpression(i)));
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
//        infoLogger.info("ContainerInitializer: " + StringProvider.toIvmlString(exp));
        ContainerInitializer containerInit = (ContainerInitializer) exp;
//        infoLogger.info("Type: " + containerInit.getType().getContainedType());
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
//            infoLogger.info("Container expression: " 
//                + StringProvider.toIvmlString(containerInit.getExpression(i)));
            Constraint constraint = new Constraint(parent);
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            if (compound) {
                cst = copyExpression(cst);
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
     * Method for resolving attribute assignments.
     * @param decl {@link AbstractVariable} with attributes.
     * @param variable {@link IDecisionVariable} with attributes.
     * @param compound {@link CompoundAccess} null if variable is not nested.
     */
    private void resolveAttributeAssignments(AbstractVariable decl, IDecisionVariable variable, 
        CompoundAccess compound) {
        for (int i = 0; i < variable.getAttributesCount(); i++) {
            ConstraintSyntaxTree defaultValue = variable.getAttribute(i).getDeclaration().getDefaultValue();
            if (null != defaultValue) {
                Constraint constraint = new Constraint(project);
                constraint.makeDefaultConstraint();
                try {
//                    infoLogger.info("Attribute constraint before: " + StringProvider.toIvmlString(defaultValue));
                    if (compound == null) {
                        defaultValue = new OCLFeatureCall(new AttributeVariable(new Variable(decl),
                            (Attribute) variable.getAttribute(i).getDeclaration()),
                            OclKeyWords.ASSIGNMENT, defaultValue);                        
                    } else {                        
                        defaultValue = new OCLFeatureCall(new AttributeVariable(compound,
                            (Attribute) variable.getAttribute(i).getDeclaration()),
                            OclKeyWords.ASSIGNMENT, defaultValue);
                    }
                    defaultValue.inferDatatype();
                    constraint.setConsSyntax(defaultValue);
//                    infoLogger.info("Attribute constraint after: " 
//                        + StringProvider.toIvmlString(constraint.getConsSyntax()));
                    defaultAttributeConstraints.add(constraint);
                } catch (CSTSemanticException e) {
                    e.printStackTrace();
                }                    
            }
        }
    }

    /**
     * Method for resolving compound default value declaration.
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of <tt>decl</tt>.
     * @param compound if variable is a nested compound.
     * @param type {@link Compound} type.
     */
    private void resolveCompoundDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable,
        CompoundAccess compound, IDatatype type) {
        CompoundAccess cmpAccess = compound;
        Compound cmpType = (Compound) type;
        List<Constraint> thisCompoundConstraints = new ArrayList<Constraint>(); 
        getAllCompoundConstraints(cmpType, thisCompoundConstraints, false);        
        CompoundVariable cmpVar = (CompoundVariable) variable;  
        for (int i = 0, n = cmpVar.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVariable = cmpVar.getNestedElement(i);
            AbstractVariable nestedDecl = nestedVariable.getDeclaration();
//            infoLogger.info(i + ": " + cmpType.getInheritedElement(i) + " " + cmpVar.getNestedElement(i));
            cmpAccess = null;
            if (compound == null) {
                cmpAccess = new CompoundAccess(new Variable(decl), nestedDecl.getName());                   
            } else {
                cmpAccess = new CompoundAccess(compound, nestedDecl.getName());
            }
            inferTypeSafe(cmpAccess, null);
            // fill varMap
            varMap.put(nestedDecl, cmpAccess); // TODO turn into local map!
            resolveDefaultsForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()),
                cmpAccess);
        }
        // used strategy: resolve compound accesses first in loop before, then constraints using them
        for (int i = 0, n = cmpVar.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVariable = cmpVar.getNestedElement(i);
            AbstractVariable nestedDecl = nestedVariable.getDeclaration();
            IDatatype nestedType = nestedDecl.getType();
            if (Container.isContainer(nestedType, ConstraintType.TYPE)  // THIS IS JUST PRELIMINARY - QM
                && nestedVariable.getValue() instanceof ContainerValue) {
                checkContainerValue((ContainerValue) nestedVariable.getValue(), decl, nestedDecl, 
                    nestedVariable, variable);
            }
            compoundConstraints.addAll(collectionCompoundConstraints(nestedDecl, variable, cmpAccess));
            if (ConstraintType.TYPE.isAssignableFrom(nestedType) 
                && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                createConstraint(nestedDecl.getDefaultValue(), decl, nestedDecl, nestedVariable, variable);
            }
        }
        // Nested attribute assignments handling
        for (int x = 0; x < cmpType.getAssignmentCount(); x++) {
            processAttributeAssignments(cmpType.getAssignment(x), null,  cmpAccess);
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree oneConstraint = thisCompoundConstraints.get(i).getConsSyntax();
            // changed null to decl
            oneConstraint = copyExpression(oneConstraint, decl);
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
                ConstraintSyntaxTree cst = copyExpression(evalCst);
                try {
                    cst.inferDatatype();
                    Constraint constraint = new Constraint(project);
                    constraint.setConsSyntax(cst);
                    compoundEvalConstraints.add(constraint);
//                    System.out.println("Eval constraint after: " 
//                        + StringProvider.toIvmlString(constraint.getConsSyntax()));
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                } 
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
//        if (cst != null && !(cst instanceof ConstantValue)) {
        if (cst != null) {
            cst = copyExpression(cst, decl);
            try {
                constraint = new Constraint(cst, parent);
                constraintVariables.add(constraint);
                //after refactoring duplicate check for ConstraintVariable is needed
                IDatatype nestedType = nestedVariable.getDeclaration().getType();
                if (ConstraintType.TYPE.isAssignableFrom(nestedType) 
                    && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                    constraintVariableMap.put(constraint, nestedVariable);
                }
                if (Descriptor.LOGGING) {
                    LOGGER.debug(variable.getDeclaration().getName() + " compound constraint variable " 
                        + StringProvider.toIvmlString(cst));
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
    private void getAllCompoundConstraints(Compound cmpType, 
        List<Constraint> thisCompoundConstraints, boolean host) {
        for (int i = 0; i < cmpType.getConstraintsCount(); i++) {
            thisCompoundConstraints.add(cmpType.getConstraint(i));            
        }
        if (host) {
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
            getAllCompoundConstraints(cmpType.getRefines(r), thisCompoundConstraints, false);
        }
        for (int a = 0; a < cmpType.getAssignmentCount(); a++) {
            collectAllAssignmentConstraints(cmpType.getAssignment(a), thisCompoundConstraints);
        }
    }
    
    /**
     * Collects all assignment constraints and adds them to <code>result</code>.
     * 
     * @param assng the assignment constraint
     * @param result the list of constraints to be modified as a side effect
     */
    private void collectAllAssignmentConstraints(AttributeAssignment assng, List<Constraint> result) {
        for (int c = 0; c < assng.getConstraintsCount(); c++) {
            result.add(assng.getConstraint(c));
        }
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            collectAllAssignmentConstraints(assng.getAssignment(a), result);
        }
    }    
    
    /**
     * Method for collecting internal constraints from Collections.
     * @param decl Collection variable
     * @param topcmpAccess {@link CompoundAccess} might be null.
     */
    private void collectionInternalConstraints(AbstractVariable decl, CompoundAccess topcmpAccess) {
        IDatatype type = decl.getType();
        if (net.ssehub.easy.varModel.model.datatypes.Set.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Set set 
                = (net.ssehub.easy.varModel.model.datatypes.Set) type;
            if (set.getContainedType() instanceof DerivedDatatype) {
                transformCollectionInternalConstraints((DerivedDatatype) set.getContainedType(),
                    Container.FORALL, decl, topcmpAccess);
            }
        }
        if (net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Sequence sequence 
                = (net.ssehub.easy.varModel.model.datatypes.Sequence) type;
            if (sequence.getContainedType() instanceof DerivedDatatype) {
                transformCollectionInternalConstraints((DerivedDatatype) sequence.getContainedType(),
                    Container.FORALL, decl, topcmpAccess);
            }
        }
    }
    
    /**
     * Method for transforming collected internal constraint from collections into cyclic constraints.
     * @param derivedType {@link DerivedDatatype} of the Collection.
     * @param op Cyclic operation.
     * @param decl Collection variable.
     * @param topcmpAccess {@link CompoundAccess}, might be null.
     */
    private void transformCollectionInternalConstraints(DerivedDatatype derivedType, Operation op, 
        AbstractVariable decl, CompoundAccess topcmpAccess) {  
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("derivedType", derivedType, null);
        InternalConstraint[] typeConstraints = createInternalConstraints(localDecl, derivedType);
        if (typeConstraints != null) {
            for (int i = 0, n = typeConstraints.length; i < n; i++) {
                InternalConstraint internalConstraint = typeConstraints[i];
                ConstraintSyntaxTree itExpression = internalConstraint.getConsSyntax();
//            itExpression = copyVisitor(itExpression, null);
//            if (Descriptor.LOGGING) {
//                System.out.println("New loop constraint " + StringProvider.toIvmlString(itExpression));
//            }
                ConstraintSyntaxTree containerOp = null;
                if (topcmpAccess == null) {
                    containerOp = createContainerCall(new Variable(decl), op, itExpression, localDecl);
                } else {
                    containerOp = createContainerCall(topcmpAccess, op, itExpression, localDecl);
                }            
                try {
                    if (containerOp != null) {
                        containerOp.inferDatatype();
                        Constraint constraint = new Constraint(containerOp, project);
                        internalConstraints.add(constraint);                    
                    }
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                }            
            }            
        }
        if (derivedType.getBasisType() instanceof DerivedDatatype) {
            transformCollectionInternalConstraints((DerivedDatatype) derivedType.getBasisType(), 
                op, decl, topcmpAccess);
        }
    }

    /**
     * Identifies the types contained in <code>variable</code>.
     * 
     * @param variable the variable to analyze for contained types
     * @param containedType an additional type that must be part of the result (ignored if <b>null</b>)
     * @return the contained types
     */
    private Set<IDatatype> identifyContainedTypes(IDecisionVariable variable, IDatatype containedType) {
        // this is still static typing based on the actual value, but if the value is changed, the constraints shall 
        // be re-collected anyway
        // unclear, shall this be recursive?
        Set<IDatatype> result = new HashSet<IDatatype>();
        if (null != containedType) {
            result.add(containedType);
        }
        if (null != variable.getValue()) {
            for (int n = 0; n < variable.getNestedElementsCount(); n++) {
                IDecisionVariable nested = variable.getNestedElement(n);
                if (null != nested) {
                    Value val = nested.getValue();
                    if (null != val) {
                        result.add(val.getType());
                    }
                }
            }
        } // fallback to default value if not given
        return result;
    }
    
    /**
     * Method for retrieving constraints from compounds initialized in collections.
     * @param decl AbstractVariable.
     * @param variable the instance of <tt>decl</tt>.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @return List of transformed constraints.
     */
    private List<Constraint> collectionCompoundConstraints(AbstractVariable decl, IDecisionVariable variable, 
        CompoundAccess topcmpAccess) {
        List<Constraint> constraints = new ArrayList<Constraint>();
        IDatatype type = decl.getType();
        if (net.ssehub.easy.varModel.model.datatypes.Container.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Container container 
                = (net.ssehub.easy.varModel.model.datatypes.Container) type;
            IDatatype containedType = container.getContainedType();
            Set<IDatatype> containedTypes = identifyContainedTypes(variable, containedType);
            for (IDatatype tmp : containedTypes) {
                if (TypeQueries.isCompound(tmp)) {
                    transformCollectionCompoundConstraints((Compound) tmp, containedType, decl, 
                        topcmpAccess, constraints);
                }
            }
        }
        return constraints;
    }
    
    /**
     * Method for transforming a compound constraint into collection forAll constraint.
     * @param cmpType Compound type with constraints.
     * @param containedType the declared contained type of the container.
     * @param decl {@link AbstractVariable}.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @param result List of transformed constraints, to be modified as a side effect.
     */
    private void transformCollectionCompoundConstraints(Compound cmpType, IDatatype containedType, 
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
        getAllCompoundConstraints(cmpType, thisCompoundConstraints, true);
        ConstraintSyntaxTree typeExpression = null;
        if (!TypeQueries.sameTypes(cmpType, containedType)) {
            try {
                typeExpression = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, cmpType));
            } catch (ValueDoesNotMatchTypeException e) {
                LOGGER.exception(e); // shall not occur, then next expression will not be correctly typed!
            }
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree itExpression = thisCompoundConstraints.get(i).getConsSyntax();
            itExpression = copyExpression(itExpression, localDecl);
            if (Descriptor.LOGGING) {
                LOGGER.debug("New loop constraint " + StringProvider.toIvmlString(itExpression));
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
     * Creates a container operation call ("shortcut").
     * 
     * @param container the container to operate on
     * @param op the operation
     * @param iterEx the iterator expression
     * @param decl the declarators
     * @return the created call
     */
    private ContainerOperationCall createContainerCall(ConstraintSyntaxTree container, Operation op, 
        ConstraintSyntaxTree iterEx, DecisionVariableDeclaration... decl) {
        return new ContainerOperationCall(container, op.getName(), iterEx, decl);
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
     * Part of the {@link #resolve()} method.
     * Processes all constraints.
     * 
     * @param dispatchScope the scope for dynamic dispatches
     */
    private void processConstraints(Project dispatchScope) { 
        List<Constraint> scopeConstraints = new ArrayList<Constraint>();
        if (!incremental && defaultConstraints.size() > 0) {
            defaultConstraints.addAll(deferredDefaultConstraints);
            addAllConstraints(scopeConstraints, transformConstraints(defaultConstraints, true));
        }
        if (internalConstraints.size() > 0) {
            addAllConstraints(scopeConstraints, transformConstraints(internalConstraints, false));
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
        if (constraintVariables.size() > 0) {
            scopeConstraints.addAll(constraintVariables);
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
            constraintBase.addAll(scopeConstraints);
            scopeConstraints.clear();
        }
        if (!incremental) {
            if (defaultAttributeConstraints.size() > 0) {
                constraintBase.addAll(defaultAttributeConstraints);
            }
            if (assignedAttributeConstraints.size() > 0) {
                constraintBase.addAll(assignedAttributeConstraints);
            }            
        }
        constraintCounter = constraintCounter + constraintBase.size();
        clearConstraintLists();
        resolveConstraints(constraintBase, dispatchScope);
    }
    

    /**
     * Method for processing scope attribute assignments.
     * @param hostAssignment Attribute assignments on top-level.
     * @param nestAssignment Attribute assignments with data.
     * @param compound Parent {@link CompoundAccess}.
     */
    private void processAttributeAssignments(AttributeAssignment hostAssignment, AttributeAssignment nestAssignment, 
        CompoundAccess compound) {
//        infoLogger.info("Attribute assignment: " + StringProvider.toIvmlString(hostAssignment));
        for (int i = 0; i < hostAssignment.getAssignmentDataCount(); i++) { 
            if (nestAssignment == null) {
                nestAssignment = hostAssignment;              
            } 
            for (int y = 0; y < nestAssignment.getElementCount(); y++) {
//                System.out.println("cmpAccess3: " + StringProvider.toIvmlString(compound));
                processElement(hostAssignment.getAssignmentData(i),
                    nestAssignment.getElement(y), compound);
                if (TypeQueries.isCompound(nestAssignment.getElement(y).getType())) {                    
                    Compound cmp = (Compound) nestAssignment.getElement(y).getType();
                    for (int j = 0; j < cmp.getDeclarationCount(); j++) {
//                        infoLogger.info("Nested: " + cmp.getDeclaration(j));
                        CompoundAccess cmpAccess;
                        if (compound == null) {
                            cmpAccess = new CompoundAccess(new Variable(nestAssignment.getElement(y)), 
                                cmp.getDeclaration(j).getName());                   
//                            System.out.println("cmpAccess1: " + StringProvider.toIvmlString(cmpAccess));
                        } else {
//                            infoLogger.info("Nested: " + cmp.getDeclaration(j));
                            cmpAccess = new CompoundAccess(compound, cmp.getDeclaration(j).getName());
//                            System.out.println("cmpAccess2: " + StringProvider.toIvmlString(cmpAccess));

                        }
                        inferTypeSafe(cmpAccess, null);
                        processElement(hostAssignment.getAssignmentData(i), cmp.getDeclaration(j), cmpAccess);
                    }
                    
                }
            }
            for (int z = 0; z < nestAssignment.getAssignmentCount(); z++) {
//                infoLogger.info("Nested attribute assignment: " 
//                        + StringProvider.toIvmlString(hostAssignment.getAssignment(i)));
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

    // TODO change constraints data structure - linked list, pointer, drop outdated constraints

    /**
     * Method for resolving constraints.
     * @param constraints List of constraints to be resolved.
     * @param dispatchScope the scope for dynamic dispatches
     */
    private void resolveConstraints(Deque<Constraint> constraints, Project dispatchScope) {
        if (Descriptor.LOGGING) {
            printConstraints(constraintBase);            
        }
        evaluator.init(config, null, false, listener); 
        evaluator.setResolutionListener(resolutionListener);
        evaluator.setDispatchScope(dispatchScope);
        evaluator.setScopeAssignmnets(scopeAssignments);
        while (!constraints.isEmpty()) { 
            problemVariables.clear();
            Constraint constraint = constraints.pop();
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            evaluator.setAssignmentState(constraint.isDefaultConstraint() 
                ? AssignmentState.DEFAULT : AssignmentState.DERIVED);
            reevaluationCounter++;
            if (cst != null) {
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Resolving: " + reevaluationCounter + ": " + StringProvider.toIvmlString(cst) 
                        + " : " + constraint.getTopLevelParent());                    
                }
                evaluator.visit(cst);
                if (evaluator.constraintFailed()) {
                    conflictingConstraint(constraint);
                } else if (evaluator.constraintFulfilled()) {
                    fulfilledConstraint(constraint);
                }
                for (int j = 0; j < evaluator.getMessageCount(); j++) {
                    if (evaluator.getMessage(j).getVariable() != null) {
                        if (!(evaluator.getMessage(j).getVariable().getParent() instanceof OperationDefinition)
                            && !(evaluator.getMessage(j).getVariable().getParent() instanceof Constraint)) {
                            problemVariables.clear();
                            problemVariables.add(evaluator.getMessage(j).getDecision());
                            FailedElementDetails failedelementDetails = new FailedElementDetails();
                            failedelementDetails.setProblemPoints(new HashSet<IDecisionVariable>(problemVariables));
                            // due to NULL result if failed assignment
                            failedelementDetails.setProblemConstraintPart(cst);
                            failedelementDetails.setProblemConstraint(constraint);
                            failedelementDetails.setErrorClassifier(ReasoningErrorCodes.FAILED_REASSIGNMENT);
                            failedElements.addProblemVariable(evaluator.getMessage(j).getVariable(), 
                                failedelementDetails);
                            if (Descriptor.LOGGING) {
                                LOGGER.debug("Assigment error: " + evaluator.getMessage(j).getVariable());
                                printProblemPoints();
                            }
                        }
                    } 
                }
                if (null != constraintVariableMap.get(constraint)) {
                    Value value = evaluator.getResult();
                    try {
                        IDecisionVariable variable = constraintVariableMap.get(constraint);
                        variable.setValue(value, AssignmentState.DEFAULT);
                    } catch (ConfigurationException e) {
                        LOGGER.exception(e);
                    }     
                }
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Result: " + evaluator.getResult());
                    LOGGER.debug("------");                     
                }
                evaluator.clearIntermediary();
            }
        }
        evaluator.clear();
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
     * Method for clearing all constraint lists.
     */
    private void clearConstraintLists() {
        defaultConstraints.clear();
        internalConstraints.clear();
        compoundConstraints.clear();
        compoundEvalConstraints.clear();
        constraintVariables.clear();        
        collectionCompoundConstraints.clear(); 
        collectionConstraints.clear();      
        defaultAttributeConstraints.clear();
        assignedAttributeConstraints.clear();
        unresolvedConstraints.clear();   
    }

    /**
     * Method for filling the map with constraints related to specific variable.
     * @param constraints Constraints to be checked for variables.
     */
    private void fillVariableConstraintPool(List<Constraint> constraints) {
        for (Constraint constraint : constraints) { 
            if (constraint.getConsSyntax() != null) {
//                if (!CSTUtils.isSimpleAssignment(constraint.getConsSyntax())) {
//                    VariablesInConstraintsFinder varFinder =
//                        new VariablesInConstraintsFinder(constraint.getConsSyntax());
//                    for (AbstractVariable declaration : varFinder.getVariables()) {
//                        constraintMap.add(declaration, constraint);                       
//                    }                    
//                }
                VariablesInConstraintsFinder varFinder = new VariablesInConstraintsFinder(constraint.getConsSyntax());
                if (!varFinder.isSimpleAssignment()) {
                    for (AbstractVariable declaration : varFinder.getVariables()) {
                        constraintMap.add(declaration, constraint);                       
                    }
                }                    
            }
        }
    }
    
    /**
     * Will be called after a failure was detected in a {@link Constraint}.
     * @param constraint The violated {@link Constraint}.
     */
    private void conflictingConstraint(Constraint constraint) {
        if (constraint != null) {
            FailedElementDetails failedElementDetails = new FailedElementDetails();
            failedElementDetails.setProblemPoints(new HashSet<IDecisionVariable>(problemVariables));
            failedElementDetails.setProblemConstraintPart(getFailedConstraintPart());
            failedElementDetails.setProblemConstraint(constraint);
            failedElementDetails.setErrorClassifier(ReasoningErrorCodes.FAILED_CONSTRAINT);
            failedElements.addProblemConstraint(constraint, failedElementDetails);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Failed constraint: " 
                    + StringProvider.toIvmlString(constraint.getConsSyntax()));
                printModelElements(config, "constraint resolved");
                printProblemPoints();
            }
        }
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
     * Will be called after a failure is not detected in a {@link Constraint}.
     * @param constraint The fulfilled {@link Constraint}.
     */
    private void fulfilledConstraint(Constraint constraint) {
        if (constraint != null) {
            failedElements.removeProblemConstraint(constraint);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Constraint fulfilled: " 
                    + StringProvider.toIvmlString(constraint.getConsSyntax()));                
            }
        }
    }
    
    /**
     * Method for creating a clean {@link Configuration}.
     * @param project Project for {@link Configuration}
     * @return Created {@link Configuration}
     */
    private Configuration createCleanConfiguration(Project project) {
        Configuration config = new Configuration(project, false);
        return config;
    }
    
    /**
     * Method for printing all variables, their states and values.
     * @param config Configuration to work with.
     * @param comment Comment for printing.
     */
    private void printModelElements(Configuration config, String comment) {
        LOGGER.debug("-------------------");
        LOGGER.debug(comment);
        for (IDecisionVariable variable : config) {
            printModelElement(variable); 
        }     
    }
    
    /**
     * Method for printing info about {@link IDecisionVariable}.
     * @param variable Variable to be printed out.
     */
    private void printModelElement(IDecisionVariable variable) {
        if (variable.getState() != null) {
            LOGGER.debug(variable.getDeclaration() 
                + " : "
                + variable.getState().toString()
                + " : " 
                + variable.getValue()
                + " | "
                + printAttributes(variable));
            if (variable.getNestedElementsCount() > 0) {
                for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                    printModelElement(variable.getNestedElement(i));
                }
            }            
        }
    }
    
    /**
     * Method for displaying all variable attributes.
     * @param variable variable
     * @return String of all attributes of the variable.
     */
    private String printAttributes(IDecisionVariable variable) {
        String attributes = "Attributes: ";
        for (int i = 0; i < variable.getAttributesCount(); i++) {
            attributes = attributes 
                    + variable.getAttribute(i).toString() + " : " 
                    + variable.getAttribute(i).getState() + " : " 
                    + variable.getAttribute(i).getValue() + "; "; 
        }
        return attributes;
    }
    
    /**
     * Method for printing constraints that are taken into account for reasoning.
     * @param constraints Constraints from the project. 
     */
    private void printConstraints(Collection<Constraint> constraints) {
        LOGGER.debug("-------------------");
        LOGGER.debug("--Constraints:");
        for (Constraint c : constraints) {
            LOGGER.debug(StringProvider.toIvmlString(c.getConsSyntax()) + " : " + c.getTopLevelParent().toString());
        }        
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
            cst = copyExpression(cst);
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
                    LOGGER.debug("Default constraint: " + StringProvider.toIvmlString(cst));                    
                }
            }            
        }
        return constraints;
    }

    /**
     * Method for using {@link CopyVisitor} for constraint transformation using {@link #varMap} 
     * to replace variables. No replacement of <i>self</i> is done.
     * 
     * @param cst Constraint to be transformed.
     * @return Transformed constraint.
     */
    private ConstraintSyntaxTree copyExpression(ConstraintSyntaxTree cst) {
        return copyExpression(cst, (ConstraintSyntaxTree) null, varMap);
    }

    /**
     * Method for using {@link CopyVisitor} for constraint transformation using {@link #varMap} 
     * to replace variables. Allows replacing <i>self</i>.
     * 
     * @param cst Constraint to be transformed.
     * @param selfVar a variable representing <i>self</i> (ignored if <b>null</b>).
     * @return Transformed constraint.
     */
    private ConstraintSyntaxTree copyExpression(ConstraintSyntaxTree cst, AbstractVariable selfVar) {
        return copyExpression(cst, new Variable(selfVar), varMap);
    }
    
    /**
     * Method for using {@link CopyVisitor} for constraint transformation.
     * 
     * @param cst Constraint to be transformed.
     * @param selfEx an expression representing <i>self</i> (ignored if <b>null</b>).
     * @param mappingCA a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @return Transformed constraint.
     */
    private ConstraintSyntaxTree copyExpression(ConstraintSyntaxTree cst, ConstraintSyntaxTree selfEx, 
        Map<AbstractVariable, CompoundAccess> mappingCA) {
        CopyVisitor visitor = new CopyVisitor(null, mappingCA);
        if (selfEx != null) {
            visitor.setSelf(selfEx);            
        }
        cst.accept(visitor);
        cst = visitor.getResult();
        inferTypeSafe(cst, null);
        return cst;
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
     * Method for displaying failed constraints and assignments.
     */
    private void displayFailedElements() {
        if (failedElements.hasProblems()) {
            if (failedElements.problemConstraintCount() > 0) {
                Iterator<Constraint> failedConstraints = failedElements.getProblemConstraints();
                while (failedConstraints.hasNext()) {
                    Constraint failedRule = failedConstraints.next();
                    LOGGER.debug("Failed constraint: " + StringProvider.toIvmlString(failedRule.getConsSyntax()));
                }
            }
            if (failedElements.problemVariabletCount() > 0) {
                Iterator<AbstractVariable> failedVariables = failedElements.getProblemVariables();
                while (failedVariables.hasNext()) {
                    AbstractVariable failedVariable = failedVariables.next();
                    LOGGER.debug("Failed variable: " + failedVariable.toString());
                } 
            }           
        } 
    }
    
    /**
     * Getter for the map of all ConstraintVariables.
     * and their {@link Constraint}s.
     * @return Map of constraint variables and their constraints.
     */
    public Map<Constraint, IDecisionVariable> getConstraintVariableMap() {
        return constraintVariableMap;
    }
    
    /**
     * Method for printing all problem points.
     */
    private void printProblemPoints() {
        if (problemVariables.size() > 0) {
            LOGGER.info("Problem points: ");
            for (IDecisionVariable problem : problemVariables) {
                LOGGER.info(problem + "; ");
            }                 
        }
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

}
