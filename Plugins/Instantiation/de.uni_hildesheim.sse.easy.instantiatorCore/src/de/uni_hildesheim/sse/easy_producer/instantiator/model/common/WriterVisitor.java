package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionWriter;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * A writer for VIL languages.
 * 
 * @param <V> the actual type of variable declaration
 * 
 * @author Holger Eichelberger
 */
public class WriterVisitor<V extends VariableDeclaration> extends ExpressionWriter implements IVisitor {

    private boolean printExpressionStatementIndentation = true;
    private boolean printExpressionStatementNewLine = true;
    
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

    /**
     * Returns whether a new line after expression statements shall be printed if 
     * {@link #endsWithSemicolon(ExpressionStatement)} is <code>true</code>.
     * 
     * @return whether a new line after expression statements shall be printed
     */
    protected boolean isPrintExpressionStatementNewLine() {
        return printExpressionStatementNewLine;
    }

    /**
     * Changes whether a new line after an expression statement shall be printed if 
     * {@link #endsWithSemicolon(ExpressionStatement)} is <code>true</code>.
     *  
     * @param printExpressionStatementNewLine if a new line shall be printed or not
     */
    protected void setPrintExpressionStatementNewLine(boolean printExpressionStatementNewLine) {
        this.printExpressionStatementNewLine = printExpressionStatementNewLine;
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
        printVersionRestrictions(advice.getVersionRestriction());
        println(")");
        return null;
    }
    
    /**
     * Prints the version restriction.
     * 
     * @param restriction the version restriction (may be <b>null</b>)
     */
    protected void printVersionRestrictions(IVersionRestriction restriction) {
        if (null != restriction) {
            print(" with ");
            print(restriction.toSpecification());
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
        if (endsWithSemicolon(statement)) {
            print(";");
            if (printExpressionStatementNewLine) {
                println();
            }
        }
        return null;
    }
    
    /**
     * Returns whether the given statement ends with a semicolon.
     * 
     * @param statement the statement to check
     * @return <code>true</code> if it ends with a semicolon, <code>false</code> else
     */
    protected boolean endsWithSemicolon(ExpressionStatement statement) {
        return true;
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
