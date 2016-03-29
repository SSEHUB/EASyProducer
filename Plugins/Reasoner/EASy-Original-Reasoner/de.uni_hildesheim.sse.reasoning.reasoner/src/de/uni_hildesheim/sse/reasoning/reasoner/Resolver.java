package de.uni_hildesheim.sse.reasoning.reasoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.reasoning.core.model.PerformanceStatistics;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration.IAdditionalInformationLogger;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElementDetails;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElements;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.ScopeAssignments;
import de.uni_hildesheim.sse.reasoning.reasoner.model.AssignmentConstraintFinder;
import de.uni_hildesheim.sse.reasoning.reasoner.model.CollectionConstraintsFinder;
import de.uni_hildesheim.sse.reasoning.reasoner.model.CopyVisitor;
import de.uni_hildesheim.sse.reasoning.reasoner.model.VariablesInConstraintsFinder;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.Utils;
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
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.InternalConstraint;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.filter.ConstraintFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.VariablesInConstraintFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Class for performing reasoning with AssignmnetResolver.
 * @author Sizonenko
 * @author El-Sharkawy
 *
 */
public class Resolver {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(Resolver.class, Descriptor.BUNDLE_NAME);
    private IAdditionalInformationLogger infoLogger;
    
    private String reasoningID; 
    
    private Project project;
    private Configuration config;
    private EvalVisitor evaluator;   
    private FailedElements failedElements;
    private ScopeAssignments scopeAssignments;   

    private VariablesMap constraintMap;
    private Map<Constraint, IDecisionVariable> constraintVariableMap;
    private List<Constraint> constraintBase;   
    private List<Constraint> constraintVariables;
    private List<Constraint> compoundConstraints;
    private List<Constraint> unresolvedConstraints; 
    private List<Constraint> defaultAttributeConstraints;
    private List<Constraint> assignedAttributeConstraints;
    private List<Constraint> collectionConstraints;
    private List<Constraint> defaultConstraints;
    private List<Constraint> internalConstraints;
    private boolean considerFrozenConstraints;
    
    private int constraintBaseSize = 0;
    
    private Map<AbstractVariable, CompoundAccess> varMap;
    
    private List<Constraint> collectionCompoundConstraints;
    private Set<IDecisionVariable> problemVariables;
    
    private int index;
    
    // Stats
    private int constraintCounter = 0;
    private int variablesInConstraintsCounter = 0;    
    private int reevaluationCounter = 0;
    private int variablesCounter = 0;
    
    private boolean incremental;
    
