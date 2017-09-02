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
package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.List;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Represents an in-place import command.
 * 
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public class InPlaceImportCommand<I extends VariableDeclaration> extends InPlaceCommand<I> {

    private String template;
    private IVersionRestriction restriction;
    
    /**
     * Creates an in-place import command.
     * 
     * @param template the template to import
     * @param restriction the version restriction (may be <b>null</b>)
     */
    public InPlaceImportCommand(String template, IVersionRestriction restriction) {
        this.template = template;
        this.restriction = restriction;
    }

    /**
     * Returns the template name.
     * 
     * @return the template name
     */
    public String getTemplate() {
        return template;
    }
    
    /**
     * Returns the version restriction.
     * 
     * @return the version restriction
     */
    public IVersionRestriction getVersionRestriction() {
        return restriction;
    }
    
    @Override
    protected void append(Expression ex) {
        // single bracket command, no appending supported
    }

    @Override
    protected Expression close(IStringParserFactory<I> factory) throws VilException {
        return factory.createImportExpression(this);
    }

    @Override
    protected void append(List<Expression> exprs) {
        // no inner content to append
    }

    @Override
    protected void replace(InPlaceCommand<I> cmd, Expression expr) {
        // no replacement needed
    }

}
