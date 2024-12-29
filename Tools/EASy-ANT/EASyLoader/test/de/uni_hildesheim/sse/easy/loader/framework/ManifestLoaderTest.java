/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;

import de.uni_hildesheim.sse.easy.loader.InitType;
import de.uni_hildesheim.sse.easy.loader.ManifestLoader;
import de.uni_hildesheim.sse.easy.loader.StartupInfo;
import org.junit.Assert;

/**
 * Tests {@link ManifestLoader}.
 * 
 * @author Holger Eichelberger
 */
public class ManifestLoaderTest {
    
    /**
     * Tests {@link ManifestLoader}.
     * 
     * @throws IOException shall not occur
     * @throws ParserConfigurationException shall not occur
     */
    @Test
    public void testManifestLoader() throws IOException, ParserConfigurationException {
        List<StartupInfo> mfInfos = ManifestLoader.loadManifests(true, null);
        System.out.println(mfInfos);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File mfFile = new File("testResources/activator/" + ManifestLoader.MF_PATH);
        StartupInfo mfInfo = ManifestLoader.loadManifest(mfFile.toURI().toURL(), builder, false);
        Assert.assertEquals(InitType.ACTIVATOR, mfInfo.getType());
        Assert.assertEquals("de.uni_hildesheim.sse.ui.Activator", mfInfo.getClassName());
        
        mfFile = new File("testResources/service/" + ManifestLoader.MF_PATH);
        mfInfo = ManifestLoader.loadManifest(mfFile.toURI().toURL(), builder, false);
        Assert.assertEquals(InitType.DS, mfInfo.getType());
        Assert.assertEquals("net.ssehub.easy.instantiation.lxc.Registration", mfInfo.getClassName());
    }
    
    // TODO sort startup

}
