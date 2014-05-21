package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
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
 * Extracts all namespaces (project names) of a given project, including all imported projects.
 * @author El-Sharkawy
 *
 */
public class NamespaceFinder extends AbstractProjectVisitor {
    
    private List<String> namepsaces;
    
    /**
     * Constructor for getting all namespaces including all imported namepsaces.
     * @param project The root project.
     */
    public NamespaceFinder(Project project) {
        super(project, FilterType.ALL);
        namepsaces = new ArrayList<String>();
        project.accept(this);
    }
    
    /**
     * Returns the retrieved namespaces.
     * @return A list containing all namepsace, will not be <tt>null</tt>.
     */
    public List<String> getNamespaces() {
        return namepsaces;
    }

    @Override
    public void visitProject(Project project) {
        namepsaces.add(project.getName());
        super.visitProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * {@inheritDoc}
     */

    public void visitOrderedEnum(OrderedEnum eenum) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        // TODO Auto-generated method stub
        
    }

}
