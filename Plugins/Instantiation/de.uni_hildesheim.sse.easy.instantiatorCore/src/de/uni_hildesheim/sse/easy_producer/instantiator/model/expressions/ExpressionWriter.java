package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.io.Writer;
import java.util.Stack;

import org.apache.commons.lang.StringEscapeUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Implements a writer for expressions using the default VIL expression syntax.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionWriter extends AbstractWriter implements IExpressionVisitor {
    
    private Stack<CompositeExpression> compositeExpressions = new Stack<CompositeExpression>();
    
    private boolean isInContent = false;
    
    private boolean isInExpression = false;

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public ExpressionWriter(Writer out) {
        super(out);
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        print("(");
        par.getExpr().accept(this);
        print(")");
        return null;
    }
    
    /**
     * Prints the name of a call expression.
     * 
     * @param call the call to print the name for
     */
    private void printName(CallExpression call) {
        if (null != call.getPrefix()) {
            print(call.getPrefix());
            print(Constants.QUALIFICATION_SEPARATOR);
        }
        print(call.getName());
    }
    
    /**
     * Prints the given type.
     * 
     * @param type the type to be printed
     */
    protected void printType(TypeDescriptor<?> type) {
        print(type.getVilName());
    }
    
    /**
     * Prints the iterator declarators if appropriate.
     * 
     * @param call the call expression to print the declarators for
     */
    private void printIteratorDeclarators(CallExpression call) {
        if (call.isIteratorCall()) {
            ExpressionEvaluator eval = (ExpressionEvaluator) call.getArgument(1).getExpression();
            VariableDeclaration iter = eval.getIteratorVariable();
            if (iter.hasExplicitType()) {
                printType(iter.getType());
                printWhitespace();
            }
            print(iter.getName());
            printWhitespace();
            print(Constants.DECLARATOR_SEPARATOR);
            printWhitespace();
        }        
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        CallType cType = call.getCallType();
        if (CallType.TRANSPARENT != cType) {
            OperationDescriptor desc = call.getResolved();
            switch (desc.getOperationType()) {
            case INFIX:
                call.getArgument(0).accept(this);
                printWhitespace();
                printName(call);
                printWhitespace();
                call.getArgument(1).accept(this);
                break;
            case NORMAL:
                if (Constants.ARRAY_ACCESS.equals(desc.getName())) {
                    call.getArgument(0).accept(this);
                    print("[");
                    printArguments(call, 1);
                    print("]");
                } else if (desc.isConstructor()) {
                    print("new ");
                    print(desc.getDeclaringType().getName());
                    printArgumentList(call, 0);
                } else if (CallType.EXTERNAL == cType) { // or static?
                    printName(call);
                    printArgumentList(call, 0);
                } else {
                    call.getArgument(0).accept(this);
                    if (call.isIteratorCall()) {
                        print(Constants.ITER_CALL);
                    } else {
                        print(".");
                    }
                    printName(call);
                    print("(");
                    printIteratorDeclarators(call);
                    printArguments(call, 1);
                    print(")");
                }
                break;
            case POSTFIX:
                if (call.getArgumentsCount() > 1) {
                    printArgumentList(call, 0);
                } else {
                    printArguments(call, 0);
                }
                printName(call);
                break;
            case PREFIX:
                printName(call);
                if (call.getArgumentsCount() > 1) {
                    printArgumentList(call, 0);
                } else {
                    printArguments(call, 0);
                }
                break;
            case FUNCTION:
                printName(call);
                printArgumentList(call, 0);
                break;
            default:
                break;
            }
        } else {
            if (call.getArgumentsCount() > 0) {
                call.getArgument(0).accept(this);
            }
        }
        return null;
    }

    /**
     * Prints arguments (see also {@link #printArgumentList(IArgumentProvider, int)}).
     * 
     * @param provider the argument provider
     * @param start the start argument index (usually 0)
     * @throws VilException in case that visiting fails
     */
    protected void printArguments(IArgumentProvider provider, int start) throws VilException {
        for (int a = start; a < provider.getArgumentsCount(); a++) {
            if (a > start) {
                print(", ");
            }
            CallArgument arg = provider.getArgument(a);
            if (arg.hasName()) {
                print(arg.getName());
                print("=");
            }
            provider.getArgument(a).accept(this);
        }
    }
    
    /**
     * Prints an argument list.
     * 
     * @param provider the argument provider
     * @param start the start argument index (usually 0)
     * @throws VilException in case that visiting fails
     */
    protected void printArgumentList(IArgumentProvider provider, int start) throws VilException {
        print("(");
        printArguments(provider, start);
        print(")");
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        Object value = cst.getValue();
        if (value instanceof EnumValue) {
            EnumValue eValue = (EnumValue) value;
            print(eValue.getType());
            print(".");
            print(eValue.getName());
        } else if (value instanceof String) {
            boolean isInComposite = isInComposite();
            if (isInComposite && isInContent) {
                value = ((String) value).replaceAll("'", "\\\\'");
                print(value);
            } else {
                print(StringEscapeUtils.escapeJava((String) value));
            }
        } else if (value instanceof Version) {
            print("v");
            print(value);
        } else {
            if (value == TypeRegistry.NULL) {
                print("null");
            } else {
                print(value);
            }
        }
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException {
        print(identifier.getIdentifier());
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        print(typeExpression.getIdentifier());
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(BuildlangWriter.class, Bundle.ID).warn(
            "unspecific expression visit: " + ex);
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return ex.getExpression().accept(this);
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        String name = cst.getQualifiedName();
        if (null == name) {
            name = cst.getDeclaration().getName();
        }
        print(name);
        return null;
    }
    
    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        if (null != ex.getVariable()) {
            print(ex.getVariable().getName());
            print(".");
            print(ex.getField().getName());
        } else {
            if (null == ex.getNested()) {
                print(ex.getField().getDeclaringType().getName()); // static access
            } else {
                ex.getNested().accept(this);
            }
            print(".");
            print(ex.getField().getName());
        }
        return null;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        print(ex.getVarDecl().getName());
        FieldDescriptor fd = ex.getField();
        if (null != fd) {
            print(".");
            print(fd.getName());
        }
        print(" = ");
        ex.getValueExpression().accept(this);
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        print("{");
        for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
            if (e > 0) {
                print(", ");
            }
            ex.getInitExpression(e).accept(this);
        }
        print("}");
        return null;
    }
    
    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        compositeExpressions.push(ex);
        if (!isInContent) {
            print("\"");
        }
        for (Expression expression : ex.getExpressionList()) {
            if (expression instanceof VariableExpression && !(expression instanceof VariableEx)) {
                print("$");
                expression.accept(this);
            } else if (expression instanceof ConstantExpression) {
                if (isInExpression) {
                    print("\"");
                }
                expression.accept(this);
                if (isInExpression) {
                    print("\"");
                }
            } else {
                isInExpression = true;
                print("${");
                expression.accept(this);
                print("}");
                isInExpression = false;
            }
        }
        if (!isInContent) {
            print("\"");
        }
        compositeExpressions.pop();
        return null;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        print(ex.getOperation().getName()); // the name is used to refer to the function
        return null;
    }
    
    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        print(ex.getVariable().getName());
        printArgumentList(ex, 0);
        return null;
    }
    
    /**
     * Check if Expression is in CompositeExpression.
     * @return boolean
     */
    protected boolean isInComposite() {
        return compositeExpressions.size() > 0;
    }
    
    /**
     * Check if Expression is in content.
     * 
     * @return boolean
     */
    protected boolean isInContent() {
        return isInContent;
    }
    
    /**
     * Set that expression is in content.
     * 
     * @param isInContent boolean
     */
    protected void setInContent(boolean isInContent) {
        this.isInContent = isInContent;
    }

    /**
     * Quotes the given string.
     * 
     * @param string the string to be quoted
     * @param terminal the actual string terminal (" or ')
     * @return the quoted string
     */
/*    protected static String quote(String string, String terminal, boolean quoteEol) {
        // loop would be faster, apache-commons-lang does not do this
        string = string.replace("\b", "\\b");
        string = string.replace("\t", "\\t");
        string = string.replace("\f", "\\f");
        if (quoteEol) {
            string = string.replace("\n", "\\n");
            string = string.replace("\r", "\\r");
        }
        string = string.replace("\b", "\\b");
        //string = string.replace("\\", "\\\\");
        // unicode escape??
        return string.replace(terminal, "\\" + terminal);
    }*/

}
