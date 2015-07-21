/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.BooleanMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CompoundMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.WriterVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
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
    
    /**
     * Returns whether the given statement ends with a semicolon.
     * 
     * @param statement the statement to check
     * @return <code>true</code> if it ends with a semicolon, <code>false</code> else
     */
    protected boolean endsWithSemicolon(ExpressionStatement statement) {
        return !(statement.getExpression() instanceof AlternativeExpression);
    }
    
    /**
     * Prints a string in quotes.
     * 
     * @param string the string to be printed
     */
    private void printString(String string) {
        print("\"");
        print(string);
        print("\"");
    }
                
    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        if (StrategyCallExpression.Type.EXECUTE == call.getType()) {
            print("execute ");
        }
        print(call.getName());
        printArgumentList(call, 0);
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
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
    
    /**
     * Returns the language element name for a "script". [extensibility]
     * 
     * @return the language element name ("vilScript")
     */
    protected String getScriptElementName() {
        return "vilScript";
    }
     
    /**
     * Prints the header of <code>script</code>. [extensibility]
     * 
     * @param script the script to be printed
     * @throws VilException in case that printing the script header fails
     * @see #getScriptElementName()
     */
    protected void printScriptHeader(Script script) throws VilException {
        printImports(script);
        printVtlRestrictions(script);
        for (int a = 0; a < script.getAdviceCount(); a++) {
            script.getAdvice(a).accept(this);
        }
        printIndentation();
        print(getScriptElementName());
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
    }

    /**
     * Returns whether <code>script</code> has contained elements. [extensibility]
     * 
     * @param script the script to consider
     * @return <code>true</code> if <code>script</code> has contained elements, <code>false</code> if 
     *     <code>script</code> is empty
     */
    protected boolean hasContainedElements(Script script) {
        return script.getImportsCount() + script.getRuleCount() + script.getVariableDeclarationCount()
            + script.getPropertiesCount() + o2i(script.getVersion()) > 0;
    }
    
    /**
     * Prints the script contents. [extensibility]
     * 
     * @param script the script to be printed
     * @throws VilException in case that printing the script contents fails
     * @see #printScriptContentsBeforeRules(Script)
     */
    protected void printScriptContents(Script script) throws VilException {
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
        if (script.getTypedefCount() > 0) {
            printTypedefs(script);
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
        printScriptContentsBeforeRules(script);
        if (script.getRuleCount() > 0) {
            for (int r = 0; r < script.getRuleCount(); r++) {
                script.getRule(r).accept(this);
            }
            println();
        }
    }

    /**
     * Prints the script contents before rules. [extensibility]
     * 
     * @param script the script to be printed
     * @throws VilException in case that printing the script contents fails
     */
    protected void printScriptContentsBeforeRules(Script script) throws VilException {
    }
    
    /**
     * Prints an entire script. [extensibility]
     * 
     * @param script the script to be printed
     * @throws VilException
     * @see #printScriptHeader(Script)
     * @see #hasContainedElements(Script)
     * @see #printScriptContents(Script)
     * @throws VilException in case that printing the script fails
     */
    protected void printScript(Script script) throws VilException {
        printScriptHeader(script);
        println('{');
        println();
        if (hasContainedElements(script)) {
            println();
            increaseIndentation();
            printScriptContents(script);
            decreaseIndentation();
        } else {
            println();
        }
        println('}');
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        printScript(script);
        return null;
    }
    
    /**
     * Prints the imports of <code>script</code>.
     * 
     * @param script the script the versions shall be printed for
     * @throws VilException in case of problems while printing the version restrictions
     */
    private void printImports(Script script) throws VilException {
        if (script.getImportsCount() > 0) {
            for (int i = 0; i < script.getImportsCount(); i++) {
                ModelImport<Script> imp = script.getImport(i);
                printIndentation();
                print("import ");
                print(imp.getName());
                printVersionRestrictions(imp.getVersionRestriction());
                println(";");
            }
            println();
        }
    }
    
    /**
     * Prints the VTL restrictions.
     * 
     * @param script the script the versions shall be printed for
     * @throws VilException in case of problems while printing the version restrictions
     */
    private void printVtlRestrictions(Script script) throws VilException {
        if (script.getVtlRestrictionsCount() > 0) {
            for (int i = 0; i < script.getVtlRestrictionsCount(); i++) {
                ModelImport<Template> imp = script.getVtlRestriction(i);
                printIndentation();
                print("requireVTL ");
                printString(imp.getName());
                printVersionRestrictions(imp.getVersionRestriction());
                println(";");
            }
            println();
        }
    }
    
    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        printIndentation();
        print("load properties ");
        printString(properties.getPath());
        println(";");
        return null;
    }
    
    @Override
    public Object visitRule(Rule rule) throws VilException {
        printIndentation();
        if (null != rule.getName()) {
            if (rule.isProtected()) {
                print("protected");
                printWhitespace();
            }
            if (rule.getDefaultReturnType() != rule.getReturnType()) { // show only for "functions"
                printType(rule.getReturnType());
                printWhitespace();
            }
            print(rule.getName());
            printParameterList(rule);
            printWhitespace();
            print("=");
            printWhitespace();
        }
        printRuleConditions(rule, Side.LHS);
        print(": ");
        printRuleConditions(rule, Side.RHS);
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
     * @throws VilException in case that visiting fails
     */
    protected void printRuleConditions(Rule rule, Side side) throws VilException {
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
     * Prints the actual block contents.
     * 
     * @param block the block to be printed
     * @throws VilException in case of visiting problems
     */
    protected void printBlockContents(IRuleBlock block) throws VilException {
        for (int b = 0; b < block.getBodyElementCount(); b++) {
            block.getBodyElement(b).accept(this);
        }
    }

    /**
     * Prints an entire block including braces.
     * 
     * @param block the block to be printed
     * @throws VilException in case of visiting problems
     * @see #printBlockContents(IRuleBlock)
     */
    protected void printBlock(IRuleBlock block) throws VilException {
        boolean exprIndent = isPrintExpressionStatementIndentation();
        boolean exprNewLine = isPrintExpressionStatementNewLine();
        boolean emitBrackets = !block.isVirtual();
        if (emitBrackets) {
            println("{");
            increaseIndentation();
        } else {
            setPrintExpressionStatementIndentation(false);
            setPrintExpressionStatementNewLine(false);
        }
        printBlockContents(block);
        if (emitBrackets) {
            decreaseIndentation();
            printIndentation();
            print("}");
        } else {
            setPrintExpressionStatementIndentation(exprIndent);
            setPrintExpressionStatementNewLine(exprNewLine);
        }
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        printString(expression.getText());
        return null;
    }
    
    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        return expression.getExpression().accept(this);
    }
    
    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return expression.getExpression().accept(this);
    }
    
    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        return expression.getExpression().accept(this);
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        return expression.getExpression().accept(this);
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        print("join(");
        for (int i = 0; i < ex.getVariablesCount(); i++) {
            if (i > 0) {
                print(", ");
            }
            ex.getVariable(i).accept(this);
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
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        if (decl.isExcluded()) {
            print("exclude ");
        }
        print(decl.getName());
        print(":");
        decl.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        print("map(");
        for (int v = 0; v < map.getVariablesCount(); v++) {
            TypeDescriptor<?> givenType = map.getGivenType(v);
            if (null != givenType) {
                print(givenType.getVilName());
                print(" ");
            }
            if (v > 0) {
                print(",");
            }
            print(map.getVariable(v).getName());
        }
        if (map.isColonSeparator()) {
            print(Constants.COLON);
        } else {
            print(Constants.ASSIGNMENT);
        }
        map.getExpression().accept(this);
        print(") ");
        printBlock(map);
        return null;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        print("instantiate ");
        if (null != inst.getProject()) {
            print(inst.getProject().getName());
            if (null != inst.getName()) {
                print(" rule ");
                printString(inst.getName());
            }
        } else {
            printString(inst.getQualifiedName());
        }
        print(" ");
        printArgumentList(inst, 0);
        printVersionRestrictions(inst.getVersionRestriction());
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        print("if (");
        alt.getCondition().accept(this);
        print(") ");
        printBlock(alt.getIfPart());
        if (null != alt.getElsePart()) {
            print(" else ");
            printBlock(alt.getElsePart());
        } 
        println();
        return null;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return expression.getCompositeExpression().accept(this);
    }

}
