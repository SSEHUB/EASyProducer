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
import org.junit.Ignore;
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
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
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
    public void testStringEqualityViaAbstracrtDeclaration() {
        Project testProject = createBasisTestProject("testStringEqualityViaAbstracrtDeclaration", StringType.TYPE,
            false, "Hello");
        // str == refTo(str)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 1, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }
    
    /**
     * Tests that a String variable and a reference pointing to the variable are equal.<br/>
     * A {@link ConstraintSyntaxTree} is used to point to the declaration, which must be parsed. <br/>
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
    public void testStringEqualityViaCST() {
        Project testProject = createBasisTestProject("testStringEqualityViaCST", StringType.TYPE, true, "Hello");
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
             false, "Hello", "Hello");
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
            StringType.TYPE, false, "Hello", "World");
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
            StringType.TYPE, false, "Hello", "World");
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
            StringType.TYPE, false, "Hello", "Hello");
        // refVar0 == refVar1
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 2, 3, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, false);
    }
    
    /**
     * Tests that a container and a reference to this container are equal.<br/>
     * <b>Tests:</b>
     * <pre><code>
     * sequenceOf(Integer) var0 = {1, 2, 3};
     * refTo(sequenceOf(Integer)) refVar0 = refBy(var0);
     * 
     * var0 == refVar0;
     * </code></pre>
     * <b>Expected result:</b> is valid
     */
    @Test
    public void testEqualityForContainers() {
        Sequence seqType = new Sequence("seqOfInt", IntegerType.TYPE, null);
        Value value = null;
        try {
            value = ValueFactory.createValue(seqType, 1, 2, 3);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create container value: " + e.getMessage());
        }
        Project testProject = createBasisTestProject("testEqualityForContainers", seqType,
            false, value);
        seqType.setParent(testProject);
        // sequence == refTo(sequence)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(testProject, 0, 1, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }
    
    /**
     * Tests that a container and a reference to this container are equal.<br/>
     * <b>Tests:</b>
     * <pre><code>
     * sequenceOf(Integer) var0 = {1, 2, 3};
     * refTo(sequenceOf(Integer)) refVar0 = refBy(var0); // Not needed, but generated
     * sequenceOf(refTo(Integer)) refVar1 = {refBy{var0[0]}, refBy{var0[1]}, refBy{var0[2]}}
     * 
     * var0 == refVar0;
     * </code></pre>
     * <b>Expected result:</b> is valid
     */
    @Ignore("sequenceOf(Integer) and sequenceOf(refTo(Integer)) are not compliant")
    @Test
    public void testEqualityForContainerElements() {
        Sequence seqType1 = new Sequence("seqOfInt", IntegerType.TYPE, null);
        Value value = null;
        try {
            value = ValueFactory.createValue(seqType1, 1, 2, 3);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create container value: " + e.getMessage());
        }
        Project testProject = createBasisTestProject("testEqualityForContainerElements", seqType1,
            false, value);
        seqType1.setParent(testProject);
        Reference intRefType = new Reference("intRef", IntegerType.TYPE, testProject);
        Sequence seqType2 = new Sequence("seqOfIntRefs", intRefType, testProject);
        DecisionVariableDeclaration refSeqDecl = new DecisionVariableDeclaration("refVar1", seqType2, testProject);
        testProject.add(refSeqDecl);
        
        // Create value for sequenceOf(refTo(Integer)) pointing to each element of sequenceOf(Integer)
        AbstractVariable orgDeclaration = (AbstractVariable) testProject.getElement(0);
        Variable orgContainer = new Variable(orgDeclaration);
        Value[] value2 = new Value[3];
        for (int i = 0; i < value2.length; i++) {
            OCLFeatureCall indexElement = null;
            try {
                ConstantValue indexValue = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, i));
                indexElement = new OCLFeatureCall(orgContainer, OclKeyWords.INDEX_ACCESS, indexValue);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail("Could not create index based reference to\"" + orgDeclaration.getName() + "[" + i + "]\":"
                    + e.getMessage());
            }
            try {
                value2[i] = ValueFactory.createValue(intRefType, indexElement);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail("Could not create expression based reference value: " + e.getMessage());
            }
        }
        try {
            Value seqValue = ValueFactory.createValue(refSeqDecl.getType(), (Object[]) value2);
            refSeqDecl.setValue(seqValue);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create sequence value for \"" + refSeqDecl.getName() + "\": " + e.getMessage());
        }
        
        // Project changed -> validate again before testing
        ProjectTestUtilities.validateProject(testProject, true);
        
        
        // sequence == refTo(sequence)
        ConstraintSyntaxTree equalityCST = createEqualityConstraint(orgDeclaration, refSeqDecl, true);
        
        // Test correct evaluation of the created constraint
        validateConstraint(testProject, equalityCST, true);
    }

    /**
     * Evaluates the specified constraint with the {@link EvaluationVisitor} and tests that the
     * {@link EvaluationVisitor} creates the expected output.
     * @param testProject The project which is used for testing.
     * @param equalityCST The (un)equality constraint to evaluate.
     * @param isValid {@code true} The {@link EvaluationVisitor} should <b>not</b> detect a violation,
     *     {@code false} the {@link EvaluationVisitor} should detect a violation.
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
     * @param equal {@code true} equality will be checked, {@code false} unequality will be checked.
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
     * @param equal {@code true} equality will be checked, {@code false} unequality will be checked.
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
            Assert.fail("Could not infer datatype for \"" + op + "\" constraint: " + e.getMessage());
        }
        
        return equalityCst;
    }
    
    /**
     * Creates a project for testing. This project contains as many variables of the given {@code basisType} as values
     * passed to the project. For each variable, the specified value will be assigned as default value. <br>
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
     * @param refValuesAsCst {@code false} The target {@link AbstractVariable} will directly be stored inside the
     *     {@link net.ssehub.easy.varModel.model.values.ReferenceValue}, this declaration can be accessed via the
     *     {@link net.ssehub.easy.varModel.model.values.ReferenceValue#getValue()} method. {@code true} A
     *     {@link ConstraintSyntaxTree} is used to point to the declaration. In this case,
     *     {@link net.ssehub.easy.varModel.model.values.ReferenceValue#getValueEx()} must be used and parsed to get the
     *     desired declaration.
     * @param values The default values for the unreferred declarations. This specifies also how many variables shall be
     *     created. 
     * @return Returns a project which can be used for testing.
     */
    private Project createBasisTestProject(String projectName, IDatatype basisType, boolean refValuesAsCst,
        Object... values) {
        
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
                /*
                 * ReferenceValues may directly to point to a AbstractVariable (ReferenceValue.getValue()),
                 * or use a constraint syntax tree to point to an AbstractVariable (ReferenceValue.getValueEx()).
                 * Currently it points directly to the AbstractVariable
                 */
                if (refValuesAsCst) {
                    // Value should store the CST (in this case only the ConstantValue)
                    refValue = ValueFactory.createValue(refType, cstValue);
                    cstValue = new ConstantValue(refValue);
                }
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
