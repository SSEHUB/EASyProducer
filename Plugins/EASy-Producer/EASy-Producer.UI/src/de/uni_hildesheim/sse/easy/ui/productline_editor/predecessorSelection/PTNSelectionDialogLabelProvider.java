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
package de.uni_hildesheim.sse.easy.ui.productline_editor.predecessorSelection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;

/**
 * LabelProvider for the {@link PredecessorSelectionDialog}.
 * Returns converts the <tt>ProductLineProject</tt>s displayed in this dialog into readable Strings.
 * @author Crowder, Schniedermeyer, Hundt
 *
 */
class PTNSelectionDialogLabelProvider extends LabelProvider implements IColorProvider {

    @Override
    public String getText(Object element) {
        String projectID = (String) element;
        PLPInfo ptn = SPLsManager.INSTANCE.getPLP(projectID);
        return ptn.getProjectName();
    }

    @Override
    public Image getImage(Object element) {
        return null;
    }

    @Override
    public Color getForeground(Object element) {
        return null;
    }

    @Override
    public Color getBackground(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

}
