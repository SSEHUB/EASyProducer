package de.uni_hildesheim.sse.varModel.datatypes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * Testcases for attributes.
 * @author lueder
 *
 */
public class AttributeTest {

    private Project pro;
    private DecisionVariableDeclaration dec;
    
    /**
     * Sets up the project + DecV before the test runs.
     */
    @Before
    public void setUp() {
        pro = new Project("Name");
        dec = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
    }
    
    /**
     * First test.
     */
    @Test
    public void test() {
        Attribute att = new Attribute("Attribut1", StringType.TYPE, pro, dec);
        Assert.assertEquals(dec, att.getElement());
    }

}
