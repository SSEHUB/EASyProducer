/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package test.net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests reasoner capabilities via coded tests, without interactions from the parser.
 * 
 * @author El-Sharkawy
 */
public class CodedTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected CodedTests(ITestDescriptor descriptor) {
        super(descriptor, null);
    }

    /**
     * Simulates value propagation based on a Boolean variable with user input via the UI.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise ValueFactory is broken.
     * @throws CSTSemanticException Must not occur, otherwise constraint.setConsSyntax is broken
     * @throws ConfigurationException Must not occur, otherwise {@link IDecisionVariable}s are broken.
     */
    @Test
    public void testBooleanIplication() throws ValueDoesNotMatchTypeException, CSTSemanticException,
        ConfigurationException {
        
        // Define test model
        Project project = new Project("BooleanIplicationTest");
        Enum enumType = new Enum("Color", project, "RED", "BLUE", "GREEN");
        project.add(enumType);
        DecisionVariableDeclaration rgbVar = new DecisionVariableDeclaration("rgb", enumType, project);
        project.add(rgbVar);
        DecisionVariableDeclaration hasColorVar
            = new DecisionVariableDeclaration("hasColor", BooleanType.TYPE, project);
        project.add(hasColorVar);
        
        // Create Constraint
        Constraint constraint = new Constraint(project);
        Value redValue = ValueFactory.createValue(enumType, enumType.getLiteral(0));
        ConstantValue redConst = new ConstantValue(redValue);
        ConstantValue trueConst = new ConstantValue(BooleanValue.TRUE);
        OCLFeatureCall booleanEquals = new OCLFeatureCall(new Variable(hasColorVar), OclKeyWords.EQUALS, trueConst);
        OCLFeatureCall enumEquals = new OCLFeatureCall(new Variable(rgbVar), OclKeyWords.EQUALS, redConst);
        OCLFeatureCall implies = new OCLFeatureCall(booleanEquals, OclKeyWords.IMPLIES, enumEquals);
        constraint.setConsSyntax(implies);
        project.add(constraint);
        
        // Create Configuration out of valid project
        ProjectTestUtilities.validateProject(project, true);
        Configuration config = new Configuration(project);
        
        // Simulate user input
        IDecisionVariable enumVar = config.getDecision(rgbVar);
        enumVar.setValue(null, AssignmentState.UNDEFINED);
        IDecisionVariable boolVar = config.getDecision(hasColorVar);
        boolVar.setValue(BooleanValue.TRUE, AssignmentState.ASSIGNED);
        
        // Test precondition
        Assert.assertFalse(enumVar.getDeclaration().getName() + " has wrong value: " + enumVar.getValue(), 
            config.getDecision(rgbVar).hasValue());
        Assert.assertEquals(boolVar.getDeclaration().getName() + " has wrong value: " + boolVar.getValue().getValue(), 
            BooleanValue.TRUE, config.getDecision(hasColorVar).getValue());
        
        // Test: Perform reasoning (and propagation)
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        performReasoning(project, config, rConfig);
        
        // Test precondition
        Assert.assertTrue(enumVar.getDeclaration().getName() + " has wrong value: " + enumVar.getValue(), 
            config.getDecision(rgbVar).hasValue());
        Assert.assertEquals(enumVar.getDeclaration().getName() + " has wrong value: " + enumVar.getValue().getValue(), 
            redValue, config.getDecision(rgbVar).getValue());
        Assert.assertEquals(boolVar.getDeclaration().getName() + " has wrong value: " + boolVar.getValue().getValue(), 
            BooleanValue.TRUE, config.getDecision(hasColorVar).getValue());
        
        // Output of the configuration
        ProjectTestUtilities.validateProject(config.toProject(true, false), true);
    }

    /**
     * Tests freezing.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public void freezeCompoundTest() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        testFreezing(false); 
        testFreezing(true);
    }

    /**
     * Creates a project for freezing and checks the frozen states.
     * 
     * @param runtimeMode whether the test shall happen in runtime reasoning mode
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    private void testFreezing(boolean runtimeMode) throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project prj = new Project("test");

        Enum bindingTime = new OrderedEnum("BindingTime", prj);
        bindingTime.add(new EnumLiteral("compile", 1, bindingTime));
        bindingTime.add(new EnumLiteral("monitor", 2, bindingTime));
        bindingTime.add(new EnumLiteral("enact", 3, bindingTime));
        prj.add(bindingTime);
        
        Attribute attr = new Attribute("binding", bindingTime, prj, prj);
        attr.setValue(ValueFactory.createValue(bindingTime, "compile"));
        prj.attribute(attr);
        prj.add(attr);
        
        Compound param = new Compound("IntParameter", prj);
        param.add(new DecisionVariableDeclaration("defaultValue", IntegerType.TYPE, param));
        AttributeAssignment assng = new AttributeAssignment(param);
        assng.add(new Assignment("binding", "=", new ConstantValue(ValueFactory.createValue(bindingTime, "enact"))));
        assng.add(new DecisionVariableDeclaration("value", IntegerType.TYPE, param));
        param.add(assng);
        prj.add(param);
        
        DecisionVariableDeclaration myParam = new DecisionVariableDeclaration("myParam", param, prj);
        prj.add(myParam);
        
        IFreezable[] freezables = new IFreezable[1];
        freezables[0] = myParam;
        FreezeVariableType iterType = new FreezeVariableType(freezables, prj);
        DecisionVariableDeclaration freezeIter = new DecisionVariableDeclaration("b", iterType, prj);
        Variable iterEx = new AttributeVariable(new Variable(freezeIter), iterType.getAttribute("binding"));
        ConstraintSyntaxTree selector = new OCLFeatureCall(iterEx, ">=", 
            new ConstantValue(ValueFactory.createValue(bindingTime, "monitor")));
        selector.inferDatatype();
        FreezeBlock freeze = new FreezeBlock(freezables, freezeIter, selector, prj);
        prj.add(freeze);
        
        // debugging
        //System.out.println(net.ssehub.easy.varModel.persistency.StringProvider.toIvmlString(prj));
        
        Configuration cfg = new Configuration(prj);
        IDecisionVariable myParamVar = cfg.getDecision(myParam);
        Assert.assertNotNull(myParamVar);
        IDecisionVariable myParamVarDeflt = findNested(myParamVar, "defaultValue");
        Assert.assertNotNull(myParamVarDeflt);
        Assert.assertEquals(1, myParamVarDeflt.getAttributesCount());
        IDecisionVariable myParamVarValue = findNested(myParamVar, "value");
        Assert.assertNotNull(myParamVarValue);
        Assert.assertEquals(1, myParamVarValue.getAttributesCount());

        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setRuntimeMode(runtimeMode);
        // Perform reasoning
        performReasoning(prj, cfg, rConfig);
        
        Assert.assertEquals(myParamVarDeflt.getQualifiedName() + " " + myParamVarDeflt.getState(), 
            AssignmentState.FROZEN, myParamVarDeflt.getState());
        Assert.assertNotEquals(myParamVarValue.getQualifiedName() + " " + myParamVarValue.getState(), 
            AssignmentState.FROZEN, myParamVarValue.getState());
        //Assert.assertNotEquals(AssignmentState.FROZEN, myParamVar.getState());
    }
    
    /**
     * Finds a nested variable.
     * 
     * @param var the parent variable
     * @param name the name of the variable
     * @return the nested variable (may be <b>null</b>)
     */
    private IDecisionVariable findNested(IDecisionVariable var, String name) {
        IDecisionVariable result = null;
        for (int n = 0; null == result && n < var.getNestedElementsCount(); n++) {
            IDecisionVariable decVar = var.getNestedElement(n);
            if (decVar.getDeclaration().getName().equals(name)) {
                result = decVar;
            }
        }
        return result;
    }

}
