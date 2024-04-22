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

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DeclrationInConstraintFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;

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
        collectNestedConstraintVariables(decl.getDefaultValue(), decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        collectNestedConstraintVariables(constraint.getConsSyntax(), constraint);
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        if (null != opdef.getOperation()) {
            ConstraintSyntaxTree cst = opdef.getOperation().getFunction();
            collectNestedConstraintVariables(cst, opdef);
        }
    }

    /**
     * Finds all nested constraint variables in the given {@link ConstraintSyntaxTree} and adds them to the
     * {@link VariableLookUpTable}.
     * @param cst The {@link ConstraintSyntaxTree} to analyze, should be part of {@code element}. Nothing will
     * be done if it is <b>null</b>.
     * @param element The element to add (should be the parent of {@code cst}).
     */
    private void collectNestedConstraintVariables(ConstraintSyntaxTree cst, ContainableModelElement element) {
        if (null != cst) {
            DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(cst);
            java.util.Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
            for (AbstractVariable usedDecl : usedDeclarations) {
                if (null != usedDecl && usedDecl.getType() == ConstraintType.TYPE) {
                    table.putConstraintOccurrence(usedDecl, element);
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
