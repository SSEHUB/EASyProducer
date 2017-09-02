package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends net.ssehub.easy.instantiation.core.model.common.NoTracer 
    implements ITracer {

    public static final ITracer INSTANCE = new NoTracer();

    /**
     * Prevents external instantiation.
     */
    private NoTracer() {
    }

    @Override
    public void visitRule(Rule rule, RuntimeEnvironment<?, ?> environment) {
    }

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment<?, ?> environment, Object result) {
    }

    @Override
    public void visitLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
    }

    @Override
    public void visitIteratorAssignment(IEnumeratingLoop loop, VariableDeclaration var, Object value) {
    }

    @Override
    public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
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
    public void visitScript(Script script, RuntimeEnvironment<?, ?> environment) {
    }
    
    @Override
    public void visitScriptBody(Script script, RuntimeEnvironment<?, ?> environment) {
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

    @Override
    public void visitWhileBody() {
    }

    @Override
    public void visitedWhileBody() {
    }

}
