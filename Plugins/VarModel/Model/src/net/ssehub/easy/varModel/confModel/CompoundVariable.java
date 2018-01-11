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
package net.ssehub.easy.varModel.confModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.confModel.paths.NameAccessPathElement;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Class for variables of Compounds.
 * @author El-Sharkawy
 *
 */
public class CompoundVariable extends StructuredVariable {
    
    private Map<String, IDecisionVariable> nestedElements;
    private Compound instantiatableType;
    
    /**
     * Sole constructor for creating {@link ContainerVariable}'s.
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds/container also the containing {@link IDecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     * @param isAttribute whether this variable represents (a part of) an attribute or a variable
     */
    CompoundVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible, 
        boolean isAttribute) {
        super(parent, varDeclaration, isVisible, isAttribute);
        if (null == nestedElements) {
            nestedElements = new LinkedHashMap<String, IDecisionVariable>();
        }
        // this is only for the base type - in case of a more specific type, missing nestedElements will be
        // created upon setting the value
        
        instantiatableType = (Compound) DerivedDatatype.resolveToBasis(varDeclaration.getType());
        if (instantiatableType.isAbstract()) {
            // cannot be instantiated, search closest
            Collection<Compound> candidates = instantiatableType.implementingNonAbstract(
                parent.getConfiguration().getProject()); // right project?
            candidates = instantiatableType.closestRefining(candidates);
            if (candidates.size() > 0) {
                instantiatableType = candidates.iterator().next();
            } // this is a problem with the current approach, as this compound cannot be instantiated -> IVML error
        }
        
        for (int i = 0; i < instantiatableType.getInheritedElementCount(); i++) {
            createNestedElement(instantiatableType.getInheritedElement(i), isVisible, isAttribute);
        }

        // Dirty: Initialize "static" assign blocks for newly created nested variable
        // TODO consider nested assign blocks
        resolveAssignBlocks(instantiatableType);
    }
    
    @Override
    public IDatatype getInstantiatableType() {
        // condition for potential legacy serialization tests, which do not initialize attribute
        return null == instantiatableType ? super.getInstantiatableType() : instantiatableType; 
    }

    /**
     * Recursive part of the constructor to resolve annotation assignment blocks of (parent/this) compound.
     * @param cType The currently analyzed compound
     * (should be called the (refined) compound type of this variable instance).
     */
    private void resolveAssignBlocks(Compound cType) {
        // Top-Down to allow overriding in refined compounds -> Start with parent
        for (int r = 0; r < cType.getRefinesCount(); r++) {
            resolveAssignBlocks(cType.getRefines(r));
        }
        
        // Resolve values for all top level assign blocks inside this compound,
        // recursive method will automatically include nested assign blocks
        for (int a = 0; a < cType.getAssignmentCount(); a++) {
            AttributeAssignment assignBlock = cType.getAssignment(a);
            resolveAssignBlocks(assignBlock, new HashMap<String, Value>());
        }
    }

    /**
     * Second recursive part of {@link #resolveAssignBlocks(Compound)}, find (nested assign blocks) inside the
     * currently visited compound and set values to the associated {@link IDecisionVariable}s.
     * @param assignBlock The currently visited assign block (start with assign blocks directly nested inside the
     * compound).
     * @param annotationValues Mapping of (annotation name, value). Start with an empty map and copy values into a new
     * map for each recursive call.
     */
    private void resolveAssignBlocks(AttributeAssignment assignBlock, Map<String, Value> annotationValues) {
        // Find annotation values
        for (int i = 0, n = assignBlock.getAssignmentDataCount(); i < n; i++) {
            Assignment annotationAssignment = assignBlock.getAssignmentData(i);
            ConstraintSyntaxTree assignmentCST = annotationAssignment.getExpression();
            EvaluationVisitor evalVisitor = new EvaluationVisitor();
            evalVisitor.init(getConfiguration(), null, false, null);
            assignmentCST.accept(evalVisitor);
            Value annotationValue = evalVisitor.getResult();
            if (null != annotationValue) {
                annotationValues.put(annotationAssignment.getName(), annotationValue);
            }
        }
        
        // Find variables for which the values must be applied
        for (int i = 0, n = assignBlock.getModelElementCount(); i < n; i++) {
            ContainableModelElement element = assignBlock.getModelElement(i);
            if (element instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration nestedDeclaration = (DecisionVariableDeclaration) element;
                IDecisionVariable nestedVariable = getNestedVariable(nestedDeclaration.getName());
                if (null != nestedVariable) {
                    for (int j = 0, m = nestedVariable.getAttributesCount(); j < m; j++) {
                        IDecisionVariable annotation = nestedVariable.getAttribute(j);
                        Value annotationValue = annotationValues.get(annotation.getDeclaration().getName());
                        if (null != annotationValue) {
                            try {
                                annotation.setValue(annotationValue, AssignmentState.DEFAULT);
                            } catch (ConfigurationException e) {
                                // Should not occur
                                Bundle.getLogger(CompoundVariable.class).exception(e);
                            }
                        }
                    }
                }                    
            } else if (element instanceof AttributeAssignment) {
                AttributeAssignment nestedAssignBlock = (AttributeAssignment) element;
                resolveAssignBlocks(nestedAssignBlock, new HashMap<String, Value>(annotationValues));
            }
        }
    }
    
