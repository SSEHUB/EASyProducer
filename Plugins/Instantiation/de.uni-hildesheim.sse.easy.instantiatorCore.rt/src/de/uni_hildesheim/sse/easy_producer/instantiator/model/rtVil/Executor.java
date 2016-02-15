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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.io.File;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * A specialized executor for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class Executor extends de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor {

    private boolean stopAfterBindValues = false;
    private boolean enactment = true;
    private boolean useReasoner = true;
    private IReasoningHook reasoningHook = null;
    private String failReason;
    private Integer failCode;
    
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

    @Override
    protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script 
        reload(de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script script) {
        
        // template parameter would be nicer but it requires changes to the existing code and we aim at unifying 
        // rtVIL and VIL later one
        return RtVilModel.INSTANCE.reload((Script) script);
    }
    
    @Override
    protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution 
        createExecutionEnvironment(ITracer tracer, File base, String startRuleName, 
        Map<String, Object> parameter) {
        RtVilExecution result = new RtVilExecution(tracer, base, parameter);
        result.setStopAfterBindValues(stopAfterBindValues);
        result.setUseReasoner(useReasoner);
        result.setEnableEnactment(enactment);
        result.setReasoningHook(reasoningHook); // null is not a problem here
        return result;
    }
    
    @Override
    protected void handleExecutionResult(RuleExecutionResult result, ITracer tracer, BuildlangExecution executor) 
        throws VilException {
        if (RuleExecutionResult.Status.FAIL == result.getStatus()) {
            failCode = result.getFailCode();
            failReason = result.getFailReason();
        }
        super.handleExecutionResult(result, tracer, executor);
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
    
}
