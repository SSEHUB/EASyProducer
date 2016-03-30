/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.producer.core.AllTests;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.internal.util.FileUtils;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;

/**
 * Tests the EASy configuration specific classes (on project level).
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTest {
    
    private static final File BASE = new File(AllTests.TESTDATA_DIR_ORIGINS, "config");
    
    private static final String OLD_SCALELOG_PATH = "src/main/easy/";
    private static final String NEW_SCALELOG_IVML_PATH = "src/productline/resources/varmodel/";
    private static final String NEW_SCALELOG_VIL_PATH = "src/productline/resources/varimpl/";
        
    /**
     * Prepares the "project" for testing.
     * 
     * @param name the name of the project
     * @return a temporary copy of the project related testing data
     * 
     * @throws IOException in case that preparation fails
     */
    private static File prepareProject(String name) throws IOException {
        File result = new File(new File(AllTests.TESTDATA_DIR_COPY, "config"), name);
        result.mkdirs();
        File src = new File(new File(BASE, name), Configuration.TOP_LEVEL_CONFIG_NAME);
        if (src.exists()) { // in case of plain!
            Utils.copyFile(src, new File(result, Configuration.TOP_LEVEL_CONFIG_NAME));
        }
        return result;
    }

    /**
     * Deletes the given "project".
     * 
     * @param project the project to be deleted
     * @throws IOException in case that deletion fails
     */
    private static void deleteProject(File project) throws IOException {
        if (project.exists()) {
            Utils.delete(project);
        }
        PersistenceUtils.closeProject(project);
    }
    
    /**
     * Normalizes a path into independent an independent path without separators at end.
     * 
     * @param path the path to be normalized
     * @return the normalized path
     */
    private static String normalizePath(String path) {
        path = FileUtils.toIndependent(path);
        while (path.endsWith(FileUtils.SEPARATOR_STRING)) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }
    
    /**
     * Asserts a path on string basis. Paths are normalized!
     * 
     * @param msg the message to be emitted in case of a failure
     * @param expected the expected value
     * @param actual the actual value
     * 
     * @see #normalizePath(String)
     */
    private static void assertPath(String msg, String expected, String actual) {
        Assert.assertEquals(msg, normalizePath(expected), normalizePath(actual));
    }

    /**
     * Asserts a path in terms of configuration. Paths are normalized!
     * 
     * @param msg the message to be emitted in case of a failure
     * @param expected the expected value
     * @param config the configuration to be tested (use {@link Configuration#DEFAULT} if <b>null</b>)
     * @param kind the path kind to be checked
     * 
     * @see #assertPath(String, String, String)
     */
    private static void assertPath(String msg, String expected, Configuration config, PathKind kind) {
        if (null == config) {
            config = Configuration.DEFAULT;
        }
        assertPath(msg, expected, config.getPath(kind));
    }
    
    /**
     * Tests the default values and changing them.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testDefaults() throws IOException {
        assertPath("default IVML", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.IVML);
        assertPath("default VIL", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.VIL);
        assertPath("default VTL", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.VTL);
        
        // test something else
        
        final String testPath = "EASy2";
        Configuration.DEFAULT.setPath(PathKind.IVML, testPath);
        Configuration.DEFAULT.setPath(PathKind.VIL, testPath);
        Configuration.DEFAULT.setPath(PathKind.VTL, testPath);

        assertPath("modified IVML", testPath, null, PathKind.IVML);
        assertPath("modified VIL", testPath, null, PathKind.VIL);
        assertPath("modified VTL", testPath, null, PathKind.VTL);

        // "reset"
        
        Configuration.DEFAULT.setPath(PathKind.IVML, PersistenceConstants.EASY_FILES_DEFAULT);
        Configuration.DEFAULT.setPath(PathKind.VIL, PersistenceConstants.EASY_FILES_DEFAULT);
        Configuration.DEFAULT.setPath(PathKind.VTL, PersistenceConstants.EASY_FILES_DEFAULT);

        assertPath("resetted IVML", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.IVML);
        assertPath("resetted VIL", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.VIL);
        assertPath("resetted VTL", PersistenceConstants.EASY_FILES_DEFAULT, null, PathKind.VTL);
    }
    
    /**
     * Tests an EASy project without configuration - shall lead to default values.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testPlain() throws IOException {
        File project = prepareProject("plain");

        Configuration config = PersistenceUtils.getConfiguration(project);
        assertPath("IVML", PersistenceConstants.EASY_FILES_DEFAULT, config, PathKind.IVML); 
        assertPath("VIL", PersistenceConstants.EASY_FILES_DEFAULT, config, PathKind.VIL); 
        assertPath("VTL", PersistenceConstants.EASY_FILES_DEFAULT, config, PathKind.VTL); 
        
        deleteProject(project);
    }

    /**
     * Tests the initial legacy case from ScaleLog.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testLegacy1() throws IOException {
        final String projectName = "legacy1";
        File original = new File(BASE, projectName);
        File project = prepareProject(projectName);
        
        Configuration config = PersistenceUtils.getConfiguration(project);
        assertPath("IVML", OLD_SCALELOG_PATH, config, PathKind.IVML); 
        assertPath("VIL", OLD_SCALELOG_PATH, config, PathKind.VIL); 
        assertPath("VTL", OLD_SCALELOG_PATH, config, PathKind.VTL); 

        // check unchanged
        Utils.assertEquals("changed", new File(original, Configuration.TOP_LEVEL_CONFIG_NAME), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);
        
        // turn to XML upon saving
        final String testPath = "EASy2";
        config.setPath(PathKind.IVML, testPath);
        config.store();

        Utils.assertEquals("XML", new File(original, "expected"), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        deleteProject(project);
    }

    /**
     * Tests the second version legacy case from ScaleLog.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testLegacy2() throws IOException {
        final String projectName = "legacy2";
        File original = new File(BASE, projectName);
        File project = prepareProject(projectName);
        
        Configuration config = PersistenceUtils.getConfiguration(project);
        assertPath("IVML", NEW_SCALELOG_IVML_PATH, config, PathKind.IVML); 
        assertPath("VIL", NEW_SCALELOG_VIL_PATH, config, PathKind.VIL); 
        // by implicit default
        assertPath("VTL", NEW_SCALELOG_VIL_PATH, config, PathKind.VTL); 

        // check unchanged
        Utils.assertEquals("changed", new File(original, Configuration.TOP_LEVEL_CONFIG_NAME), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);
        
        // force saving with same values
        config.setPath(PathKind.IVML, config.getPath(PathKind.IVML));
        config.store();

        Utils.assertEquals("XML", new File(original, "expected"), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        deleteProject(project);
    }

    /**
     * Tests XML configuration file with implicit default value.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testXML1() throws IOException {
        final String projectName = "xml1";
        File original = new File(BASE, projectName);
        File project = prepareProject(projectName);

        Configuration config = PersistenceUtils.getConfiguration(project);
        assertPath("IVML", NEW_SCALELOG_IVML_PATH, config, PathKind.IVML); 
        assertPath("VIL", NEW_SCALELOG_VIL_PATH, config, PathKind.VIL); 
        // by implicit default
        assertPath("VTL", NEW_SCALELOG_VIL_PATH, config, PathKind.VTL); 
        
        // check unchanged
        Utils.assertEquals("changed", new File(original, Configuration.TOP_LEVEL_CONFIG_NAME), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        final String testPath = "EASy2";
        config.setPath(PathKind.VTL, testPath);
        config.store();

        Utils.assertEquals("XML", new File(original, "expected"), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        deleteProject(project);
    }
    
    /**
     * Tests full XML configuration file.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testXML2() throws IOException {
        final String projectName = "xml2";
        File original = new File(BASE, projectName);
        File project = prepareProject(projectName);

        Configuration config = PersistenceUtils.getConfiguration(project);
        assertPath("IVML", NEW_SCALELOG_IVML_PATH, config, PathKind.IVML); 
        assertPath("VIL", NEW_SCALELOG_VIL_PATH, config, PathKind.VIL); 
        assertPath("VTL", NEW_SCALELOG_VIL_PATH, config, PathKind.VTL); 
        
        // check unchanged
        Utils.assertEquals("changed", new File(original, Configuration.TOP_LEVEL_CONFIG_NAME), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        final String testPath = "EASy2";
        config.setPath(PathKind.VIL, testPath);
        config.store();

        Utils.assertEquals("XML", new File(original, "expected"), 
            new File(project, Configuration.TOP_LEVEL_CONFIG_NAME), false);

        deleteProject(project);
    }

}
