package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the implemented metatype/type operations.
 * 
 * @author Holger Eichelberger
 */
public class MetaOperationsTest {

    /**
     * Tests the equals and the unequals operation for booleans.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor sType = Utils.createValue(MetaType.TYPE, context, StringType.TYPE);
        EvaluationAccessor bType = Utils.createValue(MetaType.TYPE, context, BooleanType.TYPE);
        
        Utils.testEquals(true, MetaType.EQUALS, MetaType.NOTEQUALS, sType, sType);
        Utils.testEquals(true, MetaType.EQUALS, MetaType.NOTEQUALS, bType, bType);
        Utils.testEquals(false, MetaType.EQUALS, MetaType.NOTEQUALS, bType, sType);
        Utils.testEquals(false, MetaType.EQUALS, MetaType.NOTEQUALS, sType, bType);

        sType.release();
        bType.release();
    }
    
    /**
     * Tests the all instances operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that values do not match
     * @throws CSTSemanticException in case that the constraint syntax tree is erroneous
     */
    @Test
    public void testAllInstances() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project prj = new Project("Test");
        Compound cmp1 = new Compound("Compound1", prj);
        prj.add(cmp1);
        Compound cmp2 = new Compound("Compound2", prj);
        prj.add(cmp2);
        DecisionVariableDeclaration var1Cmp1 = createDefaultVariable("var1Cmp1", cmp1, prj);
        DecisionVariableDeclaration var2Cmp1 = createDefaultVariable("var2Cmp1", cmp1, prj);
        DecisionVariableDeclaration var3Cmp1 = createDefaultVariable("var3Cmp1", cmp1, prj);
        DecisionVariableDeclaration var1Cmp2 = createDefaultVariable("var1Cmp2", cmp2, prj);
        DecisionVariableDeclaration var2Cmp2 = createDefaultVariable("var2Cmp2", cmp2, prj);

        ConstraintSyntaxTree allInstExCmp1 = createAllInstancesCall(cmp1);
        ConstraintSyntaxTree allInstExCmp2 = createAllInstancesCall(cmp2);
        ConstraintSyntaxTree allInstExDbl = createAllInstancesCall(RealType.TYPE);
        
        Configuration config = new Configuration(prj);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        allInstExCmp1.accept(visitor);
        Assert.assertNotNull(visitor.getResult());
        Assert.assertTrue(Set.TYPE.isAssignableFrom(visitor.getResult().getType()));
        Assert.assertTrue(Reference.isReferenceTo(visitor.getResult().getContainedType(), cmp1));
        Utils.assertContainer(new Object[]{var1Cmp1, var2Cmp1, var3Cmp1}, visitor.getResult());
        visitor.clear();
        
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        allInstExCmp2.accept(visitor);
        Assert.assertNotNull(visitor.getResult());
        Assert.assertTrue(Set.TYPE.isAssignableFrom(visitor.getResult().getType()));
        Assert.assertTrue(Reference.isReferenceTo(visitor.getResult().getContainedType(), cmp2));
        Utils.assertContainer(new Object[]{var1Cmp2, var2Cmp2}, visitor.getResult());
        visitor.clear();
        
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        allInstExDbl.accept(visitor);
        Assert.assertTrue(Reference.isReferenceTo(visitor.getResult().getContainedType(), RealType.TYPE));
        Utils.assertContainer(new Object[]{}, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Creates an all instances call.
     * 
     * @param type the type to create the call for
     * @return the call
     * @throws ValueDoesNotMatchTypeException in case that values do not match
     * @throws CSTSemanticException in case that the constraint syntax tree is erroneous
     */
    private ConstraintSyntaxTree createAllInstancesCall(IDatatype type) throws ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        ConstraintSyntaxTree result = new OCLFeatureCall(new ConstantValue(
            ValueFactory.createValue(MetaType.TYPE, type)), MetaType.ALL_INSTANCES.getName());
        result.inferDatatype();
        return result;
    }

    /**
     * Creates a default-assigned variable.
     *
     * @param name the name of the variable
     * @param type the type of the variable
     * @param project the parent project
     * @return the variable
     * @throws ValueDoesNotMatchTypeException in case that values do not match
     * @throws CSTSemanticException in case that the constraint syntax tree is erroneous
     */
    private DecisionVariableDeclaration createDefaultVariable(String name, IDatatype type, Project project) 
        throws ValueDoesNotMatchTypeException, CSTSemanticException {
        DecisionVariableDeclaration result = new DecisionVariableDeclaration(name, type, project);
        ConstraintSyntaxTree defltEx = new ConstantValue(ValueFactory.createValue(type, (Object[]) null));
        defltEx.inferDatatype();
        result.setValue(defltEx);
        project.add(result);
        return result;
    }
    
}
