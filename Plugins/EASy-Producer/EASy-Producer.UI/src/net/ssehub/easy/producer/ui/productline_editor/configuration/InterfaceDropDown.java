
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
package net.ssehub.easy.producer.ui.productline_editor.configuration;

import java.util.List;

import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.ui.productline_editor.components.AbstractComboBox;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.ProjectInterfaceFinder;

/**
 * Drop down menu for selecting project interfaces defined in this project, to use them as a filter.
 * @author Sascha El-Sharkawy
 *
 */
public class InterfaceDropDown extends AbstractComboBox<ProjectInterface> {
    
    /**
     * The information, which was used to build the selectable data of this combo box. <br/>
     * <b>Attention:</b> This value will initialized by the {@link #update()} call of the constructor of
     *  {@link AbstractComboBox}.
     */
    private Project lastProject;

    /**
     * Sole constructor for this class.
     * @param plp The {@link PLPInfo} which will be configured by this combo box, will also be used for creating the
     * displayed information.
     * @param parent The parent container holding this combo box
     * @param listener Listeners which should already be informed while this combo box is created.
     */
    @SuppressWarnings("unchecked")
    public InterfaceDropDown(PLPInfo plp, Composite parent, ComboBoxListener<ProjectInterface> listener) {
        super(plp, parent, listener);
    }

    @Override
    protected List<ProjectInterface> calculateValues() {
        ProjectInterfaceFinder finder = new ProjectInterfaceFinder(getProject(), FilterType.NO_IMPORTS);
        return finder.getProjectInterfaces();
    }

    @Override
    protected String getDisplayName(ProjectInterface element) {
        return element.getName();
    }
    
    @Override
    protected void onInit() {
        // Select randomly an interface during startup, if interfaces where defined in this project.
        if (size() > 1 && null == getSelectedValue()) {
            select(1);
        }
    }
    @Override
    protected boolean equals(ProjectInterface value1, ProjectInterface value2) {
        boolean equal = value1 == value2;
        if (null != value1 && null != value2) {
            // ProjectInterfaces belong to the same project
            IModelElement thisParent = value1.getTopLevelParent();
            IModelElement otherParent = value2.getTopLevelParent();
            if (null == thisParent) {
                equal = null == otherParent;
            } else {
                equal = thisParent.getName().equals(otherParent.getName());
                if (thisParent instanceof Project && otherParent instanceof Project && equal) {
                    equal = ((Project) thisParent).getVersion().equals(((Project) otherParent).getVersion());
                }
            }
            // ProjectInterfaces have the same name
            equal &= value1.getName().equals(value2.getName());
        }
        return equal;
    }
    
    @Override
    public void update() {
        /*
         * Update is only necessary if the project has been changed, i.e. if an interface was added.
         * This is only possible if the project was re-parsed, which will create a new project instance.
         * Attention: This if must be removed, if project interfaces can also change without exchanging the project.
         */
        if (lastProject != getProject()) {
            super.update();
            lastProject = getProject();
        }
    }
}
