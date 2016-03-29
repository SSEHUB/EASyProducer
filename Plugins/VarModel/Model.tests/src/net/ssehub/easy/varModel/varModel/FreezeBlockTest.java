package net.ssehub.easy.varModel.varModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.StringType;

/**
 * Testcases for the evaluation block.
 * @author lueder
 *
 */
public class FreezeBlockTest {

    private Project pro;
    private FreezeBlock frb;
    private DecisionVariableDeclaration dec1;
    private DecisionVariableDeclaration dec2;
    private IFreezable[] list;
    private String[] but;
    
    /**
     * Sets up the project + decvs before the test runs.
     */
    @Before
    public void setUp() {
        pro = new Project("Name");
        dec1 = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
        dec2 = new DecisionVariableDeclaration("Name2", StringType.TYPE, pro);
        list  = new IFreezable[2];
        list[0] = dec1;
        list[1] = dec2;

        //For the second test case
        but = new String[1];
    }

    /**
     * Creating a freeze block.
     */
    @Test
    public void creatingFreezeBlock() {
        frb = new FreezeBlock(list, null, null, pro);
        Assert.assertTrue(frb.getFreezableCount() == 2);
        Assert.assertEquals(dec2, frb.getFreezable(1));
        Assert.assertEquals(dec1, frb.getFreezable(0));
    }

    /**
     * Creating a freeze block with a but.
     */
    @Ignore("but expression would need full test against configuration")
    @Test
    public void creatingFBWithBut() {
        but[0] = "Name";
        frb = new FreezeBlock(list, null, null, pro);
        Assert.assertTrue(frb.getFreezableCount() == 2);
        Assert.assertEquals(dec2, frb.getFreezable(1));
        Assert.assertEquals(dec1, frb.getFreezable(0));
    }
    
}   
