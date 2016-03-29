/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.core;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfoSenariosTest;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfoTest;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManagerTest;
import de.uni_hildesheim.sse.easy_producer.core.persistence.ConfigurationTest;
import de.uni_hildesheim.sse.easy_producer.core.persistence.IntegrationTest;
import de.uni_hildesheim.sse.easy_producer.core.persistence.NatureHelperTest;
import de.uni_hildesheim.sse.easy_producer.core.persistence.TempDirectoryInitializer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.EASyInitializer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.velocity.VelocityInstantiator;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.reasoner.Reasoner;
import net.ssehub.easy.basics.Environment;

/**
 * Test suite: runs all test classes.
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    IntegrationTest.class,
    SPLsManagerTest.class,
    PLPInfoTest.class,
    PLPInfoSenariosTest.class,
    NatureHelperTest.class,
    ConfigurationTest.class })
public class AllTests {
    
    /**
     * Original files used for testing.
     * These files should be copied before they are used for instantiation.
     * these files must not be modified while testing.
     */
    public static final File TESTDATA_DIR_ORIGINS = determineDir("de.uni_hildesheim.sse.easy_producer.core.test"
        , "testdata");
    
    /**
     * Sub-folder of {@link #TESTDATA_DIR_ORIGINS}, where copies are stored. These files can be modified while
     * running the test cases.
     */
    public static final File TESTDATA_DIR_COPY = new File(TESTDATA_DIR_ORIGINS, "temp");
    
    public static final String PLUGIN_ID = "de.uni_hildesheim.sse.easy_producer.core.test";
    
    private static boolean initialized = false;
    
    /**
     * Determines folders, which should be used during testing.
     * @param property A system property to specify the directory from outside.
     * @param defaultFolder A folder relative to this project. Will only be used if no property was used.
     * @return A folder which can be used for testing.
     */
    private static File determineDir(String property, String defaultFolder) {
        File result;
        String externalLocation = System.getProperty(property);
        if (null == externalLocation) {
            result = new File(defaultFolder);
        } else {
            result = new File(externalLocation);
        }
        return result;
    }

    /**
     * Copies the test files into {@link #TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        TempDirectoryInitializer.INSTANCE.initTempFiles();
        
        // Facilitates plain java testing, registers bundles manually if not executed as a plug-in test
        if (!Environment.runsInEclipse() && !initialized) {
            initialized = true;
            EASyInitializer.setInitializer();
            ReasonerFrontend.getInstance().getRegistry().register(new Reasoner());
            BuiltIn.initialize();
            TypeRegistry.DEFAULT.register(VelocityInstantiator.class);
        }
    }
}
