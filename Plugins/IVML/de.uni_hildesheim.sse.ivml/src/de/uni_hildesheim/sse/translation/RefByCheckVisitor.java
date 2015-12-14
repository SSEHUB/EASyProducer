/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.translation;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;

/**
 * A simple visitor checking whether an expression can be dereferenced.
 * 
 * @author Holger Eichelberger
 */
public class RefByCheckVisitor implements IConstraintTreeVisitor {

    private boolean canBeDereferenced = false;

    /**
     * Returns whether the visited expression can be dereferenced.
     * 
     * @return <code>true</code> if it can be dereferenced, <code>false</code> else
     */
    public boolean canBeDereferenced() {
        return canBeDereferenced;
    }
    
    /**
     * Resets the value determined by this visitor.
     */
    public void reset() {
        canBeDereferenced = false;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        canBeDereferenced = false;
    }
    
    @Override
    public void visitVariable(Variable variable) {
        canBeDereferenced = true;
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        Operation op = call.getResolvedOperation();
        if (Sequence.AT == op || Sequence.INDEX_ACCESS == op) {
            // TODO can we do this more generically
            canBeDereferenced = true;
        } else {
            canBeDereferenced = false;
        }
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        if (null != ifThen.getThenExpr()) {
            boolean tmp = canBeDereferenced;
            ifThen.getThenExpr().accept(this);
            canBeDereferenced &= tmp;
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        IDatatype ret = call.getResolvedOperation().getReturns();
        canBeDereferenced = Container.TYPE.isAssignableFrom(ret) || Compound.TYPE.isAssignableFrom(ret); 
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        canBeDereferenced = true; // goes to a variable
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        canBeDereferenced = false;
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        canBeDereferenced = false;
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        canBeDereferenced = false;
    }

    @Override
    public void visitSelf(Self self) {
        canBeDereferenced = true;
    }

}
