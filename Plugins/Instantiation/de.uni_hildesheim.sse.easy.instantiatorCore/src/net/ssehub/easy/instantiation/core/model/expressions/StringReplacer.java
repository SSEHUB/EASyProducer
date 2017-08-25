package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in string values.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacer extends StringParser<String> {

    private IRuntimeEnvironment environment;
    private IExpressionVisitor expressionEvaluator;
    private IExpressionParser expressionParser;
    private IExpressionVisitor recursiveReplacer = new IExpressionVisitor() {
        // an expression replacer for recursive string replacement, returns null if nothing changed 
        
        @Override
        public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitVariableExpression(VariableExpression cst) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
            return par.getExpr().accept(this);
        }
        
        @Override
        public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitExpression(Expression ex) throws VilException {
            return null; // not needed
        }
        
        @Override
        public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
            Object result = null;
            for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
                Object tmp = ex.getInitExpression(e).accept(this);
                if (tmp instanceof Expression) {
                    ex.setInitExpression(e, (Expression) tmp);
                    result = ex; // signal change
                }
            }
            return result;
        }
        
        @Override
        public Object visitConstantExpression(ConstantExpression cst) throws VilException {
            Object result;
            if (TypeRegistry.stringType().isAssignableFrom(cst.getType())) {
                String in = cst.getValue().toString();
                String tmp = StringReplacer.substitute(cst.getValue().toString(), environment, expressionParser, 
                    expressionEvaluator);
                if (null != tmp && !tmp.equals(in)) {
                    result = new ConstantExpression(TypeRegistry.stringType(), tmp, TypeRegistry.DEFAULT);
                } else {
                    result = null; // do nothing
                }
            } else {
                result = null;
            }
            return result;
        }
        
        @Override
        public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
            Object result = null;
            for (int e = 0; e < ex.getExpressionsCount(); e++) {
                Object tmp = ex.getExpression(e).accept(this);
                if (tmp instanceof Expression) {
                    ex.setExpression(e, (Expression) tmp);
                    result = ex; // signal change
                }
            }
            return result;
        }
        
        @Override
        public Object visitCallExpression(CallExpression call) throws VilException {
            Object result = null;
            for (int a = 0; a < call.getArgumentsCount(); a++) {
                CallArgument arg = call.getArgument(a);
                Expression ex = arg.getExpression();
                if (null != ex) {
                    Object tmp = ex.accept(this);
                    if (tmp instanceof Expression) {
                        arg.setExpression((Expression) tmp);
                        result = call;
                    }
                }
            }
            return result;
        }
    };

    /**
     * Creates a replacer instance.
     * 
     * @param text
     *            the text to be analyzed
     * @param environment
     *            the runtime environment containing the variables
     * @param expressionParser
     *            an instance for parsing strings into expression (may be <b>null</b> but then expression replacement
     *            will not work)
     * @param expressionEvaluator
     *            the expression visitor for evaluating expressions (may be <b>null</b> but then expression replacement
     *            will not work)
     */
    private StringReplacer(String text, IRuntimeEnvironment environment, IExpressionParser expressionParser,
            IExpressionVisitor expressionEvaluator) {
        super(text);
        this.environment = environment;
        this.expressionEvaluator = expressionEvaluator;
        this.expressionParser = expressionParser;
    }

    /**
     * Substitutes the variable and expression placeholders in <code>text</code>.
     * 
     * @param text
     *            the text to be analyzed
     * @param environment
     *            the runtime environment containing the variables
     * @param expressionParser
     *            an instance for parsing strings into expression (may be <b>null</b> but then expression replacement
     *            will not work)
     * @param expressionEvaluator
     *            the expression visitor for evaluating expressions (may be <b>null</b> but then expression replacement
     *            will not work)
     * @return the modified <code>text</code>
     * @throws VilException
     *             in case that something goes wrong while resolving variables
     */
    public static String substitute(String text, IRuntimeEnvironment environment, IExpressionParser expressionParser,
            IExpressionVisitor expressionEvaluator) throws VilException {
        String result;
        if (null != text) {
            try {
                StringReplacer replacer = new StringReplacer(text, environment, expressionParser, expressionEvaluator);
                result = replacer.parse();
            } catch (VilException e) {
                if (VilException.ID_NULL_VALUE == e.getId()) {
                    result = null;
                } else {
                    throw e;
                }
            }
        } else {
            result = null;
        }
        return result;
    }

    @Override
    protected String createParseResult() throws VilException {
        return toText();
    }
    
    @Override
    protected void handleQuote(int pos) throws VilException {
        if (pos + 2 < length() && charAt(pos + 2) != '$') { 
            deleteCharAt(pos); // remove quote -> Java quote
        }
    }

    @Override
    protected void handleTextEnd(int curStart, int pos) throws VilException {
        // do nothing
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        return pos + 1;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        return pos;
    }

    @Override
    protected int handleVariable(int curStart, int pos) throws VilException {
        String variableName = substring(curStart, pos);
        IResolvable var = environment.get(variableName);
        if (null != var) {
            Object oValue = environment.getValue(var);
            if (null == oValue) {
                // stop replacement
                throw new VilException("", VilException.ID_NULL_VALUE);
            }
            String value = StringValueHelper.getStringValueInReplacement(oValue, null);
            if (null != value) {
                // curStart - 1 -> replace also the $!
                pos = setPos(replace(curStart - 1, pos, value));
            }
        }
        return -1;
    }

    @Override
    protected int handleExpression(int curStart, int pos) throws VilException {
        if (null == expressionParser) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression parser registered");
        } else if (null == expressionEvaluator) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression evaluator registered");
        } else {
            String expressionString = substring(curStart, pos);
            Expression expr = expressionParser.parse(expressionString, environment);
            if (null != expr) {
                Object tmp = expr.accept(recursiveReplacer);
                if (tmp instanceof Expression) {
                    expr = (Expression) tmp;
                }
            }
            if (null == expr) {
                throw new VilException("illegal expression '" + expressionString + "'",
                        VilException.ID_RUNTIME);
            }
            Object oValue = expr.accept(expressionEvaluator);
            if (null == oValue) {
                // stop replacement
                throw new VilException("", VilException.ID_NULL_VALUE);
            }
            String value = StringValueHelper.getStringValueInReplacement(oValue, null);
            if (null != value) {
                // curStart - 1 -> replace also the $!
                pos = setPos(replace(curStart - 2, pos + 1, value));
            }
        }
        return -1;
    }

}
