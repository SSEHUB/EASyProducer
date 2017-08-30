package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;

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
        public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression ex) throws VilException {
            return resolve(ex);
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
        //private int midCurPos = -1; // unused
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
         * The latest available start parsing position.
         * 
         * @return the position
         */
        private int getLatestPos() {
            return midPos < 0 ? openPos : midPos;
        }
        
        /**
         * Changes the latest available start parsing position to avoid double
         * creation of expressions.
         * 
         * @param pos the new position
         */
        private void setLatestPos(int pos) {
            if (midPos < 0) {
                openPos = pos;
            } else {
                midPos = pos;
            }
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
        
        @Override
        public Object getIvmlElement(String name) {
            return null; // cannot resolve by default
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
        handleConstant(curStart, pos, 0);
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos, 1);
        return pos + 1;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos, 0);
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        if (State.VARIABLE_START == state) {
            handleConstant(curStart, pos, 0);
        }
        return pos;
    }
    
    /**
     * Handle constant placeholder from <code>curStart</code> until <code>position</code>. 
     * 
     * @param curStart the current start position
     * @param position  the actual position in the text.
     * @param posAdvance where the next parsing position shall be with respect to <code>position</code>
     * @throws VilException in case of evaluation problems
     */
    private void handleConstant(int curStart, int position, int posAdvance) throws VilException {
        if (isNonEmptyCommandStack()) { // only for in-place commands
            String string;
            InPlaceCommand<I> cmd = getCurrentInPlaceCommand();
            Positions p = inPlacePositions.get(cmd);
            if (null != p) {
                int start = p.getLatestPos() + 1;
                int end = position - 1;
                if (start < end) {
                    string = substring(p.getLatestPos() + 1, position - 1);
                    p.setLatestPos(position + posAdvance);
                } else {
                    string = "";
                }
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
        Object oValue = null;
        IResolvable var = environment.get(variableName);
        if (null != var) {
            oValue = environment.getValue(var);
        } else {
            try {
                oValue = environment.getIvmlValue(variableName);
            } catch (VilException e) {
                warnParsingIgnoring(variableName,  e);
            }
        }
        if (null != oValue) {
            String value = StringValueHelper.getStringValueInReplacement(oValue, null);
            if (null != value) {
                int start = curStart - 1; // curStart - 1 -> replace also the $!
                if (isNonEmptyCommandStack()) {
                    InPlaceCommand<I> cmd = getCurrentInPlaceCommand();
                    Positions p = inPlacePositions.get(cmd);
                    if (null != p) {
                        start = p.getLatestPos() + 1;
                    }
                }
                pos = setPos(replace(start, pos, value));
            }
        }
        return -1;
    }
    
    @Override
    protected int handleExpression(int curStart, int pos) throws VilException {
        if (null == expressionParser) {
            getLogger().warn("no expression parser registered");
        } else if (null == expressionEvaluator) {
            getLogger().warn("no expression evaluator registered");
        } else {
            String expressionString = substring(curStart, pos);
            Expression expr = null;
            try {
                expr = handleInPlaceCommands(expressionString, curStart, pos);
            } catch (VilException e) {
                warnParsingIgnoring(expressionString, e);
            }
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
                        pos = checkForEmptyLine(value, expr, pos);
                    }
                }
            }
        }
        return -1;
    }
    
    /**
     * Checks and removes empty lines depending on <code>value</code> and {@link Expression#replaceEmptyLine()}.
     * 
     * @param value the actual value (must not be <b>null</b>)
     * @param expr the actual expression (must not be <b>null</b>
     * @param pos the actual parsing position
     * @return the new parsing position
     */
    private int checkForEmptyLine(String value, Expression expr, int pos) {
        if (0 == value.length() && expr.replaceEmptyLine() && pos > 0 && pos < length()) {
            char before = charAt(pos - 1);
            char at = charAt(pos);
            if (('\r' == before || '\n' == before) && ('\r' == at || '\n' == at)) {
                deleteCharAt(pos);
                // the Windows version
                if ('\r' == at && pos < length() && '\n' == charAt(pos)) {
                    deleteCharAt(pos);
                }
            }
        }
        return pos;
    }

    @Override
    protected void notifyStartInPlaceCommand(InPlaceCommand<I> cmd, int curStart, int pos) {
        Positions p = inPlacePositions.get(cmd);
        if (null == p) {
            inPlacePositions.put(cmd, new Positions(curStart, pos));
        } else {
            //p.midCurPos = curStart; // unused
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
    protected Expression parseExpressionImpl(String expressionString) throws VilException {
        Expression result = null;
        try {
            result = expressionParser.parse(expressionString, environment);
            if (result instanceof VarModelIdentifierExpression) { // just as fallback
                result = resolve((VarModelIdentifierExpression) result);
            }
        } catch (VilException e) {
            warnParsingIgnoring(expressionString, e);
        }
        return result;
    }
    
    /**
     * Resolves a {@link VarModelIdentifierExpression} based on the actual runtime environment 
     * and, if resolved, replaces it by a constant.
     * 
     * @param ex the expression to resolve
     * @return the resolved expression, <b>null</b> if not possible to resolve
     * @throws VilException in case of resolution problems
     */
    private Expression resolve(VarModelIdentifierExpression ex) {
        Expression result = null;
        String id = ex.getIdentifier();
        try {
            IRuntimeEnvironment env = getResolver().getRuntimeEnvironment();
            Object res = env.getIvmlValue(id);
            if (res instanceof DecisionVariable) {
                DecisionVariable var = ((DecisionVariable) res);
                TypeDescriptor<?> type = var.getType();
                result = new ConstantExpression(type, var.getValue(), type.getTypeRegistry());
            }
        } catch (VilException e) {
            warnParsingIgnoring(id, e);
        }
        return result;
    }
 
}
