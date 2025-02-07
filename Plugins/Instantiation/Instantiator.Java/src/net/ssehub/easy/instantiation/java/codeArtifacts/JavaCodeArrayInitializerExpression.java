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

import java.util.function.Consumer;
import java.util.function.Function;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;

/**
 * Represents an array initializer expression, with additional functions for adding values as VIL sequences and for
 * enforcing line breaks/indentations between the elements.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeArrayInitializerExpression extends JavaCodeArgumentListExpression {

    private boolean lineBreaks = false;
    private boolean indent = true;

    /**
     * Creates an array initializer expression.
     * 
     * @param parent the parent element, may be <b>null</b>
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     */
    protected JavaCodeArrayInitializerExpression(IJavaCodeElement parent, boolean lineBreaks) {
        super(parent);
        this.lineBreaks = lineBreaks;
    }
    
    /**
     * Creates an unlinked array initializer expression. Does not add line breaks. {@link #setParent(IJavaCodeElement)} 
     * must be called afterwards.
     * 
     * @return the created expression
     */
    public static JavaCodeArrayInitializerExpression create() {
        return new JavaCodeArrayInitializerExpression(null, false);
    }

    /**
     * Creates an unlinked array initializer expression. {@link #setParent(IJavaCodeElement)} must be called afterwards.
     * 
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     * @return the created expression
     */
    public static JavaCodeArrayInitializerExpression create(boolean lineBreaks) {
        return new JavaCodeArrayInitializerExpression(null, lineBreaks);
    }
    
    /**
     * Enables/disables the additional indentation of values if linebreaks are enabled.
     * 
     * @param indent to indent or not to indent
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = "indent")
    public JavaCodeArrayInitializerExpression setIndent(boolean indent) {
        this.indent = indent;
        return this;
    }

    /**
     * Enables/disables linebreaks between values.
     * 
     * @param lineBreaks to break lines or not to break lines
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = "linebreaks")
    public JavaCodeArrayInitializerExpression setLinebreaks(boolean lineBreaks) {
        this.lineBreaks = lineBreaks;
        return this;
    }

    @Override
    @OperationMeta(name = "value")
    public JavaCodeArrayInitializerExpression addArgument(Object arg) {
        return (JavaCodeArrayInitializerExpression) super.addArgument(arg);
    }

    @Override
    @OperationMeta(name = "null")
    public JavaCodeArrayInitializerExpression addNullArgument() {
        return (JavaCodeArrayInitializerExpression) super.addNullArgument();
    }

    @Override
    @OperationMeta(name = "string")
    public JavaCodeArrayInitializerExpression addStringArgument(String val) {
        return (JavaCodeArrayInitializerExpression) super.addStringArgument(val);
    }

    @Override
    @OperationMeta(name = "stringNotEmpty")
    public JavaCodeArrayInitializerExpression addStringArgumentNotEmpty(String val) {
        return (JavaCodeArrayInitializerExpression) super.addStringArgumentNotEmpty(val);
    }
    
    @Override
    @OperationMeta(name = "class")
    public JavaCodeArrayInitializerExpression addClassArgument(String cls) {
        return (JavaCodeArrayInitializerExpression) super.addClassArgument(cls);
    }
    
    @Override
    @OperationMeta(name = "this")
    public JavaCodeArrayInitializerExpression addThisArgument() {
        return (JavaCodeArrayInitializerExpression) super.addThisArgument();
    }

    @Override
    @OperationMeta(name = "text")
    public JavaCodeArrayInitializerExpression addArgument(String arg) {
        return (JavaCodeArrayInitializerExpression) super.addArgument(arg);
    }
    
    @Override
    @OperationMeta(name = "value")
    public JavaCodeArrayInitializerExpression addArgument(JavaCodeExpression ex) {
        return (JavaCodeArrayInitializerExpression) super.addArgument(ex);
    }

    @Override
    @OperationMeta(name = "var")
    public JavaCodeArrayInitializerExpression addArgument(JavaCodeVariableDeclaration var) {
        return (JavaCodeArrayInitializerExpression) super.addArgument(var);

    }

    @Override
    @OperationMeta(name = "var")
    public JavaCodeArrayInitializerExpression addArgument(JavaCodeParameterSpecification param) {
        return (JavaCodeArrayInitializerExpression) super.addArgument(param);
    }

    @Override
    @OperationMeta(name = "const")
    public JavaCodeArrayInitializerExpression addConstantArgument(String arg) {
        return (JavaCodeArrayInitializerExpression) super.addConstantArgument(arg);
    }

    @Override
    @OperationMeta(name = "args")
    public JavaCodeArrayInitializerExpression addArguments(JavaCodeArgumentListExpression arguments) {
        return (JavaCodeArrayInitializerExpression) super.addArguments(arguments);
    }

    /**
     * Adds the elements of {@code values} as values to this initializer expression.
     * 
     * @param values the values to add
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = "values")
    public JavaCodeArrayInitializerExpression addValues(Sequence<?> values) {
        return addValues(values, v -> v, v -> addArgument(v));
    }

    /**
     * Adds the elements of {@code values} as string values to this initializer expression.
     * 
     * @param values the values to add
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = "stringValues")
    public JavaCodeArrayInitializerExpression addStringValues(Sequence<?> values) {
        return addValues(values, String::valueOf, v -> addStringArgument(v));
    }

    /**
     * Adds the elements of {@code values} as class name (potentially adding ".class") values to this initializer 
     * expression.
     * 
     * @param values the values to add
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = "classValues")
    public JavaCodeArrayInitializerExpression addClassValues(Sequence<?> values) {
        return addValues(values, String::valueOf, v -> addClassArgument(v));
    }

    /**
     * Generically adds sequence values to this initializer expression.
     * 
     * @param <T> the final value type
     * @param values the values to add
     * @param transformer transforms an object to a target value, e.g., by turning it to a string or handing null values
     * @param consumer consumes the transformed values adding them to this instance by calling an appropriate method
     * @return <b>this</b> for chaining
     */
    private <T> JavaCodeArrayInitializerExpression addValues(Sequence<?> values, Function<Object, T> transformer, 
        Consumer<T> consumer) {
        for (Object v: values) {
            consumer.accept(transformer.apply(IVilType.convertVilValue(v)));
        }
        return this;
    }
    
    @Override
    @OperationMeta(name = "valuesCount")
    public int getArgumentsCount() {
        return super.getArgumentsCount();
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.print("{");
        if (lineBreaks) {
            int count = 0;
            final int last = getArgumentsCount();
            if (last > 0) {
                out.println();
                if (indent) {
                    out.increaseIndent();
                }
                for (IJavaCodeElement v : arguments()) {
                    out.printIndent();
                    v.store(out);
                    count++;
                    if (count < last) {
                        out.println(",");
                    }
                }
                if (indent) {
                    out.decreaseIndent();
                }
            }
        } else {
            storeArgumentList(out);
        }
        out.print("}");
    }
    
}
