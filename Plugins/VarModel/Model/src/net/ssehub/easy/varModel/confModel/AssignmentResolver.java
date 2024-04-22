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
package net.ssehub.easy.varModel.confModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.filter.AnnotationAssignmentFinder;
import net.ssehub.easy.varModel.model.filter.ConstraintFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

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
 * {@link net.ssehub.easy.varModel.model.datatypes.DerivedDatatype}s.</li>
 * <li>{@link net.ssehub.easy.varModel.model.DecisionVariableDeclaration} of type
 * {@link net.ssehub.easy.varModel.model.datatypes.ConstraintType}
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
     * Temporary list of all instances per data type. Should reduce retrieval if nested {@link IDecisionVariable}s for
     * a {@link IDatatype} (e.g. a {@link Compound}) shall be found. Needed for resolving values for nested elements.
     */
    private Map<IDatatype, List<IDecisionVariable>> instancesPerType;
    
    /**
     * Part of the {@link AssignmentResolver#resolveAnnotationAssignments(AttributeAssignment, Map, List)} for recursive
     * resolving assignment values of annotation assignment blocks. 
     * @author El-Sharkawy
     *
     */
    private class AssignBlockVisitor implements IModelVisitor {
        
        private Map<String, Value> annotationAssignments;
        private List<IDecisionVariable> parents;
        private boolean visitNestedElements;
        
        /**
         * Sole constructor of this class.
         * @param annotationAssignments A tuple of (&lt;annotation name&gt;, &lt;value&gt;) for the current 
         * annotation block.
         * If a nested block is found, these values must be copied into a new map as nested blocks can have other values
         * and also further elements can be found after a block was visited.
         * @param parents A list of {@link IDecisionVariable}s which shall currently be treated as parents for
         * retrieving (nested) {@link IDecisionVariable}s during visitation. Can be empty or <b>null</b>
         * if the current parent is the whole project.
         */
        private AssignBlockVisitor(Map<String, Value> annotationAssignments, List<IDecisionVariable> parents) {
            this.annotationAssignments = annotationAssignments;
            this.parents = parents;
            visitNestedElements = null != parents && !parents.isEmpty();
        }
        
        @Override
        public void visitSet(net.ssehub.easy.varModel.model.datatypes.Set set) {
            // Nothing to do
        }
        
        @Override
        public void visitSequence(Sequence sequence) {
            // Nothing to do
        }
        
        @Override
        public void visitReference(Reference reference) {
            // Nothing to do
        }
        
        @Override
        public void visitOrderedEnum(OrderedEnum eenum) {
            // Nothing to do
        }
        
        @Override
        public void visitEnumLiteral(EnumLiteral literal) {
            // Nothing to do
        }
        
        @Override
        public void visitEnum(Enum eenum) {
            // Nothing to do
        }
        
        @Override
        public void visitDerivedDatatype(DerivedDatatype datatype) {
            // Nothing to do
        }
        
        @Override
        public void visitCompound(Compound compound) {
            List<IDecisionVariable> oldParents = parents;
            boolean oldVisitState = visitNestedElements;
            visitNestedElements = true;
            parents = AssignmentResolver.this.getInstancesForType(compound);
            
            compound.accept(this);
            
            visitNestedElements = oldVisitState;
            parents = oldParents;
        }
        
        @Override
        public void visitProjectInterface(ProjectInterface iface) {
            // Nothing to do
        }
        
        @Override
        public void visitProjectImport(ProjectImport pImport) {
            // Nothing to do
        }
        
        @Override
        public void visitProject(Project project) {
            // Nothing to do
        }
        
        @Override
        public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
            // Nothing to do
        }
        
        @Override
        public void visitOperationDefinition(OperationDefinition opdef) {
            // Nothing to do
        }
        
        @Override
        public void visitFreezeBlock(FreezeBlock freeze) {
            // Nothing to do
        }
        
        @Override
        public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
            if (!visitNestedElements) {
                IDecisionVariable variable = config.getDecision(decl);
                assignAnnotationValuesToVariable(variable);
            } else {
                for (int i = 0, n = parents.size(); i < n; i++) {
                    IDecisionVariable parentVar = parents.get(i);
                    for (int j = 0, m = parentVar.getNestedElementsCount(); j < m; j++) {
                        IDecisionVariable nestedVar = parentVar.getNestedElement(j);
                        if (decl == nestedVar.getDeclaration()) {
                            assignAnnotationValuesToVariable(nestedVar);
                        }
                    }
                }
            }
        }

        /**
         * Part of {@link #visitDecisionVariableDeclaration(DecisionVariableDeclaration)}: Assigns all gathered
         * annotation values to the given {@link IDecisionVariable}.
         * @param variable The {@link IDecisionVariable} for which the values shall be configured.
         */
        private void assignAnnotationValuesToVariable(IDecisionVariable variable) {
            if (null != variable) {
                for (int i = 0, n = variable.getAttributesCount(); i < n; i++) {
                    IDecisionVariable annotation = variable.getAttribute(i);
                    Value annotationValue = annotationAssignments.get(annotation.getDeclaration().getName());
                    if (null != annotationValue) {
                        try {
                            annotation.setValue(annotationValue, AssignmentState.ASSIGNED);
                        } catch (ConfigurationException e) {
                            Bundle.getLogger(AssignmentResolver.class).exception(e);
                        }
                    }
                }
            }
        }
        
        @Override
        public void visitConstraint(Constraint constraint) {
            // Nothing to do
        }
        
        @Override
        public void visitCompoundAccessStatement(CompoundAccessStatement access) {
            // Nothing to do
        }
        
        @Override
        public void visitComment(Comment comment) {
            // Nothing to do
        }
        
        @Override
        public void visitAttributeAssignment(AttributeAssignment assignment) {
            Map<String, Value> nestedAssignments = new HashMap<String, Value>();
            nestedAssignments.putAll(annotationAssignments);
            AssignmentResolver.this.resolveAnnotationAssignments(assignment, nestedAssignments, parents);
        }
        
        @Override
        public void visitAttribute(Attribute attribute) {
            // Nothing to do
        }
        
    }
    
    /**
     * Sole constructor for this class. Will not start resolving values,
     * this must be done via calling the {@link #resolve()} method.
     * @param config The configuration for which assignments shall be resolved.
     */
    public AssignmentResolver(Configuration config) {
        this.config = config;
        evaluator = createEvaluationVisitor();
        iterationLoops = 5;
        instancesPerType = new HashMap<IDatatype, List<IDecisionVariable>>();
        // Handle top level variables with iterator
        Iterator<IDecisionVariable> varItr = config.iterator();
        while (varItr.hasNext()) {
            IDecisionVariable variable = varItr.next();
            IDatatype type = variable.getDeclaration().getType();
            List<IDecisionVariable> instances = instancesPerType.get(type);
            if (null == instances) {
                instances = new ArrayList<IDecisionVariable>();
                instancesPerType.put(type, instances);
            }
            instances.add(variable);
            
            findInstancesOfNestedVariavbles(variable);
        }
    }
    
    /**
     * Recursive method to collect all nested {@link IDecisionVariable}.
     * Part of the constructor.
     * @param variable A already collected variable, may containing nested variables (must not be <b>null</b>.
     */
    private void findInstancesOfNestedVariavbles(IDecisionVariable variable) {
        for (int i = 0, n = variable.getNestedElementsCount(); i < n; i++) {
            IDecisionVariable nestedVar = variable.getNestedElement(i);
            IDatatype type = nestedVar.getDeclaration().getType();
            List<IDecisionVariable> instances = instancesPerType.get(type);
            if (null == instances) {
                instances = new ArrayList<IDecisionVariable>();
                instancesPerType.put(type, instances);
            }
            instances.add(nestedVar);
            findInstancesOfNestedVariavbles(nestedVar);
        }
    }
    
    /**
     * Returns a list of all (nested) {@link IDecisionVariable}s for the given type.
     * @param type The type for which the {@link IDecisionVariable}s shall be returned.
     * Will <b>not</b> consider {@link IDatatype#isAssignableFrom(IDatatype)}.
     * @return The list of instances or <b>null</b> if no instance exist for the specified type.
     */
    protected List<IDecisionVariable> getInstancesForType(IDatatype type) {
        return instancesPerType.get(type);
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
            /* Annotation default values are already handles while the IDecisionVariable is created
             * However, assignment blocks can also be treated as default values, as they can be overwritten
             * with classical assignment constraints.The later one is handled inside the resolveAssignments
             * methods. For this reason, resolveAnnotationAssignments must be handled before resolveAssignments
             */
            resolveAnnotationAssignments(project);
            resolveAssignments(project);
        }
    }

    /**
     * Sets the (re-)assigned annotation values for all annotation of all variables for the current {@link Project}.
     * @param project The current project for which annotation assignments shall be resolved.
     */
    private void resolveAnnotationAssignments(Project project) {
        AnnotationAssignmentFinder finder = new AnnotationAssignmentFinder(project, FilterType.NO_IMPORTS, false);
        List<AttributeAssignment> assignmentBlocks = finder.getAssignmentBlocks();
        for (int i = 0, n = assignmentBlocks.size(); i < n; i++) {
            // Assign values top down (as they can be overwritten in this way)
            // TODO handle not solveable assignments, like >, >=, <, <= (is this supported?) // TODO no, see syntax
            AttributeAssignment assignBlock = assignmentBlocks.get(i);
            Map<String, Value> annotationAssignments = new HashMap<String, Value>();
            IModelElement parent = assignBlock.getParent();
            List<IDecisionVariable> parents = null;
            if (parent instanceof Project) {
                parents = new ArrayList<IDecisionVariable>();
            } else if (parent instanceof IDatatype) {
                parents = instancesPerType.get((IDatatype) parent);
            }
            resolveAnnotationAssignments(assignBlock, annotationAssignments, parents);
        }
    }

    /**
     * Recursive method for resolving annotation assignments (part of {@link #resolveAnnotationAssignments(Project)}.
     * @param assignBlock The current visited assignment block.
     * @param annotationAssignments A tuple of (&lt;annotation name&gt;, &lt;value&gt;) for the current annotation 
     * block. If a nested block is found, these values must be copied into a new map as nested blocks can have other 
     * values and also further elements can be found after a block was visited.
     * @param parents A list of {@link IDecisionVariable}s which shall currently be treated as parents for
     * retrieving (nested) {@link IDecisionVariable}s during visitation. Can be empty or <b>null</b>
     * if the current parent is the whole project.
     */
    private void resolveAnnotationAssignments(AttributeAssignment assignBlock,
        final Map<String, Value> annotationAssignments, List<IDecisionVariable> parents) {
        
        // Collect all annotation value assignments before setting them to nested variables
        for (int i = 0, n = assignBlock.getAssignmentDataCount(); i < n; i++) {
            Assignment assignment = assignBlock.getAssignmentData(i);
            String annotationName = assignment.getName();
            ConstraintSyntaxTree constraint = assignment.getExpression();
            
            evaluator.init(config, AssignmentState.DEFAULT, false, null);
            evaluator.visit(constraint);
            Value value = evaluator.getResult();
            if (null != value) {
                annotationAssignments.put(annotationName, value);
            }
            evaluator.clear();
        }
        
        // Set value for all nested elements (until the next assignment block occurs)
        for (int i = 0, n = assignBlock.getElementCount(); i < n; i++) {
            // TODO performance optimization (Do not create every time a new constructor, but only a new map
            assignBlock.getElement(i).accept(new AssignBlockVisitor(annotationAssignments, parents));
        }
    }

    /**
     * Part of the {@link #resolve()} method.
     * Resolves default values of variable declarations.
     * @param project The current project for which assignments shall be resolved.
     */
    protected void resolveDefaultValues(Project project) {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.NO_IMPORTS, null);
        List<AbstractVariable> variables = finder.getVariableDeclarations(VisibilityType.ALL);
        boolean variablesResolved = true;
        int remainingSteps = iterationLoops > 0 ? iterationLoops : 1;
        
        while (variables.size() > 0 && variablesResolved && remainingSteps > 0) {
            List<AbstractVariable> unresolvedVariables = new ArrayList<AbstractVariable>();
            variablesResolved = false;
            
            for (AbstractVariable decl : variables) {
                if (!resolveDefaultValueForDeclaration(decl, config.getDecision(decl))) {
                    unresolvedVariables.add(decl);
                    variablesResolved = true;
                }
            }
            
            // Swap
            variables = unresolvedVariables;
            unresolvedVariables = new ArrayList<AbstractVariable>();
            remainingSteps--;
        }
    }

    /**
     * Resolves default values of a particular variable. No conflict handler is used.
     * 
     * @param variable the instance to resolve the default values for.
     * @param evaluator the (re-usable) expression evaluator to utilize, may be <b>null</b> then a temporary one is 
     *     created
     * @return {@code true} if a default value could be resolved and assigned to {@code variable}, {@code false}
     *     otherwise.
     *     
     * @see #resolveDefaultValueForDeclaration(AbstractVariable, IDecisionVariable)
     */
    public static boolean resolveDefaultValue(IDecisionVariable variable, EvaluationVisitor evaluator) {
        return resolveDefaultValueForDeclaration(variable.getDeclaration(), variable, 
            null != evaluator ? evaluator : new EvaluationVisitor(), variable.getConfiguration(), null);
    }

    /**
     * Resolves default values of a particular variable. The evaluator is created on demand, no conflict handler is 
     * used.
     * 
     * @param variable the instance to resolve the default values for.
     * @return {@code true} if a default value could be resolved and assigned to {@code variable}, {@code false}
     *     otherwise.
     *     
     * @see #resolveDefaultValue(IDecisionVariable, EvaluationVisitor)
     */
    public static boolean resolveDefaultValue(IDecisionVariable variable) {
        return resolveDefaultValue(variable, null);
    }
    
    /**
     * Resolves default values of a particular declaration.
     * 
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of {@code decl}.
     * @param evaluator the (re-usable) expression evaluator to utilize
     * @param config the configuration to rely on (shall be consistent with <code>variable</code>)
     * @param conflictHandler optional instance to call {@link #conflictingDefault(AbstractVariable)} on, may be 
     *     <b>null</b> 
     * @return {@code true} if a default value could be resolved and assigned to {@code variable}, {@code false}
     *     otherwise.
     *
     * @see #resolveDefaultValues(Project)
     */
    protected static boolean resolveDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable, 
        EvaluationVisitor evaluator, IConfiguration config, AssignmentResolver conflictHandler) {
        boolean valueResolved = false;

        IDatatype type = decl.getType();
        if (Compound.TYPE.isAssignableFrom(type)) {
            Compound cmpType = (Compound) type;
            CompoundVariable cmpVar = (CompoundVariable) variable;
            for (int i = 0, n = cmpType.getInheritedElementCount(); i < n; i++) {
                AbstractVariable nestedDecl = cmpType.getInheritedElement(i);
                resolveDefaultValueForDeclaration(nestedDecl, cmpVar.getNestedVariable(nestedDecl.getName()), 
                    evaluator, config, conflictHandler);
            }
        }
        
        ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
        if (null != defaultValue) {
            if (type == ConstraintType.TYPE) {
                try {
                    Value value = ValueFactory.createValue(type, defaultValue);
                    variable.setValue(value, AssignmentState.DEFAULT);
                } catch (ConfigurationException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(AssignmentResolver.class, Bundle.ID).exception(e);
                } catch (ValueDoesNotMatchTypeException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(AssignmentResolver.class, Bundle.ID).exception(e);
                }
            } else {
                evaluator.init(config, AssignmentState.DEFAULT, false, null);
                evaluator.visit(defaultValue);
                if (evaluator.constraintFailed() && !(BooleanType.TYPE.isAssignableFrom(type))) {
                    if (null != conflictHandler) {
                        conflictHandler.conflictingDefault(decl);
                    }
                    evaluator.clear();
                } else {
                    Value value = evaluator.getResult();
                    evaluator.clear();
                    if (null != value) {
                        value = augmentValue(value, variable, evaluator, config, conflictHandler);
                        try {
                            variable.setValue(value, AssignmentState.DEFAULT);
                            valueResolved = true;
                        } catch (ConfigurationException e) {
                            EASyLoggerFactory.INSTANCE.getLogger(AssignmentResolver.class, Bundle.ID).exception(e);
                        }
                    }
                }
            }
            if (decl.isConstant()) {
                variable.freeze(AllFreezeSelector.INSTANCE);
            }
        }
        
        return valueResolved;
    }
    
    /**
     * If a value of a refined compound shall the first time be assigned to a variable of a super compound (polymorphic
     * values), then also the default values of the refined compounds shall be taken into account and augment the value.
     * Otherwise, an inconsistent configuration structure may later lead to invalid values.
     * 
     * @param value the value to be checked
     * @param variable the variable to assign the value to
     * @param evaluator the (re-usable) expression evaluator to utilize
     * @param config the configuration to rely on (shall be consistent with <code>variable</code>)
     * @param conflictHandler optional instance to call {@link #conflictingDefault(AbstractVariable)} on, may be 
     *     <b>null</b> 
     * @return the (augmented) <code>value</code>
     */
    private static Value augmentValue(Value value, IDecisionVariable variable, EvaluationVisitor evaluator, 
        IConfiguration config, AssignmentResolver conflictHandler) {
        // only in polymorphic situations, value carries refined type from compound initializer
        if (value instanceof CompoundValue && !TypeQueries.sameTypes(value.getType(), 
            variable.getDeclaration().getType())) {
            Map<String, Value> values = new HashMap<String, Value>();
            CompoundValue cValue = (CompoundValue) value;
            // save slots of value
            for (String slot : cValue.getSlotNames()) {
                values.put(slot, cValue.getNestedValue(slot));
            }
            Compound cType = (Compound) value.getType();
            // check whether slots of refined types are there, resolve them if needed, take over their initial values
            for (int e = 0; e < cType.getElementCount(); e++) {
                AbstractVariable slotDecl = cType.getElement(e);
                if (null == values.get(slotDecl.getName())) {
                    IDecisionVariable slotVar = variable.getNestedElement(slotDecl.getName());
                    if (null == slotVar.getValue()) {
                        resolveDefaultValueForDeclaration(slotVar.getDeclaration(), slotVar, 
                            evaluator, config, conflictHandler);
                    }
                    if (null != slotVar && null != slotVar.getValue()) {
                        values.put(slotDecl.getName(), slotVar.getValue());
                    }
                }
            }
            // compose new value
            Object[] tmp = new Object[values.size() * 2];
            int pos = 0;
            for (Map.Entry<String, Value> ent : values.entrySet()) {
                tmp[pos++] = ent.getKey();
                tmp[pos++] = ent.getValue();
            }
            try {
                value = ValueFactory.createValue(value.getType(), tmp);
            } catch (ValueDoesNotMatchTypeException e) {
                EASyLoggerFactory.INSTANCE.getLogger(AssignmentResolver.class, null).exception(e);
            }
        }
        return value;
    }
    
    /**
     * Resolves default values of a particular declaration.
     * 
     * @param decl The {@link AbstractVariable} for which the default value should be resolved.
     * @param variable the instance of {@code decl}.
     * @return {@code true} if a default value could be resolved and assigned to {@code variable}, {@code false}
     *     otherwise.
     *     
     * @see #resolveDefaultValues(Project)
     */
    protected boolean resolveDefaultValueForDeclaration(AbstractVariable decl, IDecisionVariable variable) {
        return resolveDefaultValueForDeclaration(decl, variable, evaluator, config, this);
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
                if (null != cst) {
                    evaluator.init(config, config.getResolutionState(), false, null);
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
     * The innermost import will be on top of the stack ({@link List}). The main {@link Project} of the
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
