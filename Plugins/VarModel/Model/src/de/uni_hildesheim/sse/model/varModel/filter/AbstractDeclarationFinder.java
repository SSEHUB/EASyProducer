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

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * Abstract super class for finding all toplevel <tt>DecisionVariableDeclaration</tt>'s of a {@link Project}. 
 * @author El-Sharkawy
 *
 */
abstract class AbstractDeclarationFinder extends AbstractProjectVisitor {
    
    /**
     * Sole constructor for this class.
     * @param project The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    protected AbstractDeclarationFinder(Project project, FilterType filterType) {
        super(project, filterType);
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        // Not needed method, since this class should only find DecisionVariableDeclaration       
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed method, since this class should only find DecisionVariableDeclaration       
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        // Not needed method, since this class should only find top-level DecisionVariableDeclarations
        // in case that also compounds shall be visited, please visit the attributeAssignments in compound
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed method, since this class should only find DecisionVariableDeclaration        
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed method, since this class should only find DecisionVariableDeclaration        
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // Not needed method, since this class should only find DecisionVariableDeclaration        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        // Not needed method, since this class should only find DecisionVariableDeclaration       
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }
}
