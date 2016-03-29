package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;

import net.ssehub.easy.reasonerCore.reasoner.ReasoningResult;

public class DroolsContainerTest extends AbstractTest {

    private static final String DIRPATH = "containerConstraints" + File.separator;
    
    
    //@Test
    public void simpleQuantorExistsTest() throws IOException {
        assertConsistency(DIRPATH + "SimpleQuantorExists.ivml", true);
    }
    
    //@Test
    public void simpleQuantorForAllTest() throws IOException {
        assertConsistency(DIRPATH + "SimpleQuantorForAll.ivml", true);
    }
    
    //@Test
    public void simpleQuantorAtTest() throws IOException {
        assertConsistency(DIRPATH + "SimpleQuantorAt.ivml", true);
    }
    
    //@Test
    public void sequenceFunctions() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "SequenceFunctions.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(6, result.getMessage(0).getConflicts().size());
        }
        
    }
    
    //@Test
    public void sequenceAsSetTest() throws IOException {
        assertConsistency(DIRPATH + "SequenceAsSet.ivml", false);
        
    }
    
    //@Test
    public void complexsequenceFunctions() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "ComplexSequenceFunctions.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(8, result.getMessage(0).getConflicts().size());
        }
        
    }
    
    //@Test
    public void quantorSelectTest() throws IOException {
        assertConsistency(DIRPATH + "QuantorSelect.ivml", true);
        
    }
    
    //@Test
    public void quantorRejectTest() throws IOException {
        assertConsistency(DIRPATH + "QuantorReject.ivml", true);
        
    }
    
    
    //@Test
    public void setQuantorsTest() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "SetQuantors.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(18, result.getMessage(0).getConflicts().size());
        }
        
    }
    
}
