package de.uni_hildesheim.sse.varModel;



import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * Test class for the message class. (To get 100% test coverage) 
 * @author deagleD
 *
 */
public class VersionTest {

    /**
     * Tests the NumberFormatException.
     */
    @Test
    public void numberFormatExc() {
        try {
            @SuppressWarnings("unused")
            Version ver = new Version("a");
            Assert.fail();
        } catch (VersionFormatException e) {
            Assert.assertEquals("a" + "is not valid", e.getMessage());
        }
    }
    
    /**
     * Tests whether creating a "null" version succeeds.
     * @throws VersionFormatException 
     */
    @Test
    public void nullVersion() throws VersionFormatException {
        String s = null;
        Version ver = new Version(s);
        
        Assert.assertEquals(0, ver.getSegment(0));
    }
}
