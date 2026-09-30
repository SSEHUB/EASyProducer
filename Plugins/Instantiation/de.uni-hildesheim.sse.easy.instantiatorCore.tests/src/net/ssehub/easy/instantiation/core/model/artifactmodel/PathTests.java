/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.artifactmodel;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import static net.ssehub.easy.instantiation.core.model.vilTypes.PseudoStringTests.*;

/**
 * Tests {@link Path}.
 * 
 * @author Holger Eichelberger
 */
public class PathTests {

    /**
     * Tests {@link Path#relativizeFolder(String)}.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testRelativizeFolderString() throws VilException  {
        ArtifactModel model = ArtifactFactory.createArtifactModel(new File(path("/a/b")));
        Path base = Path.createInstance(path("/a/b/target/gen/py"), model);
        assertFolderEquals("../../../resources/software", 
            base.relativizeFolder(path("/a/b/resources/software")));

        base = Path.createInstance(path("/a/b/"), model);
        assertFolderEquals(".", base.relativizeFolder(path("/a/b/")));

        Assert.assertTrue(base.relativizeFolder((String) null).length() > 0);
    }

    /**
     * Tests {@link Path#relativizeFolder(String)}.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testRelativizeFolderPath() throws VilException {
        ArtifactModel model = ArtifactFactory.createArtifactModel(new File(path("/a/b")));
        Path path = Path.createInstance(path("/a/b/target/gen/py"), model);
        Path dir = Path.createInstance(path("/a/b/resources/software"), model);
        assertFolderEquals(path("../../../resources/software"), path.relativizeFolder(dir));

        path = Path.createInstance(path("/a/b/"), model);
        dir = Path.createInstance(path("/a/b/"), model);
        assertFolderEquals(".", path.relativizeFolder(dir));

        Assert.assertTrue(path.relativizeFolder((Path) null).length() > 0);
    }

}
