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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IArgumentProvider;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Implements builder block, a specialized expression that receives an (object) value form a precursor expression, 
 * allows to apply a block on that expression value and, finally, returns the expression value. Useful in nested
 * builder style calls, e.g., on code generation artifacts.
 * 
 * @author Holger Eichelberger
 */
public class BuilderBlockExpression extends Expression implements IArgumentProvider {
    
    private VariableDeclaration var;
    private TemplateBlock block;
    private Mode mode;
    
    public enum Mode {
        NONE,
        NAME,
        TYPE_NAME
    }
    
    public BuilderBlockExpression(VariableDeclaration var, Mode mode, TemplateBlock block) {
        this.mode = mode;
        this.var = var;
        this.block = block;
    }
    
    public VariableDeclaration getVariable() {
        return var;
    }

    public TemplateBlock getBlock() {
        return block;
    }
    
    public Mode getMode() {
        return mode;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return var.getType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        if (visitor instanceof ITemplateLangVisitor) {
            return ((ITemplateLangVisitor) visitor).visitBuilderBlockExpression(this);
        } else {
            return null;
        }
    }

    @Override
    public int getArgumentsCount() {
        return 1;
    }

    @Override
    public CallArgument getArgument(int index) {
        return new CallArgument(var.getExpression());
    }

}
