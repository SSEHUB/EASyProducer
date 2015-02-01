package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.NoTracer 
    implements ITracer {

    public static final ITracer INSTANCE = new NoTracer();

    /**
     * Prevents external instantiation.
     */
    private NoTracer() {
    }

    @Override
    public void visitRule(Rule rule, RuntimeEnvironment environment) {
    }

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment environment, Object result) {
    }

    @Override
    public void visitMap(MapExpression map, RuntimeEnvironment environment) {
    }

    @Override
    public void visitMapIteratorAssignment(VariableDeclaration var, Object value) {
    }

    @Override
    public void visitedMap(MapExpression map, RuntimeEnvironment environment) {
    }

    @Override
    public Collection<?> adjustSequenceForMap(Collection<?> collection) {
        return collection;
    }

    @Override
    public Collection<Object> adjustSequenceForJoin(Collection<Object> collection) {
        return collection;
    }

    @Override
    public void visitSystemCall(String[] args) {
    }

    @Override
    public void visitingInstantiator(String name) {
    }

    @Override
    public void visitedInstantiator(String name, Object result) {
    }

    @Override
    public void failedAt(IBuildlangElement element) {
    }

    @Override
    public void visitScript(Script script) {
    }

    @Override
    public void visitedScript(Script script) {
    }

    @Override
    public void visitAlternative(boolean takeIf) {
    }
    
    @Override
    public void reset() {
    }

}
