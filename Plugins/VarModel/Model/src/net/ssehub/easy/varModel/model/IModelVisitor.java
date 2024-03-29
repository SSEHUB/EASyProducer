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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.model.datatypes.ICustomDatatypeVisitor;

/**
 * IModelVisitor interface. <br/>
 * Derived visitors can be used for:
 * <ul>
 * <li>saving</li>
 * <li>copying</li>
 * <li>testing properties such as (partial) equality</li>
 * <li>translating a model</li>
 * </ul>
 * the whole variability model or parts of it. See {@link AbstractVisitor} for
 * a basic implementation of default visiting sequences.<br/>
 * The IVML data model provides further visitors which are specific for the
 * {@linkplain net.ssehub.easy.varModel.model.values.IValueVisitor values} or the
 * {@linkplain net.ssehub.easy.varModel.cst.IConstraintTreeVisitor constraint syntax tree}.
 * A specific visitor 
 * implementation may implement all required interfaces at once or delegate to
 * individual classes implementing the interfaces. 
 * 
 * @author Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 * @see net.ssehub.easy.varModel.management.VarModel
 */
public interface IModelVisitor extends ICustomDatatypeVisitor {

    // use of ConstraintTreeVisitor is left to the user of this interface!
    // visiting constraints is optional
   
    /**
     * Method for visiting a project.
     * 
     * @param project The project which should be visited.
     */
    public void visitProject(Project project);

    /**
     * This method is used for visiting a ProjectImport.
     * 
     * @param pImport One ProjectImport which should be visited.
     */
    public void visitProjectImport(ProjectImport pImport);

    /**
     * This method is used for visiting a decision variable declaration.
     * 
     * @param decl One declaration which should be visited.
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl); 
    
    /**
     * Method for visiting an attribute.
     * 
     * @param attribute The attribute which should be visited.
     */
    public void visitAttribute(Attribute attribute);

    /**
     * Method for visiting a constraint.
     * 
     * @param constraint The constraint which should be visited.
     */
    public void visitConstraint(Constraint constraint);

    /**
     * Method for visiting a freeze block.
     * 
     * @param freeze The freeze block which should be visited.
     */
    public void visitFreezeBlock(FreezeBlock freeze);

    /**
     * Method for visiting an operation definition.
     * 
     * @param opdef The operation definition which should be visited.
     */
    public void visitOperationDefinition(OperationDefinition opdef);

    /**
     * Method for visiting a partial evaluation block.
     * 
     * @param block The partial evaluation block which should be visited.
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block);

    /**
     * Method for visiting a project interface.
     * 
     * @param iface The interface which should be visited.
     */
    public void visitProjectInterface(ProjectInterface iface);
    
    /**
     * Method for visiting a comment.
     * 
     * @param comment the comment to visit
     */
    public void visitComment(Comment comment);

    /**
     * Visits an attribute assignment.
     * 
     * @param assignment the assignment to visit
     */
    public void visitAttributeAssignment(AttributeAssignment assignment);

    /**
     * Visits a compound access statement (may occur in freeze blocks.
     * 
     * @param access the access statement
     */
    public void visitCompoundAccessStatement(CompoundAccessStatement access);
    
}
