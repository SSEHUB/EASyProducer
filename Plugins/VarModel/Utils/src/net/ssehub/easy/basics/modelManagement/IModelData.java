/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.basics.modelManagement;


/**
 * Specifies the interface to the most basic data of a model (and model info).
 * 
 * @author Holger Eichelberger
 */
public interface IModelData {

    /**
     * Returns the name of the model.
     * 
     * @return the name
     */
    public String getName();

    /**
     * Returns the version of the model.
     * 
     * @return the version, may be <b>null</b> if no version is specified
     */
    public Version getVersion();

}
