package net.ssehub.easy.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.drools.DroolsReasoner;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

public class DroolsEngineTest {
    
    private static DroolsReasoner engine;
    private static final String BASICFILESPATH = "Files" + File.separator 
            + "Basic" + File.separator; 
    private static final String CHALLENGESFILEPATH = "Files" 
            + File.separator + "Challenges" + File.separator;
    private static final String ASSIGNMENTSFILEPATH = "Files" 
            + File.separator + "Assignments" + File.separator; 
    private int projectNumber = 0;
    private static final String CONFIDENTIAL = File.separator
            + "Files" + File.separator + "Confidential" + File.separator; 

    /**
     * Before statements to get more usability for proper test cases.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
    }
    
    
    
    /**
     * Load an IVML File to the test project.
     * @param path of the ivml file we want to use to.
     * @projectNumber Parent project number, 0 in case there is no project import.
     * @return the project with the configuration
     * @throws IOException
     *             if an error occurred due reading the ivml file
     */
    private Project loadProject(String path) throws IOException {
//        File file = new File(System.getProperty("user.dir") + path);
        File file = new File(path);
        String externalLocation = System.getProperty("Drools.testdata.dir");
        if (null == externalLocation) {
            file = new File(path);
        } else {
            file = new File(externalLocation);
        }
        System.err.println("PROJECT NAME " + path);
        long in = System.currentTimeMillis();

        try {
            VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE,
                    ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }
        // Parse IVML File
        TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
        long out = System.currentTimeMillis();
        System.out.println("Time to parse is " + (out - in) / 1000.0);
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("error: " + result.getMessage(i).getDescription());
        }
        System.out.println("End parsing project");
        
        System.out.println("P " + result.getResultsList().size());
        // Load project
        Project p = result.getResult(projectNumber);
        //Return Project. 
        return p;
    }
    
    
    @Test
    public void stringExpressions() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
        String a = "Phani\"";
        String b = a;
        System.out.println(a + " and b " + b);
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "StringExpressions.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
    }
    
    @Test
    public void RegularExpressiontest() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
        
        
        
        projectNumber = 0;
        Project project = loadProject( BASICFILESPATH + "Regular_Expressions.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
   
    }
    
    @Test
    public void ContainerConstraint() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
    
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "ContainerConstraints.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
   
    }
//    
//    @Test
    public void testValueProp() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
    
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "ValueProp.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
   
    }
    
    
    @Test
    public void isDefined() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        
      
        projectNumber = 0;
        Project project = loadProject( BASICFILESPATH + "IsDefined.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        Assert.assertTrue(!result.hasConflict());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
     
    }
    
    
    @Test
    public void testIfThenElse() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "ifthenelse.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
   }
    
  
    
    @Test
    public void containerSum() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( BASICFILESPATH + "SimpleContainer.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
   }
    
    @Test
    public void testAssignments1() throws IOException, ConfigurationException, 
        ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "TestAssgn_1.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }

    @Test
    public void compoundBlock() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "compoundBlock.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
//    @Test
    public void testAttributesErros() throws IOException,
        ConfigurationException, ValueDoesNotMatchTypeException {
        Project project = loadProject( CHALLENGESFILEPATH + "PhaniNullPOinter.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
    }
    
    @Test
    public void assignmentAttribute() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        String $var = "phani";
        System.out.println("$var is " + $var);
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "AssignmentAttributes.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
    
//    @Test
    public void SimpleAttributesTest() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        String $var = "phani";
        System.out.println("$var is " + $var);
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "" + "AttributesTest.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
    
    @Test
    public void simpleAssignments() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "SimpleAssignments.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }
    
    @Test
    public void assignmentOne() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "Example1.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }
    
    
//    @Test
    public void assignmentTwo() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "Example2.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
//    @Test
    public void assignmentThree() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "Example3.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
//    @Test
    public void assignmentFour() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "Example4.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
//    @Test
    public void assignmentFive() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "Example5.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }
    
    
//    @Test
    public void failingCase() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "FailingCase.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }
    
    @Test
    public void compoundAssignments() throws IOException, 
    ConfigurationException, ValueDoesNotMatchTypeException {
        projectNumber = 0;
        Project project = loadProject( ASSIGNMENTSFILEPATH + "CompoundAssignments.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
       
    }
    
    @ Test
    public void valueReAssignments() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "PL_ReAssign.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
  @Test
  public void testYmsPlatform() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
     Project project = loadProject( CHALLENGESFILEPATH + "testYmsPlatform.ivml");
     Configuration config = new Configuration(project);
     engine = new DroolsReasoner();
     ReasoningResult result = engine.propagate(project, config, null, null);
     System.out.println("result is " + result.getMessageCount());
     Assert.assertTrue(result.hasConflict());
     for (int i = 0; i < result.getMessageCount(); i++) {
         System.out.println("Result -> " + result.getMessage(i).getDescription());
     }
     
  }
    

    
    @Test
    public void testNestedComps() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
       
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "NestedComp.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
//    @Test
    public void testContainerCalls() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
//        Project project = loadProject( CHALLENGESFILEPATH + "testContainerCalls.ivml");
        Project project = loadProject( CHALLENGESFILEPATH + "HEGO.ivml");
//        Project project = loadProject( CHALLENGESFILEPATH + "sequenceTest.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
       
    }
    
    
    @Test
    public void testAssignments() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
        
        
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "assignments.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(result.hasConflict());
        
        
    }
    
    
