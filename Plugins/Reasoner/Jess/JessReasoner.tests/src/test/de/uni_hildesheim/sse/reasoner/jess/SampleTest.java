package test.de.uni_hildesheim.sse.reasoner.jess;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoner.jess.JessVisitor;

/**
 * SampleTest case showing how to implement test cases. This class is also
 * created for testing the server configuration. Please delete this test case
 * when first real test case created.
 * 
 * @author Saripalli
 * @author tebbje
 */
public class SampleTest {

    private JessVisitor jessR;
    private Compound testCompound;
    private Project p;
    private DecisionVariableDeclaration varLocation;

    /**
     * SetUp for testing issues.
     * @throws ValueDoesNotMatchTypeException if value does not match datatype
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        p = new Project("project");
        jessR = new JessVisitor();
        testCompound = new Compound("test_compound", p);
        p.add(testCompound);
        varLocation = new DecisionVariableDeclaration("location",
                StringType.TYPE, testCompound);
        testCompound.add(varLocation);
        DecisionVariableDeclaration varUsers = new DecisionVariableDeclaration(
                "users", IntegerType.TYPE, testCompound);
        varUsers.setValue("5");
        testCompound.add(varUsers);

        Compound cp2 = new Compound("CP2", p);
        p.add(cp2);
        Compound cp1 = new Compound("CP1", p);
        p.add(cp1);
        DecisionVariableDeclaration cp1Decl = new DecisionVariableDeclaration(
                "cp1", cp1, p);
        DecisionVariableDeclaration cp2Decl = new DecisionVariableDeclaration(
                "cp2", cp2, cp1);
        cp1.add(cp2Decl);
        p.add(cp1Decl);
    }

    /**
     * Simple test case, always successful.
     * 
     * @throws ValueDoesNotMatchTypeException if value does not match datatype
     */
    @Test
    public void test() throws ValueDoesNotMatchTypeException {

//        Assert.assertEquals(false, jessR.isCompoundVisited());
//        jessR.visitCompound(testCompound);
//        Assert.assertEquals(true, jessR.isCompoundVisited());
//
//        Enum e = new Enum("Quality", null, "High", "Low");
//        Assert.assertEquals(false, jessR.isEnumVisited());
//        jessR.visitEnum(e);
//        Assert.assertEquals(true, jessR.isEnumVisited());
//
//        Assert.assertEquals(false, jessR.isProjectVisted());
//        jessR.visitProject(p);
//        Assert.assertEquals(true, jessR.isProjectVisted());
//
//        Assert.assertEquals(false, jessR.isDecVarVisited());
//        jessR.visitDecisionVariableDeclaration(varLocation);
//        Assert.assertEquals(true, jessR.isDecVarVisited());

    }

    /**
     * Test visits.
     * @throws ValueDoesNotMatchTypeException if value does not match datatype
     */
    @Test
    public void testVisits() throws ValueDoesNotMatchTypeException {
        Project p = new Project("test_project");
        Compound gassenTyp = new Compound("gassenTyp", p);
        p.add(gassenTyp);

        // Add maxX and maxY of type integers to the compound gassenTyp
        gassenTyp.add(new DecisionVariableDeclaration("maxX", IntegerType.TYPE,
                gassenTyp));
        gassenTyp.add(new DecisionVariableDeclaration("maxY", IntegerType.TYPE,
                gassenTyp));

        // add gassenTyp to the project
        p.add(gassenTyp);

        // Create a new compound hochRegal
        Compound hochRegal = new Compound("hochRegal", p);
        p.add(hochRegal);

        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(
                gassenTyp, "maxX", "5", "maxY", "10");

        Container seq = new Sequence("seq", gassenTyp, hochRegal);
        DecisionVariableDeclaration seqDec = new DecisionVariableDeclaration(
                "seq_var", seq, hochRegal);
        hochRegal.add(seqDec);

        String[] values1 = {"maxX", "5", "maxY", "10"};
        String[] values2 = {"maxX", "15", "maxY", "20"};
        Object[] cmpValues = {values1, values2};

        ContainerValue seqValue = (ContainerValue) ValueFactory.createValue(
                seq, values1, values2);
        // ContainerValue seqValue = (ContainerValue)
        // ValueFactory.createValue(seq, "maxX", "5", "maxY", "10");
        CompoundValue hochValue = (CompoundValue) ValueFactory.createValue(
                hochRegal, "seq_var", cmpValues);

        System.out.println("Hochregal is fully configured: "
                + hochValue.isFullyConfigured());
        

    }

}
