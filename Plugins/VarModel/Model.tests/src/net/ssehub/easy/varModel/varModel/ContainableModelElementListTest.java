package net.ssehub.easy.varModel.varModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.ContainableModelElementList;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.StringType;

/**
 * Test cases for the containable model element list.
 * @author lueder
 *
 */
public class ContainableModelElementListTest {

    private Project pro;
    private ContainableModelElementList list;
    private DecisionVariableDeclaration dec1;
    private DecisionVariableDeclaration dec2;
    
    /**
     * Sets up the project before the test runs.
     */
    @Before
    public void setUp() {
        pro = new Project("Name");
        dec1 = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
        dec2 = new DecisionVariableDeclaration("Name2", StringType.TYPE, pro);
    }

    /**
     * Creating an empty list.
     */
    @Test
    public void creatingEmptyCMEList() {
        list = new ContainableModelElementList(null);
        Assert.assertTrue(list.getElementCount() == 0);
    }
    
    /**
     * Creating a filled list.
     */
    @Test
    public void creatingFilledCMEList() {
        list = new ContainableModelElementList(2, null);
        Assert.assertTrue(list.getElementCount() == 0);
        
        Assert.assertTrue(list.add(dec1));
        Assert.assertTrue(list.getElementCount() == 1);
        
        list.add(1, dec2);
        Assert.assertTrue(list.getElementCount() == 2);
        
        Assert.assertEquals(dec1, list.get(0));
        Assert.assertEquals(dec2, list.get(1));
    }

}
