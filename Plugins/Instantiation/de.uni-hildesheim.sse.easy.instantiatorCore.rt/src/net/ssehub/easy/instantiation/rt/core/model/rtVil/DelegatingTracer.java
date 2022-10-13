/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.util.Locale;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IEnumeratingLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.ITraceFilter;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Delegates tracing.
 * 
 * @author Holger Eichelberger
 */
public class DelegatingTracer implements ITracer {

    private net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer delegate;

    /**
     * Creates a delegating tracer.
     * 
     * @param delegate the delegate
     */
    public DelegatingTracer(net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer delegate) {
        this.delegate = delegate;
    }
    
    /**
     * Returns the delegate.
     * 
     * @return the delegate
     */
    protected net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer getDelegate() {
        return delegate;
    }
    
    @Override
    public void visitScript(Script script, RuntimeEnvironment<?, ?> environment) {
        delegate.visitScript(script, environment);
    }

    @Override
    public void visitedScript(Script script) {
        delegate.visitedScript(script);
    }
    
    @Override
    public void visitScriptBody(Script script, RuntimeEnvironment<?, ?> environment) {
        delegate.visitScriptBody(script, environment);
    }

    @Override
    public void visitRule(Rule rule, RuntimeEnvironment<?, ?> environment) {
        delegate.visitRule(rule, environment);
    }

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment<?, ?> environment, Object result) {
        delegate.visitedRule(rule, environment, result);
    }

    @Override
    public void visitLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
        delegate.visitLoop(loop, environment);
    }

    @Override
    public void visitIteratorAssignment(IEnumeratingLoop loop, VariableDeclaration var, Object value) {
        delegate.visitIteratorAssignment(loop, var, value);
    }

    @Override
    public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
        delegate.visitedLoop(loop, environment);
    }

    @Override
    public Collection<?> adjustSequenceForMap(Collection<?> collection) {
        return delegate.adjustSequenceForMap(collection);
    }

    @Override
    public Collection<Object> adjustSequenceForJoin(Collection<Object> collection) {
        return delegate.adjustSequenceForJoin(collection);
    }

    @Override
    public void visitSystemCall(String[] args) {
        delegate.visitSystemCall(args);
    }

    @Override
    public void visitingInstantiator(String name) {
        delegate.visitingInstantiator(name);
    }

    @Override
    public void visitedInstantiator(String name, Object result) {
        delegate.visitedInstantiator(name, result);
    }

    @Override
    public void visitAlternative(boolean takeIf) {
        delegate.visitAlternative(takeIf);
    }

    @Override
    public void failedAt(IBuildlangElement element) {
        delegate.failedAt(element);
    }

    @Override
    public void reset() {
        delegate.reset();
    }

    @Override
    public void visitWhileBody() {
        delegate.visitWhileBody();
    }

    @Override
    public void visitedWhileBody() {
        delegate.visitedWhileBody();
    }

    @Override
    public void trace(String text) {
        delegate.trace(text);
    }

    @Override
    public void valueDefined(net.ssehub.easy.instantiation.core.model.common.VariableDeclaration var,
        FieldDescriptor field, Object value) {
        delegate.valueDefined(var, field, value);
    }

    @Override
    public void traceExecutionException(VilException exception) {
        delegate.traceExecutionException(exception);
    }

    @Override
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
        delegate.visitingCallExpression(descriptor, callType, args);
    }

    @Override
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result) {
        delegate.visitedCallExpression(descriptor, callType, args, result);
    }

    @Override
    public void failedAt(Expression expression) {
        delegate.failedAt(expression);
    }

    @Override
    public void startBind() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).startBind();
        }
    }

    @Override
    public void endBind() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).endBind();
        }
    }

    @Override
    public void startInitialize() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).startInitialize();
        }
    }

    @Override
    public void endInitialize() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).endInitialize();
        }
    }

    @Override
    public void startEnact() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).startEnact();
        }
    }

    @Override
    public void endEnact() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).endEnact();
        }
    }

    @Override
    public void startStrategies() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).startStrategies();
        }
    }

    @Override
    public void endStrategies() {
        if (delegate instanceof ITracer) {
            ((ITracer) delegate).endStrategies();
        }
    }

    @Override
    public void enable(boolean enable) {
        delegate.enable(enable);
    }

    @Override
    public Locale getLocale() {
        return delegate.getLocale();
    }

    @Override
    public void setLocale(Locale locale) {
        delegate.setLocale(locale);
    }

    @Override
    public void setRuntimeEnvironment(RuntimeEnvironment<?, ?> environment) {
        delegate.setRuntimeEnvironment(environment);
    }

    @Override
    public RuntimeEnvironment<?, ?> getRuntimeEnvironment() {
        return delegate.getRuntimeEnvironment();
    }

    @Override
    public void traceWarning(String text) {
        delegate.traceWarning(text);
    }

    @Override
    public void traceError(String text) {
        delegate.traceError(text);
    }

    @Override
    public void setTraceFilter(ITraceFilter filter) {
        delegate.setTraceFilter(filter);
    }

    @Override
    public ITraceFilter getTraceFilter() {
        return delegate.getTraceFilter();
    }

}
