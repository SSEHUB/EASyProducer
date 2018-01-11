/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.internal;

import java.util.Collection;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements a type selection dialog.
 * 
 * @author Holger Eichelberger
 */
public class TypeSelectionDialog {

    /**
     * Implements a type label provider.
     * 
     * @author Holger Eichelberger
     */
    private static class TypeLabelProvider extends LabelProvider {
        
        @Override
        public Image getImage(Object element) {
            return null;
        }

        @Override
        public String getText(Object element) {
            String result;
            if (element instanceof IDatatype) {
                result = IvmlDatatypeVisitor.getQualifiedType((IDatatype) element);
            } else {
                result = element == null ? "" : element.toString();
            }
            return result;
        }
        
    }

    /**
     * Opens a type selection dialog based on the given <code>title</code> and <code>types</code>. No type is selected
     * by default.
     * 
     * @param <T> the specific data type to work with
     * @param shell the parent shell
     * @param title the title
     * @param types the types to select from
     * @return the selected datatype, <b>null</b> if none was selected
     */
    public static <T extends IDatatype> T open(Shell shell, String title, Collection<T> types) {
        return open(shell, title, types, null);
    }

    /**
     * Opens a type selection dialog based on the given <code>title</code> and <code>types</code>.
     * 
     * @param <T> the specific data type to work with
     * @param shell the parent shell
     * @param title the title
     * @param types the types to select from
     * @param selected the type to be selected by default, <b>null</b> for none
     * @return the selected datatype, <b>null</b> if none was selected
     */
    @SuppressWarnings("unchecked")
    public static <T extends IDatatype> T open(Shell shell, String title, Collection<T> types, T selected) {
        T result = null;
        ElementListSelectionDialog dialog =
            new ElementListSelectionDialog(shell, new TypeLabelProvider());
        dialog.setAllowDuplicates(false);
        dialog.setMultipleSelection(false);
        dialog.setElements(types.toArray());
        dialog.setTitle(title);
        if (null != selected) {
            Object[] initialSelections = new Object[1];
            initialSelections[0] = selected;
            dialog.setInitialSelections(initialSelections);
        }
        if (dialog.open() == Window.OK) {
            result = (T) dialog.getFirstResult();
        }
        return result;
    }

    /**
     * Allows the user to select a compound type from all refining types from <code>type</code>. No selection
     * is shown if there are no refining types. No selection is made in the dialog.
     * 
     * @param shell the shell to display the dialog
     * @param title the dialog title
     * @param scope the search scope/project
     * @param type the compound type to search refined types for
     * @return the selected type, <code>type</code> if there was none, <b>null</b> if a selection dialog was show but
     *   no selection was made
     */
    public static Compound selectCompoundType(Shell shell, String title, IResolutionScope scope, Compound type) {
        return selectCompoundType(shell, title, scope, type, null);
    }

    /**
     * Allows the user to select a compound type from all refining types from <code>type</code>. No selection
     * is shown if there are no refining types.
     * 
     * @param shell the shell to display the dialog
     * @param title the dialog title
     * @param scope the search scope/project
     * @param type the compound type to search refined types for
     * @param current the type to be selected in the dialog, <b>null</b> for no selection
     * @return the selected type, <code>type</code> if there was none, <b>null</b> if a selection dialog was show but
     *   no selection was made
     */
    public static Compound selectCompoundType(Shell shell, String title, IResolutionScope scope, Compound type, 
        Compound current) {
        Compound result = type;
        Collection<Compound> candidates = type.implementingNonAbstract(scope);
        if (candidates.size() > 1) {
            result = open(shell, title, candidates);
        }
        return result;
    }

    /**
     * Returns "(actual: <valueType>)" if <code>value</code> is not <b>null</b>, <code>deflt</code> else. Can be 
     * used to compose the title of a type selection dialog. [utility]
     * 
     * @param value the value to return the type string for
     * @param deflt the default if <code>value</code> is <b>null</b>
     * @return the type string
     */
    public static String getActualTypeString(Value value, String deflt) {
        return null == value ? deflt : getActualTypeString(value.getType(), deflt);
    }

    /**
     * Returns "(actual: <type>)" if <code>type</code> is not <b>null</b>, <code>deflt</code> else. Can be 
     * used to compose the title of a type selection dialog. [utility]
     * 
     * @param type the value to return the type string for
     * @param deflt the default if <code>value</code> is <b>null</b>
     * @return the type string
     */
    public static String getActualTypeString(IDatatype type, String deflt) {
        return null == type ? deflt : " (actual: " + IvmlDatatypeVisitor.getQualifiedType(type) + ")";
    }

}
