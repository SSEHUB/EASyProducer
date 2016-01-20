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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;

/**
 * Part of the {@link ProjectRewriteVisitor}, will collect all relevant elements to facilitate a fast retrieval
 * of needed elements.
 * @author El-Sharkawy
 */
class InitialStructureCollector extends AbstractProjectVisitor {

    private VariableLookUpTable table;
    
    /**
     * Default constructor for this class.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param table The {@link VariableLookUpTable} which shall be initialized.
     */
    InitialStructureCollector(Project originProject, FilterType filterType, VariableLookUpTable table) {
        super(originProject, filterType);
        this.table = table;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        if (null != opdef.getOperation()) {
            ConstraintSyntaxTree cst = opdef.getOperation().getFunction();
            if (null != cst) {
                DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(cst);
                java.util.Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
                for (AbstractVariable usedDecl : usedDeclarations) {
                    if (usedDecl.getType() == ConstraintType.TYPE) {
                        table.putConstraintOccurrence(usedDecl, opdef);
                    }
                }
            }
        }
        
        
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnum(Enum eenum) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompound(Compound compound) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSet(Set set) {
        // TODO Auto-generated method stub
        
    }

}
