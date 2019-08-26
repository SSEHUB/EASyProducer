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
package net.ssehub.easy.reasoning.core.impl;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Some helpful methods for reasoners.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerHelper {

    /**
     * Creates the value for a certain IVML type/variable. Just uses the value factory.
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints, takes precedence over {@code type})
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    public static ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type,
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        return null;
    }
    
}
