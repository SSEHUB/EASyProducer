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
package net.ssehub.easy.varModel.model.filter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Searches for {@link IDecisionVariable}s in a {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}.
 * @see DeclarationInContainerFinder
 * @author El-Sharkawy
 */
public class IDecisionVariableInConstraintFinder extends AbstractVariableInConstraintFinder {

    private Configuration config;
    private Deque<IDecisionVariable> parents;
    private IDecisionVariable lastVariable;
    private Set<IDecisionVariable> variables;
    
    /**
     * Single constructor for this class. <br/>
     * This will <b>not</b> start the visitation, for this the
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree
     *   #accept(net.ssehub.easy.varModel.cst.IConstraintTreeVisitor)} must be called.
     * @param config The underlying configuration, from which the {@link IDecisionVariable}s shall come from.
     * @param considerReferences <tt>true</tt> declarations of
     *   {@link net.ssehub.easy.varModel.model.datatypes.Reference} values will also be found,
     *   <tt>false</tt> these declarations will be omitted. 
     */
    public IDecisionVariableInConstraintFinder(Configuration config, boolean considerReferences) {
        super(considerReferences);
        this.config = config;
        parents = new ArrayDeque<IDecisionVariable>();
        lastVariable = null;
        variables = new HashSet<IDecisionVariable>();
    }
    
    /**
     * Returns all {@link AbstractVariable}'s inside the given
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}.
     * @return A set of nested {@link AbstractVariable}'s (This set must not be <tt>null</tt>).
     */
    public Set<IDecisionVariable> getVariables() {
        return variables;
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
        
        parents.addFirst(lastVariable);
        visitVariable(variable);
        parents.removeFirst();
    }

    @Override
    public void visitLet(Let let) {
        // Here, we are not interested in let variables
//        declarations.add(let.getVariable());
        let.getInExpression().accept(this); 
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        
        parents.addFirst(lastVariable);
        call.getExpression().accept(this);
        parents.removeFirst();
        
        // Here, we are not interested in local declarators
//        for (int i = 0; i < call.getDeclaratorsCount(); i++) {
//            declarations.add(call.getDeclarator(i));
//        } 
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // access.inferDatatype() must be called before access.getResolvedSlot() can be called 
        try {
            access.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        access.getCompoundExpression().accept(this);
        
        parents.addFirst(lastVariable);
        addVariable(access.getResolvedSlot());
        parents.removeFirst();
    }
    
    /**
     * Recursive method to find reference values pointing to a {@link AbstractVariable}.
     * @param value the content of a {@link net.ssehub.easy.varModel.cst.ConstantValue}.
     * @see #visitConstantValue(net.ssehub.easy.varModel.cst.ConstantValue)
     */
    protected void visitValue(Value value) {
        if (null != value) {
            if (value instanceof ContainerValue) {
                ContainerValue containerValue = (ContainerValue) value;
                for (int i = 0; i < containerValue.getElementSize(); i++) {
                    visitValue(containerValue.getElement(i));
                }
            } else if (value instanceof CompoundValue) {
                CompoundValue compoundValue = (CompoundValue) value;
                Compound cType = (Compound) compoundValue.getType();
                for (int i = 0; i < cType.getInheritedElementCount(); i++) {
                    visitValue(compoundValue.getNestedValue(cType.getInheritedElement(i).getName()));
                }
            } else if (value instanceof ReferenceValue) {
                ReferenceValue refValue = (ReferenceValue) value;
                addVariable(refValue.getValue());
            }
        }
    }

    @Override
    protected void addVariable(AbstractVariable declaration) {
        if (!parents.isEmpty()) {
            // Find nested element, e.g., in a compound
            boolean found = false;
            IDecisionVariable parent = parents.peekFirst();
            for (int i = 0, end = parent.getNestedElementsCount(); i < end && !found; i++) {
                IDecisionVariable nestedVariable = parent.getNestedElement(i);
                if (nestedVariable.getDeclaration() == declaration) {
                    lastVariable = nestedVariable;
                    variables.add(lastVariable);
                    found = true;
                }
            }
        } else {
            // Find top level element
            lastVariable = config.getDecision(declaration);
            if (null != lastVariable) {
                variables.add(lastVariable);
            }
        }
    }
}
