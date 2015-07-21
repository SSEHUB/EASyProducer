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
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.cstEvaluation.IValueChangeListener;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.model.PerformanceStatistics;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedElements;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.FailedRules;
import de.uni_hildesheim.sse.reasoning.reasoner.functions.ScopeAssignments;
import de.uni_hildesheim.sse.reasoning.reasoner.model.AssignmentConstraintFinder;
import de.uni_hildesheim.sse.reasoning.reasoner.model.CollectionConstraintsFinder;
import de.uni_hildesheim.sse.reasoning.reasoner.model.CopyVisitor;
import de.uni_hildesheim.sse.reasoning.reasoner.model.VariablesInConstraintsFinder;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Class for performing reasoning with AssignmnetResolver.
 * @author Sizonenko
 *
 */
public class Resolver {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(Resolver.class, Descriptor.BUNDLE_NAME);
    
//    private static final boolean ENABLE_LOGGING = false;
    
    private String reasoningID; 
    
    private Project project;
    private Configuration config;
    private EvaluationVisitor evaluator;   
    
    private List<IDecisionVariable> allVariables;
    
    private Map<AbstractVariable, Set<Constraint>> constraintMap;
    private Map<Compound, List<Constraint>> compoundConstraintsMap;
    private Map<Constraint, AbstractVariable> constraintVariableMap;
    private List<Constraint> constraintBase;   
    private List<Constraint> constraintVariables;
    private List<Constraint> compoundConstraints;
    private List<Constraint> unresolvedConstraints; 
    private List<Constraint> defaultAttributeConstraints;
    private List<Constraint> assignedAttributeConstraints;
    private List<Constraint> collectionConstraints;
    private List<Constraint> defaultConstraints;
    
    private int constraintBaseSize = 0;
    
    private Map<AbstractVariable, CompoundAccess> varMap;
    
    private List<Constraint> collectionCompoundConstraints;
    
    // Stats
    private int constraintCounter = 0;
    private int variableCounter = 0;    
    private int reevaluationCounter = 0;
    
    private boolean incremental;
    
    private IValueChangeListener listener = new IValueChangeListener() {
        
        @Override
        public void notifyUnresolved(IDecisionVariable variable) {
            // TODO Auto-generated method stub                   
        }
        
        @Override
        public void notifyChanged(IDecisionVariable variable) {
            if (Descriptor.LOGGING) {
                LOGGER.debug("Value changed: " + variable.getDeclaration().getName() + " " + variable.getValue()
                    + " Parent: " + (null == variable.getParent() ? null : variable.getParent()));                 
            }
            ScopeAssignments.addAssignedVariable(variable);
            Set<Constraint> varConstraints = constraintMap.get(variable.getDeclaration());
            if (varConstraints != null) {
                for (Constraint varConstraint : varConstraints) {
                    constraintBase.add(varConstraint);
                    constraintBaseSize++;
                    if (Descriptor.LOGGING) {
                        LOGGER.debug("Constraints added to current list: " 
                            + StringProvider.toIvmlString(varConstraint.getConsSyntax()));                        
                    }
                }                     
            }
        }
    };
    
    /**
     * Main constructor that activates Resolver constructor.
     * @param project Project for evaluation.
     * @param config Configuration to reason on.
     * @param reasoningID ID of a reasoning (for multithreading).
     */
    public Resolver(Project project, Configuration config, String reasoningID) {
        this.config = config;
        evaluator = createEvaluationVisitor();
        this.allVariables = new ArrayList<IDecisionVariable>();
        this.reasoningID = reasoningID;
        this.constraintMap = new HashMap<AbstractVariable, Set<Constraint>>();
        this.compoundConstraintsMap = new HashMap<Compound, List<Constraint>>();
        this.constraintVariableMap = new HashMap<Constraint, AbstractVariable>();
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
    } 
    
