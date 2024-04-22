/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Part of the {@link RewriteContext} to speed up {@link IDecisionVariable} retrieval.
 * @author El-Sharkawy
 *
 */
class VariableLookUpTable {

    private boolean initialized;
    /**
     * List of instances for a given {@link IDatatype}.
     * Is used to speed up {@link Configuration} based
     * {@link net.ssehub.easy.varModel.model.rewrite.modifier.IModelElementFilter}.
     * Contains toplevel and nested variables as well as annotations.
     */
    private Map<IDatatype, Set<IDecisionVariable>> instancesPerType;
    
    /**
     * List of instances for a given declaration.
     * Is used to speed up {@link Configuration} based
     * {@link net.ssehub.easy.varModel.model.rewrite.modifier.IModelElementFilter}.
     * Contains toplevel and nested variables as well as annotations.
     */
    private Map<AbstractVariable, Set<IDecisionVariable>> instancesPerDeclaration;
    
    /**
     * List model elements, reusing a constraint variable (declaration).
     * A tuple in form of (Constraint Variable declaration,  Set of reusing elements).
     * For instance:
     * <code>
     * Constraint cVar = ...;
     * def Boolean func(Integer intVar) = cVar &amp;&amp; ...;
     * </code>
     */
    private Map<AbstractVariable, Set<ContainableModelElement>> constraintReusers;
    
    /**
     * List model elements, calling a constraint variable (declaration).
     * A tuple in form of (Calling element  Set of called constraint variables).
     * Inverse to {@link #constraintReusers}
     * For instance:
     * <code>
     * Constraint cVar = func(aVariable);
     * def Boolean func(Integer intVar) = intVar > 10;
     * </code>
     * @see #constraintReusers
     */
    //private Map<ContainableModelElement, Set<AbstractVariable>> calledByConstraintVars;
    
    private Set<AbstractVariable> definedDeclarations;
    
    /**
     * Single constructor for this class.
     */
    VariableLookUpTable() {
        initialized = false;
        instancesPerType = new HashMap<IDatatype, Set<IDecisionVariable>>();
        instancesPerDeclaration = new HashMap<AbstractVariable, Set<IDecisionVariable>>();
        definedDeclarations = new HashSet<AbstractVariable>();
        constraintReusers = new HashMap<AbstractVariable, Set<ContainableModelElement>>();
        //calledByConstraintVars = new HashMap<ContainableModelElement, Set<AbstractVariable>>();
    }
    
    /**
     * Creates the internal look up tables and should be called if it is the first time used.
     * Multiple calls will ignored.
     * @param config The used configuration.
     */
    void init(Configuration config) {
        if (!initialized) {
            for (IDecisionVariable variable : config) {
                init(variable);
            }
            
            // Make elements unmodifiable as they will be returned directly.
            for (Map.Entry<IDatatype, Set<IDecisionVariable>> entry : instancesPerType.entrySet()) {
                instancesPerType.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
            }
            for (Map.Entry<AbstractVariable, Set<IDecisionVariable>> entry : instancesPerDeclaration.entrySet()) {
                instancesPerDeclaration.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
            }
            
            initialized = true;
        }
    }
    
    /**
     * Recursive part of {@link #init(Configuration)}.
     * Will add the variable as well as all nested variables and annotations.
     * Adapt this method if further tables are needed.
     * @param variable A {@link IDecisionVariable} of the configuration.
     */
    private void init(IDecisionVariable variable) {
        // Add the variable itself
        IDatatype type = variable.getDeclaration().getType();
        addVariable(variable, type);
        
        // Add nested variables
        for (int i = variable.getNestedElementsCount() - 1; i >= 0; i--) {
            IDecisionVariable nestedVariable = variable.getNestedElement(i);
            init(nestedVariable);
        }
        
        // Add annotations;
        for (int i = variable.getAttributesCount() - 1; i >= 0; i--) {
            IDecisionVariable annotation = variable.getAttribute(i);
            init(annotation);
        }
    }

