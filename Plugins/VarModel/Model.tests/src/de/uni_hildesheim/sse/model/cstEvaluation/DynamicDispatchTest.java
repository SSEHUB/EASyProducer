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
package de.uni_hildesheim.sse.model.cstEvaluation;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomDynamicOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Tests for dynamic dispatch in IVML.
 * 
 * @author Holger Eichelberger
 */
public class DynamicDispatchTest {

    /**
     * Tests dynamic dispatch for custom operations.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperationDispatch() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        
        Project project = new Project("Test");

        // compound Base {};
        Compound cBase = new Compound("Base", project);
        project.add(cBase);

        // compound Refined refines Base {};
        Compound cRefined = new Compound("Refined", project, cBase);
        project.add(cRefined);

        // def Integer test(Base b) = 0;
        createConstantIntOperation(project, false, "test", cBase, 0);

        // def Integer test(Refined r) = 1;
        createConstantIntOperation(project, false, "test", cRefined, 1);

        DecisionVariableDeclaration var = new DecisionVariableDeclaration("r", cRefined, project);
        project.add(var);
        
        ConstraintSyntaxTree cst = new OCLFeatureCall(null, "test", project, new Variable(var));
        cst.inferDatatype();
        
        Configuration config = new Configuration(project);
        config.getDecision(var).setValue(ValueFactory.createValue(cRefined, (Object[]) null), AssignmentState.ASSIGNED);
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.setDispatchScope(project); // this is important!
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        // use the more specific one due to dynamic dispatch
        Assert.assertEquals(1, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }
    
    /**
     * Tests indirect static custom operations (contributed by QM).
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    @Test
    public void testCustomOperationIndirectStatic() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException, ModelManagementException {
        testCustomOperation(false, false, true);
    }

    /**
     * Tests indirect dynamic dispatch for custom operations (contributed by QM).
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    @Test
    public void testCustomOperationIndirectDispatch() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException, ModelManagementException {
        testCustomOperation(false, false, false);
    }
    
    /**
     * Tests indirect dynamic dispatch for imported custom operations (contributed by QM).
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    @Test
    public void testCustomOperationIndirectImportedDispatch() throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException, ModelManagementException {
        testCustomOperation(false, true, false);
    }
    
    /**
     * Creates a user-defined operation in <code>project</code> of form 
     * <code>def Integer <i>opName</i>(<i>paramType</i> b) = <i>returnValue</i></code>.
     * 
     * @param project the target project
     * @param isStatic whether the operation shall be static (<code>true</code>) or subject to dynamic dispatch 
     *     (<code>false</code>)
     * @param opName the name of the operation
     * @param paramType the parameter type
     * @param returnValue the return value
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     */
    private void createConstantIntOperation(Project project, boolean isStatic, String opName, IDatatype paramType, 
        int returnValue) throws ValueDoesNotMatchTypeException {
        // def Integer test(Base b) = 0;
        ConstraintSyntaxTree const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, returnValue));
        DecisionVariableDeclaration param1 = new DecisionVariableDeclaration("b", paramType, null);
        DecisionVariableDeclaration[] params1 = new DecisionVariableDeclaration[1];
        params1[0] = param1;
        CustomOperation custOp1;
        if (isStatic) {
            custOp1 = new CustomOperation(IntegerType.TYPE, opName, project.getType(), const0, params1);
        } else {
            custOp1 = new CustomDynamicOperation(IntegerType.TYPE, opName, project.getType(), const0, params1);
        }
        OperationDefinition opDef1 = new OperationDefinition(project);
        opDef1.setOperation(custOp1);
        project.add(opDef1);        
    }
    
    /**
     * Implements the indirect dynamic dispatch test with/without reference.
     * 
     * @param withRef test with reference
     * @param withImports test with operations in imported project
     * @param isStatic whether the test shall be for static operations (<code>true</code>) or focus on dynamic dispatch 
     *     (<code>false</code>)
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    private void testCustomOperation(boolean withRef, boolean withImports, boolean isStatic) throws 
        ValueDoesNotMatchTypeException, ConfigurationException, CSTSemanticException, ModelManagementException {
        Project project = new Project("Test");
        Project opProject = project;
        if (withImports) {
            opProject = new Project("Imported");
            ProjectImport imp = new ProjectImport(opProject.getName());
            imp.setResolved(opProject);
            project.addImport(imp);
        }
    
        // compound Base {};
        Compound cBase = new Compound("Base", opProject);
        project.add(cBase);
        // compound Refined refines Base {};
        Compound cRefined = new Compound("Refined", opProject, cBase);
        project.add(cRefined);
    
        // def Integer test(Base b) = 0;
        createConstantIntOperation(opProject, isStatic, "test", cBase, 0);
    
        // def Integer test(Refined r) = 1;
        createConstantIntOperation(opProject, isStatic, "test", cRefined, 1);
    
        // def Integer test0(Base b) = test(b); // ok if it is in project
        DecisionVariableDeclaration param3 = new DecisionVariableDeclaration("b", cBase, null);
        ConstraintSyntaxTree opCall3 = new OCLFeatureCall(new Variable(param3), "test", project);
        opCall3.inferDatatype();
        DecisionVariableDeclaration[] params3 = new DecisionVariableDeclaration[1];
        params3[0] = param3;
        CustomOperation custOp3;
        if (isStatic) {
            custOp3 = new CustomOperation(IntegerType.TYPE, "test0", project.getType(), opCall3, params3);
        } else {
            custOp3 = new CustomDynamicOperation(IntegerType.TYPE, "test0", project.getType(), opCall3, params3);
        }
        OperationDefinition opDef3 = new OperationDefinition(project);
        opDef3.setOperation(custOp3);
        project.add(opDef3);
    
        DecisionVariableDeclaration testVar;
        DecisionVariableDeclaration var = new DecisionVariableDeclaration("r", cRefined, project);
        project.add(var);
        testVar = var;
        if (withRef) {
            Reference refType = new Reference("refTo(cRefined)", cRefined, project);
            DecisionVariableDeclaration refVar = new DecisionVariableDeclaration("rv", refType, project);
            project.add(refVar);
            testVar = refVar;
        }

        ConstraintSyntaxTree cst = new OCLFeatureCall(null, "test0", project, new Variable(testVar));
        cst.inferDatatype();
        
        Configuration config = new Configuration(project);
        config.getDecision(var).setValue(ValueFactory.createValue(cRefined, (Object[]) null), AssignmentState.ASSIGNED);
        if (withRef) {
            config.getDecision(testVar).setValue(ValueFactory.createValue(testVar.getType(), var), 
                AssignmentState.ASSIGNED);
        }
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.setDispatchScope(project); // this is important!
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        // use the more specific one due to dynamic dispatch
        int expected = isStatic ? 0 : 1;
        Assert.assertEquals(expected, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }

    /**
     * Tests indirect dynamic dispatch for imported custom operations over references (contributed by QM).
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    @Test
    public void testCustomOperationIndirectRefImportedDispatch() throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException, ModelManagementException {
        testCustomOperation(true, true, false);
    }

    /**
     * Tests indirect dynamic dispatch for custom operations over references (contributed by QM).
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     * @throws ModelManagementException if setting a resolved import fails (shall not occur)
     */
    @Test
    public void testCustomOperationIndirectRefDispatch() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException, ModelManagementException {
        testCustomOperation(true, false, false);
    }

}
