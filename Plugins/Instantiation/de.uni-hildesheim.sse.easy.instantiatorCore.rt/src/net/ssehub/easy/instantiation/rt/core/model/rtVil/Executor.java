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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.io.File;
import java.util.Map;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.reasoning.core.frontend.ReasonerAdapter;

/**
 * A specialized executor for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class Executor extends net.ssehub.easy.instantiation.core.model.execution.Executor {

    private boolean stopAfterBindValues = false;
    private boolean enactment = true;
    private boolean useReasoner = true;
    private IReasoningHook reasoningHook = null;
    private String failReason;
    private Integer failCode;
    private ReasonerAdapter cache;
    
    /**
     * Creates an executor with default arguments.
     * 
     * @param script the script to execute
     * @throws IllegalArgumentException in case that <code>source</code> is <b>null</b>
     */
    public Executor(Script script) {
        super(script);
        setFrozenOnly(false);
    }
    
    /**
     * Creates an executor with predefined arguments. This enables
     * to execute scripts with custom parameters.
     * 
     * @param script the script to execute (ignored if <b>null</b>)
     * @param arguments the arguments matching all par
     */
    public Executor(Script script, Map<String, Object> arguments) {
        super(script, arguments);
        setFrozenOnly(false);
    }
    
    /**
     * Stops after binding values.
     * 
     * @return <b>this</b> (builder pattern)
     */
    public Executor stopAfterBindValues() {
        this.stopAfterBindValues = true;
        return this;
    }

    /**
     * Does not perform enactment.
     * 
     * @return <b>this</b> (builder pattern)
     */
    public Executor noEnactment() {
        this.enactment = false;
        return this;
    }
    
    /**
     * Disable the reasoner and falls back to default consistent models.
     * 
     * @return <b>this</b> (builder pattern)
     */
    public Executor disableReasoner() {
        this.useReasoner = false;
        return this;
    }
    
    /**
     * Defines the reasoning hook which may influence the reasoning result. By default, the 
     * {@link DefaultReasoningHook} is set.
     *     
     * @param reasoningHook the new reasoning hook (<b>null</b> is ignored)
     * @return <b>this</b> (builder pattern)
     */
    public Executor setReasoningHook(IReasoningHook reasoningHook) {
        this.reasoningHook = reasoningHook;
        return this;
    }
    
    /**
     * Performs reasoning in rt-VIL style. Applied language concept is <b>null</b>, i.e., top-level.
     * 
     * @param observer the observer to be considered (must not be <b>null</b>)
     * @param listener reasoning listener to obtain the (filtered) reasoning results
     * @throws VilException in case that reasoning or setup fails
     */
    public void reason(ProgressObserver observer, final IReasoningResultListener listener) throws VilException {
        IExecutable executable = new IExecutable() {

            @Override
            public void execute(net.ssehub.easy.instantiation.core.model.execution.Executor executor, ITracer tracer, 
                Map<String, Object> args) throws VilException {
                Configuration cfg = getConfiguration(args);
                ((RtVilExecution) executor.getActualExecutor()).reason(cfg, null, listener);
            }
            
        };
        execute(observer, true, executable);
    }

    @Override
    protected net.ssehub.easy.instantiation.core.model.buildlangModel.Script 
        reload(net.ssehub.easy.instantiation.core.model.buildlangModel.Script script) {
        
        // template parameter would be nicer but it requires changes to the existing code and we aim at unifying 
        // rtVIL and VIL later one
        return RtVilModel.INSTANCE.reload((Script) script);
    }
    
    @Override
    protected net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution 
        createExecutionEnvironment(ITracer tracer, File base, String startRuleName, 
        Map<String, Object> parameter) {
        RtVilExecution result = new RtVilExecution(tracer, base, parameter);
        result.setStopAfterBindValues(stopAfterBindValues);
        result.setUseReasoner(useReasoner);
        result.setEnableEnactment(enactment);
        result.setReasoningHook(reasoningHook); // null is not a problem here
        result.setReasonerCache(cache);
        return result;
    }
    
    @Override
    protected void handleExecutionResult(RuleExecutionResult result, ITracer tracer, BuildlangExecution executor) 
        throws VilException {
        boolean explicitFail = false;
        if (RuleExecutionResult.Status.FAIL == result.getStatus()) {
            failCode = result.getFailCode();
            failReason = result.getFailReason();
            explicitFail = failCode != null || failReason != null;
        }
        if (!explicitFail) {
            super.handleExecutionResult(result, tracer, executor);
        }
    }

    @Override
    protected void completeExecutionError(StringBuilder msg, RuleExecutionResult result) {
        if (null != failReason || null != failCode) { // already set in handleExecutionResult
            msg.append("due to explicit fail statement");
            if (null != failReason) {
                msg.append(" ");
                msg.append(failReason);
            }
            if (null != failCode) {
                msg.append(" with code ");
                msg.append(failCode);
            }
        }
    }
    
    /**
     * Returns the fail reason (if the execution failed).
     * 
     * @return the reason or <b>null</b> if unknown, not set or not failing
     */
    public String getFailReason() {
        return failReason;
    }
    
    /**
     * The failure code.
     * 
     * @return the failure code (may be <b>null</b> if not set)
     */
    public Integer getFailCode() {
        return failCode;
    }
    
    /**
     * Sets the reasoner cache for instance-based reasoning, i.e., for re-using already registered reasoners.
     * 
     * @param cache the cache instance
     * @return <b>this</b>
     */
    public Executor setReasonerCache(ReasonerAdapter cache) {
        this.cache = cache;
        return this;
    }
    
}
