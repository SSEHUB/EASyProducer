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
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a Java argument list as a pseudo expression. The output will not contain argument list parenthesis
 * as this is contributed by the containing/hosting code element.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeArgumentListExpression extends JavaCodeExpression {

    private List<IJavaCodeElement> arguments = new ArrayList<>();
    
    /**
     * Creates a argument list expression.
     * 
     * @param parent the parent element
     */
    protected JavaCodeArgumentListExpression(IJavaCodeElement parent) {
        super(parent);
    }
    
    /**
     * Creates an unlinked argument list expression. {@link #setParent(IJavaCodeElement)} must be called afterwards.
     * 
     * @return the created expression
     */
    public static JavaCodeArgumentListExpression create() {
        return new JavaCodeArgumentListExpression(null);
    }
    
    /**
     * Adds a call argument as raw string of {@code arg}.
     * 
     * @param arg the argument (ignored if equivalent to empty or null)
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeArgumentListExpression addArgument(Object arg) {
        arg = IVilType.convertVilValue(arg);
        if (null != arg) {
            String sArg = arg.toString();
            if (sArg.length() > 0) {
                arguments.add(new JavaCodeText(sArg, false, false));
            }
        }
        return this;
    }

    /**
     * Adds null as call argument.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeArgumentListExpression addNullArgument() {
        return addArgument("null");
    }

    /**
     * Adds a call argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param val the String value
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addStringArgument", "stringArg"})
    public JavaCodeArgumentListExpression addStringArgument(String val) {
        return addArgument(new JavaCodeStringExpression(this, val));
    }

    /**
     * Adds a call argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param val the String value
     * @return <b>this</b> for chaining
     */
    public JavaCodeArgumentListExpression addStringArgumentNotEmpty(String val) {
        if (null != val && val.length() > 0) {
            addStringArgument(val);
        }
        return this;
    }
    
    /**
     * Adds a call argument as class expression, i.e. potentially qualified class name optionally ending with ".class".
     * Cares for importing {@code cls},
     * 
     * @param cls the (qualified) class name, optionally ending with ".class", ignored if <b>null</b> or empty
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addClassArgument", "classArg"})
    public JavaCodeArgumentListExpression addClassArgument(String cls) {
        JavaCodeTypeSpecification type = JavaCodeTypeSpecification.toClassType(cls, this);
        if (null != type) {
            addArgument(new JavaCodeTypeExpression(this, type));
        }
        return this;
    }
    
    /**
     * Adds this as call argument.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeArgumentListExpression addThisArgument() {
        return addArgument("this");
    }

    /**
     * Adds a call argument as raw string.
     * 
     * @param arg the argument, may be empty or <b>null</b> to ignore this argument
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeArgumentListExpression addArgument(String arg) {
        if (null != arg && arg.length() > 0) {
            arguments.add(new JavaCodeText(arg, false, false));
        }
        return this;
    }
    
    /**
     * Adds an expression as call argument.
     * 
     * @param ex the expression, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeArgumentListExpression addArgument(JavaCodeExpression ex) {
        if (null != ex && !ex.isEmpty()) {
            ex.setParent(this);
            arguments.add(ex);
        }
        return this;
    }

    /**
     * Adds variable name as call argument.
     * 
     * @param var the variable declaration, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeArgumentListExpression addArgument(JavaCodeVariableDeclaration var) {
        if (null != var) {
            arguments.add(new JavaCodeVariableExpression(this, var));
        }
        return this;
    }

    /**
     * Adds the name of a parameter as call argument.
     * 
     * @param param the parameter declaration, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeArgumentListExpression addArgument(JavaCodeParameterSpecification param) {
        if (null != param) {
            arguments.add(new JavaCodeTextExpression(this, param.getName())); // might also be a specific instance
        }
        return this;
    }

    /**
     * Adds a call argument as raw string.
     * 
     * @param arg the argument
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addConstantArgument", "constArg"})
    public JavaCodeArgumentListExpression addConstantArgument(String arg) {
        int pos = arg.lastIndexOf('.');
        if (pos > 0) {
            int classPos = arg.lastIndexOf('.', pos - 1);
            if (classPos > 0) {
                getArtifact().validateType(new JavaCodeTypeSpecification(arg.substring(0, pos), this));
                arg = arg.substring(classPos + 1);
            }
        }
        arguments.add(new JavaCodeText(arg, false, false));
        return this;
    }
    
    /**
     * Adds a lambda expression as call argument.
     * 
     * @return the lambda expression
     */
    @OperationMeta(name = {"addLambdaArgument", "lambdaArg"})
    public JavaCodeLambdaExpression addLambdaArgument() {
        return addLambdaArgument(null);
    }

    /**
     * Adds a lambda expression with given single variable as call argument.
     * 
     * @param variable the variable name, may be <b>null</b> or empty for none
     * @return the lambda expression
     */
    @OperationMeta(name = {"addLambdaArgument", "lambdaArg"})
    public JavaCodeLambdaExpression addLambdaArgument(String variable) {
        return addArgumentImpl(new JavaCodeLambdaExpression(this).addVariable(variable));
    }

    /**
     * Adds an argument list expression through its individual contained arguments.
     * 
     * @param arguments the arguments
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArguments", "args"})
    public JavaCodeArgumentListExpression addArguments(JavaCodeArgumentListExpression arguments) {
        this.arguments.addAll(arguments.arguments);
        return this;
    }
    
    /**
     * Returns the number of arguments of this argument list.
     * 
     * @return the number of arguments
     */
    public int getArgumentsCount() {
        return arguments.size();
    }
    
    /**
     * Adds an element to the arguments and returns the element.
     * 
     * @param <E> the element type
     * @param element the element
     * @return {@code element}
     */
    protected <E extends JavaCodeExpression> E addArgumentImpl(E element) {
        return IJavaCodeElement.add(arguments, element);
    }
    
    @Override
    public void store(CodeWriter out) {
        storeArgumentList(out);
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        for (IJavaCodeElement a : arguments) {
            setParent(a, this);
        }
    }   
    
    /**
     * Returns the arguments.
     * 
     * @return the arguments
     */
    Iterable<IJavaCodeElement> arguments() {
        return arguments;
    }
    
    /**
     * Stores the argument list.
     * 
     * @param out the argument list
     */
    protected void storeArgumentList(CodeWriter out) {
        IJavaCodeElement.storeList(arguments, ",", out); // this is just a partial argument list
    }
    
    @Override
    public JavaCodeArgumentListExpression replaceVariable(String oldName, String newName) {
        arguments.forEach(a -> a.replaceVariable(oldName, newName));
        return this;
    }

    @Override
    public JavaCodeArgumentListExpression replaceMethod(String oldName, String newName) {
        arguments.forEach(a -> a.replaceMethod(oldName, newName));
        return this;
    }

}
