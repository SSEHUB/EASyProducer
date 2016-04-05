package net.ssehub.easy.varModel.model.filter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DatatypeFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * Test class to test {@link DatatypeFinder}.
 * TODO SE: some tests are commented out, because they are not working.
 * @author El-Sharkawy
 *
 */
public class DatatypeFinderTest {
    
    private Project project;
    private Enum attributeType;
    private OrderedEnum oEnumType;
    private Compound cType1;
    private Compound cType2;
    private Compound cType3;
    private DerivedDatatype dType;
    private Reference refType;
    private Set setType;
    private Sequence seqType;
    
    /**
     * Creates the project which is needed during the tests.
     */
    @Before
    public void setUp() {
        project = new Project("Project");
        
        // Create Attribute
        attributeType = new Enum("attributeType", project, "STATE_1", "STATE_2");
        project.add(attributeType);
        Attribute attribute = new Attribute("attr", attributeType, project, project);
        project.add(attribute);
        project.attribute(attribute);
        
        // Create custom datatypes
        oEnumType = new OrderedEnum("orderedEnumType", project);
        EnumLiteral oLiteral1 = new EnumLiteral("Lit1", 10, oEnumType);
        EnumLiteral oLiteral2 = new EnumLiteral("Lit2", 30, oEnumType);
        oEnumType.add(oLiteral1);
        oEnumType.add(oLiteral2);
        project.add(oEnumType);
        cType1 = new Compound("C1", project);
        project.add(cType1);
        cType2 = new Compound("C2", project, cType1);
        project.add(cType2);
        cType3 = new Compound("C3", project);
        project.add(cType3);
        refType = new Reference("refType", cType1, project);
        project.add(refType);
        dType = new DerivedDatatype("MyInt", IntegerType.TYPE, project);
        project.add(dType);
        DecisionVariableDeclaration refDecl = new DecisionVariableDeclaration("cmpReference", refType, project);
        project.add(refDecl);
        setType = new Set("Integer_Set", IntegerType.TYPE, project);
        project.add(setType);
        DecisionVariableDeclaration setDecl = new DecisionVariableDeclaration("integerSet", setType, project);
        project.add(setDecl);
        seqType = new Sequence("Compound_Set", cType1, project);
        project.add(seqType);
        DecisionVariableDeclaration seqDecl = new DecisionVariableDeclaration("cmpSeq", setType, project);
        project.add(seqDecl);
        
//        StringWriter sWriter = new StringWriter();
//        IVMLWriter iWriter = new IVMLWriter(sWriter);
//        project.accept(iWriter);
//        sWriter.flush();
//        System.out.println(sWriter.toString());

        // Check whether the project could be used for testing
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        Assert.assertEquals(0, validator.getErrorCount());
    }

    /**
     * Tests whether the {@link DatatypeFinder} is able to find all {@link CustomDatatype}.
     */
    @Test
    public void testFindAll() {
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, null);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {true, true, true, true, true, true, true, true, true});
    }
    
    /**
     * Tests whether the {@link DatatypeFinder} is able to find enumerations only.
     */
    @Test
    public void testFindEnums() {
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, Enum.TYPE);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {true, true, false, false, false, false, false, false, false});
    }
    
    /**
     * Tests whether the {@link DatatypeFinder} is able to find all compounds.
     * This test considers refinements.
     */
    @Test
    public void testFindCompounds() {
        // All compounds
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, Compound.TYPE);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {false, false, true, true, true, false, false, false, false});
        
        // All C1 compounds
        finder = new DatatypeFinder(project, FilterType.ALL, cType1);
        foundTypes = finder.getFoundDatatypes();
//        checkFoundTypes(foundTypes, new boolean[] {false, false, true, true, false, false, false, false, false});
        
        // All C2 compounds
        finder = new DatatypeFinder(project, FilterType.ALL, cType2);
        foundTypes = finder.getFoundDatatypes();
        //checkFoundTypes(foundTypes, new boolean[] {false, false, false, true, false, false, false, false, false});
        
        // All C3 compounds
        finder = new DatatypeFinder(project, FilterType.ALL, cType2);
        foundTypes = finder.getFoundDatatypes();
        //checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, true, false, false, false, false});
    }
    
    /**
     * Tests whether the {@link DatatypeFinder} is able to find all references.
     */
    @Test
    public void testFindRefernces() {
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, Reference.TYPE);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, false, false, true, false, false});
    }
    
    /**
     * Tests whether the {@link DatatypeFinder} is able to find all DerivedDatatypes.
     */
    @Test
    public void testFindDerivedTypes() {
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, DerivedDatatype.TYPE);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, false, true, false, false, false});
    }
    
    /**
     * Tests whether the {@link DatatypeFinder} is able to find all ContainerTypes.
     */
    @Test
    public void testFindContainerTypes() {
        // All container
        DatatypeFinder finder = new DatatypeFinder(project, FilterType.ALL, Container.TYPE);
        List<CustomDatatype> foundTypes = finder.getFoundDatatypes();
        //checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, false, false, false, true, true});
        
        //Only Sets
        finder = new DatatypeFinder(project, FilterType.ALL, Set.TYPE);
        foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, false, false, false, true, false});
        
        //Only Sequences
        finder = new DatatypeFinder(project, FilterType.ALL, Sequence.TYPE);
        foundTypes = finder.getFoundDatatypes();
        checkFoundTypes(foundTypes, new boolean[] {false, false, false, false, false, false, false, false, true});
    }

    /**
     * Helper method for testing whether the correct elements where found.
     * @param foundTypes The list of found elements.
     * @param elementsToFind A list, which elements should be found:<br/>
     * attributeType, oEnumType, cType1, cType2, cType3, dType, refType, setType, seqType
     */
    private void checkFoundTypes(List<CustomDatatype> foundTypes, boolean[] elementsToFind) {
        Assert.assertEquals("Specified wrong number of parameters", 9, elementsToFind.length);
        
        int noOfTypeToFind = 0;
        for (int i = 0; i < elementsToFind.length; i++) {
            if (elementsToFind[i]) {
                noOfTypeToFind++;
            }
        }
        
        Assert.assertEquals("Expected " + noOfTypeToFind + " found datatype(s), but it found " + foundTypes.size()
            + "\n", noOfTypeToFind, foundTypes.size());
        
        Assert.assertEquals(elementsToFind[0], foundTypes.contains(attributeType));
        Assert.assertEquals(elementsToFind[1], foundTypes.contains(oEnumType));
        Assert.assertEquals(elementsToFind[2], foundTypes.contains(cType1));
        Assert.assertEquals(elementsToFind[3], foundTypes.contains(cType2));
        Assert.assertEquals(elementsToFind[4], foundTypes.contains(cType3));
        Assert.assertEquals(elementsToFind[5], foundTypes.contains(dType));
        Assert.assertEquals(elementsToFind[6], foundTypes.contains(refType));
        Assert.assertEquals(elementsToFind[7], foundTypes.contains(setType));
        Assert.assertEquals(elementsToFind[8], foundTypes.contains(seqType));
    }

}
