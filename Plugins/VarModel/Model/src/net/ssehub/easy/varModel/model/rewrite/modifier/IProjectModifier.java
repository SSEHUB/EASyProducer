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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * Optional Rule how to handle {@link Project}s, while creating a
 * modifying using the {@link net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor}. <br/>
 * This modifier my be used to apply general changes, not related to specific elements, to the complete project at the
 * end of its visitation.
 * @author El-Sharkawy
 *
 */
public interface IProjectModifier {
    
    /**
     * Specification how to modify {@link Project}s. 
     * @param project A {@link Project} which may be modified by this class.
     * @param context Knowledge of the current translation, comes from the
     * {@link net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor}.
     */
    public void modifyProject(Project project, RewriteContext context);

}