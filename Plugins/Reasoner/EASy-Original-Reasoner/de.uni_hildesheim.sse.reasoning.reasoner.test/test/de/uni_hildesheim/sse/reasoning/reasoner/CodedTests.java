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
package de.uni_hildesheim.sse.reasoning.reasoner;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests reasoner capabilities via coded tests, without interactions from the parser.
 * @author El-Sharkawy
 *
 */
public class CodedTests {

    /**
     * Simulates value propagation based on a Boolean variable with user input via the UI.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise ValueFactory is broken.
     * @throws CSTSemanticException Must not occur, otherwise constraint.setConsSyntax is broken
     * @throws ConfigurationException Must not occur, otherwise {@link IDecisionVariable}s are broken.
     */
    @Ignore
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
        Reasoner sseReasoner = new Reasoner();
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        sseReasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
        
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

}
