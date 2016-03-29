package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * Class to test attributes.
 * @author Phani
 *
 */
public class DroolsAttributesTest extends AbstractTest {
    
    private static final String DIRPATH = "attributes" + File.separator;
    
    //@Test
    public void testBasicAttributesWithConstraint() throws IOException {
        
        assertConsistency(DIRPATH + "BasicAttributesWithConstraint.ivml", true);
    }
    
    
    //@Test
    public void testCompoundAttributes() throws IOException {
        
        ReasoningResult result = assertConsistency(DIRPATH + "CompoundAttributes.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(2, result.getMessage(0).getConflicts().size());
        }
//        propagate(DIRPATH + "CompoundAttributes.ivml");
    }
    
    @Test
    public void testGeneralAttributeAssignment() throws IOException {
        
        assertConsistency(DIRPATH + "GeneralAssignmentAttribute.ivml", false);
    }
    
    
}
