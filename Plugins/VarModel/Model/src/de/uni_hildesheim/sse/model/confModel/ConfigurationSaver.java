/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ExpressionVersionRestriction;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintSeparator;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FreezeBlockFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * This method is part of the configuration and responsible for saving the values of the configuration
 * inside the {@link Configuration#toProject(boolean)} method. The visibility of this class has been relaxed 
 * in order to serve as basis for refinements.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class ConfigurationSaver {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ConfigurationSaver.class, Bundle.ID);

    /**
     * this configuration, which should be saved.
     */
    private Configuration srcConfiguration;
    
    /**
     * The destination project where the information of the configuration should be stored to.
     */
    private Project destProject;
    
    /**
     * Specifies whether only user Input should be stored:
     * <ul>
     * <li><tt>true:</tt> Assignments in state {@link AssignmentState#ASSIGNED} and {@link AssignmentState#FROZEN}
     *     will be saved.</li>
     * <li><tt>false: Assignments in state {@link AssignmentState#ASSIGNED}, {@link AssignmentState#FROZEN}, and
     *     {@link AssignmentState#DERIVED} will be saved (i.e. also computed values).</tt></li>
     * </ul>
     */
    private boolean onlyUserInput;
    
    /**
     * Default constructor for this class. This Constructor will save only user input.
     * @param srcConfiguration The configuration which should be saved.
     * @param ownProject return an own project (<code>true</code>) or add the 
     *   configuration to {@link Configuration#getProject()} (<code>false</code>)
     * @throws ConfigurationException in case of any configuration errors
     * @see #ConfigurationSaver(Configuration, boolean, boolean)
     */
    ConfigurationSaver(Configuration srcConfiguration, boolean ownProject) throws ConfigurationException {
        this(srcConfiguration, ownProject, true);
    }
        
    /**
     * Constructor for this class for saving the configuration. With this constructor it is possible to decide whether
     * only user input should be saved or all configured values.
     * @param srcConfiguration The configuration which should be saved.
     * @param ownProject return an own project (<code>true</code>) or add the 
     *   configuration to {@link Configuration#getProject()} (<code>false</code>)
     * @param onlyUserInput Specifies whether only user Input should be stored:
     *     <ul>
     *     <li><tt>true:</tt> Assignments in state {@link AssignmentState#ASSIGNED} and {@link AssignmentState#FROZEN}
     *         will be saved.</li>
     *     <li><tt>false: Assignments in state {@link AssignmentState#ASSIGNED}, {@link AssignmentState#FROZEN}, and
     *         {@link AssignmentState#DERIVED} will be saved (i.e. also computed values).</tt></li>
     *     </ul>
     * @throws ConfigurationException in case of any configuration errors
     * @see #createProject(Configuration)
     * @see #addVersion(Project, Configuration)
     * @see #addImports(Project, Configuration)
     * @see #addVariables(Project, Configuration)
     */
    protected ConfigurationSaver(Configuration srcConfiguration, boolean ownProject, boolean onlyUserInput)
        throws ConfigurationException {
        
        this.srcConfiguration = srcConfiguration;
        this.onlyUserInput = onlyUserInput;
        // prepare project instance
        if (ownProject) {
            destProject = createProject(srcConfiguration);
            Version ver = srcConfiguration.getProject().getVersion();
            if (null != ver) {
                destProject.setVersion(ver);
            }
            addVersion(destProject, srcConfiguration);
            addImports(destProject, srcConfiguration);
            addAttributes(destProject, srcConfiguration);
            addLocalVariables(destProject, srcConfiguration);
        } else {
            destProject = srcConfiguration.getProject();
            removedLocalConfigChanges();
        }
        
        // transfer configuration decisions
        StringBuilder errors = new StringBuilder();
        int code = 0;
        Map<AbstractVariable, IDecisionVariable> decisions = srcConfiguration.getConfiguredDecisions();
        for (Map.Entry<AbstractVariable, IDecisionVariable> entry : decisions.entrySet()) {
            AbstractVariable varDecl = entry.getKey();
            IDecisionVariable var = entry.getValue();
            if (isSavingEnabled(destProject, var)) {
                int c = processAssignment(destProject, errors, varDecl, var, var.getValue());
                if (0 == code) {
                    code = c;
                }
                for (int a = 0; a < var.getAttributesCount(); a++) {
                    IDecisionVariable attrVar = var.getAttribute(a);
                    Value value = attrVar.getValue();
                    if (null != value) {
                        c = processAssignment(destProject, errors, attrVar.getDeclaration(), attrVar, value);
                        if (0 == code) {
                            code = c;
                        }
                    }
                }
            }
        }
        
        // transfer frozen elements
        saveFreezeStates(destProject);
        
        if (errors.length() > 0) {
            throw new ConfigurationException(srcConfiguration, errors.toString(), code);
        }
    }
    
    /**
     * Returns the project where the values and frozen states are saved to.
     * @return {@link Configuration#getProject()} if the constructor was called with <tt>ownProject = false</tt>,
     * otherwise a new project which imports {@link Configuration#getProject()}.
     */
    public Project getSavedConfiguration() {
        return destProject;
    }

    /**
     * Creates the project to store the configuration into.
     * 
     * @param srcConfiguration the configuration to be stored
     * @return the project to store the configuration into
     */
    protected Project createProject(Configuration srcConfiguration) {
        return new Project(srcConfiguration.getProject().getName() + "_conf");
    }
    
    /**
     * Adds the current version to <code>destProject</code>.
     * 
     * @param destProject the destination project being set up
     * @param srcConfiguration the source configuration
     */
    protected void addVersion(Project destProject, Configuration srcConfiguration) {
        Version ver = srcConfiguration.getProject().getVersion();
        if (null != ver) {
            destProject.setVersion(ver);
        }        
    }

    /**
     * Adds the imports to <code>destProject</code>.
     * 
     * @param destProject the destination project being set up
     * @param srcConfiguration the source configuration
     */
    protected void addImports(Project destProject, Configuration srcConfiguration) {
        Version ver = srcConfiguration.getProject().getVersion();
        IVersionRestriction restrictions = null;
        if (null != ver) {
            try {
                DecisionVariableDeclaration[] vars = ExpressionVersionRestriction.createRestrictionVars(
                    srcConfiguration.getProject().getName());
                ConstraintSyntaxTree expr = ExpressionVersionRestriction.createSingleRestriction(vars[1], 
                    IvmlKeyWords.EQUALS, ver);
                restrictions = new ExpressionVersionRestriction(expr, vars[0], vars[1]);
            } catch (RestrictionEvaluationException e) {
                LOGGER.exception(e);
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            } catch (ValueDoesNotMatchTypeException e) {
                LOGGER.exception(e);
            }   
        } 
        destProject.addImport(
            new ProjectImport(srcConfiguration.getProject().getName(), null, false, false, restrictions));
    }

    /**
     * Adds local variables to <code>destProject</code>.
     * 
     * @param destProject the destination project being set up
     * @param srcConfiguration the source configuration
     */
    protected void addLocalVariables(Project destProject, Configuration srcConfiguration) {
    }

    /**
     * Adds attributes to <code>destProject</code>.
     * 
     * @param destProject the destination project being set up
     * @param srcConfiguration the source configuration
     */
    protected void addAttributes(Project destProject, Configuration srcConfiguration) {
    }
    
    /**
     * Creates an assignment constraint.
     * 
     * @param dstProject the destination project
     * @param decl the variable declaration
     * @param var the configuration variable itself
     * @param value the value assigned to <code>decl</code>
     * @return the created constraint
     */
    protected ConstraintSyntaxTree createAssignmentConstraint(Project dstProject, AbstractVariable decl, 
        IDecisionVariable var, Value value) {
        return new OCLFeatureCall(deriveOperand(decl, var), 
            OclKeyWords.ASSIGNMENT, new ConstantValue(toSaveableValue(var, value)));
    }
    
    /**
     * Returns whether saving this variable (for the destination project <code>destProject</code>) is enabled.
     * 
     * @param destProject the project being saved
     * @param var the variable to be checked
     * @return <code>true</code> if saving for <code>var</code> is enabled, <code>false</code> else
     */
    protected boolean isSavingEnabled(Project destProject, IDecisionVariable var) {
        return true;
    }
    
    /**
     * Part of the {@link Configuration#toProject(boolean)} method.
     * Removes all local configuration settings of the current project,
     * before current configuration can be merged into the project.
     */
    private void removedLocalConfigChanges() {
        //Remove only assignment constraints of this project (don't consider imported projects).
        ConstraintSeparator separator = new ConstraintSeparator(destProject, false);
        List<ContainableModelElement> assignmentConstraints = new ArrayList<ContainableModelElement>();
        assignmentConstraints.addAll(separator.getAssingmentConstraints());
        destProject.removeElements(assignmentConstraints);
        
        // Handle frozen variables
        FreezeBlockFinder finder = new FreezeBlockFinder(destProject, FilterType.NO_IMPORTS);
        List<ContainableModelElement> freezeBlocks = new ArrayList<ContainableModelElement>();
        freezeBlocks.addAll(finder.getFreezeBlocks());
        destProject.removeElements(freezeBlocks);
    }
    
    /**
     * Processes an assignment.
     * 
     * @param confProject the project to be modified as a side effect
     * @param errors the errors collected so far
     * @param decl the variable declaration
     * @param var the configuration variable itself
     * @param value the value assigned to <code>decl</code>
     * @return the new value of <code>code</code>
     */
    private int processAssignment(Project confProject, StringBuilder errors,  
        AbstractVariable decl, IDecisionVariable var, Value value) {
        int code = 0;
        
        if (null != value && AssignmentState.UNDEFINED != var.getState() && AssignmentState.DEFAULT != var.getState()) {
            // If only user input should be stored, than also ignore Derived states.
            if (!onlyUserInput || AssignmentState.DERIVED != var.getState()) {
                
                ConstraintSyntaxTree call = createAssignmentConstraint(confProject, decl, var, value);
                try {
                    confProject.add(new Constraint(call, confProject));
                } catch (CSTSemanticException e) {
                    if (0 == errors.length()) {
                        // just take the first one; not nice...
                        code = e.getCode();
                    }
                    if (errors.length() > 0) {
                        errors.append(", ");
                    }
                    errors.append(e.getMessage());
                }
            }
        }
        return code;
    }
    
    /**
     * Derives the operand expression for turning a configuration into a project.
     * 
     * @param decl the variable declaration to start at
     * @param var the related decision variable
     * @return the constraint syntax tree representing the operand for an assignment
     */
    protected ConstraintSyntaxTree deriveOperand(AbstractVariable decl, IDecisionVariable var) {
        ConstraintSyntaxTree operand = null;
        if (var.getParent() instanceof IDecisionVariable) {
            IDecisionVariable parent = (IDecisionVariable) var.getParent();
            AbstractVariable parentDecl = parent.getDeclaration();
            IDatatype parentType = parentDecl.getType();
            if (var.getDeclaration().isAttribute()) {
                Attribute attr = (Attribute) var.getDeclaration();
                if (attr.getElement() instanceof AbstractVariable) {
                    operand = new AttributeVariable(new Variable((AbstractVariable) attr.getElement()), attr);
                }
            } else if (Compound.TYPE.isAssignableFrom(parentType)) {
                operand = new CompoundAccess(deriveOperand(parentDecl, parent), decl.getName());
            } 
            // do we need specific code for sequences here?
        }
        if (null == operand) {
            operand = new Variable(decl);
        }
        return operand;
    }
    
    /**
     * This method escapes special characters for saving them into a file.
     * Should only be called inside the
     * {@link #processAssignment(Project, StringBuilder, AbstractVariable, IDecisionVariable, Value)}
     * method.
     * @param var The variable which belongs to the corresponding value (as t holds the states, which are needed for
     * filtering irrelevant values).
     * @param value The value which should be saved.
     * @return the value where all problematic characters are escaped.
     */
    protected Value toSaveableValue(IDecisionVariable var, Value value) {
        if (null != value && null != value.getValue()) {
            if (value instanceof StringValue) {
                StringValue sValue = (StringValue) value;
                String tmpValue = sValue.getValue();
                // Replace \ with \\
                tmpValue = tmpValue.replaceAll("\\\\", "\\\\\\\\");
                // Replace " with \"
                tmpValue = tmpValue.replaceAll("\\\"", "\\\\\"");
                try {
                    value = ValueFactory.createValue(StringType.TYPE, tmpValue);
                } catch (ValueDoesNotMatchTypeException e) {
                    // This exception should not occur.
                    Bundle.getLogger(ConfigurationSaver.class).exception(e);
                }
            } else if (value instanceof CompoundValue) {
                // Filter compound value/variable for user defined states and save only them
                CompoundValue cmpValue = (CompoundValue) value;
                ArrayList<Object> slotsNValues = new ArrayList<Object>();
                for (int i = 0, n = var.getNestedElementsCount(); i < n; i++) {
                    IDecisionVariable nestedVar = var.getNestedElement(i);
                    IAssignmentState nestedState = nestedVar.getState();
                    if (AssignmentState.UNDEFINED != nestedState
                        && (!onlyUserInput || (AssignmentState.DERIVED != nestedState
                        && AssignmentState.DEFAULT != nestedState))) {
                        
                        // Slot name
                        String slotName = nestedVar.getDeclaration().getName();
                        slotsNValues.add(slotName);
                        // Slot value (recursive call)
                        slotsNValues.add(toSaveableValue(nestedVar, cmpValue.getNestedValue(slotName)));
                    }
                }
                try {
                    value = ValueFactory.createValue(var.getDeclaration().getType(), slotsNValues.toArray());
                } catch (ValueDoesNotMatchTypeException e) {
                    // This exception should not occur.
                    Bundle.getLogger(ConfigurationSaver.class).exception(e);
                }
            }
        }
        
        return value;
    }
    
    /**
     * Part of the {@link Configuration#toProject(boolean)} method. This method saves the frozen state of frozen
     * variables.
     * @param confProject The project where the states should be saved to.
     * @see Configuration#toProject(boolean)
     */
    private void saveFreezeStates(Project confProject) {
        // Find (all) frozen elements
        List<IFreezable> frozenElements = new ArrayList<IFreezable>();
        for (IDecisionVariable decisionVariable : srcConfiguration) {
//            int nNestedVars = decisionVariable.getNestedElementsCount();
            if (decisionVariable.getState() == AssignmentState.FROZEN
                && decisionVariable.getDeclaration() instanceof IFreezable) {
                
                frozenElements.add((IFreezable) decisionVariable.getDeclaration());
//            } else if (nNestedVars > 0) {
//                for (int i = 0; i < nNestedVars; i++) {
//                    IDecisionVariable nestedVar = decisionVariable.getNestedElement(i);
//                    if (nestedVar.getState() == AssignmentState.FROZEN
//                        && nestedVar.getDeclaration() instanceof IFreezable) {
//                        
//                        frozenElements.add((IFreezable) nestedVar.getDeclaration());
//                    }
//                }
            }
        }
        
        // Filter elements: Only elements which are frozen in this project
        FrozenElementsFinder finder = new FrozenElementsFinder(destProject, FilterType.ONLY_IMPORTS);
        List<IFreezable> alreadyFrozenElements = finder.getFrozenElements();
        frozenElements.removeAll(alreadyFrozenElements);
        
        // Freeze elements, which are frozen in this Configuration/Project.
        if (frozenElements.size() > 0) {
            IFreezable[] freezables = new IFreezable[frozenElements.size()];
            frozenElements.toArray(freezables);
            FreezeBlock freeze = createFreezeBlock(freezables, confProject);
            confProject.add(freeze);
        }
    }
    
    /**
     * Creates a freeze block, allowing customization (factory method).
     * 
     * @param freezables the freezables
     * @param parent the parent of the freeze block
     * @return the freeze block
     */
    protected FreezeBlock createFreezeBlock(IFreezable[] freezables, Project parent) {
        return new FreezeBlock(freezables, null, null, parent);
    }
}
