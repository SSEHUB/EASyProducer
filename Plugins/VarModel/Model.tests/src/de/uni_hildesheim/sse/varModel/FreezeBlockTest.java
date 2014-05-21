package de.uni_hildesheim.sse.varModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

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
        frb = new FreezeBlock(list, null, pro);
        Assert.assertTrue(frb.getFreezableCount() == 2);
        Assert.assertEquals(dec2, frb.getFreezable(1));
        Assert.assertEquals(dec1, frb.getFreezable(0));
        Assert.assertEquals(0, frb.getButCount());
        Assert.assertTrue(frb.getFrozenCount() == 2);
        Assert.assertEquals(dec1, frb.getFrozen(0));
    }

    /**
     * Creating a freeze block with a but.
     */
    @Test
    public void creatingFBWithBut() {
        but[0] = "Name";
        frb = new FreezeBlock(list, but, pro);
        Assert.assertTrue(frb.getFreezableCount() == 2);
        Assert.assertEquals(dec2, frb.getFreezable(1));
        Assert.assertEquals(dec1, frb.getFreezable(0));
        Assert.assertEquals(1, frb.getButCount());
        Assert.assertTrue(frb.getFrozenCount() == 1);
        Assert.assertEquals(dec2, frb.getFrozen(0));
        Assert.assertEquals(but[0], frb.getBut(0));
    }
    
    /**
     * Tests the but wildcard.
     */
    @Test
    public void wildcardBut() {
        but[0] = "Na*";
        frb = new FreezeBlock(list, but, pro);
        Assert.assertEquals(1, frb.getButCount());
        Assert.assertTrue(frb.getFrozenCount() == 0);
        Assert.assertEquals(but[0], frb.getBut(0));
    }
}   
