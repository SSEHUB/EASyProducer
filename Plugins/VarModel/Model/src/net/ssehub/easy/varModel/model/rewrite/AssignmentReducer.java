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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.AbstractConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Part of the {@link ProjectRewriteVisitor} to remove sub values of a RHS of an assignment, if declarations
 * of this assignments have been removed.<br/>
 * Visiting should be started with {@link #reduce(OCLFeatureCall)} instead of using the usual
 * <tt>accept</tt> methods.
 * @author El-Sharkawy
 *
 */
class AssignmentReducer extends AbstractConstraintTreeVisitor {

    private RewriteContext context;
    private ConstraintSyntaxTree result;
    private boolean filtered;
    
    /**
     * Default constructor.
     * @param context The context, containing information about filtered elements.
     */
    AssignmentReducer(RewriteContext context) {
        this.context = context;
        result = null;
        filtered = false;
    }
    
    /**
     * Start method for reducing assignments.
     * @param assignment And assignment constraint.
     * @return Will return
     * <ul>
     *   <li>The passed call, if if was not an assignment or if nothing was to filter</li>
     *   <li>The filtered assignment, if some of the used elements were removed</li>
     *   <li><tt>null</tt>, if all elements or necessary elements have been removed.</li>
     * </ul>
     */
    protected ConstraintSyntaxTree reduce(OCLFeatureCall assignment) {        
        result = assignment;
        
        if (OclKeyWords.ASSIGNMENT.equals(assignment.getOperation())) {
            result = null;
            assignment.getParameter(0).accept(this);
            
            if (filtered && null != result) {
                result = new OCLFeatureCall(assignment.getOperand(), assignment.getOperation(), result);
                try {
                    // Needed for setting the correct operation
                    result.inferDatatype();
                } catch (CSTSemanticException e) {
                    result = null;
                    Bundle.getLogger(AssignmentReducer.class).exception(e);
                }
            } else if (!filtered) {
                result = assignment;
            }
        }
        
        return result;
    }
    /**
     * Returns whether the given assignment was filtered or not.
     * @return <tt>true</tt> Something was filtered, <tt>false</tt> assignment is at it was before.
     */
    boolean hasFiltered() {
        return filtered;
    }
    
    @Override
    public void visitConstantValue(ConstantValue constValue) {
        ValueCopy copy = new ValueCopy(context, constValue.getConstantValue());
        if (copy.valuesOmitted()) {
            filtered = true;
            Value filteredValue = copy.getValue();
            result = null != filteredValue ? new ConstantValue(filteredValue) : null;
        }
    }
    
    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        List<String> slots = new ArrayList<String>();
        List<AbstractVariable> decls = new ArrayList<AbstractVariable>();
        List<ConstraintSyntaxTree> csts = new ArrayList<ConstraintSyntaxTree>();
        boolean currentlyFiltered = filtered;
        
        for (int i = 0, end = initializer.getSlotCount(); i < end; i++) {
            AbstractVariable decl = initializer.getSlotDeclaration(i);
            if (!context.elementWasRemoved(decl)) {
                filtered = false;
                ConstraintSyntaxTree cst = initializer.getExpression(i);
                cst.accept(this);
                if (filtered) {
                    cst = result;
                }
                
                if (null != cst) {
                    slots.add(initializer.getSlot(i));
                    decls.add(decl);
                    csts.add(cst);
                }
            }
        }
        
        filtered = currentlyFiltered;
        if (!slots.isEmpty()) {
            if (slots.size() < initializer.getSlotCount()) {
                // Some parts are filtered
                try {
                    filtered = true;
                    result = new CompoundInitializer(initializer.getType(), slots.toArray(new String[0]),
                            decls.toArray(new AbstractVariable[0]), csts.toArray(new ConstraintSyntaxTree[0]));
                } catch (CSTSemanticException e) {
                    Bundle.getLogger(AssignmentReducer.class).exception(e);
                }
            } else {
                // Keep it as it is
                result = initializer;
            }
        } else {
            // Completely filtered
            result = null;
            filtered = true;
        }
    }
    
    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        List<ConstraintSyntaxTree> csts = new ArrayList<ConstraintSyntaxTree>();
        boolean currentlyFiltered = filtered;
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            filtered = false;
            ConstraintSyntaxTree cst = initializer.getExpression(i);
            cst.accept(this);
            
            if (filtered) {
                cst = result;
            }
            
            if (null != cst) {
                csts.add(cst);
            }
        }
        
        filtered = currentlyFiltered;
        if (!csts.isEmpty()) {
            if (csts.size() < initializer.getExpressionCount()) {
                // Some parts are filtered
                try {
                    filtered = true;
                    result = new ContainerInitializer(initializer.getType(), csts.toArray(new ConstraintSyntaxTree[0]));
                } catch (CSTSemanticException e) {
                    Bundle.getLogger(AssignmentReducer.class).exception(e);
                }
            } else {
                // Keep it as it is
                result = initializer;
            }
        } else {
            // Completely filtered
            result = null;
            filtered = true;
        }
    }
}
