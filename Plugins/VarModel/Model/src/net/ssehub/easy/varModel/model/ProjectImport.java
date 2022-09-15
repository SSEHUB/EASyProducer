/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;

/**
 * Defines an import and his restrictions.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class ProjectImport extends ModelImport<Project> {
    private String interfaceName;
    private IResolutionScope scope;
    private boolean isCopied;

    /**
     * Constructor for serialization.
     */
    ProjectImport() {
        this(null);
    }    
    
    /**
     * Simplified constructor for an unrestricted (non-inserting) import of a project.
     * 
     * @param projectName the name of the project to be import, becomes a wildcard import if {@code name} ends 
     * with {@link ModelImport#WILDCARD_POSTFIX}
     */
    public ProjectImport(String projectName) {
        this(projectName, null);
    }
    
    /**
     * Simplified constructor for an unrestricted (non-inserting) import.
     * 
     * @param projectName the name of the project to be import, becomes a wildcard import if {@code name} ends 
     * with {@link ModelImport#WILDCARD_POSTFIX}
     * @param interfaceName the name of the interface to be imported (may 
     *   be <b>null</b> in case that an entire project
     *   without interfaces is being imported)
     */
    public ProjectImport(String projectName, String interfaceName) {
        this(projectName, interfaceName, false, false, (IVersionRestriction) null);
    }

    /**
     * Creates a (non-inserting) project import.
     * 
     * @param projectName the name of the project to be import, becomes a wildcard import if {@code name} ends 
     * with {@link ModelImport#WILDCARD_POSTFIX}
     * @param interfaceName the name of the interface to be imported (may be <b>null</b>)
     * @param isConflict does this object represent a conflict or an import
     * @param isCopied true if the project should be copied / false if it should be referenced
     * @param restriction the version restrictions (may be <b>null</b> if absent)
     */
    public ProjectImport(String projectName, String interfaceName, boolean isConflict, boolean isCopied, 
        IVersionRestriction restriction) {
        this(projectName, interfaceName, isConflict, isCopied, restriction, false);
    }

    /**
     * Creates a project import.
     * 
     * @param projectName the name of the project to be import, becomes a wildcard import if {@code name} ends 
     * with {@link ModelImport#WILDCARD_POSTFIX}
     * @param interfaceName the name of the interface to be imported (may be <b>null</b>)
     * @param isConflict does this object represent a conflict or an import
     * @param isCopied true if the project should be copied / false if it should be referenced
     * @param restriction the version restrictions (may be <b>null</b> if absent)
     * @param isInsert whether model elements of the resolved model shall be (virtually) insert 
     *     at the end of the importing model
     */
    public ProjectImport(String projectName, String interfaceName, boolean isConflict, boolean isCopied, 
        IVersionRestriction restriction, boolean isInsert) {
        super(projectName, isConflict, restriction, isInsert);
        this.interfaceName = interfaceName;
    }

    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitProjectImport(this);
    }

    /**
     * Returns the name of the project being imported. In fact, this is a frontend for 
     * {@link ModelImport#getName()}.
     * 
     * @return the project name
     * 
     * @see ModelImport#getName()
     */
    public String getProjectName() {
        return getName();
    }

    /**
     * Returns the name of the interface in {@link #getProjectName()} being imported.
     * 
     * @return the interface name (may be <b>null</b> in case that an entire project
     *   without interfaces is being imported)
     */
    public String getInterfaceName() {
        return interfaceName;
    }
            
    /**
     * Defines the resolved project instance. This method determines
     * also the {@linkplain #getScope() scope}.
     * 
     * @param resolved the resolved instance or <b>null</b>
     * @throws ModelManagementException in case of violated project access restrictions
     */
    public void setResolved(Project resolved) throws ModelManagementException {
        // reset scope (must fit resolved)
        this.scope = null;
        // set resolved
        super.setResolved(resolved);
        
        boolean isTemporary = false;
        if (null != resolved) {
            AvailableModels<Project> available = VarModel.INSTANCE.availableModels();
            ModelInfo<Project> info = available.getModelInfo(resolved);
            isTemporary = available.isTempInfo(info);
        }
        // aim at resolving the specific scope
        if (null != resolved && null != interfaceName && !isTemporary) { 
            // exclude temporary models from this restriction to support constraint editor
            try {
                this.scope = (IResolutionScope) ModelQuery.findElementByName(
                    resolved, interfaceName, ProjectInterface.class);
            } catch (ModelQueryException e) {
                throw new ModelManagementException(e.getMessage(), e.getCode());
            }
        }
        if (null == this.scope) {
            // anyway, if not resolved by interfaceName before, resolved is the 
            // scope (although null)
            this.scope = getResolved();
        }
    }
    
    /**
     * Returns the specific scope introduced by this import. Typically, this is the project
     * and in case of {@link #getInterfaceName()} this is the imported interface (if it exists).
     * 
     * @return the scope (imported project or interface)
     */
    public IResolutionScope getScope() {
        return scope;
    }

    /**
     * Returns the qualified name of the imported element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName() {
        String result;
        if (null == interfaceName || 0 == interfaceName.length()) {
            result = getProjectName();
        } else {
            result = getProjectName() + IvmlKeyWords.NAMESPACE_SEPARATOR + interfaceName;
        }
        return result;
    }

    /**
     * Returns whether the imported project shall be copied.
     * 
     * @return <code>true</code> if it shall be copied upon import, <code>false</code>
     *   if a reference to a shared instance is sufficient.
     */
    public boolean isCopied() {
        return isCopied;
    }
    
    @Override
    public ProjectImport copy(String modelName) {
        return new ProjectImport(null == modelName ? getName() : modelName, interfaceName, isConflict(), isCopied, 
            getVersionRestriction(), isInsert());
    }

}
