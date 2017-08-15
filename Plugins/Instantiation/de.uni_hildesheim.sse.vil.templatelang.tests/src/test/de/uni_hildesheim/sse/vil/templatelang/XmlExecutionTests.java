/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.io.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;

/**
 * Implements XML artifact tests in the xml folder.
 * 
 * @author Holger Eichelberger
 */
public class XmlExecutionTests extends AbstractExecutionTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "xml");
    
    @Override
    protected File getTestFolder() {
        return DIR;
    }
    
    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name the name of the file (excluding ".trc")
     * @return the file
     */
    private final File createInputFile(String name) {
        return new File(getTestFolder(), name + ".in");
    }
    
    /**
     * Tests XML elements creation with content.
     * 
     * @throws IOException should not occur
     * @throws VilException should not occur
     */
    @Test
    public void testElementContents() throws IOException, VilException {
        assertXml("elementContents");
    }

    /**
     * Tests XML comment creation.
     * 
     * @throws IOException should not occur
     * @throws VilException should not occur
     */
    @Test
    public void testCommentContents() throws IOException, VilException {
        assertXml("commentContents");
    }

    /**
     * Tests XML comment handling from existing XML file.
     * 
     * @throws IOException should not occur
     * @throws VilException should not occur
     */
    @Test
    public void testCommentContents2() throws IOException, VilException {
        final String name = "commentContents2";
        assertXml(name, createInputFile(name));
    }

    /**
     * Asserts a VTL execution for XML file artifacts. Expecting "main" as main VTL def, no input file and no IVML
     * configuration.
     * 
     * @param name the name of the VTL file
     * @param expectedExceptions expected exception ids
     * @throws IOException in case of any I/O related problem
     * @throws VilException in case of VIL execution problems
     */
    private void assertXml(String name, int... expectedExceptions) throws IOException, VilException {
        assertXml(name, null, null, expectedExceptions);
    }

    /**
     * Asserts a VTL execution for XML file artifacts. Expecting "main" as main VTL def, no input file and no IVML
     * configuration.
     * 
     * @param name the name of the VTL file
     * @param inputFile an optional XML input file to be used as target artifact, may be <b>null</b> for none, will
     *   be copied to a temporary file
     * @param expectedExceptions expected exception ids
     * @throws IOException in case of any I/O related problem
     * @throws VilException in case of VIL execution problems
     */
    private void assertXml(String name, File inputFile, int... expectedExceptions) throws IOException, VilException {
        assertXml(name, null, inputFile, expectedExceptions);
    }

    /**
     * Asserts a VTL execution for XML file artifacts. Expecting "main" as main VTL def.
     * 
     * @param name the name of the VTL file
     * @param cfg the IVML configuration (may be <b>null</b>)
     * @param inputFile an optional XML input file to be used as target artifact, may be <b>null</b> for none, will
     *   be copied to a temporary file
     * @param expectedExceptions expected exception ids
     * @throws IOException in case of any I/O related problem
     * @throws VilException in case of VIL execution problems
     */
    private void assertXml(String name, Configuration cfg, File inputFile, int... expectedExceptions) 
        throws IOException, VilException {
        File f = new File(name + ".xml");
        f.delete();
        if (null != inputFile) {
            Assert.assertTrue("Specified input file " + inputFile.getAbsolutePath() + " does not exist", 
                inputFile.exists()); // not part of test, must exist anyway
            FileUtils.copyFile(f, inputFile);
        }
        IArtifact target = ArtifactFactory.createFileSystemArtifact(f);
        Map<String, Object> param = createParameterMap(cfg, target);
        EqualitySetup<Template> setup = new EqualitySetup<Template>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setStartElement("main");
        assertEqual(setup, expectedExceptions);
        target.store(); // else done implicitly by calling VTL
        
        String produced = file2String(f);
        Assert.assertTrue(null != produced);
        String expected = file2String(new File(getTestFolder(), name + ".xml"));
        Assert.assertTrue(null != expected);
        expected = expected.trim();
        produced = produced.trim();
        boolean eq = checkEqualsAndPrint(expected, produced);
        if (!eq) {
            Assert.assertEquals(expected, produced);
        }
        f.delete();
    }
    
}
