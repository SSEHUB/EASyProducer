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
package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

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
     * Simplified constructor for an unrestricted import.
     * 
     * @param projectName the name of the project to be import
     * @param interfaceName the name of the interface to be imported (may 
     *   be <b>null</b> in case that an entire project
     *   without interfaces is being imported)
     */
    public ProjectImport(String projectName, String interfaceName) {
        this(projectName, interfaceName, false, false, (IVersionRestriction) null);
    }
    
    /**
     * Explicit Constructor.
     * 
     * @param projectName the name of the project to be import
     * @param interfaceName the name of the interface to be imported (may be <b>null</b>)
     * @param isConflict does this object represent a conflict or an import
     * @param isCopied true if the project should be copied / false if it should be referenced
     * @param restriction the version restrictions (may be <b>null</b> if absent)
     */
    public ProjectImport(String projectName, String interfaceName, boolean isConflict, boolean isCopied, 
        IVersionRestriction restriction) {
        super(projectName, isConflict, restriction);
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
        // aim at resolving the specific scope
        if (null != resolved && null != interfaceName) {
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

}
