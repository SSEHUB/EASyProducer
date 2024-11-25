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
package net.ssehub.easy.instantiation.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeToStringWriter;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeArtifact;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeTypeSpecification;

/**
 * Tests specific methods of the Java Code Artifact implementation (potentially) not covered by VIL tests.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTests {

    /**
     * Tests {@link JavaCodeTypeSpecification#parseGenerics(String)}.
     */
    @Test
    public void testParseGenerics() {
        JavaCodeArtifact art = new JavaCodeArtifact();
        JavaCodeClass cls = art.addClass("MyClass");
        
        Assert.assertNull(JavaCodeTypeSpecification.parseGenerics("", cls));
        Assert.assertNull(JavaCodeTypeSpecification.parseGenerics("int", cls));

        List<JavaCodeTypeSpecification> gen = JavaCodeTypeSpecification.parseGenerics("List<Integer>", cls);
        Assert.assertNotNull(gen);
        Assert.assertArrayEquals(new String[] {"Integer"}, toArray(gen));

        gen = JavaCodeTypeSpecification.parseGenerics("Map<Integer, Long>", cls);
        Assert.assertNotNull(gen);
        Assert.assertArrayEquals(new String[] {"Integer", "Long"}, toArray(gen));

        gen = JavaCodeTypeSpecification.parseGenerics("Map<String, MyData<Integer, Long>>", cls);
        Assert.assertNotNull(gen);
        Assert.assertArrayEquals(new String[] {"String", "MyData<Integer, Long>"}, toArray(gen));

        gen = JavaCodeTypeSpecification.parseGenerics("Map<MyData<Integer, Long>, String>", cls);
        Assert.assertNotNull(gen);
        Assert.assertArrayEquals(new String[] {"MyData<Integer, Long>", "String"}, toArray(gen));
    }
    
    private static String[] toArray(List<JavaCodeTypeSpecification> specs) {
        CodeToStringWriter writer = new CodeToStringWriter();
        return specs
            .stream()
            .map(t -> {
                t.store(writer); 
                return writer.getString();
            }).toArray(String[]::new);
    }

    /**
     * Tests {@link JavaCodeTypeSpecification#isVoid(JavaCodeTypeSpecification)}.
     */
    @Test
    public void testJavaTypeNull() {
        Assert.assertFalse(JavaCodeTypeSpecification.isVoid(null));
        Assert.assertTrue(JavaCodeTypeSpecification.isVoid(JavaCodeTypeSpecification.VOID));
    }

}
