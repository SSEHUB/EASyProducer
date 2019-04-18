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

import org.junit.Test;
import org.junit.Assert;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier.CopySpec;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier.IAssignmentListener;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier.IFreezeProvider;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier.EnumAttributeFreezeProvider;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * A test for {@link VariableValueCopier}.
 * 
 * @author Holger Eichelberger
 */
public class VariableValueCopierTest {

    /**
     * Tests the copier mechanism.
     * 
     * @throws ConfigurationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public void testCopier() throws ConfigurationException, ValueDoesNotMatchTypeException, ModelQueryException, 
        CSTSemanticException {
        testCopier("myVar_", null); 
        AssignmentListener listener = new AssignmentListener();
        testCopier("myListVar_", listener);
        Assert.assertEquals(3, listener.getCount());        
    }
    
    /**
     * A simple test assignment listener.
     * 
     * @author Holger Eichelberger
     */
    private static class AssignmentListener implements IAssignmentListener {

        private int count;
        
        @Override
        public void notifyAssigned(IDecisionVariable target, Value value, boolean added) {
            count++;
        }
        
        /**
         * Returns the assignment count.
         * 
         * @return the assignment count
         */
        private int getCount() {
            return count;
        }

        @Override
        public void notifyCreated(IDecisionVariable origin, IDecisionVariable target) {
        }
        
    }

    /**
     * Creates a (slot) variable.
     * 
     * @param name the name of the variable
     * @param type the data type
     * @param par the parent (compound)
     * @return the created variable
     */
    private DecisionVariableDeclaration createVar(String name, IDatatype type, IDecisionVariableContainer par) {
        DecisionVariableDeclaration var = new DecisionVariableDeclaration(name, type, par);
        par.add(var);
        return var;
    }

    /**
     * Creates a (top-level) variable.
     * 
     * @param name the name of the variable
     * @param type the data type
     * @param par the parent project
     * @return the created variable
     */
    private DecisionVariableDeclaration createVar(String name, IDatatype type, Project par) {
        DecisionVariableDeclaration var = new DecisionVariableDeclaration(name, type, par);
        par.add(var);
        return var;
    }
    
    /**
     * Explicitly sets a value for {@code var} on {@code cfg}.
     * 
     * @param cfg the configuration
     * @param var the variable declaration
     * @param value the value for {@code var}
     * @throws ConfigurationException in case that {@code var} cannot be configured
     * @throws ValueDoesNotMatchTypeException in case that the given value does not match the variable type
     */
    private void setValue(Configuration cfg, AbstractVariable var, Object... value) throws ConfigurationException, 
        ValueDoesNotMatchTypeException {
        cfg.getDecision(var).setValue(ValueFactory.createValue(var.getType(), value), AssignmentState.ASSIGNED);
    }

    /**
     * Creates the test configuration.
     * 
     * @return the configuration
     * @throws ConfigurationException in case that a variable cannot be configured
     * @throws ValueDoesNotMatchTypeException in case that a value does not match a variable type
     * @throws CSTSemanticException in case that a constraint is wrong
     */
    private Configuration createConfiguration() throws ConfigurationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        Project prj = new Project("Test");
        
        OrderedEnum bt = new OrderedEnum("BindingTime", prj);
        bt.add(new EnumLiteral("compile", 1, bt));
        bt.add(new EnumLiteral("runtime", 2, bt));
        prj.add(bt);

        Attribute attr = new Attribute("bindingTime", bt, prj, prj);
        attr.setValue(new ConstantValue(ValueFactory.createValue(bt, "compile")));
        prj.add(attr);

        Compound tDataSource = new Compound("DataSource", prj);
        prj.add(tDataSource);
        Reference tDataSrcRef = new Reference("", tDataSource, prj);
        Set tDataSrcSet = new Set("", tDataSrcRef, prj);

        Compound tAlgorithm = new Compound("Algorithm", prj);
        prj.add(tAlgorithm);
        Reference tAlgRef = new Reference("", tAlgorithm, prj);
        Set tAlgSet = new Set("", tAlgRef, prj);

        Compound tFamily = new Compound("Family", prj);
        createVar("members", tAlgSet, tFamily);
        prj.add(tFamily);
        
        Compound tSource = new Compound("Source", prj);
        createVar("source", tDataSrcRef, tSource);
        AttributeAssignment assng = new AttributeAssignment(tSource);
        assng.add(new Assignment("bindingTime", "=", new ConstantValue(ValueFactory.createValue(bt, "runtime"))));
        createVar("actual", tDataSrcRef, assng);
        createVar("available", tDataSrcSet, assng);
        tSource.add(assng);
        prj.add(tSource);

        Compound tFamilyElement = new Compound("FamilyElement", prj);
        createVar("family", new Reference("", tFamily, prj), tFamilyElement);
        assng = new AttributeAssignment(tSource);
        assng.add(new Assignment("bindingTime", "=", new ConstantValue(ValueFactory.createValue(bt, "runtime"))));
        createVar("actual", tAlgRef, assng);
        createVar("available", tAlgSet, assng);
        tFamilyElement.add(assng);
        prj.add(tFamilyElement);
        
        DecisionVariableDeclaration ds1 = createVar("ds1", tDataSource, prj);
        DecisionVariableDeclaration src1 = createVar("src1", tSource, prj);
        DecisionVariableDeclaration alg1 = createVar("alg1", tAlgorithm, prj);
        DecisionVariableDeclaration alg2 = createVar("alg2", tAlgorithm, prj);
        DecisionVariableDeclaration fam1 = createVar("fam1", tFamily, prj);
        DecisionVariableDeclaration fe1 = createVar("fe1", tFamilyElement, prj);
        
