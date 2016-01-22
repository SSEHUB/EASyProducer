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
package de.uni_hildesheim.sse.vil.rt.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.VariableValueCopier;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.VariableValueCopier.CopySpec;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.NoVariableFilter;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * A test for {@link VariableValueCopier}.
 * 
 * @author Holger Eichelberger
 */
public class VariableValueCopierTest extends AbstractRtTest {

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        test.de.uni_hildesheim.sse.vil.buildlang.ExecutionTests.startUp();
        registerReasoner();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        test.de.uni_hildesheim.sse.vil.buildlang.ExecutionTests.shutDown();
    }

    
    /**
     * Tests the copier mechanism.
     * 
     * @throws ConfigurationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void testCopier() throws ConfigurationException, ValueDoesNotMatchTypeException, ModelQueryException {
        Configuration cfg = getIvmlConfiguration("Copy", NoVariableFilter.INSTANCE).getConfiguration();
        Project prj = cfg.getProject();

        Compound sourceType = (Compound) ModelQuery.findType(prj, "Source", Compound.class);
        Compound familyElementType = (Compound) ModelQuery.findType(prj, "FamilyElement", Compound.class);
        CopySpec spec1 = new CopySpec(sourceType, "source", "available", "actual");
        CopySpec spec2 = new CopySpec(familyElementType, "family.members", "available");
        VariableValueCopier copier = new VariableValueCopier("myVar_", spec1, spec2);
        copier.process(cfg);

        //System.out.println(StringProvider.toIvmlString(cfg.toProject(true)));

        DecisionVariableDeclaration dDs1 = (DecisionVariableDeclaration) ModelQuery.findElementByName(prj, "src1", 
            DecisionVariableDeclaration.class);
        Assert.assertNotNull(dDs1);
        DecisionVariableDeclaration dSrc1 = (DecisionVariableDeclaration) ModelQuery.findElementByName(prj, "src1", 
            DecisionVariableDeclaration.class);
        Assert.assertNotNull(dSrc1);
        DecisionVariableDeclaration dFam1 = (DecisionVariableDeclaration) ModelQuery.findElementByName(prj, "fam1", 
            DecisionVariableDeclaration.class);
        Assert.assertNotNull(dFam1);
        DecisionVariableDeclaration dFe1 = (DecisionVariableDeclaration) ModelQuery.findElementByName(prj, "fe1", 
            DecisionVariableDeclaration.class);
        Assert.assertNotNull(dFe1);
        
        assertReferences(cfg, dSrc1, cfg.getDecision(dDs1), true);
        assertReferences(cfg, dFe1, Configuration.getNestedElement(cfg.getDecision(dFam1), "members"), false);
    }

    /**
     * Asserts actual and available references on the decision variable of <code>decl</code>.
     * 
     * @param cfg the configuration
     * @param decl the variable declaration
     * @param notAvailable the value that shall not be in the "available" slot of the value of <code>decl</code>
     * @param assertActual assert the value in the "actual" slot of the value of <code>decl</code> by the 
     *   {@link #projectFirstValue(Value) first value} of "available" and not by the 
     *   {@link #projectFirstValue(Value) first value} of "notAvailable)
     */
    private static void assertReferences(Configuration cfg, DecisionVariableDeclaration decl, 
        IDecisionVariable notAvailable, boolean assertActual) {
        Value expectedActualValue = null;
        Value unexpectedActualValue = null;
        IDecisionVariable var = cfg.getDecision(decl);
        Assert.assertNotNull(var);
        
        IDecisionVariable available = var.getNestedElement("available");
        Assert.assertNotNull(available);
        Assert.assertEquals(AssignmentState.ASSIGNED, available.getState());
        Assert.assertNotEquals(NullValue.INSTANCE, available.getValue());
        if (null != notAvailable) {
            Value notAvailValue = Configuration.dereference(cfg, notAvailable.getValue());
            if (null != notAvailValue) {
                Value value = Configuration.dereference(cfg, available.getValue());
                Assert.assertNotEquals(notAvailValue, value);
                expectedActualValue = projectFirstValue(value);
                unexpectedActualValue = projectFirstValue(notAvailValue);
            }
        }

        if (assertActual) {
            IDecisionVariable actual = var.getNestedElement("actual");
            Assert.assertNotNull(actual);
            Assert.assertEquals(AssignmentState.ASSIGNED, actual.getState());
            Value value = actual.getValue();
            Assert.assertNotEquals(NullValue.INSTANCE, value);
            if (null != unexpectedActualValue) {
                Assert.assertNotEquals(unexpectedActualValue, value);
            }
            if (null != expectedActualValue) {
                Assert.assertEquals(expectedActualValue, value);
            }
        }
    }
    
    /**
     * Returns the "first value" of <code>value</code>, i.e., <code>value</code> if <code>value</code> is not a 
     * container, the first value of the container else.
     * 
     * @param value the value to look into
     * @return the projected first value (may be <b>null</b>)
     */
    private static Value projectFirstValue(Value value) {
        Value result = null;
        if (value instanceof ContainerValue) {
            ContainerValue cVal = (ContainerValue) value;
            if (cVal.getElementSize() > 0) {
                result = cVal.getElement(0);
            }
        } else {
            result = value;
        }
        return result;
    }

}
