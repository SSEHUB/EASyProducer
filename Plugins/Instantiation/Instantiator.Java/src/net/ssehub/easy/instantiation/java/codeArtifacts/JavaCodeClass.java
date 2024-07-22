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
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Representes a Java code class.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeClass extends JavaCodeVisibleElement {

    static final JavaCodeClass EMPTY = new JavaCodeClass("", JavaCodeArtifact.EMPTY);
    private static NewLineStrategy newLineStrategy = new ConditionalAttributeNewLineStrategy();
    
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
        super(name, JavaCodeVisibility.PUBLIC, null);
        this.artifact = artifact;
    }

    JavaCodeClass(String name, JavaCodeClass enclosing) {
        super(name, JavaCodeVisibility.PUBLIC, null);
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
    
    @Invisible
    @Override
    protected JavaCodeClass getEnclosing() {
        return enclosing;
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
    
    public JavaCodeAttribute addAttribute(String type, String name) {
        return IJavaCodeElement.add(elements, 
            new JavaCodeAttribute(JavaCodeTypeSpecification.create(type, this), name, this), 
            lastAttribute(elements));
    }

    public JavaCodeAttribute addAttribute(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeAttribute(type, name, this), 
            lastAttribute(elements));
    }
    
    private static int lastAttribute(List<IJavaCodeElement> elements) {
        int pos = 0;
        while (pos < elements.size() && elements.get(pos).isAttribute()) {
            pos++;
        }
        return pos;
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
    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this, comment));
    }

    public JavaCodeMethod addMethod(JavaCodeTypeSpecification type, String name) {
        return IJavaCodeElement.add(elements, new JavaCodeMethod(type, name, this));
    }
    
    /**
     * Adds an extensible default getter for {@code attribute}.
     * 
     * @param attribute the attribute to add the getter for
     * @return the getter
     */
    public JavaCodeMethod addGetter(JavaCodeAttribute attribute) {
        return attribute.addGetter();
    }

    /**
     * Adds an extensible default setter for {@code attribute}.
     * 
     * @param attribute the attribute to add the setter for
     * @return the setter
     */
    public JavaCodeMethod addSetter(JavaCodeAttribute attribute) {
        return attribute.addSetter();
    }

    @Override
    public JavaCodeClass setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public JavaCodeClass setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    public JavaCodeClass setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    public JavaCodeClass setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeClass setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeClass setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    public JavaCodeClass setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

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
        if (elements.size() > 0) {
            out.println();
            newLineStrategy.start();
            for (IJavaCodeElement e: elements) {
                if (newLineStrategy.emitNewlineBefore(e)) {
                    out.println();
                }
                e.store(out);
                if (newLineStrategy.emitNewlineAfter(e)) {
                    out.println();
                }
            }
        }
        out.decreaseIndent();
        out.printlnwi("}");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaClass: " + getName();
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        setParent(parent, p -> this.enclosing = p);
    }

    /**
     * Helper to set a parent of required type {@link JavaCodeClass}.
     * 
     * @param parent the parent
     * @param consumer the setter consumer
     */
    static void setParent(IJavaCodeElement parent, Consumer<JavaCodeClass> consumer) {
        IJavaCodeElement.setParent(parent, JavaCodeClass.class, consumer);
    }

}
