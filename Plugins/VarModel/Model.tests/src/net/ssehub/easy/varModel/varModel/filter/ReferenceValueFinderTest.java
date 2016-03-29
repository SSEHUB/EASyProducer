package net.ssehub.easy.varModel.varModel.filter;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.filter.ReferenceValuesFinder;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * Tests for {@link ReferenceValuesFinder}.
 * @author El-Sharkawy
 *
 */
public class ReferenceValueFinderTest {

    private Project project;
    
    /**
     * Creates a project.
     * This created project should only containt elements, which can be used for all tests in this class.
     */
    @Before
    public void setUp() {
        project = new Project("main");
    }
    
    /**
     * Tests whether all correct compounds will be found in case of refined compounds are defined.
     */
    @Test
    public void testFindRefinedCompounds() {
        //Create Project with refined compound and reference
        Compound baseCmp = new Compound("BasisCMP", project);
        project.add(baseCmp);
        DecisionVariableDeclaration baseDecl = new DecisionVariableDeclaration("baseCmp", baseCmp, project);
        project.add(baseDecl);
        Compound refinedCmp = new Compound("RefinedCMP", project, baseCmp);
        project.add(refinedCmp);
        DecisionVariableDeclaration refinedDecl = new DecisionVariableDeclaration("refinedCmp", refinedCmp, project);
        project.add(refinedDecl);
        Reference refType1 = new Reference("cmpRefRefined", refinedCmp, project);
        project.add(refType1);
        Reference refType2 = new Reference("cmpRefBase", baseCmp, project);
        project.add(refType2);

        // Check whether project can be used for testing
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        Assert.assertTrue("Error: Created project has errors.", validator.getErrorCount() == 0);
        
        // Find all possible variable declarations for the reference
        List<AbstractVariable> possibleDeclarations1 = ReferenceValuesFinder.findPossibleValues(project, refType1);
        List<AbstractVariable> possibleDeclarations2 = ReferenceValuesFinder.findPossibleValues(project, refType2);
        
        // Check whether the suggested list is complete
        Assert.assertEquals("Error: wrong number of suggestions found.", 1, possibleDeclarations1.size());
        AbstractVariable[] expectedDeclarations = new AbstractVariable[] {refinedDecl};
        Assert.assertThat(possibleDeclarations1, CoreMatchers.hasItems(expectedDeclarations));
        expectedDeclarations = new AbstractVariable[] {refinedDecl, baseDecl};
        Assert.assertEquals("Error: wrong number of suggestions found.", 2, possibleDeclarations2.size());
        Assert.assertThat(possibleDeclarations2, CoreMatchers.hasItems(expectedDeclarations));
    }

}
