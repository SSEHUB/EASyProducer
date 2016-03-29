/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.varModel.datytypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Testfile for the basis-methods of DerivedDatatype.
 * @author beck
 * @author El-Sharkawy
 *
 */
public class DerivedDatatypeTest {

    private Project project;
    private int countInternalConstraints;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        project = new Project("project");        
    }
    
    /**
     * Test to create a DerivedDatatype and set a new Constraint.
     * @throws IvmlException possible exception for createValue or assigning/testing constraints
     */
    @Test
    public void test() throws IvmlException {
        
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, project);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        
        Constraint cons = new Constraint(constraint, null);
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);
        
        //The current project must not have any internal constraints
        countInternalConstraints = 0;
        Assert.assertEquals(countInternalConstraints, project.getInternalConstraintCount());
        
        //Now, with the creation of this declaration exactly one internalConstraint must be generated.
        DecisionVariableDeclaration videoBitrate = new DecisionVariableDeclaration("videoBitrate", bitrate, project);
        countInternalConstraints++;
        Assert.assertEquals(countInternalConstraints, project.getInternalConstraintCount());      
        testInternalConstraint(constraint, videoBitrate);
        
        //Now, with the creation of this declaration exactly one internalConstraint must be generated.
        DecisionVariableDeclaration audioBitrate = new DecisionVariableDeclaration("audioBitrate", bitrate, project);
        countInternalConstraints++;
        Assert.assertEquals(countInternalConstraints, project.getInternalConstraintCount());
        testInternalConstraint(constraint, audioBitrate);
    }

    /**
     * Test whether the given <code>DecsionVariableDeclaration</code> (instance of a <code>DerivedDatatype</code>
     * is embedded into the last created internal constraint. For this test, the <code>DerivedDatatype</code>
     * must have only one <code>OCLFeatureCall</code> constraint with itself as operand.
     * 
     * @param constraint The origin constraint of the <code>DerivedDatatype</code>.
     * This test checks also whether the newly created constraint has the same structure.
     * @param derivedTypeInstance The instance of a <code>DerivedDatatype</code>,
     * which should occur inside the internal constraint.
     */
    private void testInternalConstraint(OCLFeatureCall constraint, DecisionVariableDeclaration derivedTypeInstance) {
        Constraint internalConstraint = project.getInternalConstraint(countInternalConstraints - 1);
        OCLFeatureCall testCST = (OCLFeatureCall) internalConstraint.getConsSyntax();
        
        //Test correct behavior of the internal cosntraint
        Assert.assertNotNull(testCST);
        Variable variable = (Variable) testCST.getOperand();
        Assert.assertEquals(derivedTypeInstance, variable.getVariable());
        Assert.assertEquals(constraint.getOperation(), testCST.getOperation());
    }

}