    /**
     * Adds an {@link IDecisionVariable} to the {@link #instancesPerType}.
     * @param variable The variable to add
     * @param type The type of the variable.
     */
    private void addVariable(IDecisionVariable variable, IDatatype type) {
        AbstractVariable declaration = variable.getDeclaration();

        // Add the declaration to known declarations
        definedDeclarations.add(declaration);
        
        // Add the variable to its declaration
        Set<IDecisionVariable> instances = instancesPerDeclaration.get(declaration);
        if (null == instances) {
            instances = new HashSet<IDecisionVariable>();
            instancesPerDeclaration.put(declaration, instances);
        }
        instances.add(variable);

        // Add the variable to its specified type
        if (null != type) {            
            instances = instancesPerType.get(type);
            if (null == instances) {
                instances = new HashSet<IDecisionVariable>();
                instancesPerType.put(type, instances);
            }
            instances.add(variable);
            
            // Add the variable to parent types
            if (type instanceof Compound) {
                Compound cType = (Compound) type;
                for (int r = 0; r < cType.getRefinesCount(); r++) {
                    addVariable(variable, cType.getRefines(r));
                }
            } else if (type instanceof Reference) {
                IDatatype referedType = Reference.dereference(type);
                addVariable(variable, referedType);
            } else if (type instanceof DerivedDatatype) {
                IDatatype basisType = ((DerivedDatatype) type).getBasisType();
                addVariable(variable, basisType);
            }
        }
    }
    
    /**
     * Returns the set of instances of the given {@link IDatatype}.
     * @param type The <b>exact</b> {@link IDatatype} for which the instances shall be returned,
     * will <b>not</b> consider {@link IDatatype#isAssignableFrom(IDatatype)}.
     * @return The instances for the given type or <b>null</b> if no instances exist.
     */
    Set<IDecisionVariable> getInstancesForType(IDatatype type) {
        return instancesPerType.get(type);
    }
    
    /**
     * Returns the set of instances of the given {@link AbstractVariable} declaration.
     * @param declaration The declaration for which the instances shall be returned.
     * If the declaration is nested inside a compound which was multiple times instantiated, this single declaration
     * could return multiple {@link IDecisionVariable}s.
     * @return The instances for the given declaration or <b>null</b> if no instances exist.
     */
    Set<IDecisionVariable> getInstancesForDeclaration(AbstractVariable declaration) {
        return instancesPerDeclaration.get(declaration);
    }
    
    /**
     * Checks whether the declaration is known or whether the declaration is a local declaration used as
     * an iterator of a constraint.
     * Needs that this {@link VariableLookUpTable} was already initialized with a {@link Configuration}.
     * @param declaration The declaration to check.
     * @return {@code true} if the declaration is used for a {@link IDecisionVariable} of the configuration or
     * if this table was not initialized with a {@link Configuration}, {@code false} otherwise.
     */
    boolean declarationKnown(AbstractVariable declaration) {
        return initialized ? definedDeclarations.contains(declaration) : true;
    }
    
    /**
     * Stores that the given constraint declaration was used inside the referring element.
     * @param constraintDecl A constraint declaration used inside the second parameter.
     * @param referringElement An element which may use a constraint declaration as part of its own definition, e.g.,
     * another constraint declaration, a {@link net.ssehub.easy.varModel.model.Constraint} or a
     * {@link net.ssehub.easy.varModel.model.OperationDefinition}.
     */
    void putConstraintOccurrence(AbstractVariable constraintDecl, ContainableModelElement referringElement) {
        Set<ContainableModelElement> occurrences = constraintReusers.get(constraintDecl);
        if (null == occurrences) {
            occurrences = new HashSet<ContainableModelElement>();
            constraintReusers.put(constraintDecl, occurrences);
        }
        occurrences.add(referringElement);
    }
}
