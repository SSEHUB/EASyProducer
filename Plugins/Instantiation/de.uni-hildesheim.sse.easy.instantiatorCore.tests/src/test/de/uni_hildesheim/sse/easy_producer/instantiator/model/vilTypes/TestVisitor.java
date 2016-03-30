package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;

import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.AbstractIvmlVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
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
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * A model visitor for testing the individual variables.
 * 
 * @author Holger Eichelberger
 */
class TestVisitor implements IModelVisitor {

    private Map<String, DecisionVariable> map;
    private net.ssehub.easy.varModel.confModel.Configuration config;
    
    /**
     * Creates a test visitor for the given configurations.
     * s
     * @param config the IVML configuration
     * @param configuration the VIL configuration wrapper
     */
    TestVisitor(net.ssehub.easy.varModel.confModel.Configuration config, Configuration configuration) {
        this.config = config;
        map = new HashMap<String, DecisionVariable>();
        Sequence<DecisionVariable> variables = configuration.variables();
        Assert.assertNotNull(variables);
        Iterator<DecisionVariable> iter = variables.iterator();
        while (iter.hasNext()) {
            DecisionVariable var = iter.next();
            map.put(var.getQualifiedName(), var);
        }
    }
    
    @Override
    public void visitEnum(Enum eenum) {
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
    }

    @Override
    public void visitCompound(Compound compound) {
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
    }

    @Override
    public void visitReference(Reference reference) {
    }

    @Override
    public void visitSequence(net.ssehub.easy.varModel.model.datatypes.Sequence sequence) {
    }

    @Override
    public void visitSet(Set set) {
    }

    @Override
    public void visitProject(Project project) {
        for (int i = 0; i < project.getImportsCount(); i++) {
            project.getImport(i).accept(this);
        }
        for (int e = 0; e < project.getElementCount(); e++) {
            project.getElement(e).accept(this);
        }
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        IDecisionVariable decVar = config.getDecision(decl);
        DecisionVariable var = map.get(decl.getQualifiedName());
        test(decVar, var);
    }

    /**
     * Tests an IVML decision variable versus an abstract IVML variable.
     * 
     * @param decVar the IVML decision variable
     * @param var the IVML variable
     */
    private void test(IDecisionVariable decVar, AbstractIvmlVariable var) {
        if (null != decVar && AssignmentState.FROZEN == decVar.getState()) {
            AbstractVariable decl = decVar.getDeclaration();
            Assert.assertEquals(var.getName(), decl.getName());
            Assert.assertEquals(var.getQualifiedName(), decl.getQualifiedName());
            Assert.assertEquals(var.getType(), decl.getType().getName());
            Assert.assertEquals(var.getQualifiedType(), decl.getType().getQualifiedName());
            Assert.assertNotNull(decVar.getValue()); // FROZEN!
            ValueTester tester = new ValueTester(var);
            decVar.getValue().accept(tester);
            if (!Container.TYPE.isAssignableFrom(decVar.getDeclaration().getType())) {
                Map<String, IDecisionVariable> attrMap = new HashMap<String, IDecisionVariable>();
                for (int a = 0; a < decVar.getAttributesCount(); a++) {
                    IDecisionVariable attrib = decVar.getAttribute(a);
                    attrMap.put(attrib.getDeclaration().getName(), attrib);
                }
                for (net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Attribute attr
                    : var.attributes()) {
                    IDecisionVariable origAttrib = attrMap.get(attr.getName());
                    Assert.assertNotNull(origAttrib);
                    test(origAttrib, attr);
                }
            }
        }            
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // happens above
    }

    @Override
    public void visitConstraint(Constraint constraint) {
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
        for (int e = 0; e < assignment.getElementCount(); e++) {
            assignment.getElement(e).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
    }
    
}