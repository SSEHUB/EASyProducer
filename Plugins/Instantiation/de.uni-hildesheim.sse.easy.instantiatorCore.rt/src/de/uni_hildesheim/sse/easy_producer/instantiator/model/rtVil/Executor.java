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

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;

/**
 * A specialized executor for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class Executor extends de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor {

    private boolean stopAfterBindValues = false;
    private boolean useReasoner = true;
    
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
     * Disable the reasoner and falls back to default consistent models.
     * 
     * @return <b>this</b> (builder pattern)
     */
    public Executor disableReasoner() {
        this.useReasoner = false;
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
        return new RtVilExecution(tracer, base, parameter, stopAfterBindValues, useReasoner);
    }
    
}