    /**
     * Main constructor that activates Resolver constructor.
     * @param project Project for evaluation.
     * @param reasoningID ID of a reasoning (for multithreading).
     */
    public Resolver(Project project, String reasoningID) {
        this.config = createCleanConfiguration(project);
        evaluator = createEvaluationVisitor();
        this.allVariables = new ArrayList<IDecisionVariable>();
        this.reasoningID = reasoningID;
        this.constraintMap = new HashMap<AbstractVariable, Set<Constraint>>();
        this.compoundConstraintsMap = new HashMap<Compound, List<Constraint>>();
        this.constraintVariableMap = new HashMap<Constraint, AbstractVariable>();
        this.constraintBase = new ArrayList<Constraint>();
        this.constraintVariables = new ArrayList<Constraint>();
        this.defaultAttributeConstraints = new ArrayList<Constraint>();
        this.assignedAttributeConstraints = new ArrayList<Constraint>();
        this.collectionConstraints = new ArrayList<Constraint>();
        this.compoundConstraints = new ArrayList<Constraint>();
        this.unresolvedConstraints = new ArrayList<Constraint>();
        this.collectionCompoundConstraints = new ArrayList<Constraint>();
        this.defaultConstraints = new ArrayList<Constraint>();
        this.incremental = false;
    } 
    
