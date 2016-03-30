package net.ssehub.easy.instantiation.core.model.artifactmodel;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.DOMException;

import net.ssehub.easy.instantiation.core.model.AbstractTest;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.DefaultXmlFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlAttribute;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlElement;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlFileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Load a xml-File, call the test-Methods for renaming, deleting, inserting etc. and
 * check whether these operations are working.
 *
 * Moreover we should take a look at the file itself, create new ones,
 * compare them, modify them, compare them again etc.
 * 
 * In the current state the testcase will create a copy from every testfile.
 * The testcases are operating on the copied files.
 * When the testcases are finished the copies will be deleted.
 * If the XmlFileArtifactTest is running again the testfiles are getting copied again in
 * intention to call the important testcases on them again etc.
 *
 * @author Nowatzki
 * @author Pastuschek
 *
 */
public class XmlFileArtifactTest extends AbstractTest {

    private static String workingDir = "";
    private static XmlFileArtifact artifact;
    private static XmlFileArtifact artifactCopy;
    
    @SuppressWarnings("unused")
    private static XmlFileArtifact artifactCopyForIndentation;   
    private static XmlFileArtifact artifactSpringFragment;
    private static XmlFileArtifact artifactSpringFragmentCopy;
    private static XmlFileArtifact artifactMapperFragment;
    private static XmlFileArtifact artifactMapperFragmentCopy;
    private static XmlFileArtifact artifactXsdFragment;
    private static XmlFileArtifact artifactXsdFragmentCopy;
    
    @SuppressWarnings("unused")
    private static XmlFileArtifact artifactMenubar;
    private static XmlFileArtifact artifactMenubarCopy;
    
    private static DefaultXmlFileArtifactCreator creator;
    private static ArtifactModel model;
    
    private static String invalidName = "1$/]!";
    private static String mapperDir = "";
    private static String springDir = "";
    private static String indentDir = "";
    private static String xsdDir = "";
    private static String menubarDir = "";
    
    private static String newWorkingDir = "";
    private static String newMapperWorkingDir = ""; 
    private static String newSpringWorkingDir = "";
    private static String newIndentDir = "";
    private static String newXsdDir = "";
    private static String newMenubarDir = "";

    private static boolean used = false;
    
