package test.de.uni_hildesheim.sse;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.CompositeCompound;
import de.uni_hildesheim.sse.Datatype;
import de.uni_hildesheim.sse.IVML;
import de.uni_hildesheim.sse.Leaf;
import de.uni_hildesheim.sse.Parser;
import de.uni_hildesheim.sse.ReadHIS;
import de.uni_hildesheim.sse.Visit;


/**
 * Classfor test cases.<br/>
 * @author Phani S
 * @since 09.05.2012
 */
public class SampleTest {

    /**
     * This Method allows to test if an output file is created when reading IVML.<br/>
     */
    @Test
    public void testGetFile() {

        Parser m = new Parser();
        
        IVML obIVML = new IVML();

        // Test pre condition: f should be null
        Assert.assertNull(m.getF());

        // Now the change/action
        m.getFile("test.xml", "his", "ivml");
      
        // Test post condition: file must not be null
        Assert.assertNotNull(m.getF());
       
       
      
       
        // fail("Not yet implemented");
    }
    
    /*@Test
    public void testIVMLfilecr() {
    
        IVML obIVML = new IVML();
        obIVML.openProject();
        
        Assert.assertEquals(1, obIVML.projCreate() );
        //System.out.println(obIVML.projCreate());
    
    }
*/
    
    /*
     * @Test public void testComposite() { // Create Compound Compound comp1 = new Compound("cm.alu.system.contact");
     * 
     * // Pre-condition: Compound must not have any elements Assert.assertEquals(0, comp1.getEntities().size());
     * 
     * // fill the compound VariableDecl var1 = new VariableDecl("person", Datatype.String); VariableDecl var2 = new
     * VariableDecl("mailfrom", Datatype.String); comp1.addEntity(var1); comp1.addEntity(var2);
     * 
     * // Post-condition: compound must have 2 nested elements Assert.assertEquals(2, comp1.getEntities().size()); }
     */
    
  
    
    /**
     * This Method allows to test creation of compounds, adding compounds and leaves.<br/>
     */  
    @Test
    public void testComposite() {
        // Create Compound
        CompositeCompound comp1 = new CompositeCompound("cm.alu.system.contact");
        CompositeCompound comp2 = new CompositeCompound("contact");

        // Pre-condition: Compound must not have any elements
        Assert.assertEquals(0, comp1.getCompoundList().size());

        // fill the compound
        /*VariableDecl var1 = new VariableDecl("person", Datatype.String);
        VariableDecl var2 = new VariableDecl("mailfrom", Datatype.String);
        comp1.addEntity(var1);
        comp1.addEntity(var2);
        */
        
        //filling the compound
        
        Leaf lea1 = new Leaf("person", Datatype.String, "val");
        Leaf leaf2 = new Leaf("mailfrom", Datatype.String, "alumni@his.de");
       
        comp1.add(lea1);
        comp2.add(leaf2);
        comp2.add(comp1);
       
        Assert.assertEquals(1, comp1.getCompoundList().size());
        Assert.assertEquals(2, comp2.getCompoundList().size());
       
        // Post-condition: compound must have 2 nested elements
        //Assert.assertEquals(2, comp1.getEntities().size());
        
        Visit vis = new Visit();
        String nameOne = "ram";
        String nameTwo = "Siva";
        
        vis.addCompoundName(nameOne);
        Assert.assertEquals(true, vis.compoundNameAdded(nameOne));
        
        CompositeCompound compTestOne = new CompositeCompound(nameOne);
        CompositeCompound comp2TestTwo = new CompositeCompound(nameTwo);
        
        vis.addCompound(compTestOne);
        vis.addCompound(comp2TestTwo);
        
        compTestOne.add(comp2TestTwo);
       
       //vis.containsCompound(comp_test_1, name_2);
        Assert.assertEquals(true, vis.containsCompound(compTestOne, nameTwo));
        Assert.assertEquals(true, vis.containsLeaf(comp1, lea1));
    }

    /**
     * This Method allows to test the readHIS class.<br/>
     * incomplete
     */
    @Test
    public void testReadHIS() {
        String path = getClass().getResource("/test.xml").getPath();
        
        File f = new File(path);
        System.out.println(f.getAbsolutePath());
        ReadHIS reader = new ReadHIS("test.xml", "his", "ivml", f );
        //
        //Assert.assertEquals(false, reader.fileParsed());
        
        reader.readSpec();
       
                      
        
        
      
    }
    
}
    

