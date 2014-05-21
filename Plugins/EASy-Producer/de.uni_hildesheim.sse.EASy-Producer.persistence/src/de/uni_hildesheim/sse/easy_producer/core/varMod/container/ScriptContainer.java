/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.easy_producer.core.varMod.container;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;

/**
 * {@link ModelContainer} for holding a build {@link Script}.
 * @author El-Sharkawy
 *
 */
public class ScriptContainer extends ModelContainer<Script> {
    
    /**
     * Default constructor for a created of loaded {@link Script}.
     * @param script A valid {@link Script}, which shall be managed by this {@link ModelContainer}.
     * @param location The location (folder) of the managed build {@link Script}.
     */
    public ScriptContainer(Script script, Configuration location) {
        this(script, null, location);
    }
    
    /**
     * Constructor if an Exception occurred during parsing the {@link Script}.
     * The {@link Script} can be used but not be saved, as long the semantic error is not solved.
     * @param project The {@link Script}, which should be managed by this container.
     * @param description description A description of an occurred semantic error while parsing the {@link Script}.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as {@link #ScriptContainer(Script)}.
     * @param location The location (folder) of the managed build {@link Script}.
     */
    public ScriptContainer(Script project, SemanticErrorDescription description, Configuration location) {
        super(project, description, BuildModel.INSTANCE, location);
    }
    
    /**
     * Checks whether VIL instantiation should be possible. Currently, we check whether there is a start rule (main-rule
     * matching the script parameters) which either has a body or some kind of precondition or some kind of 
     * postcondition.
     * 
     * @return <code>true</code> if instantiation should be possible, <code>false</code> else
     */
    public boolean isTransformable() {
        boolean transformable = false;
        Script buildScript = getModel();
        if (null != buildScript) {
            try {
                Rule startRule = buildScript.determineStartRule(Executor.DEFAULT_START_RULE_NAME);
                transformable = startRule.getBodyElementCount() > 0  || startRule.hasCondition(Side.RHS) 
                    || startRule.hasCondition(Side.LHS); 
            } catch (VilLanguageException e) {
                // ignore - no start rule found, cannot be transformed
            }
        }
        return transformable;
    }

    @Override
    public File getLocation() {
        return getLocation(PathKind.VIL);
    }
}