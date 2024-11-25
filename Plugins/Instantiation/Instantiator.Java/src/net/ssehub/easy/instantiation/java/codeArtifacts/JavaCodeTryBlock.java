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
 * Represents a try-catch block.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeTryBlock extends JavaCodeBlock {
    
    private List<JavaCodeCatchBlock> catches = new ArrayList<>();
    private JavaCodeBlock finallyBlock;
    private String tryDecl;
    private List<JavaCodeVariableDeclaration> tryDecls;
    
    /**
     * A case block.
     * 
     * @author Holger Eichelberger
     */
    public class JavaCodeCatchBlock extends JavaCodeBlock {
    
        private List<JavaCodeTypeSpecification> types = new ArrayList<>();
        private String variableName;

        /**
         * Creates a catch block instance.
         * 
         * @param parent the parent
         * @param type the type
         * @param variableName the catch variable
         */
        private JavaCodeCatchBlock(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName) {
            super(parent, true, false, false, true);
            types.add(type);
            this.variableName = variableName;
        }

        /**
         * Adds another type to catch.
         * 
         * @param type the type
         */
        public void addType(String type) {
            types.add(new JavaCodeTypeSpecification(type, getParentClass()));
        }

        /**
         * Adds another type to catch.
         * 
         * @param type the type
         */
        public void addType(JavaCodeTypeSpecification type) {
            types.add(type);
        }

        @Invisible
        @Override
        public void store(CodeWriter out) {
            out.print(" catch (");
            IJavaCodeElement.storeList(types, "|", out);
            out.print(" ");
            out.print(variableName);
            out.print(")");
            super.store(out);
        }
        
    }
    
    /**
     * Creates a try-catch block.
     * 
     * @param parent the parent instance
     */
    public JavaCodeTryBlock(IJavaCodeElement parent) {
        super(parent, true, false);
    }

    /**
     * Adds a try block.
     * 
     * @param type the (first) type to catch
     * @param variableName the exception variable name
     * @return the catch block
     */
    public JavaCodeCatchBlock addCatch(JavaCodeTypeSpecification type, String variableName) {
        return IJavaCodeElement.add(catches, new JavaCodeCatchBlock(this, type, variableName));
    }

    /**
     * Adds a try block.
     * 
     * @param type the (first) type to catch
     * @param variableName the exception variable name
     * @return the catch block
     */
    public JavaCodeCatchBlock addCatch(String type, String variableName) {
        return addCatch(new JavaCodeTypeSpecification(type, getParentClass()), variableName);
    }

    /**
     * Adds a finally block.
     * 
     * @return the finally block
     */
    public JavaCodeBlock addFinally() {
        finallyBlock = new JavaCodeBlock(this, true, false);
        return finallyBlock;
    }
    
    /**
     * Creates a resource variable declaration.
     * 
     * @param tryDecl the try-resource declaration as single tring
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeTryBlock addResource(String tryDecl) {
        this.tryDecl = tryDecl;
        return this;
    }
    
    /**
     * Creates a resource variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addResource(String type, String variableName, 
        String initializer) {
        if (null == tryDecls) {
            tryDecls = new ArrayList<>();
        }
        JavaCodeTypeSpecification t = null == type ? null : new JavaCodeTypeSpecification(type, getParentClass());
        return IJavaCodeElement.add(tryDecls, new JavaCodeVariableDeclaration(this, t, variableName, 
            false, initializer, true));
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("try");
        if (null != tryDecls || null != tryDecl) {
            out.print(" (");
            if (null != tryDecl) {
                out.print(tryDecl);
            } else {
                IJavaCodeElement.storeList(tryDecls, "; ", out);
            }
            out.print(")");
        } 
        super.store(out);
        for (JavaCodeCatchBlock c : catches) {
            c.store(out);
        }
        if (finallyBlock != null) {
            out.print(" finally ");
            finallyBlock.store(out);
        }
        out.println();
    }

}
