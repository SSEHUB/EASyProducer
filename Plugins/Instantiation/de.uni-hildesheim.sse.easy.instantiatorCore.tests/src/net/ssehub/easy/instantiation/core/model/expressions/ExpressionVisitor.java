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

import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.AlternativeStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentAlternativeExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentImportExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentLoopExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentVarDeclExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.FlushStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.templateModel.JavaExtension;
import net.ssehub.easy.instantiation.core.model.templateModel.LoopStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.SwitchStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateBlock;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateCallExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.WhileStatement;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Simplified expression visitor / evaluator for testing.
 * 
 * @author Holger Eichelberger
 */
class ExpressionVisitor implements IExpressionVisitor, IVisitor {

    public static final String VAR = "VAR";
    public static final String CALL = "CALL";
    
    private RuntimeEnv environment;

    /**
     * Creates an expression visitor/evaluator.
     * 
     * @param environment the runtime environment
     */
    ExpressionVisitor(RuntimeEnv environment) {
        this.environment = environment;
    }
    
    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return null;
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        Object result = null;
        IResolvable resolvable = environment.get(cst.getName());
        if (null != resolvable) {
            result = environment.getValue(resolvable);
        }
        if (null == result) {
            result = "<" + cst.getName() + ">";
        }
        return result;
    }
    
    @Override
    public Object visitStringExpression(StringExpression ex) throws VilException {
        return "\"" + ex.getExpression().accept(this) + "\"";
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
        String result = "{";
        for (int a = 0; a < ex.getInitExpressionsCount(); a++) {
            if (a > 0) {
                result += ",";
            }
            result += ex.getInitExpression(a).accept(this);
        }
        result += "}";
        return result;
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return cst.getValue();
    }
    
    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        Object result = null;
        // for the in-place test, we need a not(bool); all others are just the signature
        if ("not".equals(call.getName()) && 1 == call.getArgumentsCount()) {
            if (TypeRegistry.booleanType().isAssignableFrom(call.getArgument(0).inferType())) {
                Object b = call.getArgument(0).accept(this);
                if (Boolean.TRUE == b) {
                    result = Boolean.FALSE;
                } else if (Boolean.FALSE == b) {
                    result = Boolean.TRUE;
                }
            }
        }
        if (null == result) {
            String res = call.getName() + "(";
            for (int a = 0; a < call.getArgumentsCount(); a++) {
                if (a > 0) {
                    res += ",";
                }
                res += call.getArgument(a).accept(this);
            }
            res += ")";
            result = res;
        }
        return result;
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        return null;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null;
    }

    @Override
    public Object visitTemplate(Template template) throws VilException {
        return null;
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        return null;
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        return null;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        return null;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        return null;
    }

    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        return null;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        return null;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        return null;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        return null;
    }

    @Override
    public Object visitFlush(FlushStatement flush) throws VilException {
        return null;
    }

    /**
     * Evaluates a content expression.
     * 
     * @param iter the expression iterator
     * @return the evaluation result
     * @throws VilException if expression evaluation fails
     */
    protected String evaluateContentExpression(IExpressionIterator iter) throws VilException {
        String result = "";
        for (int e = 0; e < iter.getExpressionsCount(); e++) {
            Expression expression = iter.getExpression(e);
            Object value;
            try {
                value = expression.accept(this);
            } catch (VilException e1) {
                if (e1.getId() == VilException.ID_NOT_FOUND) {
                    result = null;
                    break;
                } else {
                    throw e1;
                }
            }
            if (value != null) {
                result += StringValueHelper.getStringValueInReplacement(value, null);
            } else {
                result = null;
                break;
            }
        }
        return result;
    }

    @Override
    public Object visitContentAlternativeExpression(ContentAlternativeExpression ex) throws VilException {
        Object result = null;
        Object cond = ex.getCondition().accept(this);
        if (Boolean.TRUE.equals(cond)) {
            result = evaluateContentExpression(ex.thenEx());
        } else if (Boolean.FALSE.equals(cond)) {
            if (ex.getElseExpressionsCount() > 0) {
                result = evaluateContentExpression(ex.elseEx());
            } else {
                result = "";
            }
        }
        return result;
    }

    @Override
    public Object visitContentLoopExpression(ContentLoopExpression ex) throws VilException {
        return null; // we test this only in VIL files, also as VarDecl is not compatible
    }

    @Override
    public Object visitContentVarDeclExpression(ContentVarDeclExpression ex) throws VilException {
        return null; // we test this only in VIL files, also as VarDecl is not compatible
    }

    @Override
    public Object visitContentImportExpression(ContentImportExpression ex) throws VilException {
        return null; // we test this only in VIL files
    }

    @Override
    public Object visitCompound(Compound compound) throws VilException {
        return null; // not relevant to string replacer
    }

}