    private IValueChangeListener listener = new IValueChangeListener() {
        
        @Override
        public void notifyUnresolved(IDecisionVariable variable) {
            // TODO Auto-generated method stub                   
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
                    for (int i = index + 1, end = constraintBase.size(); i < end && !found; i++) {
                        found = (constraintBase.get(i) == varConstraint);
                    }
                    if (!found) {
                        constraintBase.add(varConstraint);
                        constraintBaseSize++;
                    }
                }
//                if (varConstraints != null && !varConstraints.isEmpty()) {
//                    for (Constraint varConstraint : varConstraints) {
//                        
//                        boolean found = false;
//                        for (int i = index + 1, end = constraintBase.size(); i < end && !found; i++) {
//                            found = (constraintBase.get(i) == varConstraint);
//                        }
//                        if (!found) { 
//                            constraintBase.add(varConstraint);
//                            constraintBaseSize++;
//    //                        if (declaration.getType() instanceof Container) {
//    //                            // find anonymous inner declarations (e.g., compound declared inside a set)
//    //                            for (int j = 0, nestedEnd = variable.getNestedElementsCount(); j < nestedEnd; j++) {
//    //                                // check whether we need to add further constraints for the nested element
//    //                                this.notifyChanged(variable.getNestedElement(j));
//    //                            }
//    //                        }
//                        }
//                        if (Descriptor.LOGGING) {
//                            LOGGER.debug("Constraints added to current list: " 
//                                + StringProvider.toIvmlString(varConstraint.getConsSyntax())); 
//                        }
//                    }
//                }
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
//            if (varConstraints != null && !varConstraints.isEmpty()) {
//                for (Constraint varConstraint : varConstraints) {
//                    
//                    boolean found = false;
//                    for (int i = index + 1, end = constraintBase.size(); i < end && !found; i++) {
//                        found = (constraintBase.get(i) == varConstraint);
//                    }
//                    if (!found) { 
//                        constraintBase.add(varConstraint);
//                        constraintBaseSize++;
//                    }
//                    if (Descriptor.LOGGING) {
//                        LOGGER.debug("Constraints added to current list: " 
//                            + StringProvider.toIvmlString(varConstraint.getConsSyntax())); 
//                    }
//                }
//            }
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
//            if (varConstraints != null && !varConstraints.isEmpty()) {
//                for (Constraint varConstraint : varConstraints) {
//                    
//                    boolean found = false;
//                    for (int i = index + 1, end = constraintBase.size(); i < end && !found; i++) {
//                        found = (constraintBase.get(i) == varConstraint);
//                    }
//                    if (!found) { 
//                        constraintBase.add(varConstraint);
//                        constraintBaseSize++;
//                    }
//                    if (Descriptor.LOGGING) {
//                        LOGGER.debug("Constraints added to current list: " 
//                            + StringProvider.toIvmlString(varConstraint.getConsSyntax())); 
//                    }
//                }
//            }
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
        evaluator = new EvalVisitor();
        constraintMap = new VariablesMap();
        this.reasoningID = PerformanceStatistics.createReasoningID(project.getName(), "Model validation");
        this.failedElements = new FailedElements();
        this.scopeAssignments = new ScopeAssignments();
        this.constraintVariableMap = new HashMap<Constraint, IDecisionVariable>();
        this.constraintBase = new ArrayList<Constraint>();
        this.constraintVariables = new ArrayList<Constraint>();
        this.compoundConstraints = new ArrayList<Constraint>();
        this.defaultAttributeConstraints = new ArrayList<Constraint>();
        this.assignedAttributeConstraints = new ArrayList<Constraint>();
        this.collectionConstraints = new ArrayList<Constraint>();
        this.unresolvedConstraints = new ArrayList<Constraint>();
        this.collectionCompoundConstraints = new ArrayList<Constraint>();
        this.defaultConstraints = new ArrayList<Constraint>();
        this.incremental = false;
        this.problemVariables = new HashSet<IDecisionVariable>();
        this.internalConstraints = new ArrayList<Constraint>();
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
        if (Descriptor.LOGGING) {
            printModelElements(config, "Before reasoning");            
        }        
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
//            if (ENABLE_LOGGING) {
//                printModelElements(config, "After defaults in scope " + project.getName());                
//            }
            processConstraints(project);
            // Freezes values after each scope
            config.freezeValues(project, FilterType.NO_IMPORTS);
            // TODO do incremental freezing in here -> required by interfaces with propagation constraints
            if (Descriptor.LOGGING) {
                printModelElements(config, "After reasoning in scope " + project.getName());
                displayFailedElements();                                
            }
        }
        variablesInConstraintsCounter = constraintMap.getDeclarationSize();
        if (Descriptor.LOGGING) {
            printModelElements(config, "Reasoning done");
        }
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
            resolveDefaultValueForDeclaration(decl, config.getDecision(decl), null);
        }
    }    
    
    /**
     * Part of the {@link #resolveDefaultValues(Project)} method.
     * Resolves default values of a particular declaration.
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of <tt>decl</tt>.
     * @param compound if variable is a nested compound.
     */
    protected void resolveDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable,
        CompoundAccess compound) {
        variablesCounter++;
        IDatatype type = decl.getType();
        // Internal constraints
        if (type instanceof DerivedDatatype) {
            DerivedDatatype dType = (DerivedDatatype) type;
            analyseDerivedDatatype(decl, dType); 
        }
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        // Attribute handling
        if (variable.getAttributesCount() > 0) {
            resolveAttributeAssignments(decl, variable, compound);
        }        
        if (Compound.TYPE.isAssignableFrom(type)) {
            resolveCompoundDefaultValueForDeclaration(decl, variable, compound, type); 
            if (null != defaultValue) {
                defaultValue = copyVisitor(defaultValue, decl);
            }
        }  
        collectionCompoundConstraints.addAll(collectionCompoundConstraints(decl, null));
        // Container
        if (net.ssehub.easy.varModel.model.datatypes.Container.TYPE.isAssignableFrom(type)) {            
            collectionInternalConstraints(decl, null);
        }
        if (null != defaultValue) {
            if (ConstraintType.TYPE.isAssignableFrom(type) 
                && !(type.getType() == BooleanType.TYPE.getType())) {
//                && !(defaultValue instanceof ConstantValue)) {
                if (compound == null) {
                    try {
                        // use closest parent instead of project -> runtime analysis
                        Constraint constraint = new Constraint(defaultValue, variable.getDeclaration());
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, variable);
                        if (Descriptor.LOGGING) {
                            LOGGER.debug(variable.getDeclaration().getName() + " project constraint variable " 
                                + StringProvider.toIvmlString(defaultValue));
                        }
                    } catch (CSTSemanticException e) {
                        LOGGER.exception(e);
                    }
                } 
            } else {
                // Create default constraint
                ConstraintSyntaxTree cst = new OCLFeatureCall(new Variable(decl), OclKeyWords.ASSIGNMENT,
                    defaultValue);                
                try {
                    Constraint constraint = new Constraint(project);
                    constraint.makeDefaultConstraint();
                    cst.inferDatatype(); 
                    constraint.setConsSyntax(cst);
                    defaultConstraints.add(constraint);
                } catch (CSTSemanticException e) {
                    LOGGER.exception(e);
                }            
            }                
        }
    }

    /**
     * MEthod for analyzing {@link DerivedDatatype}s and extracting internal constraints.
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
                cst = copyVisitor(cst, null);
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
     * Method for resolving compound default value declarion.
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
            IDatatype nestedType = nestedDecl.getType();
            cmpAccess = null;
            if (compound == null) {
                cmpAccess = new CompoundAccess(new Variable(decl), nestedDecl.getName());                   
            } else {
                cmpAccess = new CompoundAccess(compound, nestedDecl.getName());
            }
            try {
                cmpAccess.inferDatatype();
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
            compoundConstraints.addAll(collectionCompoundConstraints(nestedDecl, cmpAccess));
            varMap.put(nestedDecl, cmpAccess); // TODO turn into local map!
            if (ConstraintType.TYPE.isAssignableFrom(nestedType) 
                && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                createConstraint(nestedDecl.getDefaultValue(), decl, nestedDecl, nestedVariable, variable);
            }
            resolveDefaultValueForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()),
                cmpAccess);
        }
        // required strategy: resolve compound accesses first in loop before, then constraints using them
        // TODO check whether createConstraint shall move into next loop
        for (int i = 0, n = cmpVar.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVariable = cmpVar.getNestedElement(i);
            AbstractVariable nestedDecl = nestedVariable.getDeclaration();
            IDatatype nestedType = nestedDecl.getType();
            if (Container.isContainer(nestedType, ConstraintType.TYPE)  // THIS IS JUST PRELIMINARY - QM
                && nestedVariable.getValue() instanceof ContainerValue) {
                checkContainerValue((ContainerValue) nestedVariable.getValue(), decl, nestedDecl, 
                    nestedVariable, variable);
            }
        }
        // Nested attribute assignments handling
        for (int x = 0; x < cmpType.getAssignmentCount(); x++) {
            processAttributeAssignments(cmpType.getAssignment(x), null,  cmpAccess);
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree oneConstraint = thisCompoundConstraints.get(i).getConsSyntax();
            // changed null to decl
            oneConstraint = copyVisitor(oneConstraint, decl);
            try {
                Constraint constraint = new Constraint(oneConstraint, decl);
                compoundConstraints.add(constraint);            
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
//        if (cst != null && !(cst instanceof ConstantValue)) {
        if (cst != null) {
            cst = copyVisitor(cst, decl);
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
        if (cmpType.getRefines() != null) {
            Compound refinedType = cmpType.getRefines();
            getAllCompoundConstraints(refinedType, thisCompoundConstraints, false);
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
                    net.ssehub.easy.varModel.model.datatypes.Set.FORALL, decl, topcmpAccess);
            }
        }
        if (net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Sequence sequence 
                = (net.ssehub.easy.varModel.model.datatypes.Sequence) type;
            if (sequence.getContainedType() instanceof DerivedDatatype) {
                transformCollectionInternalConstraints((DerivedDatatype) sequence.getContainedType(),
                    Sequence.FORALL, decl, topcmpAccess);
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
     * Method for retrieving constraints from compounds initialized in collections.
     * @param decl AbstractVariable.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @return List of transformed constraints.
     */
    private List<Constraint> collectionCompoundConstraints(AbstractVariable decl, CompoundAccess topcmpAccess) {
        List<Constraint> constraints = new ArrayList<Constraint>();
        IDatatype type = decl.getType();
        if (net.ssehub.easy.varModel.model.datatypes.Set.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Set set 
                = (net.ssehub.easy.varModel.model.datatypes.Set) type;
            if (Compound.TYPE.isAssignableFrom(set.getContainedType())) {
                constraints = transformCompoundConstraints((Compound) set.getContainedType(),
                    net.ssehub.easy.varModel.model.datatypes.Set.FORALL, decl, topcmpAccess);
            }
        }
        if (net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE.isAssignableFrom(type)) {
            net.ssehub.easy.varModel.model.datatypes.Sequence sequence 
                = (net.ssehub.easy.varModel.model.datatypes.Sequence) type;
            if (Compound.TYPE.isAssignableFrom(sequence.getContainedType())) {
                constraints = transformCompoundConstraints((Compound) sequence.getContainedType(),
                    Sequence.FORALL, decl, topcmpAccess);
            }
        }
        return constraints;
    }
    
    /**
     * Method for transforming a compound constraint into collection forAll constraint.
     * @param cmpType Compound type with constraints.
     * @param op Operation to be performed.
     * @param decl {@link AbstractVariable}.
     * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
     * @return List of transformed constraints.
     */
    private List<Constraint> transformCompoundConstraints(Compound cmpType, Operation op, AbstractVariable decl, 
        CompoundAccess topcmpAccess) {        
        List<Constraint> constraints = new ArrayList<Constraint>();
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("cmp", cmpType, null);        
        for (int i = 0, n = cmpType.getInheritedElementCount(); i < n; i++) {
            AbstractVariable nestedDecl = cmpType.getInheritedElement(i);
            CompoundAccess cmpAccess = null;           
            cmpAccess = new CompoundAccess(new Variable(localDecl), nestedDecl.getName());
            varMap.put(nestedDecl, cmpAccess);            
        }
        
        List<Constraint> thisCompoundConstraints = new ArrayList<Constraint>(); 
        getAllCompoundConstraints(cmpType, thisCompoundConstraints, true);
        
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree itExpression = thisCompoundConstraints.get(i).getConsSyntax();
            itExpression = copyVisitor(itExpression, null);
            if (Descriptor.LOGGING) {
                LOGGER.debug("New loop constraint " + StringProvider.toIvmlString(itExpression));
            }           
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
                    constraints.add(constraint);                    
                }
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }            
        }
        return constraints;        
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
        if (!incremental) {
            if (defaultConstraints.size() > 0) {
                defaultConstraints = transformConstraints(defaultConstraints, true);
                addAllConstraints(scopeConstraints, defaultConstraints);
            }            
        }
        if (internalConstraints.size() > 0) {
            internalConstraints = transformConstraints(internalConstraints, false);
            addAllConstraints(scopeConstraints, internalConstraints);
        }
        ConstraintFinder finder = new ConstraintFinder(project, false, false, true);
        addAllConstraints(scopeConstraints, finder.getEvalConstraints());
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
        constraintBaseSize = constraintBase.size();
        resolveConstraints(constraintBase, dispatchScope);
        constraintBase.clear(); 
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
                if (Compound.TYPE.isAssignableFrom(nestAssignment.getElement(y).getType())) {                    
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
                        try {
                            cmpAccess.inferDatatype();
                        } catch (CSTSemanticException e) {
                            LOGGER.exception(e);
                        }
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
    //        infoLogger.info("Element: " 
    //              + StringProvider.toIvmlString(element));
    //        infoLogger.info("Attribute: " + StringProvider.toIvmlString(element.getAttribute(attributeName)));
            ConstraintSyntaxTree cst = null;
            //fix for annotations in compounds
            compound = null;
            compound = varMap.get(element);
            if (compound == null) {                      
                cst = new OCLFeatureCall(
                    new AttributeVariable(new Variable(element), attrib),
                        OclKeyWords.ASSIGNMENT, assignment.getExpression());
            } else {
    //            infoLogger.info("Compound: " + StringProvider.toIvmlString(compound));
                cst = new OCLFeatureCall(new AttributeVariable(compound, attrib),
                    OclKeyWords.ASSIGNMENT, assignment.getExpression());
            }
            try {
                cst.inferDatatype();
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
            Constraint constraint = new Constraint(project);
            try {
                constraint.setConsSyntax(cst);
                assignedAttributeConstraints.add(constraint);
    //            infoLogger.info("Attribute constraint: " + StringProvider.toIvmlString(cst));
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
        }
    }

   
    /**
     * Method for resolving constraints.
     * @param constraints List of constraints to be resolved.
     * @param dispatchScope the scope for dynamic dispatches
     */
    private void resolveConstraints(List<Constraint> constraints, Project dispatchScope) {
//        PerformanceStatistics.addTimestamp(reasoningID);
        if (Descriptor.LOGGING) {
            printConstraints(constraintBase);            
        }
        for (int i = 0; i < constraints.size(); i++) {
            index = i;
            problemVariables.clear();
            AssignmentState state = null;
            if (constraints.get(i).isDefaultConstraint()) {
                state = AssignmentState.DEFAULT;
            } else {
                state = AssignmentState.DERIVED;
            }
            Constraint constraint = constraints.get(i);
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            reevaluationCounter++;
            if (cst != null) {
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Resolving: " + reevaluationCounter + ": " + StringProvider.toIvmlString(cst) 
                        + " : " + constraint.getTopLevelParent());                    
                }
                // TODO check whether these four statements can be moved up / clearResult is sufficient instead of clear
                evaluator.init(config, state, false, listener); 
                evaluator.setResolutionListener(resolutionListener);
                evaluator.setScopeAssignmnets(scopeAssignments);
                evaluator.setDispatchScope(dispatchScope);
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
                evaluator.clear();
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
     * Method for clearing all constraint lists.
     */
    private void clearConstraintLists() {
        defaultConstraints.clear();
        internalConstraints.clear();
        compoundConstraints.clear();
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
    private void conflictingDefault(AbstractVariable decl) {
        // TODO
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
    private void printConstraints(List<Constraint> constraints) {
        LOGGER.debug("-------------------");
        LOGGER.debug("--Constraints:");
        for (int i = 0; i < constraints.size(); i++) {
            LOGGER.debug(StringProvider.toIvmlString(constraints.get(i).getConsSyntax())
                + " : " + constraints.get(i).getTopLevelParent().toString());
        }        
    }
    
    /**
     * Method for transforming constraints with CopyVisitor.
     * @param constraints Constraints to be transformed.
     * @param makeDefaultConstraint True if constraints should be deault.
     * @return List of transformed constraints.
     */
    private List<Constraint> transformConstraints(List<Constraint> constraints, boolean makeDefaultConstraint) {
        for (int i = 0; i < constraints.size(); i++) {
            ConstraintSyntaxTree cst = constraints.get(i).getConsSyntax();
            cst = copyVisitor(cst, null);
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
     * Method for using CopyVisitor for constraint transformation.
     * @param cst Constraint to be transformed.
     * @param decl If Self needs to be set.
     * @return Transformed constraint.
     */
    private ConstraintSyntaxTree copyVisitor(ConstraintSyntaxTree cst, AbstractVariable decl) {
        CopyVisitor visitor = new CopyVisitor(null, varMap);
        if (decl != null) {
            visitor.setSelf(decl);            
        }
        cst.accept(visitor);
        cst = visitor.getResult();
        try {
            cst.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e);
        }
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
     * Getter for the map of all {@link de.uni_hildesheim.sse.reasoning.core.model.variables.ConstraintVariable}
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
