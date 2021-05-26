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
package net.ssehub.easy.varModel.model.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
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
        Assert.assertEquals(Constraint.Type.USUAL, cons.getType()); // default
        Assert.assertNull(cons.getAttachedTo()); // default
        Assert.assertTrue(cons.createConstraint(constraint) instanceof Constraint);
        Assert.assertTrue(cons.toString().length() > 0);
        Assert.assertTrue(cons.isBooleanConstraint());
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);
    }

}
