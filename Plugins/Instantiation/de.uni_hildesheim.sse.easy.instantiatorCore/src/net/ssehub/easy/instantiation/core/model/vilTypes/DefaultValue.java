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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a data structure containing the default value(s) of a type or of parameters.
 * In case of a type, a single value (not necessarily of that but a VIL assignable type) 
 * representing a neutral element, shall be marked. In case of parameters, a whole data
 * structure, e.g., a Map can be marked indicating the relation between parameter names
 * and default values. In the latter case, multiple default value attributes may exist
 * for different operations to be indicated by {@link #name()}. In the first case, the last
 * defined default value counts. Inherited attributes are considered.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    
    /**
     * The name of the method/operation the default value(s) apply to.
     */
    String name() default "";

}
