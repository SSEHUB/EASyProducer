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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Resolves the initial assignment settings for a configuration.
 * <ul>
 * <li>Starts resolving of values inside the inner most imported {@link Project} and continues until it arrives
 * at the main project of the {@link Configuration}. Thus, interim assignments shall be considered correctly.</li>
 * <li>This "simple Reasoner" is not intended to find inconsistencies/errors inside the model. If multiple constraints
 * lead to different value assignments for the same variable, one of these values will be randomly assigned.</li>
 * </ul>
 * TODO: Still open points, which are not considered yet:
 * <ul>
 * <li>Does not consider {@link Constraint}s of {@link Compound}s and
 * {@link de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype}s.</li>
 * <li>{@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration} of type
 * {@link de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType}
 * are also not used for value assignments</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class AssignmentResolver {
    
    protected Configuration config;
    protected EvaluationVisitor evaluator;
    
    /**
     * Specification of max evaluation loops should be done per {@link Project}.
     * If 0 or less, this {@link AssignmentResolver} will reason until the end (endless).
     */
    private int iterationLoops;
    
    /**
     * Sole constructor for this class. Will not start resolving values,
     * this must be done via calling the {@link #resolve()} method.
     * @param config The configuration for which assignments shall be resolved.
     */
    public AssignmentResolver(Configuration config) {
        this.config = config;
        evaluator = createEvaluationVisitor();
        iterationLoops = 5;
    }
    
    /**
     * Factory method for creating the evaluation visitor.
     * 
     * @return the evaluation visitor
     */
    protected EvaluationVisitor createEvaluationVisitor() {
        return new EvaluationVisitor();
    }
    
    /**
     * Resolves the (initial) values of the configuration. This is done as follows:
     * <ol>
     * <li>Resolve default values of variable declarations</li>
     * <li>Resolve values of assignments</li>
     * </ol>
     */
    public void resolve() {
        // Stack of importedProject (start with inner most imported project)
        List<Project> projects = new ArrayList<Project>();
        findImportedProjects(projects);
        
        for (int p = 0; p < projects.size(); p++) {
            Project project = projects.get(p);
            evaluator.setDispatchScope(project);
            resolveDefaultValues(project);
            resolveAssignments(project);
            // TODO do incremental freezing in here -> required by interfaces with propagation constraints
        }
    }

    /**
     * Part of the {@link #resolve()} method.
     * Resolves default values of variable declarations.
     * @param project Project The current project for which assignments shall be resolved.
     */
    protected void resolveDefaultValues(Project project) {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.NO_IMPORTS, null);
        List<AbstractVariable> variables = finder.getVariableDeclarations(VisibilityType.ALL);
        for (AbstractVariable decl : variables) {
            resolveDefaultValueForDeclaration(decl, config.getDecision(decl));
        }
    }
    
    /**
     * Part of the {@link #resolveDefaultValues(Project)} method.
     * Resolves default values of a particular declaration.
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of <tt>decl</tt>.
     */
    protected void resolveDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable) {
        IDatatype type = decl.getType();
        if (Compound.TYPE.isAssignableFrom(type)) {
            Compound cmpType = (Compound) type;
            CompoundVariable cmpVar = (CompoundVariable) variable;
            for (int i = 0, n = cmpType.getInheritedElementCount(); i < n; i++) {
                AbstractVariable nestedDecl = cmpType.getInheritedElement(i);
                resolveDefaultValueForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()));
            }
        }
        
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        if (null != defaultValue) {
            evaluator.init(config, AssignmentState.DEFAULT, false, null);
            evaluator.visit(defaultValue);
            if (evaluator.constraintFailed() && !(BooleanType.TYPE.isAssignableFrom(type))) {
                conflictingDefault(decl);
            } else {
                Value value = evaluator.getResult();
                try {
                    variable.setValue(value, AssignmentState.DEFAULT);
                } catch (ConfigurationException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(AssignmentResolver.class, Bundle.ID).exception(e);
                }
            }
            evaluator.clear();
        }
    }
    
    /**
     * Part of the {@link #resolve()} method.
     * Resolves assignments.
     * @param project Project The current project for which assignments shall be resolved.
     */
    protected void resolveAssignments(Project project) {
        List<Constraint> unresolvedConstraints = new ArrayList<Constraint>();
        ConstraintFinder finder = new ConstraintFinder(project, false);
        List<Constraint> constraints = finder.getConstraints();
        int nConstraintsInLastIteration = constraints.size();
        int remainingSteps = iterationLoops > 0 ? iterationLoops : 1;
        
        while (!constraints.isEmpty() && remainingSteps > 0) {
            for (Constraint constraint : constraints) {
                ConstraintSyntaxTree cst = constraint.getConsSyntax();
                evaluator.init(config, AssignmentState.ASSIGNED, false, null);
                evaluator.visit(cst);
                // Check whether the constraint could be resolved
                if (null == evaluator.getResult()) {
                    unresolvedConstraints.add(constraint);
                } else if (evaluator.constraintFailed()) {
                    // Check whether the constraint was violated
                    conflictingConstraint(constraint);
                }
                
                evaluator.clear();
            }
            int openConstraints = unresolvedConstraints.size();
            if (nConstraintsInLastIteration != openConstraints) {
                constraints = unresolvedConstraints;
                unresolvedConstraints = new ArrayList<Constraint>();
                nConstraintsInLastIteration = openConstraints;
                if (iterationLoops > 0) {
                    remainingSteps--;
                }
            } else {
                constraints.clear();
                // Stops the while loop
            }
        }
    }
    
    /**
     * Will be called after a failure was detected in a {@link Constraint}.
     * @param constraint The violated {@link Constraint}.
     */
    protected void conflictingConstraint(Constraint constraint) {
        // Here is no action needed, but maybe in a sub class.
    }
    
    /**
     * Will be called after a failure was detected in a default constraint of an {@link AbstractVariable}.
     * @param decl The conflicting declaration of an {@link AbstractVariable}.
     *     Call {@link AbstractVariable#getDefaultValue()} to retrieve the conflicting constraint.
     */
    protected void conflictingDefault(AbstractVariable decl) {
        // Here is no action needed, but maybe in a sub class.
    }
    
    /**
     * Fills the stack of imported {@link Project}s.
     * The innermost import will be on top of the stack ({@link Deque}). The main {@link Project} of the
     * {@link Configuration} will be on bottom. No project will be listed multiple times.
     * @param projects The list of all included projects, which are used inside the configuration.
     */
    private void findImportedProjects(List<Project> projects) {
        findImportedProjects(config.getProject(), projects, new HashSet<Project>());
        /*Queue<Project> imports = new ArrayDeque<Project>();
        Project mainProject = config.getProject();
        imports.add(mainProject);
        projects.addFirst(mainProject);
        
        while (!imports.isEmpty()) {
            Project project = imports.poll();
            for (int i = 0, n = project.getImportsCount(); i < n; i++) {
                Project importedProject = project.getImport(i).getResolved();
                if (null != importedProject) {
                    imports.add(importedProject);
                    projects.addFirst(importedProject);
                }
            }
        }*/
    }

    /**
     * Fills the stack of imported {@link Project}s recursively.
     * @param project the project to be considered
     * @param projects the list of all included projects (modified as a side effect)
     * @param done already considered projects 
     */
    private void findImportedProjects(Project project, List<Project> projects, Set<Project> done) {
        if (!done.contains(project)) {
            done.add(project);

            int minPos = -1;
            for (int i = 0, n = project.getImportsCount(); i < n; i++) {
                Project importedProject = project.getImport(i).getResolved();
                if (null != importedProject) {
                    findImportedProjects(importedProject, projects, done);
                }
            }
            // TODO this is not nice, minPos in upper loop may change due to further insertions
            for (int i = 0, n = project.getImportsCount(); i < n; i++) {
                Project importedProject = project.getImport(i).getResolved();
                if (null != importedProject) {
                    minPos = Math.max(minPos, projects.indexOf(importedProject));
                }
            }
            projects.add(minPos + 1, project);
        }
    }
    
}
