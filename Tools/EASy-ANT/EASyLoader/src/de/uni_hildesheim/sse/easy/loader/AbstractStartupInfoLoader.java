/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.loader;

import java.util.List;

/**
 * Abstract loader based on {@link StartupInfo}.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractStartupInfoLoader implements ILoader {

    private boolean verbose = false;
    private List<StartupInfo> startupSequence;
    
    /**
     * Creates an instance with given startup sequence.
     * 
     * @param startupSequence the startup sequence to use
     */
    protected AbstractStartupInfoLoader(List<StartupInfo> startupSequence) {
        this.startupSequence = startupSequence;
    }
    
    @Override
    public void startup() {
        final boolean verbose = isVerbose();
        for (StartupInfo info : startupSequence) {
            info.start(verbose);
        }
    }

    @Override
    public void shutdown() {
        final boolean verbose = isVerbose();
        for (StartupInfo info : startupSequence) {
            info.stop(verbose);
        }
    }

    @Override
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Returns the verbose state.
     * 
     * @return the verbose state
     */
    public boolean isVerbose() {
        return verbose;
    }

}
