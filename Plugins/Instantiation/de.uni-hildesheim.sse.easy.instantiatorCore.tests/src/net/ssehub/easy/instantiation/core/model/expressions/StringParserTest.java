package net.ssehub.easy.instantiation.core.model.expressions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.AbstractTest;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.BuiltIn;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Tests common functionality of {@link StringReplacer} and {@link StringResolver}.
 * 
 * @author Holger Eichelberger
 */
public class StringParserTest extends AbstractTest {

    protected static final Boolean BOOLEAN_VALUE = Boolean.TRUE;
    protected static final int INT_VALUE = 1234;
    protected static final String STRING_VALUE = "test";

    private static RuntimeEnv environment;
    private static ExpressionParser parser;
    private static IExpressionVisitor evaluator;
    private static VarResolver resolver;
    
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
            evaluator = new ExpressionVisitor(environment);
            resolver = new VarResolver(environment);
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
     * Tests non-recursive expression replacements.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testExpressionReplacements() throws VilException {
        // failure - does it terminate?
        assertReplacementResult("${test", "${test");
        // variable replacement
        assertReplacementResult("${test}", "test");
        assertReplacementResult("${test}/test", "test/test");
        assertReplacementResult("test/${test}", "test/test");
        assertReplacementResult("test/$test", "test/test");
        assertReplacementResult("test/${test}/test", "test/test/test");
        // expression replacement
        assertReplacementResult("test/${func(i, b)}", "test/func(1234,true)");
        assertReplacementResult("test/${func(i, b)}/${func2(i, b)}", "test/func(1234,true)/func2(1234,true)");
        assertReplacementResult("test/${func(i, b)}/${func2(b, i)}/test", "test/func(1234,true)/func2(true,1234)/test");
    }
    
    /**
     * Tests recursive expression replacements.
     * 
     * @throws VilException shall not occur
     */
/*    @Test
    public void testRecursiveReplacements() throws VilException {
        assertReplacementResult("test/${func(\"aa${b}aa\", $test)}/${func2($i, $s)}/test", 
            "test/func(\"aa<b>aa\",<test>)/func2(1234,<test>)/test");
    }*/
    
    /**
     * Tests expression resolution.
     * 
     * @throws VilException shall not occur
     */
    @Test
    public void testExpressionResolution() throws VilException {
        assertResolutionResult("${test}", new ExpectedVariableExpression("test"));
        assertResolutionResult("test/${test}", new ExpectedConstantExpression("test/"), 
            new ExpectedVariableExpression("test"));
        assertResolutionResult("test/$test", new ExpectedConstantExpression("test/"), 
            new ExpectedVariableExpression("test"));
        assertResolutionResult("${test}/test", new ExpectedVariableExpression("test"), 
            new ExpectedConstantExpression("/test"));
        assertResolutionResult("test/${test}/test", new ExpectedConstantExpression("test/"), 
            new ExpectedVariableExpression("test"), new ExpectedConstantExpression("/test"));
/*
        StringBuilder warnings = new StringBuilder();
        Expression ex = StringResolver.substitute("test/${func(\"aa${b}aa\", $test)}/${func2($i, $s)}/test", 
            resolver, parser, warnings, parser);
        printExpression(ex);*/
    }

    /**
     * Prints an expression.
     * 
     * @param ex the expression to print
     */
    /*private void printExpression(Expression ex) {
        System.out.println(toString(ex, "", "\n") + "\n");
    }*/
    
    /**
     * Turns an expression into a string.
     * 
     * @param ex the expression
     * @param indent the indentation to prepend
     * @param separator the separator to append
     * @return the textual representation
     */
    private String toString(Expression ex, String indent, String separator) {
        String result = "";
        if (ex instanceof CompositeExpression) {
            result += indent + "COMP" + separator;
            CompositeExpression ce = (CompositeExpression) ex;
            for (int e = 0; e < ce.getExpressionsCount(); e++) {
                result += toString(ce.getExpression(e), indent + "  ", separator);
            }
        } else if (ex instanceof ConstantExpression) {
            result += indent + "CONS " + ((ConstantExpression) ex).getValue() + separator;
        } else if (ex instanceof VariableExpression) {
            result += indent + "VAR " + ((VariableExpression) ex).getName() + separator;
        } else if (ex instanceof CallExpression) {
            CallExpression ce = (CallExpression) ex;
            result += indent + "CALL " + ce.getName() + separator;
            for (int a = 0; a < ce.getArgumentsCount(); a++) {
                result += toString(ce.getArgument(a).getExpression(), indent + "  ", separator);
            }
        }
        return result;
    }
    
    /**
     * Asserts parse results.
     * 
     * @param expected the expected parse result (variables, expressions replaced)
     * @param input the input string
     * @throws VilException if parsing/evaluating fails
     */
    private void assertReplacementResult(String input, String expected) throws VilException {
        String subst = StringReplacer.substitute(input, environment, parser, evaluator);
        Assert.assertEquals(expected, subst);
    }

