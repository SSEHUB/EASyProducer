package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.LinkedList;
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
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

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
     *     If it is <tt>null</tt> all {@link CustomDatatype} will be collected.
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

    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttribute(Attribute attribute) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraint(Constraint constraint) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitFreezeBlock(FreezeBlock freeze) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitOperationDefinition(OperationDefinition opdef) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitProjectInterface(ProjectInterface iface) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // Continue visiting, because a datatype could be defined inside an attribute assignment
        for (int i = 0; i < assignment.getElementCount(); i++) {
            assignment.getElement(i).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnum(Enum eenum) {
        visitIDatatype(eenum);
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        visitIDatatype(eenum);
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompound(Compound compound) {
        visitIDatatype(compound);
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        if (null == type || type == DerivedDatatype.TYPE) {
            foundDatatypes.add(datatype);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumLiteral(EnumLiteral literal) {
        // No action needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference reference) {
        visitIDatatype(reference);
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        visitIDatatype(sequence);
    }

    /**
     * {@inheritDoc}
     */
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
}
