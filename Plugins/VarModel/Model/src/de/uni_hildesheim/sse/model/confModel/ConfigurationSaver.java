package de.uni_hildesheim.sse.model.confModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
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
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

/**
 * This method is part of the configuration and responsible for saving the values of the configuration
 * inside the {@link Configuration#toProject(boolean)} method.
 * @author El-Sharkawy
 *
 */
class ConfigurationSaver {
    
    /**
     * this configuration, which should be saved.
     */
    private Configuration srcConfiguration;
    
    /**
     * The destination project where the information of the configuration should be stored to.
     */
    private Project destProject;
    
    /**
     * Sole constructor for this class for saving the configuration.
     * @param srcConfiguration The configuration which should be saved.
     * @param ownProject return an own project (<code>true</code>) or add the 
     *   configuration to {@link Configuration#getProject()} (<code>false</code>)
     * @throws ConfigurationException in case of any configuration errors
     */
    ConfigurationSaver(Configuration srcConfiguration, boolean ownProject) throws ConfigurationException {
        this.srcConfiguration = srcConfiguration;
        // prepare project instance
        if (ownProject) {
            destProject = new Project(srcConfiguration.getProject().getName() + "_conf");
            Version ver = srcConfiguration.getProject().getVersion();
            VersionRestriction[] restrictions;
            if (null != ver) {
                destProject.setVersion(ver);
                restrictions = new VersionRestriction[1];
                restrictions[0] = new VersionRestriction(srcConfiguration.getProject().getName(), 
                    VersionRestriction.Operator.EQUALS, ver);
            } else {
                restrictions = null;
            }
            destProject.addImport(
                new ProjectImport(srcConfiguration.getProject().getName(), null, false, false, restrictions));
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
            int c = processAssignment(destProject, errors, varDecl, var, var.getValue());
            if (0 == code) {
                code = c;
            }
            for (int a = 0; a < varDecl.getAttributesCount(); a++) {
                Value value = null;
                ConstraintSyntaxTree cst = varDecl.getAttribute(a).getDefaultValue();
                if (cst instanceof ConstantValue) {
                    value = ((ConstantValue) cst).getConstantValue();
                }
                if (null != value) {
                    c = processAssignment(destProject, errors, varDecl.getAttribute(a), var, value);
                    if (0 == code) {
                        code = c;
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
    Project getSavedConfiguration() {
        return destProject;
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
        
        if (null != value & AssignmentState.UNDEFINED != var.getState() && AssignmentState.DEFAULT != var.getState()) {
            OCLFeatureCall call = new OCLFeatureCall(deriveOperand(decl, var), 
                OclKeyWords.ASSIGNMENT, new ConstantValue(toSaveableValue(value)));
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
        return code;
    }
    
    /**
     * Derives the operand expression for turning a configuration into a project.
     * 
     * @param decl the variable declaration to start at
     * @param var the related decision variable
     * @return the constraint syntax tree representing the operand for an assignment
     */
    private ConstraintSyntaxTree deriveOperand(AbstractVariable decl, IDecisionVariable var) {
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
     * @param value The value which should be saved.
     * @return the value where all problematic characters are escaped.
     */
    private static Value toSaveableValue(Value value) {
        if (null != value.getValue() && value instanceof StringValue) {
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
                e.printStackTrace();
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
            if (decisionVariable.getState() == AssignmentState.FROZEN
                && decisionVariable.getDeclaration() instanceof IFreezable ) {
                
                frozenElements.add((IFreezable) decisionVariable.getDeclaration());
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
            FreezeBlock freeze = new FreezeBlock(freezables, null, confProject);
            confProject.add(freeze);
        }
    }
}
