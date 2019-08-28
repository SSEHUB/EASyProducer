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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * This class locates all (visible) constraints in an IVML project.
 * @author El-Sharkawy
 *
 */
public class ConstraintFinder implements IModelVisitor {
    
    private List<Constraint> constraints;
    private List<Constraint> evalConstraints;
    private boolean considerImports;
    private boolean excludeAssignments;
    private boolean isEvalConstraint;
    private boolean handleEvals;
    private List<AttributeAssignment> allAttributes;
    
    /**
     * This constructor will consider imported projects.
     * @param project The project, where all constraints should be found.
     */
    public ConstraintFinder(Project project) {
       this(project, true);
    }

    /**
     * Constructor for specifying whether imported projects should be considered while finding the constraints.
     * @param project The project, where all constraints should be found.
     * @param considerImports <tt>true</tt> if constraints of imported projects should also be found
     */
    public ConstraintFinder(Project project, boolean considerImports) {
        this(project, considerImports, false);
    }
    
    /**
     * Constructor for specifying whether imported projects should be considered while finding the constraints.
     * @param project The project, where all constraints should be found.
     * @param considerImports <tt>true</tt> if constraints of imported projects should also be found
     * @param excludeAssignments whether top-level assignments shall be excluded
     */
    public ConstraintFinder(Project project, boolean considerImports, boolean excludeAssignments) {
        this(project, considerImports, false, false);
    }

    /**
     * Constructor for specifying whether imported projects should be considered while finding the constraints.
     * @param project The project, where all constraints should be found.
     * @param considerImports <tt>true</tt> if constraints of imported projects should also be found
     * @param excludeAssignments whether top-level assignments shall be excluded
     * @param handleEvals whether eval constraints should be separated from all constraints.
     */
    public ConstraintFinder(Project project, boolean considerImports, boolean excludeAssignments, boolean handleEvals) {
        constraints = new ArrayList<Constraint>();
        evalConstraints = new ArrayList<Constraint>();
        this.considerImports = considerImports;
        this.excludeAssignments = excludeAssignments;
        this.allAttributes = new ArrayList<AttributeAssignment>();
        this.handleEvals = handleEvals;
        isEvalConstraint = false;
        startAccept(project);
    }
    
    /**
     * Starts accepting in the constructor. Overridden to allow for further initializations.
     * 
     * @param project the project to start accepting
     */
    protected void startAccept(Project project) {
        project.accept(this);
    }

    /**
     * Getter for returning all constraints (except eval) of an ivml project.
     * @return A list of all constraints in the specified ivml project.
     */
    public List<Constraint> getConstraints() {
        return constraints;
    }
    
    /**
     * Getter for returning eval constraints of an ivml project.
     * @return A list of eval constraints in the specified ivml project.
     */
    public List<Constraint> getEvalConstraints() {
        return evalConstraints;
    }
    
    /**
     * Method for returning all attribute assignments.
     * @return All attribute assignments.
     */
    public List<AttributeAssignment> getAttributeAssignments() {
        return allAttributes;
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Not needed method, since this class should only find Constraints
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed method, since this class should only find Constraints 
    }

    @Override
    public void visitCompound(Compound compound) {
        // Not needed method, since this class should only find Constraints
        // TODO check... whether compounds and also attribute assignments shall be visited!
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int v = 0; v < assignment.getConstraintsCount(); v++) {
            assignment.getConstraint(v).accept(this);
        }
        // implicit realizing constraints are not visible as they are implicit
        // may be nested, even on top-level
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
        allAttributes.add(assignment);
    }
   
    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed method, since this class should only find Constraints
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed method, since this class should only find Constraints
    }

    @Override
    public void visitReference(Reference reference) {
        // Not needed method, since this class should only find Constraints   
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Not needed method, since this class should only find Constraints  
    }

    @Override
    public void visitSet(Set set) {
        // Not needed method, since this class should only find Constraints   
    }

    @Override
    public void visitProject(Project project) {
        if (considerImports) {
            for (int i = 0; i < project.getImportsCount(); i++) {
                project.getImport(i).accept(this);
            }
        }
        for (int i = 0; i < project.getElementCount(); i++) {
            project.getElement(i).accept(this);
        }     
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (pImport.isResolved()) {
            pImport.getResolved().accept(this);
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed method, since this class should only find Constraints       
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // Not needed method, since this class should only find Constraints   
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        boolean add = true;
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        if (excludeAssignments) {
            if (cst instanceof OCLFeatureCall) {
                OCLFeatureCall call = (OCLFeatureCall) cst;
                add = !OclKeyWords.ASSIGNMENT.equals(call.getOperation());
            }
        }
        if (add) {
            if (isEvalConstraint && handleEvals) {
                evalConstraints.add(constraint);                    
            } else {
                constraints.add(constraint);                    
            }
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO SE: Not sure whether we need this       
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed method, since this class should only find Constraints  
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        for (int i = 0; i < block.getNestedCount(); i++) {
            block.getNested(i).accept(this);
        }
        isEvalConstraint = true;
        for (int i = 0; i < block.getEvaluableCount(); i++) {
            block.getEvaluable(i).accept(this);
        }
        isEvalConstraint = false;
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed method, since this class should only find Constraints  
    }

    @Override
    public void visitComment(Comment comment) {
        // Not needed method, since this class should only find Constraints  
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // Not needed method, since this class should only find Constraints       
    }

}
