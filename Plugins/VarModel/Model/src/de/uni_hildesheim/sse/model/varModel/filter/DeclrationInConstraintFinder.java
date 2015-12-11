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
package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Filter class for retrieving all {@link AbstractVariable}'s nested inside a given constraint.
 * @author El-Sharkawy
 *
 */
public class DeclrationInConstraintFinder extends AbstractVariableInConstraintFinder {
    
    private Set<AbstractVariable> declarations;
    private boolean considerReferences;
    
    /**
     * Default constructor for this class.
     * @param cst A constraint where all nested {@link AbstractVariable}'s should be found.
     */
    public DeclrationInConstraintFinder(ConstraintSyntaxTree cst) {
        this(cst, false);
    }
    
    /**
     * Constructor for this class to specify whether (reference) values should also be visited. 
     * @param cst A constraint where all nested {@link AbstractVariable}'s should be found.
     * @param considerReferences <tt>true</tt> values will also be visited to discover used declarations inside
     * reference values, <tt>false</tt> these values will be ignored.
     */
    public DeclrationInConstraintFinder(ConstraintSyntaxTree cst, boolean considerReferences) {
        declarations = new HashSet<AbstractVariable>();
        this.considerReferences = considerReferences;
        cst.accept(this);
    }
    
    /**
     * Returns all {@link AbstractVariable}'s inside the given {@link ConstraintSyntaxTree}.
     * @return A set of nested {@link AbstractVariable}'s (This set must not be <tt>null</tt>).
     */
    public Set<AbstractVariable> getDeclarations() {
        return declarations;
    }

    @Override
    public void visitVariable(Variable variable) {
        declarations.add(variable.getVariable());
    }


    @Override
    public void visitLet(Let let) {
        declarations.add(let.getVariable());
        let.getInExpression().accept(this);  
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int i = 0; i < call.getDeclaratorsCount(); i++) {
            declarations.add(call.getDeclarator(i));
        } 
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
        declarations.add(access.getResolvedSlot());
        access.getCompoundExpression().accept(this);
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        if (considerReferences) {
            visitValue(value.getConstantValue());
        }
    }
    
    /**
     * Recursive method to find reference values pointing to a {@link AbstractVariable}.
     * @param value the content of a {@link ConstantValue}.
     * @see #visitConstantValue(ConstantValue)
     */
    private void visitValue(Value value) {
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
                declarations.add(refValue.getValue());
            }
        }
    }
}
