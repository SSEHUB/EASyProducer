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
 * Allows to filter trace output.
 * 
 * @author Holger Eichelberger
x */
public interface ITraceFilter {
 
    /**
     * Abstracted kinds of language element (VIL, VTL, rt-VTL) to trace.
     * 
     * @author Holger Eichelberger
     */
    public enum LanguageElementKind {
        
        /**
         * The top-level language unit.
         */
        LANGUAGE_UNIT,

        /**
         * Definition of a user-defined function.
         */
        FUNCTION_DEFINITION,

        /**
         * Execution of a user-defined function.
         */
        FUNCTION_EXECUTION,

        /**
         * Execution of a built-in operation.
         */
        OPERATION_EXECUTION,

        /**
         * Execution of a system call.
         */
        SYSCALL_EXECUTION,

        /**
         * Execution of a built-in loop.
         */
        LOOP_EXECUTION,

        /**
         * Execution of a built-in switch.
         */
        SWITCH_EXECUTION,

        /**
         * Execution of a built-in alternative.
         */
        ALTERNATIVE_EXECUTION,

        /**
         * Execution of a builder-expression.
         */
        BUILDER_EXECUTION,

        /**
         * Failure situation.
         */
        FAILURE
    }
    
    /**
     * Returns whether tracing on the given language element is enabled.
     * 
     * @param kind the element kind
     * @return {@code true} for tracing, {@code false} else
     */
    public boolean isEnabled(LanguageElementKind kind);

    /**
     * Returns whether warnings are enabled.
     * 
     * @return {@code true} for warnings, {@code false} else
     */
    public boolean isWarningEnabled();
    
}
