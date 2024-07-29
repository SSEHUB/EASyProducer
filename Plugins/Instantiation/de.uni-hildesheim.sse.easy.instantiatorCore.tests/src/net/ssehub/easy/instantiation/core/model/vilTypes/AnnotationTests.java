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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AbstractTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Tests for characteristic annotations after JDK 17 to avoid accidentally missing information.
 * 
 * @author Holger Eichelberger
 */
public class AnnotationTests extends AbstractTest {
    
    private static final File TESTDATA_DIR = determineTestDataDir();
    
    /**
     * Writes the annotations of {@code cls}.
     * 
     * @param out the stream to write to
     * @param cls the class to write
     */
    private void writeAnnotations(PrintStream out, Class<?> cls) {
        out.print(cls.getName());
        writeAnnotations(out, cls.getAnnotations(), "");
        
        Field[] fields = cls.getDeclaredFields();
        Arrays.sort(fields, 
            (f1, f2) -> f1.getName().compareTo(f2.getName()));
        for (Field f : fields) {
            out.print(" - " + f + "\r\n"); // even out win/linux -> comparison
            writeAnnotations(out, f.getAnnotations(), "  ");
        }
        Method[] methods = cls.getDeclaredMethods();
        Arrays.sort(methods, 
            (m1, m2) -> SignatureUtils.getJavaSignature(m1).compareTo(SignatureUtils.getJavaSignature(m2))); 
        for (Method m : methods) {
            if (!m.isBridge()) { // JDK 17 bridge defaults
                out.print(" - " + m + "\r\n"); // even out win/linux -> comparison
                writeAnnotations(out, m.getAnnotations(), "  ");
            }
        }
    }

    /**
     * Writes the given {@code annotations}.
     * 
     * @param out the stream to write to
     * @param annotations the annotations to write
     * @param indent the leading indentation per line
     */
    private void writeAnnotations(PrintStream out, Annotation[] annotations, String indent) {
        for (Annotation a : annotations) {
            out.print("  @"); // mimick output of annotation, however field sequence changed between JDK 17 and 21
            out.print(a.annotationType().getName());
            out.print("(");

            Method[] fields = a.annotationType().getDeclaredMethods();
            Arrays.sort(fields, (f1, f2) -> f1.getName().compareTo(f2.getName()));
            boolean first = true;
            for (Method f : fields) {
                if (!first) {
                    out.print(", ");
                }
                if (!(fields.length == 1 && f.getName().equals("value"))) {
                    out.print(f.getName());
                    out.print("=");
                }
                try {
                    Object val = f.invoke(a);
                    if (val.getClass().isArray() && !(val instanceof Object[])) { // primitive array
                        Object[] tmp = new Object[Array.getLength(val)];
                        for (int i = 0;  i < tmp.length; i++) {
                            tmp[i] = Array.get(val, i);
                        }
                        val = tmp;
                    }
                    if (val instanceof String[]) {
                        String[] array = (String[]) val;
                        for (int i = 0; i < array.length; i++) {
                            array[i] = "\"" + array[i] + "\"";
                        }
                        out.print("{");
                        out.print(String.join(",", array));
                        out.print("}");
                    } else if (val instanceof Object[]) {
                        out.print(Arrays.toString((Object[]) val));
                    } else {
                        if (val instanceof String) {
                            val = "\"" + val + "\"";
                        }
                        out.print(val);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                }
                first = false;
            }
            out.print(")\r\n"); // even out win/linux -> comparison
        }
    }
    
    /**
     * Tests for annotations in the testdata directory.
     */
    @Test
    public void testAnnotations() {
        org.junit.Assume.assumeTrue(System.getProperty("os.name").startsWith("Windows")); // comparison fails on linux
        
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(test);
        writeAnnotations(out, Collection.class);
        writeAnnotations(out, Set.class);
        writeAnnotations(out, Sequence.class);
        File specFile = new File(TESTDATA_DIR, "annotations.spec");
        try {
            String spec = FileUtils.readFileToString(specFile, Charset.defaultCharset());
            Assert.assertEquals(spec.trim(), test.toString().trim());
        } catch (IOException e) {
            Assert.fail("Cannot read test specification " + specFile);
        }
    }

}
