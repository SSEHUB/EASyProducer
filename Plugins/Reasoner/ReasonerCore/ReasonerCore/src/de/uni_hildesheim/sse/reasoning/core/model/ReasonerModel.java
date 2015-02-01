package de.uni_hildesheim.sse.reasoning.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype;
import de.uni_hildesheim.sse.model.varModel.filter.DatatypeFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.reasoning.core.Bundle;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.CompoundType;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.ReasonerDatatype;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.ReasonerTypeFactory;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ConstraintVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariableFactory;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeValues;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * A structured model containing relevant information about
 * {@link de.uni_hildesheim.sse.model.confModel.IDecisionVariable}s, needed by the individual
 * {@link  de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner}.
 * @author El-Sharkawy
 *
 */
public class ReasonerModel implements IConstraintContainer, Iterable<ReasonerVariable>, IVariableContainer {
    
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(ReasonerModel.class, Bundle.ID);
    
    // Project information
    private Project project;
    private Configuration config;
    
    // ReasonerModel
    private Map<String, ReasonerVariable> variables;
    private ConstraintContainer constraints;
    
    /**
     * This set is for retrieving variables in compounds.
     */
    private Map<String, Set<ReasonerVariable>> variablesInCompounds;
    
    /**
     * This set is for optimization and should contain a subset of the variables stored in {@link #variables}.
     * This set stores only variables which are used in constraints, other variables can be ignored by the reasoner.
     */
    private Set<ReasonerVariable> variablesInConstraints;    
    
    /**
     * This set stores only constraint variables which are used in for named constraints.
     */
    private Set<ConstraintVariable> constraintVariables;    
    
    /**
     * Translated {@link ReasonerDatatype}s in form of (Datatype name, Datatype).
     */
    private Map<String, ReasonerDatatype> customTypes;
    
    /**
     * List of variables inside the current view (could also be defined via a configuration file).
     * If attributes a passed to the reasoner, then all elements of this list must have a value after performing a
     * reasoning.
     */
    private Set<ReasonerVariable> variablesOfCurrentView;
    
    /**
     * Optional listener, which should be informed if a variable was changed during reasoning.
     */
    private IModelChangeListener listener;
    
    // Reasoner Settings
    /**
     * Optional settings for the reasoner.
     */
    private ReasonerConfiguration settings;
    
    /**
     * Optional list of attributes, which shall be considered during reasoning.
     * If this attribute is not <tt>null</tt> and not empty, variables/constraints having the
     * same attribute value assignments or no attributes should be verified after reasoning, i.e.
     * all attributes with a correct attribute assignment should have a value.
     */
    private AttributeValues attributeValues;
    
    // Reasoning results
    private List<IDecisionVariable> propagatedVariables;
   
    private String reasoningID;
    
