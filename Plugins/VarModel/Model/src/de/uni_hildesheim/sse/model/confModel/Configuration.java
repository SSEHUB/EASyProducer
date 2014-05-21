package de.uni_hildesheim.sse.model.confModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IProjectListener;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintSeparator;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Represents a configuration, i.e. a set of decision variables.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 * @author Marcel Lueder
 */
public class Configuration implements IConfigurationVisitable, IProjectListener, Iterable<IDecisionVariable>, 
    IConfigurationElement {

    /**
     * The origin project, where this configuration belongs to.
     */
    private Project project;
    private LinkedHashMap<AbstractVariable, IDecisionVariable> decisions
        = new LinkedHashMap<AbstractVariable, IDecisionVariable>();
    
    private List<IConfigurationChangeListener> listeners;
    
    /**
     * Creates a new configuration for the given project.
     * @param project The project, where this configuration belongs to.
     * This project should already be registered at the VarModel
     * @see de.uni_hildesheim.sse.utils.modelManagement.ModelManagement
     * #updateModel(de.uni_hildesheim.sse.utils.modelManagement.IModel, java.net.URI)
     */
    public Configuration(Project project) {
        this.project = project;
        VarModel.INSTANCE.events().addModelListener(project, this);
        listeners = new ArrayList<IConfigurationChangeListener>();
        init();
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
     * This method creates the list of {@link Variable} with initial value settings based on the given project. 
     */
    private void init() {     
        if (null != project) {
        
            VarModel.INSTANCE.resolveImports(project, null, null);
            
            //Loop adding the declarations to a list
            createVariables();
            
            //Loop changing the values using assignment constraints
            assignValues();
            
            // Assign frozen state to already frozen variables
            freezeValues();
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
     * @param visible Indeicates whether the variables is visible by the user:
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
                VariableCreator creator = new VariableCreator(declaration, this, visible);
                IDecisionVariable variable = creator.getVariable();
                addDecision(variable);
            } catch (ConfigurationException e) {
                // TODO SE: Check whether we must throw this exception
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Resolves the variable for <code>opVariable</code> considering attributes.
     * 
     * @param opVariable the variable to resolve
     * @return the resolved variable or <b>null</b> if not found
     */
    private IDecisionVariable resolveVariable(AbstractVariable opVariable) {
        //TODO SE: Support Attribute assignment for whole Project, i.e. <projectname>.meta
        // currently, this works for variables but not for the project itself!
        // however, it helps me with EASy1
        IDecisionVariable variable = null;
        if (opVariable instanceof Attribute) {
            // >> this part is needed for VIL!
            IAttributableElement holder = ((Attribute) opVariable).getElement();
            IDecisionVariable holderVariable = decisions.get(holder);
            for (int a = 0; null == variable && a < holderVariable.getAttributesCount(); a++) {
                IDecisionVariable attr = holderVariable.getAttribute(a);
                if (attr.getDeclaration().getName().equals(opVariable.getName())) {
                    variable = attr;
                }
            }
        } else {
            variable = decisions.get(opVariable);    
        }
        return variable;
    }
    
    /**
     * This method searches for assignment constraints and tries to set values for the constraints.
     */
    private void assignValues() {
        //searching assignment constraints
        List<Constraint> assignConstraintList = new ConstraintSeparator(project).getAssingmentConstraints();
        for (int i = 0; i < assignConstraintList.size(); i++) {
            try {
                OCLFeatureCall oclSyntax = (OCLFeatureCall) assignConstraintList.get(i).getConsSyntax();
                //if the constraint defines a variable
                if (oclSyntax.getOperand() instanceof Variable) {
                    Variable operand = (Variable) oclSyntax.getOperand();
                    AbstractVariable opVariable = operand.getVariable();
                    IDecisionVariable variable = resolveVariable(opVariable);
                    if (null != variable) {
                        Value val = null;
                        if (Reference.TYPE.isAssignableFrom(operand.getVariable().getType())
                            && oclSyntax.getParameter(0) instanceof Variable) {
                            Variable refVariable = (Variable) oclSyntax.getParameter(0);
                            val = ValueFactory.createValue(Reference.TYPE, refVariable.getVariable());
                        } else {
                            //getting the constant value
                            ConstantValue constantValue = (ConstantValue) oclSyntax.getParameter(0);
                            val = constantValue.getConstantValue();
                        }
                        if (null != val) {
                            //assigning the constant value to the decision variable
                            variable.setValue(val, AssignmentState.ASSIGNED);
                        }
                    }
                } else if (oclSyntax.getOperand() instanceof CompoundAccess) {
                    //TODO: ML: Does not work properly..
                    new CompoundValueSetter(oclSyntax, decisions);
                }
            } catch (ConfigurationException e) {
                // TODO SE: Check whether we must throw this exception
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Sets {@link AssignmentState#FROZEN} state to already frozen variables. 
     */
    private void freezeValues() {
        FrozenElementsFinder finder = new FrozenElementsFinder(project, FilterType.ALL);
        List<IFreezable> frozenElements = finder.getFrozenElements();
        
        for (int i = 0; i < frozenElements.size(); i++) {
            IFreezable frozenElement = frozenElements.get(i);
            if (frozenElement instanceof AbstractVariable) {
                AbstractVariable var = (AbstractVariable) frozenElement;
                if (var.isTopLevel() || var.getParent() instanceof AttributeAssignment) {
                    IDecisionVariable frozenVariable = getDecision((AbstractVariable) frozenElement);
                    frozenVariable.freeze();                    
                } else {
                    IModelElement parent = frozenElement.getParent();
                    System.out.println(parent);
                    //TODO SE: Handle nested Variables.
                    //DecisionVariableDeclaration parent = (DecisionVariableDeclaration) frozenElement.getParent();
                    //freezeNestedVariable(parent, frozenElement);
                }
            }
        }
    }
    
//    /**
//     * Recursive function for freezing nested variables.
//     * @param parent The parent of the nested variable, which should be frozen
//     * @param frozenElement The nested variable, which should be frozen
//     */
//    private void freezeNestedVariable(DecisionVariableDeclaration parent, IFreezable frozenElement) {
//        if (parent.isTopLevel()) {
//            DecisionVariable variable = getDecision(parent);
//            variable.freeze(frozenElement.getName());
//        } else {
//            DecisionVariableDeclaration preParent = (DecisionVariableDeclaration) parent.getParent();
//            freezeNestedVariable(preParent, frozenElement);
//            // TODO SE: Consider complete inheritance list (more than one step)
//            // parent will currently not be considered.
//        }
//    }

    
    /**
     * This method calls atm only the init() Method.
     */
    public void refresh() {
        //clean list... bad implemented just for testing
        decisions.clear();
        init();
        //maybe keep old values
        
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).configurationRefreshed(this);
        }
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
    
    /**
     * Returns the specified {@link Variable}.
     * 
     * @param declaration The declaration for which the configuration entity should be returned.
     * @return The {@link Variable} for the given declaration
     */
    public IDecisionVariable getDecision(AbstractVariable declaration) {
        return decisions.get(declaration);
    }
    
    /**
     * Returns an iterator for iterating over all stored {@link Variable}s.
     * @return an <tt>Iterator</tt> over the {@link Variable} in this configuration.
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
        return containsKey;
    }
    
    /**
     * Returns the name of the configuration.
     * 
     * @return the name of the configuration
     */
    public String getName() {
        return project.getName();
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConfigurationVisitor visitor) {
        visitor.visitConfiguration(this);
    }

    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    public final Configuration getConfiguration() {
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public IConfigurationElement getParent() {
        return null;
    }
    
    /**
     * Notifies all registered {@link IConfigurationChangeListener}s that a {@link Variable} changed.
     * 
     * @param var the {@link Variable} which changed. This {@link Variable}
     * should be part of this configuration (No validation).
     * @param oldValue the old value before the change, <code>var</code> then contains the new value
     */
    void variableChanged(IDecisionVariable var, Value oldValue) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).itemChanged(this, var, oldValue);
        }
    }
    
    /**
     * Notifies all registered {@link IConfigurationChangeListener}s
     * that a {@link Variable} has changed its state.
     * 
     * @param var the {@link Variable} which changed. This {@link Variable}
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
        VariableCreator creator = new VariableCreator(attribute, this, true);
        IDecisionVariable var = creator.getVariable();
        var.setValue(value, state);
        decisions.put(attribute, var);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isNested() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public IAssignmentState getState() {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
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
     * Freezes the whole configuration.
     */
    public void freeze() {
        for (IDecisionVariable variable : decisions.values()) {
            variable.freeze();
        }
    }

    /**
     * Freezes a single variable (must be a top layer element).
     * @param nestedElement The name of the top layer variable.
     */
    public void freeze(String nestedElement) {
        for (IDecisionVariable nestedVariable : decisions.values()) {
            if (nestedVariable.getDeclaration().getName().equals(nestedElement)) {
                nestedVariable.freeze();
            }
        }
    }
}
