/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.ui.editors;

import java.util.function.Supplier;

import org.eclipse.xtext.ui.editor.IXtextEditorCallback;

/**
 * A no-op editor callback with, can be disabled through system setting {@code easy.remindXtextNature}.
 * 
 * @author Holger Eichelberger
 */
public class NoNatureAddingEditorCallback extends IXtextEditorCallback.NullImpl {

    /**
     * Binds the xtext editor callback, with typical fallback to a super call not known here.
     * 
     * @param enabledSupplier the supplier
     * @return the actual callback class
     */
    public static Class<? extends IXtextEditorCallback> bindIXtextEditorCallback(
        Supplier<Class<? extends IXtextEditorCallback>> enabledSupplier) {
        Class<? extends IXtextEditorCallback> result;
        boolean enabled = Boolean.valueOf(System.getProperty("easy.remindXtextNature", "false"));
        if (enabled) {
            result = enabledSupplier.get();
        } else {
            result = NoNatureAddingEditorCallback.class;
        }
        return result;
    }
    
}
