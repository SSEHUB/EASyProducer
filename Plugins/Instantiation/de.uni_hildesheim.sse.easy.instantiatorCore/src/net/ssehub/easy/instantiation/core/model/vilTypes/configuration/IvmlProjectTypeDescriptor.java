package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualTypeAssignmentProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Implements a dynamic type descriptor for a project containing IVML decision variables. 
 * Instances of this class represent IVML types and act as a frontend for {@link Configuration}, thus,
 * it is assignable to {@link Configuration}.
 * 
 * @author Holger Eichelberger
 */
class IvmlProjectTypeDescriptor extends AbstractIvmlTypeDescriptor implements IActualValueProvider, 
    IActualTypeAssignmentProvider {

    private Project project;
    
    /**
     * Creates a new type descriptor. Overridden constructors shall call {@link #setOperations(java.util.Collection)}
     * and {@link #setConversions(java.util.Collection)}.
     * 
     * @param project the project to create the descriptor for
     * @param resolver for retrieving further IVML types
     * @throws VilException if analyzing the class fails for some reason
     */
    IvmlProjectTypeDescriptor(Project project, IvmlTypeResolver resolver) throws VilException {
        super(project.getType(), resolver);
        this.project = project;
        Map<String, OperationDescriptor> operations = new HashMap<String, OperationDescriptor>();
        Map<String, FieldDescriptor> fields = new HashMap<String, FieldDescriptor>();
        addDecisionVariableOperations(operations);
        // comparison operations is unclear
        //addAttributeOperations(operations, project); // attributes declare but do not have projects
        addOperations(operations, fields, project, new HashSet<Project>());
        setOperations(operations.values());
        setFields(fields.values());
        List<OperationDescriptor> conversions = new ArrayList<OperationDescriptor>();
        conversions.add(new IvmlConfigurationConversionOperationDescriptor(this));
        setConversions(conversions);
    }
    
    /**
     * Adds operations for the given variable declaration.
     * 
     * @param decl the variable declaration
     * @param operations the name-operation mapping to be filled as a side effect
     * @param fields the name-field mapping to be filled as a side effect
     */
    private void addOperations(DecisionVariableDeclaration decl, Map<String, OperationDescriptor> operations, 
        Map<String, FieldDescriptor> fields) {
        String name = decl.getName();
        if (!fields.containsKey(name)) {
            try {
                fields.put(name, new IvmlConfigurationFieldDescriptor(this, decl, getTypeRegistry()));
            } catch (VilException ex) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(ex);
            }
        }
    }
    
    /**
     * Adds operations for elements defined by <code>cont</code>.
     * 
     * @param cont the container
     * @param operations the name-operation mapping to be filled as a side effect
     * @param fields the name-field mapping to be filled as a side effect
     */
    private void addOperations(IDecisionVariableContainer cont, Map<String, OperationDescriptor> operations, 
        Map<String, FieldDescriptor> fields) {
        for (int e = 0; e < cont.getElementCount(); e++) {
            addOperations(cont.getElement(e), operations, fields);
        }
        for (int a = 0; a < cont.getAssignmentCount(); a++) {
            addOperations(cont.getAssignment(a), operations, fields);
        }
    }

    /**
     * Adds all operations of <code>project</code> and its imports to <code>operations</code>.
     * 
     * @param operations the name-operation mapping to be filled as a side effect
     * @param fields the name-field mapping to be filled as a side effect
     * @param project the project the operations shall be added for
     * @param done already done projects
     */
    private void addOperations(Map<String, OperationDescriptor> operations, Map<String, FieldDescriptor> fields, 
        Project project, Set<Project> done) {
        if (!done.contains(project)) {
            done.add(project);
            int eCount = project.getElementCount();
            for (int e = 0; e < eCount; e++) {
                ContainableModelElement elt = project.getElement(e);
                if (elt instanceof DecisionVariableDeclaration) {
                    addOperations((DecisionVariableDeclaration) elt, operations, fields);
                } else if (elt instanceof AttributeAssignment) {
                    addOperations((AttributeAssignment) elt, operations, fields);
                }
            }
            for (int i = 0; i < project.getImportsCount(); i++) {
                Project imp = project.getImport(i).getResolved();
                if (null != imp) {
                    addOperations(operations, fields, imp, done);
                }
            }
        }
    }
    
    /**
     * Returns the project associated with this descriptor.
     * 
     * @return the project
     */
    public Project getProject() {
        return project;
    }
    
    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        // final check at runtime
        return (desc == this || IvmlTypes.configurationType() == desc);
    }

    @Override
    public boolean isAssignableFrom(IMetaType type1, IMetaType type2) {
        return (type1 == this && IvmlTypes.configurationType() == type2) 
            || (type2 == this && IvmlTypes.configurationType() == type1);
    }

    @Override
    public boolean isInstance(Object object) {
        boolean isInstance = false;
        if (object instanceof Configuration) {
            Configuration cfg = (Configuration) object;
            isInstance = cfg.getName().equals(project.getName()); // no subtyping on projects
        }
        return isInstance;
    }
    
    @Override
    public boolean isSameType(Object object) {
        boolean isSame = false;
        if (object instanceof Configuration) {
            Configuration cfg = (Configuration) object;
            isSame = cfg.getName().equals(project.getName());
        }
        return isSame;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public Object determineActualValue(Object object) {
        if (object instanceof Configuration) {
            Configuration cfg = (Configuration) object;
            if (!cfg.getName().equals(project.getName())) {
                object = cfg.selectByProject(project.getName());
            }
        }
        return object;
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public boolean isInstantiator() {
        return false;
    }

    @Override
    protected IDatatype getIvmlType() {
        return project.getType();
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

}
