/*
 * Copyright 2009-2023 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Template tests.
 * 
 * @author Holger Eichelberger
 */
public class TemplateTest {

    /**
     * Tests annotations of a "def".
     */
    @Test
    public void testDefAnnotations() {
        Def def = new Def();
        Assert.assertEquals(0, def.getAnnotationCount());
        try {
            def.getAnnotation(0);
            Assert.fail("no exception");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
        ArrayList<String> annotations = new ArrayList<String>();
        annotations.add("override");
        def.setAnnotations(annotations);
        Assert.assertEquals(1, def.getAnnotationCount());
        Assert.assertEquals(annotations.get(0), def.getAnnotation(0));
        try {
            def.getAnnotation(1);
            Assert.fail("no exception");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

}
