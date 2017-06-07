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
package net.ssehub.easy.varModel.model.filter;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Filter class for retrieving all {@link AbstractVariable}'s nested inside a given constraint.
 * @see IDecisionVariableInConstraintFinder
 * @author El-Sharkawy
 *
 */
public class DeclrationInConstraintFinder extends AbstractVariableInConstraintFinder {
    
    private Set<AbstractVariable> declarations;
    
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
        super(considerReferences);
        declarations = new HashSet<AbstractVariable>();
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
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
        visitVariable(variable);
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
    protected void addVariable(AbstractVariable declaration) {
        declarations.add(declaration);
    }

}
