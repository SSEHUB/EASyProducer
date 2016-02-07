/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.model.confModel;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.confModel.ConfigurationInitializerRegistry.IConfigurationInitializer;
import de.uni_hildesheim.sse.model.cstEvaluation.FreezeEvaluator;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.ICollectionElementVariable;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IProjectListener;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.rewrite.ProjectRewriteVisitor;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.FrozenCompoundConstraintsOmitter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.FrozenConstraintVarFilter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.FrozenConstraintsFilter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.FrozenTypeDefResolver;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.ModelElementFilter;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.IModelProcessingListener.Type;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Represents a configuration, i.e. a set of decision variables.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 * @author Marcel Lueder
 */
public class Configuration implements IConfigurationVisitable, IProjectListener, Iterable<IDecisionVariable>, 
    IConfigurationElement, IConfiguration {

    /**
     * Defines the default initializer for configurations. This is used as a default value by 
     * {@link ConfigurationInitializerRegistry}. Shall be redefined by an appropriate reasoner.
     */
    static final IConfigurationInitializer DEFAULT_INITIALIZER = new IConfigurationInitializer() {
        
        @Override
        public List<Message> initializeConfiguration(Configuration config, ProgressObserver observer) {
            AssignmentResolver resolver = new AssignmentResolver(config);
            resolver.resolve();
            // TODO freezing shall be done incrementally by the Reasoner, currently freeze-state would not work
            // Assign frozen state to already frozen variables
            config.freezeValues(config.project, FilterType.ALL);
            return null; // no messages so far
        }
    };

    /**
     * The origin project, where this configuration belongs to.
     */
    private Project project;
    
    private boolean assignValues;
    
    private LinkedHashMap<AbstractVariable, IDecisionVariable> decisions
        = new LinkedHashMap<AbstractVariable, IDecisionVariable>();
    
    private List<IConfigurationChangeListener> listeners;
    
    private Map<IDatatype, Map<IDecisionVariable, ReferenceValue>> allInstances;
    
    private IAssignmentState resolutionState = AssignmentState.DERIVED;
    
    /**
     * Creates a new configuration for the given project.
     * 
     * @param project The project, where this configuration belongs to.
     * This project should already be registered at the VarModel
     * @see de.uni_hildesheim.sse.utils.modelManagement.ModelManagement
     * #updateModel(de.uni_hildesheim.sse.utils.modelManagement.IModel, java.net.URI)
     */
    public Configuration(Project project) {
        this(project, true, AssignmentState.DERIVED);
    }

    /**
     * Creates a new configuration for the given project with explicit resolution state.
     * This project should already be registered at the VarModel
     * {@link de.uni_hildesheim.sse.utils.modelManagement.ModelManagement
     * #updateModel(de.uni_hildesheim.sse.utils.modelManagement.IModel, java.net.URI)}.
     * 
     * @param project The project, where this configuration belongs to.
     * @param resolutionState the resolution state for the assignment resolver
     */
    public Configuration(Project project, IAssignmentState resolutionState) {
        this(project, true, resolutionState);
    }

    /**
     * Copies a <code>configuration</code> by taking over its defined values and assignment states.
     * 
     * @param configuration the configuration to be copied
     */
    public Configuration(Configuration configuration) {
        this.project = configuration.getProject();
        this.resolutionState = configuration.getResolutionState();
        VarModel.INSTANCE.events().addModelListener(project, this);
        listeners = new ArrayList<IConfigurationChangeListener>();
        if (null != project) {
            createVariables();
            for (Map.Entry<AbstractVariable, IDecisionVariable> entry : configuration.decisions.entrySet()) {
                IDecisionVariable newVar = getDecision(entry.getKey());
                if (null != newVar) {
                    IDecisionVariable oldVar = entry.getValue();
                    Value value = oldVar.getValue();
                    if (null != value) {
                        value = value.clone();
                    }
                    try {
                        newVar.setValue(value, oldVar.getState());
                    } catch (ConfigurationException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(Configuration.class, Bundle.ID).exception(e);
                    }
                } // shall not occur
            }
        }
    }

    /**
     * Alternative constructor to avoid initial value assignment by {@link AssignmentResolver}. If activated, the 
     * {@link AssignmentResolver} will work with {@link AssignmentState#DERIVED}.
     * 
     * @param project to get {@link Configuration} from.
     * @param assignValues Decision if values should be assigned by {@link AssignmentResolver}.
     */
    public Configuration(Project project, boolean assignValues) {
        this(project, assignValues, AssignmentState.DERIVED); // following the new convention
    }
    
    /**
     * Alternative constructor to avoid initial value assignment by {@link AssignmentResolver}.
     * 
     * @param project to get {@link Configuration} from.
     * @param assignValues Decision if values should be assigned by {@link AssignmentResolver}.
     * @param resolutionState the resolution state for the assignment resolver
     */
    public Configuration(Project project, boolean assignValues, IAssignmentState resolutionState) {
        this.project = project;
        this.assignValues = assignValues;
        this.resolutionState = resolutionState;
        VarModel.INSTANCE.events().addModelListener(project, this);
        listeners = new ArrayList<IConfigurationChangeListener>();
        init();
    }
    
    /**
     * Returns the assignment state to be used when assigning values in the configuration.
     * 
     * @return the resolution state
     */
    public IAssignmentState getResolutionState() {
        return resolutionState;
    }
    
    /**
     * Returns the related project.
     * 
     * @return the related project
     */
    public Project getProject() {
        return project;
    }
    
    /**
     * Returns the saved ({@link AbstractVariable}, {@link IDecisionVariable}) mapping.
     * @return A flat copy of the stored ({@link AbstractVariable}, {@link IDecisionVariable}) mappings.
     */
    @SuppressWarnings("unchecked")
    Map<AbstractVariable, IDecisionVariable> getConfiguredDecisions() {
        return (Map<AbstractVariable, IDecisionVariable>) decisions.clone();
    }
    
    /**
     * Registers a new listener.
     * @param listener A Listener which should be informed in case of changes.
     */
    public void register(IConfigurationChangeListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Unregisters an listener.
     * @param listener The listener which should be unregistered.
     * @return <tt>true</tt> if this configuration contained the specified listener
     */
    public boolean unregister(IConfigurationChangeListener listener) {
        return listeners.remove(listener);
    }
    
    /**
     * Returns the related model information instance.
     * 
     * @return the model information instance
     */
    private ModelInfo<Project> getModelInfo() {
        return VarModel.INSTANCE.availableModels().getModelInfo(project);
    }
    
    /**
     * This method creates the list of {@link IDecisionVariable}s
     * with initial value settings based on the given project. 
     */
    private void init() {     
        if (null != project) {
            ModelInfo<Project> info = getModelInfo();
            VarModel.INSTANCE.events().notifyModelProcessing(info, true, Type.INITIALIZING);

            VarModel.INSTANCE.resolveImports(project, null, null);
            //Loop adding the declarations to a list
            createVariables();            
            
            if (assignValues) {
                IConfigurationInitializer init = ConfigurationInitializerRegistry.getInitializer();
                if (null == init) {
                    EASyLoggerFactory.INSTANCE.getLogger(Configuration.class, Bundle.ID).error(
                        "No configuration initializer available");
                } else {
                    String msg = Message.toString(
                        init.initializeConfiguration(this, ProgressObserver.NO_OBSERVER), Status.ERROR);
                    if (msg.length() > 0) {
                        EASyLoggerFactory.INSTANCE.getLogger(Configuration.class, Bundle.ID).error(msg);
                    }
                }
                /* -> DEFAULT_INITIALIZER
                AssignmentResolver resolver = new AssignmentResolver(this);
                resolver.resolve();
                
                // TODO freezing shall be done incrementally by the Reasoner, currently freeze-state would not work
                // Assign frozen state to already frozen variables
                freezeValues(project, FilterType.ALL);*/
            }
            
            VarModel.INSTANCE.events().notifyModelProcessing(info, false, Type.INITIALIZING);
        }
    }

    /**
     * This method looks for all {@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration}s inside
     * the related projects, creates {@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration}s and adds
     * them to this configuration.
     * While creating these {@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration}s this method also
     * tries assign the specified default values to the newly created
     * {@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration}s.
     */
    private void createVariables() {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, null);
        List<AbstractVariable> topLevelDeclarations = finder.getVariableDeclarations(VisibilityType.ONLY_EXPORTED);
        addVariables(topLevelDeclarations, true);
        topLevelDeclarations = finder.getVariableDeclarations(VisibilityType.ONLY_HIDDEN);       
        addVariables(topLevelDeclarations, false);
    }

    /**
     * Creates {@link IDecisionVariable}s for all given {@link AbstractVariable}s and adds them to the configuration.
     * Part of the {@link #createVariables()} method and should only be called from this method.
     * @param topLevelDeclarations The variables to add.
     * @param visible indicates whether the variable is visible to the user:
     * <ul>
     * <li><tt>true</tt>: The variable is visible by the user and can be displayed in the GUI and so on.</li> 
     * <li><tt>false</tt>: The variable is not visible by the user but must be considered in reasoning, instantiation,
     * and so on.</li> 
     * </ul>
     */
    private void addVariables(List<AbstractVariable> topLevelDeclarations, boolean visible) {
        for (int i = 0; i < topLevelDeclarations.size(); i++) {
            AbstractVariable declaration = topLevelDeclarations.get(i);
            
            try {
                createDecision(declaration, visible);
            } catch (ConfigurationException e) {
                // TODO SE: Check whether we must throw this exception
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a visible decision in this configuration. The declaration must be on top-level and not created before.
     * 
     * @param decl the declaration to create the decision for
     * @return the created decision variable, may be <b>null</b> if the conditions are not met
     * @throws ConfigurationException in case that creating the variable failed
     */
    public IDecisionVariable createDecision(AbstractVariable decl) throws ConfigurationException {
        // we need dynamic modification capabilities!
        IDecisionVariable result = null;
        if (decl.getParent() instanceof Project && null == getDecision(decl)) {
            result = createDecision(decl, true);
        }
        return result;
    }

    /**
     * Creates a decision in this configuration. 
     * 
     * @param decl the declaration to create the decision for
     * @param visible whether the variable shall be visible
     * @return the created decision variable
     * @throws ConfigurationException in case that creating the variable failed
     */
    private IDecisionVariable createDecision(AbstractVariable decl, boolean visible) throws ConfigurationException {
        VariableCreator creator = new VariableCreator(decl, this, visible, false);
        IDecisionVariable variable = creator.getVariable();
        addDecision(variable);
        if (null != allInstances) {
            allInstances.remove(decl.getType()); // or in future... add to instances
        }
        return variable;
    }
    
    /**
     * Sets {@link AssignmentState#FROZEN} state to already frozen variables. 
     * 
     * @param project the project to be frozen
     * @param filter the filter type
     */
    public void freezeValues(Project project, FilterType filter) {
        FrozenElementsFinder finder = new FrozenElementsFinder(project, filter);
        List<IFreezable> frozenElements = finder.getFrozenElements();
        
        FreezeEvaluator selector = new FreezeEvaluator(this);
        for (int i = 0; i < frozenElements.size(); i++) {
            IFreezable frozenElement = frozenElements.get(i);
            selector.setFreeze(finder.getFreezeBlock(frozenElement));
            if (frozenElement instanceof AbstractVariable) {
                freezeValues((AbstractVariable) frozenElement, selector);
            } else if (frozenElement instanceof Project) {
                Project prj = (Project) frozenElement;
                for (int e = 0; e < prj.getElementCount(); e++) {
                    ContainableModelElement elt = prj.getElement(e);
                    if (elt instanceof AbstractVariable) {
                        freezeValues((AbstractVariable) elt, selector);
                    }
                }
            }
        }
    }
    
    /**
     * Sets {@link AssignmentState#FROZEN} state to the given variables <code>var</code>. 
     * 
     * @param var the variable to be frozen
     * @param selector the freeze selector
     */
    private void freezeValues(AbstractVariable var, IFreezeSelector selector) {
        if (var.isTopLevel() || var.getParent() instanceof AttributeAssignment) {
            IDecisionVariable frozenVariable = getDecision(var);
            frozenVariable.freeze(selector);
        } else {
            IModelElement parent = var.getParent();
            System.out.println("Config freeze for nested variable not implemented: " + parent);
            //TODO SE: Handle nested Variables.
            //DecisionVariableDeclaration parent = (DecisionVariableDeclaration) frozenElement.getParent();
            //freezeNestedVariable(parent, frozenElement);
        }
    }
    
    /**
     * This method calls atm only the init() Method.
     */
    public void refresh() {
        ModelInfo<Project> info = getModelInfo();
        VarModel.INSTANCE.events().notifyModelProcessing(info, true, Type.REFRESHING);

        //clean list... bad implemented just for testing
        decisions.clear();
        allInstances = null;
        init();
        //maybe keep old values
        
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).configurationRefreshed(this);
        }

        VarModel.INSTANCE.events().notifyModelProcessing(info, false, Type.REFRESHING);
    }
    
    /**
     * Adda a decision.
     * 
     * @param variable the decision to be added
     */
    //Make this method private in future.
    private void addDecision(IDecisionVariable variable) {
        decisions.put(variable.getDeclaration(), variable);
    }
    
    /**
     * Returns the number of decisions.
     * 
     * @return the number of decisions
     */
    public int getDecisionCount() {
        return decisions.size();
    }
    
    @Override
    public IDecisionVariable getDecision(AbstractVariable declaration) {
        IDecisionVariable result = decisions.get(declaration);
        if (null == result && declaration instanceof ICollectionElementVariable) {
            ICollectionElementVariable var = (ICollectionElementVariable) declaration;
            result = decisions.get(var.getBaseVariable());
            if (null != result) {
                result = result.getNestedElement(var.getIndex());
            }
        }
        return result;
    }
    
    /**
     * Returns an iterator for iterating over all stored {@link IDecisionVariable}s.
     * @return an <tt>Iterator</tt> over the {@link IDecisionVariable} in this configuration.
     */
    public Iterator<IDecisionVariable> iterator() {
        Collection<IDecisionVariable> variableCollection = decisions.values();
        return variableCollection.iterator();
    }
    
    /**
     * Clears all decisions.
     */
    public void clear() {
        decisions.clear();
        allInstances = null;
    }

    /**
     * Remove a specific decision.
     * 
     * @param variable the decision to be removed
     * @return <code>true</code> if this operation was successful, <code>false</code> else
     */
    public boolean removeDecision(IDecisionVariable variable) {
        boolean containsKey = decisions.containsKey(variable.getDeclaration());
        decisions.remove(variable.getDeclaration());
        if (null != allInstances) {
            removeFromAllInstances(variable);
        }
        return containsKey;
    }
    
    /**
     * Removes <code>variable</code> from all instances.
     * 
     * @param variable the variable to be removed
     */
    private void removeFromAllInstances(IDecisionVariable variable) {
        Map<IDecisionVariable, ReferenceValue> inst = allInstances.get(variable.getDeclaration().getType());
        if (null != inst) {
            inst.remove(variable);
        }
    }
    
    /**
     * Returns the name of the configuration.
     * 
     * @return the name of the configuration
     */
    public String getName() {
        return project.getName();
    }
    
    @Override
    public void accept(IConfigurationVisitor visitor) {
        visitor.visitConfiguration(this);
    }

    @Override
    public void notifyReplaced(Project oldProject, Project newProject) {
        this.project = newProject;
        refresh();
    }
    
    /**
     * Turns this configuration into a project, e.g. for writing.
     * 
     * @param ownProject return an own project (<code>true</code>) or add the 
     *   configuration to {@link #project} (<code>false</code>)
     * @return the project or <b>null</b> if not implemented (default)
     * @throws ConfigurationException in case of any configuration errors
     */
    public Project toProject(boolean ownProject) throws ConfigurationException {
        return this.toProject(ownProject, true);
    }
    
    /**
     * Turns this configuration into a project, e.g. for writing.
     * 
     * @param ownProject return an own project (<code>true</code>) or add the 
     *   configuration to {@link #project} (<code>false</code>)
     * @param onlyUserInput Specifies whether only user Input should be stored:
     *     <ul>
     *     <li><tt>true:</tt> Assignments in state {@link AssignmentState#ASSIGNED} and {@link AssignmentState#FROZEN}
     *         will be saved.</li>
     *     <li><tt>false: Assignments in state {@link AssignmentState#ASSIGNED}, {@link AssignmentState#FROZEN}, and
     *         {@link AssignmentState#DERIVED} will be saved (i.e. also computed values).</tt></li>
     *     </ul>
     * @return the project or <b>null</b> if not implemented (default)
     * @throws ConfigurationException in case of any configuration errors
     */
    public Project toProject(boolean ownProject, boolean onlyUserInput) throws ConfigurationException {
        ConfigurationSaver saver = new ConfigurationSaver(this, ownProject, onlyUserInput);
        return saver.getSavedConfiguration();
    }
    
    @Override
    public final Configuration getConfiguration() {
        return this;
    }
    
    @Override
    public IConfigurationElement getParent() {
        return null;
    }
    
    /**
     * Notifies all registered {@link IConfigurationChangeListener}s that a {@link IDecisionVariable} changed.
     * 
     * @param var the {@link IDecisionVariable} which changed. This {@link IDecisionVariable}
     * should be part of this configuration (No validation).
     * @param oldValue the old value before the change, <code>var</code> then contains the new value
     */
    void variableChanged(IDecisionVariable var, Value oldValue) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).itemChanged(this, var, oldValue);
        }
        if (null != allInstances) {
            IDatatype type = var.getDeclaration().getType();
            Map<IDecisionVariable, ReferenceValue> instances = allInstances.get(type);
            if (null != instances && !instances.containsKey(var)) {
                Reference rType = new Reference("", type, project);
                try {
                    instances.put(var, (ReferenceValue) ValueFactory.createValue(rType, var));
                } catch (ValueDoesNotMatchTypeException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                }
            }
        }
    }
    
    /**
     * Notifies all registered {@link IConfigurationChangeListener}s
     * that a {@link IDecisionVariable} has changed its state.
     * 
     * @param var the {@link IDecisionVariable} which changed. This {@link IDecisionVariable}
     * should be part of this configuration (No validation).
     */
    void variableChangedState(IDecisionVariable var) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).stateChanged(this, var);
        }
    }
    
    /**
     * Adds an attribute decision to this configuration. This method is a specific functionality for user interaction. 
     * Subclass this class and make it accessible if needed, otherwise it may break the value protection provided
     * by this class. 
     * 
     * @param attribute the attribute for which the decision shall be created
     * @param value the value of the attribute (may be <b>null</b>)
     * @param state the assignment state
     * @throws ConfigurationException in case of type conflicts
     */
    protected void addAttributeDecision(Attribute attribute, Value value, IAssignmentState state) 
        throws ConfigurationException {
        VariableCreator creator = new VariableCreator(attribute, this, true, false);
        IDecisionVariable var = creator.getVariable();
        var.setValue(value, state);
        decisions.put(attribute, var);
    }

    @Override
    public boolean isNested() {
        return false;
    }

    @Override
    public IAssignmentState getState() {
        return null;
    }
    
    @Override
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested) 
        throws ConfigurationException {
        throw new ConfigurationException(getConfiguration(), "operation not supported", 
            ConfigurationException.INTERNAL);
    }
    
    /**
     * Returns the declaration of the variable.
     * 
     * @return the declaration of the decision variable
     */
    public AbstractVariable getDeclaration() {
        return null;
    }

    /**
     * Freezes on the whole configuration.
     * 
     * @param selector the selector deciding what to freeze
     */
    public void freeze(IFreezeSelector selector) {
        for (IDecisionVariable variable : decisions.values()) {
            variable.freeze(selector);
        }
    }

    /**
     * Unfreezes the whole configuration.
     * 
     * @param state the target state after unfreezing (must not be {@link AssignmentState#FROZEN})
     */
    public void unfreeze(IAssignmentState state) {
        for (IDecisionVariable variable : decisions.values()) {
            variable.unfreeze(state);
        }
    }
    
    /**
     * Freezes a single variable (must be a top layer element).
     * @param nestedElement The name of the top layer variable.
     */
    public void freeze(String nestedElement) {
        for (IDecisionVariable nestedVariable : decisions.values()) {
            if (nestedVariable.getDeclaration().getName().equals(nestedElement)) {
                nestedVariable.freeze(AllFreezeSelector.INSTANCE); // preliminary
            }
        }
    }
    
    /**
     * Dereferences a variable.
     * 
     * @param var the variable to be dereferenced (may be <b>null</b>)
     * @return the dereferenced variable (<b>null</b> if <code>var</code> was <b>null</b>)
     */
    public static IDecisionVariable dereference(IDecisionVariable var) {
        if (null != var) {
            IDatatype type = var.getDeclaration().getType();
            while (type instanceof Reference) {
                type = ((Reference) type).getType();
                Value value = var.getValue();
                if (null != value && value != NullValue.INSTANCE) {
                    AbstractVariable refDecl = ((ReferenceValue) var.getValue()).getValue();
                    if (null != refDecl) {
                        var = var.getConfiguration().getDecision(refDecl);
                    } // TODO valueEx
                } else {
                    break;
                }
            }
        }
        return var;
    }

    /**
     * Returns all instances of the given type.
     * 
     * @param type the type to look for
     * @return all instances of <code>var</code>, may be <b>null</b> if the instances cannot be retrieved, e.g., in 
     *    case of an integer variable
     */
    public Value getAllInstances(IDatatype type) {
        if (null == allInstances) {
            allInstances = new LinkedHashMap<IDatatype, Map<IDecisionVariable, ReferenceValue>>();
        }
        // we need references to variables here in order to allow compound access and modification of variables 
        // in self-constraints
        Map<IDecisionVariable, ReferenceValue> instances = allInstances.get(type);
        Reference rType = new Reference("", type, project);
        if (null == instances && Compound.TYPE.isAssignableFrom(type)) { // check type restriction
            instances = new HashMap<IDecisionVariable, ReferenceValue>();
            allInstances.put(type, instances);
            for (IDecisionVariable var : decisions.values()) {
                if (TypeQueries.sameTypes(type, var.getDeclaration().getType())) {
                    try {
                        instances.put(var, (ReferenceValue) ValueFactory.createValue(rType, var.getDeclaration()));
                    } catch (ValueDoesNotMatchTypeException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Value result;
        Set setType = new Set(type.getName() + "Instances", rType, null);
        try {
            result = ValueFactory.createValue(setType, null == instances ? null : instances.values().toArray());
        } catch (ValueDoesNotMatchTypeException e) {
            result = null;
        }
        return result;
    }

    /**
     * Maps a variable to its configuration following nested elements up and down.
     * 
     * @param var the variable to be mapped
     * @param cfg the configuration containing the top-level variables
     * @return the mapped variable, <b>null</b> if there is no mapping
     */
    public static IDecisionVariable mapVariable(IDecisionVariable var, Configuration cfg) {
        IDecisionVariable result = null;
        if (var.getParent() instanceof IDecisionVariable) {
            IDecisionVariable par = mapVariable((IDecisionVariable) var.getParent(), cfg);
            if (null != par) {
                AbstractVariable decl = var.getDeclaration();
                for (int p = 0; null == result && p < par.getNestedElementsCount(); p++) {
                    IDecisionVariable nested = par.getNestedElement(p);
                    if (nested.getDeclaration().equals(decl)) {
                        result = nested;
                    }
                }
            }
        } else { // assume top-level
            result = cfg.getDecision(var.getDeclaration());
        } 
        return result;
    }

    /**
     * Returns the instance name of a decision variable. This name is composed 
     * from the names of the given variable and its parent variables. Please note
     * that the instance name is typically different from the qualified name of 
     * the declaration, which, in case of compound slots, leads to the variable
     * in the compound definition. The result is unqualified regarding the top-level
     * variable.
     * 
     * @param var the variable to return the name for (may be <b>null</b>)
     * @return the instance name (may be empty if <code>var == <b>null</b></code>
     */
    public static String getInstanceName(IDecisionVariable var) {
        return getInstanceName(var, false);
    }
    
    /**
     * Returns the instance name of a decision variable. This name is composed 
     * from the names of the given variable and its parent variables. Please note
     * that the instance name is typically different from the qualified name of 
     * the declaration, which, in case of compound slots, leads to the variable
     * in the compound definition.
     * 
     * @param var the variable to return the name for (may be <b>null</b>)
     * @param qualified whether the name of the top-level variable shall be qualified
     * @return the instance name (may be empty if <code>var == <b>null</b></code>
     */
    public static String getInstanceName(IDecisionVariable var, boolean qualified) {
        String result = "";
        IConfigurationElement iter = var;
        while (null != iter) {
            if (iter instanceof IDecisionVariable) {
                IDecisionVariable decVar = (IDecisionVariable) iter;
                if (result.length() > 0) {
                    result = "::" + result;
                }
                String name;
                if (qualified && !(iter.getParent() instanceof IDecisionVariable)) {
                    name = decVar.getDeclaration().getQualifiedName();
                } else {
                    name = decVar.getDeclaration().getName();
                }
                result = name + result;
            }
            iter = iter.getParent();
        }
        return result;
    }
    
    /**
     * Returns whether two decision variables are equal via their instance name.
     * Please note that this method is faster and less resource consuming than comparing the respective results of 
     * {@link #getInstanceName(IDecisionVariable)} as it compares the individual names
     * rather than composing the full name and performing the comparison then.
     * 
     * @param var1 the first variable to be compared (may be <b>null</b>)
     * @param var2 the second variable to be compared (may be <b>null</b>)
     * @return <code>true</code> if the variables are equal by their instance name, <code>false</code>
     *   if they are not equal, in particular if one is <b>null</b>
     */
    public static boolean equalsByInstanceName(IDecisionVariable var1, IDecisionVariable var2) {
        boolean equals;
        if (var1 != null && var2 != null) {
            equals = true;
            IConfigurationElement iter1 = var1;
            IConfigurationElement iter2 = var2;
            do {
                if (!iter1.getDeclaration().getName().equals(iter2.getDeclaration().getName())) {
                    equals = false;
                    break;
                }
                iter1 = iter1.getParent();
                iter2 = iter2.getParent();
            } while (iter1 instanceof IDecisionVariable && iter2 instanceof IDecisionVariable);
        } else {
            equals = false;
        }
        return equals;
    }
    
    /**
     * Prints a configuration to <code>out</code>. [debugging]
     * 
     * @param out the output stream
     * @param cfg the configuration to print
     */
    public static void printConfig(PrintStream out, Configuration cfg) {
        // -> toString???
        Iterator<IDecisionVariable> iter = cfg.iterator();
        while (iter.hasNext()) {
            IDecisionVariable var = iter.next();
            printVariable(out, var, "");
        }
    }
    
    /**
     * Prints a variable to <code>out</code>. [debugging]
     * 
     * @param out the output stream
     * @param var the variable to print
     * @param indent the indentation
     */
    private static void printVariable(PrintStream out, IDecisionVariable var, String indent) {
        out.println(indent + var.getDeclaration().getName() + " = " + var.getValue() + " STATE " + var.getState());
        for (int i = 0; i < var.getNestedElementsCount(); i++) {
            printVariable(out, var.getNestedElement(i), indent + " ");
        }
    }
    
    /**
     * Removes all by a reasoner propagated values from the configuration to clean it up.
     */
    public void removeDerivedValues() {
        boolean changed = false;
        for (IDecisionVariable variable : decisions.values()) {
            changed &= variable.removeDerivedValues();
        }
        
        if (changed) {
            // Inform with each change would be more precise, but should also more complex
            for (int i = 0, n = listeners.size(); i < n; i++) {
                listeners.get(i).configurationRefreshed(this);
            }
        }
    }

    /**
     * Reduces the underlying {@link Project} and removes elements which are not needed for a runtime reasoning,
     * e.g., constraints containing only frozen variables or comments.<br/>
     * <b><font color="red">Attention:</font></b> This method creates a modified, shallow copy of the visited project.
     * Thus, the original project becomes invalid through this visitation. This visitor should only be used if the
     * original is no longer needed, e.g., for performance tweaks in a automated setup which does not save any data.
     * <br/>
     * <b>FIXME SE:</b> Create a deep copy if a real copy mechanism is needed.
     */
    public void prune() {
        VarModel.INSTANCE.events().removeModelListener(project, this);
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(project, FilterType.ALL);
        rewriter.addModelCopyModifier(new ModelElementFilter(Comment.class));
        rewriter.addModelCopyModifier(new FrozenConstraintsFilter(this));
        rewriter.addModelCopyModifier(new FrozenTypeDefResolver(this));
        rewriter.addModelCopyModifier(new FrozenConstraintVarFilter(this));
        rewriter.addModelCopyModifier(new FrozenCompoundConstraintsOmitter(this));
        project.accept(rewriter);
        project = rewriter.getCopyiedProject();
    }
    
    /**
     * Returns an element for <code>base</code> specified by its name. This method is not recursive!
     * 
     * @param base the base variable to search on (may be <b>null</b>)
     * @param name the name of the nested element
     * @return the nested element (may be <b>null</b> if not found or <code>base</code> is <b>null</b>)
     */
    public static IDecisionVariable getNestedElement(IDecisionVariable base, String name) {
        IDecisionVariable result = null;
        if (null != base) {
            for (int n = 0, c = base.getNestedElementsCount(); null == result && n < c; n++) {
                IDecisionVariable nested = base.getNestedElement(n);
                if (name.equals(nested.getDeclaration().getName())) {
                    result = nested;
                }
            }
        }
        return result;        
    }
    
    /**
     * Dereferences a value.
     * 
     * @param conf the configuration access
     * @param value the value to be dereferenced
     * @return the dereferenced value
     */
    public static Value dereference(IConfiguration conf, Value value) {
        while (value instanceof ReferenceValue) {
            IDecisionVariable var = conf.getDecision(((ReferenceValue) value).getValue());
            if (null != var) {
                value = var.getValue();
            }
        }
        return value;
    }    

}
