package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Implements a writer for expressions using the default VIL expression syntax.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionWriter extends AbstractWriter implements IExpressionVisitor {

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public ExpressionWriter(Writer out) {
        super(out);
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
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

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
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
                    print(".");
                    printName(call);
                    printArgumentList(call, 1);
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
     * @throws ExpressionException in case that visiting fails
     */
    protected void printArguments(IArgumentProvider provider, int start) throws ExpressionException {
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
     * @throws ExpressionException in case that visiting fails
     */
    protected void printArgumentList(IArgumentProvider provider, int start) throws ExpressionException {
        print("(");
        printArguments(provider, start);
        print(")");
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        Object value = cst.getValue();
        if (value instanceof String) {
            print("\"");
            print(value);
            print("\"");
        } else {
            print(cst.getValue());
        }
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        print(identifier.getIdentifier());
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        print(typeExpression.getIdentifier());
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        EASyLoggerFactory.INSTANCE.getLogger(BuildlangWriter.class, Bundle.ID).warn(
            "unspecific expression visit: " + ex);
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        return ex.getExpression().accept(this);
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        String name = cst.getQualifiedName();
        if (null == name) {
            name = cst.getDeclaration().getName();
        }
        print(name);
        return null;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        print(ex.getVarDecl().getName());
        print(" = ");
        ex.getValueExpression().accept(this);
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        print("{");
        for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
            if (e > 0) {
                print(", ");
            }
            ex.getInitExpression(e).accept(this);
        }
        print("}");
        // TODO Auto-generated method stub
        return null;
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
