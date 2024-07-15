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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

public class JavaCodeClass extends JavaCodeVisibleElement {

    static final JavaCodeClass EMPTY = new JavaCodeClass("", JavaCodeArtifact.EMPTY);
    
    private Kind kind = Kind.CLASS;
    private List<IJavaCodeElement> elements = new ArrayList<>();
    private JavaCodeClass enclosing;
    private IJavaCodeArtifact artifact;
    private JavaCodeTypeSpecification extendingClass;
    private List<JavaCodeTypeSpecification> implementedInterfaces;
    
    public enum Kind {
        CLASS("class"),
        INTERFACE("interface"),
        ANNOTATION("@interface");
        
        private String keyword;
        
        private Kind(String keyword) {
            this.keyword = keyword;
        }
        
        public String getKeyword() {
            return keyword;
        }
        
    }
    
    JavaCodeClass(String name, JavaCodeArtifact artifact) {
        super(name, Visibility.PUBLIC, null);
        this.artifact = artifact;
    }

    JavaCodeClass(String name, JavaCodeClass enclosing) {
        super(name, Visibility.PUBLIC, null);
        this.enclosing = enclosing;
    }
    
    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        if (null == artifact) {
            return enclosing.getArtifact();
        } else {
            return artifact;
        }
    }

    /**
     * Creates a protected class with given {@code name}.
     * 
     * @param name the name of the class
     * @return the created class
     */
    public JavaCodeClass addClass(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeClass(name, this).setProtected());
    }
    
    public JavaCodeAttribute addAttribute(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeAttribute(name, this));
    }

    public JavaCodeAttribute addAttribute(String type, String name) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeAttribute(JavaCodeTypeSpecification.create(type, this), name, this));
    }

    public JavaCodeAttribute addAttribute(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeAttribute(type, name, this));
    }
    
    public JavaCodeClass addExtends(String type) {
        extendingClass = JavaCodeTypeSpecification.create(type, this);
        return this;
    }
    
    public JavaCodeClass addInterface(String type) {
        IJavaCodeElement.add(implementedInterfaces, JavaCodeTypeSpecification.create(type, this));
        return this;
    }
    
    public JavaCodeClass asInterface() {
        kind = Kind.INTERFACE;
        return this;
    }
    
    public JavaCodeClass asAnnotation() {
        kind = Kind.ANNOTATION;
        return this;
    }

    public JavaCodeMethod addMethod(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(name, this));
    }

    public JavaCodeMethod addMethod(String type, String name) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeMethod(JavaCodeTypeSpecification.create(type, this), name, this));
    }

    public JavaCodeMethod addMethod(String type, String name, String comment) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeMethod(JavaCodeTypeSpecification.create(type, this), name, this, comment));
    }

    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this));
    }
    
    @Override
    @OperationMeta(name = {"visibility"})
    public JavaCodeClass setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    @OperationMeta(name = {"visibility"})
    public JavaCodeClass setVisibility(Visibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"public"})
    public JavaCodeClass setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    @OperationMeta(name = {"private"})
    public JavaCodeClass setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    @OperationMeta(name = {"protected"})
    public JavaCodeClass setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    @OperationMeta(name = {"package"})
    public JavaCodeClass setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    @OperationMeta(name = {"static"})
    public JavaCodeClass setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @OperationMeta(name = {"static"})
    @Override
    public JavaCodeClass setStatic() {
        super.setStatic();
        return this;
    }
    
    /**
     * Returns the class kind.
     * 
     * @return the class kind
     */
    @Invisible
    Kind getKind() {
        return kind;
    }

    /*public JavaCodeJavadocComment setJavadocComment() {
        return new JavaCodeJavadocComment();
    }*/

    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier() + kind.getKeyword() + " " + getName());
        if (null != extendingClass) {
            out.print(" extends ");
            extendingClass.store(out);
        }
        IJavaCodeElement.storeList(" ", implementedInterfaces, ", ", out);
        out.println(" {");
        out.increaseIndent();
        for (IJavaCodeElement e: elements) {
            e.store(out);
        }
        out.decreaseIndent();
        out.printlnwi("}");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaClass: " + getName();
    }

}
