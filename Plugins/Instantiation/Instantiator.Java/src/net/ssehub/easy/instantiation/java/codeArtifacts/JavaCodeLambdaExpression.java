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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a lambda expression. 
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeLambdaExpression extends JavaCodeExpression {
    
    private List<String> variables;
    private JavaCodeExpression expression;
    private JavaCodeBlock block;

    /**
     * Creates an instance.
     *
     * @param parent the parent
     */
    protected JavaCodeLambdaExpression(IJavaCodeElement parent) {
        super(parent);
    }

    /**
     * Creates an instance without parent/variable. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @return the instance
     */
    public static JavaCodeLambdaExpression create() {
        return create(null);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param variable the first lambda variable (may be <b>null</b> or empty to ignore)
     * @return the instance
     */
    public static JavaCodeLambdaExpression create(String variable) {
        JavaCodeLambdaExpression result = new JavaCodeLambdaExpression(null);
        result.addVariable(variable);
        return result;
    }
    
    
    /**
     * Adds a variable to the lambda expression.
     * 
     * @param variable the variable (may be <b>null</b> or empty to ignore)
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression addVariable(String variable) {
        if (null != variable && variable.length() > 0) {
            if (null == variables) {
                variables = new ArrayList<>();
            }
            if (!variables.contains(variable)) {
                variables.add(variable);
            }
        }
        return this;
    }
    
    /**
     * Adds (multiple) variables from the comma separated {@code variables} string.
     * 
     * @param variables the variables, may be empty or null
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression addVariables(String variables) {
        if (null != variables && variables.length() > 0) {
            for (String v : variables.split(",")) {
                addVariable(v);
            }
        }
        return this;
    }

    /**
     * Convenience method to add some code element as expression. May be an expression, a block or a 
     * statement (to be wrapped into a block).
     * 
     * @param element the element
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression addAsExpression(JavaCodeElement element) {
        if (element instanceof JavaCodeExpression) {
            addExpression((JavaCodeExpression) element);
        } else if (element instanceof JavaCodeBlock) {
            setBlock((JavaCodeBlock) element);
        } else if (element instanceof JavaCodeStatement) {
            setBlock(JavaCodeBlock.create().add((JavaCodeStatement) element));
        }
        return this;
    }

    /**
     * Adds the expression to be applied to the variables.
     * 
     * @param expression the expression
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression addExpression(JavaCodeExpression expression) {
        this.expression = expression;
        return this;
    }
   
    /**
     * Adds the expression to be applied to the variables.
     * 
     * @param expression the expression
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression addExpression(String expression) { // TODO remove? -> JavaCodeExpressino
        this.expression = new JavaCodeTextExpression(this, expression);
        return this;
    }

    /**
     * Adds a block as expression.
     * 
     * @return the block
     */
    public JavaCodeBlock addBlock() {
        block = new JavaCodeBlock(getParent(), false, false, false, true, true);
        return block;
    }
    
    /**
     * Sets an already collected block as expression.
     * 
     * @param block the block
     * @return <b>this</b> for chaining
     */
    public JavaCodeLambdaExpression setBlock(JavaCodeBlock block) {
        this.block = block;
        return this;
    }

    /**
     * Adds a (static) call as expression.
     * 
     * @param methodName the method name
     * @return the call
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Adds a call as expression.
     * 
     * @param methodName the method name
     * @param scope the import resolution scope
     * @return the call
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        expression = new JavaCodeMethodCall(this, methodName, scope, false, "");
        return (JavaCodeMethodCall) expression;
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        setParent(expression, parent);
        setParent(block, parent);
    }
    
    @Override
    public void store(CodeWriter out) {
        if (null == variables) {
            out.print("()");
        } else {
            if (variables.size() > 1) {
                out.print("(");
            } 
            out.print(IJavaCodeElement.toList(variables, ","));
            if (variables.size() > 1) {
                out.print(")");
            } 
        }
        out.print(" -> ");
        if (block != null) {
            block.store(out);
        } else if (expression != null) {
            expression.store(out);
        }
    }
    
    @Override
    public JavaCodeLambdaExpression replaceVariable(String oldName, String newName) {
        if (null != block) {
            block.replaceVariable(oldName, newName);
        }
        if (null != expression) {
            expression.replaceVariable(oldName, newName);
        }
        if (null != variables) {
            for (int v = 0; v < variables.size(); v++) {
                if (variables.get(v).equals(oldName)) {
                    variables.set(v, newName);
                }
            }
        }
        return this;
    }

    @Override
    public JavaCodeLambdaExpression replaceMethod(String oldName, String newName) {
        if (null != block) {
            block.replaceVariable(oldName, newName);
        }
        if (null != expression) {
            expression.replaceVariable(oldName, newName);
        }
        return this;
    }        
    
}
