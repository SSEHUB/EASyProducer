/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Not a real test, just to ramp up the reasoner so that for subsequent tests most classloading issues are already done.
 * 
 * @author Holger Eichelberger
 */
public class RampUpTest extends AbstractTest {

    /**
     * Creates the ramp-up test.
     * 
     * @param descriptor the test descriptor
     */
    protected RampUpTest(ITestDescriptor descriptor) {
        super(descriptor, null);
    }

    /**
     * Performs the ram-up test.
     * 
     * @throws ConfigurationException if setting an expression as default value fails
     * @throws ValueDoesNotMatchTypeException if a value does not match a type
     * @throws CSTSemanticException if a constraint is erroneously composed
     */
    @Test
    public void rampUpTest() throws ConfigurationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        Configuration cfg = createRampUpTest();
        IReasoner reasoner = createReasoner();
        // NO MEASUREMENT!!!
        ReasoningResult rResult = reasoner.propagate(cfg.getProject(), cfg, rConfig, ProgressObserver.NO_OBSERVER);
        rResult.logInformation(cfg.getProject(), rConfig);
        Assert.assertFalse(rResult.hasConflict());
    }
    
    /**
     * Creates the configuration for a ram-up test, just a configuration to reason on.
     * 
     * @return the configuration
     * @throws ConfigurationException if setting an expression as default value fails
     * @throws ValueDoesNotMatchTypeException if a value does not match a type
     * @throws CSTSemanticException if a constraint is erroneously composed
     */
    public static Configuration createRampUpTest() throws ConfigurationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        Project prj = new Project("Test");
        Compound cmp = new Compound("Cmp", prj);
        prj.add(cmp);
        DecisionVariableDeclaration cmpV1 = new DecisionVariableDeclaration("v1", IntegerType.TYPE, prj);
        cmpV1.setValue(new OCLFeatureCall(
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 1)), 
            IntegerType.PLUS_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 5))));
        cmp.add(cmpV1);
        Set cmpSet = new Set("", cmp, prj);
        DecisionVariableDeclaration set = new DecisionVariableDeclaration("s", cmpSet, prj);
        DecisionVariableDeclaration iter = new DecisionVariableDeclaration("i", cmp, prj);
        ConstraintSyntaxTree iterEx = new OCLFeatureCall(
            new CompoundAccess(new Variable(iter), "v1"), 
            IntegerType.GREATER_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 2)));
        iterEx.inferDatatype();
        ConstraintSyntaxTree op = new ContainerOperationCall(new Variable(set), Set.FORALL.getName(), iterEx, iter);
        op.inferDatatype();
        Constraint constraint = new Constraint(op, prj);
        prj.add(constraint);
        
        return new Configuration(prj);
    }
    
}
