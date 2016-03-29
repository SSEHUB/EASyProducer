package net.ssehub.easy.varModel.varModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.StringType;

/**
 * Testcases for the project interface.
 * @author lueder
 *
 */
public class ProjectInterfaceTest {

    private Project pro;
    private ProjectInterface proIn;
    private DecisionVariableDeclaration dec1;
    private DecisionVariableDeclaration dec2;
    private DecisionVariableDeclaration[] decs;
    
    /**
     * Sets up the project before the test runs.
     */
    @Before
    public void setUp() {
        pro = new Project("Name");
        dec1 = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
        dec2 = new DecisionVariableDeclaration("Name2", StringType.TYPE, pro);
        decs = new DecisionVariableDeclaration[2];
        decs[0] = dec1;
        decs[1] = dec2;
    }

    /**
     * Creating a freeze block.
     */
    @Test
    public void creatingProjectInterface() {
        proIn = new ProjectInterface("Interface", null, pro);
        Assert.assertTrue(proIn.getExportsCount() == 0);
        proIn = new ProjectInterface("Interface", decs, pro);
        Assert.assertTrue(proIn.getExportsCount() == 2);
        Assert.assertEquals(dec1, proIn.getExport(0));
        Assert.assertEquals(dec2, proIn.getExport(1));
    }

}
