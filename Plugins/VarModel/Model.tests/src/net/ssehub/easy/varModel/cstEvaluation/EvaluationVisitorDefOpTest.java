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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.NamedArgument;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the {@link EvaluationVisitor} with respect to user-defined operations.
 * 
 * @author Holger Eichelberger
 */
public class EvaluationVisitorDefOpTest {

    /**
     * Tests modification access to local variables in an user defined operation.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testCompoundAccessLocalVar() throws CSTSemanticException, ConfigurationException, 
        ValueDoesNotMatchTypeException {
        Project project = new Project("Test");
        Compound cmpType = new Compound("cmp", project);
        project.add(cmpType);
        DecisionVariableDeclaration cmpTypeDecl = new DecisionVariableDeclaration("var", IntegerType.TYPE, cmpType);
        cmpType.add(cmpTypeDecl);
        
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[2];
        params[0] = new DecisionVariableDeclaration("p1", cmpType, null);
        params[1] = new DecisionVariableDeclaration("p2", IntegerType.TYPE, null);
        ConstraintSyntaxTree custOpEx = new OCLFeatureCall(new CompoundAccess(new Variable(params[0]), "var"), 
            IntegerType.ASSIGNMENT_INTEGER_INTEGER.getName(), new Variable(params[1]));
        custOpEx.inferDatatype();
        CustomOperation cOp = new CustomOperation(BooleanType.TYPE, "test", project.getType(), custOpEx, params);
        OperationDefinition opDef = new OperationDefinition(project);
        opDef.setOperation(cOp);
        project.add(opDef);

        DecisionVariableDeclaration cmpVar = new DecisionVariableDeclaration("c", cmpType, project);
        project.add(cmpVar);

        ConstraintSyntaxTree cEx = new OCLFeatureCall(new Variable(cmpVar), "test", project, 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10)));
        cEx.inferDatatype();
        
        Configuration config = new Configuration(project);
        config.getDecision(cmpVar).setValue(ValueFactory.createValue(cmpType, (Object[]) null), 
            AssignmentState.ASSIGNED);
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(cEx);
        
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        IDecisionVariable var = config.getDecision(cmpVar);
        Assert.assertNotNull(var);
        Assert.assertTrue(var instanceof CompoundVariable);
        Assert.assertEquals(AssignmentState.ASSIGNED, var.getState());
        IDecisionVariable nVar = ((CompoundVariable) var).getNestedVariable("var");
        Value val = nVar.getValue();
        Assert.assertTrue(val instanceof IntValue);
        Assert.assertEquals(10, ((IntValue) val).getValue().intValue());
    }
    
    /**
     * Tests compound access in references. An expression accessing "cmp.var" as a reference (IVML maps this
     * into a constant of a ref-Value) must be equal to the declaration of the respective decision variable.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testCompoundAccessRef() throws CSTSemanticException, ConfigurationException, 
        ValueDoesNotMatchTypeException {
        Project project = new Project("Test");
        Compound cmpType = new Compound("cmp", project);
        project.add(cmpType);
        DecisionVariableDeclaration cmpTypeDecl = new DecisionVariableDeclaration("var", IntegerType.TYPE, cmpType);
        cmpType.add(cmpTypeDecl);
        
        DecisionVariableDeclaration cmpVar = new DecisionVariableDeclaration("c", cmpType, project);
        project.add(cmpVar);
        IDatatype refType = new Reference("ref", IntegerType.TYPE, project); 
        ConstraintSyntaxTree acc = new CompoundAccess(new Variable(cmpVar), "var");
        acc.inferDatatype();
        ConstraintSyntaxTree refBy = new ConstantValue(ValueFactory.createValue(refType, acc));
        
        Configuration config = new Configuration(project);
        config.getDecision(cmpVar).setValue(ValueFactory.createValue(cmpType, new Object[]{"var", 1}), 
            AssignmentState.ASSIGNED);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(refBy);
        
        Assert.assertTrue(visitor.getResult() instanceof ReferenceValue);
        IDecisionVariable v = config.getDecision(cmpVar);
        Assert.assertEquals(v.getNestedElement("var").getDeclaration(), 
            ((ReferenceValue) visitor.getResult()).getValue());
    }

    /**
     * Tests a custom operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        
        // int myFunc(int x) = {x * 7}
        Project project = new Project("Test");
        DecisionVariableDeclaration param = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstraintSyntaxTree const7 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 7));
        ConstraintSyntaxTree func = Utils.createCall(param, IntegerType.MULT_INTEGER_INTEGER, const7);
        func.inferDatatype();
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[1];
        params[0] = param;
        CustomOperation custOp = new CustomOperation(IntegerType.TYPE, "myFunc", project.getType(), func, params);
        OperationDefinition opDef = new OperationDefinition(project);
        opDef.setOperation(custOp);
        project.add(opDef);
        
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        project.add(decl);
        
        Configuration config = new Configuration(project);
        config.getDecision(decl).setValue(ValueFactory.createValue(IntegerType.TYPE, 3), AssignmentState.ASSIGNED);
        ConstraintSyntaxTree call = new OCLFeatureCall(null, "myFunc", project, new Variable(decl));
        call.inferDatatype();
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        call.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Assert.assertEquals(21, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }

    /**
     * Tests reference parameters at custom operations.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperationReferenceParameter() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
            
        Project project = new Project("Test");

        // compound Base {};
        Compound cBase = new Compound("Base", project);
        project.add(cBase);

        DecisionVariableDeclaration cBaseVar = new DecisionVariableDeclaration("b", cBase, project);
        project.add(cBaseVar);

        Reference cBaseRef = new Reference("BaseRef", cBase, project);
        DecisionVariableDeclaration cBaseRefVar = new DecisionVariableDeclaration("bRef", cBaseRef, project);
        project.add(cBaseRefVar);
        
        // def Boolean test(Base b) = isDefined(b);
        DecisionVariableDeclaration param1 = new DecisionVariableDeclaration("b", cBase, null);
        DecisionVariableDeclaration[] params1 = new DecisionVariableDeclaration[1];
        params1[0] = param1;
        ConstraintSyntaxTree func = Utils.createCall(param1, Compound.IS_DEFINED);
        func.inferDatatype();
        CustomOperation custOp1 = new CustomOperation(BooleanType.TYPE, "test", project.getType(), func, params1);
        OperationDefinition opDef1 = new OperationDefinition(project);
        opDef1.setOperation(custOp1);
        project.add(opDef1);

        // test(b); // b is undefined -> false
        ConstraintSyntaxTree cst = new OCLFeatureCall(null, "test", project, new Variable(cBaseRefVar));
        cst.inferDatatype();
        
        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();
        
        // define b
        config.getDecision(cBaseVar).setValue(ValueFactory.createValue(cBase, (Object[]) null), 
            AssignmentState.ASSIGNED);
        config.getDecision(cBaseRefVar).setValue(ValueFactory.createValue(cBaseRef, cBaseVar), 
            AssignmentState.ASSIGNED);
        
        // test(b); // b is defined -> true
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clear();
    }

    /**
     * Tests a custom operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperationDefltValue() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        
        // int myFunc(int x, int y=7) = {x * y}
        Project project = new Project("Test");
        DecisionVariableDeclaration paramX = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstraintSyntaxTree const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree const7 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 7));
        DecisionVariableDeclaration paramY = new DecisionVariableDeclaration("y", IntegerType.TYPE, null);
        paramY.setValue(const7);
        DecisionVariableDeclaration paramZ = new DecisionVariableDeclaration("z", IntegerType.TYPE, null);
        paramZ.setValue(const0);
        
        ConstraintSyntaxTree func = Utils.createCall(paramX, IntegerType.MULT_INTEGER_INTEGER, new Variable(paramY));
        func = Utils.createCall(func, IntegerType.PLUS_INTEGER_INTEGER, new Variable(paramZ));
        func.inferDatatype();
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[3];
        params[0] = paramX;
        params[1] = paramY;
        params[2] = paramZ;
        CustomOperation custOp = new CustomOperation(IntegerType.TYPE, "myFunc", project.getType(), func, params);
        OperationDefinition opDef = new OperationDefinition(project);
        opDef.setOperation(custOp);
        project.add(opDef);
        
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        project.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("b", IntegerType.TYPE, project);
        project.add(declB);
        DecisionVariableDeclaration declC = new DecisionVariableDeclaration("c", IntegerType.TYPE, project);
        project.add(declC);
        
        Configuration config = new Configuration(project);
        config.getDecision(declA).setValue(ValueFactory.createValue(IntegerType.TYPE, 3), AssignmentState.ASSIGNED);
        config.getDecision(declB).setValue(ValueFactory.createValue(IntegerType.TYPE, 8), AssignmentState.ASSIGNED);
        config.getDecision(declC).setValue(ValueFactory.createValue(IntegerType.TYPE, 1), AssignmentState.ASSIGNED);
        ConstraintSyntaxTree call = new OCLFeatureCall(null, "myFunc", project, new Variable(declA));
        call.inferDatatype();
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        call.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Assert.assertEquals(21, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
        
        call = new OCLFeatureCall(null, "myFunc", project, new Variable(declA), 
            new NamedArgument("y", new Variable(declB)));
        call.inferDatatype();

        visitor.init(config, AssignmentState.DEFAULT, false, null);
        call.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Assert.assertEquals(24, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();

        call = new OCLFeatureCall(null, "myFunc", project, new Variable(declA), 
            new NamedArgument("z", new Variable(declC)), new NamedArgument("y", new Variable(declB)));
        call.inferDatatype();

        visitor.init(config, AssignmentState.DEFAULT, false, null);
        call.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Assert.assertEquals(25, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }

}
