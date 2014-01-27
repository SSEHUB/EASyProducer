package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;

/**
 * Class to test simple constraints over non-nested no compound type variables.
 * @author Phani
 *
 */
public class DroolsSimpleConstraintsTest extends AbstractTest {

    private static final String DIRPATH = "basicTypesConstraints" + File.separator;
    
    @Test
    public void testAssignmentsTwo() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "SimpleImpliesConstraint.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(2, result.getMessage(0).getConflicts().size());
        }
    }
    
    @Test
    public void testEnumsOne() throws IOException {
        assertConsistency(DIRPATH + "EnumsInequalityCheck.ivml", true);
    }
    
    @Test
    public void testEnumsTwo() throws IOException {
        assertConsistency(DIRPATH + "EnumsEqualityCheck.ivml", true);
    }
    
    @Test
    public void testOrderedEnumsOne() throws IOException {
        assertConsistency(DIRPATH + "ConstraintOnOrderedEnum.ivml", true);
    }
    
    @Test
    public void testRegularExpressionsOne() throws IOException {
        assertConsistency(DIRPATH + "RegularExpressions.ivml", true);
    }
    
    @Test
    public void testDerivedTypeOne() throws IOException {
        assertConsistency(DIRPATH + "DerivedTypeOne.ivml", true);
    }
    
    @Test
    public void testDerivedTypeTwo() throws IOException {
        assertConsistency(DIRPATH + "DerivedTypeTwo.ivml", false);
    }
    
    @Test
    public void testArithmeticOne() throws IOException {
        assertConsistency(DIRPATH + "ArithmeticOne.ivml", true);
    }
    
    @Test
    public void testArithmeticTwo() throws IOException {
        assertConsistency(DIRPATH + "ArithmeticTwo.ivml", true);
    }
    
    //FIXME @Roman please fix this in drools
    @Ignore("2 modeled operations are currently not supported by Drools")
    @Test
    public void testStringConstraints() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "StringConstraints.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(4, result.getMessage(0).getConflicts().size());
        }
    }
    
    @Test
    public void testComplexArithmetic() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "ComplexArithmeticConstraints.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(3, result.getMessage(0).getConflicts().size());
        }
    }
    
    
    @Test
    public void testIntegerOperations() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "IntegerOperations.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(4, result.getMessage(0).getConflicts().size());
        }
    }
    
    
    @Test
    public void testRealOperations() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "RealOperations.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(10, result.getMessage(0).getConflicts().size());
        }
    }
    
    @Test
    public void testBooleanOperations() throws IOException {
        ReasoningResult result = assertConsistency(DIRPATH + "BooleanOperations.ivml", true);
        if (result.hasConflict()) {
            Assert.assertEquals(3, result.getMessage(0).getConflicts().size());
        }
    }
    
}
