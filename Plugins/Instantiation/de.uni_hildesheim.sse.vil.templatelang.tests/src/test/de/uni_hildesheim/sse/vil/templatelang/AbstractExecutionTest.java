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
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.varModel.varModel.testSupport.DefaultConfiguration;

/**
 * Specific support for execution tests.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractExecutionTest extends AbstractTest {

    /**
     * Creates a file object relative to {@link #getTestFolder()} (not a file).
     * 
     * @param name the name of the file (excluding ".trc")
     * @return the file
     */
    protected final File createTraceFile(String name) {
        return new File(getTestFolder(), name + ".trc");
    }
    
    /**
     * Creates a default parameter map.
     * 
     * @param config the configuration (use empty if <b>null</b>)
     * @param target the target artifact (use default if <b>null</b>)
     * @return the parameter map
     */
    protected static Map<String, Object> createParameterMap(Configuration config, IArtifact target) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (null == config) {
            net.ssehub.easy.varModel.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
            Assert.assertNotNull("creating default IVML configuration failed", cfg);
            config = new Configuration(cfg);
        }
        if (null == target) {
            try {
                File f = new File("test.texts"); // TODO -> temp??
                f.deleteOnExit();
                target = ArtifactFactory.createFileSystemArtifact(f); // shall be FileArtifact!!!
            } catch (VilException e) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
        }
        param.put(TemplateLangExecution.PARAM_CONFIG, config);
        param.put(TemplateLangExecution.PARAM_TARGET, target);
        param.put(TemplateLangExecution.PARAM_CONFIG_SURE, config);
        param.put(TemplateLangExecution.PARAM_TARGET_SURE, target);
        return param;
    }
    
}
