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
package net.ssehub.easy.instantiation.core.model.templateModel;

import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;

/**
 * Tests {@link ContentFormatter}.
 * 
 * @author Holger Eichelberger
 */
public class ContentFormatterTest {
    
    private ContentFormatter createJavaFormatter() {
        ContentFormatter formatter = new ContentFormatter();
        FormattingConfiguration fConf = new FormattingConfiguration();
        fConf.setLineEnding("\n");
        fConf.setLineLength(20);
        fConf.setProfile("Java");
        formatter.setFormattingConfiguration(fConf);
        IndentationConfiguration iConf = new IndentationConfiguration(4);
        formatter.setIndentationConfiguration(iConf);
        return formatter;
    }
    
    @Test
    public void testContentFormatter() {
        ContentFormatter formatter = createJavaFormatter();
        String test = 
              "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "    }\n"
            + "}\n";
        String res = formatter.format(test);
        String expected = 
            "public class Test {\n"
            + "    public static void\n"
            + "        main(String[] args) {\n"
            + "    }\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    @Test
    public void testContentFormatterJavadoc() {
        ContentFormatter formatter = createJavaFormatter();
        String test = 
              "/**\n"
            + " * This is a rather long text for this formatter.\n"
            + " */\n"
            + "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "    }\n"
            + "}\n";
        String res = formatter.format(test);
        String expected = 
              "/**\n"
            + " * This is a rather long\n"
            + " * text for this formatter.\n"
            + " */\n"
            + "public class Test {\n"
            + "    public static void\n"
            + "        main(String[] args) {\n"
            + "    }\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    @Test
    public void testContentFormatterComment() {
        ContentFormatter formatter = createJavaFormatter();
        String test = 
              "// This is a rather long text for this formatter.\n"
            + "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "    }\n"
            + "\n"
            + "    \n"
            + "}\n";
        String res = formatter.format(test);
        String expected = 
              "// This is a rather long\n"
            + "// text for this formatter.\n"
            + "public class Test {\n"
            + "    public static void\n"
            + "        main(String[] args) {\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
        
        res = formatter.format("\n");
        Assert.assertEquals("\n", res);
        res = formatter.format("   \n");
        Assert.assertEquals(null, res);
    }

    
    @Test
    public void testContentFormatterStringArg() {
        ContentFormatter formatter = createJavaFormatter();
        String test = 
              "// This is a rather long text for this formatter.\n"
            + "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "        println(\"http://aaa.bbb.ccc\");\n"
            + "    }\n"
            + "\n"
            + "    \n"
            + "}\n";
        String res = formatter.format(test);
        System.out.println(res);
        String expected = 
              "// This is a rather long\n"
            + "// text for this formatter.\n"
            + "public class Test {\n"
            + "    public static void\n"
            + "        main(String[] args) {\n"
            + "        println(\"http\"\n"
            + "            + \"://aaa.bbb.ccc\");\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

}
