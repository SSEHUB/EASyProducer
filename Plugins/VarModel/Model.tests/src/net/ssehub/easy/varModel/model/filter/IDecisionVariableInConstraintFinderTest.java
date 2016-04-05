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
package net.ssehub.easy.varModel.model.filter;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the {@link IDecisionVariableInConstraintFinder}.
 * @author El-Sharkawy
 */
public class IDecisionVariableInConstraintFinderTest {

    private Project project;
    private Configuration config;
    
    // Used declarations
    private DecisionVariableDeclaration cmp1Decl;
    private DecisionVariableDeclaration slotDecl1;
    private DecisionVariableDeclaration cmp2Decl;
    private DecisionVariableDeclaration slotDecl2;
    private DecisionVariableDeclaration cmpsDecl;
    
    /**
     * Created {@link #project} and {@link #config} with default datatypes and declarations for testing purposes.
     * @param projectName The name of the test, for debugging purpose.
     */
    private void createProjectAndConfig(String projectName) {
        project = new Project(projectName);
        
        // First compound
        Compound cmpType1 = new Compound("CP1", project);
        slotDecl1 = new DecisionVariableDeclaration("slot1", IntegerType.TYPE, cmpType1);
        cmpType1.add(slotDecl1);
        project.add(cmpType1);
        cmp1Decl = new DecisionVariableDeclaration("cmp1", cmpType1, project);
        project.add(cmp1Decl);
        //Refined compound
        Compound cmpType2 = new Compound("CP2", project, cmpType1);
        slotDecl2 = new DecisionVariableDeclaration("slot2", IntegerType.TYPE, cmpType2);
        cmpType2.add(slotDecl2);
        project.add(cmpType2);
        cmp2Decl = new DecisionVariableDeclaration("cmp2", cmpType2, project);
        project.add(cmp2Decl);
        
        // Add further types and declarations here
        Sequence seqOfCmpType = new Sequence("seqOfCmpType", cmpType1, project);
        cmpsDecl = new DecisionVariableDeclaration("cmps", seqOfCmpType, project);
        try {
            Object[] cmpValues = new Value[] {ValueFactory.createValue(cmpType1, new Object[] {"slot1", 1}),
                ValueFactory.createValue(cmpType1, new Object[] {"slot1", 2})};
            cmpsDecl.setValue(cmpValues);
        } catch (ValueDoesNotMatchTypeException e1) {
            Assert.fail("Could not create default value for sequence of compounds");
        }
        
        project.add(cmpsDecl);
        
        // Validate before testing and create configuration
        ProjectTestUtilities.validateProject(project);
        config = new Configuration(project);
    }
    
    /**
     * Helper method: Uses {@link IDecisionVariableInConstraintFinder} to search for {@link IDecisionVariable}s in the
     * specified {@link ConstraintSyntaxTree} and checks whether <b>exactly</b> the same variables are found.
     * @param cst The constraint to test the capabilities of the {@link IDecisionVariableInConstraintFinder}.
     * @param expectedVariables A complete list of expected variables to be found.
     */
    private void assertFoundVariables(ConstraintSyntaxTree cst, IDecisionVariable... expectedVariables) {
        // Check that constraint is sufficient for retrieval
        try {
            cst.inferDatatype();
        } catch (CSTSemanticException e) {
            Assert.fail("Failure in constraint: " + e.getMessage());
        }
        
        // Retrieval
        IDecisionVariableInConstraintFinder finder = new IDecisionVariableInConstraintFinder(config);
        cst.accept(finder);
        Set<IDecisionVariable> actualFoundVariables = finder.getVariables();
        
        // Assertion
        Assert.assertEquals("Different number of variables found than expected: ", expectedVariables.length,
            actualFoundVariables.size());
        for (int i = 0; i < expectedVariables.length; i++) {
            Assert.assertTrue("Expected variable \"" + expectedVariables[i].getDeclaration().getName()
                + "\" not found:", actualFoundVariables.contains(expectedVariables[i]));
        }
    }
    
    /**
     * Tests whether compound accesses of refines compounds work.
     */
    @Test
    public void testRefinedCompoundSlotRetrieval() {
        createProjectAndConfig("testRefinedCompoundSlotRetrieval");
        
        CompoundAccess access = new CompoundAccess(new Variable(cmp2Decl), slotDecl1.getName());
        IDecisionVariable cmpVariable = config.getDecision(cmp2Decl);
        IDecisionVariable slotVar = cmpVariable.getNestedElement(slotDecl1.getName());
        assertFoundVariables(access, cmpVariable, slotVar);
    }
    
    /**
     * Tests whether sequence accesses work (array access via []).
     */
    @Test
    public void testSequenceArrayAccess() {
        createProjectAndConfig("testSequenceArrayAccess");
        
        OCLFeatureCall containerAccess = null;
        try {
            ConstantValue value1 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 1));
            containerAccess = new OCLFeatureCall(new Variable(cmpsDecl), OclKeyWords.INDEX_ACCESS, value1);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("1 as cst value.");
        }
        IDecisionVariable containerVariable = config.getDecision(cmpsDecl);
        IDecisionVariable nestedVar = containerVariable.getNestedElement(1);
        assertFoundVariables(containerAccess, containerVariable, nestedVar);
    }
}
