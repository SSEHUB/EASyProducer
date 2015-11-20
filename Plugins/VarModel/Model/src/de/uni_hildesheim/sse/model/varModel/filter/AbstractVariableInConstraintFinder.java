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
package de.uni_hildesheim.sse.model.varModel.filter;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;

/**
 * Superclass for searching for variables/declarations inside
 * {@link de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree}s.
 * @author El-Sharkawy
 *
 */
abstract class AbstractVariableInConstraintFinder implements IConstraintTreeVisitor {

    @Override
    public void visitConstantValue(ConstantValue value) {
        // No function needed
    }
    
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) { // user defined function!
            call.getOperand().accept(this);
        }
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }
    
    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);        
    }
    
    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitSelf(Self self) {
        // no variable declaration
    }
}
