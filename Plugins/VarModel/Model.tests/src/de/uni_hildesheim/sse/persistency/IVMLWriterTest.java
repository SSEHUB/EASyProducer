package de.uni_hildesheim.sse.persistency;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Test cases for the IVMLWriter class.
 * @author Marcel Lueder
 *
 */
public class IVMLWriterTest {

    private IVMLWriter writer;
    private String name;
    private Project pro;
    private Version version;
    private StringWriter strWriter;
    
    /**
     * Sets up the IVMLWriter and sets the name before the test runs.
     */
    @Before
    public void setUp() {
        name = "Name";
        pro = new Project(name);
        strWriter = new StringWriter();
        writer = new IVMLWriter(strWriter);
    }
    
    /**
     * Tests whether writing an empty project succeeds.
     */
    @Test
    public void writeEmptyProjectTest() {
        pro.accept(writer);
        
        /*Defining the expected result of the test
         *Expected output:
         * project name {
         * 
         * }
         */
        final String expected = "project " + name + " {\r\n\r\n}" + "\r\n";
        //Start testing
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing an project containing a version succeeds.
     */
    @Test
    public void writeVersionedEmptyProjectTest() {
        version = new Version(1, 2, 17, 4);
        pro.setVersion(version);
        pro.accept(writer);
        
        /*Defining the expected result of the test
         *Expected output:
         * project name {
         *     version 1.2.17.4;
         * }
         */
        String expected = "project " + name + " {\r\n\r\n";
        expected += "    version v1.2.17.4;\r\n";
        expected += "}\r\n";
        
        //Start testing
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing one project import succeeds.
     */
    @Test
    public void writeOneProjectImportTest() {
        ProjectImport pimport = new ProjectImport("NameOfImport", null);
        // TODO consider interface
        pro.addImport(pimport);
        pro.accept(writer);
        
        /*Defining the expected result of the test
         *Expected output:
         * project name {
         *     import NameOfImport;
         * }
         */
        String expected = "project " + name + " {\r\n\r\n";
        expected += "    import NameOfImport;\r\n";
        expected += "}\r\n";
        //Start testing
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing five project imports succeeds.
     */
    @Test
    public void writeFiveProjectImportTest() {
        //Adding imports
        // TODO consider interface
        for (int i = 1; i < 6; i++) {
            pro.addImport(new ProjectImport("NameOfImport" + i, null));
        }
        version = new Version(1, 2, 17, 4);
        //Adding a version
        pro.setVersion(version);
        pro.accept(writer);
        
        String expected = "project " + name + " {\r\n\r\n";
        expected += "    version v1.2.17.4;\r\n";
        expected += "    import NameOfImport1;\r\n";
        expected += "    import NameOfImport2;\r\n";
        expected += "    import NameOfImport3;\r\n";
        expected += "    import NameOfImport4;\r\n";
        expected += "    import NameOfImport5;\r\n";
        expected += "}\r\n";
        
        //Start testing
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing an project with version and import succeeds.
     */
    @Test
    public void writeVersionImportsProjectTest() {
        for (int i = 1; i < 6; i++) {
            // TODO consider interface
            pro.addImport(new ProjectImport("NameOfImport" + i, null));
        }
        pro.accept(writer);
    }
    
    /**
     * Tests whether writing an import with restriction succeeds.
     * @throws IOException 
     */
    @Test
    public void writeImportWithRestriciton() throws IOException {
        //Creating a version
        try {
            version = new Version("1");
        } catch (VersionFormatException e) {
            Assert.fail("String format exc");
        }
        
        //Defining the version of the project
        pro.setVersion(version);
        
        //Creating a version restriction
        String importedProject = "Import1";
        VersionRestriction res = new VersionRestriction(importedProject, VersionRestriction.Operator.EQUALS , version);
        // TODO consider interfaces        
        //Creating an import containing the restriction
        ProjectImport imp = new ProjectImport("Name", "InterfaceName", false, false, res);
        
        //Adding the import to the project
        pro.addImport(imp);
        
        //Calling the accept of the project
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    version v1;\r\n";
        expected += "    import Name::InterfaceName with (Import1.version == v1);\r\n";
        expected += "}\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing two imporst with restrictions succeeds.
     * @throws IOException 
     * @throws VersionFormatException 
     * @throws ValueDoesNotMatchTypeException 
     */
    @Test
    public void writeImportsWithRestricitons() throws IOException, VersionFormatException, 
        ValueDoesNotMatchTypeException {
        //Creating a version
        try {
            version = new Version("1");
        } catch (VersionFormatException e) {
            Assert.fail("String format exc");
        }
        
        //Defining the version of the project
        try {
            pro.setVersion(new Version("4"));
        } catch (VersionFormatException e) {
            Assert.fail("String format exc");
        }
        
        //Creating a version restriction
        String importedProject = "Import1";
        VersionRestriction res = new VersionRestriction(importedProject, VersionRestriction.Operator.GREATER , version);
        VersionRestriction res2 = new VersionRestriction("Import2", 
                VersionRestriction.Operator.GREATER_EQUALS , version);
        VersionRestriction res3 = new VersionRestriction("Import3", VersionRestriction.Operator.LESS ,
                new Version("20"));

        DecisionVariableDeclaration[] exports = new DecisionVariableDeclaration[2];
        exports[0] = new DecisionVariableDeclaration("name", StringType.TYPE, pro);
        exports[0].setValue("Marcel");
        exports[1] = new DecisionVariableDeclaration("alter", IntegerType.TYPE, pro);
        exports[1].setValue("20");
        ProjectInterface myInterface = new ProjectInterface("myInterface", exports, pro);
        
        //Creating first import containing the res and res3 restriction
        ProjectImport imp = new ProjectImport(importedProject, "myInterface", false, false, res, res3);
        
        //Creating second import containing the res2 restriction
        ProjectImport imp2 = new ProjectImport("Import2", null, false, false, res2);
        
        //Adding the imports + interface to the project
        pro.add(myInterface);
        pro.addImport(imp);
        pro.addImport(imp2);
        
        //Calling the accept of the project
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    version v4;\r\n";
        expected += "    import " + importedProject + "::myInterface with (" + importedProject;
        expected += ".version > v1, Import3.version < v20);\r\n";
        expected += "    import Import2 with (Import2.version >= v1);\r\n";
        expected += "    interface myInterface {\r\n";
        expected += "        export name;\r\n";
        expected += "        export alter;\r\n";
        expected += "    }\r\n";
        expected += "}\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing an empty compound succeeds.
     * @throws IOException Should not occur, otherwise the visitor
     */
    @Test
    public void writeEmptyCompound() throws IOException {
        String compName = "Name";
        Compound comp = new Compound(compName, null);
        comp.accept(writer);
        
        String expected = "compound " + compName + " {\r\n";
        expected += "}\r\n\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing a filled compound succeeds.
     * @throws IvmlException in case of any semantic error
     * @throws IOException Should not occur, otherwise the visitor
     */
    @Test
    public void writeFilledCompound() throws IvmlException, IOException {
        String compName = "Name";
        Compound comp = new Compound(compName, pro);
        DecisionVariableDeclaration name = new DecisionVariableDeclaration("name", StringType.TYPE, comp);
        name.setValue("Heiko");
        DecisionVariableDeclaration alter = new DecisionVariableDeclaration("alter", IntegerType.TYPE, comp);
        alter.setValue("20");
        DecisionVariableDeclaration groesse = new DecisionVariableDeclaration("größe", RealType.TYPE, comp);
        groesse.setValue("197.3");
        DecisionVariableDeclaration mail = new DecisionVariableDeclaration("mail", StringType.TYPE, comp);
        mail.setValue("Heiko@ablubbel.com");
        DecisionVariableDeclaration isMale = new DecisionVariableDeclaration("isMale", BooleanType.TYPE, comp);
        isMale.setValue("true");
        comp.add(name);
        comp.add(alter);
        comp.add(groesse);
        comp.add(mail);
        comp.add(isMale);
        comp.accept(writer);
        
        String expected = "compound " + compName + " {\r\n";
        expected += "    String name = \"Heiko\";\r\n";
        expected += "    Integer alter = 20;\r\n";
        expected += "    Real größe = 197.3;\r\n";
        expected += "    String mail = \"Heiko@ablubbel.com\";\r\n";
        expected += "    Boolean isMale = true;\r\n";
        expected += "}\r\n\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing an empty enum succeeds.
     * @throws IOException Should not occur, otherwise the visitor
     */
    @Test
    public void writeEmptyEnum() throws IOException {
        String enumName = "Name";
        Enum en = new Enum(enumName, null);
        en.accept(writer);
        
        String expected = "enum " + enumName + " {};\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing an filled enum succeeds.
     * @throws IOException Should not occur, otherwise the visitor
     */
    @Test
    public void writeFilledEnum() throws IOException {
        String enumName = "Name";
        Enum en = new Enum(enumName, null, "Literal1", "Literal2", "Literal3");
        en.accept(writer);
        
        String expected = "enum " + enumName + " {Literal1, Literal2, Literal3};\r\n";
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests writing a sequence.
     * @throws IOException 
     */
    @Test
    public void writeSequenceTest() throws IOException {
        Compound com = new Compound("comp", pro);
        com.add(new DecisionVariableDeclaration("x", IntegerType.TYPE, com));
        com.add(new DecisionVariableDeclaration("y", IntegerType.TYPE, com));
        Container seq = new Sequence("seq", com, null);
        
        seq.accept(writer);
        
        String expected = "sequenceOf(comp) seq;\r\n";
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests writing a set.
     * @throws IOException 
     */
    @Test
    public void writeSetTest() throws IOException {
        Compound com = new Compound("comp", pro);
        com.add(new DecisionVariableDeclaration("x", IntegerType.TYPE, com));
        com.add(new DecisionVariableDeclaration("y", IntegerType.TYPE, com));
        Container seq = new Set("seq", com, pro);
        
        seq.accept(writer);
        
        String expected = "setOf(comp) seq;\r\n";
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests the mini.ivml test.
     * @throws IvmlException in case of any semantic error
     */
    @Test
    public void miniIvmlTest() throws IvmlException {
        pro = new Project("demo");
        
        //Compound 2
        Compound comp2 = new Compound("Comp2", pro);
        DecisionVariableDeclaration name = new DecisionVariableDeclaration("name", StringType.TYPE, comp2);
        name.setValue("Marcel");
        DecisionVariableDeclaration mail = new DecisionVariableDeclaration("mail", StringType.TYPE, comp2);
        mail.setValue("Marcel@ablubbel.com");
        comp2.add(name);
        comp2.add(mail);
        pro.add(comp2);
        
        //Compound 3
        Compound comp3 = new Compound("Comp3", pro);
        DecisionVariableDeclaration name2 = new DecisionVariableDeclaration("name", StringType.TYPE, comp3);
        name2.setValue("Heiko");
        DecisionVariableDeclaration mail2 = new DecisionVariableDeclaration("mail", StringType.TYPE, comp3);
        mail2.setValue("Heiko@ablubbel.com");
        DecisionVariableDeclaration oneValue = new DecisionVariableDeclaration("oneValue", StringType.TYPE, comp3);
        oneValue.setValue("...");
        comp3.add(name2);
        comp3.add(mail2);
        comp3.add(oneValue);
        pro.add(comp3);
        
        //Compound 1
        Compound comp1 = new Compound("Comp1", pro);
        DecisionVariableDeclaration group2 = new DecisionVariableDeclaration("group2", comp2, comp1);
        DecisionVariableDeclaration group3 = new DecisionVariableDeclaration("group3", comp3, comp1);
        DecisionVariableDeclaration anothValue
            = new DecisionVariableDeclaration("anotherValue", StringType.TYPE, comp1);
        anothValue.setValue("---");
        DecisionVariableDeclaration group1 = new DecisionVariableDeclaration("group1", comp1, pro);
        comp1.add(group2);
        comp1.add(group3);
        comp1.add(anothValue);
        pro.add(comp1);
        
        //Projekt
        DecisionVariableDeclaration author = new DecisionVariableDeclaration("author", StringType.TYPE, pro);
        author.setValue("Marcel ;)");
        pro.add(author);
        pro.add(group1);
        
        
        pro.accept(writer);
        String expected = "project demo {\r\n\r\n";
        expected += "    compound Comp2 {\r\n";
        expected += "        String name = \"Marcel\";\r\n";
        expected += "        String mail = \"Marcel@ablubbel.com\";\r\n";
        expected += "    }\r\n\r\n";
        expected += "    compound Comp3 {\r\n";
        expected += "        String name = \"Heiko\";\r\n";
        expected += "        String mail = \"Heiko@ablubbel.com\";\r\n";
        expected += "        String oneValue = \"...\";\r\n";
        expected += "    }\r\n\r\n";
        expected += "    compound Comp1 {\r\n";
        expected += "        Comp2 group2;\r\n";
        expected += "        Comp3 group3;\r\n";
        expected += "        String anotherValue = \"---\";\r\n";
        expected += "    }\r\n" + "\r\n";
        expected += "    String author = \"Marcel ;)\";\r\n";
        expected += "    Comp1 group1;\r\n";
        expected += "}\r\n";
        
        //Start testing
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests the extended.ivml test.
     * @throws IvmlException in case of any semantic error
     * @throws IOException Should not occur, otherwise the visitor 
     */
    @Test
    public void extendedIvmlTest() throws IvmlException, IOException {
        pro = new Project("p");
        
        //Compound 1
        Compound cp1 = new Compound("CP1", pro);
        DecisionVariableDeclaration s1 = new DecisionVariableDeclaration("s1", StringType.TYPE, cp1);
        DecisionVariableDeclaration s2 = new DecisionVariableDeclaration("s2", StringType.TYPE, cp1);
        DecisionVariableDeclaration i = new DecisionVariableDeclaration("i", IntegerType.TYPE, cp1);
        cp1.add(s1);
        cp1.add(s2);
        cp1.add(i);
        pro.add(cp1);
        
        //Compound 2
        Compound cp2 = new Compound("CP2", pro);
        DecisionVariableDeclaration group2 = new DecisionVariableDeclaration("group2", cp1, cp2);
        DecisionVariableDeclaration r = new DecisionVariableDeclaration("r", RealType.TYPE, cp2);
        cp2.add(group2);
        cp2.add(r);
        pro.add(cp2);
        
        //Enum
        Enum eenum = new Enum("Enum", pro, "a", "b", "c", "d");
        pro.add(eenum);
        
        //Variable declarations
        DecisionVariableDeclaration group1 = new DecisionVariableDeclaration("group1", cp2, pro);
        DecisionVariableDeclaration s3 = new DecisionVariableDeclaration("s3", StringType.TYPE, pro);
        Enum e = new Enum("e", pro);
        pro.add(group1);
        pro.add(s3);
        pro.add(e);
        
        pro.accept(writer);
        String expected = "project p {\r\n\r\n";
        expected += "    compound CP1 {\r\n";
        expected += "        String s1;\r\n";
        expected += "        String s2;\r\n";
        expected += "        Integer i;\r\n";
        expected += "    }\r\n\r\n";
        expected += "    compound CP2 {\r\n";
        expected += "        CP1 group2;\r\n";
        expected += "        Real r;\r\n";
        expected += "    }\r\n\r\n";
        expected += "    enum Enum {a, b, c, d};\r\n";
        expected += "    CP2 group1;\r\n";
        expected += "    String s3;\r\n";
        expected += "    enum e {};\r\n";
        expected += "}\r\n";
        CompoundValue group1Value = (CompoundValue) ValueFactory.createValue(cp2, (Object[]) null);
        Value group2Value = ValueFactory.createValue(cp1, new Object[]{"s1", "a"});
        group1Value.configureValue("group2", group2Value);
        
        //Start testing
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing a project interface succeeds.
     * @throws IOException 
     */
    @Test
    public void writingProjectInterface() throws IOException {
        DecisionVariableDeclaration dec1 = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
        DecisionVariableDeclaration dec2 = new DecisionVariableDeclaration("Name2", StringType.TYPE, pro);
        DecisionVariableDeclaration[] decs = new DecisionVariableDeclaration[2];
        decs[0] = dec1;
        decs[1] = dec2;
        
        ProjectInterface pi = new ProjectInterface("InterfaceName", decs, pro);
        pro.add(pi);
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    interface InterfaceName {\r\n";
        expected += "        export Name;\r\n";
        expected += "        export Name2;\r\n";
        expected += "    }\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing freeze block succeeds.
     * @throws IOException 
     */
    @Test
    public void writingFreezeBlock() throws IOException {
        DecisionVariableDeclaration dec1 = new DecisionVariableDeclaration("Hans", StringType.TYPE, pro);
        DecisionVariableDeclaration dec2 = new DecisionVariableDeclaration("Klaus", StringType.TYPE, pro);
        DecisionVariableDeclaration[] decs = new DecisionVariableDeclaration[2];
        decs[0] = dec1;
        decs[1] = dec2;
        String[] but = new String[1];
        but[0] = "Kla*";
        
        FreezeBlock fb = new FreezeBlock(decs, but, pro);
        pro.add(fb);
        
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    freeze {\r\n";
        expected += "        Hans;\r\n";
        expected += "        Klaus;\r\n";
        expected += "    } but (Kla*)\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing freeze block with more than one but succeeds.
     * @throws IOException 
     * @throws ValueDoesNotMatchTypeException 
     */
    @Test
    public void writingFreezeBlockButs() throws IOException, ValueDoesNotMatchTypeException {
        Compound comp = new Compound("Compound1", pro);
        DecisionVariableDeclaration dec1 = new DecisionVariableDeclaration("Hans", StringType.TYPE, pro);
        DecisionVariableDeclaration dec2 = new DecisionVariableDeclaration("Klaus", StringType.TYPE, pro);
        DecisionVariableDeclaration dec3 = new DecisionVariableDeclaration("name", StringType.TYPE, comp);
        
        IFreezable[] decs = new IFreezable[3];
        decs[0] = dec1;
        decs[1] = dec2;
        decs[2] = dec3;
        
        String[] but = new String[3];
        but[0] = "Kla*";
        but[1] = "Rof*";
        but[2] = "SSE";
        
        FreezeBlock fb = new FreezeBlock(decs, but, pro);
        pro.add(fb);
        
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    freeze {\r\n";
        expected += "        Hans;\r\n";
        expected += "        Klaus;\r\n";
        expected += "        Compound1.name;\r\n";
        expected += "    } but (Kla*, Rof*, SSE)\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing a derived datatype succeeds.
     * @throws IOException 
     * @throws ValueDoesNotMatchTypeException 
     * @throws CSTSemanticException 
     */
    @Test
    public void writingDerivedDatatype() throws IOException, ValueDoesNotMatchTypeException, CSTSemanticException {
        DerivedDatatype dd = new DerivedDatatype("MyType", IntegerType.TYPE, pro);
        
        //Building a constraint
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, pro);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        Constraint[] cons = new Constraint[1];
        cons[0] = new Constraint(constraint, null);
        
        pro.add(dd);
        dd.setConstraints(cons);
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    typedef MyType Integer with (Bitrate > 128);\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether writing a derived datatype succeeds.
     * @throws IOException 
     * @throws ValueDoesNotMatchTypeException 
     * @throws CSTSemanticException 
     */
    @Test
    public void writingDerivedDatatypeTwoConstraints() 
        throws IOException, ValueDoesNotMatchTypeException, CSTSemanticException {
        
        DerivedDatatype dd = new DerivedDatatype("MyType", IntegerType.TYPE, pro);
        
        //Building first constraint
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, pro);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        
        DerivedDatatype bitrate2 = new DerivedDatatype("Bitrate", IntegerType.TYPE, pro);
        Variable var2 = new Variable(bitrate2.getTypeDeclaration());
        Value value2 = ValueFactory.createValue(IntegerType.TYPE, "1024");
        ConstantValue consValue2 = new ConstantValue(value2);
        OCLFeatureCall constraint2 = new OCLFeatureCall(var2, IntegerType.LESS_INTEGER_INTEGER.getName(), consValue2);
        
        
        Constraint[] cons = new Constraint[2];
        cons[0] = new Constraint(constraint, pro);
        cons[1] = new Constraint(constraint2, pro);
        
        pro.add(dd);
        dd.setConstraints(cons);
        pro.accept(writer);
        
        String expected = "project Name {\r\n\r\n";
        expected += "    typedef MyType Integer with (Bitrate > 128, Bitrate < 1024);\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    
    /*
     * TODO: luederm - complete the test.
     *
     *
     * DataType visitor 167 nullpointer exc.
     */
    /**
     * Tests whether writing a reference succeeds.
     * @throws ValueDoesNotMatchTypeException 
     * @throws IOException 
     */
    @Test 
    public void testWritingReferences() throws ValueDoesNotMatchTypeException, IOException {
        
        DecisionVariableDeclaration integ = new DecisionVariableDeclaration("oneInteger", IntegerType.TYPE, pro);
        Reference refType = new Reference("Reference_of_Int", IntegerType.TYPE, pro);
        DecisionVariableDeclaration ref = new DecisionVariableDeclaration("oneReference", refType, pro);
        
        integ.setValue("5");
        
        pro.add(integ);
        pro.add(refType);
        pro.add(ref);
        pro.accept(writer);
        
        String expected = "project " + pro.getName() + " {\r\n\r\n";
        expected += "    Integer oneInteger = 5;\r\n";
        expected += "    refTo(Integer) oneReference;\r\n";
        expected += "}\r\n";
        
        writer.flush();
        Assert.assertEquals(expected, strWriter.toString());
    }
    
    /**
     * Tests whether qualified names are used if they are needed.
     * This test will create two projects whith one variable, having exactly the same name and import botch projects
     * in {@link #pro}. Afterwards a constraint is created including both variables and {@link #pro} is saved usind the
     * {@link IVMLWriter}.
     */
    @Test
    @Ignore
    public void testWriteQualifiedNames() {
        // Create imported projects and their declarations
        DecisionVariableDeclaration var1 = createIdenticalVariable("predecessor1");
        DecisionVariableDeclaration var2 = createIdenticalVariable("predecessor2");
                
        // Create main project (including a constraint using both variables)
        Variable cstVar1 = new Variable(var1);
        Variable cstVar2 = new Variable(var2);
        OCLFeatureCall call = new OCLFeatureCall(cstVar1, OclKeyWords.EQUALS, cstVar2);
        Constraint constraint = new Constraint(pro);
        pro.add(constraint);
        try {
            constraint.setConsSyntax(call);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        // Check whether the project can be used for testing 
        ProjectTestUtilities.validateProject(pro);
        
        // Save contents of main project into a String
        pro.accept(writer);
        String result = strWriter.toString();
        String expectedConstraint = var1.getQualifiedName() + " " + OclKeyWords.EQUALS + " " + var2.getQualifiedName();
        int pos = result.indexOf(expectedConstraint);
        boolean found = pos >= 0;
        Assert.assertTrue("Error: Expected constraint not found, maybe because qualified names are not used.", found);
    }

    /**
     * Helping method of {@link #testWriteQualifiedNames()} for creating a variable in a new project.
     * All variables should have the same name to check the usage of qualified names.
     * @param projectName The name of the (imported) project to create.
     * @return The {@link DecisionVariableDeclaration} of the newly created variable.
     */
    private DecisionVariableDeclaration createIdenticalVariable(String projectName) {
        Project predecessor = new Project(projectName);
        DecisionVariableDeclaration var = new DecisionVariableDeclaration("variable", IntegerType.TYPE, predecessor);
        predecessor.add(var);
        ProjectImport imp = new ProjectImport(predecessor.getName(), null);
        try {
            imp.setResolved(predecessor);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        pro.addImport(imp);
        return var;
    }

}
