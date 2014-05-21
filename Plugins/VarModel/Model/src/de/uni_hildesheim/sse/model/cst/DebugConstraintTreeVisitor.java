package de.uni_hildesheim.sse.model.cst;

import java.io.PrintStream;

import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * A visitor for printing out constraint syntax trees. This visitor is particularly
 * intended to exhibit the nesting structure of constraint expressions rather then
 * a concrete syntax.
 * 
 * @author Holger Eichelberger
 */
public class DebugConstraintTreeVisitor implements IConstraintTreeVisitor {

    private PrintStream out;
    private StringBuilder indentation = new StringBuilder();

    /**
     * Creates a visitor to emit on <code>System.out</code>.
     */
    public DebugConstraintTreeVisitor() {
        this(System.out);
    }
    
    /**
     * Creates a visitor to emit on the given stream.
     * 
     * @param out the output stream
     */
    public DebugConstraintTreeVisitor(PrintStream out) {
        this.out = out;
    }
    
    /**
     * Increase indentation.
     */
    private void increaseIndentation() {
        indentation.append("  ");
    }
    
    /**
     * Decrease indentation.
     */
    private void decreaseIndentation() {
        int length = indentation.length();
        if (length > 0) {
            indentation.delete(length - 2, length);
        }
    }

    /**
     * Prints the text (prepending indentation).
     * 
     * @param text the text to be printed
     */
    private void print(String text) {
        out.print(indentation);
        out.print(text);
    }

    /**
     * Prints the text and a line break (prepending indentation).
     * 
     * @param text the text to be printed
     */
    private void println(String text) {
        print(text);
        out.println();
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        println(StringProvider.toIvmlString(value));
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        println(StringProvider.toIvmlString(variable) + " type " + StringProvider.toIvmlString(variable.getVariable()));
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        println("(");
        increaseIndentation();
        parenthesis.getExpr().accept(this);
        decreaseIndentation();
        println(")");
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        println("COMMENT " + comment.getComment());
        increaseIndentation();
        comment.getExpr().accept(this);
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        println("CALL " + call.getOperation() + " with parameter");
        increaseIndentation();
        call.getOperand().accept(this);
        for (int p = 0; p < call.getParameterCount(); p++) {
            call.getParameter(p).accept(this);
        }
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        println("let " + StringProvider.toIvmlString(let.getVariable()) + " in");
        increaseIndentation();
        let.getInExpression().accept(this);
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        println("if-then-else");
        increaseIndentation();
        println("if:");
        ifThen.getIfExpr().accept(this);
        println("then:");
        ifThen.getThenExpr().accept(this);
        println("else:");
        ifThen.getElseExpr().accept(this);
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        println("ContainerCall " + call.getOperation());
        increaseIndentation();
        println("container:");
        call.getContainer().accept(this);
        println("expression:");
        call.getExpression().accept(this);
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        String slot = "";
        if (null != access.getResolvedSlot()) {
            slot = " slot " + StringProvider.toIvmlString(access.getResolvedSlot());
        }
        println("compound access" + slot + " on");
        increaseIndentation();
        access.getCompoundExpression().accept(this);
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        println("DSLFRAGMENT");
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        println("UNRESOLVED");
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        println("COMPOUND INITIALIZER");
        increaseIndentation();
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            println(initializer.getSlot(e) + ":");
            initializer.getExpression(e).accept(this);
        }
        decreaseIndentation();
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        println("CONTAINER INITIALIZER");
        increaseIndentation();
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
        decreaseIndentation();
    }

}
