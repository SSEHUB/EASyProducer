package net.ssehub.easy.integration.common.impl;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.integration.common.IConstraint;
import net.ssehub.easy.integration.common.IDecisionVariable;
import net.ssehub.easy.integration.common.IModel;
import net.ssehub.easy.integration.common.ModelException;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Basic implementation for the readable model.
 * 
 * @author Holger Eichelberger
 */
public abstract class Model implements IModel {

    private Project project;
    private Configuration configuration;
    private List<DecisionVariable> variables = new ArrayList<DecisionVariable>();
    private List<IDatatype> types = new ArrayList<IDatatype>();

    /**
     * Creates a model backed by <code>project</code>.
     * 
     * @param project the IVML project instance
     */
    protected Model(Project project) {
        this.project = project;
        this.configuration = new Configuration(project);
        types.add(BooleanType.TYPE);
        types.add(StringType.TYPE);
        types.add(IntegerType.TYPE);
        types.add(RealType.TYPE);
        createModelContent(this.project);
    }
    
    /**
     * Creates the model content based on the given <code>project</code>.
     * 
     * @param project the IVML project instance
     */
    private void createModelContent(Project project) {
        if (null != project) {
            int elementCount = project.getElementCount();
            for (int c = 0; c < elementCount; c++) {
                collect(project.getElement(c));
            }
            int importCount = project.getImportsCount();
            if (importCount > 0) {
                for (int i = 0; i < importCount; i++) {
                    System.err.println("imports found!");
                    resolveImports(project.getImport(i));
                }
            }
        }
    }
    
    /**
     * Collects cached information for <code>elt</code>.
     * 
     * @param elt the element to cache information for
     */
    private void collect(ContainableModelElement elt) {
        if (elt instanceof IDatatype) {
            types.add((IDatatype) elt);
        } else if (elt instanceof DecisionVariableDeclaration) {
            DecisionVariableDeclaration decl = (DecisionVariableDeclaration) elt;
            variables.add(new DecisionVariable(decl, configuration.getDecision(decl)));
        }
    }
    
    /**
     * Resolves project import in terms of collecting type and variable definitions.
     * 
     * @param pImport the project import from which additional cache information will be stored
     */
    private void resolveImports(ProjectImport pImport) {
        Project importedProject = pImport.getResolved();
        if (importedProject != null) {
            createModelContent(importedProject); 
        }
    }

    @Override
    public String getName() {
        return project.getName();
    }

    @Override
    public String getVersion() {
        return Version.toString(project.getVersion());
    }
    
    @Override
    public int getVariablesCount() {
        return variables.size();
    }

    @Override
    public IDecisionVariable getVariable(int index) {
        return variables.get(index);
    }
    
    /**
     * Returns a decision variable by it's (valid IVML) name.
     * 
     * @param name the name of the variable
     * @return the decision variable (or <b>null</b> if not found)
     * @throws ModelException in case of any semantic problem
     */
    public IDecisionVariable getVariable(String name) throws ModelException {
        IDecisionVariable result = null;
        try {
            AbstractVariable var = ModelQuery.findVariable(project, name, DecisionVariableDeclaration.class);
            if (null != var) {
                for (int v = 0; v < variables.size(); v++) {
                    DecisionVariable tmp = variables.get(v);
                    if (tmp.getInstance() == var) {
                        result = tmp;
                    }
                }
            }
        } catch (ModelQueryException e) {
            throw new ModelException(e.getMessage());
        }
        return result;
    }

    @Override
    public int getTypesCount() {
        return types.size();
    }

    @Override
    public String getType(int index) {
        return IvmlDatatypeVisitor.getUniqueType(types.get(index));
    }

    /**
     * Adds a decision custom type to this model and updates the cached information.
     * 
     * @param type the type to add
     * @throws ModelException in case that the same variable is about to be defined multiple times
     */
    protected void add(CustomDatatype type) throws ModelException {
        if (!project.add(type)) {
            throw new ModelException("variable '" + type.getName() + "' is already part of the model");
        }
        types.add(type);
    }
    
    /**
     * Adds a decision variable to this model and updates the cached information.
     * 
     * @param variable the variable to add
     * @throws ModelException in case that the same variable is about to be defined multiple times
     */
    protected void add(DecisionVariable variable) throws ModelException {
        if (!project.add(variable.getInstance())) {
            throw new ModelException("variable '" + variable.getName() + "' is already part of the model");
        }
        variables.add(variable);
    }
    
    /**
     * Returns the project instance.
     * 
     * @return the project instance
     */
    protected Project getProject() {
        return project;
    }

    /**
     * Returns the textual representation of this model.
     * 
     * @return the textual representation in IVML syntax
     */
    public String toString() {
        return StringProvider.toIvmlString((ModelElement) project);
    }
    
    @Override
    public IConstraint createConstraint(String constraint) throws ModelException {
        return new Constraint(constraint, project);
    }

}
