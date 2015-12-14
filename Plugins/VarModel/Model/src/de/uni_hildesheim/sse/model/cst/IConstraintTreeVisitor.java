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
package de.uni_hildesheim.sse.model.cst;

/**
 * Defines the interface for a visitor for the constraint tree.
 * 
 * @author Holger Eichelberger
 */
public interface IConstraintTreeVisitor {

    /**
     * Visits a constant value.
     * 
     * @param value the value which should be visited
     */
    public void visitConstantValue(ConstantValue value);

    /**
     * Visits a variable.
     * 
     * @param variable the variable which should be visited
     */
    public void visitVariable(Variable variable);
    
    /**
     * Visits a {@link AttributeVariable}.
     * 
     * @param variable the attribute variable which should be visited
     */
    public void visitAnnotationVariable(AttributeVariable variable);

    /**
     * Visits a parenthesis.
     * 
     * @param parenthesis the parenthesis which should be visited
     */
    public void visitParenthesis(Parenthesis parenthesis);

    /**
     * Visits a comment.
     * 
     * @param comment the comment node which should be visited
     */
    public void visitComment(Comment comment);
    
    /**
     * Visits an OCL feature call.
     * 
     * @param call the feature call which should be visited
     */
    public void visitOclFeatureCall(OCLFeatureCall call);
    
    /**
     * Visits a let expression.
     * 
     * @param let the let expression which should be visited
     */
    public void visitLet(Let let);

    /**
     * Visits an if-then-else expression.
     * 
     * @param ifThen the if-then-else expression which should be visited
     */
    public void visitIfThen(IfThen ifThen);

    /**
     * Visits a container operation call (e.g. quantors, iterators).
     * 
     * @param call the container operation call
     */
    public void visitContainerOperationCall(ContainerOperationCall call);

    /**
     * Visits a compound access node.
     * 
     * @param access the compound access node
     */
    public void visitCompoundAccess(CompoundAccess access);
    
    /**
     * Visits an unresolved expression. Please note that an unresolved
     * expression may represent a leaf as well as an inner tree node.
     * Typically, visitors shall continue visiting transparently at 
     * {@link UnresolvedExpression#getActualExpression()}.
     * 
     * @param expression the expression
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression);
    
    /**
     * Visits a compound initializer.
     * 
     * @param initializer the compound initializer node
     */
    public void visitCompoundInitializer(CompoundInitializer initializer);

    /**
     * Visits a container initializer.
     * 
     * @param initializer the container initializer node
     */
    public void visitContainerInitializer(ContainerInitializer initializer);

    /**
     * Visits self.
     * 
     * @param self the self object to visit
     */
    public void visitSelf(Self self);
}
