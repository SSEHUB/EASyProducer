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

/**
 * Extends the VIL tracer by specific trace methods for rt-VIL. For compatibility, we consider this 
 * interface as optional, i.e., a VIL tracer works also but without calling the methods defined
 * in this interface.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer extends net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer {
    
    /**
     * Start of the bind phase.
     */
    public void startBind();

    /**
     * End of the bind phase.
     */
    public void endBind();
    
    /**
     * Start of the initialize phase.
     */
    public void startInitialize();

    /**
     * End of the initialize phase.
     */
    public void endInitialize();
    
    /**
     * Start of the enactment phase.
     */
    public void startEnact();
    
    /**
     * End of the initialize phase.
     */
    public void endEnact();

    /**
     * Start of the strategies phase.
     */
    public void startStrategies();

    /**
     * End of the strategies phase.
     */
    public void endStrategies();
    
}