    /**
     * Default constructor for this class.
     * This constructor should be used whenever a configuration is given, i.e., if a reasoning over the variables
     * and their assignments should be performed.
     * @param configuration A configuration over which the reasoning should be performed. This configuration must
     * contain all relevant {@link IDecisionVariable}s needed by the reasoning.
     * @param settings The reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *    may be <b>null</b>)  
     */
    public ReasonerModel(Configuration configuration, ReasonerConfiguration settings) {
        /*** Start time measurement ***/
        this.reasoningID = PerformanceStatistics.createReasoningID(configuration.getProject().getName(), "Drools2");
        PerformanceStatistics.createPerformanceMeasurement(reasoningID);
        /*** Start RM creation ***/
//        Statistic.addTimestamp(reasoningID, System.currentTimeMillis());
        /***  To DroolsEngine  ***/        
        this.project = configuration.getProject();
        this.config = configuration;
        this.settings = settings;
        this.listener = null;
        if (null != settings) {
            attributeValues = settings.getAttributeValues();
        }
        variables = new HashMap<String, ReasonerVariable>();
        variablesOfCurrentView = new HashSet<ReasonerVariable>();
        constraintVariables = new HashSet<ConstraintVariable>();
        variablesInCompounds = new HashMap<String, Set<ReasonerVariable>>();
        propagatedVariables = new ArrayList<IDecisionVariable>();
        
        // Retrieve all custom datatypes
        retrieveCustomDatatypes();
        
        // Create variables (must be created after the creation of datatypes).
        createVariables();

        // ConstraintContainer must be created after the variables have been created.
        constraints = new ConstraintContainer(this);
        
        // Create list of variables in constraints (must be done after the creation of variables)
        // (internal constraints not considered)
        variablesInConstraints = new HashSet<ReasonerVariable>();
        List<ConstraintSyntaxTree> tmpConstraintsList = new ArrayList<ConstraintSyntaxTree>();
        for (int i = 0; i < constraints.getNormalConstraintCount(); i++) {
            ConstraintSyntaxTree syntax = constraints.getNormalConstraint(i);
            tmpConstraintsList.add(syntax);
        }
        findVariablesUsedInConstraints(tmpConstraintsList);
        
        // Find variables used in constraints of compound definitions
        for (ReasonerDatatype customDatatype : customTypes.values()) {
            if (customDatatype.hasConstraints()) {
                boolean instancesFound = false;
                Iterator<ReasonerVariable> varIterator = variables.values().iterator();
                
                // Add instances of the datatype
                while (varIterator.hasNext()) {
                    ReasonerVariable variable = varIterator.next();
                    if (variable.getTypeName().equals(customDatatype.getName())) {
                        variablesInConstraints.add(variable);
                        instancesFound = true;
                    }
                }
                
                // Add further variables used in constraints of the datatype
                if (instancesFound) {
                    // Currently, only CompoundTypes can contain constraints
                    CompoundType cmpType = (CompoundType) customDatatype;
                    List<ConstraintSyntaxTree> compoundConstraints = cmpType.getCompoundConstraints();
                    findVariablesUsedInConstraints(compoundConstraints);
                    for (int i = 0; i < compoundConstraints.size(); i++) {                        
                        variablesInCompounds.put(cmpType.getName() + "_" + i,
                                retrieveVariablesUsedInCompoundConstraints(compoundConstraints.get(i)));
                    }
                }
            }
        }        
        getImportStats();        
    }

    /**
     * This constructor should only be used if now configuration is available, i.e., if a reasoning over the structure
     * of the project should be performed.
     * @param project The project, where an {@link de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner
     * #isConsistent(Project, ReasonerConfiguration, de.uni_hildesheim.sse.model.progress.ProgressObserver)}
     * operation should be performed on.
     * @param settings The reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *    may be <b>null</b>)     
     */
    public ReasonerModel(Project project, ReasonerConfiguration settings) {
        // Create temporary Configuration and IDecisionVariables to unify the handling of reasoning model.
        this(new Configuration(project), settings); 
    }
    
    /** 
     * Method for retrieved stats about imported porjects and overall number of registered constraints.
     */
    private void getImportStats() {
        for (int i = 0; i < this.getProject().getImportsCount(); i++) {
            LOGGER.debug("Imported project: " + this.getProject().getImport(i).getName());
        }
        LOGGER.debug("Overall number of constraints: " + this.getConstraintCount());
    }

    /**
     * Method for setting listener of the {@link ReasonerModel}.
     * @param listener Listener.
     */
    public void setModelListener(IModelChangeListener listener) {
        this.listener = listener;
    }
    
    /**
     * Method for notifying the {@link ReasonerModel} that a {@link ReasonerVariable} was changed.
     * @param changedVariable changed {@link ReasonerVariable}.
     */
    public void variableChanged(ReasonerVariable changedVariable) {
        if (null != listener) {
            listener.variableChanged(changedVariable);
        }
    }


