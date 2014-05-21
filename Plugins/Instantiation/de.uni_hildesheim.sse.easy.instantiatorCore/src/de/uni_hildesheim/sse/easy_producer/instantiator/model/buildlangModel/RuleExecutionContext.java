package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;

/**
 * Implements an execution context for a rule.
 * 
 * @author Holger Eichelberger
 */
public class RuleExecutionContext {
    
    private RuntimeEnvironment environment;
    private Rule rule;
    private Set<IArtifact> result;
    private Set<IArtifact> allResults;

    /**
     * Creates a rule execution context.
     * 
     * @param rule the rule being executed
     * @param environment the runtime environment holding the OTHERPROJECTS variable
     */
    RuleExecutionContext(Rule rule, RuntimeEnvironment environment) {
        this.rule = rule;
        this.result = new HashSet<IArtifact>();
        this.allResults = new HashSet<IArtifact>();
        this.environment = environment;
    }
    
    /**
     * Returns the rule being executed.
     * 
     * @return the rule
     */
    Rule getRule() {
        return rule;
    }

    /**
     * Adds an evaluation result to the immediate results.
     * 
     * @param value the value to be added
     */
    void add(Object value) {
        if (value instanceof IArtifact) {
            IArtifact artifact = (IArtifact) value; 
            result.add(artifact);
            environment.getOtherProjects().add(artifact);
        } else if (value instanceof Collection<?>) {
            for (Object val : (Collection<?>) value) {
                add(val);
            }
        }
    }
    
    /**
     * Adds a result artifact.
     * 
     * @param artifact the artifact to be added
     */
    void add(IArtifact artifact) {
        if (null != artifact) {
            result.add(artifact);
        }
    }
    
    /**
     * Adds another rule execution result to the results of previous rule executions.
     * 
     * @param executionResult the result to be added
     */
    void add(RuleExecutionResult executionResult) {
        if (null != executionResult) {
            allResults.addAll(executionResult.allResultsAsCollection());
            allResults.addAll(executionResult.resultAsCollection());
        }
    }
    
    /**
     * Returns all results collected so far as a Java collection.
     * 
     * @return all results
     */
    java.util.Collection<IArtifact> allResultsAsCollection() {
        return allResults;
    }

    /**
     * Returns the results of the execution of {@link #getRule()} as a Java collection.
     * 
     * @return the immediate results
     */
    java.util.Collection<IArtifact> resultAsCollection() {
        return result;        
    }

}