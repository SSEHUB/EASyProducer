/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
 * Denotes the index values of the generic parameters to be replaced by the given argument types. Negative values
 * indicate that the given argument types shall be used. May be required to force / enable automatic conversion.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GenericArguments {

    /**
     * Denotes the index values of the generic parameters to be replaced by the given argument types. Negative values
     * indicate that the given argument types shall be used. May be required to force / enable automatic conversion.
     * 
     * @return the generic arguments as 0-based indexes
     */
    int[] value(); 
    
}
