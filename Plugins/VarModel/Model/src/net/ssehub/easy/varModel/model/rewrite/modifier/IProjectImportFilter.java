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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * Optional Rule how to handle {@link net.ssehub.easy.varModel.model.ProjectImport}s, while creating a
 * copy using the {@link net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor}.
 * @author El-Sharkawy
 *
 */
public interface IProjectImportFilter {
    
    /**
     * Specification how to handle {@link ProjectImport}s. 
     * @param pImport A {@link ProjectImport} which may be modified by this class.
     * @param context Knowledge of the current translation, comes from the
     * {@link net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor}.
     * @return The modified element. Maybe the same instance as passed as parameter (if nothing should be changed) or
     * <tt>null</tt> if the element should be deleted.
     */
    public ProjectImport handleImport(ProjectImport pImport, RewriteContext context);

}
