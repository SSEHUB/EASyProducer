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
package net.ssehub.easy.instantiation.core.model.common;

/**
 * Some utility functions.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Returns the parent project.
     * 
     * @param <T> the project type
     * @param modelElement the model (language) element
     * @param cls the class of the project type
     * @return the parent project
     */
    public static <T> T getParentProject(ILanguageElement modelElement, Class<T> cls) {
        T parentProject = null;
        if (modelElement != null) {
            ILanguageElement par = modelElement.getParent();
            while (null != par && !cls.isInstance(par)) {
                par = par.getParent();
            }
            if (cls.isInstance(par)) {
                parentProject = cls.cast(par);
            }
        }
        return parentProject;
    }

}
