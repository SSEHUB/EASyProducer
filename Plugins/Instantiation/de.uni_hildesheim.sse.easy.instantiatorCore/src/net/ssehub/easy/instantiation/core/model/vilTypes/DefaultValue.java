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
 * Indicates a data structure containing the default value(s) of a type or of parameters. Two forms
 * are supported:
 * <ol>
 *  <li>In case of a type, a single value (not necessarily of that but a VIL assignable type) 
 *    representing a neutral element, can be marked. This defines the default value of 
 *    the respective type (or if not overriden by a subsequent definition) for the 
 *    derived subtypes.</li>
 *  <li>In case of parameters, a whole static data structure (Map&lt;String, Object&gt; or an Object array with even 
 *    dimension and alternating key-values are supported) can be used to define the relations between parameter names 
 *    and default values. In the latter case, multiple default value attributes can be stated
 *    for different operations, e.g., if the operations overlap in parameter types but not in
 *    default values). The different operations can be indicated by their name using {@link #name()}. 
 *    </li>
 * </ol>
 * Inherited attributes are considered in both cases, i.e., super classes define the default values for subclasses if 
 * not overridden explicitly. If the respective value shall not be visible and the defined static value is not used
 * within the defining class, the annotation {@link SuppressWarnings} may be required for that field in addition.
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