        Configuration result = new Configuration(prj);
        setValue(result, ds1, ValueFactory.EMPTY);
        setValue(result, src1, new Object[] {"source", ds1});
        setValue(result, alg1, ValueFactory.EMPTY);
        setValue(result, alg2, ValueFactory.EMPTY);
        setValue(result, fam1, new Object[] {"members", new Object[] {alg1, alg2}});
        setValue(result, fe1, new Object[] {"family", fam1});
        return result;
    }
    
    /**
     * Tests the copier mechanism.
     * 
     * @param prefix the copy variable prefix for new variables
     * @param listener the listener to use
     * @return the number of primarily assigned values
     * 
     * @throws ConfigurationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    private int testCopier(String prefix, IAssignmentListener listener) throws ConfigurationException, 
        ValueDoesNotMatchTypeException, ModelQueryException, CSTSemanticException {
        Configuration cfg = createConfiguration();
        Project prj = cfg.getProject();

        Compound sourceType = (Compound) ModelQuery.findType(prj, "Source", Compound.class);
        Assert.assertNotNull(sourceType);
        Compound familyElementType = (Compound) ModelQuery.findType(prj, "FamilyElement", Compound.class);
        Assert.assertNotNull(familyElementType);
        Enum bindingTime = (Enum) ModelQuery.findType(prj, "BindingTime", Enum.class);
        Assert.assertNotNull(bindingTime);
        Attribute annotation = (Attribute) ModelQuery.findElementByName(prj, "bindingTime", Attribute.class);
        Assert.assertNotNull(annotation);
        
        IFreezeProvider freezeProvider = new EnumAttributeFreezeProvider("b", annotation, OclKeyWords.GREATER_EQUALS, 
            bindingTime.getLiteral(1));
        CopySpec spec1 = new CopySpec(sourceType, "source", freezeProvider, "available", "actual");
        CopySpec spec2 = new CopySpec(familyElementType, "family.members", freezeProvider, "available");
        VariableValueCopier copier = new VariableValueCopier(prefix, spec1, spec2);
        copier.setAssignmentListener(listener);
        copier.process(cfg);

        //System.out.println(StringProvider.toIvmlString(cfg.toProject(true)));

        DecisionVariableDeclaration dDs1 = (DecisionVariableDeclaration) ModelQuery.findElementByName(prj, "ds1", 
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
        assertReferences(cfg, dFe1, getNestedElement(cfg.getDecision(dFam1), "members"), false);

        return 3;
    }
    
    /**
     * Returns an element for <code>base</code> specified by its name. This method is not recursive!
     * 
     * @param base the base variable to search on (may be <b>null</b>)
     * @param name the name of the nested element
     * @return the nested element (may be <b>null</b> if not found or <code>base</code> is <b>null</b>)
     */
    public static IDecisionVariable getNestedElement(IDecisionVariable base, String name) {
        return net.ssehub.easy.varModel.confModel.Configuration.getNestedElement(base, name);
    }
    
    /**
     * Dereferences a value.
     * 
     * @param conf the configuration access
     * @param value the value to be dereferenced
     * @return the dereferenced value
     */
    private static Value dereference(IConfiguration conf, Value value) {
        return net.ssehub.easy.varModel.confModel.Configuration.dereference(conf, value);
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
    private static void assertReferences(net.ssehub.easy.varModel.confModel.Configuration cfg, 
        DecisionVariableDeclaration decl, IDecisionVariable notAvailable, boolean assertActual) {
        Value expectedActualValue = null;
        Value unexpectedActualValue = null;
        IDecisionVariable var = cfg.getDecision(decl);
        Assert.assertNotNull(var);
        
        IDecisionVariable available = var.getNestedElement("available");
        Assert.assertNotNull(available);
        Assert.assertEquals(AssignmentState.ASSIGNED, available.getState());
        Assert.assertNotEquals(NullValue.INSTANCE, available.getValue());
        if (null != notAvailable) {
            Value notAvailValue = dereference(cfg, notAvailable.getValue());
            if (null != notAvailValue) {
                Value value = dereference(cfg, available.getValue());
                Assert.assertNotEquals(notAvailValue, value);
                expectedActualValue = projectFirstValue(value);
                unexpectedActualValue = projectFirstValue(notAvailValue);
                assertFrozen(cfg, available.getValue());
            }
        }

        if (assertActual) {
            IDecisionVariable actual = var.getNestedElement("actual");
            Assert.assertNotNull(actual);
            Assert.assertEquals(AssignmentState.ASSIGNED, actual.getState());
            Value value = actual.getValue();
            assertFrozen(cfg, value);
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
    
    /**
     * Asserts that <code>value</code> is "frozen", i.e., if it is a container, all elements are considered to be
     * frozen and if it is not a container but a reference value, the referenced variable is frozen (regardless 
     * compound slots as the may be subject to freeze-buts).
     * 
     * @param cfg the configuration
     * @param value the value to assert the frozen state on
     */
    private static void assertFrozen(net.ssehub.easy.varModel.confModel.Configuration cfg, Value value) {
        if (value instanceof ContainerValue) {
            ContainerValue cVal = (ContainerValue) value;
            for (int e = 0; e < cVal.getElementSize(); e++) {
                assertFrozen(cfg, cVal.getElement(e));
            }
        } else if (value instanceof ReferenceValue) {
            ReferenceValue refValue = (ReferenceValue) value;
            IDecisionVariable var = cfg.getDecision(refValue.getValue());
            Assert.assertNotNull(var);
            Assert.assertEquals(AssignmentState.FROZEN, var.getState());
        }
    }
    
}
