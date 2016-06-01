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
package test.de.uni_hildesheim.sse.cycletest;

import net.ssehub.easy.varModel.model.Project;

/**
 * General interface for the different visitors used in this package.
 * @author El-Sharkawy
 */
public interface IUsedProjectFinder {

    /**
     * Returns the used {@link net.ssehub.easy.varModel.model.Project}s.
     * Needs that the visitor was executed before.
     * @return All found Projects, must not be <tt>null</tt>.
     */
    public java.util.Set<Project> getUsedProjects();
}
