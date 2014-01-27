package de.uni_hildesheim.sse.reasoning.drools;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;

public class DroolsAdvancedConceptsTest extends AbstractTest {
	
	 private static final String DIRPATH = "advanced" + File.separator;
	 
	 
	 //@Test
	 public void testAttributeAssignment() throws IOException {
		 assertConsistency(DIRPATH + "AssignmentAttributeTest.ivml", true);
	 }
	 
	 //@Test
	 public void testCompoundQuantor() throws IOException {
		 assertConsistency(DIRPATH + "QuantorCompound.ivml", true);
	 }
	 
	 //@Test
	 public void testEvaluateExpressiosn() throws IOException, CSTSemanticException, ConstraintSyntaxException {
		 
		 List<String> constraints = new ArrayList<String>();
		 constraints.add("a > 5");
		 constraints.add("b == 6");
		 int totalUnsatisfiedEvaluationpairs =  assertEvaluation(DIRPATH + "EvaluateExpressions.ivml", constraints, true);
		 if (totalUnsatisfiedEvaluationpairs > 0) {
			 Assert.assertEquals(2, totalUnsatisfiedEvaluationpairs); 
			
		 }
	 }
	 
	 //@Test

     public void testConstraintsOnMeta() throws IOException {
         assertConsistency(DIRPATH + "ConstraintsOnMetaType.ivml", true);
	 }
	 
	 //@Test
     public void testFailingTest() throws IOException {
         assertConsistency(DIRPATH + "FailingTest.ivml", true);
	 }
	 
     //@Test
     public void testConstraintsInCompound() throws IOException {
         assertConsistency(DIRPATH + "ConstraintsInCompound.ivml", true);
     }
	 
     //@Test
     public void testComplexConstraintsInCompound() throws IOException {
         assertConsistency(DIRPATH + "ComplexConstraintsInCompound.ivml", false);
     }
     
	 //@Test
     public void testValuePropInCompound() throws IOException {
         assertConsistency(DIRPATH + "ValuePropInCompounds.ivml", true);
     }
	 
	 
	 //@Test
     public void testElevator() throws IOException {
	     projectCount = 2;
         assertConsistency(DIRPATH + "Elevator.ivml", false);
         projectCount = 0;
     }

}
