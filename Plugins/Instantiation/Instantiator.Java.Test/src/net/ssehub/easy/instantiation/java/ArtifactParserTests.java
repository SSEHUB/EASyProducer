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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.java.codeArtifacts.IJavaCodeElement;
import net.ssehub.easy.instantiation.java.codeArtifacts.IJavaCodeImport;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeArtifact;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeMethod;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Tests the embedded Java parser in the Java code artifacts.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactParserTests extends AbstractExecutionTest<Script> {

    private static ExecutionTests tests;

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.java.testdata.home");
    }

    @Override
    protected void furtherInitialization() {
        Registration.register();
//        DefaultLibUtils.loadDefaultModels(OBSERVER, Bundle.ID);
    }

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new ExecutionTests();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (null != tests) {
            tests.cleanTemp();
            tests = null;
        }
    }
    
    /**
     * Tests the case with given {@code name} in {@code testdata/artifacts/javaParser} by executing
     * the given parsing {@code testFunc} and comparing the result with the expected output in the {@code -exp} file.
     * 
     * @param name the name of the test/file
     * @param testFunc the parsing function
     * @return the created code element
     * @throws IOException shall not occur
     */
    private IJavaCodeElement test(String name, Function<String, IJavaCodeElement> testFunc) throws IOException {
        File dir = new File(getTestDataDir(), "artifacts/javaParser");
        File inputFile = new File(dir, name + ".txt");
        String input = FileUtils.readFileToString(inputFile, Charset.defaultCharset());
        File expectedFile = new File(dir, name + "-exp.txt");
        String expected = FileUtils.readFileToString(expectedFile, Charset.defaultCharset());
        IJavaCodeElement elt = testFunc.apply(input);
        Assert.assertNotNull(elt);
        Assert.assertEquals(expected, elt.toCode());
        return elt;
    }
    
    /**
     * Wraps {@code testFunc} by a function that puts the output of {@code testFunc} into a artifact/class context 
     * and asserts the given {@code imports}.
     * 
     * @param testFunc the original test function turning the string into an artifact instance
     * @param imports the imports to validate for
     * @return the wrapped function now to be used for testing
     */
    private Function<String, IJavaCodeElement> assertImports(final Function<String, IJavaCodeElement> testFunc, 
        final String... imports) {
        return s -> {
            IJavaCodeElement elt = testFunc.apply(s);
            if (elt instanceof JavaCodeMethod) {
                JavaCodeArtifact art = new JavaCodeArtifact();
                JavaCodeClass cls = art.addClass("Test");
                cls.addMethod((JavaCodeMethod) elt);
                boolean found = imports.length == 0;
                for (IJavaCodeImport imp : art.imports()) {
                    for (String i : imports) {
                        found |= imp.getName().equals(i);
                    }
                }
                Assert.assertTrue("None of the imports " + java.util.Arrays.toString(imports) + " is listed.", found);
            }
            return elt;
        };
    }
    
    /**
     * Basic method test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodBasic() throws IOException {
        test("method-basic", s -> JavaCodeMethod.create(s));
    }

    /**
     * Method with annotation disabling parameter.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodDisable() throws IOException {
        test("method-disable", s -> JavaCodeMethod.create(s));
    }

    /**
     * Method with exception and comments for JavaDoc.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testBasicException() throws IOException {
        test("method-basic-exc", assertImports(s -> JavaCodeMethod.create(s), "java.io.IOException"));
    }

    /**
     * Classical for-loop test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodFor() throws IOException {
        test("method-for", s -> JavaCodeMethod.create(s));
    }

    /**
     * Enhanced-for-loop test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodForIter() throws IOException {
        test("method-forIter", assertImports(s -> JavaCodeMethod.create(s), "java.util.List", "java.util.Arrays.sort"));
    }

    /**
     * Do-while test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodDo() throws IOException {
        test("method-do", s -> JavaCodeMethod.create(s));
    }

    /**
     * While test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodWhile() throws IOException {
        test("method-while", s -> JavaCodeMethod.create(s));
    }
    
    /**
     * Try test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodTry() throws IOException {
        test("method-try", assertImports(s -> JavaCodeMethod.create(s), 
            "java.io.IOException", "java.io.OutputStream", "java.util.concurrent.ExecutionException"));
    }    

    /**
     * Try with resource declaration test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodTry2() throws IOException {
        test("method-try2", assertImports(s -> JavaCodeMethod.create(s), 
            "java.io.IOException", "java.io.OutputStream", "java.io.FileOutputStream"));
    }
    
    /**
     * Synchronized with parenthesis expression.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodSynchronized() throws IOException {
        test("method-sync", s -> JavaCodeMethod.create(s));
    }       
    
    /**
     * Switch statement.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodSwitch() throws IOException {
        test("method-switch", s -> JavaCodeMethod.create(s));
    }

    /**
     * Lambdas in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodLambda() throws IOException {
        test("method-lambda", s -> JavaCodeMethod.create(s));
    }

    /**
     * Super in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodSuper() throws IOException {
        test("method-super", s -> JavaCodeMethod.create(s));
    }

    /**
     * Array in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodArray() throws IOException {
        test("method-array", s -> JavaCodeMethod.create(s));
    }

    /**
     * Missing primitive types in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodTypes() throws IOException {
        test("method-types", s -> JavaCodeMethod.create(s));
    }
    
    /**
     * An unresolved attribute access.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodAttrib() throws IOException {
        test("method-attrib", s -> JavaCodeMethod.create(s));
    }    

    /**
     * String template in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodStringTemplate() throws IOException {
        test("method-stringTemplate", s -> JavaCodeMethod.create(s));
    }

    /**
     * Anonymous class in method.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMethodAnonymous() throws IOException {
        test("method-anon", s -> JavaCodeMethod.create(s));
    }

    /**
     * Basic class parsing test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testClassBasic() throws IOException {
        test("class-basic", s -> JavaCodeClass.create(s));
    }
    
    /**
     * Class with generics parsing test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testClassGenerics() throws IOException {
        test("class-generics", s -> JavaCodeClass.create(s));
    }    
    
    /**
     * Basic enum parsing test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testEnumBasic() throws IOException {
        test("enum-basic", assertImports(s -> JavaCodeClass.create(s), "java.io.Serializable"));
    }

    /**
     * Basic interface parsing test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testInterfaceBasic() throws IOException {
        test("iface-basic", s -> JavaCodeClass.create(s));
    }

    /**
     * Basic annotation parsing test.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testAnnotationBasic() throws IOException {
        test("ann-basic", s -> JavaCodeClass.create(s));
    }
    
    /**
     * Tests an int-based expression by parsing.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testExpressionArray() throws IOException {
        test("expr-int", s -> JavaCodeExpression.create(s));
    }

}
