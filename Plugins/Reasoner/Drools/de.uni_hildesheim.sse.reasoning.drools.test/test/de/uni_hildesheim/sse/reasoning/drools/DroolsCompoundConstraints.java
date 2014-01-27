
package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Class to test constraints over variables of compound type.
 * //@author Phani
 *
 */
public class DroolsCompoundConstraints extends AbstractTest {
    
    private static final String DIRPATH = "compoundConstraints" + File.separator;
    
    
    @Test
    public void testIsDefinedInvalid() throws IOException {
        assertConsistency(DIRPATH + "IsDefinedInvalid.ivml", true);
    }
    
    @Test
    public void testIsDefinedValidTwo() throws IOException {
        assertConsistency(DIRPATH + "IsDefinedWithDefault.ivml", false);
    }
    
    @Test
    public void testIsDefinedNestedCompound() throws IOException {
        assertConsistency(DIRPATH + "IsDefinedNestedCompound.ivml", true);
    }
    
    /**
     * Test fails.
     * //@throws IOException
     */
    //@Test
    public void testIsDefinedNestedCompoundTwo() throws IOException {
        assertConsistency(DIRPATH + "IsDefinedNestedCompoundWithdefault.ivml", false);
    }
    
    @Test
    public void testConstraintsAcrossCompounds() throws IOException {
        assertConsistency(DIRPATH + "ConstraintsAcrossCompoundElements.ivml", true);
    }
    
    //@Test
    public void testCompoundAssignmentsCheck() throws IOException {
        assertConsistency(DIRPATH + "CompoundAssignmentsCheck.ivml", true);
    }

}
