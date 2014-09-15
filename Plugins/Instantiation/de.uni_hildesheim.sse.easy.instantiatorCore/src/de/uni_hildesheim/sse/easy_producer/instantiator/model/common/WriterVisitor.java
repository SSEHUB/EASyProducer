package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionWriter;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestrictable;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

/**
 * A writer for VIL languages.
 * 
 * @param <V> the actual type of variable declaration
 * 
 * @author Holger Eichelberger
 */
public class WriterVisitor<V extends VariableDeclaration> extends ExpressionWriter implements IVisitor {

    private boolean printExpressionStatementIndentation = true;
    
    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public WriterVisitor(Writer out) {
        super(out);
    }

    /**
     * Returns whether indentations at expression statements shall be printed.
     * 
     * @return whether indentations at expression statements shall be printed
     */
    protected boolean isPrintExpressionStatementIndentation() {
        return printExpressionStatementIndentation;
    }

    /**
     * Changes whether indentations at expression statements shall be printed.
     *  
     * @param printExpressionStatementIndentation if indentations shall be printed or not
     */
    protected void setPrintExpressionStatementIndentation(boolean printExpressionStatementIndentation) {
        this.printExpressionStatementIndentation = printExpressionStatementIndentation;
    }
    
    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilLanguageException {
        printIndentation();
        if (var.isConstant()) {
            print("const ");
        }
        printType(var.getType());
        printWhitespace();
        print(var.getName());
        if (null != var.getExpression()) {
            printWhitespace();
            print('=');
            printWhitespace();
            try {
                var.getExpression().accept(this);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
        }
        println(";");
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilLanguageException {
        printIndentation();
        print("@advice(");
        print(advice.getName());
        printVersionRestrictions(advice);
        println(")");
        return null;
    }
    
    /**
     * Prints the version restrictions.
     * 
     * @param restrictable the restricted element
     * @throws VilLanguageException in case that visiting fails
     */
    protected void printVersionRestrictions(IVersionRestrictable restrictable) throws VilLanguageException {
        if (restrictable.getRestrictionsCount() > 0) {
            print(" with (");
            for (int r = 0; r < restrictable.getRestrictionsCount(); r++) {
                VersionRestriction restriction = restrictable.getRestriction(r);
                if (r > 0) {
                    print(", ");
                }
                print("version ");
                print(IvmlKeyWords.toText(restriction.getOperator()));
                print(" v");
                print(restriction.getVersion().toString());
            }
            print(")");
        }
    }
    
    /**
     * Prints the parameter list of <code>parameterizable</code>.
     * 
     * @param parameterizable the element to print the parameter list
     * @throws VilLanguageException in case that visiting fails
     */
    protected void printParameterList(IParameterizable<V> parameterizable) 
        throws VilLanguageException {
        print('(');
        for (int p = 0; p < parameterizable.getParameterCount(); p++) {
            if (p > 0) {
                print(",");
                printWhitespace();
            }
            V varDecl = parameterizable.getParameter(p);
            printType(varDecl.getType());
            printWhitespace();
            print(varDecl.getName());
        }
        print(')');
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilLanguageException {
        if (printExpressionStatementIndentation) {
            printIndentation();
        }
        try {
            statement.getExpression().accept(this);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        println(";");
        return null;
    }

    /**
     * Prints the version.
     * 
     * @param ver the version to be printed
     */
    protected void printVersion(Version ver)  {
        if (null != ver) {
            print("version v");
            print(ver.toString());
            println(";");
        }
    }

    
    /**
     * Returns <code>0</code> of object is <b>null</b> else <code>1</code>.
     * 
     * @param object the object to be tested
     * @return <code>0</code> of object is <b>null</b> else <code>1</code>
     */
    protected static final int o2i(Object object) {
        return null == object ? 0 : 1;
    }

}
