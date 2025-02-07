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

import java.io.IOException;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Ignore;

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
        return createJavaFormatter(lineLength, profile, null);
    }
    
    /**
     * Creates a customizable formatter for testing.
     * 
     * @param lineLength the line length
     * @param profile the profile
     * @param optionConfigurer optional formatter option configurer, may be <b>null</b> for none
     * @return the formatter
     */
    private ContentFormatter createJavaFormatter(int lineLength, String profile, 
        Consumer<FormattingConfiguration> optionConfigurer) {
        ContentFormatter formatter = new ContentFormatter();
        FormattingConfiguration fConf = new FormattingConfiguration();
        fConf.setLineEnding("\n");
        fConf.setLineLength(lineLength);
        fConf.setProfile(null == profile ? "Java" : profile);
        fConf.setProfileArgument("javadocIndent", " * "); // the default value, just for testing
        if (null != optionConfigurer) {
            optionConfigurer.accept(fConf);
        }
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
            + "        void\n"
            + "        main(\n"
            + "        String[\n"
            + "        ]\n"
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
        ContentFormatter formatter = createJavaFormatter(31, null);
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
            + " * This is a rather long text\n"
            + " * for this formatter.\n"
            + " */\n"
            + "public class Test {\n"
            + "    public static void main(\n"
            + "        String[] args) {\n"
            + "    }\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }
    
    /**
     * Tests JavaDoc indented formatting/indentation.
     */
    @Test
    public void testContentFormatterJavadocIndented() {
        ContentFormatter formatter = createJavaFormatter(35, null);
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
            + "     * This is a rather long text\n"
            + "     * for this formatter and\n"
            + "     * it goes on here.\n"
            + "     */\n"
            + "    public class Test {\n"
            + "        public static void main(\n"
            + "            String[] args) {\n"
            + "        }\n"
            + "    }\n";
        Assert.assertEquals(expected, res);
    }

    /**
     * Tests line-end comment formatting/indentation.
     */
    @Test
    public void testContentFormatterComment() {
        ContentFormatter formatter = createJavaFormatter(22, null);
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
            + "// long text\n"
            + "// for this\n"
            + "// formatter.\n"
            + "public class Test {\n"
            + "    public static void\n"
            + "        main(\n"
            + "        String[]\n"
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
        ContentFormatter formatter = createJavaFormatter(31, null);
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
              "// This is a rather long text\n"
            + "// for this formatter.\n"
            + "public class Test {\n"
            + "    public static void main(\n"
            + "        String[] args) {\n"
            + "        println(\n"
            + "            \"http://aaa.bbb.c\"\n"
            + "            + \"cc\");\n"
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
        ContentFormatter formatter = createJavaFormatter(31, null);
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
              "// This is a rather long text\n"
            + "// for this formatter.\n"
            + "public class Test {\n"
            + "    public static void main(\n"
            + "        String[] args) {\n"
            + "        out.println(\n"
            + "            \"http://aaa.bbb.c\"\n"
            + "            + \"cc\");\n"
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
        ContentFormatter formatter = createJavaFormatter(31, null);
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
            + "    public static void main(\n"
            + "        String[] args) {\n"
            + "        Data.createBuilder().\n"
            + "            setValue(5).\n"
            + "            setArg(7).build(\n"
            + "            );\n"
            + "    }\n"
            + "\n"
            + "}\n";
        Assert.assertEquals(expected, res);
    }
    
    /**
     * Based on issue with line splitting.
     */
    @Test
    public void testLineSplit() {
        ContentFormatter formatter = createJavaFormatter(120, null);
        String test = "        service = new ConnectorServiceWrapper<DataItem, Object, MyConnPltfIn, MyConnPltfOut>("
            + "serviceData, conn, () -> param);";
        String res = formatter.format(test);
        String expected = "        service = new ConnectorServiceWrapper<DataItem, Object, MyConnPltfIn, MyConnPltfOut>"
            + "(serviceData, conn, () ->\n"
            + "            param);";
        Assert.assertEquals(expected, res);
    }
    
    /**
     * Based on issue with hopping over end of empty string at split point.
     */
    @Test
    public void testState() {
        ContentFormatter formatter = createJavaFormatter(120, null);
        String test = "Connector<DataItem, Object, MyConnPltfIn, MyConnPltfOut> conn = ConnectorFactory."
            + "createConnector(\"de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector\", () -> param, "
            + "createConnectorAdapter(()->service.getInPath(\"\"), ()->service.getOutPath(\"\")));";
        String res = formatter.format(test);
        String expected = "Connector<DataItem, Object, MyConnPltfIn, MyConnPltfOut> conn = ConnectorFactory."
            + "createConnector(\n"
            + "\"de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector\", () -> param, createConnectorAdapter("
            + "()->service.\n    getInPath(\"\"), ()->service.getOutPath(\"\")));";
        Assert.assertEquals(expected, res);
    }
    
    /**
     * Read directly from a file.
     * 
     * @throws IOException shall not occur
     */
    @Ignore
    @Test
    public void test() throws IOException {
        @SuppressWarnings("deprecation")
        java.util.List<String> test = FileUtils.readLines(new java.io.File("./test.txt"));
        ContentFormatter formatter = createJavaFormatter(120, null);
        for (String s : test) {
            String res = formatter.format(s);
            System.out.println(res);
        }
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