    /**
     * Load Test-files, check whether rootelements are existing
     * and initiate copying of testfiles.
     */
    @BeforeClass
    public static final void setUpBeforeClass() {
        creator = new DefaultXmlFileArtifactCreator();
        try {
            
            //Set path to testfile
            File testDataDir = determineTestDataDir();
            workingDir = testDataDir.getAbsolutePath();
            model = ArtifactFactory.createArtifactModel(testDataDir);
            mapperDir = workingDir + File.separator + "mapperfragment.xml";
            springDir = workingDir + File.separator + "sieSpringConfigGeneric.xml";
            xsdDir = workingDir + File.separator + "xsd.xml";
            menubarDir = workingDir + File.separator + "menubar.xml";
            workingDir = workingDir + File.separator + "XmlFile.xml";
            indentDir = workingDir;
            
            //Check whether rootelement is referenced for all testartifacts.
            artifact = (XmlFileArtifact) creator.createArtifactInstance(
                new File(workingDir), model);
            if (artifact.getRootElement() == null) {
                Assert.fail();
            }
   
            artifactMapperFragment = (XmlFileArtifact) creator.createArtifactInstance(
                new File(mapperDir), model);
            if (artifactMapperFragment.getRootElement() == null) {
                Assert.fail("Rootelement of testartifact not found!");
            }
 
            artifactSpringFragment = (XmlFileArtifact) creator.createArtifactInstance(
                new File(springDir), model);
            if (artifactSpringFragment.getRootElement() == null) {
                Assert.fail("Rootelement of testartifact not found!");
            }
            
            artifactXsdFragment = (XmlFileArtifact) creator.createArtifactInstance(
                new File(xsdDir), model);
            if (artifactXsdFragment.getRootElement() == null) {
                Assert.fail("Rootelement of testartifact not found!");
            }
            
            artifactMenubar = (XmlFileArtifact) creator.createArtifactInstance(
                new File(menubarDir), model);
            if (artifactMapperFragment.getRootElement() == null) {
                Assert.fail("Rootelement of testartifact not found!");
            }
              
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        //initiate copying
        createCopies(workingDir, mapperDir, springDir, indentDir, xsdDir);
        createMoreCopies(menubarDir);
    }
    
    /**
     * Check whether two xml-files share the exact same content.
     * We do that by checking all attributes(amount, name/value) and elements of both files,
     * the original one and the copy.
     * Due to the fact that only the copies gets manipulated this should result
     * in an quiet easy way to compare to xml-files(amount of elements, attributes in case
     * of deletion/ names in case of renaming).
     * 
     * @param file1 First xml-file.
     * @param file2 Second xml-file.
     * @return equal true - if two files share the same content.
     *               false - if two files do not share the same content.
     */
    public static boolean compareXmlFilesManually(XmlFileArtifact file1, XmlFileArtifact file2) {
   
        boolean equal = true;
        
        switchToOriginal();
    
        List<XmlElement> firstElementList = new ArrayList<XmlElement>();
        List<XmlElement> secondElementList = new ArrayList<XmlElement>();
        List<XmlAttribute> firstAttributeList = new ArrayList<XmlAttribute>();
        List<XmlAttribute> secondAttributeList = new ArrayList<XmlAttribute>();
        
        try {
            //through all elements
            for (XmlElement element : file1.getRootElement().elements()) {
                firstElementList.add(element);
            }
            for (XmlElement element: file2.getRootElement().elements()) {
                secondElementList.add(element);
            }
            //and attributes
            for (XmlAttribute attribute : file1.getRootElement().attributes()) {
                firstAttributeList.add(attribute);
            }
            for (XmlAttribute attribute : file2.getRootElement().attributes()) {
                secondAttributeList.add(attribute);
            }

            //Now we compare
            
            //Check the amounts of attributes, elements first
            if (firstElementList.size() != secondElementList.size() || firstAttributeList.size()
                != secondAttributeList.size()) {
                equal = false;
            } //Same amount of elements and attributes
            
            for (int i = 0; i <= firstElementList.size() - 1; i++) {
       
                if (!(firstElementList.get(i).getName().toString().equals((
                    secondElementList.get(i).getName().toString())))) {
                    equal = false;
                }
            }
            for (int i = 0; i <= firstAttributeList.size() - 1; i++) {
                if (!(firstAttributeList.get(i).getName().toString().equals((
                    secondAttributeList.get(i).getName().toString())))) {
                    equal = false;
                }
            }

        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }  
        return equal;
    }
    
    /**
     * Initiate copying of testfiles.
     * 
     * @param dir The files dir which will be copied.
     * @param mapperDir The mapperfiles dir which will be copied.
     * @param springDir The springfiles dir which will be copied.
     * @param indentDir The indentation-files dir which will be copied..
     * @param xsdDir The xsd-files dir which will be copied.
     */
    public static void createCopies(String dir, String mapperDir, String springDir, String indentDir, String xsdDir) {
        
        //Erase ".xml" and append "copy.xml"
        newWorkingDir = dir.substring(0, dir.length() - 4) + "Copy.xml";
        newMapperWorkingDir = mapperDir.substring(0, mapperDir.length() - 4) + "Copy.xml";
        newSpringWorkingDir = springDir.substring(0, springDir.length() - 4) + "Copy.xml";
        newIndentDir = indentDir.substring(0, indentDir.length() - 4) + "IndentationCopy.xml";
        newXsdDir = xsdDir.substring(0, xsdDir.length() - 4) + "Copy.xml";
        
        //Create files for the copies with created directories
        File fileCopy = new File(newWorkingDir);
        File mapperFileCopy = new File(newMapperWorkingDir);
        File springFileCopy = new File(newSpringWorkingDir);
        File indentFileCopy = new File(newIndentDir);
        File xsdFileCopy = new File(newXsdDir);
        
        createArtifacts(fileCopy, mapperFileCopy, springFileCopy, indentFileCopy, xsdFileCopy);
        if (!used) {
            createMoreCopies(menubarDir);
            used = true;
        }
    }
    
    /**
     * Initiate copying of more testfiles.
     * 
     * @param menubarDir The menubarfiles dir which will be copied.
     */
    public static void createMoreCopies(String menubarDir) {
        //Erase ".xml" and append "copy.xml"
        newMenubarDir = menubarDir.substring(0, menubarDir.length() - 4) + "Copy.xml";
        
        deletemoreTestFiles(newMenubarDir);
        File menuFileCopy = new File(newMenubarDir);
        
        createMoreArtifacts(menuFileCopy);
    }
    
    /**
     * Create artifacts for copies.
     * 
     * @param fileCopy first file to copy.
     * @param mapperFileCopy second file to copy.
     * @param springFileCopy third file to copy.
     * @param indentFileCopy fourth file to copy.
     * @param xsdFileCopy fifth file to copy.
     */
    public static void createArtifacts(File fileCopy, File mapperFileCopy, File springFileCopy,
        File indentFileCopy, File xsdFileCopy) {
        
        copyArtifacts(fileCopy, mapperFileCopy, springFileCopy, indentFileCopy, xsdFileCopy);
        
        try {
            artifactCopy = (XmlFileArtifact) creator.createArtifactInstance(
                fileCopy, model);
            artifactSpringFragmentCopy = (XmlFileArtifact) creator.createArtifactInstance(
                springFileCopy, model);
            artifactMapperFragmentCopy = (XmlFileArtifact) creator.createArtifactInstance(
                mapperFileCopy, model);
            artifactCopyForIndentation = (XmlFileArtifact) creator.createArtifactInstance(
                indentFileCopy, model);
            artifactXsdFragmentCopy = (XmlFileArtifact) creator.createArtifactInstance(
                xsdFileCopy, model);
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }

    }
    
    /**
     * Create more artifacts for copies.
     * 
     * @param menuFileCopy sixth file to copy.
     */
    public static void createMoreArtifacts(File menuFileCopy) {
        copyMoreArtifacts(menuFileCopy);
        try {
            artifactMenubarCopy = (XmlFileArtifact) creator.createArtifactInstance(
                menuFileCopy, model);
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        
    }
    
    /**
     * Copy artifacts.
     * 
     * @param fileCopy first artifact to copy.
     * @param mapperFileCopy second artifact to copy.
     * @param springFileCopy third artifact to copy.
     * @param indentFileCopy fourth artifact to copy.
     * @param xsdFileCopy fifth artifact to copy.
     */
    public static void copyArtifacts(File fileCopy, File mapperFileCopy, File springFileCopy, File indentFileCopy,
        File xsdFileCopy) {
        
        File file = new File(workingDir);
        File mapperFile = new File(mapperDir);
        File springFile = new File(springDir);
        File newIndentFile = new File(indentDir);
        File xsdFile = new File(xsdDir);
        
        try {
            //Copy the testfiles
            copyFileUsingFileChannels(file, fileCopy);
            copyFileUsingFileChannels(mapperFile, mapperFileCopy);
            copyFileUsingFileChannels(springFile, springFileCopy);
            copyFileUsingFileChannels(newIndentFile, indentFileCopy);
            copyFileUsingFileChannels(xsdFile, xsdFileCopy);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }  
    }
    
    /**
     * Copy more artifacts.
     * 
     * @param menuFileCopy sixth artifact to copy.
     */
    public static void copyMoreArtifacts(File menuFileCopy) {
        
        File menubarFile = new File(menubarDir);
        
        try {
            copyFileUsingFileChannels(menubarFile, menuFileCopy);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    

    /**
     * Copy a file using filechannels.
     * 
     * @param source The file which should be copied.
     * @param dest Here the copied file should go.
     * @throws IOException Exception.
     */
    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
   
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            closeQuietly(inputChannel);
            closeQuietly(outputChannel);
        }
    }
    
    /**
     * Closes a channel quietly, i.e., without throwing exceptions.
     * 
     * @param channel the channel to be closed, may be <b>null</b>
     */
    private static void closeQuietly(FileChannel channel) {
        if (null != channel) {
            try {
                channel.close();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
    }
    
    /**
     * Test the renaming-function on elements.
     */
    @Test
    public final void testRename() {
    
        switchToOriginal();
        
        //The artifacts should share the same content in the first place
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
        
        String oldFirstElementName = "";
        Iterator<? extends FragmentArtifact> iter = artifactCopy.selectAll().
            iterator();

        XmlElement root = (XmlElement) iter.next();
        try {
            Iterator<? extends FragmentArtifact> elemIter =
                root.elements().iterator();
            XmlElement firstElement = (XmlElement) elemIter.next();

            if (!compareXmlFilesManually(artifact, artifactCopy)) {
                Assert.fail();
            }
            @SuppressWarnings("unused")
            boolean invaildNameAccepted = false;
            try {
                firstElement.rename(invalidName);
                if (firstElement.getName().toString().equals(invalidName)) {
                    Assert.fail();
                }
                if (compareXmlFilesManually(artifact, artifactCopy)) {
                    Assert.fail();
                }
            } catch (DOMException exc) {
                //Do nothing. This is to be excepted.
            }         
            //firstElement should not be named "forcedChangeForTesting" in the first place
            
            oldFirstElementName = firstElement.getName().toString();
   
            Iterator<? extends FragmentArtifact> newElemIter =
                    root.elements().iterator();
            XmlElement newFirstElement = (XmlElement) newElemIter.next();
            
            if (!newFirstElement.getName().equals(oldFirstElementName)) {
                Assert.fail();
            }
            if (newFirstElement.equals(oldFirstElementName)) {
                Assert.fail();
            }        
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     *  Basic test deletion.
     * 
     * @throws VilException Exception.
     */
    @Test
    public final void testDeletion() throws VilException {
        
        switchToOriginal();
        
        //The artifacts should share the same conctent in the first place
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));

        String elemName = "";
        String newElemName = "";
        
        Iterator<? extends FragmentArtifact> iter =
            artifactCopy.selectAll().iterator();
        
        XmlElement root = (XmlElement) iter.next();
        Iterator<? extends FragmentArtifact> elemIter = null;

        elemIter = root.elements().iterator();
        XmlElement firstElement = (XmlElement) elemIter.next();
        elemName = firstElement.getName();
        
        XmlElement nextElement = (XmlElement) elemIter.next();
        elemName = nextElement.getName();
   
        nextElement.delete();
        
        XmlElement newNextElement = (XmlElement) elemIter.next();
        newElemName = newNextElement.getName();

        Assert.assertTrue(elemName != newElemName);
        //Deletion succeeded
    }

    /**
     * Help-Method for the TearDown in oder to clear
     * the workspace after this Test-Case is finished.
     *
     * @param file file which will be deleted.
     */
    public static void deleteFile(final File file) {
        if (file.isDirectory()) {
            File[] nestedFiles = file.listFiles();
            if (null != nestedFiles) {
                for (int i = 0; i < nestedFiles.length; i++) {
                    deleteFile(nestedFiles[i]);
                }
            }
        }
        file.delete();
    } 

   /**
    * Testing the ObjectRelationMapperTemplate.vtl process.
    */
    @Test
    public void objectRelationTest() {
 
        XmlFileArtifact ormArtifact = artifactMapperFragmentCopy;
        String configName = "Material";
        String configName2 = "description";
        boolean configDelete = true;
 
        int deleted = 0;
        int expectedDeletions = 1;
 
        switchToOriginal();
        
        try {
 
            Set<XmlElement> subModels = ormArtifact.selectByRegEx("edmx:.*Models");
 
            for (XmlElement subModel : subModels) {
 
                Set<XmlElement> entityTypes = subModel.selectByName("EntityType");
 
                for (XmlElement entityType : entityTypes) {
 
                    if (entityType.getAttribute("Name").getValue().equals(configName)) {
 
                        Set<XmlElement> properties = entityType.selectByName("Property");
 
                        for (XmlElement property : properties) {
 
                            if (property.getAttribute("Name").getValue().equals(configName2) && configDelete) {
 
                                property.delete();
                                deleted++;
                            }
 
                        }
 
                    }
 
                }
 
            }
 
            if (deleted != expectedDeletions) {
                Assert.fail();
            }
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
 
    }
    
    /**
     * Test the sieSpringConfigGeneric.vtl process.
     */
    @Test
    public void springTest() {
    
        String configName = "stArea.stAreaAbcStrategy";
        String configText = "configTest";
        XmlFileArtifact springArtifact = artifactSpringFragmentCopy;
        boolean configRename = false;
        int renamed = 0;
        int expectedRenames = 1;
    
        switchToOriginal();
        
        try {
            Set<XmlElement> propertyEntries = springArtifact.selectByRegEx("property");

            for (XmlElement entry : propertyEntries) {
                Set<XmlElement> varEntry = entry.selectByName("easy:varprop");
                
                for (XmlElement singleEntry : varEntry) {

                    if (singleEntry.getText().getText().equals(configName)) {
                        singleEntry.getText().setText(configText);
                    
                        if (singleEntry.getText().getText().equals(configText)) {
                            configRename = true;
                            renamed++;
                        }
                    }
                    Assert.assertTrue(renamed == expectedRenames && configRename);
                    if (!compareXmlFilesManually(artifact, artifactCopy)) {
                        Assert.fail();
                    }
                }
            }  
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        try {
            springArtifact.store();
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test for the deletion of more than one XmlElement.
     * 
     * @param elements A Set with all elements.
     * @param elemName name of the element.
     */
    public void xsdFunction(Set<XmlElement> elements, String elemName) {
    
        /* 
         * Delete elements which are named elemName
         */
    
        for (XmlElement entry : elements) {
            try {
                if (entry.getAttribute("name").getValue().equals(elemName)) {
                    entry.delete();
                }
            } catch (VilException e1) {
                Assert.fail(e1.getMessage());
            } 
        }
    }
    
    /**
     * Test the deletion.
     */
    @Test
    public void testHeavyDeletion() {
    
        switchToOriginal();

        int elementCount = 0;
        int newElementCount = 0;
        XmlFileArtifact xsdArtifact = artifactXsdFragmentCopy;
    
        try {
            Set<XmlElement> elements = xsdArtifact.selectByPath(
                "xs:schema/xs:element/xs:complexType/xs:sequence").projectSingle().elements();
            
            elementCount = elements.size();
            
            //Call function from above to delete certain elements
            xsdFunction(elements, "client");
            xsdFunction(elements, "flagbatch");
            xsdFunction(elements, "flagbestbefore");
            xsdFunction(elements, "ean");
            
            elements = xsdArtifact.selectByPath(
                "xs:schema/xs:element/xs:complexType/xs:sequence").projectSingle().elements();
            
            newElementCount = elements.size();
            
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    
        //Check whether four elements are deleted or just the first ones
        Assert.assertTrue(elementCount == (newElementCount + 4));
    }
    

/**
     * Test DTD-handling.
     * 
     * @throws VilException 
     */
    @Test
    public void testDTD() throws VilException {
    
        switchToOriginal();
        
        File originalMenubarFile = new File(menubarDir);

        try {
            //Store the copy, thus content could be lost...
            artifactMenubarCopy.store();
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        
        File menubarFileAfter = new File(newMenubarDir);
            
        //Now check whether the artifacts share the same content
        
        try {
            assertFileEquality(menubarFileAfter, originalMenubarFile);
        } catch (IOException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
    }
    
    /**
     * Tests the creation of elements.
     */
    @Test
    public final void testElementCreation() { 
        boolean invElemFailed = false;
    
        switchToOriginal();
        
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
        
        try { //add an element and see whether the element was created.
            int size = artifactCopy.selectByName("created").size();
            XmlElement newElem = XmlElement.create(artifactCopy.getRootElement(), "created");
            
            if (newElem == null || !newElem.getName().equals("created")
                    || artifactCopy.selectByName("created").size() != size + 1) {
                Assert.fail();
            } 
            
            try { //try to add an element to a non existing root
                @SuppressWarnings("unused")
                XmlElement invNewElem = XmlElement.create(artifactCopy.getRootElement().
                    selectByName("forTestcaseOnly", true).iterator().next(), "forTestcaseOnly");
            } catch (NoSuchElementException e) {
                invElemFailed = true;
            }
            
            Assert.assertTrue(invElemFailed);
            
            if (!invElemFailed) {
                Assert.fail();
            }
            
            //try to add an element to deleted root
            try {
                
                artifactCopy.getRootElement().elements().iterator().next().delete();
                
                @SuppressWarnings("unused")
                XmlElement newElem2 = XmlElement.create(artifactCopy.getRootElement().elements().
                    iterator().next(), "created");
                
            } catch (VilException e) {
                Assert.fail(e.getMessage());
            } catch (NoSuchElementException e) {
                Assert.fail(e.getMessage());
            } catch (NullPointerException e) {
                Assert.fail(e.getMessage());
            }
            
            try {
                XmlElement.create(artifact.getRootElement(), "/(�)");
                //should never occur.
                Assert.fail();
            } catch (VilException e) {
                //expected to happen due to invalid naming.
            } 
            //Try to create an XmlElement for not existing parent
            try {
                XmlElement.create((XmlElement) null, "test");
                Assert.fail();
            } catch (VilException e) { 
                //expected to happen. Appending a child without any parent does not serve any purpose.
            }
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test the creation of attributes.
     */
    @Test
    public void testAttributeCreation() {
    
        switchToOriginal();
    
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
        
        try {
            XmlAttribute.create(artifactCopy.getRootElement(), "/$(�", "&%/$");
            //should never occur.
            Assert.fail();
        } catch (VilException e) {
            //expected to happen due to invalid naming.
        }
        
        try {
            XmlAttribute.create(artifactCopy.getRootElement(), "TestRoot", "newValue", true);
            for (XmlAttribute att : artifactCopy.getRootElement().attributes()) {
                if (att.getName().equals("TestRoot") && !att.getValue().equals("newValue")) {
                    Assert.fail();
                }
            }
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }  
        
        try {
            XmlElement newElem = XmlElement.create(artifactCopy.getRootElement(), "created");
            XmlAttribute newAtt = XmlAttribute.create(newElem, "test", "attribute");
            if (newAtt == null || !newAtt.getName().equals("test") || !newAtt.getValue().equals("attribute")
                || newElem.attributes().isEmpty()) {
                Assert.fail();
            }
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        
        try {
            XmlAttribute.create(null, "test", "value");
            Assert.fail();
        } catch (VilException e2) {
            //expected to happen due to non existing element.     
            //Try to add attributes to the root element. Root elements tend to be rather delicate.
            try {
                XmlAttribute.create(artifactCopy.getRootElement(), "TestRoot", "ValueRoot");
            } catch (VilException e) {
                Assert.fail(e.getMessage());
            }     
            //Try to overwrite existing element without permission.
            try {
                XmlAttribute.create(artifactCopy.getRootElement(), "TestRoot", "newValue", false);
                for (XmlAttribute att : artifact.getRootElement().attributes()) {
                    if (att.getName().equals("TestRoot") && att.getValue().equals("newValue")) {
                        Assert.fail();
                    }
                }
            } catch (VilException e) {
                Assert.fail(e.getMessage());
            }
            Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));
        }
    }
    
    /**
     * Test the select-by-path functionality.
     * 
     * NullPointer if delete is called on nonexisting element.
     */
    @SuppressWarnings("unused")
    @Test
    public final void testSelectByPath() {
        try {
            switchToOriginal();
            
            Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
            
            int size = artifactCopy.getRootElement().elements().size();
        
            XmlElement newElem1 =
                XmlElement.create(artifactCopy.getRootElement(), "oneCreated");
            XmlElement newElem2 =
                XmlElement.create(artifactCopy.getRootElement(), "secondCreated");
          
            Assert.assertEquals(artifactCopy.getRootElement().elements().size(), size + 2);
            
            XmlElement newElem3 =
                XmlElement.create(artifactCopy.getRootElement(), "thirdCreated");
            XmlElement newElem4 =
                XmlElement.create(artifactCopy.getRootElement(), "fourthCreated");
         
            Assert.assertEquals(artifactCopy.getRootElement().elements().size(), size + 4);
            
            Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));
            
            if (artifactCopy.getRootElement().elements().iterator().next() == null) {
                Assert.fail();
            }
            
            switchToOriginal();
            
            Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
            
            int size2 = artifactCopy.selectByPath("project").iterator().next().elements().size();
            XmlElement pathNewElem1 = 
                XmlElement.create(artifactCopy.selectByPath("project").iterator().next(), "oneCreated");
            XmlElement pathNewElem2 =
                XmlElement.create(artifactCopy.selectByPath("project").iterator().next(), "secondCreated");
            
            Assert.assertEquals(artifactCopy.selectByPath("project").iterator().next().elements().size(), size2 + 2);
            Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
    }
    
    /**
     * Specific test on deleting attributes using and not using
     * path-functionality.
     */
    @Test
    public void testDeleteAttribute() {
    
        boolean deletionSucceeded = false;
        boolean deletionSucceeded2 = false;
    
        switchToOriginal();
        
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
         
        try {

            artifactCopy.getRootElement().attributes().iterator().next().delete();

            artifactCopy.getRootElement().attributes().iterator().next().delete();
            
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        } catch (NullPointerException e) {
            deletionSucceeded = true;
            if (!deletionSucceeded) {
                Assert.fail(e.getMessage());
            }
        }
        
        try {
            while (!artifactCopy.getRootElement().attributes().isEmpty()) {
                artifactCopy.getRootElement().attributes().iterator().next().delete();
            }
            
            artifactCopy.getRootElement().attributes().iterator().next().delete();
            
            Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));
            
        } catch (VilException e1) {
            Assert.fail(e1.getMessage());
        } catch (NullPointerException e1) {
            deletionSucceeded2 = true;
            if (!deletionSucceeded2) {
                Assert.fail(e1.getMessage());
            }
        }
    }
        
    /**
     * Specific test on deleting.
     */
    @Test
    public void testDeleteElement() {
    
        switchToOriginal();
        
        @SuppressWarnings("unused")
        boolean deletionSucceed = false;
        
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
        
        try {
            int elemSize = artifactCopy.getRootElement().elements().size();
            
            artifactCopy.getRootElement().elements().iterator().next().delete();
            artifactCopy.getRootElement().elements().iterator().next().delete();
            
            int newElemSize = artifactCopy.getRootElement().elements().size();
            
            Assert.assertTrue((elemSize - 2) == newElemSize);
            
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        } catch (NullPointerException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Tests the XML path utils.
     */
    @Test
    public void testPathNormalization() {
        testPath("");
        testPath("a");
        testPath("a" + PathUtils.SEPARATOR + "b");
        testPath("a" + PathUtils.SEPARATOR + PathUtils.SEPARATOR + "b");
    }

    /**
     * Rests a single path in various combinations with (additional) separators.
     * 
     * @param path the expected path (may contain duplicated separators
     */
    private static void testPath(String path) {
        final String doubleSeparator = PathUtils.SEPARATOR + PathUtils.SEPARATOR;
        String expected = path.replace(doubleSeparator, PathUtils.SEPARATOR);
        Assert.assertEquals(expected, PathUtils.normalize(path));
        Assert.assertEquals(expected, PathUtils.normalize(PathUtils.SEPARATOR + path));
        Assert.assertEquals(expected, PathUtils.normalize(path + PathUtils.SEPARATOR));
        Assert.assertEquals(expected, PathUtils.normalize(PathUtils.SEPARATOR + path + PathUtils.SEPARATOR));
        Assert.assertEquals(expected, PathUtils.normalize(doubleSeparator + path + doubleSeparator));
    }
    
    /**
     * Test the creation, insertion of attribute in artifact.
     * We create several attributes and insert them via valid and invalid 
     * paths.
     */
    @Test
    public void testAddAttributeByPath() {
        switchToOriginal();
        try {
            int size = 0;
            int newAttSize = 0;
            boolean fail = false;
    
            //Files should equal each other in the first place
            Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
            try {
                size = artifactCopy.getRootElement().attributes().size();
                //Create an Attribute
                XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test", "test");
                
                newAttSize = artifactCopy.getRootElement().attributes().size();
                Assert.assertTrue(newAttSize == (size + 1));
            } catch (NoSuchElementException e) {
                Assert.fail(e.getMessage());
            }
            try {
                //Now try that again but with a wrong path
                switchToOriginal();
                
                size = artifactCopy.getRootElement().attributes().size();
                
                XmlAttribute.create(artifactCopy.selectByPath("bla").iterator().next(), "test", "test");
            } catch (NoSuchElementException e) {
                fail = true;
            }
            if (!fail) {
                Assert.fail();
                try {
                    //One more time with more attributes using path-functionalities
                    switchToOriginal();
                
                    size = artifactCopy.getRootElement().attributes().size();
                
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test", "test");
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test2", "test2");
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test3", "test3");
                 
                    newAttSize = artifactCopy.getRootElement().attributes().size();
                    Assert.assertTrue(newAttSize == (size + 3));
                
                    switchToOriginal();
                    size = artifactCopy.getRootElement().attributes().size();
                
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test", "test");
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test2", "test2");
                    XmlAttribute.create(artifactCopy.selectByPath("project").iterator().next(), "test3", "test3");
                
                    newAttSize = artifactCopy.getRootElement().attributes().size();

                    Assert.assertTrue(newAttSize == (size + 3));
                 
                    artifactCopy.getRootElement().attributes().iterator().next().delete();               
                    newAttSize = artifactCopy.getRootElement().attributes().size();
                    
                    Assert.assertTrue(newAttSize == (size + 3)); 
                    Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));                   
                } catch (NoSuchElementException e) {
                    Assert.fail(e.getMessage());
                }
            }
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        } catch (NullPointerException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test the creation of elements.
     */
    @Test
    public void testAddElementByPath() {

        switchToOriginal();
    
        Assert.assertTrue(compareXmlFilesManually(artifact, artifactCopy));
        
        try {
            int size0 = artifactCopy.selectByPath("nothingToFind").size();
            int size1 = artifactCopy.selectByPath("oneCreated").size();
            int size2 = artifactCopy.selectByPath("secondCreated").size();
            int size3 = artifactCopy.selectByPath("thirdCreatedTwice").size();
            
            XmlElement newElem1 = XmlElement.create(artifactCopy.getRootElement(), "oneCreated");
            XmlElement newElem2 = XmlElement.create(artifactCopy.getRootElement(), "secondCreated");
            XmlElement newElem3 = XmlElement.create(artifactCopy.getRootElement(), "thirdCreated");
            XmlElement newElem4 = XmlElement.create(artifactCopy.getRootElement(), "thirdCreated");
            
            XmlElement newElem5 = XmlElement.create(artifactCopy.getRootElement().elements().iterator().
                next(), "fourthCreated");
            XmlElement newElem6 = XmlElement.create(artifactCopy.getRootElement().elements().iterator().
                next(), "fifthCreated");
            
            if (newElem1 == null || newElem2 == null || newElem3 == null || newElem4 == null) {
                Assert.fail();
            }
            if (!artifactCopy.getRootElement().elements().includes(newElem1) || !artifactCopy.getRootElement().
                elements().includes(newElem2) || !artifactCopy.getRootElement().elements().includes(newElem3)
                || !artifactCopy.getRootElement().elements().includes(newElem4)) {
                
                Assert.fail();
            }
            
            if (newElem5 == null || newElem6 == null) {
                Assert.fail();
            }
            if ((!artifactCopy.getRootElement().elements().iterator().next().elements().includes(newElem5)
                || !artifactCopy.getRootElement().elements().iterator().next().elements().includes(newElem6))) {
                Assert.fail();
            }
            
            if (artifactCopy.selectByPath("nothingToFind").size() != size0
                && artifactCopy.selectByPath("oneCreated").size() != size1 + 1
                && artifactCopy.selectByPath("secondCreated").size() != size2 + 1
                && artifactCopy.selectByPath("thirdCreated").size() != size3 + 2) {
                Assert.fail();
            }
            
            Assert.assertFalse(compareXmlFilesManually(artifact, artifactCopy));
            
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Switch to copied/ original files, thus the changes initiated by earlier testcases
     * do not influence ongoing tests.
     */
    public static void switchToOriginal() {
        tearDownTestFiles();
        createCopies(workingDir, mapperDir, springDir, indentDir, xsdDir);
        
        if (!used) {
            createMoreCopies(menubarDir);
            used = true;
        }
    }
    
    /**
     * Delete testfiles.
     * 
     * @param dir1 Directory of the first file - XmlFileArtifact.xml
     * @param dir2 Directory of the second file - mapperfragment.xml
     * @param dir3 Directory of the third file - sieSPringConfigGeneric.xml
     * @param dir4 Directory of the fourth file - XmlFileArtifactIndentationCopy.xml
     * @param dir5 Directory of the fifth file - xsd.xml
     * 
     * which will be deleted.
     */
    public static void deleteTestFiles(String dir1, String dir2, String dir3, String dir4, String dir5) {
        deleteFile(new File(dir1));
        deleteFile(new File(dir2));
        deleteFile(new File(dir3));
        deleteFile(new File(dir4));
        deleteFile(new File(dir5));
    }
    
    /**
     * Delete more testfiles.
     * 
     * @param dir1 Directory of the sixth file - menubar.xml
     */
    public static void deletemoreTestFiles(String dir1) {
        //deleteFile(new File(dir1));
    }
    
    /**
     * Clear workspace.
     */
    @AfterClass
    public static void tearDownTestFiles() {
        deleteTestFiles(newWorkingDir, newMapperWorkingDir, newSpringWorkingDir, newIndentDir, newXsdDir);
        deletemoreTestFiles(newMenubarDir);
    }
}