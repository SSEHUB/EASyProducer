package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in string values.
 * 
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public class StringReplacer<I extends VariableDeclaration> extends StringParser<String, I, Resolver<I>> {

    private IRuntimeEnvironment environment;
    private IExpressionVisitor expressionEvaluator;
    private IExpressionParser expressionParser;
    private Map<Object, Positions> inPlacePositions = new HashMap<Object, Positions>();
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
                    expressionEvaluator, getFactory());
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
        
        @Override
        public Object visitStringExpression(StringExpression ex) throws VilException {
            return ex.getExpression().accept(this);
        }

    };
    
    /**
     * Stores in-place command positions for replacing. Consists of the open-position (parsing positions 
     * where the in-place command started) and the optional latest mid-position (parsing positions if the 
     * in-place command consists of multiple mid parts, e.g., if-else).
     * 
     * @author Holger Eichelberger
     *
     */
    private static class Positions {
        private int openCurPos;
        private int openPos;
        private int midCurPos = -1;
        private int midPos = -1;
        
        /**
         * Creates a position object.
         * 
         * @param curPos the concept start position
         * @param pos the parsing position
         */
        private Positions(int curPos, int pos) {
            this.openCurPos = curPos;
            this.openPos = pos;
        }
        
        /**
         * The latest start position.
         * 
         * @return the position
         */
        @SuppressWarnings("unused")
        private int getLatestCurPos() {
            return midCurPos < 0 ? openCurPos : midCurPos;
        }

        /**
         * The latest start parsing position.
         * 
         * @return the position
         */
        private int getLatestPos() {
            return midPos < 0 ? openPos : midPos;
        }

    }
    
    /**
     * An internal local resolver class.
     * 
     * @param <V> the variable declaration type
     * @author Holger Eichelberger
     */
    private static class ReplacerResolver<V extends VariableDeclaration> extends Resolver<V> {

        /**
         * Creates a resolver instance.
         * 
         * @param environment the runtime environment
         */
        public ReplacerResolver(IRuntimeEnvironment environment) {
            super(environment);
        }

        @Override
        protected net.ssehub.easy.instantiation.core.model.expressions.Resolver.IContextType getDefaultType() {
            return null;
        }
        
    }

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
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     */
    private StringReplacer(String text, IRuntimeEnvironment environment, IExpressionParser expressionParser,
            IExpressionVisitor expressionEvaluator, IStringResolverFactory<I> factory) {
        super(text, createResolver(environment, factory), factory);
        this.environment = environment;
        this.expressionEvaluator = expressionEvaluator;
        this.expressionParser = expressionParser;
    }
    
    /**
     * Creates a resolver if needed.
     * 
     * @param <I> the variable declaration type
     * @param environment
     *            the runtime environment containing the variables
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     * @return the resolver (may be <b>null</b>)
     */
    private static <I extends VariableDeclaration> Resolver<I> createResolver(IRuntimeEnvironment environment, 
        IStringResolverFactory<I> factory) {
        return null == factory ? null : new ReplacerResolver<I>(environment);
    }

    /**
     * Substitutes the variable and expression placeholders in <code>text</code>.
     * 
     * @param <I> the variable declaration type
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
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     * @return the modified <code>text</code>
     * @throws VilException
     *             in case that something goes wrong while resolving variables
     */
    public static <I extends VariableDeclaration> String substitute(String text, IRuntimeEnvironment environment, 
        IExpressionParser expressionParser, IExpressionVisitor expressionEvaluator, IStringResolverFactory<I> factory) 
        throws VilException {
        String result;
        if (null != text) {
            try {
                StringReplacer<I> replacer = new StringReplacer<I>(text, environment, expressionParser, 
                    expressionEvaluator, factory);
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
        handleConstant(curStart, pos);
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos);
        return pos + 1;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos);
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        if (State.VARIABLE_START == state) {
            handleConstant(curStart, pos);
        }
        return pos;
    }
    
    /**
     * Handle constant placeholder from <code>curStart</code> until <code>position</code>. 
     * 
     * @param curStart the current start position
     * @param position  the actual position in the text.
     * @throws VilException in case of evaluation problems
     */
    private void handleConstant(int curStart, int position) throws VilException {
        if (isNonEmptyCommandStack()) { // only for in-place commands
            InPlaceCommand<I> cmd = getCurrentInPlaceCommand();
            String string;
            Positions p = inPlacePositions.get(cmd);
            if (null != p) {
                string = substring(p.getLatestPos() + 1, position - 1);
            } else { // should not occur
                string = substring(curStart, position);
            }
            if (string.length() > 0) {
                addExpression(createConstantStringExpression(string), null);
            }
        }
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
            Expression expr = handleInPlaceCommands(expressionString, curStart, pos);
            if (null != expr) {
                Object tmp = expr.accept(recursiveReplacer);
                if (tmp instanceof Expression) {
                    expr = (Expression) tmp;
                }
            }
            if (null != expr) {
                Object oValue = expr.accept(expressionEvaluator);
                if (null != oValue) {
                    String value = StringValueHelper.getStringValueInReplacement(oValue, null);
                    if (null != value) {
                        Positions inPlaceStart = inPlacePositions.remove(expr);
                        int start = null == inPlaceStart ? curStart : inPlaceStart.openCurPos;
                        // start - 2 -> replace also the $!
                        pos = setPos(replace(start - 2, pos + 1, value));
                    }
                }
            }
        }
        return -1;
    }

    @Override
    protected void notifyStartInPlaceCommand(InPlaceCommand<I> cmd, int curStart, int pos) {
        Positions p = inPlacePositions.get(cmd);
        if (null == p) {
            inPlacePositions.put(cmd, new Positions(curStart, pos));
        } else {
            p.midCurPos = curStart;
            p.midPos = pos;
        }
    }

    @Override
    protected void notifyEndInPlaceCommand(InPlaceCommand<I> cmd, Expression expr, int curStart, int pos) {
        Positions p = inPlacePositions.remove(cmd);
        if (null != p) {
            inPlacePositions.put(expr, p);
        }
    }

    @Override
    protected Expression parseExpression(String expressionString) throws VilException {
        Expression expr = expressionParser.parse(expressionString, environment);
        if (expr instanceof VariableExpression) {
            VariableExpression e = (VariableExpression) expr;
            expr = new VariableEx(e.getDeclaration(), e.getQualifiedName());
        }
        return expr;
    }
 
}
