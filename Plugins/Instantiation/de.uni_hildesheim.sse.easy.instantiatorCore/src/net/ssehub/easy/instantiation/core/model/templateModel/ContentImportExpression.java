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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Represents an import of a template through a in-content expression.
 * 
 * @author Holger Eichelberger
 */
public class ContentImportExpression extends InContentExpression {

    private String template;
    private IVersionRestriction restriction;
    
    /**
     * Creates the import expression.
     * 
     * @param template the template name
     * @param restriction the version restriction expression (may be <b>null</b>)
     */
    public ContentImportExpression(String template, IVersionRestriction restriction) {
        this.template = template;
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
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitContentImportExpression(this);
        } else {
            result = null;
        }
        return result;
    }
    
}
