package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.IMatchVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

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
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitScript(Script script) throws VilException;

    /**
     * Visits a load properties directive.
     * 
     * @param properties the load properties representation
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitLoadProperties(LoadProperties properties) throws VilException;
    
    /**
     * Visits a strategy call node.
     * 
     * @param call the node
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException;

    /**
     * Visits a rule call expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException;

    /**
     * Visits a join expression.
     * 
     * @param ex the join expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitJoinExpression(JoinExpression ex) throws VilException;
    
    /**
     * Visits a join variable declaration.
     * 
     * @param decl the declaration
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException;
    
    /**
     * Visits an alternative.
     * 
     * @param alt the alternative
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException;

    /**
     * Visits a rule.
     * 
     * @param rule the rule
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitRule(Rule rule) throws VilException;

    /**
     * Visits a map expression.
     * 
     * @param map the expression to be visited
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitMapExpression(MapExpression map) throws VilException;

    /**
     * Visits a while statement.
     * 
     * @param stmt the statement to be visited
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitWhileStatement(WhileStatement stmt) throws VilException;

    /**
     * Visits a for statement.
     * 
     * @param stmt the statement to be visited
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitForStatement(ForStatement stmt) throws VilException;
    
    /**
     * Visits an instantiate expression.
     * 
     * @param inst the instantiation expression
     * @return the result of visiting the given expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException;

}
