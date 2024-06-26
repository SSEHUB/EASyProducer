package net.ssehub.easy.varModel.model.filter;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Test whether filtering of constraints works correctly.
 * @author El-Sharkawy
 *
 */
public class ConstraintSeparatorTest {
    
    private static Project project;
    private static Constraint assingmentConstraint;
    private static Constraint unequalConstraint;

    /**
     * SetupBefore Class method, creating a project for testing.
     * @throws ValueDoesNotMatchTypeException Should not occur,
     * otherwise there exist an error in the {@link ValueFactory} class.
     * @throws CSTSemanticException Should not occur, otherwise there exist an error in the {@link Constraint} class.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        //Create Project and Variables
        project = new Project("TestProject");
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(intA);
        project.add(intB);
        
        //Create AssignmentConstraint
        Variable varA = new Variable(intA);
        Value constValueA = ValueFactory.createValue(intA.getType(), "1");
        ConstantValue constA = new ConstantValue(constValueA);
        OCLFeatureCall assingment = new OCLFeatureCall(varA, OclKeyWords.ASSIGNMENT, constA);
        assingmentConstraint = new Constraint(assingment, project);
        project.add(assingmentConstraint);
        
        //Create normal constraint
        Variable varA2 = new Variable(intA);
        Variable varB = new Variable(intB);
        OCLFeatureCall unequal = new OCLFeatureCall(varA2, OclKeyWords.UNEQUALS, varB);
        unequalConstraint = new Constraint(unequal, project);
        project.add(unequalConstraint);
    }

    /**
     * Test method for testing whether the {@link ConstraintSeparator} works correctly on projects
     * without considering imports.
     */
    @Test
    public void testNotImportedConstraints() {
        ConstraintSeparator separator = new ConstraintSeparator(project);
        List<Constraint> assingmentConstraints = separator.getAssingmentConstraints();
        List<Constraint> normalConstraints = separator.getNormalConstraints();
        List<Constraint> allConstraints = separator.getAllConstraints();
        
        // Test whether assignment Constraint was found correctly.
        Assert.assertEquals(1, assingmentConstraints.size());
        Assert.assertThat(assingmentConstraints, hasItems(new Constraint[]{assingmentConstraint}));
        
        // Test whether normal Constraint was found correctly.
        Assert.assertEquals(1, normalConstraints.size());
        Assert.assertThat(normalConstraints, hasItems(new Constraint[]{unequalConstraint}));
        
        // Test whether all Constraint was found correctly.
        Assert.assertEquals(2, allConstraints.size());
        Assert.assertThat(allConstraints, hasItems(new Constraint[]{assingmentConstraint, unequalConstraint}));
    }

}
