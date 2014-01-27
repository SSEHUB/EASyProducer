package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
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
 * A variable collector used to collect the (configured) variables of a variability model.
 * 
 * @author Holger Eichelberger
 */
class VariableCollector implements IModelVisitor {
    
    private List<DecisionVariable> variables = new ArrayList<DecisionVariable>();
    private de.uni_hildesheim.sse.model.confModel.Configuration configuration;

    /**
     * Creates a new variable collector.
     * 
     * @param configuration the configuration to determine the configured variables from
     */
    public VariableCollector(de.uni_hildesheim.sse.model.confModel.Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Returns the collected variables.
     * 
     * @return the collected variables
     */
    DecisionVariable[] getCollectedVariables() {
        DecisionVariable[] result = new DecisionVariable[variables.size()];
        return variables.toArray(result);
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Typedef - not relevant here
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Typedef - not relevant here
    }

    @Override
    public void visitCompound(Compound compound) {
        // Typedef - not relevant here
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Typedef - not relevant here
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Typedef - not relevant here
    }

    @Override
    public void visitReference(Reference reference) {
        // Typedef - not relevant here
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Typedef - not relevant here
    }

    @Override
    public void visitSet(Set set) {
        // Typedef - not relevant here
    }

    @Override
    public void visitProject(Project project) {
        for (int i = 0; i < project.getImportsCount(); i++) {
            project.getImport(i).accept(this);
        }
        int eSize = project.getElementCount();
        for (int e = 0; e < eSize; e++) {
            project.getElement(e).accept(this);
        }
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
        // already resolved - not relevant here
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // retrieve and if ok wrap
        IDecisionVariable var = configuration.getDecision(decl);
        if (null != var && AssignmentState.FROZEN == var.getState()) {
            variables.add(new DecisionVariable(var));
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO implement
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // just a declaration and considered by the reasoner ;)
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // already processed ;)
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // just a declaration and considered by the reasoner ;)
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // to be considered while reasoning ;)
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // declaration, already resolved
    }

    @Override
    public void visitComment(Comment comment) {
        // not relevant here
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
        for (int e = 0; e < assignment.getModelElementCount(); e++) {
            assignment.getModelElement(e).accept(this);
        }
    }

}