//    @Test
    public void testCompoundAccessAssignments() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "CompoundAccessAssignments.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
        
        
    }
    
//    @Test
    public void dataDictionaryTest() throws IOException, ConfigurationException, 
    ValueDoesNotMatchTypeException {
        
        
        
        projectNumber = 3;
        Project project = loadProject( CONFIDENTIAL + "Constraints.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("Result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
        Assert.assertTrue(!result.hasConflict());
   
    }
    
    
//    @Test
    public void testProjectImports() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
       
        projectNumber = 2;
        Project project = loadProject( CHALLENGESFILEPATH + "ProjectImportsTest.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        Assert.assertTrue(!result.hasConflict());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
       
    } 
    
//    @Test
    public void testErrorProducer() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        projectNumber = 0;
        Project project = loadProject( CHALLENGESFILEPATH + "AssignableTypeErrorProducer.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        Assert.assertTrue(!result.hasConflict());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
       
    } 
    
    
//  @Test
    public void testNewApproach() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        Project project = loadProject( CHALLENGESFILEPATH + "NewApproach.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        //Value updation.
        Assert.assertTrue(!result.hasConflict());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
     
    }
  
//  @Test
      public void testStas() throws IOException {
          String path = "/Users/Phani/Documents/Uni-Work/Reasoning_Stats/ModelsL/Simple/50000V/";
          
          Project project = loadProject(path + "IVML_gen0" + ".ivml");
          Configuration conf = new Configuration(project);
          engine = new DroolsReasoner();
          ReasoningResult result = engine.check(project, conf, null, null);
          System.out.println("......." + result.getMessageCount() + "...............");
      }
    

    
//    @Test
    public void testYmsPlatform2() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        
        Project project = loadProject( CHALLENGESFILEPATH + "PL_YMS_platform_0.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Result -> " + result.getMessage(i).getDescription());
        }
       
        Assert.assertTrue(result.hasConflict());
    }
    
//    @Test
    public void testOrderedEnum() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        Project project = loadProject( CHALLENGESFILEPATH + "updateOrderedEnum.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        Assert.assertTrue(result.hasConflict());
       
    }
    
    

//    @Test
    public void test() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
        Project project = loadProject( BASICFILESPATH + "complex.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        System.out.println("result is " + result.getMessageCount());
        Assert.assertTrue(!result.hasConflict());
        
        
    }
    
    /*

  @Test
   public void testStringOperations() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
       Project project = loadProject( BASICFILESPATH + "defTest.ivml");
       Configuration config = new Configuration(project);
       engine = new DroolsReasoner();
       ReasoningResult result = engine.check(project, config, null, null);
       System.out.println("result is " + result.getMessageCount());
       Assert.assertTrue(result.hasConflict());
      
   }
   
   */
  
  /*
   * File missing somehow ... 
   */
//   @Test
  public void testBasicIvml() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
      Project project = loadProject( CHALLENGESFILEPATH + "testDef.ivml");
      Configuration config = new Configuration(project);
      engine = new DroolsReasoner();
      ReasoningResult result = engine.propagate(project, config, null, null);
      System.out.println("result is " + result.getMessageCount());
      Assert.assertTrue(result.hasConflict());
      
  }
   
   
   
//   @Test
   public void testDefaults() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
       Project project = loadProject( BASICFILESPATH + "complex.ivml");
       Configuration config = new Configuration(project);
       engine = new DroolsReasoner();
       ReasoningResult result = engine.propagate(project, config, null, null);
       Assert.assertTrue(!result.hasConflict());
       System.out.println("result is " + result.getMessageCount());
       
   }
  
//  @Test
  public void testSAP1() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException {
      Project project = loadProject(CHALLENGESFILEPATH + "isD.ivml");
//      Project project = loadProject(CHALLENGESFILEPATH + "testInfra.ivml");
      Configuration config = new Configuration(project);
      engine = new DroolsReasoner();
      ReasoningResult result = engine.propagate(project, config, null, null);
      System.out.println("result is " + result.getMessageCount());
      for (int i = 0; i < result.getMessageCount(); i++) {
          System.out.println(result.getMessage(i).getDescription());
      }
      Assert.assertTrue(result.hasConflict());
      
  }
    
//    @Test
    public void testContainer() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( CHALLENGESFILEPATH + "PL_car_0.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.propagate(project, config, null, null);
        Assert.assertTrue(result.hasConflict());
        
    }
    
    
//    @Test
    public void testEqs() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( CHALLENGESFILEPATH + "testEqs.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        if (!result.hasConflict()) {
         ReasoningResult result2 = engine.propagate(project, config, null, null);
         System.out.println("result2 -> " + result2.getMessageCount());
        }
        Assert.assertTrue(result.hasConflict());
    }    
    
    
//    @Test
    public void testNonNested() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( CHALLENGESFILEPATH + "TestNonNested.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        Assert.assertTrue(!result.hasConflict());
        
    }
    
