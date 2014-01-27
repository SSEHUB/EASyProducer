package de.uni_hildesheim.sse.varModel.datatypes;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;

/**
 * Testfile for the Reference-class.
 * @author beck
 *
 */
public class ReferenceTest {

    /**
     * Test creates a Reference and tests the reference-methods but the accept-method.
     */
    @Test
    public void createReferenceTest() {
        //create a reference to the compound cp1
        String cp1Name = "cp1";
        String refName = "refToCp1";
        Compound cp1 = new Compound(cp1Name, null);        
        Reference refToCompound = new Reference(refName, cp1, null);
        
        Assert.assertEquals(cp1, refToCompound.getType());
    }

}
