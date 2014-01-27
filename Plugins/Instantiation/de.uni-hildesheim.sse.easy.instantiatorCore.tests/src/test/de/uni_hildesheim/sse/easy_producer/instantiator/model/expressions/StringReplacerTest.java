package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Tests common functionality of {@link StringReplacer}.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacerTest extends AbstractTest {

    protected static final Boolean BOOLEAN_VALUE = Boolean.TRUE;
    protected static final int INT_VALUE = 1234;
    protected static final String STRING_VALUE = "test";

    private static RuntimeEnvironment environment;
    
    /**
     * Sets up the environment.
     */
    @BeforeClass
    public static void startUp() {
        try {
            environment = new RuntimeEnvironment();
            environment.switchContext(new PseudoModel());
            VariableDeclaration test = new VariableDeclaration("b", TypeRegistry.booleanType());
            environment.addValue(test, BOOLEAN_VALUE);
            test = new VariableDeclaration("i", TypeRegistry.integerType());
            environment.addValue(test, INT_VALUE);
            test = new VariableDeclaration("s", TypeRegistry.stringType());
            environment.addValue(test, STRING_VALUE);
        } catch (VilLanguageException e) {
            Assert.fail("cannot create environment: " + e.getMessage());
        }
    }
    
    /**
     * Tests string replacements which actually do not cause a replacement.
     * 
     * @throws VilLanguageException shall not occur
     * @throws ExpressionException shall not occur
     */
    @Test
    public void testNoReplacements() throws VilLanguageException, ExpressionException {
        // no need for expression parser / evaluator
        Assert.assertEquals("", StringReplacer.substitute("", environment, null, null));
        Assert.assertEquals("abba", StringReplacer.substitute("abba", environment, null, null));
    }

    /**
     * Tests value replacements which cause a replacement.
     * 
     * @throws VilLanguageException shall not occur
     * @throws ExpressionException shall not occur
     */
    @Test
    public void testValueReplacements() throws VilLanguageException, ExpressionException {
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
     * @throws VilLanguageException shall not occur
     * @throws ExpressionException shall not occur
     */
    @Ignore
    @Test
    public void testExpressionReplacements() throws VilLanguageException, ExpressionException {
        // this is not a functional test as we do not have the parser here -> xText
        System.out.println(StringReplacer.substitute("${test}", environment, null, null));
        System.out.println(StringReplacer.substitute("${test}/test", environment, null, null));
        System.out.println(StringReplacer.substitute("test/${test}", environment, null, null));
        System.out.println(StringReplacer.substitute("test/${test}/test", environment, null, null));
    }
    
}