//    @Test
    public void testEnums1() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( BASICFILESPATH + "en.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        Assert.assertTrue(result.hasConflict());
        
    }
    
    /*
    */
    
    /*
     * Test division operators across integer and real.
     */
//    @Test
    public void testIntRealDiv() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( BASICFILESPATH + "testDiv.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, config, null, null);
        if (result.hasConflict()) {
            
        }
        Assert.assertTrue(!result.hasConflict());
    }
    
    
    
    
//    @Test
    public void testEvaluation() throws IOException, ConfigurationException, ValueDoesNotMatchTypeException, 
    CSTSemanticException, ConstraintSyntaxException {
        Project project = loadProject( BASICFILESPATH + "complex.ivml");
        Configuration config = new Configuration(project);
        engine = new DroolsReasoner();
//        List<Constraint> constraints = new ArrayList<Constraint>();
//        Constraint cons1 = ModelUtility.createConstraint("maxi > 5", project, false);
//        Constraint cons2 = ModelUtility.createConstraint("maxi = 6", project, false);
//        constraints.add(cons1);
//        constraints.add(cons2);
//        EvaluationResult result1 = engine.evaluate(project, config, constraints, null, null);
//        Assert.assertFalse(0 == result1.getEvaluationPairCount());
        ReasoningResult result2 = engine.propagate(project, config, null, null);
        Assert.assertTrue(!result2.hasConflict());
        
    }
    
    /* 
    
    
//    @Test
    public void testFourthProject() throws ValueDoesNotMatchTypeException,
    CSTSemanticException, ConfigurationException, IOException {
        Project project = new Project("testProjectFour");
        Compound compoundOne = new Compound("compoundOne", project);
        
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, project);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128"); 
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        
        Constraint cons = new Constraint(constraint, null); 
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);
        
        DecisionVariableDeclaration intDecVarOne;
        intDecVarOne = new DecisionVariableDeclaration("x", bitrate, compoundOne);
        compoundOne.add(intDecVarOne);
        project.add(compoundOne);
        
        DecisionVariableDeclaration intDecVarTwo;
        intDecVarTwo = new DecisionVariableDeclaration("y", bitrate, project);
        project.add(intDecVarTwo);
        
        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(compoundOne, "x", "64");
        Value intValue = ValueFactory.createValue(bitrate, "256");
        DecisionVariableDeclaration compoundVar = new DecisionVariableDeclaration("compoundVar", compoundOne, project);
        project.add(compoundVar);
        
        Configuration conf = new Configuration(project);
        
        conf.getDecision(compoundVar).setValue(cValue, null);
        conf.getDecision(intDecVarTwo).setValue(intValue, null);
        
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, conf, null, null);
        System.out.println("......." + result.getMessageCount() + "...............");
        
        
    }

      
    
//    @Test
    public void testCompsAndSeq() throws IOException {
        Project project = loadProject( BASICFILESPATH + "CompsAndSeq.ivml");
        Configuration conf = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, conf, null, null);
        System.out.println("......." + result.getMessageCount() + "...............");
        Assert.assertTrue(result.hasConflict());
        
    }
    
//    @Test
    public void testLoop() throws IOException {
        Project project = loadProject( BASICFILESPATH + "Loop.ivml");
        Configuration conf = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, conf, null, null);
        System.out.println("......." + result.getMessageCount() + "...............");
        Assert.assertTrue(result.hasConflict());
        
    }
    
//    @Test
    public void testcomplex() throws IOException {
        Project project = loadProject( BASICFILESPATH + "test1.ivml");
        Configuration conf = new Configuration(project);
        engine = new DroolsReasoner();
        ReasoningResult result = engine.check(project, conf, null, null);
        System.out.println("......." + result.getMessageCount() + "...............");
        Assert.assertTrue(result.hasConflict());
        
    }
    
    
    
    /**
     * Method to test container operation calls.
    * @throws ValueDoesNotMatchTypeException Should not occur if the values 
     * are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws JessException Should not occur if the Jess output is 
     * correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.
     * @throws ConfigurationException Should not occur ifthe config. is right.
     */
