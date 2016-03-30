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
package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Defines the instantiator tree content provider.
 * 
 * @author Holger Eichelberger
 */
class InstantiatorTreeContentProvider implements ITreeContentProvider {
    
    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public Object[] getElements(Object inputElement) {
        Object[] elements;
        if (inputElement instanceof Object[]) {
            elements = (Object[]) inputElement;
        } else {
            elements = new Object[0];
        }
        return elements;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        Object[] result = null;
        if (parentElement instanceof TreeNode) {
            result = ((TreeNode) parentElement).getChildren();
        }
        return result;
    }

    @Override
    public Object getParent(Object element) {
        Object result = null;
        if (element instanceof TreeNode) {
            result = ((TreeNode) element).getParent();
        }
        return result;
    }

    @Override
    public boolean hasChildren(Object element) {
        boolean result = false;
        if (element instanceof TreeNode) {
            result = ((TreeNode) element).hasChildren();
        }
        return result;
    }

}
