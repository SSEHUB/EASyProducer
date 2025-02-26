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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a code block.
 * 
 * @author Holger Eichelberger
 */
public interface JavaCodeBlockInterface extends IJavaCodeElement, JavaCodeCallElement {

    
    /**
     * Transfers all my elements to the given block.
     * 
     * @param block the target block
     * @see #add(IJavaCodeElement)
     */
    @Invisible
    public void transferElementsTo(JavaCodeBlockInterface block);

    /**
     * Adds the given element to this block.
     * 
     * @param element the element to add
     */
    @Invisible
    public void add(IJavaCodeElement element);

    /**
     * Adds all elements in {@code block} to this block.
     * 
     * @param block the block to take the elements from (remove them)
     * @return this boick for chaining
     * @see #transferElementsTo(JavaCodeBlockInterface)
     */
    public JavaCodeBlockInterface addAll(JavaCodeBlockInterface block);

    /**
     * Adds a statement and indents it.
     * 
     * @param stmt the statement
     * @return <b>this</b> for chaining
     */
    public JavaCodeBlockInterface add(JavaCodeStatement stmt);

    /**
     * Adds an expression as a statement and indents it.
     * 
     * @param expr the expression
     * @return <b>this</b> for chaining
     */
    public default JavaCodeBlockInterface add(JavaCodeExpression expr) {
        add(new JavaCodeExpressionStatement(this, expr));
        return this;
    }

    /**
     * Adds text and indents it.
     * 
     * @param text the text
     * @return <b>this</b> for chaining
     */
    public JavaCodeBlockInterface add(String text);
    
    /**
     * Adds text, potentially as a statement (potentially adding a ";"), and indents it.
     * 
     * @param text the text
     * @return <b>this</b> for chaining
     */
    public JavaCodeBlockInterface addAsStatement(String text);

    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     * @param indent {@code true} if {@code text} shall be indented, {@code false} if the text is preformatted
     * @return <b>this</b> for chaining
     */
    public JavaCodeBlockInterface addRaw(String text, boolean indent);
    
    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    @OperationMeta(name = {"addDoLoop", "do"})
    public JavaCodeDoLoop addDoLoop(String condition);

    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    @OperationMeta(name = {"addWhileLoop", "while"})
    public JavaCodeWhileLoop addWhileLoop(String condition);

    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String expression);
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    //@OperationMeta(name = {"addForLoop", "for"})
    //public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String expression);

    /**
     * Creates a traditional for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     * @return the for loop block
     */
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String initializer, 
        String condition, String update);

    /**
     * Creates a traditional for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     * @return the for loop block
     */
    //@OperationMeta(name = {"addForLoop", "for"})
    //public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String initializer, 
    //    String condition, String update);
    
    /**
     * Adds a if-then-else block.
     * 
     * @param condition the loop condition
     * @return the if-then-else block
     */
    @OperationMeta(name = {"addIf", "if"})
    public JavaCodeAlternative addIf(String condition);

    /**
     * Adds a throw statement.
     * 
     * @param expression the expression to throw
     * @return throw statement
     */
    @OperationMeta(name = {"addThrow", "throw"})
    public JavaCodeThrow addThrow(String expression);

    /**
     * Adds a switch block.
     * 
     * @param expression the switch expression
     * @return the switch block
     */
    @OperationMeta(name = {"addSwitch", "switch"})
    public JavaCodeSwitch addSwitch(JavaCodeExpression expression);

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    @OperationMeta(name = {"addSynchronized", "synchronized"})
    public JavaCodeSynchronizedBlock addSynchronized();

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    @OperationMeta(name = {"addTry", "try"})
    public JavaCodeTryBlock addTry();

    /**
     * Adds a postfix increment expression as statement.
     * 
     * @param variable the variable
     * @return the increment expression statement
     */
    public JavaCodeExpressionStatement addPostfixIncrement(String variable);    

    /**
     * Adds a postfix decrement expression as statement.
     * 
     * @param variable the variable
     * @return the decrement expression statement
     */
    public JavaCodeExpressionStatement addPostfixDecrement(String variable);    

    /**
     * Adds an assignment without value expression, to be added through the returned assignment.
     * 
     * @param variable the variable to change
     * @return the assignment
     */
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable);

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param expression the expression determining the value
     * @return the assignment
     */
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable, JavaCodeExpression expression);

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param operator the assignment operator, e.g., {@code =} or {@code +=}
     * @param expression the expression determining the value
     * @return the assignment
     */
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable, String operator, JavaCodeExpression expression);

    /**
     * Adds an empty line.
     * 
     * @return <b>this</b>
     */
    @OperationMeta(name = {"addEmptyLine", "emptyLine"})
    public JavaCodeBlockInterface addEmptyLine();

    /**
     * Adds a single-line comment.
     * 
     * @param text the comment text
     * @return <b>this</b>
     */
    @OperationMeta(name = {"addSLComment", "SLComment"})
    public JavaCodeBlockInterface addSLComment(String text);

    /**
     * Adds a constructor super call.
     * 
     * @return the method call (for chaining)
     */
    @OperationMeta(name = {"addSuperCall", "super"})
    public JavaCodeMethodCall addSuperCall();

    /**
     * Adds a constructor this call.
     * 
     * @return the method call (for chaining)
     */
    @OperationMeta(name = {"addThisCall", "this"})
    public JavaCodeMethodCall addThisCall();

    /**
     * Adds a "System.out.println" call.
     * 
     * @return the method call (for chaining)
     */
    @OperationMeta(name = {"addSystemOutPrintlnCall", "SystemOutPrintln", "sysoutprintln"})
    public JavaCodeMethodCall addSystemOutPrintlnCall();

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        JavaCodeExpression initializer);

    /**
     * Creates a variable declaration without initialization.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @return the variable declaration (for chaining)
     */
    @OperationMeta(name = {"addVariable", "var"})
    public default JavaCodeVariableDeclaration addVariable(String type, String variableName) {
        return addVariable(type, variableName, null);
    }

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return the variable declaration (for chaining)
     */
    //@OperationMeta(name = {"addVariable", "var"})
    //public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
    //    JavaCodeExpression initializer);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return the variable declaration (for chaining)
     */
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return the variable declaration (for chaining)
     */
    //@OperationMeta(name = {"addVariable", "var"})
    //public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
    //    boolean isFinal, JavaCodeExpression initializer);
    
    /**
     * Creates a variable declaration without initialization and without adding it.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @return the variable declaration (for chaining)
     */
    public default JavaCodeVariableDeclaration createVariable(String type, String variableName) {
        return createVariable(type, variableName, null);
    }
    
    /**
     * Creates a variable declaration without initialization and without adding it.
     * 
     * @param type the type of the variable, may be <b>null</b> or empty for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, JavaCodeExpression initializer);

    /**
     * Creates a variable declaration without adding it.
     * 
     * @param type the type of the variable, may be <b>null</b> for or empty auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer);
    
}
