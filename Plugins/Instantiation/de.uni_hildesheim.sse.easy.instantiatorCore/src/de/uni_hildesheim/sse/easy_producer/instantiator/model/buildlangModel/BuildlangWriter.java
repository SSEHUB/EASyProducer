package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.WriterVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * For writing a buildlanguage model to a print stream. Needed for persisting the 
 * model after external creation / modification. Does currently not consider Comments.
 * 
 * @author Holger Eichelberger
 */
public class BuildlangWriter extends WriterVisitor<VariableDeclaration> implements IBuildlangVisitor {

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public BuildlangWriter(Writer out) {
        super(out);
    }
                
    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException {
        if (StrategyCallExpression.Type.EXECUTE == call.getType()) {
            print("execute ");
        }
        print(call.getName());
        printArgumentList(call, 0);
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException {
        if (ex.isSuper()) {
            print("super.");
        }
        if (null != ex.getPrefix()) {
            print(ex.getPrefix());
            print(Constants.QUALIFICATION_SEPARATOR);
        }
        print(ex.getName());
        printArgumentList(ex, 0);
        return null;
    }

    @Override
    public Object visitScript(Script script) throws VilLanguageException {
        printImports(script);
        for (int a = 0; a < script.getAdviceCount(); a++) {
            script.getAdvice(a).accept(this);
        }
        printIndentation();
        print("vilScript");
        printWhitespace();
        print(script.getName());
        printWhitespace();
        printParameterList(script);
        printWhitespace();
        if (null != script.getSuper()) {
            print("extends ");
            print(script.getSuper().getName());
            printWhitespace();
        }
        println('{');
        println();
        int contained = script.getImportsCount() + script.getRuleCount() + script.getVariableDeclarationCount()
            + script.getPropertiesCount() + o2i(script.getVersion());
        if (contained > 0) {
            println();
            increaseIndentation();
            if (null != script.getVersion()) {
                printIndentation();
                printVersion(script.getVersion());
                println();
            }
            if (script.getPropertiesCount() > 0) {
                for (int l = 0; l < script.getPropertiesCount(); l++) {
                    script.getProperties(l).accept(this);
                }
                println();
            }
            if (script.getVariableDeclarationCount() > 0) {
                int implCount = 0;
                for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
                    VariableDeclaration varDecl = script.getVariableDeclaration(v);
                    if (!script.isImplicit(varDecl)) {
                        script.getVariableDeclaration(v).accept(this);
                    } else {
                        implCount++;
                    }
                }
                if (implCount != script.getVariableDeclarationCount()) {
                    println();
                }
            }
            if (script.getRuleCount() > 0) {
                for (int r = 0; r < script.getRuleCount(); r++) {
                    script.getRule(r).accept(this);
                }
                println();
            }
            decreaseIndentation();
        } else {
            println();
        }
        println('}');
        return null;
    }
    
    /**
     * Prints the imports of <code>script</code>.
     * 
     * @param script the script the versions shall be printed for
     * @throws VilLanguageException in case of problems while printing the version restrictions
     */
    private void printImports(Script script) throws VilLanguageException {
        if (script.getImportsCount() > 0) {
            for (int i = 0; i < script.getImportsCount(); i++) {
                ModelImport<Script> imp = script.getImport(i);
                printIndentation();
                print("import ");
                print(imp.getName());
                printVersionRestrictions(imp);
                println(";");
            }
            println();
        }
    }
    
    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException {
        printIndentation();
        print("load properties \"");
        print(properties.getPath());
        println("\";");
        return null;
    }
    
/*    @Override
    public void visitAlternative(Alternative alt) throws BuildlangException {
    }*/

/*    @Override
    public void visitDefer(Defer defer) throws BuildlangException {
    }*/

/*    @Override
    public void visitLoop(Loop loop) throws BuildlangException {
    }*/

    @Override
    public Object visitRule(Rule rule) throws VilLanguageException {
        printIndentation();
        if (null != rule.getName()) {
            if (rule.isProtected()) {
                print("protected");
                printWhitespace();
            }
            print(rule.getName());
            printParameterList(rule);
            printWhitespace();
            print("=");
            printWhitespace();
        }
        try {
            printRuleConditions(rule, Side.LHS);
            print(": ");
            printRuleConditions(rule, Side.RHS);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        printBlock(rule);
        println();
        
        boolean isLast = false;
        Script script = rule.getParent();
        if (null != script) {
            isLast = script.indexOf(rule) + 1 == script.getRuleCount();
        }
        if (!isLast) {
            println();
        }
        return null;
    }
        
    /**
     * Prints the rule conditions on the specified side.
     * 
     * @param rule the rule to print the conditions for
     * @param side the side (LHS = postconditions, RHS = preconditions)
     * @throws ExpressionException in case that visiting fails
     */
    private void printRuleConditions(Rule rule, Side side) throws ExpressionException {
        int conditionCount = rule.getRuleConditionCount(side);
        for (int c = 0; c < conditionCount; c++) {
            if (c > 0) {
                print(", ");
            }
            rule.getRuleCondition(side, c).accept(this);
        }
        int callCount = rule.getRuleCallCount(side);
        for (int c = 0; c < callCount; c++) {
            if (c  + conditionCount > 0) {
                print(", ");
            }
            rule.getRuleCall(side, c).accept(this);
        }
        if (conditionCount + callCount > 0) {
            print(" ");
        }
        
    }

    /**
     * Prints an entire block including braces.
     * 
     * @param block the block to be printed
     * @throws VilLanguageException in case of visiting problems
     */
    private void printBlock(IRuleBlock block) throws VilLanguageException {
        println("{");
        increaseIndentation();
        for (int b = 0; b < block.getBodyElementCount(); b++) {
            block.getBodyElement(b).accept(this);
        }
        decreaseIndentation();
        printIndentation();
        print("}");
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        print("\"");
        print(expression.getText());
        print("\"");
        return null;
    }
    
    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        return expression.getExpression().accept(this);
    }
    
    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        return expression.getExpression().accept(this);
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        return expression.getExpression().accept(this);
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException {
        print("join(");
        for (int i = 0; i < ex.getVariablesCount(); i++) {
            if (i > 0) {
                print(", ");
            }
            try {
                ex.getVariable(i).accept(this);
            } catch (VilLanguageException e) {
                throw new ExpressionException(e);
            }
        }
        print(")");
        if (null != ex.getCondition()) {
            print(" with (");
            ex.getCondition().accept(this);
            print(")");
        }
        return null;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException {
        if (decl.isExcluded()) {
            print("exclude ");
        }
        print(decl.getName());
        print(":");
        try {
            decl.getExpression().accept(this);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws ExpressionException {
        print("map(");
        for (int v = 0; v < map.getVariablesCount(); v++) {
            if (v > 0) {
                print(",");
            }
            print(map.getVariable(v).getName());
        }
        print("=");
        map.getExpression().accept(this);
        print(") ");
        try {
            printBlock(map);
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        }
        return null;
    }

}
