package test.de.uni_hildesheim.sse.reasoner.jess;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.importResolver.ReasoningImportResolver;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Class for JessReasoner.<br/>
 * This class contains:
 * <ul>
 * <li>The main method</li>
 * <li>for the instantiation of IVML objects. In essence, these provide several
 * tests to check reasoning process using Jess rules.</li>
 * </ul>
 * 
 * @since 31.05.2012
 * @author Phani
 */
public class JessReasoner {


    protected static final ReasonerFrontend REASONER = ReasonerFrontend.getInstance();

    /**
     * Sets up the tests.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        Utils.init();
    }

    // private static final String FILENAME = "test.ivml";

    /**
     * Main class for testing the IVML test cases.<br/>
     * 
     * @throws IOException a
     * @throws IvmlException b
     */
    @Test
    public void main() throws IOException, IvmlException {

        /*
         * testSecondProject(); testContainerOperationCalls();
         * testSimpleProject(); testThirdProject(); testProjectFive();
         * testEnumMethod(); testParanthesisProject();
         * 
         * //Below ProjectSix testComplexConstraintsProject();
         * 
         * complexDataTypeTest1(); complexDataTypeTest2();
         * 
         * //testing equalities and implies projectEqualities();
         * 
         * testFourthProject(); // projectImportTest();
         * 
         * //testing project imports testSimpleImplies(); // ivmlParse();
         */
        testingStringOperations();
        Assert.assertTrue(true);

    }

    /**
     * Method to test container operation calls.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws IOException
     *             Should not occur if the Jess file is found.
     * @throws ConfigurationException
     *             Should not occur ifthe config. is right.
     */

