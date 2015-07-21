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
package de.uni_hildesheim.sse.persistency;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;

/**
 * An IVML writer which may or not emit imports.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurableIVMLWriter extends IVMLWriter {

    private List<Project> imports;
    private int projectNestingLevel = 0;
    
    /**
     * Creates a writer instance. Due to the pooling mechanism, disabling comments
     * can only be done by a non-pooled subclass.
     *  
     * @param writer the writer which should be used for writing the output
     * @param emitComments whether comments shall be emitted or ignored
     * @param emitImports whether imports shall be emitted or ignored
     */
    public ConfigurableIVMLWriter(Writer writer, boolean emitComments, boolean emitImports) {
        super(writer, emitComments);
        if (emitImports) {
            imports = new ArrayList<Project>();
        }
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        super.visitProjectImport(pImport);
        Project resolved = pImport.getResolved();
        if (null != imports && null != resolved) {
            if (!imports.contains(resolved)) {
                imports.add(resolved);
            }
        }
    }

    @Override
    public void visitProject(Project project) {
        projectNestingLevel++;
        super.visitProject(project);
        projectNestingLevel--;
        if (0 == projectNestingLevel && null != imports) {
            projectNestingLevel++;
            for (int i = 0; i < imports.size(); i++) {
                imports.get(i).accept(this);
            }
            projectNestingLevel--;
        }
    }
    
}
