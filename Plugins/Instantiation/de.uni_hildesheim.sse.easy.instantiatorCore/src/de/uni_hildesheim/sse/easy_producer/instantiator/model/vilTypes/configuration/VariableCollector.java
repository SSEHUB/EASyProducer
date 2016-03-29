package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
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
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * A variable collector used to collect the (configured) variables of a variability model.
 * 
 * @author Holger Eichelberger
 */
class VariableCollector implements IModelVisitor {
    
    private List<DecisionVariable> variables = new ArrayList<DecisionVariable>();
    private Configuration configuration;
    private IVariableFilter filter;

    /**
     * Creates a new variable collector.
     * 
     * @param configuration the configuration to determine the configured variables from
     * @param filter the variable filter
     */
    public VariableCollector(Configuration configuration, IVariableFilter filter) {
        this.configuration = configuration;
        this.filter = filter;
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
        net.ssehub.easy.varModel.confModel.Configuration cfg = configuration.getConfiguration();
        IDecisionVariable var = cfg.getDecision(decl);
        if (null != var && filter.isEnabled(var)) {
            variables.add(new DecisionVariable(configuration, var, filter));
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

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // not relevant here
    }

}
