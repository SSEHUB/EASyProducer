package net.ssehub.easy.instantiation.core.model.expressions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.AbstractTest;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.BuiltIn;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Tests common functionality of {@link StringReplacer}.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacerTest extends AbstractTest {

    protected static final Boolean BOOLEAN_VALUE = Boolean.TRUE;
    protected static final int INT_VALUE = 1234;
    protected static final String STRING_VALUE = "test";

    private static RuntimeEnv environment;
    private static IExpressionParser parser;
    private static IExpressionVisitor evaluator;
    
    /**
     * Sets up the environment.
     */
    @BeforeClass
    public static void startUp() {
        BuiltIn.initialize();
        try {
            environment = new RuntimeEnv();
            environment.switchContext(new PseudoModel());
            VarDecl test = new VarDecl("b", TypeRegistry.booleanType());
            environment.addValue(test, BOOLEAN_VALUE);
            test = new VarDecl("i", TypeRegistry.integerType());
            environment.addValue(test, INT_VALUE);
            test = new VarDecl("s", TypeRegistry.stringType());
            environment.addValue(test, STRING_VALUE);
            test = new VarDecl("test", TypeRegistry.stringType());
            environment.addValue(test, STRING_VALUE);
            
            parser = new ExpressionParser();
            evaluator = new ExpressionVisitor();

        } catch (VilException e) {
            Assert.fail("cannot create environment: " + e.getMessage());
        }
    }
    
    /**
     * Tests string replacements which actually do not cause a replacement.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testNoReplacements() throws VilException {
        // no need for expression parser / evaluator
        Assert.assertEquals("", StringReplacer.substitute("", environment, null, null));
        Assert.assertEquals("abba", StringReplacer.substitute("abba", environment, null, null));
    }

    /**
     * Tests value replacements which cause a replacement.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testValueReplacements() throws VilException {
        // no need for expression parser / evaluator
        Assert.assertEquals(String.valueOf(INT_VALUE), 
            StringReplacer.substitute("$i", environment, null, null));
        Assert.assertEquals(String.valueOf(BOOLEAN_VALUE), 
            StringReplacer.substitute("$b", environment, null, null));
        Assert.assertEquals(STRING_VALUE, 
            StringReplacer.substitute("$s", environment, null, null));

        Assert.assertEquals(STRING_VALUE + "=" + STRING_VALUE, 
            StringReplacer.substitute("$s=$s", environment, null, null));
        Assert.assertEquals(STRING_VALUE + " = " + STRING_VALUE, 
            StringReplacer.substitute("$s = $s", environment, null, null));

        String postfix = "/src";
        Assert.assertEquals(STRING_VALUE + postfix, 
            StringReplacer.substitute("$s" + postfix, environment, null, null));
        String prefix = "/";
        Assert.assertEquals(prefix + STRING_VALUE, 
            StringReplacer.substitute(prefix + "$s" , environment, null, null));
        Assert.assertEquals(prefix + STRING_VALUE + postfix, 
            StringReplacer.substitute(prefix + "$s" + postfix, environment, null, null));
    }
    
    
    /**
     * Tests expression replacements which cause a replacement.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testExpressionReplacements() throws VilException {

        final String var = "<test>";
        // failure - does it terminate?
        assertResult("${test", "${test");
        // variable replacement
        assertResult(var, "${test}");
        assertResult(var + "/test", "${test}/test");
        assertResult("test/" + var, "test/${test}");
        assertResult("test/" + var + "/test", "test/${test}/test");
        // expression replacement
        assertResult("test/func(<i>,<b>)", "test/${func(i, b)}");
        assertResult("test/func(<i>,<b>)/func2(<i>,<b>)", "test/${func(i, b)}/${func2(i, b)}");
        assertResult("test/func(<i>,<b>)/func2(<b>,<i>)/test", "test/${func(i, b)}/${func2(b, i)}/test");
        //assertResult("test/CALL/CALL/test", "test/${func(${test}, $test)}/${func2($i, $s)}/test");
    }
    
    /**
     * Asserts parse results.
     * 
     * @param expected the expected parse result (variables, expressions replaced)
     * @param input the input string
     * @throws VilException if parsing/evaluating fails
     */
    private void assertResult(String expected, String input) throws VilException {
        String subst = StringReplacer.substitute(input, environment, parser, evaluator);
        Assert.assertEquals(expected, subst);
    }
    
}
