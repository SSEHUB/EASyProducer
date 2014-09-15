package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IActualValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Implements a dynamic type descriptor for a project containing IVML decision variables. 
 * Instances of this class represent IVML types and act as a frontend for {@link Configuration}, thus,
 * it is assignable to {@link Configuration}.
 * 
 * @author Holger Eichelberger
 */
class IvmlProjectTypeDescriptor extends AbstractIvmlTypeDescriptor implements IActualValueProvider {

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
        addMetaOperations(operations);
        // comparison operations is unclear
        //addAttributeOperations(operations, project); // attributes declare but do not have projects
        addOperations(operations, project);
        setOperations(operations.values());
        setConversions(null);
    }

    /**
     * Adds all operations of <code>project</code> and its imports to <code>operations</code>.
     * 
     * @param operations the name-operation mapping to be filled as a side effect
     * @param project the project the operations shall be added for
     */
    private void addOperations(Map<String, OperationDescriptor> operations, Project project) {
        int eCount = project.getElementCount();
        for (int e = 0; e < eCount; e++) {
            ContainableModelElement elt = project.getElement(e);
            if (elt instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) elt;
                String name = decl.getName();
                if (!operations.containsKey(name)) {
                    operations.put(name, new IvmlConfigurationOperationDescriptor(this, decl));
                }
            }
        }
        for (int i = 0; i < project.getImportsCount(); i++) {
            Project imp = project.getImport(i).getResolved();
            if (null != imp) {
                addOperations(operations, imp);
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
    public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
        // final check at runtime
        return (desc == this || IvmlTypes.configurationType() == desc);
    }

    @Override
    public boolean isInstance(Object object) {
        boolean isInstance = false;
        if (object instanceof Configuration) {
            Configuration cfg = (Configuration) object;
            isInstance = cfg.getName().equals(project.getName());
        }
        return isInstance;
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

}
