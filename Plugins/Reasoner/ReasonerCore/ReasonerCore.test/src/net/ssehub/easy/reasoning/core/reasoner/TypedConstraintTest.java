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

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Simple tests for the typed constraint.
 * 
 * @author Holger Eichelberger
 */
public class TypedConstraintTest {
    
    /**
     * Tests the typed constraint.
     * 
     * @throws ValueDoesNotMatchTypeException in case of problems creating a value
     */
    @Test
    public void testTypedConstraint() throws ValueDoesNotMatchTypeException {
        Project prj = new Project("test");
        ConstantValue cst = new ConstantValue(ValueFactory.createValue(BooleanType.TYPE, true));
        try {
            TypedConstraint constraint = new TypedConstraint(cst, Constraint.Type.DEFAULT, prj);
            Assert.assertEquals(prj, constraint.getParent());
            Assert.assertEquals(cst, constraint.getConsSyntax());
            Assert.assertTrue(constraint.isBooleanConstraint());
            Assert.assertEquals(Constraint.Type.DEFAULT, constraint.getType());
            
            constraint = new TypedConstraint(cst, Constraint.Type.CONSTRAINT, prj);
            Assert.assertEquals(Constraint.Type.CONSTRAINT, constraint.getType());
        } catch (CSTSemanticException e) {
            Assert.fail("Unexpected exception " + e.getMessage());
        }
    }

    /**
     * Tests the default constraint.
     * 
     * @throws ValueDoesNotMatchTypeException in case of problems creating a value
     */
    @Test
    public void testDefaultConstraint() throws ValueDoesNotMatchTypeException {
        Project prj = new Project("test");
        ConstantValue cst = new ConstantValue(ValueFactory.createValue(BooleanType.TYPE, true));
        try {
            Constraint constraint = new DefaultConstraint(cst, prj);
            Assert.assertEquals(prj, constraint.getParent());
            Assert.assertEquals(cst, constraint.getConsSyntax());
            Assert.assertTrue(constraint.isBooleanConstraint());
            Assert.assertEquals(Constraint.Type.DEFAULT, constraint.getType());
        } catch (CSTSemanticException e) {
            Assert.fail("Unexpected exception " + e.getMessage());
        }
    }

    /**
     * Tests the constraint variable constraint.
     * 
     * @throws ValueDoesNotMatchTypeException in case of problems creating a value
     */
    @Test
    public void testConstraintVariableConstraint() throws ValueDoesNotMatchTypeException {
        Project prj = new Project("test");
        ConstantValue cst = new ConstantValue(ValueFactory.createValue(BooleanType.TYPE, true));
        try {
            Constraint constraint = new ConstraintVariableConstraint(cst, prj);
            Assert.assertEquals(prj, constraint.getParent());
            Assert.assertEquals(cst, constraint.getConsSyntax());
            Assert.assertTrue(constraint.isBooleanConstraint());
            Assert.assertEquals(Constraint.Type.CONSTRAINT, constraint.getType());
        } catch (CSTSemanticException e) {
            Assert.fail("Unexpected exception " + e.getMessage());
        }
    }

}
