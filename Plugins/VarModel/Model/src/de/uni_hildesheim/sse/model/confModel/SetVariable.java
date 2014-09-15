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
package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * Decision variable for <tt>Set</tt>s.
 * @author lueder
 * @author Holger Eichelberger
 */
public class SetVariable extends ContainerVariable {
    
    /**
     * Sole Constructor for this class.
     * @param varDecl the variable declaration for this variable
     * @param parent the parent of this set
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    public SetVariable(AbstractVariable varDecl, IConfigurationElement parent, boolean isVisible) {
        super(parent, varDecl, isVisible);
    }

    /**
     * {@inheritDoc}
     */
    protected String getElementName(int index) {
        return getDeclaration().getName() + " {" + String.valueOf(index) + "}"; // initial, empty?
    }

}