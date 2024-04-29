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
 * Annotation for providing details to a VIL operation parameter.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterMeta {

    /**
     * The generic parameters of the parameter/argument type. This is required as the type parameters
     * of Java generics cannot be accessed. Generics of complex types are just given in 
     * linear sequence. Empty by default. Might be replaced by new reflection functions in Java 8.
     * 
     * @return the generic parameters of the parameter/argument type (none/neutral is the empty array)
     */
    Class<?>[] generics(); // java 17 does not compile empty non-constant arrays as defaults anymore
    
    /**
     * Indicates a named parameter. The name may be the same as the parameter name but it may also differ.
     * Default values are either determined based on the default java values or, if given, from a static attribute
     * marked by {@link DefaultValue}. Names per method signature shall be unique.
     * 
     * @return the name of the named parameter
     */
    String name() default "";

}
