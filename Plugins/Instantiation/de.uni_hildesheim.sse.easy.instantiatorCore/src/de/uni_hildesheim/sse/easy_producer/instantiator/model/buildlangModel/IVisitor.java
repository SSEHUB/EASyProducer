package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.IMatchVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;

/**
 * A visitor interface for the build language elements.
 * 
 * @author Holger Eichelberger
 */
public interface IVisitor extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVisitor, 
    IMatchVisitor {
    
    /**
     * Visits a script.
     * 
     * @param script the project instance
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitScript(Script script) throws VilLanguageException;

    /**
     * Visits a load properties directive.
     * 
     * @param properties the load properties representation
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException;
    
    /**
     * Visits a strategy call node.
     * 
     * @param call the node
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException;

    /**
     * Visits a rule call expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException;

    /**
     * Visits a join expression.
     * 
     * @param ex the join expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException;
    
    /**
     * Visits a join variable declaration.
     * 
     * @param decl the declaration
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException;
    
    /**
     * Visits an alternative.
     * 
     * @param alt the alternative
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitAlternativeExpression(AlternativeExpression alt) throws ExpressionException;

    /**
     * Visits a rule.
     * 
     * @param rule the rule
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object visitRule(Rule rule) throws VilLanguageException;

    /**
     * Visits a map expression.
     * 
     * @param map the expression to be visited
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitMapExpression(MapExpression map) throws ExpressionException;
    
    /**
     * Visits an instantiate expression.
     * 
     * @param inst the instantiation expression
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitInstantiateExpression(InstantiateExpression inst) throws ExpressionException;

}
