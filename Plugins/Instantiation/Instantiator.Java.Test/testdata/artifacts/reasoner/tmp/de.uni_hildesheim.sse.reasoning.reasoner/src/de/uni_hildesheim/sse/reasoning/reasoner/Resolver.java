package de.uni_hildesheim.sse.reasoning.reasoner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.CompoundVariable;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstraintReplacer;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.cstEvaluation.IResolutionListener;
import de.uni_hildesheim.sse.model.cstEvaluation.IValueChangeListener;
import de.uni_hildesheim.sse.model.cstEvaluation.LocalDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.InternalConstraint;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.VariablesInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.persistency.StringProvider;
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
import de.uni_hildesheim.sse.utils.modelManagement.Utils;
/** 
 * Class for performing reasoning with AssignmnetResolver.
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class Resolver {
    private IAdditionalInformationLogger infoLogger;
    private String reasoningID;
    private Project project;
    private Configuration config;
    private EvalVisitor evaluator;
    private FailedElements failedElements;
    private ScopeAssignments scopeAssignments;
    private List<IDecisionVariable> allVariables;
    private Map<AbstractVariable, Set<Constraint>> constraintMap;
    private Map<Compound, List<Constraint>> compoundConstraintsMap;
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
    private Set<Constraint> lastAdded = null;
    private int constraintBaseIndex = 0;
    private Map<AbstractVariable, CompoundAccess> varMap;
    private List<Constraint> collectionCompoundConstraints;
    private Set<IDecisionVariable> problemVariables;
    private int constraintCounter = 0;
    private int variableCounter = 0;
    private int reevaluationCounter = 0;
    private boolean incremental;
    private IValueChangeListener listener = new IValueChangeListener() {
        @Override
        public void notifyUnresolved(IDecisionVariable variable) {
        }
        @Override
        public void notifyChanged(IDecisionVariable variable) {
            if (Descriptor.LOGGING) {
            }
            scopeAssignments.addAssignedVariable(variable);
            Set<Constraint> varConstraints = constraintMap.get(variable.getDeclaration());
            if (varConstraints != null) {
                if (!varConstraints.isEmpty() && lastAdded != varConstraints) {
                    for (Constraint varConstraint : varConstraints) {
                        constraintBase.add(varConstraint);
                        constraintBaseSize++;
                        if (Descriptor.LOGGING) {
                        }
                    }
                    lastAdded = varConstraints;
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
    * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, may be <b>null</b>)
    * @param considerFrozenConstraints Specification whether constraints containing only frozen variablesshall be considered during reasoning (<tt>true</tt>: Shall be considered).
    */
    public Resolver(Project project, Configuration config, boolean considerFrozenConstraints,
            ReasonerConfiguration reasonerConfig) {
        this.infoLogger = reasonerConfig.getLogger();
        this.config = config;
        evaluator = new EvalVisitor();
        this.allVariables = new ArrayList<IDecisionVariable>();
        this.reasoningID = PerformanceStatistics.createReasoningID(project.getName(), "Model validation");
        this.failedElements = new FailedElements();
        this.scopeAssignments = new ScopeAssignments();
        this.constraintMap = new HashMap<AbstractVariable, Set<Constraint>>();
        this.compoundConstraintsMap = new HashMap<Compound, List<Constraint>>();
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
    * Main constructor that activates Resolver constructor with clean   {@link Configuration}.
    * @param project Project for evaluation.
    * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, may be <b>null</b>)
    */
    public Resolver(Project project, ReasonerConfiguration reasonerConfig) {
        new Resolver(project, createCleanConfiguration(project), true, reasonerConfig);
    }
    /** 
    * Main constructor that activates Resolver constructor.
    * @param config Configuration to reason on.
    * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, may be <b>null</b>)
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
    * @return the evaluation visitor
    */
    protected EvaluationVisitor createEvaluationVisitor() {
        return new EvalVisitor();
    }
    /** 
    * Resolves the (initial) values of the configuration. This is done as follows: <ol> <li>Resolve default values of variable declarations</li> <li>Resolve values of assignments</li> </ol>
    */
    public void resolve() {
        if (Descriptor.LOGGING) {
            printModelElements(config, "Before reasoning");
        }
        List<Project> projects = Utils.discoverImports(config.getProject());
        while (!projects.isEmpty()) {
            project = projects.remove(0);
            if (Descriptor.LOGGING) {
            }
            evaluator.setDispatchScope(project);
            scopeAssignments.clearScopeAssignments();
            resolveDefaultValues();
            fillConstraintMapKeys();
            processConstraints();
            config.freezeValues(project, FilterType.NO_IMPORTS);
            if (Descriptor.LOGGING) {
                printModelElements(config, "After reasoning in scope " + project.getName());
                displayFailedElements();
            }
        }
        variableCounter = constraintMap.size();
        if (Descriptor.LOGGING) {
            printModelElements(config, "Reasoning done");
        }
    }
    /** 
    * Part of the   {@link #resolve()} method.Resolves default values of variable declarations.
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
    * Part of the   {@link #resolveDefaultValues(Project)} method.Resolves default values of a particular declaration.
    * @param decl The {@link AbstractVariable} for which the default value should be resolved.
    * @param variable the instance of <tt>decl</tt>.
    * @param compound if variable is a nested compound.
    */
    protected void resolveDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable,
            CompoundAccess compound) {
        allVariables.add(variable);
        IDatatype type = decl.getType();
        if (type instanceof DerivedDatatype) {
            InternalConstraint[] typeConstraints = createInternalConstraints(decl, type);
            if (typeConstraints != null) {
                for (InternalConstraint internalConstraint : typeConstraints) {
                    internalConstraints.add(internalConstraint);
                }
            }
        }
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
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
        if (null != defaultValue) {
            if (ConstraintType.TYPE.isAssignableFrom(type) && !(type.getType() == BooleanType.TYPE.getType())) {
                if (compound == null) {
                    try {
                        Constraint constraint = new Constraint(defaultValue, project);
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, variable);
                        if (Descriptor.LOGGING) {
                        }
                    } catch (CSTSemanticException e) {
                    }
                }
            } else {
                ConstraintSyntaxTree cst = new OCLFeatureCall(new Variable(decl), OclKeyWords.ASSIGNMENT, defaultValue);
                try {
                    Constraint constraint = new Constraint(project);
                    constraint.makeDefaultConstraint();
                    cst.inferDatatype();
                    constraint.setConsSyntax(cst);
                    defaultConstraints.add(constraint);
                } catch (CSTSemanticException e) {
                }
            }
        }
    }
    /** 
    * Creates constraints related to variable declaration. This method is needed for <code>DerivedDatatypes</code>. 
    * @param declaration VariableDeclaration of <code>DerivedDatatype</code>
    * @param type type of <code>DerivedDatatype</code>
    * @return <code>null</code> if this datatype is not <code>DerivedDatatype</code> or if this <code>DerivedDatatype</code> has no constraints, otherwise the adapted constraints of the  <code>DerivedDatatype</code> for this VariableDeclaration
    */
    private InternalConstraint[] createInternalConstraints(AbstractVariable declaration, IDatatype type) {
        InternalConstraint[] constraintInstances = null;
        DerivedDatatype dType = (DerivedDatatype) type;
        if (dType.getConstraintCount() > 0 && dType.getTypeDeclaration() != declaration) {
            constraintInstances = new InternalConstraint[dType.getConstraintCount()];
            for (int i = 0; i < dType.getConstraintCount(); i++) {
                ConstraintSyntaxTree oneConstraint = dType.getConstraint(i).getConsSyntax();
                ConstraintReplacer replacer = new ConstraintReplacer(oneConstraint);
                Variable origin = new Variable(dType.getTypeDeclaration());
                Variable replacement = new Variable(declaration);
                ConstraintSyntaxTree copiedCST = replacer.replaceVariable(origin, replacement);
                try {
                    constraintInstances[i] = new InternalConstraint(dType, copiedCST, declaration.getTopLevelParent());
                } catch (CSTSemanticException e) {
                }
            }
        }
        return constraintInstances;
    }
    /** 
    * Method for checking if   {@link CompoundInitializer} holds a  {@link de.uni_hildesheim.sse.ivml.CollectionInitializer} with {@link Constraint}s.
    * @param exp expression to check.
    * @param compound false if variable is not nested.
    */
    private void checkCompoundInitializer(ConstraintSyntaxTree exp, Boolean compound) {
        CompoundInitializer compoundInit = (CompoundInitializer) exp;
        for (int i = 0; i < compoundInit.getExpressionCount(); i++) {
            if (compoundInit.getExpression(i) instanceof ContainerInitializer) {
                checkContainerInitializer(compoundInit.getExpression(i), compound);
            }
            if (compoundInit.getExpression(i) instanceof CompoundInitializer) {
                checkCompoundInitializer(compoundInit.getExpression(i), compound);
            }
        }
    }
    /** 
    * Method for checking if an expression is a   {@link ContainerInitializer}.
    * @param exp expression to be checked.
    * @param compound false if variable is not nested.
    */
    private void checkContainerInitializer(ConstraintSyntaxTree exp, Boolean compound) {
        ContainerInitializer containerInit = (ContainerInitializer) exp;
        if (ConstraintType.TYPE.isAssignableFrom(containerInit.getType().getContainedType())) {
            extractCollectionConstraints(containerInit, compound);
        }
    }
    /** 
    * Method for extracting collection constraints.
    * @param containerInit Container with constraints.
    * @param compound false if variable is not nested.
    */
    private void extractCollectionConstraints(ContainerInitializer containerInit, Boolean compound) {
        for (int i = 0; i < containerInit.getExpressionCount(); i++) {
            Constraint constraint = new Constraint(project);
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            if (compound) {
                cst = copyVisitor(cst, null);
            }
            try {
                constraint.setConsSyntax(cst);
                collectionConstraints.add(constraint);
            } catch (CSTSemanticException e) {
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
                    if (compound == null) {
                        defaultValue = new OCLFeatureCall(
                                new AttributeVariable(new Variable(decl),
                                        (Attribute) variable.getAttribute(i).getDeclaration()),
                                OclKeyWords.ASSIGNMENT, defaultValue);
                    } else {
                        defaultValue = new OCLFeatureCall(
                                new AttributeVariable(compound, (Attribute) variable.getAttribute(i).getDeclaration()),
                                OclKeyWords.ASSIGNMENT, defaultValue);
                    }
                    defaultValue.inferDatatype();
                    constraint.setConsSyntax(defaultValue);
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
            }
            compoundConstraints.addAll(collectionCompoundConstraints(nestedDecl, cmpAccess));
            varMap.put(nestedDecl, cmpAccess);
            if (ConstraintType.TYPE.isAssignableFrom(nestedType)
                    && !(nestedType.getType() == BooleanType.TYPE.getType())) {
                ConstraintSyntaxTree defaultValue = nestedDecl.getDefaultValue();
                if (defaultValue != null) {
                    defaultValue = copyVisitor(defaultValue, decl);
                    try {
                        Constraint constraint = new Constraint(defaultValue, project);
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, nestedVariable);
                        if (Descriptor.LOGGING) {
                        }
                    } catch (CSTSemanticException e) {
                    }
                }
            }
            resolveDefaultValueForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()), cmpAccess);
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree oneConstraint = thisCompoundConstraints.get(i).getConsSyntax();
            oneConstraint = copyVisitor(oneConstraint, null);
            try {
                Constraint constraint = new Constraint(oneConstraint, project);
                compoundConstraints.add(constraint);
            } catch (CSTSemanticException e) {
            }
        }
        for (int i = 0; i < cmpType.getAssignmentCount(); i++) {
            processAttributeAssignments(cmpType.getAssignment(i), null, cmpAccess);
        }
    }
    /** 
    * Method for getting all constraints relevant to a   {@link Compound}.
    * @param cmpType Compound to be analyzed.
    * @param thisCompoundConstraints The list to add the compound {@link Constraint}s to.
    * @param host True if this is a host compound.
    */
    private void getAllCompoundConstraints(Compound cmpType, List<Constraint> thisCompoundConstraints, boolean host) {
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
    * Method for retrieving constraints from compounds initialized in collections.
    * @param decl AbstractVariable.
    * @param topcmpAccess {@link CompoundAccess} if Collection is a nested element.
    * @return List of transformed constraints.
    */
    private List<Constraint> collectionCompoundConstraints(AbstractVariable decl, CompoundAccess topcmpAccess) {
        List<Constraint> constraints = new ArrayList<Constraint>();
        IDatatype type = decl.getType();
        if (de.uni_hildesheim.sse.model.varModel.datatypes.Set.TYPE.isAssignableFrom(type)) {
            de.uni_hildesheim.sse.model.varModel.datatypes.Set set = (de.uni_hildesheim.sse.model.varModel.datatypes.Set) type;
            if (Compound.TYPE.isAssignableFrom(set.getContainedType())) {
                constraints = transformCompoundConstraints((Compound) set.getContainedType(),
                        de.uni_hildesheim.sse.model.varModel.datatypes.Set.FORALL, decl, topcmpAccess);
            }
        }
        if (de.uni_hildesheim.sse.model.varModel.datatypes.Sequence.TYPE.isAssignableFrom(type)) {
            de.uni_hildesheim.sse.model.varModel.datatypes.Sequence sequence = (de.uni_hildesheim.sse.model.varModel.datatypes.Sequence) type;
            if (Compound.TYPE.isAssignableFrom(sequence.getContainedType())) {
                constraints = transformCompoundConstraints((Compound) sequence.getContainedType(), Sequence.FORALL,
                        decl, topcmpAccess);
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
            }
        }
        return constraints;
    }
    /** 
    * Creates a container operation call ("shortcut").
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
    * Adds the constraints of <tt>constraintsToAdd</tt> to <tt>scopeConstraints</tt> while considering  {@link #considerFrozenConstraints}.
    * @param scopeConstraints The list of constraints for the current reasoning process(will be changed as side effect).
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
    * Part of the   {@link #resolve()} method.Processes all constraints.
    */
    private void processConstraints() {
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
        ConstraintFinder finder = new ConstraintFinder(project, false);
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
        if (unresolvedConstraints.size() > 0) {
            constraintBase.addAll(unresolvedConstraints);
        }
        clearConstraintLists();
        constraintBaseSize = constraintBase.size();
        resolveConstraints(constraintBase);
        filterOutSimpleAssignments();
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
        for (int i = 0; i < hostAssignment.getAssignmentDataCount(); i++) {
            if (nestAssignment == null) {
                nestAssignment = hostAssignment;
            }
            for (int y = 0; y < nestAssignment.getElementCount(); y++) {
                processElement(hostAssignment.getAssignmentData(i), nestAssignment.getElement(y), compound);
                if (Compound.TYPE.isAssignableFrom(nestAssignment.getElement(y).getType())) {
                    Compound cmp = (Compound) nestAssignment.getElement(y).getType();
                    for (int j = 0; j < cmp.getDeclarationCount(); j++) {
                        CompoundAccess cmpAccess;
                        if (compound == null) {
                            cmpAccess = new CompoundAccess(new Variable(nestAssignment.getElement(y)),
                                    cmp.getDeclaration(j).getName());
                        } else {
                            cmpAccess = new CompoundAccess(compound, cmp.getDeclaration(j).getName());
                        }
                        try {
                            cmpAccess.inferDatatype();
                        } catch (CSTSemanticException e) {
                        }
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
    private void processElement(Assignment assignment, DecisionVariableDeclaration element, CompoundAccess compound) {
        String attributeName = assignment.getName();
        ConstraintSyntaxTree cst = null;
        if (compound == null) {
            cst = new OCLFeatureCall(
                    new AttributeVariable(new Variable(element), (Attribute) element.getAttribute(attributeName)),
                    OclKeyWords.ASSIGNMENT, assignment.getExpression());
        } else {
            cst = new OCLFeatureCall(new AttributeVariable(compound, (Attribute) element.getAttribute(attributeName)),
                    OclKeyWords.ASSIGNMENT, assignment.getExpression());
        }
        try {
            cst.inferDatatype();
        } catch (CSTSemanticException e) {
        }
        Constraint constraint = new Constraint(project);
        try {
            constraint.setConsSyntax(cst);
            assignedAttributeConstraints.add(constraint);
        } catch (CSTSemanticException e) {
        }
    }
    /** 
    * Method for resolving constraints.
    * @param constraints List of constraints to be resolved.
    */
    private void resolveConstraints(List<Constraint> constraints) {
        if (Descriptor.LOGGING) {
            printConstraints(constraintBase);
        }
        constraintBaseIndex = 0;
        for (int i = 0; i < constraints.size(); i++) {
            constraintBaseIndex = i;
            problemVariables.clear();
            AssignmentState state = null;
            if (constraints.get(i).isDefaultConstraint()) {
                state = AssignmentState.DEFAULT;
            } else {
                state = AssignmentState.DERIVED;
            }
            ConstraintSyntaxTree cst = constraints.get(i).getConsSyntax();
            if (cst != null) {
                if (Descriptor.LOGGING) {
                }
                evaluator.init(config, state, false, listener);
                evaluator.setResolutionListener(resolutionListener);
                evaluator.setScopeAssignmnets(scopeAssignments);
                evaluator.visit(cst);
                reevaluationCounter++;
                if (evaluator.constraintFailed()) {
                    conflictingConstraint(constraints.get(i));
                } else if (evaluator.constraintFulfilled()) {
                    fulfilledConstraint(constraints.get(i));
                }
                for (int j = 0; j < evaluator.getMessageCount(); j++) {
                    if (evaluator.getMessage(j).getVariable() != null) {
                        if (!(evaluator.getMessage(j).getVariable().getParent() instanceof OperationDefinition)
                                && !(evaluator.getMessage(j).getVariable().getParent() instanceof Constraint)) {
                            problemVariables.clear();
                            problemVariables.add(evaluator.getMessage(j).getDecision());
                            FailedElementDetails failedelementDetails = new FailedElementDetails();
                            failedelementDetails.setProblemPoints(new HashSet<IDecisionVariable>(problemVariables));
                            failedelementDetails.setProblemConstraintPart(cst);
                            failedElements.addProblemVariable(evaluator.getMessage(j).getVariable(),
                                    failedelementDetails);
                            if (Descriptor.LOGGING) {
                                printProblemPoints();
                            }
                        }
                    }
                }
                if (null != constraintVariableMap.get(constraints.get(i))) {
                    Value value = evaluator.getResult();
                    try {
                        constraintVariableMap.get(constraints.get(i)).setValue(value, AssignmentState.DEFAULT);
                    } catch (ConfigurationException e) {
                    }
                }
                if (Descriptor.LOGGING) {
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
            checkContainerInitializer(finder.getExpression(), false);
        }
        if (finder.isCompoundInitializer()) {
            checkCompoundInitializer(finder.getExpression(), true);
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
        for (IDecisionVariable variable : allVariables) {
            for (Constraint constraint : constraints) {
                if (constraint.getConsSyntax() != null) {
                    VariablesInConstraintsFinder varFinder = new VariablesInConstraintsFinder(variable.getDeclaration(),
                            constraint.getConsSyntax());
                    if (varFinder.containsVariable() && !varFinder.isSimpleAssignment()) {
                        addConstraintToConstraintMap(variable.getDeclaration(), constraint);
                    }
                }
            }
        }
    }
    /** 
    * Method for filtering out simple assignment constraints.
    */
    private void filterOutSimpleAssignments() {
        for (Constraint constraint : constraintBase) {
            if (constraint.getConsSyntax() != null) {
                VariablesInConstraintsFinder simpleAssignmentFinder = new VariablesInConstraintsFinder(
                        constraint.getConsSyntax());
                if (!simpleAssignmentFinder.isSimpleAssignment()) {
                    unresolvedConstraints.add(constraint);
                }
            }
        }
    }
    /** 
    * Will be called after a failure was detected in a   {@link Constraint}.
    * @param constraint The violated {@link Constraint}.
    */
    private void conflictingConstraint(Constraint constraint) {
        if (constraint != null) {
            FailedElementDetails failedElementDetails = new FailedElementDetails();
            failedElementDetails.setProblemPoints(new HashSet<IDecisionVariable>(problemVariables));
            failedElementDetails.setProblemConstraintPart(getFailedConstraintPart());
            failedElements.addProblemConstraint(constraint, failedElementDetails);
            if (Descriptor.LOGGING) {
                printModelElements(config, "constraint resolved");
                printProblemPoints();
            }
        }
    }
    /** 
    * Will be called after a failure was detected in a default constraint of an   {@link AbstractVariable}.
    * @param decl The conflicting declaration of an {@link AbstractVariable}. Call   {@link AbstractVariable#getDefaultValue()} to retrieve the conflicting constraint.
    */
    private void conflictingDefault(AbstractVariable decl) {
    }
    /** 
    * Will be called after a failure is not detected in a   {@link Constraint}.
    * @param constraint The fulfilled {@link Constraint}.
    */
    private void fulfilledConstraint(Constraint constraint) {
        if (constraint != null) {
            failedElements.removeProblemConstraint(constraint);
            if (Descriptor.LOGGING) {
            }
        }
    }
    /** 
    * Method for creating a clean   {@link Configuration}.
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
        for (IDecisionVariable variable : config) {
            printModelElement(variable);
        }
    }
    /** 
    * Method for printing info about   {@link IDecisionVariable}.
    * @param variable Variable to be printed out.
    */
    private void printModelElement(IDecisionVariable variable) {
        if (variable.getNestedElementsCount() > 0) {
            for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                printModelElement(variable.getNestedElement(i));
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
            attributes = attributes + variable.getAttribute(i).toString() + " : " + variable.getAttribute(i).getState()
                    + " : " + variable.getAttribute(i).getValue() + "; ";
        }
        return attributes;
    }
    /** 
    * Method for printing constraints that are taken into account for reasoning.
    * @param constraints Constraints from the project. 
    */
    private void printConstraints(List<Constraint> constraints) {
        for (int i = 0; i < constraints.size(); i++) {
        }
    }
    /** 
    * Method for initial filling of keys for constraint map.
    */
    private void fillConstraintMapKeys() {
        for (IDecisionVariable variable : allVariables) {
            retrieveVariable(variable);
        }
    }
    /** 
    * Method for analyzing variable and adding it to the variable map.
    * @param variable {@link IDecisionVariable}.
    */
    private void retrieveVariable(IDecisionVariable variable) {
        addConstraintMapKey(variable.getDeclaration());
    }
    /** 
    * Method for adding a key to a constraint map.
    * @param variable {@link AbstractVariable}.
    */
    private void addConstraintMapKey(AbstractVariable variable) {
        constraintMap.put(variable, new HashSet<Constraint>());
    }
    /** 
    * Method for adding a constraint to the constraint map.
    * @param variable Key variable.
    * @param constraint Constraint to be added.
    */
    private void addConstraintToConstraintMap(AbstractVariable variable, Constraint constraint) {
        Set<Constraint> relevantConstraints = constraintMap.get(variable);
        relevantConstraints.add(constraint);
        constraintMap.put(variable, relevantConstraints);
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
                }
                if (Descriptor.LOGGING) {
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
                }
            }
            if (failedElements.problemVariabletCount() > 0) {
                Iterator<AbstractVariable> failedVariables = failedElements.getProblemVariables();
                while (failedVariables.hasNext()) {
                    AbstractVariable failedVariable = failedVariables.next();
                }
            }
        }
    }
    /** 
    * Getter for the map of all   {@link de.uni_hildesheim.sse.reasoning.core.model.variables.ConstraintVariable}and their   {@link Constraint}s.
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
            for (IDecisionVariable problem : problemVariables) {
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
        return variableCounter;
    }
    /** 
    * Method for returning the overall number of reevaluations in the model.
    * @return number of reevaluations.
    */
    public int reevaluationCount() {
        return reevaluationCounter;
    }
    /** 
    * Method for retrieving   {@link FailedElements} with failed {@link Constraint}s and   {@link IDecisionVariable}s.
    * @return {@link FailedElements}
    */
    public FailedElements getFailedElements() {
        return failedElements;
    }
}