//    @Test
    public void testContainerOperationCalls() throws ValueDoesNotMatchTypeException,
    CSTSemanticException, IOException, ConfigurationException {
        Project project = new Project("OperationCall");
        IDatatype setType = new Set("setOf(Integer)", IntegerType.TYPE, project);
        
        DecisionVariableDeclaration sVar = new DecisionVariableDeclaration("set_se", setType, project);
        project.add(sVar);
        Variable sVarCst = new Variable(sVar);
        ConstantValue constCst10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "10"));
        DecisionVariableDeclaration tVar = new DecisionVariableDeclaration("t", IntegerType.TYPE, null);
        Variable tVarCst = new Variable(tVar);
        OCLFeatureCall greater = new OCLFeatureCall(tVarCst, ">", constCst10);
        ContainerOperationCall opCall = new ContainerOperationCall(sVarCst, "forAll", greater, tVar);
        Constraint cons = new Constraint(opCall, null);
        tVar.setParent(cons);
        project.add(cons);
        
        
        ContainerOperationCall opCall1 = new ContainerOperationCall(sVarCst, OclKeyWords.EXISTS, greater, tVar);
        Constraint cons2 = new Constraint(opCall1, null);
        project.add(cons2);
        
        OCLFeatureCall lesser = new OCLFeatureCall(tVarCst, "<", constCst10);
        ContainerOperationCall opCallLess = new ContainerOperationCall(sVarCst, "exists", lesser, tVar);
        Constraint consLess = new Constraint(opCallLess, null);
        tVar.setParent(consLess);
        project.add(consLess);
        
        ContainerOperationCall opCallSelect = new ContainerOperationCall(sVarCst, OclKeyWords.SELECT, lesser, tVar);
        OCLFeatureCall ln = new OCLFeatureCall(opCallSelect, OclKeyWords.EQUALS, sVarCst);
        Constraint consSelect = new Constraint(ln, null);
        tVar.setParent(consSelect);
        project.add(consSelect);
        
        ContainerOperationCall opAny = new ContainerOperationCall(sVarCst, OclKeyWords.ANY, lesser, tVar);
        OCLFeatureCall ln2 = new OCLFeatureCall(opAny, OclKeyWords.EQUALS, sVarCst);
        Constraint consAny = new Constraint(ln2, null);
        tVar.setParent(consAny);
        project.add(consAny);
        
        
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE, project);
        
        project.add(intDecVar);
        
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5")); 
        Variable var1 = new Variable(intDecVar);
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, IntegerType.GREATER_INTEGER_INTEGER.getName(), cV); 
        Constraint cons1 = new Constraint(ocl1, null);
        project.add(cons1);
        
        Object[] values1 = {"2", "3", "12", "9", "15"};
        ContainerValue value = (ContainerValue) ValueFactory.createValue(setType, values1);
        Configuration conf = new Configuration(project);
        conf.getDecision(sVar).setValue(value, null);
        
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");
    }
    
    

    /**
     * Private Method for testSimpleProject IVML test case - x > 5 .<br/>
     * Jess engine should return <b>False></b> as x is configured 2.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values 
     * are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is 
     * correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found. 
     */
//    @Test
    public void testSimpleProject() throws ValueDoesNotMatchTypeException, 
    ConfigurationException, CSTSemanticException, IOException {

        
        Project project = new Project("testProjectOne");
        
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE, project);
        
        project.add(intDecVar);
        
        Variable var1 = new Variable(intDecVar);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5")); 
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, IntegerType.GREATER_INTEGER_INTEGER.getName(), cV); 
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);
        
        Value val1 = ValueFactory.createValue(IntegerType.TYPE, "2");
        
        
        Configuration conf = new Configuration(project);
        conf.getDecision(intDecVar).setValue(val1, null);

        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
        
        
    }
    
    /**
     * Second test containing a compound with an int and a constraint place on int.
     * Jess engine should return <b>False></b>.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values 
     * are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is 
     * correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found. 
     */
//    @Test
    public void testSecondProject() throws ValueDoesNotMatchTypeException,
    CSTSemanticException, ConfigurationException, IOException {

        Project project = new Project("testProjectTwo"); 
        
        Compound compoundOne = new Compound("CompoundOne", project); 
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE, compoundOne);
        compoundOne.add(intDecVar);
        project.add(compoundOne);
        
        Variable var1 = new Variable(intDecVar);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5")); 
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, IntegerType.GREATER_INTEGER_INTEGER.getName(), cV); 
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);
        
        
        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(compoundOne, "x", "3");
        DecisionVariableDeclaration compDecvar = new DecisionVariableDeclaration("compoundVar", compoundOne, project);
        project.add(compDecvar);
        Configuration conf = new Configuration(project);
        conf.getDecision(compDecvar).setValue(cValue, null);
        
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
        
    }



    /**
     * Private Method for sequence and constraints in its elements IVML test case.<br/>
     * The IVML Object model consists of two compounds. The first compound consists of two integers, maxX & maxY;
     * while the second compound consists an integer and an element which is a sequenceOf the first compound.
     * The constraint is placed between maxX & maxY (maxX > maxY).
     * 
     * @throws ValueDoesNotMatchTypeException Should not occur if 
     * the values are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is correct 
     * syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found. 
     */
