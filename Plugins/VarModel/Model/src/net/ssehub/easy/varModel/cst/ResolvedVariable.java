/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Carries a resolved variable. Typically used only for temporary resolution, e.g., during reasoning.
 * 
 * @author Holger Eichelberger
 */
public class ResolvedVariable extends Variable {

    private IDecisionVariable resolved;
    
    /**
     * Creates a resolved variable.
     * 
     * @param resolved the resolved variable
     */
    public ResolvedVariable(IDecisionVariable resolved) {
        super(resolved.getDeclaration());
        this.resolved = resolved;
    }

    @Override
    public IDecisionVariable getResolved() {
        return resolved;
    }
    
}
