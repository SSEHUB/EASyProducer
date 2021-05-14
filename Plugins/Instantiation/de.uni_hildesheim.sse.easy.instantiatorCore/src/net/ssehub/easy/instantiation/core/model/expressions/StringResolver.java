package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.dslCore.translation.IMessageReceiver;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * StringResolver to resolve variables and expressions on compiling. Use the StringReplacer if you need to replace
 * expressions or variables on runtime.
 * 
 * @param <I> the actual variable declaration type
 * @param <R> the actual resolver type
 * @param <E> the actual expression statement type
 * @author Sass
 * @author Eichelberger
 */
public class StringResolver<I extends VariableDeclaration, R extends Resolver<I>, 
    E extends ExpressionStatement> extends StringParser<CompositeExpression, I, R> implements IMessageReceiver {

    private IExpressionTranslator<I, R> translator;
    private StringBuilder warnings;
    private List<Expression> expressions = new ArrayList<Expression>();

    /**
     * The general interface of an expression translator.
     * 
     * @param <I> the actual variable declaration type
     * @param <R> the actual resolver type
     * @author Holger Eichelberger
     */
    public interface IExpressionTranslator<I extends VariableDeclaration, R extends Resolver<I>> {

        /**
         * Parse the given expression.
         * 
         * @param expression the expression as string
         * @param resolver the resolver
         * @param warnings a collector for warnings
         * @return the resulting expression
         * @throws VilException if problems occur while parsing / resolving
         */
        public Expression parseExpression(String expression, R resolver, StringBuilder warnings) 
            throws VilException;

    }
    
    /**
     * Creates a replacer instance.
     * 
     * @param text the text to be analyzed
     * @param translator the translator to be used
     * @param resolver the resolver to be used
     * @param warnings  to collect warnings (may be <b>null</b>)
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     */
    private StringResolver(String text, R resolver, IExpressionTranslator<I, R> translator, StringBuilder warnings, 
        IStringParserFactory<I> factory) {
        super(text, resolver, factory);
        this.warnings = warnings;
        this.translator = translator;
    }

    /**
     * Substitutes a given text and returns a CompositeExpression.
     * 
     * @param <I> the variable declaration type
     * @param <R> the resolver type
     * @param <E> the expression statement type
     * @param text the text to be analyzed
     * @param resolver the resolver to be used.
     * @param translator the translator to be used.
     * @param warnings an optional (may be <b>null</b> buffer to collect warnings
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     * 
     * @throws VilException delegates the exception
     *
     * @return a {@link CompositeExpression}
     */
    public static <I extends VariableDeclaration, R extends Resolver<I>, 
        E extends ExpressionStatement> Expression substitute(String text, R resolver,
        IExpressionTranslator<I, R> translator, StringBuilder warnings, IStringParserFactory<I> factory) 
        throws VilException {
        CompositeExpression result;
        if (null != text) {
            try {
                StringResolver<I, R, E> replacer = new StringResolver<I, R, E>(text, resolver, translator, 
                    warnings, factory);
                if (text.contains("$")) {
                    result = replacer.parse();
                } else {
                    List<Expression> list = replacer.handleConstant(text);
                    result = new CompositeExpression(list);
                }
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
    protected CompositeExpression createParseResult() throws VilException {
        clearStatementStack(expressions);
        return new CompositeExpression(expressions);
    }
    
    @Override
    protected void handleQuote(int pos) throws VilException {
        // don't modify quotes, keep the text
    }
    
    @Override
    protected void handleTextEnd(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos + 1);
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos - 1);
        return pos;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos - 1);
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        if (State.VARIABLE_START == state) {
            handleConstant(curStart, pos);
        }
        return pos;
    }


    @Override
    protected int handleExpression(int curStart, int pos) throws VilException {
        Expression result = null;
        String expressionString = substring(curStart - 1, pos + 1);
        //remove leading ${ and trailing }
        expressionString = expressionString.substring(2, expressionString.length() - 1);
        result = handleInPlaceCommands(expressionString, curStart, pos);
        addExpression(result, expressions);
        return pos + 1;
    }
    
    @Override
    protected Expression parseExpressionImpl(String expressionString) throws VilException {
        return translator.parseExpression(expressionString, getResolver(), warnings);
    }

    /**
     * Handle constant placeholder from <code>curStart</code> until <code>position</code>. 
     * 
     * @param curStart the current start position
     * @param position  the actual position in the text.
     * @throws VilException in case of evaluation problems
     */
    private void handleConstant(int curStart, int position) throws VilException {
        String string = substring(curStart, position);
        if (string.length() > 0) {
            addExpression(createConstantStringExpression(string), expressions);
        }
    }

    /**
     * Handle constant for a given text. Splits the text into constants by seperating the string on whitespaces.
     * 
     * @param text to be analyzed
     * @return  List of ConstantExpressions
     * @throws VilException in case of evaluation problems
     */
    private List<Expression> handleConstant(String text) throws VilException {
        List<Expression> list = new ArrayList<Expression>();
        // Split the string into words but keep the spaces
        String[] textArray = text.split("(?<=\\s)|(?=\\s)");
        for (String string : textArray) {
            list.add(createConstantStringExpression(string));
        }
        return list;
    }

    /**
     * Handle variable.
     * 
     * @param text the variable name
     * @return CompositeExpression containing the variable
     */
    protected CompositeExpression resolveVariable(String text) {
        CompositeExpression compExpression = null;
        // we are our own message receiver - cause/feature not needed here
        VariableDeclaration var = (VariableDeclaration) getResolver().resolve(text, false, null, null, this);
        VariableExpression varExpr = null;
        if (var != null) {
            varExpr = new VariableExpression(var);
            List<Expression> expressionList = new ArrayList<Expression>();
            expressionList.add(varExpr);
            compExpression = new CompositeExpression(expressionList);
        }
        return compExpression;
    }

    @Override
    protected int handleVariable(int curStart, int pos) throws VilException {
        String variableName = substring(curStart - 1, pos);
        String pattern2 = "\\$([A-Za-z0-9]+)";
        variableName = variableName.replaceAll(pattern2, "$1");
        pos = setPos(replace(curStart - 1, pos, variableName));
        VariableDeclaration var = (VariableDeclaration) getResolver().resolve(variableName, false, null, null, this);
        VariableExpression varExpr = null;
        if (var != null) {
            varExpr = new VariableExpression(var);
        } else {
            appendWarning(VariableExpression.composeUnkownVariableWarning(variableName));
        }
        addExpression(varExpr, expressions);
        return pos;
    }

    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        // we just collect warnings here
    }

    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        appendWarning(message);
    }

    @Override
    public void collect(IMessage message, EObject cause, EStructuralFeature causeFeature, int code) {
        if (Status.WARNING == message.getStatus()) {
            appendWarning(message.getDescription());
        }
    }

    /**
     * Appends message as a warning.
     * 
     * @param message the message to append
     */
    private void appendWarning(String message) {
        appendWarning(warnings, message);
    }

    /**
     * Appends message as a warning.
     * 
     * @param warnings the warnings collected so far, nothing will happen if <b>null</b>
     * @param message the message to append
     */
    public static void appendWarning(StringBuilder warnings, String message) {
        if (null != warnings) {
            if (warnings.length() > 0) {
                warnings.append(", ");
            }
            warnings.append(message);
        }
    }

}