    /**
     * Method for retrieving custom datatypes from the project.
     */
    private void retrieveCustomDatatypes() {
        customTypes = new HashMap<String, ReasonerDatatype>();
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, null);
        List<CustomDatatype> customTypesList = finder.getFoundDatatypes();
        for (CustomDatatype type : customTypesList) {
            ReasonerDatatype rType = ReasonerTypeFactory.createDatatype(type, project);
            if (null != rType) {
                customTypes.put(rType.getName(), rType);
            }
        }
    }
    
    /**
     * Method for creating {@link ReasonerVariable}s.
     */
    private void createVariables() {
        for (IDecisionVariable variable : config) {
            ReasonerVariable reasonerVariable = ReasonerVariableFactory.createVariables(variable, this, null);
            addVariable(reasonerVariable);
            String varName = variable.getClass().getSimpleName();
            if (varName.equals("SetVariable") || varName.equals("SequenceVariable")) {
                for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                    ReasonerVariable nestedVariable = 
                            ReasonerVariableFactory.createVariables(variable.getNestedElement(i), this, null);
                    addVariable(nestedVariable);
                    reasonerVariable.addNested(nestedVariable);
                }
            }  
        }
    }
    
    /**
     * Traverses all constraints and collects all toplevel {@link ReasonerVariable}s, which are used in constraints.
     * Only these variables are relevant for reasoning.
     * @param constraints A Collection of constraints stored in this model, which should be used for reasoning.
     */
    private void findVariablesUsedInConstraints(Collection<ConstraintSyntaxTree> constraints) {
        VariablesInConstraintsFinder variablesFinder = new VariablesInConstraintsFinder(constraints);
        Set<AbstractVariable> foundVariables = variablesFinder.getVariables();
        for (AbstractVariable abstractVariable : foundVariables) {
            String variableName = abstractVariable.getName();
            ReasonerVariable foundReasonerVariable = getVariable(variableName);
            /*
             *  In case of a nested variable (e.g. of a compound), the nested variables will not be stored
             *  in the variables map, and, thus, the result will be null.
             */
            if (null != foundReasonerVariable) {
                variablesInConstraints.add(foundReasonerVariable);
            }
        }
    } 
    
    /**
     * Method to retrieve constraint variables from a specific compound.
     * @param compoundConstraint Constraints of the compound.
     * @return Set of variables.
     */
    private Set<ReasonerVariable> retrieveVariablesUsedInCompoundConstraints(
            ConstraintSyntaxTree compoundConstraint) {
        Set<ReasonerVariable> variablesInCompoundConstraints = new HashSet<ReasonerVariable>();
        VariablesInConstraintsFinder variablesFinder = new VariablesInConstraintsFinder(compoundConstraint);
        Set<AbstractVariable> foundVariables = variablesFinder.getVariables();
        for (AbstractVariable abstractVariable : foundVariables) {
            // Solves attribute assignment, but will give error on compound-compound nesting.
            if (abstractVariable.getParent().getParent() != null) {                
                if (!abstractVariable.getParent().getClass().getSimpleName().equals("Compound")
                        && 
                        !abstractVariable.getParent().getParent().getClass().getSimpleName().equals("Compound")) {
                    addFoundReasonerVariable(variablesInCompoundConstraints, abstractVariable);
                }
            } else if (!abstractVariable.getParent().getClass().getSimpleName().equals("Compound")) {
                addFoundReasonerVariable(variablesInCompoundConstraints, abstractVariable);
            }
        }
        return variablesInCompoundConstraints;
    }

    /**
     * Method for adding {@link ReasonerVariable} defined in the project to variables used 
     * in specific compound constraint.
     * @param variablesInCompoundConstraints variables used in compound constraint.
     * @param abstractVariable {@link AbstractVariable}.
     */
    private void addFoundReasonerVariable(Set<ReasonerVariable> variablesInCompoundConstraints,
            AbstractVariable abstractVariable) {
        String variableName = abstractVariable.getName();            
        ReasonerVariable foundReasonerVariable = getVariable(variableName);
        //if (!foundReasonerVariable.getDecisionVariable().isNested()) {
        variablesInCompoundConstraints.add(foundReasonerVariable);
        //}
    }
    
    /**
     * Getter for the {@link Project}.
     * @return Returns the {@link Project}, which is used for reasoning.
     */
    public Project getProject() {
        return project;
    }
    
    /**
     * Getter for the {@link Configuration}.
     * @return Returns the {@link Configuration}, which holds the {@link IDecisionVariable}s used for reasoning.
     */
    public Configuration getConfiguration() {
        return config;
    }
    
    /**
     * Getter for the reasoner settings, which shall be used for reasoning.
     * @return A {@link ReasonerConfiguration}, which shall be used for reasoning (maybe <tt>null</tt>).
     */
    public ReasonerConfiguration getSettings() {
        return settings;
    }
    
    /**
     * Checks whether attributes have to be considered or not.
     * @return <tt>false</tt> Attributes can be ignored, <tt>true</tt> all variables with no attributes
     *     or with an attribute assignment as contained in the {@link #attributeValues} must be configured completely
     *     after running the reasoning.
     * @see #isFullyConfigured()
     */
    public boolean hasAttributes() {
        return null != attributeValues && !attributeValues.isEmpty();
    }
    
    /**
     * Adds a variable to this model.
     * The variable is added to this model if one of the following conditions is met:
     * <ul>
     * <li>There a no {@link #attributeValues} specified, or to be more precise {@link #hasAttributes()} returns
     *     <tt>false</tt>.</li>
     * <li>Or {@link ReasonerVariable#getDecisionVariable()} has an assigned attribute as specified in the given
     *    {@link #attributeValues}</li>
     * </ul>
     * @param variable The variable, which should be added to this reasoning model
     */
    private void addVariable(ReasonerVariable variable) {
        IDecisionVariable decisionVariable = variable.getDecisionVariable();
        
        // Check whether the variable has one or more attributes
        if (hasAttributes() && decisionVariable.getAttributesCount() > 0) {
            boolean variableAdded = false;
            boolean onlyNullValues = true;
            
            // Check whether the variable has at least one of the specified attribute value pairs.
            for (int i = 0; !variableAdded && i < decisionVariable.getAttributesCount(); i++) {
                IDecisionVariable attributeVariable = decisionVariable.getAttribute(i);
                Value attributeValue = attributeVariable.getValue();
                if (null != attributeValue) {
                    onlyNullValues = false;
                    Attribute attribute = (Attribute) attributeVariable.getDeclaration();
                    
                    // Add the variable to the list of variables handled in the current view
                    if (attributeValues.contains(attribute) && attributeValues.hasValue(attribute, attributeValue)) {
                        variablesOfCurrentView.add(variable);
                        variableAdded = true;
                    }                    
                }
            }
            // Add all variables where no attribute assignment was assigned to or having the correct assignment set.
            if (variableAdded || onlyNullValues) {
                variablesOfCurrentView.add(variable);
            }
        }
        
        // Determine correct ReasoningState
        if (variable.getReasoningState() == ReasoningState.DEFAULT_DIFFERENT) {
            new ReasoningStateRetriver(project, variable);
        }

        // Add the variable
        variables.put(variable.getName(), variable);
    }
        
    @Override
    public Iterator<ReasonerVariable> iterator() {
        return variables.values().iterator();
    }
    
    /**
     * Returns an iterator for all {@link ReasonerDatatype}s, which may serve as further constraints for variables.
     * @return An iterator for iterating through all {@link ReasonerDatatype}.
     */
    public Iterator<ReasonerDatatype> datatypeIterator() {
        return customTypes.values().iterator();
    }
    
    /**
     * Returns a {@link ReasonerVariable} stored in this {@link ReasonerModel}.
     * @param name The name of the variable, which should be returned.
     * @return The translated {@link ReasonerVariable} or <tt>null</tt>
     * if the no variables exists with the specified name.
     */
    public ReasonerVariable getVariable(String name) {
        return variables.get(name);
    }
    
    @Override
    public int getInternalConstraintCount() {
        return constraints.getInternalConstraintCount();
    }
    
    @Override
    public ConstraintSyntaxTree getInternalConstraint(int index) {
        return constraints.getInternalConstraint(index);
    }
    
    /**
     * Method to return all variables that are used constraints.
     * @return Set of {@link ReasonerVariable}.
     */
    public Set<ReasonerVariable> getVariablesUsedInConstraints() {
        return variablesInConstraints;
    } 
    
    
    /**
     * Checks whether all variables has been assigned. <br />
     * <ul>
     * <li>If {@link AttributeValues} were passed to the reasoning model, then this method checks whether all
     *     variables with an attribute assignment as specified in the {@link AttributeValues} have been assigned.
     *     In this case, all variables without a attribute will also be checked whether they are configured.</li>
     * <li>If no {@link AttributeValues} where passed to this model, it will check whether all variables
     *     have been configured.</li>
     * </ul>
     * @return <tt>true</tt> if all (relevant) variables has been configured, <tt>false</tt> otherwise.
     * @see #hasAttributes()
     */
    public boolean isFullyConfigured() {
        boolean fullyConfigured = true;
        
        // Determine whether all variables or only attributed variables should be checked.
        Iterator<ReasonerVariable> variablesIterator = null;
        if (hasAttributes()) {
            variablesIterator = variablesOfCurrentView.iterator();
        } else {
            variablesIterator = variables.values().iterator();
        }
        
        // Check whether all relevant variables are configured completely
        while (variablesIterator.hasNext() && fullyConfigured) {
            ReasonerVariable variable = variablesIterator.next();
            fullyConfigured = variable.getReasoningState() != ReasoningState.UNASSIGNED;
        }
        
        return fullyConfigured;
    }
    
    /**
     * Returns a translated {@link ReasonerDatatype} for the given name.
     * @param name The name of the origin {@link de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype},
     *     which should be returned.
     * @return The translated {@link ReasonerDatatype} or
     *     <tt>null</tt> if no {@link ReasonerDatatype} exists with the given name.
     */
    public ReasonerDatatype getDatatype(String name) {
        return customTypes.get(name);
    }

    @Override
    public ConstraintSyntaxTree getConstraint(int index) {
        return constraints.getConstraint(index);
    }

    @Override
    public ModelElement getConflictingElement(int index) {
        return constraints.getConflictingElement(index);
    }

    @Override
    public Set<ReasonerVariable> getVariablesOfNormalConstraint(int index) {
        return constraints.getVariablesOfNormalConstraint(index);
    }
    
    /**
     * Returns a list containing only {@link CompoundType}s, containing constraints.
     * @return A list of constrained {@link CompoundType}s, maybe empty.
     */
    public List<CompoundType> getConstrainedCompounds() {
        CompoundFinder finder = new CompoundFinder(customTypes.values());
        return finder.getConstrainedCompounds();
    }
    
    /**
     * Method to get not nested variables of the compound that are used in constraints of that compound.
     * @param varSet Compound
     * @return Set of variables.
     */
    public Set<ReasonerVariable> getCompoundNotNestedVariablesFromConstraints(String varSet) {        
        return variablesInCompounds.get(varSet);
    }

    @Override
    public int getNormalConstraintCount() {
        return constraints.getNormalConstraintCount();
    }

    @Override
    public ConstraintSyntaxTree getNormalConstraint(int index) {
        return constraints.getNormalConstraint(index);
    }

    @Override
    public Set<ReasonerVariable> getVariablesOfInternalConstraint(int index) {
        return constraints.getVariablesOfInternalConstraint(index);
    }

    @Override
    public Set<ReasonerVariable> getVariablesOfConstraint(int index) {
        return constraints.getVariablesOfConstraint(index);
    }

    @Override
    public int getConstraintCount() {
        return constraints.getConstraintCount();
    }
    
    /**
     * Method for adding a propagated variable to the list of propagated variables.
     * @param variable Variable that was propagated.
     */
    public void addPropagatedVariable(ReasonerVariable variable) {
        propagatedVariables.add(variable.getDecisionVariable());
    }
    
    /**
     * Method for retrieving the overall number of propagated variables.
     * @return Number of propagated variables.
     */
    public int getCountPropagatedVariables() {
        return propagatedVariables.size();
    }
    
    /**
     * Method for retrieving a specific propagated variable from the propagated variable list.
     * @param index Number of propagated variable.
     * @return Propagated variable.
     */
    public IDecisionVariable getPropagatedVariable(int index) {
        return propagatedVariables.get(index);
    }
    
    /**
     * Method for returning reasoningID.
     * @return ID of an individual reasoning process.
     */
    public String getReasoningID() {
        return reasoningID;
    }
    
    /**
     * Method for adding a {@link ConstraintVariable} to the list.
     * @param cstVar {@link ConstraintVariable} to be added.
     */
    public void addConstraintVariable(ConstraintVariable cstVar) {
        constraintVariables.add(cstVar);
    }
}
