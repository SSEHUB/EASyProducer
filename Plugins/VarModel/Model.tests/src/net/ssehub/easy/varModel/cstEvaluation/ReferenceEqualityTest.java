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

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests for checking {@link OclKeyWords#EQUALS} on {@link Reference}s and unreferenced variables.
 * @author El-Sharkawy
 *
 */
public class ReferenceEqualityTest {

    /**
     * Tests that a String variable and a reference pointing to the variable are equal.<br/>
     * <b>Tests:</b>
     * <pre><code>
     * String var0 = "Hello";
     * refTo(String) refVar0 = refBy(var0);
     * 
     * var0 == refVar0;
     * </code></pre>
     * <b>Expected result:</b> is valid
     */
    @Test
    public void testStringEquality() {
        Project testProject = createBasisTestProject("testStringEquality", StringType.TYPE, "Hello");
        // str == refTo(str)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 1, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }
    
    /**
     * Tests that a String variable and a reference pointing to a variable with the same value are equal.<br/>
     * <b>Tests:</b>
     * <pre><code>
     * String var0 = "Hello";
     * String var1 = "Hello";
     * refTo(String) refVar0 = refBy(var0);
     * refTo(String) refVar1 = refBy(var1);
     * 
     * var0 == refVar1;
     * </code></pre>
     * <b>Expected result:</b> is valid
     */
    @Test
    public void testStringEqualityBetweenDifferentInstances() {
        Project testProject = createBasisTestProject("testStringEqualityBetweenDifferentInstances", StringType.TYPE,
            "Hello", "Hello");
        // str0 == refTo(str1)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 3, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }
    
    /**
     * Tests that a String variable and a reference pointing to a variable with a different value are <b>not</b> equal.
     * <br/>
     * <b>Tests:</b>
     * <pre><code>
     * String var0 = "Hello";
     * String var1 = "World";
     * refTo(String) refVar0 = refBy(var0);
     * refTo(String) refVar1 = refBy(var1);
     * 
     * var0 != refVar1;
     * </code></pre>
     * <b>Expected result:</b> is valid
     */
    @Test
    public void testStringUnEqualityBetweenDifferentInstancesValid() {
        Project testProject = createBasisTestProject("testStringUnEqualityBetweenDifferentInstancesValid",
            StringType.TYPE, "Hello", "World");
        // str0 != refTo(str1)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 3, false);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }
    
    /**
     * Tests that the {@link EvaluationVisitor} is able to detect a constraint violation between a String variable
     * and a reference pointing to a variable with a different value.
     * <br/>
     * <b>Tests:</b>
     * <pre><code>
     * String var0 = "Hello";
     * String var1 = "World";
     * refTo(String) refVar0 = refBy(var0);
     * refTo(String) refVar1 = refBy(var1);
     * 
     * var0 == refVar1;
     * </code></pre>
     * <b>Expected result:</b> is invalid
     */
    @Test
    public void testStringUnEqualityBetweenDifferentInstancesInvalid() {
        Project testProject = createBasisTestProject("testStringUnEqualityBetweenDifferentInstancesInvalid",
            StringType.TYPE, "Hello", "World");
        // str0 == refTo(str1)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 3, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, false);
    }
    
    /**
     * Tests that a two references pointing to different variables with the same values are not equal.<br/>
     * <b>Tests:</b>
     * <pre><code>
     * String var0 = "Hello";
     * String var1 = "Hello";
     * refTo(String) refVar0 = refBy(var0);
     * refTo(String) refVar1 = refBy(var1);
     * 
     * refVar0 == refVar1;
     * </code></pre>
     * <b>Expected result:</b> is invalid
     */
    @Test
    public void testUnEqualityOfDifferentReferencesWithSameValues() {
        Project testProject = createBasisTestProject("testUnEqualityOfDifferentReferencesWithSameValues",
            StringType.TYPE, "Hello", "Hello");
        // refVar0 == refVar1
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 2, 3, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, false);
    }

    /**
     * Evaluates the specified constraint with the {@link EvaluationVisitor} and tests that the
     * {@link EvaluationVisitor} creates the expected output.
     * @param testProject The project which is used for testing.
     * @param equalityCST The (un)equality constraint to evaluate.
     * @param isValid <tt>true</tt> The {@link EvaluationVisitor} should <b>not</b> detect a violation,
     *     <tt>false</tt> the {@link EvaluationVisitor} should detect a violation.
     */
    private void validateConstraint(Project testProject, ConstraintSyntaxTree equalityCST, boolean isValid) {
        // Run evaluation visitor
        Configuration config = new Configuration(testProject, true);
        EvaluationVisitor evalVisitor = new EvaluationVisitor(config, null, false, null);
        equalityCST.accept(evalVisitor);
        
        // Test expected result
        String cstAsString = "\"" + StringProvider.toIvmlString(equalityCST, testProject) + "\" in project \""
            + testProject.getName() + "\"";
        if (isValid) {
            Assert.assertFalse("Evaluation visitor should NOT detect errors on " + cstAsString + ", but it did.",
                evalVisitor.constraintFailed());
            Assert.assertTrue("Evaluation visitor should NOT detect violations on " + cstAsString + ", but it did.",
                evalVisitor.constraintFulfilled());
        } else {
            Assert.assertTrue("Evaluation visitor should detect errors on " + cstAsString + ", but it did NOT.",
                evalVisitor.constraintFailed());
            Assert.assertFalse("Evaluation visitor should detect violations on " + cstAsString + ", "
                + "but it did NOT.", evalVisitor.constraintFulfilled());
        }
    }
    
    /**
     * Creates an (un)equal comparison constraint for the two variable declarations.
     * @param testProject The project, containing the two declarations.
     * @param indexDecl1 The 0 based index of the first declaration.
     * @param indexDecl2 The 0 based index of the second declaration.
     * @param equal <tt>true</tt> equality will be checked, <tt>false</tt> unequality will be checked.
     * @return The (un)equal comparison constraint for the two declarations, which can be used for evaluation
     */
    private ConstraintSyntaxTree createEqualityConstraint(Project testProject, int indexDecl1, int indexDecl2,
        boolean equal) {

        return createEqualityConstraint((AbstractVariable) testProject.getElement(indexDecl1),
            (AbstractVariable) testProject.getElement(indexDecl2), equal);
    }
    
    /**
     * Creates an (un)equal comparison constraint for the two variable declarations.
     * @param decl1 The first declaration to compare
     * @param decl2 The second variable om compare
     * @param equal <tt>true</tt> equality will be checked, <tt>false</tt> unequality will be checked.
     * @return The (un)equal comparison constraint for the two declarations, which can be used for evaluation
     */
    private ConstraintSyntaxTree createEqualityConstraint(AbstractVariable decl1, AbstractVariable decl2,
        boolean equal) {
        
        String op = equal ? OclKeyWords.EQUALS : OclKeyWords.UNEQUALS;
        ConstraintSyntaxTree equalityCst = new OCLFeatureCall(new Variable(decl1), op, new Variable(decl2));
        try {
            // Must be called to facilitate evaluation
            equalityCst.inferDatatype();
        } catch (CSTSemanticException e) {
            Assert.fail("Could not infer datatype for apply constraint: " + e.getMessage());
        }
        
        return equalityCst;
    }
    
    /**
     * Creates a project for testing. This project contains as many variables of the given <tt>basisType</tt> as values
     * passed to the project. For each variable, the specified value will be assigned as default value. <br/>
     * Further, the project contains the same amount of reference variables. The first reference will point to the
     * first unreferenced variable and so on. First comes all basis variables than all references. For example:
     * <pre><code>
     * project testStringEquality {
     *
     *   String var0 = "Hello";
     *   String var1 = "World";
     *   refTo(String) refVar0 = refBy(var0);
     *   refTo(String) refVar1 = refBy(var1);
     * }
     * </code></pre>
     * @param projectName The name of the project to be created, should be the name of the test method to simplify
     *     error analysis.
     * @param basisType The datatype which shall be used for all variable declarations
     *     (and as basis for the references).
     * @param values The default values for the unreferred declarations. This specifies also how many variables shall be
     *     created.
     * @return Returns a project which can be used for testing.
     */
    private Project createBasisTestProject(String projectName, IDatatype basisType, Object... values) {
        Project project = new Project(projectName);
        Reference refType = new Reference("reference_of_" + basisType.getName(), basisType, project);
        
        // Create basis variables
        for (int i = 0; i < values.length; i++) {
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration("var" + i, basisType, project);
            try {
                decl.setValue(values[i]);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail("Could not set value \"" + values[i] +  "\" for \"" + decl.getName() + "\" in project \""
                    + projectName + "\": " + e.getMessage());
            }
            project.add(decl);
        }
        
        // Create same amount of references
        for (int i = 0; i < values.length; i++) {
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration("refVar" + i, refType, project);
            AbstractVariable referredDecl = (AbstractVariable) project.getElement(i); 
            try {
                Value refValue = ValueFactory.createValue(refType, referredDecl);
                ConstantValue cstValue = new ConstantValue(refValue);
                decl.setValue(cstValue);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail("Could not set reference value \"" + referredDecl.getName() +  "\" for \"" + decl.getName()
                    + "\" in project \"" + projectName + "\": " + e.getMessage());
            } catch (CSTSemanticException e) {
                Assert.fail("Could not set reference value \"" + referredDecl.getName() +  "\" for \"" + decl.getName()
                    + "\" in project \"" + projectName + "\": " + e.getMessage());
            }
            project.add(decl);
        }
        
        ProjectTestUtilities.validateProject(project);
        return project;
    }
}