//    @Test
    public void testThirdProject() throws ValueDoesNotMatchTypeException,
    ConfigurationException, IOException, CSTSemanticException { 
         
        Project project = new Project("testProjectThree");
        Compound gassenTyp = new Compound("gassenTyp", project);
        
        DecisionVariableDeclaration maxX = new DecisionVariableDeclaration("maxX", IntegerType.TYPE, gassenTyp);
        DecisionVariableDeclaration maxY = new DecisionVariableDeclaration("maxY", IntegerType.TYPE, gassenTyp);
        DecisionVariableDeclaration c = new DecisionVariableDeclaration("notUsedVar", IntegerType.TYPE, gassenTyp);
        
        gassenTyp.add(maxX);
        gassenTyp.add(maxY);
        gassenTyp.add(c);
        
        project.add(gassenTyp); 
        
        Compound hochRegal = new Compound("hochRegal", project);
        
        project.add(hochRegal);
        
        Container seq = new Sequence("seq", gassenTyp, hochRegal);
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration("seq_var", seq, hochRegal);
        hochRegal.add(seqDec);
        DecisionVariableDeclaration decX = new DecisionVariableDeclaration("x", IntegerType.TYPE, hochRegal);
        hochRegal.add(decX);

        String[] values1 = {"maxX", "5", "maxY", "10"}; 
        String[] values2 = {"maxX", "25", "maxY", "20"};

        Object[] cmpValues = {values1, values2};
        
        CompoundValue hochValue = (CompoundValue) ValueFactory.createValue(hochRegal, "seq_var", cmpValues, "x", "100");
        
        DecisionVariableDeclaration hochVAR = new DecisionVariableDeclaration("hochVAR", hochRegal, project);
        project.add(hochVAR);
        Configuration conf = new Configuration(project);
        conf.getDecision(hochVAR).setValue(hochValue, null);

        Variable var1 = new Variable(maxX);
        Variable var2 = new Variable(maxY);
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, IntegerType.GREATER_EQUALS_INTEGER_INTEGER.getName(), var2); 
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);
        
        Variable var3 = new Variable(seqDec); 
        OCLFeatureCall ocl2 = new OCLFeatureCall(var3, OclKeyWords.NOT_EMPTY);
        Constraint cons1 = new Constraint(ocl2, null);
        
        project.add(cons1);
         
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
    }
    
   
    
    /**
     *Method to test the operation Isempty on seq.
     *
     * 
     * @throws ValueDoesNotMatchTypeException Should not occur 
     * if the values are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     *
     */
//    @Test
    public void testSequenceProject() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Project project = new Project("testSequenceProject");
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration("seq_var", Sequence.TYPE, project);
        Configuration conf = new Configuration(project);
        project.add(seqDec);
        DecisionVariableDeclaration boolA = new DecisionVariableDeclaration("boolA", BooleanType.TYPE, project);
        project.add(boolA);
        Variable var1 = new Variable(seqDec);
        Variable var2 = new Variable(boolA);
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, OclKeyWords.IS_EMPTY);
        OCLFeatureCall ocl2 = new OCLFeatureCall(var2, OclKeyWords.EQUALS, ocl1);
        Constraint cons1 = new Constraint(ocl2, null);
        project.add(cons1);
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertFalse(r.hasConflict());
        System.out.println(" .. has conflict?");
    }
    
    
    
    
    /**
     * Test for checking the constraint x = (y + z) * 2 .
     * 
     * @throws ValueDoesNotMatchTypeException .
     * @throws ValueDoesNotMatchTypeException Should not occur 
     * if the values are configured correctly in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is 
     * correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.  
     */
//    @Test
    public void testComplexConstraintsProject() throws ValueDoesNotMatchTypeException,
    CSTSemanticException,  IOException, ConfigurationException {
        Project project = new Project("testProjectConstraints");
        DecisionVariableDeclaration decVarOne = new DecisionVariableDeclaration("x", IntegerType.TYPE, project);
        DecisionVariableDeclaration decVarTwo = new DecisionVariableDeclaration("y", IntegerType.TYPE, project);
        DecisionVariableDeclaration decVarThree = new DecisionVariableDeclaration("z", IntegerType.TYPE, project);
        //DecisionVariableDeclaration decVarFour = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        
        project.add(decVarOne);
        project.add(decVarTwo);
        project.add(decVarThree);
         
        Variable vX = new Variable(decVarOne);
        Variable vY = new Variable(decVarTwo);  
        Variable vZ = new Variable(decVarThree);
        //Variable vA = new Variable(decVarFour);
        
        OCLFeatureCall ocl1 = new OCLFeatureCall(vY, IntegerType.PLUS_INTEGER_INTEGER.getName(), vZ);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5"));
        OCLFeatureCall ocl2 = new OCLFeatureCall(ocl1, IntegerType.MULT_INTEGER_INTEGER.getName(), cV);
        Parenthesis parenthesis = new Parenthesis(ocl2);
        OCLFeatureCall ocl3 = new OCLFeatureCall(vX, IntegerType.EQUALS_INTEGER_INTEGER.getName(), parenthesis);
        
        Constraint cons = new Constraint(ocl3, null);
        project.add(cons);
        
        Configuration conf = new Configuration(project);
        Value xValue = ValueFactory.createValue(IntegerType.TYPE, "1");
        conf.getDecision(decVarOne).setValue(xValue, null);
        
        Value yValue = ValueFactory.createValue(IntegerType.TYPE, "2"); 
        conf.getDecision(decVarTwo).setValue(yValue, null);
        
        Value zValue = ValueFactory.createValue(IntegerType.TYPE, "3");
        conf.getDecision(decVarThree).setValue(zValue, null);
         
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");
        
        
    }
    
    
    /**
     * Method which includes and tests the use of parenthesis in constraints.
     * Testing - ((a + b) + x) > c
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package  
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly in relation 
     * to the datatype.
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.  
     * 
     */
