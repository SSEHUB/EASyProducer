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
package net.ssehub.easy.varModel.confModel;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests whether instances of {@link DerivedDatatype}s (in IVML: {@code typedef}) can be created and configured.
 * @author El-Sharkawy
 *
 */
public class DerivedVeriableTest {

    private Project project;
    private Configuration config;
    
    /**
     * Creation of an empty project and configuration, needed for all tests.
     */
    @Before
    public void setUp() {
        project = new Project("testProject");
        config = new Configuration(project);
    }
    
    /**
     * Created a {@link DerivedDatatype} for testing using {@code basisType} as basis.
     * @param basisType A {@link IDatatype} which shall be used as basis for the new {@link DerivedDatatype}.
     * @return The newly created {@link DerivedDatatype}.
     */
    private DerivedDatatype createdDerivedType(IDatatype basisType) {
        DerivedDatatype derivedType = new DerivedDatatype("Derived" + basisType.getName(), basisType, project);
        project.add(derivedType);
        return derivedType;
    }

    /**
     * Tests whether an instance of {@link DerivedDatatype}s using {@code basisType} can be created and configured.
     * Will only created one instance and test this instance.
     * @param basisType A {@link IDatatype} which shall be used as basis for the new {@link DerivedDatatype}
     * inside this test.
     * @param debug If {@code true} The IVML code of the project will be printed to the console for debugging,
     * should be {@code false}.
     * @param value The value wich shall be assigned to the instance of the {@link DerivedDatatype} inside this test.
     */
    private void testDerivedVariable(IDatatype basisType, boolean debug, Object... value) {
        // Created Variable
        IDatatype type = createdDerivedType(basisType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("derivedVar", type, project);
        project.add(decl);
        config.refresh();
        
        // Test part 1: Valid project can be created:
        ProjectTestUtilities.validateProject(project, debug);
        IDecisionVariable var = config.getDecision(decl);
        Assert.assertNotNull(var);
        
        // Test part 2: Configure Variable
        Value val;
        try {
            val = ValueFactory.createValue(type, value);
            var.setValue(val, AssignmentState.ASSIGNED);
            var.setValue(val, AssignmentState.ASSIGNED);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Value creation Failed: " + e.getMessage());
            e.printStackTrace();
        } catch (ConfigurationException e) {
            Assert.fail("Setting value Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Tests whether an instance of {@link DerivedDatatype}s using {@link Set}s can be created.
     */
    @Test
    public void testDerivedSet() {
        Set intSet = new Set("IntegerSet", IntegerType.TYPE, project);
        testDerivedVariable(intSet, false, null, 1, 2, 3);
    }
    
    /**
     * Tests whether an instance of {@link DerivedDatatype}s using {@link Sequence}s can be created.
     */
    @Test
    public void testDerivedSequence() {
        Sequence strSeq = new Sequence("StringSequence", StringType.TYPE, project);
        testDerivedVariable(strSeq, true, null, "a", "a");
    }
    
    /**
     * Tests whether an instance of {@link DerivedDatatype}s using {@link Compound}s can be created.
     */
    @Test
    public void testDerivedCompound() {
        Compound cmpType =  new Compound("CP", project);
        project.add(cmpType);
        DecisionVariableDeclaration slotVar = new DecisionVariableDeclaration("slotA", IntegerType.TYPE, cmpType);
        cmpType.add(slotVar);
        testDerivedVariable(cmpType, false, new Object[] {slotVar.getName(), 1});
    }


}
