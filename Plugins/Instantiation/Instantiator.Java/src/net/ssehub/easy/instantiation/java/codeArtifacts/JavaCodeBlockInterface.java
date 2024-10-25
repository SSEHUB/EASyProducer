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

/**
 * Represents a code block.
 * 
 * @author Holger Eichelberger
 */
public interface JavaCodeBlockInterface extends IJavaCodeElement {

    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text);

    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text);
    
    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeDoLoop addDoLoop(String condition);

    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeWhileLoop addWhileLoop(String condition);

    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(String type, String variableName, String expression);
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String expression);

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
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String initializer, 
        String condition, String update);
    
    /**
     * Adds a if-then-else block.
     * 
     * @param condition the loop condition
     * @return the if-then-else block
     */
    public JavaCodeAlternative addIf(String condition);

    /**
     * Adds a throw statement.
     * 
     * @param expression the expression to throw
     * @return throw statement
     */
    public JavaCodeThrow addThrow(String expression);

    /**
     * Adds a switch block.
     * 
     * @param expression the switch expression
     * @return the switch block
     */
    public JavaCodeSwitch addSwitch(String expression);

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeSynchronizedBlock addSynchronized();

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeTryBlock addTry();

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param expression the expression determining the value
     * @return the assignment
     */
    public JavaCodeAssignment addAssignment(String variable, String expression);

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param operator the assignment operator, e.g., {@code =} or {@code +=}
     * @param expression the expression determining the value
     * @return the assignment
     */
    public JavaCodeAssignment addAssignment(String variable, String operator, String expression);

    /**
     * Adds an empty line.
     * 
     * @return <b>this</b>
     */
    public JavaCodeBlockInterface addEmptyLine();

    /**
     * Adds a single-line comment.
     * 
     * @param text the comment text
     * @return <b>this</b>
     */
    public JavaCodeBlockInterface addSLComment(String text);

    /**
     * Adds a constructor super call.
     * 
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addSuperCall();

    /**
     * Adds a constructor this call.
     * 
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addThisCall();
    
    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName);

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        String initializer);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        String initializer);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        boolean isFinal, String initializer);

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, String initializer);
    
}
