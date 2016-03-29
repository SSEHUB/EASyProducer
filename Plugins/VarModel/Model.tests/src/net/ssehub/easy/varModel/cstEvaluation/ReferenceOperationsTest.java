/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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

import org.junit.Test;

import net.ssehub.easy.varModel.cstEvaluation.EvaluationAccessor;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented reference operations.
 * 
 * @author Holger Eichelberger
 */
public class ReferenceOperationsTest {

    /**
     * Empty test so that the suite works. Remove with the first test
     */
    @Test
    public void testDummy() {
        //equals
        //isdefined
        //typeof
    }
    
    /**
     * Tests the equals and the unequals operation for booleans.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Reference sType = new Reference("sRef", StringType.TYPE, null);
        Reference bType = new Reference("bRef", BooleanType.TYPE, null);
        DecisionVariableDeclaration var1 = new DecisionVariableDeclaration("sVar", StringType.TYPE, null);
        DecisionVariableDeclaration var2 = new DecisionVariableDeclaration("bVar", BooleanType.TYPE, null);
        EvaluationAccessor ref1 = Utils.createValue(sType, context, var1);
        EvaluationAccessor ref2 = Utils.createValue(bType, context, var2);
        EvaluationAccessor nullV = Utils.createNullValue(context);

        Utils.testEquals(true, Reference.EQUALS, Reference.UNEQUALS, ref1, ref1);
        Utils.testEquals(false, Reference.EQUALS, Reference.UNEQUALS, ref1, ref2);
        Utils.testEquals(false, Reference.EQUALS, Reference.UNEQUALS, ref2, ref1);
        Utils.testEquals(true, Reference.EQUALS, Reference.UNEQUALS, ref2, ref2);

        Utils.testEquals(false, Reference.EQUALS, Reference.UNEQUALS, ref1, nullV);
        Utils.testEquals(false, Reference.EQUALS, Reference.UNEQUALS, ref2, nullV);

        ref1.release();
        ref2.release();
        nullV.release();
    }

    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Reference sType = new Reference("sRef", StringType.TYPE, null);
        DecisionVariableDeclaration var1 = new DecisionVariableDeclaration("sVar", StringType.TYPE, null);
        Utils.testDefined(sType, Reference.IS_DEFINED, var1);
    }
    
}
