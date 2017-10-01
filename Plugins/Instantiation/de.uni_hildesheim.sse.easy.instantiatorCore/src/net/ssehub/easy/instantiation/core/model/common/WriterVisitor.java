package net.ssehub.easy.instantiation.core.model.common;

import java.io.Writer;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor.SlotDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;

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

    /**
     * Prints the modifiers of the given modifier <code>holder</code>.
     * 
     * @param holder the modifier holder
     */
    protected void printModifiers(IModifierHolder holder) {
    }
    
    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        printIndentation();
        printModifiers(var);
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
            var.getExpression().accept(this);
        }
        println(";");
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        printIndentation();
        print("@advice(");
        print(advice.getName());
        printVersionRestrictions(advice.getVersionRestriction(), false);
        println(")");
        return null;
    }
    
    /**
     * Prints the version restriction.
     * 
     * @param restriction the version restriction (may be <b>null</b>)
     * @param capitalize whether the "with" shall be stated in capital letters
     */
    protected void printVersionRestrictions(IVersionRestriction restriction, boolean capitalize) {
        if (null != restriction) {
            String with = " with ";
            if (capitalize) {
                with = with.toUpperCase();
            }
            print(with);
            print(restriction.toSpecification());
        }
    }
    
    /**
     * Prints the parameter list of <code>parameterizable</code>.
     * 
     * @param parameterizable the element to print the parameter list
     * @throws VilException in case that visiting fails
     */
    protected void printParameterList(IParameterizable<V> parameterizable) 
        throws VilException {
        print('(');
        for (int p = 0; p < parameterizable.getParameterCount(); p++) {
            if (p > 0) {
                print(",");
                printWhitespace();
            }
            V param = parameterizable.getParameter(p);
            printType(param.getType());
            printWhitespace();
            print(param.getName());
            if (null != param.getExpression()) {
                print("=");
                param.getExpression().accept(this);
            }
        }
        print(')');
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        if (printExpressionStatementIndentation) {
            printIndentation();
        }
        statement.getExpression().accept(this);
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

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        printIndentation();
        print("typedef");
        printWhitespace();
        print(typedef.getName());
        printWhitespace();
        print(typedef.getType().getVilName());
        println(";");
        return null;
    }
    
    /**
     * Prints the typedefs of <code>model</code>.
     * 
     * @param <R> the parameter type
     * @param <M> the model type
     * @param model the model to print the typedefs for
     * @throws VilException in case of printing problems
     */
    protected <R extends IMetaParameterDeclaration, M extends IModel> void printTypedefs(
        AbstractResolvableModel<R, M> model) throws VilException {
        for (int t = 0; t < model.getTypedefCount(); t++) {
            model.getTypedef(t).accept(this);
        }
    }

    /**
     * Prints the typedefs of <code>model</code>.
     * 
     * @param <R> the parameter type
     * @param <M> the model type
     * @param model the model to print the typedefs for
     * @throws VilException in case of printing problems
     */
    protected <R extends IMetaParameterDeclaration, M extends IModel> void printCompounds(
        AbstractResolvableModel<R, M> model) throws VilException {
        for (int c = 0; c < model.getCompoundCount(); c++) {
            model.getCompound(c).accept(this);
        }
    }

    @Override
    public Object visitCompound(Compound compound) throws VilException {
        printIndentation();
        if (compound.isAbstract()) {
            print("abstract ");
        }
        print("compound ");
        print(compound.getName());
        if (null != compound.getRefines()) {
            print(" refines ");
            print(compound.getRefines().getName());
        }
        println(" {");
        increaseIndentation();
        for (int s = 0; s < compound.getSlotsCount(); s++) {
            SlotDescriptor slot = compound.getSlot(s);
            printIndentation();
            printModifiers(slot);
            if (slot.isConstant()) {
                print("const ");
            }
            printType(slot.getType());
            printWhitespace();
            print(slot.getName());
            if (null != slot.getExpression()) {
                printWhitespace();
                print('=');
                printWhitespace();
                slot.getExpression().accept(this);
            }
            println(";");
        }
        decreaseIndentation();
        printIndentation();
        println("}");
        return null;
    }

}
