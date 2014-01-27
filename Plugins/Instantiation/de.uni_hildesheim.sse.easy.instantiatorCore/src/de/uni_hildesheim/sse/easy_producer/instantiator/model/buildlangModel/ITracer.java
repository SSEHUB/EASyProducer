package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;

/**
 * A simple tracer interface providing test support to the execution part.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ITracer {
    
    /**
     * Is called when a script is being visited.
     * 
     * @param script the script
     */
    public void visitScript(Script script);

    /**
     * Is called when visiting a script ends.
     * 
     * @param script the script
     */
    public void visitedScript(Script script);
    
    /**
     * Is called when visiting a rule starts.
     * 
     * @param rule the rule being visited
     * @param environment the runtime environment
     */
    public void visitRule(Rule rule, RuntimeEnvironment environment);

    /**
     * Is called when visiting a rule ends.
     * 
     * @param rule the rule being visited
     * @param environment the runtime environment
     * @param result the result produced by the rule
     */
    public void visitedRule(Rule rule, RuntimeEnvironment environment, Object result);

    /**
     * Is called when visiting a map starts.
     * 
     * @param map the map being visited
     * @param environment the runtime environment
     */
    public void visitMap(MapExpression map, RuntimeEnvironment environment);

    /**
     * Is called when visiting a map starts.
     * 
     * @param var the map iterator variable
     * @param value the actual value
     */
    public void visitMapIteratorAssignment(VariableDeclaration var, Object value);
    
    /**
     * Is called when visiting a map ends.
     * 
     * @param map the map being visited
     * @param environment the runtime environment
     */
    public void visitedMap(MapExpression map, RuntimeEnvironment environment);

    /**
     * Allows a tracer to change the sequence of processing a map collection.
     * This is intended for testing and debugging only as it normalizes and, thus, interfers
     * with the actual execution sequence.
     * 
     * @param collection the collection to be considered
     * @return the new sequence (just the elements may be reordered)
     */
    public Collection<?> adjustSequenceForMap(Collection<?> collection);

    /**
     * Allows a tracer to change the sequence of processing a map collection.
     * This is intended for testing and debugging only as it normalizes and, thus, interfers
     * with the actual execution sequence.
     * 
     * @param collection the collection to be considered
     * @return the new sequence (just the elements may be reordered)
     */
    public Collection<Object> adjustSequenceForJoin(Collection<Object> collection);

    /**
     * Is called before executing a system call.
     * 
     * @param args the arguments for the system call
     */
    public void visitSystemCall(String[] args);
   
    /**
     * Is called when an instantiator is being visited / executed.
     * 
     * @param name the name of the instantiator
     */
    public void visitingInstantiator(String name);
    
    /**
     * Is called when an instantiator was visited / executed.
     * 
     * @param name the name of the instantiator
     * @param result the result of the execution
     */
    public void visitedInstantiator(String name, Object result);

    /**
     * Is called when the execution of a build language element failed.
     * 
     * @param element the failed element
     */
    public void failedAt(IBuildlangElement element);

}
