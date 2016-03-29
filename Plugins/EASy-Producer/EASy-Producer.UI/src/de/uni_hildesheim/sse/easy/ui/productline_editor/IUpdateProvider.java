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
package de.uni_hildesheim.sse.easy.ui.productline_editor;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Supports external updates to the created editors.
 * 
 * @author Holger Eichelberger
 */
public interface IUpdateProvider extends IRefreshableEditor {

    @Override
    public void refresh();
    
    /**
     * Defines the update listener. The update listener will be disposed automatically .
     * 
     * @param listener the update listener
     */
    public void setUpdateListener(IUpdateListener listener);
    
    /**
     * Returns the underlying decision variable.
     * 
     * @return the decision variable
     */
    public IDecisionVariable getVariable();
}
