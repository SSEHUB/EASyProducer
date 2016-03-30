package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.io.Writer;

import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.AbstractBreakdownCall.TupleField;

/**
 * Defines the output writer for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilWriter extends BuildlangWriter implements IRtVilVisitor {

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public RtVilWriter(Writer out) {
        super(out);
    }

    @Override
    protected String getScriptElementName() {
        return "rtVilScript";
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        super.visitScript(script);
        return null;
    }

    @Override
    protected void printModifiers(VariableDeclaration var) {
        if (var.hasModifier(VariableDeclarationModifier.PERSISTENT)) {
            print("persistent");
            printWhitespace();
        }
    }
    
    /**
     * Returns whether <code>script</code> has contained elements. [extensibility]
     * 
     * @param script the script to consider
     * @return <code>true</code> if <code>script</code> has contained elements, <code>false</code> if 
     *     <code>script</code> is empty
     */
    protected boolean hasContainedElements(
        net.ssehub.easy.instantiation.core.model.buildlangModel.Script script) {
        boolean result = super.hasContainedElements(script);
        if (script instanceof Script) {
            Script scr = (Script) script;
            result |= scr.getStrategiesCount() + scr.getTacticsCount() > 0;
        }
        return result;
    }
    
    /**
     * Prints the script contents. [extensibility]
     * 
     * @param script the script to be printed
     * @throws VilException in case that printing the script contents fails
     */
    @Override
    protected void printScriptContentsBeforeRules(
        net.ssehub.easy.instantiation.core.model.buildlangModel.Script script) 
        throws VilException {
        if (script instanceof Script) {
            Script scr = (Script) script;
            for (int s = 0; s < scr.getStrategiesCount(); s++) {
                scr.getStrategy(s).accept(this);
            }
            for (int t = 0; t < scr.getTacticsCount(); t++) {
                scr.getTactic(t).accept(this);
            }
        }
    }

    @Override
    public Object visitStrategy(Strategy strategy) throws VilException {
        printIndentation();
        print("strategy");
        printWhitespace();
        print(strategy.getName());
        printParameterList(strategy);
        printWhitespace();
        print("=");
        printWhitespace();
        if (strategy.hasCondition(Side.LHS) || strategy.hasCondition(Side.RHS)) {
            printRuleConditions(strategy, Side.LHS);
            print(": ");
            printRuleConditions(strategy, Side.RHS);
        }
        printBlock(strategy); // local
        println();
        
        println();
        return null;
    }
    
    @Override
    protected void printBlockContents(IRuleBlock block) throws VilException {
        Strategy strategy = block instanceof Strategy ? (Strategy) block : null;
        Tactic tactic = block instanceof Tactic ? (Tactic) block : null;
        if (null != strategy) {
            for (int v = 0; v < strategy.getVariableDeclarationCount(); v++) {
                strategy.getVariableDeclaration(v).accept(this);
            }
            if (null != strategy.getObjective()) {
                printIndentation();
                print("objective");
                printWhitespace();
                strategy.getObjective().accept(this);
                println(";");
            }
            printIndentation();
            print("breakdown");
            printWhitespace();
            println("{");
            increaseIndentation();
            WeightingFunction wf = strategy.getWeightingFunction(); 
            if (null != wf) {
                printIndentation();
                print("weighting");
                printWhitespace();
                print("(");
                print(wf.getVariable().getName()); // no full declaration here
                printWhitespace();
                print(":");
                printWhitespace();
                wf.getExpression().accept(this);
                println(");");
            }
        }
        if (null != tactic) {
            ExpressionStatement intent = tactic.getIntent();
            if (null != intent) {
                print("intent");
                printWhitespace();
                intent.accept(this);
            }
        }
        super.printBlockContents(block);
        if (null != strategy) {
            decreaseIndentation();
            printIndentation();
            println("}");
            IRuleBlock post = strategy.getPostprocessing();
            if (null != post) { 
                printBlockContents(post);
            }
        }
    }

    @Override
    public Object visitTactic(Tactic tactic) throws VilException {
        printIndentation();
        print("tactic");
        printWhitespace();
        print(tactic.getName());
        printParameterList(tactic);
        printWhitespace();
        print("=");
        printWhitespace();
        if (tactic.hasCondition(Side.LHS) || tactic.hasCondition(Side.RHS)) {
            printRuleConditions(tactic, Side.LHS);
            print(": ");
            printRuleConditions(tactic, Side.RHS);
        }
        printBlock(tactic);
        println();
        
        println();
        return null;
    }

    @Override
    public Object visitStrategyCall(StrategyCall call) throws VilException {
        printBreakdownCall("strategy", call);
        return null;
    }

    @Override
    public Object visitTacticCall(TacticCall call) throws VilException {
        printBreakdownCall("tactic", call);
        return null;
    }
    
    /**
     * Prints a breakdown call.
     * 
     * @param keyword the keyword to indicate the call
     * @param call the call itself
     * @throws VilException in case of problems accessing or printing parts
     */
    private void printBreakdownCall(String keyword, AbstractBreakdownCall call) throws VilException {
        printIndentation();
        print(keyword);
        printWhitespace();
        Expression guard = call.getGuardExpression();
        if (null != guard) {
            print("(");
            guard.accept(this);
            print(")");
            printWhitespace(); 
        }
        print(call.getName());
        print("(");
        printArguments(call, 0);
        print(")");
        int tfCount = call.getTupleFieldCount();
        if (tfCount > 0) {
            printWhitespace();
            print("with");
            printWhitespace();
            print("(");
            for (int f = 0; f < tfCount; f++) {
                if  (f > 0) {
                    print(",");
                    printWhitespace();
                }
                TupleField field = call.getTupleField(f);
                print(field.getName());
                printWhitespace();
                print("=");
                printWhitespace();
                field.getValueExpression().accept(this);
            }
            print(")");
        }
        Expression timeout = call.getTimeoutExpression();
        if (null != timeout) {
            printWhitespace();
            print("@");
            timeout.accept(this);
        }
        println(";");
    }

    @Override
    public Object visitFailStatement(FailStatement statement) throws VilException {
        printIndentation();
        if (statement.isRefail()) {
            print("refail");    
        } else {
            print("fail");
            if (null != statement.getReasonEx()) {
                printWhitespace();
                statement.getReasonEx().accept(this);
            }
            if (null != statement.getCodeEx()) {
                printWhitespace();
                print("with");
                printWhitespace();
                statement.getCodeEx().accept(this);
            }
        }
        println(";");
        return null;
    }

}
