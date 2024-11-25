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
import java.util.Optional;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Representes a Java enum in code.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeEnum extends JavaCodeClass {

    private List<JavaCodeEnumConstant> constants = new ArrayList<>();
    
    public class JavaCodeEnumConstant extends JavaCodeMethodCall implements IJavaCodeElement {

        private JavaCodeJavadocComment comment;

        public JavaCodeEnumConstant(String methodName, String comment) {
            super(JavaCodeEnum.this, methodName, JavaCodeImportScope.NONE, false, "");
            if (null != comment && comment.length() > 0) {
                this.comment = new JavaCodeJavadocComment(comment, this); 
            }
        }
        
        protected void storeBefore(CodeWriter out) {
            if (null != comment) {
                comment.store(out);
                // println?
            }
            out.printIndent();
        }
        
        boolean hasComment() {
            return null != comment;
        }

        @Override
        protected void storeArgumentList(CodeWriter out) {
            if (getArgumentsCount() > 0) {
                super.storeArgumentList(out);
            }
        }

    }
    
    /**
     * Creates a public enum given name in {@code artifact}.
     * 
     * @param name the name of the enum
     * @param artifact the name of the containing artifact
     */
    JavaCodeEnum(String name, IJavaCodeArtifact artifact) {
        super(name, artifact);
        setKind(Kind.ENUM);
    }

    /**
     * Creates a public enum with given name and comment as top-level entity in {@code artifact}.
     * 
     * @param name the name of the enum
     * @param artifact the name of the containing artifact
     * @param comment the describing comment of the enum
     */
    JavaCodeEnum(String name, IJavaCodeArtifact artifact, String comment) {
        super(name, artifact, comment);
        setKind(Kind.ENUM);
    }

    /**
     * Creates a nested instance with given name within {@code enclosing}.
     * 
     * @param name the name of the enum
     * @param enclosing the enclosing class
     */
    JavaCodeEnum(String name, JavaCodeClass enclosing) {
        super(name, enclosing);
        setKind(Kind.ENUM);
    }

    /**
     * Creates a nested instance with given name within {@code enclosing}.
     * 
     * @param name the name of the enum
     * @param enclosing the enclosing class
     * @param comment the describing comment of the enum
     */
    JavaCodeEnum(String name, JavaCodeClass enclosing, String comment) {
        super(name, enclosing, comment);
        setKind(Kind.ENUM);
    }

    @Override
    protected JavaCodeMethod configureConstructor(JavaCodeMethod cons) {
        return cons.setPrivate();
    }
    
    public JavaCodeEnumConstant addLiteral(String name) {
        return addLiteral(name, "");
    }

    public JavaCodeEnumConstant addLiteral(String name, String comment) {
        Optional<JavaCodeEnumConstant> found 
            = constants.stream().filter(c -> c.getMethodName().equals(name)).findFirst();
        if (found.isPresent()) {
            return found.get();
        } else {
            JavaCodeEnumConstant result = new JavaCodeEnumConstant(name, comment);
            constants.add(result);
            return result;
        }
    }

    @Override
    public JavaCodeEnum addExtends(String type) {
        // has no effect, not possible
        return this;
    }

    @Override
    public JavaCodeEnum addInterface(String type) {
        super.addInterface(type);
        return this;
    }

    @Override
    public JavaCodeEnum setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public JavaCodeEnum setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    public JavaCodeEnum asInterface() {
        // has no effect, not possible
        return this;
    }

    @Override
    public JavaCodeEnum asAnnotation() {
        // has no effect, not possible
        return this;
    }
    
    @Override
    public JavaCodeEnum setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    public JavaCodeEnum setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeEnum setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeEnum setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    protected void storeAtBlockStart(CodeWriter out) {
        int size = constants.size();
        int size1 = size - 1;        
        for (int c = 0; c < size; c++) {
            JavaCodeEnumConstant constant = constants.get(c);
            if (c == 0 || constant.hasComment()) {
                out.println();
            }
            constant.store(out);
            if (c < size1) {
                out.println(",");
            }
        }
        if (getElementsCount() > 0) { // initial; has constructor?
            out.println(";");
        }
        out.println();
    }

}
