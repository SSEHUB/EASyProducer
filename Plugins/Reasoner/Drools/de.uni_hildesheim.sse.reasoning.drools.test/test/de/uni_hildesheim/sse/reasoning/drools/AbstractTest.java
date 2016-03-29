package de.uni_hildesheim.sse.reasoning.drools;

import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult.ConstraintEvaluationResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * Abstract test class for checking the reasoning correctness. 
 * @author Phani
 *
 */
public abstract class AbstractTest {
    
    public static final File TESTDATA_DIR = determineTestDataDir();
    private static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    public int projectCount = 0;
    
    private DroolsReasoner engine = null;
    
    /**
     * Determines the exact location of the file.
     * @return The actual directory as a file.
     */
    private static File determineTestDataDir() {
        File result;
        String externalLocation = System.getProperty("Drools.testdata.dir");
//        System.out.println("externam location is  " + externalLocation + File.separator + "testdata");
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
    
    /**
    * Starts up the {@link VarModel} by registering {@link #TESTDATA_DIR} as
    * model directory and registering {@link ModelUtility} as model loader.
    */
   @BeforeClass
   public static void startUp() {
       try {
           ModelUtility.setResourceInitializer(new StandaloneInitializer());
           VarModel.INSTANCE.locations().addLocation(TESTDATA_DIR, OBSERVER);
           VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
       } catch (ModelManagementException e) {
           e.printStackTrace(System.err);
           Assert.assertTrue(false); // shall not happen
       }
   }
   
   
   /**
    * Tears down up the {@link VarModel} by unregistering {@link #TESTDATA_DIR}
    * as model directory and unregistering {@link ModelUtility} as model
    * loader.
    * 
    * @throws ModelManagementException shall not occur
    */
   @AfterClass
   public static void shutDown() throws ModelManagementException {
       VarModel.INSTANCE.locations().removeLocation(TESTDATA_DIR, OBSERVER);
       VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
   }
   
   /**
    * Load an IVML File to the test projekt.
    * 
    * @param path
    *            of the ivml file we want to use to
    * @return the projekt with the configuration
    * @throws IOException
    *             if an error occurred due reading the ivml file
    */
   protected final Project loadProject(String path) throws IOException {
     File file = new File(TESTDATA_DIR.getPath() + File.separator + path);
       try {
           VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
           VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE,
                   ProgressObserver.NO_OBSERVER);
       } catch (ModelManagementException e) {
           System.out.println(e.getMessage());
       }
       
       // Parse IVML File
       de.uni_hildesheim.sse.dslCore.TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
       for (int i = 0; i < result.getMessageCount(); i++) {
           System.out.println("Parsing error -> " + result.getMessage(i).getDescription());
       }

       // Load project
       System.out.println("project count is " + result.getResultCount());
       Project project = result.getResult(projectCount);
       return project;
   }
   
   
   /**
    * Method for checking consistency.
    * @param path Path to the file.
    * @param expectedResult Expected result, <b>True</b> or <b>False</b>.
    * @return Returns the Reasoning result. 
    * @throws IOException Should not occur if the file is found. 
    */
   public ReasoningResult assertConsistency(String path, boolean expectedResult) throws 
       IOException {
       
       Project project = loadProject(path);
       System.out.println("Reasoning " + project.getName());
       Configuration config = new Configuration(project);
       engine = new DroolsReasoner();
       ReasoningResult result = engine.check(project, config, null, OBSERVER);
       Assert.assertEquals(expectedResult, result.hasConflict());
       return result;
       
   }
   
   
   public Configuration propagate(String path) throws IOException {
       Project project = loadProject(path);
       System.out.println("Reasoning " + project.getName());
       Configuration config = new Configuration(project);
       engine = new DroolsReasoner();
       ReasoningResult result = engine.propagate(project, config, null, OBSERVER);
       
       System.out.println("result is " + result.getMessageCount());
       System.out.println("has conflict ? " + result.hasConflict());
       
       return config;
   }
   
   /**
    * Checking changes after value propagation. 
    * @param config Configuration.
    * @param name name of the decision variable.
    * @param value Value (as a string).
    * @param state state of the variable.
    */
   public void checkConfiguration (Configuration config, String name, String value, IAssignmentState state) {
       
       Iterator<IDecisionVariable> itr = config.getConfiguration().iterator();
       while (itr.hasNext()) {
           IDecisionVariable element = itr.next();
           if (element.getDeclaration().getName().equals(name)) {
               System.out.print("name " + name + " ");
               System.out.println("state " + element.getState());
               if (element.getValue() != null) {
                   System.out.println("Value in config is : " + element.getValue());
               }
               Assert.assertEquals(value, element.getValue().getValue().toString());
               Assert.assertEquals(state, element.getState());
           } 
           
       }
       
   }
   
   /**
    * Method for evaluating a set of expressions.
    * @param path Path to the file.
    * @param expectedResult Expected result, <b>True</b> or <b>False</b>.
    * @return Returns total number of unsatisfied evaluation pairs. 
    * @throws IOException Should not occur if the file is found. 
    * @throws ConstraintSyntaxException 
    * @throws CSTSemanticException 
    */
   public int assertEvaluation(String path, List<String> stringConstraints, boolean expectedResult) throws 
   	   IOException, CSTSemanticException, ConstraintSyntaxException {
	   
	   Project project = loadProject(path);
       System.out.println("Reasoning " + project.getName());
       Configuration config = new Configuration(project);
       engine = new DroolsReasoner();
       List<Constraint> constraints = new ArrayList<Constraint>();
       for (String cons: stringConstraints) {
    	   constraints.add(ModelUtility.INSTANCE.createConstraint(cons, project, false));
       }
       
       EvaluationResult result = engine.evaluate(project, config, constraints, null, OBSERVER);
       System.out.println("eval pair count " + result.getEvaluationPairCount());
       int count = result.getEvaluationPairCount();
       int totalUnsatisfiedEvaluationpairs = 0;

       for (int i = 0; i < count; i++) {
    	   if(result.getEvaluationPair(i).getResult().equals(ConstraintEvaluationResult.FALSE)) {
    		   totalUnsatisfiedEvaluationpairs++;
    	   }
       }
       Assert.assertEquals(expectedResult, totalUnsatisfiedEvaluationpairs > 0);
       return totalUnsatisfiedEvaluationpairs;
   }
    
}
