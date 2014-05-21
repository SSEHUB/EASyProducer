package de.uni_hildesheim.sse.varModel.filter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Abstract super class for testing <tt>FreezeBlockFinder</tt> and <tt>FrozenElementsFinder</tt>.
 * @author El-Sharkawy
 *
 */
public class AbstractFrozenElementsFinderTest {

    protected static final Project ORIGIN_PROJECT = new Project("Project A");
    protected static final FreezeBlock[] FREEZEBLOCKS = new FreezeBlock[4];
    
    private static final Project IMPORTED_PROJECT_1 = new Project("Project B");
    private static final Project IMPORTED_PROJECT_2 = new Project("Project C");
    private static final Project IMPORTED_PROJECT_3 = new Project("Project D");
    
    private static final List<ModelManagementException> STATIC_EXCEPTIONS = new ArrayList<ModelManagementException>();
    
    /**
     * Cannot be done in setUpBeforeClass method, otherwise the amount of imports will change with every new sub class.
     */
    static {
        createProject(ORIGIN_PROJECT, 0);
        createProject(IMPORTED_PROJECT_1, 1);
        createProject(IMPORTED_PROJECT_2, 2);
        createProject(IMPORTED_PROJECT_3, 3);
        
        // Create following structure
        // A imports B, C
        // B imports D
        ProjectImport importB = new ProjectImport(IMPORTED_PROJECT_1.getName(), null);
        try {
            importB.setResolved(IMPORTED_PROJECT_1);
        } catch (ModelManagementException e) {
            STATIC_EXCEPTIONS.add(e);
        }
        ORIGIN_PROJECT.addImport(importB);
        ProjectImport importC = new ProjectImport(IMPORTED_PROJECT_2.getName(), null);
        try {
            importC.setResolved(IMPORTED_PROJECT_2);
        } catch (ModelManagementException e) {
            STATIC_EXCEPTIONS.add(e);
        }
        ORIGIN_PROJECT.addImport(importC);
        ProjectImport importD = new ProjectImport(IMPORTED_PROJECT_3.getName(), null);
        try {
            importD.setResolved(IMPORTED_PROJECT_3);
        } catch (ModelManagementException e) {
            STATIC_EXCEPTIONS.add(e);
        }
        IMPORTED_PROJECT_1.addImport(importD);
    }
    
    /**
     * Tests whether the static initialization did not fail.
     */
    @Test
    public void testCorrectInitialization() {
        Assert.assertEquals(0, STATIC_EXCEPTIONS.size());
    }

    /**
     * Creates one project for testing.
     * @param project The project which should be configured
     * @param index For creating independent names and for accessing the FREEZEBLOCKS array
     */
    private static void createProject(Project project, int index) {
        //Create data types
        Compound cmpClass = new Compound("CP" + index, project);
        project.add(cmpClass);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB" + index, IntegerType.TYPE, cmpClass);
        DecisionVariableDeclaration strB = new DecisionVariableDeclaration("strB" + index, StringType.TYPE, cmpClass);
        cmpClass.add(intB);
        cmpClass.add(strB);
        
        //Create some variables.
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA" + index, IntegerType.TYPE, project);
        DecisionVariableDeclaration strA = new DecisionVariableDeclaration("strA" + index, StringType.TYPE, project);
        DecisionVariableDeclaration cmpB = new DecisionVariableDeclaration("cmpB" + index, cmpClass, project);
        project.add(intA);
        project.add(strA);
        project.add(cmpB);
        
        //Create a freeze block
        FREEZEBLOCKS[index] = new FreezeBlock(new IFreezable[] {intA, cmpB}, null, project);
        project.add(FREEZEBLOCKS[index]);
    }
}
