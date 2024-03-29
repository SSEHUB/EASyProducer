package net.ssehub.easy.varModel.varModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.IPartialEvaluable;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;

/**
 * Testcases for the partial evaluation block.
 * @author lueder
 *
 */
public class PartialEvaluationBlockTest {

    private Project pro;
    private PartialEvaluationBlock peb;
    private IPartialEvaluable[] elements;
    
    /**
    * Sets up the project before the test runs.
    */
    @Before
    public void setUp() {
        pro = new Project("Name");
        elements = new IPartialEvaluable[2];
    }
   
    /**
     * First test.
     */
    @Test
    public void createPartialEvBlock() {
        peb = new PartialEvaluationBlock("Block", pro);
        Assert.assertTrue(peb.isEmpty());
        Assert.assertEquals(0, peb.getEvaluableCount());
        
        peb.setEvaluables(elements);
        Assert.assertEquals(elements[0], peb.getEvaluable(0));
        Assert.assertTrue(!peb.isEmpty());
    }

}
