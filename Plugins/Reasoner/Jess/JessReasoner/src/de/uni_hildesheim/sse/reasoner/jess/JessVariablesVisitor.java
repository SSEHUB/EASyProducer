package de.uni_hildesheim.sse.reasoner.jess;
import java.util.LinkedList;

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
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * This is a partial visitor whose job is to visit all the non-nested elements/variables and add to
 * one common Jess template. This is cruicial as Jess offers a very poor reasoning over global variables.
 * @author Phani
 *
 */
public class JessVariablesVisitor implements IModelVisitor, IDatatypeVisitor {

    private StringBuffer projTemplate = new StringBuffer();
    private StringBuffer slot = new StringBuffer();
    private LinkedList<String> projectList = new LinkedList<String>();
    
    
    
    public LinkedList<String> getProjectList() {
        return projectList;
    }


    /**
     * Method to return the Proj Template consisting of the non-nested elements (decision avriables) of the project.
     * @return Project Template.
     */
    public StringBuffer getProjTemplate() {
        return projTemplate;
    }

    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {

        this.slot.append("(");
        String slotName = decl.getName();
        decl.getType().accept(this);
        this.slot.append(" " + slotName);
        this.slot.append(" (type ANY)) \n");
        projTemplate.append(this.slot.toString());
        projectList.add(this.slot.toString());
        this.slot = new StringBuffer();
        
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

        this.slot.append("slot");
    }

    @Override
    public void visitSequence(Sequence sequence) {
        this.slot.append("multislot");

    }

    @Override
    public void visitSet(Set set) {
        this.slot.append("multislot");

    }

    @Override
    public void visitDatatype(IDatatype datatype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitAnyType(AnyType datatype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitMetaType(MetaType datatype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        this.slot.append("slot");

    }

    @Override
    public void visitBooleanType(BooleanType type) {
        this.slot.append("slot");

    }

    @Override
    public void visitStringType(StringType type) {
        this.slot.append("slot");

    }

    @Override
    public void visitIntegerType(IntegerType type) {

        this.slot.append("slot");
    }

    @Override
    public void visitRealType(RealType type) {
        this.slot.append("slot");

    }

    @Override
    public void visitCompoundType(Compound compound) {
        this.slot.append("slot");

    }

    @Override
    public void visitEnumType(Enum enumType) {
        this.slot.append("slot");

    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        this.slot.append("slot");

    }

    @Override
    public void visitProject(Project project) {
        String proName = project.getName();
        String templ = "(deftemplate Proj \n(slot PROJECT (type STRING) (default "
                + proName + "))";
        
        this.projTemplate.append(templ);
        projectList.add(templ);

    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
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
        // TODO Auto-generated method stub

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
    public void visitConstraintType(ConstraintType type) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitComment(Comment comment) {
        // No action needed in reasoning
    }

    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
    }
}
