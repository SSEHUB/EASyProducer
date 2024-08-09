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

    /**
     * Creates a default formatter with line length 20 for Java.
     * 
     * @return the formatter
     */
    private ContentFormatter createJavaFormatter() {
        return createJavaFormatter(20, null);
    }
    
    /**
     * Creates a customizable formatter for testing.
     * 
     * @param lineLength the line length
     * @param profile the profile
     * @return the formatter
     */
    private ContentFormatter createJavaFormatter(int lineLength, String profile) {
        ContentFormatter formatter = new ContentFormatter();
        FormattingConfiguration fConf = new FormattingConfiguration();
        fConf.setLineEnding("\n");
        fConf.setLineLength(lineLength);
        fConf.setProfile(null == profile ? "Java" : profile);
        fConf.setProfileArgument("javadocIndent", " * "); // the default value, just for testing
        formatter.setFormattingConfiguration(fConf);
        IndentationConfiguration iConf = new IndentationConfiguration(4);
        formatter.setIndentationConfiguration(iConf);
        return formatter;
    }
    
    /**
     * Tests basic formatting/indentation.
     */
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
            + "    public static\n"
            + "        void main(String[]\n"
            + "        args) {\n"
            + "    }\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    /**
     * Tests JavaDoc formatting/indentation.
     */
    @Test
    public void testContentFormatterJavadoc() {
        ContentFormatter formatter = createJavaFormatter(21, null);
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
            + " * This is a rather\n"
            + " * long text for this\n"
            + " * formatter.\n"
            + " */\n"
            + "public class Test {\n"
            + "    public static\n"
            + "        void main(String[]\n"
            + "        args) {\n"
            + "    }\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }
    
    /**
     * Tests JavaDoc indented formatting/indentation.
     */
    @Test
    public void testContentFormatterJavadocIndented() {
        ContentFormatter formatter = createJavaFormatter(28, null);
        String test = 
              "    /**\n"
            + "     * This is a rather long text for this formatter and it goes on here.\n"
            + "     */\n"
            + "    public class Test {\n"
            + "        public static void main(String[] args) {\n"
            + "        }\n"
            + "    }\n";
        String res = formatter.format(test);
        String expected = 
              "    /**\n"
            + "     * This is a rather\n"
            + "     * long text for this\n"
            + "     * formatter and it goes on\n"
            + "     * here.\n"
            + "     */\n"
            + "    public class Test {\n"
            + "        public static void\n"
            + "            main(String[] args) {\n"
            + "        }\n"
            + "    }\n";
        Assert.assertEquals(expected, res);
    }

    /**
     * Tests line-end comment formatting/indentation.
     */
    @Test
    public void testContentFormatterComment() {
        ContentFormatter formatter = createJavaFormatter(21, null);
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
              "// This is a rather\n"
            + "// long text for this\n"
            + "// formatter.\n"
            + "public class Test {\n"
            + "    public static\n"
            + "        void main(String[]\n"
            + "        args) {\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
        
        res = formatter.format("\n");
        Assert.assertEquals("\n", res);
        res = formatter.format("   \n");
        Assert.assertEquals(null, res);
    }

    /**
     * Tests string argument method formatting/indentation.
     */
    @Test
    public void testContentFormatterStringArg() {
        ContentFormatter formatter = createJavaFormatter(21, null);
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
        String expected = 
              "// This is a rather\n"
            + "// long text for this\n"
            + "// formatter.\n"
            + "public class Test {\n"
            + "    public static\n"
            + "        void main(String[]\n"
            + "        args) {\n"
            + "        println(\n"
            + "            \"http://aaa.bbb.ccc\");\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    /**
     * Tests line-end comment and string argument formatting/indentation.
     */
    @Test
    public void testContentFormatterStringArg2() {
        ContentFormatter formatter = createJavaFormatter(25, null);
        String test = 
              "// This is a rather long text for this formatter.\n"
            + "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "        out.println(\"http://aaa.bbb.ccc\");\n"
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
            + "        out.println(\n"
            + "            \"http://aaa.bbb.ccc\");\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    /**
     * Tests string chained arguments method formatting/indentation.
     */
    @Test
    public void testContentFormatterChainedExpression() {
        ContentFormatter formatter = createJavaFormatter(21, null);
        String test = 
            "public class Test {\n"
            + "    public static void main(String[] args) {\n"
            + "        Data.createBuilder().setValue(5).setArg(7).build();\n"
            + "    }\n"
            + "\n"
            + "    \n"
            + "}\n";
        String res = formatter.format(test);
        String expected = 
            "public class Test {\n"
            + "    public static\n"
            + "        void main(String[]\n"
            + "        args) {\n"
            + "        Data.\n"
            + "            createBuilder().\n"
            + "            setValue(5).setArg(\n"
            + "            7).build();\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }

    /*@Test
    public void test() {
        ContentFormatter formatter = createJavaFormatter(120, "JAVA-outDoc");
        String s = "";        
        System.out.print("1        ");
        for (int i = 1; i <= 12; i++) {
            System.out.print("1         ");    
        }
        System.out.println();
        String res = formatter.format(s);
        System.out.println(res);
    }*/

}