//    @Test
    public void testParanthesisProject() 
        throws CSTSemanticException, ValueDoesNotMatchTypeException,
            ConfigurationException,  IOException {
        
        Project project = new Project("testParanthesisProject");
        DecisionVariableDeclaration realADecl = 
                new DecisionVariableDeclaration("realA", RealType.TYPE, project);
        DecisionVariableDeclaration realBDecl = 
                new DecisionVariableDeclaration("realB", RealType.TYPE, project);
        DecisionVariableDeclaration realCDecl = 
                new DecisionVariableDeclaration("realC", RealType.TYPE, project);
        DecisionVariableDeclaration realXDecl = 
                new DecisionVariableDeclaration("realX", RealType.TYPE, project);
        
        project.add(realADecl);
        project.add(realBDecl);
        project.add(realCDecl);
        project.add(realXDecl);
        
        //Create constraint variables for building constraints in test methods
        Variable realA = new Variable(realADecl);
        Variable realB = new Variable(realBDecl);
        Variable realC = new Variable(realCDecl); 
        Variable realX = new Variable(realXDecl);
        
        
        OCLFeatureCall nestedCall = new OCLFeatureCall(realA, OclKeyWords.PLUS, realB);
        Parenthesis parenthesis = new Parenthesis(nestedCall);
        OCLFeatureCall nestedCall1 = new OCLFeatureCall(parenthesis, OclKeyWords.PLUS, realX);
        Parenthesis parenthesis1 = new Parenthesis(nestedCall1);
        //Create (realA + realB) < realC
        OCLFeatureCall completeCall = new OCLFeatureCall(parenthesis1, OclKeyWords.EQUALS, realC);
        Constraint cons = new Constraint(completeCall, null);
        project.add(cons); 
        
        
        Value val1 = ValueFactory.createValue(RealType.TYPE, "1.0");
        Value val2 = ValueFactory.createValue(RealType.TYPE, "2.0"); 
        Value val3 = ValueFactory.createValue(RealType.TYPE, "2.0");
        Value val4 = ValueFactory.createValue(RealType.TYPE, "0.0");
        Configuration conf = new Configuration(project);
        
        conf.getDecision(realADecl).setValue(val1, null);
        conf.getDecision(realBDecl).setValue(val2, null);
        conf.getDecision(realCDecl).setValue(val3, null);
        conf.getDecision(realXDecl).setValue(val4, null);
        
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
        
    }
    
    /**
     * complexDtataTypeTest1 method which tests integer operations between two integers. 
     * The following are tested in the method for two integers, intA and intB:
     * 1) intA < intB
     * 2) intA != intB
     * 3) intA < 5
     * 4) (intA + intB) = 7
     * The test should return <b>True</b> for the configuration intA = 2, intB = 5.
     * 
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly in relation 
     * to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found. 
     * 
     */
//    @Test
    public void complexDataTypeTest1() throws 
    CSTSemanticException, ValueDoesNotMatchTypeException, 
    ConfigurationException,  IOException {
        Project project = new Project("ComplexdatatypeTest1");
        DecisionVariableDeclaration integerADecl = 
                new DecisionVariableDeclaration("intlA", IntegerType.TYPE, project);
        DecisionVariableDeclaration integerBDecl = 
                new DecisionVariableDeclaration("intlB", IntegerType.TYPE, project);
        
        project.add(integerADecl);
        project.add(integerBDecl);
        //Create constraint variables for building constraints in test methods
        Variable integerA = new Variable(integerADecl);
        Variable integerB = new Variable(integerBDecl);
        
        OCLFeatureCall ocl1 = new OCLFeatureCall(integerA, OclKeyWords.LESS, integerB);
        
        OCLFeatureCall ocl2 = new 
                OCLFeatureCall(integerA, IntegerType.NOTEQUALS_INTEGER_INTEGER.getName(), integerB);
        
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5"));
        OCLFeatureCall ocl3 = new OCLFeatureCall(integerA, OclKeyWords.LESS, cV);
        
        ConstantValue cV1 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "7"));
        OCLFeatureCall nestedCall = new OCLFeatureCall(integerA, OclKeyWords.PLUS, integerB);
        Parenthesis parenthesis = new Parenthesis(nestedCall);
        OCLFeatureCall ocl4 = new OCLFeatureCall(parenthesis, OclKeyWords.EQUALS, cV1);
        
        Constraint cons1 = new Constraint(ocl1, null);
        project.add(cons1);  
        
        Constraint cons2 = new Constraint(ocl2, null);
        project.add(cons2);
        Constraint cons3 = new Constraint(ocl3, null);
        project.add(cons3);
        Constraint cons4 = new Constraint(ocl4, null);
        project.add(cons4);
        
        Value val1 = ValueFactory.createValue(IntegerType.TYPE, "2");
        Value val2 = ValueFactory.createValue(IntegerType.TYPE, "5");
        Configuration conf = new Configuration(project);
        
        conf.getDecision(integerADecl).setValue(val1, null);
        conf.getDecision(integerBDecl).setValue(val2, null);
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");
        
    }
    
  
    /**
     * complexDtataTypeTest2 method which tests real operations between two reals.
     * The following are tested in the method for two reals, realX and realY:
     * 1) realX != realY
     * 2) realX < 9.1
     * 3) realY > 10.1
     * 4) (realX + realY) < 22.0
     * 5) (realY - realX) > 2.0
     * The test should return <b>True</b> for the configuration realX = 9.0 and realY = 11.5
     * and <b>False</b> for the configuration realX = 9.0 and realY = 10.5
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly in relation 
     * to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found. 
     * 
     */
