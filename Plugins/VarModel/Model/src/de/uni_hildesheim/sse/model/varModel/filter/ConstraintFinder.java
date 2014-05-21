package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
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
 * This class locates all (visible) constraints in a ivml project.
 * @author El-Sharkawy
 *
 */
public class ConstraintFinder implements IModelVisitor {
    
    private List<Constraint> constraints;
    private boolean considerImports;
    
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
        constraints = new ArrayList<Constraint>();
        this.considerImports = considerImports;
        project.accept(this);
    }
    
    /**
     * Getter for returning all constraints of an ivml project.
     * @return A list of all constraints in the specified ivml project.
     */
    public List<Constraint> getConstraints() {
        return constraints;
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        // Not needed method, since this class should only find Constraints
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed method, since this class should only find Constraints 
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        // Not needed method, since this class should only find Constraints
        // TODO check... whether compounds and also attribute assignments shall be visited!
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int v = 0; v < assignment.getConstraintsCount(); v++) {
            assignment.getConstraint(v).accept(this);
        }
        // implicit realizing constraints are not visible as they are implicit
        // may be nested, even on top-level
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
    }
   
    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed method, since this class should only find Constraints
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed method, since this class should only find Constraints
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // Not needed method, since this class should only find Constraints   
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        // Not needed method, since this class should only find Constraints  
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        // Not needed method, since this class should only find Constraints   
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitProjectImport(ProjectImport pImport) {
        if (pImport.isResolved()) {
            pImport.getResolved().accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed method, since this class should only find Constraints       
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // Not needed method, since this class should only find Constraints   
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        constraints.add(constraint);       
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO SE: Not sure whether we need this       
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed method, since this class should only find Constraints  
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        for (int i = 0; i < block.getEvaluableCount(); i++) {
            block.getEvaluable(i).accept(this);
        }       
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed method, since this class should only find Constraints  
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // Not needed method, since this class should only find Constraints  
    }

}
