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

package net.ssehub.easy.producer.core.varMod.container;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.buildlangModel.AbstractRule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;

/**
 * {@link ModelContainer} for holding a build {@link Script}.
 * @author El-Sharkawy
 *
 */
public class ScriptContainer extends ModelContainer<Script> {
    
    /**
     * Specification whether this script was edited inside of easy.
     * <ul>
     * <li><tt>true</tt>: Was edited in EASy and should be saved</li>
     * <li><tt>false</tt>: Should not be saved</li>
     * </ul>
     */
    private boolean wasEdited;
    
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
     * @param script The {@link Script}, which should be managed by this container.
     * @param description A description of an occurred semantic error while parsing the {@link Script}.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as {@link #ScriptContainer(Script)}.
     * @param location The location (folder) of the managed build {@link Script}.
     */
    public ScriptContainer(Script script, SemanticErrorDescription description, Configuration location) {
        this(script, description, location, false);
    }
    
    /**
     * Constructor if a {@link Script} was created inside of EASy (not via a XTextEditor).
     * @param script The {@link Script}, which should be managed by this container.
     * @param description A description of an occurred semantic error while parsing the {@link Script}.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as {@link #ScriptContainer(Script)}.
     * @param location The location (folder) of the managed build {@link Script}.
     * @param newlyCreated <tt>true</tt> If the <tt>script</tt> was edited/created inside of EASy and shall be saved
     *     when the whole project is saved, <tt>false</tt> ohterwise.  
     */
    public ScriptContainer(Script script, SemanticErrorDescription description, Configuration location,
        boolean newlyCreated) {
        
        super(script, description, BuildModel.INSTANCE, location);
        wasEdited = newlyCreated;        
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
                AbstractRule startRule = buildScript.determineStartRule(Executor.DEFAULT_START_RULE_NAME);
                transformable = startRule.getBodyElementCount() > 0  || startRule.hasCondition(Side.RHS) 
                    || startRule.hasCondition(Side.LHS); 
            } catch (VilException e) {
                // ignore - no start rule found, cannot be transformed
            }
        }
        return transformable;
    }

    @Override
    public File getLocation() {
        return getLocation(PathKind.VIL);
    }

    @Override
    public boolean isSaveable() {
        return super.isSaveable() && wasEdited();
    }
    
    /**
     * Returns whether this script was edited in EASy and should be saved.
     * @return <tt>true</tt> should be saved (will also overwrite existing files and delete (not parsed) comments).
     */
    private boolean wasEdited() {
        return wasEdited;
    }

    /**
     * Specification whether this file was edited in EASy.
     * 
     * @param wasEdited <tt>true</tt> should be saved (will also overwrite existing files
     * and delete (not parsed) comments).
     */
    public void setEdited(boolean wasEdited) {
        this.wasEdited = wasEdited;
    }
}