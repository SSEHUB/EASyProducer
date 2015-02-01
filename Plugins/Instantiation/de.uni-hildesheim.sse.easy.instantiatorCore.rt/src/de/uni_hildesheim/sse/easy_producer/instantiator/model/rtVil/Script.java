/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IRestrictionEvaluationContext;

/**
 * Represents a script, i.e., the top-level element of a rtVIL-model.
 * Scripts represent an implicit type, i.e., they are not registered with the 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry} and, thus, not
 * assignable.
 * 
 * @author Holger Eichelberger
 */
public class Script extends de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script {

    /**
     * Constructor for a script without parent, parameters or advices and with the default
     * type registry.
     * 
     * @param name Name of the project.
     */
    public Script(String name) {
        super(name);
    }

    /**
     * Constructor for a script without parent, parameters or advices.
     * 
     * @param name Name of the project.
     * @param registry the responsible registry
     */
    public Script(String name, TypeRegistry registry) {
        super(name, registry);
    }

    /**
     * Creates implicit variables.
     * 
     * @see #isImplicit(VariableDeclaration)
     */
    protected void createImplicitVariables() {
        // no implicit variables for now
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitScript(this);
    }

    //TODO getOperations
    //TODO getSuper

    @Override
    protected void reload() {
        RtVilModel.INSTANCE.reload(this);
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return new RuntimeEnvironment();
    }

}