//    @Test
    public void complexDataTypeTest2() throws 
    CSTSemanticException, ValueDoesNotMatchTypeException, 
    ConfigurationException,  IOException {
        Project project = new Project("ComplexdatatypeTest2");
        
        DecisionVariableDeclaration realYDecl = 
                new DecisionVariableDeclaration("realY", RealType.TYPE, project);
        DecisionVariableDeclaration realXDecl = 
                new DecisionVariableDeclaration("realX", RealType.TYPE, project);
        
        project.add(realYDecl);
        project.add(realXDecl);
        
        //Create constraint variables for building constraints in test methods
        Variable realX = new Variable(realXDecl);
        Variable realY = new Variable(realYDecl); 
               
        OCLFeatureCall ocl5 = new 
                OCLFeatureCall(realX, RealType.NOTEQUALS_REAL_INTEGER.getName(), realY);
        ConstantValue cV3 = new 
                ConstantValue(ValueFactory.createValue(RealType.TYPE, "9.1"));
        OCLFeatureCall ocl6 = new OCLFeatureCall(realX, OclKeyWords.LESS, cV3);
        ConstantValue cV4 = new 
                ConstantValue(ValueFactory.createValue(RealType.TYPE, "10.1"));
        OCLFeatureCall ocl7 = new OCLFeatureCall(realY, OclKeyWords.GREATER, cV4); 
        
        OCLFeatureCall ocl8 = new OCLFeatureCall(realX, OclKeyWords.PLUS, realY);
        Parenthesis parenthesis3 = new Parenthesis(ocl8);
        ConstantValue cV5 = new 
                ConstantValue(ValueFactory.createValue(RealType.TYPE, "22.0"));
        OCLFeatureCall ocl9 = new OCLFeatureCall(parenthesis3, OclKeyWords.LESS, cV5);
        
        OCLFeatureCall ocl10 = new 
                OCLFeatureCall(realY, RealType.MINUS_REAL_REAL.getName(), realX);
        Parenthesis parenthesis4 = new Parenthesis(ocl10);
        ConstantValue cV6 = new ConstantValue(ValueFactory.createValue(RealType.TYPE, "2.0"));
        OCLFeatureCall ocl11 = new OCLFeatureCall(parenthesis4, OclKeyWords.GREATER, cV6);
        
        Constraint cons5 = new Constraint(ocl5, null);
        project.add(cons5);
        Constraint cons6 = new Constraint(ocl6, null);
        project.add(cons6);
        Constraint cons7 = new Constraint(ocl7, null);
        project.add(cons7);
        Constraint cons8 = new Constraint(ocl9, null);
        project.add(cons8);
        Constraint cons9 = new Constraint(ocl11, null);
        project.add(cons9);
        
        Configuration conf = new Configuration(project);
        
        Value val3 = ValueFactory.createValue(RealType.TYPE, "9.0");
        Value val4 = ValueFactory.createValue(RealType.TYPE, "11.5");

        conf.getDecision(realXDecl).setValue(val3, null);
        conf.getDecision(realYDecl).setValue(val4, null);
        
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertFalse(r.hasConflict());
        System.out.println("......................");
        
    }
    
    /**
     * Method to test project imports. 
     * This is a simple test with a project import without any restriction. Since there are not any 
     * import restrictions, the original project will have have everything present 
     * on the project being imported.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly 
     * in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws ConfigurationException Should not occur if the values are configured rightly.
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.
     * @throws ModelQueryException Should not throw Model Query exception emerging from 
     * faulty project imports.
     */
//    @Test
    public void projectImportTest() throws ValueDoesNotMatchTypeException,
    CSTSemanticException,  IOException, ConfigurationException, 
    ModelManagementException {
        
        Project importedPro = new Project("ProjectBeingImported");
        DecisionVariableDeclaration realYDecl = 
                new DecisionVariableDeclaration("realY", RealType.TYPE, importedPro);
        DecisionVariableDeclaration realXDecl = 
                new DecisionVariableDeclaration("realX", RealType.TYPE, importedPro);
        
        importedPro.add(realYDecl);
        importedPro.add(realXDecl);
        
        Variable realX = new Variable(realXDecl);
        ConstantValue cV3 = new 
                ConstantValue(ValueFactory.createValue(RealType.TYPE, "9.1"));
        OCLFeatureCall ocl6 = new OCLFeatureCall(realX, OclKeyWords.GREATER, cV3);
        Constraint cons6 = new Constraint(ocl6, null);
        importedPro.add(cons6);
        
        ProjectImport proImport = new ProjectImport("projectBeingImported", "NoReference");
        proImport.setResolved(importedPro);  
        
        Project project = new Project("ActualProjectWhichImports"); 
        project.addImport(proImport);  
         
         
        Compound compoundOne = new Compound("CompoundOne", project);
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE, compoundOne);
        compoundOne.add(intDecVar);
        project.add(compoundOne); 
         
        Variable var1 = new Variable(intDecVar); 
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5")); 
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, IntegerType.GREATER_INTEGER_INTEGER.getName(), cV); 
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);
        
        project.add(realXDecl);
        
        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(compoundOne, "x", "3");
        DecisionVariableDeclaration compDecvar = new DecisionVariableDeclaration("compoundVar", compoundOne, project);
        project.add(compDecvar);
        Configuration conf = new Configuration(project);
        conf.getDecision(compDecvar).setValue(cValue, null);
        Value val3 = ValueFactory.createValue(RealType.TYPE, "9.0");
        conf.getDecision(realXDecl).setValue(val3, null);
        
        
        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
        
    }
    
    /**
     * Method which tests equalities - and also equalities in a call involving implies. Two types are tested
     * Consider reals realX and realY
     * 1) realX = realY - which is an assignment.
     * 2) real > 9.1 implies realY = realY. The RHS is an assignment when LHS is evaluated to <b>True</b>.
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly 
     * in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.
     * faulty project imports. 
     * 
     */