    private static void testContainerOperationCalls()
        throws ValueDoesNotMatchTypeException, CSTSemanticException,
        IOException, ConfigurationException {
        Project project = new Project("OperationCall");
        IDatatype setType = new Set("setOf(Integer)", IntegerType.TYPE, project);

        DecisionVariableDeclaration sVar = new DecisionVariableDeclaration("set_se", setType, project);
        project.add(sVar);
        Variable sVarCst = new Variable(sVar);
        ConstantValue constCst10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "10"));
        DecisionVariableDeclaration tVar = new DecisionVariableDeclaration("t", IntegerType.TYPE, null);
        Variable tVarCst = new Variable(tVar);
        OCLFeatureCall greater = new OCLFeatureCall(tVarCst, ">", constCst10);
        ContainerOperationCall opCall = new ContainerOperationCall(sVarCst,
                "forAll", greater, tVar);
        Constraint cons = new Constraint(opCall, null);
        tVar.setParent(cons);
        project.add(cons);

        ContainerOperationCall opCall1 = new ContainerOperationCall(sVarCst,
                OclKeyWords.EXISTS, greater, tVar);
        Constraint cons2 = new Constraint(opCall1, null);
        project.add(cons2);

        OCLFeatureCall lesser = new OCLFeatureCall(tVarCst, "<", constCst10);
        ContainerOperationCall opCallLess = new ContainerOperationCall(sVarCst,
                "exists", lesser, tVar);
        Constraint consLess = new Constraint(opCallLess, null);
        tVar.setParent(consLess);
        project.add(consLess);

        ContainerOperationCall opCallSelect = new ContainerOperationCall(
                sVarCst, OclKeyWords.SELECT, lesser, tVar);
        OCLFeatureCall ln = new OCLFeatureCall(opCallSelect,
                OclKeyWords.EQUALS, sVarCst);
        Constraint consSelect = new Constraint(ln, null);
        tVar.setParent(consSelect);
        project.add(consSelect);

        ContainerOperationCall opAny = new ContainerOperationCall(sVarCst,
                OclKeyWords.ANY, lesser, tVar);
        OCLFeatureCall ln2 = new OCLFeatureCall(opAny, OclKeyWords.EQUALS,
                sVarCst);
        Constraint consAny = new Constraint(ln2, null);
        tVar.setParent(consAny);
        project.add(consAny);

        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE,
                project);

        project.add(intDecVar);

        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        Variable var1 = new Variable(intDecVar);
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), cV);
        Constraint cons1 = new Constraint(ocl1, null);
        project.add(cons1);

        Object[] values1 = {"2", "3", "12", "9", "15"};
        ContainerValue value = (ContainerValue) ValueFactory.createValue(
                setType, values1);
        Configuration conf = new Configuration(project);
        conf.getDecision(sVar).setValue(value, null);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
    }

    /**
     * Private Method for testSimpleProject IVML test case - x > 5 .<br/>
     * Jess engine should return <b>False></b> as x is configured 2.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testSimpleProject()
        throws ValueDoesNotMatchTypeException, ConfigurationException,
        CSTSemanticException, IOException {

        Project project = new Project("testProjectOne");

        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE,
                project);

        project.add(intDecVar);

        Variable var1 = new Variable(intDecVar);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), cV);
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);

        Value val1 = ValueFactory.createValue(IntegerType.TYPE, "2");

        Configuration conf = new Configuration(project);
        conf.getDecision(intDecVar).setValue(val1, null);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");

    }

    /**
     * Second test containing a compound with an int and a constraint place on
     * int. Jess engine should return <b>False></b>.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testSecondProject()
        throws ValueDoesNotMatchTypeException, CSTSemanticException,
        ConfigurationException, IOException {

        Project project = new Project("testProjectTwo");

        Compound compoundOne = new Compound("CompoundOne", project);
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE,
                compoundOne);
        compoundOne.add(intDecVar);
        project.add(compoundOne);

        Variable var1 = new Variable(intDecVar);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), cV);
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);

        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(
                compoundOne, "x", "3");
        DecisionVariableDeclaration compDecvar = new DecisionVariableDeclaration(
                "compoundVar", compoundOne, project);
        project.add(compDecvar);
        Configuration conf = new Configuration(project);
        conf.getDecision(compDecvar).setValue(cValue, null);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");

    }

    /**
     * Private Method for sequence and constraints in its elements IVML test
     * case.<br/>
     * The IVML Object model consists of two compounds. The first compound
     * consists of two integers, maxX & maxY; while the second compound consists
     * an integer and an element which is a sequenceOf the first compound. The
     * constraint is placed between maxX & maxY (maxX > maxY).
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testThirdProject()
        throws ValueDoesNotMatchTypeException, ConfigurationException,
        IOException, CSTSemanticException {

        Project project = new Project("testProjectThree");
        Compound gassenTyp = new Compound("gassenTyp", project);

        DecisionVariableDeclaration maxX = new DecisionVariableDeclaration(
                "maxX", IntegerType.TYPE, gassenTyp);
        DecisionVariableDeclaration maxY = new DecisionVariableDeclaration(
                "maxY", IntegerType.TYPE, gassenTyp);
        DecisionVariableDeclaration c = new DecisionVariableDeclaration(
                "notUsedVar", IntegerType.TYPE, gassenTyp);

        gassenTyp.add(maxX);
        gassenTyp.add(maxY);
        gassenTyp.add(c);

        project.add(gassenTyp);

        Compound hochRegal = new Compound("hochRegal", project);

        project.add(hochRegal);

        Container seq = new Sequence("seq", gassenTyp, hochRegal);
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration(
                "seq_var", seq, hochRegal);
        hochRegal.add(seqDec);
        DecisionVariableDeclaration decX = new DecisionVariableDeclaration("x",
                IntegerType.TYPE, hochRegal);
        hochRegal.add(decX);

        String[] values1 = {"maxX", "5", "maxY", "10"};
        String[] values2 = {"maxX", "25", "maxY", "20"};

        Object[] cmpValues = {values1, values2};

        CompoundValue hochValue = (CompoundValue) ValueFactory.createValue(
                hochRegal, "seq_var", cmpValues, "x", "100");

        DecisionVariableDeclaration hochVAR = new DecisionVariableDeclaration(
                "hochVAR", hochRegal, project);
        project.add(hochVAR);
        Configuration conf = new Configuration(project);
        conf.getDecision(hochVAR).setValue(hochValue, null);

        Variable var1 = new Variable(maxX);
        Variable var2 = new Variable(maxY);
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_EQUALS_INTEGER_INTEGER.getName(), var2);
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);

        Variable var3 = new Variable(seqDec);
        OCLFeatureCall ocl2 = new OCLFeatureCall(var3, OclKeyWords.NOT_EMPTY);
        Constraint cons1 = new Constraint(ocl2, null);
        Set set1 = new Set("some set", StringType.TYPE, project);

        project.add(cons1);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
    }

    /**
     * A test project consisting of derived datatypes, and constraints on such
     * decision variable declarations. Two cases are considered, a decision
     * variable declaration as a nested element and as a non-nested. This test
     * results in consistency - false - as the constraints are placed on
     * elements that are typedef(Integer > 128), while in the configuration one
     * is assigned a value > 128 while the other < 128.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testFourthProject()
        throws ValueDoesNotMatchTypeException, CSTSemanticException,
        ConfigurationException, IOException {
        Project project = new Project("testProjectFour");
        Compound compoundOne = new Compound("compoundOne", project);

        DerivedDatatype bitrate = new DerivedDatatype("Bitrate",
                IntegerType.TYPE, project);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);

        Constraint cons = new Constraint(constraint, null);
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);

        DecisionVariableDeclaration intDecVarOne;
        intDecVarOne = new DecisionVariableDeclaration("x", bitrate,
                compoundOne);
        compoundOne.add(intDecVarOne);
        project.add(compoundOne);

        DecisionVariableDeclaration intDecVarTwo;
        intDecVarTwo = new DecisionVariableDeclaration("y", bitrate, project);
        project.add(intDecVarTwo);

        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(
                compoundOne, "x", "64");
        Value intValue = ValueFactory.createValue(bitrate, "256");
        DecisionVariableDeclaration compoundVar = new DecisionVariableDeclaration(
                "compoundVar", compoundOne, project);
        project.add(compoundVar);

        Configuration conf = new Configuration(project);

        conf.getDecision(compoundVar).setValue(cValue, null);
        conf.getDecision(intDecVarTwo).setValue(intValue, null);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        REASONER.check(project, conf, null, ProgressObserver.NO_OBSERVER);
        System.out.println("......................");

    }

    /**
     * A very basic test on Enum. However, constraints on enums are not yet
     * supported. For e.g. consider an enum like the following: Enum(Color) =
     * {red, blue} and a declaration: Color color; And constraint - color = red;
     * 
     * @throws IOException a
     * @throws ValueDoesNotMatchTypeException a
     * @throws ConfigurationException s 
     * @throws CSTSemanticException s
     * 
     */
    private static void testEnumMethod() throws IOException,
        ValueDoesNotMatchTypeException, ConfigurationException,
        CSTSemanticException {
        Project project = new Project("testEnum");
        Enum enumOne = new Enum("TestEnum", project, "red", "blue");
        project.add(enumOne);
        Compound compoundOne = new Compound("compoundOne", project);
        project.add(compoundOne);
        DecisionVariableDeclaration decVarOne = new DecisionVariableDeclaration(
                "enumVar", enumOne, project);
        // compoundOne.add(decVarOne);
        project.add(decVarOne);

        DecisionVariableDeclaration decVarTwo = new DecisionVariableDeclaration(
                "enumVarTwo", enumOne, project);
        project.add(decVarTwo);
        Variable var1 = new Variable(decVarTwo);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(enumOne,
                "blue"));
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1, Enum.EQUALS.getName(),
                cV);
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);

        // the commented below and the one below it both work the same!
        // EnumValue eValue = (EnumValue) ValueFactory.createValue(enumOne,
        // enumOne.getLiteral(1));
        EnumValue eValue = (EnumValue) ValueFactory
                .createValue(enumOne, "blue");
        Configuration conf = new Configuration(project);
        conf.getDecision(decVarTwo).setValue(eValue, null);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        REASONER.check(project, conf, null, ProgressObserver.NO_OBSERVER);
        System.out.println("......................");

    }

    /**
     * Test for checking the constraint x = (y + z) * 2 .
     * 
     * @throws ValueDoesNotMatchTypeException .
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testComplexConstraintsProject()
        throws ValueDoesNotMatchTypeException, CSTSemanticException,
        IOException, ConfigurationException {
        Project project = new Project("testProjectConstraints");
        DecisionVariableDeclaration decVarOne = new DecisionVariableDeclaration(
                "x", IntegerType.TYPE, project);
        DecisionVariableDeclaration decVarTwo = new DecisionVariableDeclaration(
                "y", IntegerType.TYPE, project);
        DecisionVariableDeclaration decVarThree = new DecisionVariableDeclaration(
                "z", IntegerType.TYPE, project);
        // DecisionVariableDeclaration decVarFour = new
        // DecisionVariableDeclaration("a", IntegerType.TYPE, project);

        project.add(decVarOne);
        project.add(decVarTwo);
        project.add(decVarThree);

        Variable vX = new Variable(decVarOne);
        Variable vY = new Variable(decVarTwo);
        Variable vZ = new Variable(decVarThree);
        // Variable vA = new Variable(decVarFour);

        OCLFeatureCall ocl1 = new OCLFeatureCall(vY,
                IntegerType.PLUS_INTEGER_INTEGER.getName(), vZ);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl2 = new OCLFeatureCall(ocl1,
                IntegerType.MULT_INTEGER_INTEGER.getName(), cV);
        Parenthesis parenthesis = new Parenthesis(ocl2);
        OCLFeatureCall ocl3 = new OCLFeatureCall(vX,
                IntegerType.EQUALS_INTEGER_INTEGER.getName(), parenthesis);

        Constraint cons = new Constraint(ocl3, null);
        project.add(cons);

        Configuration conf = new Configuration(project);
        Value xValue = ValueFactory.createValue(IntegerType.TYPE, "1");
        conf.getDecision(decVarOne).setValue(xValue, null);

        Value yValue = ValueFactory.createValue(IntegerType.TYPE, "2");
        conf.getDecision(decVarTwo).setValue(yValue, null);

        Value zValue = ValueFactory.createValue(IntegerType.TYPE, "3");
        conf.getDecision(decVarThree).setValue(zValue, null);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        REASONER.check(project, conf, null, ProgressObserver.NO_OBSERVER);
        System.out.println("......................");

    }

    /**
     * Test project Five. Purpose of this is to test the modification. For e.g.,
     * if x > 5 then y == x. was expected to because of CST no custom operator
     * access given exception raise when OCLKeywords.equals_alias was used. So,
     * the below code uses a "less" operator for the purpose. However, this will
     * be changed soon.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    public static void testProjectFive() throws ValueDoesNotMatchTypeException,
            CSTSemanticException, ConfigurationException, IOException {

        Project project = new Project("testProjectFive");
        Compound compoundOne = new Compound("CompoundOne", project);
        DecisionVariableDeclaration intDecVarOne;
        intDecVarOne = new DecisionVariableDeclaration("x", IntegerType.TYPE, compoundOne);
        compoundOne.add(intDecVarOne);
        DecisionVariableDeclaration intDecVarA;
        intDecVarA = new DecisionVariableDeclaration("a", IntegerType.TYPE, compoundOne);
        compoundOne.add(intDecVarA);
        project.add(compoundOne);

        Compound compoundTwo = new Compound("CompoundTwo", project);
        DecisionVariableDeclaration intDecVarTwo;
        intDecVarTwo = new DecisionVariableDeclaration("y", IntegerType.TYPE,
                compoundTwo);
        compoundTwo.add(intDecVarTwo);
        DecisionVariableDeclaration intDecVarZ;
        intDecVarZ = new DecisionVariableDeclaration("Z", IntegerType.TYPE,
                compoundOne);
        compoundTwo.add(intDecVarZ);
        project.add(compoundTwo);
        DecisionVariableDeclaration boolA = new DecisionVariableDeclaration(
                "boolA", BooleanType.TYPE, project);
        DecisionVariableDeclaration boolB = new DecisionVariableDeclaration(
                "boolB", BooleanType.TYPE, project);
        project.add(boolA);
        project.add(boolB);
        Variable varA = new Variable(boolA);
        Variable varB = new Variable(boolB);

        Variable var1 = new Variable(intDecVarOne);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), cV);

        Variable var2 = new Variable(intDecVarTwo);
        // OclKeyWords.EQUALS_ALIAS does not work here.
        OCLFeatureCall ocl2 = new OCLFeatureCall(var2, OclKeyWords.EQUALS, var1);
        OCLFeatureCall ocl3 = new OCLFeatureCall(ocl1, OclKeyWords.IMPLIES,
                ocl2);

        Constraint cons = new Constraint(ocl3, null);
        project.add(cons);

        OCLFeatureCall ocl4 = new OCLFeatureCall(varA, OclKeyWords.IMPLIES,
                varB);

        Constraint cons1 = new Constraint(ocl4, null);
        project.add(cons1);

        DecisionVariableDeclaration dc = new DecisionVariableDeclaration("dc",
                compoundOne, project);
        Value val = (CompoundValue) ValueFactory.createValue(compoundOne, "x",
                "6");

        project.add(dc);
        Configuration conf = new Configuration(project);
        conf.getDecision(dc).setValue(val, null);
        Value boolVal1 = ValueFactory.createValue(boolA.getType(), "true");
        Value boolVal2 = ValueFactory.createValue(boolB.getType(), "false");
        conf.getDecision(boolA).setValue(boolVal1, null);
        conf.getDecision(boolB).setValue(boolVal2, null);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");
    }

    /**
     * Method which includes and tests the use of parenthesis in constraints.
     * Testing - ((a + b) + x) > c
     * 
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    public static void testParanthesisProject() throws CSTSemanticException,
            ValueDoesNotMatchTypeException, ConfigurationException, IOException {

        Project project = new Project("testParanthesisProject");
        DecisionVariableDeclaration realADecl = new DecisionVariableDeclaration(
                "realA", RealType.TYPE, project);
        DecisionVariableDeclaration realBDecl = new DecisionVariableDeclaration(
                "realB", RealType.TYPE, project);
        DecisionVariableDeclaration realCDecl = new DecisionVariableDeclaration(
                "realC", RealType.TYPE, project);
        DecisionVariableDeclaration realXDecl = new DecisionVariableDeclaration(
                "realX", RealType.TYPE, project);

        project.add(realADecl);
        project.add(realBDecl);
        project.add(realCDecl);
        project.add(realXDecl);

        // Create constraint variables for building constraints in test methods
        Variable realA = new Variable(realADecl);
        Variable realB = new Variable(realBDecl);
        Variable realC = new Variable(realCDecl);
        Variable realX = new Variable(realXDecl);

        OCLFeatureCall nestedCall = new OCLFeatureCall(realA, OclKeyWords.PLUS,
                realB);
        Parenthesis parenthesis = new Parenthesis(nestedCall);
        OCLFeatureCall nestedCall1 = new OCLFeatureCall(parenthesis,
                OclKeyWords.PLUS, realX);
        Parenthesis parenthesis1 = new Parenthesis(nestedCall1);
        // Create (realA + realB) < realC
        OCLFeatureCall completeCall = new OCLFeatureCall(parenthesis1,
                OclKeyWords.EQUALS, realC);
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

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");

    }

    /**
     * complexDtataTypeTest1 method which tests integer operations between two
     * integers. The following are tested in the method for two integers, intA
     * and intB: 1) intA < intB 2) intA != intB 3) intA < 5 4) (intA + intB) = 7
     * The test should return <b>True</b> for the configuration intA = 2, intB =
     * 5.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    public static void complexDataTypeTest1() throws CSTSemanticException,
            ValueDoesNotMatchTypeException, ConfigurationException, IOException {
        Project project = new Project("ComplexdatatypeTest1");
        DecisionVariableDeclaration integerADecl = new DecisionVariableDeclaration(
                "intlA", IntegerType.TYPE, project);
        DecisionVariableDeclaration integerBDecl = new DecisionVariableDeclaration(
                "intlB", IntegerType.TYPE, project);

        project.add(integerADecl);
        project.add(integerBDecl);
        // Create constraint variables for building constraints in test methods
        Variable integerA = new Variable(integerADecl);
        Variable integerB = new Variable(integerBDecl);

        OCLFeatureCall ocl1 = new OCLFeatureCall(integerA, OclKeyWords.LESS,
                integerB);

        OCLFeatureCall ocl2 = new OCLFeatureCall(integerA,
                IntegerType.NOTEQUALS_INTEGER_INTEGER.getName(), integerB);

        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl3 = new OCLFeatureCall(integerA, OclKeyWords.LESS, cV);

        ConstantValue cV1 = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "7"));
        OCLFeatureCall nestedCall = new OCLFeatureCall(integerA,
                OclKeyWords.PLUS, integerB);
        Parenthesis parenthesis = new Parenthesis(nestedCall);
        OCLFeatureCall ocl4 = new OCLFeatureCall(parenthesis,
                OclKeyWords.EQUALS, cV1);

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

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");

    }

    /**
     * complexDtataTypeTest2 method which tests real operations between two
     * reals. The following are tested in the method for two reals, realX and
     * realY: 1) realX != realY 2) realX < 9.1 3) realY > 10.1 4) (realX +
     * realY) < 22.0 5) (realY - realX) > 2.0 The test should return <b>True</b>
     * for the configuration realX = 9.0 and realY = 11.5 and <b>False</b> for
     * the configuration realX = 9.0 and realY = 10.5
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    public static void complexDataTypeTest2() throws CSTSemanticException,
            ValueDoesNotMatchTypeException, ConfigurationException, IOException {
        Project project = new Project("ComplexdatatypeTest2");

        DecisionVariableDeclaration realYDecl = new DecisionVariableDeclaration(
                "realY", RealType.TYPE, project);
        DecisionVariableDeclaration realXDecl = new DecisionVariableDeclaration(
                "realX", RealType.TYPE, project);

        project.add(realYDecl);
        project.add(realXDecl);

        // Create constraint variables for building constraints in test methods
        Variable realX = new Variable(realXDecl);
        Variable realY = new Variable(realYDecl);

        OCLFeatureCall ocl5 = new OCLFeatureCall(realX,
                RealType.NOTEQUALS_REAL_INTEGER.getName(), realY);
        ConstantValue cV3 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "9.1"));
        OCLFeatureCall ocl6 = new OCLFeatureCall(realX, OclKeyWords.LESS, cV3);
        ConstantValue cV4 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "10.1"));
        OCLFeatureCall ocl7 = new OCLFeatureCall(realY, OclKeyWords.GREATER,
                cV4);

        OCLFeatureCall ocl8 = new OCLFeatureCall(realX, OclKeyWords.PLUS, realY);
        Parenthesis parenthesis3 = new Parenthesis(ocl8);
        ConstantValue cV5 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "22.0"));
        OCLFeatureCall ocl9 = new OCLFeatureCall(parenthesis3,
                OclKeyWords.LESS, cV5);

        OCLFeatureCall ocl10 = new OCLFeatureCall(realY,
                RealType.MINUS_REAL_REAL.getName(), realX);
        Parenthesis parenthesis4 = new Parenthesis(ocl10);
        ConstantValue cV6 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "2.0"));
        OCLFeatureCall ocl11 = new OCLFeatureCall(parenthesis4,
                OclKeyWords.GREATER, cV6);

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

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");

    }

    /**
     * Method to test project imports. This is a simple test with a project
     * import without any restriction. Since there are not any import
     * restrictions, the original project will have have everything present on
     * the project being imported.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws ConfigurationException
     *             Should not occur if the values are configured rightly.
     * @throws IOException
     *             Should not occur if the Jess file is found.
     * @throws ModelManagementException
     *             Should not throw Model Query exception emerging from faulty
     *             project imports.
     */

    private static void projectImportTest()
        throws ValueDoesNotMatchTypeException, CSTSemanticException,
        IOException, ConfigurationException, ModelManagementException {

        Project importedPro = new Project("ProjectBeingImported");
        DecisionVariableDeclaration realYDecl = new DecisionVariableDeclaration(
                "realY", RealType.TYPE, importedPro);
        DecisionVariableDeclaration realXDecl = new DecisionVariableDeclaration(
                "realX", RealType.TYPE, importedPro);

        importedPro.add(realYDecl);
        importedPro.add(realXDecl);

        Variable realX = new Variable(realXDecl);
        ConstantValue cV3 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "9.1"));
        OCLFeatureCall ocl6 = new OCLFeatureCall(realX, OclKeyWords.GREATER,
                cV3);
        Constraint cons6 = new Constraint(ocl6, null);
        importedPro.add(cons6);

        ProjectImport proImport = new ProjectImport("projectBeingImported",
                "NoReference");
        proImport.setResolved(importedPro);

        Project project = new Project("ActualProjectWhichImports");
        project.addImport(proImport);

        Compound compoundOne = new Compound("CompoundOne", project);
        DecisionVariableDeclaration intDecVar;
        intDecVar = new DecisionVariableDeclaration("x", IntegerType.TYPE,
                compoundOne);
        compoundOne.add(intDecVar);
        project.add(compoundOne);

        Variable var1 = new Variable(intDecVar);
        ConstantValue cV = new ConstantValue(ValueFactory.createValue(
                IntegerType.TYPE, "5"));
        OCLFeatureCall ocl1 = new OCLFeatureCall(var1,
                IntegerType.GREATER_INTEGER_INTEGER.getName(), cV);
        Constraint cons = new Constraint(ocl1, null);
        project.add(cons);

        project.add(realXDecl);

        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(
                compoundOne, "x", "3");
        DecisionVariableDeclaration compDecvar = new DecisionVariableDeclaration(
                "compoundVar", compoundOne, project);
        project.add(compDecvar);
        Configuration conf = new Configuration(project);
        conf.getDecision(compDecvar).setValue(cValue, null);
        Value val3 = ValueFactory.createValue(RealType.TYPE, "9.0");
        conf.getDecision(realXDecl).setValue(val3, null);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(r.hasConflict());
        System.out.println("......................");

    }

    /**
     * Method which tests equalities - and also equalities in a call involving
     * implies. Two types are tested Consider reals realX and realY 1) realX =
     * realY - which is an assignment. 2) real > 9.1 implies realY = realY. The
     * RHS is an assignment when LHS is evaluated to <b>True</b>.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws IOException
     *             Should not occur if the Jess file is found. faulty project
     *             imports.
     */
    private static void projectEqualities() 
        throws ValueDoesNotMatchTypeException, CSTSemanticException, IOException {

        Project project = new Project("ProjectEqualities");
        DecisionVariableDeclaration realYDecl = new DecisionVariableDeclaration(
                "realY", RealType.TYPE, project);
        DecisionVariableDeclaration realXDecl = new DecisionVariableDeclaration(
                "realX", RealType.TYPE, project);
        project.add(realYDecl);
        project.add(realXDecl);
        // Create constraint variables for building constraints in test methods

        Variable realX = new Variable(realXDecl);
        Variable realY = new Variable(realYDecl);
        OCLFeatureCall ocl1 = new OCLFeatureCall(realX, OclKeyWords.EQUALS,
                realY);

        ConstantValue cV3 = new ConstantValue(ValueFactory.createValue(
                RealType.TYPE, "9.1"));

        OCLFeatureCall ocl2 = new OCLFeatureCall(realX, OclKeyWords.EQUALS, cV3);
        OCLFeatureCall ocl3 = new OCLFeatureCall(realY, OclKeyWords.EQUALS,
                realX);
        OCLFeatureCall ocl4 = new OCLFeatureCall(ocl2, OclKeyWords.IMPLIES,
                ocl3);

        Constraint cons1 = new Constraint(ocl1, null);
        project.add(cons1);
        Constraint con2 = new Constraint(ocl4, null);
        project.add(con2);
        Configuration conf = new Configuration(project);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(!r.hasConflict());
        System.out.println("......................");
    }

    /**
     * Method to test implies.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws IOException
     *             Should not occur if the Jess file is found. faulty project
     *             imports.
     * @throws ConfigurationException
     *             Should not occur if there is no configuration error.
     */
    private static void testSimpleImplies() throws CSTSemanticException,
            IOException, ValueDoesNotMatchTypeException, ConfigurationException {

        Project project = new Project("testSimpleImplies");
        DecisionVariableDeclaration boolA = new DecisionVariableDeclaration(
                "boolA", BooleanType.TYPE, project);
        DecisionVariableDeclaration boolB = new DecisionVariableDeclaration(
                "boolB", BooleanType.TYPE, project);
        project.add(boolA);
        project.add(boolB);
        DecisionVariableDeclaration boolC = new DecisionVariableDeclaration(
                "boolC", BooleanType.TYPE, project);
        project.add(boolC);
        Variable varA = new Variable(boolA);
        Variable varB = new Variable(boolB);
        Variable varC = new Variable(boolC);
        OCLFeatureCall ocl1 = new OCLFeatureCall(varA, OclKeyWords.IMPLIES,
                varB);
        Parenthesis parenthesis = new Parenthesis(ocl1);
        OCLFeatureCall ocl2 = new OCLFeatureCall(varC, OclKeyWords.IMPLIES,
                parenthesis);

        Constraint cons1 = new Constraint(ocl2, null);
        project.add(cons1);

        Configuration conf = new Configuration(project);
        Value boolVal1 = ValueFactory.createValue(boolA.getType(), "true");
        Value boolVal2 = ValueFactory.createValue(boolB.getType(), "false");

        conf.getDecision(boolA).setValue(boolVal1, null);
        conf.getDecision(boolB).setValue(boolVal2, null);
        conf.getDecision(boolC).setValue(boolVal2, null);

        /*
         * boolean consistency = checker.isConsistent(project, conf);
         * System.out.println("\nConsistency - " + consistency);
         * System.out.println("\n..................................");
         */
        REASONER.check(project, conf, null, ProgressObserver.NO_OBSERVER);
        System.out.println("......................");

    }

    // Commented the whole method for now.

    /**
     * IVML Parsing test.
     * 
     * @throws ValueDoesNotMatchTypeException
     *             Should not occur if the values are configured correctly in
     *             relation to the datatype.
     * @throws CSTSemanticException
     *             Must not occur, otherwise there is an error inside the CST
     *             package
     * @throws IOException
     *             Should not occur if the Jess file is found. faulty project
     *             imports.
     * @throws ConfigurationException
     *             Should not occur if there is no configuration error.
     * 
     */
    private static void ivmlParse() throws IOException, CSTSemanticException,
            ValueDoesNotMatchTypeException, ConfigurationException {

        File file = new File(System.getProperty("user.dir") + File.separator
                + "Files" + File.separator + "test.ivml");

        try {
            ReasoningImportResolver.registerAsTopResolver();
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
            VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE,
                    ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {

        }

        TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
        Project project = result.getResult(0);

        Configuration conf = new Configuration(project);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        System.out.println("message count : " + r.getMessageCount());
        System.out
                .println(".............................. END CHECKING ..............................");
        Assert.assertTrue(r.hasConflict());
        // checker.propagate(project, conf, null, ProgressObserver.NO_OBSERVER);

    }

    /**
     * A private method to test string operations.
     * 
     * @throws IOException
     *             Should not occur if the Jess file is found.
     */
    private static void testingStringOperations() throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator
                + "Files" + File.separator + "CompsAndSeq.ivml");

        try {
            ReasoningImportResolver.registerAsTopResolver();
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
            VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE,
                    ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {

        }

        TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
        Project project = result.getResult(0);

        Configuration conf = new Configuration(project);

        ReasoningResult r = REASONER.check(project, conf, null,
                ProgressObserver.NO_OBSERVER);
        System.out.println("Message count: " + r.getMessageCount());
        Assert.assertFalse(r.hasConflict());
    }

}