    /**
     * Represents an expected expression.
     * 
     * @param <E> the expression type
     * @author Holger Eichelberger
     */
    private abstract static class ExpectedExpression<E extends Expression> {
        
        private Class<E> expectedCls;
        
        /**
         * Creates an expected expression object.
         * 
         * @param expectedCls the expected class
         */
        protected ExpectedExpression(Class<E> expectedCls) {
            this.expectedCls = expectedCls;
        }
        
        /**
         * Returns whether the given expression matches the expected expression.
         * 
         * @param ex the expression to match
         * @return <code>true</code> if match, <code>false</code> else
         */
        protected final boolean matches(Expression ex) {
            boolean result;
            if (expectedCls.isInstance(ex)) {
                result = matchesImpl(expectedCls.cast(ex));
            } else {
                result = false;
            }
            return result;
        }

        /**
         * Returns whether the given expression matches the expected expression.
         * 
         * @param ex the expression to match
         * @return <code>true</code> if match, <code>false</code> else
         */
        protected abstract boolean matchesImpl(E ex);
        
    }

    /**
     * Represents an expected composite expression.
     * 
     * @author Holger Eichelberger
     */
    private static class ExpectedCompositeExpression extends ExpectedExpression<CompositeExpression> {
        
        private ExpectedExpression<?>[] expressions;

        /**
         * Creates an expected composite expression.
         * 
         * @param expressions the expected expressions
         */
        private ExpectedCompositeExpression(ExpectedExpression<?>... expressions) {
            super(CompositeExpression.class);
            this.expressions = expressions;
        }

        @Override
        public boolean matchesImpl(CompositeExpression ex) {
            boolean matches = (expressions.length == ex.getExpressionsCount());
            for (int e = 0; matches && e < expressions.length; e++) {
                matches = expressions[e].matches(ex.getExpression(e));
            }
            return matches;
        }
        
    }

    /**
     * Represents an expected constant expression.
     * 
     * @author Holger Eichelberger
     */
    private static class ExpectedConstantExpression extends ExpectedExpression<ConstantExpression> {

        private Object value;

        /**
         * Creates an expected constant expression.
         * 
         * @param value the expected value
         */
        private ExpectedConstantExpression(Object value) {
            super(ConstantExpression.class);
            this.value = value;
        }

        @Override
        public boolean matchesImpl(ConstantExpression ex) {
            return value.equals(ex.getValue());
        }

    }

    /**
     * Represents an expected variable expression.
     * 
     * @author Holger Eichelberger
     */
    private static class ExpectedVariableExpression extends ExpectedExpression<VariableExpression> {
        
        private String name;

        /**
         * Creates an expected variable expression.
         * 
         * @param name the expected variable name
         */
        private ExpectedVariableExpression(String name) {
            super(VariableExpression.class);
            this.name = name;
        }

        @Override
        public boolean matchesImpl(VariableExpression ex) {
            return name.equals(ex.getName());
        }

    }

    /**
     * Represents an expected call expression.
     * 
     * @author Holger Eichelberger
     */
    @SuppressWarnings("unused")
    private static class ExpectedCallExpression extends ExpectedExpression<CallExpression> {
        
        private String name;
        private ExpectedExpression<?>[] expressions;

        /**
         * Creates an expected call expression.
         * 
         * @param name the expected call name
         * @param expressions the expected argument expressions
         */
        private ExpectedCallExpression(String name, ExpectedExpression<?>... expressions) {
            super(CallExpression.class);
            this.name = name;
            this.expressions = expressions;
        }

        @Override
        public boolean matchesImpl(CallExpression ex) {
            boolean matches = name.equals(ex.getName());
            if (matches && expressions.length == ex.getArgumentsCount()) {
                for (int e = 0; matches && e < expressions.length; e++) {
                    matches = expressions[e].matches(ex.getArgument(e).getExpression());
                }
            }
            return matches;
        }
    }
    
    /**
     * Asserts a resolution result.
     * 
     * @param input the input string
     * @param expected the expected expressions
     * @throws VilException in case of parse/resolution problems
     */
    private void assertResolutionResult(String input, ExpectedExpression<?>... expected) throws VilException {
        StringBuilder warnings = new StringBuilder();
        Expression ex = StringResolver.substitute(input, resolver, parser, warnings, parser);
        ExpectedExpression<?> start;
        if (expected.length == 1 && expected[0] instanceof ExpectedCompositeExpression) {
            start = expected[0];
        } else {
            start = new ExpectedCompositeExpression(expected);
        }
        Assert.assertTrue("for input " + input + " received " + toString(ex, "", " -- "), start.matches(ex));
    }
    
}