//    /**
//     * Adds nested elements due to attribute assignments.
//     * 
//     * @param assng the assignment
//     * @param isVisible specifies whether the parent variable is exported by an interface or not
//     */
//    @SuppressWarnings("unused") // see constructor
//    private void addNestedElements(AttributeAssignment assng, boolean isVisible) {
//        for (int e = 0; e < assng.getElementCount(); e++) {
//            createNestedElement(assng.getElement(e), isVisible);
//        }
//        for (int a = 0; a < assng.getAssignmentCount(); a++) {
//            addNestedElements(assng.getAssignment(a), isVisible);
//        }
//    }

    /**
     * Creates a nested element due to its declaration.
     * 
     * @param decl the variable declaration
     * @param isVisible specifies whether the parent variable is exported by an interface or not
     * @param isAttribute whether this variable represents (a part of) an attribute or a variable
     */
    private void createNestedElement(AbstractVariable decl, boolean isVisible, boolean isAttribute) {
        VariableCreator creator = new VariableCreator(decl, this, isVisible, isAttribute);
        try {
            IDecisionVariable nestedVar = creator.getVariable(false);
            nestedElements.put(decl.getName(), nestedVar);
        } catch (ConfigurationException e) {
            // Should not occur
            e.printStackTrace();
        }
    }
    
    @Override
    public IAssignmentState getState() {
        IAssignmentState state = super.getState();
        
        // check whether the whole compound was frozen already
        if (state != AssignmentState.FROZEN && ownStateAllowed()) {
            if (getValue() != NullValue.INSTANCE) {
                CompoundValue cmpValue = (CompoundValue) getValue();
                if (cmpValue != null && null != cmpValue.getValue()) {                
                    state = AssignmentState.ASSIGNED;    
                } else {
                    state = AssignmentState.UNDEFINED;
                }                
            }
        }
        
        return state;
    }

    @Override
    public int getNestedElementsCount() {
        return null == nestedElements ? 0 : nestedElements.size();
    }

    @Override
    public IDecisionVariable getNestedElement(int index) {
        return (IDecisionVariable) nestedElements.values().toArray()[index];
    }
    
    @Override
    public IDecisionVariable getNestedElement(String name) {
        return nestedElements.get(name);
    }

    @Override
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        IDecisionVariable nestedVar = getNestedVariable(nested.getDeclaration().getName());
        nestedVar.setValue(value, state);        
    }
    
    /**
     * {@inheritDoc}<br/>
     * Sets also the states for the nested elements.
     */
    @Override
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        super.setValue(value, state); // TODO if state==FREEZE this leads to Exception in second part
        if (null != value && value != NullValue.INSTANCE) {
            CompoundValue cmpValue = (CompoundValue) value;
            Compound cmpType = (Compound) DerivedDatatype.resolveToBasis(getDeclaration().getType());
            
            // polymorphic case - vType is more specific, then nested elements are missing
            if (!value.getType().equals(cmpType)) {
                // might be helpful to store the actual type... let's see
                Set<String> itemNames = new HashSet<String>();
                itemNames.addAll(nestedElements.keySet());
                Compound vType = (Compound) value.getType();
                for (int i = 0; i < vType.getInheritedElementCount(); i++) {
                    AbstractVariable nestedItem = vType.getInheritedElement(i);
                    String name = nestedItem.getName();
                    if (!nestedElements.containsKey(name)) { // may already exist as assigned before
                        VariableCreator creator = new VariableCreator(nestedItem, this, isVisible(), false);
                        try {
                            nestedElements.put(name, creator.getVariable(false));
                        } catch (ConfigurationException e) {
                            // Should not occur
                            e.printStackTrace();
                        }
                    }
                    // cleanup in case of setting different types
                    itemNames.remove(name);
                }
                for (String name : itemNames) {
                    nestedElements.remove(name);
                }
            }
            
            for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
                String slotName = cmpType.getInheritedElement(i).getName();
                if (null != slotName && null != cmpValue.getNestedValue(slotName)) {
                    DecisionVariable nestedVar = (DecisionVariable) nestedElements.get(slotName);
                    Value nestedValue = cmpValue.getNestedValue(slotName);
                    if (null != nestedVar) {
//                        nestedVar.setState(state);
                        IAssignmentState nestedState = nestedVar.getState();
                        // Overwrite value only if it was not user defined.
                        if (nestedState != AssignmentState.USER_ASSIGNED || state == AssignmentState.USER_ASSIGNED) {
                            nestedVar.setValue(nestedValue, state);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Returns a nested {@link IDecisionVariable}.
     * @param slotName The name of the nested {@link IDecisionVariable} to be returned.
     * @return The nested {@link IDecisionVariable} with the same name or <tt>null</tt>.
     */
    public IDecisionVariable getNestedVariable(String slotName) {
        return nestedElements.get(slotName);
    }

    @Override
    public void freeze(String nestedElement) {
        IDecisionVariable nestedVar = nestedElements.get(nestedElement);
        nestedVar.freeze(AllFreezeSelector.INSTANCE);
    }
    
    @Override
    public void freeze(IFreezeSelector selector) {
        super.freeze(selector);
        for (IDecisionVariable var : nestedElements.values()) {
            var.freeze(selector);
        }
    }
    
    @Override
    public void unfreeze(IAssignmentState state) {
        super.unfreeze(state);
        for (IDecisionVariable var : nestedElements.values()) {
            var.unfreeze(state);
        }
    }

    @Override
    boolean allowsNestedStates() {
        return true;
    }
    
    @Override
    public Value getValue() {
        Value value = super.getValue();
        if (null == value) {
            try {
                value = ValueFactory.createValue(getInstantiatableType(), (Object[]) null);
                setValue(value, AssignmentState.UNDEFINED);
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        
        return value;
    }

    @Override
    public boolean removeDerivedValues() {
        boolean changed = false;
        for (IDecisionVariable var : nestedElements.values()) {
            if (AssignmentState.ASSIGNED != var.getState()) {
                var.removeDerivedValues();
                changed = true;
            }
        }
        
        return changed;
    }

    /**
     * Returns the resolution path for a nested element.
     * 
     * @param nested the nested element
     * @return the resolution path
     */
    protected IResolutionPathElement getPathForNestedElement(IDecisionVariable nested) {
        IResolutionPathElement result = null;
        for (Map.Entry<String, IDecisionVariable> entry : nestedElements.entrySet()) {
            if (entry.getValue() == nested) {
                result = new NameAccessPathElement(getResolutionPath(), entry.getKey());
                break;
            }
        }
        return result;
    }
    
}
