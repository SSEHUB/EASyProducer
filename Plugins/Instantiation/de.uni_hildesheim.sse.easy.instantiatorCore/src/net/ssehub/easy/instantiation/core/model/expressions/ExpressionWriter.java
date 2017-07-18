package net.ssehub.easy.instantiation.core.model.expressions;

import java.io.Writer;
import java.util.Stack;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;

/**
 * Implements a writer for expressions using the default VIL expression syntax.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionWriter extends AbstractWriter implements IExpressionVisitor {

    /**
     * Detect, warn, report about and write to avoid OCL compliance problems.
     */
    private static boolean oclCompliance = false;

    private transient Stack<CompositeExpression> compositeExpressions = new Stack<CompositeExpression>();
    private transient boolean isInContent = false;
    private transient boolean isInExpression = false;

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public ExpressionWriter(Writer out) {
        super(out);
    }
    
    /**
     * Changes the OCL compliance setting. Similar to IVML, but we separate this in case
     * that the UI shall do different settings for IVML and VIL.
     * 
     * @param compliance operate with OCL compliance (<code>true</code>), allow both IVML + OCL (<code>false</code>
     */
    public static void setOclCompliance(boolean compliance) {
        oclCompliance = compliance;
    }
    
    /**
     * Returns whether OCL compliance shall be considered. Similar to IVML, but we separate this in case
     * that the UI shall do different settings for IVML and VIL.
     * 
     * @return <code>true</code> for OCL compliance, <code>false</code> else
     */
    public static boolean considerOclCompliance() {
        return oclCompliance;
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
     * @throws VilException if visiting fails
     */
    private void printIteratorDeclarators(CallExpression call) throws VilException {
        if (call.isIteratorCall()) {
            ExpressionEvaluator eval = (ExpressionEvaluator) call.getArgument(1).getExpression();
            int done = 0;
            for (int d = 0; d < eval.getDeclaratorsCount(); d++) {
                VariableDeclaration decl = eval.getDeclarator(d);
                if (!decl.isImplicit()) {
                    if (d > 0) {
                        if (decl.hasExplicitType()) {
                            print(";");    
                        } else {
                            print(",");
                        }
                        printWhitespace();
                    }
                    if (decl.hasExplicitType()) {
                        printType(decl.getType());
                        printWhitespace();
                    }
                    print(decl.getName());
                    printWhitespace();
                    if (null != decl.getExpression()) {
                        print("=");
                        printWhitespace();
                        decl.getExpression().accept(this);
                    }
                    done++;
                }
            }
            if (done > 0) {
                print(Constants.DECLARATOR_SEPARATOR);
                printWhitespace();
            }
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
                    printCallAccess(call);
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
     * Prints the call access operator.
     * 
     * @param call the call to print
     * @throws VilException in case of type resolution problems
     */
    private void printCallAccess(CallExpression call) throws VilException {
        if (call.isIteratorCall()) {
            print(Constants.ITER_CALL);
        } else {
            if (considerOclCompliance() && call.getArgument(0).inferType().isCollection()) {
                print(Constants.ITER_CALL);
            } else {
                print(".");
            }
        }
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
            print(eValue.getTypeName());
            if (considerOclCompliance()) {
                print("::");
            } else {
                print(".");
            }
            print(eValue.getName());
        } else if (value instanceof String) {
            boolean isInComposite = isInComposite();
            if (isInComposite && isInContent) {
                String tmp = (String) value;
                tmp = tmp.replace("\\", "\\\\");
                tmp = tmp.replaceAll("'", "\\\\'");
                print(tmp);
            } else {
                printJavaEscaped((String) value);
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
        if (!ex.isImplicit()) { // has then only one init expression
            print("{");
        }
        for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
            if (e > 0) {
                print(", ");
            }
            ex.getInitExpression(e).accept(this);
        }
        if (!ex.isImplicit()) { 
            print("}");
        }
        return null;
    }
    
    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        compositeExpressions.push(ex);
        if (!isInContent) {
            print("\"");
        }
        printContentExpressions(ex);
        if (!isInContent) {
            print("\"");
        }
        compositeExpressions.pop();
        return null;
    }

    /**
     * Prints a content expressions given by an expression iterator.
     * 
     * @param iter the expression iterator
     * @throws VilException if printing fails for some reason
     */
    protected void printContentExpressions(IExpressionIterator iter) throws VilException {
        for (int e = 0; e < iter.getExpressionsCount(); e++) {
            Expression expression = iter.getExpression(e);
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
                boolean before = isInExpression;
                boolean quote = quoteExpression(expression);
                isInExpression = quote;
                if (quote) {
                    print("${");
                }
                expression.accept(this);
                if (quote) {
                    print("}");
                }
                isInExpression = before;
            }
        }
    }
    
    /**
     * Returns if visiting <code>expression</code> in {@link #printContentExpressions(IExpressionIterator)}
     * shall lead to quote constant expressions or unquoted constant expressionsisInExpression.
     * 
     * @param expression the expression to visit
     * @return <code>true</code> for quoting, <code>false</code> else
     */
    protected boolean quoteExpression(Expression expression) {
        return true;
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

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        for (int e = 0; e < ex.getExpressionCount(); e++) {
            AbstractCallExpression expr = ex.getExpression(e);
            if (expr.getArgumentsCount() > 0) {
                if (0 == e) {
                    expr.getArgument(0).accept(this);
                }
                for (int a = 1; a < expr.getArgumentsCount(); a++) {
                    printWhitespace();
                    print(expr.getName());
                    printWhitespace();
                    expr.getArgument(a).accept(this);
                }
            }
        }
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
