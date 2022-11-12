/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.common;

/**
 * A filter that only emits failure messages.
 * 
 * @author Holger Eichelberger
 */
public class AllButFailureTraceFilter implements ITraceFilter {

    public static final ITraceFilter INSTANCE = new AllButFailureTraceFilter();
    
    /**
     * Prevents external instantiation.
     */
    private AllButFailureTraceFilter() {
    }
    
    @Override
    public boolean isEnabled(LanguageElementKind kind) {
        return kind == LanguageElementKind.FAILURE;
    }

    @Override
    public boolean isWarningEnabled() {
        return false;
    }

}