//    @Test
    public void projectEqualities() throws ValueDoesNotMatchTypeException,
    CSTSemanticException,  IOException {

        Project project = new Project("ProjectEqualities");
        DecisionVariableDeclaration realYDecl = 
                new DecisionVariableDeclaration("realY", RealType.TYPE, project); 
        DecisionVariableDeclaration realXDecl = 
                new DecisionVariableDeclaration("realX", RealType.TYPE, project);
        project.add(realYDecl);
        project.add(realXDecl);
        //Create constraint variables for building constraints in test methods

        Variable realX = new Variable(realXDecl);
        Variable realY = new Variable(realYDecl); 
        OCLFeatureCall ocl1 = new 
                OCLFeatureCall(realX, OclKeyWords.EQUALS, realY);

        ConstantValue cV3 = new 
                ConstantValue(ValueFactory.createValue(RealType.TYPE, "9.1"));

        OCLFeatureCall ocl2 = new OCLFeatureCall(realX, OclKeyWords.EQUALS, cV3);
        OCLFeatureCall ocl3 = new OCLFeatureCall(realY, OclKeyWords.EQUALS, realX);
        OCLFeatureCall ocl4 = new OCLFeatureCall(ocl2, OclKeyWords.IMPLIES, ocl3);

        Constraint cons1 = new Constraint(ocl1, null);
        project.add(cons1);
        Constraint con2 = new Constraint(ocl4, null);
        project.add(con2);
        Configuration conf = new Configuration(project);

        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................" + r.getMessageCount());
    }
    
    /**
     * Method to test implies.
     *
     * @throws ValueDoesNotMatchTypeException Should not occur if the values are configured correctly 
     * in relation to the datatype.
     * @throws CSTSemanticException Must not occur, otherwise 
     * there is an error inside the CST package
     * @throws JessException Should not occur if the Jess output is correct syntactically and semantically..
     * @throws IOException Should not occur if the Jess file is found.
     * faulty project imports. 
     * @throws ConfigurationException Should not occur if there is no configuration error.
     */ 
//    @Test
    public void testSimpleImplies() throws CSTSemanticException,
     IOException, ValueDoesNotMatchTypeException, ConfigurationException {
        
        Project project = new Project("testSimpleImplies");
        DecisionVariableDeclaration boolA = new DecisionVariableDeclaration("boolA", BooleanType.TYPE, project);
        DecisionVariableDeclaration boolB = new DecisionVariableDeclaration("boolB", BooleanType.TYPE, project);
        project.add(boolA); project.add(boolB);
        DecisionVariableDeclaration boolC = new DecisionVariableDeclaration("boolC", BooleanType.TYPE, project);
        project.add(boolC);
        Variable varA = new Variable(boolA);
        Variable varB = new Variable(boolB);
        Variable varC = new Variable(boolC);
        OCLFeatureCall ocl1 = new OCLFeatureCall(varA, OclKeyWords.IMPLIES, varB);
        Parenthesis parenthesis = new Parenthesis(ocl1);
        OCLFeatureCall ocl2 = new OCLFeatureCall(varC, OclKeyWords.IMPLIES, parenthesis);
        
        Constraint cons1 = new Constraint(ocl2, null);
        project.add(cons1);
         
        Configuration conf = new Configuration(project);
        Value boolVal1 = ValueFactory.createValue(boolA.getType(), "true");
        Value boolVal2 = ValueFactory.createValue(boolB.getType(), "false");
        
        conf.getDecision(boolA).setValue(boolVal1, null);
        conf.getDecision(boolB).setValue(boolVal2, null);
        conf.getDecision(boolC).setValue(boolVal2, null);

        engine = new DroolsReasoner();
        ReasoningResult r = engine.check(project, conf, null, null);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");

    }
    
//  @Test
  public void testConfigs() throws IOException {
      Project project = loadProject( BASICFILESPATH + "compounds.ivml");
      Configuration conf = new Configuration(project);
      engine = new DroolsReasoner();
      ReasoningResult result = engine.check(project, conf, null, null);
      System.out.println("......." + result.getMessageCount() + "...............");
      Assert.assertTrue(!result.hasConflict());
      
  }
    
    
    

}
