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
package net.ssehub.easy.producer.ui.productline_editor;

import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Declares the interface of an overriding editor in {@link ConfigurationTableEditorFactory} that
 * can be wrapped into a {@link net.ssehub.easy.producer.ui.confModel.GUIVariable}. Actually,
 * this interface repeats some methods from {@link net.ssehub.easy.producer.ui.confModel.GUIVariable}
 * declaring {@link #getValueAssignment(Object)} as public rather than protected.
 * 
 * @author Holger Eichelberger
 */
public interface IOverridingEditor extends IRefreshableEditor {

    /**
     * Returns the value of the given {@link net.ssehub.easy.varModel.confModel.IDecisionVariable} so that it can 
     * be used as return value for the {@link org.eclipse.jface.viewers.EditingSupport#getValue(Object)} method.
     * 
     * @return A value as needed by the Eclipse UI.
     */
    public abstract Object getValue();
    
    /**
     * Converts the given object into a {@link Value}.
     * 
     * @param value An object given by the Eclipse GUI.
     * 
     * @return A {@link Value} representation of the object, maybe <code>null</code>.
     * @throws ValueDoesNotMatchTypeException in case of <code>value</code> cannot be converted to
     * the related data type of the wrapped {@link net.ssehub.easy.varModel.confModel.IDecisionVariable}.
     */
    public Value getValueAssignment(Object value) throws ValueDoesNotMatchTypeException;
    
    /**
     * Returns a string representation of the current value.
     * This is used when <b>no</b> cursor is inside the cell (if the user is <b>not</b> editing the variable).
     * 
     * @return A string representation of the current value or <code>null</code>.
     */
    public abstract String getValueText();
    
    @Override
    public void refresh();
    
}