    /**
     * Main constructor that activates Resolver constructor.
     * @param config Configuration to reason on.
     * @param reasoningID ID of a reasoning (for multithreading).
     */
    public Resolver(Configuration config, String reasoningID) {
        new Resolver(config.getProject(), config, reasoningID);
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
        ArrayList<Project> projects = new ArrayList<Project>();
        findImportedProjects(projects);
        
        projects = arrangeImportedProjects(projects);        
        
        while (!projects.isEmpty()) {
            project = projects.remove(0);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Project:" + project.getName());                
            }
            evaluator.setDispatchScope(project);
            ScopeAssignments.clearScopeAssignments();
            resolveDefaultValues();
            fillConstraintMapKeys();
//            if (ENABLE_LOGGING) {
//                printModelElements(config, "After defaults in scope " + project.getName());                
//            }
            processConstraints();
            // Freezes values after each scope
            config.freezeValues(project, FilterType.NO_IMPORTS);
            // TODO do incremental freezing in here -> required by interfaces with propagation constraints
            if (Descriptor.LOGGING) {
                printModelElements(config, "After reasoning in scope " + project.getName());
                displayFailedElements();                                
            }
        }
        variableCounter = constraintMap.size();
//        System.out.println("Constraint reevaluation count: " + reevaluationCounter);
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
        allVariables.add(variable);
        IDatatype type = decl.getType();
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        // Attribute handling
        if (variable.getAttributesCount() > 0) {
            resolveAttributeAssignments(decl, variable, compound);
        }        
        if (Compound.TYPE.isAssignableFrom(type)) {
            resolveCompoundDefaultValueForDeclaration(decl, variable, compound, type); 
            if (null != defaultValue) {
                CopyVisitor visitor = new CopyVisitor(null, varMap);
                visitor.setSelf(decl);
                defaultValue.accept(visitor);
                defaultValue = visitor.getResult();                
            }
        }  
        collectionCompoundConstraints.addAll(collectionCompoundConstraints(decl, null));        
        if (null != defaultValue) {
            //Comment out BOOLEAN
            if (ConstraintType.TYPE.isAssignableFrom(type) /*&& !(BooleanType.TYPE.isAssignableFrom(type))*/) {
                if (compound == null) {
                    Constraint constraint = new Constraint(project);
                    try {
                        constraint.setConsSyntax(defaultValue);
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, decl);
                    } catch (CSTSemanticException e) {
                        e.printStackTrace();
                    }
                    if (Descriptor.LOGGING) {
                        LOGGER.debug(variable.getDeclaration().getName() + " project constraint variable " 
                            + StringProvider.toIvmlString(defaultValue));
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
                    // TODO Auto-generated catch block
                    LOGGER.exception(e);
                }
//                evaluator.init(config, AssignmentState.DEFAULT, false, null);
//                evaluator.visit(defaultValue);
//                if (evaluator.constraintFailed() && !(BooleanType.TYPE.isAssignableFrom(type))) {
//                    conflictingDefault(decl);
//                } else {
//                    Value value = evaluator.getResult();
//                    try {
//                        variable.setValue(value, AssignmentState.DEFAULT);
//                        ScopeAssignments.addAssignedVariable(variable);
//                    } catch (ConfigurationException e) {
//                        LOGGER.exception(e);
//                    }
//                }
//                evaluator.clear();                
            }                
        }
    }

    /**
     * Method for checking if {@link CompoundInitializer} holds 
     * a {@link CollectionInitializer} with {@link Constraint}s.
     * @param exp expression to check.
     * @param compound false if variable is not nested.
     */
    private void checkCompoundInitializer(ConstraintSyntaxTree exp, Boolean compound) {
//        System.out.println("CompoundInitializer: " + StringProvider.toIvmlString(exp));
        CompoundInitializer compoundInit = (CompoundInitializer) exp;
        for (int i = 0; i < compoundInit.getExpressionCount(); i++) {
//            System.out.println("Exp: " + StringProvider.toIvmlString(compoundInit.getExpression(i)));
            if (compoundInit.getExpression(i) instanceof ContainerInitializer) {
                checkContainerInitializer(compoundInit.getExpression(i), compound);
            }
            if (compoundInit.getExpression(i) instanceof CompoundInitializer) {
                checkCompoundInitializer(compoundInit.getExpression(i), compound);
            }    
        }
    }

    /**
     * Method for checking if an expression is a {@link ContainerInitializer}.
     * @param exp expression to be checked.
     * @param compound false if variable is not nested.
     */
    private void checkContainerInitializer(ConstraintSyntaxTree exp, Boolean compound) {
//        System.out.println("ContainerInitializer: " + StringProvider.toIvmlString(exp));
        ContainerInitializer containerInit = (ContainerInitializer) exp;
//        System.out.println("Type: " + containerInit.getType().getContainedType());
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
//            System.out.println("Container expression: " 
//                + StringProvider.toIvmlString(containerInit.getExpression(i)));
            Constraint constraint = new Constraint(project);
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            if (compound) {
                CopyVisitor visitor = new CopyVisitor(null, varMap);
                cst.accept(visitor);
                cst = visitor.getResult();                
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
//                    System.out.println("Attribute constraint before: " + StringProvider.toIvmlString(defaultValue));
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
//                    System.out.println("Attribute constraint after: " 
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
//        compoundConstraintsMap.put(cmpType, thisCompoundConstraints);
        CompoundVariable cmpVar = (CompoundVariable) variable;        
        for (int i = 0, n = cmpType.getInheritedElementCount(); i < n; i++) {
            AbstractVariable nestedDecl = cmpType.getInheritedElement(i);
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
            varMap.put(nestedDecl, cmpAccess);
            if (ConstraintType.TYPE.isAssignableFrom(nestedType)) {
                ConstraintSyntaxTree defaultValue = nestedDecl.getDefaultValue();
                if (defaultValue != null) {
                    CopyVisitor visitor = new CopyVisitor(null, varMap);
                    visitor.setSelf(decl);
                    defaultValue.accept(visitor);
                    ConstraintSyntaxTree copiedCST = visitor.getResult();
                    try {
                        Constraint constraint = new Constraint(copiedCST, project);
                        constraintVariables.add(constraint);
                        constraintVariableMap.put(constraint, nestedDecl);
                    } catch (CSTSemanticException e) {
                        LOGGER.exception(e);
                    }
                    if (Descriptor.LOGGING) {
                        LOGGER.debug(variable.getDeclaration().getName() + " compound constraint variable " 
                            + StringProvider.toIvmlString(copiedCST));
                    }                    
                }
            }
            resolveDefaultValueForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()),
                cmpAccess);
        }
        for (int i = 0; i < thisCompoundConstraints.size(); i++) {
            ConstraintSyntaxTree oneConstraint = thisCompoundConstraints.get(i).getConsSyntax();             
            CopyVisitor visitor = new CopyVisitor(null, varMap);
            oneConstraint.accept(visitor);
            ConstraintSyntaxTree copiedCST = visitor.getResult();
            try {
                Constraint constraint = new Constraint(copiedCST, project);
                compoundConstraints.add(constraint);            
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }               
        }
        for (int i = 0; i < cmpType.getAssignmentCount(); i++) {
            processAttributeAssignments(cmpType.getAssignment(i), null,  cmpAccess);
        }
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
//                        constraintVariableMap.put(constraint, decl);
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
            de.uni_hildesheim.sse.model.varModel.datatypes.Set set 
                = (de.uni_hildesheim.sse.model.varModel.datatypes.Set) type;
            if (Compound.TYPE.isAssignableFrom(set.getContainedType())) {
                constraints = transformCompoundConstraints((Compound) set.getContainedType(),
                    de.uni_hildesheim.sse.model.varModel.datatypes.Set.FORALL, decl, topcmpAccess);
            }
        }
        if (de.uni_hildesheim.sse.model.varModel.datatypes.Sequence.TYPE.isAssignableFrom(type)) {
            de.uni_hildesheim.sse.model.varModel.datatypes.Sequence sequence 
                = (de.uni_hildesheim.sse.model.varModel.datatypes.Sequence) type;
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
            ConstraintSyntaxTree copiedCST = null;
            try {
                itExpression.inferDatatype();
                CopyVisitor visitor = new CopyVisitor(null, varMap);
                itExpression.accept(visitor);
                copiedCST = visitor.getResult();
                copiedCST.inferDatatype();
                if (Descriptor.LOGGING) {
                    LOGGER.debug("New loop constraint " + StringProvider.toIvmlString(copiedCST));                    
                }
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            }
            ConstraintSyntaxTree containerOp = null;
            if (topcmpAccess == null) {
                containerOp = createContainerCall(new Variable(decl), op, copiedCST, localDecl);
            } else {
                containerOp = createContainerCall(topcmpAccess, op, copiedCST, localDecl);
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
     * Part of the {@link #resolve()} method.
     * Processes all constraints.
     */
    private void processConstraints() { 
        List<Constraint> scopeConstraints = new ArrayList<Constraint>();
        if (!incremental) {
            if (defaultConstraints.size() > 0) {
                refineDefaultConstraints();
                scopeConstraints.addAll(defaultConstraints);
            }            
        }
        for (int i = 0; i < project.getInternalConstraintCount(); i++) {
            scopeConstraints.add(project.getInternalConstraint(i));
        }
        ConstraintFinder finder = new ConstraintFinder(project, false);
        scopeConstraints.addAll(finder.getConstraints());
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
        fillVariableConstraintPool(scopeConstraints);
        if (scopeConstraints.size() > 0) {
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
        if (Descriptor.LOGGING) {
            printConstraints(constraintBase);            
        }
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
        System.out.println("Attribute assignment: " + StringProvider.toIvmlString(hostAssignment));
        for (int i = 0; i < hostAssignment.getAssignmentDataCount(); i++) { 
            if (nestAssignment == null) {
                nestAssignment = hostAssignment;              
            } 
            for (int y = 0; y < nestAssignment.getElementCount(); y++) {
                processElement(hostAssignment.getAssignmentData(i),
                    nestAssignment.getElement(y), compound);
                if (Compound.TYPE.isAssignableFrom(nestAssignment.getElement(y).getType())) {                    
                    Compound cmp = (Compound) nestAssignment.getElement(y).getType();
                    for (int j = 0; j < cmp.getDeclarationCount(); j++) {
                        System.out.println("Nested: " + cmp.getDeclaration(j));
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
                            LOGGER.exception(e);
                        }
                        processElement(hostAssignment.getAssignmentData(i), cmp.getDeclaration(j), cmpAccess);
                    }
                    
                }
            }
            for (int z = 0; z < nestAssignment.getAssignmentCount(); z++) {
//                    System.out.println("Nested attribute assignment: " 
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
//        System.out.println("Element: " 
//              + StringProvider.toIvmlString(element));
//        System.out.println(element.getAttribute(attributeName));
        ConstraintSyntaxTree cst = null;
        if (compound == null) {                      
            cst = new OCLFeatureCall(
                new AttributeVariable(new Variable(element), (Attribute) element.getAttribute(attributeName)),
                    OclKeyWords.ASSIGNMENT, assignment.getExpression());
        } else {
//            System.out.println("Compound: " + StringProvider.toIvmlString(compound));
            cst = new OCLFeatureCall(new AttributeVariable(compound, (Attribute) element.getAttribute(attributeName)),
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
            System.out.println("Attribute constraint: " + StringProvider.toIvmlString(cst));
        } catch (CSTSemanticException e) {
            LOGGER.exception(e);
        }        
    }

   
    /**
     * Method for resolving constraints.
     * @param constraints List of constraints to be resolved.
     */
    private void resolveConstraints(List<Constraint> constraints) {
//        PerformanceStatistics.addTimestamp(reasoningID);
        for (int i = 0; i < constraints.size(); i++) { 
            AssignmentState state = null;
            if (constraints.get(i).isDefaultConstraint()) {
                state = AssignmentState.DEFAULT;
            } else {
                state = AssignmentState.DERIVED;
            }
            ConstraintSyntaxTree cst = constraints.get(i).getConsSyntax();
            if (cst != null) { 
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Resolving: " + StringProvider.toIvmlString(cst) 
                        + " : " + constraints.get(i).getTopLevelParent());                    
                }
                evaluator.init(config, state, false, listener);
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
                            FailedRules.addFailedVariable(reasoningID, evaluator.getMessage(j).getVariable());
                            if (Descriptor.LOGGING) {
                                LOGGER.debug("Assigment error: " + evaluator.getMessage(j).getVariable());
                            }
                        }
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
     * Method for refining default constraints.
     */
    private void refineDefaultConstraints() {
        List<Constraint> tmpConstraints = new ArrayList<Constraint>();
        for (Constraint constraint : defaultConstraints) {
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            CopyVisitor visitor = new CopyVisitor(null, varMap);
            cst.accept(visitor);
            cst = visitor.getResult();
            Constraint newConstraint = new Constraint(project);
            newConstraint.makeDefaultConstraint();
            try {
                cst.inferDatatype();
                if (Descriptor.LOGGING) {
                    LOGGER.debug("Default constraint: " + StringProvider.toIvmlString(cst));                    
                }
                if (cst != null) {
                    newConstraint.setConsSyntax(cst);
                    tmpConstraints.add(newConstraint);                    
                }
            } catch (CSTSemanticException e) {
                // TODO Auto-generated catch block
                LOGGER.exception(e);
            }
        }
        defaultConstraints.clear();
        defaultConstraints.addAll(tmpConstraints);
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
        constraintVariables.clear();
        compoundConstraints.clear();
        collectionCompoundConstraints.clear();        
        defaultAttributeConstraints.clear();
        collectionConstraints.clear();
        unresolvedConstraints.clear();        
    }

    /**
     * Method for filling the map with constraints related to specific variable.
     * @param constraints Constraints to be checked for variables.
     */
    private void fillVariableConstraintPool(List<Constraint> constraints) {
        for (IDecisionVariable variable : allVariables) {
//            LOGGER.debug("--");
//            LOGGER.debug("Creating constraint pool: " + variable.getDeclaration().getName());
            for (Constraint constraint : constraints) { 
                if (constraint.getConsSyntax() != null) {
                    VariablesInConstraintsFinder varFinder 
                        = new VariablesInConstraintsFinder(variable.getDeclaration(),
                            constraint.getConsSyntax());                
//                    LOGGER.debug("Constraint " + StringProvider.toIvmlString(constraint.getConsSyntax())
//                        + "  Contains variable: " + varFinder.containsVariable()
//                        + "  Simple Assignment: " + varFinder.isSimpleAssignment());
                    if (varFinder.containsVariable() && !varFinder.isSimpleAssignment()) {
                        addConstraintToConstraintMap(variable.getDeclaration(), constraint);
//                        LOGGER.debug("Constraint added to map");
                    }                    
                }
            }
        }
//        LOGGER.debug("--");
    } 
    
    /**
     * Method for filtering out simple assignment constraints.
     */
    private void filterOutSimpleAssignments() {
        for (Constraint constraint : constraintBase) { 
            if (constraint.getConsSyntax() != null) {
                VariablesInConstraintsFinder simpleAssignmentFinder 
                    = new VariablesInConstraintsFinder(constraint.getConsSyntax());            
                if (!simpleAssignmentFinder.isSimpleAssignment()) {                
                    unresolvedConstraints.add(constraint);
//                    LOGGER.debug("Constraint saved for next round: " 
//                        + StringProvider.toIvmlString(constraint.getConsSyntax()));
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
            FailedRules.addFailedConstraint(reasoningID, constraint);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Failed constraint: " 
                    + StringProvider.toIvmlString(constraint.getConsSyntax()));
                printModelElements(config, "constraint resolved");                
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
            FailedRules.removeValidConstraint(reasoningID, constraint);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Constraint fulfilled: " 
                    + StringProvider.toIvmlString(constraint.getConsSyntax()));                
            }
        }
    }
    
    /**
     * Fills the stack of imported {@link Project}s.
     * Starts with the core project.
     * @param projects The list of all included projects, which are used inside the configuration.
     */
    private void findImportedProjects(ArrayList<Project> projects) {
        findImportedProjects(config.getProject(), projects, new HashSet<Project>());        
    }

    /**
     * Fills the stack of imported {@link Project}s recursively.
     * @param project the project to be considered
     * @param projects the list of all included projects (modified as a side effect)
     * @param done already considered projects 
     */
    private void findImportedProjects(Project project, ArrayList<Project> projects, Set<Project> done) {
        if (!done.contains(project)) {
            done.add(project);
            projects.add(project); // do this in sequence of import specification
            for (int i = 0, n = project.getImportsCount(); i < n; i++) {
                Project importedProject = project.getImport(i).getResolved();
                if (null != importedProject) {
                    findImportedProjects(importedProject, projects, done);
                }
            }
        }
    }
    
    /**
     * Rearranges all {@link Project} used in imports.
     * @param projects {@link Project} retrieved from {@link Configuration}.
     * @return Rearranged list of {@link Project}s.
     */
    private ArrayList<Project> arrangeImportedProjects(ArrayList<Project> projects) {
        ArrayList<Project> sequence = new ArrayList<Project>();
        Set<Project> done = new HashSet<Project>();        
        while (!projects.isEmpty()) {            
            for (int y = projects.size() - 1; y >= 0; y--) {
                Project project = projects.get(y);
                boolean resolved = true;
                for (int i = 0, n = project.getImportsCount(); resolved && i < n; i++) {
                    Project importedProject = project.getImport(i).getResolved();
                    if (null != importedProject) {
                        resolved = done.contains(importedProject);
                    }
                }
                if (resolved) {
                    sequence.add(project);
                    done.add(project);
                    projects.remove(y);
                }
            }
        }
        return sequence;
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
            LOGGER.debug(variable.getDeclaration() 
                    + " : "
                    + variable.getState().toString()
                    + " : " 
                    + variable.getValue()
                    + " | "
                    + printAttributes(variable));
            if (variable.getNestedElementsCount() > 0) {
                for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                    LOGGER.debug("Nested: " 
                        + variable.getNestedElement(i).getDeclaration() 
                        + " : "
                        + variable.getNestedElement(i).getState().toString()
                        + " : " 
                        + variable.getNestedElement(i).getValue()
                        + " | "
                        + printAttributes(variable.getNestedElement(i)));
                }
            }
            LOGGER.debug("");
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
//        IDatatype type = variable.getDeclaration().getType();        
//        if (Compound.TYPE.isAssignableFrom(type)) {
//            CompoundVariable cmpVar = (CompoundVariable) variable;
//            for (int i = 0; i < cmpVar.getNestedElementsCount(); i++) {
//                retrieveVariable(cmpVar.getNestedElement(i));
//            }
//        }
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
     * Method for displying failed constraints and assignments.
     */
    private void displayFailedElements() {
        List<ModelElement> failedModelElements;
        FailedElements failedElements = FailedRules.getFailedElements(reasoningID);
        if (failedElements.hasErrors()) {
            if (failedElements.failedConstraintCount() > 0) {
                failedModelElements = new ArrayList<ModelElement>(failedElements.failedConstraintCount());
                Iterator<Constraint> failedConstraints = failedElements.getFailedConstraints();
                while (failedConstraints.hasNext()) {
                    Constraint failedRule = failedConstraints.next();
                    failedModelElements.add(failedRule);
                    LOGGER.debug("Failed constraint: " + StringProvider.toIvmlString(failedRule.getConsSyntax()));
                }
                failedModelElements = null;
            }        
            if (failedElements.failedVariablesCount() > 0) {
                failedModelElements = new ArrayList<ModelElement>(failedElements.failedVariablesCount());
                Iterator<AbstractVariable> failedVariables = failedElements.getFailedVariables();
                while (failedVariables.hasNext()) {
                    AbstractVariable failedVariable = failedVariables.next();
                    failedModelElements.add(failedVariable);
                    LOGGER.debug("Failed variable: " + failedVariable.toString());
                } 
                failedModelElements = null;
            }                        
        } 
    }
    
    /**
     * Getter for the map of all {@link ConstraintVariable} and their {@link Constraint}s.
     * @return Map of constraint variables and their constraints.
     */
    public Map<Constraint, AbstractVariable> getConstraintVariableMap() {
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
        return variableCounter;
    }
    
    /**
     * Method for returning the overall number of reevaluations in the model.
     * @return number of reevaluations.
     */
    public int reevaluationCount() {
        return reevaluationCounter;
    }


}
