package net.ssehub.easy.producer.ui.productline_editor.configuration;

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
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.model.ProjectInterface;

/**
 * A filter based on {@link ProjectInterface}s defined in the same project as the currently shown project.
 * @author Sascha El-Sharkawy
 *
 */
public class InterfaceFilter extends AbstractConfigurationFilter {
    
    private ProjectInterface pInterface;
    private Set<String> publicVariables;
    
    /**
     * Sole constructor for this class.
     * @param pInterface A project interface defined in the currently displayed project, or
     * <tt>null</tt> to deactivate this filter.
     */
    InterfaceFilter(ProjectInterface pInterface) {
        this.pInterface = pInterface;
        if (null != pInterface) {
            publicVariables = new HashSet<String>();
            for (int i = 0, n = pInterface.getExportsCount(); i < n; i++) {
                publicVariables.add(pInterface.getExport(i).getQualifiedName());
            }
        } else {
            publicVariables = null;
        }
    }

    @Override
    protected boolean checkVariable(GUIVariable variable) {
        boolean showVariable = null != pInterface ? false : true;
        if (!showVariable) {
            String qName = variable.getVariable().getDeclaration().getQualifiedName();
            if (publicVariables.contains(qName)) {
                showVariable = true;
            }
            
            // Make parent visible, if a nested variable shall be visible
            for (int i = 0; i < variable.getNestedElementsCount() && !showVariable; i++) {
                showVariable = checkVariable(variable.getNestedElement(i));
            }
        }
        
        return showVariable;
    }

}
