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

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Simplified expression visitor / evaluator for testing.
 * 
 * @author Holger Eichelberger
 */
class ExpressionVisitor implements IExpressionVisitor {

    public static final String VAR = "VAR";
    public static final String CALL = "CALL";

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return null;
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        return "<" + cst.getName() + ">";
    }
    
    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws VilException {
        return null;
    }
    
    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        return null;
    }
    
    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return null;
    }
    
    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        String result = call.getName() + "(";
        for (int a = 0; a < call.getArgumentsCount(); a++) {
            if (a > 0) {
                result += ",";
            }
            result += call.getArgument(a).accept(this);
        }
        result += ")";
        return result;
    }

}
