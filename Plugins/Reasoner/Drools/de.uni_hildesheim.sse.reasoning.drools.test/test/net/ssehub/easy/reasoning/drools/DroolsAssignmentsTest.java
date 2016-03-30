package net.ssehub.easy.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DroolsAssignmentsTest extends AbstractTest {
    
    private static final String DIRPATH = "assignments" + File.separator;

    @Test
    public void testAssignmentsOne() throws IOException {
        assertConsistency(DIRPATH + "SequenceAssignmentStatus.ivml", false);
    }
    
    
    @Test
    public void testAssignmentsThree() throws IOException {
        assertConsistency(DIRPATH + "HardConstraintOverFixedStatus.ivml", true);
    }
    
    @Test
    public void testAssignmentsFour() throws IOException {
        assertConsistency(DIRPATH + "HardConstraintOverFixedStatus2.ivml", true);
    }
    
    @Test
    public void testAssignmentsFive() throws IOException {
        assertConsistency(DIRPATH + "DefaultToFixedStatusAssignment.ivml", true);
    }
    
    @Test
    public void testAssignmentsSix() throws IOException {
        assertConsistency(DIRPATH + "DynamicStatusChange.ivml", false);
    }
    
    @Test
    public void testAssignmentsSeven() throws IOException {
        assertConsistency(DIRPATH + "DynamicStatusChangeFail.ivml", true);
    }
    
    @Test
    public void testAssignmentsEight() throws IOException {
        assertConsistency(DIRPATH + "HardConstraintOverFixedStatus3.ivml", true);
    }
    
    @Test
    public void testPartialCompoundAssignment() throws IOException {
        assertConsistency(DIRPATH + "PartialCompoundAssignment.ivml", false);
    }
    
    
}
