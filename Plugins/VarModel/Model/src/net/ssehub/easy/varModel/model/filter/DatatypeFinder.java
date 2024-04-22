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

import java.util.LinkedList;
import java.util.List;

import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * Visitor for finding {@link CustomDatatype} of a specific type.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class DatatypeFinder extends AbstractProjectVisitor {

    private List<CustomDatatype> foundDatatypes;
    private IDatatype type;
    
    /**
     * Sole constructor for creating a new {@link DatatypeFinder}.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param type An optional parameter of which kind the found elements should be.
     *     This should be a {@link CustomDatatype}.
     *     If it is <b>null</b> all {@link CustomDatatype} will be collected.
     */
    public DatatypeFinder(Project originProject, FilterType filterType, IDatatype type) {
        super(originProject, filterType);
        foundDatatypes = new LinkedList<CustomDatatype>();
        this.type = type;
        
        //Start visiting
        originProject.accept(this);
    }
    
    /**
     * Returns a list of all found datatypes of the specified {@link CustomDatatype}.
     * @return a list of found {@link CustomDatatype} defined inside the given {@link Project}.
     * This list maybe empty.
     */
    public List<CustomDatatype> getFoundDatatypes() {
        return foundDatatypes;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // No action needed
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // No action needed
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // No action needed
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // No action needed
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // No action needed
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // No action needed
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // No action needed
    }

    @Override
    public void visitComment(Comment comment) {
        // No action needed
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // Continue visiting, because a datatype could be defined inside an attribute assignment
        for (int i = 0; i < assignment.getElementCount(); i++) {
            assignment.getElement(i).accept(this);
        }
    }

    @Override
    public void visitEnum(Enum eenum) {
        visitIDatatype(eenum);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        visitIDatatype(eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        visitIDatatype(compound);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        if (null == type || type == DerivedDatatype.TYPE) {
            foundDatatypes.add(datatype);
        }
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // No action needed
    }

    @Override
    public void visitReference(Reference reference) {
        visitIDatatype(reference);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        visitIDatatype(sequence);
    }

    @Override
    public void visitSet(Set set) {
        visitIDatatype(set);
    }

    /**
     * Checks whether the visited datatype definition is an instance of
     * the specified {@link #type} and adds the type definition to the
     * list of found elements.
     * @param typeDefinition The visited datatype definition, which should be added
     * to the list of found elements, if it is an instance of {@link #type}.
     */
    private void visitIDatatype(CustomDatatype typeDefinition) {
        if (null != type) {
            if (type != DerivedDatatype.TYPE && type.isAssignableFrom(typeDefinition)) {
                foundDatatypes.add(typeDefinition);
            }            
        } else {
            foundDatatypes.add(typeDefinition);            
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // No action needed
    }

}